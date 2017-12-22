/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.View;

import CommonBuscaminas.Model.partidas.Partida;
import CommonBuscaminas.Model.partidas.Tablero;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Federico
 */
public class TableroTableModel extends AbstractTableModel {

    private Tablero tablero;

    public TableroTableModel(Tablero xTablero) {
        this.tablero = xTablero;
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
    
    public Object getModel(){
        return tablero;
    }


}
