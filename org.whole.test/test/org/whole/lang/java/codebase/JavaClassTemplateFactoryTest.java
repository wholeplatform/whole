package org.whole.lang.java.codebase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.pojo.util.ElementType;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ReflectionFactory;

public class JavaClassTemplateFactoryTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
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
