package shapesDrawing;

public class Rectangle implements Drawable{
    private Integer width;
    private Integer height;

    public Rectangle(Integer width, Integer height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setWidth(Integer width) {
        this.width = width;
    }

    private void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public void draw() {
        for (int i = 1; i <= this.height; i++) {
                for (int j = 1; j <= this.width; j++) {
                    String character = "* ";
                    if(i != 1 && i != this.height && j != 1 && j != this.width ){
                        character = "  ";
                    }
                    System.out.print(character);
                }
                System.out.println();
            }
    }
}
