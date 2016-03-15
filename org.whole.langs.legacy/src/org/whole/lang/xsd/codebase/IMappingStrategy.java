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

import java.util.Collection;
import java.util.Map;

import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.xml.util.QName;

/**
 * @author Enrico Persiani
 */
public interface IMappingStrategy {
	public String getNamespace();
	public String getSchemaLocation();
	public boolean isSynthesized();
	public boolean isElementsFormQualified();
	public boolean isAttributesFormQualified();

	// xsi to models mappings
	public EntityDescriptor<?> getElementEntityMapping(EntityDescriptor<?> context, QName name);
	public Collection<FeatureDescriptor> getElementFeatureMappings(EntityDescriptor<?> context, QName name);

	public EntityDescriptor<?> getAttributeEntityMapping(EntityDescriptor<?> context, QName name);
	public FeatureDescriptor getAttributeFeatureMapping(EntityDescriptor<?> context, QName name);

	public EntityDescriptor<?> getStructuralEntityMapping(EntityDescriptor<?> context, QName name);
	public FeatureDescriptor getStructuralFeatureMapping(EntityDescriptor<?> context, QName name);

	public EntityDescriptor<?> getContentEntityMapping(EntityDescriptor<?> context);
	public FeatureDescriptor getContentFeatureMapping(EntityDescriptor<?> context);

	public EntityDescriptor<?> getMixedStructuralEntityMapping(EntityDescriptor<?> context);
	public FeatureDescriptor getMixedStructuralFeatureMapping(EntityDescriptor<?> context);

	public Collection<EntityDescriptor<?>> getUnionEntityMappings(EntityDescriptor<?> context);
	public EntityDescriptor<?> getRootEntityMapping(QName name);

	public EntityDescriptor<?> getMixedDataType();
	public boolean isMixedType(EntityDescriptor<?> ed);

	// models to xsi mappings
	public String getAttributeNCName(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd);
	public String getAttributeNCName(IEntity entity);
	public String getElementNCName(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd);
	public String getElementNCName(IEntity entity);
	public String getRootElementNCName(EntityDescriptor<?> ed);

	public boolean isAttributeMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd);
	public boolean isAttributeMapping(IEntity entity);
	public boolean isElementMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd);
	public boolean isElementMapping(IEntity entity);
	public boolean isStructuralMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd);
	public boolean isStructuralMapping(IEntity entity);

	public boolean isContentMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd);
	public boolean isContentMapping(IEntity entity);

	public boolean isMixedStructuralMapping(EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd);
	public boolean isMixedStructuralMapping(IEntity entity);

	// data types
	public Map<EntityDescriptor<?>, IDataTypeParser> getDataTypeParsers();
}
