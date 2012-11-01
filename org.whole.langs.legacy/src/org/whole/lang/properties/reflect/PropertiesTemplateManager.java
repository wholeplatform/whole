package org.whole.lang.properties.reflect;

import java.io.IOException;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.properties.factories.PropertiesEntityFactory;
import org.whole.lang.properties.util.PropertiesUtils;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class PropertiesTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final PropertiesTemplateManager instance = new PropertiesTemplateManager();
	}

	public static PropertiesTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private PropertiesTemplateManager() {
		put("empty", new AbstractTemplateFactory<Properties>() {
			public Properties create() {
				return GenericEntityFactory.instance
						.create(PropertiesEntityDescriptorEnum.Properties);
			}
		});
		put("System Properties", new AbstractTemplateFactory<Properties>() {
			public Properties create() {
				try {
					return PropertiesUtils.translate(System.getProperties());
				} catch (IOException e) {
					return PropertiesEntityFactory.instance.create(PropertiesEntityDescriptorEnum.Properties);
				}
			}
		});
		
	}
}