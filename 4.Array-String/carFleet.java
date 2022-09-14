import java.util.*;

class carFleet {
    class Car implements Comparable<Car> {
       int position;
       int speed;
       
       Car(int position, int speed){
           this.position = position;
           this.speed = speed;
       }
       
        // taking out car with biggest position -> desending order
       public int compareTo(Car c){
           // ulta
           return c.position - this.position;
       }
   }
   
   public int car_Fleet(int target, int[] position, int[] speed) {
       PriorityQueue<Car> pq = new PriorityQueue<>();
       
       for(int i=0 ; i<position.length ; i++){
          Car c = new Car(position[i] , speed[i]);
          pq.add(c); 
       }
       

       // it doesn't matter kis time pahuchega
       // kitna group reach krega wo matter krega
       int groups = 0;
       double time = 0;
       while(pq.size() > 0){
           Car c = pq.remove();
           double ctime = (target - c.position) * 1.0 / c.speed;
           if(ctime > time){
               time = ctime;
               groups++;
           }
       }
       
       return groups;
   }
}