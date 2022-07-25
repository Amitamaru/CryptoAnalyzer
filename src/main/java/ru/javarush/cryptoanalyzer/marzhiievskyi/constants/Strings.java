package ru.javarush.cryptoanalyzer.marzhiievskyi.constants;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static final String CYRILLIC_ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
    private static final String NUMERIC = "0123456789";
    private static final String SYMBOLS = "-.,?'\";:! ";

    private static final String ALL_SYMBOLS =
            CYRILLIC_ALPHABET + CYRILLIC_ALPHABET.toUpperCase() + NUMERIC + SYMBOLS;

    public static final List<Character> ALPHABET_LIST = new ArrayList<>();

    static {
        for (Character ch : ALL_SYMBOLS.toCharArray()) {
            ALPHABET_LIST.add(ch);
        }
    }
    //regex pattern for ru dictionary
    public static final String REGEX_FINDER_PATTERN = "(\\. [A-Z])|(, which)|(, but)|(, and)";

    //dialog msg's for program
    private static final String EXIT_WORD = ANSI_GREEN + "exit" + ANSI_RESET;
    public static final String WELCOME_MESSAGE = ANSI_BLUE + "\nWelcome. Please enter command number, " +
            "or enter " + EXIT_WORD + ANSI_BLUE + " to exit from program" + ANSI_RESET;
    public static final String CHOSE_COMMAND = ANSI_CYAN + """

            Choose action :\s
            Enter 1 to encrypt text from file
            Enter 2 to decrypt text from encrypted file
            Enter 3 to decrypt using method Brute Force
            Enter 4 to try decrypt by text analyzing""" + ANSI_RESET;

    public static final String ENTER_KEY_SHIFT = ANSI_PURPLE + "Enter key of encryption" + ANSI_RESET;
    public static final String ENTER_ENCRYPTED_TEXT_FILE = ANSI_PURPLE + "Enter file name with encrypted text" + ANSI_RESET;
    public static final String ENTER_INPUT_FILE_TEXT = ANSI_PURPLE + "Enter file name with incoming original text" + ANSI_RESET;
    public static final String ENTER_OUT_FILE_NAME = ANSI_PURPLE + "Enter file name for result" + ANSI_RESET;
    public static final String ENTER_INPUT_DICTIONARY_TEXT_FILE = ANSI_PURPLE + "Enter the name of the file with similar text to analyze" + ANSI_RESET;
    public static final String GOOD_BYE = ANSI_GREEN + "Good by" + ANSI_RESET;
    public static final String IO_EXCEPTION_MSG = ANSI_RED + "File path error" + ANSI_RESET;
    public static final String ARGS_EXCEPTION_MSG = ANSI_RED + "Incorrect arguments" + ANSI_RESET;
    public static final String KEY_EXCEPTION_MSG = ANSI_RED + "The key can not be '0', or be negative" + ANSI_RESET;

    //system msg's for program
    public static final String MSG_ENCRYPTION_DONE_WELL = "Encryption finished. ";
    public static final String MSG_PATH_TO_THE_RESULT = "\nPath to the result: ";
    public static final String MSG_DECRYPTION_DONE_WELL = "Decryption finished. ";
    public static final String MSG_DECRYPTION_DONE_FAILED = "Decryption failed";
    public static final String MSG_DECRYPTION_BRUTE_FORCE_DONE_WELL = MSG_DECRYPTION_DONE_WELL + "The key should be: ";
    public static final String MSG_DECRYPTION_BY_STATISTIC_ANALYZE_FINISHED = MSG_DECRYPTION_DONE_WELL + "Please check result.";
    public static final String MSG_EXCEPTION_FAILED = "Failed. ";

    //result msg's
    public static final String RESULT_OF_PROGRAM = "The result of program: ";
    public static final String CODE_OF_RESULT = "\ncode of result = ";
    public static final String MESSAGE_WORD = "\nmessage = ";
}
