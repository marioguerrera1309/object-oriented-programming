package org.unict.model;

import org.unict.api.Loanable;
import org.unict.exception.LoanException;

import java.time.LocalDate;

public class PaperBook extends Book implements Loanable {

    private Loan loan;

    public PaperBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    @Override
    public void lend(User u, LocalDate startLoan, LocalDate endLoan) throws LoanException {
        if (this.loan != null) {
            //NOTICE different LoadException builder methods
//            throw new LoanException("Book already loaned");
//            throw new LoanException("Book "+ this.toString() + "already loaned");
            throw new LoanException(this);
        }
        this.loan = new Loan(u, startLoan, endLoan);
    }

    @Override
    public void revokeLoan() {
        this.loan = null;
    }

    @Override
    public Loan getLoan() {
        return loan;
    }

    @Override
    public String toString() {
        return "PaperBook{" +
                "loan=" + loan +
                '}';
    }
}
