package com.mycompany.user.exception;

import java.util.Date;

public record ErrorMessage(int statusCode, Date timestamp, String message) {
}
