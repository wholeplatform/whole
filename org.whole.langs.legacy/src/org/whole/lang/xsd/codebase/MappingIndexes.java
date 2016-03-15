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
/**
 * 
 */
package org.whole.lang.xsd.codebase;

import static org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser.*;
import static org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.xsd.mapping.model.AnyMapping;
import org.whole.lang.xsd.mapping.model.ContentMapping;
import org.whole.lang.xsd.mapping.model.Mapping;
import org.whole.lang.xsd.mapping.model.Mappings;
import org.whole.lang.xsd.mapping.model.MixedStructuralMapping;
import org.whole.lang.xsd.mapping.model.RootMapping;
import org.whole.lang.xsd.mapping.model.TypeMapping;
import org.whole.lang.xsd.mapping.visitors.MappingIdentityDefaultVisitor;
import org.whole.lang.xsd.util.SchemaUtils;

/**
 * @author Enrico Persiani
 */
public class MappingIndexes {
	private final Map<MappingIndexes.IndexTypes, Map<Object, Set<CompiledMapping>>> indexes;

	public MappingIndexes() {
		indexes = new HashMap<MappingIndexes.IndexTypes, Map<Object, Set<CompiledMapping>>>();
	}

	public CompiledMapping add(EntityDescriptor<?> mappingType, EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd, String ncname) {
		return add(new CompiledMapping(mappingType, context, ed, fd, ncname));
	}
	public CompiledMapping add(Mapping mapping) {
		return add(new CompiledMapping(mapping));
	}
	public void addAll(Mappings mappings) {
		for (int i=0, size=mappings.wSize(); i<size; i++) {
			Mapping mapping = (Mapping) mappings.wGet(i);
			switch (mapping.wGetEntityDescriptor().getOrdinal()) {
			case UnionMapping_ord:
				break;
			default:
				add(mapping);
				break;
			}
		}
	}

	public Set<CompiledMapping> findMappings(EntityDescriptor<?> mappingType, EntityDescriptor<?> context, String ncname) {
		Set<CompiledMapping> byContext = getMappings(IndexTypes.CONTEXT, context);
		Set<CompiledMapping> result = new HashSet<CompiledMapping>(getMappings(IndexTypes.NCNAME, ncname));
		Iterator<CompiledMapping> iterator = result.iterator();
		while (iterator.hasNext()) {
			CompiledMapping m = iterator.next();
			if (!mappingType.equals(m.mappingType) || !byContext.contains(m))
				iterator.remove();
		}
		return result;
	}
	public CompiledMapping findMapping(EntityDescriptor<?> mappingType, EntityDescriptor<?> context, String ncname) {
		Set<CompiledMapping> byContext = getMappings(IndexTypes.CONTEXT, context);
		for (CompiledMapping m : getMappings(IndexTypes.NCNAME, ncname))
			if (mappingType.equals(m.mappingType) && (byContext.contains(m)))
				return m;
		return CompiledMapping.NULL;
	}
	public CompiledMapping findMapping(EntityDescriptor<?> mappingType, EntityDescriptor<?> context) {
		for (CompiledMapping m : getMappings(IndexTypes.CONTEXT, context))
			if (mappingType.equals(m.mappingType))
				return m;
		return CompiledMapping.NULL;
	}
	public CompiledMapping findMapping(String ncname) {
		for (CompiledMapping m : getMappings(IndexTypes.NCNAME, ncname))
			if (RootMapping.equals(m.mappingType))
				return m;
		return CompiledMapping.NULL;
	}
	public CompiledMapping findMapping(EntityDescriptor<?> ed) {
		for (CompiledMapping m : getMappings(IndexTypes.ED, ed))
			if (RootMapping.equals(m.mappingType))
				return m;
		return CompiledMapping.NULL;
	}
	public CompiledMapping findMapping(EntityDescriptor<?> mappingType, EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		Set<CompiledMapping> byEntity = getMappings(IndexTypes.ED, ed);
		Set<CompiledMapping> byFeature = getMappings(IndexTypes.FD, fd);
		for (CompiledMapping m : getMappings(IndexTypes.CONTEXT, context))
			if (mappingType.equals(m.mappingType) &&
					(byEntity.contains(m) || 
							(m.ed.isAbstract() && m.ed.isPlatformSupertypeOf(ed))) &&
					(m.fd == null || // would be CommonsFeatureDescriptorEnum.any
					byFeature.contains(m)))
				return m;
		return CompiledMapping.NULL;
	}

	private Map<Object, Set<CompiledMapping>> getIndex(MappingIndexes.IndexTypes indexType) {
		Map<Object, Set<CompiledMapping>> index = indexes.get(indexType);
		if (index == null)
			indexes.put(indexType, index = new HashMap<Object, Set<CompiledMapping>>());
		return index;
	}
	private Set<CompiledMapping> getMappings(MappingIndexes.IndexTypes indexType, Object key) {
		Set<CompiledMapping> mappings = getIndex(indexType).get(key);
		return mappings != null ? mappings : Collections.<CompiledMapping>emptySet();
	}
	private void add(MappingIndexes.IndexTypes indexType, Object key, CompiledMapping mapping) {
		if (key != null) {
			Set<CompiledMapping> mappings = getIndex(indexType).get(key);
			if (mappings == null)
				getIndex(indexType).put(key, mappings = new HashSet<CompiledMapping>());
			mappings.add(mapping);
		}
	}
	private CompiledMapping add(CompiledMapping mapping) {
		add(IndexTypes.MAPPING_TYPE, mapping.mappingType, mapping);
		add(IndexTypes.CONTEXT, mapping.context, mapping);
		add(IndexTypes.ED, mapping.ed, mapping);
		add(IndexTypes.FD, mapping.fd, mapping);
		add(IndexTypes.NCNAME, mapping.ncname, mapping);
		return mapping;
	}

	private enum IndexTypes {
		MAPPING_TYPE, CONTEXT, ED, FD, NCNAME
	}

	public static class CompiledMapping {
		public static final CompiledMapping NULL = new CompiledMapping() {
			public boolean isNull() {
				return true;
			}
		};

		public EntityDescriptor<?> mappingType;
		public EntityDescriptor<?> context;
		public EntityDescriptor<?> ed;
		public FeatureDescriptor fd;
		public String ncname;

		protected CompiledMapping() {
		}
		protected CompiledMapping(EntityDescriptor<?> mappingType, EntityDescriptor<?> context, EntityDescriptor<?> ed, FeatureDescriptor fd, String ncname) {
			this.mappingType = mappingType;
			this.context = context;
			this.ed = ed;
			this.fd = fd;
			this.ncname = ncname;
		}
		
		protected CompiledMapping(Mapping mapping) {
			this.mappingType = mapping.wGetEntityDescriptor();
			mapping.accept(new MappingIdentityDefaultVisitor() {
				@Override
				public void visit(ContentMapping entity) {
					context = parseEntityDescriptor(entity.getContextEntityType().getValue());
					fd = parseFeatureDescriptor(entity.getFeatureType().getValue());
					ed = parseEntityDescriptor(entity.getEntityType().getValue());
				}
				@Override
				public void visit(MixedStructuralMapping entity) {
					context = parseEntityDescriptor(entity.getContextEntityType().getValue());
					fd = parseFeatureDescriptor(entity.getFeatureType().getValue());
					ed = parseEntityDescriptor(entity.getEntityType().getValue());
				}
				@Override
				public void visit(AnyMapping entity) {
					context = parseEntityDescriptor(entity.getContextEntityType().getValue());
					fd = parseFeatureDescriptor(entity.getFeatureType().getValue());
					ed = parseEntityDescriptor(entity.getEntityType().getValue());

					//TODO test and modularize
					if (SchemaUtils.hasAnyTypeEntityName(ed))
						ed.getEntityDescriptorEnum().setAssignableFromAll(true, ed.getOrdinal());
				}
				@Override
				public void visit(TypeMapping entity) {
					context = parseEntityDescriptor(entity.getContextEntityType().getValue());
					ncname = entity.getName().getValue();
					fd = parseFeatureDescriptor(entity.getFeatureType().getValue());
					ed = parseEntityDescriptor(entity.getEntityType().getValue());
					
					//TODO test and modularize
					if (!ed.getLanguageKit().equals(context.getLanguageKit()))
						context.getEntityDescriptorEnum().setAssignableFromAll(true, context.getEntityDescriptor(fd).getOrdinal());

				}
				@Override
				public void visit(RootMapping entity) {
					ncname = entity.getName().getValue();
					ed = parseEntityDescriptor(entity.getEntityType().getValue());
				}
			});
		}

		public boolean isNull() {
			return false;
		}
	}
}
