package ru.netology.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/amountOptions.csv", numLinesToSkip = 1)
    void checkRemain(int amount, int expected, String message) {
        CashbackHackService cashBackService = new CashbackHackService();
        int actual = cashBackService.remain(amount);
        assertEquals(expected,actual, message);
    }

    @Test
    void checkThatThrowsExceptionIfAmountBelowZero() {
        CashbackHackService cashBackService = new CashbackHackService();
        int amount = -1;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
           cashBackService.remain(amount);
        });

        assertEquals("amount must be greater than zero", exception.getMessage());
    }

    @Test
    void checkThatThrowsExceptionIfAmountIsZero() {
        CashbackHackService cashBackService = new CashbackHackService();
        int amount = 0;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            cashBackService.remain(amount);
        });

        assertEquals("amount must be greater than zero", exception.getMessage());
    }

}