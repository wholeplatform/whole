package org.whole.lang.reusables.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reusables.builders.IReusablesBuilder;
import org.whole.lang.reusables.builders.ReusablesGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.reusables.builders.ReusablesSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/**
 *  @generator  Whole
 */
public class ReusablesLanguageDeployer extends AbstractLanguageDeployer {

    public void deploy(ReflectionFactory platform) {
        platform.addLanguageKit(new ReusablesLanguageKit());
        platform.addOperationFactory(ReusablesLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ReusablesGenericBuilderAdapter((IReusablesBuilder) strategy, entityContext);
            }
        });
        platform.addOperationFactory(ReusablesLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ReusablesSpecificBuilderAdapter(strategy, entityContext);
            }
        });
    }

    public void undeploy(ReflectionFactory platform) {
        platform.removeLanguageKit(ReusablesLanguageKit.URI);
    }
}
