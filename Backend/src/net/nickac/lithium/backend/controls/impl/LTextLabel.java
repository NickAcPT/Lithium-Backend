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

package net.nickac.lithium.backend.controls.impl;

import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.other.objects.Color;

/**
 * Created by NickAc for Lithium!
 */
public class LTextLabel extends LControl {

	private Color color = Color.WHITE;

	public LTextLabel(String text) {
		setText(text);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
