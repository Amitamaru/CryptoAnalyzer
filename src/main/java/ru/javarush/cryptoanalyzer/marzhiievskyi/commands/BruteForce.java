package ru.javarush.cryptoanalyzer.marzhiievskyi.commands;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.AppException;
import ru.javarush.cryptoanalyzer.marzhiievskyi.util.PathFinder;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce extends DecryptingKeyShift implements Action {


    @Override
    public Result execute(String[] parameters) {

        String inputTextFile = parameters[0];
        String decryptedTextFile = parameters[1];
        int keyShift = 1;

        List<Character> encryptedCharsList = new ArrayList<>();

        Result result = new Result(ResultCode.ERROR, Strings.MSG_DECRYPTION_DONE_FAILED);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PathFinder.getRoot() + inputTextFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathFinder.getRoot() + decryptedTextFile))) {
            while (bufferedReader.ready()) {
                encryptedCharsList.add((char) bufferedReader.read());
            }

            while (keyShift < Strings.ALPHABET_LIST.size()) {
                List<Character> oneOfListsChars = new ArrayList<>();
                for (Character character : encryptedCharsList) {
                    oneOfListsChars.add(decryptingByKeyShift(character, keyShift));
                }
                StringBuilder oneOfResultString = new StringBuilder();
                for (Character ch : oneOfListsChars) {
                    oneOfResultString.append(ch);
                }
                Pattern patter = Pattern.compile(Strings.REGEX_FINDER_PATTERN);
                Matcher matcher = patter.matcher(oneOfResultString);
                if (matcher.find()) {
                    bufferedWriter.write(String.valueOf(oneOfResultString));
                    result = new Result(ResultCode.OK, Strings.MSG_DECRYPTION_BRUTE_FORCE_DONE_WELL
                            + keyShift
                            + Strings.MSG_PATH_TO_THE_RESULT
                            + PathFinder.getRoot()
                            + decryptedTextFile);
                    break;
                }
                keyShift++;
            }

        } catch (IOException e) {
            throw new AppException(Strings.IO_EXCEPTION_MSG, e);
        }
        return result;
    }
}
