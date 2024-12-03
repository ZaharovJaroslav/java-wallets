package ru.jaroslav_zakharov.wallets.service;

import ru.jaroslav_zakharov.wallets.dto.WalletBalanceDto;
import ru.jaroslav_zakharov.wallets.dto.WalletOperationDto;

public interface WalletsService {
    void operationTypeValidation(WalletOperationDto walletOperationDto);
    void addDeposit(Long walletId, Double amount);
    void withdrawDeposit(Long walletId, Double amount);
    WalletBalanceDto getBalanceById(Long walletId);
}
