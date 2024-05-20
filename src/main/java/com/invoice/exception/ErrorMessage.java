package com.invoice.exception;

import java.time.LocalDateTime;

public record ErrorMessage(LocalDateTime timeStamp, String message, int status) {
}
