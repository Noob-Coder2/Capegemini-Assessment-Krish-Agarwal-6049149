package assesment2.cg.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String error;
    private String message;
    private int errorCode;
    private LocalDateTime timestamp;

    public ErrorResponse(){
        
    }
    
    public ErrorResponse(String error, String message, int errorCode, LocalDateTime timestamp) {
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
}
