package ru.javarush.cryptoanalyzer.marzhiievskyi.user_interface;

import ru.javarush.cryptoanalyzer.marzhiievskyi.commandSelector.AppOfCommands;
import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;


public class CUI_Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        AppOfCommands commandSelector = new AppOfCommands(mainController);
        Result result = commandSelector.run(args);
        System.out.println(result);

    }
}
