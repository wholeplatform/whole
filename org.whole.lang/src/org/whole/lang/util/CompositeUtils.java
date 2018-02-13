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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author Riccardo Solmi
 */
public class CompositeUtils {
	@SuppressWarnings("unchecked")
	public static <T> T[] resize(T[] array, int length, Supplier<T> fillElementSupplier) {
		if (array.length == length)
			return array;

		Class<T> componentType = (Class<T>) array.getClass().getComponentType();
		T[] newArray = (T[]) Array.newInstance(componentType, length);
		System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newArray.length));
		if (array.length < newArray.length)
			Arrays.fill(newArray, array.length, newArray.length, fillElementSupplier.get());
		return newArray;
	}
	public static int[] resize(int[] array, int length, Supplier<Integer> fillElementSupplier) {
		if (array.length == length)
			return array;
		
		int[] newArray = new int[length];
		System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newArray.length));
		if (array.length < newArray.length)
			Arrays.fill(newArray, array.length, newArray.length, fillElementSupplier.get());
		return newArray;
	}
	public static boolean[] resize(boolean[] array, int length, Supplier<Boolean> fillElementSupplier) {
		if (array.length == length)
			return array;

		boolean[] newArray = new boolean[length];
		System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newArray.length));
		if (array.length < newArray.length)
			Arrays.fill(newArray, array.length, newArray.length, fillElementSupplier.get());
		return newArray;
	}

	public static <T> T[] grow(T[] array, int length, T fillElement) {
		return array.length >= length ? array : resize(array, length, () -> fillElement);
	}
	public static int[] grow(int[] array, int length, int fillElement) {
		return array.length >= length ? array : resize(array, length, () -> fillElement);
	}
	public static boolean[] grow(boolean[] array, int length, boolean fillElement) {
		return array.length >= length ? array : resize(array, length, () -> fillElement);
	}
}
