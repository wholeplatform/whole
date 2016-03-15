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
package org.whole.lang.tests.parsers;

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.util.WholeMessages;


/**
 * @author Enrico Persiani
 */
public class TestsDataTypePresentationParser extends DefaultDataTypePresentationParser {
	private static class SingletonHolder {
		private static final TestsDataTypePresentationParser instance = new TestsDataTypePresentationParser();
	}
	public static TestsDataTypePresentationParser instance() {
		return SingletonHolder.instance;
	}
	protected TestsDataTypePresentationParser() {
	}

	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		if (TestsEntityDescriptorEnum.CommentKind_ord == ed.getOrdinal()) {
			EnumType<?> dataEnumType = ed.getDataEnumType();
			if (dataEnumType == null)
				throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
			
			EnumValue result = dataEnumType.valueOf(value);
			if (result == null)
				throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		
			return result;
		} else
			return super.parseEnumValue(ed, value);
	}

	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		if (TestsEntityDescriptorEnum.CommentKind_ord == ed.getOrdinal())
			return value.toString().toUpperCase();
		else
			return super.unparseEnumValue(ed, value);
	}
}
