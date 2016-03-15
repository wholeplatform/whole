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
package org.whole.lang.patterns.parsers;

import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class PatternsDataTypePresentationParser extends DefaultDataTypePresentationParser {
	private static final PatternsDataTypePresentationParser instance = new PatternsDataTypePresentationParser();
	public static PatternsDataTypePresentationParser instance() {
		return instance;
	}
	protected PatternsDataTypePresentationParser() {
	}

	@Override
	public boolean parseBoolean(EntityDescriptor<?> ed, String value) {
		if (PatternsEntityDescriptorEnum.BooleanValue.equals(ed)) {
			if ("?".equals(value))
				return true;
			if ("!".equals(value))
				return false;
		}
		return super.parseBoolean(ed, value);
	}
	
	@Override
	public String unparseBoolean(EntityDescriptor<?> ed, boolean value) {
		if (PatternsEntityDescriptorEnum.BooleanValue.equals(ed))
			return value ? "?" : "!";
		else
			return super.unparseBoolean(ed, value);
	}
}
