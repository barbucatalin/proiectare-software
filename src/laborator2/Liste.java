package laborator2;

import java.util.*;

public class Liste {
    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();          // a
        Set<Integer> zSet = new TreeSet<>();               // b
        List<Integer> xMinusY = new ArrayList<>();         // c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>(); // d

        Random rand = new Random();

        for (int i = 0; i < 5; i++) x.add(rand.nextInt(11));
        for (int i = 0; i < 7; i++) y.add(rand.nextInt(11));


        Collections.sort(x);
        Collections.sort(y);

        System.out.println("x initial: " + x);
        System.out.println("y initial: " + y);

        //a)xPlusY contine toate elementele sirurilor x si y
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) xPlusY: " + xPlusY);
        //b) zSet contine doar valorile comune din ambele siruri
        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("b) zSet (comune): " + zSet);
        //c)diferenta sirurilor (elemente care sunt in x si nu sunt in y)
        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("c) xMinusY: " + xMinusY);
    }
}
