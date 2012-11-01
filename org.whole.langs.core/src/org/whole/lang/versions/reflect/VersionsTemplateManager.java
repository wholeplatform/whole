package org.whole.lang.versions.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.versions.model.History;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class VersionsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final VersionsTemplateManager instance = new VersionsTemplateManager();
	}

	public static VersionsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private VersionsTemplateManager() {
		put("empty", new AbstractTemplateFactory<History>() {
			public History create() {
				return GenericEntityFactory.instance
						.create(VersionsEntityDescriptorEnum.History);
			}
		});
	}
}
