package org.whole.lang.dbcfg.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.dbcfg.builders.IDBCFGBuilder;
import org.whole.lang.dbcfg.builders.DBCFGGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.dbcfg.builders.DBCFGSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/** 
 * @generator Whole
 */
public class DBCFGLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new DBCFGLanguageKit());
		platform.addOperationFactory(DBCFGLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new DBCFGGenericBuilderAdapter(
								(IDBCFGBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(DBCFGLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new DBCFGSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(DBCFGLanguageKit.URI);
	}
}
