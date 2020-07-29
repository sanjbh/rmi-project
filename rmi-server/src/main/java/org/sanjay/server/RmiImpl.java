package org.sanjay.server;

import org.sanjay.shared.Config;
import org.sanjay.shared.RmiInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static java.lang.String.format;

public class RmiImpl extends UnicastRemoteObject implements RmiInterface {
    protected RmiImpl() throws RemoteException {
        super(Config.getRemotePort());
    }

    @Override
    public String sayHello(String name) {
        return format("Hello %s from RMI server, nice to meet you!!", name);
    }
}
