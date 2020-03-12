package com.company.DAO;

import com.company.exceptions.UserNotFoundException;
import com.company.model.User;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;

public class DAO_User {

    public ArrayList<User> readAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/User/UserBD.txt"))) {
            ArrayList<User> Users = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String email = reader.readLine();
                String password = reader.readLine();
                String username = reader.readLine();
                String phoneNumber = reader.readLine();
                Users.add(new User(Id,email,password,username,phoneNumber));
            }
            return Users;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User readUser(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/User/UserBD.txt"))) {
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String email = reader.readLine();
                String password = reader.readLine();
                String username = reader.readLine();
                String phoneNumber = reader.readLine();
                if (id == Id) {
                    return new User(Id,email,password,username,phoneNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UserNotFoundException();
    }

    public void createUser(User User) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/User/UserBD.txt", true))) {
            writer.write(User.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }
    }
    public void deleteAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/User/UserBD.txt"))) {
            writer.write("");
        } catch (IOException ignored) {
        }
    }

    public void deleteUser(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/User/UserBD.txt"));
            ) {
            ArrayList<User> Users = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String email = reader.readLine();
                String password = reader.readLine();
                String username = reader.readLine();
                String phoneNumber = reader.readLine();
                Users.add(new User(Id,email,password,username,phoneNumber));
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("BD/User/UserBD.txt"));
            User User;
            for (User value : Users) {
                User = value;
                if (User.getId() != id) {
                    createUser(User);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User User, long id) {
        this.deleteUser(id);
        this.createUser(User);
    }
}
