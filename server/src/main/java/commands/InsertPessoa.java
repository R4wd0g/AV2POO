package commands;

import model.Dao;
import model.Pessoa;

public class InsertPessoa extends Comando {

    @Override
    public void execute(String[] args) {
        Pessoa pessoa = new Pessoa(args[3], args[2].trim(), args[4]);
        Dao.getInstance().getPessoas().add(pessoa);
    }
    
    @Override
    public String returnMessage() {
        return "";
    }
    
}