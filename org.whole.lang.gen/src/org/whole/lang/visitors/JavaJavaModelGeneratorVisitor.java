/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.visitors;

import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.JavaModelGenerator;
import org.whole.lang.java.model.*;
import org.whole.lang.java.parsers.JavaDataTypePersistenceParser;
import org.whole.lang.java.visitors.JavaIdentityVisitor;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class JavaJavaModelGeneratorVisitor extends JavaIdentityVisitor {
	private String name = "";

	private org.eclipse.jdt.core.dom.Type type;

	private org.eclipse.jdt.core.dom.VariableDeclarationFragment varDecFragment;

	public JavaModelGenerator getGenerator() {
		return ((JavaCompilerOperation) getOperation()).getGenerator();
	}

	public final CompilationUnitBuilder builder() {
		return getGenerator().getCurrentBuilder();
	}

	public org.eclipse.jdt.core.dom.Expression getExpression() {
		return builder().exp;
	}

	public org.eclipse.jdt.core.dom.Expression setExpression(
			org.eclipse.jdt.core.dom.Expression exp) {
		return builder().exp = exp;
	}

	public org.eclipse.jdt.core.dom.Statement getStatement() {
		return builder().stm;
	}

	public org.eclipse.jdt.core.dom.Statement setStatement(
			org.eclipse.jdt.core.dom.Statement stm) {
		return builder().stm = stm;
	}

	public final org.eclipse.jdt.core.dom.Name astOf(Name n) {
		n.accept(this);
		return (org.eclipse.jdt.core.dom.Name) getExpression();
	}

	public final org.eclipse.jdt.core.dom.Type astOf(Type t) {
		t.accept(this);
		return type;
	}

	public final org.eclipse.jdt.core.dom.VariableDeclarationFragment astOf(
			VariableDeclarationFragment f) {
		f.accept(this);
		return varDecFragment;
	}

	private final org.eclipse.jdt.core.dom.Expression astOf(Expression e) {
		e.accept(this);
		return getExpression();
	}

	private final org.eclipse.jdt.core.dom.Statement astOf(Statement s) {
		s.accept(this);
		return getStatement();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.InstanceofExpression)
	 */
	public void visit(InstanceofExpression entity) {
		// TODO Auto-generated method stub

	}

	public void visit(IfStatement entity) {
		setStatement(builder().newIfStatement(astOf(entity.getExpression()),
				astOf(entity.getThenStatement()),
				astOf(entity.getElseStatement())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ArrayType)
	 */
	public void visit(ArrayType entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.SwitchCase)
	 */
	public void visit(SwitchCase entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TypeParameter)
	 */
	public void visit(TypeParameter entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ContinueStatement)
	 */
	public void visit(ContinueStatement entity) {
		// TODO Auto-generated method stub

	}

	public void visit(VariableDeclarationFragment entity) {
		entity.getName().accept(this);
		String varName = name;
		builder().exp = null;
		entity.getInitializer().accept(this);
		varDecFragment = builder().newVariableDeclarationFragment(varName,
				getExpression());
	}

	public void visit(FieldDeclaration entity) {
		VariableDeclarationFragments fragments = entity.getFragments();
		if (fragments.wSize() == 0)
			throw new IllegalArgumentException(
					"empty IVariableDeclarationFragments");
		org.eclipse.jdt.core.dom.FieldDeclaration fieldDec = builder()
				.newFieldDeclaration(astOf(entity.getType()),
						astOf((VariableDeclarationFragment) fragments.wGet(0)));
		for (int i = 1; i < fragments.wSize(); i++) {
			fieldDec.fragments().add(
					astOf((VariableDeclarationFragment) fragments.wGet(i)));
		}

		builder().addBodyDeclaration(fieldDec);
	}

	public void visit(VariableDeclarationFragments entity) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.NormalAnnotation_Values)
	 */
	public void visit(MemberValuePairs entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.NormalAnnotation)
	 */
	public void visit(NormalAnnotation entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TextElement)
	 */
	public void visit(TextElement entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.AnnotationTypeMemberDeclaration)
	 */
	public void visit(AnnotationTypeMemberDeclaration entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.SynchronizedStatement)
	 */
	public void visit(SynchronizedStatement entity) {
		// TODO Auto-generated method stub

	}

	public void visit(ByteLiteral entity) {
		setExpression(builder().newNumberLiteral(JavaDataTypePersistenceParser.instance().unparseByte(entity.wGetEntityDescriptor(), entity.getValue())));
	}

	public void visit(FloatLiteral entity) {
		setExpression(builder().newNumberLiteral(JavaDataTypePersistenceParser.instance().unparseFloat(entity.wGetEntityDescriptor(), entity.getValue())));
	}

	public void visit(DoubleLiteral entity) {
		setExpression(builder().newNumberLiteral(JavaDataTypePersistenceParser.instance().unparseDouble(entity.wGetEntityDescriptor(), entity.getValue())));
	}

	public void visit(IntLiteral entity) {
		setExpression(builder().newNumberLiteral(JavaDataTypePersistenceParser.instance().unparseInt(entity.wGetEntityDescriptor(), entity.getValue())));
	}

	public void visit(LongLiteral entity) {
		setExpression(builder().newNumberLiteral(JavaDataTypePersistenceParser.instance().unparseLong(entity.wGetEntityDescriptor(), entity.getValue())));
	}

	public void visit(ShortLiteral entity) {
		setExpression(builder().newNumberLiteral(JavaDataTypePersistenceParser.instance().unparseShort(entity.wGetEntityDescriptor(), entity.getValue())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.PrefixExpression_Operator)
	 */
	public void visit(PrefixOperator entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.PrefixExpression)
	 */
	public void visit(PrefixExpression entity) {
		// TODO Auto-generated method stub

	}

	public void visit(StringLiteral entity) {
		setExpression(builder().newLiteral(entity.getValue()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ParameterizedType)
	 */
	public void visit(ParameterizedType entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.SuperConstructorInvocation_Arguments)
	 */
	public void visit(Arguments entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.SuperConstructorInvocation)
	 */
	public void visit(SuperConstructorInvocation entity) {
		// TODO Auto-generated method stub

	}

	public void visit(ExpressionStatement entity) {
		setStatement(builder().newExpressionStatement(
				astOf(entity.getExpression())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.Javadoc_Tags)
	 */
	public void visit(Tags entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.Javadoc)
	 */
	public void visit(Javadoc entity) {
		// TODO Auto-generated method stub

	}

	public void visit(NullLiteral entity) {
		setExpression(builder().newNullLiteral());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.MethodRef)
	 */
	public void visit(MethodRef entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.MethodDeclaration_TypeParameters)
	 */
	public void visit(TypeParameters entity) {
		// TODO Auto-generated method stub

	}

	public void visit(MethodDeclaration entity) {
		org.eclipse.jdt.core.dom.MethodDeclaration method;
		builder().addBodyDeclaration(
				method = builder().newMethodDeclaration(
						astOf(entity.getReturnType()),
						((SimpleName) entity.getName()).wStringValue()));
		entity.getParameters().accept(this);
		method
				.setBody((org.eclipse.jdt.core.dom.Block) astOf((Statement) entity
						.getBody()));
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((SingleVariableDeclaration) entity.wGet(i)).accept(this);
	}

	public void visit(SingleVariableDeclaration entity) {
		builder().addParameter(
				builder().newSingleVariableDeclaration(astOf(entity.getType()),
						((SimpleName) entity.getName()).wStringValue()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.MemberRef)
	 */
	public void visit(MemberRef entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ThrowStatement)
	 */
	public void visit(ThrowStatement entity) {
		// TODO Auto-generated method stub

	}

	public void visit(ClassDeclaration entity) {
		entity.getName().accept(this);
		builder().addClassDeclaration(name);
		if (!EntityUtils.isResolver(entity.getSuperclassType())) {
			entity.getSuperclassType().accept(this);
			builder().setSuperclass(name);
		}
		entity.getSuperInterfaceTypes().accept(this);
		entity.getBodyDeclarations().accept(this);
	}

	public void visit(Types entity) {
		name = null;
		for (int i = 0; i < entity.wSize(); i++) {
			((Type) entity.wGet(i)).accept(this);
			if (name != null)
				builder().addSuperInterface(name);
		}
	}

	public void visit(BodyDeclarations entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((BodyDeclaration) entity.wGet(i)).accept(this);
	}

	public void visit(PrimitiveType entity) {
		type = builder().newType(entity.wStringValue());
	}

	public void visit(TypeLiteral entity) {
		entity.getType().accept(this);
		setExpression(builder().newTypeLiteral(name));
	}

	public void visit(CharLiteral entity) {
		setExpression(builder().newLiteral(entity.getValue()));
	}

	public void visit(MethodInvocation entity) {
		org.eclipse.jdt.core.dom.MethodInvocation callExp =
				EntityUtils.isResolver(entity.getExpression()) ? builder()
				.newMethodInvocation(
						((SimpleName) entity.getName()).wStringValue())
				: builder().newMethodInvocation(astOf(entity.getExpression()),
						((SimpleName) entity.getName()).wStringValue());

		Arguments arguments = entity.getArguments();
		for (int i = 0; i < arguments.wSize(); i++) {
			Expression e = (Expression) arguments.wGet(i);
			if (!EntityUtils.isResolver(e))
				callExp.arguments().add(astOf(e));
		}
		setExpression(callExp);
	}

	public void visit(FieldAccess entity) {
		setExpression(builder().newFieldAccess(astOf(entity.getExpression()),
				((SimpleName) entity.getName()).wStringValue()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ArrayInitializer)
	 */
	public void visit(ArrayInitializer entity) {
		// TODO Auto-generated method stub

	}

	private int inQualifiedName = 0;

	public void visit(QualifiedName entity) {
		setExpression(builder().newSimpleName(entity.wStringValue()));
	}

	public void visit(SimpleName entity) {
		name = entity.wStringValue();
		if (inQualifiedName == 0)
			setExpression(builder().newSimpleName(name));
	}

	public void visit(WhileStatement entity) {
		setStatement(builder().newWhileStatement(astOf(entity.getExpression()),
				astOf(entity.getBody())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.LabeledStatement)
	 */
	public void visit(LabeledStatement entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TryStatement_CatchClauses)
	 */
	public void visit(CatchClauses entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TryStatement)
	 */
	public void visit(TryStatement entity) {
		// TODO Auto-generated method stub

	}

	public void visit(Assignment entity) {
		setExpression(builder()
				.newAssignment(
						astOf(entity.getLeftHandSide()),
						JavaDataTypePersistenceParser.unparseAssignmentOperator(entity.getOperator()
						.wEnumValue()),
						astOf(entity.getRightHandSide())));
	}

	public void visit(BooleanLiteral entity) {
		setExpression(builder().newLiteral(entity.wBooleanValue()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.WildcardType)
	 */
	public void visit(WildcardType entity) {
		// TODO Auto-generated method stub

	}

	public void visit(SuperFieldAccess entity) {
		setExpression(builder().newSuperFieldAccess(
				((SimpleName) entity.getName()).wStringValue()));
	}

	public void visit(VariableDeclarationStatement entity) {
		VariableDeclarationFragments fragments = entity.getFragments();
		if (fragments.wSize() == 0)
			throw new IllegalArgumentException(
					"empty IVariableDeclarationFragments");
		org.eclipse.jdt.core.dom.VariableDeclarationStatement varDec = builder()
				.newVariableDeclarationStatement(astOf(entity.getType()),
						astOf((VariableDeclarationFragment) fragments.wGet(0)));
		for (int i = 1; i < fragments.wSize(); i++) {
			varDec.fragments().add(
					astOf((VariableDeclarationFragment) fragments.wGet(i)));
		}
		setStatement(varDec);
	}

	public void visit(VariableDeclarationExpression entity) {
		VariableDeclarationFragments fragments = entity.getFragments();
		if (fragments.wSize() == 0)
			throw new IllegalArgumentException(
					"empty IVariableDeclarationFragments");
		org.eclipse.jdt.core.dom.VariableDeclarationExpression varDec = builder()
				.newVariableDeclarationExpression(astOf(entity.getType()),
						astOf((VariableDeclarationFragment) fragments.wGet(0)));
		for (int i = 1; i < fragments.wSize(); i++) {
			varDec.fragments().add(
					astOf((VariableDeclarationFragment) fragments.wGet(i)));
		}
		setExpression(varDec);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.MemberValuePair)
	 */
	public void visit(MemberValuePair entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.AnnotationTypeDeclaration)
	 */
	public void visit(AnnotationTypeDeclaration entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ConstructorInvocation)
	 */
	public void visit(ConstructorInvocation entity) {
		// TODO Auto-generated method stub

	}

	public void visit(DoStatement entity) {
		setStatement(builder().newDoStatement(astOf(entity.getExpression()),
				astOf(entity.getBody())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.QualifiedType)
	 */
	public void visit(QualifiedType entity) {
		type = builder().newQualifiedType(entity.wStringValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.AssertStatement)
	 */
	public void visit(AssertStatement entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.MethodRefParameter)
	 */
	public void visit(MethodRefParameter entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.CastExpression)
	 */
	public void visit(CastExpression entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.EnumDeclaration)
	 */
	public void visit(EnumDeclaration entity) {
		// TODO Auto-generated method stub

	}

	public void visit(ReturnStatement entity) {
		setStatement(builder()
				.newReturnStatement(astOf(entity.getExpression())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.EnhancedForStatement)
	 */
	public void visit(EnhancedForStatement entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.CatchClause)
	 */
	public void visit(CatchClause entity) {
		// TODO Auto-generated method stub

	}

	public void visit(SimpleType entity) {
		type = builder().newType(entity.wStringValue());
	}

	public void visit(Expressions entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ArrayCreation)
	 */
	public void visit(ArrayCreation entity) {
		// TODO Auto-generated method stub

	}

	public void visit(ParenthesizedExpression entity) {
		setExpression(builder().newParenthesizedExpression(
				astOf(entity.getExpression())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.Modifier)
	 */
	public void visit(Modifier entity) {
		// TODO Auto-generated method stub

	}

	public void visit(ImportDeclaration entity) {
		entity.getName().accept(this);
		builder().addImportDeclaration(name);
	}

	public void visit(ThisExpression entity) {
		org.eclipse.jdt.core.dom.ThisExpression exp = builder().ast
				.newThisExpression();
		if (!EntityUtils.isResolver(entity.getQualifier()))
			exp.setQualifier(astOf(entity.getQualifier()));
		setExpression(exp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TypeDeclarationStatement)
	 */
	public void visit(TypeDeclarationStatement entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TagElement_Fragments)
	 */
	public void visit(DocElements entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TagElement_TagName)
	 */
	public void visit(TagName entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.TagElement)
	 */
	public void visit(TagElement entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ClassInstanceCreation)
	 */
	public void visit(ClassInstanceCreation entity) {
		// TODO Auto-generated method stub

	}

	public void visit(PackageDeclaration entity) {
		inQualifiedName++;
		entity.getName().accept(this);
		inQualifiedName--;
		builder().putPackageDeclaration(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ArrayAccess)
	 */
	public void visit(ArrayAccess entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.BlockComment)
	 */
	public void visit(BlockComment entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.EnumConstantDeclaration)
	 */
	public void visit(EnumConstantDeclaration entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.LineComment)
	 */
	public void visit(LineComment entity) {
		// TODO Auto-generated method stub

	}

	public void visit(InfixExpression entity) {
		org.eclipse.jdt.core.dom.Expression left = astOf(entity
				.getLeftOperand());
		org.eclipse.jdt.core.dom.Expression right = astOf(entity
				.getRightOperand());
		setExpression(builder().newInfixExpression(left,
				JavaDataTypePersistenceParser.unparseInfixOperator(entity.getOperator().wEnumValue()),
				right));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.BreakStatement)
	 */
	public void visit(BreakStatement entity) {
		// TODO Auto-generated method stub

	}

	public void visit(SuperMethodInvocation entity) {
		org.eclipse.jdt.core.dom.SuperMethodInvocation callExp = builder()
				.newSuperMethodInvocation(
						((SimpleName) entity.getName()).wStringValue());

		Arguments arguments = entity.getArguments();
		for (int i = 0; i < arguments.wSize(); i++)
			callExp.arguments().add(astOf((Expression) arguments.wGet(i)));
		setExpression(callExp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.AnonymousClassDeclaration)
	 */
	public void visit(AnonymousClassDeclaration entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.MarkerAnnotation)
	 */
	public void visit(MarkerAnnotation entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.SwitchStatement_Statements)
	 */
	public void visit(Statements entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.SwitchStatement)
	 */
	public void visit(SwitchStatement entity) {
		// TODO Auto-generated method stub

	}

	public void visit(Block entity) {
		org.eclipse.jdt.core.dom.Block body = builder().newBlock();
		for (int i = 0; i < entity.wSize(); i++) {
			body.statements().add(astOf((Statement) entity.wGet(i)));
		}
		setStatement(body);
	}

	public void visit(PostfixExpression entity) {
		setExpression(builder().newPostfixExpression(
				astOf(entity.getOperand()),
				JavaDataTypePersistenceParser.unparsePostfixOperator(entity.getOperator().wEnumValue())));
	}

	public void visit(Initializer entity) {
		builder()
				.addBodyDeclaration(
						builder()
								.newInitializer(
										(org.eclipse.jdt.core.dom.Block) astOf((Statement) entity
												.getBody())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.SingleMemberAnnotation)
	 */
	public void visit(SingleMemberAnnotation entity) {
		// TODO Auto-generated method stub

	}

	public void visit(ForStatement entity) {
		org.eclipse.jdt.core.dom.ForStatement forStm = builder()
				.newForStatement(astOf(entity.getExpression()),
						astOf(entity.getBody()));

		Expressions inits = entity.getInitializers();
		for (int i = 0; i < inits.wSize(); i++)
			forStm.initializers().add(astOf((Expression) inits.wGet(i)));

		Expressions upds = entity.getUpdaters();
		for (int i = 0; i < upds.wSize(); i++)
			forStm.updaters().add(astOf((Expression) upds.wGet(i)));

		setStatement(forStm);
	}

	public void visit(TypeDeclarations entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((TypeDeclaration) entity.wGet(i)).accept(this);
	}

	public void visit(ImportDeclarations entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((ImportDeclaration) entity.wGet(i)).accept(this);
	}

	public void visit(CompilationUnit entity) {
		entity.getPackage().accept(this);
		entity.getImports().accept(this);
		entity.getTypes().accept(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.whole.lang.java.model.IJavaVisitor#visit(org.whole.lang.java.model.impl.ConditionalExpression)
	 */
	public void visit(ConditionalExpression entity) {
		// TODO Auto-generated method stub

	}

	public void visit(JavaSystemSoftware entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			((CompilationUnit) entity.wGet(i)).accept(this);
			getGenerator().setCurrentBuilder(null);
		}
	}
}
