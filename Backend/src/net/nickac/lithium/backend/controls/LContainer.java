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

package net.nickac.lithium.backend.controls;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public interface LContainer {
	UUID getViewer();

	Collection<LControl> getControls();

	void addControl(LControl c);

	void addControl(LControl c, int x, int y, int w, int h);

	void addControl(LControl c, int w, int h);

	void removeControl(UUID c);

	void removeControl(LControl c);
}
