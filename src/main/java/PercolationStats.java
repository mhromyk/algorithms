import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    // size of the grid (n-by-n)
    private int n;
    // T independent computational experiments
    private int T;
    private double[] percolationResult;

    private int getPercolationThreshold(int gridSize){
        Percolation percolation = new Percolation(gridSize);
        do{
            percolation.open(StdRandom.uniform(1,gridSize+1),StdRandom.uniform(1,gridSize+1));
        }while (!percolation.percolates());

        return percolation.numberOfOpenSites();
    }

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n<=0){
            throw new java.lang.IllegalArgumentException("Illegal set of size for n-by-n grid.");
        }
        if (trials <=0){
            throw new java.lang.IllegalArgumentException("Illegal set of trials for stats check.");
        }
        this.n = n;
        this.T = trials;

        percolationResult = new double[trials];
        for (int t = 0; t < trials; t++) {
            percolationResult[t]=0.0;
        }

        for (int t = 0; t < trials; t++) {
            percolationResult[t]=1.0*getPercolationThreshold(n)/T;
        }

        for (int t = 0; t < trials; t++) {
            System.out.println("The threshold for "+(t+1)+"-try is : " + percolationResult[t]);
        }

    }

    // sample mean of percolation threshold
    public double mean(){
//        double meanX = 0.0;
//        for (int i = 0; i < T; i++) {
//            meanX += percolationResult[i];
//        }
//
//        return meanX/T;
        return StdStats.mean(percolationResult);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
//        double meanX = mean();
//        double sSquared = 0.0;
//        for (int i = 0; i < T; i++) {
//            sSquared += Math.pow((percolationResult[i]-meanX),2);
//        }
//        sSquared = sSquared/(T-1);
//        return Math.sqrt(sSquared);
        return StdStats.stddev(percolationResult);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo(){
        double xMean = mean();
        double stddev = stddev();
        return ( xMean - (1.96*stddev)/Math.sqrt(T));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        double xMean = mean();
        double stddev = stddev();
        return ( xMean + (1.96*stddev)/Math.sqrt(T));
    }

    // test client (described below)
    public static void main(String[] args){
        PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
}
