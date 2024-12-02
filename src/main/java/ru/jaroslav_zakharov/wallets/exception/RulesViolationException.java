package ru.jaroslav_zakharov.wallets.exception;

public class RulesViolationException extends  RuntimeException {
    public RulesViolationException(String message) {
        super(message);
    }
}
