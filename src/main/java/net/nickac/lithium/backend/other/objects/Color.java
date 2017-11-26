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

package net.nickac.lithium.backend.other.objects;

import java.io.Serializable;

/**
 * Created by NickAc for Lithium!
 */
@SuppressWarnings("ALL")
public class Color implements Serializable {

	private Color(int red, int green, int blue) {
		this(255, red, green, blue);
	}

	private Color(int alpha, int red, int green, int blue) {
		this.alpha = Math.min(alpha, 255);
		this.red = Math.min(red, 255);
		this.green = Math.min(green, 255);
		this.blue = Math.min(blue, 255);

	}

	public transient static Color RED = new Color(255, 0, 0);
	public transient static Color GREEN = new Color(0, 255, 0);
	public transient static Color DARK_GREEN = new Color(3, 85, 47);
	public transient static Color BLUE = new Color(0, 0, 255);
	public transient static Color WHITE = new Color(255, 255, 255);
	public transient static Color GRAY = new Color(128, 128, 128);
	public transient static Color BLACK = new Color(0, 0, 0);
	private int alpha = 255;
	private int red = 0;
	private int green = 0;
	private int blue = 0;

	public static Color fromRGB(int red, int green, int blue) {
		return new Color(red, green, blue);
	}

	public static Color fromARGB(int alpha, int red, int green, int blue) {
		return new Color(alpha, red, green, blue);
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = Math.min(alpha, 255);
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = Math.min(red, 255);
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = Math.min(green, 255);
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = Math.min(blue, 255);
	}

	public long getHexColor() {
		String r = Integer.toHexString(getRed());
		r = r.length() < 2 ? "0" + r : r;
		String g = Integer.toHexString(getGreen());
		g = g.length() < 2 ? "0" + g : g;
		String b = Integer.toHexString(getBlue());
		b = b.length() < 2 ? "0" + b : b;
		String a = Integer.toHexString(getAlpha());
		a = a.length() < 2 ? "0" + a : a;

		return Long.parseLong(a + r + g + b, 16);
	}

}
