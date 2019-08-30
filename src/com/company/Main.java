package com.company;

import com.company.dao.UserDao;
import com.company.models.User;

import java.util.Scanner;

public class Main {
    //    1. Tworzymy nowy obiekt klasy .
//        2. Wypełniamy odpowiednie dane, używając .
//        3. Tworzymy nowy obiekt klasy .
//        4. Używamy metody , żeby zapisać dane użytkownika do bazy.

    public static void main(String[] args) {
        manageUsers();

//        User user = new User("Piotr", "address2@mail.com", "tajne", 1);
//        UserDao userDAO = new UserDao();
//        user = userDAO.create(user);
//
//        User userZBazyDanych1 = userDAO.read(user.getId());
//        User userZBazyDanych2 = userDAO.read(1);
//
//        System.out.println(userZBazyDanych1);
//        System.out.println(userZBazyDanych2);
//
//        userZBazyDanych2.setUserName("Joanna");
//        userDAO.update(userZBazyDanych2);
//        User nowy2 = userDAO.read(1);
//        System.out.println(nowy2);
//
//        userDAO.delete(1);



    }

    public static void manageUsers() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz jedną z opcji:\n" +
                    "add – dodanie użytkownika,\n" +
                    "edit – edycja użytkownika,\n" +
                    "delete – usunięcie użytkownika,\n" +
                    "quit – zakończenie programu.");

            if (scan.hasNextLine()) {
                String command = scan.nextLine();
                if (command.equals("add")) {
                    String[] features = {"username", "email", "password", "group_id"};
                    String[] userData = readData(features);
                    User user = new User(userData[0], userData[1], userData[2], Integer.parseInt(userData[3]));
                    UserDao userDAO = new UserDao();
                    userDAO.create(user);

                } else if (command.equals("edit")) {
                    String[] features = {"id", "username", "email", "password", "group_id"};
                    String[] userData = readData(features);
                    UserDao userDao = new UserDao();

                    User user = userDao.read(Integer.parseInt(userData[0]));
                    user.setUserName(userData[1]);
                    user.setEmail(userData[2]);
                    user.setPassword(userData[3]);
                    user.setGroup_id(Integer.parseInt(userData[4]));

                } else if (command.equals("delete")) {
                    String[] features = {"id"};
                    String[] userData = readData(features);
                    UserDao userDao = new UserDao();
                    userDao.delete(Integer.parseInt(userData[0]));

                } else if (command.equals("quit")) {
                    break;

                } else {
                    System.out.println("Niepoprawna komenda \n");
                }
            }

        }

    }

    private static String[] readData(String[] features) {
        Scanner scan = new Scanner(System.in);
        String[] userData = new String[features.length];
        for (int i=0; i < features.length; i++) {
            System.out.println("Podaj " + features[i] + ": ");
            if (scan.hasNextLine()) {
                userData[i]  = scan.next();
            }
        }
        return userData;
    }

}
