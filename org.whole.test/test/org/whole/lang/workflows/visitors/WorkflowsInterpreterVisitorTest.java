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

import junit.framework.TestCase;

import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
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
public class WorkflowsInterpreterVisitorTest extends TestCase {
	private Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();

	@Override
	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();

		comparatorsMap.put(ArtifactsEntityDescriptorEnum.Artifacts, new OrderedMatcher.SimpleFeatureComparator(ArtifactsFeatureDescriptorEnum.name));

		new File("data/SampleModel.xml").deleteOnExit();
		new File("data/SampleM.xml").deleteOnExit();
	}

	public void testSequence() {
		IEntity sequenceTest = WorkflowsTestTemplateManager.instance().create("sequenceTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(sequenceTest, args);

		assertTrue(args.wIsSet("equals"));
		assertTrue(args.wBooleanValue("equals"));
	}

	public void testParallel() {
		IEntity parallelTest = WorkflowsTestTemplateManager.instance().create("parallelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(parallelTest, args);

		assertTrue(args.wIsSet("equals"));
		assertTrue(args.wBooleanValue("equals"));
	}

	public void testWhileLoop() {
		IEntity whileLoopTest = WorkflowsTestTemplateManager.instance().create("whileLoopTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(whileLoopTest, args);

		assertTrue(args.wIsSet("count"));
		assertEquals(5, args.wIntValue("count"));
	}

	public void testForeachLoop() {
		IEntity foreachLoopTest = WorkflowsTestTemplateManager.instance().create("foreachLoopTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(foreachLoopTest, args);

		assertTrue(args.wIsSet("count"));
		assertEquals(5, args.wIntValue("count"));
	}

	public void testSwitchControl() {
		IEntity switchControlTest = WorkflowsTestTemplateManager.instance().create("switchControlTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(switchControlTest, args);

		assertTrue(args.wIsSet("value"));
		assertEquals(12, args.wIntValue("value"));

		assertTrue(args.wIsSet("result"));
		assertEquals(1235, args.wIntValue("result"));
	}

	public void testLoadModel() {
		IEntity loadModelTest = WorkflowsTestTemplateManager.instance().create("loadModelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(loadModelTest, args);
		
		assertFalse(args.wIsSet("varName"));
		
		assertTrue(Matcher.match(args.wGet("model"), new SampleModel().create()));
	}
	
	public void testLoadAndSaveModelToString() {
		IEntity loadAndSaveModelToStringTest = WorkflowsTestTemplateManager.instance().create("loadAndSaveModelToStringTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		String ls = System.getProperty("line.separator");
		String sourceString =	"Hello, world!"+ls+
								"This is a three"+ls+
								"lines text message";

		args.wDefValue("sourceString", sourceString);
		InterpreterOperation.interpret(loadAndSaveModelToStringTest, args);

		assertTrue(args.wIsSet("targetString"));
		assertEquals(args.wStringValue("sourceString"), args.wStringValue("targetString"));
	}

	public void testSaveModel() {
		IEntity saveModelTest = WorkflowsTestTemplateManager.instance().create("saveModelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDef("model", new SampleModel().create());
		InterpreterOperation.interpret(saveModelTest, args);

		assertTrue(Matcher.match(args.wGet("model"), args.wGet("newModel")));

	}

	public void testLoadJavaModel() {
		IEntity loadJavaModelTest = WorkflowsTestTemplateManager.instance().create("loadJavaModelTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(loadJavaModelTest, args);
		
		assertTrue(Matcher.match(args.wGet("model"), 
				new JavaClassTemplateFactory(SampleModel.class).create()));
	}


	public void testShallowSaveArtifacts() {
		IEntity shallowSaveArtifactsTest = WorkflowsTestTemplateManager.instance().create("shallowSaveArtifactsTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(shallowSaveArtifactsTest, args);

		assertTrue(args.wIsSet("artifacts"));
		IEntity artifacts = args.wGet("artifacts");

		assertTrue(args.wIsSet("shallowResult"));
		IEntity shallowResult = args.wGet("shallowResult");

		assertTrue(args.wIsSet("deepFileResult"));
		IEntity deepFileResult = args.wGet("deepFileResult");

		assertTrue(args.wIsSet("deepDirectoryResult"));
		IEntity deepDirectoryResult = args.wGet("deepDirectoryResult");

		assertTrue(args.wIsSet("deepResult"));
		IEntity deepResult = args.wGet("deepResult");

		// shallow save & deep file load == shallow save & deep
		assertTrue(OrderedMatcher.match(deepFileResult, deepResult, comparatorsMap));

		// shallow save & deep directory load == shallow save & shallow
		assertTrue(OrderedMatcher.match(deepDirectoryResult, shallowResult, comparatorsMap));
		
		// the original model differs from every other model
		assertFalse(OrderedMatcher.match(artifacts, shallowResult, comparatorsMap));
		assertFalse(OrderedMatcher.match(artifacts, deepFileResult, comparatorsMap));
		assertFalse(OrderedMatcher.match(artifacts, deepDirectoryResult, comparatorsMap));
		assertFalse(OrderedMatcher.match(artifacts, deepResult, comparatorsMap));

		// the only difference is the content on the file artifact
		IEntityIterator<IEntity> iterator = IteratorFactory.matcherIterator(
				IteratorFactory.descendantOrSelfIterator())
						.withPattern(ArtifactsFeatureDescriptorEnum.content);

		iterator.reset(deepFileResult);
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		assertTrue(OrderedMatcher.match(deepDirectoryResult, deepFileResult, comparatorsMap));
	}

	public void testDeepSaveArtifacts() {
		IEntity deepSaveArtifactsTest = WorkflowsTestTemplateManager.instance().create("deepSaveArtifactsTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(deepSaveArtifactsTest, args);

		assertTrue(args.wIsSet("artifacts"));
		IEntity artifacts = args.wGet("artifacts");

		assertTrue(args.wIsSet("shallowResult"));
		IEntity shallowResult = args.wGet("shallowResult");

		assertTrue(args.wIsSet("deepFileResult"));
		IEntity deepFileResult = args.wGet("deepFileResult");

		assertTrue(args.wIsSet("deepDirectoryResult"));
		IEntity deepDirectoryResult = args.wGet("deepDirectoryResult");

		assertTrue(args.wIsSet("deepResult"));
		IEntity deepResult = args.wGet("deepResult");

		// deep save & deep load == original model
		assertTrue(OrderedMatcher.match(artifacts, deepResult, comparatorsMap));
		
		// the original model differs from every other model
		assertFalse(OrderedMatcher.match(artifacts, shallowResult, comparatorsMap));
		assertFalse(OrderedMatcher.match(artifacts, deepFileResult, comparatorsMap));
		assertFalse(OrderedMatcher.match(artifacts, deepDirectoryResult, comparatorsMap));

		// the only difference is the content on the file artifact
		IEntityIterator<IEntity> iterator = IteratorFactory.matcherIterator(
				IteratorFactory.descendantOrSelfIterator())
						.withPattern(ArtifactsFeatureDescriptorEnum.content);

		iterator.reset(deepResult);
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		assertTrue(Matcher.match(deepDirectoryResult, deepResult));
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

	public void testInvokeOperation() throws Exception {
		IEntity invokeOperationTest = WorkflowsTestTemplateManager.instance().create("invokeOperationTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();

		TestDecorationManager dm = new TestDecorationManager();
		args.wDefValue("decorationManager", dm);
		StringWriter writer = new StringWriter();
		args.wDefValue("printWriter", new PrintWriter(writer));
		InterpreterOperation.interpret(invokeOperationTest, args);

		assertTrue(args.wIsSet("model"));
		assertTrue(args.wIsSet("modelCopy"));

		// validate assertions
		assertNotNull(dm.messages);
		assertFalse(dm.messages.isEmpty());
		assertEquals(1, dm.messages.size());
		assertTrue(dm.messages.contains("Reference to the undeclared type: IType"));
		
		// normalize assertions
		IEntity modelCopy = args.wGet("modelCopy");
		assertFalse(Matcher.match(args.wGet("model"), modelCopy));
		assertTrue(Matcher.match(args.wGet("model"), 
				NormalizerOperation.normalize(EntityUtils.clone(modelCopy))));

		// pretty print assertions
		String ls = System.getProperty("line.separator");
		String TEXT_MODEL = "model SampleM" + ls+ls+ls+
		"entity Type types IType" + ls+
		"    feature DataStr data" + ls+ls+
		"entity DataStr" + ls+
		"    value <String>" + ls+ls+
		"abstract entity IType" + ls;
		assertEquals(TEXT_MODEL, writer.toString());

		// pretty print assertions
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit("http://lang.whole.org/SampleM");
		assertNotNull(languageKit);
		EntityDescriptor<? extends IEntity> ed = languageKit.getEntityDescriptorEnum().valueOf("Type");
		assertNotNull(ed);
		assertEquals(1, ed.featureSize());

		// generate assertions
		File file = new File("./data/SampleM.xwl");
		assertTrue(file.exists());
		IEntity entity = XmlBuilderPersistenceKit.instance().readModel(
				new FilePersistenceProvider(file));
		assertTrue(Matcher.match(args.wGet("model"), entity));
		assertFalse(args.wIsSet("fileArtifact"));
	}

	public void testInvokeQuery() {
		IEntity invokeQueryTest = WorkflowsTestTemplateManager.instance().create("invokeQueryTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wEnterScope();
		InterpreterOperation.interpret(invokeQueryTest, args);
		args.wExitScope();
		
		assertFalse(args.wIsSet("queryName"));
		assertFalse(args.wIsSet("methodName"));
		assertFalse(args.wIsSet("self"));
		assertFalse(args.wIsSet("methodCall"));
	}

	public void testCreateEntity() {
		IEntity createEntityTest = WorkflowsTestTemplateManager.instance().create("createEntityTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(createEntityTest, args);

		ModelsEntityFactory mef = ModelsEntityFactory.instance(RegistryConfigurations.RESOLVER); 

		assertTrue(args.wIsSet("entity"));
		assertTrue(Matcher.match(
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

		assertTrue(args.wIsSet("model"));
		IEntity model = args.wGet("model");
		Matcher.removeVars(model, false);
		assertTrue(Matcher.match(se, model));
	}

	public void testCreateJavaClassInstance() {
		IEntity createJavaClassInstanceTest = WorkflowsTestTemplateManager.instance().create("createJavaClassInstanceTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(createJavaClassInstanceTest, args);

		assertTrue(args.wIsSet("value"));
		assertEquals(new BigDecimal("1231.84587345"), args.wGetValue("value"));
	}

	public void testInvokeJavaClassMethodTest() {
		IEntity invokeJavaClassMethodTest = WorkflowsTestTemplateManager.instance().create("invokeJavaClassMethodTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(invokeJavaClassMethodTest, args);

		assertTrue(args.wIsSet("value"));
		assertEquals(Double.parseDouble("1231.84587345"), args.wGetValue("value"));
	}

	public void testInvokeJavaInstanceMethod() {
		IEntity invokeJavaInstanceMethodTest = WorkflowsTestTemplateManager.instance().create("invokeJavaInstanceMethodTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(invokeJavaInstanceMethodTest, args);

		assertTrue(args.wIsSet("value"));
		assertFalse(args.wBooleanValue("value"));
	}

	public void testParse() {
		IEntity parseTest = WorkflowsTestTemplateManager.instance().create("parseTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(parseTest, args);

		assertTrue(args.wIsSet("model"));
		IEntity model = args.wGet("model");
		assertEquals(32, model.wGet(0).wIntValue());
		assertEquals("enrico", model.wGet(1).wStringValue());
	}

	public void testUnparse() {
		IEntity unparseTest = WorkflowsTestTemplateManager.instance().create("unparseTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		InterpreterOperation.interpret(unparseTest, args);

		assertTrue(args.wIsSet("text"));
		assertEquals("Type1, Type2, Type3", args.wStringValue("text"));
	}

	public void testTask() {
		IEntity taskTest = WorkflowsTestTemplateManager.instance().create("taskTest");
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDefValue("reader", new StringReader("yep!\n"));

		try {
			InterpreterOperation.interpret(taskTest, args, (Reader) null, (Writer) null);
		} catch (VisitException e) {
			fail();
		}

		args.wDefValue("reader", new StringReader("NO\n"));
		try {
			InterpreterOperation.interpret(taskTest, args, (Reader) null, (Writer) null);
			fail();
		} catch (VisitException e) {
		}
	}
}
