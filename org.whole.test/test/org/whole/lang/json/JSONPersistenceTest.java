/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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

import junit.framework.TestCase;

import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.json.codebase.JSONPersistenceKit;
import org.whole.lang.json.util.JSONGeneratorBuilderOperation;
import org.whole.lang.json.util.JSONParserTemplateFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.text.codebase.TextSourcePersistenceKit;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * @author Riccardo Solmi
 */
public class JSONPersistenceTest extends TestCase {
	String sampleString;

	@Override
	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();

		IEntity sampleText = TextSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		sampleString = PrettyPrinterOperation.toPrettyPrintString(sampleText);
	}

	public void testStreamAndBuildParserEquivalence() throws Exception {
		IEntity sampleModelByFactory = JSONPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));

		ModelBuilderOperation op = new ModelBuilderOperation();
		new JSONParserTemplateFactory(new JsonFactory().createParser(sampleString)).apply(op);
		IEntity sampleModelByBuilder = ReflectionFactory.makeRootEntity(op.wGetResult());

		assertTrue(Matcher.match(sampleModelByFactory, sampleModelByBuilder));
	}

	public void testParseAndGenerateWithPrettyPrinter() throws Exception {
		IEntity sampleModel = JSONPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		
		assertEquals(sampleString, PrettyPrinterOperation.toPrettyPrintString(sampleModel));
	}

	public void testParseAndGenerateWithBuilderOperation() throws Exception {
		IEntity sampleModel = JSONPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		

		StringPersistenceProvider pp = new StringPersistenceProvider();

		JsonGenerator generator = new JsonFactory().createGenerator(pp.getOutputStream());
		generator.useDefaultPrettyPrinter();
		JSONGeneratorBuilderOperation op = new JSONGeneratorBuilderOperation(generator);
		new ModelTemplate(sampleModel).apply(op);
		generator.close();
		
		assertEquals(sampleString, pp.getStore());
	}

	public void testPersistenceKit() throws Exception {
		IEntity sampleModel = JSONPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.json")));
		
		StringPersistenceProvider pp = new StringPersistenceProvider();
		JSONPersistenceKit.instance().writeModel(sampleModel, pp);
		assertEquals(sampleString, pp.getStore());
	}
}
