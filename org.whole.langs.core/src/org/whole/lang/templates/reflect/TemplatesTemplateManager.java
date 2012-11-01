package org.whole.lang.templates.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.model.TemplateManager;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class TemplatesTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final TemplatesTemplateManager instance = new TemplatesTemplateManager();
	}

	public static TemplatesTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private TemplatesTemplateManager() {
		put("empty", new AbstractTemplateFactory<TemplateManager>() {
			public TemplateManager create() {
				return GenericEntityFactory.instance
						.create(TemplatesEntityDescriptorEnum.TemplateManager);
			}
		});
		
//		put("TemplateManagerArtifacts templates", new TemplateManagerArtifactsTemplates());
	}
}