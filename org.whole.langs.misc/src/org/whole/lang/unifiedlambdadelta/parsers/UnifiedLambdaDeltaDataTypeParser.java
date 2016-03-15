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
package org.whole.lang.unifiedlambdadelta.parsers;

import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class UnifiedLambdaDeltaDataTypeParser extends DefaultDataTypePresentationParser {
	private static final UnifiedLambdaDeltaDataTypeParser instance = new UnifiedLambdaDeltaDataTypeParser();
	public static UnifiedLambdaDeltaDataTypeParser instance() {
		return instance;
	}
	protected UnifiedLambdaDeltaDataTypeParser() {
	}

	@Override
	public boolean parseBoolean(EntityDescriptor<?> ed, String value) {
		if (ed.equals(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity)) {
			if (value.equals("+"))
				return true;
			else if (value.equals("-"))
				return false;
		} else if (ed.equals(UnifiedLambdaDeltaEntityDescriptorEnum.Access)) {
			if (value.equals(""))
				return true;
			else if (value.equals("_"))
				return false;
		}

		return super.parseBoolean(ed, value);
	}
	@Override
	public String unparseBoolean(EntityDescriptor<?> ed, boolean value) {
		if (ed.equals(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity))
			return value ? "+" : "-";
		else if (ed.equals(UnifiedLambdaDeltaEntityDescriptorEnum.Access))
			return value ? "" : "_";
		else
			return super.unparseBoolean(ed, value);
	}
}
