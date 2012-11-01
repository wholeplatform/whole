package org.whole.lang.xsd.mapping.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.xsd.mapping.model.MappingStrategy;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class MappingTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final MappingTemplateManager instance = new MappingTemplateManager();
	}

	public static MappingTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private MappingTemplateManager() {
		put("empty", new AbstractTemplateFactory<MappingStrategy>() {
			public MappingStrategy create() {
				return GenericEntityFactory.instance
						.create(MappingEntityDescriptorEnum.MappingStrategy);
			}
		});
	}
}
