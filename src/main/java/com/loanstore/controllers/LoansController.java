package com.loanstore.controllers;

import com.loanstore.dtos.LoanRequestDto;
import com.loanstore.dtos.LoanResponseDto;
import com.loanstore.exceptions.InvalidLoanException;
import com.loanstore.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("loans")
public class LoansController {

    private final LoanService loanService;

    @Autowired
    public LoansController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(path = "update")
    public ResponseEntity<LoanResponseDto> updateLoan(@RequestBody LoanRequestDto dto) {
        try {
            return new ResponseEntity<>(loanService.updateLoan(dto), HttpStatus.OK);
        } catch (InvalidLoanException ex) {
            return new ResponseEntity<>(new LoanResponseDto(false, "Invalid Data", ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ParseException ex) {
            return new ResponseEntity<>(new LoanResponseDto(false, "Invalid Dates", "Error while parsing dates"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            return new ResponseEntity<>(new LoanResponseDto(false, "Error Occurred", ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
