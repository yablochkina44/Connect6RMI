package org.example;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ServerConnect {
    public static void main(String[] args) {
        try {

            Connect service = new ConnecctLogic();
            Registry registry = LocateRegistry.createRegistry(8080);
            registry.bind("Game connect6", service);
            System.out.println("Server for game is ready");
        } catch (Exception e){
            System.err.println("ServerConnect excp " + e.toString());
            e.printStackTrace();
        }
    }
}
