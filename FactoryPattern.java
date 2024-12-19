

public class FactoryPattern {
    
    public interface Shape {
    
        void draw();
    }

    public class Circle implements Shape{
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    public class Rectangle implements Shape{
        @Override
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    public class ShapeFactory{

        public Shape getShape(String shape){

            Shape newShape = null;
            switch (shape) {
                case "Circle":
                    newShape = new Circle();
                    break;
                case "Rectangle":
                    newShape = new Rectangle();
                    break;
            }

            return newShape;
        }
    }

    public static void main(String[] args) {
        
        FactoryPattern obj = new FactoryPattern();
        FactoryPattern.ShapeFactory shapeFactory = obj.new ShapeFactory();


        Shape newShape = shapeFactory.getShape("Rectangle");
        newShape.draw();
        
    }
}