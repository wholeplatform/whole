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
 * @author Riccardo Solmi
 */
public class UniqueIdGenerator {
	public static UniqueIdGenerator newUniqueIdGenerator(String prefix) {
		return newUniqueIdGenerator(prefix, 1);
	}
	public static UniqueIdGenerator newUniqueIdGenerator(String prefix, long counter) {
	    return new UniqueIdGenerator(prefix, counter);
	}

    private final String prefix;
	private long counter;
	
	private UniqueIdGenerator(String prefix, long counter) {
	    this.prefix = prefix;
	    this.counter = counter;
	}

	public String next() {
		return prefix + counter++; //Long.toHexString(counter++);
	}
}
