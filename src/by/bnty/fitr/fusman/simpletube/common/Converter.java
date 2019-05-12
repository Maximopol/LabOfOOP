package by.bnty.fitr.fusman.simpletube.common;

public class Converter {
    public static String convertToUnique(String nickname, String email) {
        return nickname + Math.abs(email.hashCode());
    }
}
