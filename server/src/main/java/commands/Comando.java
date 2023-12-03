package commands;

abstract public class Comando {
    
    protected boolean success;
    
    public abstract void execute(String[] args);
    
    public abstract String returnMessage();

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}