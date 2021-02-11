package assignment5.lib;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.util.ErrorException;

import java.awt.*;

class GScorecardEntry extends GCompound implements YahtzeeDisplayConstants {
    private GRect box;
    private GLabel label;
    private int myCategory;
    private int alignment;
    private boolean highlighted;
    private Color highlightColor;
    private Color textColor;
    private Color backgroundColor;

    public GScorecardEntry(double width, double height, int category) {
        this.myCategory = category;
        this.box = new GRect(width, height);
        this.box.setFilled(true);
        this.label = new GLabel("");
        this.highlighted = false;
        this.add(this.box);
        this.add(this.label);
        this.setHighlightColor(YahtzeeDisplayConstants.STANDARD_HIGHLIGHT);
        this.setTextColor(Color.black);
        this.setBackgroundColor(Color.white);
        this.setHighlighted(false);
        this.setAlignment(2);
    }

    public void setLabel(String str) {
        this.label.setLabel(str);
        double x = this.getXCoordinate();
        double y = (this.box.getHeight() + this.label.getAscent()) / 2.0D - 1.0D;
        this.label.setLocation(x, y);
        this.setHighlighted(this.highlighted);
    }

    public void setHighlighted(boolean flag) {
        this.highlighted = flag;
        if (this.highlighted) {
            this.label.setColor(this.highlightColor == YahtzeeDisplayConstants.STANDARD_HIGHLIGHT ? Color.black : Color.white);
            this.box.setFillColor(this.highlightColor);
        } else {
            this.label.setColor(this.textColor);
            this.box.setFillColor(this.backgroundColor);
        }

    }

    public int getCategory() {
        return this.myCategory;
    }

    public boolean isHighlighted() {
        return this.highlighted;
    }

    public void setAlignment(int align) {
        this.alignment = align;
    }

    public void setFont(Font font) {
        this.label.setFont(font);
    }

    public void setHighlightColor(Color color) {
        this.highlightColor = color;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    private double getXCoordinate() {
        switch(this.alignment) {
            case 0:
                return 4.0D;
            case 1:
                return 18.0D;
            case 2:
                return (this.box.getWidth() - this.label.getWidth()) / 2.0D;
            case 3:
                return 0.65D * this.box.getWidth() - this.label.getWidth();
            default:
                throw new ErrorException("Illegal alignment");
        }
    }
}
