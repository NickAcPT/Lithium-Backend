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

package net.nickac.lithium.backend.controls;

import net.nickac.lithium.backend.other.LithiumConstants;
import net.nickac.lithium.backend.other.objects.Dimension;
import net.nickac.lithium.backend.other.objects.Point;

import java.util.UUID;

import static net.nickac.lithium.backend.other.LithiumConstants.CENTERED_CONSTANT;

/**
 * This is the base control for Lithium.
 * All Lithium controls must extend this class
 */
public class LControl implements ILithiumControl {

	private LContainer parent;
	private UUID uuid;
	private String text;
	private Dimension size = Dimension.EMPTY;
	private Point location = Point.EMPTY;
	private transient Object tag;

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
		if (uuid == null)
			uuid = UUID.randomUUID();
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
		return location.getX();
	}

	@Override
	public int getRight() {
		return location.getX() + size.getWidth();
	}

	@Override
	public int getTop() {
		return location.getY();
	}

	@Override
	public int getBottom() {
		return location.getY() + size.getHeight();
	}

	public LControl setCentered(CenterOptions options) {
		switch (options) {
			case NONE:
				setLocation(Point.EMPTY);
				break;
			case HORIZONTAL:
				setLocation(new Point(CENTERED_CONSTANT, getLocation().getY()));
				break;
			case VERTICAL:
				setLocation(new Point(getLocation().getX(), CENTERED_CONSTANT));
				break;
			case HORIZONTAL_VERTICAL:
				setLocation(new Point(CENTERED_CONSTANT, CENTERED_CONSTANT));
				break;
		}
		return this;
	}

	@Override
	public void refresh() {
		try {
			if (LithiumConstants.onRefresh != null && parent != null && parent.getViewer() != null)
				LithiumConstants.onRefresh.onRefresh(parent.getViewer(), this);

		} catch (NullPointerException ex) {
			//Sorry! I had to do this....
		}
	}

	@Override
	public void dispose() {
		//TODO: Make global Implementation to handle this
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

	public enum CenterOptions {
		NONE,
		HORIZONTAL,
		VERTICAL,
		HORIZONTAL_VERTICAL
	}
}
