/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IChat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author davit
 */
public interface IServer extends Remote{
    
    public String CargarHistorial()throws RemoteException;
    public void enviarMsj(String msj)throws RemoteException;
}
