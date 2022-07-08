package ru.javarush.cryptoanalyzer.marzhiievskyi.controller;

import ru.javarush.cryptoanalyzer.marzhiievskyi.processing.Cryptographer;
import ru.javarush.cryptoanalyzer.marzhiievskyi.processing.InputOutput;

import java.io.IOException;

public class MainController {
    public void execute(String command, String[] parameters) {
        String input = parameters[0];
        String outputFile = parameters[1];
        String reviewTextFile = parameters[2];
        int shiftKey = Integer.parseInt(parameters[3]);

        try {
            String message = InputOutput.gettingTextFromFIle(input);
            String reviewText = InputOutput.gettingTextFromFIle(reviewTextFile);

            if (command.equalsIgnoreCase("encode")) {
                InputOutput.writingMessageToFile(outputFile, Cryptographer.encryption(message, shiftKey));
            } else if (command.equalsIgnoreCase("decode")) {
                InputOutput.writingMessageToFile(outputFile, Cryptographer.decryption(message, shiftKey));
            } else if (command.equalsIgnoreCase("bruteforce")) {
                InputOutput.writingMessageToFile(outputFile, Cryptographer.brutForceDecryption(message, reviewText));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
