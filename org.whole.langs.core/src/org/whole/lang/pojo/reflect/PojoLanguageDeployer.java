package org.whole.lang.pojo.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.pojo.builders.IPojoBuilder;
import org.whole.lang.pojo.builders.PojoGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.pojo.builders.PojoSpecificBuilderAdapter;
import org.whole.lang.pojo.visitors.PojoNormalizerVisitor;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class PojoLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new PojoLanguageKit());
		platform.addOperationFactory(PojoLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new PojoGenericBuilderAdapter(
								(IPojoBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(PojoLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new PojoSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(PojoLanguageKit.URI, NormalizerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new PojoNormalizerVisitor();
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(PojoLanguageKit.URI);
	}
}
