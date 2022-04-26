package cyc.Containers;

import java.util.PriorityQueue;
import java.util.Random;

public class Exercise11 {
    static class NewInteger implements Comparable<NewInteger>
    {
        private Integer data;
        public NewInteger(Integer data){this.data=data;}
        @Override
        public int compareTo(NewInteger o) {
            if(data.compareTo(o.data)>0)return 1;
            else if(data.compareTo(o.data)<0)return -1;
            return 0;
        }

        @Override
        public String toString() {
            return "NewInteger{" +
                    "data=" + data +
                    '}';
        }
    }
    public static void main(String[]args)
    {
        PriorityQueue<NewInteger>priorityQueue=new PriorityQueue<>();
        Random random=new Random(47);
        for(int i=0;i<10;i++)
            priorityQueue.add(new NewInteger(random.nextInt(100)));
        while(!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());
    }
}
