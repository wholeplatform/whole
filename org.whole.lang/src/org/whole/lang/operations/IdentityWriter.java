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
package org.whole.lang.operations;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Enrico Persiani
 */
public final class IdentityWriter extends Writer {
	private static class SingletonHolder {
		private static final IdentityWriter instance = new IdentityWriter();
	}
	public static IdentityWriter instance() {
		return SingletonHolder.instance;
	}
	private IdentityWriter() {
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
	}
	public void write(char[] cbuf) throws IOException {
	}
	public void write(int c) throws IOException {
	}
	public void write(String str) throws IOException {
	}
	public void write(String str, int off, int len) throws IOException {
	}

	public Writer append(char c) throws IOException {
		return this;
	}
	public Writer append(CharSequence csq) throws IOException {
		return this;
	}
	public Writer append(CharSequence csq, int start, int end) {
		return this;
	}
	
	public boolean equals(Object obj) {
		return this == obj;
	}
	public void close() throws IOException {
	}
	public void flush() throws IOException {
	}
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
