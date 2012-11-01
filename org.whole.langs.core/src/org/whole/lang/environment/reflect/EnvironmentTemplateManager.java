package org.whole.lang.environment.reflect;

import org.whole.lang.environment.model.BooleanData;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;

/** 
 * @generator Whole
 */
public class EnvironmentTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final EnvironmentTemplateManager instance = new EnvironmentTemplateManager();
	}

	public static EnvironmentTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private EnvironmentTemplateManager() {
		put("empty", new AbstractTemplateFactory<BooleanData>() {
			public BooleanData create() {
				return GenericEntityFactory.instance
						.create(EnvironmentEntityDescriptorEnum.BooleanData);
			}
		});
	}
}
