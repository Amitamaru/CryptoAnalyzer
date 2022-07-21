package ru.javarush.cryptoanalyzer.marzhiievskyi.entity;

import ru.javarush.cryptoanalyzer.marzhiievskyi.constants.Strings;

public class Result {
    private final ResultCode resultCode;
    private final String message;

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return Strings.ANSI_YELLOW + Strings.RESULT_OF_PROGRAM + Strings.CODE_OF_RESULT + Strings.ANSI_RESET
                + resultCode
                + Strings.ANSI_YELLOW + Strings.MESSAGE_WORD + Strings.ANSI_RESET
                + message;
    }
}
