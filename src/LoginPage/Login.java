package LoginPage;

import java.util.List;
import java.util.Scanner;

class User {
    private final String email;
    private final String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

public class Login {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("jack@indiumsoft.com", "qwerty"),
                new User("tom@indiumsoft.com", "asdfg"),
                new User("peter@indiumsoft.com", "dsiuy"),
                new User("luka@indiumsoft.com", "mnbvh")
        );

        Scanner scanner = new Scanner(System.in);

        int attemptsLeft = 3;

        while (true) {
            System.out.print("Enter email: ");
            String email = scanner.next();

            System.out.print("Enter password: ");
            String password = scanner.next();

            try {
                login(users, email, password);
                System.out.println("Logged in successfully");
                break;
            } catch (InvalidUserException e) {
                System.out.println(e.getMessage());
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
                attemptsLeft--;
                if (attemptsLeft == 0) {
                    System.out.println("Your account is blocked");
                    break;
                } else {
                    System.out.println(attemptsLeft + " attempt(s) left");
                }
            }
        }
    }

    private static void login(List<User> users, String email, String password) throws InvalidUserException, WrongPasswordException {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    return;
                } else {
                    throw new WrongPasswordException("Wrong password");
                }
            }
        }
        throw new InvalidUserException("Invalid user");
    }

    static class InvalidUserException extends Exception {
        public InvalidUserException(String message) {
            super(message);
        }
    }

    static class WrongPasswordException extends Exception {
        public WrongPasswordException(String message) {
            super(message);
        }
    }
}
