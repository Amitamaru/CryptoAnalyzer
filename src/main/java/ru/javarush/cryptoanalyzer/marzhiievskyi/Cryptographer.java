package ru.javarush.cryptoanalyzer.marzhiievskyi;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cryptographer {
    private static final String ALPHABET = Strings.ALL_SYMBOLS;


    public static String encryption(String message, int keyShift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            int charPos = ALPHABET.indexOf(message.charAt(i));
            int keyVal = (charPos + keyShift) % ALPHABET.length();
            char replaceChar = ALPHABET.charAt(keyVal);
            result.append(replaceChar);
        }
        return result.toString();
    }


    public static String decryption(String encryptedMessage, int keyShift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            int charPos = ALPHABET.indexOf(encryptedMessage.charAt(i));
            int keyVal = (charPos - keyShift) % ALPHABET.length();
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceChar = ALPHABET.charAt(keyVal);
            result.append(replaceChar);
        }
        return result.toString();

    }

    public static String brutForceDecryption(String encryptedMessage, String reviewText) {
        Map<Integer, String> mapWithResults = new HashMap<>();

        int keyShift = 1;
        while (keyShift < ALPHABET.length()) {
            mapWithResults.put(keyShift, decryption(encryptedMessage, keyShift));
            keyShift++;
        }
        return gettingBestMatch(mapWithResults, reviewText);
    }

    private static String gettingBestMatch(Map<Integer, String> decryptedMap, String reviewText) {

        List<String> example = List.of(reviewText.split(" "));
        String result = "";

        for (var elem : decryptedMap.entrySet()) {
            String tmpResult = elem.getValue();
            List<String> str = List.of(tmpResult.split(" "));
            for (String s : example) {
                if (str.contains(s)) {
                    result = tmpResult;
                    System.out.println(elem.getKey()+ "<----");//   <- delete after finish
                    break;
                }
            }
        }
        return result;
    }


}
