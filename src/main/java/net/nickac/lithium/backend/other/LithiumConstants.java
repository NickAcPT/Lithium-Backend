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

package net.nickac.lithium.backend.other;

import net.nickac.lithium.backend.other.serverhandlers.LithiumCloseWindowHandler;
import net.nickac.lithium.backend.other.serverhandlers.LithiumRefreshControlHandler;
import net.nickac.lithium.backend.other.serverhandlers.LithiumRuntimeControlHandler;

/**
 * Created by NickAc for Lithium!
 */
public class LithiumConstants {

    public final static String VERSION="1.3";

    public static class TO_SERVER {
        public final static String WINDOW_OPEN = "WINDOW_OPEN"; //UUID (Client->Server)
        public final static String WINDOW_CLOSE = "WINDOW_CLOSE"; //UUID (Client->Server)
        public final static String BUTTON_ACTION = "BUTTON_ACTION"; //UUID (Client->Server)
        public final static String TEXTBOX_TEXT_CHANGED = "TEXTBOX_CHANGED"; //UUID|TEXT (Client->Server)
        public final static String SLIDER_VALUE_CHANGED = "SLIDER_CHANGED"; //UUID|VALUE (Client->Server)
        public final static String TOGGLE_ACTION = "TOGGLE_ACTION"; //UUID (Client->Server)
        public final static String CONNECTION_ESTABLISHED = "CONNECTION_ESTABLISHED"; //OBJECT SERIALIZED WITH BASE64 (Server->Client)
    }
    public static class TO_CLIENT {
        public final static String RECEIVE_WINDOW = "RECEIVE_WINDOW"; //OBJECT SERIALIZED WITH BASE64 (Server->Client)
        public final static String CONTROL_CHANGED = "CONTROL_CHANGED"; //OBJECT SERIALIZED WITH BASE64 (Server->Client)
        public final static String CLOSE_WINDOW = "CLOSE_WINDOW"; // (Server->Client)
        public final static String ADD_TO_CONTAINER = "ADD_TO_CONTAINER"; //CONTAINER UUID|OBJECT SERIALIZED WITH BASE64 (Server->Client)
        public final static String REMOVE_FROM_CONTAINER = "REMOVE_FROM_CONTAINER"; //CONTAINER UUID|CONTROL UUID (Server->Client)
        public final static String SHOW_OVERLAY = "SHOW_OVERLAY"; //OBJECT SERIALIZED WITH BASE64 (Server->Client)
        public final static String REMOVE_OVERLAY = "REMOVE_OVERLAY"; // (Server->Client)

    }

    //Start Event Section
    public static LithiumRefreshControlHandler onRefresh = null;
    public static LithiumCloseWindowHandler onClose = null;
    public static LithiumRuntimeControlHandler onControlRuntime = null;

    //End  Overlay Section
    public final static int CENTERED_CONSTANT = -2; //LEGACY




}
