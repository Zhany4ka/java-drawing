import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw extends JPanel {
    private int x, y;
    private int brushRadius = 5;
    private Color brushColor = Color.RED;

    public Draw() {
        setBackground(Color.WHITE);
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(brushColor);
        g.fillOval(x - brushRadius, y - brushRadius, brushRadius * 2, brushRadius * 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smooth Drawing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        Draw draw = new Draw();
        frame.add(draw);
        frame.setVisible(true);

        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(100, 500));
        colorPanel.setBackground(Color.LIGHT_GRAY);
        frame.add(colorPanel, BorderLayout.EAST);

        JButton colorButton1 = new JButton();
        colorButton1.setBackground(Color.RED);
        colorButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw.brushColor = Color.RED;
            }
        });
        colorPanel.add(colorButton1);

        JButton colorButton2 = new JButton();
        colorButton2.setBackground(Color.GREEN);
        colorButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw.brushColor = Color.GREEN;
            }
        });
        colorPanel.add(colorButton2);

        JButton colorButton3 = new JButton();
        colorButton3.setBackground(Color.BLUE);
        colorButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw.brushColor = Color.BLUE;
            }
        });
        colorPanel.add(colorButton3);

        JTextField radiusField = new JTextField(5);
        radiusField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw.brushRadius = Integer.parseInt(radiusField.getText());
            }
        });
        colorPanel.add(new JLabel("Radius:"));
        colorPanel.add(radiusField);
    }
}
