package org.whole.lang.actions.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class ActionsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final ActionsTemplateManager instance = new ActionsTemplateManager();
	}

	public static ActionsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private ActionsTemplateManager() {
		put("empty", new AbstractTemplateFactory<LanguageActionFactory>() {
			public LanguageActionFactory create() {
				return GenericEntityFactory.instance
						.create(ActionsEntityDescriptorEnum.LanguageActionFactory);
			}
		});
	}
}
