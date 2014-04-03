package org.whole.lang.modules.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.modules.builders.IModulesBuilder;
import org.whole.lang.modules.builders.ModulesGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.modules.builders.ModulesSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/**
 *  @generator  Whole
 */
public class ModulesLanguageDeployer extends AbstractLanguageDeployer {

    public void deploy(ReflectionFactory platform) {
        platform.addLanguageKit(new ModulesLanguageKit());
        platform.addOperationFactory(ModulesLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ModulesGenericBuilderAdapter((IModulesBuilder) strategy, entityContext);
            }
        });
        platform.addOperationFactory(ModulesLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ModulesSpecificBuilderAdapter(strategy, entityContext);
            }
        });
    }

    public void undeploy(ReflectionFactory platform) {
        platform.removeLanguageKit(ModulesLanguageKit.URI);
    }
}
