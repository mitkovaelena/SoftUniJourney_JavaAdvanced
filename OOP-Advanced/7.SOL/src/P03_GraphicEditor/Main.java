package P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        Shape circle = new Rectangle();
        System.out.println(ge.drawShape(circle));
    }
}
