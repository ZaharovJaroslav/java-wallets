package ru.jaroslav_zakharov.wallets.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.jaroslav_zakharov.wallets.dto.WalletBalanceDto;
import ru.jaroslav_zakharov.wallets.dto.WalletOperationDto;
import ru.jaroslav_zakharov.wallets.exception.InvalidRequestException;
import ru.jaroslav_zakharov.wallets.exception.ObjectNotFoundException;
import ru.jaroslav_zakharov.wallets.exception.RulesViolationException;
import ru.jaroslav_zakharov.wallets.mapper.WalletMapper;
import ru.jaroslav_zakharov.wallets.model.OperationType;
import ru.jaroslav_zakharov.wallets.model.Wallet;
import ru.jaroslav_zakharov.wallets.repository.WalletsRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalletsServiceImpl implements WalletsService {
   private final WalletsRepository walletsRepository;


    @Override
    public void operationTypeValidation(WalletOperationDto walletOperationDto) {
        String operationType = walletOperationDto.getOperation();
       if (OperationType.DEPOSIT.toString().equals(operationType)) {
           addDeposit(walletOperationDto.getId(), walletOperationDto.getAmount());
       } else if (OperationType.DEPOSIT.toString().equals(operationType)) {
           withdrawDeposit(walletOperationDto.getId(), walletOperationDto.getAmount());
       } else
           throw new InvalidRequestException("Incorrect type of operation");
    }

    @Override
    public void addDeposit(Long walletId, Double amount) {
        log.info("Add deposit: amount = {} ", amount);
        Wallet wallet = getWalletOrThrow(walletId);
        wallet.setBalance(wallet.getBalance() + amount);
        walletsRepository.save(wallet);
    }

    @Override
    public void withdrawDeposit(Long walletId, Double amount) {
        log.info("Withdraw Deposit: amount = {} ", amount);
        Wallet wallet = getWalletOrThrow(walletId);
        if (wallet.getBalance() < amount) {
             throw new RulesViolationException("Wallet balance is less than the withdrawal amount");
        }
        wallet.setBalance(wallet.getBalance() - amount);
        walletsRepository.save(wallet);
    }

    @Override
    public WalletBalanceDto getBalanceById(Long walletId) {
        log.info("Get a balance");
        Wallet wallet = getWalletOrThrow(walletId);
        return WalletMapper.toWalletBalanceDto(wallet.getBalance());
    }

    private Wallet getWalletOrThrow(Long walletId) {
        return walletsRepository.findById(walletId).orElseThrow(
                () -> new ObjectNotFoundException(String.format("Wallet with id = %d was not found", walletId)));
    }
}