package org.whole.lang.flowchart.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.flowchart.model.Flowchart;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.flowchart.codebase.Sample;

/** 
 * @generator Whole
 */
public class FlowchartTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final FlowchartTemplateManager instance = new FlowchartTemplateManager();
	}

	public static FlowchartTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private FlowchartTemplateManager() {
		put("empty", new AbstractTemplateFactory<Flowchart>() {
			public Flowchart create() {
				return GenericEntityFactory.instance
						.create(FlowchartEntityDescriptorEnum.Flowchart);
			}
		});
		put("sample flowchart", new Sample());
	}
}
