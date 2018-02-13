package org.whole.lang.properties.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.properties.builders.IPropertiesBuilder;
import org.whole.lang.properties.builders.PropertiesGenericBuilderAdapter;
import org.whole.lang.properties.builders.PropertiesSpecificBuilderAdapter;
import org.whole.lang.properties.codebase.PropertiesTextPersistenceKit;
import org.whole.lang.properties.codebase.PropertiesXmlPersistenceKit;
import org.whole.lang.properties.visitors.PropertiesInterpreterVisitor;
import org.whole.lang.properties.visitors.PropertiesPrettyPrinterVisitor;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class PropertiesLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new PropertiesLanguageKit());
		platform.addOperationFactory(PropertiesLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new PropertiesGenericBuilderAdapter(
								(IPropertiesBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(PropertiesLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new PropertiesSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});

		platform.addOperationFactory(PropertiesLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new PropertiesPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
		platform.addOperationFactory(PropertiesLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new PropertiesInterpreterVisitor();
				else
					return null;
			}
		});

		platform.addPersistenceKit("org.whole.lang.properties.PropertiesTextEditor", PropertiesTextPersistenceKit.instance());
		platform.addPersistenceKit("org.whole.lang.properties.PropertiesXmlEditor", PropertiesXmlPersistenceKit.instance());
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(PropertiesLanguageKit.URI);
	}
}