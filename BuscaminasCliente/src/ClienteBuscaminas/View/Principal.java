/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.View;

import ClienteBuscaminas.ControladoraCliente;
import ClienteBuscaminas.Controller.PartidaController;
import ServidorBuscaminas.Model.apuestas.Apuesta;
import ServidorBuscaminas.Model.partidas.Partida;
import ServidorBuscaminas.Model.usuarios.Jugador;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author Federico
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnNuevaPartida = new javax.swing.JButton();
        txtY = new javax.swing.JTextField();
        txtX = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblApuesta = new javax.swing.JLabel();
        txtApuesta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnNuevaPartida.setText("Nueva Partida");
        jbtnNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevaPartidaActionPerformed(evt);
            }
        });

        txtY.setNextFocusableComponent(jbtnNuevaPartida);

        txtX.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtX.setNextFocusableComponent(txtY);

        jLabel1.setText("X");

        jLabel2.setText("Y");

        jLabel3.setText("Tamaño");

        lblApuesta.setText("Apuesta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtY)
                            .addComponent(txtX)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnNuevaPartida))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtApuesta, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblApuesta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jbtnNuevaPartida)))
                .addGap(18, 18, 18)
                .addComponent(lblApuesta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevaPartidaActionPerformed
        // un jugador de prueba que debería estar en la base
        Object nuevoUsuario = ControladoraCliente.getInstance().getMyUsuario();
        Jugador miJugador = null;

        //Verificacion de usuario Administrador
        if (nuevoUsuario instanceof Jugador) {
            miJugador = (Jugador) nuevoUsuario;
        } else {
            JOptionPane.showMessageDialog(null, "Sos un admin, no podés jugar");
            return;
        }

        //FIN Verificacion de usuario Administrador
        Apuesta apuesta1 = new Apuesta(miJugador, Integer.parseInt(txtApuesta.getText()));

        Partida partida;
        try {
            partida = ControladoraCliente.getInstance().getFacade().nuevaPartida(miJugador, Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()), apuesta1);
        } catch (RemoteException e) {
            System.out.println("Ha ocurrido un error en: ");
            e.printStackTrace();
            return;
        }

        TableroView tableroView = new TableroView(partida.getTablero());
        PartidaController partidaController = new PartidaController(tableroView, partida.getIdPartida());
        tableroView.agregarMouseListener(partidaController);
        tableroView.setVisible(true);
    }//GEN-LAST:event_jbtnNuevaPartidaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Principal().setVisible(true);
//
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnNuevaPartida;
    private javax.swing.JLabel lblApuesta;
    private javax.swing.JTextField txtApuesta;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    // End of variables declaration//GEN-END:variables
}
