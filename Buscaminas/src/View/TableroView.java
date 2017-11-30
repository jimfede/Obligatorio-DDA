/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.PartidaController;
import Model.Evento;
import Model.Mensaje;
import Model.partidas.Casillero;
import Model.partidas.Partida;
import javax.swing.JOptionPane;

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
    public TableroView(Partida partida) {
        initComponents();
        this.jTableTableModel = new TableroTableModel(partida);
        jTableTablero.setModel(this.jTableTableModel);
        //jTableTablero.setDefaultRenderer(Object.class, new CasilleroCellRenderer());
        jTableTablero.setRowHeight(50);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    public void procesarMensajeTablero(Mensaje mensaje) {
        if (mensaje.getEvento() == Evento.JUGADA_NO_PERMITIDA) {
            JOptionPane.showMessageDialog(null, mensaje.getAux().toString());
        } else if (mensaje.getEvento() == Evento.JUGADA_REALIZADA) {
            actualizarVista();
        }
    }

    @Override
    public void setControlador(PartidaController partidaController) {
        jTableTablero.addMouseListener(partidaController);
    }
}
