package org.sanjay.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.sanjay.shared.Config;
import org.sanjay.shared.RmiInterface;



public class RmiClient {
    static Registry registry;

    public static void main(String[] args) throws NotBoundException {

        try {
            String remoteHost = Config.getRemoteHost();

            System.out.println(String.format("Locating registry: remoteHost: %s port: %d", Config.getRemoteHost(), Config.getRemotePort()));
            registry = LocateRegistry.getRegistry(remoteHost, Config.getRemotePort());

            System.out.println(String.format("Lookup interface: remote ID: %s", Config.REMOTE_ID));
            RmiInterface rmiInterface = (RmiInterface) registry.lookup(Config.REMOTE_ID);

            String name = "Sanjay";
            System.out.println(String.format("RMI returns %s", rmiInterface.sayHello(name)));

        } catch(RemoteException remoteException) {
            System.err.println(remoteException.getMessage());
        }

    }
}
