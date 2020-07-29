package org.sanjay.server;

import org.sanjay.shared.Config;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RmiServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RmiImpl rmiImpl = new RmiImpl();
        Registry registry = LocateRegistry.createRegistry(Config.getRemotePort());

        registry.bind(Config.REMOTE_ID, rmiImpl);
        System.out.println(String.format("Server with id: %s bound to port %d successfully", Config.REMOTE_ID, Config.getRemotePort()));
    }
}
