package ru.javarush.cryptoanalyzer.marzhiievskyi.constants;

public class Strings {
    private static final String ENG_ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
    private static final String CYRILIC_ALPHABET = "йцукенгшщзхъфывапролджэячсмитьбюёії";
    private static final String NUMERIC = "0123456789";
    private static final String SYMBOLS = ".,/?'\"[];:!@#$%^&*() -";

    public static final String ALL_SYMBOLS =
            ENG_ALPHABET + ENG_ALPHABET.toUpperCase()
            + CYRILIC_ALPHABET + CYRILIC_ALPHABET.toUpperCase() + NUMERIC + SYMBOLS;
    //public static final char[] ALL_CHARS = ALL_SYMBOLS.toCharArray();
}
