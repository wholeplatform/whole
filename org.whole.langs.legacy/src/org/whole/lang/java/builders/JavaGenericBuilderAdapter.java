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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.java.model.PrimitiveTypeEnum.Value;

/**
 *  @generator Whole
 */
public class JavaGenericBuilderAdapter extends GenericIdentityBuilder {
    private IJavaBuilder specificBuilder;

    public JavaGenericBuilderAdapter(IJavaBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public JavaGenericBuilderAdapter(IJavaBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.JavaSystemSoftware_ord :
            specificBuilder.JavaSystemSoftware();
            break;
            case JavaEntityDescriptorEnum.CompilationUnit_ord :
            specificBuilder.CompilationUnit();
            break;
            case JavaEntityDescriptorEnum.PackageDeclaration_ord :
            specificBuilder.PackageDeclaration();
            break;
            case JavaEntityDescriptorEnum.BlockComment_ord :
            specificBuilder.BlockComment();
            break;
            case JavaEntityDescriptorEnum.LineComment_ord :
            specificBuilder.LineComment();
            break;
            case JavaEntityDescriptorEnum.Javadoc_ord :
            specificBuilder.Javadoc();
            break;
            case JavaEntityDescriptorEnum.Tags_ord :
            specificBuilder.Tags();
            break;
            case JavaEntityDescriptorEnum.DocElements_ord :
            specificBuilder.DocElements();
            break;
            case JavaEntityDescriptorEnum.MethodRef_ord :
            specificBuilder.MethodRef();
            break;
            case JavaEntityDescriptorEnum.MethodRefParameters_ord :
            specificBuilder.MethodRefParameters();
            break;
            case JavaEntityDescriptorEnum.MethodRefParameter_ord :
            specificBuilder.MethodRefParameter();
            break;
            case JavaEntityDescriptorEnum.MemberRef_ord :
            specificBuilder.MemberRef();
            break;
            case JavaEntityDescriptorEnum.TagElement_ord :
            specificBuilder.TagElement();
            break;
            case JavaEntityDescriptorEnum.Annotations_ord :
            specificBuilder.Annotations();
            break;
            case JavaEntityDescriptorEnum.SingleMemberAnnotation_ord :
            specificBuilder.SingleMemberAnnotation();
            break;
            case JavaEntityDescriptorEnum.MarkerAnnotation_ord :
            specificBuilder.MarkerAnnotation();
            break;
            case JavaEntityDescriptorEnum.NormalAnnotation_ord :
            specificBuilder.NormalAnnotation();
            break;
            case JavaEntityDescriptorEnum.MemberValuePairs_ord :
            specificBuilder.MemberValuePairs();
            break;
            case JavaEntityDescriptorEnum.MemberValuePair_ord :
            specificBuilder.MemberValuePair();
            break;
            case JavaEntityDescriptorEnum.ImportDeclarations_ord :
            specificBuilder.ImportDeclarations();
            break;
            case JavaEntityDescriptorEnum.ImportDeclaration_ord :
            specificBuilder.ImportDeclaration();
            break;
            case JavaEntityDescriptorEnum.TypeDeclarations_ord :
            specificBuilder.TypeDeclarations();
            break;
            case JavaEntityDescriptorEnum.EnumDeclaration_ord :
            specificBuilder.EnumDeclaration();
            break;
            case JavaEntityDescriptorEnum.EnumConstants_ord :
            specificBuilder.EnumConstants();
            break;
            case JavaEntityDescriptorEnum.EnumConstantDeclaration_ord :
            specificBuilder.EnumConstantDeclaration();
            break;
            case JavaEntityDescriptorEnum.Arguments_ord :
            specificBuilder.Arguments();
            break;
            case JavaEntityDescriptorEnum.AnonymousClassDeclaration_ord :
            specificBuilder.AnonymousClassDeclaration();
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeDeclaration_ord :
            specificBuilder.AnnotationTypeDeclaration();
            break;
            case JavaEntityDescriptorEnum.ClassDeclaration_ord :
            specificBuilder.ClassDeclaration();
            break;
            case JavaEntityDescriptorEnum.InterfaceDeclaration_ord :
            specificBuilder.InterfaceDeclaration();
            break;
            case JavaEntityDescriptorEnum.TypeParameters_ord :
            specificBuilder.TypeParameters();
            break;
            case JavaEntityDescriptorEnum.TypeParameter_ord :
            specificBuilder.TypeParameter();
            break;
            case JavaEntityDescriptorEnum.Types_ord :
            specificBuilder.Types();
            break;
            case JavaEntityDescriptorEnum.BodyDeclarations_ord :
            specificBuilder.BodyDeclarations();
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration_ord :
            specificBuilder.AnnotationTypeMemberDeclaration();
            break;
            case JavaEntityDescriptorEnum.Initializer_ord :
            specificBuilder.Initializer();
            break;
            case JavaEntityDescriptorEnum.FieldDeclaration_ord :
            specificBuilder.FieldDeclaration();
            break;
            case JavaEntityDescriptorEnum.MethodDeclaration_ord :
            specificBuilder.MethodDeclaration();
            break;
            case JavaEntityDescriptorEnum.ConstructorDeclaration_ord :
            specificBuilder.ConstructorDeclaration();
            break;
            case JavaEntityDescriptorEnum.Parameters_ord :
            specificBuilder.Parameters();
            break;
            case JavaEntityDescriptorEnum.SingleVariableDeclaration_ord :
            specificBuilder.SingleVariableDeclaration();
            break;
            case JavaEntityDescriptorEnum.AnnotatedType_ord :
            specificBuilder.AnnotatedType();
            break;
            case JavaEntityDescriptorEnum.ArrayType_ord :
            specificBuilder.ArrayType();
            break;
            case JavaEntityDescriptorEnum.ParameterizedType_ord :
            specificBuilder.ParameterizedType();
            break;
            case JavaEntityDescriptorEnum.WildcardType_ord :
            specificBuilder.WildcardType();
            break;
            case JavaEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType();
            break;
            case JavaEntityDescriptorEnum.IntersectionType_ord :
            specificBuilder.IntersectionType();
            break;
            case JavaEntityDescriptorEnum.AssertStatement_ord :
            specificBuilder.AssertStatement();
            break;
            case JavaEntityDescriptorEnum.Block_ord :
            specificBuilder.Block();
            break;
            case JavaEntityDescriptorEnum.BreakStatement_ord :
            specificBuilder.BreakStatement();
            break;
            case JavaEntityDescriptorEnum.ConstructorInvocation_ord :
            specificBuilder.ConstructorInvocation();
            break;
            case JavaEntityDescriptorEnum.ContinueStatement_ord :
            specificBuilder.ContinueStatement();
            break;
            case JavaEntityDescriptorEnum.DoStatement_ord :
            specificBuilder.DoStatement();
            break;
            case JavaEntityDescriptorEnum.EmptyStatement_ord :
            specificBuilder.EmptyStatement();
            break;
            case JavaEntityDescriptorEnum.EnhancedForStatement_ord :
            specificBuilder.EnhancedForStatement();
            break;
            case JavaEntityDescriptorEnum.ExpressionStatement_ord :
            specificBuilder.ExpressionStatement();
            break;
            case JavaEntityDescriptorEnum.ForStatement_ord :
            specificBuilder.ForStatement();
            break;
            case JavaEntityDescriptorEnum.Expressions_ord :
            specificBuilder.Expressions();
            break;
            case JavaEntityDescriptorEnum.IfStatement_ord :
            specificBuilder.IfStatement();
            break;
            case JavaEntityDescriptorEnum.LabeledStatement_ord :
            specificBuilder.LabeledStatement();
            break;
            case JavaEntityDescriptorEnum.ReturnStatement_ord :
            specificBuilder.ReturnStatement();
            break;
            case JavaEntityDescriptorEnum.SuperConstructorInvocation_ord :
            specificBuilder.SuperConstructorInvocation();
            break;
            case JavaEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder.SwitchCase();
            break;
            case JavaEntityDescriptorEnum.SwitchDefault_ord :
            specificBuilder.SwitchDefault();
            break;
            case JavaEntityDescriptorEnum.SwitchStatement_ord :
            specificBuilder.SwitchStatement();
            break;
            case JavaEntityDescriptorEnum.Statements_ord :
            specificBuilder.Statements();
            break;
            case JavaEntityDescriptorEnum.SynchronizedStatement_ord :
            specificBuilder.SynchronizedStatement();
            break;
            case JavaEntityDescriptorEnum.ThrowStatement_ord :
            specificBuilder.ThrowStatement();
            break;
            case JavaEntityDescriptorEnum.TryStatement_ord :
            specificBuilder.TryStatement();
            break;
            case JavaEntityDescriptorEnum.CatchClauses_ord :
            specificBuilder.CatchClauses();
            break;
            case JavaEntityDescriptorEnum.CatchClause_ord :
            specificBuilder.CatchClause();
            break;
            case JavaEntityDescriptorEnum.TypeDeclarationStatement_ord :
            specificBuilder.TypeDeclarationStatement();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationStatement_ord :
            specificBuilder.VariableDeclarationStatement();
            break;
            case JavaEntityDescriptorEnum.WhileStatement_ord :
            specificBuilder.WhileStatement();
            break;
            case JavaEntityDescriptorEnum.NullLiteral_ord :
            specificBuilder.NullLiteral();
            break;
            case JavaEntityDescriptorEnum.TypeLiteral_ord :
            specificBuilder.TypeLiteral();
            break;
            case JavaEntityDescriptorEnum.ArrayAccess_ord :
            specificBuilder.ArrayAccess();
            break;
            case JavaEntityDescriptorEnum.ArrayCreation_ord :
            specificBuilder.ArrayCreation();
            break;
            case JavaEntityDescriptorEnum.ArrayInitializer_ord :
            specificBuilder.ArrayInitializer();
            break;
            case JavaEntityDescriptorEnum.Assignment_ord :
            specificBuilder.Assignment();
            break;
            case JavaEntityDescriptorEnum.CastExpression_ord :
            specificBuilder.CastExpression();
            break;
            case JavaEntityDescriptorEnum.ClassInstanceCreation_ord :
            specificBuilder.ClassInstanceCreation();
            break;
            case JavaEntityDescriptorEnum.ConditionalExpression_ord :
            specificBuilder.ConditionalExpression();
            break;
            case JavaEntityDescriptorEnum.FieldAccess_ord :
            specificBuilder.FieldAccess();
            break;
            case JavaEntityDescriptorEnum.InfixExpression_ord :
            specificBuilder.InfixExpression();
            break;
            case JavaEntityDescriptorEnum.InstanceofExpression_ord :
            specificBuilder.InstanceofExpression();
            break;
            case JavaEntityDescriptorEnum.LambdaExpression_ord :
            specificBuilder.LambdaExpression();
            break;
            case JavaEntityDescriptorEnum.MethodInvocation_ord :
            specificBuilder.MethodInvocation();
            break;
            case JavaEntityDescriptorEnum.ParenthesizedExpression_ord :
            specificBuilder.ParenthesizedExpression();
            break;
            case JavaEntityDescriptorEnum.PostfixExpression_ord :
            specificBuilder.PostfixExpression();
            break;
            case JavaEntityDescriptorEnum.PrefixExpression_ord :
            specificBuilder.PrefixExpression();
            break;
            case JavaEntityDescriptorEnum.SuperFieldAccess_ord :
            specificBuilder.SuperFieldAccess();
            break;
            case JavaEntityDescriptorEnum.SuperMethodInvocation_ord :
            specificBuilder.SuperMethodInvocation();
            break;
            case JavaEntityDescriptorEnum.ThisExpression_ord :
            specificBuilder.ThisExpression();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationExpression_ord :
            specificBuilder.VariableDeclarationExpression();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragments_ord :
            specificBuilder.VariableDeclarationFragments();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragment_ord :
            specificBuilder.VariableDeclarationFragment();
            break;
            case JavaEntityDescriptorEnum.ExtendedModifiers_ord :
            specificBuilder.ExtendedModifiers();
            break;
            case JavaEntityDescriptorEnum.ConstructorReference_ord :
            specificBuilder.ConstructorReference();
            break;
            case JavaEntityDescriptorEnum.ExpressionMethodReference_ord :
            specificBuilder.ExpressionMethodReference();
            break;
            case JavaEntityDescriptorEnum.SuperMethodReference_ord :
            specificBuilder.SuperMethodReference();
            break;
            case JavaEntityDescriptorEnum.TypeMethodReference_ord :
            specificBuilder.TypeMethodReference();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.JavaSystemSoftware_ord :
            specificBuilder.JavaSystemSoftware_();
            break;
            case JavaEntityDescriptorEnum.CompilationUnit_ord :
            specificBuilder.CompilationUnit_();
            break;
            case JavaEntityDescriptorEnum.PackageDeclaration_ord :
            specificBuilder.PackageDeclaration_();
            break;
            case JavaEntityDescriptorEnum.BlockComment_ord :
            specificBuilder.BlockComment_();
            break;
            case JavaEntityDescriptorEnum.LineComment_ord :
            specificBuilder.LineComment_();
            break;
            case JavaEntityDescriptorEnum.Javadoc_ord :
            specificBuilder.Javadoc_();
            break;
            case JavaEntityDescriptorEnum.Tags_ord :
            specificBuilder.Tags_();
            break;
            case JavaEntityDescriptorEnum.DocElements_ord :
            specificBuilder.DocElements_();
            break;
            case JavaEntityDescriptorEnum.MethodRef_ord :
            specificBuilder.MethodRef_();
            break;
            case JavaEntityDescriptorEnum.MethodRefParameters_ord :
            specificBuilder.MethodRefParameters_();
            break;
            case JavaEntityDescriptorEnum.MethodRefParameter_ord :
            specificBuilder.MethodRefParameter_();
            break;
            case JavaEntityDescriptorEnum.MemberRef_ord :
            specificBuilder.MemberRef_();
            break;
            case JavaEntityDescriptorEnum.TagElement_ord :
            specificBuilder.TagElement_();
            break;
            case JavaEntityDescriptorEnum.Annotations_ord :
            specificBuilder.Annotations_();
            break;
            case JavaEntityDescriptorEnum.SingleMemberAnnotation_ord :
            specificBuilder.SingleMemberAnnotation_();
            break;
            case JavaEntityDescriptorEnum.MarkerAnnotation_ord :
            specificBuilder.MarkerAnnotation_();
            break;
            case JavaEntityDescriptorEnum.NormalAnnotation_ord :
            specificBuilder.NormalAnnotation_();
            break;
            case JavaEntityDescriptorEnum.MemberValuePairs_ord :
            specificBuilder.MemberValuePairs_();
            break;
            case JavaEntityDescriptorEnum.MemberValuePair_ord :
            specificBuilder.MemberValuePair_();
            break;
            case JavaEntityDescriptorEnum.ImportDeclarations_ord :
            specificBuilder.ImportDeclarations_();
            break;
            case JavaEntityDescriptorEnum.ImportDeclaration_ord :
            specificBuilder.ImportDeclaration_();
            break;
            case JavaEntityDescriptorEnum.TypeDeclarations_ord :
            specificBuilder.TypeDeclarations_();
            break;
            case JavaEntityDescriptorEnum.EnumDeclaration_ord :
            specificBuilder.EnumDeclaration_();
            break;
            case JavaEntityDescriptorEnum.EnumConstants_ord :
            specificBuilder.EnumConstants_();
            break;
            case JavaEntityDescriptorEnum.EnumConstantDeclaration_ord :
            specificBuilder.EnumConstantDeclaration_();
            break;
            case JavaEntityDescriptorEnum.Arguments_ord :
            specificBuilder.Arguments_();
            break;
            case JavaEntityDescriptorEnum.AnonymousClassDeclaration_ord :
            specificBuilder.AnonymousClassDeclaration_();
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeDeclaration_ord :
            specificBuilder.AnnotationTypeDeclaration_();
            break;
            case JavaEntityDescriptorEnum.ClassDeclaration_ord :
            specificBuilder.ClassDeclaration_();
            break;
            case JavaEntityDescriptorEnum.InterfaceDeclaration_ord :
            specificBuilder.InterfaceDeclaration_();
            break;
            case JavaEntityDescriptorEnum.TypeParameters_ord :
            specificBuilder.TypeParameters_();
            break;
            case JavaEntityDescriptorEnum.TypeParameter_ord :
            specificBuilder.TypeParameter_();
            break;
            case JavaEntityDescriptorEnum.Types_ord :
            specificBuilder.Types_();
            break;
            case JavaEntityDescriptorEnum.BodyDeclarations_ord :
            specificBuilder.BodyDeclarations_();
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration_ord :
            specificBuilder.AnnotationTypeMemberDeclaration_();
            break;
            case JavaEntityDescriptorEnum.Initializer_ord :
            specificBuilder.Initializer_();
            break;
            case JavaEntityDescriptorEnum.FieldDeclaration_ord :
            specificBuilder.FieldDeclaration_();
            break;
            case JavaEntityDescriptorEnum.MethodDeclaration_ord :
            specificBuilder.MethodDeclaration_();
            break;
            case JavaEntityDescriptorEnum.ConstructorDeclaration_ord :
            specificBuilder.ConstructorDeclaration_();
            break;
            case JavaEntityDescriptorEnum.Parameters_ord :
            specificBuilder.Parameters_();
            break;
            case JavaEntityDescriptorEnum.SingleVariableDeclaration_ord :
            specificBuilder.SingleVariableDeclaration_();
            break;
            case JavaEntityDescriptorEnum.AnnotatedType_ord :
            specificBuilder.AnnotatedType_();
            break;
            case JavaEntityDescriptorEnum.ArrayType_ord :
            specificBuilder.ArrayType_();
            break;
            case JavaEntityDescriptorEnum.ParameterizedType_ord :
            specificBuilder.ParameterizedType_();
            break;
            case JavaEntityDescriptorEnum.WildcardType_ord :
            specificBuilder.WildcardType_();
            break;
            case JavaEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType_();
            break;
            case JavaEntityDescriptorEnum.IntersectionType_ord :
            specificBuilder.IntersectionType_();
            break;
            case JavaEntityDescriptorEnum.AssertStatement_ord :
            specificBuilder.AssertStatement_();
            break;
            case JavaEntityDescriptorEnum.Block_ord :
            specificBuilder.Block_();
            break;
            case JavaEntityDescriptorEnum.BreakStatement_ord :
            specificBuilder.BreakStatement_();
            break;
            case JavaEntityDescriptorEnum.ConstructorInvocation_ord :
            specificBuilder.ConstructorInvocation_();
            break;
            case JavaEntityDescriptorEnum.ContinueStatement_ord :
            specificBuilder.ContinueStatement_();
            break;
            case JavaEntityDescriptorEnum.DoStatement_ord :
            specificBuilder.DoStatement_();
            break;
            case JavaEntityDescriptorEnum.EmptyStatement_ord :
            specificBuilder.EmptyStatement_();
            break;
            case JavaEntityDescriptorEnum.EnhancedForStatement_ord :
            specificBuilder.EnhancedForStatement_();
            break;
            case JavaEntityDescriptorEnum.ExpressionStatement_ord :
            specificBuilder.ExpressionStatement_();
            break;
            case JavaEntityDescriptorEnum.ForStatement_ord :
            specificBuilder.ForStatement_();
            break;
            case JavaEntityDescriptorEnum.Expressions_ord :
            specificBuilder.Expressions_();
            break;
            case JavaEntityDescriptorEnum.IfStatement_ord :
            specificBuilder.IfStatement_();
            break;
            case JavaEntityDescriptorEnum.LabeledStatement_ord :
            specificBuilder.LabeledStatement_();
            break;
            case JavaEntityDescriptorEnum.ReturnStatement_ord :
            specificBuilder.ReturnStatement_();
            break;
            case JavaEntityDescriptorEnum.SuperConstructorInvocation_ord :
            specificBuilder.SuperConstructorInvocation_();
            break;
            case JavaEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder.SwitchCase_();
            break;
            case JavaEntityDescriptorEnum.SwitchDefault_ord :
            specificBuilder.SwitchDefault_();
            break;
            case JavaEntityDescriptorEnum.SwitchStatement_ord :
            specificBuilder.SwitchStatement_();
            break;
            case JavaEntityDescriptorEnum.Statements_ord :
            specificBuilder.Statements_();
            break;
            case JavaEntityDescriptorEnum.SynchronizedStatement_ord :
            specificBuilder.SynchronizedStatement_();
            break;
            case JavaEntityDescriptorEnum.ThrowStatement_ord :
            specificBuilder.ThrowStatement_();
            break;
            case JavaEntityDescriptorEnum.TryStatement_ord :
            specificBuilder.TryStatement_();
            break;
            case JavaEntityDescriptorEnum.CatchClauses_ord :
            specificBuilder.CatchClauses_();
            break;
            case JavaEntityDescriptorEnum.CatchClause_ord :
            specificBuilder.CatchClause_();
            break;
            case JavaEntityDescriptorEnum.TypeDeclarationStatement_ord :
            specificBuilder.TypeDeclarationStatement_();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationStatement_ord :
            specificBuilder.VariableDeclarationStatement_();
            break;
            case JavaEntityDescriptorEnum.WhileStatement_ord :
            specificBuilder.WhileStatement_();
            break;
            case JavaEntityDescriptorEnum.NullLiteral_ord :
            specificBuilder.NullLiteral_();
            break;
            case JavaEntityDescriptorEnum.TypeLiteral_ord :
            specificBuilder.TypeLiteral_();
            break;
            case JavaEntityDescriptorEnum.ArrayAccess_ord :
            specificBuilder.ArrayAccess_();
            break;
            case JavaEntityDescriptorEnum.ArrayCreation_ord :
            specificBuilder.ArrayCreation_();
            break;
            case JavaEntityDescriptorEnum.ArrayInitializer_ord :
            specificBuilder.ArrayInitializer_();
            break;
            case JavaEntityDescriptorEnum.Assignment_ord :
            specificBuilder.Assignment_();
            break;
            case JavaEntityDescriptorEnum.CastExpression_ord :
            specificBuilder.CastExpression_();
            break;
            case JavaEntityDescriptorEnum.ClassInstanceCreation_ord :
            specificBuilder.ClassInstanceCreation_();
            break;
            case JavaEntityDescriptorEnum.ConditionalExpression_ord :
            specificBuilder.ConditionalExpression_();
            break;
            case JavaEntityDescriptorEnum.FieldAccess_ord :
            specificBuilder.FieldAccess_();
            break;
            case JavaEntityDescriptorEnum.InfixExpression_ord :
            specificBuilder.InfixExpression_();
            break;
            case JavaEntityDescriptorEnum.InstanceofExpression_ord :
            specificBuilder.InstanceofExpression_();
            break;
            case JavaEntityDescriptorEnum.LambdaExpression_ord :
            specificBuilder.LambdaExpression_();
            break;
            case JavaEntityDescriptorEnum.MethodInvocation_ord :
            specificBuilder.MethodInvocation_();
            break;
            case JavaEntityDescriptorEnum.ParenthesizedExpression_ord :
            specificBuilder.ParenthesizedExpression_();
            break;
            case JavaEntityDescriptorEnum.PostfixExpression_ord :
            specificBuilder.PostfixExpression_();
            break;
            case JavaEntityDescriptorEnum.PrefixExpression_ord :
            specificBuilder.PrefixExpression_();
            break;
            case JavaEntityDescriptorEnum.SuperFieldAccess_ord :
            specificBuilder.SuperFieldAccess_();
            break;
            case JavaEntityDescriptorEnum.SuperMethodInvocation_ord :
            specificBuilder.SuperMethodInvocation_();
            break;
            case JavaEntityDescriptorEnum.ThisExpression_ord :
            specificBuilder.ThisExpression_();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationExpression_ord :
            specificBuilder.VariableDeclarationExpression_();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragments_ord :
            specificBuilder.VariableDeclarationFragments_();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragment_ord :
            specificBuilder.VariableDeclarationFragment_();
            break;
            case JavaEntityDescriptorEnum.ExtendedModifiers_ord :
            specificBuilder.ExtendedModifiers_();
            break;
            case JavaEntityDescriptorEnum.ConstructorReference_ord :
            specificBuilder.ConstructorReference_();
            break;
            case JavaEntityDescriptorEnum.ExpressionMethodReference_ord :
            specificBuilder.ExpressionMethodReference_();
            break;
            case JavaEntityDescriptorEnum.SuperMethodReference_ord :
            specificBuilder.SuperMethodReference_();
            break;
            case JavaEntityDescriptorEnum.TypeMethodReference_ord :
            specificBuilder.TypeMethodReference_();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.JavaSystemSoftware_ord :
            specificBuilder.JavaSystemSoftware_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Tags_ord :
            specificBuilder.Tags_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.DocElements_ord :
            specificBuilder.DocElements_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.MethodRefParameters_ord :
            specificBuilder.MethodRefParameters_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Annotations_ord :
            specificBuilder.Annotations_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.MemberValuePairs_ord :
            specificBuilder.MemberValuePairs_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.ImportDeclarations_ord :
            specificBuilder.ImportDeclarations_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.TypeDeclarations_ord :
            specificBuilder.TypeDeclarations_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.EnumConstants_ord :
            specificBuilder.EnumConstants_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Arguments_ord :
            specificBuilder.Arguments_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.AnonymousClassDeclaration_ord :
            specificBuilder.AnonymousClassDeclaration_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.TypeParameters_ord :
            specificBuilder.TypeParameters_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Types_ord :
            specificBuilder.Types_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.BodyDeclarations_ord :
            specificBuilder.BodyDeclarations_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Parameters_ord :
            specificBuilder.Parameters_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.IntersectionType_ord :
            specificBuilder.IntersectionType_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Block_ord :
            specificBuilder.Block_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Expressions_ord :
            specificBuilder.Expressions_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.Statements_ord :
            specificBuilder.Statements_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.CatchClauses_ord :
            specificBuilder.CatchClauses_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.ArrayInitializer_ord :
            specificBuilder.ArrayInitializer_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragments_ord :
            specificBuilder.VariableDeclarationFragments_(initialCapacity);
            break;
            case JavaEntityDescriptorEnum.ExtendedModifiers_ord :
            specificBuilder.ExtendedModifiers_(initialCapacity);
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.JavaSystemSoftware_ord :
            specificBuilder._JavaSystemSoftware();
            break;
            case JavaEntityDescriptorEnum.CompilationUnit_ord :
            specificBuilder._CompilationUnit();
            break;
            case JavaEntityDescriptorEnum.PackageDeclaration_ord :
            specificBuilder._PackageDeclaration();
            break;
            case JavaEntityDescriptorEnum.BlockComment_ord :
            specificBuilder._BlockComment();
            break;
            case JavaEntityDescriptorEnum.LineComment_ord :
            specificBuilder._LineComment();
            break;
            case JavaEntityDescriptorEnum.Javadoc_ord :
            specificBuilder._Javadoc();
            break;
            case JavaEntityDescriptorEnum.Tags_ord :
            specificBuilder._Tags();
            break;
            case JavaEntityDescriptorEnum.DocElements_ord :
            specificBuilder._DocElements();
            break;
            case JavaEntityDescriptorEnum.MethodRef_ord :
            specificBuilder._MethodRef();
            break;
            case JavaEntityDescriptorEnum.MethodRefParameters_ord :
            specificBuilder._MethodRefParameters();
            break;
            case JavaEntityDescriptorEnum.MethodRefParameter_ord :
            specificBuilder._MethodRefParameter();
            break;
            case JavaEntityDescriptorEnum.MemberRef_ord :
            specificBuilder._MemberRef();
            break;
            case JavaEntityDescriptorEnum.TagElement_ord :
            specificBuilder._TagElement();
            break;
            case JavaEntityDescriptorEnum.Annotations_ord :
            specificBuilder._Annotations();
            break;
            case JavaEntityDescriptorEnum.SingleMemberAnnotation_ord :
            specificBuilder._SingleMemberAnnotation();
            break;
            case JavaEntityDescriptorEnum.MarkerAnnotation_ord :
            specificBuilder._MarkerAnnotation();
            break;
            case JavaEntityDescriptorEnum.NormalAnnotation_ord :
            specificBuilder._NormalAnnotation();
            break;
            case JavaEntityDescriptorEnum.MemberValuePairs_ord :
            specificBuilder._MemberValuePairs();
            break;
            case JavaEntityDescriptorEnum.MemberValuePair_ord :
            specificBuilder._MemberValuePair();
            break;
            case JavaEntityDescriptorEnum.ImportDeclarations_ord :
            specificBuilder._ImportDeclarations();
            break;
            case JavaEntityDescriptorEnum.ImportDeclaration_ord :
            specificBuilder._ImportDeclaration();
            break;
            case JavaEntityDescriptorEnum.TypeDeclarations_ord :
            specificBuilder._TypeDeclarations();
            break;
            case JavaEntityDescriptorEnum.EnumDeclaration_ord :
            specificBuilder._EnumDeclaration();
            break;
            case JavaEntityDescriptorEnum.EnumConstants_ord :
            specificBuilder._EnumConstants();
            break;
            case JavaEntityDescriptorEnum.EnumConstantDeclaration_ord :
            specificBuilder._EnumConstantDeclaration();
            break;
            case JavaEntityDescriptorEnum.Arguments_ord :
            specificBuilder._Arguments();
            break;
            case JavaEntityDescriptorEnum.AnonymousClassDeclaration_ord :
            specificBuilder._AnonymousClassDeclaration();
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeDeclaration_ord :
            specificBuilder._AnnotationTypeDeclaration();
            break;
            case JavaEntityDescriptorEnum.ClassDeclaration_ord :
            specificBuilder._ClassDeclaration();
            break;
            case JavaEntityDescriptorEnum.InterfaceDeclaration_ord :
            specificBuilder._InterfaceDeclaration();
            break;
            case JavaEntityDescriptorEnum.TypeParameters_ord :
            specificBuilder._TypeParameters();
            break;
            case JavaEntityDescriptorEnum.TypeParameter_ord :
            specificBuilder._TypeParameter();
            break;
            case JavaEntityDescriptorEnum.Types_ord :
            specificBuilder._Types();
            break;
            case JavaEntityDescriptorEnum.BodyDeclarations_ord :
            specificBuilder._BodyDeclarations();
            break;
            case JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration_ord :
            specificBuilder._AnnotationTypeMemberDeclaration();
            break;
            case JavaEntityDescriptorEnum.Initializer_ord :
            specificBuilder._Initializer();
            break;
            case JavaEntityDescriptorEnum.FieldDeclaration_ord :
            specificBuilder._FieldDeclaration();
            break;
            case JavaEntityDescriptorEnum.MethodDeclaration_ord :
            specificBuilder._MethodDeclaration();
            break;
            case JavaEntityDescriptorEnum.ConstructorDeclaration_ord :
            specificBuilder._ConstructorDeclaration();
            break;
            case JavaEntityDescriptorEnum.Parameters_ord :
            specificBuilder._Parameters();
            break;
            case JavaEntityDescriptorEnum.SingleVariableDeclaration_ord :
            specificBuilder._SingleVariableDeclaration();
            break;
            case JavaEntityDescriptorEnum.AnnotatedType_ord :
            specificBuilder._AnnotatedType();
            break;
            case JavaEntityDescriptorEnum.ArrayType_ord :
            specificBuilder._ArrayType();
            break;
            case JavaEntityDescriptorEnum.ParameterizedType_ord :
            specificBuilder._ParameterizedType();
            break;
            case JavaEntityDescriptorEnum.WildcardType_ord :
            specificBuilder._WildcardType();
            break;
            case JavaEntityDescriptorEnum.UnionType_ord :
            specificBuilder._UnionType();
            break;
            case JavaEntityDescriptorEnum.IntersectionType_ord :
            specificBuilder._IntersectionType();
            break;
            case JavaEntityDescriptorEnum.AssertStatement_ord :
            specificBuilder._AssertStatement();
            break;
            case JavaEntityDescriptorEnum.Block_ord :
            specificBuilder._Block();
            break;
            case JavaEntityDescriptorEnum.BreakStatement_ord :
            specificBuilder._BreakStatement();
            break;
            case JavaEntityDescriptorEnum.ConstructorInvocation_ord :
            specificBuilder._ConstructorInvocation();
            break;
            case JavaEntityDescriptorEnum.ContinueStatement_ord :
            specificBuilder._ContinueStatement();
            break;
            case JavaEntityDescriptorEnum.DoStatement_ord :
            specificBuilder._DoStatement();
            break;
            case JavaEntityDescriptorEnum.EmptyStatement_ord :
            specificBuilder._EmptyStatement();
            break;
            case JavaEntityDescriptorEnum.EnhancedForStatement_ord :
            specificBuilder._EnhancedForStatement();
            break;
            case JavaEntityDescriptorEnum.ExpressionStatement_ord :
            specificBuilder._ExpressionStatement();
            break;
            case JavaEntityDescriptorEnum.ForStatement_ord :
            specificBuilder._ForStatement();
            break;
            case JavaEntityDescriptorEnum.Expressions_ord :
            specificBuilder._Expressions();
            break;
            case JavaEntityDescriptorEnum.IfStatement_ord :
            specificBuilder._IfStatement();
            break;
            case JavaEntityDescriptorEnum.LabeledStatement_ord :
            specificBuilder._LabeledStatement();
            break;
            case JavaEntityDescriptorEnum.ReturnStatement_ord :
            specificBuilder._ReturnStatement();
            break;
            case JavaEntityDescriptorEnum.SuperConstructorInvocation_ord :
            specificBuilder._SuperConstructorInvocation();
            break;
            case JavaEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder._SwitchCase();
            break;
            case JavaEntityDescriptorEnum.SwitchDefault_ord :
            specificBuilder._SwitchDefault();
            break;
            case JavaEntityDescriptorEnum.SwitchStatement_ord :
            specificBuilder._SwitchStatement();
            break;
            case JavaEntityDescriptorEnum.Statements_ord :
            specificBuilder._Statements();
            break;
            case JavaEntityDescriptorEnum.SynchronizedStatement_ord :
            specificBuilder._SynchronizedStatement();
            break;
            case JavaEntityDescriptorEnum.ThrowStatement_ord :
            specificBuilder._ThrowStatement();
            break;
            case JavaEntityDescriptorEnum.TryStatement_ord :
            specificBuilder._TryStatement();
            break;
            case JavaEntityDescriptorEnum.CatchClauses_ord :
            specificBuilder._CatchClauses();
            break;
            case JavaEntityDescriptorEnum.CatchClause_ord :
            specificBuilder._CatchClause();
            break;
            case JavaEntityDescriptorEnum.TypeDeclarationStatement_ord :
            specificBuilder._TypeDeclarationStatement();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationStatement_ord :
            specificBuilder._VariableDeclarationStatement();
            break;
            case JavaEntityDescriptorEnum.WhileStatement_ord :
            specificBuilder._WhileStatement();
            break;
            case JavaEntityDescriptorEnum.NullLiteral_ord :
            specificBuilder._NullLiteral();
            break;
            case JavaEntityDescriptorEnum.TypeLiteral_ord :
            specificBuilder._TypeLiteral();
            break;
            case JavaEntityDescriptorEnum.ArrayAccess_ord :
            specificBuilder._ArrayAccess();
            break;
            case JavaEntityDescriptorEnum.ArrayCreation_ord :
            specificBuilder._ArrayCreation();
            break;
            case JavaEntityDescriptorEnum.ArrayInitializer_ord :
            specificBuilder._ArrayInitializer();
            break;
            case JavaEntityDescriptorEnum.Assignment_ord :
            specificBuilder._Assignment();
            break;
            case JavaEntityDescriptorEnum.CastExpression_ord :
            specificBuilder._CastExpression();
            break;
            case JavaEntityDescriptorEnum.ClassInstanceCreation_ord :
            specificBuilder._ClassInstanceCreation();
            break;
            case JavaEntityDescriptorEnum.ConditionalExpression_ord :
            specificBuilder._ConditionalExpression();
            break;
            case JavaEntityDescriptorEnum.FieldAccess_ord :
            specificBuilder._FieldAccess();
            break;
            case JavaEntityDescriptorEnum.InfixExpression_ord :
            specificBuilder._InfixExpression();
            break;
            case JavaEntityDescriptorEnum.InstanceofExpression_ord :
            specificBuilder._InstanceofExpression();
            break;
            case JavaEntityDescriptorEnum.LambdaExpression_ord :
            specificBuilder._LambdaExpression();
            break;
            case JavaEntityDescriptorEnum.MethodInvocation_ord :
            specificBuilder._MethodInvocation();
            break;
            case JavaEntityDescriptorEnum.ParenthesizedExpression_ord :
            specificBuilder._ParenthesizedExpression();
            break;
            case JavaEntityDescriptorEnum.PostfixExpression_ord :
            specificBuilder._PostfixExpression();
            break;
            case JavaEntityDescriptorEnum.PrefixExpression_ord :
            specificBuilder._PrefixExpression();
            break;
            case JavaEntityDescriptorEnum.SuperFieldAccess_ord :
            specificBuilder._SuperFieldAccess();
            break;
            case JavaEntityDescriptorEnum.SuperMethodInvocation_ord :
            specificBuilder._SuperMethodInvocation();
            break;
            case JavaEntityDescriptorEnum.ThisExpression_ord :
            specificBuilder._ThisExpression();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationExpression_ord :
            specificBuilder._VariableDeclarationExpression();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragments_ord :
            specificBuilder._VariableDeclarationFragments();
            break;
            case JavaEntityDescriptorEnum.VariableDeclarationFragment_ord :
            specificBuilder._VariableDeclarationFragment();
            break;
            case JavaEntityDescriptorEnum.ExtendedModifiers_ord :
            specificBuilder._ExtendedModifiers();
            break;
            case JavaEntityDescriptorEnum.ConstructorReference_ord :
            specificBuilder._ConstructorReference();
            break;
            case JavaEntityDescriptorEnum.ExpressionMethodReference_ord :
            specificBuilder._ExpressionMethodReference();
            break;
            case JavaEntityDescriptorEnum.SuperMethodReference_ord :
            specificBuilder._SuperMethodReference();
            break;
            case JavaEntityDescriptorEnum.TypeMethodReference_ord :
            specificBuilder._TypeMethodReference();
            break;
        }
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case JavaFeatureDescriptorEnum._package_ord :
            specificBuilder._package();
            break;
            case JavaFeatureDescriptorEnum.imports_ord :
            specificBuilder.imports();
            break;
            case JavaFeatureDescriptorEnum.types_ord :
            specificBuilder.types();
            break;
            case JavaFeatureDescriptorEnum.javadoc_ord :
            specificBuilder.javadoc();
            break;
            case JavaFeatureDescriptorEnum.annotations_ord :
            specificBuilder.annotations();
            break;
            case JavaFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case JavaFeatureDescriptorEnum.docElements_ord :
            specificBuilder.docElements();
            break;
            case JavaFeatureDescriptorEnum.text_ord :
            specificBuilder.text();
            break;
            case JavaFeatureDescriptorEnum.tags_ord :
            specificBuilder.tags();
            break;
            case JavaFeatureDescriptorEnum.qualifier_ord :
            specificBuilder.qualifier();
            break;
            case JavaFeatureDescriptorEnum.parameters_ord :
            specificBuilder.parameters();
            break;
            case JavaFeatureDescriptorEnum.type_ord :
            specificBuilder.type();
            break;
            case JavaFeatureDescriptorEnum.varargs_ord :
            specificBuilder.varargs();
            break;
            case JavaFeatureDescriptorEnum.tagName_ord :
            specificBuilder.tagName();
            break;
            case JavaFeatureDescriptorEnum.fragments_ord :
            specificBuilder.fragments();
            break;
            case JavaFeatureDescriptorEnum.typeName_ord :
            specificBuilder.typeName();
            break;
            case JavaFeatureDescriptorEnum.value_ord :
            specificBuilder.value();
            break;
            case JavaFeatureDescriptorEnum.values_ord :
            specificBuilder.values();
            break;
            case JavaFeatureDescriptorEnum.onDemand_ord :
            specificBuilder.onDemand();
            break;
            case JavaFeatureDescriptorEnum._static_ord :
            specificBuilder._static();
            break;
            case JavaFeatureDescriptorEnum.modifiers_ord :
            specificBuilder.modifiers();
            break;
            case JavaFeatureDescriptorEnum.bodyDeclarations_ord :
            specificBuilder.bodyDeclarations();
            break;
            case JavaFeatureDescriptorEnum.superInterfaceTypes_ord :
            specificBuilder.superInterfaceTypes();
            break;
            case JavaFeatureDescriptorEnum.enumConstants_ord :
            specificBuilder.enumConstants();
            break;
            case JavaFeatureDescriptorEnum.arguments_ord :
            specificBuilder.arguments();
            break;
            case JavaFeatureDescriptorEnum.anonymousClassDeclaration_ord :
            specificBuilder.anonymousClassDeclaration();
            break;
            case JavaFeatureDescriptorEnum.typeParameters_ord :
            specificBuilder.typeParameters();
            break;
            case JavaFeatureDescriptorEnum.superclassType_ord :
            specificBuilder.superclassType();
            break;
            case JavaFeatureDescriptorEnum.typeBounds_ord :
            specificBuilder.typeBounds();
            break;
            case JavaFeatureDescriptorEnum._default_ord :
            specificBuilder._default();
            break;
            case JavaFeatureDescriptorEnum.body_ord :
            specificBuilder.body();
            break;
            case JavaFeatureDescriptorEnum.returnType_ord :
            specificBuilder.returnType();
            break;
            case JavaFeatureDescriptorEnum.extraDimensions_ord :
            specificBuilder.extraDimensions();
            break;
            case JavaFeatureDescriptorEnum.thrownExceptions_ord :
            specificBuilder.thrownExceptions();
            break;
            case JavaFeatureDescriptorEnum.initializer_ord :
            specificBuilder.initializer();
            break;
            case JavaFeatureDescriptorEnum.varargsAnnotations_ord :
            specificBuilder.varargsAnnotations();
            break;
            case JavaFeatureDescriptorEnum.componentType_ord :
            specificBuilder.componentType();
            break;
            case JavaFeatureDescriptorEnum.typeArguments_ord :
            specificBuilder.typeArguments();
            break;
            case JavaFeatureDescriptorEnum.bound_ord :
            specificBuilder.bound();
            break;
            case JavaFeatureDescriptorEnum.upperBound_ord :
            specificBuilder.upperBound();
            break;
            case JavaFeatureDescriptorEnum.expression_ord :
            specificBuilder.expression();
            break;
            case JavaFeatureDescriptorEnum.message_ord :
            specificBuilder.message();
            break;
            case JavaFeatureDescriptorEnum.label_ord :
            specificBuilder.label();
            break;
            case JavaFeatureDescriptorEnum.parameter_ord :
            specificBuilder.parameter();
            break;
            case JavaFeatureDescriptorEnum.initializers_ord :
            specificBuilder.initializers();
            break;
            case JavaFeatureDescriptorEnum.updaters_ord :
            specificBuilder.updaters();
            break;
            case JavaFeatureDescriptorEnum.thenStatement_ord :
            specificBuilder.thenStatement();
            break;
            case JavaFeatureDescriptorEnum.elseStatement_ord :
            specificBuilder.elseStatement();
            break;
            case JavaFeatureDescriptorEnum.statements_ord :
            specificBuilder.statements();
            break;
            case JavaFeatureDescriptorEnum.catchClauses_ord :
            specificBuilder.catchClauses();
            break;
            case JavaFeatureDescriptorEnum._finally_ord :
            specificBuilder._finally();
            break;
            case JavaFeatureDescriptorEnum.exception_ord :
            specificBuilder.exception();
            break;
            case JavaFeatureDescriptorEnum.typeDeclaration_ord :
            specificBuilder.typeDeclaration();
            break;
            case JavaFeatureDescriptorEnum.array_ord :
            specificBuilder.array();
            break;
            case JavaFeatureDescriptorEnum.index_ord :
            specificBuilder.index();
            break;
            case JavaFeatureDescriptorEnum.dimensions_ord :
            specificBuilder.dimensions();
            break;
            case JavaFeatureDescriptorEnum.leftHandSide_ord :
            specificBuilder.leftHandSide();
            break;
            case JavaFeatureDescriptorEnum.operator_ord :
            specificBuilder.operator();
            break;
            case JavaFeatureDescriptorEnum.rightHandSide_ord :
            specificBuilder.rightHandSide();
            break;
            case JavaFeatureDescriptorEnum.thenExpression_ord :
            specificBuilder.thenExpression();
            break;
            case JavaFeatureDescriptorEnum.elseExpression_ord :
            specificBuilder.elseExpression();
            break;
            case JavaFeatureDescriptorEnum.leftOperand_ord :
            specificBuilder.leftOperand();
            break;
            case JavaFeatureDescriptorEnum.rightOperand_ord :
            specificBuilder.rightOperand();
            break;
            case JavaFeatureDescriptorEnum.extendedOperands_ord :
            specificBuilder.extendedOperands();
            break;
            case JavaFeatureDescriptorEnum.operand_ord :
            specificBuilder.operand();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.TextElement_ord :
            specificBuilder.TextElement(value);
            break;
            case JavaEntityDescriptorEnum.TagName_ord :
            specificBuilder.TagName(value);
            break;
            case JavaEntityDescriptorEnum.QualifiedType_ord :
            specificBuilder.QualifiedType(value);
            break;
            case JavaEntityDescriptorEnum.SimpleType_ord :
            specificBuilder.SimpleType(value);
            break;
            case JavaEntityDescriptorEnum.SimpleName_ord :
            specificBuilder.SimpleName(value);
            break;
            case JavaEntityDescriptorEnum.QualifiedName_ord :
            specificBuilder.QualifiedName(value);
            break;
            case JavaEntityDescriptorEnum.StringLiteral_ord :
            specificBuilder.StringLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.ImportModifier_ord :
            specificBuilder.ImportModifier(value);
            break;
            case JavaEntityDescriptorEnum.Varargs_ord :
            specificBuilder.Varargs(value);
            break;
            case JavaEntityDescriptorEnum.UpperBound_ord :
            specificBuilder.UpperBound(value);
            break;
            case JavaEntityDescriptorEnum.BooleanLiteral_ord :
            specificBuilder.BooleanLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.PrimitiveType_ord :
            specificBuilder.PrimitiveType((Value) value);
            break;
            case JavaEntityDescriptorEnum.AssignmentOperator_ord :
            specificBuilder.AssignmentOperator((org.whole.lang.java.model.AssignmentOperatorEnum.Value) value);
            break;
            case JavaEntityDescriptorEnum.InfixOperator_ord :
            specificBuilder.InfixOperator((org.whole.lang.java.model.InfixOperatorEnum.Value) value);
            break;
            case JavaEntityDescriptorEnum.PostfixOperator_ord :
            specificBuilder.PostfixOperator((org.whole.lang.java.model.PostfixOperatorEnum.Value) value);
            break;
            case JavaEntityDescriptorEnum.PrefixOperator_ord :
            specificBuilder.PrefixOperator((org.whole.lang.java.model.PrefixOperatorEnum.Value) value);
            break;
            case JavaEntityDescriptorEnum.Modifier_ord :
            specificBuilder.Modifier((org.whole.lang.java.model.ModifierEnum.Value) value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.ByteLiteral_ord :
            specificBuilder.ByteLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, char value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.CharLiteral_ord :
            specificBuilder.CharLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.DoubleLiteral_ord :
            specificBuilder.DoubleLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.FloatLiteral_ord :
            specificBuilder.FloatLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.IntLiteral_ord :
            specificBuilder.IntLiteral(value);
            break;
            case JavaEntityDescriptorEnum.ExtraDimensions_ord :
            specificBuilder.ExtraDimensions(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.ShortLiteral_ord :
            specificBuilder.ShortLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        switch (entityDesc.getOrdinal()) {
            case JavaEntityDescriptorEnum.LongLiteral_ord :
            specificBuilder.LongLiteral(value);
            break;
        }
    }
}
