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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.java.model.*;

/**
 *  @generator Whole
 */
public class JavaTraverseAllSwitchVisitor extends JavaIdentityUnaryVisitor<IVisitor> {

    public JavaTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(JavaSystemSoftware entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CompilationUnit entity) {
        wGetVisitor1().visit(entity.getPackage());
        wGetVisitor1().visit(entity.getImports());
        wGetVisitor1().visit(entity.getTypes());
    }

    public void visit(PackageDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getAnnotations());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(BlockComment entity) {
        wGetVisitor1().visit(entity.getDocElements());
    }

    public void visit(LineComment entity) {
        wGetVisitor1().visit(entity.getText());
    }

    public void visit(Javadoc entity) {
        wGetVisitor1().visit(entity.getTags());
    }

    public void visit(Tags entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(DocElements entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MethodRef entity) {
        wGetVisitor1().visit(entity.getQualifier());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getParameters());
    }

    public void visit(MethodRefParameters entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MethodRefParameter entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getVarargs());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(MemberRef entity) {
        wGetVisitor1().visit(entity.getQualifier());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(TagElement entity) {
        wGetVisitor1().visit(entity.getTagName());
        wGetVisitor1().visit(entity.getFragments());
    }

    public void visit(Annotations entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Annotation entity) {
        wGetVisitor1().visit(entity.getTypeName());
    }

    public void visit(SingleMemberAnnotation entity) {
        wGetVisitor1().visit(entity.getTypeName());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(MarkerAnnotation entity) {
        wGetVisitor1().visit(entity.getTypeName());
    }

    public void visit(NormalAnnotation entity) {
        wGetVisitor1().visit(entity.getTypeName());
        wGetVisitor1().visit(entity.getValues());
    }

    public void visit(MemberValuePairs entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MemberValuePair entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(ImportDeclarations entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ImportDeclaration entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getOnDemand());
        wGetVisitor1().visit(entity.getStatic());
    }

    public void visit(TypeDeclarations entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AnnotatedBodyDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
    }

    public void visit(TypeDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBodyDeclarations());
    }

    public void visit(EnumDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getSuperInterfaceTypes());
        wGetVisitor1().visit(entity.getEnumConstants());
        wGetVisitor1().visit(entity.getBodyDeclarations());
    }

    public void visit(EnumConstants entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(EnumConstantDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getAnonymousClassDeclaration());
    }

    public void visit(Arguments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AnonymousClassDeclaration entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AnnotationTypeDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBodyDeclarations());
    }

    public void visit(ClassDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTypeParameters());
        wGetVisitor1().visit(entity.getSuperclassType());
        wGetVisitor1().visit(entity.getSuperInterfaceTypes());
        wGetVisitor1().visit(entity.getBodyDeclarations());
    }

    public void visit(InterfaceDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTypeParameters());
        wGetVisitor1().visit(entity.getSuperInterfaceTypes());
        wGetVisitor1().visit(entity.getBodyDeclarations());
    }

    public void visit(TypeParameters entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TypeParameter entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTypeBounds());
        wGetVisitor1().visit(entity.getAnnotations());
    }

    public void visit(Types entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(BodyDeclarations entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AnnotationTypeMemberDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getDefault());
    }

    public void visit(Initializer entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(FieldDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getFragments());
    }

    public void visit(MethodDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getTypeParameters());
        wGetVisitor1().visit(entity.getReturnType());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getParameters());
        wGetVisitor1().visit(entity.getExtraDimensions());
        wGetVisitor1().visit(entity.getThrownExceptions());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(ConstructorDeclaration entity) {
        wGetVisitor1().visit(entity.getJavadoc());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getTypeParameters());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getParameters());
        wGetVisitor1().visit(entity.getExtraDimensions());
        wGetVisitor1().visit(entity.getThrownExceptions());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(Parameters entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SingleVariableDeclaration entity) {
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getVarargs());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExtraDimensions());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getVarargsAnnotations());
    }

    public void visit(AnnotatedType entity) {
        wGetVisitor1().visit(entity.getAnnotations());
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(ArrayType entity) {
        wGetVisitor1().visit(entity.getComponentType());
    }

    public void visit(ParameterizedType entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getTypeArguments());
    }

    public void visit(WildcardType entity) {
        wGetVisitor1().visit(entity.getBound());
        wGetVisitor1().visit(entity.getUpperBound());
    }

    public void visit(UnionType entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(IntersectionType entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AssertStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getMessage());
    }

    public void visit(Block entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(BreakStatement entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(ConstructorInvocation entity) {
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(ContinueStatement entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(DoStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(EnhancedForStatement entity) {
        wGetVisitor1().visit(entity.getParameter());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(ExpressionStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ForStatement entity) {
        wGetVisitor1().visit(entity.getInitializers());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getUpdaters());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(Expressions entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(IfStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getThenStatement());
        wGetVisitor1().visit(entity.getElseStatement());
    }

    public void visit(LabeledStatement entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(ReturnStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(SuperConstructorInvocation entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(SwitchCase entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(SwitchStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getStatements());
    }

    public void visit(Statements entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SynchronizedStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(ThrowStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(TryStatement entity) {
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getCatchClauses());
        wGetVisitor1().visit(entity.getFinally());
    }

    public void visit(CatchClauses entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CatchClause entity) {
        wGetVisitor1().visit(entity.getException());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(TypeDeclarationStatement entity) {
        wGetVisitor1().visit(entity.getTypeDeclaration());
    }

    public void visit(VariableDeclarationStatement entity) {
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getFragments());
    }

    public void visit(WhileStatement entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(TypeLiteral entity) {
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(ArrayAccess entity) {
        wGetVisitor1().visit(entity.getArray());
        wGetVisitor1().visit(entity.getIndex());
    }

    public void visit(ArrayCreation entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getDimensions());
        wGetVisitor1().visit(entity.getInitializer());
    }

    public void visit(ArrayInitializer entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Assignment entity) {
        wGetVisitor1().visit(entity.getLeftHandSide());
        wGetVisitor1().visit(entity.getOperator());
        wGetVisitor1().visit(entity.getRightHandSide());
    }

    public void visit(CastExpression entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ClassInstanceCreation entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getAnonymousClassDeclaration());
    }

    public void visit(ConditionalExpression entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getThenExpression());
        wGetVisitor1().visit(entity.getElseExpression());
    }

    public void visit(FieldAccess entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(InfixExpression entity) {
        wGetVisitor1().visit(entity.getLeftOperand());
        wGetVisitor1().visit(entity.getOperator());
        wGetVisitor1().visit(entity.getRightOperand());
        wGetVisitor1().visit(entity.getExtendedOperands());
    }

    public void visit(InstanceofExpression entity) {
        wGetVisitor1().visit(entity.getLeftOperand());
        wGetVisitor1().visit(entity.getRightOperand());
    }

    public void visit(LambdaExpression entity) {
        wGetVisitor1().visit(entity.getParameters());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(MethodInvocation entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(ParenthesizedExpression entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(PostfixExpression entity) {
        wGetVisitor1().visit(entity.getOperand());
        wGetVisitor1().visit(entity.getOperator());
    }

    public void visit(PrefixExpression entity) {
        wGetVisitor1().visit(entity.getOperator());
        wGetVisitor1().visit(entity.getOperand());
    }

    public void visit(SuperFieldAccess entity) {
        wGetVisitor1().visit(entity.getQualifier());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(SuperMethodInvocation entity) {
        wGetVisitor1().visit(entity.getQualifier());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(ThisExpression entity) {
        wGetVisitor1().visit(entity.getQualifier());
    }

    public void visit(VariableDeclarationExpression entity) {
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getFragments());
    }

    public void visit(VariableDeclarationFragments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(VariableDeclarationFragment entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExtraDimensions());
        wGetVisitor1().visit(entity.getInitializer());
    }

    public void visit(ExtendedModifiers entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MethodReference entity) {
        wGetVisitor1().visit(entity.getTypeArguments());
    }

    public void visit(ConstructorReference entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getTypeArguments());
    }

    public void visit(ExpressionMethodReference entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(SuperMethodReference entity) {
        wGetVisitor1().visit(entity.getQualifier());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(TypeMethodReference entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getName());
    }
}
