package com.example.andro.util;

public enum Language {
    ENGLISH("Английский"),
    RUSSIAN("Русский");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
