package message;

import interfaces.Transmissible;
import java.util.List;
import util.EnumOperators;

/**
 * @author AV2POO
 */
public class GetMessageParser<T extends Transmissible> extends MessageParser<T> {

    public GetMessageParser(T entity) {
        super(entity);
    }

    @Override
    protected String getOperationDescription() {
        return EnumOperators.GET.getDescription();
    }

    @Override
    protected List<String> getEspecificInfo() {
        return this.getEntity().getInfoGet();
    }

}