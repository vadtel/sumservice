package org.vadtel.sumservice.exception;

public class ApiExceptionDuplicateEntry extends RuntimeException {
    public ApiExceptionDuplicateEntry() {
        this("Duplicate entry");
    }

    public ApiExceptionDuplicateEntry(String message) {
        super(message);
    }

    public ApiExceptionDuplicateEntry(Throwable cause) {
        super(cause);
    }
}
