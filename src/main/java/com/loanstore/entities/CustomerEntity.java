package com.loanstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerAggregation")
public class CustomerEntity {

    @Id
    @Column(name = "CustomerId")
    private Integer customerId;

    @Column(name = "TotalRemainingAmount")
    private Double totalRemainingAmount;

    @Column(name = "TotalInterest")
    private Double totalInterest;

    @Column(name = "TotalPenalty")
    private Double totalPenalty;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getTotalRemainingAmount() {
        return totalRemainingAmount;
    }

    public void setTotalRemainingAmount(Double totalRemainingAmount) {
        this.totalRemainingAmount = totalRemainingAmount;
    }

    public Double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(Double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public Double getTotalPenalty() {
        return totalPenalty;
    }

    public void setTotalPenalty(Double totalPenalty) {
        this.totalPenalty = totalPenalty;
    }
}
