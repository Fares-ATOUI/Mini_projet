package com.faresatoui.userprofileapps.demo.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CommonUtilsTest {

    @Test
    @DisplayName("Check majority valid")
    public void isValidMajor(){
        assertEquals(true, CommonUtils.ageAuthorized(LocalDate.of(2000, 12, 13)), "must be a major");
    }

    @Test
    @DisplayName("Check no majority")
    public void isNonValidMajor(){
        assertEquals(false, CommonUtils.ageAuthorized(LocalDate.of(2010, 12, 13)), "must be a non valid major");
    }

}
