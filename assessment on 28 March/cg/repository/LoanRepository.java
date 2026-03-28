package assesment2.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assesment2.cg.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
    List<Loan> findByApplicantNameAndStatus(String applicantName, String status);
}
