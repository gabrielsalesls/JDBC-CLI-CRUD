package gabrielsalesls.controller;

import gabrielsalesls.dao.UserDAO;
import gabrielsalesls.factory.ConnectionFactory;
import gabrielsalesls.model.Gender;
import gabrielsalesls.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {


    public void run() {
        int option;

        try (Scanner scan = new Scanner(System.in)) {
            try (Connection connection = ConnectionFactory.getConnection()) {
                UserDAO userDAO = new UserDAO(connection);

                boolean running = true;
                while (running) {

                    options();
                    option = scan.nextInt();

                    switch (option) {
                        case 1:
                            insertUser(userDAO);
                            break;
                        case 2:
                            listAllUsers(userDAO);
                            break;
                        case 3:
                            editUser(userDAO);
                            break;
                        case 4:
                            deleteUserById(userDAO);
                            break;
                        case 5:
                            deleteAllUsers(userDAO);
                            break;
                        case 6:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid Option");
                            break;
                    }

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void options() {

        System.out.println("\n\n");
        System.out.println("+-------------------------------------------+");
        System.out.println("|                  Menu                     |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 01 - New User                             |");
        System.out.println("| 02 - List All Users                       |");
        System.out.println("| 03 - Edit User                            |");
        System.out.println("| 04 - Delete user by ID                    |");
        System.out.println("| 05 - Delete All Users                     |");
        System.out.println("| 06 - Exit                                 |");
        System.out.println("+-------------------------------------------+");
        System.out.printf("Select option: ");

    }

    // Options
    private static void insertUser(UserDAO userDAO) {
        User user = getUser();

        // Insert User
        try {
            userDAO.insert(user);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void listAllUsers(UserDAO userDAO) {
        userDAO.listUsers();
    }

    private void editUser(UserDAO userDAO) {
        int id = getId(userDAO);

        User user = getUser();
        userDAO.updateUser(user, id);

    }

    private void deleteUserById(UserDAO userDAO) {
        int id = getId(userDAO);
        userDAO.deleteUserById(id);

    }

    private void deleteAllUsers(UserDAO userDAO) {
        userDAO.deleteAll();
    }

    private int getId(UserDAO userDAO) {
        Scanner scanner = new Scanner(System.in);
        userDAO.listUsers();
        System.out.println("ID: ");
        return scanner.nextInt();
    }

    private static User getUser() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Gender userGender = null;

        System.out.printf("Name: ");
        user.setName(scanner.nextLine());

        System.out.printf("Email: ");
        user.setEmail(scanner.nextLine());

        System.out.printf("Country: ");
        user.setCountry(scanner.nextLine());

        boolean selectingGender = true;
        int genderChoose;
        while (selectingGender) {
            System.out.println("Gender: \n   1- Male\n   2- Female\n   3- Other");
            System.out.printf("Select: ");
            genderChoose = scanner.nextInt();
            switch (genderChoose) {
                case 1:
                    userGender = Gender.MALE;
                    selectingGender = false;
                    break;
                case 2:
                    userGender = Gender.FEMALE;
                    selectingGender = false;
                    break;
                case 3:
                    userGender = Gender.OTHER;
                    selectingGender = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        user.setGender(userGender);
        return user;
    }
}
