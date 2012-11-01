package org.whole.lang.xsd.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.xsd.model.Schema;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class XsdTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final XsdTemplateManager instance = new XsdTemplateManager();
	}

	public static XsdTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private XsdTemplateManager() {
		put("empty", new AbstractTemplateFactory<Schema>() {
			public Schema create() {
				return GenericEntityFactory.instance
						.create(XsdEntityDescriptorEnum.Schema);
			}
		});
	}
}
