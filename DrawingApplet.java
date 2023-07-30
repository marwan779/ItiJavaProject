
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingApplet extends Applet implements ActionListener, MouseListener, MouseMotionListener  {
 private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 400;

    private Panel topPanel;
    private Button rectButton, circleButton, ovalButton, lineButton, yellowButton, blueButton, greenButton, fillButton, eraseButton, increaseButton, decreaseButton,clearButton;
    private Color currentColor = Color.BLACK;
    private String currentShape = "";
    private int startX, startY, endX, endY, lineWidth = 1;
    private boolean isDrawing = false;
    private boolean isErasing = false;   
    public void init() 
 {       setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        rectButton = new Button("Rectangle");
        circleButton = new Button("Circle");
        ovalButton = new Button("Oval");
        lineButton = new Button("Line");
        yellowButton = new Button();
        yellowButton.setBackground(Color.YELLOW);
        blueButton = new Button();
        blueButton.setBackground(Color.BLUE);
        greenButton = new Button();
        greenButton.setBackground(Color.GREEN);
        fillButton = new Button("Fill");
        eraseButton = new Button("Eraser");
        increaseButton = new Button("Increase Thickness"); // the increase and decrease buttons can cotrol the Thickness of the lines and the eraser also 
        decreaseButton = new Button("Decrease Thickness");  
        clearButton = new Button("Clear");


 }

}
