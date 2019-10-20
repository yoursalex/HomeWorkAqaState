package ru.netology.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
    void checkRemainIfAmountIs900() {
        CashbackHackService cashBackService = new CashbackHackService();
        int amount = 900;
        int actual = cashBackService.remain(amount);
        int expected = 100;

        assertEquals(expected,actual);
    }

    @Test
    void checkRemainIfAmountIs1000() {
        CashbackHackService cashBackService = new CashbackHackService();
        int amount = 1000;
        int actual = cashBackService.remain(amount);
        int expected = 0;

        assertEquals(expected,actual);
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