package ru.javarush.cryptoanalyzer.marzhiievskyi.app;

import java.util.Arrays;

public class Application {
    public void run(String[] args) {
        String[] parameters = Arrays.copyOfRange(args, 0, args.length);
        System.out.println(Arrays.toString(parameters));
    }
}
