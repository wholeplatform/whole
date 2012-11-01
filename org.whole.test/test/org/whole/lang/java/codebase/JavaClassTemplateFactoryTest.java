package org.whole.lang.java.codebase;

import junit.framework.TestCase;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.pojo.util.ElementType;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ReflectionFactory;

public class JavaClassTemplateFactoryTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();
	}

	public void testClass() {
		Class<?> clazz = JavaEntityFactory.class;
		JavaClassTemplateFactory javaReflectionTemplateFactory = new JavaClassTemplateFactory(clazz);
		PrettyPrinterOperation.prettyPrint(javaReflectionTemplateFactory.create());

		clazz = GenericEntityFactory.class;
		javaReflectionTemplateFactory = new JavaClassTemplateFactory(clazz);
		PrettyPrinterOperation.prettyPrint(javaReflectionTemplateFactory.create());

		clazz = ElementType.class;
		javaReflectionTemplateFactory = new JavaClassTemplateFactory(clazz);
		PrettyPrinterOperation.prettyPrint(javaReflectionTemplateFactory.create());

		clazz = EntityKinds.class;
		javaReflectionTemplateFactory = new JavaClassTemplateFactory(clazz);
		PrettyPrinterOperation.prettyPrint(javaReflectionTemplateFactory.create());

		clazz = ReflectionFactory.class;
		javaReflectionTemplateFactory = new JavaClassTemplateFactory(clazz);
		PrettyPrinterOperation.prettyPrint(javaReflectionTemplateFactory.create());
	}
}
