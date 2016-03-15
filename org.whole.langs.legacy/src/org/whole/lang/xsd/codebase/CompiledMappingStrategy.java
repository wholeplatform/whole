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

import static org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum.*;
import static org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.EnumType;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xsd.mapping.model.CustomDataType;
import org.whole.lang.xsd.mapping.model.EnumDataType;
import org.whole.lang.xsd.mapping.model.EnumValue;
import org.whole.lang.xsd.mapping.model.MappingStrategy;
import org.whole.lang.xsd.mapping.model.Types;
import org.whole.lang.xsd.mapping.model.URI;
import org.whole.lang.xsd.mapping.model.UnionMapping;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.xsd.parsers.SchemaDataTypes;
import org.whole.lang.xsd.parsers.SchemaEnumDataTypeParser;

/**
 * @author Enrico Persiani
 */
public class CompiledMappingStrategy extends AbstractMappingStrategy {
	private MappingStrategy strategy;

	public CompiledMappingStrategy() {
	}
	public CompiledMappingStrategy(MappingStrategy strategy) {
		this.strategy = NormalizerOperation.normalize(EntityUtils.clone(strategy));
		this.indexes.addAll(this.strategy.getMappings());

		IEntityIterator<CustomDataType> customIterator = IteratorFactory.<CustomDataType>childMatcherIterator()
				.withPattern(MappingEntityDescriptorEnum.CustomDataType);
		customIterator.reset(this.strategy.getDataTypes());
		for (CustomDataType customDataType : customIterator) {
			String edUri = customDataType.getEntityType().getValue();
			String builtInType = customDataType.getBuiltInType().getValue();
			this.parsers.put(parseEntityDescriptor(edUri), SchemaDataTypes.getDataTypeParser(builtInType));
		}

		IEntityIterator<EnumDataType> enumIterator = IteratorFactory.<EnumDataType>childMatcherIterator()
				.withPattern(MappingEntityDescriptorEnum.EnumDataType);
		enumIterator.reset(this.strategy.getDataTypes());
		for (EnumDataType enumDataType : enumIterator) {
			EntityDescriptor<?> ed = parseEntityDescriptor(enumDataType.getEntityType().getValue());
			Map<String, org.whole.lang.model.EnumValue> map = new HashMap<String, org.whole.lang.model.EnumValue>();
			EnumType<?> enumType = ed.getDataEnumType();
			for (int i=0, size=enumDataType.getEnumValues().wSize(); i<size; i++) {
				EnumValue enumValue = (EnumValue) enumDataType.getEnumValues().wGet(i);
				map.put(enumValue.getValue().getValue(), 
						enumType.valueOf(enumValue.getEnumValue().getValue()));
			}
			parsers.put(ed, new SchemaEnumDataTypeParser(ed, map));
		}
	}

	public String getNamespace() {
		return strategy.getNamespace().getValue();
	}
	public String getSchemaLocation() {
		return strategy.getSchemaLocation().getValue();
	}
	public boolean isSynthesized() {
		return strategy.getSynthesized().isValue();
	}
	public boolean isElementsFormQualified() {
		return strategy.getElementsFormQualified().isValue();
	}
	public boolean isAttributesFormQualified() {
		return strategy.getAttributesFormQualified().isValue();
	}

	public MappingStrategy getMappingModel() {
		return strategy;
	}

	public EntityDescriptor<?> getMixedDataType() {
		URI mixedDataType = strategy.getMixedDataType();
		return DataTypeUtils.getDataKind(mixedDataType).isString() ? parseEntityDescriptor(mixedDataType.getValue()) : null;
	}

	private Set<EntityDescriptor<?>> mixedTypes;
	public boolean isMixedType(EntityDescriptor<?> ed) {
		if (mixedTypes == null) {
			mixedTypes = new HashSet<EntityDescriptor<?>>();
			Types uris = strategy.getMixedTypes();
			for (int i=0, size=uris.wSize(); i<size; i++)
				mixedTypes.add(parseEntityDescriptor(uris.wGet(i).wStringValue()));
		}
		return mixedTypes.contains(ed);
	}

	public Collection<EntityDescriptor<?>> getUnionEntityMappings(EntityDescriptor<?> context) {
		//TODO optimize
		String contextURI = unparseEntityDescriptor(context);
		AbstractPatternFilterIterator<UnionMapping> i2 = IteratorFactory.<UnionMapping>childMatcherIterator()
				.withPattern(UnionMapping);
		i2.reset(strategy.getMappings());
		for (UnionMapping mapping : i2)
			if (contextURI.equals(mapping.getContextEntityType().getValue())) {
				Types unionTypes = mapping.getUnionTypes();
				int size = unionTypes.wSize();
				List<EntityDescriptor<?>> list = new ArrayList<EntityDescriptor<?>>(size);
				for (int i=0; i<size; i++)
					list.add(parseEntityDescriptor(unionTypes.wGet(i).wStringValue()));
				return list;
			}
		return Collections.emptyList();
	}
}
