package com.loanstore.models;

/**
 * The type Loans model.
 */
public class LoansModel {

    private Integer loanId;

    private Integer customerId;

    private Integer lenderId;

    private Double amount;

    private Double remainingAmount;

    private Double interest;

    private Double penalty;

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
