package unit06;

public class Calculon {
    public static void main(String[] args) {
        System.out.println(add(1,2));
        System.out.println(subtract(1,2));
        System.out.println(multiply(1,2));
        System.out.println(divide(1,2));
    }

    public static double add(double val1, double val2){
        return val1 + val2;
    }

    public static double subtract(double val1, double val2){
        return val1 - val2;
    }

    public static double multiply(double val1, double val2){
        return val1 * val2;
    }   

    public static double divide(double val1, double val2){
        return val1 / val2;
    }

}

