package model;

import interfaces.Transmissible;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AV2POO
 */
public class Pessoa implements Transmissible {

    private String cpf;
    private String nome;
    private String endereco;

    public Pessoa() {
        
    }

    public Pessoa(String cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public Pessoa setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Pessoa setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public String toString() {
        return this.getCpf().concat(" - ").concat(this.getNome());
    }

    @Override
    public List<String> getInfoInsert() {
        List<String> info = new ArrayList<>();
        info.add(this.getCpf());
        info.add(this.getNome());
        info.add(this.getEndereco());
        return info;
    }

    @Override
    public List<String> getInfoUpdate() {
        List<String> info = new ArrayList<>();
        info.add(this.getCpf());
        info.add(this.getNome());
        info.add(this.getEndereco());
        return info;
    }

    @Override
    public List<String> getInfoGet() {
        List<String> info = new ArrayList<>();
        info.add(this.getCpf());
        return info;
    }

    @Override
    public List<String> getInfoDelete() {
        List<String> info = new ArrayList<>();
        info.add(this.getCpf());
        return info;
    }

    @Override
    public List<String> getInfoList() {
        List<String> info = new ArrayList<>();
        return info;
    }
    
}