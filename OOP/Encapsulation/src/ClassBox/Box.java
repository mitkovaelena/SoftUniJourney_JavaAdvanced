package ClassBox;

public class Box {
    private Double length;
    private Double width;
    private Double height;

    public Box(Double length, Double width, Double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(Double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(Double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(Double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public Double getSurfaceArea(){
        return 2*(this.length*this.height + this.length*this.width + this.width*this.height);
    }

    public Double getLateralSurfaceArea(){
        return 2*(this.length*this.height + this.width*this.height);
    }

    public Double getVolume(){
        return this.length*this.height*this.width;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume - %.2f\n", this.getSurfaceArea(), getLateralSurfaceArea(), getVolume());
    }
}
