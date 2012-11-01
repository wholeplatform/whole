package org.whole.lang.rdb.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.rdb.builders.IRDBBuilder;
import org.whole.lang.rdb.builders.RDBGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.rdb.builders.RDBSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class RDBLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new RDBLanguageKit());
		platform.addOperationFactory(RDBLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new RDBGenericBuilderAdapter(
								(IRDBBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(RDBLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new RDBSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(RDBLanguageKit.URI);
	}
}
