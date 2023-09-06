package com.loanstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LenderAggregation")
public class LenderEntity {

    @Id
    @Column(name = "LenderId")
    private Integer lenderId;

    @Column(name = "TotalRemainingAmount")
    private Double totalRemainingAmount;

    @Column(name = "TotalInterest")
    private Double totalInterest;

    @Column(name = "TotalPenalty")
    private Double totalPenalty;

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
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
