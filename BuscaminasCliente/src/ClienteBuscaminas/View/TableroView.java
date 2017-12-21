/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.View;

import ClienteBuscaminas.Controller.PartidaController;
import ClienteBuscaminas.GestoraCliente;
import CommonBuscaminas.Model.mensajes.Evento;
import CommonBuscaminas.Model.mensajes.Mensaje;
import CommonBuscaminas.Model.partidas.Casillero;
import CommonBuscaminas.Model.partidas.Mina;
import CommonBuscaminas.Model.partidas.Partida;
import CommonBuscaminas.Model.partidas.Tablero;
import CommonBuscaminas.Model.usuarios.Jugador;
import CommonBuscaminas.Model.usuarios.Usuario;
import javax.swing.JOptionPane;
//import javax.swing.JTable;

/**
 *
 * @author Federico
 */
public class TableroView extends javax.swing.JFrame implements ITableroView {

    private TableroTableModel jTableTableModel;

    /**
     * Creates new form TableroView
     *
     * @param partida
     */
    public TableroView(Tablero xTablero) {
        initComponents();
        this.jTableTableModel = new TableroTableModel(xTablero);
        jTableTablero.setModel(this.jTableTableModel);
        jTableTablero.setDefaultRenderer(Object.class, new CasilleroCellRenderer());
        jTableTablero.setRowHeight(70);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTablero = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblNotificacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jTableTablero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTablero.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableTablero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableTablero.setRowSelectionAllowed(false);
        jTableTablero.setTableHeader(null);
        jScrollPane1.setViewportView(jTableTablero);

        jButton1.setText("Nueva Apuesta");

        jLabel1.setText("Monto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNotificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNotificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTablero;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblNotificacion;
    // End of variables declaration//GEN-END:variables

    private void actualizarVista() {
        this.jTableTableModel.fireTableDataChanged();
    }

    @Override
    public int[] obtenerCeldaSeleccionada() {
        int row = jTableTablero.getSelectedRow();
        int column = jTableTablero.getSelectedColumn();
        return new int[]{row, column};
    }

    @Override
    public void procesarMensajeTablero(Object arg, Mensaje mensaje) {
        if (mensaje.getEvento() == Evento.JUGADA_NO_PERMITIDA) {
            lblNotificacion.setText(mensaje.getAux().toString());
        } else if (mensaje.getEvento() == Evento.JUGADA_REALIZADA) {
            int[] coords = (int[]) arg;
            int[] nuevaMina = (int[]) mensaje.getAux();
            Casillero miCasillero = (Casillero) jTableTableModel.getValueAt(coords[0], coords[1]);
            miCasillero.setDescubierto(true);
            if (nuevaMina != null) {
                ((Casillero) jTableTableModel.getValueAt(nuevaMina[0], nuevaMina[1])).setMina(new Mina());
            }
            actualizarVista();
        }
        if (mensaje.getEvento() == Evento.TURNO_INCORRECTO) {
            lblNotificacion.setText(mensaje.getAux().toString());
        }
        if (mensaje.getEvento() == Evento.JUEGO_TERMINADO) {
            String usuActual = GestoraCliente.getInstance().getMyUsuario().getNombreUsuario(); 
            String usuMensaje = ((Jugador) arg).getNombreUsuario();
            if (usuActual.equals(usuMensaje)) {
                lblNotificacion.setText("Perdiste!");

            } else {
                lblNotificacion.setText("Ganaste!");
            }
        }

    }

    @Override
    public void agregarMouseListener(PartidaController partidaController) {
        this.jTableTablero.addMouseListener(partidaController);
    }

}
