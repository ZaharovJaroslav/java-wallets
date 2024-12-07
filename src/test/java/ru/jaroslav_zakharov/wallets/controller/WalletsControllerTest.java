package ru.jaroslav_zakharov.wallets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.jaroslav_zakharov.wallets.dto.WalletBalanceDto;
import ru.jaroslav_zakharov.wallets.dto.WalletOperationDto;
import ru.jaroslav_zakharov.wallets.service.WalletsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(WalletsController.class)
@AutoConfigureMockMvc
class WalletsControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WalletsService walletsService;


    @Test
    void balanceById() throws Exception {
        WalletBalanceDto walletBalanceDto  = new WalletBalanceDto();
        walletBalanceDto.setBalance(100D);

        Mockito.when(walletsService.getBalanceById(anyLong()))
                .thenReturn(walletBalanceDto);

        String result =  mockMvc.perform(get("/api/v1/wallets/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        verify(walletsService, times(1)).getBalanceById(anyLong());
        assertEquals(objectMapper.writeValueAsString(walletBalanceDto), result);
    }

    @Test
    void addDeposit() throws Exception {
        WalletOperationDto walletOperationDto = new WalletOperationDto();
        walletOperationDto.setWalletId(1L);
        walletOperationDto.setOperationType("DEPOSIT");
        walletOperationDto.setAmount(100D);

        String depositOperationJson = objectMapper.writeValueAsString(walletOperationDto);
        mockMvc.perform(post("/api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(depositOperationJson))
                .andExpect(status().isOk());
    }
}