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
package org.whole.lang.java.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.java.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/**
 *  @generator Whole
 */
public class JavaEntityFactory extends GenericEntityFactory {
    public static final JavaEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static JavaEntityFactory instance(IEntityRegistryProvider provider) {
        return new JavaEntityFactory(provider);
    }

    protected JavaEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public JavaSystemSoftware createJavaSystemSoftware() {
        return create(JavaEntityDescriptorEnum.JavaSystemSoftware);
    }

    public JavaSystemSoftware createJavaSystemSoftware(CompilationUnit... entities) {
        return create(JavaEntityDescriptorEnum.JavaSystemSoftware, (IEntity[]) entities);
    }

    public JavaSystemSoftware createJavaSystemSoftware(int initialSize) {
        return clone(JavaEntityDescriptorEnum.JavaSystemSoftware, initialSize);
    }

    public CompilationUnit createCompilationUnit() {
        return create(JavaEntityDescriptorEnum.CompilationUnit);
    }

    public CompilationUnit createCompilationUnit(PackageDeclaration _package, ImportDeclarations imports, TypeDeclarations types) {
        return create(JavaEntityDescriptorEnum.CompilationUnit, _package, imports, types);
    }

    public IEntityBuilder<CompilationUnit> buildCompilationUnit() {
        return new EntityBuilder<CompilationUnit>(create(JavaEntityDescriptorEnum.CompilationUnit));
    }

    public PackageDeclaration createPackageDeclaration() {
        return create(JavaEntityDescriptorEnum.PackageDeclaration);
    }

    public PackageDeclaration createPackageDeclaration(Javadoc javadoc, Annotations annotations, Name name) {
        return create(JavaEntityDescriptorEnum.PackageDeclaration, javadoc, annotations, name);
    }

    public IEntityBuilder<PackageDeclaration> buildPackageDeclaration() {
        return new EntityBuilder<PackageDeclaration>(create(JavaEntityDescriptorEnum.PackageDeclaration));
    }

    public BlockComment createBlockComment() {
        return create(JavaEntityDescriptorEnum.BlockComment);
    }

    public BlockComment createBlockComment(DocElements docElements) {
        return create(JavaEntityDescriptorEnum.BlockComment, docElements);
    }

    public LineComment createLineComment() {
        return create(JavaEntityDescriptorEnum.LineComment);
    }

    public LineComment createLineComment(TextElement text) {
        return create(JavaEntityDescriptorEnum.LineComment, text);
    }

    public Javadoc createJavadoc() {
        return create(JavaEntityDescriptorEnum.Javadoc);
    }

    public Javadoc createJavadoc(Tags tags) {
        return create(JavaEntityDescriptorEnum.Javadoc, tags);
    }

    public Tags createTags() {
        return create(JavaEntityDescriptorEnum.Tags);
    }

    public Tags createTags(TagElement... entities) {
        return create(JavaEntityDescriptorEnum.Tags, (IEntity[]) entities);
    }

    public Tags createTags(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Tags, initialSize);
    }

    public DocElements createDocElements() {
        return create(JavaEntityDescriptorEnum.DocElements);
    }

    public DocElements createDocElements(DocElement... entities) {
        return create(JavaEntityDescriptorEnum.DocElements, (IEntity[]) entities);
    }

    public DocElements createDocElements(int initialSize) {
        return clone(JavaEntityDescriptorEnum.DocElements, initialSize);
    }

    public MethodRef createMethodRef() {
        return create(JavaEntityDescriptorEnum.MethodRef);
    }

    public MethodRef createMethodRef(Name qualifier, SimpleName name, MethodRefParameters parameters) {
        return create(JavaEntityDescriptorEnum.MethodRef, qualifier, name, parameters);
    }

    public IEntityBuilder<MethodRef> buildMethodRef() {
        return new EntityBuilder<MethodRef>(create(JavaEntityDescriptorEnum.MethodRef));
    }

    public MethodRefParameters createMethodRefParameters() {
        return create(JavaEntityDescriptorEnum.MethodRefParameters);
    }

    public MethodRefParameters createMethodRefParameters(MethodRefParameter... entities) {
        return create(JavaEntityDescriptorEnum.MethodRefParameters, (IEntity[]) entities);
    }

    public MethodRefParameters createMethodRefParameters(int initialSize) {
        return clone(JavaEntityDescriptorEnum.MethodRefParameters, initialSize);
    }

    public MethodRefParameter createMethodRefParameter() {
        return create(JavaEntityDescriptorEnum.MethodRefParameter);
    }

    public MethodRefParameter createMethodRefParameter(Type type, Varargs varargs, SimpleName name) {
        return create(JavaEntityDescriptorEnum.MethodRefParameter, type, varargs, name);
    }

    public IEntityBuilder<MethodRefParameter> buildMethodRefParameter() {
        return new EntityBuilder<MethodRefParameter>(create(JavaEntityDescriptorEnum.MethodRefParameter));
    }

    public MemberRef createMemberRef() {
        return create(JavaEntityDescriptorEnum.MemberRef);
    }

    public MemberRef createMemberRef(Name qualifier, SimpleName name) {
        return create(JavaEntityDescriptorEnum.MemberRef, qualifier, name);
    }

    public IEntityBuilder<MemberRef> buildMemberRef() {
        return new EntityBuilder<MemberRef>(create(JavaEntityDescriptorEnum.MemberRef));
    }

    public TextElement createTextElement() {
        return create(JavaEntityDescriptorEnum.TextElement);
    }

    public TextElement createTextElement(String value) {
        return create(JavaEntityDescriptorEnum.TextElement, value);
    }

    public TagElement createTagElement() {
        return create(JavaEntityDescriptorEnum.TagElement);
    }

    public TagElement createTagElement(TagName tagName, DocElements fragments) {
        return create(JavaEntityDescriptorEnum.TagElement, tagName, fragments);
    }

    public IEntityBuilder<TagElement> buildTagElement() {
        return new EntityBuilder<TagElement>(create(JavaEntityDescriptorEnum.TagElement));
    }

    public TagName createTagName() {
        return create(JavaEntityDescriptorEnum.TagName);
    }

    public TagName createTagName(String value) {
        return create(JavaEntityDescriptorEnum.TagName, value);
    }

    public Annotations createAnnotations() {
        return create(JavaEntityDescriptorEnum.Annotations);
    }

    public Annotations createAnnotations(Annotation... entities) {
        return create(JavaEntityDescriptorEnum.Annotations, (IEntity[]) entities);
    }

    public Annotations createAnnotations(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Annotations, initialSize);
    }

    public SingleMemberAnnotation createSingleMemberAnnotation() {
        return create(JavaEntityDescriptorEnum.SingleMemberAnnotation);
    }

    public SingleMemberAnnotation createSingleMemberAnnotation(Name typeName, Expression value) {
        return create(JavaEntityDescriptorEnum.SingleMemberAnnotation, typeName, value);
    }

    public IEntityBuilder<SingleMemberAnnotation> buildSingleMemberAnnotation() {
        return new EntityBuilder<SingleMemberAnnotation>(create(JavaEntityDescriptorEnum.SingleMemberAnnotation));
    }

    public MarkerAnnotation createMarkerAnnotation() {
        return create(JavaEntityDescriptorEnum.MarkerAnnotation);
    }

    public MarkerAnnotation createMarkerAnnotation(Name typeName) {
        return create(JavaEntityDescriptorEnum.MarkerAnnotation, typeName);
    }

    public NormalAnnotation createNormalAnnotation() {
        return create(JavaEntityDescriptorEnum.NormalAnnotation);
    }

    public NormalAnnotation createNormalAnnotation(Name typeName, MemberValuePairs values) {
        return create(JavaEntityDescriptorEnum.NormalAnnotation, typeName, values);
    }

    public IEntityBuilder<NormalAnnotation> buildNormalAnnotation() {
        return new EntityBuilder<NormalAnnotation>(create(JavaEntityDescriptorEnum.NormalAnnotation));
    }

    public MemberValuePairs createMemberValuePairs() {
        return create(JavaEntityDescriptorEnum.MemberValuePairs);
    }

    public MemberValuePairs createMemberValuePairs(MemberValuePair... entities) {
        return create(JavaEntityDescriptorEnum.MemberValuePairs, (IEntity[]) entities);
    }

    public MemberValuePairs createMemberValuePairs(int initialSize) {
        return clone(JavaEntityDescriptorEnum.MemberValuePairs, initialSize);
    }

    public MemberValuePair createMemberValuePair() {
        return create(JavaEntityDescriptorEnum.MemberValuePair);
    }

    public MemberValuePair createMemberValuePair(SimpleName name, Expression value) {
        return create(JavaEntityDescriptorEnum.MemberValuePair, name, value);
    }

    public IEntityBuilder<MemberValuePair> buildMemberValuePair() {
        return new EntityBuilder<MemberValuePair>(create(JavaEntityDescriptorEnum.MemberValuePair));
    }

    public ImportDeclarations createImportDeclarations() {
        return create(JavaEntityDescriptorEnum.ImportDeclarations);
    }

    public ImportDeclarations createImportDeclarations(ImportDeclaration... entities) {
        return create(JavaEntityDescriptorEnum.ImportDeclarations, (IEntity[]) entities);
    }

    public ImportDeclarations createImportDeclarations(int initialSize) {
        return clone(JavaEntityDescriptorEnum.ImportDeclarations, initialSize);
    }

    public ImportDeclaration createImportDeclaration() {
        return create(JavaEntityDescriptorEnum.ImportDeclaration);
    }

    public ImportDeclaration createImportDeclaration(Name name, ImportModifier onDemand, ImportModifier _static) {
        return create(JavaEntityDescriptorEnum.ImportDeclaration, name, onDemand, _static);
    }

    public IEntityBuilder<ImportDeclaration> buildImportDeclaration() {
        return new EntityBuilder<ImportDeclaration>(create(JavaEntityDescriptorEnum.ImportDeclaration));
    }

    public ImportModifier createImportModifier() {
        return create(JavaEntityDescriptorEnum.ImportModifier);
    }

    public ImportModifier createImportModifier(boolean value) {
        return create(JavaEntityDescriptorEnum.ImportModifier, value);
    }

    public TypeDeclarations createTypeDeclarations() {
        return create(JavaEntityDescriptorEnum.TypeDeclarations);
    }

    public TypeDeclarations createTypeDeclarations(TypeDeclaration... entities) {
        return create(JavaEntityDescriptorEnum.TypeDeclarations, (IEntity[]) entities);
    }

    public TypeDeclarations createTypeDeclarations(int initialSize) {
        return clone(JavaEntityDescriptorEnum.TypeDeclarations, initialSize);
    }

    public EnumDeclaration createEnumDeclaration() {
        return create(JavaEntityDescriptorEnum.EnumDeclaration);
    }

    public EnumDeclaration createEnumDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, SimpleName name, Types superInterfaceTypes, EnumConstants enumConstants, BodyDeclarations bodyDeclarations) {
        return create(JavaEntityDescriptorEnum.EnumDeclaration, javadoc, modifiers, name, superInterfaceTypes, enumConstants, bodyDeclarations);
    }

    public IEntityBuilder<EnumDeclaration> buildEnumDeclaration() {
        return new EntityBuilder<EnumDeclaration>(create(JavaEntityDescriptorEnum.EnumDeclaration));
    }

    public EnumConstants createEnumConstants() {
        return create(JavaEntityDescriptorEnum.EnumConstants);
    }

    public EnumConstants createEnumConstants(EnumConstantDeclaration... entities) {
        return create(JavaEntityDescriptorEnum.EnumConstants, (IEntity[]) entities);
    }

    public EnumConstants createEnumConstants(int initialSize) {
        return clone(JavaEntityDescriptorEnum.EnumConstants, initialSize);
    }

    public EnumConstantDeclaration createEnumConstantDeclaration() {
        return create(JavaEntityDescriptorEnum.EnumConstantDeclaration);
    }

    public EnumConstantDeclaration createEnumConstantDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, SimpleName name, Arguments arguments, AnonymousClassDeclaration anonymousClassDeclaration) {
        return create(JavaEntityDescriptorEnum.EnumConstantDeclaration, javadoc, modifiers, name, arguments, anonymousClassDeclaration);
    }

    public IEntityBuilder<EnumConstantDeclaration> buildEnumConstantDeclaration() {
        return new EntityBuilder<EnumConstantDeclaration>(create(JavaEntityDescriptorEnum.EnumConstantDeclaration));
    }

    public Arguments createArguments() {
        return create(JavaEntityDescriptorEnum.Arguments);
    }

    public Arguments createArguments(Expression... entities) {
        return create(JavaEntityDescriptorEnum.Arguments, (IEntity[]) entities);
    }

    public Arguments createArguments(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Arguments, initialSize);
    }

    public AnonymousClassDeclaration createAnonymousClassDeclaration() {
        return create(JavaEntityDescriptorEnum.AnonymousClassDeclaration);
    }

    public AnonymousClassDeclaration createAnonymousClassDeclaration(BodyDeclaration... entities) {
        return create(JavaEntityDescriptorEnum.AnonymousClassDeclaration, (IEntity[]) entities);
    }

    public AnonymousClassDeclaration createAnonymousClassDeclaration(int initialSize) {
        return clone(JavaEntityDescriptorEnum.AnonymousClassDeclaration, initialSize);
    }

    public AnnotationTypeDeclaration createAnnotationTypeDeclaration() {
        return create(JavaEntityDescriptorEnum.AnnotationTypeDeclaration);
    }

    public AnnotationTypeDeclaration createAnnotationTypeDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, SimpleName name, BodyDeclarations bodyDeclarations) {
        return create(JavaEntityDescriptorEnum.AnnotationTypeDeclaration, javadoc, modifiers, name, bodyDeclarations);
    }

    public IEntityBuilder<AnnotationTypeDeclaration> buildAnnotationTypeDeclaration() {
        return new EntityBuilder<AnnotationTypeDeclaration>(create(JavaEntityDescriptorEnum.AnnotationTypeDeclaration));
    }

    public ClassDeclaration createClassDeclaration() {
        return create(JavaEntityDescriptorEnum.ClassDeclaration);
    }

    public ClassDeclaration createClassDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, SimpleName name, TypeParameters typeParameters, Type superclassType, Types superInterfaceTypes, BodyDeclarations bodyDeclarations) {
        return create(JavaEntityDescriptorEnum.ClassDeclaration, javadoc, modifiers, name, typeParameters, superclassType, superInterfaceTypes, bodyDeclarations);
    }

    public IEntityBuilder<ClassDeclaration> buildClassDeclaration() {
        return new EntityBuilder<ClassDeclaration>(create(JavaEntityDescriptorEnum.ClassDeclaration));
    }

    public InterfaceDeclaration createInterfaceDeclaration() {
        return create(JavaEntityDescriptorEnum.InterfaceDeclaration);
    }

    public InterfaceDeclaration createInterfaceDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, SimpleName name, TypeParameters typeParameters, Types superInterfaceTypes, BodyDeclarations bodyDeclarations) {
        return create(JavaEntityDescriptorEnum.InterfaceDeclaration, javadoc, modifiers, name, typeParameters, superInterfaceTypes, bodyDeclarations);
    }

    public IEntityBuilder<InterfaceDeclaration> buildInterfaceDeclaration() {
        return new EntityBuilder<InterfaceDeclaration>(create(JavaEntityDescriptorEnum.InterfaceDeclaration));
    }

    public TypeParameters createTypeParameters() {
        return create(JavaEntityDescriptorEnum.TypeParameters);
    }

    public TypeParameters createTypeParameters(TypeParameter... entities) {
        return create(JavaEntityDescriptorEnum.TypeParameters, (IEntity[]) entities);
    }

    public TypeParameters createTypeParameters(int initialSize) {
        return clone(JavaEntityDescriptorEnum.TypeParameters, initialSize);
    }

    public TypeParameter createTypeParameter() {
        return create(JavaEntityDescriptorEnum.TypeParameter);
    }

    public TypeParameter createTypeParameter(SimpleName name, Types typeBounds, Annotations annotations) {
        return create(JavaEntityDescriptorEnum.TypeParameter, name, typeBounds, annotations);
    }

    public IEntityBuilder<TypeParameter> buildTypeParameter() {
        return new EntityBuilder<TypeParameter>(create(JavaEntityDescriptorEnum.TypeParameter));
    }

    public Types createTypes() {
        return create(JavaEntityDescriptorEnum.Types);
    }

    public Types createTypes(Type... entities) {
        return create(JavaEntityDescriptorEnum.Types, (IEntity[]) entities);
    }

    public Types createTypes(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Types, initialSize);
    }

    public BodyDeclarations createBodyDeclarations() {
        return create(JavaEntityDescriptorEnum.BodyDeclarations);
    }

    public BodyDeclarations createBodyDeclarations(BodyDeclaration... entities) {
        return create(JavaEntityDescriptorEnum.BodyDeclarations, (IEntity[]) entities);
    }

    public BodyDeclarations createBodyDeclarations(int initialSize) {
        return clone(JavaEntityDescriptorEnum.BodyDeclarations, initialSize);
    }

    public AnnotationTypeMemberDeclaration createAnnotationTypeMemberDeclaration() {
        return create(JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration);
    }

    public AnnotationTypeMemberDeclaration createAnnotationTypeMemberDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, SimpleName name, Type type, Expression _default) {
        return create(JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration, javadoc, modifiers, name, type, _default);
    }

    public IEntityBuilder<AnnotationTypeMemberDeclaration> buildAnnotationTypeMemberDeclaration() {
        return new EntityBuilder<AnnotationTypeMemberDeclaration>(create(JavaEntityDescriptorEnum.AnnotationTypeMemberDeclaration));
    }

    public Initializer createInitializer() {
        return create(JavaEntityDescriptorEnum.Initializer);
    }

    public Initializer createInitializer(Javadoc javadoc, ExtendedModifiers modifiers, Block body) {
        return create(JavaEntityDescriptorEnum.Initializer, javadoc, modifiers, body);
    }

    public IEntityBuilder<Initializer> buildInitializer() {
        return new EntityBuilder<Initializer>(create(JavaEntityDescriptorEnum.Initializer));
    }

    public FieldDeclaration createFieldDeclaration() {
        return create(JavaEntityDescriptorEnum.FieldDeclaration);
    }

    public FieldDeclaration createFieldDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, Type type, VariableDeclarationFragments fragments) {
        return create(JavaEntityDescriptorEnum.FieldDeclaration, javadoc, modifiers, type, fragments);
    }

    public IEntityBuilder<FieldDeclaration> buildFieldDeclaration() {
        return new EntityBuilder<FieldDeclaration>(create(JavaEntityDescriptorEnum.FieldDeclaration));
    }

    public MethodDeclaration createMethodDeclaration() {
        return create(JavaEntityDescriptorEnum.MethodDeclaration);
    }

    public MethodDeclaration createMethodDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, TypeParameters typeParameters, Type returnType, SimpleName name, Parameters parameters, ExtraDimensions extraDimensions, Types thrownExceptions, Block body) {
        return create(JavaEntityDescriptorEnum.MethodDeclaration, javadoc, modifiers, typeParameters, returnType, name, parameters, extraDimensions, thrownExceptions, body);
    }

    public IEntityBuilder<MethodDeclaration> buildMethodDeclaration() {
        return new EntityBuilder<MethodDeclaration>(create(JavaEntityDescriptorEnum.MethodDeclaration));
    }

    public ConstructorDeclaration createConstructorDeclaration() {
        return create(JavaEntityDescriptorEnum.ConstructorDeclaration);
    }

    public ConstructorDeclaration createConstructorDeclaration(Javadoc javadoc, ExtendedModifiers modifiers, TypeParameters typeParameters, SimpleName name, Parameters parameters, ExtraDimensions extraDimensions, Types thrownExceptions, Block body) {
        return create(JavaEntityDescriptorEnum.ConstructorDeclaration, javadoc, modifiers, typeParameters, name, parameters, extraDimensions, thrownExceptions, body);
    }

    public IEntityBuilder<ConstructorDeclaration> buildConstructorDeclaration() {
        return new EntityBuilder<ConstructorDeclaration>(create(JavaEntityDescriptorEnum.ConstructorDeclaration));
    }

    public Parameters createParameters() {
        return create(JavaEntityDescriptorEnum.Parameters);
    }

    public Parameters createParameters(SingleVariableDeclaration... entities) {
        return create(JavaEntityDescriptorEnum.Parameters, (IEntity[]) entities);
    }

    public Parameters createParameters(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Parameters, initialSize);
    }

    public SingleVariableDeclaration createSingleVariableDeclaration() {
        return create(JavaEntityDescriptorEnum.SingleVariableDeclaration);
    }

    public SingleVariableDeclaration createSingleVariableDeclaration(ExtendedModifiers modifiers, Type type, Varargs varargs, SimpleName name, ExtraDimensions extraDimensions, Expression initializer, Annotations varargsAnnotations) {
        return create(JavaEntityDescriptorEnum.SingleVariableDeclaration, modifiers, type, varargs, name, extraDimensions, initializer, varargsAnnotations);
    }

    public IEntityBuilder<SingleVariableDeclaration> buildSingleVariableDeclaration() {
        return new EntityBuilder<SingleVariableDeclaration>(create(JavaEntityDescriptorEnum.SingleVariableDeclaration));
    }

    public Varargs createVarargs() {
        return create(JavaEntityDescriptorEnum.Varargs);
    }

    public Varargs createVarargs(boolean value) {
        return create(JavaEntityDescriptorEnum.Varargs, value);
    }

    public AnnotatedType createAnnotatedType() {
        return create(JavaEntityDescriptorEnum.AnnotatedType);
    }

    public AnnotatedType createAnnotatedType(Annotations annotations, Type type) {
        return create(JavaEntityDescriptorEnum.AnnotatedType, annotations, type);
    }

    public IEntityBuilder<AnnotatedType> buildAnnotatedType() {
        return new EntityBuilder<AnnotatedType>(create(JavaEntityDescriptorEnum.AnnotatedType));
    }

    public ArrayType createArrayType() {
        return create(JavaEntityDescriptorEnum.ArrayType);
    }

    public ArrayType createArrayType(Type componentType) {
        return create(JavaEntityDescriptorEnum.ArrayType, componentType);
    }

    public ParameterizedType createParameterizedType() {
        return create(JavaEntityDescriptorEnum.ParameterizedType);
    }

    public ParameterizedType createParameterizedType(Type type, Types typeArguments) {
        return create(JavaEntityDescriptorEnum.ParameterizedType, type, typeArguments);
    }

    public IEntityBuilder<ParameterizedType> buildParameterizedType() {
        return new EntityBuilder<ParameterizedType>(create(JavaEntityDescriptorEnum.ParameterizedType));
    }

    public PrimitiveType createPrimitiveType() {
        return create(JavaEntityDescriptorEnum.PrimitiveType);
    }

    public PrimitiveType createPrimitiveType(PrimitiveTypeEnum.Value value) {
        return create(JavaEntityDescriptorEnum.PrimitiveType, value);
    }

    public QualifiedType createQualifiedType() {
        return create(JavaEntityDescriptorEnum.QualifiedType);
    }

    public QualifiedType createQualifiedType(String value) {
        return create(JavaEntityDescriptorEnum.QualifiedType, value);
    }

    public SimpleType createSimpleType() {
        return create(JavaEntityDescriptorEnum.SimpleType);
    }

    public SimpleType createSimpleType(String value) {
        return create(JavaEntityDescriptorEnum.SimpleType, value);
    }

    public WildcardType createWildcardType() {
        return create(JavaEntityDescriptorEnum.WildcardType);
    }

    public WildcardType createWildcardType(Type bound, UpperBound upperBound) {
        return create(JavaEntityDescriptorEnum.WildcardType, bound, upperBound);
    }

    public IEntityBuilder<WildcardType> buildWildcardType() {
        return new EntityBuilder<WildcardType>(create(JavaEntityDescriptorEnum.WildcardType));
    }

    public UnionType createUnionType() {
        return create(JavaEntityDescriptorEnum.UnionType);
    }

    public UnionType createUnionType(Type... entities) {
        return create(JavaEntityDescriptorEnum.UnionType, (IEntity[]) entities);
    }

    public UnionType createUnionType(int initialSize) {
        return clone(JavaEntityDescriptorEnum.UnionType, initialSize);
    }

    public IntersectionType createIntersectionType() {
        return create(JavaEntityDescriptorEnum.IntersectionType);
    }

    public IntersectionType createIntersectionType(Type... entities) {
        return create(JavaEntityDescriptorEnum.IntersectionType, (IEntity[]) entities);
    }

    public IntersectionType createIntersectionType(int initialSize) {
        return clone(JavaEntityDescriptorEnum.IntersectionType, initialSize);
    }

    public UpperBound createUpperBound() {
        return create(JavaEntityDescriptorEnum.UpperBound);
    }

    public UpperBound createUpperBound(boolean value) {
        return create(JavaEntityDescriptorEnum.UpperBound, value);
    }

    public AssertStatement createAssertStatement() {
        return create(JavaEntityDescriptorEnum.AssertStatement);
    }

    public AssertStatement createAssertStatement(Expression expression, Expression message) {
        return create(JavaEntityDescriptorEnum.AssertStatement, expression, message);
    }

    public IEntityBuilder<AssertStatement> buildAssertStatement() {
        return new EntityBuilder<AssertStatement>(create(JavaEntityDescriptorEnum.AssertStatement));
    }

    public Block createBlock() {
        return create(JavaEntityDescriptorEnum.Block);
    }

    public Block createBlock(Statement... entities) {
        return create(JavaEntityDescriptorEnum.Block, (IEntity[]) entities);
    }

    public Block createBlock(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Block, initialSize);
    }

    public BreakStatement createBreakStatement() {
        return create(JavaEntityDescriptorEnum.BreakStatement);
    }

    public BreakStatement createBreakStatement(SimpleName label) {
        return create(JavaEntityDescriptorEnum.BreakStatement, label);
    }

    public ConstructorInvocation createConstructorInvocation() {
        return create(JavaEntityDescriptorEnum.ConstructorInvocation);
    }

    public ConstructorInvocation createConstructorInvocation(Types typeArguments, Arguments arguments) {
        return create(JavaEntityDescriptorEnum.ConstructorInvocation, typeArguments, arguments);
    }

    public IEntityBuilder<ConstructorInvocation> buildConstructorInvocation() {
        return new EntityBuilder<ConstructorInvocation>(create(JavaEntityDescriptorEnum.ConstructorInvocation));
    }

    public ContinueStatement createContinueStatement() {
        return create(JavaEntityDescriptorEnum.ContinueStatement);
    }

    public ContinueStatement createContinueStatement(SimpleName label) {
        return create(JavaEntityDescriptorEnum.ContinueStatement, label);
    }

    public DoStatement createDoStatement() {
        return create(JavaEntityDescriptorEnum.DoStatement);
    }

    public DoStatement createDoStatement(Expression expression, Statement body) {
        return create(JavaEntityDescriptorEnum.DoStatement, expression, body);
    }

    public IEntityBuilder<DoStatement> buildDoStatement() {
        return new EntityBuilder<DoStatement>(create(JavaEntityDescriptorEnum.DoStatement));
    }

    public EmptyStatement createEmptyStatement() {
        return create(JavaEntityDescriptorEnum.EmptyStatement);
    }

    public EnhancedForStatement createEnhancedForStatement() {
        return create(JavaEntityDescriptorEnum.EnhancedForStatement);
    }

    public EnhancedForStatement createEnhancedForStatement(SingleVariableDeclaration parameter, Expression expression, Statement body) {
        return create(JavaEntityDescriptorEnum.EnhancedForStatement, parameter, expression, body);
    }

    public IEntityBuilder<EnhancedForStatement> buildEnhancedForStatement() {
        return new EntityBuilder<EnhancedForStatement>(create(JavaEntityDescriptorEnum.EnhancedForStatement));
    }

    public ExpressionStatement createExpressionStatement() {
        return create(JavaEntityDescriptorEnum.ExpressionStatement);
    }

    public ExpressionStatement createExpressionStatement(Expression expression) {
        return create(JavaEntityDescriptorEnum.ExpressionStatement, expression);
    }

    public ForStatement createForStatement() {
        return create(JavaEntityDescriptorEnum.ForStatement);
    }

    public ForStatement createForStatement(Expressions initializers, Expression expression, Expressions updaters, Statement body) {
        return create(JavaEntityDescriptorEnum.ForStatement, initializers, expression, updaters, body);
    }

    public IEntityBuilder<ForStatement> buildForStatement() {
        return new EntityBuilder<ForStatement>(create(JavaEntityDescriptorEnum.ForStatement));
    }

    public Expressions createExpressions() {
        return create(JavaEntityDescriptorEnum.Expressions);
    }

    public Expressions createExpressions(Expression... entities) {
        return create(JavaEntityDescriptorEnum.Expressions, (IEntity[]) entities);
    }

    public Expressions createExpressions(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Expressions, initialSize);
    }

    public IfStatement createIfStatement() {
        return create(JavaEntityDescriptorEnum.IfStatement);
    }

    public IfStatement createIfStatement(Expression expression, Statement thenStatement, Statement elseStatement) {
        return create(JavaEntityDescriptorEnum.IfStatement, expression, thenStatement, elseStatement);
    }

    public IEntityBuilder<IfStatement> buildIfStatement() {
        return new EntityBuilder<IfStatement>(create(JavaEntityDescriptorEnum.IfStatement));
    }

    public LabeledStatement createLabeledStatement() {
        return create(JavaEntityDescriptorEnum.LabeledStatement);
    }

    public LabeledStatement createLabeledStatement(SimpleName label, Statement body) {
        return create(JavaEntityDescriptorEnum.LabeledStatement, label, body);
    }

    public IEntityBuilder<LabeledStatement> buildLabeledStatement() {
        return new EntityBuilder<LabeledStatement>(create(JavaEntityDescriptorEnum.LabeledStatement));
    }

    public ReturnStatement createReturnStatement() {
        return create(JavaEntityDescriptorEnum.ReturnStatement);
    }

    public ReturnStatement createReturnStatement(Expression expression) {
        return create(JavaEntityDescriptorEnum.ReturnStatement, expression);
    }

    public SuperConstructorInvocation createSuperConstructorInvocation() {
        return create(JavaEntityDescriptorEnum.SuperConstructorInvocation);
    }

    public SuperConstructorInvocation createSuperConstructorInvocation(Expression expression, Types typeArguments, Arguments arguments) {
        return create(JavaEntityDescriptorEnum.SuperConstructorInvocation, expression, typeArguments, arguments);
    }

    public IEntityBuilder<SuperConstructorInvocation> buildSuperConstructorInvocation() {
        return new EntityBuilder<SuperConstructorInvocation>(create(JavaEntityDescriptorEnum.SuperConstructorInvocation));
    }

    public SwitchCase createSwitchCase() {
        return create(JavaEntityDescriptorEnum.SwitchCase);
    }

    public SwitchCase createSwitchCase(Expression expression) {
        return create(JavaEntityDescriptorEnum.SwitchCase, expression);
    }

    public SwitchDefault createSwitchDefault() {
        return create(JavaEntityDescriptorEnum.SwitchDefault);
    }

    public SwitchStatement createSwitchStatement() {
        return create(JavaEntityDescriptorEnum.SwitchStatement);
    }

    public SwitchStatement createSwitchStatement(Expression expression, Statements statements) {
        return create(JavaEntityDescriptorEnum.SwitchStatement, expression, statements);
    }

    public IEntityBuilder<SwitchStatement> buildSwitchStatement() {
        return new EntityBuilder<SwitchStatement>(create(JavaEntityDescriptorEnum.SwitchStatement));
    }

    public Statements createStatements() {
        return create(JavaEntityDescriptorEnum.Statements);
    }

    public Statements createStatements(Statement... entities) {
        return create(JavaEntityDescriptorEnum.Statements, (IEntity[]) entities);
    }

    public Statements createStatements(int initialSize) {
        return clone(JavaEntityDescriptorEnum.Statements, initialSize);
    }

    public SynchronizedStatement createSynchronizedStatement() {
        return create(JavaEntityDescriptorEnum.SynchronizedStatement);
    }

    public SynchronizedStatement createSynchronizedStatement(Expression expression, Block body) {
        return create(JavaEntityDescriptorEnum.SynchronizedStatement, expression, body);
    }

    public IEntityBuilder<SynchronizedStatement> buildSynchronizedStatement() {
        return new EntityBuilder<SynchronizedStatement>(create(JavaEntityDescriptorEnum.SynchronizedStatement));
    }

    public ThrowStatement createThrowStatement() {
        return create(JavaEntityDescriptorEnum.ThrowStatement);
    }

    public ThrowStatement createThrowStatement(Expression expression) {
        return create(JavaEntityDescriptorEnum.ThrowStatement, expression);
    }

    public TryStatement createTryStatement() {
        return create(JavaEntityDescriptorEnum.TryStatement);
    }

    public TryStatement createTryStatement(Block body, CatchClauses catchClauses, Block _finally) {
        return create(JavaEntityDescriptorEnum.TryStatement, body, catchClauses, _finally);
    }

    public IEntityBuilder<TryStatement> buildTryStatement() {
        return new EntityBuilder<TryStatement>(create(JavaEntityDescriptorEnum.TryStatement));
    }

    public CatchClauses createCatchClauses() {
        return create(JavaEntityDescriptorEnum.CatchClauses);
    }

    public CatchClauses createCatchClauses(CatchClause... entities) {
        return create(JavaEntityDescriptorEnum.CatchClauses, (IEntity[]) entities);
    }

    public CatchClauses createCatchClauses(int initialSize) {
        return clone(JavaEntityDescriptorEnum.CatchClauses, initialSize);
    }

    public CatchClause createCatchClause() {
        return create(JavaEntityDescriptorEnum.CatchClause);
    }

    public CatchClause createCatchClause(SingleVariableDeclaration exception, Block body) {
        return create(JavaEntityDescriptorEnum.CatchClause, exception, body);
    }

    public IEntityBuilder<CatchClause> buildCatchClause() {
        return new EntityBuilder<CatchClause>(create(JavaEntityDescriptorEnum.CatchClause));
    }

    public TypeDeclarationStatement createTypeDeclarationStatement() {
        return create(JavaEntityDescriptorEnum.TypeDeclarationStatement);
    }

    public TypeDeclarationStatement createTypeDeclarationStatement(TypeDeclaration typeDeclaration) {
        return create(JavaEntityDescriptorEnum.TypeDeclarationStatement, typeDeclaration);
    }

    public VariableDeclarationStatement createVariableDeclarationStatement() {
        return create(JavaEntityDescriptorEnum.VariableDeclarationStatement);
    }

    public VariableDeclarationStatement createVariableDeclarationStatement(ExtendedModifiers modifiers, Type type, VariableDeclarationFragments fragments) {
        return create(JavaEntityDescriptorEnum.VariableDeclarationStatement, modifiers, type, fragments);
    }

    public IEntityBuilder<VariableDeclarationStatement> buildVariableDeclarationStatement() {
        return new EntityBuilder<VariableDeclarationStatement>(create(JavaEntityDescriptorEnum.VariableDeclarationStatement));
    }

    public WhileStatement createWhileStatement() {
        return create(JavaEntityDescriptorEnum.WhileStatement);
    }

    public WhileStatement createWhileStatement(Expression expression, Statement body) {
        return create(JavaEntityDescriptorEnum.WhileStatement, expression, body);
    }

    public IEntityBuilder<WhileStatement> buildWhileStatement() {
        return new EntityBuilder<WhileStatement>(create(JavaEntityDescriptorEnum.WhileStatement));
    }

    public SimpleName createSimpleName() {
        return create(JavaEntityDescriptorEnum.SimpleName);
    }

    public SimpleName createSimpleName(String value) {
        return create(JavaEntityDescriptorEnum.SimpleName, value);
    }

    public QualifiedName createQualifiedName() {
        return create(JavaEntityDescriptorEnum.QualifiedName);
    }

    public QualifiedName createQualifiedName(String value) {
        return create(JavaEntityDescriptorEnum.QualifiedName, value);
    }

    public NullLiteral createNullLiteral() {
        return create(JavaEntityDescriptorEnum.NullLiteral);
    }

    public BooleanLiteral createBooleanLiteral() {
        return create(JavaEntityDescriptorEnum.BooleanLiteral);
    }

    public BooleanLiteral createBooleanLiteral(boolean value) {
        return create(JavaEntityDescriptorEnum.BooleanLiteral, value);
    }

    public ByteLiteral createByteLiteral() {
        return create(JavaEntityDescriptorEnum.ByteLiteral);
    }

    public ByteLiteral createByteLiteral(byte value) {
        return create(JavaEntityDescriptorEnum.ByteLiteral, value);
    }

    public CharLiteral createCharLiteral() {
        return create(JavaEntityDescriptorEnum.CharLiteral);
    }

    public CharLiteral createCharLiteral(char value) {
        return create(JavaEntityDescriptorEnum.CharLiteral, value);
    }

    public DoubleLiteral createDoubleLiteral() {
        return create(JavaEntityDescriptorEnum.DoubleLiteral);
    }

    public DoubleLiteral createDoubleLiteral(double value) {
        return create(JavaEntityDescriptorEnum.DoubleLiteral, value);
    }

    public FloatLiteral createFloatLiteral() {
        return create(JavaEntityDescriptorEnum.FloatLiteral);
    }

    public FloatLiteral createFloatLiteral(float value) {
        return create(JavaEntityDescriptorEnum.FloatLiteral, value);
    }

    public IntLiteral createIntLiteral() {
        return create(JavaEntityDescriptorEnum.IntLiteral);
    }

    public IntLiteral createIntLiteral(int value) {
        return create(JavaEntityDescriptorEnum.IntLiteral, value);
    }

    public ShortLiteral createShortLiteral() {
        return create(JavaEntityDescriptorEnum.ShortLiteral);
    }

    public ShortLiteral createShortLiteral(short value) {
        return create(JavaEntityDescriptorEnum.ShortLiteral, value);
    }

    public LongLiteral createLongLiteral() {
        return create(JavaEntityDescriptorEnum.LongLiteral);
    }

    public LongLiteral createLongLiteral(long value) {
        return create(JavaEntityDescriptorEnum.LongLiteral, value);
    }

    public StringLiteral createStringLiteral() {
        return create(JavaEntityDescriptorEnum.StringLiteral);
    }

    public StringLiteral createStringLiteral(String value) {
        return create(JavaEntityDescriptorEnum.StringLiteral, value);
    }

    public TypeLiteral createTypeLiteral() {
        return create(JavaEntityDescriptorEnum.TypeLiteral);
    }

    public TypeLiteral createTypeLiteral(Type type) {
        return create(JavaEntityDescriptorEnum.TypeLiteral, type);
    }

    public ArrayAccess createArrayAccess() {
        return create(JavaEntityDescriptorEnum.ArrayAccess);
    }

    public ArrayAccess createArrayAccess(Expression array, Expression index) {
        return create(JavaEntityDescriptorEnum.ArrayAccess, array, index);
    }

    public IEntityBuilder<ArrayAccess> buildArrayAccess() {
        return new EntityBuilder<ArrayAccess>(create(JavaEntityDescriptorEnum.ArrayAccess));
    }

    public ArrayCreation createArrayCreation() {
        return create(JavaEntityDescriptorEnum.ArrayCreation);
    }

    public ArrayCreation createArrayCreation(ArrayType type, Expressions dimensions, ArrayInitializer initializer) {
        return create(JavaEntityDescriptorEnum.ArrayCreation, type, dimensions, initializer);
    }

    public IEntityBuilder<ArrayCreation> buildArrayCreation() {
        return new EntityBuilder<ArrayCreation>(create(JavaEntityDescriptorEnum.ArrayCreation));
    }

    public ArrayInitializer createArrayInitializer() {
        return create(JavaEntityDescriptorEnum.ArrayInitializer);
    }

    public ArrayInitializer createArrayInitializer(Expression... entities) {
        return create(JavaEntityDescriptorEnum.ArrayInitializer, (IEntity[]) entities);
    }

    public ArrayInitializer createArrayInitializer(int initialSize) {
        return clone(JavaEntityDescriptorEnum.ArrayInitializer, initialSize);
    }

    public Assignment createAssignment() {
        return create(JavaEntityDescriptorEnum.Assignment);
    }

    public Assignment createAssignment(Expression leftHandSide, AssignmentOperator operator, Expression rightHandSide) {
        return create(JavaEntityDescriptorEnum.Assignment, leftHandSide, operator, rightHandSide);
    }

    public IEntityBuilder<Assignment> buildAssignment() {
        return new EntityBuilder<Assignment>(create(JavaEntityDescriptorEnum.Assignment));
    }

    public AssignmentOperator createAssignmentOperator() {
        return create(JavaEntityDescriptorEnum.AssignmentOperator);
    }

    public AssignmentOperator createAssignmentOperator(AssignmentOperatorEnum.Value value) {
        return create(JavaEntityDescriptorEnum.AssignmentOperator, value);
    }

    public CastExpression createCastExpression() {
        return create(JavaEntityDescriptorEnum.CastExpression);
    }

    public CastExpression createCastExpression(Type type, Expression expression) {
        return create(JavaEntityDescriptorEnum.CastExpression, type, expression);
    }

    public IEntityBuilder<CastExpression> buildCastExpression() {
        return new EntityBuilder<CastExpression>(create(JavaEntityDescriptorEnum.CastExpression));
    }

    public ClassInstanceCreation createClassInstanceCreation() {
        return create(JavaEntityDescriptorEnum.ClassInstanceCreation);
    }

    public ClassInstanceCreation createClassInstanceCreation(Expression expression, Types typeArguments, Type type, Arguments arguments, AnonymousClassDeclaration anonymousClassDeclaration) {
        return create(JavaEntityDescriptorEnum.ClassInstanceCreation, expression, typeArguments, type, arguments, anonymousClassDeclaration);
    }

    public IEntityBuilder<ClassInstanceCreation> buildClassInstanceCreation() {
        return new EntityBuilder<ClassInstanceCreation>(create(JavaEntityDescriptorEnum.ClassInstanceCreation));
    }

    public ConditionalExpression createConditionalExpression() {
        return create(JavaEntityDescriptorEnum.ConditionalExpression);
    }

    public ConditionalExpression createConditionalExpression(Expression expression, Expression thenExpression, Expression elseExpression) {
        return create(JavaEntityDescriptorEnum.ConditionalExpression, expression, thenExpression, elseExpression);
    }

    public IEntityBuilder<ConditionalExpression> buildConditionalExpression() {
        return new EntityBuilder<ConditionalExpression>(create(JavaEntityDescriptorEnum.ConditionalExpression));
    }

    public FieldAccess createFieldAccess() {
        return create(JavaEntityDescriptorEnum.FieldAccess);
    }

    public FieldAccess createFieldAccess(Expression expression, SimpleName name) {
        return create(JavaEntityDescriptorEnum.FieldAccess, expression, name);
    }

    public IEntityBuilder<FieldAccess> buildFieldAccess() {
        return new EntityBuilder<FieldAccess>(create(JavaEntityDescriptorEnum.FieldAccess));
    }

    public InfixExpression createInfixExpression() {
        return create(JavaEntityDescriptorEnum.InfixExpression);
    }

    public InfixExpression createInfixExpression(Expression leftOperand, InfixOperator operator, Expression rightOperand, Expressions extendedOperands) {
        return create(JavaEntityDescriptorEnum.InfixExpression, leftOperand, operator, rightOperand, extendedOperands);
    }

    public IEntityBuilder<InfixExpression> buildInfixExpression() {
        return new EntityBuilder<InfixExpression>(create(JavaEntityDescriptorEnum.InfixExpression));
    }

    public InfixOperator createInfixOperator() {
        return create(JavaEntityDescriptorEnum.InfixOperator);
    }

    public InfixOperator createInfixOperator(InfixOperatorEnum.Value value) {
        return create(JavaEntityDescriptorEnum.InfixOperator, value);
    }

    public InstanceofExpression createInstanceofExpression() {
        return create(JavaEntityDescriptorEnum.InstanceofExpression);
    }

    public InstanceofExpression createInstanceofExpression(Expression leftOperand, Type rightOperand) {
        return create(JavaEntityDescriptorEnum.InstanceofExpression, leftOperand, rightOperand);
    }

    public IEntityBuilder<InstanceofExpression> buildInstanceofExpression() {
        return new EntityBuilder<InstanceofExpression>(create(JavaEntityDescriptorEnum.InstanceofExpression));
    }

    public LambdaExpression createLambdaExpression() {
        return create(JavaEntityDescriptorEnum.LambdaExpression);
    }

    public LambdaExpression createLambdaExpression(LambdaParameters parameters, ExpressionOrStatement body) {
        return create(JavaEntityDescriptorEnum.LambdaExpression, parameters, body);
    }

    public IEntityBuilder<LambdaExpression> buildLambdaExpression() {
        return new EntityBuilder<LambdaExpression>(create(JavaEntityDescriptorEnum.LambdaExpression));
    }

    public MethodInvocation createMethodInvocation() {
        return create(JavaEntityDescriptorEnum.MethodInvocation);
    }

    public MethodInvocation createMethodInvocation(Expression expression, Types typeArguments, SimpleName name, Arguments arguments) {
        return create(JavaEntityDescriptorEnum.MethodInvocation, expression, typeArguments, name, arguments);
    }

    public IEntityBuilder<MethodInvocation> buildMethodInvocation() {
        return new EntityBuilder<MethodInvocation>(create(JavaEntityDescriptorEnum.MethodInvocation));
    }

    public ParenthesizedExpression createParenthesizedExpression() {
        return create(JavaEntityDescriptorEnum.ParenthesizedExpression);
    }

    public ParenthesizedExpression createParenthesizedExpression(Expression expression) {
        return create(JavaEntityDescriptorEnum.ParenthesizedExpression, expression);
    }

    public PostfixExpression createPostfixExpression() {
        return create(JavaEntityDescriptorEnum.PostfixExpression);
    }

    public PostfixExpression createPostfixExpression(Expression operand, PostfixOperator operator) {
        return create(JavaEntityDescriptorEnum.PostfixExpression, operand, operator);
    }

    public IEntityBuilder<PostfixExpression> buildPostfixExpression() {
        return new EntityBuilder<PostfixExpression>(create(JavaEntityDescriptorEnum.PostfixExpression));
    }

    public PostfixOperator createPostfixOperator() {
        return create(JavaEntityDescriptorEnum.PostfixOperator);
    }

    public PostfixOperator createPostfixOperator(PostfixOperatorEnum.Value value) {
        return create(JavaEntityDescriptorEnum.PostfixOperator, value);
    }

    public PrefixExpression createPrefixExpression() {
        return create(JavaEntityDescriptorEnum.PrefixExpression);
    }

    public PrefixExpression createPrefixExpression(PrefixOperator operator, Expression operand) {
        return create(JavaEntityDescriptorEnum.PrefixExpression, operator, operand);
    }

    public IEntityBuilder<PrefixExpression> buildPrefixExpression() {
        return new EntityBuilder<PrefixExpression>(create(JavaEntityDescriptorEnum.PrefixExpression));
    }

    public PrefixOperator createPrefixOperator() {
        return create(JavaEntityDescriptorEnum.PrefixOperator);
    }

    public PrefixOperator createPrefixOperator(PrefixOperatorEnum.Value value) {
        return create(JavaEntityDescriptorEnum.PrefixOperator, value);
    }

    public SuperFieldAccess createSuperFieldAccess() {
        return create(JavaEntityDescriptorEnum.SuperFieldAccess);
    }

    public SuperFieldAccess createSuperFieldAccess(Name qualifier, SimpleName name) {
        return create(JavaEntityDescriptorEnum.SuperFieldAccess, qualifier, name);
    }

    public IEntityBuilder<SuperFieldAccess> buildSuperFieldAccess() {
        return new EntityBuilder<SuperFieldAccess>(create(JavaEntityDescriptorEnum.SuperFieldAccess));
    }

    public SuperMethodInvocation createSuperMethodInvocation() {
        return create(JavaEntityDescriptorEnum.SuperMethodInvocation);
    }

    public SuperMethodInvocation createSuperMethodInvocation(Name qualifier, Types typeArguments, SimpleName name, Arguments arguments) {
        return create(JavaEntityDescriptorEnum.SuperMethodInvocation, qualifier, typeArguments, name, arguments);
    }

    public IEntityBuilder<SuperMethodInvocation> buildSuperMethodInvocation() {
        return new EntityBuilder<SuperMethodInvocation>(create(JavaEntityDescriptorEnum.SuperMethodInvocation));
    }

    public ThisExpression createThisExpression() {
        return create(JavaEntityDescriptorEnum.ThisExpression);
    }

    public ThisExpression createThisExpression(Name qualifier) {
        return create(JavaEntityDescriptorEnum.ThisExpression, qualifier);
    }

    public VariableDeclarationExpression createVariableDeclarationExpression() {
        return create(JavaEntityDescriptorEnum.VariableDeclarationExpression);
    }

    public VariableDeclarationExpression createVariableDeclarationExpression(ExtendedModifiers modifiers, Type type, VariableDeclarationFragments fragments) {
        return create(JavaEntityDescriptorEnum.VariableDeclarationExpression, modifiers, type, fragments);
    }

    public IEntityBuilder<VariableDeclarationExpression> buildVariableDeclarationExpression() {
        return new EntityBuilder<VariableDeclarationExpression>(create(JavaEntityDescriptorEnum.VariableDeclarationExpression));
    }

    public VariableDeclarationFragments createVariableDeclarationFragments() {
        return create(JavaEntityDescriptorEnum.VariableDeclarationFragments);
    }

    public VariableDeclarationFragments createVariableDeclarationFragments(VariableDeclarationFragment... entities) {
        return create(JavaEntityDescriptorEnum.VariableDeclarationFragments, (IEntity[]) entities);
    }

    public VariableDeclarationFragments createVariableDeclarationFragments(int initialSize) {
        return clone(JavaEntityDescriptorEnum.VariableDeclarationFragments, initialSize);
    }

    public VariableDeclarationFragment createVariableDeclarationFragment() {
        return create(JavaEntityDescriptorEnum.VariableDeclarationFragment);
    }

    public VariableDeclarationFragment createVariableDeclarationFragment(SimpleName name, ExtraDimensions extraDimensions, Expression initializer) {
        return create(JavaEntityDescriptorEnum.VariableDeclarationFragment, name, extraDimensions, initializer);
    }

    public IEntityBuilder<VariableDeclarationFragment> buildVariableDeclarationFragment() {
        return new EntityBuilder<VariableDeclarationFragment>(create(JavaEntityDescriptorEnum.VariableDeclarationFragment));
    }

    public ExtraDimensions createExtraDimensions() {
        return create(JavaEntityDescriptorEnum.ExtraDimensions);
    }

    public ExtraDimensions createExtraDimensions(int value) {
        return create(JavaEntityDescriptorEnum.ExtraDimensions, value);
    }

    public ExtendedModifiers createExtendedModifiers() {
        return create(JavaEntityDescriptorEnum.ExtendedModifiers);
    }

    public ExtendedModifiers createExtendedModifiers(ExtendedModifier... entities) {
        return create(JavaEntityDescriptorEnum.ExtendedModifiers, (IEntity[]) entities);
    }

    public ExtendedModifiers createExtendedModifiers(int initialSize) {
        return clone(JavaEntityDescriptorEnum.ExtendedModifiers, initialSize);
    }

    public Modifier createModifier() {
        return create(JavaEntityDescriptorEnum.Modifier);
    }

    public Modifier createModifier(ModifierEnum.Value value) {
        return create(JavaEntityDescriptorEnum.Modifier, value);
    }

    public ConstructorReference createConstructorReference() {
        return create(JavaEntityDescriptorEnum.ConstructorReference);
    }

    public ConstructorReference createConstructorReference(Type type, Types typeArguments) {
        return create(JavaEntityDescriptorEnum.ConstructorReference, type, typeArguments);
    }

    public IEntityBuilder<ConstructorReference> buildConstructorReference() {
        return new EntityBuilder<ConstructorReference>(create(JavaEntityDescriptorEnum.ConstructorReference));
    }

    public ExpressionMethodReference createExpressionMethodReference() {
        return create(JavaEntityDescriptorEnum.ExpressionMethodReference);
    }

    public ExpressionMethodReference createExpressionMethodReference(Expression expression, Types typeArguments, SimpleName name) {
        return create(JavaEntityDescriptorEnum.ExpressionMethodReference, expression, typeArguments, name);
    }

    public IEntityBuilder<ExpressionMethodReference> buildExpressionMethodReference() {
        return new EntityBuilder<ExpressionMethodReference>(create(JavaEntityDescriptorEnum.ExpressionMethodReference));
    }

    public SuperMethodReference createSuperMethodReference() {
        return create(JavaEntityDescriptorEnum.SuperMethodReference);
    }

    public SuperMethodReference createSuperMethodReference(Name qualifier, Types typeArguments, SimpleName name) {
        return create(JavaEntityDescriptorEnum.SuperMethodReference, qualifier, typeArguments, name);
    }

    public IEntityBuilder<SuperMethodReference> buildSuperMethodReference() {
        return new EntityBuilder<SuperMethodReference>(create(JavaEntityDescriptorEnum.SuperMethodReference));
    }

    public TypeMethodReference createTypeMethodReference() {
        return create(JavaEntityDescriptorEnum.TypeMethodReference);
    }

    public TypeMethodReference createTypeMethodReference(Type type, Types typeArguments, SimpleName name) {
        return create(JavaEntityDescriptorEnum.TypeMethodReference, type, typeArguments, name);
    }

    public IEntityBuilder<TypeMethodReference> buildTypeMethodReference() {
        return new EntityBuilder<TypeMethodReference>(create(JavaEntityDescriptorEnum.TypeMethodReference));
    }
}
