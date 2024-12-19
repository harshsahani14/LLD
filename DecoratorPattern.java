public class DecoratorPattern {
    
    static interface BasePizza{
        public int cost();
    }

    static interface PizzaWithToppings extends BasePizza {
        public int cost();
    }

    static class ItalianPizza implements BasePizza{

        @Override
        public int cost(){
            return 100;
        }
    }

    static class AmericanPizza implements BasePizza{

        @Override
        public int cost(){
            return 120;
        }
    }

    static class IndianPizza implements BasePizza{

        @Override
        public int cost(){
            return 140;
        }
    }

    static class CheeseTopping implements PizzaWithToppings{

        BasePizza pizza;

        public CheeseTopping(BasePizza pizza){
            this.pizza = pizza;
        }

        @Override
        public int cost(){
            return pizza.cost() + 10;
        }
    }


    static class MushroomTopping implements PizzaWithToppings{

        BasePizza pizza;

        public MushroomTopping(BasePizza pizza){
            this.pizza = pizza;
        }

        @Override
        public int cost(){
            return pizza.cost() + 15;
        }
    }


    public static void main(String[] args) {
        
        BasePizza pizza1 = new CheeseTopping(new ItalianPizza());
        BasePizza pizza2 = new MushroomTopping(new CheeseTopping(new AmericanPizza()));
         
        System.out.println(pizza1.cost());
        System.out.println(pizza2.cost());
    }
}
