package com.faresatoui.userprofileapps.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class in order to customise Error
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AddUserException extends RuntimeException
{
    /**
     * Constructor with message
     * @param message to display
     */
    public AddUserException(String message)
    {
        super(message);
    }
}
