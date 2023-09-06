package com.loanstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

/**
 * The type Loans entity.
 */
@Entity
@Table(name = "loans")
public class LoansEntity {

    @Id
    @Column(name = "LoanID")
    private Integer loanId;

    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "LenderID")
    private Integer lenderId;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "RemainingAmount")
    private Double remainingAmount;

    @Column(name = "PaymentDate")
    private Date paymentDate;

    @Column(name = "InterestPerDay")
    private Double interest;

    @Column(name = "DueDate")
    private Date dueDate;

    @Column(name = "PenaltyPerDay")
    private Double penalty;

    @Column(name = "Cancelled")
    private Boolean cancelled;

    /**
     * Gets load id.
     *
     * @return the load id
     */
    public Integer getLoanId() {
        return loanId;
    }

    /**
     * Sets load id.
     *
     * @param loanId the load id
     */
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets lender id.
     *
     * @return the lender id
     */
    public Integer getLenderId() {
        return lenderId;
    }

    /**
     * Sets lender id.
     *
     * @param lenderId the lender id
     */
    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets remaining amount.
     *
     * @return the remaining amount
     */
    public Double getRemainingAmount() {
        return remainingAmount;
    }

    /**
     * Sets remaining amount.
     *
     * @param remainingAmount the remaining amount
     */
    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    /**
     * Gets payment date.
     *
     * @return the payment date
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets payment date.
     *
     * @param paymentDate the payment date
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * Gets interest.
     *
     * @return the interest
     */
    public Double getInterest() {
        return interest;
    }

    /**
     * Sets interest.
     *
     * @param interest the interest
     */
    public void setInterest(Double interest) {
        this.interest = interest;
    }

    /**
     * Gets due date.
     *
     * @return the due date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets penalty.
     *
     * @return the penalty
     */
    public Double getPenalty() {
        return penalty;
    }

    /**
     * Sets penalty.
     *
     * @param penalty the penalty
     */
    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    /**
     * Gets cancelled.
     *
     * @return the cancelled
     */
    public Boolean getCancelled() {
        return cancelled;
    }

    /**
     * Sets cancelled.
     *
     * @param cancelled the cancelled
     */
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
