package ru.jaroslav_zakharov.wallets.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WalletOperationDto {
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String operation;

    @NotNull
    @Size(min = 50, message = "Сумма не может быть меньше 50 рублей ")
    private Double amount;
}
