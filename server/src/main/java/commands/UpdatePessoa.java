package commands;

import model.Dao;
import model.Pessoa;

public class UpdatePessoa extends Comando {

    @Override
    public void execute(String[] args) {
        boolean achou = false;
        for(Pessoa p : Dao.getInstance().getPessoas()) {
            if(p.getCpf().equals(args[2])) {
                achou = true;
                p.setNome(args[3]);
                p.setEndereco(args[4]);
                this.setSuccess(true);
            }
        }
        if(!achou) {
            this.setSuccess(false);
        }
    }

    @Override
    public String returnMessage() {
        if(this.success) {
            return "Pessoa atualizada com sucesso";
        } 
        return "Pessoa não encontrada";
    }
    
}
