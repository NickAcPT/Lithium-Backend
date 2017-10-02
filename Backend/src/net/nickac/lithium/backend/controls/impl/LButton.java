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
import net.nickac.lithium.backend.controls.impl.events.ButtonActionEventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
@SuppressWarnings("UnusedReturnValue")
public class LButton extends LControl {

	//Event Load
	private transient List<ButtonActionEventHandler> buttonActionHandlers = new ArrayList<>();

	public LButton(String text) {
		setText(text);
	}

	public LButton onButtonClick(ButtonActionEventHandler hl) {
		buttonActionHandlers.add(hl);
		return this;
	}
	//End Event

	public void invokeButtonClick(UUID invoker) {
		buttonActionHandlers.forEach(h -> h.handleEvent(this, invoker));
	}
}
