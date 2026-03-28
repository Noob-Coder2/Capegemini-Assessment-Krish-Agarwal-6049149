package assesment2.cg.service;

import java.util.List;
import java.util.Map;

import assesment2.cg.entity.Loan;

public interface LoanService {
    Loan applyForLoan(Loan loan);
    List<Loan> getAllLoans();
    Loan getLoanById(Long id);
    Loan updateLoanStatus(Long id, Map<String, String> statusUpdate);
}
