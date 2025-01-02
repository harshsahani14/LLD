// Weighing machine from pounds to kilos
public class AdapterDesignPattern {
    
    //Adadptee
    public class WeighingMachine{

        public int weightInPounds(){ return 20;}
    }

    // Target interface
    public interface WeightMachineAdapter{

        double weightinKilos();
    }

    // Adapter 
    public class WeightMachineAdapterImp implements WeightMachineAdapter{

        WeighingMachine weighingMachine;

        WeightMachineAdapterImp(WeighingMachine weighingMachine)
        {
            this.weighingMachine=weighingMachine; 
        }

        public double weightinKilos(){
            
            int weight = weighingMachine.weightInPounds();
            return weight*(0.45);
        }
    }
    public static void main(String[] args) {
        
        AdapterDesignPattern obj = new AdapterDesignPattern();
         
        WeightMachineAdapter weightmachine = obj.new WeightMachineAdapterImp(obj.new WeighingMachine());

        System.out.println(weightmachine.weightinKilos());
    }
}
