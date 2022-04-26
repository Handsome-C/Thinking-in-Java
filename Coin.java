import java.util.Random;

public class Coin {
   static void do_coin()
    {
        int head=0,flower=0;
        Random r=new Random();
        for(int i=0;i<1000;i++)
             if(r.nextBoolean())
                 head++;
             else
                 flower++;
    System.out.println("head:"+head+'\n'+"flower:"+flower);
    }


}
