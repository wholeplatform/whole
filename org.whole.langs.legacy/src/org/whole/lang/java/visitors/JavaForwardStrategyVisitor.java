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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class JavaForwardStrategyVisitor extends GenericForwardStrategyVisitor<IJavaVisitor> implements IJavaVisitor {

    public JavaForwardStrategyVisitor() {
        this(new JavaIdentityVisitor());
    }

    public JavaForwardStrategyVisitor(IJavaVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IJavaEntity) entity).accept(this);
    }

    public void visit(JavaSystemSoftware entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CompilationUnit entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PackageDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BlockComment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LineComment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Javadoc entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Tags entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DocElements entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MethodRef entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MethodRefParameters entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MethodRefParameter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberRef entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TextElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TagElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TagName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Annotations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SingleMemberAnnotation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MarkerAnnotation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NormalAnnotation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberValuePairs entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberValuePair entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImportDeclarations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImportDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImportModifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeDeclarations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumConstants entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumConstantDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arguments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AnonymousClassDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AnnotationTypeDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InterfaceDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeParameters entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeParameter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Types entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BodyDeclarations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AnnotationTypeMemberDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Initializer entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FieldDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MethodDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConstructorDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Parameters entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SingleVariableDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Varargs entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AnnotatedType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ParameterizedType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrimitiveType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(QualifiedType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SimpleType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WildcardType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntersectionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UpperBound entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssertStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Block entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BreakStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConstructorInvocation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ContinueStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DoStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EmptyStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnhancedForStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExpressionStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ForStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Expressions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LabeledStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReturnStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SuperConstructorInvocation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchDefault entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Statements entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SynchronizedStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ThrowStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TryStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CatchClauses entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CatchClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeDeclarationStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDeclarationStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WhileStatement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SimpleName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(QualifiedName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NullLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BooleanLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ByteLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CharLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DoubleLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FloatLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ShortLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LongLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayAccess entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayCreation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayInitializer entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Assignment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssignmentOperator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CastExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassInstanceCreation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionalExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FieldAccess entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InfixExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InfixOperator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InstanceofExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LambdaExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MethodInvocation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ParenthesizedExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PostfixExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PostfixOperator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrefixExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrefixOperator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SuperFieldAccess entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SuperMethodInvocation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ThisExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDeclarationExpression entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDeclarationFragments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDeclarationFragment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtraDimensions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtendedModifiers entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Modifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConstructorReference entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExpressionMethodReference entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SuperMethodReference entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeMethodReference entity) {
        wGetStrategy().visit(entity);
    }
}
