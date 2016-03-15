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
package org.whole.lang.parsers;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class DefaultDataTypePresentationParser extends DefaultDataTypePersistenceParser {
	public static final IDataTypeParser instance = new DefaultDataTypePresentationParser();
	protected DefaultDataTypePresentationParser() {
	}

	protected DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
	protected DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	protected DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public Date parseDate(EntityDescriptor<?> ed, String value) {
		try {
			return shortDateFormat.parse(value);
		} catch (ParseException e1) {
			try {
				return longDateFormat.parse(value);
			} catch (ParseException e2) {
				try {
					return mediumDateFormat.parse(value);
				} catch (ParseException e3) {
					throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
				}
			}
		}
	}
	public String unparseDate(EntityDescriptor<?> ed, Date value) {
		return shortDateFormat.format(value);
	}

	protected DateFormat shortTimeFormat = DateFormat.getDateInstance(DateFormat.SHORT);
	protected DateFormat mediumTimeFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM);
	protected DateFormat longTimeFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public Date parseTime(EntityDescriptor<?> ed, String value) {
		try {
			return mediumTimeFormat.parse(value);
		} catch (ParseException e1) {
			try {
				return shortTimeFormat.parse(value);
			} catch (ParseException e2) {
				try {
					return longTimeFormat.parse(value);
				} catch (ParseException e3) {
					throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
				}
			}
		}
	}
	public String unparseTime(EntityDescriptor<?> ed, Date value) {
		return mediumTimeFormat.format(value);
	}

	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		EnumType<?> dataEnumType = ed.getDataEnumType();
		if (dataEnumType == null)
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		
		EnumValue result = dataEnumType.valueOf(value);
		if (result != null)
			return result;

		for (Iterator<? extends EnumValue> i = dataEnumType.iterator(); i.hasNext();) {
			EnumValue enumValue = i.next();
			if (enumValue.getName().equalsIgnoreCase(value))
				return enumValue;
		}
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
}
