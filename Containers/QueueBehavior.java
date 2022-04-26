package cyc.Containers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueBehavior {
    private static int count=10;
    static <T>void test(Queue<T>queue,Generator<T>gen)
    {
        for(int i=0;i<count;i++)
        {
            queue.offer(gen.next());
        }
        while(queue.peek()!=null)
        {
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }
    static class Gen implements Generator<String>
    {
        int i=0;
        String[]strings="one two three four five six seven eight nine ten".split(" ");
        @Override
        public String next() {
            return strings[i++%strings.length];
        }
    }
    public static void main(String[]args)
    {
        test(new LinkedList<String>(),new Gen());
        test(new PriorityQueue<String>(),new Gen());
        test(new ArrayBlockingQueue<String>(count),new Gen());
    }
}
