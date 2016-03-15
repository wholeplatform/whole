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
public class JavaForwardStagedVisitor extends JavaIdentityVisitor {

    public void visit(JavaSystemSoftware entity) {
        stagedVisit(entity);
    }

    public void visit(CompilationUnit entity) {
        stagedVisit(entity);
    }

    public void visit(PackageDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(BlockComment entity) {
        stagedVisit(entity);
    }

    public void visit(LineComment entity) {
        stagedVisit(entity);
    }

    public void visit(Javadoc entity) {
        stagedVisit(entity);
    }

    public void visit(Tags entity) {
        stagedVisit(entity);
    }

    public void visit(DocElements entity) {
        stagedVisit(entity);
    }

    public void visit(MethodRef entity) {
        stagedVisit(entity);
    }

    public void visit(MethodRefParameters entity) {
        stagedVisit(entity);
    }

    public void visit(MethodRefParameter entity) {
        stagedVisit(entity);
    }

    public void visit(MemberRef entity) {
        stagedVisit(entity);
    }

    public void visit(TextElement entity) {
        stagedVisit(entity);
    }

    public void visit(TagElement entity) {
        stagedVisit(entity);
    }

    public void visit(TagName entity) {
        stagedVisit(entity);
    }

    public void visit(Annotations entity) {
        stagedVisit(entity);
    }

    public void visit(SingleMemberAnnotation entity) {
        stagedVisit(entity);
    }

    public void visit(MarkerAnnotation entity) {
        stagedVisit(entity);
    }

    public void visit(NormalAnnotation entity) {
        stagedVisit(entity);
    }

    public void visit(MemberValuePairs entity) {
        stagedVisit(entity);
    }

    public void visit(MemberValuePair entity) {
        stagedVisit(entity);
    }

    public void visit(ImportDeclarations entity) {
        stagedVisit(entity);
    }

    public void visit(ImportDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(ImportModifier entity) {
        stagedVisit(entity);
    }

    public void visit(TypeDeclarations entity) {
        stagedVisit(entity);
    }

    public void visit(EnumDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(EnumConstants entity) {
        stagedVisit(entity);
    }

    public void visit(EnumConstantDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(Arguments entity) {
        stagedVisit(entity);
    }

    public void visit(AnonymousClassDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(AnnotationTypeDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(ClassDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(InterfaceDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(TypeParameters entity) {
        stagedVisit(entity);
    }

    public void visit(TypeParameter entity) {
        stagedVisit(entity);
    }

    public void visit(Types entity) {
        stagedVisit(entity);
    }

    public void visit(BodyDeclarations entity) {
        stagedVisit(entity);
    }

    public void visit(AnnotationTypeMemberDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(Initializer entity) {
        stagedVisit(entity);
    }

    public void visit(FieldDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(MethodDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(ConstructorDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(Parameters entity) {
        stagedVisit(entity);
    }

    public void visit(SingleVariableDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(Varargs entity) {
        stagedVisit(entity);
    }

    public void visit(AnnotatedType entity) {
        stagedVisit(entity);
    }

    public void visit(ArrayType entity) {
        stagedVisit(entity);
    }

    public void visit(ParameterizedType entity) {
        stagedVisit(entity);
    }

    public void visit(PrimitiveType entity) {
        stagedVisit(entity);
    }

    public void visit(QualifiedType entity) {
        stagedVisit(entity);
    }

    public void visit(SimpleType entity) {
        stagedVisit(entity);
    }

    public void visit(WildcardType entity) {
        stagedVisit(entity);
    }

    public void visit(UnionType entity) {
        stagedVisit(entity);
    }

    public void visit(IntersectionType entity) {
        stagedVisit(entity);
    }

    public void visit(UpperBound entity) {
        stagedVisit(entity);
    }

    public void visit(AssertStatement entity) {
        stagedVisit(entity);
    }

    public void visit(Block entity) {
        stagedVisit(entity);
    }

    public void visit(BreakStatement entity) {
        stagedVisit(entity);
    }

    public void visit(ConstructorInvocation entity) {
        stagedVisit(entity);
    }

    public void visit(ContinueStatement entity) {
        stagedVisit(entity);
    }

    public void visit(DoStatement entity) {
        stagedVisit(entity);
    }

    public void visit(EmptyStatement entity) {
        stagedVisit(entity);
    }

    public void visit(EnhancedForStatement entity) {
        stagedVisit(entity);
    }

    public void visit(ExpressionStatement entity) {
        stagedVisit(entity);
    }

    public void visit(ForStatement entity) {
        stagedVisit(entity);
    }

    public void visit(Expressions entity) {
        stagedVisit(entity);
    }

    public void visit(IfStatement entity) {
        stagedVisit(entity);
    }

    public void visit(LabeledStatement entity) {
        stagedVisit(entity);
    }

    public void visit(ReturnStatement entity) {
        stagedVisit(entity);
    }

    public void visit(SuperConstructorInvocation entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchCase entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchDefault entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchStatement entity) {
        stagedVisit(entity);
    }

    public void visit(Statements entity) {
        stagedVisit(entity);
    }

    public void visit(SynchronizedStatement entity) {
        stagedVisit(entity);
    }

    public void visit(ThrowStatement entity) {
        stagedVisit(entity);
    }

    public void visit(TryStatement entity) {
        stagedVisit(entity);
    }

    public void visit(CatchClauses entity) {
        stagedVisit(entity);
    }

    public void visit(CatchClause entity) {
        stagedVisit(entity);
    }

    public void visit(TypeDeclarationStatement entity) {
        stagedVisit(entity);
    }

    public void visit(VariableDeclarationStatement entity) {
        stagedVisit(entity);
    }

    public void visit(WhileStatement entity) {
        stagedVisit(entity);
    }

    public void visit(SimpleName entity) {
        stagedVisit(entity);
    }

    public void visit(QualifiedName entity) {
        stagedVisit(entity);
    }

    public void visit(NullLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(BooleanLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(ByteLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(CharLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(DoubleLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(FloatLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(IntLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(ShortLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(LongLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(StringLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(TypeLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(ArrayAccess entity) {
        stagedVisit(entity);
    }

    public void visit(ArrayCreation entity) {
        stagedVisit(entity);
    }

    public void visit(ArrayInitializer entity) {
        stagedVisit(entity);
    }

    public void visit(Assignment entity) {
        stagedVisit(entity);
    }

    public void visit(AssignmentOperator entity) {
        stagedVisit(entity);
    }

    public void visit(CastExpression entity) {
        stagedVisit(entity);
    }

    public void visit(ClassInstanceCreation entity) {
        stagedVisit(entity);
    }

    public void visit(ConditionalExpression entity) {
        stagedVisit(entity);
    }

    public void visit(FieldAccess entity) {
        stagedVisit(entity);
    }

    public void visit(InfixExpression entity) {
        stagedVisit(entity);
    }

    public void visit(InfixOperator entity) {
        stagedVisit(entity);
    }

    public void visit(InstanceofExpression entity) {
        stagedVisit(entity);
    }

    public void visit(LambdaExpression entity) {
        stagedVisit(entity);
    }

    public void visit(MethodInvocation entity) {
        stagedVisit(entity);
    }

    public void visit(ParenthesizedExpression entity) {
        stagedVisit(entity);
    }

    public void visit(PostfixExpression entity) {
        stagedVisit(entity);
    }

    public void visit(PostfixOperator entity) {
        stagedVisit(entity);
    }

    public void visit(PrefixExpression entity) {
        stagedVisit(entity);
    }

    public void visit(PrefixOperator entity) {
        stagedVisit(entity);
    }

    public void visit(SuperFieldAccess entity) {
        stagedVisit(entity);
    }

    public void visit(SuperMethodInvocation entity) {
        stagedVisit(entity);
    }

    public void visit(ThisExpression entity) {
        stagedVisit(entity);
    }

    public void visit(VariableDeclarationExpression entity) {
        stagedVisit(entity);
    }

    public void visit(VariableDeclarationFragments entity) {
        stagedVisit(entity);
    }

    public void visit(VariableDeclarationFragment entity) {
        stagedVisit(entity);
    }

    public void visit(ExtraDimensions entity) {
        stagedVisit(entity);
    }

    public void visit(ExtendedModifiers entity) {
        stagedVisit(entity);
    }

    public void visit(Modifier entity) {
        stagedVisit(entity);
    }

    public void visit(ConstructorReference entity) {
        stagedVisit(entity);
    }

    public void visit(ExpressionMethodReference entity) {
        stagedVisit(entity);
    }

    public void visit(SuperMethodReference entity) {
        stagedVisit(entity);
    }

    public void visit(TypeMethodReference entity) {
        stagedVisit(entity);
    }
}
