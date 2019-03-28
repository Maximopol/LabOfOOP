package by.bnty.fitr.fusman.simpletube.registerandaauthorization;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
    private static final String regex =
            "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";

    public static boolean isCheckedTrueInputEmail(String email) {

        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(email);


        return m1.matches();
    }

}
