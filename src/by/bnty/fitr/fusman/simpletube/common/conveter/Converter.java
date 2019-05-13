package by.bnty.fitr.fusman.simpletube.common.conveter;

public class Converter {
    public static String convertToUnique(String nickname, String email) {
        return nickname + Math.abs(email.hashCode());
    }
}
