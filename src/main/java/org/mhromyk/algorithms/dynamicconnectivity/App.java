package org.mhromyk.algorithms.dynamicconnectivity;

import org.junit.Assert;

import java.util.Scanner;

public class App {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        UnionFind unionFindQuickFind = new QuickFind(n);
        //UnionFind unionFindQuickUnion = new QuickUnionReqursive(n);
        UnionFind unionFindQuickUnion = new QuickUnion(n);
        System.out.println("The array has been initialized with size= "+n);

        while (scanner.hasNext()){
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            System.out.println(p+ " "+ q);

            if (unionFindQuickFind.connected(p,q)!=unionFindQuickUnion.connected(p,q)){
                System.out.println("There is discrepancy between QuickFind and QuickUnion algorithms:");
                System.out.println("        unionFindQuickFind.connected(p,q)="+unionFindQuickFind.connected(p,q));
                System.out.println("        unionFindQuickUnion.connected(p,q)="+unionFindQuickUnion.connected(p,q));
            }

            if (!unionFindQuickFind.connected(p,q)){
                unionFindQuickFind.union(p,q);
                if (!unionFindQuickFind.connected(p,q)){
                    throw new Exception("unionFindQuickFind.connected(p,q)="+unionFindQuickFind.connected(p,q)+" after connection");
                }
            }

            if(!unionFindQuickUnion.connected(p,q)){
                unionFindQuickUnion.union(p,q);
                if (!unionFindQuickUnion.connected(p,q)){
                    throw new Exception("unionFindQuickUnion.connected(p,q)="+unionFindQuickUnion.connected(p,q)+" after connection");
                }
            }

            if (unionFindQuickFind.connected(p,q)!=unionFindQuickUnion.connected(p,q)){
                System.out.println("There is discrepancy between QuickFind and QuickUnion algorithms after union operation for P and Q elements:");
                System.out.println("        unionFindQuickFind.connected(p,q)="+unionFindQuickFind.connected(p,q));
                System.out.println("        unionFindQuickUnion.connected(p,q)="+unionFindQuickUnion.connected(p,q));
            }

            //System.out.println(unionFindQuickFind);
        }

        System.out.println("Let's test it:");

        System.out.println("unionFind.connected(2,3): quickFind="+unionFindQuickFind.connected(2,3)+" | quickUnion= "+unionFindQuickUnion.connected(2,3));
        System.out.println("unionFind.connected(6,5): quickFind="+unionFindQuickFind.connected(6,5)+" | quickUnion= "+unionFindQuickUnion.connected(6,5));
        System.out.println("unionFind.connected(7,0): quickFind="+unionFindQuickFind.connected(7,0)+" | quickUnion= "+unionFindQuickUnion.connected(7,0));


        System.out.println("End of program");
    }
}
