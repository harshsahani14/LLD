public class BuilderDesignPattern {
    

    public class Student{

        int rollNo;
        String name;
        int age;
        String motherName;
        String fatherName;

        public Student(StudentBuilder obj){
            this.rollNo = obj.rollNo;
            this.name = obj.name;
            this.age = obj.age;
            this.motherName = obj.motherName;
            this.fatherName = obj.fatherName;
        }
    }

    public abstract class  StudentBuilder {
        
        int rollNo;
        String name;
        int age;
        String motherName;
        String fatherName;
        
        public StudentBuilder setRollNo(int rollNo){
            this.rollNo = rollNo;
            return this;
        }

        public StudentBuilder setName(String name){
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age){
            this.age = age;
            return this;
        }
        public StudentBuilder setMotherName(String motherName){
            this.motherName = motherName;
            return this;
        }

        public StudentBuilder setFatherName(String fatherName){
            this.fatherName = fatherName;
            return this;
        }
        
        public Student build(){
            return new Student(this);
        }
    }

    public class EngineeringStudent extends StudentBuilder{

    }

    public class MBAStudent extends StudentBuilder{
        
    }

    public class Director{

        StudentBuilder studentBuilder;

        Director(StudentBuilder studentBuilder){ this.studentBuilder = studentBuilder;}

        public Student createStudent(){

            if(studentBuilder instanceof EngineeringStudent){
                return createEngineeringStudent();
            }
            else{
                return createMBAStudent();
            }
        }

        private Student createEngineeringStudent(){
            return studentBuilder.setRollNo(1).setName("ABC").setAge(18).setMotherName("ABC").setFatherName("ABC").build();
        }

        private Student createMBAStudent(){
            return studentBuilder.setRollNo(2).setName("ABC").setAge(22).setMotherName("ABC").setFatherName("ABC").build();
        }
    }

   
    public static void main(String []args){

        BuilderDesignPattern obj = new BuilderDesignPattern();

        Director director1 = obj.new Director(obj.new EngineeringStudent());
        Director director2 = obj.new Director(obj.new MBAStudent());


        Student student1 = director1.createStudent();
        Student student2 = director2.createStudent();

        System.out.println(student1.age);
        System.out.println(student2.age);
    }
}
