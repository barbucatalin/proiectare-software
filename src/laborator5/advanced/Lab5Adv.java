package laborator5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {


        NewIntCalculator intCalc = new NewIntCalculator(10);
        int intResult = (Integer) intCalc.add(5)
                .subtract(3)
                .multiply(2)
                .result();
        System.out.println("5.5.2 a) Rezultat Integer: " + intResult);


        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        double doubleResult = (Double) doubleCalc.add(5.0)
                .subtract(3.3)
                .multiply(2.2)
                .result();
        System.out.println("5.5.2 b) Rezultat Double: " + doubleResult);
    }
}