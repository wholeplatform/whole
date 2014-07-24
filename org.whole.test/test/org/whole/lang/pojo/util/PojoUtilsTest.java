package org.whole.lang.pojo.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.ITypeRoot;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.java.codebase.JavaClassTemplateFactory;
import org.whole.lang.java.codebase.JavaSourceTemplateFactory;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.misc.factories.MiscEntityFactory;
import org.whole.lang.misc.model.Any;
import org.whole.lang.misc.model.Misc;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.test.KnownFailingTests;
import org.whole.test.SlowTests;

@Category(SlowTests.class)
public class PojoUtilsTest {
	private static final Class<?>[] CLASSES = { AbstractPojo1.class, AbstractPojo2.class,
		ConcretePojo1.class, ConcretePojo2.class, EnumPojo.class, SimplePojo.class};

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@SuppressWarnings("unchecked")
	private Object createPojo() {
		Set<Pattern> testSet = new HashSet<Pattern>();
		testSet.add(Pattern.compile("xxx"));
		testSet.add(Pattern.compile("yyy"));
		return new SimplePojo(true, (byte) 127, 'c', 1.0, 1.1f, 1000000, 100000000000l, (short) 10000, "" ,
				new SimplePojo(false, (byte) 12, '\0', 0.0, 0.0f, 0, 0l, (short) 0, "12", null, null,
						Pattern.compile(".+"), 
						new ConcretePojo1(Pattern.compile(".+"), "concretePojo1"),
						EnumPojo.VALUE1, new Set[] { testSet }),
				new SimplePojo(false, (byte) 13, '\0', 0.0, 0.0f, 0, 0l, (short) 0, "13", null, null,
						Pattern.compile(".?"),
						new ConcretePojo2(Pattern.compile(".?"), true, 22222),
						EnumPojo.VALUE2, null),
				Pattern.compile(".*"),
				new ConcretePojo1(),
				EnumPojo.VALUE3,
				null
		);
	}

	public static Misc getCompilationUnits(Class<?> ...classes) {
		MiscEntityFactory mef = MiscEntityFactory.instance;
		Misc misc = mef.createMisc(0);

		for (int i=0; i<classes.length; i++) {
			JavaClassTemplateFactory javaSourceTemplateFactory = new JavaClassTemplateFactory(classes[i]);
			CompilationUnit compilationUnit = javaSourceTemplateFactory.create();
			Any stageUpFragment = CommonsEntityAdapterFactory.createStageUpFragment(MiscEntityDescriptorEnum.Any, compilationUnit);
			misc.wAdd(stageUpFragment);
		}
		return misc;
	}

	public static Misc getCompilationUnits(ITypeRoot ...typeRoots) {
		MiscEntityFactory mef = MiscEntityFactory.instance;
		Misc misc = mef.createMisc(0);

		for (int i=0; i<typeRoots.length; i++) {
			JavaSourceTemplateFactory javaSourceTemplateFactory = new JavaSourceTemplateFactory(typeRoots[i]);
			CompilationUnit compilationUnit = javaSourceTemplateFactory.create();
			Any stageUpFragment = CommonsEntityAdapterFactory.createStageUpFragment(MiscEntityDescriptorEnum.Any, compilationUnit);
			misc.wAdd(stageUpFragment);
		}
		return misc;
	}

	@Category(KnownFailingTests.class)//FIXME
	@Test
	public void testTranslateFromPojoClasses() {
		Object simplePojo = createPojo();

		Misc compilationUnits = getCompilationUnits(CLASSES);

		Library library = PojoMappingUtils.getLibrary(compilationUnits, "SimplePojo");
		IEntity mappedModel = PojoMappingUtils.getModel(library);

		InterpreterOperation.interpret(mappedModel);

		Library normalizedLibrary = NormalizerOperation.normalize(EntityUtils.clone(library));
		IEntity simplePojoModel = PojoUtils.create(simplePojo, normalizedLibrary);
		Object simplePojoObject = PojoUtils.create(simplePojoModel, normalizedLibrary);

		Assert.assertEquals(simplePojoObject, simplePojo);
	}

//FIXME
//
// must implement SimpleName and SimpleType resolution using imports and package declaration
//
//	public void testTranslateFromPojoSources() throws JavaModelException {
//		IWorkspace workspace = ResourcesPlugin.getWorkspace();
//		IJavaProject javaProject = JavaCore.create(workspace.getRoot().getProject("org.whole.test"));
//		IJavaElement[] javaElements = new IJavaElement[CLASSES.length];
//		for (int i=0; i<javaElements.length; i++)
//			javaElements[i] = javaProject.findType(CLASSES[i].getCanonicalName());
//		
//		Object simplePojo = createPojo();
//		Misc compilationUnits =getCompilationUnits(javaElements);
//		Library library = PojoMappingUtils.getLibrary(compilationUnits, "SimplePojo");
//		IEntity mappedModel = PojoMappingUtils.getModel(library);
//		InterpreterOperation.interpret(mappedModel);
//		Library normalizedLibrary = NormalizerOperation.normalize(CloneModelOperation.clone(library));
//
//		IEntity simplePojoModel = PojoUtils.create(simplePojo, normalizedLibrary);
//		Object simplePojoObject = PojoUtils.create(simplePojoModel, normalizedLibrary);
//		assertEquals(simplePojoObject, simplePojo);
//	}
}
