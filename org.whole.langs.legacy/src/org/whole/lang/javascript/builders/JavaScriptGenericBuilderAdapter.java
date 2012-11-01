package org.whole.lang.javascript.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.javascript.model.CommentKindEnum.Value;

/** 
 * @generator Whole
 */
public class JavaScriptGenericBuilderAdapter extends GenericIdentityBuilder {
	private IJavaScriptBuilder specificBuilder;

	public JavaScriptGenericBuilderAdapter(IJavaScriptBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public JavaScriptGenericBuilderAdapter(IJavaScriptBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case JavaScriptFeatureDescriptorEnum.statements_ord:
			specificBuilder.statements();
			break;
		case JavaScriptFeatureDescriptorEnum.kind_ord:
			specificBuilder.kind();
			break;
		case JavaScriptFeatureDescriptorEnum.contents_ord:
			specificBuilder.contents();
			break;
		case JavaScriptFeatureDescriptorEnum.id_ord:
			specificBuilder.id();
			break;
		case JavaScriptFeatureDescriptorEnum.params_ord:
			specificBuilder.params();
			break;
		case JavaScriptFeatureDescriptorEnum.body_ord:
			specificBuilder.body();
			break;
		case JavaScriptFeatureDescriptorEnum.destructuring_ord:
			specificBuilder.destructuring();
			break;
		case JavaScriptFeatureDescriptorEnum.properties_ord:
			specificBuilder.properties();
			break;
		case JavaScriptFeatureDescriptorEnum.key_ord:
			specificBuilder.key();
			break;
		case JavaScriptFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		case JavaScriptFeatureDescriptorEnum.elements_ord:
			specificBuilder.elements();
			break;
		case JavaScriptFeatureDescriptorEnum.expression_ord:
			specificBuilder.expression();
			break;
		case JavaScriptFeatureDescriptorEnum.test_ord:
			specificBuilder.test();
			break;
		case JavaScriptFeatureDescriptorEnum.consequent_ord:
			specificBuilder.consequent();
			break;
		case JavaScriptFeatureDescriptorEnum.alternate_ord:
			specificBuilder.alternate();
			break;
		case JavaScriptFeatureDescriptorEnum.labels_ord:
			specificBuilder.labels();
			break;
		case JavaScriptFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case JavaScriptFeatureDescriptorEnum.target_ord:
			specificBuilder.target();
			break;
		case JavaScriptFeatureDescriptorEnum.object_ord:
			specificBuilder.object();
			break;
		case JavaScriptFeatureDescriptorEnum.cases_ord:
			specificBuilder.cases();
			break;
		case JavaScriptFeatureDescriptorEnum.argument_ord:
			specificBuilder.argument();
			break;
		case JavaScriptFeatureDescriptorEnum._try_ord:
			specificBuilder._try();
			break;
		case JavaScriptFeatureDescriptorEnum.handlers_ord:
			specificBuilder.handlers();
			break;
		case JavaScriptFeatureDescriptorEnum._finally_ord:
			specificBuilder._finally();
			break;
		case JavaScriptFeatureDescriptorEnum.param_ord:
			specificBuilder.param();
			break;
		case JavaScriptFeatureDescriptorEnum.guard_ord:
			specificBuilder.guard();
			break;
		case JavaScriptFeatureDescriptorEnum.init_ord:
			specificBuilder.init();
			break;
		case JavaScriptFeatureDescriptorEnum.update_ord:
			specificBuilder.update();
			break;
		case JavaScriptFeatureDescriptorEnum.iterator_ord:
			specificBuilder.iterator();
			break;
		case JavaScriptFeatureDescriptorEnum.iterated_ord:
			specificBuilder.iterated();
			break;
		case JavaScriptFeatureDescriptorEnum.variables_ord:
			specificBuilder.variables();
			break;
		case JavaScriptFeatureDescriptorEnum.attribute_ord:
			specificBuilder.attribute();
			break;
		case JavaScriptFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case JavaScriptFeatureDescriptorEnum.property_ord:
			specificBuilder.property();
			break;
		case JavaScriptFeatureDescriptorEnum.left_ord:
			specificBuilder.left();
			break;
		case JavaScriptFeatureDescriptorEnum.operator_ord:
			specificBuilder.operator();
			break;
		case JavaScriptFeatureDescriptorEnum.right_ord:
			specificBuilder.right();
			break;
		case JavaScriptFeatureDescriptorEnum.fragments_ord:
			specificBuilder.fragments();
			break;
		case JavaScriptFeatureDescriptorEnum.xml_ord:
			specificBuilder.xml();
			break;
		case JavaScriptFeatureDescriptorEnum.operand_ord:
			specificBuilder.operand();
			break;
		case JavaScriptFeatureDescriptorEnum.constructor_ord:
			specificBuilder.constructor();
			break;
		case JavaScriptFeatureDescriptorEnum.arguments_ord:
			specificBuilder.arguments();
			break;
		case JavaScriptFeatureDescriptorEnum.callee_ord:
			specificBuilder.callee();
			break;
		case JavaScriptFeatureDescriptorEnum.blocks_ord:
			specificBuilder.blocks();
			break;
		case JavaScriptFeatureDescriptorEnum.filter_ord:
			specificBuilder.filter();
			break;
		case JavaScriptFeatureDescriptorEnum.quote_ord:
			specificBuilder.quote();
			break;
		case JavaScriptFeatureDescriptorEnum.flags_ord:
			specificBuilder.flags();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.Program_ord:
			specificBuilder.Program();
			break;
		case JavaScriptEntityDescriptorEnum.Statements_ord:
			specificBuilder.Statements();
			break;
		case JavaScriptEntityDescriptorEnum.Comment_ord:
			specificBuilder.Comment();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectLiteral_ord:
			specificBuilder.ObjectLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperties_ord:
			specificBuilder.ObjectProperties();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperty_ord:
			specificBuilder.ObjectProperty();
			break;
		case JavaScriptEntityDescriptorEnum.ArrayLiteral_ord:
			specificBuilder.ArrayLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.EmptyExpression_ord:
			specificBuilder.EmptyExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ExpressionStatement_ord:
			specificBuilder.ExpressionStatement();
			break;
		case JavaScriptEntityDescriptorEnum.IfStatement_ord:
			specificBuilder.IfStatement();
			break;
		case JavaScriptEntityDescriptorEnum.LabeledStatement_ord:
			specificBuilder.LabeledStatement();
			break;
		case JavaScriptEntityDescriptorEnum.Labels_ord:
			specificBuilder.Labels();
			break;
		case JavaScriptEntityDescriptorEnum.Label_ord:
			specificBuilder.Label();
			break;
		case JavaScriptEntityDescriptorEnum.BreakStatement_ord:
			specificBuilder.BreakStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ContinueStatement_ord:
			specificBuilder.ContinueStatement();
			break;
		case JavaScriptEntityDescriptorEnum.WithStatement_ord:
			specificBuilder.WithStatement();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchStatement_ord:
			specificBuilder.SwitchStatement();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCases_ord:
			specificBuilder.SwitchCases();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCase_ord:
			specificBuilder.SwitchCase();
			break;
		case JavaScriptEntityDescriptorEnum.ReturnStatement_ord:
			specificBuilder.ReturnStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ThrowStatement_ord:
			specificBuilder.ThrowStatement();
			break;
		case JavaScriptEntityDescriptorEnum.TryStatement_ord:
			specificBuilder.TryStatement();
			break;
		case JavaScriptEntityDescriptorEnum.CatchClauses_ord:
			specificBuilder.CatchClauses();
			break;
		case JavaScriptEntityDescriptorEnum.CatchClause_ord:
			specificBuilder.CatchClause();
			break;
		case JavaScriptEntityDescriptorEnum.WhileStatement_ord:
			specificBuilder.WhileStatement();
			break;
		case JavaScriptEntityDescriptorEnum.DoWhileStatement_ord:
			specificBuilder.DoWhileStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ForStatement_ord:
			specificBuilder.ForStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ForInStatement_ord:
			specificBuilder.ForInStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ForEachStatement_ord:
			specificBuilder.ForEachStatement();
			break;
		case JavaScriptEntityDescriptorEnum.LetStatement_ord:
			specificBuilder.LetStatement();
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializers_ord:
			specificBuilder.VariableInitializers();
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializer_ord:
			specificBuilder.VariableInitializer();
			break;
		case JavaScriptEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder.FunctionDeclaration();
			break;
		case JavaScriptEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration();
			break;
		case JavaScriptEntityDescriptorEnum.XmlAny_ord:
			specificBuilder.XmlAny();
			break;
		case JavaScriptEntityDescriptorEnum.ComputedXmlRef_ord:
			specificBuilder.ComputedXmlRef();
			break;
		case JavaScriptEntityDescriptorEnum.StaticXmlRef_ord:
			specificBuilder.StaticXmlRef();
			break;
		case JavaScriptEntityDescriptorEnum.XmlMemberGet_ord:
			specificBuilder.XmlMemberGet();
			break;
		case JavaScriptEntityDescriptorEnum.XmlDotQuery_ord:
			specificBuilder.XmlDotQuery();
			break;
		case JavaScriptEntityDescriptorEnum.XmlLiteral_ord:
			specificBuilder.XmlLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.XmlFragments_ord:
			specificBuilder.XmlFragments();
			break;
		case JavaScriptEntityDescriptorEnum.XmlString_ord:
			specificBuilder.XmlString();
			break;
		case JavaScriptEntityDescriptorEnum.XmlExpression_ord:
			specificBuilder.XmlExpression();
			break;
		case JavaScriptEntityDescriptorEnum.XmlDefaultNamespace_ord:
			specificBuilder.XmlDefaultNamespace();
			break;
		case JavaScriptEntityDescriptorEnum.FunctionExpression_ord:
			specificBuilder.FunctionExpression();
			break;
		case JavaScriptEntityDescriptorEnum.Expressions_ord:
			specificBuilder.Expressions();
			break;
		case JavaScriptEntityDescriptorEnum.ParenthesizedExpression_ord:
			specificBuilder.ParenthesizedExpression();
			break;
		case JavaScriptEntityDescriptorEnum.PrefixExpression_ord:
			specificBuilder.PrefixExpression();
			break;
		case JavaScriptEntityDescriptorEnum.PostfixExpression_ord:
			specificBuilder.PostfixExpression();
			break;
		case JavaScriptEntityDescriptorEnum.InfixExpression_ord:
			specificBuilder.InfixExpression();
			break;
		case JavaScriptEntityDescriptorEnum.AssignmentExpression_ord:
			specificBuilder.AssignmentExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ConditionalExpression_ord:
			specificBuilder.ConditionalExpression();
			break;
		case JavaScriptEntityDescriptorEnum.NewExpression_ord:
			specificBuilder.NewExpression();
			break;
		case JavaScriptEntityDescriptorEnum.CallExpression_ord:
			specificBuilder.CallExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ComputedMemberExpression_ord:
			specificBuilder.ComputedMemberExpression();
			break;
		case JavaScriptEntityDescriptorEnum.StaticMemberExpression_ord:
			specificBuilder.StaticMemberExpression();
			break;
		case JavaScriptEntityDescriptorEnum.YieldExpression_ord:
			specificBuilder.YieldExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression_ord:
			specificBuilder.ArrayComprehensionExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ComprehensionBlocks_ord:
			specificBuilder.ComprehensionBlocks();
			break;
		case JavaScriptEntityDescriptorEnum.ForInComprehensionBlock_ord:
			specificBuilder.ForInComprehensionBlock();
			break;
		case JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock_ord:
			specificBuilder.ForEachComprehensionBlock();
			break;
		case JavaScriptEntityDescriptorEnum.LetExpression_ord:
			specificBuilder.LetExpression();
			break;
		case JavaScriptEntityDescriptorEnum.NullLiteral_ord:
			specificBuilder.NullLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.ThisLiteral_ord:
			specificBuilder.ThisLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.StringLiteral_ord:
			specificBuilder.StringLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.RegExpLiteral_ord:
			specificBuilder.RegExpLiteral();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.Program_ord:
			specificBuilder.Program_();
			break;
		case JavaScriptEntityDescriptorEnum.Statements_ord:
			specificBuilder.Statements_();
			break;
		case JavaScriptEntityDescriptorEnum.Comment_ord:
			specificBuilder.Comment_();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectLiteral_ord:
			specificBuilder.ObjectLiteral_();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperties_ord:
			specificBuilder.ObjectProperties_();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperty_ord:
			specificBuilder.ObjectProperty_();
			break;
		case JavaScriptEntityDescriptorEnum.ArrayLiteral_ord:
			specificBuilder.ArrayLiteral_();
			break;
		case JavaScriptEntityDescriptorEnum.EmptyExpression_ord:
			specificBuilder.EmptyExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.ExpressionStatement_ord:
			specificBuilder.ExpressionStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.IfStatement_ord:
			specificBuilder.IfStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.LabeledStatement_ord:
			specificBuilder.LabeledStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.Labels_ord:
			specificBuilder.Labels_();
			break;
		case JavaScriptEntityDescriptorEnum.Label_ord:
			specificBuilder.Label_();
			break;
		case JavaScriptEntityDescriptorEnum.BreakStatement_ord:
			specificBuilder.BreakStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.ContinueStatement_ord:
			specificBuilder.ContinueStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.WithStatement_ord:
			specificBuilder.WithStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchStatement_ord:
			specificBuilder.SwitchStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCases_ord:
			specificBuilder.SwitchCases_();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCase_ord:
			specificBuilder.SwitchCase_();
			break;
		case JavaScriptEntityDescriptorEnum.ReturnStatement_ord:
			specificBuilder.ReturnStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.ThrowStatement_ord:
			specificBuilder.ThrowStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.TryStatement_ord:
			specificBuilder.TryStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.CatchClauses_ord:
			specificBuilder.CatchClauses_();
			break;
		case JavaScriptEntityDescriptorEnum.CatchClause_ord:
			specificBuilder.CatchClause_();
			break;
		case JavaScriptEntityDescriptorEnum.WhileStatement_ord:
			specificBuilder.WhileStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.DoWhileStatement_ord:
			specificBuilder.DoWhileStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.ForStatement_ord:
			specificBuilder.ForStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.ForInStatement_ord:
			specificBuilder.ForInStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.ForEachStatement_ord:
			specificBuilder.ForEachStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.LetStatement_ord:
			specificBuilder.LetStatement_();
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializers_ord:
			specificBuilder.VariableInitializers_();
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializer_ord:
			specificBuilder.VariableInitializer_();
			break;
		case JavaScriptEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder.FunctionDeclaration_();
			break;
		case JavaScriptEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder.VariableDeclaration_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlAny_ord:
			specificBuilder.XmlAny_();
			break;
		case JavaScriptEntityDescriptorEnum.ComputedXmlRef_ord:
			specificBuilder.ComputedXmlRef_();
			break;
		case JavaScriptEntityDescriptorEnum.StaticXmlRef_ord:
			specificBuilder.StaticXmlRef_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlMemberGet_ord:
			specificBuilder.XmlMemberGet_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlDotQuery_ord:
			specificBuilder.XmlDotQuery_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlLiteral_ord:
			specificBuilder.XmlLiteral_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlFragments_ord:
			specificBuilder.XmlFragments_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlString_ord:
			specificBuilder.XmlString_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlExpression_ord:
			specificBuilder.XmlExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.XmlDefaultNamespace_ord:
			specificBuilder.XmlDefaultNamespace_();
			break;
		case JavaScriptEntityDescriptorEnum.FunctionExpression_ord:
			specificBuilder.FunctionExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.Expressions_ord:
			specificBuilder.Expressions_();
			break;
		case JavaScriptEntityDescriptorEnum.ParenthesizedExpression_ord:
			specificBuilder.ParenthesizedExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.PrefixExpression_ord:
			specificBuilder.PrefixExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.PostfixExpression_ord:
			specificBuilder.PostfixExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.InfixExpression_ord:
			specificBuilder.InfixExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.AssignmentExpression_ord:
			specificBuilder.AssignmentExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.ConditionalExpression_ord:
			specificBuilder.ConditionalExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.NewExpression_ord:
			specificBuilder.NewExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.CallExpression_ord:
			specificBuilder.CallExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.ComputedMemberExpression_ord:
			specificBuilder.ComputedMemberExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.StaticMemberExpression_ord:
			specificBuilder.StaticMemberExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.YieldExpression_ord:
			specificBuilder.YieldExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression_ord:
			specificBuilder.ArrayComprehensionExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.ComprehensionBlocks_ord:
			specificBuilder.ComprehensionBlocks_();
			break;
		case JavaScriptEntityDescriptorEnum.ForInComprehensionBlock_ord:
			specificBuilder.ForInComprehensionBlock_();
			break;
		case JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock_ord:
			specificBuilder.ForEachComprehensionBlock_();
			break;
		case JavaScriptEntityDescriptorEnum.LetExpression_ord:
			specificBuilder.LetExpression_();
			break;
		case JavaScriptEntityDescriptorEnum.NullLiteral_ord:
			specificBuilder.NullLiteral_();
			break;
		case JavaScriptEntityDescriptorEnum.ThisLiteral_ord:
			specificBuilder.ThisLiteral_();
			break;
		case JavaScriptEntityDescriptorEnum.StringLiteral_ord:
			specificBuilder.StringLiteral_();
			break;
		case JavaScriptEntityDescriptorEnum.RegExpLiteral_ord:
			specificBuilder.RegExpLiteral_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.Program_ord:
			specificBuilder._Program();
			break;
		case JavaScriptEntityDescriptorEnum.Statements_ord:
			specificBuilder._Statements();
			break;
		case JavaScriptEntityDescriptorEnum.Comment_ord:
			specificBuilder._Comment();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectLiteral_ord:
			specificBuilder._ObjectLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperties_ord:
			specificBuilder._ObjectProperties();
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperty_ord:
			specificBuilder._ObjectProperty();
			break;
		case JavaScriptEntityDescriptorEnum.ArrayLiteral_ord:
			specificBuilder._ArrayLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.EmptyExpression_ord:
			specificBuilder._EmptyExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ExpressionStatement_ord:
			specificBuilder._ExpressionStatement();
			break;
		case JavaScriptEntityDescriptorEnum.IfStatement_ord:
			specificBuilder._IfStatement();
			break;
		case JavaScriptEntityDescriptorEnum.LabeledStatement_ord:
			specificBuilder._LabeledStatement();
			break;
		case JavaScriptEntityDescriptorEnum.Labels_ord:
			specificBuilder._Labels();
			break;
		case JavaScriptEntityDescriptorEnum.Label_ord:
			specificBuilder._Label();
			break;
		case JavaScriptEntityDescriptorEnum.BreakStatement_ord:
			specificBuilder._BreakStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ContinueStatement_ord:
			specificBuilder._ContinueStatement();
			break;
		case JavaScriptEntityDescriptorEnum.WithStatement_ord:
			specificBuilder._WithStatement();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchStatement_ord:
			specificBuilder._SwitchStatement();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCases_ord:
			specificBuilder._SwitchCases();
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCase_ord:
			specificBuilder._SwitchCase();
			break;
		case JavaScriptEntityDescriptorEnum.ReturnStatement_ord:
			specificBuilder._ReturnStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ThrowStatement_ord:
			specificBuilder._ThrowStatement();
			break;
		case JavaScriptEntityDescriptorEnum.TryStatement_ord:
			specificBuilder._TryStatement();
			break;
		case JavaScriptEntityDescriptorEnum.CatchClauses_ord:
			specificBuilder._CatchClauses();
			break;
		case JavaScriptEntityDescriptorEnum.CatchClause_ord:
			specificBuilder._CatchClause();
			break;
		case JavaScriptEntityDescriptorEnum.WhileStatement_ord:
			specificBuilder._WhileStatement();
			break;
		case JavaScriptEntityDescriptorEnum.DoWhileStatement_ord:
			specificBuilder._DoWhileStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ForStatement_ord:
			specificBuilder._ForStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ForInStatement_ord:
			specificBuilder._ForInStatement();
			break;
		case JavaScriptEntityDescriptorEnum.ForEachStatement_ord:
			specificBuilder._ForEachStatement();
			break;
		case JavaScriptEntityDescriptorEnum.LetStatement_ord:
			specificBuilder._LetStatement();
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializers_ord:
			specificBuilder._VariableInitializers();
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializer_ord:
			specificBuilder._VariableInitializer();
			break;
		case JavaScriptEntityDescriptorEnum.FunctionDeclaration_ord:
			specificBuilder._FunctionDeclaration();
			break;
		case JavaScriptEntityDescriptorEnum.VariableDeclaration_ord:
			specificBuilder._VariableDeclaration();
			break;
		case JavaScriptEntityDescriptorEnum.XmlAny_ord:
			specificBuilder._XmlAny();
			break;
		case JavaScriptEntityDescriptorEnum.ComputedXmlRef_ord:
			specificBuilder._ComputedXmlRef();
			break;
		case JavaScriptEntityDescriptorEnum.StaticXmlRef_ord:
			specificBuilder._StaticXmlRef();
			break;
		case JavaScriptEntityDescriptorEnum.XmlMemberGet_ord:
			specificBuilder._XmlMemberGet();
			break;
		case JavaScriptEntityDescriptorEnum.XmlDotQuery_ord:
			specificBuilder._XmlDotQuery();
			break;
		case JavaScriptEntityDescriptorEnum.XmlLiteral_ord:
			specificBuilder._XmlLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.XmlFragments_ord:
			specificBuilder._XmlFragments();
			break;
		case JavaScriptEntityDescriptorEnum.XmlString_ord:
			specificBuilder._XmlString();
			break;
		case JavaScriptEntityDescriptorEnum.XmlExpression_ord:
			specificBuilder._XmlExpression();
			break;
		case JavaScriptEntityDescriptorEnum.XmlDefaultNamespace_ord:
			specificBuilder._XmlDefaultNamespace();
			break;
		case JavaScriptEntityDescriptorEnum.FunctionExpression_ord:
			specificBuilder._FunctionExpression();
			break;
		case JavaScriptEntityDescriptorEnum.Expressions_ord:
			specificBuilder._Expressions();
			break;
		case JavaScriptEntityDescriptorEnum.ParenthesizedExpression_ord:
			specificBuilder._ParenthesizedExpression();
			break;
		case JavaScriptEntityDescriptorEnum.PrefixExpression_ord:
			specificBuilder._PrefixExpression();
			break;
		case JavaScriptEntityDescriptorEnum.PostfixExpression_ord:
			specificBuilder._PostfixExpression();
			break;
		case JavaScriptEntityDescriptorEnum.InfixExpression_ord:
			specificBuilder._InfixExpression();
			break;
		case JavaScriptEntityDescriptorEnum.AssignmentExpression_ord:
			specificBuilder._AssignmentExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ConditionalExpression_ord:
			specificBuilder._ConditionalExpression();
			break;
		case JavaScriptEntityDescriptorEnum.NewExpression_ord:
			specificBuilder._NewExpression();
			break;
		case JavaScriptEntityDescriptorEnum.CallExpression_ord:
			specificBuilder._CallExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ComputedMemberExpression_ord:
			specificBuilder._ComputedMemberExpression();
			break;
		case JavaScriptEntityDescriptorEnum.StaticMemberExpression_ord:
			specificBuilder._StaticMemberExpression();
			break;
		case JavaScriptEntityDescriptorEnum.YieldExpression_ord:
			specificBuilder._YieldExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression_ord:
			specificBuilder._ArrayComprehensionExpression();
			break;
		case JavaScriptEntityDescriptorEnum.ComprehensionBlocks_ord:
			specificBuilder._ComprehensionBlocks();
			break;
		case JavaScriptEntityDescriptorEnum.ForInComprehensionBlock_ord:
			specificBuilder._ForInComprehensionBlock();
			break;
		case JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock_ord:
			specificBuilder._ForEachComprehensionBlock();
			break;
		case JavaScriptEntityDescriptorEnum.LetExpression_ord:
			specificBuilder._LetExpression();
			break;
		case JavaScriptEntityDescriptorEnum.NullLiteral_ord:
			specificBuilder._NullLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.ThisLiteral_ord:
			specificBuilder._ThisLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.StringLiteral_ord:
			specificBuilder._StringLiteral();
			break;
		case JavaScriptEntityDescriptorEnum.RegExpLiteral_ord:
			specificBuilder._RegExpLiteral();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.Statements_ord:
			specificBuilder.Statements_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.ObjectProperties_ord:
			specificBuilder.ObjectProperties_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.Labels_ord:
			specificBuilder.Labels_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.SwitchCases_ord:
			specificBuilder.SwitchCases_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.CatchClauses_ord:
			specificBuilder.CatchClauses_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.VariableInitializers_ord:
			specificBuilder.VariableInitializers_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.XmlFragments_ord:
			specificBuilder.XmlFragments_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.Expressions_ord:
			specificBuilder.Expressions_(initialCapacity);
			break;
		case JavaScriptEntityDescriptorEnum.ComprehensionBlocks_ord:
			specificBuilder.ComprehensionBlocks_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.CommentKind_ord:
			specificBuilder.CommentKind((Value) value);
			break;
		case JavaScriptEntityDescriptorEnum.VariableDeclarationKind_ord:
			specificBuilder
					.VariableDeclarationKind((org.whole.lang.javascript.model.VariableDeclarationKindEnum.Value) value);
			break;
		case JavaScriptEntityDescriptorEnum.XmlMemberOperator_ord:
			specificBuilder
					.XmlMemberOperator((org.whole.lang.javascript.model.XmlMemberOperatorEnum.Value) value);
			break;
		case JavaScriptEntityDescriptorEnum.PrefixOperator_ord:
			specificBuilder
					.PrefixOperator((org.whole.lang.javascript.model.PrefixOperatorEnum.Value) value);
			break;
		case JavaScriptEntityDescriptorEnum.PostfixOperator_ord:
			specificBuilder
					.PostfixOperator((org.whole.lang.javascript.model.PostfixOperatorEnum.Value) value);
			break;
		case JavaScriptEntityDescriptorEnum.InfixOperator_ord:
			specificBuilder
					.InfixOperator((org.whole.lang.javascript.model.InfixOperatorEnum.Value) value);
			break;
		case JavaScriptEntityDescriptorEnum.AssignmentOperator_ord:
			specificBuilder
					.AssignmentOperator((org.whole.lang.javascript.model.AssignmentOperatorEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.Identifier_ord:
			specificBuilder.Identifier(value);
			break;
		case JavaScriptEntityDescriptorEnum.StringData_ord:
			specificBuilder.StringData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.BooleanLiteral_ord:
			specificBuilder.BooleanLiteral(value);
			break;
		case JavaScriptEntityDescriptorEnum.BooleanData_ord:
			specificBuilder.BooleanData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, double value) {
		switch (entityDesc.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.NumberLiteral_ord:
			specificBuilder.NumberLiteral(value);
			break;
		}
	}
}
