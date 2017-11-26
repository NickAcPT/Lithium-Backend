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
import net.nickac.lithium.backend.other.LithiumConstants;
import net.nickac.lithium.backend.other.objects.Dimension;
import net.nickac.lithium.backend.other.objects.Point;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LPanel extends LControl implements LContainer {
	public LPanel() {
		child = new HashMap<>();
	}

	private Map<UUID, LControl> child;

	@Override
	public boolean canReceiveUserInput() {
		return false;
	}

	@Override
	public void addControl(LControl c) {
		c.setParent(this);
		child.put(c.getUUID(), c);
		refresh();
		try {
			if (LithiumConstants.onControlRuntime != null && getViewer() != null) {
				LithiumConstants.onControlRuntime.addControl(c, this, getViewer());
			}
		} catch (NullPointerException ex) {
			//Sorry! I had to do this....
		}
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
		LControl toRemove = child.getOrDefault(c, null);
		child.remove(c);
		refresh();
		if (toRemove != null) {
			try {
				if (LithiumConstants.onControlRuntime != null && getViewer() != null) {
					LithiumConstants.onControlRuntime.removeControl(toRemove, this, getViewer());
				}
			} catch (NullPointerException ex) {
				//Sorry! I had to do this....
			}
		}
	}

	@Override
	public void removeControl(LControl c) {
		removeControl(c.getUUID());
	}
}
