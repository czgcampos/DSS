/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Actor;
import Business.Pagamento;
import Data.DespesaDAO;
import Data.PagamentoDAO;

/**
 *
 * @author user
 */
public class MenuPrincipalMorador extends javax.swing.JFrame {

    private static Actor logado;
    
    public MenuPrincipalMorador(Actor a) {
        this.logado=a;
        initComponents();
        divida.setText(""+DespesaDAO.getDivida(logado));
        Nome.setText("Divida do "+logado.getNome()+":");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nome = new javax.swing.JLabel();
        divida = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        Pagar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Valor = new javax.swing.JTextField();
        montante = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Sair = new javax.swing.JButton();
        Aviso = new javax.swing.JLabel();
        Despesa = new javax.swing.JTextField();
        Informacoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Nome.setText("Username:");

        divida.setText("Divida");

        jButton5.setText("Consultar Despesas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Pagar.setText("Pagar");
        Pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarActionPerformed(evt);
            }
        });

        jLabel15.setText(":");

        jLabel16.setText("Id Despesa");

        jLabel17.setText("Valor da despesa");

        Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorActionPerformed(evt);
            }
        });

        montante.setText("--------------------");

        jLabel19.setText("Valor que quer pagar");

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        Despesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DespesaActionPerformed(evt);
            }
        });

        Informacoes.setText("Informações");
        Informacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Nome)
                .addGap(28, 28, 28)
                .addComponent(divida))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Pagar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(Despesa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(18, 18, 18)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(montante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Informacoes)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Sair)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(divida))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(Informacoes))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pagar)
                    .addComponent(jLabel15)
                    .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montante)
                    .addComponent(Despesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sair)
                    .addComponent(Aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ConsultarDespesasMorador c = new ConsultarDespesasMorador(logado);
        c.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void PagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarActionPerformed
        int id=-1;
        Float montant=0f;
        int valor=0;
        Pagamento p=null;
        if(Despesa.getText().isEmpty()){
            Aviso.setText("Coloque o Id da Despesa (veja em consultar).");
            return;
        }
        try{
            id = Integer.parseInt(Despesa.getText());
            if(!DespesaDAO.containsKey(id)){
                Aviso.setText("Coloque um Id válido (veja em consultar).");
                return;
            }
        }
        catch(NumberFormatException e){
            Aviso.setText("Coloque um Id válido (veja em consultar).");
            return;
        }
        if(Valor.getText().isEmpty()){
            Aviso.setText("Insira o valor que quer pagar.");
            return;
        }
        try{
            valor = Integer.parseInt(Valor.getText());
            if(valor<0){
                Aviso.setText("Coloque um Valor válido.");
                return;
            }
        }
        catch(NumberFormatException e){
            Aviso.setText("Coloque um Valor válido.");
            return;
        }
        montant=DespesaDAO.getPrecoDespesa(id);
        if(montant-valor<0)
            Aviso.setText("Valor inserido maior que montante.");
        else{
            p=new Pagamento(id,logado.getEmail(),valor);
            PagamentoDAO.efetuaPagamento(p);
            divida.setText(""+DespesaDAO.getDivida(logado));
            montante.setText(""+(montant-valor));
            Aviso.setText("Pagamento efetuado.");
        }
    }//GEN-LAST:event_PagarActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        MenuInicial m = new MenuInicial();
        m.setVisible(true);
        this.setVisible(false);
        this.dispose();
        logado=null;
    }//GEN-LAST:event_SairActionPerformed

    private void DespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DespesaActionPerformed
        Despesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                float montant=0f;
                int id=0;
                try{
                    id = Integer.parseInt(Despesa.getText());
                }
                catch(NumberFormatException f){
                    Aviso.setText("Coloque um Id válido (veja em consultar).");
                }
                if (DespesaDAO.containsKey(id)){
                    montant=DespesaDAO.getPrecoDespesa(id);
                    montante.setText(""+montant);
                }
                else
                Aviso.setText("Id inválido (veja em consultar).");
            }
        });
    }//GEN-LAST:event_DespesaActionPerformed

    private void ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorActionPerformed

    private void InformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacoesActionPerformed
        this.setVisible(false);
        InformacoesMorador i = new InformacoesMorador(logado);
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_InformacoesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalMorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalMorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalMorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalMorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalMorador(logado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Aviso;
    private javax.swing.JTextField Despesa;
    private javax.swing.JButton Informacoes;
    private javax.swing.JLabel Nome;
    private javax.swing.JButton Pagar;
    private javax.swing.JButton Sair;
    private javax.swing.JTextField Valor;
    private javax.swing.JLabel divida;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel montante;
    // End of variables declaration//GEN-END:variables
}
