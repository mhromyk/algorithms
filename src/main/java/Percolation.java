/**
 * Created by Maks on 8/31/2018.
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF graph;
    private int sizeOfTheGrid;
    //        initialize array for tracking state of the sites.
    private Site sites;

    // virtual node for simplifying checking percolation by joining all opened nodes from top row with virtual top node and as a result we will check percolation staring from virtual top node.
    private int virtualTop;
    private int virtualDown;

    private int getIndex(int row, int col){
        if ( (row<=0) || (row>sizeOfTheGrid) || (col<=0) || (col>sizeOfTheGrid)) throw new IllegalArgumentException("specified ("+row+","+col+") indices are outside of boundaries.");
        return (row-1)*sizeOfTheGrid+(col-1);
    }

    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
        sizeOfTheGrid = n;
        graph = new WeightedQuickUnionUF(n*n+2);
        virtualTop = n*n;
        virtualDown = n*n+1;

        sites = new Site(n*n+2);
        // open VirtualTop and VirtualBottom sites to be ready for connection
        sites.openSite(virtualTop);
        sites.openSite(virtualDown);
    }

    // open sites (row, col) if it is not open already
    public  void open(int row, int col){
        // check 4 neighbors

        // check top neighbor
        if (row > 1){
          if(sites.getState(getIndex(row-1,col))==State.OPENED){
              graph.union(getIndex(row-1,col),getIndex(row,col));
          }

        }
        if (row == 1){
            //connect to virtualTop site
            graph.union(getIndex(row,col),virtualTop);
        }

        // check bottom neighbor
        if (row<sizeOfTheGrid){
            if (sites.getState(getIndex(row+1,col))==State.OPENED){
                graph.union(getIndex(row+1,col),getIndex(row,col));
            }
        }
        if (row == sizeOfTheGrid){
            //connect to virtualDown site
            graph.union(getIndex(row,col),virtualDown);
        }

        //check left neighbor
        if (col > 1){
            if (sites.getState(getIndex(row,col-1))==State.OPENED){
                graph.union(getIndex(row,col-1),getIndex(row,col));
            }
        }

        //check right neighbor
        if (col < sizeOfTheGrid){
            if (sites.getState(getIndex(row,col+1))==State.OPENED){
                graph.union(getIndex(row,col+1),getIndex(row,col));
            }
        }

        sites.openSite(getIndex(row,col));
    }

    // is sites (row, col) open?
    public boolean isOpen(int row, int col){
        return sites.getState(getIndex(row,col))==State.OPENED;
    }

    // is sites (row, col) full?
    public boolean isFull(int row, int col){
        return graph.connected(virtualTop,getIndex(row,col));
    }

    // number of open sites
    public int numberOfOpenSites(){
        return sites.getOpenedSites();
    }

    // does the system percolate?
    public boolean percolates(){
        return graph.connected(virtualTop,virtualDown);
    }

    // test client (optional)
    public static void main(String[] args){

    }
}