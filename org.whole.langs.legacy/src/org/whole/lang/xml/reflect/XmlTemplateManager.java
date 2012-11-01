package org.whole.lang.xml.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.xml.codebase.HibernateMapping;
import org.whole.lang.xml.model.Document;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class XmlTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final XmlTemplateManager instance = new XmlTemplateManager();
	}

	public static XmlTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private XmlTemplateManager() {
		put("empty", new AbstractTemplateFactory<Document>() {
			public Document create() {
				return GenericEntityFactory.instance
						.create(XmlEntityDescriptorEnum.Document);
			}
		});
		
		put("Whole Language Hibernate Mapping", new HibernateMapping());
	}
}