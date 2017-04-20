
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 *
 * @author ylhaart
 */
public class Painting extends JPanel {

    private int drawingWidth = 400;
    private int drawingHeight = 400;
    private int eyeballHeight = 150;
    private int eyeballWidthMargin = 125;
    private int eyeballOuterRadius = 50;
    private int eyeballInnerRadius = 20;

    private Eye[] eyes;

    public Painting() {
        this.addMouseMotionListener(new EyeballListener(eyeballOuterRadius, eyeballInnerRadius, this, eyes));
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(drawingWidth, drawingHeight));

        this.eyes = new Eye[2];
        this.eyes[0] = new Eye(new Point(eyeballWidthMargin, eyeballHeight));
        this.eyes[1] = new Eye(new Point(drawingWidth - eyeballWidthMargin,
                eyeballHeight));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        for (Eye eye : eyes) {
            drawCircle(g, eye.getOrigin(), eyeballOuterRadius);
            fillCircle(g, eye.getEyeballOrigin(), eyeballInnerRadius);
        }

//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        int size = Math.min(getWidth(), getHeight()) / 2;
//        g2.setColor(Color.black);
//
////        g2.scale(size / 16.0, size / 16.0);
//        g2.draw(new Ellipse2D.Double(2, 2, size * 2, size * 2));
//
//        drawEye(g2, size);
//        g2.translate(size, 0);
//        drawEye(g2, size);
    }

    private void drawCircle(Graphics g, Point origin, int radius) {
        g.drawOval(origin.x - radius, origin.y - radius, radius + radius,
                radius + radius);
    }

    private void fillCircle(Graphics g, Point origin, int radius) {
        g.fillOval(origin.x - radius, origin.y - radius, radius + radius,
                radius + radius);
    }

//    private void drawEye(Graphics2D g2, int size) {
//        AffineTransform transform = g2.getTransform();
//        g2.scale(size / 16.0, size / 16.0);
//        g2.fill(new Ellipse2D.Double(7, 7, 2, 2));
//        g2.draw(new Ellipse2D.Double(4, 4, 8, 8));
//        g2.setTransform(transform);
//    }
}
