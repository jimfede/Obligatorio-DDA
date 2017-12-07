/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.View;

import ServidorBuscaminas.Model.partidas.Partida;
import ServidorBuscaminas.Model.partidas.Tablero;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Federico
 */
public class TableroTableModel extends AbstractTableModel {

    private Tablero tablero;

    public TableroTableModel(Partida partida) {
        this.tablero = partida.getTablero();
    }

    @Override
    public int getRowCount() {
        return this.tablero.getCasillerosX();
    }

    @Override
    public int getColumnCount() {
        return this.tablero.getCasillerosY();
    }

    @Override
    public Object getValueAt(int x, int y) {
        return tablero.obtenerCasillero(x, y);
    }

}
