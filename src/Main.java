import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("authorization = " +
                authorization("java_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
    }
    private static boolean authorization(String login, String password, String confirmPassword) {
        boolean authorization = true;
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException  loginException) {
            authorization = false;
            loginException.printStackTrace();
        }
            return authorization;
    }
    private static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20) {
            throw new WrongLoginException("login должен быть равен или меньше 20 символов!");
        }
        if (!Pattern.matches("\\w+", login)) {
            throw new WrongLoginException("login должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания!");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("password должен быть строго меньше 20 символов!");
        }
        if (!Pattern.matches("\\w+", password)) {
            throw new WrongPasswordException("password должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password и confirmPassword должны быть равны!");
        }
    }
}