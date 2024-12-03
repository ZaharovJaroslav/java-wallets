package ru.jaroslav_zakharov.wallets.mapper;

import ru.jaroslav_zakharov.wallets.dto.WalletBalanceDto;
public class WalletMapper {

    public static WalletBalanceDto toWalletBalanceDto (Double balance) {
        WalletBalanceDto walletBalanceDto = new WalletBalanceDto();
        walletBalanceDto.setBalance(balance);
        return walletBalanceDto;

    }
}