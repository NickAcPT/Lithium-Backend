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

import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.controls.impl.events.TextBoxEventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LTextBox extends LControl {

	private String text;
	private int maxStringLength = 23;

	//Event Load
	private transient List<TextBoxEventHandler> textChangedHandlers = new ArrayList<>();

	public LTextBox() {
	}

	public LTextBox onTextChanged(TextBoxEventHandler hl) {
		textChangedHandlers.add(hl);
		return this;
	}
	//End Event

	public void invokeTextChanged(UUID invoker) {
		textChangedHandlers.forEach(h -> h.handleEvent(this, invoker));
	}

	/**
	 * The max length of the text
	 *
	 * @return the max length
	 */
	public int getMaxStringLength() {
		return maxStringLength;
	}

	public void setMaxStringLength(int maxStringLength) {
		this.maxStringLength = maxStringLength;
	}

	@Override
	public String getText() {
		return text;
	}

	/**
	 * Sets this textbox's text without refreshing it on the client!
	 *
	 * @param text The new text
	 */
	public void setInternalText(String text) {
		this.text = text;
	}

	/**
	 * Set this textbox's text and refreshes it on the client!
	 * @param text The new text
	 * @return This object to allow chained calls
	 */
	@Override
	public LTextBox setText(String text) {
		setInternalText(text);
		refresh();
		return this;
	}
}
