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

public enum ICNSType {
	IC08("ic08", 256),
	IC09("ic09", 512),
	IC10("ic10", 1024),
	IC11("ic11", 32),
	IC12("ic12", 64),
	IC13("ic13", 256),
	IC14("ic14", 512),
	IS32("is32", "s8mk", 16),
	IL32("il32", "l8mk", 32),
	IT32("it32", "t8mk", 128);

	private String magic;
	private String alphaMagic;
	private int size;

	private ICNSType(String magic, int size) {
		this(magic, null, size);
	}
	private ICNSType(String magic, String alphaMagic, int size) {
		this.magic = magic;
		this.alphaMagic = alphaMagic;
		this.size = size;
	}

	public String getMagic() {
		return magic;
	}
	public boolean hasAlpha() {
		return alphaMagic != null;
	}
	public String getAlphaMagic() {
		return alphaMagic;
	}
	public int getSize() {
		return size;
	}
}
