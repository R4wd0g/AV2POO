package model;

import java.util.ArrayList;
import java.util.Date;
import utils.DateUtils;

public class Empresa extends Model {
    
    private String cnpj;
    private String razao;
    private Date dataCriacao;
    
    private ArrayList<Pessoa> pessoas;

    public Empresa(String cnpj, String razao, Date dataCriacao) {
        this.cnpj = cnpj;
        this.razao = razao;
        this.dataCriacao = dataCriacao;
        this.pessoas = new ArrayList<>();
    }
    
    public void addPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
    
    public void clearPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        String retorno = this.cnpj + ";" + this.razao + ";" + DateUtils.dateToString(this.dataCriacao);
        if(!this.pessoas.isEmpty()) {
            retorno = retorno + ";";
            retorno = retorno.concat(this.pessoas.stream().map((Pessoa pessoa) -> {
                return pessoa.getCpf(); 
            }).reduce((String cpf, String cpf2) -> {
                return cpf + "," + cpf2; 
            }).get());
        }
        return retorno;
    }
    
}