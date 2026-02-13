package com.feature.toggle.strategy;

public record TogglePair<I, O>(
    ToggleAction <I, O> newAction,
    ToggleAction<I, O> legacyAction
) {

}
