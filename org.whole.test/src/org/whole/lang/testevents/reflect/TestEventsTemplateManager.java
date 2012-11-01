package org.whole.lang.testevents.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.testevents.model.TestEvents;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class TestEventsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final TestEventsTemplateManager instance = new TestEventsTemplateManager();
	}

	public static TestEventsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private TestEventsTemplateManager() {
		put("empty", new AbstractTemplateFactory<TestEvents>() {
			public TestEvents create() {
				return GenericEntityFactory.instance
						.create(TestEventsEntityDescriptorEnum.TestEvents);
			}
		});
	}
}
