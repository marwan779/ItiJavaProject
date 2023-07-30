
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

}
