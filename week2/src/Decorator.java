// Giao diện chung
interface Shape {
    void draw();
}

// Lớp triển khai
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn");
    }
}

// Lớp trang trí trừu tượng
abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}

// Lớp trang trí cụ thể
class ColoredShape extends ShapeDecorator {
    private String color;

    public ColoredShape(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Tô màu " + color);
    }
}

// Lớp trang trí cụ thể
class BorderedShape extends ShapeDecorator {
    public BorderedShape(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Vẽ viền");
    }
}

public class Decorator {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new ColoredShape(circle, "đỏ");
        Shape redBorderedCircle = new BorderedShape(redCircle);

        redBorderedCircle.draw();
    }
}
