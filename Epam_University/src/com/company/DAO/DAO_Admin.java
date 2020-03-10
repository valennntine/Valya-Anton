package com.company.DAO;

import com.company.exceptions.AdminNotFoundException;
import com.company.model.Admin;

import java.io.*;
import java.util.ArrayList;

public class DAO_Admin {

    public ArrayList<Admin> readAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Admin/AdminBD.txt"))) {
            ArrayList<Admin> admins = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String email = reader.readLine();
                String password = reader.readLine();
                admins.add(new Admin(Id, email, password));
            }
            return admins;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Admin readAdmin(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Admin/AdminBD.txt"))) {
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String email = reader.readLine();
                String password = reader.readLine();
                if (id == Id) {
                    return new Admin(Id, email, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new AdminNotFoundException();
    }

    public void createAdmin(Admin admin) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Admin/AdminBD.txt", true))) {
            writer.write(admin.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }
    }
    public void deleteAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Admin/AdminBD.txt"))) {
            writer.write("");
        } catch (IOException ignored) {
        }
    }

    public void deleteAdmin(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Admin/AdminBD.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Admin/AdminBD.txt"))) {
            ArrayList<Admin> admins = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String email = reader.readLine();
                String password = reader.readLine();
                admins.add(new Admin(Id, email, password));
            }
            Admin admin;
            for (Admin value : admins) {
                admin = value;
                if (admin.getId() != id) {
                    writer.write(admin.toString());
                    writer.newLine();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(Admin admin, long id) {
        this.deleteAdmin(id);
        this.createAdmin(admin);
    }
}
