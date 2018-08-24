package org.mhromyk.algorithms.dynamicconnectivity;

public class QuickUnion implements UnionFind {
    private int[] element;

    public QuickUnion(int n) {
        element = new int[n];
        for (int i=0;i<element.length;i++){
            element[i]=i;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p)==findRoot(q);
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot != qRoot){
          element[pRoot]=qRoot;
        }
    }

    private int findRoot(int node){
        while (node != element[node]){
            node = element[node];
        }
        return node;
    }
}
