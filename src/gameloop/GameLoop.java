package gameloop;

import javafx.application.Platform;

public class GameLoop implements Runnable {

    public GameLoop(Controller controller) {
        this.controller = controller;
    }

    private Controller controller;

    private boolean running = false;
    private Thread thread;
    public static boolean logicUpdate = false;

    public synchronized void start()
    {
        if (running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop()
    {
        if(!running)
        {
            return;
        }

        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(1);
    }

    public void run()
    {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println(String.format("FPS: %s, updates: %s", frames, updates));
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {
        Platform.runLater(() -> controller.tick());
        if (logicUpdate)//alleen renderen als er een update is geweest;
        {
            logicUpdate = false;
            Platform.runLater(() -> controller.render());
        }
        else
        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
