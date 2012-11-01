package org.whole.lang.scheme.reflect;

import org.whole.lang.scheme.codebase.Reverse;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.scheme.model.Definitions;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class SchemeTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final SchemeTemplateManager instance = new SchemeTemplateManager();
	}

	public static SchemeTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private SchemeTemplateManager() {
		put("empty", new AbstractTemplateFactory<Definitions>() {
			public Definitions create() {
				return GenericEntityFactory.instance
						.create(SchemeEntityDescriptorEnum.Definitions);
			}
		});
		
		put("reverse", new Reverse());
	}
}