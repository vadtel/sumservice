package org.vadtel.sumservice.exception;

public class ApiExceptionNotFoundInDatabase extends RuntimeException {
    public ApiExceptionNotFoundInDatabase(String message) {
        super(message);
    }

    public ApiExceptionNotFoundInDatabase(Throwable cause) {
        super(cause);
    }

    public ApiExceptionNotFoundInDatabase() {
        this("Number not found in database");
    }
}
