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
package org.whole.lang.xsd.codebase;

import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.*;
import static org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.util.QName;
import org.whole.lang.xsd.codebase.MappingIndexes.CompiledMapping;
import org.whole.lang.xsd.util.SchemaUtils;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractMappingStrategy implements IMappingStrategy {
	protected MappingIndexes indexes;
	protected  Map<EntityDescriptor<?>, IDataTypeParser> parsers;

	public AbstractMappingStrategy() {
		indexes = new MappingIndexes();
		parsers = new HashMap<EntityDescriptor<?>, IDataTypeParser>();
	}

	public EntityDescriptor<?> getElementEntityMapping(EntityDescriptor<?> context, QName name) {
		CompiledMapping mapping = indexes.findMapping(ElementMapping, context, name.getLocalPart());
		if (mapping.isNull())
			mapping = indexes.findMapping(AnyElementMapping, context);
		return mapping.ed;
	}
	public Collection<FeatureDescriptor> getElementFeatureMappings(EntityDescriptor<?> context, QName name) {
		Set<CompiledMapping> mappings = indexes.findMappings(ElementMapping, context, name.getLocalPart());
		if (mappings.isEmpty())
			mappings = Collections.singleton(indexes.findMapping(AnyElementMapping, context));
		Set<FeatureDescriptor> featureMappings = new HashSet<FeatureDescriptor>(mappings.size());
		for (CompiledMapping mapping : mappings)
			featureMappings.add(mapping.fd);
		return featureMappings;
	}

	protected CompiledMapping getAttributeMapping(EntityDescriptor<?> context, QName name) {
		CompiledMapping mapping = indexes.findMapping(AttributeMapping, context, name.getLocalPart());
		if (mapping.isNull())
			mapping = indexes.findMapping(AnyAttributeMapping, context);
		return mapping;
	}
	public EntityDescriptor<?> getAttributeEntityMapping(EntityDescriptor<?> context, QName name) {
		return getAttributeMapping(context, name).ed;
	}
	public FeatureDescriptor getAttributeFeatureMapping(EntityDescriptor<?> context, QName name) {
		return getAttributeMapping(context, name).fd;
	}

	protected CompiledMapping getStructuralMapping(EntityDescriptor<?> context, QName name) {
		CompiledMapping mapping = indexes.findMapping(StructuralMapping, context, name.getLocalPart());
		if (mapping.isNull())
			mapping = indexes.findMapping(AnyStructuralMapping, context);
		return mapping;
	}
	public EntityDescriptor<?> getStructuralEntityMapping(EntityDescriptor<?> context, QName name) {
		return getStructuralMapping(context, name).ed;
	}
	public FeatureDescriptor getStructuralFeatureMapping(EntityDescriptor<?> context, QName name) {
		return getStructuralMapping(context, name).fd;
	}

	public EntityDescriptor<?> getContentEntityMapping(EntityDescriptor<?> context) {
		return indexes.findMapping(ContentMapping, context).ed;
	}
	public FeatureDescriptor getContentFeatureMapping(EntityDescriptor<?> context) {
		return indexes.findMapping(ContentMapping, context).fd;
	}

	public EntityDescriptor<?> getMixedStructuralEntityMapping(EntityDescriptor<?> context) {
		return indexes.findMapping(MixedStructuralMapping, context).ed;
	}
	public FeatureDescriptor getMixedStructuralFeatureMapping(EntityDescriptor<?> context) {
		return indexes.findMapping(MixedStructuralMapping, context).fd;
	}

	public String getAttributeNCName(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return indexes.findMapping(AttributeMapping, context, ed, fd).ncname;
	}
	public String getElementNCName(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		if (SchemaUtils.isAnyType(context.getEntityDescriptor(fd)))
			return getRootElementNCName(ed);
		else
			return indexes.findMapping(ElementMapping, context, ed, fd).ncname;
	}
	public boolean isContentMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return indexes.findMapping(ContentMapping, context, ed, fd) != CompiledMapping.NULL;
	}
	public boolean isMixedStructuralMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return indexes.findMapping(MixedStructuralMapping, context, ed, fd) != CompiledMapping.NULL;
	}

	public EntityDescriptor<?> getRootEntityMapping(QName name) {
		return indexes.findMapping(name.getLocalPart()).ed;
	}
	public String getRootElementNCName(EntityDescriptor<?> ed) {
		return indexes.findMapping(ed).ncname;
	}

	public String getAttributeNCName(IEntity entity) {
		IEntity parent = entity.wGetParent().wGetAdaptee(false);
		return getAttributeNCName(EntityUtils.isFragment(parent) ? 
				RootFragment : parent.wGetEntityDescriptor(),
				parent.wGetEntityDescriptor(entity), parent.wGetFeatureDescriptor(entity));
	}
	public String getElementNCName(IEntity entity) {
		IEntity parent = entity.wGetParent().wGetAdaptee(false);
		return getElementNCName(EntityUtils.isFragment(parent) ? 
				RootFragment : parent.wGetEntityDescriptor(),
				parent.wGetEntityDescriptor(entity), parent.wGetFeatureDescriptor(entity));
	}
	public boolean isAttributeMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return getAttributeNCName(context, ed, fd) != null;
	}
	public boolean isAttributeMapping(IEntity entity) {
		return getAttributeNCName(entity) != null;
	}

	public boolean isElementMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return getElementNCName(context, ed, fd) != null;
	}
	public boolean isElementMapping(IEntity entity) {
		return getElementNCName(entity) != null;
	}

	public boolean isStructuralMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return indexes.findMapping(StructuralMapping, context, ed, fd) != CompiledMapping.NULL;
	}
	public boolean isStructuralMapping(IEntity entity) {
		IEntity parent = entity.wGetParent().wGetAdaptee(false);
		return isStructuralMapping(EntityUtils.isFragment(parent) ? 
				RootFragment : parent.wGetEntityDescriptor(),
				parent.wGetEntityDescriptor(entity), parent.wGetFeatureDescriptor(entity));
	}

	public boolean isContentMapping(IEntity entity) {
		IEntity parent = entity.wGetParent().wGetAdaptee(false);
		return isContentMapping(EntityUtils.isFragment(parent) ? 
				RootFragment : parent.wGetEntityDescriptor(),
				entity.wGetEntityDescriptor(), parent.wGetFeatureDescriptor(entity));
	}

	public boolean isMixedStructuralMapping(IEntity entity) {
		IEntity parent = entity.wGetParent().wGetAdaptee(false);
		return isMixedStructuralMapping(EntityUtils.isFragment(parent) ? 
				RootFragment : parent.wGetEntityDescriptor(),
				entity.wGetEntityDescriptor(), parent.wGetFeatureDescriptor(entity));
	}
	
	public Map<EntityDescriptor<?>, IDataTypeParser> getDataTypeParsers() {
		return Collections.unmodifiableMap(parsers);
	}
}
