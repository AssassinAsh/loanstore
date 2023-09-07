package com.loanstore.components;

import com.loanstore.bos.LoansBo;
import com.loanstore.repositories.master.CustomerMasterRepo;
import com.loanstore.repositories.master.LenderMasterRepo;
import com.loanstore.repositories.slave.CustomerSlaveRepo;
import com.loanstore.repositories.slave.LenderSlaveRepo;
import com.loanstore.services.mocks.LoanServiceMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AggregationComponentTest {

    private AutoCloseable closeable;

    @InjectMocks
    private AggregationComponent aggregationComponent;

    @Mock
    private CustomerMasterRepo customerMasterRepo;

    @Mock
    private CustomerSlaveRepo customerSlaveRepo;

    @Mock
    private LenderMasterRepo lenderMasterRepo;

    @Mock
    private LenderSlaveRepo lenderSlaveRepo;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Updates customer aggregation data for new customers")
    public void updateCustomerAggregation_NewCustomer() throws Exception {
        LoansBo bo = LoanServiceMocks.getValidLoanBo();

        // Mock that findByCustomerId returns null, indicating a new customer
        when(customerSlaveRepo.findByCustomerId(bo.getCustomerId())).thenReturn(null);

        aggregationComponent.updateCustomerAggregation(bo);

        // Verify that save is called with the expected customer data
        verify(customerMasterRepo).save(argThat(customer ->
                customer.getCustomerId() == 455 &&
                        customer.getTotalInterest() == 715692.88 &&
                        customer.getTotalRemainingAmount() == 21212.00 &&
                        customer.getTotalPenalty() == 309398.232));
    }

    @Test
    @DisplayName("Updates customer aggregation data for existing customers")
    public void updateCustomerAggregation_ExistingCustomer() throws Exception {
        LoansBo bo = LoanServiceMocks.getValidLoanBo();

        // Mock that findByCustomerId returns an existing customer
        when(customerSlaveRepo.findByCustomerId(bo.getCustomerId())).thenReturn(LoanServiceMocks.getCustomerEntity());

        aggregationComponent.updateCustomerAggregation(bo);

        // Verify that save is called with the expected customer data (updated values)
        verify(customerMasterRepo).save(argThat(customer ->
                customer.getCustomerId() == 455 &&
                        customer.getTotalInterest() == 715742.88 &&
                        customer.getTotalRemainingAmount() == 21412.0 &&
                        customer.getTotalPenalty() == 309408.232));
    }

    @Test
    @DisplayName("Updates customer aggregation data for new lender")
    public void updateLenderAggregation_NewLender() throws Exception {
        LoansBo bo = LoanServiceMocks.getValidLoanBo();

        // Mock that findByLenderId returns null, indicating a new lender
        when(lenderSlaveRepo.findByLenderId(bo.getLenderId())).thenReturn(null);

        aggregationComponent.updateLenderAggregation(bo);

        // Verify that save is called with the expected lender data
        verify(lenderMasterRepo).save(argThat(lender ->
                lender.getLenderId() == 12124 &&
                        lender.getTotalInterest() == 715692.88 &&
                        lender.getTotalRemainingAmount() == 21212.00 &&
                        lender.getTotalPenalty() == 309398.232));
    }

    @Test
    @DisplayName("Updates customer aggregation data for existing lender")
    public void updateLenderAggregation_ExistingLender() throws Exception {
        LoansBo bo = LoanServiceMocks.getValidLoanBo();

        // Mock that findByCustomerId returns an existing customer
        when(lenderSlaveRepo.findByLenderId(bo.getLenderId())).thenReturn(LoanServiceMocks.getLenderEntity());

        aggregationComponent.updateLenderAggregation(bo);

        // Verify that save is called with the expected customer data (updated values)
        verify(lenderMasterRepo).save(argThat(lender ->
                lender.getLenderId() == 12124 &&
                        lender.getTotalInterest() == 715742.88 &&
                        lender.getTotalRemainingAmount() == 21412.0 &&
                        lender.getTotalPenalty() == 309408.232));
    }
}