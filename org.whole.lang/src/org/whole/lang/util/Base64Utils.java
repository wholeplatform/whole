/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.util;

/**
 * @author Enrico Persiani
 */
public class Base64Utils {
	private static final String BASE64_ALPHABET_STRING = 
		"ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
		"abcdefghijklmnopqrstuvwxyz" +
		"0123456789" + "+/";
	private static final char[] BASE64_ALPHABET =
		BASE64_ALPHABET_STRING.toCharArray();

	public static byte[] decode(String value) {
		char[] charArray = value.replaceAll("[^A-Za-z0-9+/=]+", "").toCharArray();
		int padtype = value.endsWith("=") ? 
				value.endsWith("==") ? 2 : 1 : 0;

		byte[] bytes = new byte[((charArray.length/4)*3 - padtype)];
		int offset = 0;
		for (int j=0; j<charArray.length-(padtype>0 ? 4 : 0) ; j+=4) {
			int group = BASE64_ALPHABET_STRING.indexOf(charArray[j]) << 18 |
					BASE64_ALPHABET_STRING.indexOf(charArray[j+1]) << 12 |
					BASE64_ALPHABET_STRING.indexOf(charArray[j+2]) << 6 |
					BASE64_ALPHABET_STRING.indexOf(charArray[j+3]);
			bytes[offset++] = (byte) (group >> 16);
			bytes[offset++] = (byte) ((group >> 8) & 0xff);
			bytes[offset++] = (byte) (group & 0xff);
		}

		int lastgroup = 0;
		switch (padtype) {
		case 1:
			lastgroup = BASE64_ALPHABET_STRING.indexOf(charArray[charArray.length-4]) << 10 |
					BASE64_ALPHABET_STRING.indexOf(charArray[charArray.length-3]) << 4 |
					BASE64_ALPHABET_STRING.indexOf(charArray[charArray.length-2]) >> 2;
			bytes[offset++] = (byte) (lastgroup >> 8);
			bytes[offset++] = (byte) (lastgroup & 0xff);
			break;
		case 2:
			lastgroup = BASE64_ALPHABET_STRING.indexOf(charArray[charArray.length-4]) << 2 |
					BASE64_ALPHABET_STRING.indexOf(charArray[charArray.length-3]) >> 4;
			bytes[offset++] = (byte) (lastgroup & 0xff);
			break;
		}
		return bytes;
	}

	public static String encode(byte[] value) {
		int remainder = value.length % 3;
		int padtype = remainder > 0 ? 
				(remainder == 2 ? 1 : 2) : 0;

		StringBuilder sb = new StringBuilder((value.length/3+1)*4);
		for (int i=0; i<value.length-remainder; i+=3) {
			if (i > 0 && i % 57 == 0)
				sb.append('\n');
			int group = ((value[i] << 16) & 0x00FF0000) | ((value[i+1] << 8) & 0x0000FF00) | ((value[i+2]) & 0x000000FF);
			sb.append(BASE64_ALPHABET[(group >> 18) & 0x3f]);
			sb.append(BASE64_ALPHABET[(group >> 12) & 0x3f]);
			sb.append(BASE64_ALPHABET[(group >> 6) & 0x3f]);
			sb.append(BASE64_ALPHABET[group & 0x3f]);
		}

		int lastgroup = 0;
		switch (padtype) {
		case 1:
			lastgroup = ((value[value.length-2] << 8) & 0x0000FF00) | (value[value.length-1] & 0x000000FF);
			sb.append(BASE64_ALPHABET[(lastgroup >> 10) & 0x3f]);
			sb.append(BASE64_ALPHABET[(lastgroup >> 4) & 0x3f]);
			sb.append(BASE64_ALPHABET[(lastgroup & 0xf) << 2]);
			sb.append("=");
			break;
		case 2:
			lastgroup = value[value.length-1] & 0x000000FF;
			sb.append(BASE64_ALPHABET[(lastgroup >> 2) & 0x3f]);
			sb.append(BASE64_ALPHABET[(lastgroup & 0x3) << 4]);
			sb.append("==");
			break;
		}
		return sb.toString();
	}
}
