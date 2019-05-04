package by.bnty.fitr.fusman.simpletube.client.register.registr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
    private static final String CHECKER_TRUE_EMAIL =

            "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";

    public static boolean isCheckedTrueInputEmail(String email) {


        Pattern p1 = Pattern.compile(CHECKER_TRUE_EMAIL);

        Matcher m1 = p1.matcher(email);


        return m1.matches();
    }

}
