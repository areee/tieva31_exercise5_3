
import java.awt.Point;

/**
 *
 * @author ylhaart
 */
public class Eye {

    private final Point origin;
    private Point eyeballOrigin;

    public Eye(Point origin) {
        this.origin = origin;
        this.eyeballOrigin = origin;
    }

    public Point getEyeballOrigin() {
        return eyeballOrigin;
    }

    public void setEyeballOrigin(Point eyeballOrigin) {
        this.eyeballOrigin = eyeballOrigin;
    }

    public Point getOrigin() {
        return origin;
    }

}
