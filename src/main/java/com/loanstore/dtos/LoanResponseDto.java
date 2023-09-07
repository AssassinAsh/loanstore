package com.loanstore.dtos;

import com.loanstore.models.ResponseModel;

public class LoanResponseDto extends ResponseModel {

    public LoanResponseDto() {
    }

    public LoanResponseDto(Boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
    }

    public LoanResponseDto(Boolean success, String message, String error) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setError(error);
    }
}
