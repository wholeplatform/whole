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

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;


/**
 * @author Enrico Persiani
 */
public class ReaderInputStream extends InputStream {
	private final Reader reader;
	private CharsetEncoder encoder;
	private boolean endOfInput;
	private CharBuffer in;

	public ReaderInputStream(Reader reader) {
		this(reader, Charset.defaultCharset().name());
	}
	public ReaderInputStream(Reader reader, String encoding) {
		this(reader, Charset.forName(encoding));
	}
	public ReaderInputStream(Reader reader, Charset charset) {
		this(reader, charset, 32);
	}
	public ReaderInputStream(Reader reader, Charset charset, int size) {
		this.reader = reader;
		this.encoder = charset.newEncoder();
		this.endOfInput = false;
		this.in = CharBuffer.allocate(size);
		this.in.limit(0);
	}

	@Override
	public int read() throws IOException {
		byte[] b = new byte[1];
		return read(b) == -1 ? -1 : b[0] & 0x000000FF;
	}
	
	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		// fill input buffer as much as possible
		if (!endOfInput) {
			in.compact();
			endOfInput = reader.read(in) == -1;
			in.flip();
		}

		// encode to the wrapped buffer
		ByteBuffer out = ByteBuffer.wrap(b, off, len);
		if (encoder.encode(in, out, endOfInput).isError())
			throw new IOException("encoding error");

		if (!in.hasRemaining())
			in.clear().limit(0);

		int count = out.position() - off;
		return count > 0 ? count : -1;
	}

	@Override
	public void close() throws IOException {
		reader.close();
	}
}
