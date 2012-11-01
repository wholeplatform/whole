package org.whole.lang.queries.reflect;

import org.whole.lang.queries.codebase.FileArtifactGenerator;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.queries.model.QueryDeclaration;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class QueriesTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final QueriesTemplateManager instance = new QueriesTemplateManager();
	}
	public static QueriesTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private QueriesTemplateManager() {
		put("empty", new AbstractTemplateFactory<QueryDeclaration>() {
			public QueryDeclaration create() {
				return GenericEntityFactory.instance
						.create(QueriesEntityDescriptorEnum.QueryDeclaration);
			}
		});
		put("FileArtifact generator", new FileArtifactGenerator());
	}
}
