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
package org.whole.lang.xsd.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.DynamicLanguageKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.util.StringUtils;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.codebase.MappingStrategyRegistry;
import org.whole.lang.xsd.parsers.SchemaDataTypes;
import org.whole.lang.xsd.parsers.XsiDataTypeParser;
import org.whole.lang.xsd.visitors.XsiPrettyPrinterVisitor;

/**
 * @author Enrico Persiani
 */
public class SchemaHelpers {
	public static Set<String> getReservedEntityNames() {
		Set<String> reservedNames = new HashSet<String>(SchemaDataTypes.getBuiltInToEntityNameMap().values());
		reservedNames.add(SchemaUtils.getAnyTypeEntityName());
		return Collections.unmodifiableSet(reservedNames);
	}

	public static String toFreshEntityName(FreshNameGenerator fng, String baseName) {
		return fng.nextFreshName(StringUtils.toUpperCap(baseName));
	}
	public static String toFreshFeatureName(FreshNameGenerator fng, String baseName) {
		return fng.nextFreshName(StringUtils.toLowerPrefix(baseName));
	}
	public static String toFreshEnumLiteralName(FreshNameGenerator fng, String baseName) {
		return fng.nextFreshName(baseName);
	}
	
	public static void deploySchemaOperations(final String languageUri) {
		ILanguageKit lk = ReflectionFactory.getLanguageKit(languageUri, false, null);
		if (!lk.isDynamic())
			return;

		// configure data-type parsers
		IMappingStrategy mappingStrategy = MappingStrategyRegistry.instance().getMappingStrategy(languageUri);
		IDataTypeParser parser = new XsiDataTypeParser(mappingStrategy.getDataTypeParsers());

		DynamicLanguageKit languageKit = (DynamicLanguageKit) lk;
		languageKit.setDataTypeParser(DataTypeParsers.PERSISTENCE, parser);
		languageKit.setDataTypeParser(DataTypeParsers.PRESENTATION, parser);

		// deploy a generic pretty print
		ReflectionFactory.deploy(new AbstractLanguageExtensionDeployer() {
			public void deploy(ReflectionFactory platform) {
				platform.addOperationFactory(languageUri, PrettyPrinterOperation.ID, new IVisitorFactory() {
					public IVisitor create(IOperation operation, int stage) {
						return new XsiPrettyPrinterVisitor();
					}
				});
			}
		});
	}
}
