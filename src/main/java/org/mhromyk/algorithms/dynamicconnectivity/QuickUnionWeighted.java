package org.mhromyk.algorithms.dynamicconnectivity;

public class QuickUnionWeighted implements UnionFind {

    private int[] element;
    private int[] depth;

    public QuickUnionWeighted(int n) {
        element = new int[n];
        depth = new int[n];

        for (int i=0;i<n;i++){
            element[i]=i;
            depth[i]=0;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p)==findRoot(q);
    }

    public void union(int p, int q) {
        // balance by linking root of smaller tree to root of larger tree
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;

        if (depth[p]<=depth[q]){
            element[pRoot]=qRoot;
           // depth[]
        }

    }

    private int findRoot(int node){
        while (node!=element[node]){
            node = element[node];
        }
        return node;
    }

}
