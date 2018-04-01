/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import IChat.IServer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class Servidor extends UnicastRemoteObject implements IServer {

    private int thisPort;
    private String thisAdress;
    private Registry registry;
    private String historial;
    
    public static void main(String[] args) throws UnknownHostException, Exception {
        String ip=(InetAddress.getLocalHost()).getHostAddress();
        Servidor s = new Servidor(ip);
    }
    public Servidor(String ip) throws Exception {
        historial="";
        thisAdress = (InetAddress.getLocalHost()).getHostAddress();
        thisAdress=ip;
        System.out.println(InetAddress.getLocalHost());
        thisPort = 3232;
        System.out.println("Escuchando en " + thisAdress + " puerto " + thisPort);
        this.registry = LocateRegistry.createRegistry(thisPort);
        registry.rebind("server", (IServer) this);
    }

    @Override
    public String CargarHistorial() throws RemoteException {
        return historial;
    }

    @Override
    public void enviarMsj(String msj) throws RemoteException {
        historial+=msj;
    }



}
