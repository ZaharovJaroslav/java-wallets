package ru.jaroslav_zakharov.wallets.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.jaroslav_zakharov.wallets.dto.WalletBalanceDto;
import ru.jaroslav_zakharov.wallets.dto.WalletOperationDto;
import ru.jaroslav_zakharov.wallets.service.WalletsService;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class WalletsController {
    private final WalletsService walletsService;

    @PostMapping("/wallet")
    @ResponseStatus(HttpStatus.OK)
    public void depositOrWithdraw(@Valid @RequestBody WalletOperationDto walletOperationDto) {
        walletsService.operationTypeValidation(walletOperationDto);
    }

    @GetMapping("/wallets/{walletId}")
    @ResponseStatus(HttpStatus.OK)
    public WalletBalanceDto getBalance(@PathVariable Long walletId) {
        return walletsService.getBalanceById(walletId);
    }
}
