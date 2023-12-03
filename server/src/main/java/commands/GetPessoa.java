package commands;

import model.Dao;
import model.Pessoa;

public class GetPessoa extends Comando {
    
    private Pessoa pessoaSelecionada;
    
    @Override
    public void execute(String[] args) {
        this.setSuccess(false);
        for(Pessoa p : Dao.getInstance().getPessoas()) {
            if(p.getCpf().equals(args[2])) {
                this.pessoaSelecionada = p;
                this.setSuccess(true);
            }
        }
    }

    @Override
    public String returnMessage() {
        if(Dao.getInstance().getPessoas().isEmpty()) {
            return "Sem pessoas cadastradas";
        }
        if(success) {
            return pessoaSelecionada.toString();
        }
        return "Pessoa não encontrada";
    }
    
}