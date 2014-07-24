package org.whole.lang.xsd.mapping;

import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsTemplateManager;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.ResourceLoader;
import org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery;
import org.whole.lang.xsd.codebase.XsiPersistenceKit;
import org.whole.lang.xsd.mapping.model.MappingStrategy;
import org.whole.lang.xsd.mapping.samples.AppEngineWebInstance;
import org.whole.lang.xsd.mapping.samples.ChoiceSampleInstance;
import org.whole.lang.xsd.mapping.samples.CronInstance;
import org.whole.lang.xsd.mapping.samples.DatastoreIndexesInstance;
import org.whole.lang.xsd.mapping.samples.DatatypesInstance;
import org.whole.lang.xsd.mapping.samples.DosInstance;
import org.whole.lang.xsd.mapping.samples.FreemindInstance;
import org.whole.lang.xsd.mapping.samples.JDOConfigInstance;
import org.whole.lang.xsd.mapping.samples.Maven400Instance;
import org.whole.lang.xsd.mapping.samples.PainInstance;
import org.whole.lang.xsd.mapping.samples.QueueInstance;
import org.whole.lang.xsd.mapping.samples.SepaSctInstance;
import org.whole.lang.xsd.mapping.samples.SimpleContentInstance;
import org.whole.lang.xsd.mapping.samples.Xmi20Instance;
import org.whole.test.KnownFailingTests;
import org.whole.test.SlowTests;

public class XsdMappingTest {
	private final ResourceLoader loader = ResourceLoader.instance("org.whole.lang.xsd.mapping.samples");
	private final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Before
	public void setUp() throws Exception {
		factory.setResourceResolver(new ResourceResolverAdapter(loader));
	}

	@Test
	public void testMappingNormalization() throws Exception {
		MappingStrategy strategy = new ArtifactsMapping().create();
		MappingStrategy normalizedStrategy = new ArtifactsMappingNormalized().create();
		Assert.assertTrue(Matcher.match(normalizedStrategy, NormalizerOperation.normalize(strategy)));

		strategy = new SepaSctMapping().create();
		normalizedStrategy = new SepaSctMappingNormalized().create();
		Assert.assertTrue(Matcher.match(normalizedStrategy, NormalizerOperation.normalize(strategy)));
	}

	@Test
	public void testInclusion() throws Exception {
		InputStream is = loader.getResourceAsStream("books.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("books.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	@Category(SlowTests.class)
	@Test
	public void testXmi20() throws Exception {
		InputStream is = loader.getResourceAsStream("xmi20.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("xmi20.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("xmi20.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new Xmi20Instance().create(), model));
	}

	@Category(SlowTests.class)
	@Test
	public void testDatatypes() throws Exception {
		InputStream is = loader.getResourceAsStream("datatypes.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("datatypes.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("datatypes.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new DatatypesInstance().create(), model));
	}

	//Requires an Internet connection
	@Category(SlowTests.class)
	@Test
	public void testWsBPEL() throws Exception {
		InputStream is = loader.getResourceAsStream("ws-bpel_executable.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("ws-bpel-example.bpel");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	//Requires an Internet connection
	@Category(SlowTests.class)
	@Test
	public void testWsBPELLegacy() throws Exception {
		InputStream is = loader.getResourceAsStream("wsbpel_2_0.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("wsbpel_2_0.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	@Category(SlowTests.class)
	@Test
	public void testMaven() throws Exception {
		InputStream is = loader.getResourceAsStream("maven-v4_0_0.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("maven-v4_0_0.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("maven-v4_0_0.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new Maven400Instance().create(), model));
	}

	@Category(SlowTests.class)
	@Test
	public void testFreemind() throws Exception {
		InputStream is = loader.getResourceAsStream("freemind.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("freemindExample.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("freemindExample.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new FreemindInstance(model.wGetLanguageKit()).create(), model));
	}

	@Category(SlowTests.class)
	@Test
	public void testAppEngine() throws Exception {
		InputStream is = loader.getResourceAsStream("appengine-web.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("appengine-web.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("appengine-web.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new AppEngineWebInstance().create(), model));

		is = loader.getResourceAsStream("cron.xsd");
		ss = new StreamSource(is);
		schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("cron.xml");
		v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("cron.xml");
		pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new CronInstance(model.wGetLanguageKit()).create(), model));

		is = loader.getResourceAsStream("queue.xsd");
		ss = new StreamSource(is);
		schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("queue.xml");
		v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("queue.xml");
		pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new QueueInstance(model.wGetLanguageKit()).create(), model));

		is = loader.getResourceAsStream("datastore-indexes.xsd");
		ss = new StreamSource(is);
		schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("datastore-indexes.xml");
		v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("datastore-indexes.xml");
		pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new DatastoreIndexesInstance(model.wGetLanguageKit()).create(), model));

		is = loader.getResourceAsStream("dos.xsd");
		ss = new StreamSource(is);
		schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("dos.xml");
		v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("dos.xml");
		pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new DosInstance(model.wGetLanguageKit()).create(), model));

		is = loader.getResourceAsStream("jdoconfig_2_3.xsd");
		ss = new StreamSource(is);
		schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("jdoconfig.xml");
		v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("jdoconfig.xml");
		pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new JDOConfigInstance().create(), model));
	}

	@Test
	public void testChoiceSample() throws Exception {
		InputStream is = loader.getResourceAsStream("ChoiceSample.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("ChoiceSample.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("ChoiceSample.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new ChoiceSampleInstance().create(), model));
	}

	@Category(SlowTests.class)
	@Test
	public void testPain() throws Exception {
		InputStream is = loader.getResourceAsStream("pain.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("pain.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("pain.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new PainInstance().create(), model));
	}

	@Test
	public void testECore() throws Exception {
		InputStream is = loader.getResourceAsStream("ECore.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("HUTN.ecore");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	//Requires an Internet connection
	@Category(SlowTests.class)
	@Test
	public void testDocbook() throws Exception {
		InputStream is = loader.getResourceAsStream("docbook.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("docbook-howto.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	@Category(SlowTests.class)
	@Test
	public void testFlex3() throws Exception {
		InputStream is = loader.getResourceAsStream("flex3.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("flex3-sample.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	@Category(SlowTests.class)
	@Test
	public void testSCTScf() throws Exception {
		InputStream is = loader.getResourceAsStream("SepaSct.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("SepaSct.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("SepaSct.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new SepaSctInstance().create(), model));
	}

	//Requires an Internet connection
	@Category({SlowTests.class, KnownFailingTests.class})//FIXME remove KnownFailingTests
	@Test
	public void testSimpleContent() throws Exception {
		InputStream is = loader.getResourceAsStream("simpleContent.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("simpleContent.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));

		is = loader.getResourceAsStream("simpleContent.xml");
		IPersistenceProvider pp = new StreamPersistenceProvider(is);
		pp.getBindings().wDefValue("packageName", "org.whole.lang.xsd.mapping.samples");
		IEntity model = XsiPersistenceKit.instance().readModel(pp);

		Assert.assertTrue(Matcher.match(new SimpleContentInstance().create(), model));
	}

	@Test
	public void testMappedEditorsModel() throws Exception {
		InputStream is = loader.getResourceAsStream("Editors.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("Editors.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	@Test
	public void testMappedArtifactsModel() throws Exception {
		InputStream is = loader.getResourceAsStream("Artifacts.xsd");
		StreamSource ss = new StreamSource(is);
		Schema schema = factory.newSchema(ss);

		is = loader.getResourceAsStream("Artifacts.xml");
		Validator v = schema.newValidator();
		v.validate(new StreamSource(is));
	}

	@Test
	public void testModelsToXmlSchemaXXX() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		PathExpression path = new ModelToXmlSchemaQuery().create();
		Model model = (Model) ModelsTemplateManager.instance().create("Models model");
		String uri = model.getUri().getValue();
		ILanguageKit lk = ReflectionFactory.getLanguageKit(uri);
		IEntity tuple = BehaviorUtils.evaluateFirstResult(path, model, bm);
		Assert.assertNotNull(tuple);

		InterpreterOperation.interpret(tuple.wGet(1));
		ITemplateManager tm = lk.getTemplateManager();

		IEntity entity = tm.create("Editors model");
		IPersistenceProvider pp = new StringPersistenceProvider();
		XsiPersistenceKit.instance().writeModel(entity, pp);
		IEntity entity2 = XsiPersistenceKit.instance().readModel(pp);
		boolean matches = Matcher.match(entity, entity2);
		Assert.assertTrue (matches);
	}
}
