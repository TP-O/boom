package ui.text;

import core.main.Handler;
import helper.Helper;
import ui.Element;
import java.awt.Graphics;

public abstract class Text extends Element
{
    public Text(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    public void setValue(String value)
    {
        super.setValue(value);

        loadImages();
    }

    @Override
    protected void loadImages()
    {   
        // Delete old images
        images.clear();

        // Transform to uppercase
        value = value.toUpperCase();

        for(int i = 0; i < value.length(); i++) {
            images.add(Helper.loadImage("alphabet/" + value.charAt(i) + ".png"));
        }
    }

    @Override
    public void render(Graphics graphics)
    {
        // Calculate position x to make the text in the center
        int newX  = x - (value.length() - 1) * width / 2;

        for(int i = 0; i < images.size(); i++) {
            graphics.drawImage(images.get(i), newX + width * i, y, width, height, null);
        }
    }
}
