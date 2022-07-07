package ru.javarush.cryptoanalyzer.marzhiievskyi;

import ru.javarush.cryptoanalyzer.marzhiievskyi.app.Application;
import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;

public class Run {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        application.run(args);


//        String textDemo = "Привіт мене звати Дмитро\n" +
//                "And who u are?";
//        System.out.println(textDemo);
//        String result = Cryptographer.encryption(textDemo, 3);
//        System.out.println(result);
//        String result2 = Cryptographer.decryption(result, 3);
//        System.out.println(result2);


    }
}
