package model;

import java.util.ArrayList;

public class Dao {
    
    private static Dao instance;
    
    protected ArrayList<Pessoa> pessoas;
    protected ArrayList<Empresa> empresas;
    
    public Dao() {
        this.pessoas = new ArrayList<>();
        this.empresas = new ArrayList<>();
    }

    public static Dao getInstance() {
        if(instance == null) {
            instance = new Dao();
        }
        return instance;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }
    
}