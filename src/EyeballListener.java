
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
 *
 * @author ylhaart
 */
public class EyeballListener extends MouseMotionAdapter {

    private int eyeballOuterRadius;
    private int eyeballInnerRadius;
    private JPanel panel;
    private Eye[] eyes;

    public EyeballListener(int eyeballOuterRadius, int eyeballInnerRadius, JPanel panel, Eye[] eyes) {
        this.eyeballOuterRadius = eyeballOuterRadius;
        this.eyeballInnerRadius = eyeballInnerRadius;
        this.panel = panel;
        this.eyes = eyes;
    }

    private double eyeballDistance = eyeballOuterRadius - eyeballInnerRadius - 5;

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        for (Eye eye : eyes) {
            Point origin = eye.getOrigin();
            double theta = Math.atan2((double) (p.y - origin.y), (double) (p.x - origin.x));
            int x = (int) Math.round(Math.cos(theta) * eyeballDistance) + origin.x;
            int y = (int) Math.round(Math.sin(theta) * eyeballDistance) + origin.y;
            eye.setEyeballOrigin(new Point(x, y));
        }
        panel.repaint();
    }

}
