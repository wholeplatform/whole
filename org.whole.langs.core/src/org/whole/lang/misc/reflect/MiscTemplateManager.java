package org.whole.lang.misc.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.misc.codebase.ModelsInfo;
import org.whole.lang.misc.codebase.WholeLanguage;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.misc.model.Misc;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class MiscTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final MiscTemplateManager instance = new MiscTemplateManager();
	}

	public static MiscTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private MiscTemplateManager() {
		put("empty", new AbstractTemplateFactory<Misc>() {
			public Misc create() {
				return GenericEntityFactory.instance
						.create(MiscEntityDescriptorEnum.Misc);
			}
		});
		
		put("Whole Language", new WholeLanguage());
		
		put("Models Info", new ModelsInfo());
	}
}