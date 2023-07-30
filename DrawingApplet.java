
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
           //the buttons
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
        clearButton = new Button("Clear"); // this button erases everthing and restore the white background
            // the action listeners
        rectButton.addActionListener(this);
        circleButton.addActionListener(this);
        ovalButton.addActionListener(this);
        lineButton.addActionListener(this);
        yellowButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);
        fillButton.addActionListener(this);
        eraseButton.addActionListener(this);
        increaseButton.addActionListener(this);
        decreaseButton.addActionListener(this);
       clearButton.addActionListener(this);

  	// the panel 
  	 topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(rectButton);
        topPanel.add(circleButton);
        topPanel.add(ovalButton);
        topPanel.add(lineButton);
        topPanel.add(yellowButton);
        topPanel.add(blueButton);
        topPanel.add(greenButton);
        topPanel.add(fillButton);
        topPanel.add(eraseButton);
        topPanel.add(increaseButton);
        topPanel.add(decreaseButton);
	topPanel.add(clearButton);

        add(topPanel, BorderLayout.NORTH);
        addMouseListener(this);
        addMouseMotionListener(this);
 }
/*____________________________________________*/
	 public void actionPerformed(ActionEvent e) {
         if (e.getSource() == rectButton) {
            currentShape = "rectangle";
         } 
	 else if (e.getSource() == circleButton) {
            currentShape = "circle";
       }
	 else if (e.getSource() == ovalButton) {
            currentShape = "oval";
	
       } 
	 else if (e.getSource() == lineButton) {
            currentShape = "line";				
        }
		 
	 }
	



	public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        if (currentShape.equals("line")) {
            isDrawing = true;
        }
    }
	public void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        if (currentShape.equals("rectangle")) {
            drawRectangle();
        } else if (currentShape.equals("circle")) {
            drawCircle();
        } else if (currentShape.equals("oval")) {
            drawOval();
        }
        isDrawing = false;
        isErasing = false;
    }
	
	
	public void mouseDragged(MouseEvent e) {
        if (isDrawing) {
            endX = e.getX();
            endY = e.getY();
            drawLine();
            startX = endX;
            startY = endY;
        } else if (isErasing) {
            int x = e.getX();
            int y = e.getY();
            eraseObject(x, y);
        }
    }
	 public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}


	
 private void drawRectangle() {
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        int width = Math.abs(startX - endX);
        int height = Math.abs(startY - endY);
        Graphics g = getGraphics();
        g.setColor(currentColor);
        g.drawRect(x, y, width, height);
    }
 private void drawCircle() {
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        int width = Math.abs(startX - endX);
        int height = Math.abs(startY - endY);
        int diameter = Math.min(width, height);
        Graphics g = getGraphics();
        g.setColor(currentColor);
        g.drawOval(x, y, diameter, diameter);
    }
    private void drawOval() {
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        int width = Math.abs(startX - endX);
        int height = Math.abs(startY - endY);
        Graphics g = getGraphics();
        g.setColor(currentColor);
        g.drawOval(x, y, width, height);
    }
    private void drawLine() {
        Graphics g = getGraphics();
        g.setColor(currentColor);
        ((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
        g.drawLine(startX, startY, endX, endY);
    }
 private void fillShape() {
	  Graphics g = getGraphics();
        g.setColor(currentColor);
        if (currentShape.equals("rectangle")) {
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);
            int width = Math.abs(startX - endX);
            int height = Math.abs(startY - endY);
            g.fillRect(x, y, width, height);
	}
	else if (currentShape.equals("circle")) {
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);
            int width = Math.abs(startX - endX);
            int height = Math.abs(startY - endY);
            int diameter = Math.min(width, height);
            g.fillOval(x, y, diameter, diameter);
        } 
	 else if (currentShape.equals("oval")) {
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);
            int width = Math.abs(startX - endX);
            int height = Math.abs(startY - endY);
            g.fillOval(x, y, width, height);
        }
	 
 
 }
    


	


private void eraseObject(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.drawLine(x - 5, y - 5, 10, 10);
    }
private void clearCanvas() {
Graphics g = getGraphics();
g.setColor(Color.WHITE);
g.fillRect(0, 0, 10000, 10000);
g.setColor(currentColor);
}
}
