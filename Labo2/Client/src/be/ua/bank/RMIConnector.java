package be.ua.bank;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIConnector {

    private Bank bank;

    public RMIConnector(String serverIP) {
        if (System.getSecurityManager() == null) {
            System.setProperty("java.security.policy","file:src/client.policy");
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Bank";
            Registry registry = LocateRegistry.getRegistry(serverIP);
            bank = (Bank) registry.lookup(name);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Bank getBank() {
        return bank;
    }
}
