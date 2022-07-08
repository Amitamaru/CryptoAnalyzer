package ru.javarush.cryptoanalyzer.marzhiievskyi;

import ru.javarush.cryptoanalyzer.marzhiievskyi.app.Application;
import ru.javarush.cryptoanalyzer.marzhiievskyi.controller.MainController;


public class Run {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        application.run(args);



        String textDemo = "Java[прим. 1] — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle). Разработка ведётся сообществом, организованным через Java Community Process; язык и основные реализующие его технологии распространяются по лицензии GPL. Права на торговую марку принадлежат корпорации Oracle.";
        int keyShift = 12;
        System.out.println("Demo text is: \n" + textDemo);

        String reviewText = "Приложения Java обычно транслируются в специальный байт-код, поэтому они могут работать на любой компьютерной архитектуре, для которой существует реализация виртуальной Java-машины. Дата официального выпуска — 23 мая 1995 года. Занимает высокие места в рейтингах популярности языков программирования (2-е место в рейтингах IEEE Spectrum (2020)[2] и TIOBE (2021)[3]).";

        String encryptedStr = Cryptographer.encryption(textDemo, keyShift);

        System.out.println("Starting decryption Brut Force ...");
        String result = Cryptographer.brutForceDecryption(encryptedStr, reviewText);
        System.out.println(result);

    }
}
