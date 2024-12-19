public class AbstractFactoryPattern {
    

    public interface Shape {
    
        void draw();
    }

    public interface Colour {
        
        void paint();
    }

    public class Rectangle implements Shape{
         @Override
         public void draw() {
            System.out.println("Rectangle");
         }
    }

    public class Circle implements Shape{
        @Override
        public void draw() {
           System.out.println("Circle");
        }
    }

    public class Red implements Colour{
        @Override
        public void paint() {
           System.out.println("Red");
        }
   }

    public class Yellow implements Colour{
        @Override
        public void paint() {
        System.out.println("Yellow");
        }
    }


    public interface AbstractFactory {
        
        Shape getShape(String shape);
        Colour getColour(String colour);
    }

    public class ShapeFactory implements AbstractFactory{

        @Override
        public Shape getShape(String shape){

            switch (shape) {
                case "Circle":
                    return new Circle();
                case "Rectangle":
                    return new Rectangle();
            }

            return null;
        }

        @Override
        public Colour getColour(String colour) {
            System.out.println("This factory cannot make colours");
            return null;
        }
        
    }

    public class ColourFactory implements AbstractFactory{

        @Override
        public Colour getColour(String colour){

            switch (colour) {
                case "Red":
                    return new Red();
                case "Yellow":
                    return new Yellow();
            }

            return null;
        }

        @Override
        public Shape getShape(String shape) {
            System.out.println("This factory cannot make shaped");
            return null;
        }
        
    }

    public class FactoryProducer {
    
        public AbstractFactory getFactory(String factory){
            if(factory.equals("Shape")){
                return new ShapeFactory();
            }
            else{
                return new ColourFactory();
            }
        }
    }
    public static void main(String[] args) {
        
        AbstractFactoryPattern obj = new AbstractFactoryPattern();
        AbstractFactoryPattern.FactoryProducer factoryProducer = obj.new FactoryProducer();

        AbstractFactory shapeFactory = factoryProducer.getFactory("Shape");

        Shape shape = shapeFactory.getShape("Rectangle");
        shape.draw();

        AbstractFactory colourFactory = factoryProducer.getFactory("Colour");

        Colour colour = colourFactory.getColour("Yellow");
        colour.paint();


    }
}
