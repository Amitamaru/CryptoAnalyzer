package ru.javarush.cryptoanalyzer.marzhiievskyi.user_interface;

import ru.javarush.cryptoanalyzer.marzhiievskyi.commandSelector.AppOfCommands;
import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;
import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;
import ru.javarush.cryptoanalyzer.marzhiievskyi.entity.Result;

import java.util.Scanner;

public class CLI_Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        AppOfCommands commandSelector = new AppOfCommands(mainController);
        String[] parameters = new  String[4];

        Scanner console = new Scanner(System.in);
        System.out.println(Strings.WELCOME_MESSAGE);
        String command = console.next();

        parameters[0] = command;

        //TODO modify view console!!!
            if ("encrypt".equalsIgnoreCase(command)) {
                System.out.println("Enter input file with text");
                parameters[1] = console.next();
                System.out.println("Enter output name file");
                parameters[2] = console.next();
                System.out.println("Enter key to encrypt");
                parameters[3] = console.next();
            } else if ("decrypt".equalsIgnoreCase(command)) {
                System.out.println("Enter input file with encrypted text");
                parameters[1] = console.next();
                System.out.println("Enter output name file");
                parameters[2] = console.next();
                System.out.println("Enter key to encrypt");
                parameters[3] = console.next();
            } else if ("bruteforce".equalsIgnoreCase(command)) {
                System.out.println("Enter input file with encrypted text");
                parameters[1] = console.next();
                System.out.println("Enter output name file");
                parameters[2] = console.next();
                System.out.println("Enter example text file");
                parameters[3] = console.next();
            }


        Result result = commandSelector.run(parameters);
        System.out.println(result);
    }
}
