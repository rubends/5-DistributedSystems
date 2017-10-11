package be.ua.bank;

import java.rmi.Remote;

public interface Bank extends Remote{

    float getBalance();
    boolean deposit(float amount);
    boolean withdraw(float amount);
}
