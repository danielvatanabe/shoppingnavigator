package iot.shoppingnavigator.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.*;
 
/**
 * @see http://stackoverflow.com/questions/6991648
 * @see http://stackoverflow.com/questions/6887296
 * @see http://stackoverflow.com/questions/5797965
 */
public class Person {
        private int x;
        private int y;
       
        // constructors
        public Person() {
        }
        public Person(int x, int y) {
                this.x = x;
                this.y = y;
        }
       
        // methods
        int getX() {
                return x;
        }
        int getY() {
                return y;
        }
        void setPos(int x, int y) {
                this.x = x;
                this.y = y;
        }
}
