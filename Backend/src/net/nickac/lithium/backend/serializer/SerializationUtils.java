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
	public static <T extends Serializable> T stringToObject(String string, Class<T> clazz) throws IllegalArgumentException {
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
