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

import org.whole.lang.java.model.*;

/**
 *  @generator Whole
 */
public class JavaIdentityDefaultVisitor extends JavaIdentityVisitor {

    public void visit(IJavaEntity entity) {
    }

    public void visit(JavaSystemSoftware entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(CompilationUnit entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(PackageDeclaration entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(ExpressionOrStatement entity) {
    }

    public void visit(Statement entity) {
        visit((ExpressionOrStatement) entity);
    }

    public void visit(Expression entity) {
        visit((ExpressionOrStatement) entity);
    }

    public void visit(Comment entity) {
        visit((Statement) entity);
        visit((BodyDeclaration) entity);
    }

    public void visit(BodyDeclaration entity) {
    }

    public void visit(BlockComment entity) {
        visit((IJavaEntity) entity);
        visit((Comment) entity);
    }

    public void visit(LineComment entity) {
        visit((IJavaEntity) entity);
        visit((Comment) entity);
    }

    public void visit(Javadoc entity) {
        visit((IJavaEntity) entity);
        visit((Comment) entity);
    }

    public void visit(Tags entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(DocElements entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(DocElement entity) {
    }

    public void visit(MethodRef entity) {
        visit((IJavaEntity) entity);
        visit((DocElement) entity);
    }

    public void visit(MethodRefParameters entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(MethodRefParameter entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(MemberRef entity) {
        visit((IJavaEntity) entity);
        visit((DocElement) entity);
    }

    public void visit(TextElement entity) {
        visit((IJavaEntity) entity);
        visit((DocElement) entity);
    }

    public void visit(TagElement entity) {
        visit((IJavaEntity) entity);
        visit((DocElement) entity);
    }

    public void visit(TagName entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(Annotations entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(ExtendedModifier entity) {
    }

    public void visit(Annotation entity) {
        visit((ExtendedModifier) entity);
        visit((Expression) entity);
    }

    public void visit(SingleMemberAnnotation entity) {
        visit((IJavaEntity) entity);
        visit((Annotation) entity);
    }

    public void visit(MarkerAnnotation entity) {
        visit((IJavaEntity) entity);
        visit((Annotation) entity);
    }

    public void visit(NormalAnnotation entity) {
        visit((IJavaEntity) entity);
        visit((Annotation) entity);
    }

    public void visit(MemberValuePairs entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(MemberValuePair entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(ImportDeclarations entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(ImportDeclaration entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(ImportModifier entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(TypeDeclarations entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(AnnotatedBodyDeclaration entity) {
        visit((BodyDeclaration) entity);
    }

    public void visit(TypeDeclaration entity) {
        visit((AnnotatedBodyDeclaration) entity);
    }

    public void visit(EnumDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((TypeDeclaration) entity);
    }

    public void visit(EnumConstants entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(EnumConstantDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((AnnotatedBodyDeclaration) entity);
    }

    public void visit(Arguments entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(AnonymousClassDeclaration entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(AnnotationTypeDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((TypeDeclaration) entity);
    }

    public void visit(ClassDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((TypeDeclaration) entity);
    }

    public void visit(InterfaceDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((TypeDeclaration) entity);
    }

    public void visit(TypeParameters entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(TypeParameter entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(Types entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(BodyDeclarations entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(AnnotationTypeMemberDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((AnnotatedBodyDeclaration) entity);
    }

    public void visit(Initializer entity) {
        visit((IJavaEntity) entity);
        visit((AnnotatedBodyDeclaration) entity);
    }

    public void visit(FieldDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((AnnotatedBodyDeclaration) entity);
    }

    public void visit(MethodDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((AnnotatedBodyDeclaration) entity);
    }

    public void visit(ConstructorDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((AnnotatedBodyDeclaration) entity);
    }

    public void visit(LambdaParameters entity) {
    }

    public void visit(Parameters entity) {
        visit((IJavaEntity) entity);
        visit((LambdaParameters) entity);
    }

    public void visit(VariableDeclaration entity) {
    }

    public void visit(SingleVariableDeclaration entity) {
        visit((IJavaEntity) entity);
        visit((VariableDeclaration) entity);
    }

    public void visit(Varargs entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(Type entity) {
    }

    public void visit(AnnotatedType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(ArrayType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(ParameterizedType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(PrimitiveType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(QualifiedType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(SimpleType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(WildcardType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(UnionType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(IntersectionType entity) {
        visit((IJavaEntity) entity);
        visit((Type) entity);
    }

    public void visit(UpperBound entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(AssertStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(Block entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(BreakStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(ConstructorInvocation entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(ContinueStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(DoStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(EmptyStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(EnhancedForStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(ExpressionStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(ForStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(Expressions entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(IfStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(LabeledStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(ReturnStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(SuperConstructorInvocation entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(SwitchCase entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(SwitchDefault entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(SwitchStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(Statements entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(SynchronizedStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(ThrowStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(TryStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(CatchClauses entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(CatchClause entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(TypeDeclarationStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(VariableDeclarationStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(WhileStatement entity) {
        visit((IJavaEntity) entity);
        visit((Statement) entity);
    }

    public void visit(Name entity) {
        visit((Expression) entity);
        visit((DocElement) entity);
    }

    public void visit(SimpleName entity) {
        visit((IJavaEntity) entity);
        visit((Name) entity);
    }

    public void visit(QualifiedName entity) {
        visit((IJavaEntity) entity);
        visit((Name) entity);
    }

    public void visit(NullLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(BooleanLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ByteLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(CharLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(DoubleLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(FloatLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(IntLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ShortLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(LongLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(StringLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(TypeLiteral entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ArrayAccess entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ArrayCreation entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ArrayInitializer entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Assignment entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(AssignmentOperator entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(CastExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ClassInstanceCreation entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ConditionalExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(FieldAccess entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(InfixExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(InfixOperator entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(InstanceofExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(LambdaExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(MethodInvocation entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ParenthesizedExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(PostfixExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(PostfixOperator entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(PrefixExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(PrefixOperator entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(SuperFieldAccess entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(SuperMethodInvocation entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ThisExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(VariableDeclarationExpression entity) {
        visit((IJavaEntity) entity);
        visit((Expression) entity);
    }

    public void visit(VariableDeclarationFragments entity) {
        visit((IJavaEntity) entity);
        visit((LambdaParameters) entity);
    }

    public void visit(VariableDeclarationFragment entity) {
        visit((IJavaEntity) entity);
        visit((VariableDeclaration) entity);
        visit((LambdaParameters) entity);
    }

    public void visit(ExtraDimensions entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(ExtendedModifiers entity) {
        visit((IJavaEntity) entity);
    }

    public void visit(Modifier entity) {
        visit((IJavaEntity) entity);
        visit((ExtendedModifier) entity);
    }

    public void visit(MethodReference entity) {
        visit((Expression) entity);
    }

    public void visit(ConstructorReference entity) {
        visit((IJavaEntity) entity);
        visit((MethodReference) entity);
    }

    public void visit(ExpressionMethodReference entity) {
        visit((IJavaEntity) entity);
        visit((MethodReference) entity);
    }

    public void visit(SuperMethodReference entity) {
        visit((IJavaEntity) entity);
        visit((MethodReference) entity);
    }

    public void visit(TypeMethodReference entity) {
        visit((IJavaEntity) entity);
        visit((MethodReference) entity);
    }
}
