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
package org.whole.lang.properties.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class PropertiesDataTypePersistenceParser extends DefaultDataTypePersistenceParser {
	private static final Pattern WS_SEQUENCE = Pattern.compile("[ \\t\\f]*[\\r\\n][ \\t\\f\\r\\n]*");

	private static class SingletonHolder {
		private static final PropertiesDataTypePersistenceParser instance = new PropertiesDataTypePersistenceParser();
	}
	public static PropertiesDataTypePersistenceParser instance() {
		return SingletonHolder.instance;
	}
	protected PropertiesDataTypePersistenceParser() {
	}

	@Override
	public String parseString(EntityDescriptor<?> ed, String value) {
		String stringValue = null;
		switch (ed.getOrdinal()) {
		case PropertiesEntityDescriptorEnum.PropertyName_ord:
			stringValue = parseStringValue(value);
			break;
		}
		if (stringValue != null)
			return stringValue;
		else
			return super.parseString(ed, value);
	}

	@Override
	public String unparseString(EntityDescriptor<?> ed, String value) {
		switch (ed.getOrdinal()) {
		case PropertiesEntityDescriptorEnum.PropertyName_ord:
			return unparseStringValue(value);
		default:
			return super.unparseString(ed, value);
		}
	}

	protected String parseStringValue(String value) {
		return unescapePropertyString(value);
	}
	protected String unparseStringValue(String value) {
		return escapePropertyString(value);
	}

	public static String escapePropertyString(String t) {
		StringBuilder r = new StringBuilder();
		for (int j=0; j<t.length(); ++j) {
			char c = t.charAt(j);
			if (c==' ')
				r.append(' ');
			else if (c=='\n')
				r.append("\\n");
			else if (c=='\r')
				r.append("\\r");
			else if (c=='=')
				r.append("\\=");
			else if (c==':')
				r.append("\\:");
			else if (c=='\t')
				r.append("\\t");
			else if (c=='\f')
				r.append("\\f");
			else if (c=='\\')
				r.append("\\\\");
			else if (Character.isISOControl(c) || Character.isWhitespace(c)) {
				r.append("\\u");
				r.append(StringUtils.charToHex(c));
			} else
				r.append(c);
		}
		return r.toString();
	}

	/**
	 * Properties escape sequences are specified in
	 * {@link java.util.Properties#load(java.io.Reader) load(Reader)}.
	 */
	public static String unescapePropertyString(String t) {
		StringBuilder r = new StringBuilder();
		int length = t.length();
		int j=0;
		while (j<length) {
			char c = t.charAt(j);
			if (c=='\\') {
				c = t.charAt(++j);
				switch (c) {
				case 'n':
					r.append('\n');
					break;
				case 't':
					r.append('\t');
					break;
				case 'r':
					r.append('\r');
					break;
				case 'f':
					r.append('\f');
					break;
				case '\\':
					r.append('\\');
					break;
				case 'u':
					r.append((char) Integer.parseInt(t.substring(j+1, j+5), 16));
					j += 4;
					break;
				case '\t':
				case '\f':
				case ' ':
					Matcher matcher = WS_SEQUENCE.matcher(t.substring(j+1));
					if (matcher.find()) {
						j += matcher.end()-matcher.start();
						break;
					}
				default:
					r.append(c);
				}
			} else
				r.append(c);
			j++;
		}
		return r.toString();
	}
}
