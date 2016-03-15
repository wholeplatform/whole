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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class JavaFailureVisitor extends JavaIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(JavaSystemSoftware entity) {
        throw new VisitException();
    }

    public void visit(CompilationUnit entity) {
        throw new VisitException();
    }

    public void visit(PackageDeclaration entity) {
        throw new VisitException();
    }

    public void visit(BlockComment entity) {
        throw new VisitException();
    }

    public void visit(LineComment entity) {
        throw new VisitException();
    }

    public void visit(Javadoc entity) {
        throw new VisitException();
    }

    public void visit(Tags entity) {
        throw new VisitException();
    }

    public void visit(DocElements entity) {
        throw new VisitException();
    }

    public void visit(MethodRef entity) {
        throw new VisitException();
    }

    public void visit(MethodRefParameters entity) {
        throw new VisitException();
    }

    public void visit(MethodRefParameter entity) {
        throw new VisitException();
    }

    public void visit(MemberRef entity) {
        throw new VisitException();
    }

    public void visit(TextElement entity) {
        throw new VisitException();
    }

    public void visit(TagElement entity) {
        throw new VisitException();
    }

    public void visit(TagName entity) {
        throw new VisitException();
    }

    public void visit(Annotations entity) {
        throw new VisitException();
    }

    public void visit(SingleMemberAnnotation entity) {
        throw new VisitException();
    }

    public void visit(MarkerAnnotation entity) {
        throw new VisitException();
    }

    public void visit(NormalAnnotation entity) {
        throw new VisitException();
    }

    public void visit(MemberValuePairs entity) {
        throw new VisitException();
    }

    public void visit(MemberValuePair entity) {
        throw new VisitException();
    }

    public void visit(ImportDeclarations entity) {
        throw new VisitException();
    }

    public void visit(ImportDeclaration entity) {
        throw new VisitException();
    }

    public void visit(ImportModifier entity) {
        throw new VisitException();
    }

    public void visit(TypeDeclarations entity) {
        throw new VisitException();
    }

    public void visit(EnumDeclaration entity) {
        throw new VisitException();
    }

    public void visit(EnumConstants entity) {
        throw new VisitException();
    }

    public void visit(EnumConstantDeclaration entity) {
        throw new VisitException();
    }

    public void visit(Arguments entity) {
        throw new VisitException();
    }

    public void visit(AnonymousClassDeclaration entity) {
        throw new VisitException();
    }

    public void visit(AnnotationTypeDeclaration entity) {
        throw new VisitException();
    }

    public void visit(ClassDeclaration entity) {
        throw new VisitException();
    }

    public void visit(InterfaceDeclaration entity) {
        throw new VisitException();
    }

    public void visit(TypeParameters entity) {
        throw new VisitException();
    }

    public void visit(TypeParameter entity) {
        throw new VisitException();
    }

    public void visit(Types entity) {
        throw new VisitException();
    }

    public void visit(BodyDeclarations entity) {
        throw new VisitException();
    }

    public void visit(AnnotationTypeMemberDeclaration entity) {
        throw new VisitException();
    }

    public void visit(Initializer entity) {
        throw new VisitException();
    }

    public void visit(FieldDeclaration entity) {
        throw new VisitException();
    }

    public void visit(MethodDeclaration entity) {
        throw new VisitException();
    }

    public void visit(ConstructorDeclaration entity) {
        throw new VisitException();
    }

    public void visit(Parameters entity) {
        throw new VisitException();
    }

    public void visit(SingleVariableDeclaration entity) {
        throw new VisitException();
    }

    public void visit(Varargs entity) {
        throw new VisitException();
    }

    public void visit(AnnotatedType entity) {
        throw new VisitException();
    }

    public void visit(ArrayType entity) {
        throw new VisitException();
    }

    public void visit(ParameterizedType entity) {
        throw new VisitException();
    }

    public void visit(PrimitiveType entity) {
        throw new VisitException();
    }

    public void visit(QualifiedType entity) {
        throw new VisitException();
    }

    public void visit(SimpleType entity) {
        throw new VisitException();
    }

    public void visit(WildcardType entity) {
        throw new VisitException();
    }

    public void visit(UnionType entity) {
        throw new VisitException();
    }

    public void visit(IntersectionType entity) {
        throw new VisitException();
    }

    public void visit(UpperBound entity) {
        throw new VisitException();
    }

    public void visit(AssertStatement entity) {
        throw new VisitException();
    }

    public void visit(Block entity) {
        throw new VisitException();
    }

    public void visit(BreakStatement entity) {
        throw new VisitException();
    }

    public void visit(ConstructorInvocation entity) {
        throw new VisitException();
    }

    public void visit(ContinueStatement entity) {
        throw new VisitException();
    }

    public void visit(DoStatement entity) {
        throw new VisitException();
    }

    public void visit(EmptyStatement entity) {
        throw new VisitException();
    }

    public void visit(EnhancedForStatement entity) {
        throw new VisitException();
    }

    public void visit(ExpressionStatement entity) {
        throw new VisitException();
    }

    public void visit(ForStatement entity) {
        throw new VisitException();
    }

    public void visit(Expressions entity) {
        throw new VisitException();
    }

    public void visit(IfStatement entity) {
        throw new VisitException();
    }

    public void visit(LabeledStatement entity) {
        throw new VisitException();
    }

    public void visit(ReturnStatement entity) {
        throw new VisitException();
    }

    public void visit(SuperConstructorInvocation entity) {
        throw new VisitException();
    }

    public void visit(SwitchCase entity) {
        throw new VisitException();
    }

    public void visit(SwitchDefault entity) {
        throw new VisitException();
    }

    public void visit(SwitchStatement entity) {
        throw new VisitException();
    }

    public void visit(Statements entity) {
        throw new VisitException();
    }

    public void visit(SynchronizedStatement entity) {
        throw new VisitException();
    }

    public void visit(ThrowStatement entity) {
        throw new VisitException();
    }

    public void visit(TryStatement entity) {
        throw new VisitException();
    }

    public void visit(CatchClauses entity) {
        throw new VisitException();
    }

    public void visit(CatchClause entity) {
        throw new VisitException();
    }

    public void visit(TypeDeclarationStatement entity) {
        throw new VisitException();
    }

    public void visit(VariableDeclarationStatement entity) {
        throw new VisitException();
    }

    public void visit(WhileStatement entity) {
        throw new VisitException();
    }

    public void visit(SimpleName entity) {
        throw new VisitException();
    }

    public void visit(QualifiedName entity) {
        throw new VisitException();
    }

    public void visit(NullLiteral entity) {
        throw new VisitException();
    }

    public void visit(BooleanLiteral entity) {
        throw new VisitException();
    }

    public void visit(ByteLiteral entity) {
        throw new VisitException();
    }

    public void visit(CharLiteral entity) {
        throw new VisitException();
    }

    public void visit(DoubleLiteral entity) {
        throw new VisitException();
    }

    public void visit(FloatLiteral entity) {
        throw new VisitException();
    }

    public void visit(IntLiteral entity) {
        throw new VisitException();
    }

    public void visit(ShortLiteral entity) {
        throw new VisitException();
    }

    public void visit(LongLiteral entity) {
        throw new VisitException();
    }

    public void visit(StringLiteral entity) {
        throw new VisitException();
    }

    public void visit(TypeLiteral entity) {
        throw new VisitException();
    }

    public void visit(ArrayAccess entity) {
        throw new VisitException();
    }

    public void visit(ArrayCreation entity) {
        throw new VisitException();
    }

    public void visit(ArrayInitializer entity) {
        throw new VisitException();
    }

    public void visit(Assignment entity) {
        throw new VisitException();
    }

    public void visit(AssignmentOperator entity) {
        throw new VisitException();
    }

    public void visit(CastExpression entity) {
        throw new VisitException();
    }

    public void visit(ClassInstanceCreation entity) {
        throw new VisitException();
    }

    public void visit(ConditionalExpression entity) {
        throw new VisitException();
    }

    public void visit(FieldAccess entity) {
        throw new VisitException();
    }

    public void visit(InfixExpression entity) {
        throw new VisitException();
    }

    public void visit(InfixOperator entity) {
        throw new VisitException();
    }

    public void visit(InstanceofExpression entity) {
        throw new VisitException();
    }

    public void visit(LambdaExpression entity) {
        throw new VisitException();
    }

    public void visit(MethodInvocation entity) {
        throw new VisitException();
    }

    public void visit(ParenthesizedExpression entity) {
        throw new VisitException();
    }

    public void visit(PostfixExpression entity) {
        throw new VisitException();
    }

    public void visit(PostfixOperator entity) {
        throw new VisitException();
    }

    public void visit(PrefixExpression entity) {
        throw new VisitException();
    }

    public void visit(PrefixOperator entity) {
        throw new VisitException();
    }

    public void visit(SuperFieldAccess entity) {
        throw new VisitException();
    }

    public void visit(SuperMethodInvocation entity) {
        throw new VisitException();
    }

    public void visit(ThisExpression entity) {
        throw new VisitException();
    }

    public void visit(VariableDeclarationExpression entity) {
        throw new VisitException();
    }

    public void visit(VariableDeclarationFragments entity) {
        throw new VisitException();
    }

    public void visit(VariableDeclarationFragment entity) {
        throw new VisitException();
    }

    public void visit(ExtraDimensions entity) {
        throw new VisitException();
    }

    public void visit(ExtendedModifiers entity) {
        throw new VisitException();
    }

    public void visit(Modifier entity) {
        throw new VisitException();
    }

    public void visit(ConstructorReference entity) {
        throw new VisitException();
    }

    public void visit(ExpressionMethodReference entity) {
        throw new VisitException();
    }

    public void visit(SuperMethodReference entity) {
        throw new VisitException();
    }

    public void visit(TypeMethodReference entity) {
        throw new VisitException();
    }
}
