package be.ua.bank;

public interface Bank {

    float getBalance();
    boolean deposit(float amount);
    boolean withdraw(float amount);
}
