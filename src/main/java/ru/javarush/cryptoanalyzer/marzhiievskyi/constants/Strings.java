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

    public static final String WELCOME_MESSAGE = "\nWelcome to crypto analyzer. Please enter number of command or enter exit to close program";
    public static final String CHOSE_COMMAND = """

            Please select command to do:\s
            To encode enter 1
            To decode enter 2
            To decode with Brute Force enter 3""";
    public static final String ENTER_KEY_SHIFT = "Enter the key to ";
    public static final String ENTER_ENCRYPTED_TEXT_FILE = "Enter input file with encrypted text";
    public static final String ENTER_INPUT_FILE_TEXT = "Enter input file with text";
    public static final String ENTER_OUT_FILE_NAME = "Enter output name file";
    public static final String ENTER_INPUT_DICTIONARY_TEXT_FILE = "Enter example text file to analyze";

    public static final String GOOD_BYE = "Good Bye!";
}
