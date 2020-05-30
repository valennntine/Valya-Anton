package com.company.DAO;

import com.company.Exceptions.GemNotFoundException;
import com.company.models.Gem;

import java.io.*;
import java.util.ArrayList;

public class GemDao {
    public ArrayList<Gem> readAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader("GemBD.txt"))) {
            ArrayList<Gem> Gems = new ArrayList<>();
            String idRepresentation = "";
            while ((idRepresentation = reader.readLine()) != null) {
                long Id = Long.parseLong(idRepresentation);
                double weight = Double.parseDouble(reader.readLine());
                double price = Double.parseDouble(reader.readLine());
                double visibility = Double.parseDouble(reader.readLine());
                String name = reader.readLine();
                Gems.add(new Gem(Id,weight, price,visibility,name));
            }
            return Gems;
        } catch (IOException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        }
        return null;
    }

    public Gem readGem(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("GemBD.txt"))) {
            String idRepresentation = "";
            while ((idRepresentation = reader.readLine()) != null) {
                long Id = Long.parseLong(idRepresentation);
                double weight = Double.parseDouble(reader.readLine());
                double price = Double.parseDouble(reader.readLine());
                double visibility = Double.parseDouble(reader.readLine());
                String name = reader.readLine();
                if (id == Id) {
                    return new Gem(Id,weight, price,visibility,name);
                }
            }
        } catch (IOException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        }

        throw new GemNotFoundException();
    }

    public void createGem(Gem Gem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("GemBD.txt", true))) {
            writer.write(Gem.toString());
            writer.newLine();
        } catch (IOException ignored) {
        }
    }
    public void deleteAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("GemBD.txt"))) {
            writer.write("");
        } catch (IOException ignored) {
        }
    }

    public void deleteGem(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("GemBD.txt"));
        ) {
            ArrayList<Gem> Gems = new ArrayList<>();
            String idRepresentation = "";
            while ((idRepresentation = reader.readLine()) != null) {
                long Id = Long.parseLong(idRepresentation);
                double weight = Double.parseDouble(reader.readLine());
                double price = Double.parseDouble(reader.readLine());
                double visibility = Double.parseDouble(reader.readLine());
                String name = reader.readLine();
                Gems.add(new Gem(Id,weight, price,visibility,name));
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("GemBD.txt"));
            Gem Gem;
            for (Gem value : Gems) {
                Gem = value;
                if (Gem.getId() != id) {
                    createGem(Gem);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateGem(Gem Gem, long id) {
        this.deleteGem(id);
        this.createGem(Gem);
    }
}
