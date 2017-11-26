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

import net.nickac.lithium.backend.controls.IToggleable;
import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.controls.impl.events.PropertyChangedHandler;
import net.nickac.lithium.backend.other.objects.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LCheckBox extends LControl implements IToggleable {
	public LCheckBox(String text) {
		setText(text);
	}

	private Color foreColor = Color.WHITE;
	private Color outsideColor = Color.GRAY;
	private Color insideColor = Color.BLACK;
	private Color checkedColor = Color.GRAY;
	private boolean checked;
	private transient List<PropertyChangedHandler<LCheckBox>> toggleHandlers = new ArrayList<>();

	@Override
	public boolean canReceiveUserInput() {
		return true;
	}

	public Color getForeColor() {
		return foreColor;
	}

	public void setForeColor(Color foreColor) {
		this.foreColor = foreColor;
	}

	public Color getOutsideColor() {
		return outsideColor;
	}

	public void setOutsideColor(Color outsideColor) {
		this.outsideColor = outsideColor;
	}

	public Color getInsideColor() {
		return insideColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}

	public Color getCheckedColor() {
		return checkedColor;
	}

	public void setCheckedColor(Color checkedColor) {
		this.checkedColor = checkedColor;
	}

	@Override
	public boolean isChecked() {
		return checked;
	}

	@Override
	public void setChecked(boolean checked) {
		setCheckedInternal(checked);
		refresh();
	}

	public LCheckBox onToggled(PropertyChangedHandler<LCheckBox> hl) {
		toggleHandlers.add(hl);
		return this;
	}

	public void invokeToggled(UUID invoker) {
		toggleHandlers.forEach(h -> h.handleEvent(this, invoker));
	}


	public void setCheckedInternal(boolean checked) {
		this.checked = checked;
	}
}
