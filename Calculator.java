public class Calculator {
    
    enum Operation{
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    public interface ArithmeticExpression {
    
        public double evaluate();    
    }

    public class Number implements ArithmeticExpression{

        double num;

        Number(double num){
            this.num = num;
        }

        public double evaluate(){
            System.out.println("Number is"+num);
            return num;
        }
    }

    public class Expression implements ArithmeticExpression{

        Operation operator;
        ArithmeticExpression left;
        ArithmeticExpression right;

        Expression(Operation operator,ArithmeticExpression left,ArithmeticExpression right){
            this.operator = operator;
            this.left = left;
            this.right = right;
        }

        public double evaluate(){

            double result = Integer.MAX_VALUE;
            switch (operator) {
                case ADD:
                    result = left.evaluate()+right.evaluate();
                    break;
                case SUBTRACT:
                    result = left.evaluate()-right.evaluate();
                    break; 
                case MULTIPLY:
                    result = left.evaluate()*right.evaluate();
                    break; 
                case DIVIDE:
                    result = left.evaluate()/right.evaluate();
                    break;          
            }
            System.out.println("Result is:"+result);
            return result;
        }
    }
    public static void main(String[] args) {
        
        Calculator obj = new Calculator();
        Number num1 = obj.new Number(2.0);

        Number num2 = obj.new Number(1.0);
        Number num3 = obj.new Number(7.0);


        Expression expression1 = obj.new Expression(Operation.ADD, num2, num3);

        Expression expression2 = obj.new Expression(Operation.MULTIPLY, num1, expression1);

        expression2.evaluate();
    }
}
