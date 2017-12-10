/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.View;

import CommonBuscaminas.Model.partidas.Casillero;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Federico
 */
public class CasilleroCellRenderer extends JButton implements TableCellRenderer {

    public CasilleroCellRenderer() {

    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int i, int i1) {
        Casillero casillero = (Casillero) value;
        if (casillero.isDescubierto()) {
            this.setBackground(Color.red);
        } else {
            this.setBackground(Color.gray);
        }
        return this;
    }

}
