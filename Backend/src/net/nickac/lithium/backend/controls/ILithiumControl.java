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

import net.nickac.lithium.backend.other.Dimension;
import net.nickac.lithium.backend.other.Point;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
@SuppressWarnings("ALL")
public interface ILithiumControl extends Serializable {
	/**
	 * Get the parent of this control
	 *
	 * @return The parent of this control.
	 */
	LContainer getParent();

	/**
	 * Set the parent of this control
	 *
	 * @param parent The new parent of this control.
	 */
	void setParent(LContainer parent);

	/**
	 * The Unique ID associated with this control
	 *
	 * @return The UUID of this control.
	 */
	UUID getUUID();

	/**
	 * Gets the text of this control. <br>
	 * Not all controls contain text.
	 *
	 * @return The text of this control.
	 */
	String getText();

	/**
	 * Sets the text of this control
	 *
	 * @param text The new text of the control
	 * @return Itself, in order to allow chained calls.
	 */
	ILithiumControl setText(String text);

	/**
	 * Gets the size of the control. <br>
	 * Some controls may have fixed size on the client, so this may not be accurate.
	 *
	 * @return The size of this control.
	 */
	Dimension getSize();

	/**
	 * Sets the size of this control
	 *
	 * @param size The new size of this control
	 * @return Itself, in order to allow chained calls.
	 */
	LControl setSize(Dimension size);

	/**
	 * Gets the location of this control
	 *
	 * @return The location of this control
	 */
	Point getLocation();

	/**
	 * Ses the location of this control
	 *
	 * @param loc The new location of this control
	 * @return Itself, in
	 */
	ILithiumControl setLocation(Point loc);

	/**
	 * Get the location of the left side of this control
	 *
	 * @return The location of the left side of the control
	 */
	int getLeft();

	/**
	 * Get the location of the right side of this control
	 *
	 * @return The location of the right side of the control
	 */
	int getRight();

	/**
	 * Get the location of the top of this control
	 *
	 * @return The location of the top of the control
	 */
	int getTop();

	/**
	 * Get the location of the bottom of this control
	 *
	 * @return The location of the top side of the control
	 */
	int getBottom();

	/**
	 * Get the location of the left side of this control
	 *
	 * @return The location of the left side of the control
	 */


	void refresh();

	void dispose();

	Object getTag();

	LControl setTag(Object tag);


}
