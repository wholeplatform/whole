package org.whole.lang.workflows.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.workflows.model.Workflow;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class WorkflowsTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final WorkflowsTemplateManager instance = new WorkflowsTemplateManager();
	}

	public static WorkflowsTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private WorkflowsTemplateManager() {
		put("empty", new AbstractTemplateFactory<Workflow>() {
			public Workflow create() {
				return GenericEntityFactory.instance
						.create(WorkflowsEntityDescriptorEnum.Workflow);
			}
		});
	}
}
