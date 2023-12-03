package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Pessoa;

/**
 * @author AV2POO
 */
public class ViewFormEmpresa extends javax.swing.JFrame {

    private TableModelPessoa tableModelPessoa;
    
    public ViewFormEmpresa() {
        this.tableModelPessoa = new TableModelPessoa();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonConfirmar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        fieldRazao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldCnpj = new javax.swing.JTextField();
        fieldDataCriacao = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        listPessoas = new javax.swing.JComboBox<>();
        buttonAdicionarPessoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePessoas = new javax.swing.JTable();
        buttonRemoverPessoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empresa");

        buttonConfirmar.setText("Confirmar");

        buttonCancelar.setText("Cancelar");

        jLabel1.setText("CNPJ:");

        jLabel2.setText("Razão:");

        jLabel3.setText("Data de Criação:");

        jLabel4.setText("Selecione uma pessoa para adicioná-la:");

        listPessoas.setModel(new javax.swing.DefaultComboBoxModel<Pessoa>());

        buttonAdicionarPessoa.setText("Adicionar");

        tablePessoas.setModel(this.getTableModelPessoa());
        jScrollPane1.setViewportView(tablePessoas);

        buttonRemoverPessoa.setText("Remover Pessoa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldRazao)
                                    .addComponent(fieldDataCriacao, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(fieldCnpj)))
                            .addComponent(buttonConfirmar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAdicionarPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(buttonRemoverPessoa)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldDataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdicionarPessoa)
                    .addComponent(buttonRemoverPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConfirmar)
                    .addComponent(buttonCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getButtonCancelar() {
        return buttonCancelar;
    }

    public JButton getButtonConfirmar() {
        return buttonConfirmar;
    }

    public JTextField getFieldCnpj() {
        return fieldCnpj;
    }

    public JTextField getFieldDataCriacao() {
        return fieldDataCriacao;
    }

    public JTextField getFieldRazao() {
        return fieldRazao;
    }

    public TableModelPessoa getTableModelPessoa() {
        return tableModelPessoa;
    }

    public JButton getButtonAdicionarPessoa() {
        return buttonAdicionarPessoa;
    }

    public JButton getButtonRemoverPessoa() {
        return buttonRemoverPessoa;
    }

    public JComboBox<Pessoa> getListPessoas() {
        return listPessoas;
    }

    public JTable getTablePessoas() {
        return tablePessoas;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarPessoa;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonRemoverPessoa;
    private javax.swing.JTextField fieldCnpj;
    private javax.swing.JTextField fieldDataCriacao;
    private javax.swing.JTextField fieldRazao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<Pessoa> listPessoas;
    private javax.swing.JTable tablePessoas;
    // End of variables declaration//GEN-END:variables
}
