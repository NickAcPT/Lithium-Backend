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

import java.util.Collection;
import java.util.UUID;

/**
 * Represents a Lithium Container.
 */
public interface LContainer {
	/**
	 * Gets the viewer of this container<br>.
	 *
	 * @return The viewer of this container if there is a viewer, null otherwise.
	 */
	UUID getViewer();

	/**
	 * Gets the controls of this container.
	 * @return The collection of Lithium Controls of this container.
	 */
	Collection<LControl> getControls();

	/**
	 * Adds a control to this container.
	 * @param c The control that will be added to the container.
	 */
	void addControl(LControl c);

	/**
	 * Adds a control to this container.
	 * @param c The control that will be added
	 * @param x X position of the control
	 * @param y Y position of the control
	 * @param w Width of the control
	 * @param h Height of the control
	 */
	void addControl(LControl c, int x, int y, int w, int h);

	/**
	 * Adds a control to this container.
	 * @param c The control that will be added
	 * @param w Width of the control
	 * @param h Height of the control
	 */
	void addControl(LControl c, int w, int h);

	/**
	 * Removes a control from this container by an UUID
	 * @param c The UUID of the control that will be removed
	 */
	void removeControl(UUID c);

	/**
	 * Removes a control from this container.
	 * @param c The control instance to be removed
	 */
	void removeControl(LControl c);
}
