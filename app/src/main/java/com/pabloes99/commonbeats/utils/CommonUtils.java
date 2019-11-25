package com.pabloes99.commonbeats.utils;

import java.util.regex.Pattern;

public class CommonUtils {

    /**
     * Este método comprueba si el password cumple un patrón dado:
     * Tamaño mínimo es ocho y máximo 12, una mayúscula y un número
     */
    public static boolean checkPatternPassword (String password){
        final String pattern_password = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,12}$";
        Pattern pattern = Pattern.compile(pattern_password);
        return pattern.matcher(password).matches();
        //return password.matches(pattern_password);
    }
}
