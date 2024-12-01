package ru.jaroslav_zakharov.wallets.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jaroslav_zakharov.wallets.dto.WalletBalanceDto;
import ru.jaroslav_zakharov.wallets.dto.WalletOperationDto;

@Service
@RequiredArgsConstructor
public class WalletsServiceImpl implements WalletsService {

    @Override
    public void operationType(WalletOperationDto walletOperationDto) {

    }

    @Override
    public void addDeposit() {

    }

    @Override
    public void withdrawDeposit() {

    }

    @Override
    public WalletBalanceDto getBalanceById(Long walletId) {
        return null;
    }
}
