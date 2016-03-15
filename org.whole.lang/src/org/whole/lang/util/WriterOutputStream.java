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
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


/**
 * @author Enrico Persiani
 */
public class WriterOutputStream extends OutputStream {
	private Writer writer;
	private CharsetDecoder decoder;
	private CharBuffer out;

	public WriterOutputStream(Writer writer) {
		this(writer, Charset.defaultCharset().name());
	}
	public WriterOutputStream(Writer writer, String encoding) {
		this(writer, Charset.forName(encoding));
	}
	public WriterOutputStream(Writer writer, Charset charset) {
		this(writer, charset, 32);
	}
	public WriterOutputStream(Writer writer, Charset charset, int size) {
		this.writer = writer;
		this.decoder = charset.newDecoder();
		this.out = CharBuffer.allocate(size);
		this.out.limit(0);
	}

	public void write(int b) throws IOException {
		byte[] bytes = new byte[] { (byte) b };
		write(bytes);
	}

	@Override
	public void write(byte[] b) throws IOException {
		write(b, 0, b.length);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		// wrap with byte buffer
		ByteBuffer in = ByteBuffer.wrap(b, off, len);

		// decode and write the input buffer
		while (in.hasRemaining()) {
			if (decoder.decode(in, out, true).isError())
				throw new IOException("decoding error");
			writer.write(out.array(), 0, out.position());
			out.clear();
		}
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
	}
	@Override
	public void close() throws IOException {
		writer.close();
	}
}
