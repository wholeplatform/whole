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
package org.whole.lang.java.parsers;

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Enrico Persiani
 */
public class JavaDataTypePresentationParser extends JavaDataTypePersistenceParser {
	private static class SingletonHolder {
		private static final JavaDataTypePresentationParser instance = new JavaDataTypePresentationParser();
	}
	public static JavaDataTypePresentationParser instance() {
		return SingletonHolder.instance;
	}
	protected JavaDataTypePresentationParser() {
	}

	@Override
	public String parseString(EntityDescriptor<?> ed, String value) {
		switch (ed.getOrdinal()) {
		case JavaEntityDescriptorEnum.StringLiteral_ord:
			return parseStringLiteral(value);
		case JavaEntityDescriptorEnum.SimpleType_ord:
			if (StringUtils.isPrimitive(value) || StringUtils.isQualified(value))
				throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
			break;
		case JavaEntityDescriptorEnum.QualifiedType_ord:
			if (StringUtils.isPrimitive(value) || !StringUtils.isQualified(value))
				throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
			break;
		}
		return super.parseString(ed, value);
	}

	@Override
	public String unparseString(EntityDescriptor<?> ed, String value) {
		if (ed.getOrdinal() == JavaEntityDescriptorEnum.StringLiteral_ord)
			return unparseStringLiteral(value);
		else
			return super.unparseString(ed, value);
	}

	private String parseStringLiteral(String value) {
		return StringUtils.unescapeString(value);
	}

	private String unparseStringLiteral(String value) {
		return StringUtils.escapeString(value, true, false);
	}
}
