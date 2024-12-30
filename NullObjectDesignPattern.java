import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NullObjectDesignPattern {
    
    public interface Car{

        void drive();
        void stop();
    }

    public class Suv implements Car{

        @Override
        public void drive(){
            System.out.println("Suv is driving");
        }

        @Override
        public void stop(){
            System.out.println("Suv has stopped");
        }
    }


    public class NullCar implements Car{
        
        @Override
        public void drive(){
            System.out.println("Null cannot drive");
        }

        @Override
        public void stop(){
            System.out.println("Null cannot stop");
        }
    }


    public class CarFactory{

        public Car getCar(String car){
            if(car.equals("Suv")){ return new Suv();}

            return new NullCar();
        }
    }
    public static void main(String[] args) {
        
        NullObjectDesignPattern obj = new NullObjectDesignPattern();
        NullObjectDesignPattern.CarFactory carFactory = obj.new CarFactory();


        Car newCar = carFactory.getCar("Wagonar");

        newCar.drive();
        newCar.stop();

        List<Integer> list  = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        Stream<Integer> stream = l1.stream();

        
    }
}
