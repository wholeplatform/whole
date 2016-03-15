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
package org.whole.lang.xsd.templates;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.rdb.codebase.OrderedMatcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.codebase.XmlNormalizerBuilderOperation;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.xsd.codebase.XsdDeployStrategies;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.codebase.XsiPersistenceKit;
import org.whole.test.KnownFailingTests;
import org.whole.test.SlowTests;

/**
 * @author Enrico Persiani
 */
public class XsiModelTemplateTest {
	private Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = 
		new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Before
    public void setUp() {
		comparatorsMap.put(XmlEntityDescriptorEnum.Attributes, new Comparator<IEntity>() {
			public int compare(IEntity o1, IEntity o2) {
				
				String s1 = EntityUtils.isNotResolver(o1) ? PrettyPrinterOperation.toPrettyPrintString(o1.wGet(XmlFeatureDescriptorEnum.name)) : "";
				String s2 = EntityUtils.isNotResolver(o2) ? PrettyPrinterOperation.toPrettyPrintString(o2.wGet(XmlFeatureDescriptorEnum.name)) : "";
				return s1.compareTo(s2);
			}
		});
	}

	private InputStream getInputStream(String fileName) {
		return new BufferedInputStream(getClass().getResourceAsStream(fileName));
	}

	private IEntity loadXMLSchema(String fileName) throws Exception {
		return XsdPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream(fileName)));
	}

	@Category({KnownFailingTests.class, SlowTests.class})
	@Test
	public void testXsiModelTemplate() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		bm.wDefValue("folderLocation", new File("test/org/whole/lang/xsd/templates").getAbsolutePath());
		bm.wDefValue("packageName", "");
		XsdDeployStrategies.setDeployStrategy(bm, XsdDeployStrategies.ALL);

		String fileName = "S202SCTDIRPFRAA0001.C.xml";
		IEntity xsiModel = XsiPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream(fileName), null, bm));
		CommonsEntityFactory.instance.createRootFragment(
				xsiModel.wGetAdapter(CommonsEntityDescriptorEnum.Any));
		IEntity xmlModel = XmlSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream(fileName), null, bm));
		CommonsEntityFactory.instance.createRootFragment(
				xmlModel.wGetAdapter(CommonsEntityDescriptorEnum.Any));

		ModelBuilderOperation mop = new ModelBuilderOperation();
		XmlNormalizerBuilderOperation xnbo = new XmlNormalizerBuilderOperation(mop);
		XsiModelTemplate xsiModelTemplate = new XsiModelTemplate(xsiModel);
		xsiModelTemplate.apply(xnbo);
		IEntity xmlModelFromXsiModel = mop.wGetResult();

		Assert.assertTrue(Matcher.match(xmlModelFromXsiModel, xmlModel));
	}

	@Test
	public void testXsdModelTemplate() throws Exception {
		String pacs002FileName = "pacs.002.001.02S2.xsd";
		IEntity xsdPacs002 = loadXMLSchema(pacs002FileName);
		CommonsEntityFactory.instance.createRootFragment(
				xsdPacs002.wGetAdapter(CommonsEntityDescriptorEnum.Any));
		IEntity xmlPacs002 = XmlSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream(pacs002FileName)));
		CommonsEntityFactory.instance.createRootFragment(
				xmlPacs002.wGetAdapter(CommonsEntityDescriptorEnum.Any));

		ModelBuilderOperation mop = new ModelBuilderOperation();
		XmlNormalizerBuilderOperation xnbo = new XmlNormalizerBuilderOperation(mop);
		XsdModelTemplate xsdModelTemplate = new XsdModelTemplate(xsdPacs002);
		xsdModelTemplate.apply(xnbo);
		IEntity xmlModelFromXsdPacs002 = mop.wGetResult();
	
		Assert.assertTrue(OrderedMatcher.match(xmlModelFromXsdPacs002, xmlPacs002, comparatorsMap));

		String credTrfFileName = "SCTCcfBlkCredTrf.xsd";
		IEntity xsdCredTrf = loadXMLSchema(credTrfFileName);
		CommonsEntityFactory.instance.createRootFragment(
				xsdCredTrf.wGetAdapter(CommonsEntityDescriptorEnum.Any));
		IEntity xmlCredTrf = XmlSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream(credTrfFileName)));
		CommonsEntityFactory.instance.createRootFragment(
				xmlCredTrf.wGetAdapter(CommonsEntityDescriptorEnum.Any));

		mop = new ModelBuilderOperation();
		xnbo = new XmlNormalizerBuilderOperation(mop);
		xsdModelTemplate = new XsdModelTemplate(xsdCredTrf);
		xsdModelTemplate.apply(xnbo);
		IEntity xmlModelFromXsdCredTrf = mop.wGetResult();
	
		Assert.assertTrue(OrderedMatcher.match(xmlModelFromXsdCredTrf, xmlCredTrf, comparatorsMap));
	}
}
