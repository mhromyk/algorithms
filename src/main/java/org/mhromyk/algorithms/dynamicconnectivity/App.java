package org.mhromyk.algorithms.dynamicconnectivity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        UnionFind unionFind = new UF(n);
        System.out.println("The array has been initialized with size= "+n);

        while (scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!unionFind.connected(p,q)){
                unionFind.union(p,q);
                System.out.println(p+ " "+ q);
            }
            System.out.println(unionFind);
        }

        System.out.println("Let's test it:");

        System.out.println("unionFind.connected(2,3)="+unionFind.connected(2,3));
        System.out.println("unionFind.connected(6,5)="+unionFind.connected(6,5));
        System.out.println("unionFind.connected(7,0)="+unionFind.connected(7,0));

        System.out.println("End of program");
    }
}
