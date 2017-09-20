package Contracts;

import java.awt.*;

/**
 * Created by Nezife on 9/11/16.
 */
public interface Updatable {
    public abstract void tick();
    public  abstract void render(Graphics g);
}
