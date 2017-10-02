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

package net.nickac.lithium.backend.other;

import net.nickac.lithium.backend.other.serverhandlers.LithiumCloseWindowHandler;
import net.nickac.lithium.backend.other.serverhandlers.LithiumRefreshControlHandler;

/**
 * Created by NickAc for Lithium!
 */
public class LithiumConstants {
	//Start Window Section
	public static String LITHIUM_WINDOW_OPEN = "LITHIUM|WINDOW_OPEN|"; //UUID
	public static String LITHIUM_WINDOW_CLOSE = "LITHIUM|WINDOW_CLOSE|"; //UUID
	public static String LITHIUM_RECEIVE_WINDOW = "LITHIUM|RECEIVE_WINDOW|"; //OBJECT SERIALIZED WITH BASE64
	//End Window Section

	//Start Action Section
	public static String LITHIUM_CONTROL_CHANGED = "LITHIUM|CONTROL_CHANGED|"; //OBJECT SERIALIZED WITH BASE64
	public static String LITHIUM_BUTTON_ACTION = "LITHIUM|BUTTON_ACTION|"; //UUID
	public static String LITHIUM_TEXTBOX_TEXT_CHANGED = "LITHIUM|TEXTBOX_CHANGED|"; //UUID|TEXT
	public static String LITHIUM_CLOSE_WINDOW = "LITHIUM|CLOSE_WINDOW"; //
	//End Action Section

	//Start Dummy Section
	public static LithiumRefreshControlHandler onRefresh = null;
	public static LithiumCloseWindowHandler onClose = null;
	//End Dummy Section
	public static int CENTERED_CONSTANT = -2;
}
