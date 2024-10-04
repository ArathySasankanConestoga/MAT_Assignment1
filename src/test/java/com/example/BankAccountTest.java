package com.example;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.Test;

public class BankAccountTest {
   
    @Test
    public void testPositiveBalance() {
        BankAccount bankaccount = new BankAccount(1200.25);
        Assert.assertEquals(1200.25, bankaccount.getBalance(), 0.25);
   
    }

    // @Test
    // public void testIncorrectBalance() {
    //     BankAccount bankaccount = new BankAccount(1200);
    //     assertThrows(IllegalArgumentException.class, () -> {
    //         bankaccount.getBalance();
    //     }, "Incorrect Balance Error!");
    // }


    @Test
    public void testInitialBalanceNegative() {
       try {
           new BankAccount(-50.0);
           fail("Expected IllegalArgumentException to be thrown");
       } catch (IllegalArgumentException e) {
           assertEquals("Initial balance cannot be negative", e.getMessage());
       }
   }

    @Test
    public void testWithdraw(){
        BankAccount bankaccount = new BankAccount(1200.25);
        bankaccount.withdraw(1000);
        assertEquals(200.25, bankaccount.getBalance());
    }

    @Test
    public void testInsufficientAmountWithdraw() {
        BankAccount bankaccount = new BankAccount(1200.0);
       try {
           bankaccount.withdraw(1500.0);
           fail("Expected IllegalArgumentException to be thrown");
       } catch (IllegalArgumentException e) {
           assertEquals("Insu?icient funds", e.getMessage());
       }
   }

   @Test
   public void testNegativeAmountWithdraw() {
       BankAccount bankaccount = new BankAccount(1200.0);
      try {
          bankaccount.withdraw(-200.0);
          fail("Expected IllegalArgumentException to be thrown");
      } catch (IllegalArgumentException e) {
          assertEquals("Withdrawal amount must be positive", e.getMessage());
      }
  }

    @Test
    public void testDeposit(){
        BankAccount bankaccount = new BankAccount(1200.25);
        bankaccount.deposit(200.75);
        assertEquals(1401, bankaccount.getBalance());
    }
    
    @Test
    public void testNegativeBalanceDeposit() {
        BankAccount bankaccount = new BankAccount(1200.0);
       try {
           bankaccount.deposit(-200.0);
           fail("Expected IllegalArgumentException to be thrown");
       } catch (IllegalArgumentException e) {
           assertEquals("Deposit amount must be positive", e.getMessage());
       }
   }
    
    
}
