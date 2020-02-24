import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Game extends JFrame implements ActionListener {
    JFrame W1;
    JLabel ba;
    JButton bt;
    JLabel l2;
    Dice obj = new Dice();
    JTextArea ar = new JTextArea(30, 1);
    JTextArea ar1 = new JTextArea(30, 1);
    JTextArea ar2 = new JTextArea(30, 1);
    Font font = new Font("Kristen ITC", Font.PLAIN, 18);
    Font font1 = new Font("Kristen ITC", Font.PLAIN, 22);
    int i = 0;
    Location ob = new Location();
    int no;
    JLabel[] lbl = new JLabel[6];
    JButton[] red = new JButton[4];
    JButton[] green = new JButton[4];
    JButton[] blue = new JButton[4];
    JButton[] yellow = new JButton[4];
    Color cb = new Color(0, 162, 232);
    Color cr = new Color(237, 28, 36);
    Color cy = new Color(255, 201, 14);
    Color cg = new Color(151, 193, 21);
    int sb, sg, sr, sy;

    Game(int np) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }
        W1 = new JFrame();
        //bt=new JButton();
        //bt.setIcon(new ImageIcon("di.png"));
        W1.setTitle("Ludo");
        W1.setSize(1010, 730);
        W1.setLocationRelativeTo(null);
        W1.setResizable(false);
        //W1.setUndecorated(true);
        //W1.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        ba = new JLabel(new ImageIcon("Images/back1.png"));
        W1.add(ba);

        no = np;

        lbl[0] = new JLabel(new ImageIcon("Images/one.png"));
        lbl[1] = new JLabel(new ImageIcon("Images/two.png"));
        lbl[2] = new JLabel(new ImageIcon("Images/three.png"));
        lbl[3] = new JLabel(new ImageIcon("Images/four.png"));
        lbl[4] = new JLabel(new ImageIcon("Images/five.png"));
        lbl[5] = new JLabel(new ImageIcon("Images/six.png"));
        //lbl[6]=new JLabel(new ImageIcon("blnk.png"));
        for (int i = 0; i < 6; i++) {
            lbl[i].setBounds(890, 565, 68, 68);
            //lbl[i].setBounds(300,300,70,70);
            ba.add(lbl[i]);
            lbl[i].setVisible(false);
        }

        ar.setEditable(false);
        ar.setOpaque(false);
        ar.setFont(font);
        ar.setBounds(755, 590, 200, 40);
        W1.setVisible(true);

        sb = 4;
        sy = 4;
        sg = 4;
        sr = 4;

        ar1.setEditable(false);
        ar1.setOpaque(false);
        ar1.setFont(font1);
        ar1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        ar1.setBounds(807, 380, 270, 50);
        ba.add(ar1);
        ar1.setText("Player 1");
        ar1.setForeground(cb);

        ar2.setEditable(false);
        ar2.setOpaque(false);
        ar2.setFont(font);
        ar2.setBounds(760, 645, 200, 30);
        ba.add(ar2);

        ar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        ba.add(ar);
        //bt.setBounds(750,480,201,107);
        W1.setLayout(new GridLayout());
        //ba.add(bt);
        //bt.setContentAreaFilled(false);
        //bt.addActionListener(this);

        for (int i = 0; i < 4; i++) {
            red[i] = new JButton();
            red[i].setIcon(new ImageIcon("Images/red.png"));
            red[i].addActionListener(this);
            red[i].setToolTipText("RED " + (i + 1));
            blue[i] = new JButton();
            blue[i].setIcon(new ImageIcon("Images/blue.png"));
            blue[i].addActionListener(this);
            blue[i].setToolTipText("BLUE " + (i + 1));
            yellow[i] = new JButton();
            yellow[i].setIcon(new ImageIcon("Images/yellow.png"));
            yellow[i].addActionListener(this);
            yellow[i].setToolTipText("YELLOW " + (i + 1));
            green[i] = new JButton();
            green[i].setIcon(new ImageIcon("Images/green.png"));
            green[i].addActionListener(this);
            green[i].setToolTipText("GREEN " + (i + 1));
        }

        switch (np) {
            case 4: {
                yellow[0].setBounds(87, 500, 30, 30);
                ba.add(yellow[0]);
                yellow[1].setBounds(179, 499, 30, 30);
                ba.add(yellow[1]);
                yellow[2].setBounds(86, 586, 30, 30);
                ba.add(yellow[2]);
                yellow[3].setBounds(178, 585, 30, 30);
                ba.add(yellow[3]);
            }
            case 3: {
                red[0].setBounds(505, 88, 30, 30);
                ba.add(red[0]);
                red[1].setBounds(597, 88, 30, 30);
                ba.add(red[1]);
                red[2].setBounds(504, 174, 30, 30);
                ba.add(red[2]);
                red[3].setBounds(596, 174, 30, 30);
                ba.add(red[3]);
            }
            case 2: {
                blue[0].setBounds(88, 86, 30, 30);
                ba.add(blue[0]);
                blue[1].setBounds(180, 86, 30, 30);
                ba.add(blue[1]);
                blue[2].setBounds(87, 172, 30, 30);
                ba.add(blue[2]);
                blue[3].setBounds(179, 172, 30, 30);
                ba.add(blue[3]);

                green[0].setBounds(504, 502, 30, 30);
                ba.add(green[0]);
                green[1].setBounds(596, 503, 30, 30);
                ba.add(green[1]);
                green[2].setBounds(503, 588, 30, 30);
                ba.add(green[2]);
                green[3].setBounds(595, 588, 30, 30);
                ba.add(green[3]);

            }
        }

        bt = new JButton();
        //bt.setContentAreaFilled(false);
        bt.setIcon(new ImageIcon("Images/d.png"));
        ba.add(bt);
        bt.setBounds(750, 440, 201, 107);
        bt.addActionListener(this);

        W1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        W1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit?", "User Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    W1.setVisible(false);
                    System.exit(0);
                }
            }
        });
    }

    String j;
    int k = 1, l, m = 0;
    int[] stateb = {1, 1, 1, 1};
    int[] stateg = {1, 1, 1, 1};
    int[] stater = {1, 1, 1, 1};
    int[] statey = {1, 1, 1, 1};

    int di;
    int six, nonsix;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt) {
            di = obj.roll();
            l = k % no;
            if (l == 0)
                l = no;
            k = k + 1;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar.setText("You Have Got : " + di);
            ar2.setText("");
            // ba.add(lbl[di-1]);
            lbl[di - 1].setVisible(true);
            if (di == 6) {
                ar2.setText("       Roll Again !");
                m++;
                k--;
            }
            if (di != 6) {
                j = m + "," + di;
                m = 0;
            }
            if (j != null) {
                String[] score = j.split(",");
                six = Integer.parseInt(score[0]);
                nonsix = Integer.parseInt(score[1]);
                if (l == 1 && sb == 4 && six == 0) {
                    ar1.setForeground(cg);
                    ar1.setText("Player 2");
                } else if (l == 2 && sg == 4 && six == 0) {
                    if (no == 2) {
                        ar1.setForeground(cb);
                        ar1.setText("Player 1");
                    }
                    if (no == 3 || no == 4) {
                        ar1.setForeground(cr);
                        ar1.setText("Player 3");
                    }
                } else if (l == 3 && sr == 4 && six == 0) {
                    if (no == 3) {
                        ar1.setForeground(cb);
                        ar1.setText("Player 1");
                    }
                    if (no == 4) {
                        ar1.setForeground(cy);
                        ar1.setText("Player 4");
                    }
                } else if (l == 4 && sy == 4 && six == 0) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                } else {
                    System.out.println("here am");
                    bt.setVisible(false);
                }
                j = null;
            }
        }

        if (e.getSource() == blue[0] && l == 1 && !bt.isVisible() && ((stateb[0] == 1 && six != 0) || (stateb[0] == 0))) {
            moverblue1();
        }

        if (e.getSource() == blue[1] && l == 1 && !bt.isVisible() && ((stateb[1] == 1 && six != 0) || (stateb[1] == 0))) {
            moverblue2();
        }

        if (e.getSource() == blue[2] && !bt.isVisible() && l == 1 && ((stateb[2] == 1 && six > 0) || (stateb[2] == 0))) {
            moverblue3();
        }

        if (e.getSource() == blue[3] && !bt.isVisible() && l == 1 && ((stateb[3] == 1 && six > 0) || (stateb[3] == 0))) {
            moverblue4();
        }

        if (e.getSource() == green[0] && !bt.isVisible() && l == 2 && ((stateg[0] == 1 && six > 0) || (stateg[0] == 0))) {
            movergreen1();
        }

        if (e.getSource() == green[1] && !bt.isVisible() && l == 2 && ((stateg[1] == 1 && six > 0) || (stateg[1] == 0))) {
            movergreen2();
        }

        if (e.getSource() == green[2] && !bt.isVisible() && l == 2 && ((stateg[2] == 1 && six > 0) || (stateg[2] == 0))) {
            movergreen3();
        }

        if (e.getSource() == green[3] && !bt.isVisible() && l == 2 && ((stateg[3] == 1 && six > 0) || (stateg[3] == 0))) {
            movergreen4();
        }

        if (e.getSource() == red[0] && !bt.isVisible() && l == 3 && ((stater[0] == 1 && six > 0) || (stater[0] == 0))) {
            moverred1();
        }

        if ((e.getSource() == red[1]) && !bt.isVisible() && (l == 3) && (((stater[1] == 1) && (six > 0)) || (stater[1] == 0))) {
            moverred2();
        }

        if (e.getSource() == red[2] && !bt.isVisible() && l == 3 && ((stater[2] == 1 && six > 0) || (stater[2] == 0))) {
            moverred3();
        }

        if (e.getSource() == red[3] && !bt.isVisible() && l == 3 && ((stater[3] == 1 && six > 0) || (stater[3] == 0))) {
            moverred4();
        }

        if (e.getSource() == yellow[0] && !bt.isVisible() && l == 4 && ((statey[0] == 1 && six > 0) || (statey[0] == 0))) {
            moveryellow1();
        }

        if (e.getSource() == yellow[1] && !bt.isVisible() && l == 4 && ((statey[1] == 1 && six > 0) || (statey[1] == 0))) {
            moveryellow2();
        }

        if (e.getSource() == yellow[2] && !bt.isVisible() && l == 4 && ((statey[2] == 1 && six > 0) || (statey[2] == 0))) {
            moveryellow3();
        }

        if (e.getSource() == yellow[3] && !bt.isVisible() && l == 4 && ((statey[3] == 1 && six > 0) || (statey[3] == 0))) {
            moveryellow4();
        }
    }

    int lx;
    boolean checker;

    void moverblue1() {
        System.out.println("Reach 1");
        if (stateb[0] == 1) {
            if (six > 0) {
                blue[0].setLocation(ob.pt[0]);
                six = six - 1;
                sb--;
                stateb[0] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {
            for (int i = 0; i < 52; i++) {
                if (blue[0].getLocation().x == ob.pt[i].x && blue[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 1);
            blue[0].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            six -= 1;
            j = six + "," + nonsix;
        } else {
            for (int i = 0; i < 52; i++) {
                if (blue[0].getLocation().x == ob.pt[i].x && blue[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 1);
            blue[0].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cg);
                ar1.setText("Player 2");
                highlight(2);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moverblue2() {
        System.out.println("Reach 2");
        if (stateb[1] == 1) {
            if (six > 0) {
                blue[1].setLocation(ob.pt[0]);
                six = six - 1;
                sb--;
                stateb[1] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {
            for (int i = 0; i < 52; i++) {
                if (blue[1].getLocation().x == ob.pt[i].x && blue[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 1);
            blue[1].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            six--;
            j = six + "," + nonsix;
        } else {
            for (int i = 0; i < 52; i++) {
                if (blue[1].getLocation().x == ob.pt[i].x && blue[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 1);
            blue[1].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            nonsix = 0;
            j = six + "," + nonsix;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cg);
                ar1.setText("Player 2");
                highlight(2);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moverblue3() {
        System.out.println("Reach 1");
        if (stateb[2] == 1) {
            if (six > 0) {
                blue[2].setLocation(ob.pt[0]);
                six = six - 1;
                sb--;
                stateb[2] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {
            for (int i = 0; i < 52; i++) {
                if (blue[2].getLocation().x == ob.pt[i].x && blue[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 1);
            blue[2].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            six -= 1;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (blue[2].getLocation().x == ob.pt[i].x && blue[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 1);
            blue[2].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cg);
                ar1.setText("Player 2");
                highlight(2);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moverblue4() {
        System.out.println("Reach 1");
        if (stateb[3] == 1) {
            if (six > 0) {
                blue[3].setLocation(ob.pt[0]);
                six = six - 1;
                sb--;
                stateb[3] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (blue[3].getLocation().x == ob.pt[i].x && blue[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 1);
            blue[3].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            six--;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (blue[3].getLocation().x == ob.pt[i].x && blue[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 1);
            blue[3].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cg);
                ar1.setText("Player 2");

                highlight(2);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void movergreen1() {
        if (stateg[0] == 1) {
            if (six > 0) {
                green[0].setLocation(ob.pt[26]);
                six = six - 1;
                sg--;
                stateg[0] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (green[0].getLocation().x == ob.pt[i].x && green[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 2);
            green[0].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (green[0].getLocation().x == ob.pt[i].x && green[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 2);
            green[0].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            nonsix = 0;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 2) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 3 || no == 4) {
                    ar1.setForeground(cr);
                    ar1.setText("Player 3");
                    highlight(3);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void movergreen2() {
        if (stateg[1] == 1) {
            if (six > 0) {
                green[1].setLocation(ob.pt[26]);
                six = six - 1;
                sg--;
                stateg[1] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (green[1].getLocation().x == ob.pt[i].x && green[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 2);
            green[1].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (green[1].getLocation().x == ob.pt[i].x && green[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 2);
            green[1].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            nonsix = 0;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 2) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 3 || no == 4) {
                    ar1.setForeground(cr);
                    ar1.setText("Player 3");
                    highlight(3);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void movergreen3() {
        if (stateg[2] == 1) {
            if (six > 0) {
                green[2].setLocation(ob.pt[26]);
                six = six - 1;
                sg--;
                stateg[2] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (green[2].getLocation().x == ob.pt[i].x && green[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 2);
            green[2].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (green[2].getLocation().x == ob.pt[i].x && green[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 2);
            green[2].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 2) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 3 || no == 4) {
                    ar1.setForeground(cr);
                    ar1.setText("Player 3");
                    highlight(3);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void movergreen4() {
        if (stateg[3] == 1) {
            if (six > 0) {
                green[3].setLocation(ob.pt[26]);
                six = six - 1;
                sg--;
                stateg[3] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (green[3].getLocation().x == ob.pt[i].x && green[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 2);
            green[3].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (green[3].getLocation().x == ob.pt[i].x && green[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 2);
            green[3].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            nonsix = 0;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 2) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 3 || no == 4) {
                    ar1.setForeground(cr);
                    ar1.setText("Player 3");
                    highlight(3);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moverred1() {
        if (stater[0] == 1) {
            if (six > 0) {
                red[0].setLocation(ob.pt[13]);
                six = six - 1;
                sr--;
                stater[0] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (red[0].getLocation().x == ob.pt[i].x && red[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 3);
            red[0].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (red[0].getLocation().x == ob.pt[i].x && red[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 3);
            red[0].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 3) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 4) {
                    ar1.setForeground(cy);
                    ar1.setText("Player 4");
                    highlight(4);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moverred2() {
        if (stater[1] == 1) {
            if (six > 0) {
                red[1].setLocation(ob.pt[13]);
                six = six - 1;
                sr--;
                stater[1] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (red[1].getLocation().x == ob.pt[i].x && red[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 3);
            red[1].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (red[1].getLocation().x == ob.pt[i].x && red[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 3);
            red[1].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 3) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 4) {
                    ar1.setForeground(cy);
                    ar1.setText("Player 4");
                    highlight(4);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moverred3() {
        if (stater[2] == 1) {
            if (six > 0) {
                red[2].setLocation(ob.pt[13]);
                six = six - 1;
                sr--;
                stater[2] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (red[2].getLocation().x == ob.pt[i].x && red[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 3);
            red[2].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (red[2].getLocation().x == ob.pt[i].x && red[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 3);
            red[2].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            nonsix = 0;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 3) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 4) {
                    ar1.setForeground(cy);
                    ar1.setText("Player 4");
                    highlight(4);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moverred4() {
        if (stater[3] == 1) {
            if (six > 0) {
                red[3].setLocation(ob.pt[13]);
                six = six - 1;
                sr--;
                stater[3] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (red[3].getLocation().x == ob.pt[i].x && red[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 3);
            red[3].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            ar2.setText("");
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (red[3].getLocation().x == ob.pt[i].x && red[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 3);
            red[3].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            nonsix = 0;
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                if (no == 3) {
                    ar1.setForeground(cb);
                    ar1.setText("Player 1");
                    highlight(1);
                }
                if (no == 4) {
                    ar1.setForeground(cy);
                    ar1.setText("Player 4");
                    highlight(4);
                }
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moveryellow1() {
        if (statey[0] == 1) {
            if (six > 0) {
                yellow[0].setLocation(ob.pt[39]);
                six = six - 1;
                sy--;
                statey[0] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (yellow[0].getLocation().x == ob.pt[i].x && yellow[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 4);
            yellow[0].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (yellow[0].getLocation().x == ob.pt[i].x && yellow[0].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 4);
            yellow[0].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cb);
                ar1.setText("Player 1");
                highlight(1);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moveryellow2() {
        if (statey[1] == 1) {
            if (six > 0) {
                yellow[1].setLocation(ob.pt[39]);
                six = six - 1;
                sy--;
                statey[1] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (yellow[1].getLocation().x == ob.pt[i].x && yellow[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 4);
            yellow[1].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (yellow[1].getLocation().x == ob.pt[i].x && yellow[1].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 4);
            yellow[1].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cb);
                ar1.setText("Player 1");
                highlight(1);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moveryellow3() {
        if (statey[2] == 1) {
            if (six > 0) {
                yellow[2].setLocation(ob.pt[39]);
                six = six - 1;
                sy--;
                statey[2] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (yellow[2].getLocation().x == ob.pt[i].x && yellow[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 4);
            yellow[2].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (yellow[2].getLocation().x == ob.pt[i].x && yellow[2].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 4);
            yellow[2].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cb);
                ar1.setText("Player 1");
                highlight(1);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    void moveryellow4() {
        if (statey[3] == 1) {
            if (six > 0) {
                yellow[3].setLocation(ob.pt[39]);
                six = six - 1;
                sy--;
                statey[3] = 0;
                j = six + "," + nonsix;
            }
        } else if (six > 0) {

            for (int i = 0; i < 52; i++) {
                if (yellow[3].getLocation().x == ob.pt[i].x && yellow[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + 6) % 52, 4);
            yellow[3].setLocation(ob.pt[(lx + 6) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            six -= 1;
            j = six + "," + nonsix;

        } else {
            for (int i = 0; i < 52; i++) {
                if (yellow[3].getLocation().x == ob.pt[i].x && yellow[3].getLocation().y == ob.pt[i].y) {
                    lx = i;
                }
            }
            checker = cancel((lx + nonsix) % 52, 4);
            yellow[3].setLocation(ob.pt[(lx + nonsix) % 52]);
            ar.setText("");
            ar2.setText("");
            for (int i = 0; i < 6; i++)
                lbl[i].setVisible(false);
            nonsix = 0;
            j = six + "," + nonsix;
        }
        if (six == 0 && nonsix == 0) {
            j = null;
            bt.setVisible(true);
            if (!checker) {
                ar1.setForeground(cb);
                ar1.setText("Player 1");
                highlight(1);
            } else {
                ar2.setText("Penality ! Roll Again !");
                k--;
                checker = false;
            }
        }
    }

    int counter = 0;
    int numb;

    boolean cancel(int num, int pno) {
        System.out.println("Reach 9999");
        if (num != 0 && num != 9 && num != 13 && num != 22 && num != 26 && num != 35 && num != 39 && num != 49) {
            if (pno != 1) {
                for (int i = 0; i < 4; i++) {
                    if (blue[i].getLocation().x == ob.pt[num].x && blue[i].getLocation().y == ob.pt[num].y) {
                        counter++;
                        numb = i;
                    }
                }
                if (counter == 1) {
                    blue[numb].setLocation(ob.hb[numb]);
                    stateb[numb] = 1;
                    sb++;
                    counter = 0;
                    return true;
                }
            }

            if (pno != 2) {
                for (int i = 0; i < 4; i++) {
                    if (green[i].getLocation().x == ob.pt[num].x && green[i].getLocation().y == ob.pt[num].y) {
                        counter++;
                        numb = i;
                    }
                }
                if (counter == 1) {
                    green[numb].setLocation(ob.hg[numb]);
                    stateg[numb] = 1;
                    sg++;
                    counter = 0;
                    return true;
                }
            }

            if (pno != 3) {
                for (int i = 0; i < 4; i++) {
                    if (red[i].getLocation().x == ob.pt[num].x && red[i].getLocation().y == ob.pt[num].y) {
                        counter++;
                        numb = i;
                    }
                }
                if (counter == 1) {
                    red[numb].setLocation(ob.hr[numb]);
                    stater[numb] = 1;
                    sr++;
                    counter = 0;
                    return true;
                }
            }

            if (pno != 4) {
                for (int i = 0; i < 4; i++) {
                    if (yellow[i].getLocation().x == ob.pt[num].x && yellow[i].getLocation().y == ob.pt[num].y) {
                        counter++;
                        numb = i;
                    }
                }
                if (counter == 1) {
                    yellow[numb].setLocation(ob.hy[numb]);
                    statey[numb] = 1;
                    sy++;
                    counter = 0;
                    return true;
                }
            }
        }
        System.out.println("Reach 88888");
        return false;
    }

    void highlight(int mm) {
        if (mm == 1) {
            for (int i = 0; i < 4; i++)
                blue[i].setLocation(blue[i].getLocation());
        }
        if (mm == 2) {
            for (int i = 0; i < 4; i++)
                green[i].setLocation(green[i].getLocation());
        }
        if (mm == 3) {
            for (int i = 0; i < 4; i++)
                red[i].setLocation(red[i].getLocation());
        }
        if (mm == 4) {
            for (int i = 0; i < 4; i++)
                yellow[i].setLocation(yellow[i].getLocation());
        }
    }
}