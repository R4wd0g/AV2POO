package message;

import interfaces.Transmissible;
import java.util.List;
import util.EnumOperators;

/**
 * @author AV2POO
 */
public class DeleteMessageParser<T extends Transmissible> extends MessageParser<T> {

    public DeleteMessageParser(T entity) {
        super(entity);
    }

    @Override
    protected String getOperationDescription() {
        return EnumOperators.DELETE.getDescription();
    }

    @Override
    protected List<String> getEspecificInfo() {
        return this.getEntity().getInfoDelete();
    }

}