package ru.javarush.cryptoanalyzer.marzhiievskyi.constants;

public class Strings {
    private final String engAlphabet = "qwertyuiopasdfghjklzxcvbnm";
    private final String rusAlphabet = "йцукенгшщзхъфывапролджэячсмитьбюё";
    private final String ukrAlphabet = "йцукенгшщзхїфівапролджєячсмитьбю";
    private final String numeric = "0123456789";
    private final String symbols = ".,/?'\"[];:!@#$%^&*()";

    // all symbols what we are going to use for crypto analyzer
    public final String allSymbols =
            engAlphabet + engAlphabet.toUpperCase()
            + rusAlphabet + rusAlphabet.toUpperCase() + ukrAlphabet
            + ukrAlphabet.toUpperCase() + numeric + symbols;

}
