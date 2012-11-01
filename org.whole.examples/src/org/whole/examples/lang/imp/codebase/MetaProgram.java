package org.whole.examples.lang.imp.codebase;

import org.whole.examples.lang.imp.builders.IImpBuilder;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.examples.lang.imp.reflect.ImpLanguageKit;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

/**
 * @generator Whole
 */
public class MetaProgram extends AbstractTemplateFactory<FunctionDeclaration> {
	public void apply(IBuilderOperation op) {
		IImpBuilder b0 = (IImpBuilder) op.wGetBuilder(ImpLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		b0.FunctionDeclaration_();
		b0.PrimitiveType("void");
		b0.Name("testTemplates");
		cb.Resolver();
		b0.BlockStatement_(6);
		b0.VariableDeclaration_();
		b0.PrimitiveType("entity");
		b0.Name("l");
		cb.StageUpFragment_();
		b0.StringLiteral("ciao");
		cb._StageUpFragment();
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.PrimitiveType("entity");
		b0.Name("e");
		cb.StageUpFragment_();
		b0.PrintlnStatement_();
		cb.StageDownFragment_();
		b0.NameExpression("l");
		cb._StageDownFragment();
		b0._PrintlnStatement();
		cb._StageUpFragment();
		b0._VariableDeclaration();
		b0.PrintlnStatement_();
		b0.NameExpression("e");
		b0._PrintlnStatement();
		b0.VariableDeclaration_();
		b0.PrimitiveType("entity");
		b0.Name("f");
		cb.StageUpFragment_();
		b0.FunctionDeclaration_();
		b0.PrimitiveType("void");
		b0.Name("t");
		cb.Resolver();
		b0.BlockStatement_(2);
		b0.PrintlnStatement_();
		b0.StringLiteral("test");
		b0._PrintlnStatement();
		cb.StageDownFragment_();
		b0.NameExpression("e");
		cb._StageDownFragment();
		b0._BlockStatement();
		b0._FunctionDeclaration();
		cb._StageUpFragment();
		b0._VariableDeclaration();
		b0.PrintlnStatement_();
		b0.NameExpression("f");
		b0._PrintlnStatement();
		b0.ExpressionStatement_();
		b0.FunctionInvocationExpression_();
		b0.NameExpression("f");
		cb.Resolver();
		b0._FunctionInvocationExpression();
		b0._ExpressionStatement();
		b0._BlockStatement();
		b0._FunctionDeclaration();
	}
}