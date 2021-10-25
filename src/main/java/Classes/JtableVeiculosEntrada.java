/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DAO.MovimentacaoDAO;
import java.util.List;
import java.util.function.UnaryOperator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Douglas
 */
public class JtableVeiculosEntrada extends AbstractTableModel {

    MovimentacaoDAO movDAO = new MovimentacaoDAO();

    public List<Movimentacao> dados = movDAO.tableVeiculosEnt();
    private String[] colunas = {"Id", "Data_Entrada","Horario_Entrada", "Placa", "Modelo"};

     
    
    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return this.dados.get(linha).getId();
            case 1:
                return this.dados.get(linha).getData_entrada();
            case 2:
                return this.dados.get(linha).getHorario_entrada();    
            case 3:
                return this.dados.get(linha).getPlaca();
            case 4:
                return this.dados.get(linha).getModelo();
            default:
                return "";
        }
    

    }
   
    public Class getColclass( int coluna) {

        switch (coluna) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                return null;
        }
    

    }
       
    
    public void addRow(Movimentacao m) {
        this.dados.add(m);
        this.fireTableDataChanged();

    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public void setValueAt(int linha, Movimentacao m) {
        this.dados.set(linha, m);
        this.fireTableRowsUpdated(linha, linha);
    }
    
     public void setValueAt2(Object m,int linha,int coluna ) {
        
         
        switch(coluna)
        {
            case 0: dados.get(linha).setModelo((String) m);
            case 1: dados.get(linha).setPlaca((String) m);
        }
         
        this.fireTableRowsUpdated(linha, linha);
    }

      
}
