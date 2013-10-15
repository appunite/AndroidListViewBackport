/*
 * Copyright (C) 2013 Jacek Marchwicki <jacek.marchwicki@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appunite.list;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

public class Compat {
    public static int combineMeasuredStates(int curState, int newState) {
        return curState | newState;
    }

    public static int getMeasuredState(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return view.getMeasuredState();
        } else {
            return 0;
        }
    }

    public static void jumpDrawablesToCurrentState(View child) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            child.jumpDrawablesToCurrentState();
        }
    }

    public static void setActivated(View child, boolean activated) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            child.setActivated(activated);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isLayoutRtl(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return (view.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL);
        } else {
            return false;
        }
    }
}
