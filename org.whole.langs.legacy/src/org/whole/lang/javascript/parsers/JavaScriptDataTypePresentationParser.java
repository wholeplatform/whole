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
package org.whole.lang.javascript.parsers;

import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class JavaScriptDataTypePresentationParser extends JavaScriptDataTypePersistenceParser {
	private static class SingletonHolder {
		private static final JavaScriptDataTypePresentationParser instance = new JavaScriptDataTypePresentationParser();
	}
	public static JavaScriptDataTypePresentationParser instance() {
		return SingletonHolder.instance;
	}
	protected JavaScriptDataTypePresentationParser() {
	}

	@Override
	public String parseString(EntityDescriptor<?> ed, String value) {
		if (ed.getOrdinal() == JavaScriptEntityDescriptorEnum.StringLiteral_ord)
			return parseStringLiteral(value);
		else
			return super.parseString(ed, value);
	}

	@Override
	public String unparseString(EntityDescriptor<?> ed, String value) {
		if (ed.getOrdinal() == JavaScriptEntityDescriptorEnum.StringLiteral_ord)
			return unparseStringLiteral(value);
		else
			return super.unparseString(ed, value);
	}

	private String parseStringLiteral(String value) {
		return StringUtils.unescapeString(value);
	}

	private String unparseStringLiteral(String value) {
		return StringUtils.escapeString(value, true, true);
	}
}
