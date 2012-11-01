package org.whole.lang.tests.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class TestsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final TestsTemplateManager instance = new TestsTemplateManager();
	}

	public static TestsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private TestsTemplateManager() {
		put("empty", new AbstractTemplateFactory<TestSuite>() {
			public TestSuite create() {
				return GenericEntityFactory.instance
						.create(TestsEntityDescriptorEnum.TestSuite);
			}
		});
	}
}
