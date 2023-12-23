package com.online.shopping_back.dto.response;

public interface   ResponseCode {
    
    String SUCCESS = "SU";

    String VALIDATION_FAILED = "VF";

    String DUPLICATED_EMAIL = "DE";
    String DUPLICATED_NICKNAME = "DN";
    String DUPLICATED_TEL_NUMBER = "DT";

    String SIGN_IN_FAILED = "SF";

    String NO_PERMISSION = "NP";

    String NOT_EXIST_USER = "NU";
    String NOT_EXIST_MANAGER = "NM";
    
    String NOT_EXIST_SHOP = "NS";
    String NOT_EXIST_PRODUCT = "NP";
    String NOT_EXIST_ORDER = "NO";
    String NOT_EXIST_CART = "NC";

    String DATABASE_ERROR = "DBE";
}
