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
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class XmlUtils {
	public static final String IGNORABLE_WHITESPACE_CHARS = 
		" \t\n\r";
	
	/* see "Extensible Markup Language (XML) 1.0 (Second Edition)" */
	public static final String CHARS =
		"\t\n\r" +
		"\u0020-\uD7FF" +				// U+20-U+D7FF
		"\uE000-\uFFFD" +				// U+E000-U+FFFD
		"\uD800\uDC00-\uDBFF\uDFFF"; 	// U+10000-U+10FFFF

	/* see "Namespaces in XML 1.0 (Second Edition)" */
	public static final String NAME_START_CHARS =
		"\\:a-z_A-Z" +
		"\u00C0-\u00D6" +				// U+C0-U+D6
		"\u00D8-\u00F6" +				// U+D8-U+F6
		"\u00F8-\u02FF" +				// U+F8-U+2FF
		"\u0370-\u037D" +				// U+370-U+37D
		"\u037F-\u1FFF" +				// U+37F-U+1FFF
		"\u200C-\u200D" +				// U+200C-U+200D
		"\u2070-\u218F" +				// U+2070-U+218F
		"\u2C00-\u2FEF" +				// U+2C00-U+2FEF
		"\u3001-\uD7FF" +				// U+3001-U+D7FF
		"\uF900-\uFDCF" +				// U+F900-U+FDCF
		"\uFDF0-\uFFFD" +				// U+FDF0-U+FFFD
		"\uD800\uDC00-\uDB7F\uDFFF"; 	// U+10000-U+EFFFF

	public static final String NAME_CHARS =
		".\\-0-9" +
		"\u00B7" +						// U+B7
		"\u0300-\u036F" +				// U+300-U+36F
		"\u203F-\u2040" +				// U+203F-U+2040
		NAME_START_CHARS;

	public static final String IGNORABLE_WHITESPACE_RE = "["+IGNORABLE_WHITESPACE_CHARS+"]*+";

	public static final String STRING_RE = "["+CHARS+"]*+";
	public static final String NORMALIZED_STRING_RE = "["+CHARS+"&&[^\t\n\r]]*+";
	public static final String TOKEN_RE = "["+CHARS+"&&[^ \t\n\r]]*+( ["+CHARS+"&&[^ \t\n\r]]++)*+";
	public static final String LANGUAGE_RE = "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*+";

	public static final String NAME_RE = "["+NAME_START_CHARS+"]["+NAME_CHARS+"]*+";
	public static final String NMTOKEN_RE = "["+NAME_CHARS+"]++";
	public static final String NCNAME_RE = "["+NAME_START_CHARS+"&&[^:]]["+NAME_CHARS+"&&[^:]]*+";
	public static final String QNAME_RE = "("+NCNAME_RE+"):("+NCNAME_RE+")";

	public static final Pattern IGNORABLE_WHITESPACE_PATTERN = Pattern.compile(IGNORABLE_WHITESPACE_RE);

	public static final Pattern STRING_PATTERN = Pattern.compile(STRING_RE);
	public static final Pattern NORMALIZED_STRING_PATTERN = Pattern.compile(NORMALIZED_STRING_RE);
	public static final Pattern TOKEN_PATTERN = Pattern.compile(TOKEN_RE);
	public static final Pattern LANGUAGE_PATTERN = Pattern.compile(LANGUAGE_RE);

	public static final Pattern NAME_PATTERN = Pattern.compile(NAME_RE);
	public static final Pattern NMTOKEN_PATTERN = Pattern.compile(NMTOKEN_RE);
	public static final Pattern NCNAME_PATTERN = Pattern.compile(NCNAME_RE);
	public static final Pattern QNAME_PATTERN = Pattern.compile(QNAME_RE);


	public static boolean isIgnorableWhitespace(String input) {
		return IGNORABLE_WHITESPACE_PATTERN.matcher(input).matches();
	}

	public static boolean isString(String input) {
		return STRING_PATTERN.matcher(input).matches();
	}
	public static boolean isNormalizedString(String input) {
		return NORMALIZED_STRING_PATTERN.matcher(input).matches();
	}
	public static boolean isToken(String input) {
		return TOKEN_PATTERN.matcher(input).matches();
	}
	public static boolean isLanguage(String input) {
		return LANGUAGE_PATTERN.matcher(input).matches();
	}

	public static boolean isName(String input) {
		return NAME_PATTERN.matcher(input).matches();
	}
	public static boolean isNMToken(String input) {
		return NMTOKEN_PATTERN.matcher(input).matches();
	}
	public static boolean isNCName(String input) {
		return NCNAME_PATTERN.matcher(input).matches();
	}

	public static String toNCName(String input) {
		input = input.replaceAll("[:[^"+NAME_CHARS+"]]", "_");
		return isNCName(input) ? input : "_"+input;
	}
	public static boolean isQName(String input) {
		return QNAME_PATTERN.matcher(input).matches();
	}
	public static String getPrefix(String input) {
		Matcher matcher = QNAME_PATTERN.matcher(input);
		return matcher.matches() ?
				matcher.group(1) : null;
	}
	public static String getLocalPart(String input) {
		Matcher matcher = QNAME_PATTERN.matcher(input);
		return matcher.matches() ?
				matcher.group(2) : null;
	}

	public static final String DECIMAL_RE = "[-+]?\\d+(\\.\\d*)?";
	public static final Pattern DECIMAL_PATTERN = Pattern.compile(DECIMAL_RE);
	public static boolean isDecimal(String input) {
		return DECIMAL_PATTERN.matcher(input).matches();
	}

	public static URI parseURI(String uri) {
		try {
			int length = uri.length();
			StringBuilder sb = new StringBuilder(length*2);
			for (int i=0; i<length; i++) {
				char ch = uri.charAt(i);
				switch (ch) {
				case '<': case '>': case '{': case '}':
				case '"': case '|': case '^': case '`': case '\\':
					break;
				default:
					if (Character.isISOControl(ch) || Character.isWhitespace(ch))
						break;
				sb.append(ch);
				continue;
				}
				sb.append('%');
				sb.append(StringUtils.byteToHex((byte) (ch & 0xff)));
			}	
			return new URI(sb.toString());
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static String encodingFromXmlDeclaration(int magic) {
		// if there's no byte order mark, try to guess
		// using XML delcaration's first characters "<?xm" 
		switch (magic) {
		case 0x0000003C:
			return "UTF-32BE";
		case 0x3C000000:
			return "UTF-32LE";
		case 0x003C003F:
			return "UTF-16BE";
		case 0x3C003F00:
			return "UTF-16LE";
		case 0x3C3F786D:
			return "UTF-8";
		case 0x4C6FA794:
			return "EBCDIC";
		}
		return null;
	}

	private static final Pattern ENCODING_PATTERN = Pattern.compile("encoding\\s*=\\s*[\"']([^\"']+)", Pattern.CASE_INSENSITIVE);
	public static String guessEncoding(InputStream is, String defaultEncoding) {
		String encoding = null;
		try {
			// both the BOM and the xml declaration heuristic
			// algorithms need at least the first four bytes
			byte[] bytes = StringUtils.peekBytes(is, 4, true);

			if (bytes != null) {
				int magic = 0;
				for (int i=0; i<bytes.length; i++)
					magic |= (bytes[i] & 0xFF) << (8*(3-i));

				encoding = StringUtils.encodingFromBOM(magic);

				// skip bom length bytes
				is.read(bytes, 0, StringUtils.bomLength(magic));

				if (encoding == null) {
					encoding = XmlUtils.encodingFromXmlDeclaration(magic);

					if (encoding != null && !encoding.startsWith("UTF-32")) {
						String xmlDecl = new String(StringUtils.peekBytes(is, 1024, false), encoding);
						int endIndex = xmlDecl.indexOf("?>");
						xmlDecl = endIndex != -1 ? xmlDecl.substring(0, endIndex) : xmlDecl;
						java.util.regex.Matcher matcher = ENCODING_PATTERN.matcher(xmlDecl);
						if (matcher.find())
							encoding = Charset.forName(matcher.group(1)).name();
					}
				}
			}
		} catch (Exception e) {
			encoding = null;
		}
		return encoding != null ? encoding : defaultEncoding;
	}

	private static final String XML_DECL_PREFIX = "<?xml";
	public static boolean hasXmlDecl(Reader reader, boolean defaultValue) {
		try {
			char[] prefixChars = StringUtils.peekChars(reader, XML_DECL_PREFIX.length());
			String prefixString = new String(prefixChars);
			return XML_DECL_PREFIX.equals(prefixString);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	public static boolean hasXmlDecl(InputStream is, String encoding, boolean defaultValue) {
		try {
			byte[] bytes = XML_DECL_PREFIX.getBytes(encoding);
			return Arrays.equals(bytes, StringUtils.peekBytes(is, bytes.length, false));
		} catch (Exception e) {
			return defaultValue;
		}
	}
}
