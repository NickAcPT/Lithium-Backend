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

package net.nickac.lithium.backend.controls;

import net.nickac.lithium.backend.other.objects.Dimension;
import net.nickac.lithium.backend.other.objects.Point;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
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
	 * @return The location of the bottom side of the control
	 */
	int getBottom();


	/**
	 * Refresh this control.<br>
	 * The control will be resent to the client and will be updated.
	 */
	void refresh();

	/**
	 * Dispose this control.<br>
	 * This control will be removed from the parent and from the client.
	 */
	void dispose();

	Object getTag();

	LControl setTag(Object tag);


}
