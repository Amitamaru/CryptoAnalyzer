package ru.javarush.cryptoanalyzer.marzhiievskyi;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import java.util.HashMap;
import java.util.Map;

public class Cryptographer {


    public static String encryption(String message, int keyShift) {
        String alphabet = Strings.ALL_SYMBOLS;
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            int charPos = alphabet.indexOf(message.charAt(i));
            int keyVal = (charPos + keyShift) % alphabet.length();
            char replaceChar = alphabet.charAt(keyVal);
            result += replaceChar;
        }

        return result;

    }


    public static String decryption(String message, int keyShift) {
        String alphabet = Strings.ALL_SYMBOLS;
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            int charPos = alphabet.indexOf(message.charAt(i));
            int keyVal = (charPos - keyShift) % alphabet.length();
            if (keyVal < 0) {
                keyVal = alphabet.length() + keyVal;
            }
            char replaceChar = alphabet.charAt(keyVal);
            result += replaceChar;
        }
        return result;

    }

    public static Map<Integer, String> brutForceDecryption(String encryptedMessage, String representTextExample) {
        String alphabet = Strings.ALL_SYMBOLS;
        String result = "";
        Map<Integer, String> mapWithResults = new HashMap<>();

        int keyShift = 1;
        for (int j = 0; j < alphabet.length(); j++) {
            for (int i = 0; i < encryptedMessage.length(); i++) {
                int charPos = alphabet.indexOf(encryptedMessage.charAt(i));
                int keyVal = (charPos - keyShift) % alphabet.length();
                if (keyVal < 0) {
                    keyVal = alphabet.length() + keyVal;
                }
                char replaceChar = alphabet.charAt(keyVal);
                result += replaceChar;
            }
            mapWithResults.put(keyShift, result);
            keyShift++;
        }
        return mapWithResults;
    }


}
