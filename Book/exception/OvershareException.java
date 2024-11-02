package org.unict.exception;

public class OvershareException extends Exception {

    public OvershareException() {
        super("OvershareException raised");
    }

    public OvershareException(String message) {
        super(message);
    }

}
