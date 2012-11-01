package org.whole.lang.javascript.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.javascript.model.Program;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class JavaScriptTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final JavaScriptTemplateManager instance = new JavaScriptTemplateManager();
	}

	public static JavaScriptTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private JavaScriptTemplateManager() {
		put("empty", new AbstractTemplateFactory<Program>() {
			public Program create() {
				return GenericEntityFactory.instance
						.create(JavaScriptEntityDescriptorEnum.Program);
			}
		});
	}
}
