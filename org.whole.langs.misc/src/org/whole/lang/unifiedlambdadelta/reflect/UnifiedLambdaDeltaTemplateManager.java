package org.whole.lang.unifiedlambdadelta.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.unifiedlambdadelta.codebase.Identity;
import org.whole.lang.unifiedlambdadelta.model.Declaration;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final UnifiedLambdaDeltaTemplateManager instance = new UnifiedLambdaDeltaTemplateManager();
	}

	public static UnifiedLambdaDeltaTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private UnifiedLambdaDeltaTemplateManager() {
		put("empty", new AbstractTemplateFactory<Declaration>() {
			public Declaration create() {
				return GenericEntityFactory.instance
						.create(UnifiedLambdaDeltaEntityDescriptorEnum.Declaration);
			}
		});
		put("identity", new Identity());
	}
}
