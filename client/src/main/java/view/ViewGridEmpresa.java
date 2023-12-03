package view;

import javax.swing.JButton;
import javax.swing.JTable;

/**
 * @author AV2POO
 */
public class ViewGridEmpresa extends javax.swing.JFrame {

    private TableModelEmpresa tableModelEmpresa;
    
    public ViewGridEmpresa() {
        this.tableModelEmpresa = new TableModelEmpresa();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonGet = new javax.swing.JButton();
        buttonList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empresas");

        buttonInsert.setText("Inserir");

        buttonUpdate.setText("Alterar");

        buttonDelete.setText("Remover");

        buttonGet.setText("Visualizar");

        buttonList.setText("Consultar");

        table.setModel(this.getTableModelEmpresa());
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsert)
                    .addComponent(buttonUpdate)
                    .addComponent(buttonDelete)
                    .addComponent(buttonGet)
                    .addComponent(buttonList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public TableModelEmpresa getTableModelEmpresa() {
        return tableModelEmpresa;
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

    public JButton getButtonUpdate() {
        return buttonUpdate;
    }

    public JTable getTable() {
        return table;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonGet;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonList;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
