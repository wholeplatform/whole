package org.whole.lang.java.reflect;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.java.codebase.Factorial;
import org.whole.lang.java.model.JavaSystemSoftware;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
 */
public class JavaTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final JavaTemplateManager instance = new JavaTemplateManager();
	}

	public static JavaTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private JavaTemplateManager() {
		put("empty", new AbstractTemplateFactory<JavaSystemSoftware>() {
			public JavaSystemSoftware create() {
				return GenericEntityFactory.instance
						.create(JavaEntityDescriptorEnum.JavaSystemSoftware);
			}
		});
		put("Factorial", new Factorial());
	}
}