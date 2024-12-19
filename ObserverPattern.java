import java.util.*;

class ObserverPattern{

    public static interface Observable {
    
        public void add(Observer obj);

        public void remove(Observer obj);

        public void notifyUsers();

        public void setStock(int newStock); 

        public int getStock();

    }

    public static interface Observer{

        public void updateUser();
    }

    public static class IphoneObservable implements Observable{

        int stock=0;
        public List<Observer> users = new ArrayList<>();

        @Override
        public void add(Observer obj){ 
            users.add(obj);
        }

        @Override
        public void remove(Observer obj){ 
            users.remove(obj);
        }

        @Override
        public void notifyUsers(){ 
            for(Observer obs:users){
                obs.updateUser();
            }
        }

        @Override
        public void setStock(int newStock){ 
            
            if(stock==0){
                notifyUsers();
            }
            stock = stock + newStock;

        }

        @Override
        public int getStock(){ 
            return stock;
        }

    }

    public static class EmailObserver implements Observer{

        String name;
        Observable observable;

        public EmailObserver(String name,Observable observable){
            this.name=name;
            this.observable=observable;
        }
        @Override
        public void updateUser(){
            System.out.println("User notified through mail:"+name);
        }
    }

    public static class MessageObserver implements Observer{

        String name;
        Observable observable;

        public MessageObserver(String name,Observable observable){
            this.name=name;
            this.observable=observable;
        }
        @Override
        public void updateUser(){
            System.out.println("User notified through message:"+name);
        }
    }

    public static void main(String[] args) {
        
        Observable iphone = new IphoneObservable();
        
        Observer user1 = new EmailObserver("user1",iphone);
        Observer user2 = new MessageObserver("user2",iphone);
        Observer user3 = new EmailObserver("user3",iphone);

        iphone.add(user1);
        iphone.add(user2);
        iphone.add(user3);

        iphone.setStock(10);
        iphone.setStock(0);
        iphone.setStock(10);

    }

    
}