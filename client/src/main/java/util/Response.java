package util;

import interfaces.Transmissible;
import java.util.ArrayList;

/**
 * @author AV2POO
 */
public class Response<Type extends Transmissible> {

    private boolean success;
    private String message;
    private Type transmissible;
    private ArrayList<Type> transmissibles;

    public Response(boolean success, String message) {
        this(success, message, null, new ArrayList<>());
    }

    public Response(boolean success, String message, Type transmissible) {
        this(success, message, transmissible, new ArrayList<>());
    }

    public Response(boolean success, String message, ArrayList<Type> transmissibles) {
        this(success, message, null, transmissibles);
    }

    public Response() {
        this(true, "", null, new ArrayList<>());
    }

    public Response(boolean success, String message, Type transmissible, ArrayList<Type> transmissibles) {
        this.success = success;
        this.message = message;
        this.transmissible = transmissible;
        this.transmissibles = transmissibles;
    }

    public boolean isSuccess() {
        return success;
    }

    public Response setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Type getTransmissible() {
        return transmissible;
    }

    public Response setTransmissible(Type transmissible) {
        this.transmissible = transmissible;
        return this;
    }

    public ArrayList<Type> getTransmissibles() {
        return transmissibles;
    }

    public Response setTransmissibles(ArrayList<Type> transmissibles) {
        this.transmissibles = transmissibles;
        return this;
    }
    
    public Response addTransmissible(Type transmissible) {
        this.transmissibles.add(transmissible);
        return this;
    }
    
}