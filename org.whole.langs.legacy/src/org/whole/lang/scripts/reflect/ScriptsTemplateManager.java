package org.whole.lang.scripts.reflect;

import org.whole.lang.scripts.codebase.EmbeddedJS;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.scripts.model.Script;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class ScriptsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final ScriptsTemplateManager instance = new ScriptsTemplateManager();
	}

	public static ScriptsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private ScriptsTemplateManager() {
		put("empty", new AbstractTemplateFactory<Script>() {
			public Script create() {
				return GenericEntityFactory.instance
						.create(ScriptsEntityDescriptorEnum.Script);
			}
		});

		put("Embedded JavaScript script", new EmbeddedJS());
	}
}
