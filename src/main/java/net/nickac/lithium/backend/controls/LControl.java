/*
 * MIT License
 *
 * Copyright (c) 2017 NickAc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.nickac.lithium.backend.controls;

import net.nickac.lithium.backend.other.LithiumConstants;
import net.nickac.lithium.backend.other.objects.Dimension;
import net.nickac.lithium.backend.other.objects.Point;

import java.util.UUID;

/**
 * This is the base control for Lithium.
 * All Lithium controls must extend this class
 */
public abstract class LControl implements ILithiumControl {

    private CenterOptions centerOptions = CenterOptions.NONE;
    private LContainer parent;
    private UUID uuid;
    private String text;
    private Dimension size = Dimension.EMPTY;
    private Point location = Point.EMPTY;
    private transient Object tag;

    public abstract boolean canReceiveUserInput();

    public CenterOptions getCentered() {
        return centerOptions;
    }

    public LControl setCentered(CenterOptions options) {
        centerOptions = options;
        return this;
    }

    @Override
    public LContainer getParent() {
        return parent;
    }

    @Override
    public void setParent(LContainer parent) {
        this.parent = parent;
    }

    @Override
    public UUID getUUID() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
        return uuid;
    }

    @Override
    public String getText() {
        return text != null ? text : "";
    }

    @Override
    public LControl setText(String text) {
        this.text = text;
        refresh();
        return this;
    }

    @Override
    public Dimension getSize() {
        return size != null ? size : Dimension.EMPTY;
    }

    @Override
    public LControl setSize(Dimension size) {
        this.size = size;
        refresh();
        return this;
    }

    @Override
    public Point getLocation() {
        return location != null ? location : Point.EMPTY;
    }

    @Override
    public ILithiumControl setLocation(Point loc) {
        location = loc;
        refresh();
        return this;
    }

    @Override
    public int getLeft() {
        int parentOffset = getParent() != null && getParent() instanceof LControl ? ((LControl) getParent()).getLeft() : 0;

        return parentOffset + location.getX();
    }

    @Override
    public int getRight() {
        return getLeft() + size.getWidth();
    }

    @Override
    public int getTop() {
        int parentOffset = getParent() != null && getParent() instanceof LControl ? ((LControl) getParent()).getTop() : 0;
        return parentOffset + location.getY();
    }

    @Override
    public int getBottom() {
        return getTop() + size.getHeight();
    }

    @Override
    public void refresh() {
        try {
            if (LithiumConstants.onRefresh != null && parent != null && parent.getViewer() != null) {
                LithiumConstants.onRefresh.onRefresh(parent.getViewer(), this);
            }

        } catch (NullPointerException ex) {
            //Sorry! I had to do this....
        }
    }

    @Override
    public void dispose() {
        //TODO: Make global Implementation to handle this
        if (getParent() != null) {
            getParent().removeControl(this);
        }
    }

    @Override
    public Object getTag() {
        return tag;
    }

    @Override
    public LControl setTag(Object tag) {
        this.tag = tag;
        return this;
    }
}
