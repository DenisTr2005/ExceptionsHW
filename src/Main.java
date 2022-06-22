import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        System.out.println("authorization = " +
                authorization("java_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
    }
    private static boolean authorization(String login, String password, String confirmPassword) {
        boolean authorization = true;
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException loginException) {
            authorization = false;
            loginException.printStackTrace();
        } catch (WrongPasswordException passwordException) {
            authorization = false;
            passwordException.printStackTrace();
        } finally {
            return authorization;
        }
    }
    private static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20) {
            throw new WrongLoginException("login должен быть равен или меньше 20 символов!");
        }
        if (incorrect(login)) {
            throw new WrongLoginException("login должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания!");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("password должен быть строго меньше 20 символов!");
        }
        if (incorrect(password)) {
            throw new WrongPasswordException("password должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password и confirmPassword должны быть равны!");
        }
    }
    private  static boolean incorrect(String s) {
        for (char c : s.toCharArray()) {
            if ((c < 65 || c > 90) && c != 95 && (c < 97 || c > 122) && (c < 48 || c > 57)) {
                return true;
            }
        }
        return false;
    }

}