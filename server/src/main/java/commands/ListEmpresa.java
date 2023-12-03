package commands;

import model.Dao;
import model.Empresa;

public class ListEmpresa extends Comando {

    @Override
    public void execute(String[] args) {}

    @Override
    public String returnMessage() {
        String returnMsg;
        if(Dao.getInstance().getEmpresas().isEmpty()) {
            returnMsg = "00";
        } else {
            returnMsg = "" + Dao.getInstance().getEmpresas().size() + "\n";
            for(Empresa emp : Dao.getInstance().getEmpresas()) {
                returnMsg = returnMsg + emp.toString() + "\n";
            }
        }
        return returnMsg;
    }
    
}