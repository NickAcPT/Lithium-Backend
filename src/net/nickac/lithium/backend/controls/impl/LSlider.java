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
 *
 */

package net.nickac.lithium.backend.controls.impl;

import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.controls.impl.events.PropertyChangedHandler;
import net.nickac.lithium.backend.other.objects.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LSlider extends LControl {

	public LSlider() {
	}

	public LSlider(int value) {
		setValue(value);
	}

	public LSlider(int value, int min, int max) {
		setValue(value);
		setMinValue(min);
		setMaxValue(max);
	}

	private transient List<PropertyChangedHandler<LSlider>> valueChangedHandlers = new ArrayList<>();
	private Color borderColor = Color.WHITE;
	private Color backgroundColor = Color.BLACK;
	private SliderType sliderType = SliderType.HORIZONTAL;
	private int minimumValue = 0;
	private int maximumValue = 100;
	private int value = 0;

	public SliderType getSliderType() {
		return sliderType;
	}

	public void setSliderType(SliderType sliderType) {
		this.sliderType = sliderType;
	}

	public LSlider onValueChanged(PropertyChangedHandler<LSlider> hl) {
		valueChangedHandlers.add(hl);
		return this;
	}

	public void invokeValueChanged(UUID invoker) {
		valueChangedHandlers.forEach(h -> h.handleEvent(this, invoker));
	}

	public int getMinValue() {
		return minimumValue;
	}

	public void setMinValue(int minimumValue) {
		this.minimumValue = minimumValue;
	}

	public int getMaxValue() {
		return maximumValue;
	}

	public void setMaxValue(int maximumValue) {
		this.maximumValue = maximumValue;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean canReceiveUserInput() {
		return true;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public enum SliderType {
		HORIZONTAL,
		VERTICAL
	}

}
