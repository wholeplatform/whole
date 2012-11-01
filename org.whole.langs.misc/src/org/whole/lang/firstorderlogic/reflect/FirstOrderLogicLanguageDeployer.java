package org.whole.lang.firstorderlogic.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.firstorderlogic.builders.FirstOrderLogicGenericBuilderAdapter;
import org.whole.lang.firstorderlogic.builders.FirstOrderLogicSpecificBuilderAdapter;
import org.whole.lang.firstorderlogic.builders.IFirstOrderLogicBuilder;
import org.whole.lang.firstorderlogic.ui.FirstOrderLogicTextualEditorKit;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;

/** 
 * @generator Whole
 */
public class FirstOrderLogicLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new FirstOrderLogicLanguageKit());
		platform.addOperationFactory(FirstOrderLogicLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new FirstOrderLogicGenericBuilderAdapter(
								(IFirstOrderLogicBuilder) strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(FirstOrderLogicLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new FirstOrderLogicSpecificBuilderAdapter(
								strategy, entityContext);
					}
				});
		platform.addEditorKit(FirstOrderLogicTextualEditorKit.ID);
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(FirstOrderLogicLanguageKit.URI);
	}
}