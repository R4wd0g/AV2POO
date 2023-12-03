package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Empresa;

/**
 * @author AV2POO
 */
public class TableModelEmpresa extends AbstractTableModel {

    private List<Empresa> data;

    public TableModelEmpresa() {
        this.data = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empresa empresa = this.data.get(rowIndex);
        switch (columnIndex) {
            case 0: return empresa.getCnpj();
            case 1: return empresa.getRazao();
            case 2: return empresa.getDataCriacaoAsString();
            case 3: return empresa.getPessoas().size(); 
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "CNPJ";
            case 1: return "Razão";
            case 2: return "Data de Criação";
            case 3: return "Quantidade de Funcionários";
        }
        return "";
    }

    public List<Empresa> getData() {
        return data;
    }

    public void addData(Empresa empresa) {
        this.getData().add(empresa);
        int i = this.getData().indexOf(empresa);
        this.fireTableRowsInserted(i, i);
    }

    public void clearData() {
        int i = this.getData().size();
        this.data = new ArrayList<>();
        this.fireTableRowsDeleted(0, i);
    }
    
    public void deleteData(Empresa empresa) {
        int i = this.getData().indexOf(empresa);
        this.getData().remove(empresa);
        this.fireTableRowsDeleted(i, i);
    }
    
    public void updateData(int i, Empresa empresa) {
        this.getData().remove(i);
        this.getData().add(i, empresa);
        this.fireTableRowsDeleted(i, i);
    }
    
}