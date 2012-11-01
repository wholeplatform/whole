package org.whole.lang.javascript.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.model.CommentKindEnum;
import org.whole.lang.javascript.model.VariableDeclarationKindEnum;
import org.whole.lang.javascript.model.XmlMemberOperatorEnum;
import org.whole.lang.javascript.model.PrefixOperatorEnum;
import org.whole.lang.javascript.model.PostfixOperatorEnum;
import org.whole.lang.javascript.model.InfixOperatorEnum;
import org.whole.lang.javascript.model.AssignmentOperatorEnum;

/** 
 * @generator Whole
 */
public class JavaScriptSpecificBuilderAdapter extends GenericBuilderContext
		implements IJavaScriptBuilder {
	public JavaScriptSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public JavaScriptSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void flags() {
		wFeature(JavaScriptFeatureDescriptorEnum.flags);
	}

	public void quote() {
		wFeature(JavaScriptFeatureDescriptorEnum.quote);
	}

	public void filter() {
		wFeature(JavaScriptFeatureDescriptorEnum.filter);
	}

	public void blocks() {
		wFeature(JavaScriptFeatureDescriptorEnum.blocks);
	}

	public void callee() {
		wFeature(JavaScriptFeatureDescriptorEnum.callee);
	}

	public void arguments() {
		wFeature(JavaScriptFeatureDescriptorEnum.arguments);
	}

	public void constructor() {
		wFeature(JavaScriptFeatureDescriptorEnum.constructor);
	}

	public void operand() {
		wFeature(JavaScriptFeatureDescriptorEnum.operand);
	}

	public void xml() {
		wFeature(JavaScriptFeatureDescriptorEnum.xml);
	}

	public void fragments() {
		wFeature(JavaScriptFeatureDescriptorEnum.fragments);
	}

	public void right() {
		wFeature(JavaScriptFeatureDescriptorEnum.right);
	}

	public void operator() {
		wFeature(JavaScriptFeatureDescriptorEnum.operator);
	}

	public void left() {
		wFeature(JavaScriptFeatureDescriptorEnum.left);
	}

	public void property() {
		wFeature(JavaScriptFeatureDescriptorEnum.property);
	}

	public void namespace() {
		wFeature(JavaScriptFeatureDescriptorEnum.namespace);
	}

	public void attribute() {
		wFeature(JavaScriptFeatureDescriptorEnum.attribute);
	}

	public void variables() {
		wFeature(JavaScriptFeatureDescriptorEnum.variables);
	}

	public void iterated() {
		wFeature(JavaScriptFeatureDescriptorEnum.iterated);
	}

	public void iterator() {
		wFeature(JavaScriptFeatureDescriptorEnum.iterator);
	}

	public void update() {
		wFeature(JavaScriptFeatureDescriptorEnum.update);
	}

	public void init() {
		wFeature(JavaScriptFeatureDescriptorEnum.init);
	}

	public void guard() {
		wFeature(JavaScriptFeatureDescriptorEnum.guard);
	}

	public void param() {
		wFeature(JavaScriptFeatureDescriptorEnum.param);
	}

	public void _finally() {
		wFeature(JavaScriptFeatureDescriptorEnum._finally);
	}

	public void handlers() {
		wFeature(JavaScriptFeatureDescriptorEnum.handlers);
	}

	public void _try() {
		wFeature(JavaScriptFeatureDescriptorEnum._try);
	}

	public void argument() {
		wFeature(JavaScriptFeatureDescriptorEnum.argument);
	}

	public void cases() {
		wFeature(JavaScriptFeatureDescriptorEnum.cases);
	}

	public void object() {
		wFeature(JavaScriptFeatureDescriptorEnum.object);
	}

	public void target() {
		wFeature(JavaScriptFeatureDescriptorEnum.target);
	}

	public void name() {
		wFeature(JavaScriptFeatureDescriptorEnum.name);
	}

	public void labels() {
		wFeature(JavaScriptFeatureDescriptorEnum.labels);
	}

	public void alternate() {
		wFeature(JavaScriptFeatureDescriptorEnum.alternate);
	}

	public void consequent() {
		wFeature(JavaScriptFeatureDescriptorEnum.consequent);
	}

	public void test() {
		wFeature(JavaScriptFeatureDescriptorEnum.test);
	}

	public void expression() {
		wFeature(JavaScriptFeatureDescriptorEnum.expression);
	}

	public void elements() {
		wFeature(JavaScriptFeatureDescriptorEnum.elements);
	}

	public void value() {
		wFeature(JavaScriptFeatureDescriptorEnum.value);
	}

	public void key() {
		wFeature(JavaScriptFeatureDescriptorEnum.key);
	}

	public void properties() {
		wFeature(JavaScriptFeatureDescriptorEnum.properties);
	}

	public void destructuring() {
		wFeature(JavaScriptFeatureDescriptorEnum.destructuring);
	}

	public void body() {
		wFeature(JavaScriptFeatureDescriptorEnum.body);
	}

	public void params() {
		wFeature(JavaScriptFeatureDescriptorEnum.params);
	}

	public void id() {
		wFeature(JavaScriptFeatureDescriptorEnum.id);
	}

	public void contents() {
		wFeature(JavaScriptFeatureDescriptorEnum.contents);
	}

	public void kind() {
		wFeature(JavaScriptFeatureDescriptorEnum.kind);
	}

	public void statements() {
		wFeature(JavaScriptFeatureDescriptorEnum.statements);
	}

	public void visit() {
	}

	public void Program() {
		wEntity(JavaScriptEntityDescriptorEnum.Program);
	}

	public void Program_() {
		wEntity_(JavaScriptEntityDescriptorEnum.Program);
	}

	public void _Program() {
		_wEntity(JavaScriptEntityDescriptorEnum.Program);
	}

	public void Statements() {
		wEntity(JavaScriptEntityDescriptorEnum.Statements);
	}

	public void Statements_() {
		wEntity_(JavaScriptEntityDescriptorEnum.Statements);
	}

	public void Statements_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.Statements, initialCapacity);
	}

	public void _Statements() {
		_wEntity(JavaScriptEntityDescriptorEnum.Statements);
	}

	public void Comment() {
		wEntity(JavaScriptEntityDescriptorEnum.Comment);
	}

	public void Comment_() {
		wEntity_(JavaScriptEntityDescriptorEnum.Comment);
	}

	public void _Comment() {
		_wEntity(JavaScriptEntityDescriptorEnum.Comment);
	}

	public void CommentKind() {
		wEntity(JavaScriptEntityDescriptorEnum.CommentKind);
	}

	public void CommentKind(CommentKindEnum.Value value) {
		wEntity(JavaScriptEntityDescriptorEnum.CommentKind, value);
	}

	public void CommentKind(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.CommentKind, value);
	}

	public void ObjectLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.ObjectLiteral);
	}

	public void ObjectLiteral_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ObjectLiteral);
	}

	public void _ObjectLiteral() {
		_wEntity(JavaScriptEntityDescriptorEnum.ObjectLiteral);
	}

	public void ObjectProperties() {
		wEntity(JavaScriptEntityDescriptorEnum.ObjectProperties);
	}

	public void ObjectProperties_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ObjectProperties);
	}

	public void ObjectProperties_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.ObjectProperties,
				initialCapacity);
	}

	public void _ObjectProperties() {
		_wEntity(JavaScriptEntityDescriptorEnum.ObjectProperties);
	}

	public void ObjectProperty() {
		wEntity(JavaScriptEntityDescriptorEnum.ObjectProperty);
	}

	public void ObjectProperty_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ObjectProperty);
	}

	public void _ObjectProperty() {
		_wEntity(JavaScriptEntityDescriptorEnum.ObjectProperty);
	}

	public void ArrayLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.ArrayLiteral);
	}

	public void ArrayLiteral_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ArrayLiteral);
	}

	public void _ArrayLiteral() {
		_wEntity(JavaScriptEntityDescriptorEnum.ArrayLiteral);
	}

	public void EmptyExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.EmptyExpression);
	}

	public void EmptyExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.EmptyExpression);
	}

	public void _EmptyExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.EmptyExpression);
	}

	public void ExpressionStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.ExpressionStatement);
	}

	public void ExpressionStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ExpressionStatement);
	}

	public void _ExpressionStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.ExpressionStatement);
	}

	public void IfStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.IfStatement);
	}

	public void IfStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.IfStatement);
	}

	public void _IfStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.IfStatement);
	}

	public void LabeledStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.LabeledStatement);
	}

	public void LabeledStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.LabeledStatement);
	}

	public void _LabeledStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.LabeledStatement);
	}

	public void Labels() {
		wEntity(JavaScriptEntityDescriptorEnum.Labels);
	}

	public void Labels_() {
		wEntity_(JavaScriptEntityDescriptorEnum.Labels);
	}

	public void Labels_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.Labels, initialCapacity);
	}

	public void _Labels() {
		_wEntity(JavaScriptEntityDescriptorEnum.Labels);
	}

	public void Label() {
		wEntity(JavaScriptEntityDescriptorEnum.Label);
	}

	public void Label_() {
		wEntity_(JavaScriptEntityDescriptorEnum.Label);
	}

	public void _Label() {
		_wEntity(JavaScriptEntityDescriptorEnum.Label);
	}

	public void BreakStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.BreakStatement);
	}

	public void BreakStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.BreakStatement);
	}

	public void _BreakStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.BreakStatement);
	}

	public void ContinueStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.ContinueStatement);
	}

	public void ContinueStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ContinueStatement);
	}

	public void _ContinueStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.ContinueStatement);
	}

	public void WithStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.WithStatement);
	}

	public void WithStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.WithStatement);
	}

	public void _WithStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.WithStatement);
	}

	public void SwitchStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.SwitchStatement);
	}

	public void SwitchStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.SwitchStatement);
	}

	public void _SwitchStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.SwitchStatement);
	}

	public void SwitchCases() {
		wEntity(JavaScriptEntityDescriptorEnum.SwitchCases);
	}

	public void SwitchCases_() {
		wEntity_(JavaScriptEntityDescriptorEnum.SwitchCases);
	}

	public void SwitchCases_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.SwitchCases, initialCapacity);
	}

	public void _SwitchCases() {
		_wEntity(JavaScriptEntityDescriptorEnum.SwitchCases);
	}

	public void SwitchCase() {
		wEntity(JavaScriptEntityDescriptorEnum.SwitchCase);
	}

	public void SwitchCase_() {
		wEntity_(JavaScriptEntityDescriptorEnum.SwitchCase);
	}

	public void _SwitchCase() {
		_wEntity(JavaScriptEntityDescriptorEnum.SwitchCase);
	}

	public void ReturnStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.ReturnStatement);
	}

	public void ReturnStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ReturnStatement);
	}

	public void _ReturnStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.ReturnStatement);
	}

	public void ThrowStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.ThrowStatement);
	}

	public void ThrowStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ThrowStatement);
	}

	public void _ThrowStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.ThrowStatement);
	}

	public void TryStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.TryStatement);
	}

	public void TryStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.TryStatement);
	}

	public void _TryStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.TryStatement);
	}

	public void CatchClauses() {
		wEntity(JavaScriptEntityDescriptorEnum.CatchClauses);
	}

	public void CatchClauses_() {
		wEntity_(JavaScriptEntityDescriptorEnum.CatchClauses);
	}

	public void CatchClauses_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.CatchClauses, initialCapacity);
	}

	public void _CatchClauses() {
		_wEntity(JavaScriptEntityDescriptorEnum.CatchClauses);
	}

	public void CatchClause() {
		wEntity(JavaScriptEntityDescriptorEnum.CatchClause);
	}

	public void CatchClause_() {
		wEntity_(JavaScriptEntityDescriptorEnum.CatchClause);
	}

	public void _CatchClause() {
		_wEntity(JavaScriptEntityDescriptorEnum.CatchClause);
	}

	public void WhileStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.WhileStatement);
	}

	public void WhileStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.WhileStatement);
	}

	public void _WhileStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.WhileStatement);
	}

	public void DoWhileStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.DoWhileStatement);
	}

	public void DoWhileStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.DoWhileStatement);
	}

	public void _DoWhileStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.DoWhileStatement);
	}

	public void ForStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.ForStatement);
	}

	public void ForStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ForStatement);
	}

	public void _ForStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.ForStatement);
	}

	public void ForInStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.ForInStatement);
	}

	public void ForInStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ForInStatement);
	}

	public void _ForInStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.ForInStatement);
	}

	public void ForEachStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.ForEachStatement);
	}

	public void ForEachStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ForEachStatement);
	}

	public void _ForEachStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.ForEachStatement);
	}

	public void LetStatement() {
		wEntity(JavaScriptEntityDescriptorEnum.LetStatement);
	}

	public void LetStatement_() {
		wEntity_(JavaScriptEntityDescriptorEnum.LetStatement);
	}

	public void _LetStatement() {
		_wEntity(JavaScriptEntityDescriptorEnum.LetStatement);
	}

	public void VariableInitializers() {
		wEntity(JavaScriptEntityDescriptorEnum.VariableInitializers);
	}

	public void VariableInitializers_() {
		wEntity_(JavaScriptEntityDescriptorEnum.VariableInitializers);
	}

	public void VariableInitializers_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.VariableInitializers,
				initialCapacity);
	}

	public void _VariableInitializers() {
		_wEntity(JavaScriptEntityDescriptorEnum.VariableInitializers);
	}

	public void VariableInitializer() {
		wEntity(JavaScriptEntityDescriptorEnum.VariableInitializer);
	}

	public void VariableInitializer_() {
		wEntity_(JavaScriptEntityDescriptorEnum.VariableInitializer);
	}

	public void _VariableInitializer() {
		_wEntity(JavaScriptEntityDescriptorEnum.VariableInitializer);
	}

	public void FunctionDeclaration() {
		wEntity(JavaScriptEntityDescriptorEnum.FunctionDeclaration);
	}

	public void FunctionDeclaration_() {
		wEntity_(JavaScriptEntityDescriptorEnum.FunctionDeclaration);
	}

	public void _FunctionDeclaration() {
		_wEntity(JavaScriptEntityDescriptorEnum.FunctionDeclaration);
	}

	public void VariableDeclaration() {
		wEntity(JavaScriptEntityDescriptorEnum.VariableDeclaration);
	}

	public void VariableDeclaration_() {
		wEntity_(JavaScriptEntityDescriptorEnum.VariableDeclaration);
	}

	public void _VariableDeclaration() {
		_wEntity(JavaScriptEntityDescriptorEnum.VariableDeclaration);
	}

	public void VariableDeclarationKind() {
		wEntity(JavaScriptEntityDescriptorEnum.VariableDeclarationKind);
	}

	public void VariableDeclarationKind(VariableDeclarationKindEnum.Value value) {
		wEntity(JavaScriptEntityDescriptorEnum.VariableDeclarationKind, value);
	}

	public void VariableDeclarationKind(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.VariableDeclarationKind, value);
	}

	public void XmlAny() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlAny);
	}

	public void XmlAny_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlAny);
	}

	public void _XmlAny() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlAny);
	}

	public void ComputedXmlRef() {
		wEntity(JavaScriptEntityDescriptorEnum.ComputedXmlRef);
	}

	public void ComputedXmlRef_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ComputedXmlRef);
	}

	public void _ComputedXmlRef() {
		_wEntity(JavaScriptEntityDescriptorEnum.ComputedXmlRef);
	}

	public void StaticXmlRef() {
		wEntity(JavaScriptEntityDescriptorEnum.StaticXmlRef);
	}

	public void StaticXmlRef_() {
		wEntity_(JavaScriptEntityDescriptorEnum.StaticXmlRef);
	}

	public void _StaticXmlRef() {
		_wEntity(JavaScriptEntityDescriptorEnum.StaticXmlRef);
	}

	public void XmlMemberGet() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlMemberGet);
	}

	public void XmlMemberGet_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlMemberGet);
	}

	public void _XmlMemberGet() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlMemberGet);
	}

	public void XmlDotQuery() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlDotQuery);
	}

	public void XmlDotQuery_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlDotQuery);
	}

	public void _XmlDotQuery() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlDotQuery);
	}

	public void XmlMemberOperator() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlMemberOperator);
	}

	public void XmlMemberOperator(XmlMemberOperatorEnum.Value value) {
		wEntity(JavaScriptEntityDescriptorEnum.XmlMemberOperator, value);
	}

	public void XmlMemberOperator(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.XmlMemberOperator, value);
	}

	public void XmlLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlLiteral);
	}

	public void XmlLiteral_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlLiteral);
	}

	public void _XmlLiteral() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlLiteral);
	}

	public void XmlFragments() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlFragments);
	}

	public void XmlFragments_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlFragments);
	}

	public void XmlFragments_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlFragments, initialCapacity);
	}

	public void _XmlFragments() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlFragments);
	}

	public void XmlString() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlString);
	}

	public void XmlString_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlString);
	}

	public void _XmlString() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlString);
	}

	public void XmlExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlExpression);
	}

	public void XmlExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlExpression);
	}

	public void _XmlExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlExpression);
	}

	public void XmlDefaultNamespace() {
		wEntity(JavaScriptEntityDescriptorEnum.XmlDefaultNamespace);
	}

	public void XmlDefaultNamespace_() {
		wEntity_(JavaScriptEntityDescriptorEnum.XmlDefaultNamespace);
	}

	public void _XmlDefaultNamespace() {
		_wEntity(JavaScriptEntityDescriptorEnum.XmlDefaultNamespace);
	}

	public void FunctionExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.FunctionExpression);
	}

	public void FunctionExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.FunctionExpression);
	}

	public void _FunctionExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.FunctionExpression);
	}

	public void Expressions() {
		wEntity(JavaScriptEntityDescriptorEnum.Expressions);
	}

	public void Expressions_() {
		wEntity_(JavaScriptEntityDescriptorEnum.Expressions);
	}

	public void Expressions_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.Expressions, initialCapacity);
	}

	public void _Expressions() {
		_wEntity(JavaScriptEntityDescriptorEnum.Expressions);
	}

	public void ParenthesizedExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.ParenthesizedExpression);
	}

	public void ParenthesizedExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ParenthesizedExpression);
	}

	public void _ParenthesizedExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.ParenthesizedExpression);
	}

	public void PrefixExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.PrefixExpression);
	}

	public void PrefixExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.PrefixExpression);
	}

	public void _PrefixExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.PrefixExpression);
	}

	public void PostfixExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.PostfixExpression);
	}

	public void PostfixExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.PostfixExpression);
	}

	public void _PostfixExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.PostfixExpression);
	}

	public void PrefixOperator() {
		wEntity(JavaScriptEntityDescriptorEnum.PrefixOperator);
	}

	public void PrefixOperator(PrefixOperatorEnum.Value value) {
		wEntity(JavaScriptEntityDescriptorEnum.PrefixOperator, value);
	}

	public void PrefixOperator(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.PrefixOperator, value);
	}

	public void PostfixOperator() {
		wEntity(JavaScriptEntityDescriptorEnum.PostfixOperator);
	}

	public void PostfixOperator(PostfixOperatorEnum.Value value) {
		wEntity(JavaScriptEntityDescriptorEnum.PostfixOperator, value);
	}

	public void PostfixOperator(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.PostfixOperator, value);
	}

	public void InfixExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.InfixExpression);
	}

	public void InfixExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.InfixExpression);
	}

	public void _InfixExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.InfixExpression);
	}

	public void InfixOperator() {
		wEntity(JavaScriptEntityDescriptorEnum.InfixOperator);
	}

	public void InfixOperator(InfixOperatorEnum.Value value) {
		wEntity(JavaScriptEntityDescriptorEnum.InfixOperator, value);
	}

	public void InfixOperator(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.InfixOperator, value);
	}

	public void AssignmentExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.AssignmentExpression);
	}

	public void AssignmentExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.AssignmentExpression);
	}

	public void _AssignmentExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.AssignmentExpression);
	}

	public void AssignmentOperator() {
		wEntity(JavaScriptEntityDescriptorEnum.AssignmentOperator);
	}

	public void AssignmentOperator(AssignmentOperatorEnum.Value value) {
		wEntity(JavaScriptEntityDescriptorEnum.AssignmentOperator, value);
	}

	public void AssignmentOperator(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.AssignmentOperator, value);
	}

	public void ConditionalExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.ConditionalExpression);
	}

	public void ConditionalExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ConditionalExpression);
	}

	public void _ConditionalExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.ConditionalExpression);
	}

	public void NewExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.NewExpression);
	}

	public void NewExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.NewExpression);
	}

	public void _NewExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.NewExpression);
	}

	public void CallExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.CallExpression);
	}

	public void CallExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.CallExpression);
	}

	public void _CallExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.CallExpression);
	}

	public void ComputedMemberExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.ComputedMemberExpression);
	}

	public void ComputedMemberExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ComputedMemberExpression);
	}

	public void _ComputedMemberExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.ComputedMemberExpression);
	}

	public void StaticMemberExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.StaticMemberExpression);
	}

	public void StaticMemberExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.StaticMemberExpression);
	}

	public void _StaticMemberExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.StaticMemberExpression);
	}

	public void YieldExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.YieldExpression);
	}

	public void YieldExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.YieldExpression);
	}

	public void _YieldExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.YieldExpression);
	}

	public void ArrayComprehensionExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression);
	}

	public void ArrayComprehensionExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression);
	}

	public void _ArrayComprehensionExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression);
	}

	public void ComprehensionBlocks() {
		wEntity(JavaScriptEntityDescriptorEnum.ComprehensionBlocks);
	}

	public void ComprehensionBlocks_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ComprehensionBlocks);
	}

	public void ComprehensionBlocks_(int initialCapacity) {
		wEntity_(JavaScriptEntityDescriptorEnum.ComprehensionBlocks,
				initialCapacity);
	}

	public void _ComprehensionBlocks() {
		_wEntity(JavaScriptEntityDescriptorEnum.ComprehensionBlocks);
	}

	public void ForInComprehensionBlock() {
		wEntity(JavaScriptEntityDescriptorEnum.ForInComprehensionBlock);
	}

	public void ForInComprehensionBlock_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ForInComprehensionBlock);
	}

	public void _ForInComprehensionBlock() {
		_wEntity(JavaScriptEntityDescriptorEnum.ForInComprehensionBlock);
	}

	public void ForEachComprehensionBlock() {
		wEntity(JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock);
	}

	public void ForEachComprehensionBlock_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock);
	}

	public void _ForEachComprehensionBlock() {
		_wEntity(JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock);
	}

	public void LetExpression() {
		wEntity(JavaScriptEntityDescriptorEnum.LetExpression);
	}

	public void LetExpression_() {
		wEntity_(JavaScriptEntityDescriptorEnum.LetExpression);
	}

	public void _LetExpression() {
		_wEntity(JavaScriptEntityDescriptorEnum.LetExpression);
	}

	public void Identifier() {
		wEntity(JavaScriptEntityDescriptorEnum.Identifier);
	}

	public void Identifier(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.Identifier, value);
	}

	public void NullLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.NullLiteral);
	}

	public void NullLiteral_() {
		wEntity_(JavaScriptEntityDescriptorEnum.NullLiteral);
	}

	public void _NullLiteral() {
		_wEntity(JavaScriptEntityDescriptorEnum.NullLiteral);
	}

	public void ThisLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.ThisLiteral);
	}

	public void ThisLiteral_() {
		wEntity_(JavaScriptEntityDescriptorEnum.ThisLiteral);
	}

	public void _ThisLiteral() {
		_wEntity(JavaScriptEntityDescriptorEnum.ThisLiteral);
	}

	public void StringLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.StringLiteral);
	}

	public void StringLiteral_() {
		wEntity_(JavaScriptEntityDescriptorEnum.StringLiteral);
	}

	public void _StringLiteral() {
		_wEntity(JavaScriptEntityDescriptorEnum.StringLiteral);
	}

	public void BooleanLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.BooleanLiteral);
	}

	public void BooleanLiteral(boolean value) {
		wEntity(JavaScriptEntityDescriptorEnum.BooleanLiteral, value);
	}

	public void NumberLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.NumberLiteral);
	}

	public void NumberLiteral(double value) {
		wEntity(JavaScriptEntityDescriptorEnum.NumberLiteral, value);
	}

	public void RegExpLiteral() {
		wEntity(JavaScriptEntityDescriptorEnum.RegExpLiteral);
	}

	public void RegExpLiteral_() {
		wEntity_(JavaScriptEntityDescriptorEnum.RegExpLiteral);
	}

	public void _RegExpLiteral() {
		_wEntity(JavaScriptEntityDescriptorEnum.RegExpLiteral);
	}

	public void BooleanData() {
		wEntity(JavaScriptEntityDescriptorEnum.BooleanData);
	}

	public void BooleanData(boolean value) {
		wEntity(JavaScriptEntityDescriptorEnum.BooleanData, value);
	}

	public void StringData() {
		wEntity(JavaScriptEntityDescriptorEnum.StringData);
	}

	public void StringData(String value) {
		wEntity(JavaScriptEntityDescriptorEnum.StringData, value);
	}
}
