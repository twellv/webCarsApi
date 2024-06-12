package ecommerce.util;

public enum AccessLevel {

    SUPER_ADMIN,
    ADMIN,
    MODERATOR,
    USER;

    public static AccessLevel access(String accessLevel){
        return AccessLevel.valueOf(accessLevel.toUpperCase());
    }
}
