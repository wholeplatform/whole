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
package org.whole.lang.xsd.builders;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.whole.lang.xml.builders.XmlGenericBuilderAdapter;
import org.whole.lang.xml.codebase.XmlNormalizerBuilderOperation;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;
import org.whole.lang.xml.model.Document;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xsd.codebase.XsdDeployStrategies;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.model.Schema;
import org.whole.test.KnownFailingTests;

/**
 * @author Enrico Persiani
 */
public class XsdModelBuilderTest {

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	private InputStream getInputStream(String fileName) {
		return getClass().getResourceAsStream(fileName);
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testBuilderAPI() throws Exception {
		Schema xsdFromInputStream = (Schema) XsdPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream("datatypes.xsd")));
		Document document = (Document) XmlSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream("datatypes.xsd")));
		
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		bm.wDefValue("mergeCDataSect", true);
		XsdDeployStrategies.setDeployStrategy(bm, XsdDeployStrategies.ALL);

		ModelBuilderOperation mop = new ModelBuilderOperation();
		IBuilderOperation xsdBuilderOperation = new XmlSpecific2XsdBuilderAdapterOperation(mop, bm);
		XmlNormalizerBuilderOperation normalizerOp = new XmlNormalizerBuilderOperation(xsdBuilderOperation, bm);

		ModelTemplate template = new ModelTemplate(document);
		template.apply(new XmlGenericBuilderAdapter((IXmlBuilder) normalizerOp.wGetBuilder(XmlLanguageKit.URI)));
		
		Schema xsdFromXmlModel = (Schema) mop.wGetResult();
		
		Assert.assertTrue(Matcher.match(xsdFromInputStream, xsdFromXmlModel));
	}
}
