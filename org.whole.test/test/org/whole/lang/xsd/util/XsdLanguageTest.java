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

import java.io.File;
import java.io.FilenameFilter;
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
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.ArtifactsModel;
import org.whole.lang.models.model.Model;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.rdb.codebase.OrderedMatcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.codebase.XsiPersistenceKit;
import org.whole.lang.xsd.model.Schema;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;
import org.whole.test.KnownFailingTests;
import org.whole.test.SlowTests;

/**
 * @author Enrico Persiani
 */
public class XsdLanguageTest {

	private Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = 
		new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Before
    public void setUp() {
		comparatorsMap.put(XsdEntityDescriptorEnum.NamespaceDecls, 
				new OrderedMatcher.SimpleFeatureComparator(XsdFeatureDescriptorEnum.uri));
		comparatorsMap.put(XsdEntityDescriptorEnum.SchemaComponents, 
				new OrderedMatcher.SimpleFeatureComparator(XsdFeatureDescriptorEnum.name));
		comparatorsMap.put(XsdEntityDescriptorEnum.Particles, new Comparator<IEntity>() {
			public int compare(IEntity o1, IEntity o2) {
				String s1 = Matcher.isAssignableAsIsFrom(XsdEntityDescriptorEnum.NamedComponent, o1) ?//TODO test was isAssignableFrom
					o1.wGet(XsdFeatureDescriptorEnum.name).wStringValue() : o1.wGet(XsdFeatureDescriptorEnum.ref).wStringValue();
				String s2 = Matcher.isAssignableAsIsFrom(XsdEntityDescriptorEnum.NamedComponent, o2) ?//TODO test was isAssignableFrom
						o2.wGet(XsdFeatureDescriptorEnum.name).wStringValue() : o2.wGet(XsdFeatureDescriptorEnum.ref).wStringValue();
				return s1.compareTo(s2);
			}
		});
	}

	private Schema loadXsd(String fileName) throws Exception {
		return (Schema) XsdPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream(fileName)));
	}

	private InputStream getInputStream(String fileName) {
		return getClass().getResourceAsStream(fileName);
	}

	private void loadSchemaInstance(String schemaFileName, String... instanceFileNames) throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		String folderLocation = new File("test/org/whole/lang/xsd/util").getAbsolutePath();
		bm.wDefValue("folderLocation", folderLocation);
		bm.wDefValue("packageName", "");
		Schema xsd = loadXsd(schemaFileName);
		InterpreterOperation.interpret(xsd, bm);
		for (String instanceFileName : instanceFileNames)
			XsiPersistenceKit.instance().readModel(
					new StreamPersistenceProvider(getInputStream(instanceFileName)));
	}

	@Test
	public void testXsdNormalization() {
		try {
			Schema xsdNormalized1 = NormalizerOperation.normalize(loadXsd("schema-to-normalize.xsd"));
			Schema xsdNormalized2 = loadXsd("schema-normalized.xsd");

			Assert.assertTrue(OrderedMatcher.match(xsdNormalized2, xsdNormalized1, comparatorsMap));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Category(SlowTests.class)
	@Test
	public void testXsdPersistence() {
		File file = null;
		try {
			IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
			File folder = new File("test/org/whole/lang/xsd/util");
			bm.wDefValue("folderLocation", folder.getAbsolutePath());
			bm.wDefValue("packageName", "");

			FilenameFilter xsdFilenameFilter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".xsd");
				}
			};
			for (File f : folder.listFiles(xsdFilenameFilter))
				XsdPersistenceKit.instance().readModel(new FilePersistenceProvider(file = f, bm));

			folder = new File("test/org/whole/lang/xsd/util/xsd");
			bm.wDefValue("folderLocation", folder.getAbsolutePath());
			bm.wDefValue("packageName", "");

			for (File f : folder.listFiles(xsdFilenameFilter))
				XsdPersistenceKit.instance().readModel(new FilePersistenceProvider(file = f, bm));

		} catch (Exception e) {
			Assert.fail("Cannot load "+file+" cause:\n"+e.getMessage());
		}
	}

	@Test
	public void testModelToXsdMapping() {
		try {
			IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
			PathExpression path = new ModelToXmlSchemaQuery().create();
			Model model = new ArtifactsModel().create();

			Assert.assertNotNull(BehaviorUtils.evaluateFirstResult(path, model, bm));
			IEntity mappedXsd = bm.wGet("schema");

			IEntity xsd = loadXsd("artifacts.xsd");
			Assert.assertTrue(OrderedMatcher.match(xsd, mappedXsd, comparatorsMap));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testArtifactsMappedModel() {
		try {
			IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
			PathExpression path = new ModelToXmlSchemaQuery().create();
			Model model = new ArtifactsModel().create();

			Assert.assertNotNull(BehaviorUtils.evaluateFirstResult(path, model, bm));
			InterpreterOperation.interpret(bm.wGet("mapping"));

			bm.wDefValue("folderLocation", new File("test/org/whole/lang/xsd/util").getAbsolutePath());
			bm.wDefValue("packageName", "");
			IEntity artifacts = XsiPersistenceKit.instance().readModel(new StreamPersistenceProvider(getInputStream("Artifacts.xml"), null, bm));
			
			Assert.assertTrue(Matcher.match(new Artifacts().create(), artifacts));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Category({KnownFailingTests.class, SlowTests.class})
	@Test
	public void testBpel20Instance() {
		try {
			loadSchemaInstance("wsbpel_2_0.xsd", "wsbpel_2_0.xml", "Div.bpel",
					"ReceiveMessageFromApplication.bpel", "ReceiveTwoOperandForSum.bpel",
					"SlaveProcess.bpel", "StringMessageReceive.bpel", "Sum.bpel",
					"SumReceiveProcess.bpel", "Java2BPELException.bpel", "MasterProcess.bpel");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testXslt20Instance() {
		Assert.fail(); // force failure since test is unable to download imported schemas
		try {
			loadSchemaInstance("xslt20.xsd", "xslt20.xml");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testJsp21Instance() {
		Assert.fail(); // force failure since test is unable to download imported schemas
		try {
			loadSchemaInstance("jsp_2_1.xsd", "jsp_2_1.xml");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testXhtml11Instance() {
		Assert.fail(); // force failure since test is unable to download imported schemas
		try {
			loadSchemaInstance("xhtml11.xsd", "xhtml11.xml");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testXForms10Instance() {
		Assert.fail(); // force failure since test is unable to download imported schemas
		try {
			loadSchemaInstance("XForms-Schema10.xsd", "XForms-Schema10.xml");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
