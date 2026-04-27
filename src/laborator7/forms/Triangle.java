package laborator7.forms;

public class Triangle extends Form {

    private float base;
    private float height;

    public Triangle() {
        super();
    }

    public Triangle(float base, float height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public float getArea() {
        return base * height;
    }

    @Override
    public String toString() {
        return "Triangle: " + super.toString() + ", base=" + base + ", height=" + height;
    }
}