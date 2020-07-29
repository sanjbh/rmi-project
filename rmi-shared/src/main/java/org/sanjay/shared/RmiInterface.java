package org.sanjay.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {
    String sayHello(String name) throws RemoteException;
}