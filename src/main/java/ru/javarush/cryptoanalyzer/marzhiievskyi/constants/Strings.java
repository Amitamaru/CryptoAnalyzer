package ru.javarush.cryptoanalyzer.marzhiievskyi.constants;

public class Strings {
    private static final String ENG_ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
    private static final String RUS_ALPHABET = "йцукенгшщзхъфывапролджэячсмитьбюё";
    private static final String UKR_ALPHABET = "йцукенгшщзхїфівапролджєячсмитьбю";
    private static final String NUMERIC = "0123456789";
    private static final String SYMBOLS = ".,/?'\"[];:!@#$%^&*()";

    // all symbols what we are going to use for crypto analyzer
    public static final String ALL_SYMBOLS =
            ENG_ALPHABET + ENG_ALPHABET.toUpperCase()
            + RUS_ALPHABET + RUS_ALPHABET.toUpperCase() + UKR_ALPHABET
            + UKR_ALPHABET.toUpperCase() + NUMERIC + SYMBOLS;

}
