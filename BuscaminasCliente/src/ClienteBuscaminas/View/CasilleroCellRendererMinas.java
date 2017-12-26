/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.View;

import CommonBuscaminas.Model.partidas.Casillero;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author SALTI002
 */
public class CasilleroCellRendererMinas extends JButton implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        Casillero casillero = (Casillero) o;
        if (casillero.getMina() != null) {
            this.setBackground(Color.yellow);
        } else {
            this.setBackground(Color.gray);
        }
        return this;
    }
}
