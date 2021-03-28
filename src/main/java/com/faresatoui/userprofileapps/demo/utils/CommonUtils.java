package com.faresatoui.userprofileapps.demo.utils;

import java.time.LocalDate;

/**
 * Class that implements different methods
 */
public class CommonUtils {

    /**
     * Define constant for authorised age
     */
    public static final int AGE_AUTHORIZED = 18;


    /**
     * Check majority for some birth date's
     * @param localDate, date of birth to checked
     * @return a boolean, true if is major or false to other case
     */
    public static boolean ageAuthorized(LocalDate localDate) {
        return LocalDate.now().getYear() - localDate.getYear() > AGE_AUTHORIZED ||
                (LocalDate.now().getYear() - localDate.getYear() == AGE_AUTHORIZED
                        && LocalDate.now().getDayOfYear() > localDate.getDayOfYear());
    }
}
