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
package org.whole.lang.xsd.mapping.util;

import java.util.Collection;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.util.QName;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.codebase.MappingStrategyRegistry;

/**
 * @author Enrico Persiani
 */
public class MappingStrategyUtils {
	public static IMappingStrategy getMappingStrategy(String uri) {
		return MappingStrategyRegistry.instance().getMappingStrategy(uri);
	}
	public static boolean hasMappingStrategy(String uri) {
		//TODO check if can derive from languageKit
		return MappingStrategyRegistry.instance().hasMappingStrategy(uri);
	}
	public static IMappingStrategy getMappingStrategy(ILanguageKit languageKit) {
		return getMappingStrategy(languageKit.getURI());
	}
	public static IMappingStrategy getMappingStrategy(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed.getLanguageKit());
	}
	public static boolean hasMappingStrategy(QName name) {
		return hasMappingStrategy(name.getNamespaceURI());
	}

	public static Collection<FeatureDescriptor> getElementFeatureMappings(EntityDescriptor<?> ed, QName name) {
		return getMappingStrategy(ed).getElementFeatureMappings(ed, name);
	}
	public static EntityDescriptor<?> getElementEntityMapping(EntityDescriptor<?> ed, QName name) {
		return getMappingStrategy(ed).getElementEntityMapping(ed, name);
	}
	public static FeatureDescriptor getAttributeFeatureMapping(EntityDescriptor<?> ed, QName name) {
		return getMappingStrategy(ed).getAttributeFeatureMapping(ed, name);
	}
	public static EntityDescriptor<?> getAttributeEntityMapping(EntityDescriptor<?> ed, QName name) {
		return getMappingStrategy(ed).getAttributeEntityMapping(ed, name);
	}
	public static FeatureDescriptor getStructuralFeatureMapping(EntityDescriptor<?> ed, QName name) {
		return getMappingStrategy(ed).getStructuralFeatureMapping(ed, name);
	}
	public static EntityDescriptor<?> getStructuralEntityMapping(EntityDescriptor<?> ed, QName name) {
		return getMappingStrategy(ed).getStructuralEntityMapping(ed, name);
	}
	public static FeatureDescriptor getContentFeatureMapping(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).getContentFeatureMapping(ed);
	}
	public static EntityDescriptor<?> getContentEntityMapping(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).getContentEntityMapping(ed);
	}
	public static Collection<EntityDescriptor<?>> getUnionEntityMappings(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).getUnionEntityMappings(ed);
	}
	public static EntityDescriptor<?> getRootEntityMapping(QName name) {
		return getMappingStrategy(name.getNamespaceURI()).getRootEntityMapping(name);
	}
	public static String getRootElementNCName(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).getRootElementNCName(ed);
	}

	public static FeatureDescriptor getMixedStructuralFeature(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).getMixedStructuralFeatureMapping(ed);
	}
	public static EntityDescriptor<?> getMixedDataType(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).getMixedDataType();
	}
	public static EntityDescriptor<?> getMixedStructuralType(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).getMixedStructuralEntityMapping(ed);
	}
	public static boolean hasMixedContent(EntityDescriptor<?> ed) {
		return getMappingStrategy(ed).isMixedType(ed);
	}
	public static boolean hasMixedStructuralMapping(EntityDescriptor<?> ed) {
		return getMixedStructuralType(ed) != null;
	}
	
	public static boolean hasStructuralEntityMapping(EntityDescriptor<?> ed, QName name) {
		return getStructuralEntityMapping(ed, name) != null;
	}
	public static boolean hasElementEntityMapping(EntityDescriptor<?> ed, QName name) {
		return getElementEntityMapping(ed, name) != null;
	}
	public static boolean hasAttributeEntityMapping(EntityDescriptor<?> ed, QName name) {
		return getAttributeEntityMapping(ed, name) != null;
	}
	public static boolean hasContentEntityMapping(EntityDescriptor<?> ed) {
		return getContentEntityMapping(ed) != null;
	}

	public static String getElementNCName(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return getMappingStrategy(context).getElementNCName(context, ed, fd);
	}
	public static String getAttributeNCName(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return getMappingStrategy(context).getAttributeNCName(context, ed, fd);
	}
	public static boolean isStructuralMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return getMappingStrategy(context).isStructuralMapping(context, ed, fd);
	}

	public static IMappingStrategy getMappingStrategy(IEntity entity) {
		IEntity parent = entity.wGetParent();
		EntityDescriptor<?> ed = EntityUtils.isNull(parent) ? 
				CommonsEntityDescriptorEnum.RootFragment : parent.wGetEntityDescriptor();
		return getMappingStrategy(ed.getLanguageKit().getURI());
	}

	public static boolean hasElementNCName(IEntity entity) {
		return getElementNCName(entity) != null;
	}
	public static String getElementNCName(IEntity entity) {
		EntityDescriptor<?> context;
		FeatureDescriptor fd;

		IEntity parent = entity.wGetParent();
		if (EntityUtils.isNull(parent)) {
			context = CommonsEntityDescriptorEnum.RootFragment;
			fd = CommonsFeatureDescriptorEnum.rootEntity;
		} else {
			context = parent.wGetEntityDescriptor();
			fd = parent.wGetFeatureDescriptor(entity);
		}
		IMappingStrategy strategy = getMappingStrategy(context.getLanguageKit().getURI());
		return strategy == null ? null :
			strategy.getElementNCName(context, entity.wGetEntityDescriptor(), fd);
	}
	public static boolean hasAttributeNCName(IEntity entity) {
		return getAttributeNCName(entity) != null;
	}
	public static String getAttributeNCName(IEntity entity) {
		EntityDescriptor<?> context;
		FeatureDescriptor fd;

		IEntity parent = entity.wGetParent();
		if (EntityUtils.isNull(parent)) {
			context = CommonsEntityDescriptorEnum.RootFragment;
			fd = CommonsFeatureDescriptorEnum.rootEntity;
		} else {
			context = parent.wGetEntityDescriptor();
			fd = parent.wGetFeatureDescriptor(entity);
		}
		IMappingStrategy strategy = getMappingStrategy(context.getLanguageKit().getURI());
		return strategy == null ? null :
			strategy.getAttributeNCName(context, entity.wGetEntityDescriptor(), fd);
	}

	public static boolean isMixedType(IEntity entity) {
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		return getMappingStrategy(ed).isMixedType(ed);
	}
}
