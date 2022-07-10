package ru.javarush.cryptoanalyzer.marzhiievskyi.controller;

import ru.javarush.cryptoanalyzer.marzhiievskyi.commands.Action;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.ResultCode;
import ru.javarush.cryptoanalyzer.marzhiievskyi.exeptions.AppException;


public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = ActionsContainer.find(command);
        try {
            return action.execute(parameters);
        } catch (AppException e) {
            return new Result(ResultCode.ERROR, "Failed");
        }

    }

}
