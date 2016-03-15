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
package org.whole.lang.grammars.util.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.FailureDataTypeParser;
import org.whole.lang.parsers.ForwardEntityDescriptorStrategyDataTypeParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public class DataTypesGrammarsDataTypeParser extends FailureDataTypeParser {

	private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	public DataTypesGrammarsDataTypeParser() {
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	@Override
	public Date parseDate(EntityDescriptor<?> ed, String value) {
		synchronized (format) {
			try {
				return format.parse(value);
			} catch (ParseException e) {
				throw new IllegalArgumentException("ParseException: "+e.getMessage());
			}
		}
	}

	@Override
	public String unparseDate(EntityDescriptor<?> ed, Date value) {
		synchronized (format) {
			return format.format(value);
		}
	}

	public static void deploy(String grammarURI) {
		Grammar grammar = GrammarsRegistry.instance().getGrammar(grammarURI);
		ILanguageKit lk = ReflectionFactory.getLanguageKit(GrammarsUtils.getLanguageURI(grammar), false, null);

		EntityDescriptor<?> ed = lk.getEntityDescriptorEnum().valueOf("DateLiteral");
		Map<EntityDescriptor<?>, IDataTypeParser> strategies = new HashMap<EntityDescriptor<?>, IDataTypeParser>();
		strategies.put(ed, new DataTypesGrammarsDataTypeParser());

		install(lk, strategies);
	}

	public static void install(ILanguageKit lk, Map<EntityDescriptor<?>, IDataTypeParser> strategies) {
		IDataTypeParser persistence = lk.getDataTypeParser(DataTypeParsers.PERSISTENCE);
		IDataTypeParser persistenceStrategy = persistence.getStrategy();

		IDataTypeParser presentation = lk.getDataTypeParser(DataTypeParsers.PRESENTATION);
		IDataTypeParser presentationStrategy = presentation.getStrategy();

		ForwardEntityDescriptorStrategyDataTypeParser persistenceForwardStrategy, presentationForwardStrategy;

		if (persistenceStrategy.equals(presentationStrategy)) {
			persistenceForwardStrategy = presentationForwardStrategy = new ForwardEntityDescriptorStrategyDataTypeParser(presentationStrategy);
			persistenceForwardStrategy.putParserStrategies(strategies);
		} else {
			persistenceForwardStrategy = new ForwardEntityDescriptorStrategyDataTypeParser(presentationStrategy);
			persistenceForwardStrategy.putParserStrategies(strategies);
			presentationForwardStrategy = new ForwardEntityDescriptorStrategyDataTypeParser(presentationStrategy);
			presentationForwardStrategy.putParserStrategies(strategies);
		}
		persistence.setStrategy(persistenceForwardStrategy);
		presentation.setStrategy(presentationForwardStrategy);
	}
}
