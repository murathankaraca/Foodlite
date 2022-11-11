package com.eray.foodlite.Models;

public class Settings {
    private Language language;
    public Language getLanguage() {
        return this.language;
    }
}

enum Language {
    Turkish,
    English
}