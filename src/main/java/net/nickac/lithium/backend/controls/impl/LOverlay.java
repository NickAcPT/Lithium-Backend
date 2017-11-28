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

import net.nickac.lithium.backend.controls.LContainerViewable;
import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.other.objects.Dimension;
import net.nickac.lithium.backend.other.objects.Point;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LOverlay extends LControl implements LContainerViewable {
	private UUID viewer;
	private Map<UUID, LControl> controls = new HashMap<>();

	@Override
	public boolean canReceiveUserInput() {
		return false;
	}

	@Override
	public UUID getViewer() {
		return viewer;
	}

	public void setViewer(UUID viewer) {
		this.viewer = viewer;
	}

	@Override
	public Collection<LControl> getControls() {
		return controls.values();
	}

	@Override
	public void addControl(LControl c) {
		//We can't allow stuff that needs user input.
		//It's an overlay, not a GUI!
		if (c.canReceiveUserInput()) {
			return;
		}
		controls.put(c.getUUID(), c);
		internalAddControl(c);
	}

	private void internalAddControl(LControl c) {
		c.setParent(this);
	}

	private void internalRemoveControl(UUID c) {

	}

	@Override
	public void addControl(LControl c, int x, int y, int w, int h) {
		c.setSize(new Dimension(w, h));
		c.setLocation(new Point(x, y));
		addControl(c);
	}

	@Override
	public void addControl(LControl c, int w, int h) {
		c.setSize(new Dimension(w, h));
		addControl(c);
	}

	@Override
	public void removeControl(UUID c) {
		internalRemoveControl(c);
	}

	@Override
	public void removeControl(LControl c) {
		internalRemoveControl(c.getUUID());
	}
}
