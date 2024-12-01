package ru.jaroslav_zakharov.wallets.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jaroslav_zakharov.wallets.dto.WalletOperationDto;
import ru.jaroslav_zakharov.wallets.service.WalletsService;

@RestController
@RequestMapping("api/v1")
@Slf4j
@RequiredArgsConstructor
public class WalletsController {
    private final WalletsService walletsService;

    @PostMapping("/wallet")
    public Double depositOrWithdraw(@Valid @RequestBody WalletOperationDto walletOperationDto) {
        return null;
    }

    @GetMapping("wallets/")
    public Double getBalance(@PathVariable Long walletId) {
        return null;
    }
}
