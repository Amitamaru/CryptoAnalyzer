package ru.javarush.cryptoanalyzer.marzhiievskyi.processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class InputOutput {

    public static String gettingTextFromFIle(String inputFile) throws IOException {
        Path inputPath = Path.of(inputFile);
        String readyMessage = "";
        if (Files.exists(inputPath)) {
            readyMessage = Files.readString(inputPath);
        }
        return readyMessage;
    }

    public static void writingMessageToFile(String outputFile, String outputMessage) throws IOException {
        Path outputPath = Path.of(outputFile);
        if (Files.notExists(outputPath)) {
            Files.createFile(outputPath);
        }
        Files.write(outputPath, outputMessage.getBytes());
    }
}
