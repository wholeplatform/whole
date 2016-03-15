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


import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.junit.Test;

/**
 * @author Enrico Persiani
 */
public class StreamAdapterTest {
	@Test
	public void testWriterOutputStream() throws Exception {
		InputStream is = getClass().getResourceAsStream("utf8.txt");
		String expected = StringUtils.readAsString(is, "UTF-8");
		is.close();

		for (int size=2; size<128; size++) {
			byte[] bytes = expected.getBytes("UTF-8");
			StringWriter stringWriter = new StringWriter();
			WriterOutputStream wos = new WriterOutputStream(stringWriter, Charset.forName("UTF-8"), size);
			wos.write(bytes);
			wos.close();
			String actual = stringWriter.toString();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testReaderInputStream() throws Exception {
		InputStream is = getClass().getResourceAsStream("utf8.txt");
		String expected = StringUtils.readAsString(is, "UTF-8");
		is.close();

		for (int size=2 ; size<128; size++) {
			is = new ReaderInputStream(new StringReader(expected), Charset.forName("UTF-8"), size);
			String actual = StringUtils.readAsString(is,  "UTF-8");
			is.close();
			assertEquals(expected, actual);
		}
	}
	
}
