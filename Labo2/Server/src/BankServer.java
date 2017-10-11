import java.rmi.Naming;

public class BankServer {

    public BankServer() {
        try {
            Bank bank = new BankEngine();
            Naming.rebind("rmi://localhost:1099/Bank", bank);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String args[]) {
        new BankServer();
    }
}
