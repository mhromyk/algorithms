import org.junit.Before;
import org.junit.Test;

public class TestPercolationStats {
    private PercolationStats percolationStats;

    @Test
    public void testPercolationTreshold(){
        percolationStats = new PercolationStats(200,100);
        System.out.println("mean                    ="+percolationStats.mean());
        System.out.println("stddev                  ="+percolationStats.stddev());
        System.out.println("95% confidence interval = ["+percolationStats.confidenceLo()+", "+percolationStats.confidenceHi()+"]");
    }


}
