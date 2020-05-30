package com.company;

import com.company.test.StarTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static class PlanetOrStar
    {
        private String name;
        private boolean star;


        public PlanetOrStar(String name, boolean star) {
            this.name = name;
            this.star = star;
        }

        public PlanetOrStar() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isStar() {
            return star;
        }

        public void setStar(boolean star) {
            this.star = star;
        }

        @Override
        public String toString() {
            String temp;
            if(!this.star)
                temp = "Planet,Name:"+ this.name;
            else
                temp = "Star,Name:"+ this.name;

            return temp;
        }
    }
    static class StarSystem
    {
        PlanetOrStar [] planetOrStars;
        int n;

        public StarSystem() {
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
            planetOrStars = new PlanetOrStar[this.n];
        }

        public void setPlanet(PlanetOrStar planetOrStar, int n)
        {
            this.planetOrStars[n] = planetOrStar;
        }
        public void AddPlanet(PlanetOrStar planet)
        {
            this.n++;
            PlanetOrStar[] planetOrStar = new PlanetOrStar[this.n];
            System.arraycopy(this.planetOrStars, 0, planetOrStar, 0, this.n-1);
            this.planetOrStars = null;
            planetOrStar[this.n-1] = planet;
            this.planetOrStars = planetOrStar;

        }
        public PlanetOrStar getPlanet(int index)
        {
            return planetOrStars[index];
        }
        public int getNumOfPlanets()
        {
            int temp = 0;
            for (int i = 0; i < this.n; i ++)
            {
                if(!this.planetOrStars[i].isStar())
                {
                    temp++;
                }
            }
            return temp;
        }

        @Override
        public String toString() {
            return "StarSystem{\n" +
                    "planetOrStars=\n" + Arrays.toString(planetOrStars) +

                    '}';
        }
    }
        public static void main(String[] args) {
            StarTest starTest = new StarTest();
            Scanner scanner = new Scanner(System.in);
            StarSystem a = new StarSystem();
           /* System.out.println("Введите количество планет и звезд в звёздной системе: ");
            try {
                n = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Вне диапазона int, выставлено значение 0");
            }*/
            a.setN(0);
            try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"))) {
                while (true){
                    String line = reader.readLine();
                    if(line != null){
                        String name = line;
                        String check = reader.readLine();
                        if(starTest.test(name,check)){
                            a.AddPlanet(new PlanetOrStar(name, Boolean.parseBoolean(check)));
                        }
                    }else{
                        break;
                    }
                }
            }catch (IOException e){
                System.out.println("Файл не найден");
                e.printStackTrace();
            }


            /*for (int i = 0 ; i < a.getN() ; i ++)
            {
                System.out.println("Введите " + (i+1) + " планету или звезду ");
                System.out.print("Введите имя планеты или звезды: ");
                String name = scanner.nextLine();
                String check;
                System.out.print("Является ли обьект звездой: ");
                check = scanner.nextLine();
                if(starTest.test(name,check)) {
                    PlanetOrStar planetOrStar = new PlanetOrStar(name, Boolean.parseBoolean(check));
                    a.setPlanet(planetOrStar, i);
                }else{
                    i--;
                }


            }*/
            System.out.println("Количество планет: " + a.getNumOfPlanets());
            System.out.println("Добавить планету?(Да/Нет)");
            String yesOrNo = scanner.nextLine();
            if(yesOrNo.equals("Да"))
            {
                System.out.print("Введите имя планеты или звезды: ");
                String name = scanner.nextLine();
                String check;
                System.out.print("Является ли обьект звездой: ");
                check = scanner.nextLine();
                if(starTest.test(name,check)) {
                    PlanetOrStar planetOrStar = new PlanetOrStar(name, Boolean.parseBoolean(check));
                    a.AddPlanet(planetOrStar);
                }
            }
            System.out.println("Количество планет: " + a.getNumOfPlanets());
            System.out.println(a.toString());
            System.out.println("Вывести планету по индексу?(Да/Нет)");
            yesOrNo = scanner.nextLine();
            if(yesOrNo.equals("Да"))
            {
                try {
                    System.out.println("Введите индекс планеты которую хотите вывести: ");
                    System.out.println(a.getPlanet(scanner.nextInt()));
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Планеты с данным индексом не сущетсвует");
                }


            }

        }
}
