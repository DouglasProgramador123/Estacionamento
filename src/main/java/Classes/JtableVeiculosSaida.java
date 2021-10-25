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
public class JtableVeiculosSaida extends AbstractTableModel {

    MovimentacaoDAO movDAO = new MovimentacaoDAO();

    public List<Movimentacao> dados = movDAO.tableVeiculosSaid();
    private String[] colunas = {"Id", "Data_Saída","Horário_Saída", "Placa", "Modelo","Tempo", "Valor_Pago"};

     
    
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
                return this.dados.get(linha).getData_saida();
            case 2:
                return this.dados.get(linha).getHorario_saida();
            case 3:
                return this.dados.get(linha).getPlaca();
            case 4:
                return this.dados.get(linha).getModelo();
            case 5:
                return this.dados.get(linha).getTempo();
            case 6:
                return this.dados.get(linha).getValor_pago();
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
            case 5:
                return Double.class;
            case 6:
                return String.class;
            default:
                return null;
        }
    

    }
       
   public Movimentacao getdados(int row)
{
    return dados.get( row );
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
