package org.whole.lang.workflows.visitors;

import java.io.File;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.java.codebase.JavaClassTemplateFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.operations.AbstractDecorationManager;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.rdb.codebase.OrderedMatcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Enrico Persiani
 */
public class WorkflowsInterpreterVisitorTest {
	private Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.undeployWholePlatform(); //TODO workaround
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
	public void setUp() throws Exception {
		comparatorsMap.put(ArtifactsEntityDescriptorEnum.Artifacts, new OrderedMatcher.SimpleFeatureComparator(ArtifactsFeatureDescriptorEnum.name));

		new File("data/artifacts").mkdir();
		new File("data/SampleModel.xml").deleteOnExit();
		new File("data/SampleM.xml").deleteOnExit();
	}
	
	@Test
	public void testSequence() {
		IEntity sequenceTest = WorkflowsTestTemplateManager.instance().create("sequenceTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(sequenceTest, args);

		Assert.assertTrue(args.wIsSet("equals"));
		Assert.assertTrue(args.wBooleanValue("equals"));
	}

	@Test
	public void testParallel() {
		IEntity parallelTest = WorkflowsTestTemplateManager.instance().create("parallelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(parallelTest, args);

		Assert.assertTrue(args.wIsSet("equals"));
		Assert.assertTrue(args.wBooleanValue("equals"));
	}

	@Test
	public void testWhileLoop() {
		IEntity whileLoopTest = WorkflowsTestTemplateManager.instance().create("whileLoopTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(whileLoopTest, args);

		Assert.assertTrue(args.wIsSet("count"));
		Assert.assertEquals(5, args.wIntValue("count"));
	}

	@Test
	public void testForeachLoop() {
		IEntity foreachLoopTest = WorkflowsTestTemplateManager.instance().create("foreachLoopTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(foreachLoopTest, args);

		Assert.assertTrue(args.wIsSet("count"));
		Assert.assertEquals(5, args.wIntValue("count"));
	}

	@Test
	public void testSwitchControl() {
		IEntity switchControlTest = WorkflowsTestTemplateManager.instance().create("switchControlTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(switchControlTest, args);

		Assert.assertTrue(args.wIsSet("value"));
		Assert.assertEquals(12, args.wIntValue("value"));

		Assert.assertTrue(args.wIsSet("result"));
		Assert.assertEquals(1235, args.wIntValue("result"));
	}

	@Test
	public void testLoadModel() {
		IEntity loadModelTest = WorkflowsTestTemplateManager.instance().create("loadModelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(loadModelTest, args);
		
		Assert.assertFalse(args.wIsSet("varName"));
		
		Assert.assertTrue(Matcher.match(args.wGet("model"), new SampleModel().create()));
	}
	
	@Test
	public void testLoadAndSaveModelToString() {
		IEntity loadAndSaveModelToStringTest = WorkflowsTestTemplateManager.instance().create("loadAndSaveModelToStringTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		String ls = System.getProperty("line.separator");
		String sourceString =	"Hello, world!"+ls+
								"This is a three"+ls+
								"lines text message";

		args.wDefValue("sourceString", sourceString);
		InterpreterOperation.interpret(loadAndSaveModelToStringTest, args);

		Assert.assertTrue(args.wIsSet("targetString"));
		Assert.assertEquals(args.wStringValue("sourceString"), args.wStringValue("targetString"));
	}

	@Test
	public void testSaveModel() {
		IEntity saveModelTest = WorkflowsTestTemplateManager.instance().create("saveModelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDef("model", new SampleModel().create());
		InterpreterOperation.interpret(saveModelTest, args);

		Assert.assertTrue(Matcher.match(args.wGet("model"), args.wGet("newModel")));

	}

	@Test
	public void testLoadJavaModel() {
		IEntity loadJavaModelTest = WorkflowsTestTemplateManager.instance().create("loadJavaModelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(loadJavaModelTest, args);
		
		Assert.assertTrue(Matcher.match(args.wGet("model"), 
				new JavaClassTemplateFactory(SampleModel.class).create()));
	}


	@Test
	public void testShallowSaveArtifacts() {
		IEntity shallowSaveArtifactsTest = WorkflowsTestTemplateManager.instance().create("shallowSaveArtifactsTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(shallowSaveArtifactsTest, args);

		Assert.assertTrue(args.wIsSet("artifacts"));
		IEntity artifacts = args.wGet("artifacts");

		Assert.assertTrue(args.wIsSet("shallowResult"));
		IEntity shallowResult = args.wGet("shallowResult");

		Assert.assertTrue(args.wIsSet("deepFileResult"));
		IEntity deepFileResult = args.wGet("deepFileResult");

		Assert.assertTrue(args.wIsSet("deepDirectoryResult"));
		IEntity deepDirectoryResult = args.wGet("deepDirectoryResult");

		Assert.assertTrue(args.wIsSet("deepResult"));
		IEntity deepResult = args.wGet("deepResult");

		// shallow save & deep file load == shallow save & deep
		Assert.assertTrue(OrderedMatcher.match(deepFileResult, deepResult, comparatorsMap));

		// shallow save & deep directory load == shallow save & shallow
		Assert.assertTrue(OrderedMatcher.match(deepDirectoryResult, shallowResult, comparatorsMap));
		
		// the original model differs from every other model
		Assert.assertFalse(OrderedMatcher.match(artifacts, shallowResult, comparatorsMap));
		Assert.assertFalse(OrderedMatcher.match(artifacts, deepFileResult, comparatorsMap));
		Assert.assertFalse(OrderedMatcher.match(artifacts, deepDirectoryResult, comparatorsMap));
		Assert.assertFalse(OrderedMatcher.match(artifacts, deepResult, comparatorsMap));

		// the only difference is the content on the file artifact
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable executable = f.createFilter(f.createDescendantOrSelf(), f.createAtFeature(ArtifactsFeatureDescriptorEnum.content.getURI()));

		executable.reset(deepFileResult);
		while (executable.evaluateNext() != null)
			executable.remove();

		Assert.assertTrue(OrderedMatcher.match(deepDirectoryResult, deepFileResult, comparatorsMap));
	}

	@Test
	public void testDeepSaveArtifacts() {
		IEntity deepSaveArtifactsTest = WorkflowsTestTemplateManager.instance().create("deepSaveArtifactsTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(deepSaveArtifactsTest, args);

		Assert.assertTrue(args.wIsSet("artifacts"));
		IEntity artifacts = args.wGet("artifacts");

		Assert.assertTrue(args.wIsSet("shallowResult"));
		IEntity shallowResult = args.wGet("shallowResult");

		Assert.assertTrue(args.wIsSet("deepFileResult"));
		IEntity deepFileResult = args.wGet("deepFileResult");

		Assert.assertTrue(args.wIsSet("deepDirectoryResult"));
		IEntity deepDirectoryResult = args.wGet("deepDirectoryResult");

		Assert.assertTrue(args.wIsSet("deepResult"));
		IEntity deepResult = args.wGet("deepResult");

		// deep save & deep load == original model
		Assert.assertTrue(OrderedMatcher.match(artifacts, deepResult, comparatorsMap));
		
		// the original model differs from every other model
		Assert.assertFalse(OrderedMatcher.match(artifacts, shallowResult, comparatorsMap));
		Assert.assertFalse(OrderedMatcher.match(artifacts, deepFileResult, comparatorsMap));
		Assert.assertFalse(OrderedMatcher.match(artifacts, deepDirectoryResult, comparatorsMap));

		// the only difference is the content on the file artifact
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable executable = f.createFilter(f.createDescendantOrSelf(), f.createAtFeature(ArtifactsFeatureDescriptorEnum.content.getURI()));

		executable.reset(deepResult);
		while (executable.evaluateNext() != null)
			executable.remove();
		Assert.assertTrue(Matcher.match(deepDirectoryResult, deepResult));
	}

	private static final class TestDecorationManager extends AbstractDecorationManager {
		public Set<String> messages;
		public void addDecoration(DecorationKind kind, IEntity entity, String message, String location) {
			messages.add(message);
		}
		public void deleteDecorations(IEntity entity, boolean deep) {
			messages = new HashSet<String>();
		}
	}

	@Test
	public void testInvokeOperation() throws Exception {
		IEntity invokeOperationTest = WorkflowsTestTemplateManager.instance().create("invokeOperationTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();

		TestDecorationManager dm = new TestDecorationManager();
		args.wDefValue("decorationManager", dm);
		StringWriter writer = new StringWriter();
		args.wDefValue("printWriter", new PrintWriter(writer));
		InterpreterOperation.interpret(invokeOperationTest, args);

		Assert.assertTrue(args.wIsSet("model"));
		Assert.assertTrue(args.wIsSet("modelCopy"));

		// validate assertions
		Assert.assertNotNull(dm.messages);
		Assert.assertFalse(dm.messages.isEmpty());
		Assert.assertEquals(1, dm.messages.size());
		Assert.assertTrue(dm.messages.contains("Reference to the undeclared type: IType"));
		
		// normalize assertions
		IEntity modelCopy = args.wGet("modelCopy");
		Assert.assertFalse(Matcher.match(args.wGet("model"), modelCopy));
		Assert.assertTrue(Matcher.match(args.wGet("model"), 
				NormalizerOperation.normalize(EntityUtils.clone(modelCopy))));

		// pretty print assertions
		String ls = System.getProperty("line.separator");
		String TEXT_MODEL = "model SampleM" + ls+ls+ls+
		"entity Type types IType" + ls+
		"    feature DataStr data" + ls+ls+
		"entity DataStr" + ls+
		"    value <String>" + ls+ls+
		"abstract entity IType" + ls;
		Assert.assertEquals(TEXT_MODEL, writer.toString());

		// pretty print assertions
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit("http://lang.whole.org/SampleM");
		Assert.assertNotNull(languageKit);
		EntityDescriptor<? extends IEntity> ed = languageKit.getEntityDescriptorEnum().valueOf("Type");
		Assert.assertNotNull(ed);
		Assert.assertEquals(1, ed.featureSize());

		// generate assertions
		File file = new File("./data/SampleM.xwl");
		Assert.assertTrue(file.exists());
		IEntity entity = XmlBuilderPersistenceKit.instance().readModel(
				new FilePersistenceProvider(file));
		Assert.assertTrue(Matcher.match(args.wGet("model"), entity));
		Assert.assertFalse(args.wIsSet("fileArtifact"));
	}

	@Test
	public void testInvokeQuery() {
		IEntity invokeQueryTest = WorkflowsTestTemplateManager.instance().create("invokeQueryTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wEnterScope();
		InterpreterOperation.interpret(invokeQueryTest, args);
		args.wExitScope();
		
		Assert.assertFalse(args.wIsSet("queryName"));
		Assert.assertFalse(args.wIsSet("methodName"));
		Assert.assertFalse(args.wIsSet(IBindingManager.SELF));
		Assert.assertFalse(args.wIsSet("methodCall"));
	}

	@Test
	public void testCreateEntity() {
		IEntity createEntityTest = WorkflowsTestTemplateManager.instance().create("createEntityTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(createEntityTest, args);

		ModelsEntityFactory mef = ModelsEntityFactory.instance(RegistryConfigurations.RESOLVER); 

		Assert.assertTrue(args.wIsSet("entity"));
		Assert.assertTrue(Matcher.match(
				mef.buildSimpleEntity()
						.set(ModelsFeatureDescriptorEnum.modifiers,
								mef.createEntityModifiers(0))
						.set(ModelsFeatureDescriptorEnum.name,
								mef.createSimpleName("EntityName"))
						.set(ModelsFeatureDescriptorEnum.types,
								mef.createTypes(mef.createSimpleName("Type")))
						.set(ModelsFeatureDescriptorEnum.features,
								mef.createFeatures(mef.buildFeature()
										.set(ModelsFeatureDescriptorEnum.type,
												mef.createSimpleName("FType"))
										.set(ModelsFeatureDescriptorEnum.name,
												mef.createSimpleName("fname"))
										.getResult()))
						.getResult(),
				args.wGet("entity")
		));
	}

	@Test
	public void testCreateModel() {
		IEntity createModelTest = WorkflowsTestTemplateManager.instance().create("createModelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(createModelTest, args);

		ModelsEntityFactory mef = ModelsEntityFactory.instance;
		SimpleEntity se = mef.createSimpleEntity(
				mef.createEntityModifiers(mef.createEntityModifier(EntityModifierEnum._abstract)),
				mef.createSimpleName("Entity1"),
				mef.createTypes(0),
				mef.createFeatures(mef.buildFeature()
						.set(ModelsFeatureDescriptorEnum.type,
								mef.createSimpleName("FType"))
						.set(ModelsFeatureDescriptorEnum.name,
								mef.createSimpleName("fname"))
						.getResult())
		);

		Assert.assertTrue(args.wIsSet("model"));
		IEntity model = args.wGet("model");
		Matcher.removeVars(model, false);
		Assert.assertTrue(Matcher.match(se, model));
	}

	@Test
	public void testCreateJavaClassInstance() {
		IEntity createJavaClassInstanceTest = WorkflowsTestTemplateManager.instance().create("createJavaClassInstanceTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(createJavaClassInstanceTest, args);

		Assert.assertTrue(args.wIsSet("value"));
		Assert.assertEquals(new BigDecimal("1231.84587345"), args.wGetValue("value"));
	}

	@Test
	public void testInvokeJavaClassMethodTest() {
		IEntity invokeJavaClassMethodTest = WorkflowsTestTemplateManager.instance().create("invokeJavaClassMethodTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(invokeJavaClassMethodTest, args);

		Assert.assertTrue(args.wIsSet("value"));
		Assert.assertEquals(Double.parseDouble("1231.84587345"), args.wGetValue("value"));
	}

	@Test
	public void testInvokeJavaInstanceMethod() {
		IEntity invokeJavaInstanceMethodTest = WorkflowsTestTemplateManager.instance().create("invokeJavaInstanceMethodTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(invokeJavaInstanceMethodTest, args);

		Assert.assertTrue(args.wIsSet("value"));
		Assert.assertFalse(args.wBooleanValue("value"));
	}

	@Test
	public void testParse() {
		IEntity parseTest = WorkflowsTestTemplateManager.instance().create("parseTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(parseTest, args);

		Assert.assertTrue(args.wIsSet("model"));
		IEntity model = args.wGet("model");
		Assert.assertEquals(32, model.wGet(0).wIntValue());
		Assert.assertEquals("enrico", model.wGet(1).wStringValue());
	}

	@Test
	public void testUnparse() {
		IEntity unparseTest = WorkflowsTestTemplateManager.instance().create("unparseTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(unparseTest, args);

		Assert.assertTrue(args.wIsSet("text"));
		Assert.assertEquals("Type1, Type2, Type3", args.wStringValue("text"));
	}

	@Test
	public void testTask() {
		IEntity taskTest = WorkflowsTestTemplateManager.instance().create("taskTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDefValue("reader", new StringReader("yep!\n"));

		try {
			InterpreterOperation.interpret(taskTest, args, (Reader) null, (Writer) null);
		} catch (VisitException e) {
			Assert.fail();
		}

		args.wDefValue("reader", new StringReader("NO\n"));
		try {
			InterpreterOperation.interpret(taskTest, args, (Reader) null, (Writer) null);
			Assert.fail();
		} catch (VisitException e) {
		}
	}
}
