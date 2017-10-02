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

import net.nickac.lithium.backend.controls.LContainer;
import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.other.Dimension;
import net.nickac.lithium.backend.other.Point;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LPanel extends LControl implements LContainer {
	private CenterOptions centerOptions = CenterOptions.NONE;
	private HashMap<UUID, LControl> child = new HashMap<>();

	public LPanel() {
		child = new HashMap<>();
	}

	public CenterOptions getCenterOptions() {
		return centerOptions;
	}

	public void setCenterOptions(CenterOptions centerOptions) {
		this.centerOptions = centerOptions;
	}

	@Override
	public void addControl(LControl c) {
		c.setParent(this);
		child.put(c.getUUID(), c);
		refresh();
	}

	@Override
	public void addControl(LControl c, int x, int y, int w, int h) {
		c.setSize(new Dimension(w, h));
		c.setLocation(new Point(x, y));
		addControl(c);
	}

	public void addControl(LControl c, int w, int h) {
		c.setSize(new Dimension(w, h));
		addControl(c);
	}

	public int getTotalWidth() {
		int width = 0;
		for (LControl control : child.values()) {
			width = Math.max(width, control.getRight());
		}
		return width;
	}

	public int getTotalHeight() {
		int height = 0;
		for (LControl control : child.values()) {
			height = Math.max(height, control.getBottom());
		}
		return height;
	}


	@Override
	public UUID getViewer() {
		return getParent().getViewer();
	}

	public Collection<LControl> getControls() {
		return child.values();
	}

	@SuppressWarnings("WeakerAccess")
	@Override
	public void removeControl(UUID c) {
		child.remove(c);
		refresh();
	}

	@Override
	public void removeControl(LControl c) {
		removeControl(c.getUUID());
	}
}
