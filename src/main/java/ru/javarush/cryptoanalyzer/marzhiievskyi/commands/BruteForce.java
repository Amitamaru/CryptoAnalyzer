package ru.javarush.cryptoanalyzer.marzhiievskyi.commands;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.util.PathFinder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parameters) {

        String inputTextFile = parameters[0];
        String decryptedTextFile = parameters[1];
        String reviewTextFile = parameters[2];
        int keyShift = 1;

        List<Character> textCharsList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputTextFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathFinder.getRoot() + decryptedTextFile))) {

            while (bufferedReader.ready()) {
                textCharsList.add((char) bufferedReader.read());
            }


            while (keyShift < Strings.ALPHABET_LIST.size()) {
                List<Character> oneOfListsChars = new ArrayList<>();
                for (Character character : textCharsList) {
                    int charPos = Strings.ALPHABET_LIST.indexOf(character);
                    int keyValue = (charPos - keyShift) % Strings.ALPHABET_LIST.size();
                    if (keyValue < 0) {
                        keyValue = Strings.ALPHABET_LIST.size() + keyValue;
                    }
                    char replChar = Strings.ALPHABET_LIST.get(keyValue);
                    oneOfListsChars.add(replChar);
                }

                keyShift++;
            }
            //TODO finish bruteforce decryption
            return new Result(ResultCode.OK, "Decryption is OK");



        } catch (IOException e) {
            throw new AppException("IO Err ", e);
        }

    }
}
