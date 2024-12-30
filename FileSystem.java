import java.util.*;
public class FileSystem {
    
    public interface Filesystem {
        
        public void ls();
    }

    public class File implements Filesystem{

        String name;

        File(String name){
            this.name = name;
        }

        public void ls(){
            System.out.println("File name:" + this.name);
        }
    }

    public class Directory implements Filesystem{

        String name;
        List<Filesystem> list;

        Directory(String name){
            this.name = name;
            this.list = new ArrayList<>();
        }

        public void add(Filesystem fileSystem){ this.list.add(fileSystem);}

        @Override
        public void ls(){

            System.out.println("Directory name:"+this.name);
            for(Filesystem fileSystemObj:list){
                fileSystemObj.ls();
            }
        }
        
    }
    
    
    public static void main(String []args){ 
        
        FileSystem obj = new FileSystem();
        Directory filesystem = obj.new Directory("MyFileSystem");
        

        filesystem.add(obj.new File("config"));

        Directory frontend = obj.new Directory("frontend");

        frontend.add(obj.new File("index.html"));
        frontend.add(obj.new File("index.css"));
        filesystem.add(frontend);
        
        Directory backend = obj.new Directory("backend");
        backend.add(obj.new File("DB"));
        backend.add(obj.new File("Server"));
        filesystem.add(backend);

        filesystem.ls();
    }
}
