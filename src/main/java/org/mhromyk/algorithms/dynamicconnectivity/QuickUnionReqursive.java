package org.mhromyk.algorithms.dynamicconnectivity;

public class QuickUnionReqursive implements UnionFind {

    private int[] element;

    public QuickUnionReqursive(int n) {
        element = new int[n];
        for(int i=0;i<element.length;i++){
            element[i]=i;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p)==findRoot(q);
    }

    /**
     * To merge components containing p and q, set the p's root to the q's root
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        element[pRoot]=findRoot(q);
    }

    private int findRoot(int node){
        if (element[node]==node){
            return node;
        }else {
            return findRoot(element[node]);
        }
    }

}
