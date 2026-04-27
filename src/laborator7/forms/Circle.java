package laborator7.forms;

public class Circle extends Form {

    private float radius;

    public Circle() {
        super();
    }

    public Circle(float radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Circle: " + super.toString() + ", radius=" + radius;
    }
}