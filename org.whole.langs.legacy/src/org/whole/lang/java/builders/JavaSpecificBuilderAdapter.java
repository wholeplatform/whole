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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.java.model.PrimitiveTypeEnum;
import org.whole.lang.java.model.AssignmentOperatorEnum;
import org.whole.lang.java.model.InfixOperatorEnum;
import org.whole.lang.java.model.PostfixOperatorEnum;
import org.whole.lang.java.model.PrefixOperatorEnum;
import org.whole.lang.java.model.ModifierEnum;

/**
 *  @generator Whole
 */
public class JavaSpecificBuilderAdapter extends GenericBuilderContext implements IJavaBuilder {

    public JavaSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public JavaSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void operand() {
        wFeature(JavaFeatureDescriptorEnum.operand);
    }

    public void extendedOperands() {
        wFeature(JavaFeatureDescriptorEnum.extendedOperands);
    }

    public void rightOperand() {
        wFeature(JavaFeatureDescriptorEnum.rightOperand);
    }

    public void leftOperand() {
        wFeature(JavaFeatureDescriptorEnum.leftOperand);
    }

    public void elseExpression() {
        wFeature(JavaFeatureDescriptorEnum.elseExpression);
    }

    public void thenExpression() {
        wFeature(JavaFeatureDescriptorEnum.thenExpression);
    }

    public void rightHandSide() {
        wFeature(JavaFeatureDescriptorEnum.rightHandSide);
    }

    public void operator() {
        wFeature(JavaFeatureDescriptorEnum.operator);
    }

    public void leftHandSide() {
        wFeature(JavaFeatureDescriptorEnum.leftHandSide);
    }

    public void dimensions() {
        wFeature(JavaFeatureDescriptorEnum.dimensions);
    }

    public void index() {
        wFeature(JavaFeatureDescriptorEnum.index);
    }

    public void array() {
        wFeature(JavaFeatureDescriptorEnum.array);
    }

    public void typeDeclaration() {
        wFeature(JavaFeatureDescriptorEnum.typeDeclaration);
    }

    public void exception() {
        wFeature(JavaFeatureDescriptorEnum.exception);
    }

    public void _finally() {
        wFeature(JavaFeatureDescriptorEnum._finally);
    }

    public void catchClauses() {
        wFeature(JavaFeatureDescriptorEnum.catchClauses);
    }

    public void statements() {
        wFeature(JavaFeatureDescriptorEnum.statements);
    }

    public void elseStatement() {
        wFeature(JavaFeatureDescriptorEnum.elseStatement);
    }

    public void thenStatement() {
        wFeature(JavaFeatureDescriptorEnum.thenStatement);
    }

    public void updaters() {
        wFeature(JavaFeatureDescriptorEnum.updaters);
    }

    public void initializers() {
        wFeature(JavaFeatureDescriptorEnum.initializers);
    }

    public void parameter() {
        wFeature(JavaFeatureDescriptorEnum.parameter);
    }

    public void label() {
        wFeature(JavaFeatureDescriptorEnum.label);
    }

    public void message() {
        wFeature(JavaFeatureDescriptorEnum.message);
    }

    public void expression() {
        wFeature(JavaFeatureDescriptorEnum.expression);
    }

    public void upperBound() {
        wFeature(JavaFeatureDescriptorEnum.upperBound);
    }

    public void bound() {
        wFeature(JavaFeatureDescriptorEnum.bound);
    }

    public void typeArguments() {
        wFeature(JavaFeatureDescriptorEnum.typeArguments);
    }

    public void componentType() {
        wFeature(JavaFeatureDescriptorEnum.componentType);
    }

    public void varargsAnnotations() {
        wFeature(JavaFeatureDescriptorEnum.varargsAnnotations);
    }

    public void initializer() {
        wFeature(JavaFeatureDescriptorEnum.initializer);
    }

    public void thrownExceptions() {
        wFeature(JavaFeatureDescriptorEnum.thrownExceptions);
    }

    public void extraDimensions() {
        wFeature(JavaFeatureDescriptorEnum.extraDimensions);
    }

    public void returnType() {
        wFeature(JavaFeatureDescriptorEnum.returnType);
    }

    public void body() {
        wFeature(JavaFeatureDescriptorEnum.body);
    }

    public void _default() {
        wFeature(JavaFeatureDescriptorEnum._default);
    }

    public void typeBounds() {
        wFeature(JavaFeatureDescriptorEnum.typeBounds);
    }

    public void superclassType() {
        wFeature(JavaFeatureDescriptorEnum.superclassType);
    }

    public void typeParameters() {
        wFeature(JavaFeatureDescriptorEnum.typeParameters);
    }

    public void anonymousClassDeclaration() {
        wFeature(JavaFeatureDescriptorEnum.anonymousClassDeclaration);
    }

    public void arguments() {
        wFeature(JavaFeatureDescriptorEnum.arguments);
    }

    public void enumConstants() {
        wFeature(JavaFeatureDescriptorEnum.enumConstants);
    }

    public void superInterfaceTypes() {
        wFeature(JavaFeatureDescriptorEnum.superInterfaceTypes);
    }

    public void bodyDeclarations() {
        wFeature(JavaFeatureDescriptorEnum.bodyDeclarations);
    }

    public void modifiers() {
        wFeature(JavaFeatureDescriptorEnum.modifiers);
    }

    public void _static() {
        wFeature(JavaFeatureDescriptorEnum._static);
    }

    public void onDemand() {
        wFeature(JavaFeatureDescriptorEnum.onDemand);
    }

    public void values() {
        wFeature(JavaFeatureDescriptorEnum.values);
    }

    public void value() {
        wFeature(JavaFeatureDescriptorEnum.value);
    }

    public void typeName() {
        wFeature(JavaFeatureDescriptorEnum.typeName);
    }

    public void fragments() {
        wFeature(JavaFeatureDescriptorEnum.fragments);
    }

    public void tagName() {
        wFeature(JavaFeatureDescriptorEnum.tagName);
    }

    public void varargs() {
        wFeature(JavaFeatureDescriptorEnum.varargs);
    }

    public void type() {
        wFeature(JavaFeatureDescriptorEnum.type);
    }

    public void parameters() {
        wFeature(JavaFeatureDescriptorEnum.parameters);
    }

    public void qualifier() {
        wFeature(JavaFeatureDescriptorEnum.qualifier);
    }

    public void tags() {
        wFeature(JavaFeatureDescriptorEnum.tags);
    }

    public void text() {
        wFeature(JavaFeatureDescriptorEnum.text);
    }

    public void docElements() {
        wFeature(JavaFeatureDescriptorEnum.docElements);
    }

    public void name() {
        wFeature(JavaFeatureDescriptorEnum.name);
    }

    public void annotations() {
        wFeature(JavaFeatureDescriptorEnum.annotations);
    }

    public void javadoc() {
        wFeature(JavaFeatureDescriptorEnum.javadoc);
    }

    public void types() {
        wFeature(JavaFeatureDescriptorEnum.types);
    }

    public void imports() {
        wFeature(JavaFeatureDescriptorEnum.imports);
    }

    public void _package() {
        wFeature(JavaFeatureDescriptorEnum._package);
    }

    public void visit() {
    }

    public void JavaSystemSoftware() {
        wEntity(JavaEntityDescriptorEnum.JavaSystemSoftware);
    }

    public void JavaSystemSoftware_() {
        wEntity_(JavaEntityDescriptorEnum.JavaSystemSoftware);
    }

    public void JavaSystemSoftware_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.JavaSystemSoftware, initialCapacity);
    }

    public void _JavaSystemSoftware() {
        _wEntity(JavaEntityDescriptorEnum.JavaSystemSoftware);
    }

    public void CompilationUnit() {
        wEntity(JavaEntityDescriptorEnum.CompilationUnit);
    }

    public void CompilationUnit_() {
        wEntity_(JavaEntityDescriptorEnum.CompilationUnit);
    }

    public void _CompilationUnit() {
        _wEntity(JavaEntityDescriptorEnum.CompilationUnit);
    }

    public void PackageDeclaration() {
        wEntity(JavaEntityDescriptorEnum.PackageDeclaration);
    }

    public void PackageDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.PackageDeclaration);
    }

    public void _PackageDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.PackageDeclaration);
    }

    public void BlockComment() {
        wEntity(JavaEntityDescriptorEnum.BlockComment);
    }

    public void BlockComment_() {
        wEntity_(JavaEntityDescriptorEnum.BlockComment);
    }

    public void _BlockComment() {
        _wEntity(JavaEntityDescriptorEnum.BlockComment);
    }

    public void LineComment() {
        wEntity(JavaEntityDescriptorEnum.LineComment);
    }

    public void LineComment_() {
        wEntity_(JavaEntityDescriptorEnum.LineComment);
    }

    public void _LineComment() {
        _wEntity(JavaEntityDescriptorEnum.LineComment);
    }

    public void Javadoc() {
        wEntity(JavaEntityDescriptorEnum.Javadoc);
    }

    public void Javadoc_() {
        wEntity_(JavaEntityDescriptorEnum.Javadoc);
    }

    public void _Javadoc() {
        _wEntity(JavaEntityDescriptorEnum.Javadoc);
    }

    public void Tags() {
        wEntity(JavaEntityDescriptorEnum.Tags);
    }

    public void Tags_() {
        wEntity_(JavaEntityDescriptorEnum.Tags);
    }

    public void Tags_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Tags, initialCapacity);
    }

    public void _Tags() {
        _wEntity(JavaEntityDescriptorEnum.Tags);
    }

    public void DocElements() {
        wEntity(JavaEntityDescriptorEnum.DocElements);
    }

    public void DocElements_() {
        wEntity_(JavaEntityDescriptorEnum.DocElements);
    }

    public void DocElements_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.DocElements, initialCapacity);
    }

    public void _DocElements() {
        _wEntity(JavaEntityDescriptorEnum.DocElements);
    }

    public void MethodRef() {
        wEntity(JavaEntityDescriptorEnum.MethodRef);
    }

    public void MethodRef_() {
        wEntity_(JavaEntityDescriptorEnum.MethodRef);
    }

    public void _MethodRef() {
        _wEntity(JavaEntityDescriptorEnum.MethodRef);
    }

    public void MethodRefParameters() {
        wEntity(JavaEntityDescriptorEnum.MethodRefParameters);
    }

    public void MethodRefParameters_() {
        wEntity_(JavaEntityDescriptorEnum.MethodRefParameters);
    }

    public void MethodRefParameters_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.MethodRefParameters, initialCapacity);
    }

    public void _MethodRefParameters() {
        _wEntity(JavaEntityDescriptorEnum.MethodRefParameters);
    }

    public void MethodRefParameter() {
        wEntity(JavaEntityDescriptorEnum.MethodRefParameter);
    }

    public void MethodRefParameter_() {
        wEntity_(JavaEntityDescriptorEnum.MethodRefParameter);
    }

    public void _MethodRefParameter() {
        _wEntity(JavaEntityDescriptorEnum.MethodRefParameter);
    }

    public void MemberRef() {
        wEntity(JavaEntityDescriptorEnum.MemberRef);
    }

    public void MemberRef_() {
        wEntity_(JavaEntityDescriptorEnum.MemberRef);
    }

    public void _MemberRef() {
        _wEntity(JavaEntityDescriptorEnum.MemberRef);
    }

    public void TextElement() {
        wEntity(JavaEntityDescriptorEnum.TextElement);
    }

    public void TextElement(String value) {
        wEntity(JavaEntityDescriptorEnum.TextElement, value);
    }

    public void TagElement() {
        wEntity(JavaEntityDescriptorEnum.TagElement);
    }

    public void TagElement_() {
        wEntity_(JavaEntityDescriptorEnum.TagElement);
    }

    public void _TagElement() {
        _wEntity(JavaEntityDescriptorEnum.TagElement);
    }

    public void TagName() {
        wEntity(JavaEntityDescriptorEnum.TagName);
    }

    public void TagName(String value) {
        wEntity(JavaEntityDescriptorEnum.TagName, value);
    }

    public void Annotations() {
        wEntity(JavaEntityDescriptorEnum.Annotations);
    }

    public void Annotations_() {
        wEntity_(JavaEntityDescriptorEnum.Annotations);
    }

    public void Annotations_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Annotations, initialCapacity);
    }

    public void _Annotations() {
        _wEntity(JavaEntityDescriptorEnum.Annotations);
    }

    public void SingleMemberAnnotation() {
        wEntity(JavaEntityDescriptorEnum.SingleMemberAnnotation);
    }

    public void SingleMemberAnnotation_() {
        wEntity_(JavaEntityDescriptorEnum.SingleMemberAnnotation);
    }

    public void _SingleMemberAnnotation() {
        _wEntity(JavaEntityDescriptorEnum.SingleMemberAnnotation);
    }

    public void MarkerAnnotation() {
        wEntity(JavaEntityDescriptorEnum.MarkerAnnotation);
    }

    public void MarkerAnnotation_() {
        wEntity_(JavaEntityDescriptorEnum.MarkerAnnotation);
    }

    public void _MarkerAnnotation() {
        _wEntity(JavaEntityDescriptorEnum.MarkerAnnotation);
    }

    public void NormalAnnotation() {
        wEntity(JavaEntityDescriptorEnum.NormalAnnotation);
    }

    public void NormalAnnotation_() {
        wEntity_(JavaEntityDescriptorEnum.NormalAnnotation);
    }

    public void _NormalAnnotation() {
        _wEntity(JavaEntityDescriptorEnum.NormalAnnotation);
    }

    public void MemberValuePairs() {
        wEntity(JavaEntityDescriptorEnum.MemberValuePairs);
    }

    public void MemberValuePairs_() {
        wEntity_(JavaEntityDescriptorEnum.MemberValuePairs);
    }

    public void MemberValuePairs_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.MemberValuePairs, initialCapacity);
    }

    public void _MemberValuePairs() {
        _wEntity(JavaEntityDescriptorEnum.MemberValuePairs);
    }

    public void MemberValuePair() {
        wEntity(JavaEntityDescriptorEnum.MemberValuePair);
    }

    public void MemberValuePair_() {
        wEntity_(JavaEntityDescriptorEnum.MemberValuePair);
    }

    public void _MemberValuePair() {
        _wEntity(JavaEntityDescriptorEnum.MemberValuePair);
    }

    public void ImportDeclarations() {
        wEntity(JavaEntityDescriptorEnum.ImportDeclarations);
    }

    public void ImportDeclarations_() {
        wEntity_(JavaEntityDescriptorEnum.ImportDeclarations);
    }

    public void ImportDeclarations_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.ImportDeclarations, initialCapacity);
    }

    public void _ImportDeclarations() {
        _wEntity(JavaEntityDescriptorEnum.ImportDeclarations);
    }

    public void ImportDeclaration() {
        wEntity(JavaEntityDescriptorEnum.ImportDeclaration);
    }

    public void ImportDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.ImportDeclaration);
    }

    public void _ImportDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.ImportDeclaration);
    }

    public void ImportModifier() {
        wEntity(JavaEntityDescriptorEnum.ImportModifier);
    }

    public void ImportModifier(boolean value) {
        wEntity(JavaEntityDescriptorEnum.ImportModifier, value);
    }

    public void TypeDeclarations() {
        wEntity(JavaEntityDescriptorEnum.TypeDeclarations);
    }

    public void TypeDeclarations_() {
        wEntity_(JavaEntityDescriptorEnum.TypeDeclarations);
    }

    public void TypeDeclarations_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.TypeDeclarations, initialCapacity);
    }

    public void _TypeDeclarations() {
        _wEntity(JavaEntityDescriptorEnum.TypeDeclarations);
    }

    public void EnumDeclaration() {
        wEntity(JavaEntityDescriptorEnum.EnumDeclaration);
    }

    public void EnumDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.EnumDeclaration);
    }

    public void _EnumDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.EnumDeclaration);
    }

    public void EnumConstants() {
        wEntity(JavaEntityDescriptorEnum.EnumConstants);
    }

    public void EnumConstants_() {
        wEntity_(JavaEntityDescriptorEnum.EnumConstants);
    }

    public void EnumConstants_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.EnumConstants, initialCapacity);
    }

    public void _EnumConstants() {
        _wEntity(JavaEntityDescriptorEnum.EnumConstants);
    }

    public void EnumConstantDeclaration() {
        wEntity(JavaEntityDescriptorEnum.EnumConstantDeclaration);
    }

    public void EnumConstantDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.EnumConstantDeclaration);
    }

    public void _EnumConstantDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.EnumConstantDeclaration);
    }

    public void Arguments() {
        wEntity(JavaEntityDescriptorEnum.Arguments);
    }

    public void Arguments_() {
        wEntity_(JavaEntityDescriptorEnum.Arguments);
    }

    public void Arguments_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Arguments, initialCapacity);
    }

    public void _Arguments() {
        _wEntity(JavaEntityDescriptorEnum.Arguments);
    }

    public void AnonymousClassDeclaration() {
        wEntity(JavaEntityDescriptorEnum.AnonymousClassDeclaration);
    }

    public void AnonymousClassDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.AnonymousClassDeclaration);
    }

    public void AnonymousClassDeclaration_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.AnonymousClassDeclaration, initialCapacity);
    }

    public void _AnonymousClassDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.AnonymousClassDeclaration);
    }

    public void AnnotationTypeDeclaration() {
        wEntity(JavaEntityDescriptorEnum.AnnotationTypeDeclaration);
    }

    public void AnnotationTypeDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.AnnotationTypeDeclaration);
    }

    public void _AnnotationTypeDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.AnnotationTypeDeclaration);
    }

    public void ClassDeclaration() {
        wEntity(JavaEntityDescriptorEnum.ClassDeclaration);
    }

    public void ClassDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.ClassDeclaration);
    }

    public void _ClassDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.ClassDeclaration);
    }

    public void InterfaceDeclaration() {
        wEntity(JavaEntityDescriptorEnum.InterfaceDeclaration);
    }

    public void InterfaceDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.InterfaceDeclaration);
    }

    public void _InterfaceDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.InterfaceDeclaration);
    }

    public void TypeParameters() {
        wEntity(JavaEntityDescriptorEnum.TypeParameters);
    }

    public void TypeParameters_() {
        wEntity_(JavaEntityDescriptorEnum.TypeParameters);
    }

    public void TypeParameters_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.TypeParameters, initialCapacity);
    }

    public void _TypeParameters() {
        _wEntity(JavaEntityDescriptorEnum.TypeParameters);
    }

    public void TypeParameter() {
        wEntity(JavaEntityDescriptorEnum.TypeParameter);
    }

    public void TypeParameter_() {
        wEntity_(JavaEntityDescriptorEnum.TypeParameter);
    }

    public void _TypeParameter() {
        _wEntity(JavaEntityDescriptorEnum.TypeParameter);
    }

    public void Types() {
        wEntity(JavaEntityDescriptorEnum.Types);
    }

    public void Types_() {
        wEntity_(JavaEntityDescriptorEnum.Types);
    }

    public void Types_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Types, initialCapacity);
    }

    public void _Types() {
        _wEntity(JavaEntityDescriptorEnum.Types);
    }

    public void BodyDeclarations() {
        wEntity(JavaEntityDescriptorEnum.BodyDeclarations);
    }

    public void BodyDeclarations_() {
        wEntity_(JavaEntityDescriptorEnum.BodyDeclarations);
    }

    public void BodyDeclarations_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.BodyDeclarations, initialCapacity);
    }

    public void _BodyDeclarations() {
        _wEntity(JavaEntityDescriptorEnum.BodyDeclarations);
    }

    public void AnnotationTypeMemberDeclaration() {
        wEntity(JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration);
    }

    public void AnnotationTypeMemberDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration);
    }

    public void _AnnotationTypeMemberDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration);
    }

    public void Initializer() {
        wEntity(JavaEntityDescriptorEnum.Initializer);
    }

    public void Initializer_() {
        wEntity_(JavaEntityDescriptorEnum.Initializer);
    }

    public void _Initializer() {
        _wEntity(JavaEntityDescriptorEnum.Initializer);
    }

    public void FieldDeclaration() {
        wEntity(JavaEntityDescriptorEnum.FieldDeclaration);
    }

    public void FieldDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.FieldDeclaration);
    }

    public void _FieldDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.FieldDeclaration);
    }

    public void MethodDeclaration() {
        wEntity(JavaEntityDescriptorEnum.MethodDeclaration);
    }

    public void MethodDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.MethodDeclaration);
    }

    public void _MethodDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.MethodDeclaration);
    }

    public void ConstructorDeclaration() {
        wEntity(JavaEntityDescriptorEnum.ConstructorDeclaration);
    }

    public void ConstructorDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.ConstructorDeclaration);
    }

    public void _ConstructorDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.ConstructorDeclaration);
    }

    public void Parameters() {
        wEntity(JavaEntityDescriptorEnum.Parameters);
    }

    public void Parameters_() {
        wEntity_(JavaEntityDescriptorEnum.Parameters);
    }

    public void Parameters_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Parameters, initialCapacity);
    }

    public void _Parameters() {
        _wEntity(JavaEntityDescriptorEnum.Parameters);
    }

    public void SingleVariableDeclaration() {
        wEntity(JavaEntityDescriptorEnum.SingleVariableDeclaration);
    }

    public void SingleVariableDeclaration_() {
        wEntity_(JavaEntityDescriptorEnum.SingleVariableDeclaration);
    }

    public void _SingleVariableDeclaration() {
        _wEntity(JavaEntityDescriptorEnum.SingleVariableDeclaration);
    }

    public void Varargs() {
        wEntity(JavaEntityDescriptorEnum.Varargs);
    }

    public void Varargs(boolean value) {
        wEntity(JavaEntityDescriptorEnum.Varargs, value);
    }

    public void AnnotatedType() {
        wEntity(JavaEntityDescriptorEnum.AnnotatedType);
    }

    public void AnnotatedType_() {
        wEntity_(JavaEntityDescriptorEnum.AnnotatedType);
    }

    public void _AnnotatedType() {
        _wEntity(JavaEntityDescriptorEnum.AnnotatedType);
    }

    public void ArrayType() {
        wEntity(JavaEntityDescriptorEnum.ArrayType);
    }

    public void ArrayType_() {
        wEntity_(JavaEntityDescriptorEnum.ArrayType);
    }

    public void _ArrayType() {
        _wEntity(JavaEntityDescriptorEnum.ArrayType);
    }

    public void ParameterizedType() {
        wEntity(JavaEntityDescriptorEnum.ParameterizedType);
    }

    public void ParameterizedType_() {
        wEntity_(JavaEntityDescriptorEnum.ParameterizedType);
    }

    public void _ParameterizedType() {
        _wEntity(JavaEntityDescriptorEnum.ParameterizedType);
    }

    public void PrimitiveType() {
        wEntity(JavaEntityDescriptorEnum.PrimitiveType);
    }

    public void PrimitiveType(PrimitiveTypeEnum.Value value) {
        wEntity(JavaEntityDescriptorEnum.PrimitiveType, value);
    }

    public void PrimitiveType(String value) {
        wEntity(JavaEntityDescriptorEnum.PrimitiveType, value);
    }

    public void QualifiedType() {
        wEntity(JavaEntityDescriptorEnum.QualifiedType);
    }

    public void QualifiedType(String value) {
        wEntity(JavaEntityDescriptorEnum.QualifiedType, value);
    }

    public void SimpleType() {
        wEntity(JavaEntityDescriptorEnum.SimpleType);
    }

    public void SimpleType(String value) {
        wEntity(JavaEntityDescriptorEnum.SimpleType, value);
    }

    public void WildcardType() {
        wEntity(JavaEntityDescriptorEnum.WildcardType);
    }

    public void WildcardType_() {
        wEntity_(JavaEntityDescriptorEnum.WildcardType);
    }

    public void _WildcardType() {
        _wEntity(JavaEntityDescriptorEnum.WildcardType);
    }

    public void UnionType() {
        wEntity(JavaEntityDescriptorEnum.UnionType);
    }

    public void UnionType_() {
        wEntity_(JavaEntityDescriptorEnum.UnionType);
    }

    public void UnionType_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.UnionType, initialCapacity);
    }

    public void _UnionType() {
        _wEntity(JavaEntityDescriptorEnum.UnionType);
    }

    public void IntersectionType() {
        wEntity(JavaEntityDescriptorEnum.IntersectionType);
    }

    public void IntersectionType_() {
        wEntity_(JavaEntityDescriptorEnum.IntersectionType);
    }

    public void IntersectionType_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.IntersectionType, initialCapacity);
    }

    public void _IntersectionType() {
        _wEntity(JavaEntityDescriptorEnum.IntersectionType);
    }

    public void UpperBound() {
        wEntity(JavaEntityDescriptorEnum.UpperBound);
    }

    public void UpperBound(boolean value) {
        wEntity(JavaEntityDescriptorEnum.UpperBound, value);
    }

    public void AssertStatement() {
        wEntity(JavaEntityDescriptorEnum.AssertStatement);
    }

    public void AssertStatement_() {
        wEntity_(JavaEntityDescriptorEnum.AssertStatement);
    }

    public void _AssertStatement() {
        _wEntity(JavaEntityDescriptorEnum.AssertStatement);
    }

    public void Block() {
        wEntity(JavaEntityDescriptorEnum.Block);
    }

    public void Block_() {
        wEntity_(JavaEntityDescriptorEnum.Block);
    }

    public void Block_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Block, initialCapacity);
    }

    public void _Block() {
        _wEntity(JavaEntityDescriptorEnum.Block);
    }

    public void BreakStatement() {
        wEntity(JavaEntityDescriptorEnum.BreakStatement);
    }

    public void BreakStatement_() {
        wEntity_(JavaEntityDescriptorEnum.BreakStatement);
    }

    public void _BreakStatement() {
        _wEntity(JavaEntityDescriptorEnum.BreakStatement);
    }

    public void ConstructorInvocation() {
        wEntity(JavaEntityDescriptorEnum.ConstructorInvocation);
    }

    public void ConstructorInvocation_() {
        wEntity_(JavaEntityDescriptorEnum.ConstructorInvocation);
    }

    public void _ConstructorInvocation() {
        _wEntity(JavaEntityDescriptorEnum.ConstructorInvocation);
    }

    public void ContinueStatement() {
        wEntity(JavaEntityDescriptorEnum.ContinueStatement);
    }

    public void ContinueStatement_() {
        wEntity_(JavaEntityDescriptorEnum.ContinueStatement);
    }

    public void _ContinueStatement() {
        _wEntity(JavaEntityDescriptorEnum.ContinueStatement);
    }

    public void DoStatement() {
        wEntity(JavaEntityDescriptorEnum.DoStatement);
    }

    public void DoStatement_() {
        wEntity_(JavaEntityDescriptorEnum.DoStatement);
    }

    public void _DoStatement() {
        _wEntity(JavaEntityDescriptorEnum.DoStatement);
    }

    public void EmptyStatement() {
        wEntity(JavaEntityDescriptorEnum.EmptyStatement);
    }

    public void EmptyStatement_() {
        wEntity_(JavaEntityDescriptorEnum.EmptyStatement);
    }

    public void _EmptyStatement() {
        _wEntity(JavaEntityDescriptorEnum.EmptyStatement);
    }

    public void EnhancedForStatement() {
        wEntity(JavaEntityDescriptorEnum.EnhancedForStatement);
    }

    public void EnhancedForStatement_() {
        wEntity_(JavaEntityDescriptorEnum.EnhancedForStatement);
    }

    public void _EnhancedForStatement() {
        _wEntity(JavaEntityDescriptorEnum.EnhancedForStatement);
    }

    public void ExpressionStatement() {
        wEntity(JavaEntityDescriptorEnum.ExpressionStatement);
    }

    public void ExpressionStatement_() {
        wEntity_(JavaEntityDescriptorEnum.ExpressionStatement);
    }

    public void _ExpressionStatement() {
        _wEntity(JavaEntityDescriptorEnum.ExpressionStatement);
    }

    public void ForStatement() {
        wEntity(JavaEntityDescriptorEnum.ForStatement);
    }

    public void ForStatement_() {
        wEntity_(JavaEntityDescriptorEnum.ForStatement);
    }

    public void _ForStatement() {
        _wEntity(JavaEntityDescriptorEnum.ForStatement);
    }

    public void Expressions() {
        wEntity(JavaEntityDescriptorEnum.Expressions);
    }

    public void Expressions_() {
        wEntity_(JavaEntityDescriptorEnum.Expressions);
    }

    public void Expressions_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Expressions, initialCapacity);
    }

    public void _Expressions() {
        _wEntity(JavaEntityDescriptorEnum.Expressions);
    }

    public void IfStatement() {
        wEntity(JavaEntityDescriptorEnum.IfStatement);
    }

    public void IfStatement_() {
        wEntity_(JavaEntityDescriptorEnum.IfStatement);
    }

    public void _IfStatement() {
        _wEntity(JavaEntityDescriptorEnum.IfStatement);
    }

    public void LabeledStatement() {
        wEntity(JavaEntityDescriptorEnum.LabeledStatement);
    }

    public void LabeledStatement_() {
        wEntity_(JavaEntityDescriptorEnum.LabeledStatement);
    }

    public void _LabeledStatement() {
        _wEntity(JavaEntityDescriptorEnum.LabeledStatement);
    }

    public void ReturnStatement() {
        wEntity(JavaEntityDescriptorEnum.ReturnStatement);
    }

    public void ReturnStatement_() {
        wEntity_(JavaEntityDescriptorEnum.ReturnStatement);
    }

    public void _ReturnStatement() {
        _wEntity(JavaEntityDescriptorEnum.ReturnStatement);
    }

    public void SuperConstructorInvocation() {
        wEntity(JavaEntityDescriptorEnum.SuperConstructorInvocation);
    }

    public void SuperConstructorInvocation_() {
        wEntity_(JavaEntityDescriptorEnum.SuperConstructorInvocation);
    }

    public void _SuperConstructorInvocation() {
        _wEntity(JavaEntityDescriptorEnum.SuperConstructorInvocation);
    }

    public void SwitchCase() {
        wEntity(JavaEntityDescriptorEnum.SwitchCase);
    }

    public void SwitchCase_() {
        wEntity_(JavaEntityDescriptorEnum.SwitchCase);
    }

    public void _SwitchCase() {
        _wEntity(JavaEntityDescriptorEnum.SwitchCase);
    }

    public void SwitchDefault() {
        wEntity(JavaEntityDescriptorEnum.SwitchDefault);
    }

    public void SwitchDefault_() {
        wEntity_(JavaEntityDescriptorEnum.SwitchDefault);
    }

    public void _SwitchDefault() {
        _wEntity(JavaEntityDescriptorEnum.SwitchDefault);
    }

    public void SwitchStatement() {
        wEntity(JavaEntityDescriptorEnum.SwitchStatement);
    }

    public void SwitchStatement_() {
        wEntity_(JavaEntityDescriptorEnum.SwitchStatement);
    }

    public void _SwitchStatement() {
        _wEntity(JavaEntityDescriptorEnum.SwitchStatement);
    }

    public void Statements() {
        wEntity(JavaEntityDescriptorEnum.Statements);
    }

    public void Statements_() {
        wEntity_(JavaEntityDescriptorEnum.Statements);
    }

    public void Statements_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.Statements, initialCapacity);
    }

    public void _Statements() {
        _wEntity(JavaEntityDescriptorEnum.Statements);
    }

    public void SynchronizedStatement() {
        wEntity(JavaEntityDescriptorEnum.SynchronizedStatement);
    }

    public void SynchronizedStatement_() {
        wEntity_(JavaEntityDescriptorEnum.SynchronizedStatement);
    }

    public void _SynchronizedStatement() {
        _wEntity(JavaEntityDescriptorEnum.SynchronizedStatement);
    }

    public void ThrowStatement() {
        wEntity(JavaEntityDescriptorEnum.ThrowStatement);
    }

    public void ThrowStatement_() {
        wEntity_(JavaEntityDescriptorEnum.ThrowStatement);
    }

    public void _ThrowStatement() {
        _wEntity(JavaEntityDescriptorEnum.ThrowStatement);
    }

    public void TryStatement() {
        wEntity(JavaEntityDescriptorEnum.TryStatement);
    }

    public void TryStatement_() {
        wEntity_(JavaEntityDescriptorEnum.TryStatement);
    }

    public void _TryStatement() {
        _wEntity(JavaEntityDescriptorEnum.TryStatement);
    }

    public void CatchClauses() {
        wEntity(JavaEntityDescriptorEnum.CatchClauses);
    }

    public void CatchClauses_() {
        wEntity_(JavaEntityDescriptorEnum.CatchClauses);
    }

    public void CatchClauses_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.CatchClauses, initialCapacity);
    }

    public void _CatchClauses() {
        _wEntity(JavaEntityDescriptorEnum.CatchClauses);
    }

    public void CatchClause() {
        wEntity(JavaEntityDescriptorEnum.CatchClause);
    }

    public void CatchClause_() {
        wEntity_(JavaEntityDescriptorEnum.CatchClause);
    }

    public void _CatchClause() {
        _wEntity(JavaEntityDescriptorEnum.CatchClause);
    }

    public void TypeDeclarationStatement() {
        wEntity(JavaEntityDescriptorEnum.TypeDeclarationStatement);
    }

    public void TypeDeclarationStatement_() {
        wEntity_(JavaEntityDescriptorEnum.TypeDeclarationStatement);
    }

    public void _TypeDeclarationStatement() {
        _wEntity(JavaEntityDescriptorEnum.TypeDeclarationStatement);
    }

    public void VariableDeclarationStatement() {
        wEntity(JavaEntityDescriptorEnum.VariableDeclarationStatement);
    }

    public void VariableDeclarationStatement_() {
        wEntity_(JavaEntityDescriptorEnum.VariableDeclarationStatement);
    }

    public void _VariableDeclarationStatement() {
        _wEntity(JavaEntityDescriptorEnum.VariableDeclarationStatement);
    }

    public void WhileStatement() {
        wEntity(JavaEntityDescriptorEnum.WhileStatement);
    }

    public void WhileStatement_() {
        wEntity_(JavaEntityDescriptorEnum.WhileStatement);
    }

    public void _WhileStatement() {
        _wEntity(JavaEntityDescriptorEnum.WhileStatement);
    }

    public void SimpleName() {
        wEntity(JavaEntityDescriptorEnum.SimpleName);
    }

    public void SimpleName(String value) {
        wEntity(JavaEntityDescriptorEnum.SimpleName, value);
    }

    public void QualifiedName() {
        wEntity(JavaEntityDescriptorEnum.QualifiedName);
    }

    public void QualifiedName(String value) {
        wEntity(JavaEntityDescriptorEnum.QualifiedName, value);
    }

    public void NullLiteral() {
        wEntity(JavaEntityDescriptorEnum.NullLiteral);
    }

    public void NullLiteral_() {
        wEntity_(JavaEntityDescriptorEnum.NullLiteral);
    }

    public void _NullLiteral() {
        _wEntity(JavaEntityDescriptorEnum.NullLiteral);
    }

    public void BooleanLiteral() {
        wEntity(JavaEntityDescriptorEnum.BooleanLiteral);
    }

    public void BooleanLiteral(boolean value) {
        wEntity(JavaEntityDescriptorEnum.BooleanLiteral, value);
    }

    public void ByteLiteral() {
        wEntity(JavaEntityDescriptorEnum.ByteLiteral);
    }

    public void ByteLiteral(byte value) {
        wEntity(JavaEntityDescriptorEnum.ByteLiteral, value);
    }

    public void CharLiteral() {
        wEntity(JavaEntityDescriptorEnum.CharLiteral);
    }

    public void CharLiteral(char value) {
        wEntity(JavaEntityDescriptorEnum.CharLiteral, value);
    }

    public void DoubleLiteral() {
        wEntity(JavaEntityDescriptorEnum.DoubleLiteral);
    }

    public void DoubleLiteral(double value) {
        wEntity(JavaEntityDescriptorEnum.DoubleLiteral, value);
    }

    public void FloatLiteral() {
        wEntity(JavaEntityDescriptorEnum.FloatLiteral);
    }

    public void FloatLiteral(float value) {
        wEntity(JavaEntityDescriptorEnum.FloatLiteral, value);
    }

    public void IntLiteral() {
        wEntity(JavaEntityDescriptorEnum.IntLiteral);
    }

    public void IntLiteral(int value) {
        wEntity(JavaEntityDescriptorEnum.IntLiteral, value);
    }

    public void ShortLiteral() {
        wEntity(JavaEntityDescriptorEnum.ShortLiteral);
    }

    public void ShortLiteral(short value) {
        wEntity(JavaEntityDescriptorEnum.ShortLiteral, value);
    }

    public void LongLiteral() {
        wEntity(JavaEntityDescriptorEnum.LongLiteral);
    }

    public void LongLiteral(long value) {
        wEntity(JavaEntityDescriptorEnum.LongLiteral, value);
    }

    public void StringLiteral() {
        wEntity(JavaEntityDescriptorEnum.StringLiteral);
    }

    public void StringLiteral(String value) {
        wEntity(JavaEntityDescriptorEnum.StringLiteral, value);
    }

    public void TypeLiteral() {
        wEntity(JavaEntityDescriptorEnum.TypeLiteral);
    }

    public void TypeLiteral_() {
        wEntity_(JavaEntityDescriptorEnum.TypeLiteral);
    }

    public void _TypeLiteral() {
        _wEntity(JavaEntityDescriptorEnum.TypeLiteral);
    }

    public void ArrayAccess() {
        wEntity(JavaEntityDescriptorEnum.ArrayAccess);
    }

    public void ArrayAccess_() {
        wEntity_(JavaEntityDescriptorEnum.ArrayAccess);
    }

    public void _ArrayAccess() {
        _wEntity(JavaEntityDescriptorEnum.ArrayAccess);
    }

    public void ArrayCreation() {
        wEntity(JavaEntityDescriptorEnum.ArrayCreation);
    }

    public void ArrayCreation_() {
        wEntity_(JavaEntityDescriptorEnum.ArrayCreation);
    }

    public void _ArrayCreation() {
        _wEntity(JavaEntityDescriptorEnum.ArrayCreation);
    }

    public void ArrayInitializer() {
        wEntity(JavaEntityDescriptorEnum.ArrayInitializer);
    }

    public void ArrayInitializer_() {
        wEntity_(JavaEntityDescriptorEnum.ArrayInitializer);
    }

    public void ArrayInitializer_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.ArrayInitializer, initialCapacity);
    }

    public void _ArrayInitializer() {
        _wEntity(JavaEntityDescriptorEnum.ArrayInitializer);
    }

    public void Assignment() {
        wEntity(JavaEntityDescriptorEnum.Assignment);
    }

    public void Assignment_() {
        wEntity_(JavaEntityDescriptorEnum.Assignment);
    }

    public void _Assignment() {
        _wEntity(JavaEntityDescriptorEnum.Assignment);
    }

    public void AssignmentOperator() {
        wEntity(JavaEntityDescriptorEnum.AssignmentOperator);
    }

    public void AssignmentOperator(AssignmentOperatorEnum.Value value) {
        wEntity(JavaEntityDescriptorEnum.AssignmentOperator, value);
    }

    public void AssignmentOperator(String value) {
        wEntity(JavaEntityDescriptorEnum.AssignmentOperator, value);
    }

    public void CastExpression() {
        wEntity(JavaEntityDescriptorEnum.CastExpression);
    }

    public void CastExpression_() {
        wEntity_(JavaEntityDescriptorEnum.CastExpression);
    }

    public void _CastExpression() {
        _wEntity(JavaEntityDescriptorEnum.CastExpression);
    }

    public void ClassInstanceCreation() {
        wEntity(JavaEntityDescriptorEnum.ClassInstanceCreation);
    }

    public void ClassInstanceCreation_() {
        wEntity_(JavaEntityDescriptorEnum.ClassInstanceCreation);
    }

    public void _ClassInstanceCreation() {
        _wEntity(JavaEntityDescriptorEnum.ClassInstanceCreation);
    }

    public void ConditionalExpression() {
        wEntity(JavaEntityDescriptorEnum.ConditionalExpression);
    }

    public void ConditionalExpression_() {
        wEntity_(JavaEntityDescriptorEnum.ConditionalExpression);
    }

    public void _ConditionalExpression() {
        _wEntity(JavaEntityDescriptorEnum.ConditionalExpression);
    }

    public void FieldAccess() {
        wEntity(JavaEntityDescriptorEnum.FieldAccess);
    }

    public void FieldAccess_() {
        wEntity_(JavaEntityDescriptorEnum.FieldAccess);
    }

    public void _FieldAccess() {
        _wEntity(JavaEntityDescriptorEnum.FieldAccess);
    }

    public void InfixExpression() {
        wEntity(JavaEntityDescriptorEnum.InfixExpression);
    }

    public void InfixExpression_() {
        wEntity_(JavaEntityDescriptorEnum.InfixExpression);
    }

    public void _InfixExpression() {
        _wEntity(JavaEntityDescriptorEnum.InfixExpression);
    }

    public void InfixOperator() {
        wEntity(JavaEntityDescriptorEnum.InfixOperator);
    }

    public void InfixOperator(InfixOperatorEnum.Value value) {
        wEntity(JavaEntityDescriptorEnum.InfixOperator, value);
    }

    public void InfixOperator(String value) {
        wEntity(JavaEntityDescriptorEnum.InfixOperator, value);
    }

    public void InstanceofExpression() {
        wEntity(JavaEntityDescriptorEnum.InstanceofExpression);
    }

    public void InstanceofExpression_() {
        wEntity_(JavaEntityDescriptorEnum.InstanceofExpression);
    }

    public void _InstanceofExpression() {
        _wEntity(JavaEntityDescriptorEnum.InstanceofExpression);
    }

    public void LambdaExpression() {
        wEntity(JavaEntityDescriptorEnum.LambdaExpression);
    }

    public void LambdaExpression_() {
        wEntity_(JavaEntityDescriptorEnum.LambdaExpression);
    }

    public void _LambdaExpression() {
        _wEntity(JavaEntityDescriptorEnum.LambdaExpression);
    }

    public void MethodInvocation() {
        wEntity(JavaEntityDescriptorEnum.MethodInvocation);
    }

    public void MethodInvocation_() {
        wEntity_(JavaEntityDescriptorEnum.MethodInvocation);
    }

    public void _MethodInvocation() {
        _wEntity(JavaEntityDescriptorEnum.MethodInvocation);
    }

    public void ParenthesizedExpression() {
        wEntity(JavaEntityDescriptorEnum.ParenthesizedExpression);
    }

    public void ParenthesizedExpression_() {
        wEntity_(JavaEntityDescriptorEnum.ParenthesizedExpression);
    }

    public void _ParenthesizedExpression() {
        _wEntity(JavaEntityDescriptorEnum.ParenthesizedExpression);
    }

    public void PostfixExpression() {
        wEntity(JavaEntityDescriptorEnum.PostfixExpression);
    }

    public void PostfixExpression_() {
        wEntity_(JavaEntityDescriptorEnum.PostfixExpression);
    }

    public void _PostfixExpression() {
        _wEntity(JavaEntityDescriptorEnum.PostfixExpression);
    }

    public void PostfixOperator() {
        wEntity(JavaEntityDescriptorEnum.PostfixOperator);
    }

    public void PostfixOperator(PostfixOperatorEnum.Value value) {
        wEntity(JavaEntityDescriptorEnum.PostfixOperator, value);
    }

    public void PostfixOperator(String value) {
        wEntity(JavaEntityDescriptorEnum.PostfixOperator, value);
    }

    public void PrefixExpression() {
        wEntity(JavaEntityDescriptorEnum.PrefixExpression);
    }

    public void PrefixExpression_() {
        wEntity_(JavaEntityDescriptorEnum.PrefixExpression);
    }

    public void _PrefixExpression() {
        _wEntity(JavaEntityDescriptorEnum.PrefixExpression);
    }

    public void PrefixOperator() {
        wEntity(JavaEntityDescriptorEnum.PrefixOperator);
    }

    public void PrefixOperator(PrefixOperatorEnum.Value value) {
        wEntity(JavaEntityDescriptorEnum.PrefixOperator, value);
    }

    public void PrefixOperator(String value) {
        wEntity(JavaEntityDescriptorEnum.PrefixOperator, value);
    }

    public void SuperFieldAccess() {
        wEntity(JavaEntityDescriptorEnum.SuperFieldAccess);
    }

    public void SuperFieldAccess_() {
        wEntity_(JavaEntityDescriptorEnum.SuperFieldAccess);
    }

    public void _SuperFieldAccess() {
        _wEntity(JavaEntityDescriptorEnum.SuperFieldAccess);
    }

    public void SuperMethodInvocation() {
        wEntity(JavaEntityDescriptorEnum.SuperMethodInvocation);
    }

    public void SuperMethodInvocation_() {
        wEntity_(JavaEntityDescriptorEnum.SuperMethodInvocation);
    }

    public void _SuperMethodInvocation() {
        _wEntity(JavaEntityDescriptorEnum.SuperMethodInvocation);
    }

    public void ThisExpression() {
        wEntity(JavaEntityDescriptorEnum.ThisExpression);
    }

    public void ThisExpression_() {
        wEntity_(JavaEntityDescriptorEnum.ThisExpression);
    }

    public void _ThisExpression() {
        _wEntity(JavaEntityDescriptorEnum.ThisExpression);
    }

    public void VariableDeclarationExpression() {
        wEntity(JavaEntityDescriptorEnum.VariableDeclarationExpression);
    }

    public void VariableDeclarationExpression_() {
        wEntity_(JavaEntityDescriptorEnum.VariableDeclarationExpression);
    }

    public void _VariableDeclarationExpression() {
        _wEntity(JavaEntityDescriptorEnum.VariableDeclarationExpression);
    }

    public void VariableDeclarationFragments() {
        wEntity(JavaEntityDescriptorEnum.VariableDeclarationFragments);
    }

    public void VariableDeclarationFragments_() {
        wEntity_(JavaEntityDescriptorEnum.VariableDeclarationFragments);
    }

    public void VariableDeclarationFragments_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.VariableDeclarationFragments, initialCapacity);
    }

    public void _VariableDeclarationFragments() {
        _wEntity(JavaEntityDescriptorEnum.VariableDeclarationFragments);
    }

    public void VariableDeclarationFragment() {
        wEntity(JavaEntityDescriptorEnum.VariableDeclarationFragment);
    }

    public void VariableDeclarationFragment_() {
        wEntity_(JavaEntityDescriptorEnum.VariableDeclarationFragment);
    }

    public void _VariableDeclarationFragment() {
        _wEntity(JavaEntityDescriptorEnum.VariableDeclarationFragment);
    }

    public void ExtraDimensions() {
        wEntity(JavaEntityDescriptorEnum.ExtraDimensions);
    }

    public void ExtraDimensions(int value) {
        wEntity(JavaEntityDescriptorEnum.ExtraDimensions, value);
    }

    public void ExtendedModifiers() {
        wEntity(JavaEntityDescriptorEnum.ExtendedModifiers);
    }

    public void ExtendedModifiers_() {
        wEntity_(JavaEntityDescriptorEnum.ExtendedModifiers);
    }

    public void ExtendedModifiers_(int initialCapacity) {
        wEntity_(JavaEntityDescriptorEnum.ExtendedModifiers, initialCapacity);
    }

    public void _ExtendedModifiers() {
        _wEntity(JavaEntityDescriptorEnum.ExtendedModifiers);
    }

    public void Modifier() {
        wEntity(JavaEntityDescriptorEnum.Modifier);
    }

    public void Modifier(ModifierEnum.Value value) {
        wEntity(JavaEntityDescriptorEnum.Modifier, value);
    }

    public void Modifier(String value) {
        wEntity(JavaEntityDescriptorEnum.Modifier, value);
    }

    public void ConstructorReference() {
        wEntity(JavaEntityDescriptorEnum.ConstructorReference);
    }

    public void ConstructorReference_() {
        wEntity_(JavaEntityDescriptorEnum.ConstructorReference);
    }

    public void _ConstructorReference() {
        _wEntity(JavaEntityDescriptorEnum.ConstructorReference);
    }

    public void ExpressionMethodReference() {
        wEntity(JavaEntityDescriptorEnum.ExpressionMethodReference);
    }

    public void ExpressionMethodReference_() {
        wEntity_(JavaEntityDescriptorEnum.ExpressionMethodReference);
    }

    public void _ExpressionMethodReference() {
        _wEntity(JavaEntityDescriptorEnum.ExpressionMethodReference);
    }

    public void SuperMethodReference() {
        wEntity(JavaEntityDescriptorEnum.SuperMethodReference);
    }

    public void SuperMethodReference_() {
        wEntity_(JavaEntityDescriptorEnum.SuperMethodReference);
    }

    public void _SuperMethodReference() {
        _wEntity(JavaEntityDescriptorEnum.SuperMethodReference);
    }

    public void TypeMethodReference() {
        wEntity(JavaEntityDescriptorEnum.TypeMethodReference);
    }

    public void TypeMethodReference_() {
        wEntity_(JavaEntityDescriptorEnum.TypeMethodReference);
    }

    public void _TypeMethodReference() {
        _wEntity(JavaEntityDescriptorEnum.TypeMethodReference);
    }
}
