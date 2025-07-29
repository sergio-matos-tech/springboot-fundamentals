package org.api.firststeps.exception;

import java.time.LocalDate;

public record ExceptionResponse(LocalDate timestamp, String message, String details) {}
