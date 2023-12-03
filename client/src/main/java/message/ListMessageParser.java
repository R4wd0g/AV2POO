package message;

import interfaces.Transmissible;
import java.util.List;
import util.EnumOperators;

/**
 * @author AV2POO
 */
public class ListMessageParser<T extends Transmissible> extends MessageParser<T> {

    public ListMessageParser(T entity) {
        super(entity);
    }
    
    public ListMessageParser(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        super(clazz.newInstance());
    }
    
    @Override
    protected String getOperationDescription() {
        return EnumOperators.LIST.getDescription();
    }

    @Override
    protected List<String> getEspecificInfo() {
        return this.getEntity().getInfoList();
    }

}