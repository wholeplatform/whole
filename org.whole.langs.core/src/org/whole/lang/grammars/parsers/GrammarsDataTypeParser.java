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
package org.whole.lang.grammars.parsers;

import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class GrammarsDataTypeParser extends DefaultDataTypePresentationParser {
	private static class SingletonHolder {
		private static final GrammarsDataTypeParser instance = new GrammarsDataTypeParser();
	}
	public static GrammarsDataTypeParser instance() {
		return SingletonHolder.instance;
	}
	protected GrammarsDataTypeParser() {
	}

	@Override
	public String parseString(EntityDescriptor<?> ed, String value) {
		switch (ed.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.Literal_ord:
			return parseLiteral(value);
		case GrammarsEntityDescriptorEnum.Format_ord:
			return parseFormat(value);
		default:
			return super.parseString(ed, value);
		}
	}

	@Override
	public String unparseString(EntityDescriptor<?> ed, String value) {
		switch (ed.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.Literal_ord:
			return unparseLiteral(value);
		case GrammarsEntityDescriptorEnum.Format_ord:
			return unparseFormat(value);
		default:
			return super.unparseString(ed, value);
		}
	}

	public String parseLiteral(String value) {
		return StringUtils.unescapeString(value);
	}
	public String unparseLiteral(String value) {
		return StringUtils.escapeString(value, true, false);
	}
	public String parseFormat(String value) {
		return StringUtils.unescapeString(value);
	}
	public String unparseFormat(String value) {
		return StringUtils.escapeString(value, true, false);
	}
}
