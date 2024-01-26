import java.awt.Frame;

/**
 * GUI: Graphical user interface 
 * Two sets of java API's we have for make gui appliactions in java:-
 *      1. AWT (Abstract Window Toolkit)
 *      2. Swing => latest one 
 * AWT:-
 *  1. Its is platform dependent, means it use the some components of underlying operating system.
 *     means its apperaence may varry from system to system (across platform).
 *  2. Components in AWT are thin wrappers around native components, their availability dpends on underlying platform.
 *     example:- button in awt is essentially native button on the OS.
 *  3. AWT is gernally Faster, better performance in term of speed than Swing since AWT depends on native components,
 *     AWT Look and Feel may be inconsistent as components are inherits properties of native components in OS. 
 *     i.e. less customiztion options in GUI.
 *  4. AWT have less customiztion options over components developer have less options for customization. 
 *  5. AWT is easier to learn and have samller set of component than swing.
 *     Missing Component in awt is :- radio button.
 * 
 * 
 * Swing:-
 *  1. Its is platform independent, as Swing is made entirely in java.
 *  2. Components are written in java, therefore not depends on navtive components of OS.
 *     provide richer set of controls and customization options.
 *  3. Swing componets are potentially slower due to pure java nature offers modern and flexible architecture, highly customizable 
 *     and feature-rich inetrfaces.
 *  4. highly customizable, allow more polished and more ;peofessional appearence.
 *  5. Is complex to learn than AWT, provide richer set of fetures. And more commonly used in modern JAVA GUI development.
 * 
 * ===========================================================================================================================================
 * 
 *********************************AWT***********************************************
 * AWT consists of 12 pacakages.
 * AWT is under "java.awt" package and "java.awt.event" these two are commonly used.
 * 
 * In AWT java.awt,
 * GUI Components classes:-  Button, TextArea, TextFeild, Label
 * GUI Container classes:- Frame, ScrollPane, Dialog, Panel
 * GUI Layout Managers:- FlowLayout, GridLayout, BorderLayout
 * Custom Graphic classes:- Graphics, Color,Font
 * 
 * Frame -> is a top level container,  frame have title bar 
 * (containing title , icon, minimizing, maximizing, close buttons, optional menu bar and content display area.)
 * 
 * Panel -> its is a rectangular area used to group similar GUI components.
 * 
 * "Every Component must kept inside a conatiner, and Every container have an option to add componet is called add(component)"
 * ----------------------------------------------------------------------------------------------------------------------------------------
 * In AWT java.awt.event,
 * Event Listeners for event handling :-
 * Event Classes -> ActionEvent, MouseEvent, KeyEvent, WindowEvent.
 * Event Listener Interfaces -> ActionListener, MouseListener, WinodwListener, KeyListener.
 * 
 * EXAMPLES:-
 * 
        import java.awt.*;
        import java.awt.event.*;

        // Class to handle mouse events and change background color
        class Mouse implements MouseListener {
            public Frame fm;
        
            public Mouse() {
                fm = new Frame();
                fm.addMouseListener(this);
                fm.setSize(500, 500);
                fm.setVisible(true);
                fm.setBackground(Color.BLACK);
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                fm.setBackground(Color.RED);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                fm.setBackground(Color.BLUE);
            }
        
            @Override
            public void mouseClicked(MouseEvent e) {
                Dialog dg = new Dialog(fm, "Message", true);
                dg.add(new Label("This Mouse Clicked Event"));
                dg.setSize(100, 150);
                dg.setVisible(true);
            }
        
            @Override
            public void mousePressed(MouseEvent e) {
                // Unimplemented method 'mousePressed'
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
                // Unimplemented method 'mouseReleased'
            }
        }

        // Class to change background color on button click
        class Action extends Frame implements ActionListener {
            public Action() {
                setSize(500, 600);
                setBackground(Color.RED);
                setLayout(null);
                setVisible(true);
            
                Button btn = new Button("Click Me");
                btn.setLocation(100, 300);
                btn.setSize(200, 100);
                add(btn);
            
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
                        setBackground(Color.DARK_GRAY);
                    }
                });
            }
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // Unimplemented method 'actionPerformed'
            }
        }

        // Class to change text field appearance and display label on mouse exit
        class TextFeil implements MouseListener {
            public Frame fm;
            TextField txt1;
        
            public TextFeil() {
                fm = new Frame();
                fm.setSize(300, 600);
                fm.setLayout(null);
                fm.setVisible(true);
            
                txt1 = new TextField();
                txt1.setLocation(100, 200);
                txt1.setSize(200, 100);
                fm.add(txt1);
                txt1.addMouseListener(this);
            }
        
            @Override
            public void mouseClicked(MouseEvent e) {
                txt1.setBackground(Color.DARK_GRAY);
                txt1.setForeground(Color.WHITE);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                txt1.setBackground(Color.WHITE);
                txt1.setForeground(Color.BLACK);
            
                // Retrieve text from text field and display it in a label
                String text = txt1.getText();
                Label lb = new Label(text);
                lb.setLocation(250, 200);
                lb.setSize(100, 200);
                fm.add(lb);
            }
        
            @Override
            public void mousePressed(MouseEvent e) {
                // Unimplemented method 'mousePressed'
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
                // Unimplemented method 'mouseReleased'
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                // Unimplemented method 'mouseEntered'
            }
        }

        public class GUI {
            public static void main(String[] args) {
                // Uncomment the line corresponding to the class you want to test
                // new TextFeil();
                // new Action();
                // new Mouse();
            }
        }
 
 *  Listeners :-
 *              They are interfaces and you need to implement all the methods of the inetface, even if you donot use them all.
 *  Adapters:- 
 *              They are abstract classes that provide default(empty) implementations, allowing you to override only the methods you need.
 *              They are more covenient when you are handling the subset of the events.
 * 
 * */



/* Different layouts are:-
 * 1) Flow Layout = places components left to right and top to bottom.
 *                  Components are arranged in a row until the row is filled, and then a new row is started.
 *                  Arranging the components is in natural order, simple.      
 * 
 * 2) Border Layout = it divides the container into five regions NORTH, SOUTH, WEST, EAST, CENTRE.
 *                    Each region can contain only one component.
 *  
 * 3) Grid Layout = it divide the container into grids rows and columns.
 *                  All components of same size.
 *  
 * 4) Box Layout = import javax.swing.BoxLayout;
 *                 it place the components either in vertical or horizontal direction.
 *                 it is useful when u wants to put all components in particular directions.
 * 
 * EXAMPLE:- 

        import java.awt.*;

        import javax.swing.BoxLayout;

        class FlowLayoutExample extends Frame{
            public FlowLayoutExample(){
            
                setSize(300,300);
                setLayout(new FlowLayout());
            
                Button b;
                for(int i=1; i <= 50; i++){
                    b = new Button("" + i);
                    b.setSize(30,30);
                    add(b);
                }

                setVisible(true);
            }
        }

        class BoxLayoutExample extends Frame{
            public BoxLayoutExample(){
            
                setSize(300,300);
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //BoxLayout(Container target, int axis)
            
                Button b;
                for(int i=1; i <= 50; i++){
                    b = new Button("" + i);
                    b.setSize(30,30);
                    add(b);
                }

                setVisible(true);
            }
        }

        class BorderLayoutExample extends Frame{
            public BorderLayoutExample(){
            
                setSize(300,300);
                setLayout(new BorderLayout()); //BoxLayout(Container target, int axis)
            
                Button b;
                b = new Button("NORTH");
                add(b, BorderLayout.NORTH);
            
                b = new Button("CENTER");
                add(b, BorderLayout.CENTER);

                b = new Button("EAST");
                add(b, BorderLayout.EAST);
            
                b = new Button("WEST");
                add(b, BorderLayout.WEST);
            
                b = new Button("SOUTH");
                add(b, BorderLayout.SOUTH);
            
                setVisible(true);
            }
        }

        class GridLayoutExample {
            public GridLayoutExample(){
                Frame frame = new Frame("GridLayout Example");
                frame.setLayout(new GridLayout(3, 2));
            
                for (int i = 1; i <= 6; i++) {
                    frame.add(new Button("Button " + i));
                }
            
                frame.setSize(300, 200);
                frame.setVisible(true);
            }
        }

        public class GUI{
            public static void main(String [] args){
                new GridLayoutExample();
                //new BorderLayoutExample();
                //new BoxLayoutExample();
                //new FlowLayoutExample();
            }
        }
*/

import java.awt.*;
import java.awt.event.*;

class ListExample extends Frame implements ItemListener {
    Choice l;

   public ListExample(){
    setSize(200,300);
    l = new Choice();
    l.add("Red");
    l.add("Orange");
    l.add("Yellow");
    l.add("Green");
    l.add("Blue");
    l.add("Indigo");
    l.add("Violet");
    l.addItemListener(this);
    add(l);
    setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        System.out.println("Index of Selected: "+ l.getSelectedIndex());
        
    }
}

class Mouse extends MouseMotionAdapter{
    Frame f;

    public Mouse(){
        f = new Frame();

        f.setSize(300,400);

        f.addMouseMotionListener(this);

        f.setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e){
        f.setBackground(Color.BLACK);
    }

    public void mouseDragged(MouseEvent e){
        f.setBackground(Color.GRAY);
    }
}

class Counter extends Frame implements ActionListener {
    Button b;
    Label l;
    int clicks = 0;

    public Counter(){
        setSize(700, 700);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
               dispose();
            }
        });

        b = new Button("Click Me");
        b.addActionListener(this);
        add(b, BorderLayout.NORTH);

        l = new Label("No. of Clicked: " + clicks);
        add(l, BorderLayout.SOUTH);     
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        clicks++;
        l.setText("No. of Clicked: " + clicks);
    }

}
 public class GUI{
            public static void main(String [] args){
                new Counter();
                //new Mouse();
            }
        }



 /*
import java.awt.*;
import java.awt.event.*;

class Grid extends Frame implements ActionListener {
    Label txt;

    Grid() {
        setLayout(null);
        setSize(500, 650);
        setVisible(true);

        txt = new Label();
        txt.setSize(500, 100);
        txt.setLocation(10, 10);
        add(txt);

        Panel p = new Panel();
        p.setBackground(Color.PINK);
        p.setSize(500, 500);
        p.setLocation(10, 120);
        p.setLayout(new GridLayout(0, 3)); // 0 means no. of rows depends on no. of components
        p.setVisible(true);
        add(p);

        Button b;
        Label l;

        String components[] = {
                "1", "2", "+",
                "3", "4", "-",
                "5", "6", "/",
                "7", "8", "*",
                "9", "0", "C",
                "", "", "="
        };

        for (String c : components) {
            b = new Button(c);
            b.addActionListener(this);
            p.add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button cb = (Button) e.getSource();
        String value = cb.getLabel();
        if (value == "C") {
            txt.setText("");
        } else if (value == "=") {
            evaluate(txt.getText());
        } else {
            txt.setText(txt.getText() + " " + value);
        }
    }

    public void evaluate(String exp) {
        String[] values = exp.split(" ");
        double result = Double.parseDouble(values[1]);

        for (int i = 2; i < values.length; i += 2) {
            System.out.println(result);
            System.out.println(Double.parseDouble(values[i + 1]) + result);
            if (values[i] == "+") {
                result = Double.parseDouble(values[i + 1]) + result;
            } else if (values[i] == "*") {
                result = Double.parseDouble(values[i + 1]) * result;
            } else if (values[i] == "/") {
                result = result / Double.parseDouble(values[i + 1]);
            } else if (values[i] == "-") {
                result = result - Double.parseDouble(values[i + 1]);
            }    
            txt.setText(String.valueOf(result));
        }

    }
}

public class GUI {
    public static void main(String[] args) {
        new Grid();
    }
}
*/
