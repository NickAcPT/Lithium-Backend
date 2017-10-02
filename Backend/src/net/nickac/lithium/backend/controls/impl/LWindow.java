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
import net.nickac.lithium.backend.controls.impl.events.WindowEventHandler;
import net.nickac.lithium.backend.other.Dimension;
import net.nickac.lithium.backend.other.LithiumConstants;
import net.nickac.lithium.backend.other.Point;

import java.util.*;

/**
 * Created by NickAc for Lithium!
 */
public class LWindow extends LControl implements LContainer {

	private transient UUID viewer;
	private HashMap<UUID, LControl> child = new HashMap<>();

	//Event Load
	private transient List<WindowEventHandler> windowLoadHandlers = new ArrayList<>();

	public LWindow() {
		child = new HashMap<>();
	}

	public LWindow onWindowLoad(WindowEventHandler hl) {
		windowLoadHandlers.add(hl);
		return this;
	}
	//End Event

	public void invokeWindowLoad(UUID invoker) {
		windowLoadHandlers.forEach(h -> h.handleEvent(this, invoker));
	}

	public UUID getViewer() {
		return viewer;
	}

	public void setViewer(UUID viewer) {
		this.viewer = viewer;
	}

	@Override
	public void addControl(LControl c) {
		if (c.getParent() == null) c.setParent(this);
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

	public void close() {
		if (LithiumConstants.onClose != null && getViewer() != null)
			LithiumConstants.onClose.closeWindow(this, getViewer());
	}
}
