package shapesDrawing;

public class Circle  implements Drawable{
    private Integer radius;
    private Integer centerX;
    private Integer centerY;

    public Circle(Integer radius, Integer centerX, Integer centerY) {
        this.setRadius(radius);
        this.setCenterX(centerX);
        this.setCenterY(centerY);
    }

    private void setRadius(Integer radius) {
        this.radius = radius;
    }

    private void setCenterX(Integer centerX) {
        this.centerX = centerX;
    }

    private void setCenterY(Integer centerY) {
        this.centerY = centerY;
    }

    @Override
    public void draw() {
        double r_in = this.radius - 0.4;
        double r_out = this.radius + 0.4;
        for(double y = this.radius; y >= -this.radius; --y) {
            for (double x = -this.radius; x < r_out; x += 0.5) {
                double value = x * x + y * y;
                if (value >= r_in * r_in && value <= r_out * r_out) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
