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

/**
 *  @generator Whole
 */
public class JavaIdentityVisitor extends AbstractVisitor implements IJavaVisitor {

    public void visit(IEntity entity) {
        ((IJavaEntity) entity).accept(this);
    }

    public void visit(JavaSystemSoftware entity) {
    }

    public void visit(CompilationUnit entity) {
    }

    public void visit(PackageDeclaration entity) {
    }

    public void visit(BlockComment entity) {
    }

    public void visit(LineComment entity) {
    }

    public void visit(Javadoc entity) {
    }

    public void visit(Tags entity) {
    }

    public void visit(DocElements entity) {
    }

    public void visit(MethodRef entity) {
    }

    public void visit(MethodRefParameters entity) {
    }

    public void visit(MethodRefParameter entity) {
    }

    public void visit(MemberRef entity) {
    }

    public void visit(TextElement entity) {
    }

    public void visit(TagElement entity) {
    }

    public void visit(TagName entity) {
    }

    public void visit(Annotations entity) {
    }

    public void visit(SingleMemberAnnotation entity) {
    }

    public void visit(MarkerAnnotation entity) {
    }

    public void visit(NormalAnnotation entity) {
    }

    public void visit(MemberValuePairs entity) {
    }

    public void visit(MemberValuePair entity) {
    }

    public void visit(ImportDeclarations entity) {
    }

    public void visit(ImportDeclaration entity) {
    }

    public void visit(ImportModifier entity) {
    }

    public void visit(TypeDeclarations entity) {
    }

    public void visit(EnumDeclaration entity) {
    }

    public void visit(EnumConstants entity) {
    }

    public void visit(EnumConstantDeclaration entity) {
    }

    public void visit(Arguments entity) {
    }

    public void visit(AnonymousClassDeclaration entity) {
    }

    public void visit(AnnotationTypeDeclaration entity) {
    }

    public void visit(ClassDeclaration entity) {
    }

    public void visit(InterfaceDeclaration entity) {
    }

    public void visit(TypeParameters entity) {
    }

    public void visit(TypeParameter entity) {
    }

    public void visit(Types entity) {
    }

    public void visit(BodyDeclarations entity) {
    }

    public void visit(AnnotationTypeMemberDeclaration entity) {
    }

    public void visit(Initializer entity) {
    }

    public void visit(FieldDeclaration entity) {
    }

    public void visit(MethodDeclaration entity) {
    }

    public void visit(ConstructorDeclaration entity) {
    }

    public void visit(Parameters entity) {
    }

    public void visit(SingleVariableDeclaration entity) {
    }

    public void visit(Varargs entity) {
    }

    public void visit(AnnotatedType entity) {
    }

    public void visit(ArrayType entity) {
    }

    public void visit(ParameterizedType entity) {
    }

    public void visit(PrimitiveType entity) {
    }

    public void visit(QualifiedType entity) {
    }

    public void visit(SimpleType entity) {
    }

    public void visit(WildcardType entity) {
    }

    public void visit(UnionType entity) {
    }

    public void visit(IntersectionType entity) {
    }

    public void visit(UpperBound entity) {
    }

    public void visit(AssertStatement entity) {
    }

    public void visit(Block entity) {
    }

    public void visit(BreakStatement entity) {
    }

    public void visit(ConstructorInvocation entity) {
    }

    public void visit(ContinueStatement entity) {
    }

    public void visit(DoStatement entity) {
    }

    public void visit(EmptyStatement entity) {
    }

    public void visit(EnhancedForStatement entity) {
    }

    public void visit(ExpressionStatement entity) {
    }

    public void visit(ForStatement entity) {
    }

    public void visit(Expressions entity) {
    }

    public void visit(IfStatement entity) {
    }

    public void visit(LabeledStatement entity) {
    }

    public void visit(ReturnStatement entity) {
    }

    public void visit(SuperConstructorInvocation entity) {
    }

    public void visit(SwitchCase entity) {
    }

    public void visit(SwitchDefault entity) {
    }

    public void visit(SwitchStatement entity) {
    }

    public void visit(Statements entity) {
    }

    public void visit(SynchronizedStatement entity) {
    }

    public void visit(ThrowStatement entity) {
    }

    public void visit(TryStatement entity) {
    }

    public void visit(CatchClauses entity) {
    }

    public void visit(CatchClause entity) {
    }

    public void visit(TypeDeclarationStatement entity) {
    }

    public void visit(VariableDeclarationStatement entity) {
    }

    public void visit(WhileStatement entity) {
    }

    public void visit(SimpleName entity) {
    }

    public void visit(QualifiedName entity) {
    }

    public void visit(NullLiteral entity) {
    }

    public void visit(BooleanLiteral entity) {
    }

    public void visit(ByteLiteral entity) {
    }

    public void visit(CharLiteral entity) {
    }

    public void visit(DoubleLiteral entity) {
    }

    public void visit(FloatLiteral entity) {
    }

    public void visit(IntLiteral entity) {
    }

    public void visit(ShortLiteral entity) {
    }

    public void visit(LongLiteral entity) {
    }

    public void visit(StringLiteral entity) {
    }

    public void visit(TypeLiteral entity) {
    }

    public void visit(ArrayAccess entity) {
    }

    public void visit(ArrayCreation entity) {
    }

    public void visit(ArrayInitializer entity) {
    }

    public void visit(Assignment entity) {
    }

    public void visit(AssignmentOperator entity) {
    }

    public void visit(CastExpression entity) {
    }

    public void visit(ClassInstanceCreation entity) {
    }

    public void visit(ConditionalExpression entity) {
    }

    public void visit(FieldAccess entity) {
    }

    public void visit(InfixExpression entity) {
    }

    public void visit(InfixOperator entity) {
    }

    public void visit(InstanceofExpression entity) {
    }

    public void visit(LambdaExpression entity) {
    }

    public void visit(MethodInvocation entity) {
    }

    public void visit(ParenthesizedExpression entity) {
    }

    public void visit(PostfixExpression entity) {
    }

    public void visit(PostfixOperator entity) {
    }

    public void visit(PrefixExpression entity) {
    }

    public void visit(PrefixOperator entity) {
    }

    public void visit(SuperFieldAccess entity) {
    }

    public void visit(SuperMethodInvocation entity) {
    }

    public void visit(ThisExpression entity) {
    }

    public void visit(VariableDeclarationExpression entity) {
    }

    public void visit(VariableDeclarationFragments entity) {
    }

    public void visit(VariableDeclarationFragment entity) {
    }

    public void visit(ExtraDimensions entity) {
    }

    public void visit(ExtendedModifiers entity) {
    }

    public void visit(Modifier entity) {
    }

    public void visit(ConstructorReference entity) {
    }

    public void visit(ExpressionMethodReference entity) {
    }

    public void visit(SuperMethodReference entity) {
    }

    public void visit(TypeMethodReference entity) {
    }
}
