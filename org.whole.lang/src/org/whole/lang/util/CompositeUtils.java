/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

/**
 * @author Riccardo Solmi
 */
public class CompositeUtils {
    @SuppressWarnings("unchecked")
	public static <T> T[] grow(T[] array, int length, T fillElement) {
    	Class<T> componentType = (Class<T>) array.getClass().getComponentType();
    	T[] newArray = (T[]) Array.newInstance(componentType, length);
    	System.arraycopy(array, 0, newArray, 0, array.length);
        Arrays.fill(newArray, array.length, newArray.length, fillElement);
    	return newArray;
    }
    public static boolean[] grow(boolean[] array, int length, boolean fillElement) {
    	boolean[] newArray = new boolean[length];
    	System.arraycopy(array, 0, newArray, 0, array.length);
        Arrays.fill(newArray, array.length, newArray.length, fillElement);
        return newArray;
    }
}
