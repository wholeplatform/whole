/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.java.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.java.model.PrimitiveTypeEnum;
import org.whole.lang.java.model.AssignmentOperatorEnum;
import org.whole.lang.java.model.InfixOperatorEnum;
import org.whole.lang.java.model.PostfixOperatorEnum;
import org.whole.lang.java.model.PrefixOperatorEnum;
import org.whole.lang.java.model.ModifierEnum;

/**
 *  @generator Whole
 */
public interface IJavaBuilder extends IBuilder {


    public void visit();

    public void operand();

    public void extendedOperands();

    public void rightOperand();

    public void leftOperand();

    public void elseExpression();

    public void thenExpression();

    public void rightHandSide();

    public void operator();

    public void leftHandSide();

    public void dimensions();

    public void index();

    public void array();

    public void typeDeclaration();

    public void exception();

    public void _finally();

    public void catchClauses();

    public void statements();

    public void elseStatement();

    public void thenStatement();

    public void updaters();

    public void initializers();

    public void parameter();

    public void label();

    public void message();

    public void expression();

    public void upperBound();

    public void bound();

    public void typeArguments();

    public void componentType();

    public void varargsAnnotations();

    public void initializer();

    public void thrownExceptions();

    public void extraDimensions();

    public void returnType();

    public void body();

    public void _default();

    public void typeBounds();

    public void superclassType();

    public void typeParameters();

    public void anonymousClassDeclaration();

    public void arguments();

    public void enumConstants();

    public void superInterfaceTypes();

    public void bodyDeclarations();

    public void modifiers();

    public void _static();

    public void onDemand();

    public void values();

    public void value();

    public void typeName();

    public void fragments();

    public void tagName();

    public void varargs();

    public void type();

    public void parameters();

    public void qualifier();

    public void tags();

    public void text();

    public void docElements();

    public void name();

    public void annotations();

    public void javadoc();

    public void types();

    public void imports();

    public void _package();

    public void JavaSystemSoftware();

    public void JavaSystemSoftware_();

    public void JavaSystemSoftware_(int initialCapacity);

    public void _JavaSystemSoftware();

    public void CompilationUnit();

    public void CompilationUnit_();

    public void _CompilationUnit();

    public void PackageDeclaration();

    public void PackageDeclaration_();

    public void _PackageDeclaration();

    public void BlockComment();

    public void BlockComment_();

    public void _BlockComment();

    public void LineComment();

    public void LineComment_();

    public void _LineComment();

    public void Javadoc();

    public void Javadoc_();

    public void _Javadoc();

    public void Tags();

    public void Tags_();

    public void Tags_(int initialCapacity);

    public void _Tags();

    public void DocElements();

    public void DocElements_();

    public void DocElements_(int initialCapacity);

    public void _DocElements();

    public void MethodRef();

    public void MethodRef_();

    public void _MethodRef();

    public void MethodRefParameters();

    public void MethodRefParameters_();

    public void MethodRefParameters_(int initialCapacity);

    public void _MethodRefParameters();

    public void MethodRefParameter();

    public void MethodRefParameter_();

    public void _MethodRefParameter();

    public void MemberRef();

    public void MemberRef_();

    public void _MemberRef();

    public void TextElement();

    public void TextElement(String value);

    public void TagElement();

    public void TagElement_();

    public void _TagElement();

    public void TagName();

    public void TagName(String value);

    public void Annotations();

    public void Annotations_();

    public void Annotations_(int initialCapacity);

    public void _Annotations();

    public void SingleMemberAnnotation();

    public void SingleMemberAnnotation_();

    public void _SingleMemberAnnotation();

    public void MarkerAnnotation();

    public void MarkerAnnotation_();

    public void _MarkerAnnotation();

    public void NormalAnnotation();

    public void NormalAnnotation_();

    public void _NormalAnnotation();

    public void MemberValuePairs();

    public void MemberValuePairs_();

    public void MemberValuePairs_(int initialCapacity);

    public void _MemberValuePairs();

    public void MemberValuePair();

    public void MemberValuePair_();

    public void _MemberValuePair();

    public void ImportDeclarations();

    public void ImportDeclarations_();

    public void ImportDeclarations_(int initialCapacity);

    public void _ImportDeclarations();

    public void ImportDeclaration();

    public void ImportDeclaration_();

    public void _ImportDeclaration();

    public void ImportModifier();

    public void ImportModifier(boolean value);

    public void TypeDeclarations();

    public void TypeDeclarations_();

    public void TypeDeclarations_(int initialCapacity);

    public void _TypeDeclarations();

    public void EnumDeclaration();

    public void EnumDeclaration_();

    public void _EnumDeclaration();

    public void EnumConstants();

    public void EnumConstants_();

    public void EnumConstants_(int initialCapacity);

    public void _EnumConstants();

    public void EnumConstantDeclaration();

    public void EnumConstantDeclaration_();

    public void _EnumConstantDeclaration();

    public void Arguments();

    public void Arguments_();

    public void Arguments_(int initialCapacity);

    public void _Arguments();

    public void AnonymousClassDeclaration();

    public void AnonymousClassDeclaration_();

    public void AnonymousClassDeclaration_(int initialCapacity);

    public void _AnonymousClassDeclaration();

    public void AnnotationTypeDeclaration();

    public void AnnotationTypeDeclaration_();

    public void _AnnotationTypeDeclaration();

    public void ClassDeclaration();

    public void ClassDeclaration_();

    public void _ClassDeclaration();

    public void InterfaceDeclaration();

    public void InterfaceDeclaration_();

    public void _InterfaceDeclaration();

    public void TypeParameters();

    public void TypeParameters_();

    public void TypeParameters_(int initialCapacity);

    public void _TypeParameters();

    public void TypeParameter();

    public void TypeParameter_();

    public void _TypeParameter();

    public void Types();

    public void Types_();

    public void Types_(int initialCapacity);

    public void _Types();

    public void BodyDeclarations();

    public void BodyDeclarations_();

    public void BodyDeclarations_(int initialCapacity);

    public void _BodyDeclarations();

    public void AnnotationTypeMemberDeclaration();

    public void AnnotationTypeMemberDeclaration_();

    public void _AnnotationTypeMemberDeclaration();

    public void Initializer();

    public void Initializer_();

    public void _Initializer();

    public void FieldDeclaration();

    public void FieldDeclaration_();

    public void _FieldDeclaration();

    public void MethodDeclaration();

    public void MethodDeclaration_();

    public void _MethodDeclaration();

    public void ConstructorDeclaration();

    public void ConstructorDeclaration_();

    public void _ConstructorDeclaration();

    public void Parameters();

    public void Parameters_();

    public void Parameters_(int initialCapacity);

    public void _Parameters();

    public void SingleVariableDeclaration();

    public void SingleVariableDeclaration_();

    public void _SingleVariableDeclaration();

    public void Varargs();

    public void Varargs(boolean value);

    public void AnnotatedType();

    public void AnnotatedType_();

    public void _AnnotatedType();

    public void ArrayType();

    public void ArrayType_();

    public void _ArrayType();

    public void ParameterizedType();

    public void ParameterizedType_();

    public void _ParameterizedType();

    public void PrimitiveType();

    public void PrimitiveType(PrimitiveTypeEnum.Value value);

    public void PrimitiveType(String value);

    public void QualifiedType();

    public void QualifiedType(String value);

    public void SimpleType();

    public void SimpleType(String value);

    public void WildcardType();

    public void WildcardType_();

    public void _WildcardType();

    public void UnionType();

    public void UnionType_();

    public void UnionType_(int initialCapacity);

    public void _UnionType();

    public void IntersectionType();

    public void IntersectionType_();

    public void IntersectionType_(int initialCapacity);

    public void _IntersectionType();

    public void UpperBound();

    public void UpperBound(boolean value);

    public void AssertStatement();

    public void AssertStatement_();

    public void _AssertStatement();

    public void Block();

    public void Block_();

    public void Block_(int initialCapacity);

    public void _Block();

    public void BreakStatement();

    public void BreakStatement_();

    public void _BreakStatement();

    public void ConstructorInvocation();

    public void ConstructorInvocation_();

    public void _ConstructorInvocation();

    public void ContinueStatement();

    public void ContinueStatement_();

    public void _ContinueStatement();

    public void DoStatement();

    public void DoStatement_();

    public void _DoStatement();

    public void EmptyStatement();

    public void EmptyStatement_();

    public void _EmptyStatement();

    public void EnhancedForStatement();

    public void EnhancedForStatement_();

    public void _EnhancedForStatement();

    public void ExpressionStatement();

    public void ExpressionStatement_();

    public void _ExpressionStatement();

    public void ForStatement();

    public void ForStatement_();

    public void _ForStatement();

    public void Expressions();

    public void Expressions_();

    public void Expressions_(int initialCapacity);

    public void _Expressions();

    public void IfStatement();

    public void IfStatement_();

    public void _IfStatement();

    public void LabeledStatement();

    public void LabeledStatement_();

    public void _LabeledStatement();

    public void ReturnStatement();

    public void ReturnStatement_();

    public void _ReturnStatement();

    public void SuperConstructorInvocation();

    public void SuperConstructorInvocation_();

    public void _SuperConstructorInvocation();

    public void SwitchCase();

    public void SwitchCase_();

    public void _SwitchCase();

    public void SwitchDefault();

    public void SwitchDefault_();

    public void _SwitchDefault();

    public void SwitchStatement();

    public void SwitchStatement_();

    public void _SwitchStatement();

    public void Statements();

    public void Statements_();

    public void Statements_(int initialCapacity);

    public void _Statements();

    public void SynchronizedStatement();

    public void SynchronizedStatement_();

    public void _SynchronizedStatement();

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

    public void TypeDeclarationStatement();

    public void TypeDeclarationStatement_();

    public void _TypeDeclarationStatement();

    public void VariableDeclarationStatement();

    public void VariableDeclarationStatement_();

    public void _VariableDeclarationStatement();

    public void WhileStatement();

    public void WhileStatement_();

    public void _WhileStatement();

    public void SimpleName();

    public void SimpleName(String value);

    public void QualifiedName();

    public void QualifiedName(String value);

    public void NullLiteral();

    public void NullLiteral_();

    public void _NullLiteral();

    public void BooleanLiteral();

    public void BooleanLiteral(boolean value);

    public void ByteLiteral();

    public void ByteLiteral(byte value);

    public void CharLiteral();

    public void CharLiteral(char value);

    public void DoubleLiteral();

    public void DoubleLiteral(double value);

    public void FloatLiteral();

    public void FloatLiteral(float value);

    public void IntLiteral();

    public void IntLiteral(int value);

    public void ShortLiteral();

    public void ShortLiteral(short value);

    public void LongLiteral();

    public void LongLiteral(long value);

    public void StringLiteral();

    public void StringLiteral(String value);

    public void TypeLiteral();

    public void TypeLiteral_();

    public void _TypeLiteral();

    public void ArrayAccess();

    public void ArrayAccess_();

    public void _ArrayAccess();

    public void ArrayCreation();

    public void ArrayCreation_();

    public void _ArrayCreation();

    public void ArrayInitializer();

    public void ArrayInitializer_();

    public void ArrayInitializer_(int initialCapacity);

    public void _ArrayInitializer();

    public void Assignment();

    public void Assignment_();

    public void _Assignment();

    public void AssignmentOperator();

    public void AssignmentOperator(AssignmentOperatorEnum.Value value);

    public void AssignmentOperator(String value);

    public void CastExpression();

    public void CastExpression_();

    public void _CastExpression();

    public void ClassInstanceCreation();

    public void ClassInstanceCreation_();

    public void _ClassInstanceCreation();

    public void ConditionalExpression();

    public void ConditionalExpression_();

    public void _ConditionalExpression();

    public void FieldAccess();

    public void FieldAccess_();

    public void _FieldAccess();

    public void InfixExpression();

    public void InfixExpression_();

    public void _InfixExpression();

    public void InfixOperator();

    public void InfixOperator(InfixOperatorEnum.Value value);

    public void InfixOperator(String value);

    public void InstanceofExpression();

    public void InstanceofExpression_();

    public void _InstanceofExpression();

    public void LambdaExpression();

    public void LambdaExpression_();

    public void _LambdaExpression();

    public void MethodInvocation();

    public void MethodInvocation_();

    public void _MethodInvocation();

    public void ParenthesizedExpression();

    public void ParenthesizedExpression_();

    public void _ParenthesizedExpression();

    public void PostfixExpression();

    public void PostfixExpression_();

    public void _PostfixExpression();

    public void PostfixOperator();

    public void PostfixOperator(PostfixOperatorEnum.Value value);

    public void PostfixOperator(String value);

    public void PrefixExpression();

    public void PrefixExpression_();

    public void _PrefixExpression();

    public void PrefixOperator();

    public void PrefixOperator(PrefixOperatorEnum.Value value);

    public void PrefixOperator(String value);

    public void SuperFieldAccess();

    public void SuperFieldAccess_();

    public void _SuperFieldAccess();

    public void SuperMethodInvocation();

    public void SuperMethodInvocation_();

    public void _SuperMethodInvocation();

    public void ThisExpression();

    public void ThisExpression_();

    public void _ThisExpression();

    public void VariableDeclarationExpression();

    public void VariableDeclarationExpression_();

    public void _VariableDeclarationExpression();

    public void VariableDeclarationFragments();

    public void VariableDeclarationFragments_();

    public void VariableDeclarationFragments_(int initialCapacity);

    public void _VariableDeclarationFragments();

    public void VariableDeclarationFragment();

    public void VariableDeclarationFragment_();

    public void _VariableDeclarationFragment();

    public void ExtraDimensions();

    public void ExtraDimensions(int value);

    public void ExtendedModifiers();

    public void ExtendedModifiers_();

    public void ExtendedModifiers_(int initialCapacity);

    public void _ExtendedModifiers();

    public void Modifier();

    public void Modifier(ModifierEnum.Value value);

    public void Modifier(String value);

    public void ConstructorReference();

    public void ConstructorReference_();

    public void _ConstructorReference();

    public void ExpressionMethodReference();

    public void ExpressionMethodReference_();

    public void _ExpressionMethodReference();

    public void SuperMethodReference();

    public void SuperMethodReference_();

    public void _SuperMethodReference();

    public void TypeMethodReference();

    public void TypeMethodReference_();

    public void _TypeMethodReference();
}
