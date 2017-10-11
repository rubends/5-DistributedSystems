import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer {
    protected String bankName = "Bank";

    public BankServer() {
        try {
            Bank bank = new BankEngine();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(bankName, bank);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String args[]) {
        new BankServer();
    }
}
