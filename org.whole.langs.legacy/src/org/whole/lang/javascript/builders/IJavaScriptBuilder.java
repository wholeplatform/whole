package org.whole.lang.javascript.builders;

import org.whole.lang.builders.IBuilder;
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
public interface IJavaScriptBuilder extends IBuilder {
	public void visit();

	public void flags();

	public void quote();

	public void filter();

	public void blocks();

	public void callee();

	public void arguments();

	public void constructor();

	public void operand();

	public void xml();

	public void fragments();

	public void right();

	public void operator();

	public void left();

	public void property();

	public void namespace();

	public void attribute();

	public void variables();

	public void iterated();

	public void iterator();

	public void update();

	public void init();

	public void guard();

	public void param();

	public void _finally();

	public void handlers();

	public void _try();

	public void argument();

	public void cases();

	public void object();

	public void target();

	public void name();

	public void labels();

	public void alternate();

	public void consequent();

	public void test();

	public void expression();

	public void elements();

	public void value();

	public void key();

	public void properties();

	public void destructuring();

	public void body();

	public void params();

	public void id();

	public void contents();

	public void kind();

	public void statements();

	public void Program();

	public void Program_();

	public void _Program();

	public void Statements();

	public void Statements_();

	public void Statements_(int initialCapacity);

	public void _Statements();

	public void Comment();

	public void Comment_();

	public void _Comment();

	public void CommentKind();

	public void CommentKind(CommentKindEnum.Value value);

	public void CommentKind(String value);

	public void ObjectLiteral();

	public void ObjectLiteral_();

	public void _ObjectLiteral();

	public void ObjectProperties();

	public void ObjectProperties_();

	public void ObjectProperties_(int initialCapacity);

	public void _ObjectProperties();

	public void ObjectProperty();

	public void ObjectProperty_();

	public void _ObjectProperty();

	public void ArrayLiteral();

	public void ArrayLiteral_();

	public void _ArrayLiteral();

	public void EmptyExpression();

	public void EmptyExpression_();

	public void _EmptyExpression();

	public void ExpressionStatement();

	public void ExpressionStatement_();

	public void _ExpressionStatement();

	public void IfStatement();

	public void IfStatement_();

	public void _IfStatement();

	public void LabeledStatement();

	public void LabeledStatement_();

	public void _LabeledStatement();

	public void Labels();

	public void Labels_();

	public void Labels_(int initialCapacity);

	public void _Labels();

	public void Label();

	public void Label_();

	public void _Label();

	public void BreakStatement();

	public void BreakStatement_();

	public void _BreakStatement();

	public void ContinueStatement();

	public void ContinueStatement_();

	public void _ContinueStatement();

	public void WithStatement();

	public void WithStatement_();

	public void _WithStatement();

	public void SwitchStatement();

	public void SwitchStatement_();

	public void _SwitchStatement();

	public void SwitchCases();

	public void SwitchCases_();

	public void SwitchCases_(int initialCapacity);

	public void _SwitchCases();

	public void SwitchCase();

	public void SwitchCase_();

	public void _SwitchCase();

	public void ReturnStatement();

	public void ReturnStatement_();

	public void _ReturnStatement();

	public void ThrowStatement();

	public void ThrowStatement_();

	public void _ThrowStatement();

	public void TryStatement();

	public void TryStatement_();

	public void _TryStatement();

	public void CatchClauses();

	public void CatchClauses_();

	public void CatchClauses_(int initialCapacity);

	public void _CatchClauses();

	public void CatchClause();

	public void CatchClause_();

	public void _CatchClause();

	public void WhileStatement();

	public void WhileStatement_();

	public void _WhileStatement();

	public void DoWhileStatement();

	public void DoWhileStatement_();

	public void _DoWhileStatement();

	public void ForStatement();

	public void ForStatement_();

	public void _ForStatement();

	public void ForInStatement();

	public void ForInStatement_();

	public void _ForInStatement();

	public void ForEachStatement();

	public void ForEachStatement_();

	public void _ForEachStatement();

	public void LetStatement();

	public void LetStatement_();

	public void _LetStatement();

	public void VariableInitializers();

	public void VariableInitializers_();

	public void VariableInitializers_(int initialCapacity);

	public void _VariableInitializers();

	public void VariableInitializer();

	public void VariableInitializer_();

	public void _VariableInitializer();

	public void FunctionDeclaration();

	public void FunctionDeclaration_();

	public void _FunctionDeclaration();

	public void VariableDeclaration();

	public void VariableDeclaration_();

	public void _VariableDeclaration();

	public void VariableDeclarationKind();

	public void VariableDeclarationKind(VariableDeclarationKindEnum.Value value);

	public void VariableDeclarationKind(String value);

	public void XmlAny();

	public void XmlAny_();

	public void _XmlAny();

	public void ComputedXmlRef();

	public void ComputedXmlRef_();

	public void _ComputedXmlRef();

	public void StaticXmlRef();

	public void StaticXmlRef_();

	public void _StaticXmlRef();

	public void XmlMemberGet();

	public void XmlMemberGet_();

	public void _XmlMemberGet();

	public void XmlDotQuery();

	public void XmlDotQuery_();

	public void _XmlDotQuery();

	public void XmlMemberOperator();

	public void XmlMemberOperator(XmlMemberOperatorEnum.Value value);

	public void XmlMemberOperator(String value);

	public void XmlLiteral();

	public void XmlLiteral_();

	public void _XmlLiteral();

	public void XmlFragments();

	public void XmlFragments_();

	public void XmlFragments_(int initialCapacity);

	public void _XmlFragments();

	public void XmlString();

	public void XmlString_();

	public void _XmlString();

	public void XmlExpression();

	public void XmlExpression_();

	public void _XmlExpression();

	public void XmlDefaultNamespace();

	public void XmlDefaultNamespace_();

	public void _XmlDefaultNamespace();

	public void FunctionExpression();

	public void FunctionExpression_();

	public void _FunctionExpression();

	public void Expressions();

	public void Expressions_();

	public void Expressions_(int initialCapacity);

	public void _Expressions();

	public void ParenthesizedExpression();

	public void ParenthesizedExpression_();

	public void _ParenthesizedExpression();

	public void PrefixExpression();

	public void PrefixExpression_();

	public void _PrefixExpression();

	public void PostfixExpression();

	public void PostfixExpression_();

	public void _PostfixExpression();

	public void PrefixOperator();

	public void PrefixOperator(PrefixOperatorEnum.Value value);

	public void PrefixOperator(String value);

	public void PostfixOperator();

	public void PostfixOperator(PostfixOperatorEnum.Value value);

	public void PostfixOperator(String value);

	public void InfixExpression();

	public void InfixExpression_();

	public void _InfixExpression();

	public void InfixOperator();

	public void InfixOperator(InfixOperatorEnum.Value value);

	public void InfixOperator(String value);

	public void AssignmentExpression();

	public void AssignmentExpression_();

	public void _AssignmentExpression();

	public void AssignmentOperator();

	public void AssignmentOperator(AssignmentOperatorEnum.Value value);

	public void AssignmentOperator(String value);

	public void ConditionalExpression();

	public void ConditionalExpression_();

	public void _ConditionalExpression();

	public void NewExpression();

	public void NewExpression_();

	public void _NewExpression();

	public void CallExpression();

	public void CallExpression_();

	public void _CallExpression();

	public void ComputedMemberExpression();

	public void ComputedMemberExpression_();

	public void _ComputedMemberExpression();

	public void StaticMemberExpression();

	public void StaticMemberExpression_();

	public void _StaticMemberExpression();

	public void YieldExpression();

	public void YieldExpression_();

	public void _YieldExpression();

	public void ArrayComprehensionExpression();

	public void ArrayComprehensionExpression_();

	public void _ArrayComprehensionExpression();

	public void ComprehensionBlocks();

	public void ComprehensionBlocks_();

	public void ComprehensionBlocks_(int initialCapacity);

	public void _ComprehensionBlocks();

	public void ForInComprehensionBlock();

	public void ForInComprehensionBlock_();

	public void _ForInComprehensionBlock();

	public void ForEachComprehensionBlock();

	public void ForEachComprehensionBlock_();

	public void _ForEachComprehensionBlock();

	public void LetExpression();

	public void LetExpression_();

	public void _LetExpression();

	public void Identifier();

	public void Identifier(String value);

	public void NullLiteral();

	public void NullLiteral_();

	public void _NullLiteral();

	public void ThisLiteral();

	public void ThisLiteral_();

	public void _ThisLiteral();

	public void StringLiteral();

	public void StringLiteral_();

	public void _StringLiteral();

	public void BooleanLiteral();

	public void BooleanLiteral(boolean value);

	public void NumberLiteral();

	public void NumberLiteral(double value);

	public void RegExpLiteral();

	public void RegExpLiteral_();

	public void _RegExpLiteral();

	public void BooleanData();

	public void BooleanData(boolean value);

	public void StringData();

	public void StringData(String value);
}
