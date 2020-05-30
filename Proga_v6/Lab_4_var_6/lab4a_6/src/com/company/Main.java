package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
       /* Scanner scanner = new Scanner(System.in);
        StarSystem a = new StarSystem();
        System.out.println("Введите количество планет и звезд в звёздной системе: ");
        int n = scanner.nextInt();
        a.setN(n);*/
        public static void main(String[] args) {
            ArrayList<String> strings = new ArrayList<String>();
            strings.add("роза");
            strings.add("лоза");
            strings.add("лира");
            strings = fix(strings);

            for (String string : strings) {
                System.out.println(string);
            }
        }

        public static ArrayList<String> fix(ArrayList<String> strings) {
            for (int i = 0; i<strings.size();){
                if (strings.get(i).contains("л") && strings.get(i).contains("р")){
                    i++;
                }else if (strings.get(i).contains("л")){
                    strings.add(i+1, strings.get(i));
                    i++;
                }
                else if (strings.get(i).contains("р")){
                    strings.remove(i);

                }
            }
            return strings;
        }
       /* for (int i = 0 ; i < n ; i ++)
        {
            System.out.println("Введите " + (i+1) + " планету или звезду ");
            System.out.print("Введите имя планеты или звезды: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            boolean check;
            System.out.print("Является ли обьект звездой: ");
            check = scanner.nextBoolean();
            PlanetOrStar planetOrStar = new PlanetOrStar(name,check);
            a.setPlanet(planetOrStar,i);


        }
        System.out.println("Количество планет: " + a.getNumOfPlanets());
        System.out.println("Добавить планету?(Да/Нет)");
        scanner.nextLine();
        String yesOrNo = scanner.nextLine();
        if(yesOrNo.equals("Да"))
        {
            System.out.print("Введите имя планеты или звезды: ");
            String name = scanner.nextLine();
            boolean check;
            System.out.print("Является ли обьект звездой: ");
            check = scanner.nextBoolean();
            PlanetOrStar planetOrStar = new PlanetOrStar(name,check);
            a.AddPlanet(planetOrStar);
        }
        System.out.println("Количество планет: " + a.getNumOfPlanets());
        System.out.println(a.toString());

    */
}
