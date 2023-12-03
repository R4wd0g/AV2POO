package model;

import interfaces.Transmissible;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.DateUtils;

/**
 * @author AV2POO
 */
public class Empresa implements Transmissible {

    private String cnpj;
    private String razao;
    private Date dataCriacao;
    private ArrayList<Pessoa> pessoas;

    public Empresa() {
        this(null, null, null, new ArrayList<>());
    }

    public Empresa(String cnpj, String razao, Date dataCriacao) {
        this(cnpj, razao, dataCriacao, new ArrayList<>());
    }

    public Empresa(String cnpj, String razao, Date dataCriacao, ArrayList<Pessoa> pessoas) {
        this.cnpj = cnpj;
        this.razao = razao;
        this.dataCriacao = dataCriacao;
        this.pessoas = pessoas;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Empresa setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getRazao() {
        return razao;
    }

    public Empresa setRazao(String razao) {
        this.razao = razao;
        return this;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Empresa setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public Empresa setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
        return this;
    }
    
    public Empresa addPessoa(Pessoa pessoa) {
        this.getPessoas().add(pessoa);
        return this;
    }

    public String getDataCriacaoAsString() {
        return this.getDataCriacao() != null ? DateUtils.dateToString(this.getDataCriacao()) : null;
    }
    
    public String getPessoasAsString() {
        return this.getPessoas().stream().map((Pessoa pessoa) -> {
            return pessoa.getCpf();
        }).reduce((String cpf1, String cpf2) -> {
            return cpf1.concat(",").concat(cpf2);
        }).get();
    }
    
    @Override
    public String toString() {
        String retorno = "Empresa{" + "cnpj=" + cnpj + ", razao=" + razao + ", dataCriacao=" + dataCriacao + '}';
        for (Pessoa pessoa : this.getPessoas()) {
            retorno = retorno.concat("\n    -> ").concat(pessoa.toString());
        }
        return retorno;
    }
    
    @Override
    public List<String> getInfoInsert() {
        List<String> info = new ArrayList<>();
        info.add(this.getCnpj());
        info.add(this.getRazao());
        info.add(this.getDataCriacaoAsString());
        info.add(this.getPessoasAsString());
        return info;
    }

    @Override
    public List<String> getInfoUpdate() {
        List<String> info = new ArrayList<>();
        info.add(this.getCnpj());
        info.add(this.getRazao());
        info.add(this.getDataCriacaoAsString());
        info.add(this.getPessoasAsString());
        return info;
    }

    @Override
    public List<String> getInfoGet() {
        List<String> info = new ArrayList<>();
        info.add(this.getCnpj());
        return info;
    }

    @Override
    public List<String> getInfoDelete() {
        List<String> info = new ArrayList<>();
        info.add(this.getCnpj());
        return info;
    }

    @Override
    public List<String> getInfoList() {
        List<String> info = new ArrayList<>();
        return info;
    }
    
}