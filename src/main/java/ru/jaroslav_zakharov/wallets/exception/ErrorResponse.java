package ru.jaroslav_zakharov.wallets.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static ru.jaroslav_zakharov.wallets.constant.Constants.DATE_FORMAT;

@Data
@RequiredArgsConstructor
public class ErrorResponse {

    private final HttpStatus status;
    private final String reason;
    private final String message;

    @JsonFormat(pattern = DATE_FORMAT)
    private final LocalDateTime timestamp;
}
