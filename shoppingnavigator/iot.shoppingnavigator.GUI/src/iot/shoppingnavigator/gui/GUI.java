package iot.shoppingnavigator.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
 
import java.awt.*;
import java.util.*;
 
 
/* Transformar JPanel em JFrame
 * JPanel causa alguns bugs no update da tela
 */
public class GUI extends JPanel {
        private final int H = 100; // grid height
        private final int W = 100; // grid weight
        JFrame f;
        Grid grid;
        Person person;
        Navigator nav;
        Vector <Button> options = null; // botoes com as opcoes
        // get person image
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image img1 = toolkit.getImage("person3.jpg");
       
        public Gui() {
                grid = new Grid(H, W);
                person = new Person(0, 0);
                nav = new Navigator();
                this.displayOptions();
        }
       
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                new GUI().display();
            }
        });
    }
   
    private void display() {
        f = new JFrame("MoveTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.add(this);
        f.add(new ControlPanel(), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
   
    private void displayOptions() {
        System.out.println("goiabinha");
        Vector <String> s = nav.getOptionFromCentral(); // string with options
        options.clear();
       
        for (int i = 0; i < s.size(); i++) {
                options.add(new Button());
                options.get(i).setLabel(s.get(i));
                f.add(options.get(i));
        }
    }
   
    //Vector <String> getOptionFromCentral() {
        // sendAnswerToCentral(String answer) {
   
    private class ControlPanel extends JPanel {
 
        private static final int DELTA = 10; // movement delta
 
        public ControlPanel() {
            this.setPreferredSize(new Dimension(640, 480));
            this.add(new MoveButton("\u2190", KeyEvent.VK_LEFT, -DELTA, 0));
            this.add(new MoveButton("\u2191", KeyEvent.VK_UP, 0, -DELTA));
            this.add(new MoveButton("\u2192", KeyEvent.VK_RIGHT, DELTA, 0));
            this.add(new MoveButton("\u2193", KeyEvent.VK_DOWN, 0, DELTA));
        }
       
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.blue);
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(8,
                BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
            //g.drawRect(p1.x, p1.y, HEIGHT, WIDTH);
            //g.fillRect(p1.x, p1.y, HEIGHT, WIDTH);
            int x = person.getX();
            int y = person.getY();
            g.drawImage(img1, x, y, this);  
           
        }
 
        private class MoveButton extends JButton {
 
            KeyStroke k;
            int dx, dy;
 
            public MoveButton(String name, int code, final int dx, final int dy) {
                super(name);
                this.k = KeyStroke.getKeyStroke(code, 0);
                this.dx = dx;
                this.dy = dy;
 
                this.setAction(new AbstractAction(this.getText()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int nx = person.getX() + dx;
                        int ny = person.getY() + dy;
                        person.setPos(nx,  ny);
                        GUI.this.repaint();
                        f.repaint();
 
                    }
                });
                ControlPanel.this.getInputMap(
                    WHEN_IN_FOCUSED_WINDOW).put(k, k.toString());
                ControlPanel.this.getActionMap().put(k.toString(), new AbstractAction() {
 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MoveButton.this.doClick();
                    }
                });
            }
        }
    }
}
 
 
 
