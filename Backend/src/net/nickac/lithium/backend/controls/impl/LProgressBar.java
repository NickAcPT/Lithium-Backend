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
import net.nickac.lithium.backend.other.objects.Color;

/**
 * Created by NickAc for Lithium!
 */
public class LProgressBar extends LControl {

	public LProgressBar() {
	}

	public LProgressBar(int progress) {
		this.progress = progress;
	}

	private Color progressColor = Color.GREEN;
	private Color borderColor = Color.GRAY;
	private Color insideColor = Color.BLACK;
	private int progress = 0;
	private int minValue = 0;
	private int maxValue = 100;

	@Override
	public boolean canReceiveUserInput() {
		return false;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
		refresh();
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
		refresh();
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
		refresh();
	}

	public Color getProgressColor() {
		return progressColor;
	}

	public void setProgressColor(Color progressColor) {
		this.progressColor = progressColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getInsideColor() {
		return insideColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}


}
