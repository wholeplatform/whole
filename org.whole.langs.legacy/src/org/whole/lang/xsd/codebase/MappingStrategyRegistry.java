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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.xsd.mapping.model.MappingStrategy;

/**
 * @author Enrico Persiani
 */
public class MappingStrategyRegistry {
	private static class SingletonHolder {
		private static final MappingStrategyRegistry instance = new MappingStrategyRegistry();
	}
	public static final MappingStrategyRegistry instance() {
		return SingletonHolder.instance;
	}

	// a registry that maps languageIds to specific strategies
	private Map<String, IMappingStrategy> mappingStrategyMap;
	private Map<String, MappingStrategy> mappingModelMap;

	private MappingStrategyRegistry() {
		mappingStrategyMap = new HashMap<String, IMappingStrategy>();
		mappingModelMap = new HashMap<String, MappingStrategy>();
	}

	public IMappingStrategy createMappingStrategy(MappingStrategy mappingModel) {
		return new CompiledMappingStrategy(mappingModel);
	}

	public IMappingStrategy putMappingModel(MappingStrategy mappingModel) {
		mappingModelMap.put(mappingModel.getNamespace().getValue(), mappingModel);
		return putMappingStrategy(createMappingStrategy(mappingModel));
	}

	public IMappingStrategy putMappingStrategy(IMappingStrategy strategy) {
		return mappingStrategyMap.put(strategy.getNamespace(), strategy);
	}

	public MappingStrategy getMappingModel(String namespaceURI) {
		return mappingModelMap.get(namespaceURI);
	}

	public IMappingStrategy getMappingStrategy(String namespaceURI) {
		return mappingStrategyMap.get(namespaceURI);
	}

	public boolean hasMappingModel(String namespaceURI) {
		return mappingModelMap.get(namespaceURI) != null;
	}

	public boolean hasMappingStrategy(String namespaceURI) {
		return mappingStrategyMap.get(namespaceURI) != null;
	}
}
