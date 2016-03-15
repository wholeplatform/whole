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
package org.whole.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.whole.lang.grammars.util.GrammarsUtilsTest;
import org.whole.lang.grammars.util.tests.GrammarsTestSuite;
import org.whole.lang.mediawiki.tests.MediawikiTestSuite;
import org.whole.lang.pojo.util.PojoUtilsTest;
import org.whole.lang.properties.PropertiesTest;
import org.whole.lang.queries.util.BindVariablesInPathTest;
import org.whole.lang.queries.util.ControlQueriesTest;
import org.whole.lang.queries.util.PathExpressionsQueriesTest;
import org.whole.lang.queries.util.RewriteQueriesTest;
import org.whole.lang.queries.util.SelectQueriesTest;
import org.whole.lang.queries.util.tests.QueriesTestSuite;
import org.whole.lang.rdb.codebase.DBSchemaTemplateFactoryTest;
import org.whole.lang.sql.SQLInterpreterTest;
import org.whole.lang.tests.TestsInterpreterVisitorTest;
import org.whole.lang.workflow.model.BindingCommandTest;
import org.whole.lang.workflows.visitors.WorkflowsInterpreterVisitorTest;
import org.whole.lang.workflows.visitors.tests.WorkflowsTestSuite;
import org.whole.lang.xml.builders.XmlNormalizerBuilderTest;
import org.whole.lang.xml.builders.XmlPrettyPrinterBuilderTest;
import org.whole.lang.xsd.builders.XsdModelBuilderTest;
import org.whole.lang.xsd.mapping.XsdMappingTest;
import org.whole.lang.xsd.templates.XsiModelTemplateTest;
import org.whole.lang.xsd.util.XsdLanguageTest;
import org.whole.lang.xsd.util.XsiDateTimeUtilsTest;

/**
 * Runs: 245
 * Errors: 2
 * Failures: 11

 * @author Riccardo Solmi
 */
@RunWith(Suite.class)
@SuiteClasses( {
	PathExpressionsQueriesTest.class,
	SelectQueriesTest.class,
	ControlQueriesTest.class,
	RewriteQueriesTest.class,
	BindVariablesInPathTest.class,
	QueriesTestSuite.class,
	GrammarsUtilsTest.class,
	GrammarsTestSuite.class,
	PojoUtilsTest.class,
	PropertiesTest.class,
	DBSchemaTemplateFactoryTest.class,
	SQLInterpreterTest.class,
	XmlNormalizerBuilderTest.class,
	XmlPrettyPrinterBuilderTest.class,
	XsdLanguageTest.class,
	XsdMappingTest.class,
	XsiModelTemplateTest.class,
	XsdModelBuilderTest.class,
	XsiDateTimeUtilsTest.class,
	BindingCommandTest.class,
	TestsInterpreterVisitorTest.class,
	WorkflowsInterpreterVisitorTest.class,
	WorkflowsTestSuite.class,
	MediawikiTestSuite.class
})
public class AllLanguagesTests {
}
