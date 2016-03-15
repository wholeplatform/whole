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
package org.whole.lang.commons.parsers;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class CommonsDataTypePresentationParser extends DefaultDataTypePresentationParser {
	private static class SingletonHolder {
		private static CommonsDataTypePresentationParser instance = new CommonsDataTypePresentationParser();
	}
	public static CommonsDataTypePresentationParser instance() {
		return SingletonHolder.instance;
	}
	protected CommonsDataTypePresentationParser() {
	}

	@Override
	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		EnumValue enumValue = null;
		switch (ed.getOrdinal()) {
		case CommonsEntityDescriptorEnum.Quantifier_ord:
			enumValue = CommonsDataTypePersistenceParser.parseQuantifier(value);
			break;
		}
		if (enumValue != null)
			return enumValue;
		else
			return super.parseEnumValue(ed, value);			
	}
	@Override
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		switch (ed.getOrdinal()) {
		case CommonsEntityDescriptorEnum.Quantifier_ord:
			return CommonsDataTypePersistenceParser.unparseQuantifier(value);
		default:
			return super.unparseEnumValue(ed, value);
		}
	}

	@Override
	public Object parseObject(EntityDescriptor<?> ed, String value) {
		switch (ed.getOrdinal()) {
		case CommonsEntityDescriptorEnum.VarType_ord:
			return parseEntityDescriptor(value);
		}
		return super.parseObject(ed, value);
	}
	@Override
	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		switch (ed.getOrdinal()) {
		case CommonsEntityDescriptorEnum.VarType_ord:
			return unparseEntityDescriptor((EntityDescriptor<?>) value);
		}
		return super.unparseObject(ed, value);
	}

	public static EntityDescriptor<? extends IEntity> parseEntityDescriptor(String value) {
		int index = value.indexOf('#');
		if (index > 0) {
			String languageUri = value.substring(0, index);
    		ILanguageKit lk /*= null;
			if (ReflectionFactory.hasLanguageKit(languageUri)) {
    			for (ILanguageKit lk2 : ReflectionFactory.getLanguageKits(true))
    				if (lk2.getName().equalsIgnoreCase(languageUri)) {
    					lk = lk2; 
    					break;
    				}
    		}
    		if (lk == null)
    			lk*/ = ReflectionFactory.getLanguageKit(languageUri);

	    	EntityDescriptor<?> ed = lk.getEntityDescriptorEnum().valueOf(value.substring(index+1));
    		if (ed != null)
    			return ed;
		}
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public static String unparseEntityDescriptor(EntityDescriptor<?> ed) {
		return ed.getLanguageKit().getName()+'#'+ed.getName();
	}

	public static FeatureDescriptor parseFeatureDescriptor(String value) {
		int index = value.indexOf('#');
		if (index > 0) {
			String languageUri = value.substring(0, index);
    		ILanguageKit lk /*= null;
			if (ReflectionFactory.hasLanguageKit(languageUri)) {
    			for (ILanguageKit lk2 : ReflectionFactory.getLanguageKits(true))
    				if (lk2.getName().equalsIgnoreCase(languageUri)) {
    					lk = lk2; 
    					break;
    				}
    		}
    		if (lk == null)
    			lk*/ = ReflectionFactory.getLanguageKit(languageUri);

    		FeatureDescriptor fd = lk.getFeatureDescriptorEnum().valueOf(value.substring(index+1));
   			if (fd != null)
   				return fd;
		}
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public static String unparseFeatureDescriptor(FeatureDescriptor fd) {
		return fd.getLanguageKit().getName()+'#'+fd.getName();
	}
}
