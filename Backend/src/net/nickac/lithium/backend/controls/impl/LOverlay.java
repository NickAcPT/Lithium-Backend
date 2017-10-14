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

import net.nickac.lithium.backend.controls.LContainer;
import net.nickac.lithium.backend.controls.LControl;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LOverlay extends LControl implements LContainer {


	@Override
	public UUID getViewer() {
		return null;
	}

	@Override
	public Collection<LControl> getControls() {
		return null;
	}

	@Override
	public void addControl(LControl c) {

	}

	@Override
	public void addControl(LControl c, int x, int y, int w, int h) {

	}

	@Override
	public void addControl(LControl c, int w, int h) {

	}

	@Override
	public void removeControl(UUID c) {

	}

	@Override
	public void removeControl(LControl c) {

	}
}
