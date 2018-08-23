package org.mhromyk.algorithms.dynamicconnectivity;

public interface UnionFind {
    boolean connected(int p, int q);
    void union(int p, int q);
}
