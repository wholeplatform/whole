package org.whole.lang.sql.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.sql.model.SQLStatements;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class SQLTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final SQLTemplateManager instance = new SQLTemplateManager();
	}

	public static SQLTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private SQLTemplateManager() {
		put("empty", new AbstractTemplateFactory<SQLStatements>() {
			public SQLStatements create() {
				return GenericEntityFactory.instance
						.create(SQLEntityDescriptorEnum.SQLStatements);
			}
		});
	}
}
