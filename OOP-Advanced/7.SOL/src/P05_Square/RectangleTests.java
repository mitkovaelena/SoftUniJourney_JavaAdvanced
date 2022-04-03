package P05_Square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {
    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(10, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(50, rect.getArea());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSidesTestForSquare() {
        Rectangle rect = new Square(5, 10);
    }

    @Test
    public void getSquareSidesTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(5);
        Assert.assertEquals(5, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }

    @Test
    public void getSquareAreaTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(5);
        Assert.assertEquals(25, rect.getArea());
    }
}
