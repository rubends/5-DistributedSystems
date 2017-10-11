import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

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

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setProperty("java.security.policy", "file:src/server.policy");
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String bankName = "Bank";
            Bank bankEngine = new BankEngine();
            //Bank stub = (Bank) UnicastRemoteObject.exportObject(bankEngine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(bankName, bankEngine);
            System.out.println("bankEngine bound");
        } catch (Exception e) {
            System.err.println("bankEngine exception:");
            e.printStackTrace();
        }
    }
}
