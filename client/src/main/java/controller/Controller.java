package controller;

/**
 * @author AV2POO
 */
public class Controller {

    private Controller caller;

    public Controller(Controller caller) {
        this.caller = caller;
    }

    public Controller getCaller() {
        return this.caller;
    }

    protected Controller setCaller(Controller caller) {
        this.caller = caller;
        return this;
    }
    
}
