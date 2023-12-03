package message;

import interfaces.Transmissible;
import java.util.List;
import util.EnumOperators;

/**
 * @author AV2POO
 */
public class UpdateMessageParser<T extends Transmissible> extends MessageParser<T> {

    public UpdateMessageParser(T entity) {
        super(entity);
    }

    @Override
    protected String getOperationDescription() {
        return EnumOperators.UPDATE.getDescription();
    }

    @Override
    protected List<String> getEspecificInfo() {
        return this.getEntity().getInfoUpdate();
    }

}