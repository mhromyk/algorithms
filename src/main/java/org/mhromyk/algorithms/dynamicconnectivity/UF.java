package org.mhromyk.algorithms.dynamicconnectivity;

public class UF implements UnionFind {

    private int element[] ;

    public UF(int n){
        element = new int[n];

        for (int i=0;i<n;i++){
            element[i]=i;
        }
    }

    public boolean connected(int p, int q) {
        return element[p]==element[q];
    }

    public void union(int p, int q) {
        if (!connected(p,q)){
            int componentsForP = element[p];
            for (int anElement : element) {
                if(anElement==element[p]){
                    element[p] = element[q];
                }
            }
        }

    }

    @Override
    public String toString(){

        StringBuilder stringBuilder       = new StringBuilder("element[]=[ | ");
        StringBuilder stringBuilderHeader = new StringBuilder("position =[ | ");


        for (int i=0;i<element.length;i++ ){
            stringBuilderHeader.append(i+" | ");
            stringBuilder.append(element[i]+" | ");
        }
        stringBuilderHeader.append(" ]");
        stringBuilder.append(" ]");

        return stringBuilderHeader.append("\n").append(stringBuilder.toString()).toString();
    }
}
