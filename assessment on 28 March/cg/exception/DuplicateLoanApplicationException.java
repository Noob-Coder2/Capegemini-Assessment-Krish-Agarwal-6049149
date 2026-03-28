package assesment2.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateLoanApplicationException extends RuntimeException {
    public DuplicateLoanApplicationException(String message) {
        super(message);
    }
}