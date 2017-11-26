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

import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.controls.impl.events.PropertyChangedHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LTextBox extends LControl {

	public LTextBox() {
	}

	private boolean passwordField = false;
	private String text = "";
	private int maxStringLength = 23;
	//Event Start
	private transient List<PropertyChangedHandler<LTextBox>> textChangedHandlers = new ArrayList<>();

	@Override
	public boolean canReceiveUserInput() {
		return true;
	}

	public LTextBox onTextChanged(PropertyChangedHandler<LTextBox> hl) {
		textChangedHandlers.add(hl);
		return this;
	}

	//End Event

	public void invokeTextChanged(UUID invoker) {
		textChangedHandlers.forEach(h -> h.handleEvent(this, invoker));
	}

	public boolean isPasswordField() {
		return passwordField;
	}

	public void setPasswordField(boolean passwordField) {
		this.passwordField = passwordField;
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
	 * Set this textbox's text and refreshes it on the client!
	 *
	 * @param text The new text
	 * @return This object to allow chained calls
	 */
	@Override
	public LTextBox setText(String text) {
		setInternalText(text);
		refresh();
		return this;
	}

	/**
	 * Sets this textbox's text without refreshing it on the client!
	 *
	 * @param text The new text
	 */
	public void setInternalText(String text) {
		this.text = text;
	}
}
