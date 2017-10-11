public interface Bank extends java.rmi.Remote {

    public float getBalance() throws java.rmi.RemoteException;
    public boolean deposit(float amount) throws java.rmi.RemoteException;
    public boolean withdraw(float amount) throws java.rmi.RemoteException;
}