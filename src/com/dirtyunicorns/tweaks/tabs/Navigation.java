/*
 * Copyright (C) 2017-2018 The Dirty Unicorns Project
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

package com.dirtyunicorns.tweaks.tabs;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.support.v14.preference.PreferenceFragment;
import android.preference.Preference.OnPreferenceChangeListener;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.util.du.Utils;

public class Navigation extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String BUTTONS_CATEGORY = "buttons_category";
    private static final String NAVIGATION_CATEGORY = "navigation_category";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.navigation);

        Preference Buttons = findPreference(BUTTONS_CATEGORY);
        if (!getResources().getBoolean(R.bool.has_buttons)) {
            getPreferenceScreen().removePreference(Buttons);
        }

        Preference Navigation = findPreference(NAVIGATION_CATEGORY);
        // This is temporary thing until we integrate a method to enable
        // and disable the navigation bar on devices with hw keys.
        if (!Utils.hasNavigationBar()) {
            getPreferenceScreen().removePreference(Navigation);
        } else {
            if (!getResources().getBoolean(R.bool.has_navigation)) {
                getPreferenceScreen().removePreference(Navigation);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return false;
    }


    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.DIRTYTWEAKS;
    }
}

