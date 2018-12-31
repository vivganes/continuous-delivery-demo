package com.vivekganesan.cddemo.featuretoggles;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum AppFeatures implements Feature {

    @EnabledByDefault
    @Label("Home Page Header")
    HEADER_TEXT,

    @Label("Welcome Message")
    WELCOME_MESSAGE;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
