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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class CommonsDataTypePersistenceParser extends DefaultDataTypePersistenceParser {
	private static class SingletonHolder {
		private static final CommonsDataTypePersistenceParser instance = new CommonsDataTypePersistenceParser();
	}
	public static CommonsDataTypePersistenceParser instance() {
		return SingletonHolder.instance;
	}
	protected CommonsDataTypePersistenceParser() {
	}

	@Override
	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		EnumValue enumValue = null;
		switch (ed.getOrdinal()) {
		case CommonsEntityDescriptorEnum.Quantifier_ord:
			enumValue = parseQuantifier(value);
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
			return unparseQuantifier(value);
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

	//FIXME remove. Fails on names containing #
	public static boolean hasLanguageKitPart(String descriptorUri) {
		return descriptorUri.indexOf('#') > 0;
	}
	public static ILanguageKit getLanguageKitPart(String descriptorUri) {
		int index = descriptorUri.indexOf('#');
		if (index > 0) {
			String languageUri = descriptorUri.substring(0, index);
			if (ReflectionFactory.hasLanguageKit(languageUri))
				return ReflectionFactory.getLanguageKit(languageUri);
		}
		return null;
	}
	public static String getDescriptorNamePart(String descriptorUri) {
		int index = descriptorUri.indexOf("#");
		if (index > 0) {
			String languageUri = descriptorUri.substring(0, index);
			if (ReflectionFactory.hasLanguageKit(languageUri, false, null))
				return descriptorUri.substring(index+1);
		}
		return null;
	}

	public static EntityDescriptor<? extends IEntity> getEntityDescriptor(String edUri) {
		return getEntityDescriptor(edUri, false, null);
	}
	public static EntityDescriptor<? extends IEntity> getEntityDescriptor(String edUri, boolean loadOnDemand, String contextURI) {
		int index = edUri.indexOf('#');
		if (index > 0) {
			String languageUri = edUri.substring(0, index);
			if (ReflectionFactory.hasLanguageKit(languageUri, loadOnDemand, contextURI)) {
				ILanguageKit lk = ReflectionFactory.getLanguageKit(languageUri, loadOnDemand, contextURI);
	    		EntityDescriptor<?> ed = lk.getEntityDescriptorEnum().valueOf(edUri.substring(index+1));
	    		if (ed != null)
	    			return ed;
			}
		}
		return null;
	}
	public static FeatureDescriptor getFeatureDescriptor(String fdUri, boolean loadOnDemand, String contextURI) {
		int index = fdUri.indexOf('#');
		if (index > 0) {
			String languageUri = fdUri.substring(0, index);
			if (ReflectionFactory.hasLanguageKit(languageUri, loadOnDemand, contextURI)) {
				ILanguageKit lk = ReflectionFactory.getLanguageKit(languageUri, loadOnDemand, contextURI);
	    		FeatureDescriptor fd = lk.getFeatureDescriptorEnum().valueOf(fdUri.substring(index+1));
	    		if (fd != null)
	    			return fd;
			}
		}
		return null;
	}

	public static EntityDescriptor<? extends IEntity> parseEntityDescriptor(String edUri) {
		EntityDescriptor<?> ed = getEntityDescriptor(edUri, true, null);
		if (ed == null)
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);

		return ed;
	}
	public static String unparseEntityDescriptor(EntityDescriptor<?> ed) {
		return ed.getLanguageKit().getURI()+'#'+ed.getName();//TODO ? getImplName()
	}

	public static FeatureDescriptor parseFeatureDescriptor(String fdUri) {
		FeatureDescriptor fd = getFeatureDescriptor(fdUri, true, null);
		if (fd == null)
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);

		return fd;
	}
	public static String unparseFeatureDescriptor(FeatureDescriptor fd) {
		return fd.getLanguageKit().getURI()+'#'+fd.getName();//TODO ? getImplName()
	}

	private static Map<String, QuantifierEnum.Value> quantifierMap;
	public static final QuantifierEnum.Value parseQuantifier(String value) {
		if (quantifierMap == null) {
			quantifierMap = new HashMap<String, QuantifierEnum.Value>();

			quantifierMap.put("?", QuantifierEnum.OPTIONAL);
			quantifierMap.put("!", QuantifierEnum.MANDATORY);
			quantifierMap.put("*", QuantifierEnum.ZERO_OR_MORE_GREEDY);
			quantifierMap.put("+", QuantifierEnum.ONE_OR_MORE_GREEDY);
			quantifierMap.put("*?", QuantifierEnum.ZERO_OR_MORE_RELUCTANT);
			quantifierMap.put("+?", QuantifierEnum.ONE_OR_MORE_RELUCTANT);
			quantifierMap.put("*+", QuantifierEnum.ZERO_OR_MORE_POSSESSIVE);
			quantifierMap.put("++", QuantifierEnum.ONE_OR_MORE_POSSESSIVE);

			assert QuantifierEnum.instance.size() == quantifierMap.size();
		}
		return quantifierMap.get(value);
	}
	public static final String unparseQuantifier(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case QuantifierEnum.OPTIONAL_ord:
    		return "?";
    	case QuantifierEnum.MANDATORY_ord:
    		return "!";
    	case QuantifierEnum.ZERO_OR_MORE_GREEDY_ord:
    		return "*";
    	case QuantifierEnum.ONE_OR_MORE_GREEDY_ord:
    		return "+";
    	case QuantifierEnum.ZERO_OR_MORE_RELUCTANT_ord:
    		return "*?";
    	case QuantifierEnum.ONE_OR_MORE_RELUCTANT_ord:
    		return "+?";
    	case QuantifierEnum.ZERO_OR_MORE_POSSESSIVE_ord:
    		return "*+";
    	case QuantifierEnum.ONE_OR_MORE_POSSESSIVE_ord:
    		return "++";
    	default:
    		throw new IllegalArgumentException();
    	}
	}
}
