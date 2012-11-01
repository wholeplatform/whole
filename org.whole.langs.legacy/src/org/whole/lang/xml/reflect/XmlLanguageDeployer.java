package org.whole.lang.xml.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.whole.lang.xml.builders.XmlGenericBuilderAdapter;
import org.whole.lang.xml.builders.XmlSpecificBuilderAdapter;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;
import org.whole.lang.xml.visitors.XmlNormalizerVisitor;
import org.whole.lang.xml.visitors.XmlPrettyPrinterVisitor;

/**
 * @generator Whole
 */
public class XmlLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new XmlLanguageKit());
		platform.addOperationFactory(XmlLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new XmlGenericBuilderAdapter(
								(IXmlBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(XmlLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new XmlSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(XmlLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new XmlPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
		platform.addOperationFactory(XmlLanguageKit.URI, NormalizerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new XmlNormalizerVisitor();
			}
		});

		platform.addPersistenceKit("org.whole.lang.xml.XmlBuilderEditor", XmlBuilderPersistenceKit.instance());
		platform.addPersistenceKit("org.whole.lang.xml.XmlSourceEditor", XmlSourcePersistenceKit.instance());
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(XmlLanguageKit.URI);
	}
}