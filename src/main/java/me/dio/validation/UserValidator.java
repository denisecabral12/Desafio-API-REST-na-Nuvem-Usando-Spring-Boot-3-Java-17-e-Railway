package me.dio.validation;

import me.dio.domain.model.User;
import me.dio.service.exception.BusinessException;

public class UserValidator {

    public static void validate(User user) {
        if (user.getAccount() == null) {
            throw new BusinessException("User account must not be null.");
        }
        if (user.getCard() == null) {
            throw new BusinessException("User card must not be null.");
        }
        
    }
}
