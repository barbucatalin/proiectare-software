package laborator7.forms;

public class Form {

    private String color;


    private static int counter = 0;

    public Form() {
        this.color = "white";
        counter++;
    }

    public Form(String color) {
        this.color = color;
        counter++;
    }


    public static int getInstanceCount() {
        return counter;
    }

    public float getArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "Form color=" + color;
    }
}