package com.company.DAO;

import com.company.exceptions.CafeNotFoundException;
import com.company.model.Cafe;

import java.io.*;
import java.util.ArrayList;

public class DAO_Cafe {

    public ArrayList<Cafe> readAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Cafe/CafeBD.txt"))) {
            ArrayList<Cafe> Cafes = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String name = reader.readLine();
                String address = reader.readLine();
                String phone = reader.readLine();
                double avgbill = Double.parseDouble(reader.readLine());
                Cafes.add(new Cafe(Id,name,address,phone,avgbill));
            }
            return Cafes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cafe readCafe(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Cafe/CafeBD.txt"))) {
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String name = reader.readLine();
                String address = reader.readLine();
                String phone = reader.readLine();
                double avgbill = Double.parseDouble(reader.readLine());
                if (id == Id) {
                    return new Cafe(Id,name,address,phone,avgbill);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new CafeNotFoundException();
    }

    public void createCafe(Cafe Cafe) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Cafe/CafeBD.txt", true))) {
            writer.write(Cafe.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }
    }
    public void deleteAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Cafe/CafeBD.txt"))) {
            writer.write("");
        } catch (IOException ignored) {
        }
    }

    public void deleteCafe(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("BD/Cafe/CafeBD.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("BD/Cafe/CafeBD.txt"))) {
            ArrayList<Cafe> Cafes = new ArrayList<>();
            String id_representation = "";
            while ((id_representation = reader.readLine()) != null) {
                long Id = Long.parseLong(id_representation);
                String name = reader.readLine();
                String address = reader.readLine();
                String phone = reader.readLine();
                double avgbill = Double.parseDouble(reader.readLine());
                Cafes.add(new Cafe(Id,name,address,phone,avgbill));
            }
            Cafe Cafe;
            for (Cafe value : Cafes) {
                Cafe = value;
                if (Cafe.getId() != id) {
                    writer.write(Cafe.toString());
                    writer.newLine();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCafe(Cafe Cafe, long id) {
        this.deleteCafe(id);
        this.createCafe(Cafe);
    }
}
