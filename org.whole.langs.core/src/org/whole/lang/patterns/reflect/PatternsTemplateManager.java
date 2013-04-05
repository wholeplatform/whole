package org.whole.lang.patterns.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.patterns.model.PatternLanguage;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class PatternsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final PatternsTemplateManager instance = new PatternsTemplateManager();
	}

	public static PatternsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private PatternsTemplateManager() {
		put("empty", new AbstractTemplateFactory<PatternLanguage>() {
			public PatternLanguage create() {
				return GenericEntityFactory.instance
						.create(PatternsEntityDescriptorEnum.PatternLanguage);
			}
		});
	}
}
