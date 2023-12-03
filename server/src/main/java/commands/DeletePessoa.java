package commands;

import model.Dao;
import model.Pessoa;

public class DeletePessoa extends Comando {

    @Override
    public void execute(String[] args) {
        this.success = false;
        for(Pessoa p : Dao.getInstance().getPessoas()) {
            if(args[2].equals(p.getCpf())) {
                this.success = true;
                Dao.getInstance().getPessoas().remove(p);
                break;
            }
        }
    }

    @Override
    public String returnMessage() {
        if(this.success) {
            return "Pessoa removida com sucesso";
        }
        if(Dao.getInstance().getPessoas().isEmpty()) {
            return "Sem pessoas cadastradas";
        }
        return "Pessoa não encontrada";
    }
    
}