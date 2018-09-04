/**
 * Created by Maks on 8/31/2018.
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int numberOfOpenSites;
    private WeightedQuickUnionUF graph;
    private int sizeOfTheGrid;

    // virtual node for simplifying checking percolation by joining all opened nodes from top row with virtual top node and as a result we will check percolation staring from virtual top node.
    private int virtualTop;
    private int virtualDown;

    private int getIndex(int row, int col){
        if (row<=0) throw IllegalArgumentException("element is outside of ")
        return (row-1)*sizeOfTheGrid+(col-1);
    }

    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
        sizeOfTheGrid = n;
        graph = new WeightedQuickUnionUF(n+2);
        virtualTop = n;
        virtualDown = n+1;
    }

    // open site (row, col) if it is not open already
    public    void open(int row, int col){

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col){

    }

    // is site (row, col) full?
    public boolean isFull(int row, int col){

    }

    // number of open sites
    public     int numberOfOpenSites(){

    }

    // does the system percolate?
    public boolean percolates(){

    }

    // test client (optional)
    public static void main(String[] args){

    }
}