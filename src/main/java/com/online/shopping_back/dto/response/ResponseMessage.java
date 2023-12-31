package com.online.shopping_back.dto.response;

public interface  ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAILED = "Validation failed.";

    String DUPLICATED_EMAIL = "Duplicate email.";
    String DUPLICATED_NICKNAME = "Duplicate nickname";
    String DUPLICATED_TEL_NUMBER = "Duplicate telephone number.";

    String SIGN_IN_FAILED = "Login information mismatch.";

    String NO_PERMISSION = " Do not have permission.";
        
    String NOT_EXIST_USER = "This user does not exist.";
    String NOT_EXIST_MANAGER = "This manager does not exist.";

    String NOT_FOUND_PAY = "This pay not found.";
    String NOT_EXIST_SHOP = "This shop does not exist.";
    String NOT_FOUND_PRODUCT = "This Product is not found.";
    String NOT_EXIST_BUY = "This order does not exist.";
    String NOT_EXIST_CART = "This cart does not exist.";
    String NOT_FOUND_ORDER_PRODUCT = "This order product not found.";

    String DATABASE_ERROR = "Database error.";    
}
