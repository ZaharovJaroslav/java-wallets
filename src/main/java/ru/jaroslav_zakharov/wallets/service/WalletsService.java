package ru.jaroslav_zakharov.wallets.service;

import ru.jaroslav_zakharov.wallets.dto.WalletBalanceDto;
import ru.jaroslav_zakharov.wallets.dto.WalletOperationDto;

public interface WalletsService {
    void operationType(WalletOperationDto walletOperationDto);
    void addDeposit();
    void withdrawDeposit();
    WalletBalanceDto getBalanceById(Long walletId);
}
