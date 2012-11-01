package org.whole.lang.testentities.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.testentities.model.SimpleTestEntity;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class TestEntitiesTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final TestEntitiesTemplateManager instance = new TestEntitiesTemplateManager();
	}

	public static TestEntitiesTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private TestEntitiesTemplateManager() {
		put("empty", new AbstractTemplateFactory<SimpleTestEntity>() {
			public SimpleTestEntity create() {
				return GenericEntityFactory.instance
						.create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
			}
		});
	}
}
