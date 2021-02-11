package assignment5.lib;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRoundRect;
import acm.util.ErrorException;

import java.awt.*;

class GDie extends GCompound implements YahtzeeDisplayConstants {
    private int dieValue;
    private boolean highlighted;

    public GDie() {
        this.set(0);
    }

    public void set(int pips) {
        this.dieValue = pips;
        this.removeAll();
        this.createOutline(this.highlighted ? YahtzeeDisplayConstants.PIP_COLOR : YahtzeeDisplayConstants.DIE_COLOR);
        if (pips == 0) {
            this.createQuestionMark();
        } else {
            this.createPips(pips);
        }

    }

    public void setHighlighted(boolean flag) {
        this.highlighted = flag;
        this.set(this.dieValue);
    }

    public boolean isHighlighted() {
        return this.highlighted;
    }

    private void createOutline(Color bgcolor) {
        GRoundRect outline = new GRoundRect(0.0D, 0.0D, 44.0D, 44.0D, 18.0D);
        outline.setColor(YahtzeeDisplayConstants.PIP_COLOR);
        outline.setFilled(true);
        outline.setFillColor(bgcolor);
        this.add(outline);
    }

    private void createQuestionMark() {
        GLabel label = new GLabel("?");
        label.setColor(YahtzeeDisplayConstants.PIP_COLOR);
        label.setFont(YahtzeeDisplayConstants.QUESTION_MARK_FONT);
        this.add(label, (44.0D - label.getWidth()) / 2.0D, (44.0D + label.getAscent()) / 2.0D - 1.0D);
    }

    private void createPips(int pips) {
        switch(pips) {
            case 0:
                break;
            case 1:
                this.createPip(2, 2);
                break;
            case 2:
                this.createPip(3, 1);
                this.createPip(1, 3);
                break;
            case 3:
                this.createPip(3, 1);
                this.createPip(2, 2);
                this.createPip(1, 3);
                break;
            case 4:
                this.createPip(1, 1);
                this.createPip(1, 3);
                this.createPip(3, 1);
                this.createPip(3, 3);
                break;
            case 5:
                this.createPip(1, 1);
                this.createPip(1, 3);
                this.createPip(2, 2);
                this.createPip(3, 1);
                this.createPip(3, 3);
                break;
            case 6:
                this.createPip(1, 1);
                this.createPip(1, 2);
                this.createPip(1, 3);
                this.createPip(3, 1);
                this.createPip(3, 2);
                this.createPip(3, 3);
                break;
            default:
                throw new ErrorException("Illegal die value = " + pips);
        }

    }

    private void createPip(int col, int row) {
        double x = 22.0D + 0.27D * (double)(col - 2) * 44.0D;
        double y = 22.0D + 0.27D * (double)(row - 2) * 44.0D + 1.0D;
        GOval pip = new GOval(10.0D, 10.0D);
        pip.setFilled(true);
        pip.setColor(this.highlighted ? YahtzeeDisplayConstants.DIE_COLOR : YahtzeeDisplayConstants.PIP_COLOR);
        this.add(pip, x - 5.0D, y - 5.0D);
    }
}
