package ru.javarush.cryptoanalyzer.marzhiievskyi.commands;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.util.PathFinder;

import java.io.*;
import java.util.*;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parameters) {

        String inputTextFile = parameters[0];
        String decryptedTextFile = parameters[1];
        String reviewTextFile = parameters[2];
        int keyShift = 1;

        List<Character> encryptedCharsList = new ArrayList<>();
        //Если не будет совпадения результат будет отрицательным
        Result result = new Result(ResultCode.ERROR, "Расшифрование закончено неудачно");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputTextFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathFinder.getRoot() + decryptedTextFile));
             BufferedReader bufferedReaderDict = new BufferedReader(new FileReader(PathFinder.getRoot() + reviewTextFile))) {
            //прочитаем зашифрованный файл
            while (bufferedReader.ready()) {
                encryptedCharsList.add((char) bufferedReader.read());
            }
            StringBuilder dict = new StringBuilder();
            //прочитаем словарь (текст по которому будем сравнивать)
            while (bufferedReaderDict.ready()) {
                dict.append(bufferedReaderDict.readLine());
            }
            List<String> dictionary = Arrays.stream(dict.toString().split(" ")).toList();

            Map<Integer, String> mapOfResults = new HashMap<>();
            // переберем все варианты с ключами от 1 до размера алфавита
            while (keyShift < Strings.ALPHABET_LIST.size()) {
                List<Character> oneOfListsChars = new ArrayList<>();
                for (Character character : encryptedCharsList) {
                    int charPos = Strings.ALPHABET_LIST.indexOf(character);
                    int keyValue = (charPos - keyShift) % Strings.ALPHABET_LIST.size();
                    if (keyValue < 0) {
                        keyValue = Strings.ALPHABET_LIST.size() + keyValue;
                    }
                    char replChar = Strings.ALPHABET_LIST.get(keyValue);
                    oneOfListsChars.add(replChar);
                }
                StringBuilder oneOfResultString = new StringBuilder();
                for (Character ch :
                        oneOfListsChars) {
                    oneOfResultString.append(ch);
                }
                //Положим в мапу все возможные варианты (сдвиг, текст);
                mapOfResults.put(keyShift, oneOfResultString.toString());
                keyShift++;
            }

            // Ищем максимальное количество совпадающих слов в каждом из результатов, с примером
            List<Integer> countedMatches = new ArrayList<>();
            for (var value : mapOfResults.entrySet()) {
                String[] s = value.getValue().split(" ");
                int countMatch = 0;
                for (String item : s) {
                    if (dictionary.contains(item)) {
                        countMatch++;
                    }
                }
                countedMatches.add(countMatch);
            }
            // запишем в файл тот вариант расшифровки, у которого наибольшее число совпадающих слов со словарем
            // номер индекса + 1 совпадает с keyShift
            int indexOfKeyMaxMatchesWords = countedMatches.indexOf(Collections.max(countedMatches)) + 1; // + 1 так как ключи начинаются с 1 а не 0
            for (var value :
                    mapOfResults.entrySet()) {
                if (indexOfKeyMaxMatchesWords == value.getKey()) {
                    bufferedWriter.write(value.getValue());
                    result = new Result(ResultCode.OK, "Расшифрование закончено удачно. Ключ шифрования должен быть: " + value.getKey() +
                            "\nПуть к результату: " + PathFinder.getRoot() + decryptedTextFile);
                }
            }
        } catch (IOException e) {
            throw new AppException(Strings.IO_EXCEPTION_MSG, e);
        }
        return result;
    }
}
