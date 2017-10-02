/*
 *     This file is part of Lithium.
 *
 *     Lithium is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lithium is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lithium.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 *     This file is part of Lithium.
 *
 *     Lithium is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lithium is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lithium.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.nickac.lithium.backend.other.objects;

import java.io.Serializable;

/**
 * Created by NickAc for Lithium!
 */
@SuppressWarnings("ALL")
public class Color implements Serializable {

	public transient static Color RED = new Color(255, 0, 0);
	public transient static Color GREEN = new Color(0, 255, 0);
	public transient static Color BLUE = new Color(0, 0, 255);
	public transient static Color WHITE = new Color(255, 255, 255);
	public transient static Color BLACK = new Color(0, 0, 0);

	private int alpha = 255;
	private int red = 0;
	private int green = 0;
	private int blue = 0;

	private Color(int red, int green, int blue) {
		this(255, red, green, blue);
	}

	private Color(int alpha, int red, int green, int blue) {
		this.alpha = Math.min(alpha, 255);
		this.red = Math.min(red, 255);
		this.green = Math.min(green, 255);
		this.blue = Math.min(blue, 255);

	}

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

}
