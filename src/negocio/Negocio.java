/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

/**
 *
 * @author estudiante
 */
public class Negocio {

    private Cliente cliente;
    private Servidor servidor;
    private HiloHistorial h;
    private String nombre;
    private String ip;

    public Negocio() {
        cliente = new Cliente();
        h=new HiloHistorial(cliente);
    }

    public void inicializarHilo(JTextArea txt) {
        h.iniciar(txt);
    }

    public boolean unirseARed(String ip, String nick) {
        return cliente.conectar(ip, nick);
    }

    public boolean crearRed(String nick) throws UnknownHostException {
        ip = (InetAddress.getLocalHost()).getHostAddress();
        try {
            servidor = new Servidor(ip);
            this.unirseARed(ip, nick);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void enviarmsj(String msj) throws RemoteException{
        cliente.enviarmsj(msj);
    }
}
