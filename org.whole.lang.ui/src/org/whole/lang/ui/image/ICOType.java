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
package org.whole.lang.ui.image;

public enum ICOType {
	H32(256, false),
	L32(48, false),
	M32(32, false),
	S32(16, false),
	L16(48, true),
	M16(32, true),
	S16(16, true);

	private int size;
	private boolean indexed;

	private ICOType(int size, boolean indexed) {
		this.size = size;
		this.indexed = indexed;
	}

	public int getSize() {
		return size;
	}
	
	public boolean isIndexed() {
		return indexed;
	}
}
