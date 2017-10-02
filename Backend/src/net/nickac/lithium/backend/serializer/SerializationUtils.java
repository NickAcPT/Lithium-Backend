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

package net.nickac.lithium.backend.serializer;

import java.io.*;
import java.util.Base64;

/**
 * Created by NickAc for Lithium!
 */
public class SerializationUtils {

	/**
	 * Serializes an object to a base64 encoded string
	 *
	 * @param object The object to serialize
	 * @return a base64 encoded string that contains the object
	 */
	public static String objectToString(Serializable object) {
		String encoded = null;

		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			objectOutputStream.close();
			encoded = new String(Base64.getEncoder().encode(byteArrayOutputStream.toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encoded;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T stringToObject(String string, Class<T> clazz) {
		byte[] bytes = Base64.getDecoder().decode(string.getBytes());
		T object = null;
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
			object = (T) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
		return object;
	}

}
