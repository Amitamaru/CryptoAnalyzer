package ru.javarush.cryptoanalyzer.marzhiievskyi.controller;

import ru.javarush.cryptoanalyzer.marzhiievskyi.commands.*;

public enum ActionsContainer {
    ENCRYPT(new Encryption()),
    DECRYPT(new Decryption()),
    BRUTEFORCE(new BruteForce()),
    TEXTANALYZER(new TextAnalyzer());

    public final Action action;


    ActionsContainer(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return ActionsContainer.valueOf(command.toUpperCase()).action;
    }
}
