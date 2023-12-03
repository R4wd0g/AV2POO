package model;

import commands.Comando;

public class FactoryComando {
    
    public Comando getComando(String classe, String acao) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (Comando) Class.forName("commands." + acao.substring(0, 1).toUpperCase() + acao.substring(1).toLowerCase() + classe).newInstance();
    }
    
}
