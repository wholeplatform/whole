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

import org.whole.lang.java.visitors.JavaIdentityUnaryVisitor;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class JavaTraverseAllChildrenVisitor extends JavaIdentityUnaryVisitor<IJavaVisitor> {

    public JavaTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public JavaTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(JavaSystemSoftware entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CompilationUnit entity) {
        entity.getPackage().accept(wGetVisitor1());
        entity.getImports().accept(wGetVisitor1());
        entity.getTypes().accept(wGetVisitor1());
    }

    public void visit(PackageDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getAnnotations().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(BlockComment entity) {
        entity.getDocElements().accept(wGetVisitor1());
    }

    public void visit(LineComment entity) {
        entity.getText().accept(wGetVisitor1());
    }

    public void visit(Javadoc entity) {
        entity.getTags().accept(wGetVisitor1());
    }

    public void visit(Tags entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(DocElements entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MethodRef entity) {
        entity.getQualifier().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getParameters().accept(wGetVisitor1());
    }

    public void visit(MethodRefParameters entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MethodRefParameter entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getVarargs().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(MemberRef entity) {
        entity.getQualifier().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(TagElement entity) {
        entity.getTagName().accept(wGetVisitor1());
        entity.getFragments().accept(wGetVisitor1());
    }

    public void visit(Annotations entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Annotation entity) {
        entity.getTypeName().accept(wGetVisitor1());
    }

    public void visit(SingleMemberAnnotation entity) {
        entity.getTypeName().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(MarkerAnnotation entity) {
        entity.getTypeName().accept(wGetVisitor1());
    }

    public void visit(NormalAnnotation entity) {
        entity.getTypeName().accept(wGetVisitor1());
        entity.getValues().accept(wGetVisitor1());
    }

    public void visit(MemberValuePairs entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MemberValuePair entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(ImportDeclarations entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ImportDeclaration entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getOnDemand().accept(wGetVisitor1());
        entity.getStatic().accept(wGetVisitor1());
    }

    public void visit(TypeDeclarations entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AnnotatedBodyDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
    }

    public void visit(TypeDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBodyDeclarations().accept(wGetVisitor1());
    }

    public void visit(EnumDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getSuperInterfaceTypes().accept(wGetVisitor1());
        entity.getEnumConstants().accept(wGetVisitor1());
        entity.getBodyDeclarations().accept(wGetVisitor1());
    }

    public void visit(EnumConstants entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(EnumConstantDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getAnonymousClassDeclaration().accept(wGetVisitor1());
    }

    public void visit(Arguments entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AnonymousClassDeclaration entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AnnotationTypeDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBodyDeclarations().accept(wGetVisitor1());
    }

    public void visit(ClassDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getTypeParameters().accept(wGetVisitor1());
        entity.getSuperclassType().accept(wGetVisitor1());
        entity.getSuperInterfaceTypes().accept(wGetVisitor1());
        entity.getBodyDeclarations().accept(wGetVisitor1());
    }

    public void visit(InterfaceDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getTypeParameters().accept(wGetVisitor1());
        entity.getSuperInterfaceTypes().accept(wGetVisitor1());
        entity.getBodyDeclarations().accept(wGetVisitor1());
    }

    public void visit(TypeParameters entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TypeParameter entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTypeBounds().accept(wGetVisitor1());
        entity.getAnnotations().accept(wGetVisitor1());
    }

    public void visit(Types entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(BodyDeclarations entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AnnotationTypeMemberDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getDefault().accept(wGetVisitor1());
    }

    public void visit(Initializer entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(FieldDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getFragments().accept(wGetVisitor1());
    }

    public void visit(MethodDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getTypeParameters().accept(wGetVisitor1());
        entity.getReturnType().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getParameters().accept(wGetVisitor1());
        entity.getExtraDimensions().accept(wGetVisitor1());
        entity.getThrownExceptions().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(ConstructorDeclaration entity) {
        entity.getJavadoc().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getTypeParameters().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getParameters().accept(wGetVisitor1());
        entity.getExtraDimensions().accept(wGetVisitor1());
        entity.getThrownExceptions().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(Parameters entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SingleVariableDeclaration entity) {
        entity.getModifiers().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getVarargs().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getExtraDimensions().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getVarargsAnnotations().accept(wGetVisitor1());
    }

    public void visit(AnnotatedType entity) {
        entity.getAnnotations().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(ArrayType entity) {
        entity.getComponentType().accept(wGetVisitor1());
    }

    public void visit(ParameterizedType entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
    }

    public void visit(WildcardType entity) {
        entity.getBound().accept(wGetVisitor1());
        entity.getUpperBound().accept(wGetVisitor1());
    }

    public void visit(UnionType entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(IntersectionType entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AssertStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getMessage().accept(wGetVisitor1());
    }

    public void visit(Block entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(BreakStatement entity) {
        entity.getLabel().accept(wGetVisitor1());
    }

    public void visit(ConstructorInvocation entity) {
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(ContinueStatement entity) {
        entity.getLabel().accept(wGetVisitor1());
    }

    public void visit(DoStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(EnhancedForStatement entity) {
        entity.getParameter().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(ExpressionStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ForStatement entity) {
        entity.getInitializers().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getUpdaters().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(Expressions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(IfStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getThenStatement().accept(wGetVisitor1());
        entity.getElseStatement().accept(wGetVisitor1());
    }

    public void visit(LabeledStatement entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(ReturnStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(SuperConstructorInvocation entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(SwitchCase entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(SwitchStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getStatements().accept(wGetVisitor1());
    }

    public void visit(Statements entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SynchronizedStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(ThrowStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(TryStatement entity) {
        entity.getBody().accept(wGetVisitor1());
        entity.getCatchClauses().accept(wGetVisitor1());
        entity.getFinally().accept(wGetVisitor1());
    }

    public void visit(CatchClauses entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CatchClause entity) {
        entity.getException().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(TypeDeclarationStatement entity) {
        entity.getTypeDeclaration().accept(wGetVisitor1());
    }

    public void visit(VariableDeclarationStatement entity) {
        entity.getModifiers().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getFragments().accept(wGetVisitor1());
    }

    public void visit(WhileStatement entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(TypeLiteral entity) {
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(ArrayAccess entity) {
        entity.getArray().accept(wGetVisitor1());
        entity.getIndex().accept(wGetVisitor1());
    }

    public void visit(ArrayCreation entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getDimensions().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
    }

    public void visit(ArrayInitializer entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Assignment entity) {
        entity.getLeftHandSide().accept(wGetVisitor1());
        entity.getOperator().accept(wGetVisitor1());
        entity.getRightHandSide().accept(wGetVisitor1());
    }

    public void visit(CastExpression entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ClassInstanceCreation entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getAnonymousClassDeclaration().accept(wGetVisitor1());
    }

    public void visit(ConditionalExpression entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getThenExpression().accept(wGetVisitor1());
        entity.getElseExpression().accept(wGetVisitor1());
    }

    public void visit(FieldAccess entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(InfixExpression entity) {
        entity.getLeftOperand().accept(wGetVisitor1());
        entity.getOperator().accept(wGetVisitor1());
        entity.getRightOperand().accept(wGetVisitor1());
        entity.getExtendedOperands().accept(wGetVisitor1());
    }

    public void visit(InstanceofExpression entity) {
        entity.getLeftOperand().accept(wGetVisitor1());
        entity.getRightOperand().accept(wGetVisitor1());
    }

    public void visit(LambdaExpression entity) {
        entity.getParameters().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(MethodInvocation entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(ParenthesizedExpression entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(PostfixExpression entity) {
        entity.getOperand().accept(wGetVisitor1());
        entity.getOperator().accept(wGetVisitor1());
    }

    public void visit(PrefixExpression entity) {
        entity.getOperator().accept(wGetVisitor1());
        entity.getOperand().accept(wGetVisitor1());
    }

    public void visit(SuperFieldAccess entity) {
        entity.getQualifier().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(SuperMethodInvocation entity) {
        entity.getQualifier().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(ThisExpression entity) {
        entity.getQualifier().accept(wGetVisitor1());
    }

    public void visit(VariableDeclarationExpression entity) {
        entity.getModifiers().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getFragments().accept(wGetVisitor1());
    }

    public void visit(VariableDeclarationFragments entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(VariableDeclarationFragment entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getExtraDimensions().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
    }

    public void visit(ExtendedModifiers entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MethodReference entity) {
        entity.getTypeArguments().accept(wGetVisitor1());
    }

    public void visit(ConstructorReference entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
    }

    public void visit(ExpressionMethodReference entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(SuperMethodReference entity) {
        entity.getQualifier().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(TypeMethodReference entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getTypeArguments().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }
}
