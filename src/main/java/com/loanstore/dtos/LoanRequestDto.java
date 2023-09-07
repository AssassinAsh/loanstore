package com.loanstore.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loanstore.models.LoansModel;

/**
 * The type Loans dto.
 */
public class LoanRequestDto extends LoansModel {

    @JsonProperty("paymentDate")
    private String paymentDate;

    @JsonProperty("dueDate")
    private String dueDate;

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
