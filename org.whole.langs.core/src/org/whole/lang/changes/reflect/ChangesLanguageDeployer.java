package org.whole.lang.changes.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.changes.builders.IChangesBuilder;
import org.whole.lang.changes.builders.ChangesGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.changes.builders.ChangesSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/**
 *  @generator  Whole
 */
public class ChangesLanguageDeployer extends AbstractLanguageDeployer {

    public void deploy(ReflectionFactory platform) {
        platform.addLanguageKit(new ChangesLanguageKit());
        platform.addOperationFactory(ChangesLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ChangesGenericBuilderAdapter((IChangesBuilder) strategy, entityContext);
            }
        });
        platform.addOperationFactory(ChangesLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ChangesSpecificBuilderAdapter(strategy, entityContext);
            }
        });
    }

    public void undeploy(ReflectionFactory platform) {
        platform.removeLanguageKit(ChangesLanguageKit.URI);
    }
}
