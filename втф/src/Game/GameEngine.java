package Game;

import Contracts.Updatable;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Nezife on 9/11/16.
 */
public class GameEngine implements Runnable, Updatable {
    private Thread thread;

    private boolean isRunning;

    private GameWindow dislay;

    private String title;
    private int width;
    private int height;

    private Graphics g;
    private BufferStrategy bs;

    public GameEngine(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void Init() {
        this.dislay = new GameWindow(this.title, this.width, this.height);
        this.dislay.getCanvas().createBufferStrategy(2);
        this.bs = this.dislay.getCanvas().getBufferStrategy(); //the count of buffers in canvas
        this.g = this.bs.getDrawGraphics();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g = this.bs.getDrawGraphics();
        g.clearRect(0, 0, this.width, this.height);
        this.bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        Init();

        while(isRunning) {
            tick();
            render(this.g);
        }

        Stop();


    }

    public synchronized void Start() {
        if (this.thread != null) {
            return;
        }

        this.isRunning = true;
        this.thread =  new Thread(this);
        this.thread.start();
    }

    public synchronized void Stop() {
        if (this.thread == null) {
            return;
        }

        this.isRunning = false;

        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
