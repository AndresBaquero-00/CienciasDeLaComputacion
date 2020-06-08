/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ochoreinas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Leeyn
 */
public class OchoReinas extends JFrame implements ActionListener, Runnable {

    /**
     * @param args the command line arguments
     */
    private static boolean q[] = new boolean[1];
    private static boolean[] a = new boolean[9];
    private static boolean[] b = new boolean[17];
    private static boolean[] c = new boolean[16];
    private static int[] x = new int[9];
    Thread hiloll = new Thread(this);

    public static void main(String[] args) {
        OchoReinas ck = new OchoReinas();
        ck.setSize(500, 600);
        ck.setVisible(true);
        ck.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    Color fondo;

    JButton bo = new JButton("Calcular");

    //--------------------------------------------------------
    ImageIcon image2 = new ImageIcon("RnB.png");
    JLabel Reina1 = new JLabel(image2);
    JLabel Reina2 = new JLabel(image2);
    JLabel Reina3 = new JLabel(image2);
    JLabel Reina4 = new JLabel(image2);
    JLabel Reina5 = new JLabel(image2);
    JLabel Reina6 = new JLabel(image2);
    JLabel Reina7 = new JLabel(image2);
    JLabel Reina8 = new JLabel(image2);

    //---------------------------------------------------------------
    static int ColumnaReina1, FilaReina1;
    static int ColumnaReina2, FilaReina2;
    static int ColumnaReina3, FilaReina3;
    static int ColumnaReina4, FilaReina4;
    static int ColumnaReina5, FilaReina5;
    static int ColumnaReina6, FilaReina6;
    static int ColumnaReina7, FilaReina7;
    static int ColumnaReina8, FilaReina8;

    OchoReinas() {
        fondo = getBackground();

        Container ck = getContentPane();
        ck.setLayout(null);
        ck.add(Reina1);
        ck.add(Reina2);
        ck.add(Reina3);
        ck.add(Reina4);
        ck.add(Reina5);
        ck.add(Reina6);
        ck.add(Reina7);
        ck.add(Reina8);

        ck.add(bo);

        ImageIcon image = new ImageIcon("Captura2.PNG");
        JLabel Tablero = new JLabel(image);
        ck.add(Tablero);
        Tablero.setBounds(10, 80, 400, 400);

        bo.setBounds(10, 30, 100, 20);
        bo.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == bo) {
            int h = 0;
            Reina1.setBounds((((9) * 39) + 50), (((FilaReina1) * 39) + 130), 39, 39);
            Reina2.setBounds((((9) * 25) + 10), (((FilaReina2) * 39) + 130), 39, 39);
            Reina3.setBounds((((9) * 25) + 10), (((FilaReina3) * 39) + 130), 39, 39);
            Reina4.setBounds((((9) * 25) + 10), (((FilaReina4) * 39) + 130), 39, 39);
            Reina5.setBounds((((9) * 25) + 10), (((FilaReina5) * 39) + 130), 39, 39);
            Reina6.setBounds((((9) * 25) + 10), (((FilaReina6) * 39) + 130), 39, 39);
            Reina7.setBounds((((9) * 25) + 10), (((FilaReina7) * 39) + 130), 39, 39);
            Reina8.setBounds((((9) * 25) + 10), (((FilaReina8) * 39) + 130), 39, 39);

            for (int i = 0; i < 9; i++) {
                a[i] = true;
            }
            for (int i = 0; i < 17; i++) {
                b[i] = true;
            }
            for (int i = 0; i < 16; i++) {
                c[i] = true;
            }

            hiloll.start();
            for (int i = 1; i < 9; i++) {
                System.out.println("(" + (i) + ", " + x[i] + ")");
            }

        }
    }

    public void intentar(int i, boolean q[]) {
        int j = 0;
        
        do {
            j++;
            q[0] = false;
            if (a[j] && b[i + j] && c[i - j + 7]) {
                x[i] = j;
                a[j] = false;
                b[i + j] = false;
                c[i - j + 7] = false;

                if (i < 8) {
                    intentar(i + 1, q);
                    if (q[0] == false) {
                        a[j] = true;
                        b[i + j] = true;
                        c[i - j + 7] = true;
                    }
                } else {
                    q[0] = true;
                }
            }
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                Logger.getLogger(OchoReinas.class.getName()).log(Level.SEVERE, null, e);
            }

            ColumnaReina1 = x[1];
            ColumnaReina2 = x[2];
            ColumnaReina3 = x[3];
            ColumnaReina4 = x[4];
            ColumnaReina5 = x[5];
            ColumnaReina6 = x[6];
            ColumnaReina7 = x[7];
            ColumnaReina8 = x[8];

            Reina1.setLocation((((ColumnaReina1) * 39) + 19), ((0 * 39) + 130));
            Reina2.setLocation((((ColumnaReina2) * 39) + 17), ((1 * 39) + 123));
            Reina3.setLocation((((ColumnaReina3) * 39) + 16), ((2 * 39) + 122));
            Reina4.setLocation((((ColumnaReina4) * 39) + 15), ((3 * 39) + 122));
            Reina5.setLocation((((ColumnaReina5) * 39) + 19), ((4 * 39) + 124));
            Reina6.setLocation((((ColumnaReina6) * 39) + 15), ((5 * 39) + 120));
            Reina7.setLocation((((ColumnaReina7) * 39) + 19), ((6 * 39) + 120));
            Reina8.setLocation((((ColumnaReina8) * 39) + 17), ((7 * 39) + 120));
        } while (j != 8 && q[0] == false);
    }

    @Override
    public void run() {
        q[0] = true;
        intentar(1, q);
        JOptionPane.showMessageDialog(null, "1:"+ColumnaReina1+"\n"+"2:"+ColumnaReina2+"\n"+"3:"+ColumnaReina3+"\n"+"4:"+ColumnaReina4+"\n"
          +"5:"+ColumnaReina5+"\n"+"6:"+ColumnaReina6+"\n"+"7:"+ColumnaReina7+"\n"+"8:"+ColumnaReina8+"\n");
    }
}
