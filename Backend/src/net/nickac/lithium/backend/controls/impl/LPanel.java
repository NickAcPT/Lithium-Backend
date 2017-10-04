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

package net.nickac.lithium.backend.controls.impl;

import net.nickac.lithium.backend.controls.LContainer;
import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.other.objects.Dimension;
import net.nickac.lithium.backend.other.objects.Point;

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
