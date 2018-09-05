import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPercolation {
    private Percolation percolation;

    @Before
    public void init(){
        percolation = new Percolation(3);
    }

    @Test
    public void testOpen(){

        Assert.assertFalse(percolation.isOpen(1,1));
        percolation.open(1,1);
        Assert.assertTrue(percolation.isOpen(1,1));
    }

    @Test
    public void testIsFull(){
        Assert.assertFalse(percolation.isFull(1,1));
        percolation.open(1,1);
        Assert.assertTrue(percolation.isFull(1,1));

        Assert.assertFalse(percolation.isFull(2,2));
        percolation.open(2,2);
        Assert.assertFalse(percolation.isFull(2,2));
    }

    @Test
    public void testPercolation(){

    }
}
