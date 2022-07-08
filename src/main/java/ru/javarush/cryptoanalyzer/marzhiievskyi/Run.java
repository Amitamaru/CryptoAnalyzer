package ru.javarush.cryptoanalyzer.marzhiievskyi;

import ru.javarush.cryptoanalyzer.marzhiievskyi.app.Application;
import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;


public class Run {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        application.run(args);


    }
}
