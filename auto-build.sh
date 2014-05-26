export ANDROID_NDK_HOME="$HOME/Android/android-ndk-r9c"
export ANDROID_HOME="$HOME/Android/adt-bundle-linux-x86_64-20131030/sdk"
export PATH="${PATH}:${ANDROID_HOME}/platform-tools"
export PATH="${PATH}:${ANDROID_HOME}/tools/proguard/bin"
export PATH="${PATH}:${ANDROID_HOME}/tools"
export PATH="${PATH}:${ANDROID_NDK_HOME}"

if [ -f "${HOME}/.ssh/id_rsa" ];
then
	echo "Never run this script on your computer - it is designed to run on build server"
	exit 1
fi

mv /tmp/id_rsa "${HOME}/.ssh/id_rsa" || exit 1
mv /tmp/id_rsa.pub "${HOME}/.ssh/id_rsa.pub" || exit 1
chmod 0600 "${HOME}/.ssh/id_rsa" || exit 1

cat > "${HOME}/.ssh/known_hosts" <<EOF
[review.appunite.com]:29418 ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC7QO9BK5rR1/3draS4UZlfzRuCXsvauubbN3HNcJiFe4rqDNRTW5oKJ4US4wbds9lB58zrUW3e9mK7XiuX1VXcfZp18//kdozreTK2z37vC0l2KfScfn11EjwBsHztEm+ZTm8oir1ihHUsdob9dnMoMCvD1IpM1jwVsogNX8OwluUY4axlBv+meV4YGKN9YoFIEut9oM2eZXuDM7Yz9PxZ034vxtgMLKdIPfJDb11KmtdEkw5wPRBTq/2baYhacP3QZtXOHi2VWyMztmTsEg4Asl+eCSaXfQzNSQgJxWUxkvfX/bHz4/3DPaTsWESn76lwNQQVKKmp88LNQKUwHIEz
EOF

mkdir -p /tmp/workspace || exit 1
cd /tmp/workspace || exit 1
git init work || exit 1
cd work || exit 1
git fetch ssh://jenkins@$GERRIT_HOST:$GERRIT_PORT/$GERRIT_PROJECT $GERRIT_REFSPEC && git checkout FETCH_HEAD || exit 1

TASKS="build"

./gradlew --parallel --refresh-dependencies ${TASKS} --stacktrace --project-prop versionSuffix="$GERRIT_CHANGE_NUMBER.$GERRIT_PATCHSET_NUMBER"

OUT=$?


mkdir -p /tmp/build/library
mv library/build/reports /tmp/build/library/reports

mkdir -p /tmp/build/example
mv example/build/reports /tmp/build/example/reports

exit $OUT
