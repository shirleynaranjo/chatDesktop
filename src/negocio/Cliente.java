/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import IChat.IServer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author davit
 */
public class Cliente {

    private IServer servidor;
    private String nick;
    public Cliente() {
        
    }
    public boolean conectar(String ip,String nick) {
        try {
            this.nick=nick;
            Registry registry = LocateRegistry.getRegistry(ip, 3232);
            System.out.println("registro = " + registry);
            if ((IServer) registry.lookup("server") != null) {
                servidor = (IServer) registry.lookup("server");
                return true;
            } else {
                System.out.println("Conexion Rechazada: Error Al Conectar");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void enviarmsj(String msj) throws RemoteException{
        servidor.enviarMsj(nick+": "+msj+"\n");
    }
    public String cargarMsjs() throws RemoteException{
        return servidor.CargarHistorial();
    }
}
