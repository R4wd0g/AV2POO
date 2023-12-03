package commands;

import model.Dao;
import model.Empresa;

public class GetEmpresa extends Comando {
    
    private Empresa empresaSelecionada;

    @Override
    public void execute(String[] args) {
        this.setSuccess(false);
        for(Empresa emp : Dao.getInstance().getEmpresas()) {
            if(emp.getCnpj().equals(args[2])) {
                this.empresaSelecionada = emp;
                this.setSuccess(true);
            }
        }
    }

    @Override
    public String returnMessage() {
        if(Dao.getInstance().getEmpresas().isEmpty()) {
            return "Sem empresas cadastradas";
        }
        if(success) {
            return empresaSelecionada.toString();
        }
        return "Empresa não encontrada";
    }
    
}