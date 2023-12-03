package commands;

import model.Dao;
import model.Empresa;
import model.Pessoa;
import utils.DateUtils;

public class InsertEmpresa extends Comando {

    @Override
    public void execute(String[] args) {
        Empresa empresa = new Empresa(args[2], args[3], DateUtils.stringToDate(args[4]));
        String[] cpfPessoas = args[5].split(",");
        for(String cpf : cpfPessoas) {
            for(Pessoa pessoa : Dao.getInstance().getPessoas()) {
                if(pessoa.getCpf().equals(cpf)) {
                    empresa.addPessoa(pessoa);
                }
            }
        }
        Dao.getInstance().getEmpresas().add(empresa);
    }
    
    @Override
    public String returnMessage() {
        return "";
    }
    
}