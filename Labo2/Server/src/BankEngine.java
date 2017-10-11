public class BankEngine extends java.rmi.server.UnicastRemoteObject implements Bank {
    private int balance = 100;

    public BankEngine() throws java.rmi.RemoteException {
        super();
    }

    public float getBalance() throws java.rmi.RemoteException {
        return balance;
    }
    public boolean deposit(float amount) throws java.rmi.RemoteException {
        balance += amount;
        return true;
    }
    public boolean withdraw(float amount) throws java.rmi.RemoteException {
        if(amount < balance){
            return true;
        }
        return false;
    }
}
