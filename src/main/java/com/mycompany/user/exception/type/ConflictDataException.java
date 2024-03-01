package com.mycompany.user.exception.type;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictDataException extends RuntimeException {
    public ConflictDataException(String message, Object... args) {
        super(String.format(message, args));
    }
}
