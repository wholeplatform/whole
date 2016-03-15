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
package org.whole.lang.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.json.codebase.JSONLDPersistenceKit;
import org.whole.lang.json.codebase.JSONSourcePersistenceKit;
import org.whole.lang.json.util.JSONGeneratorBuilderOperation;
import org.whole.lang.json.util.JSONParserTemplateFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.text.codebase.TextSourcePersistenceKit;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * @author Riccardo Solmi
 */
public class JSONPersistencesTest {
	String sampleString;
	String[] models = new String[] {
			"org/whole/lang/queries/QueriesModel.xwl",
			"org/whole/lang/html/HTML5Actions.xwl",
			"org/whole/lang/javascript/JavaScriptSemantics.xwl",
			"org/whole/lang/patterns/PatternsSemantics.xwl"
	};

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() throws Exception {
		IEntity sampleText = TextSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		sampleString = PrettyPrinterOperation.toPrettyPrintString(sampleText);
	}

    @Test
    public void testStreamAndBuildParserEquivalence() throws Exception {
		IEntity sampleModelByFactory = JSONSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));

		ModelBuilderOperation op = new ModelBuilderOperation();
		new JSONParserTemplateFactory(new JsonFactory().createParser(sampleString)).apply(op);
		IEntity sampleModelByBuilder = ReflectionFactory.makeRootEntity(op.wGetResult());

		assertTrue(Matcher.match(sampleModelByFactory, sampleModelByBuilder));
	}

    @Test
    public void testParseAndGenerateWithPrettyPrinter() throws Exception {
		IEntity sampleModel = JSONSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		
		assertEquals(sampleString, PrettyPrinterOperation.toPrettyPrintString(sampleModel));
	}

    @Test
    public void testParseAndGenerateWithBuilderOperation() throws Exception {
		IEntity sampleModel = JSONSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		

		StringPersistenceProvider pp = new StringPersistenceProvider();

		JsonGenerator generator = new JsonFactory().createGenerator(pp.getOutputStream());
		generator.useDefaultPrettyPrinter();
		JSONGeneratorBuilderOperation op = new JSONGeneratorBuilderOperation(generator);
		new ModelTemplate(sampleModel).apply(op);
		generator.close();
		
		assertEquals(sampleString, pp.getStore());
	}

    @Test
    public void testPersistenceKit() throws Exception {
		IEntity sampleModel = JSONSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		
		StringPersistenceProvider pp = new StringPersistenceProvider();
		JSONSourcePersistenceKit.instance().writeModel(sampleModel, pp);
		assertEquals(sampleString, pp.getStore());
	}

    @Test
    public void testJSONLDPersistence() throws Exception {
		StringPersistenceProvider pp = new StringPersistenceProvider();

		for (String modelPath : models) {
	    	IEntity sourceModel = XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider(modelPath));
	
	    	pp.delete();
			JSONLDPersistenceKit.instance().writeModel(sourceModel, pp);
			IEntity targetModel = JSONLDPersistenceKit.instance().readModel(pp);

			assertTrue(Matcher.forceMatch(sourceModel, targetModel));
		}
	}
}
