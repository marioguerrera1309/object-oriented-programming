package org.unict.api;

import org.unict.exception.LoanException;
import org.unict.model.Loan;
import org.unict.model.User;

import java.time.LocalDate;
import java.util.Locale;

public interface Loanable {

    void lend(User u, LocalDate startLoan, LocalDate endLoan) throws LoanException;
    void revokeLoan();
    Loan getLoan();
}
