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
package org.whole.lang.java.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class JavaIdentitySwitchVisitor extends AbstractVisitor implements IJavaVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case JavaEntityDescriptorEnum.JavaSystemSoftware_ord :
            visit((JavaSystemSoftware) entity);
            break;
            case JavaEntityDescriptorEnum.CompilationUnit_ord :
            visit((CompilationUnit) entity);
            break;
            case JavaEntityDescriptorEnum.PackageDeclaration_ord :
            visit((PackageDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.BlockComment_ord :
            visit((BlockComment) entity);
            break;
            case JavaEntityDescriptorEnum.LineComment_ord :
            visit((LineComment) entity);
            break;
            case JavaEntityDescriptorEnum.Javadoc_ord :
            visit((Javadoc) entity);
            break;
            case JavaEntityDescriptorEnum.Tags_ord :
            visit((Tags) entity);
            break;
            case JavaEntityDescriptorEnum.DocElements_ord :
            visit((DocElements) entity);
            break;
            case JavaEntityDescriptorEnum.MethodRef_ord :
            visit((MethodRef) entity);
            break;
            case JavaEntityDescriptorEnum.MethodRefParameters_ord :
            visit((MethodRefParameters) entity);
            break;
            case JavaEntityDescriptorEnum.MethodRefParameter_ord :
            visit((MethodRefParameter) entity);
            break;
            case JavaEntityDescriptorEnum.MemberRef_ord :
            visit((MemberRef) entity);
            break;
            case JavaEntityDescriptorEnum.TextElement_ord :
            visit((TextElement) entity);
            break;
            case JavaEntityDescriptorEnum.TagElement_ord :
            visit((TagElement) entity);
            break;
            case JavaEntityDescriptorEnum.TagName_ord :
            visit((TagName) entity);
            break;
            case JavaEntityDescriptorEnum.Annotations_ord :
            visit((Annotations) entity);
            break;
            case JavaEntityDescriptorEnum.SingleMemberAnnotation_ord :
            visit((SingleMemberAnnotation) entity);
            break;
            case JavaEntityDescriptorEnum.MarkerAnnotation_ord :
            visit((MarkerAnnotation) entity);
            break;
            case JavaEntityDescriptorEnum.NormalAnnotation_ord :
            visit((NormalAnnotation) entity);
            break;
            case JavaEntityDescriptorEnum.MemberValuePairs_ord :
            visit((MemberValuePairs) entity);
            break;
            case JavaEntityDescriptorEnum.MemberValuePair_ord :
            visit((MemberValuePair) entity);
            break;
            case JavaEntityDescriptorEnum.ImportDeclarations_ord :
            visit((ImportDeclarations) entity);
            break;
            case JavaEntityDescriptorEnum.ImportDeclaration_ord :
            visit((ImportDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.ImportModifier_ord :
            visit((ImportModifier) entity);
            break;
            case JavaEntityDescriptorEnum.TypeDeclarations_ord :
            visit((TypeDeclarations) entity);
            break;
            case JavaEntityDescriptorEnum.EnumDeclaration_ord :
            visit((EnumDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.EnumConstants_ord :
            visit((EnumConstants) entity);
            break;
            case JavaEntityDescriptorEnum.EnumConstantDeclaration_ord :
            visit((EnumConstantDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.Arguments_ord :
            visit((Arguments) entity);
            break;
            case JavaEntityDescriptorEnum.AnonymousClassDeclaration_ord :
            visit((AnonymousClassDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeDeclaration_ord :
            visit((AnnotationTypeDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.ClassDeclaration_ord :
            visit((ClassDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.InterfaceDeclaration_ord :
            visit((InterfaceDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.TypeParameters_ord :
            visit((TypeParameters) entity);
            break;
            case JavaEntityDescriptorEnum.TypeParameter_ord :
            visit((TypeParameter) entity);
            break;
            case JavaEntityDescriptorEnum.Types_ord :
            visit((Types) entity);
            break;
            case JavaEntityDescriptorEnum.BodyDeclarations_ord :
            visit((BodyDeclarations) entity);
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration_ord :
            visit((AnnotationTypeMemberDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.Initializer_ord :
            visit((Initializer) entity);
            break;
            case JavaEntityDescriptorEnum.FieldDeclaration_ord :
            visit((FieldDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.MethodDeclaration_ord :
            visit((MethodDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.ConstructorDeclaration_ord :
            visit((ConstructorDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.Parameters_ord :
            visit((Parameters) entity);
            break;
            case JavaEntityDescriptorEnum.SingleVariableDeclaration_ord :
            visit((SingleVariableDeclaration) entity);
            break;
            case JavaEntityDescriptorEnum.Varargs_ord :
            visit((Varargs) entity);
            break;
            case JavaEntityDescriptorEnum.AnnotatedType_ord :
            visit((AnnotatedType) entity);
            break;
            case JavaEntityDescriptorEnum.ArrayType_ord :
            visit((ArrayType) entity);
            break;
            case JavaEntityDescriptorEnum.ParameterizedType_ord :
            visit((ParameterizedType) entity);
            break;
            case JavaEntityDescriptorEnum.PrimitiveType_ord :
            visit((PrimitiveType) entity);
            break;
            case JavaEntityDescriptorEnum.QualifiedType_ord :
            visit((QualifiedType) entity);
            break;
            case JavaEntityDescriptorEnum.SimpleType_ord :
            visit((SimpleType) entity);
            break;
            case JavaEntityDescriptorEnum.WildcardType_ord :
            visit((WildcardType) entity);
            break;
            case JavaEntityDescriptorEnum.UnionType_ord :
            visit((UnionType) entity);
            break;
            case JavaEntityDescriptorEnum.IntersectionType_ord :
            visit((IntersectionType) entity);
            break;
            case JavaEntityDescriptorEnum.UpperBound_ord :
            visit((UpperBound) entity);
            break;
            case JavaEntityDescriptorEnum.AssertStatement_ord :
            visit((AssertStatement) entity);
            break;
            case JavaEntityDescriptorEnum.Block_ord :
            visit((Block) entity);
            break;
            case JavaEntityDescriptorEnum.BreakStatement_ord :
            visit((BreakStatement) entity);
            break;
            case JavaEntityDescriptorEnum.ConstructorInvocation_ord :
            visit((ConstructorInvocation) entity);
            break;
            case JavaEntityDescriptorEnum.ContinueStatement_ord :
            visit((ContinueStatement) entity);
            break;
            case JavaEntityDescriptorEnum.DoStatement_ord :
            visit((DoStatement) entity);
            break;
            case JavaEntityDescriptorEnum.EmptyStatement_ord :
            visit((EmptyStatement) entity);
            break;
            case JavaEntityDescriptorEnum.EnhancedForStatement_ord :
            visit((EnhancedForStatement) entity);
            break;
            case JavaEntityDescriptorEnum.ExpressionStatement_ord :
            visit((ExpressionStatement) entity);
            break;
            case JavaEntityDescriptorEnum.ForStatement_ord :
            visit((ForStatement) entity);
            break;
            case JavaEntityDescriptorEnum.Expressions_ord :
            visit((Expressions) entity);
            break;
            case JavaEntityDescriptorEnum.IfStatement_ord :
            visit((IfStatement) entity);
            break;
            case JavaEntityDescriptorEnum.LabeledStatement_ord :
            visit((LabeledStatement) entity);
            break;
            case JavaEntityDescriptorEnum.ReturnStatement_ord :
            visit((ReturnStatement) entity);
            break;
            case JavaEntityDescriptorEnum.SuperConstructorInvocation_ord :
            visit((SuperConstructorInvocation) entity);
            break;
            case JavaEntityDescriptorEnum.SwitchCase_ord :
            visit((SwitchCase) entity);
            break;
            case JavaEntityDescriptorEnum.SwitchDefault_ord :
            visit((SwitchDefault) entity);
            break;
            case JavaEntityDescriptorEnum.SwitchStatement_ord :
            visit((SwitchStatement) entity);
            break;
            case JavaEntityDescriptorEnum.Statements_ord :
            visit((Statements) entity);
            break;
            case JavaEntityDescriptorEnum.SynchronizedStatement_ord :
            visit((SynchronizedStatement) entity);
            break;
            case JavaEntityDescriptorEnum.ThrowStatement_ord :
            visit((ThrowStatement) entity);
            break;
            case JavaEntityDescriptorEnum.TryStatement_ord :
            visit((TryStatement) entity);
            break;
            case JavaEntityDescriptorEnum.CatchClauses_ord :
            visit((CatchClauses) entity);
            break;
            case JavaEntityDescriptorEnum.CatchClause_ord :
            visit((CatchClause) entity);
            break;
            case JavaEntityDescriptorEnum.TypeDeclarationStatement_ord :
            visit((TypeDeclarationStatement) entity);
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationStatement_ord :
            visit((VariableDeclarationStatement) entity);
            break;
            case JavaEntityDescriptorEnum.WhileStatement_ord :
            visit((WhileStatement) entity);
            break;
            case JavaEntityDescriptorEnum.SimpleName_ord :
            visit((SimpleName) entity);
            break;
            case JavaEntityDescriptorEnum.QualifiedName_ord :
            visit((QualifiedName) entity);
            break;
            case JavaEntityDescriptorEnum.NullLiteral_ord :
            visit((NullLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.BooleanLiteral_ord :
            visit((BooleanLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.ByteLiteral_ord :
            visit((ByteLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.CharLiteral_ord :
            visit((CharLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.DoubleLiteral_ord :
            visit((DoubleLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.FloatLiteral_ord :
            visit((FloatLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.IntLiteral_ord :
            visit((IntLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.ShortLiteral_ord :
            visit((ShortLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.LongLiteral_ord :
            visit((LongLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.StringLiteral_ord :
            visit((StringLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.TypeLiteral_ord :
            visit((TypeLiteral) entity);
            break;
            case JavaEntityDescriptorEnum.ArrayAccess_ord :
            visit((ArrayAccess) entity);
            break;
            case JavaEntityDescriptorEnum.ArrayCreation_ord :
            visit((ArrayCreation) entity);
            break;
            case JavaEntityDescriptorEnum.ArrayInitializer_ord :
            visit((ArrayInitializer) entity);
            break;
            case JavaEntityDescriptorEnum.Assignment_ord :
            visit((Assignment) entity);
            break;
            case JavaEntityDescriptorEnum.AssignmentOperator_ord :
            visit((AssignmentOperator) entity);
            break;
            case JavaEntityDescriptorEnum.CastExpression_ord :
            visit((CastExpression) entity);
            break;
            case JavaEntityDescriptorEnum.ClassInstanceCreation_ord :
            visit((ClassInstanceCreation) entity);
            break;
            case JavaEntityDescriptorEnum.ConditionalExpression_ord :
            visit((ConditionalExpression) entity);
            break;
            case JavaEntityDescriptorEnum.FieldAccess_ord :
            visit((FieldAccess) entity);
            break;
            case JavaEntityDescriptorEnum.InfixExpression_ord :
            visit((InfixExpression) entity);
            break;
            case JavaEntityDescriptorEnum.InfixOperator_ord :
            visit((InfixOperator) entity);
            break;
            case JavaEntityDescriptorEnum.InstanceofExpression_ord :
            visit((InstanceofExpression) entity);
            break;
            case JavaEntityDescriptorEnum.LambdaExpression_ord :
            visit((LambdaExpression) entity);
            break;
            case JavaEntityDescriptorEnum.MethodInvocation_ord :
            visit((MethodInvocation) entity);
            break;
            case JavaEntityDescriptorEnum.ParenthesizedExpression_ord :
            visit((ParenthesizedExpression) entity);
            break;
            case JavaEntityDescriptorEnum.PostfixExpression_ord :
            visit((PostfixExpression) entity);
            break;
            case JavaEntityDescriptorEnum.PostfixOperator_ord :
            visit((PostfixOperator) entity);
            break;
            case JavaEntityDescriptorEnum.PrefixExpression_ord :
            visit((PrefixExpression) entity);
            break;
            case JavaEntityDescriptorEnum.PrefixOperator_ord :
            visit((PrefixOperator) entity);
            break;
            case JavaEntityDescriptorEnum.SuperFieldAccess_ord :
            visit((SuperFieldAccess) entity);
            break;
            case JavaEntityDescriptorEnum.SuperMethodInvocation_ord :
            visit((SuperMethodInvocation) entity);
            break;
            case JavaEntityDescriptorEnum.ThisExpression_ord :
            visit((ThisExpression) entity);
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationExpression_ord :
            visit((VariableDeclarationExpression) entity);
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragments_ord :
            visit((VariableDeclarationFragments) entity);
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragment_ord :
            visit((VariableDeclarationFragment) entity);
            break;
            case JavaEntityDescriptorEnum.ExtraDimensions_ord :
            visit((ExtraDimensions) entity);
            break;
            case JavaEntityDescriptorEnum.ExtendedModifiers_ord :
            visit((ExtendedModifiers) entity);
            break;
            case JavaEntityDescriptorEnum.Modifier_ord :
            visit((Modifier) entity);
            break;
            case JavaEntityDescriptorEnum.ConstructorReference_ord :
            visit((ConstructorReference) entity);
            break;
            case JavaEntityDescriptorEnum.ExpressionMethodReference_ord :
            visit((ExpressionMethodReference) entity);
            break;
            case JavaEntityDescriptorEnum.SuperMethodReference_ord :
            visit((SuperMethodReference) entity);
            break;
            case JavaEntityDescriptorEnum.TypeMethodReference_ord :
            visit((TypeMethodReference) entity);
            break;
        }
    }
}
