package message;

import interfaces.Transmissible;
import java.util.List;
import util.EnumOperators;

/**
 * @author AV2POO
 */
public class InsertMessageParser<T extends Transmissible> extends MessageParser<T> {

    public InsertMessageParser(T entity) {
        super(entity);
    }

    @Override
    protected String getOperationDescription() {
        return EnumOperators.INSERT.getDescription();
    }

    @Override
    protected List<String> getEspecificInfo() {
        return this.getEntity().getInfoInsert();
    }

}