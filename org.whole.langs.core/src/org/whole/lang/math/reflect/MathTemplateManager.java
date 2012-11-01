package org.whole.lang.math.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.math.model.Addition;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class MathTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final MathTemplateManager instance = new MathTemplateManager();
	}

	public static MathTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private MathTemplateManager() {
		put("empty", new AbstractTemplateFactory<Addition>() {
			public Addition create() {
				return GenericEntityFactory.instance
						.create(MathEntityDescriptorEnum.Addition);
			}
		});
	}
}
