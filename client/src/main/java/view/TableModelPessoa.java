package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Pessoa;

/**
 * @author AV2POO
 */
public class TableModelPessoa extends AbstractTableModel {

    private ArrayList<Pessoa> data;

    public TableModelPessoa() {
        this.data = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa pessoa = this.data.get(rowIndex);
        switch (columnIndex) {
            case 0: return pessoa.getCpf();
            case 1: return pessoa.getNome();
            case 2: return pessoa.getEndereco();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "CPF";
            case 1: return "Nome";
            case 2: return "Endereço";
        }
        return "";
    }

    public ArrayList<Pessoa> getData() {
        return data;
    }

    public void addData(Pessoa pessoa) {
        this.getData().add(pessoa);
        int i = this.getData().indexOf(pessoa);
        this.fireTableRowsInserted(i, i);
    }

    public void clearData() {
        int i = this.getData().size();
        this.data = new ArrayList<>();
        this.fireTableRowsDeleted(0, i);
    }
    
    public void deleteData(Pessoa pessoa) {
        int i = this.getData().indexOf(pessoa);
        this.getData().remove(pessoa);
        this.fireTableRowsDeleted(i, i);
    }
    
    public void updateData(int i, Pessoa pessoa) {
        this.getData().remove(i);
        this.getData().add(i, pessoa);
        this.fireTableRowsDeleted(i, i);
    }
    
}