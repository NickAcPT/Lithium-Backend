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

import java.util.Collection;
import java.util.UUID;

/**
 * Represents a Lithium Container.
 */
public interface LContainer extends ILithiumControl {
	/**
	 * Gets the viewer of this container<br>.
	 *
	 * @return The viewer of this container if there is a viewer, null otherwise.
	 */
	UUID getViewer();


	/**
	 * Gets the controls of this container.
	 *
	 * @return The collection of Lithium Controls of this container.
	 */
	Collection<LControl> getControls();

	/**
	 * Adds a control to this container.
	 *
	 * @param c The control that will be added to the container.
	 */
	void addControl(LControl c);

	/**
	 * Adds a control to this container.
	 *
	 * @param c The control that will be added
	 * @param x X position of the control
	 * @param y Y position of the control
	 * @param w Width of the control
	 * @param h Height of the control
	 */
	void addControl(LControl c, int x, int y, int w, int h);

	/**
	 * Adds a control to this container.
	 *
	 * @param c The control that will be added
	 * @param w Width of the control
	 * @param h Height of the control
	 */
	void addControl(LControl c, int w, int h);

	/**
	 * Removes a control from this container by an UUID
	 *
	 * @param c The UUID of the control that will be removed
	 */
	void removeControl(UUID c);

	/**
	 * Removes a control from this container.
	 *
	 * @param c The control instance to be removed
	 */
	void removeControl(LControl c);
}
