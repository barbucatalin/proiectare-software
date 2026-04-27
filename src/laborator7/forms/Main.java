package laborator7.forms;

import laborator7.util.PasswordMaker;

public class Main {

    public static void main(String[] args) {


        System.out.println("7.6.1 Instance Counter:\n");

        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");

        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);

        System.out.println("Total instance count is " + Form.getInstanceCount());


        System.out.println("\n7.6.2 Singleton test:\n");

        PasswordMaker pm2 = PasswordMaker.getInstance();

        System.out.println("1: " + PasswordMaker.getInstance().getPassword());
        System.out.println("2: " + PasswordMaker.getInstance().getPassword());
        System.out.println("3: " + PasswordMaker.getInstance().getPassword());
        System.out.println("4: " + pm2.getPassword());
        System.out.println("5: " + pm2.getPassword());

        System.out.println("\nNumber of getInstance() calls: " + PasswordMaker.getCallingCounts());
    }
}