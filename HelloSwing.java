import javax.swing.*;
import  cyc.*;

import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Button extends  JFrame{
    private JButton b1=new JButton("b1");
    private JButton b2=new JButton("b2");
    public  Button(){
        //b1.setSize(100,100);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }
}

public class HelloSwing extends JFrame {
    static HelloSwing j;
    static public void main(String[] args)
    {
        j=new HelloSwing();
        SwingConsole.run(new Button(),300,300);

    try {
        TimeUnit.SECONDS.sleep(1);
    }
    catch(Exception exp)
    {
        System.out.println("erro");
    }
//SwingUtilities.invokeLater(new Runnable() {
//    @Override
//    public void run() {
//        h.label.setText("Change");
//    }
//});

    }

}
