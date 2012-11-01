package org.whole.lang.javascript.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.javascript.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/** 
 * @generator Whole
 */
public class JavaScriptEntityFactory extends GenericEntityFactory {
	public static final JavaScriptEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static JavaScriptEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new JavaScriptEntityFactory(provider);
	}

	protected JavaScriptEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Program createProgram() {
		return create(JavaScriptEntityDescriptorEnum.Program);
	}

	public Program createProgram(Statements statements) {
		return create(JavaScriptEntityDescriptorEnum.Program, statements);
	}

	public Statements createStatements() {
		return create(JavaScriptEntityDescriptorEnum.Statements);
	}

	public Statements createStatements(Statement... entities) {
		return create(JavaScriptEntityDescriptorEnum.Statements,
				(IEntity[]) entities);
	}

	public Statements createStatements(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.Statements, initialSize);
	}

	public Comment createComment() {
		return create(JavaScriptEntityDescriptorEnum.Comment);
	}

	public Comment createComment(CommentKind kind, StringData contents) {
		return create(JavaScriptEntityDescriptorEnum.Comment, kind, contents);
	}

	public IEntityBuilder<Comment> buildComment() {
		return new EntityBuilder<Comment>(
				create(JavaScriptEntityDescriptorEnum.Comment));
	}

	public CommentKind createCommentKind() {
		return create(JavaScriptEntityDescriptorEnum.CommentKind);
	}

	public CommentKind createCommentKind(CommentKindEnum.Value value) {
		return create(JavaScriptEntityDescriptorEnum.CommentKind, value);
	}

	public ObjectLiteral createObjectLiteral() {
		return create(JavaScriptEntityDescriptorEnum.ObjectLiteral);
	}

	public ObjectLiteral createObjectLiteral(BooleanData destructuring,
			ObjectProperties properties) {
		return create(JavaScriptEntityDescriptorEnum.ObjectLiteral,
				destructuring, properties);
	}

	public IEntityBuilder<ObjectLiteral> buildObjectLiteral() {
		return new EntityBuilder<ObjectLiteral>(
				create(JavaScriptEntityDescriptorEnum.ObjectLiteral));
	}

	public ObjectProperties createObjectProperties() {
		return create(JavaScriptEntityDescriptorEnum.ObjectProperties);
	}

	public ObjectProperties createObjectProperties(ObjectProperty... entities) {
		return create(JavaScriptEntityDescriptorEnum.ObjectProperties,
				(IEntity[]) entities);
	}

	public ObjectProperties createObjectProperties(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.ObjectProperties,
				initialSize);
	}

	public ObjectProperty createObjectProperty() {
		return create(JavaScriptEntityDescriptorEnum.ObjectProperty);
	}

	public ObjectProperty createObjectProperty(LiteralOrIdentifier key,
			Expression value) {
		return create(JavaScriptEntityDescriptorEnum.ObjectProperty, key, value);
	}

	public IEntityBuilder<ObjectProperty> buildObjectProperty() {
		return new EntityBuilder<ObjectProperty>(
				create(JavaScriptEntityDescriptorEnum.ObjectProperty));
	}

	public ArrayLiteral createArrayLiteral() {
		return create(JavaScriptEntityDescriptorEnum.ArrayLiteral);
	}

	public ArrayLiteral createArrayLiteral(BooleanData destructuring,
			Expressions elements) {
		return create(JavaScriptEntityDescriptorEnum.ArrayLiteral,
				destructuring, elements);
	}

	public IEntityBuilder<ArrayLiteral> buildArrayLiteral() {
		return new EntityBuilder<ArrayLiteral>(
				create(JavaScriptEntityDescriptorEnum.ArrayLiteral));
	}

	public EmptyExpression createEmptyExpression() {
		return create(JavaScriptEntityDescriptorEnum.EmptyExpression);
	}

	public ExpressionStatement createExpressionStatement() {
		return create(JavaScriptEntityDescriptorEnum.ExpressionStatement);
	}

	public ExpressionStatement createExpressionStatement(Expression expression) {
		return create(JavaScriptEntityDescriptorEnum.ExpressionStatement,
				expression);
	}

	public IfStatement createIfStatement() {
		return create(JavaScriptEntityDescriptorEnum.IfStatement);
	}

	public IfStatement createIfStatement(Expression test, Statement consequent,
			Statement alternate) {
		return create(JavaScriptEntityDescriptorEnum.IfStatement, test,
				consequent, alternate);
	}

	public IEntityBuilder<IfStatement> buildIfStatement() {
		return new EntityBuilder<IfStatement>(
				create(JavaScriptEntityDescriptorEnum.IfStatement));
	}

	public LabeledStatement createLabeledStatement() {
		return create(JavaScriptEntityDescriptorEnum.LabeledStatement);
	}

	public LabeledStatement createLabeledStatement(Labels labels, Statement body) {
		return create(JavaScriptEntityDescriptorEnum.LabeledStatement, labels,
				body);
	}

	public IEntityBuilder<LabeledStatement> buildLabeledStatement() {
		return new EntityBuilder<LabeledStatement>(
				create(JavaScriptEntityDescriptorEnum.LabeledStatement));
	}

	public Labels createLabels() {
		return create(JavaScriptEntityDescriptorEnum.Labels);
	}

	public Labels createLabels(Label... entities) {
		return create(JavaScriptEntityDescriptorEnum.Labels,
				(IEntity[]) entities);
	}

	public Labels createLabels(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.Labels, initialSize);
	}

	public Label createLabel() {
		return create(JavaScriptEntityDescriptorEnum.Label);
	}

	public Label createLabel(Identifier name) {
		return create(JavaScriptEntityDescriptorEnum.Label, name);
	}

	public BreakStatement createBreakStatement() {
		return create(JavaScriptEntityDescriptorEnum.BreakStatement);
	}

	public BreakStatement createBreakStatement(Identifier target) {
		return create(JavaScriptEntityDescriptorEnum.BreakStatement, target);
	}

	public ContinueStatement createContinueStatement() {
		return create(JavaScriptEntityDescriptorEnum.ContinueStatement);
	}

	public ContinueStatement createContinueStatement(Identifier target) {
		return create(JavaScriptEntityDescriptorEnum.ContinueStatement, target);
	}

	public WithStatement createWithStatement() {
		return create(JavaScriptEntityDescriptorEnum.WithStatement);
	}

	public WithStatement createWithStatement(Expression object, Statement body) {
		return create(JavaScriptEntityDescriptorEnum.WithStatement, object,
				body);
	}

	public IEntityBuilder<WithStatement> buildWithStatement() {
		return new EntityBuilder<WithStatement>(
				create(JavaScriptEntityDescriptorEnum.WithStatement));
	}

	public SwitchStatement createSwitchStatement() {
		return create(JavaScriptEntityDescriptorEnum.SwitchStatement);
	}

	public SwitchStatement createSwitchStatement(Expression expression,
			SwitchCases cases) {
		return create(JavaScriptEntityDescriptorEnum.SwitchStatement,
				expression, cases);
	}

	public IEntityBuilder<SwitchStatement> buildSwitchStatement() {
		return new EntityBuilder<SwitchStatement>(
				create(JavaScriptEntityDescriptorEnum.SwitchStatement));
	}

	public SwitchCases createSwitchCases() {
		return create(JavaScriptEntityDescriptorEnum.SwitchCases);
	}

	public SwitchCases createSwitchCases(SwitchCase... entities) {
		return create(JavaScriptEntityDescriptorEnum.SwitchCases,
				(IEntity[]) entities);
	}

	public SwitchCases createSwitchCases(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.SwitchCases, initialSize);
	}

	public SwitchCase createSwitchCase() {
		return create(JavaScriptEntityDescriptorEnum.SwitchCase);
	}

	public SwitchCase createSwitchCase(Expression test, Statements statements) {
		return create(JavaScriptEntityDescriptorEnum.SwitchCase, test,
				statements);
	}

	public IEntityBuilder<SwitchCase> buildSwitchCase() {
		return new EntityBuilder<SwitchCase>(
				create(JavaScriptEntityDescriptorEnum.SwitchCase));
	}

	public ReturnStatement createReturnStatement() {
		return create(JavaScriptEntityDescriptorEnum.ReturnStatement);
	}

	public ReturnStatement createReturnStatement(Expression argument) {
		return create(JavaScriptEntityDescriptorEnum.ReturnStatement, argument);
	}

	public ThrowStatement createThrowStatement() {
		return create(JavaScriptEntityDescriptorEnum.ThrowStatement);
	}

	public ThrowStatement createThrowStatement(Expression argument) {
		return create(JavaScriptEntityDescriptorEnum.ThrowStatement, argument);
	}

	public TryStatement createTryStatement() {
		return create(JavaScriptEntityDescriptorEnum.TryStatement);
	}

	public TryStatement createTryStatement(Statements _try,
			CatchClauses handlers, Statements _finally) {
		return create(JavaScriptEntityDescriptorEnum.TryStatement, _try,
				handlers, _finally);
	}

	public IEntityBuilder<TryStatement> buildTryStatement() {
		return new EntityBuilder<TryStatement>(
				create(JavaScriptEntityDescriptorEnum.TryStatement));
	}

	public CatchClauses createCatchClauses() {
		return create(JavaScriptEntityDescriptorEnum.CatchClauses);
	}

	public CatchClauses createCatchClauses(CatchClause... entities) {
		return create(JavaScriptEntityDescriptorEnum.CatchClauses,
				(IEntity[]) entities);
	}

	public CatchClauses createCatchClauses(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.CatchClauses, initialSize);
	}

	public CatchClause createCatchClause() {
		return create(JavaScriptEntityDescriptorEnum.CatchClause);
	}

	public CatchClause createCatchClause(Expression param, Expression guard,
			Statements body) {
		return create(JavaScriptEntityDescriptorEnum.CatchClause, param, guard,
				body);
	}

	public IEntityBuilder<CatchClause> buildCatchClause() {
		return new EntityBuilder<CatchClause>(
				create(JavaScriptEntityDescriptorEnum.CatchClause));
	}

	public WhileStatement createWhileStatement() {
		return create(JavaScriptEntityDescriptorEnum.WhileStatement);
	}

	public WhileStatement createWhileStatement(Expression test, Statement body) {
		return create(JavaScriptEntityDescriptorEnum.WhileStatement, test, body);
	}

	public IEntityBuilder<WhileStatement> buildWhileStatement() {
		return new EntityBuilder<WhileStatement>(
				create(JavaScriptEntityDescriptorEnum.WhileStatement));
	}

	public DoWhileStatement createDoWhileStatement() {
		return create(JavaScriptEntityDescriptorEnum.DoWhileStatement);
	}

	public DoWhileStatement createDoWhileStatement(Statement body,
			Expression test) {
		return create(JavaScriptEntityDescriptorEnum.DoWhileStatement, body,
				test);
	}

	public IEntityBuilder<DoWhileStatement> buildDoWhileStatement() {
		return new EntityBuilder<DoWhileStatement>(
				create(JavaScriptEntityDescriptorEnum.DoWhileStatement));
	}

	public ForStatement createForStatement() {
		return create(JavaScriptEntityDescriptorEnum.ForStatement);
	}

	public ForStatement createForStatement(
			VariableDeclarationOrExpression init, Expression test,
			Expression update, Statement body) {
		return create(JavaScriptEntityDescriptorEnum.ForStatement, init, test,
				update, body);
	}

	public IEntityBuilder<ForStatement> buildForStatement() {
		return new EntityBuilder<ForStatement>(
				create(JavaScriptEntityDescriptorEnum.ForStatement));
	}

	public ForInStatement createForInStatement() {
		return create(JavaScriptEntityDescriptorEnum.ForInStatement);
	}

	public ForInStatement createForInStatement(
			VariableDeclarationOrExpression iterator, Expression iterated,
			Statement body) {
		return create(JavaScriptEntityDescriptorEnum.ForInStatement, iterator,
				iterated, body);
	}

	public IEntityBuilder<ForInStatement> buildForInStatement() {
		return new EntityBuilder<ForInStatement>(
				create(JavaScriptEntityDescriptorEnum.ForInStatement));
	}

	public ForEachStatement createForEachStatement() {
		return create(JavaScriptEntityDescriptorEnum.ForEachStatement);
	}

	public ForEachStatement createForEachStatement(
			VariableDeclarationOrExpression iterator, Expression iterated,
			Statement body) {
		return create(JavaScriptEntityDescriptorEnum.ForEachStatement,
				iterator, iterated, body);
	}

	public IEntityBuilder<ForEachStatement> buildForEachStatement() {
		return new EntityBuilder<ForEachStatement>(
				create(JavaScriptEntityDescriptorEnum.ForEachStatement));
	}

	public LetStatement createLetStatement() {
		return create(JavaScriptEntityDescriptorEnum.LetStatement);
	}

	public LetStatement createLetStatement(VariableInitializers variables,
			Statement body) {
		return create(JavaScriptEntityDescriptorEnum.LetStatement, variables,
				body);
	}

	public IEntityBuilder<LetStatement> buildLetStatement() {
		return new EntityBuilder<LetStatement>(
				create(JavaScriptEntityDescriptorEnum.LetStatement));
	}

	public VariableInitializers createVariableInitializers() {
		return create(JavaScriptEntityDescriptorEnum.VariableInitializers);
	}

	public VariableInitializers createVariableInitializers(
			VariableInitializer... entities) {
		return create(JavaScriptEntityDescriptorEnum.VariableInitializers,
				(IEntity[]) entities);
	}

	public VariableInitializers createVariableInitializers(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.VariableInitializers,
				initialSize);
	}

	public VariableInitializer createVariableInitializer() {
		return create(JavaScriptEntityDescriptorEnum.VariableInitializer);
	}

	public VariableInitializer createVariableInitializer(Expression id,
			Expression init) {
		return create(JavaScriptEntityDescriptorEnum.VariableInitializer, id,
				init);
	}

	public IEntityBuilder<VariableInitializer> buildVariableInitializer() {
		return new EntityBuilder<VariableInitializer>(
				create(JavaScriptEntityDescriptorEnum.VariableInitializer));
	}

	public FunctionDeclaration createFunctionDeclaration() {
		return create(JavaScriptEntityDescriptorEnum.FunctionDeclaration);
	}

	public FunctionDeclaration createFunctionDeclaration(Identifier id,
			Expressions params, FunctionBody body) {
		return create(JavaScriptEntityDescriptorEnum.FunctionDeclaration, id,
				params, body);
	}

	public IEntityBuilder<FunctionDeclaration> buildFunctionDeclaration() {
		return new EntityBuilder<FunctionDeclaration>(
				create(JavaScriptEntityDescriptorEnum.FunctionDeclaration));
	}

	public VariableDeclaration createVariableDeclaration() {
		return create(JavaScriptEntityDescriptorEnum.VariableDeclaration);
	}

	public VariableDeclaration createVariableDeclaration(
			VariableDeclarationKind kind, VariableInitializers variables) {
		return create(JavaScriptEntityDescriptorEnum.VariableDeclaration, kind,
				variables);
	}

	public IEntityBuilder<VariableDeclaration> buildVariableDeclaration() {
		return new EntityBuilder<VariableDeclaration>(
				create(JavaScriptEntityDescriptorEnum.VariableDeclaration));
	}

	public VariableDeclarationKind createVariableDeclarationKind() {
		return create(JavaScriptEntityDescriptorEnum.VariableDeclarationKind);
	}

	public VariableDeclarationKind createVariableDeclarationKind(
			VariableDeclarationKindEnum.Value value) {
		return create(JavaScriptEntityDescriptorEnum.VariableDeclarationKind,
				value);
	}

	public XmlAny createXmlAny() {
		return create(JavaScriptEntityDescriptorEnum.XmlAny);
	}

	public ComputedXmlRef createComputedXmlRef() {
		return create(JavaScriptEntityDescriptorEnum.ComputedXmlRef);
	}

	public ComputedXmlRef createComputedXmlRef(BooleanData attribute,
			IdentifierOrXmlAny namespace, Expression expression) {
		return create(JavaScriptEntityDescriptorEnum.ComputedXmlRef, attribute,
				namespace, expression);
	}

	public IEntityBuilder<ComputedXmlRef> buildComputedXmlRef() {
		return new EntityBuilder<ComputedXmlRef>(
				create(JavaScriptEntityDescriptorEnum.ComputedXmlRef));
	}

	public StaticXmlRef createStaticXmlRef() {
		return create(JavaScriptEntityDescriptorEnum.StaticXmlRef);
	}

	public StaticXmlRef createStaticXmlRef(BooleanData attribute,
			IdentifierOrXmlAny namespace, IdentifierOrXmlAny property) {
		return create(JavaScriptEntityDescriptorEnum.StaticXmlRef, attribute,
				namespace, property);
	}

	public IEntityBuilder<StaticXmlRef> buildStaticXmlRef() {
		return new EntityBuilder<StaticXmlRef>(
				create(JavaScriptEntityDescriptorEnum.StaticXmlRef));
	}

	public XmlMemberGet createXmlMemberGet() {
		return create(JavaScriptEntityDescriptorEnum.XmlMemberGet);
	}

	public XmlMemberGet createXmlMemberGet(Expression left,
			XmlMemberOperator operator, Expression right) {
		return create(JavaScriptEntityDescriptorEnum.XmlMemberGet, left,
				operator, right);
	}

	public IEntityBuilder<XmlMemberGet> buildXmlMemberGet() {
		return new EntityBuilder<XmlMemberGet>(
				create(JavaScriptEntityDescriptorEnum.XmlMemberGet));
	}

	public XmlDotQuery createXmlDotQuery() {
		return create(JavaScriptEntityDescriptorEnum.XmlDotQuery);
	}

	public XmlDotQuery createXmlDotQuery(Expression left, Expression right) {
		return create(JavaScriptEntityDescriptorEnum.XmlDotQuery, left, right);
	}

	public IEntityBuilder<XmlDotQuery> buildXmlDotQuery() {
		return new EntityBuilder<XmlDotQuery>(
				create(JavaScriptEntityDescriptorEnum.XmlDotQuery));
	}

	public XmlMemberOperator createXmlMemberOperator() {
		return create(JavaScriptEntityDescriptorEnum.XmlMemberOperator);
	}

	public XmlMemberOperator createXmlMemberOperator(
			XmlMemberOperatorEnum.Value value) {
		return create(JavaScriptEntityDescriptorEnum.XmlMemberOperator, value);
	}

	public XmlLiteral createXmlLiteral() {
		return create(JavaScriptEntityDescriptorEnum.XmlLiteral);
	}

	public XmlLiteral createXmlLiteral(XmlFragments fragments) {
		return create(JavaScriptEntityDescriptorEnum.XmlLiteral, fragments);
	}

	public XmlFragments createXmlFragments() {
		return create(JavaScriptEntityDescriptorEnum.XmlFragments);
	}

	public XmlFragments createXmlFragments(XmlFragment... entities) {
		return create(JavaScriptEntityDescriptorEnum.XmlFragments,
				(IEntity[]) entities);
	}

	public XmlFragments createXmlFragments(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.XmlFragments, initialSize);
	}

	public XmlString createXmlString() {
		return create(JavaScriptEntityDescriptorEnum.XmlString);
	}

	public XmlString createXmlString(StringData xml) {
		return create(JavaScriptEntityDescriptorEnum.XmlString, xml);
	}

	public XmlExpression createXmlExpression() {
		return create(JavaScriptEntityDescriptorEnum.XmlExpression);
	}

	public XmlExpression createXmlExpression(Expression expression) {
		return create(JavaScriptEntityDescriptorEnum.XmlExpression, expression);
	}

	public XmlDefaultNamespace createXmlDefaultNamespace() {
		return create(JavaScriptEntityDescriptorEnum.XmlDefaultNamespace);
	}

	public XmlDefaultNamespace createXmlDefaultNamespace(Expression operand) {
		return create(JavaScriptEntityDescriptorEnum.XmlDefaultNamespace,
				operand);
	}

	public FunctionExpression createFunctionExpression() {
		return create(JavaScriptEntityDescriptorEnum.FunctionExpression);
	}

	public FunctionExpression createFunctionExpression(Identifier id,
			Expressions params, FunctionBody body) {
		return create(JavaScriptEntityDescriptorEnum.FunctionExpression, id,
				params, body);
	}

	public IEntityBuilder<FunctionExpression> buildFunctionExpression() {
		return new EntityBuilder<FunctionExpression>(
				create(JavaScriptEntityDescriptorEnum.FunctionExpression));
	}

	public Expressions createExpressions() {
		return create(JavaScriptEntityDescriptorEnum.Expressions);
	}

	public Expressions createExpressions(Expression... entities) {
		return create(JavaScriptEntityDescriptorEnum.Expressions,
				(IEntity[]) entities);
	}

	public Expressions createExpressions(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.Expressions, initialSize);
	}

	public ParenthesizedExpression createParenthesizedExpression() {
		return create(JavaScriptEntityDescriptorEnum.ParenthesizedExpression);
	}

	public ParenthesizedExpression createParenthesizedExpression(
			Expression expression) {
		return create(JavaScriptEntityDescriptorEnum.ParenthesizedExpression,
				expression);
	}

	public PrefixExpression createPrefixExpression() {
		return create(JavaScriptEntityDescriptorEnum.PrefixExpression);
	}

	public PrefixExpression createPrefixExpression(PrefixOperator operator,
			Expression operand) {
		return create(JavaScriptEntityDescriptorEnum.PrefixExpression,
				operator, operand);
	}

	public IEntityBuilder<PrefixExpression> buildPrefixExpression() {
		return new EntityBuilder<PrefixExpression>(
				create(JavaScriptEntityDescriptorEnum.PrefixExpression));
	}

	public PostfixExpression createPostfixExpression() {
		return create(JavaScriptEntityDescriptorEnum.PostfixExpression);
	}

	public PostfixExpression createPostfixExpression(Expression operand,
			PostfixOperator operator) {
		return create(JavaScriptEntityDescriptorEnum.PostfixExpression,
				operand, operator);
	}

	public IEntityBuilder<PostfixExpression> buildPostfixExpression() {
		return new EntityBuilder<PostfixExpression>(
				create(JavaScriptEntityDescriptorEnum.PostfixExpression));
	}

	public PrefixOperator createPrefixOperator() {
		return create(JavaScriptEntityDescriptorEnum.PrefixOperator);
	}

	public PrefixOperator createPrefixOperator(PrefixOperatorEnum.Value value) {
		return create(JavaScriptEntityDescriptorEnum.PrefixOperator, value);
	}

	public PostfixOperator createPostfixOperator() {
		return create(JavaScriptEntityDescriptorEnum.PostfixOperator);
	}

	public PostfixOperator createPostfixOperator(PostfixOperatorEnum.Value value) {
		return create(JavaScriptEntityDescriptorEnum.PostfixOperator, value);
	}

	public InfixExpression createInfixExpression() {
		return create(JavaScriptEntityDescriptorEnum.InfixExpression);
	}

	public InfixExpression createInfixExpression(Expression left,
			InfixOperator operator, Expression right) {
		return create(JavaScriptEntityDescriptorEnum.InfixExpression, left,
				operator, right);
	}

	public IEntityBuilder<InfixExpression> buildInfixExpression() {
		return new EntityBuilder<InfixExpression>(
				create(JavaScriptEntityDescriptorEnum.InfixExpression));
	}

	public InfixOperator createInfixOperator() {
		return create(JavaScriptEntityDescriptorEnum.InfixOperator);
	}

	public InfixOperator createInfixOperator(InfixOperatorEnum.Value value) {
		return create(JavaScriptEntityDescriptorEnum.InfixOperator, value);
	}

	public AssignmentExpression createAssignmentExpression() {
		return create(JavaScriptEntityDescriptorEnum.AssignmentExpression);
	}

	public AssignmentExpression createAssignmentExpression(Expression left,
			AssignmentOperator operator, Expression right) {
		return create(JavaScriptEntityDescriptorEnum.AssignmentExpression,
				left, operator, right);
	}

	public IEntityBuilder<AssignmentExpression> buildAssignmentExpression() {
		return new EntityBuilder<AssignmentExpression>(
				create(JavaScriptEntityDescriptorEnum.AssignmentExpression));
	}

	public AssignmentOperator createAssignmentOperator() {
		return create(JavaScriptEntityDescriptorEnum.AssignmentOperator);
	}

	public AssignmentOperator createAssignmentOperator(
			AssignmentOperatorEnum.Value value) {
		return create(JavaScriptEntityDescriptorEnum.AssignmentOperator, value);
	}

	public ConditionalExpression createConditionalExpression() {
		return create(JavaScriptEntityDescriptorEnum.ConditionalExpression);
	}

	public ConditionalExpression createConditionalExpression(Expression test,
			Expression consequent, Expression alternate) {
		return create(JavaScriptEntityDescriptorEnum.ConditionalExpression,
				test, consequent, alternate);
	}

	public IEntityBuilder<ConditionalExpression> buildConditionalExpression() {
		return new EntityBuilder<ConditionalExpression>(
				create(JavaScriptEntityDescriptorEnum.ConditionalExpression));
	}

	public NewExpression createNewExpression() {
		return create(JavaScriptEntityDescriptorEnum.NewExpression);
	}

	public NewExpression createNewExpression(Expression constructor,
			Expressions arguments) {
		return create(JavaScriptEntityDescriptorEnum.NewExpression,
				constructor, arguments);
	}

	public IEntityBuilder<NewExpression> buildNewExpression() {
		return new EntityBuilder<NewExpression>(
				create(JavaScriptEntityDescriptorEnum.NewExpression));
	}

	public CallExpression createCallExpression() {
		return create(JavaScriptEntityDescriptorEnum.CallExpression);
	}

	public CallExpression createCallExpression(Expression callee,
			Expressions arguments) {
		return create(JavaScriptEntityDescriptorEnum.CallExpression, callee,
				arguments);
	}

	public IEntityBuilder<CallExpression> buildCallExpression() {
		return new EntityBuilder<CallExpression>(
				create(JavaScriptEntityDescriptorEnum.CallExpression));
	}

	public ComputedMemberExpression createComputedMemberExpression() {
		return create(JavaScriptEntityDescriptorEnum.ComputedMemberExpression);
	}

	public ComputedMemberExpression createComputedMemberExpression(
			Expression object, Expression expression) {
		return create(JavaScriptEntityDescriptorEnum.ComputedMemberExpression,
				object, expression);
	}

	public IEntityBuilder<ComputedMemberExpression> buildComputedMemberExpression() {
		return new EntityBuilder<ComputedMemberExpression>(
				create(JavaScriptEntityDescriptorEnum.ComputedMemberExpression));
	}

	public StaticMemberExpression createStaticMemberExpression() {
		return create(JavaScriptEntityDescriptorEnum.StaticMemberExpression);
	}

	public StaticMemberExpression createStaticMemberExpression(
			Expression object, IdentifierOrXmlAny property) {
		return create(JavaScriptEntityDescriptorEnum.StaticMemberExpression,
				object, property);
	}

	public IEntityBuilder<StaticMemberExpression> buildStaticMemberExpression() {
		return new EntityBuilder<StaticMemberExpression>(
				create(JavaScriptEntityDescriptorEnum.StaticMemberExpression));
	}

	public YieldExpression createYieldExpression() {
		return create(JavaScriptEntityDescriptorEnum.YieldExpression);
	}

	public YieldExpression createYieldExpression(Expression argument) {
		return create(JavaScriptEntityDescriptorEnum.YieldExpression, argument);
	}

	public ArrayComprehensionExpression createArrayComprehensionExpression() {
		return create(JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression);
	}

	public ArrayComprehensionExpression createArrayComprehensionExpression(
			Expression expression, ComprehensionBlocks blocks, Expression filter) {
		return create(
				JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression,
				expression, blocks, filter);
	}

	public IEntityBuilder<ArrayComprehensionExpression> buildArrayComprehensionExpression() {
		return new EntityBuilder<ArrayComprehensionExpression>(
				create(JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression));
	}

	public ComprehensionBlocks createComprehensionBlocks() {
		return create(JavaScriptEntityDescriptorEnum.ComprehensionBlocks);
	}

	public ComprehensionBlocks createComprehensionBlocks(
			ComprehensionBlock... entities) {
		return create(JavaScriptEntityDescriptorEnum.ComprehensionBlocks,
				(IEntity[]) entities);
	}

	public ComprehensionBlocks createComprehensionBlocks(int initialSize) {
		return clone(JavaScriptEntityDescriptorEnum.ComprehensionBlocks,
				initialSize);
	}

	public ForInComprehensionBlock createForInComprehensionBlock() {
		return create(JavaScriptEntityDescriptorEnum.ForInComprehensionBlock);
	}

	public ForInComprehensionBlock createForInComprehensionBlock(
			Expression iterator, Expression iterated) {
		return create(JavaScriptEntityDescriptorEnum.ForInComprehensionBlock,
				iterator, iterated);
	}

	public IEntityBuilder<ForInComprehensionBlock> buildForInComprehensionBlock() {
		return new EntityBuilder<ForInComprehensionBlock>(
				create(JavaScriptEntityDescriptorEnum.ForInComprehensionBlock));
	}

	public ForEachComprehensionBlock createForEachComprehensionBlock() {
		return create(JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock);
	}

	public ForEachComprehensionBlock createForEachComprehensionBlock(
			Expression iterator, Expression iterated) {
		return create(JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock,
				iterator, iterated);
	}

	public IEntityBuilder<ForEachComprehensionBlock> buildForEachComprehensionBlock() {
		return new EntityBuilder<ForEachComprehensionBlock>(
				create(JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock));
	}

	public LetExpression createLetExpression() {
		return create(JavaScriptEntityDescriptorEnum.LetExpression);
	}

	public LetExpression createLetExpression(VariableInitializers variables,
			Expression expression) {
		return create(JavaScriptEntityDescriptorEnum.LetExpression, variables,
				expression);
	}

	public IEntityBuilder<LetExpression> buildLetExpression() {
		return new EntityBuilder<LetExpression>(
				create(JavaScriptEntityDescriptorEnum.LetExpression));
	}

	public Identifier createIdentifier() {
		return create(JavaScriptEntityDescriptorEnum.Identifier);
	}

	public Identifier createIdentifier(String value) {
		return create(JavaScriptEntityDescriptorEnum.Identifier, value);
	}

	public NullLiteral createNullLiteral() {
		return create(JavaScriptEntityDescriptorEnum.NullLiteral);
	}

	public ThisLiteral createThisLiteral() {
		return create(JavaScriptEntityDescriptorEnum.ThisLiteral);
	}

	public StringLiteral createStringLiteral() {
		return create(JavaScriptEntityDescriptorEnum.StringLiteral);
	}

	public StringLiteral createStringLiteral(StringData value, StringData quote) {
		return create(JavaScriptEntityDescriptorEnum.StringLiteral, value,
				quote);
	}

	public IEntityBuilder<StringLiteral> buildStringLiteral() {
		return new EntityBuilder<StringLiteral>(
				create(JavaScriptEntityDescriptorEnum.StringLiteral));
	}

	public BooleanLiteral createBooleanLiteral() {
		return create(JavaScriptEntityDescriptorEnum.BooleanLiteral);
	}

	public BooleanLiteral createBooleanLiteral(boolean value) {
		return create(JavaScriptEntityDescriptorEnum.BooleanLiteral, value);
	}

	public NumberLiteral createNumberLiteral() {
		return create(JavaScriptEntityDescriptorEnum.NumberLiteral);
	}

	public NumberLiteral createNumberLiteral(double value) {
		return create(JavaScriptEntityDescriptorEnum.NumberLiteral, value);
	}

	public RegExpLiteral createRegExpLiteral() {
		return create(JavaScriptEntityDescriptorEnum.RegExpLiteral);
	}

	public RegExpLiteral createRegExpLiteral(StringData value, StringData flags) {
		return create(JavaScriptEntityDescriptorEnum.RegExpLiteral, value,
				flags);
	}

	public IEntityBuilder<RegExpLiteral> buildRegExpLiteral() {
		return new EntityBuilder<RegExpLiteral>(
				create(JavaScriptEntityDescriptorEnum.RegExpLiteral));
	}

	public BooleanData createBooleanData() {
		return create(JavaScriptEntityDescriptorEnum.BooleanData);
	}

	public BooleanData createBooleanData(boolean value) {
		return create(JavaScriptEntityDescriptorEnum.BooleanData, value);
	}

	public StringData createStringData() {
		return create(JavaScriptEntityDescriptorEnum.StringData);
	}

	public StringData createStringData(String value) {
		return create(JavaScriptEntityDescriptorEnum.StringData, value);
	}
}
