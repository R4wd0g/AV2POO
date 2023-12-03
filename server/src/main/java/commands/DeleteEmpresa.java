package commands;

import model.Dao;
import model.Empresa;

public class DeleteEmpresa extends Comando {

    @Override
    public void execute(String[] args) {
        this.success = false;
        for(Empresa e : Dao.getInstance().getEmpresas()) {
            if(args[2].equals(e.getCnpj())) {
                this.success = true;
                Dao.getInstance().getEmpresas().remove(e);
                break;
            }
        }
    }

    @Override
    public String returnMessage() {
        if(this.success) {
            return "Empresa removida com sucesso";
        }
        if(Dao.getInstance().getEmpresas().isEmpty()) {
            return "Sem empresas cadastradas";
        }
        return "Empresa não encontrada";
    }
    
}