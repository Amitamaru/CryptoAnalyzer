package ru.javarush.cryptoanalyzer.marzhiievskyi.controller;

import ru.javarush.cryptoanalyzer.marzhiievskyi.commands.Action;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;


public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = ActionsContainer.find(command);
        return action.execute(parameters);
    }

}
