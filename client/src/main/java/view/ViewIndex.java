package view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author AV2POO
 */
public class ViewIndex extends javax.swing.JFrame {

    private TableModelPessoa tableModelPessoa;
    
    public ViewIndex() {
        this.tableModelPessoa = new TableModelPessoa();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        buttonSaveIP = new javax.swing.JButton();
        fieldIP = new javax.swing.JTextField();
        fieldPort = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonTestConnection = new javax.swing.JButton();
        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonGet = new javax.swing.JButton();
        buttonList = new javax.swing.JButton();
        buttonGerenciarEmpresas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Pessoas");

        table.setModel(this.getTableModelPessoa());
        jScrollPane1.setViewportView(table);

        buttonSaveIP.setText("Aplicar IP/Porta");

        jLabel1.setText("IP:");

        jLabel2.setText("Porta:");

        jLabel3.setText(":");

        buttonTestConnection.setText("Testar Conexão");

        buttonInsert.setText("Inserir");

        buttonUpdate.setText("Alterar");

        buttonDelete.setText("Remover");

        buttonGet.setText("Visualizar");

        buttonList.setText("Consultar");

        buttonGerenciarEmpresas.setText("Gerenciar Empresas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonGerenciarEmpresas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSaveIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTestConnection))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(fieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(fieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSaveIP)
                    .addComponent(buttonTestConnection)
                    .addComponent(buttonInsert)
                    .addComponent(buttonUpdate)
                    .addComponent(buttonDelete)
                    .addComponent(buttonGet)
                    .addComponent(buttonList)
                    .addComponent(buttonGerenciarEmpresas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public TableModelPessoa getTableModelPessoa() {
        return tableModelPessoa;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JButton getButtonGet() {
        return buttonGet;
    }

    public JButton getButtonInsert() {
        return buttonInsert;
    }

    public JButton getButtonList() {
        return buttonList;
    }

    public JButton getButtonSaveIP() {
        return buttonSaveIP;
    }

    public JButton getButtonTestConnection() {
        return buttonTestConnection;
    }

    public JButton getButtonUpdate() {
        return buttonUpdate;
    }

    public JButton getButtonGerenciarEmpresas() {
        return buttonGerenciarEmpresas;
    }

    public JTextField getFieldIP() {
        return fieldIP;
    }

    public JTextField getFieldPort() {
        return fieldPort;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonGerenciarEmpresas;
    private javax.swing.JButton buttonGet;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonList;
    private javax.swing.JButton buttonSaveIP;
    private javax.swing.JButton buttonTestConnection;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JTextField fieldIP;
    private javax.swing.JTextField fieldPort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
