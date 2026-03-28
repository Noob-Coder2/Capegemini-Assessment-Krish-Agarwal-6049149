package assesment2.cg.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assesment2.cg.entity.Loan;
import assesment2.cg.exception.DuplicateLoanApplicationException;
import assesment2.cg.exception.InvalidLoanAmountException;
import assesment2.cg.exception.LoanNotFoundException;
import assesment2.cg.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanRepository loanRepo;

    @Override
    public Loan applyForLoan(Loan loan){
        if (loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 5000000){
            throw new InvalidLoanAmountException("Loan amount must be between 1 and 5,000,000");
        }

        List<Loan> pendingLoans = loanRepo.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING");
        if (!pendingLoans.isEmpty()){
            throw new DuplicateLoanApplicationException("Applicant already has a pending loan application");
        }
        
        loan.setStatus("PENDING");
        return loanRepo.save(loan);
    }

    @Override
    public List<Loan> getAllLoans(){
        return loanRepo.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepo.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan with ID " + id + " not found"));
    }

    @Override
    public Loan updateLoanStatus(Long id, Map<String, String> statusUpdate) {
        Loan loan = getLoanById(id);
        String newStatus = statusUpdate.get("status");
        
        if (newStatus != null && (newStatus.equalsIgnoreCase("APPROVED") || newStatus.equalsIgnoreCase("REJECTED"))) {
            loan.setStatus(newStatus.toUpperCase());
        } else {
            throw new IllegalArgumentException("Invalid status. Use 'APPROVED' or 'REJECTED'");
        }
        
        return loanRepo.save(loan);
    }
}
