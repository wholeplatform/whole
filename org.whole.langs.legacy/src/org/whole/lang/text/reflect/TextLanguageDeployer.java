package org.whole.lang.text.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.text.builders.ITextBuilder;
import org.whole.lang.text.builders.TextGenericBuilderAdapter;
import org.whole.lang.text.builders.TextSpecificBuilderAdapter;
import org.whole.lang.text.codebase.TextSourcePersistenceKit;
import org.whole.lang.text.visitors.TextInterpreterVisitor;
import org.whole.lang.text.visitors.TextPrettyPrinterVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class TextLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new TextLanguageKit());
		platform.addOperationFactory(TextLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TextGenericBuilderAdapter(
								(ITextBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(TextLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TextSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(TextLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new TextInterpreterVisitor((InterpreterOperation) operation);
				else
					return null;
			}
		});
		platform.addOperationFactory(TextLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new TextPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});

		platform.addPersistenceKit("org.whole.lang.text.TextSourceEditor", TextSourcePersistenceKit.instance());
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(TextLanguageKit.URI);
	}
}