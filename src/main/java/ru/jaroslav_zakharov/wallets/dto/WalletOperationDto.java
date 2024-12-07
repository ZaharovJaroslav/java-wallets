package ru.jaroslav_zakharov.wallets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletOperationDto {
    @NotNull
    private Long walletId;

    @NotNull
    @NotBlank
    private String operationType;

    @NotNull
    private Double amount;
}
