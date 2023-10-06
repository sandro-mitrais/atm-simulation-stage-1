package org.learning.atmsimulation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.learning.atmsimulation.model.Account;

public class AccountServiceTest {

    @Test
    void addBalance_withValidData_returnSuccess() {
        AccountService accountService = new AccountService();
        Account account = new Account("Sandro", 1000.0);

        accountService.addBalance(account, 50.0);
        org.assertj.core.api.Assertions.assertThat(account.getBalance()).isEqualTo(1050.0);
    }

    @Test
    void reduceBalance_withValidData_returnSuccess() throws Exception {
        AccountService accountService = new AccountService();
        Account account = new Account("Sandro", 1000.0);

        accountService.reduceBalance(account, 50.0);
        org.assertj.core.api.Assertions.assertThat(account.getBalance()).isEqualTo(950.0);
    }

    @Test
    void reduceBalance_withInvalidData_returnException() throws Exception {
        AccountService accountService = new AccountService();
        Account account = new Account("Sandro", 10.0);

        Assertions.assertThrows(Exception.class, () -> accountService.reduceBalance(account, 50.0));
    }

    @Test
    void transferBalance_withValidData_returnSuccess() throws Exception {
        AccountService accountService = new AccountService();

        Account accountA = new Account("A", 100.0);
        Account accountB = new Account("B", 50.0);

        accountService.transfer(accountA, accountB, 10.0);

        org.assertj.core.api.Assertions.assertThat(accountA.getBalance()).isEqualTo(90.0);
        org.assertj.core.api.Assertions.assertThat(accountB.getBalance()).isEqualTo(60.0);
    }

    @Test
    void transferBalance_withInvalidData_returnException() {
        AccountService accountService = new AccountService();

        Account accountA = new Account("A", 10.0);
        Account accountB = new Account("B", 50.0);

        Assertions.assertThrows(Exception.class, () -> accountService.transfer(accountA, accountB, 11.0));
    }
}