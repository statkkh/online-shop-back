package com.online.shopping_back.dto.response;

public interface  ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAILED = "Validation failed.";

    String DUPLICATED_EMAIL = "Duplicate email.";
    String DUPLICATED_NICKNAME = "Duplicate nickname";
    String DUPLICATED_TEL_NUMBER = "Duplicate telephone number.";

    String SIGN_IN_FAILED = "Login information mismatch.";

    String NO_PERMISSION = " Do not have permission.";
        
    String NOT_EXIST_USER = "User does not exist.";
    String NOT_EXIST_SHOP = "This shop does not exist.";
    String NOT_EXIST_PRODUCT = "Product does not exist.";
    String NOT_EXIST_ORDER = "Order does not exist.";
    String NOT_EXIST_CART = "Cart does not exist.";

    String DATABASE_ERROR = "Database error.";    
}
