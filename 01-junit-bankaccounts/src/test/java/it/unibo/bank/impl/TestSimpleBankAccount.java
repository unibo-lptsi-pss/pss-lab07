package it.unibo.bank.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;

public class TestSimpleBankAccount {
    private AccountHolder aRossi;
    private AccountHolder aBianchi;

    @BeforeEach
    public void setUp() {
        this.aRossi = new AccountHolder("Andrea", "Rossi", 1);
        this.aBianchi = new AccountHolder("Alex", "Bianchi", 2);
    }

    @Test
    public void testNewSimpleBankAccount() {
        BankAccount account = new SimpleBankAccount(aRossi, 0.0);
        Assertions.assertEquals(0.0, account.getBalance());
        Assertions.assertEquals(0, account.getTransactionsCount());
        Assertions.assertSame(this.aRossi, account.getAccountHolder());
    }    
}
