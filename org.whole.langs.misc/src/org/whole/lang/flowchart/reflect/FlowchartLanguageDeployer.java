package org.whole.lang.flowchart.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.flowchart.builders.IFlowchartBuilder;
import org.whole.lang.flowchart.builders.FlowchartGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.flowchart.builders.FlowchartSpecificBuilderAdapter;
import org.whole.lang.flowchart.ui.FlowchartFreeformEditorKit;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class FlowchartLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new FlowchartLanguageKit());
		platform.addOperationFactory(FlowchartLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new FlowchartGenericBuilderAdapter(
								(IFlowchartBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(FlowchartLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new FlowchartSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addEditorKit(FlowchartFreeformEditorKit.ID);
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(FlowchartLanguageKit.URI);
	}
}