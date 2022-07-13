package ru.javarush.cryptoanalyzer.marzhiievskyi.constants;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    //private static final String ENG_ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
    private static final String CYRILLIC_ALPHABET = "йцукенгшщзхъфывапролджэячсмитьбюёіїє";
    private static final String NUMERIC = "0123456789";
    private static final String SYMBOLS = "-.,/?'\"[];:!() *";

    private static final String ALL_SYMBOLS =
            CYRILLIC_ALPHABET + CYRILLIC_ALPHABET.toUpperCase() + NUMERIC + SYMBOLS;

    public static final List<Character> ALPHABET_LIST = new ArrayList<>();

    static {
        for (Character ch : ALL_SYMBOLS.toCharArray()) {
            ALPHABET_LIST.add(ch);
        }
    }
            //Сообщения, которые использует программа
    public static final String WELCOME_MESSAGE = "\nДобро пожаловать в Шифр Цезаря. Выберете и введите номер команды, " +
                    "или слово \"exit\" для выхода из программы.";
    public static final String CHOSE_COMMAND = """

            Выберете действие :\s
            Введите 1 чтобы зашифровать текст из файле
            Введите 2 чтобы расшифровать текст из зашифрованного
            Введите 3 чтобы расшифровать методом Brute Force
            Введите 4 чтобы попробовать расшифровать статистическим анализом""";
    public static final String ENTER_KEY_SHIFT = "Введите цифру-ключ шифрования";
    public static final String ENTER_ENCRYPTED_TEXT_FILE = "Введите имя файла, на котором зашифрован текст";
    public static final String ENTER_INPUT_FILE_TEXT = "Введите имя файла с текстом для шифрования";
    public static final String ENTER_OUT_FILE_NAME = "Введите имя файла, в котором будет результат";
    public static final String ENTER_INPUT_DICTIONARY_TEXT_FILE = "Введите имя файла, в котором текст того же автора, для анализа";
    public static final String GOOD_BYE = "До свидания";
    public static final String IO_EXCEPTION_MSG = "Ошибка пути файла";
    public static final String ARGS_EXCEPTION_MSG = "Некорректно заданы аргументы";
    public static final String KEY_EXCEPTION_MSG = "Значение ключа не может быть отрицательным";
}
