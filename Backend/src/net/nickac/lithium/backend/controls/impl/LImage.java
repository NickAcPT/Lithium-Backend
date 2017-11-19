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

/**
 * Created by NickAc for Lithium!
 */
public class LImage extends LControl {

	public LImage(String imageUrl) {
		setImageURL(imageUrl);
	}

	private String imageURL = "";
	private ImageDisplayOption displayOption = ImageDisplayOption.STRECH;

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public ImageDisplayOption getDisplayOption() {
		return displayOption;
	}

	public void setDisplayOption(ImageDisplayOption displayOption) {
		this.displayOption = displayOption;
	}

	@Override
	public boolean canReceiveUserInput() {
		return false;
	}

	public enum ImageDisplayOption {
		TILED, //FUTURE
		AUTO_SIZE,
		STRECH, //FUTURE
		NONE //The same as auto_size
	}

}
