package org.whole.examples.lang.imp;


import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createVariable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.examples.lang.imp.factories.ImpEntityFactory;
import org.whole.examples.lang.imp.model.PrimitiveTypeEnum;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpLanguageDeployer;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class RewriteTest {
	@BeforeClass
	public static void init() {
		ReflectionFactory.deployWholePlatform();
		ReflectionFactory.deploy(ImpLanguageDeployer.class);
	}

	@Test
	public void testRewrite() {
		IEntity program = buildImpProgram();
		PrettyPrinterOperation.prettyPrint(program);

		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		GenericTraversalFactory tf = GenericTraversalFactory.instance;

		IVisitor v = tf.innermost(tf.concurrentSome(
				mf.rewrite(IfElseEmptyPattern(), IfElseEmptyRewrite(), false),
				mf.rewrite(IfTruePattern(), IfTrueRewrite(), false),
				mf.rewrite(IfTrueElsePattern(), IfTrueRewrite(), false),
				mf.rewrite(IfNotPattern(), IfNotRewrite(), false)
		));
		v.visit(program);

		PrettyPrinterOperation.prettyPrint(program);
	}

	public IEntity buildImpProgram() {
		ImpEntityFactory lf = ImpEntityFactory.instance;
		return lf.createFunctionDeclaration(
				lf.createPrimitiveType(PrimitiveTypeEnum._boolean),
				lf.createName("fun"),
				lf.createParameters(0),
				lf.createBlockStatement(
					lf.createIfElseStatement(
							lf.createNot(lf.createBooleanLiteral(true)),
							lf.createEmptyStatement(),
							lf.createExpressionStatement(
									lf.createAssignmentExpression(
											lf.createName("x"),
											lf.createAddition(
													lf.createNameExpression("x"),
													lf.createIntLiteral(1))))),
					lf.createIfElseStatement(
							lf.createNot(lf.createBooleanLiteral(true)),
							lf.createIfElseStatement(
									lf.createNot(lf.createBooleanLiteral(true)),
									lf.createExpressionStatement(
											lf.createAssignmentExpression(
													lf.createName("y"),
													lf.createAddition(
															lf.createNameExpression("y"),
															lf.createIntLiteral(1)))),
									lf.createEmptyStatement()),
							lf.createExpressionStatement(
									lf.createAssignmentExpression(
											lf.createName("z"),
											lf.createAddition(
													lf.createNameExpression("z"),
													lf.createIntLiteral(2)))))
				));
	}
	public IEntity IfNotPattern() {
		ImpEntityFactory lf = ImpEntityFactory.instance;
		return lf.createIfElseStatement(
				lf.createNot(createVariable(ImpEntityDescriptorEnum.Expression, "cond")),
				createVariable(ImpEntityDescriptorEnum.Statement, "thenStm"),
				createVariable(ImpEntityDescriptorEnum.Statement, "elseStm"));
	}
	public IEntity IfNotRewrite() {
		ImpEntityFactory lf = ImpEntityFactory.instance;
		return lf.createIfElseStatement(
				createVariable(ImpEntityDescriptorEnum.Expression, "cond"),
				createVariable(ImpEntityDescriptorEnum.Statement, "elseStm"),
				createVariable(ImpEntityDescriptorEnum.Statement, "thenStm"));
	}
	public IEntity IfElseEmptyPattern() {
		ImpEntityFactory lf = ImpEntityFactory.instance;
		return lf.createIfElseStatement(
				createVariable(ImpEntityDescriptorEnum.Expression, "cond"),
				createVariable(ImpEntityDescriptorEnum.Statement, "thenStm"),
				lf.createEmptyStatement());
	}
	public IEntity IfElseEmptyRewrite() {
		ImpEntityFactory lf = ImpEntityFactory.instance;
		return lf.createIfStatement(
				createVariable(ImpEntityDescriptorEnum.Expression, "cond"),
				createVariable(ImpEntityDescriptorEnum.Statement, "thenStm"));
	}

	public IEntity IfTruePattern() {
		ImpEntityFactory lf = ImpEntityFactory.instance;
		return lf.createIfStatement(
				lf.createBooleanLiteral(true),
				createVariable(ImpEntityDescriptorEnum.Statement, "thenStm"));
	}
	public IEntity IfTrueElsePattern() {
		ImpEntityFactory lf = ImpEntityFactory.instance;
		return lf.createIfElseStatement(
				lf.createBooleanLiteral(true),
				createVariable(ImpEntityDescriptorEnum.Statement, "thenStm"),
				createVariable(ImpEntityDescriptorEnum.Statement, "elseStm"));
	}
	public IEntity IfTrueRewrite() {
		return createVariable(ImpEntityDescriptorEnum.Statement, "thenStm");
	}
}
