package org.whole.lang.javascript.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.javascript.builders.IJavaScriptBuilder;
import org.whole.lang.javascript.builders.JavaScriptGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.javascript.builders.JavaScriptSpecificBuilderAdapter;
import org.whole.lang.javascript.codebase.JavaScriptSourcePersistenceKit;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class JavaScriptLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new JavaScriptLanguageKit());
		platform.addOperationFactory(JavaScriptLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new JavaScriptGenericBuilderAdapter(
								(IJavaScriptBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(JavaScriptLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new JavaScriptSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addPersistenceKit("org.whole.lang.java.JavaScriptSourceEditor", JavaScriptSourcePersistenceKit.instance());
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(JavaScriptLanguageKit.URI);
	}
}
