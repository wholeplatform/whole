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


import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.whole.lang.xml.util.XmlUtils;

/**
 * @author Enrico Persiani
 */
public class StreamEncodingTest {
	private static InputStream toStream(String contents, String encoding) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(("\uFEFF"+contents).getBytes(encoding));
	}
	private InputStream asStream(String name) {
		return new BufferedInputStream(getClass().getResourceAsStream(name));
	}

	@Test
	public void testGuessEncodingFromBOM() throws Exception {
		InputStream is = asStream("withbom.xml");
		String contents = StringUtils.readAsString(is, "UTF-8");
		is.close();

		assertEquals("UTF-8", XmlUtils.guessEncoding(toStream(contents, "UTF-8"), null));
		assertEquals("UTF-16LE", XmlUtils.guessEncoding(toStream(contents, "UTF-16LE"), null));
		assertEquals("UTF-16BE", XmlUtils.guessEncoding(toStream(contents, "UTF-16BE"), null));
		assertEquals("UTF-32LE", XmlUtils.guessEncoding(toStream(contents, "UTF-32LE"), null));
		assertEquals("UTF-32BE", XmlUtils.guessEncoding(toStream(contents, "UTF-32BE"), null));
	}

	@Test
	public void testGuessEncodingFromXmlDecl() throws Exception {
		assertEquals("ISO-8859-1", XmlUtils.guessEncoding(asStream("withoutbom_Latin1.xml"), null));
		assertEquals("UTF-8", XmlUtils.guessEncoding(asStream("withoutbom_utf8.xml"), null));
		assertEquals("UTF-8", XmlUtils.guessEncoding(asStream("withoutbom_utf8_noenc.xml"), null));

		assertEquals("UTF-16LE", XmlUtils.guessEncoding(asStream("withoutbom_utf16le_noenc.xml"), null));
		assertEquals("UTF-16LE", XmlUtils.guessEncoding(asStream("withoutbom_utf16le.xml"), null));

		assertEquals("UTF-16BE", XmlUtils.guessEncoding(asStream("withoutbom_utf16be_noenc.xml"), null));
		assertEquals("UTF-16BE", XmlUtils.guessEncoding(asStream("withoutbom_utf16be.xml"), null));

		assertEquals("UTF-32LE", XmlUtils.guessEncoding(asStream("withoutbom_utf32le_noenc.xml"), null));
		assertEquals("UTF-32LE", XmlUtils.guessEncoding(asStream("withoutbom_utf32le.xml"), null));

		assertEquals("UTF-32BE", XmlUtils.guessEncoding(asStream("withoutbom_utf32be_noenc.xml"), null));
		assertEquals("UTF-32BE", XmlUtils.guessEncoding(asStream("withoutbom_utf32be.xml"), null));
	}

	@Test
	public void testEncodingFromBOM() throws Exception {
		InputStream is = asStream("utf8.txt");
		String contents = StringUtils.readAsString(is, "UTF-8");
		is.close();

		assertEquals("UTF-8", StringUtils.encodingFromBOM(toStream(contents, "UTF-8"), null));
		assertEquals("UTF-16LE", StringUtils.encodingFromBOM(toStream(contents, "UTF-16LE"), null));
		assertEquals("UTF-16BE", StringUtils.encodingFromBOM(toStream(contents, "UTF-16BE"), null));
		assertEquals("UTF-32LE", StringUtils.encodingFromBOM(toStream(contents, "UTF-32LE"), null));
		assertEquals("UTF-32BE", StringUtils.encodingFromBOM(toStream(contents, "UTF-32BE"), null));
	}

	@Test
	public void testReadAsString() throws Exception {
		InputStream is = asStream("utf8.txt");
		String contents = StringUtils.readAsString(is, "UTF-8");
		is.close();

		assertEquals(contents, StringUtils.readAsString(toStream(contents, "UTF-8"), "UTF-8"));
		assertEquals(contents, StringUtils.readAsString(toStream(contents, "UTF-16LE"), "UTF-16LE"));
		assertEquals(contents, StringUtils.readAsString(toStream(contents, "UTF-16BE"), "UTF-16BE"));
		assertEquals(contents, StringUtils.readAsString(toStream(contents, "UTF-32LE"), "UTF-32LE"));
		assertEquals(contents, StringUtils.readAsString(toStream(contents, "UTF-32BE"), "UTF-32BE"));
	}
}
