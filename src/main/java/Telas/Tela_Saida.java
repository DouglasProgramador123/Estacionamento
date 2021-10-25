/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Classes.JtableVeiculosSaida;
import Classes.Valor;
import Classes.Movimentacao;
import DAO.MovimentacaoDAO;
import DAO.ValorDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Douglas
 */
public class Tela_Saida extends javax.swing.JDialog {

    /**
     * Creates new form Tela_Saída
     */
    JtableVeiculosSaida veicSaid = new JtableVeiculosSaida();
    Movimentacao m = new Movimentacao();

    public Tela_Saida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ValorDAO val = new ValorDAO();
        Valor v = new Valor();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String data = dateFormat.format(date);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
        String horarioFormatado = sdf.format(hora);

        LocalTime localTime = LocalTime.parse(TelaPrincipal.horario_entrada, DateTimeFormatter.ofPattern("HH:mm:ss"));
        int horaEnt = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);

        LocalTime localTime2 = LocalTime.parse(horarioFormatado, DateTimeFormatter.ofPattern("HH:mm:ss"));
        int horaSaid = localTime2.get(ChronoField.CLOCK_HOUR_OF_DAY);

        int tempo = horaSaid-horaEnt ;

        if (tempo == 0) {
            tempo = 1;
        }

        v = val.ValoresEstacionamento();

        if (tempo == 1) {
            jTextFieldValorPagamento.setText(String.valueOf(v.getValor_primeira_hora()));
        
        } else if (tempo >= 2) {
            Double total = v.getValor_primeira_hora() + ((tempo - 1) * v.getValor_demais_horas());
            jTextFieldValorPagamento.setText(String.valueOf(total));
         
        }

        jTextFieldId.setText(TelaPrincipal.id);
        jTextFieldModelo.setText(TelaPrincipal.modelo);
        jTextFieldPlaca.setText(TelaPrincipal.placa);
        jTextFieldDataSaida.setText(data);
        jTextFieldHorarioSaida.setText(horarioFormatado);
        jTextFieldTempo.setText(String.valueOf(tempo));

        jTableVeiculosSaid.setModel(veicSaid);

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
        jTableVeiculosSaid = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDataSaida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldHorarioSaida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTempo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValorPagamento = new javax.swing.JTextField();
        jButtonSaidVeiculo = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTableVeiculosSaid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Data_Saída", "Horario_Saida", "Placa", "Modelo", "Tempo", "Valor_Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVeiculosSaid);
        if (jTableVeiculosSaid.getColumnModel().getColumnCount() > 0) {
            jTableVeiculosSaid.getColumnModel().getColumn(0).setResizable(false);
            jTableVeiculosSaid.getColumnModel().getColumn(2).setResizable(false);
            jTableVeiculosSaid.getColumnModel().getColumn(3).setResizable(false);
            jTableVeiculosSaid.getColumnModel().getColumn(4).setResizable(false);
            jTableVeiculosSaid.getColumnModel().getColumn(5).setResizable(false);
            jTableVeiculosSaid.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setText("Id");

        jTextFieldId.setEditable(false);

        jLabel3.setText("Data de Saída");

        jTextFieldDataSaida.setEditable(false);

        jLabel4.setText("Horário de Saída");

        jTextFieldHorarioSaida.setEditable(false);

        jLabel5.setText("Placa");

        jTextFieldPlaca.setEditable(false);

        jLabel6.setText("Modelo");

        jTextFieldModelo.setEditable(false);

        jLabel7.setText("Tempo");

        jTextFieldTempo.setEditable(false);

        jLabel8.setText("Valor do Pagamento");

        jTextFieldValorPagamento.setEditable(false);

        jButtonSaidVeiculo.setText("Saida do Veículo");
        jButtonSaidVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaidVeiculoActionPerformed(evt);
            }
        });

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSaidVeiculo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldHorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldValorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaidVeiculo)
                    .addComponent(jButtonFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonSaidVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaidVeiculoActionPerformed
        // TODO add your handling code here:
        m.setId(Long.parseLong(jTextFieldId.getText()));
        m.setHorario_saida(jTextFieldHorarioSaida.getText());
        m.setData_saida(jTextFieldDataSaida.getText());
        m.setTempo(jTextFieldTempo.getText());
        m.setPlaca(jTextFieldPlaca.getText());
        m.setModelo(jTextFieldModelo.getText());
        m.setValor_pago(Double.parseDouble(jTextFieldValorPagamento.getText()));
       
     
        
        System.out.println(jTextFieldValorPagamento.getText());
        
        MovimentacaoDAO movDAO = new MovimentacaoDAO();
        movDAO.UpdateSaid(m);
        veicSaid.addRow(m);
        
        this.dispose();
       

    }//GEN-LAST:event_jButtonSaidVeiculoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Saida dialog = new Tela_Saida(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonSaidVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVeiculosSaid;
    private javax.swing.JTextField jTextFieldDataSaida;
    private javax.swing.JTextField jTextFieldHorarioSaida;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPlaca;
    private javax.swing.JTextField jTextFieldTempo;
    private javax.swing.JTextField jTextFieldValorPagamento;
    // End of variables declaration//GEN-END:variables
}
