import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.reverse;

public class Sukcesja {

    public static void main(String[] args) {
        int a = -1, b = 1, d = 6, m = 1, iloscOsobnikow = 10;
        double iloscKombinacji;
        int t = 0;
        Random r = new Random();
        ArrayList<Integer> T = new ArrayList<>();
        ArrayList<Double> FX = new ArrayList<>();
        int epoka = 1;

        // SELEKCJA
        int il = 0, osobnik1 = 0, osobnik2 = 0;
        ArrayList<Integer> OSOBNIK = new ArrayList<>();
        ArrayList<Double> GRUPA = new ArrayList<>();
        ArrayList<Integer> T_SEL = new ArrayList<>();

        // MUTACJA
        double pm = 0.2;
        double r_rand; // losowa wartość dla chromosomu przy mutacji
        ArrayList<Double> R_RAND= new ArrayList<Double>(); // zbiór losowych wartości dla chromosomów przy mutacji
        ArrayList<Integer> T_MUT = new ArrayList<>();

        // KRZYŻOWANIE
        double pk = 0.5;
        double rand;
        int randDelete;
        ArrayList<Double> RandTab = new ArrayList<>();
        ArrayList<Integer> COUNTER = new ArrayList<>();

        int counter = 0;

        int licznik = 0;
        int liczydlo = 0;
        int randPara;
        ArrayList<Integer> T_KRZYZ = new ArrayList<>();
        ArrayList<Integer> RANDPARA = new ArrayList<>();

        int index = 2;
        int num = 0;
        int nr_Potomka = 0;
        int ji = 1;

        ArrayList<Integer> Potomek1 = new ArrayList<>();
        ArrayList<Integer> Potomek2 = new ArrayList<>();
        ArrayList<Integer> POTOMEK = new ArrayList<>();


        System.out.println("############### GENEROWANIE POPULACJI POCZĄTKOWEJ ###############");
        System.out.println();
        iloscKombinacji = (b - a) * Math.pow(10, d) + 1;

        double xPrim = 0, x = 0;
        double Fx = 0;
        while (0 == 0) {
            if ((Math.pow(2, m - 1) <= iloscKombinacji && iloscKombinacji <= Math.pow(2, m))) {
                break;
            }
            m += 1;
            continue;
        }

        for (int i = 1; i <= iloscOsobnikow; i++) {
            for (int j = 1; j <= m; j++) {
                t = r.nextInt(2);
                T.add(t);
                System.out.print(t);
                xPrim += t * Math.pow(2, m - j);
            }

            x = a + (((b - a) * xPrim) / (Math.pow(2, m) - 1));
            System.out.print(" x' = " + xPrim + " x = " + x);

            Fx = 10 + Math.pow(x, 2) - 10 * Math.cos(20 * 3.14 * x);
            FX.add(Fx);
            System.out.print(" F(x) = " + Fx);
            System.out.println();
            xPrim = 0;
        }
        System.out.println();

        while(epoka <= 100) {
            System.out.println("##########################################################################################");
            System.out.println("#####                                 EPOKA " + epoka + "                                        #####");
            System.out.println("##########################################################################################");
            System.out.println();
            System.out.println("############### SELEKCA - METODA TURNIEJOWA MAX ###############");
            System.out.println();
            for (int i = 0; i < T.size(); i++) {
                System.out.print(T.get(i));
                if ((i + 1) % m == 0) System.out.println();
            }
            System.out.println();

            while (il < iloscOsobnikow) {
                if (osobnik1 == osobnik2) {
                    while (osobnik1 == osobnik2) {
                        osobnik1 = r.nextInt(FX.size());
                        osobnik2 = r.nextInt(FX.size());
                    }
                }
                System.out.println(osobnik1 + " " + osobnik2);
                if (FX.get(osobnik1) > FX.get(osobnik2)) {
                    GRUPA.add(FX.get(osobnik1));
                    OSOBNIK.add(osobnik1);
                } else {
                    GRUPA.add(FX.get(osobnik2));
                    OSOBNIK.add(osobnik2);
                }
                osobnik1 = r.nextInt(FX.size());
                osobnik2 = r.nextInt(FX.size());
                il++;
            }
            System.out.println();
            System.out.println("PO SELEKCJI");
            for (int i = 0; i < iloscOsobnikow; i++) {
                System.out.print(OSOBNIK.get(i) + ". ");
                for (int j = OSOBNIK.get(i) * m; j < OSOBNIK.get(i) * m + m; j++) {
                    System.out.print(T.get(j));
                    T_SEL.add(T.get(j));
                }
                System.out.println(" " + GRUPA.get(i));
            }
            for (int i = 0; i < T_SEL.size(); i++) {
                T.set(i, T_SEL.get(i));
            }
            T_SEL.clear();
            System.out.println();
            System.out.println("############### MUTACJA ###############");
            System.out.println();
            System.out.println("pm = " + pm);
            System.out.println();
            for (int i = 0; i < T.size(); i++) {
                System.out.print(T.get(i));
                r_rand = r.nextDouble();
                r_rand *= 100;
                r_rand = Math.round(r_rand);
                r_rand /= 100;
                R_RAND.add(r_rand);
                if ((i + 1) % m == 0) System.out.println();
            }
            System.out.println();
            for (int i = 0; i < R_RAND.size(); i++) {
                System.out.print(R_RAND.get(i) + " ");
                if ((i + 1) % m == 0) System.out.println();
            }
            System.out.println();
            for (int i = 0; i < T.size(); i++) {
                if (R_RAND.get(i) < pm) {
                    if (T.get(i) == 1) T.set(i, 0);
                    else T.set(i, 1);
                }
                T_MUT.add(T.get(i));
            }
            System.out.println("PO MUTACJI");
            for (int i = 0; i < T_MUT.size(); i++) {
                System.out.print(T_MUT.get(i));
                if ((i + 1) % m == 0) System.out.println();
            }
            System.out.println();
            for (int i = 0; i < T.size(); i++) {
                T.set(i, T_MUT.get(i));
            }
            T_MUT.clear();
            R_RAND.clear();

            System.out.println();

            System.out.println("############### KRZYŻOWANIE JEDNOPUNKTOWE ###############");
            System.out.println();

            System.out.println("pk = " + pk);
            System.out.println();
            for (int i = 0; i < iloscOsobnikow; i++) {
                rand = r.nextDouble();
                rand *= 100;
                rand = Math.round(rand);
                rand /= 100;
                RandTab.add(rand);
            }
            System.out.println(RandTab);

            for (int i = 0; i < T.size(); i++) {
                if ((i + 1) % m == 1) System.out.print(counter + ". ");
                System.out.print(T.get(i));
                if ((i + 1) % m == 0) {
                    System.out.println(" " + RandTab.get(counter));
                    if (RandTab.get(counter) < pk) {
                        COUNTER.add(counter);
                    }
                    counter++;
                }
            }

            System.out.println(COUNTER);

            if (COUNTER.size() % 2 != 0) {
                randDelete = r.nextInt(COUNTER.size());
                COUNTER.remove(randDelete);
            }
            System.out.println(COUNTER);
            Collections.shuffle(COUNTER);

            for (int i = 0; i < COUNTER.size(); i++) {
                System.out.print(COUNTER.get(i) + " ");
                if ((i + 1) % 2 == 0) System.out.println();
            }
            while (licznik < COUNTER.size() * m) {
                if ((licznik + 1) % m == 0) {
                    for (int i = COUNTER.get(liczydlo) * m; i < COUNTER.get(liczydlo) * m + m; i++) {
                        System.out.print(T.get(i));
                        T_KRZYZ.add(T.get(i));
                    }

                    liczydlo++;
                    if ((licznik + 1) % (m * 2) == 0) {
                        randPara = r.nextInt(m) + 1;
                        System.out.print(" " + randPara);
                        RANDPARA.add(randPara);
                    }

                    System.out.println();
                }
                licznik++;
            }

            counter = 0;
            licznik = 1;
            liczydlo = 1;

            for (int i = 0; i < m; i++) Potomek2.add(1);
            System.out.println();
            System.out.println("Rodzice 1");
            System.out.println("T_KRZYZ = " + T_KRZYZ.size());
            for (int i = 0; i < T_KRZYZ.size(); i++) {
                System.out.print(T_KRZYZ.get(i));
                if (licznik == RANDPARA.get(counter)) System.out.print("|");
                if (liczydlo % 2 != 0) {
                    if (licznik <= RANDPARA.get(counter)) Potomek1.add(T_KRZYZ.get(i));
                    if (licznik > RANDPARA.get(counter)) Potomek2.set(licznik - 1, T_KRZYZ.get(i));
                }
                if (liczydlo % 2 == 0) {
                    if (licznik > RANDPARA.get(counter)) Potomek1.add(T_KRZYZ.get(i));
                    if (licznik <= RANDPARA.get(counter)) Potomek2.set(licznik - 1, T_KRZYZ.get(i));
                }

                licznik++;
                if ((i + 1) % m == 0) {
                    System.out.println();
                    licznik = 1;
                    liczydlo++;
                }
                if ((i + 1) % (m * 2) == 0) {
                    counter++;
                    System.out.println();
                    System.out.println("Potomkowie " + counter);
                    System.out.println(Potomek1);
                    System.out.println(Potomek2);
                    for (int z = 0; z < Potomek1.size(); z++) POTOMEK.add(Potomek1.get(z));
                    for (int z = 0; z < Potomek2.size(); z++) POTOMEK.add(Potomek2.get(z));

                    Potomek1.clear();

                    if (counter < RANDPARA.size()) {
                        index = counter + 1;
                        System.out.println();

                        System.out.println("Rodzice " + index);
                    }
                }
            }
            for (int z = 0; z < COUNTER.size(); z++) {
                for (int y = COUNTER.get(z) * m; y < COUNTER.get(z) * m + m; y++) {
                    T.set(y, POTOMEK.get(nr_Potomka));
                    nr_Potomka++;
                }
                num++;
                System.out.println();
            }
            COUNTER.clear();
            Potomek2.clear();
            counter = 0;
            FX.clear();
            System.out.println("PO KRZYZOWANIU");
            for (int i = 0; i < T.size(); i++) {
                System.out.print(T.get(i));
                xPrim += T.get(i) * Math.pow(2, m - ji);
                ji++;
                if ((i + 1) % m == 0) {
                    System.out.println();
                    ji = 1;
                    x = a + (((b - a) * xPrim) / (Math.pow(2, m) - 1));
                    System.out.print(" x' = " + xPrim + " x = " + x);
                    Fx = 10 + Math.pow(x, 2) - 10 * Math.cos(20 * 3.14 * x);
                    FX.add(Fx);
                    System.out.print(" F(x) = " + Fx);
                    System.out.println();
                    xPrim = 0;
                }
            }
            liczydlo = 0;
            RandTab.clear();
            ji = 1;
            T_KRZYZ.clear();
            System.out.println("FX = " + FX);
            System.out.println();

            epoka++;
        }
    }
}
