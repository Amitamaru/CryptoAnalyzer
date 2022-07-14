package ru.javarush.cryptoanalyzer.marzhiievskyi.commands;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.util.PathFinder;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TextAnalyzer implements Action {


    @Override
    public Result execute(String[] parameters) {

        String inputEncryptedFile = parameters[0];
        String decryptedTextFile = parameters[1];
        String dictionaryTextFile = parameters[2];

        Result result = new Result(ResultCode.ERROR, "Расшифрование закончено неудачно");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputEncryptedFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathFinder.getRoot() + decryptedTextFile));
             BufferedReader bufferedReaderDictionary = new BufferedReader(new FileReader(PathFinder.getRoot() + dictionaryTextFile))) {

            Map<Character, Integer> mapOfEncryptedText = gettingCountsOfChars(bufferedReader);

            Map<Character, Integer> mapOfDictionaryTextChars = gettingCountsOfChars(bufferedReaderDictionary);
            Map<Character, Character> alphabetToDecrypt = new HashMap<>();


            System.out.println("Example Text");
            int allCharsDict = 0;
            for (var element : mapOfDictionaryTextChars.entrySet()) {
                allCharsDict = allCharsDict + element.getValue();
            }
            for (var el :
                    mapOfDictionaryTextChars.entrySet()) {
                System.out.println(el.getKey() + " : " + el.getValue() );
            }



            System.out.println("Encrypted Text");
            int allCharsEncrypted = 0;
            for (var el : mapOfEncryptedText.entrySet()) {
                allCharsEncrypted = allCharsEncrypted + el.getValue();
            }
            for (var el :
                    mapOfEncryptedText.entrySet()) {
                System.out.println(el.getKey() + " : " + el.getValue() );
            }




            for (var el: alphabetToDecrypt.entrySet()) {
                System.out.println(el.getKey() + " = " + el.getValue());
            }



            char spDict = Collections.max(mapOfDictionaryTextChars.entrySet(), Map.Entry.comparingByValue()).getKey(); // самый часты символ


            char spaceEncr = Collections.max(mapOfEncryptedText.entrySet(), Map.Entry.comparingByValue()).getKey(); // самый часты зашифрованный символ


//            try (BufferedReader fileReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputEncryptedFile));
//                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(PathFinder.getRoot() + decryptedTextFile))) {
//                while (fileReader.ready()) {
//                    char replChar = (char) fileReader.read();
//                    if (replChar == spaceEncr) {
//                        replChar = ' ';
//                    }
//                    fileWriter.write(replChar);
//                }
//                result = new Result(ResultCode.OK, "Расшифрование закончено. Проверте результат." +
//                        "\nПуть к результату: " + PathFinder.getRoot() + decryptedTextFile);
//            }


        } catch (IOException e) {
            throw new AppException(Strings.IO_EXCEPTION_MSG, e);
        }


        return result;
    }

    private Map<Character, Integer> gettingCountsOfChars(BufferedReader bufferedReader) throws IOException {

        Map<Character, Integer> characterIntegerTreeMap = new TreeMap<>();

        while (bufferedReader.ready()) {
            char ch = (char) bufferedReader.read();
            if (characterIntegerTreeMap.get(ch) != null) {
                characterIntegerTreeMap.put(ch, characterIntegerTreeMap.get(ch) + 1);
            } else {
                characterIntegerTreeMap.put(ch, 1);
            }
        }
        return characterIntegerTreeMap;
    }
}
