public class ProxyDesignPattern {

    public interface EmployeeDB {
        
        public void create(String user,Employee emp);
        public void get(String user,int empId);
        public void delete(String user,int empId); 
    }

    public class Employee{
        int id;
        String name;

        Employee(int id,String name){
            this.id = id;
            this.name = name;
        }   

    }

    public class EmployeeDBImp implements EmployeeDB{
        
        @Override
        public void create(String user,Employee emp){
            System.out.println("Employee created successfully");
            return;
        }

        @Override
        public void get(String user,int empId){
            System.out.println("Employee fetched successfully");
            return;
        }

        @Override
        public void delete(String user,int empId){
            System.out.println("Employee deleted successfully");
            return;
        }
    }


    public class EmployeeDBProxy implements EmployeeDB{

        EmployeeDB employeeDB;

        EmployeeDBProxy(){
            this.employeeDB = new EmployeeDBImp();
        }

        @Override
        public void create(String user,Employee emp){
            if(user.equals("Admin")){
                employeeDB.create(user, emp);
                return;
            }
            System.out.println("Access denied");

        }

        @Override
        public void get(String user,int empId){
            if(user.equals("Admin") || user.equals("User")){
                employeeDB.get(user, empId);
                return;
            }
            System.out.println("Access denied");
        }

        @Override
        public void delete(String user,int empId){
            if(user.equals("Admin") || user.equals("User")){
                employeeDB.delete(user, empId);
                return;
            }
            System.out.println("Access denied");
        }
    }
    public static void main(String[] args) {
        
        ProxyDesignPattern obj = new ProxyDesignPattern();
        ProxyDesignPattern.EmployeeDB employeeDB = obj.new EmployeeDBProxy();

        employeeDB.create("Admin", obj.new Employee(0, "Harsh"));
        employeeDB.get("visitor", 0);
        employeeDB.delete("User", 0);
    }
}
