public class LoggingSystem {

    enum LogType {
        DEBUG,
        ERROR,
        INFO,
        DB
    }

    public static class LogManager{

        LogManager nextLogManager;

        LogManager(LogManager nextLogManager){
            this.nextLogManager = nextLogManager;
        }

        
        public void log(LogType logType,String message){

            if(nextLogManager!=null){
                nextLogManager.log(logType,message);
            }
            else{
                System.out.println("Cannot handle the request");
            }
        }
    }

    public class InfoLogManager extends LogManager{
        
        InfoLogManager(LogManager nextLogManager){
            super(nextLogManager);
        }

        @Override
        public void log(LogType logType,String message){

            if(logType==LogType.INFO){
                System.out.println("INFO: "+message);
            }
            else{
                super.log(logType, message);
            }
        }
    }

    public class DebugLogManager extends LogManager{
        
        DebugLogManager(LogManager nextLogManager){
            super(nextLogManager);
        }

        @Override
        public void log(LogType logType,String message){

            if(logType==LogType.DEBUG){
                System.out.println("DEBUG: "+message);
            }
            else{
                super.log(logType, message);
            }
        }
        
    }

    public class ErrorLogManager extends LogManager{
        
        ErrorLogManager(LogManager nextLogManager){
            super(nextLogManager);
        }

        @Override
        public void log(LogType logType,String message){

            if(logType==LogType.ERROR){
                System.out.println("ERROR: "+message);
            }
            else{
                super.log(logType, message);
            }
        }
    }
    public static void main(String[] args) {
        
        LoggingSystem obj = new LoggingSystem();

        LoggingSystem.LogManager logManager = obj.new InfoLogManager(obj.new DebugLogManager(obj.new ErrorLogManager(null)));

        logManager.log(LogType.ERROR,"This is error log");
        logManager.log(LogType.DEBUG,"This is debug log");
        logManager.log(LogType.INFO,"This is info log");
        logManager.log(LogType.DB,"This is db log");


    }
}
