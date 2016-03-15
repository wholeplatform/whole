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
package org.whole.lang.xml.util;

import java.io.InputStream;

/**
 * @author Enrico Persiani
 */
public class InputStreamInput extends NullLSInput {
	private InputStream is;
	private String encoding;

	public InputStreamInput(InputStream is) {
		this(is, null);
	}
	public InputStreamInput(InputStream is, String encoding) {
		setByteStream(is);
		setEncoding(encoding);
	}

	@Override
	public InputStream getByteStream() {
		return this.is;
	}
	@Override
	public void setByteStream(InputStream is) {
		this.is = is;
	}
	@Override
	public String getEncoding() {
		return this.encoding;
	}
	@Override
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
}
