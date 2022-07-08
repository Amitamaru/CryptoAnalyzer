package ru.javarush.cryptoanalyzer.marzhiievskyi.processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class InputOutput {
    private final String inputParameter;
    private final String outputParameter;

    public InputOutput(String inputParameter, String outputParameter) {
        this.inputParameter = inputParameter;
        this.outputParameter = outputParameter;
    }

    public String gettingTextFromFIle() throws IOException {
        Path inputPath = Path.of(inputParameter);
        String readyMessage = "";
        if (Files.exists(inputPath)) {
            readyMessage = Files.readString(inputPath);
        }
        return readyMessage;
    }

    public void writingMessageToFile(String outputMessage) throws IOException {
        Path outputPath = Path.of(outputParameter);
        if (Files.notExists(outputPath)) {
            Files.createFile(outputPath);
        }
        Files.write(outputPath, outputMessage.getBytes());
    }
}
