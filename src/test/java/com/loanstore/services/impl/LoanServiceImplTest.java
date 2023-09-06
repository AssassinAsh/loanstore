package com.loanstore.services.impl;

import com.loanstore.bos.LoansBo;
import com.loanstore.components.AggregationComponent;
import com.loanstore.dtos.LoanRequestDto;
import com.loanstore.dtos.LoanResponseDto;
import com.loanstore.entities.LoansEntity;
import com.loanstore.exceptions.InvalidLoanException;
import com.loanstore.mappers.LoansMapper;
import com.loanstore.repositories.master.LoanMasterRepo;
import com.loanstore.services.mocks.LoanServiceMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LoanServiceImplTest {

    private AutoCloseable closeable;

    @InjectMocks
    private LoanServiceImpl loanService;

    @Mock
    private LoanMasterRepo loanMasterRepo;

    @Mock
    private AggregationComponent aggregationComponent;

    @Mock
    private LoansMapper loansMapper;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Payment date greater than due date, throws invalid loan exception")
    public void updateLoan_InvalidPaymentDate() throws Exception {
        LoanRequestDto dto = LoanServiceMocks.getLoanRequestDto();

        when(loansMapper.dtoToBo(dto)).thenReturn(LoanServiceMocks.getInvalidLoanBo());

        assertThrows(InvalidLoanException.class, () -> loanService.updateLoan(dto));
    }

    @Test
    @DisplayName("Successfully updates loan entry to database")
    public void updateLoan_Success() throws Exception {
        LoanRequestDto dto = LoanServiceMocks.getLoanRequestDto();

        LoansBo bo = LoanServiceMocks.getValidLoanBo();

        when(loansMapper.dtoToBo(dto)).thenReturn(bo);

        LoansEntity entity = LoanServiceMocks.getLoansEntity();

        when(loansMapper.boToEntity(bo)).thenReturn(entity);

        LoanResponseDto responseDto = loanService.updateLoan(dto);

        assertAll(
                () -> assertTrue(responseDto.getSuccess()),
                () -> assertEquals("Loan Saved Successfully", responseDto.getMessage()));
    }
}