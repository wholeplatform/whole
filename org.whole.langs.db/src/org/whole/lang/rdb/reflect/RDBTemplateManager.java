package org.whole.lang.rdb.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.rdb.model.Database;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class RDBTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final RDBTemplateManager instance = new RDBTemplateManager();
	}

	public static RDBTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private RDBTemplateManager() {
		put("empty", new AbstractTemplateFactory<Database>() {
			public Database create() {
				return GenericEntityFactory.instance
						.create(RDBEntityDescriptorEnum.Database);
			}
		});
	}
}
