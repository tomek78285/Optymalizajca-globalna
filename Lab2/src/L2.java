import java.util.*;

import static java.util.Collections.*;

class Funkcja_Jednowymiarowa{
    int a, b, d, iloscOsobnikow;
    int t = 0;

    public Funkcja_Jednowymiarowa(int a, int b, int d, int iloscOsobnikow)
    {
        this.a = a;
        this.b = b;
        this.d = d;
        this.iloscOsobnikow = iloscOsobnikow;
    }

    void licz() {
        double iloscKombinacji = (b-a) * Math.pow(10, d) + 1;
        double m = 1;
        Random r = new Random();
        double xPrim = 0, x = 0;
        double Fx = 0;
        while (0 == 0) {
            if((Math.pow(2, m-1) <= iloscKombinacji && iloscKombinacji <= Math.pow(2, m))) {
                break;
            }
            m += 1;
            continue;
        }
        System.out.println(m);
        for(int i = 1; i <= iloscOsobnikow; i++){
            for(int j = 1; j <= m; j++){
                t = r.nextInt(2);
                System.out.print(t);
                xPrim += t * Math.pow(2, m-j);
            }
            x = a + (((b - a) * xPrim) / (Math.pow(2, m) - 1));
            System.out.print(" x' = " + xPrim + " x = " + x);

            Fx = 10 + Math.pow(x, 2) - 10 * Math.cos(20 * 3.14 * x);
            System.out.print(" F(x) = " + Fx);
            System.out.println();
            xPrim = 0;
            x = 0;
        }
    }
}

class Funkcja_Trojwymiarowa{
    int a1, b1, a2, b2, a3, b3, d1, d2, d3, iloscOsobnikow;
    int t = 0;

    public Funkcja_Trojwymiarowa(int a1, int b1, int a2, int b2, int a3, int b3, int d1, int d2, int d3, int iloscOsobnikow)
    {
        this.a1 = a1;
        this.b1 = b1;
        this.d1 = d1;
        this.a2 = a2;
        this.b2 = b2;
        this.d2 = d2;
        this.a3 = a3;
        this.b3 = b3;
        this.d3 = d3;
        this.iloscOsobnikow = iloscOsobnikow;
    }

    void licz() {
        double iloscKombinacji_1 = (b1-a1) * Math.pow(10, d1) + 1;
        double iloscKombinacji_2 = (b2-a2) * Math.pow(10, d2) + 1;
        double iloscKombinacji_3 = (b3-a3) * Math.pow(10, d3) + 1;

        int m1 = 1;
        int m2 = 1;
        int m3 = 1;
        Random r = new Random();
        double xPrim1 = 0, xPrim2 = 0, xPrim3 = 0, x1 = 0, x2 = 0, x3 = 0;
        double Fx = 0;

        while (0 == 0) {
            if((Math.pow(2, m1-1) <= iloscKombinacji_1 && iloscKombinacji_1 <= Math.pow(2, m1))) {
                break;
            }
            m1 += 1;
            continue;
        }
        while (0 == 0) {
            if((Math.pow(2, m2-1) <= iloscKombinacji_2 && iloscKombinacji_2 <= Math.pow(2, m2))) {
                break;
            }
            m2 += 1;
            continue;
        }
        while (0 == 0) {
            if((Math.pow(2, m3-1) <= iloscKombinacji_3 && iloscKombinacji_3 <= Math.pow(2, m3))) {
                break;
            }
            m3 += 1;
            continue;
        }
        int m = m1+m2+m3;
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m);
        for(int i = 1; i <= iloscOsobnikow; i++){
            for(int j = 1; j <= m; j++){
                t = r.nextInt(2);
                System.out.print(t);
                if(j >= 1 && j <= m1) {
                    xPrim1 += t * Math.pow(2, m1 - j);
                }
//                if(j == m1) System.out.print("-");
                if(j > m1 && j <= m1+m2){
                    xPrim2 += t * Math.pow(2, m2 + m1 - j);
                }
//                if(j == m1+m2) System.out.print("-");
                if(j > m1+m2){
                    xPrim3 += t * Math.pow(2, m - j);
                }
            }
            x1 = a1 + (((b1 - a1) * xPrim1) / (Math.pow(2, m1) - 1));
            x2 = a2 + (((b2 - a2) * xPrim2) / (Math.pow(2, m2) - 1));
            x3 = a3 + (((b3 - a3) * xPrim3) / (Math.pow(2, m3) - 1));

            Fx = 30 + Math.pow(x1, 2) - 10 * Math.cos(20 * 3.14 * x1) + Math.pow(x2, 2) - 10 * Math.cos(20 * 3.14 * x2) + Math.pow(x3, 2) - 10 * Math.cos(20 * 3.14 * x3);

            System.out.print(" x1' = " + xPrim1 + " ");
            System.out.print("x2' =  " + xPrim2 + " ");
            System.out.print("x3' =  " + xPrim3 + " ");

            System.out.print(" x1 = " + x1 + " ");
            System.out.print(" x2 = " + x2 + " ");
            System.out.print(" x3 = " + x3 + " ");

            System.out.print(" F(x1, x2, x3) = " + Fx);
            System.out.println();
            xPrim1 = 0;
            xPrim2 = 0;
            xPrim3 = 0;
        }
    }
}

class Funkcja_Wielowymiarowa{
    int n, iloscOsobnikow;
    int t = 0;

    public Funkcja_Wielowymiarowa(int n, int iloscOsobnikow)
    {
        this.n = n;
        this.iloscOsobnikow = iloscOsobnikow;
    }
        int i = 0, ai, bi, di, mi;
        Random r = new Random();
        int xPrim = 0;
        double x = 0;
        double Fx = 0;
        double pm = 0.2;

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        ArrayList<Integer> M = new ArrayList<>();
        ArrayList<ArrayList> T = new ArrayList<>();
        ArrayList<Integer> Ti = new ArrayList<>();
        ArrayList<Integer> XPrim = new ArrayList<>();
        ArrayList<Double> X = new ArrayList<>();
        ArrayList<Double> FX = new ArrayList<>();
        public static final HashMap<Integer, Double> H_MAPA = new HashMap<>();
        void licz() {
            while (i < n) {
                ai = r.nextInt(2)+1;
                bi = r.nextInt(2)+1;
                di = 1;

                while (1 == 1) {
                    if (bi > ai) {
                        A.add(ai);
                        B.add(bi);
                        break;
                    } else {
                        ai = r.nextInt(2);
                        bi = r.nextInt(2) ;
                        continue;
                    }
                }
                D.add(di);
                i++;
            }

//            System.out.println("A: " + A);
//            System.out.println("B: " + B);
//            System.out.println("D: " + D);

            i = 0;

            while (i < n) {
                mi = 1;
                double iloscKombinacji = (B.get(i) - A.get(i)) * Math.pow(10, D.get(i)) + 1;
                while (0 == 0) {
                    if ((Math.pow(2, mi - 1) <= iloscKombinacji && iloscKombinacji <= Math.pow(2, mi))) {
                        M.add(mi);
                        break;
                    }
                    mi += 1;
                    continue;
                }
                i++;
            }
//            System.out.println("M: " + M);
            System.out.println("pm: " + pm);
            System.out.println();
            i = 0;
            int m = 0;
//        System.out.println(M.size());
            while (i < M.size()) {
                m += M.get(i);
                i++;
            }
//            System.out.println(m);
            ArrayList<Double> PiRand = new ArrayList<>();

            int t = 0;
            i = 0;
//            System.out.println("m" + m);
            for (int j = 1; j <= iloscOsobnikow; j++) {
                double piRand = r.nextDouble();
                piRand *= 100;
                piRand = Math.round(piRand);
                piRand/=100;


                PiRand.add(piRand);
                while (i < M.size()) {
                    for (int k = 1; k <= M.get(i); k++) {
                        t = r.nextInt(2);
                        Ti.add(t);
                        System.out.print(t);
                        xPrim += t * Math.pow(2, M.get(i) - k);
                    }


                    XPrim.add(xPrim);
                    x = A.get(i) + (((B.get(i) - A.get(i)) * xPrim) / (Math.pow(2, M.get(i)) - 1));


                    xPrim = 0;
                    X.add(x);
                    x = 0;

                    i++;
//                    System.out.print(" ");
                    T.add(Ti);
//                    System.out.println("T " + T);
                }
                H_MAPA.put(Ti.get(j), PiRand.get(j-1));
                i = 0;
                System.out.println();
            }
            System.out.println(H_MAPA);
            ArrayList<Double> TiRand = new ArrayList<>();
            double ti_rand;
//            System.out.println("x' = " + XPrim);
            i = 0;
//            System.out.println("x = " + X);
//            System.out.println("Ti = " + Ti);

            for (int i = 0; i < Ti.size(); i++) {
                System.out.print(Ti.get(i));
                if((i+1)%m == 0){ System.out.println(" " + PiRand.get(0));
            }
            System.out.println();
            int counter = 0;
            for (int i = 0; i < 5; i++) {
                for(int j = 0; j < 8; j++) {
                    if(PiRand.get() < pm) {
                        System.out.print(Ti.get(counter));
                    }
                    counter++;
                }
                System.out.println();
            }
            for(int i = 0; i < Ti.size(); i++) {
                ti_rand = r.nextDouble();
                ti_rand*=100;
                ti_rand=Math.round(ti_rand);
                ti_rand/=100;
                TiRand.add(ti_rand);
                if(ti_rand < pm) {
                    if(Ti.get(i) == 1) Ti.set(i, 0);
                    else Ti.set(i, 1);

                }
//                System.out.println(Ti.get(s) + " ");

            }
//            for (int i = 0; i < Ti.size(); i++) {
//                System.out.print(TiRand.get(i) + " ");
//                if((i+1)%m == 0) System.out.println();
//            }
//            System.out.println();
//            System.out.println("Ti po zmianie" + Ti);
//            System.out.println("Mutacja:");
//            for (int i = 0; i < Ti.size(); i++) {
//                System.out.print(Ti.get(i));
//                if((i+1)%m == 0) System.out.println();
//            }
//            System.out.println();

            Fx = 10 * n;
            i = 0;
            while (i < iloscOsobnikow) {
                Fx += Math.pow(X.get(i), 2) - 10 * Math.cos(20 * 3.14 * X.get(i));
                i++;
                FX.add(Fx);
            }
//            System.out.println("F(x) = " + FX);
//            metodaTurniejowaMax();
//            metodaTurniejowaMin();
//            metodaRankingowaMax();
//            metodaRankingowaMin();
//            metodaRuletki();
        }

        public void metodaTurniejowaMax() {
            System.out.println();
            System.out.println();
            System.out.println("METODA TURNIEJOWA MAX");
            int il = 0, osobnik1 = 0, osobnik2 = 0, numerOsobnika1 = 0, numerOsobnika2 = 0, licznik = 0;
            System.out.println(FX);
            Random r = new Random();
            ArrayList<ArrayList> kontrolaGrupy = new ArrayList<>();
            ArrayList<Double> result = new ArrayList<>();
            ArrayList<Integer> pary = new ArrayList<>();

            while (il < FX.size()){

                ArrayList<Double> grupa = new ArrayList<>();
                if (osobnik1 == osobnik2) {
                    while(osobnik1 == osobnik2) {
                        osobnik1 = r.nextInt(FX.size());
                        osobnik2 = r.nextInt(FX.size());
                    }
                }
                grupa.add(FX.get(osobnik1));
                grupa.add(FX.get(osobnik2));
                numerOsobnika1 = FX.indexOf(FX.get(osobnik1))+1;
                numerOsobnika2 = FX.indexOf(FX.get(osobnik2))+1;
                pary.add(numerOsobnika1);
                pary.add(numerOsobnika2);
//                    if(pary.get(0) == pary.get(2) && pary.get(1) == pary.get(3))
                System.out.println(numerOsobnika1 + " " + grupa.get(0) + " " + numerOsobnika2 + " " + grupa.get(1));

                kontrolaGrupy.add(pary);
                if (FX.get(osobnik1) > FX.get(osobnik2))  result.add(FX.get(osobnik1));
                else result.add(FX.get(osobnik2));
                il++;
                osobnik1 = r.nextInt(FX.size());
                osobnik2 = r.nextInt(FX.size());

            }
//            System.out.println(kontrolaGrupy);
            System.out.println(result);
            System.out.println(pary);
        }

    public void metodaTurniejowaMin() {
        System.out.println();
        System.out.println();
        System.out.println("METODA TURNIEJOWA MIN");
        int il = 0, osobnik1 = 0, osobnik2 = 0, numerOsobnika1 = 0, numerOsobnika2 = 0, licznik = 0;
        System.out.println(FX);
        Random r = new Random();
        ArrayList<ArrayList> kontrolaGrupy = new ArrayList<>();
        ArrayList<Double> result = new ArrayList<>();
        ArrayList<Integer> pary = new ArrayList<>();

        while (il < FX.size()){

            ArrayList<Double> grupa = new ArrayList<>();
            while (osobnik1 == osobnik2) {
                osobnik1 = r.nextInt(FX.size());
                osobnik2 = r.nextInt(FX.size());
           }
            grupa.add(FX.get(osobnik1));
            grupa.add(FX.get(osobnik2));
            numerOsobnika1 = FX.indexOf(FX.get(osobnik1))+1;
            numerOsobnika2 = FX.indexOf(FX.get(osobnik2))+1;
            pary.add(numerOsobnika1);
            pary.add(numerOsobnika2);
//                    if(pary.get(0) == pary.get(2) && pary.get(1) == pary.get(3))
            System.out.println(numerOsobnika1 + " " + grupa.get(0) + " " + numerOsobnika2 + " " + grupa.get(1));

            kontrolaGrupy.add(pary);
            if (FX.get(osobnik1) < FX.get(osobnik2))  result.add(FX.get(osobnik1));
            else result.add(FX.get(osobnik2));
            il++;
            osobnik1 = r.nextInt(FX.size());
            osobnik2 = r.nextInt(FX.size());
        }
//            System.out.println(kontrolaGrupy);
        System.out.println(result);
        System.out.println(pary);
        i = 0;
        while(i < 5) {
            System.out.println("T = " + T.get(i));
            i++;
        }

    }

        public void metodaRankingowaMax() {
            System.out.println();
            System.out.println();
            System.out.println("METODA RANKINGOWA MAX");
            int il = 0, osobnik = 0, los = 0;
            Random r = new Random();
            ArrayList<Double> result = new ArrayList<>();

            System.out.println("FX " + FX);
            sort(FX, reverseOrder());
            System.out.println("FX sort " + FX);

            while (il < FX.size()) {
                los = r.nextInt(FX.size()-1)+1;
                osobnik = r.nextInt(los);
                result.add(FX.get(osobnik));
                il++;
            }
            System.out.println(result);
        }

    public void metodaRankingowaMin() {
        System.out.println();
        System.out.println();
        System.out.println("METODA RANKINGOWA MIN");
        int il = 0, osobnik = 0, los = 0;
        Random r = new Random();
        ArrayList<Double> result = new ArrayList<>();

        System.out.println("FX " + FX);
        sort(FX);
        System.out.println("FX sort " + FX);

        while (il < FX.size()) {
            los = r.nextInt(FX.size()-1)+1;
            osobnik = r.nextInt(los);
            result.add(FX.get(osobnik));
            il++;
        }
        System.out.println(result);
    }

    public void metodaRuletki() {
        double F = 0, pi = 0, qi = 0, randR = 0;
        i = 0;
        Random random = new Random();
        ArrayList<Double> P = new ArrayList<>();
        ArrayList<Double> Q = new ArrayList<>();
        ArrayList<Double> R = new ArrayList<>();
        while(i < FX.size()) {
            F += FX.get(i);
            i++;
        }
        i = 0;
        while(i < FX.size()) {
            randR = random.nextDouble();
            randR = Math.round(randR * 100.0) / 100.0;
            R.add(randR);
            pi = Math.round((FX.get(i)/F) * 100.0) / 100.0;
            qi += pi;
            qi = Math.round(qi * 100.0) / 100.0;
            P.add(pi);
            Q.add(qi);
            i++;
        }
        metodaRuletkiMax(R,P,Q,F);
//        metodaRuletkiMin(R,P,Q,F);
    }

    public void metodaRuletkiMax(ArrayList<Double> R, ArrayList<Double> P, ArrayList<Double> Q, double F) {
            System.out.println();
            System.out.println();
            System.out.println("METODA RULETKI MAX");

        ArrayList<Double> result = new ArrayList<>();
            i = 0;
            for(int j = 0; j < R.size(); j++) {
                for(int k = 0; k < Q.size(); k++) {
                    if(k == 0) {
                        if(R.get(j) <= Q.get(k)) result.add(FX.get(k));
                    }
                    else {
                        if (R.get(j) > Q.get(k-1) && R.get(j) <= Q.get(k)) {
                            result.add(FX.get(k));
                        }
                    }
                }
            }
            System.out.println("F = " + F);
            System.out.println("p = " + P);
            System.out.println("q = " + Q);
            System.out.println("r = " + R);
            System.out.println("result = " + result);
        }

    public void metodaRuletkiMin(ArrayList<Double> R, ArrayList<Double> P, ArrayList<Double> Q, double F){
        System.out.println();
        System.out.println();
        System.out.println("METODA RULETKI MIN");

        ArrayList<Double> result = new ArrayList<>();
        i = 0;
        for(int j = 0; j < R.size(); j++) {
            for(int k = 0; k < Q.size(); k++) {
                if(k == 0) {
                    if(R.get(j) <= Q.get(k)) result.add(FX.get(k));
                }
                else {
                    if (R.get(j) >= Q.get(k-1) && R.get(j) < Q.get(k)) {
                        result.add(FX.get(k));
                    }
                }
            }
        }

        System.out.println("F = " + F);
        System.out.println("p = " + P);
        System.out.println("q = " + Q);
        System.out.println("r = " + R);
        System.out.println("result = " + result);
    }
}

public class L2 {
    public static void main(String[] args) {
        int a = -1, b = 1, d = 1;
        int iloscOsobnikow = 10;

//        Funkcja_Jednowymiarowa f1 = new Funkcja_Jednowymiarowa(a,b,d,iloscOsobnikow);
//        f1.licz();
//        Funkcja_Trojwymiarowa f2 = new Funkcja_Trojwymiarowa(-1,1,1,2,2,3,1,2,3,5);
//        f2.licz();
        Funkcja_Wielowymiarowa f3 = new Funkcja_Wielowymiarowa(2,5);
        f3.licz();

    }
}
