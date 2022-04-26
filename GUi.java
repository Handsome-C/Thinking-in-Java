import javax.swing.*;
import java.awt.*;

public class GUi extends JFrame {

    public void init(){
        this.setVisible((true));
        this.setSize(500,350);
        this.setTitle("CYC");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel j1=new JLabel("hello world");
        j1.setHorizontalAlignment(SwingConstants.CENTER);
        Container con=this.getContentPane();
        con.add(j1);
        con.setBackground(Color.blue);
    }

    public static void main(String [] args)
    {

        //new GUi().init();
       Coin.do_coin();
    }
}