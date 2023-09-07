package com.loanstore.bos;

import com.loanstore.models.LoansModel;

import java.util.Date;

/**
 * The type Loans bo.
 */
public class LoansBo extends LoansModel {

    private Date paymentDate;

    private Date dueDate;

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
