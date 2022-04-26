import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import cyc.*;

import java.awt.*;

public class Button2 extends JFrame {
    private JButton b1=new JButton("JButton");
    private BasicArrowButton
    up=new BasicArrowButton(BasicArrowButton.NORTH),
    down=new BasicArrowButton(BasicArrowButton.SOUTH),
    right=new BasicArrowButton(BasicArrowButton.EAST),
    left=new BasicArrowButton(BasicArrowButton.WEST);
    public Button2(){
        setLayout(new FlowLayout());
        JPanel jp=new JPanel();
        jp.setBorder(new TitledBorder("head"));
        add(new JToggleButton("JtoggleButton"));
        add(new JCheckBox("JcheckBock"));
        add(new JRadioButton("RADIOBUTTON"));
        add(b1);
        jp.add(up);
        jp.add(down);
        jp.add(right);
        jp.add(left);
        add(jp);
    }

    static public void main(String args[]) {
        SwingConsole.run(new Button2(), 300, 300);
    }
}
