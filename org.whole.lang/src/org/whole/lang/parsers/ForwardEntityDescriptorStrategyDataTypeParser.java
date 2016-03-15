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
public class ForwardEntityDescriptorStrategyDataTypeParser extends ForwardStrategyDataTypeParser {
	private Map<EntityDescriptor<?>, IDataTypeParser> parserStrategies = new HashMap<EntityDescriptor<?>, IDataTypeParser>();

	public ForwardEntityDescriptorStrategyDataTypeParser() {
		super();
	}
	public ForwardEntityDescriptorStrategyDataTypeParser(IDataTypeParser defaultParserStrategy) {
		super(defaultParserStrategy);
	}

	@Override
	public IDataTypeParser getStrategy(EntityDescriptor<?> ed) {
		IDataTypeParser parser = parserStrategies.get(ed);
		if (parser != null)
			return parser;
		else
			return super.getStrategy(ed);
	}

	public void putParserStrategies(Map<? extends EntityDescriptor<?>, ? extends IDataTypeParser> parserStrategies) {
		this.parserStrategies.putAll(parserStrategies);
	}
	public IDataTypeParser putParserStrategy(EntityDescriptor<?> ed, IDataTypeParser parserStrategy) {
		return parserStrategies.put(ed, parserStrategy);
	}
	public IDataTypeParser removeParserStrategy(EntityDescriptor<?> ed) {
		return parserStrategies.remove(ed);
	}
}
