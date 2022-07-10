package ru.javarush.cryptoanalyzer.marzhiievskyi.constants;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    private static final String ENG_ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
    private static final String CYRILLIC_ALPHABET = "йцукенгшщзхъфывапролджэячсмитьбюёіїє";
    private static final String NUMERIC = "0123456789";
    private static final String SYMBOLS = "-.,/?'\"[];:!@#$%^&*() ";

    private static final String ALL_SYMBOLS =
            ENG_ALPHABET + ENG_ALPHABET.toUpperCase()
            + CYRILLIC_ALPHABET + CYRILLIC_ALPHABET.toUpperCase() + NUMERIC + SYMBOLS;

    public static final List<Character> ALPHABET_LIST = new ArrayList<>();

    static {
        for (Character ch : ALL_SYMBOLS.toCharArray()) {
            ALPHABET_LIST.add(ch);
        }
    }

    public static final String WELCOME_MESSAGE = "Welcome to crypto analyzer. Please enter number of command or enter exit to close program";
}
