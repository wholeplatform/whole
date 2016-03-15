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
package org.whole.lang.xsd.parsers;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTimeZone;
import org.joda.time.tz.FixedDateTimeZone;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.parsers.ForwardDataTypeStrategyDataTypeParser;
import org.whole.lang.parsers.ForwardEntityDescriptorStrategyDataTypeParser;
import org.whole.lang.parsers.ForwardStrategyDataTypeParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class XsiDataTypeParser extends ForwardStrategyDataTypeParser {
	public static final DateTimeZone UTC = new FixedDateTimeZone("UTC", "UTC", 0, 0);

	public XsiDataTypeParser() {
		this(Collections.<EntityDescriptor<?>, IDataTypeParser>emptyMap());
	}

	public XsiDataTypeParser(Map<EntityDescriptor<?>, IDataTypeParser> parserStrategies) {
		IDataTypeParser baseStrategy = createDefaultStrategy();

		ForwardDataTypeStrategyDataTypeParser forwardDataTypeStrategy =
			new ForwardDataTypeStrategyDataTypeParser(baseStrategy);

		ForwardEntityDescriptorStrategyDataTypeParser forwardEntityDescriptorStrategy =
			new ForwardEntityDescriptorStrategyDataTypeParser(forwardDataTypeStrategy);

		for (Entry<EntityDescriptor<?>, IDataTypeParser> entry: parserStrategies.entrySet())
			forwardEntityDescriptorStrategy.putParserStrategy(entry.getKey(), entry.getValue());

		setStrategy(forwardEntityDescriptorStrategy);
	}
	
	protected XsiDefaultDataTypeParser createDefaultStrategy() {
		return new XsiDefaultDataTypeParser();
	}

	protected void putParserStrategy(String entityType, IDataTypeParser dataTypeParser) {
		ForwardEntityDescriptorStrategyDataTypeParser strategy = (ForwardEntityDescriptorStrategyDataTypeParser) getStrategy();
		EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.parseEntityDescriptor(entityType);
		strategy.putParserStrategy(ed, dataTypeParser);
	}
}
