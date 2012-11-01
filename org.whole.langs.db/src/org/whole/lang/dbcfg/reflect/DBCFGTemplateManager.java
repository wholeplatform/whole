package org.whole.lang.dbcfg.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.dbcfg.model.DBConfiguration;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class DBCFGTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final DBCFGTemplateManager instance = new DBCFGTemplateManager();
	}

	public static DBCFGTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private DBCFGTemplateManager() {
		put("empty", new AbstractTemplateFactory<DBConfiguration>() {
			public DBConfiguration create() {
				return GenericEntityFactory.instance
						.create(DBCFGEntityDescriptorEnum.DBConfiguration);
			}
		});
	}
}
