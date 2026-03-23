package ottimizza_eduardo_testepleno.exceptions.handler;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
