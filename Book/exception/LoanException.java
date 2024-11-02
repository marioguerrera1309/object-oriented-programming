package org.unict.exception;

import org.unict.api.Loanable;

public class LoanException extends Exception {
    Loanable loanable;

    public LoanException() {
        super("LoanException raised");
    }

    public LoanException(String message) {
        super(message);
    }

    public LoanException(Loanable loanable) {
        super("exception: book " + loanable.toString() + "already lend");
        this.loanable=loanable;
    }

    public Loanable getLoanable() {
        return loanable;
    }
}
