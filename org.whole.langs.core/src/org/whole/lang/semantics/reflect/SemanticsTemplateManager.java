package org.whole.lang.semantics.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.semantics.model.SemanticTheory;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class SemanticsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final SemanticsTemplateManager instance = new SemanticsTemplateManager();
	}

	public static SemanticsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private SemanticsTemplateManager() {
		put("empty", new AbstractTemplateFactory<SemanticTheory>() {
			public SemanticTheory create() {
				return GenericEntityFactory.instance
						.create(SemanticsEntityDescriptorEnum.SemanticTheory);
			}
		});
	}
}
