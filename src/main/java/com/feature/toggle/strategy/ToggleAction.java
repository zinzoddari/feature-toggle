package com.feature.toggle.strategy;

public interface ToggleAction<I, O> {
    <I, O> O run(String toggleId, I input);
}
