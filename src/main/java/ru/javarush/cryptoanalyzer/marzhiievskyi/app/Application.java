package ru.javarush.cryptoanalyzer.marzhiievskyi.app;

import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public void run(String[] args) {
        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        mainController.execute(command, parameters);
    }
}
