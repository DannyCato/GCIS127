package unit07.toys;
import unit07.products.*;

public class Main {
    public static void main(String[] args) {
        Complex complex1 = new Complex("Action Figures");
        complex1.add(new FactoryActionFigure());
        Trailer t1 = new Trailer();
        complex1.fillTrailer(t1);
        
        while (!t1.isEmpty()) {
            System.out.println(t1.unload().toString());
        }
    }
}
