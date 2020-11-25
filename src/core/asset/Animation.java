package core.asset;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation
{    
    private int speed, index;
    private long lastTime, timer;
    private ArrayList<BufferedImage> frames;

    public Animation(int speed, ArrayList<BufferedImage> frames)
    {
        this.speed = speed;
        this.frames = frames;
        this.index = 0;
        this.timer = 0;
        this.lastTime = System.currentTimeMillis();
    }

    public void tick()
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed)
        {
            index++;
            timer = 0;

            if (index >= frames.size()) {
                index = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame()
    {
        return frames.get(index);
    }
}
