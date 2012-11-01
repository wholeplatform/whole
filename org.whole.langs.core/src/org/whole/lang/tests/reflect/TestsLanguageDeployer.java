package org.whole.lang.tests.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.builders.ITestsBuilder;
import org.whole.lang.tests.builders.TestsGenericBuilderAdapter;
import org.whole.lang.tests.builders.TestsSpecificBuilderAdapter;
import org.whole.lang.tests.visitors.TestsContentAssistVisitor;
import org.whole.lang.tests.visitors.TestsLearningInterpreterVisitor;
import org.whole.lang.tests.visitors.TestsPrettyPrinterVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class TestsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new TestsLanguageKit());
		platform.addOperationFactory(TestsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TestsGenericBuilderAdapter(
								(ITestsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(TestsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new TestsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});
		platform.addOperationFactory(TestsLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new TestsPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
		platform.addOperationFactory(TestsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new TestsLearningInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(TestsLanguageKit.URI, ContentAssistOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new TestsContentAssistVisitor();
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(TestsLanguageKit.URI);
	}
}
