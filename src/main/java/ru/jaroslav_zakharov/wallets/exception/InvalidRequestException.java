package ru.jaroslav_zakharov.wallets.exception;

public class InvalidRequestException extends  RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
