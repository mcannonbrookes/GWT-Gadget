package com.atlassian.mike.plugins.client;

import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.gadgets.client.BooleanPreference;
import com.google.gwt.gadgets.client.StringPreference;

public interface HelloPreferences extends UserPreferences {
    @PreferenceAttributes(display_name = "Vegetarian", default_value = "false")
    BooleanPreference noMeat();

    @UserPreferences.PreferenceAttributes(display_name = "Count", default_value = "0")
    StringPreference count();
}
