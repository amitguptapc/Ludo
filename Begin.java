import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Begin extends JFrame implements ActionListener {
    protected static JFrame W4;
    protected static JLabel ba1, ba2, ba3, ba4, ba5, ba6, lb;
    protected static JButton b;
    protected static int players = 0;
    protected static JCheckBox b2, b3, b4;
    protected static ButtonGroup bg;
    protected static Font font = new Font("Kristen ITC", Font.PLAIN, 20);

    public static void main(String[] args) {
         try {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.seaglass.SeaGlassLookAndFeel");
         }
         catch (Exception ignored) {
         }
        W4 = new JFrame();
        W4.setTitle("Ludo");
        W4.setSize(537, 264);
        W4.setUndecorated(true);
        W4.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        W4.setLocationRelativeTo(null);
        W4.setResizable(false);
        b = new JButton(" OK ");
        b.setFont(font);
        /* b.setContentAreaFilled(false);*/
        b.setBounds(340, 200, 80, 40);
        /* W4.setLayout(new GridLayout());*/
        ba1 = new JLabel(new ImageIcon("Images/border.png"));
        ba2 = new JLabel(new ImageIcon("Images/logo.png"));
        ba3 = new JLabel("Select no. of players :");
        ba3.setFont(font);
        ba4 = new JLabel("2");
        ba4.setFont(font);
        ba5 = new JLabel("3");
        ba5.setFont(font);
        ba6 = new JLabel("4");
        ba6.setFont(font);
        W4.add(ba1);
        ba1.add(ba2);
        ba2.setBounds(100, 100, 120, 100);
        ba1.add(ba3);
        ba3.setBounds(270, 86, 300, 50);
        ba1.add(ba4);
        ba1.add(b);
        ba1.add(ba5);
        ba1.add(ba6);
        ba4.setBounds(300, 130, 30, 50);
        ba5.setBounds(380, 130, 30, 50);
        ba6.setBounds(460, 130, 30, 50);
        lb = new JLabel("ERROR !");
        lb.setFont(font);
        lb.setForeground(Color.RED);
        b2 = new JCheckBox();
        b3 = new JCheckBox();
        b4 = new JCheckBox();
        bg = new ButtonGroup();
        bg.add(b2);
        bg.add(b3);
        bg.add(b4);
        ba1.add(b2);
        ba1.add(b3);
        ba1.add(b4);
        b2.setBounds(276, 145, 20, 20);
        b3.setBounds(356, 145, 20, 20);
        b4.setBounds(436, 145, 20, 20);
        b2.setContentAreaFilled(false);
        b3.setContentAreaFilled(false);
        b4.setContentAreaFilled(false);
        b.requestFocus();
        Begin be = new Begin();
        b.addActionListener(be);
        b2.addActionListener(be);
        b3.addActionListener(be);
        b4.addActionListener(be);
        W4.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            players = 2;
        }
        if (e.getSource() == b3) {
            players = 3;
        }
        if (e.getSource() == b4) {
            players = 4;
        }
        if (e.getSource() == b) {
            if (players != 0) {
                W4.setVisible(false);
                Game ob = new Game(players);
            } else {
                ba1.add(lb);
                lb.setBounds(215, 210, 103, 30);
            }
        }
    }
}
