package util;

/**
 *
 * @author AV2POO
 */
public enum EnumOperators {
    INSERT("INSERT"),
    UPDATE("UPDATE"),
    GET("GET"),
    DELETE("DELETE"),
    LIST("LIST");
    
    private final String description;

    private EnumOperators(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
}
