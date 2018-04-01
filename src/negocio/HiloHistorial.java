/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.swing.JTextArea;

/**
 *
 * @author davit
 */
public class HiloHistorial extends Thread {

    private JTextArea txt;
    private Cliente cliente;
    public HiloHistorial(Cliente cliente) {
        this.cliente=cliente;
    }

    public void iniciar(JTextArea txt) {
        this.txt = txt;
        this.start();
    }

    @Override
    public void run() {
        String a = "a";
        try {
            while (true) {
                txt.setText(cliente.cargarMsjs());
                sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
