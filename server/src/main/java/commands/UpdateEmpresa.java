package commands;

import model.Dao;
import model.Empresa;
import model.Pessoa;
import utils.DateUtils;

public class UpdateEmpresa extends Comando {

    @Override
    public void execute(String[] args) {
        this.setSuccess(false);
        for(Empresa e : Dao.getInstance().getEmpresas()) {
            if(e.getCnpj().equals(args[2])) {
                e.setRazao(args[3]);
                e.setDataCriacao(DateUtils.stringToDate(args[4]));
                e.clearPessoas();
                this.addPessoasEmpresa(e, args[5]);
                this.setSuccess(true);
            }
        }
    }
    
    private void addPessoasEmpresa(Empresa e, String cpfPessoas) {
        String[] cpfs = cpfPessoas.split(",");
        for(String newCpf : cpfs) {
            for(Pessoa p : Dao.getInstance().getPessoas()) {
                if(p.getCpf().equals(newCpf)) {
                    e.addPessoa(p);
                }
            }
        }
    }

    @Override
    public String returnMessage() {
        if(this.success) {
            return "Empresa atualizada com sucesso";
        } 
        return "Empresa não encontrada";
    }
    
}
