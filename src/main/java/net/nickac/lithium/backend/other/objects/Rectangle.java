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
 *
 */

package net.nickac.lithium.backend.other.objects;

/**
 * Created by NickAc for Lithium!
 */
public class Rectangle {
	public Rectangle(Point corner, Dimension size) {
		this.corner = corner;
		this.size = size;
	}

	public Rectangle(int x, int y, int width, int height) {
		this.corner = new Point(x, y);
		this.size = new Dimension(width, height);
	}

	private Point corner = Point.EMPTY;
	private Dimension size = Dimension.EMPTY;

	public static Rectangle fromLTRB(int left, int top, int right, int bottom) {
		return new Rectangle(left, top, right - left, bottom - top);
	}

	public int getX() {
		return corner.getX();
	}

	public int getY() {
		return corner.getY();
	}

	public int getWidth() {
		return size.getWidth();
	}

	public int getHeight() {
		return size.getHeight();
	}

	public int getTop() {
		return corner.getY();
	}

	public int getRight() {
		return corner.getX() + size.getWidth();
	}

	public int getBottom() {
		return corner.getY() + size.getHeight();
	}

	public int getLeft() {
		return corner.getX();
	}

	public Rectangle inflate(int x, int y) {
		return new Rectangle(corner.getX() - x, corner.getY() - y, size.getWidth() + x * 2, size.getHeight() + y * 2);
	}

	public boolean contains(Point p) {
		return p.getX() >= getLeft() && p.getX() <= getRight() && p.getY() >= getTop() && p.getY() <= getBottom();
	}

}
