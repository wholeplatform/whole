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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class ForwardDataTypeStrategyDataTypeParser extends ForwardStrategyDataTypeParser {
	private Map<Class<?>, IDataTypeParser> parserStrategies = new HashMap<Class<?>, IDataTypeParser>();

	public ForwardDataTypeStrategyDataTypeParser() {
		super();
	}
	public ForwardDataTypeStrategyDataTypeParser(IDataTypeParser defaultParserStrategy) {
		super(defaultParserStrategy);
	}

	@Override
	public IDataTypeParser getStrategy(EntityDescriptor<?> ed) {
		Class<?> dataType = ed.getDataType();
		if (dataType != null) {
			IDataTypeParser parser = parserStrategies.get(dataType);
			if (parser != null)
				return parser;
		}
		return super.getStrategy(ed);
	}

	public void putParserStrategies(Map<? extends Class<?>, ? extends IDataTypeParser> parserStrategies) {
		this.parserStrategies.putAll(parserStrategies);
	}
	public IDataTypeParser putParserStrategy(Class<?> dataType, IDataTypeParser parserStrategy) {
		return parserStrategies.put(dataType, parserStrategy);
	}
	public IDataTypeParser removeParserStrategy(Class<?> dataType) {
		return parserStrategies.remove(dataType);
	}
}
