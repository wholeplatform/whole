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
package org.whole.lang.java.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class JavaEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int JavaSystemSoftware_ord = 0;
    public static final int CompilationUnit_ord = 1;
    public static final int PackageDeclaration_ord = 2;
    public static final int Statement_ord = 3;
    public static final int Expression_ord = 4;
    public static final int Comment_ord = 5;
    public static final int BlockComment_ord = 6;
    public static final int LineComment_ord = 7;
    public static final int Javadoc_ord = 8;
    public static final int Tags_ord = 9;
    public static final int DocElements_ord = 10;
    public static final int MethodRef_ord = 11;
    public static final int MethodRefParameters_ord = 12;
    public static final int MethodRefParameter_ord = 13;
    public static final int MemberRef_ord = 14;
    public static final int TextElement_ord = 15;
    public static final int TagElement_ord = 16;
    public static final int TagName_ord = 17;
    public static final int Annotations_ord = 18;
    public static final int Annotation_ord = 19;
    public static final int SingleMemberAnnotation_ord = 20;
    public static final int MarkerAnnotation_ord = 21;
    public static final int NormalAnnotation_ord = 22;
    public static final int MemberValuePairs_ord = 23;
    public static final int MemberValuePair_ord = 24;
    public static final int ImportDeclarations_ord = 25;
    public static final int ImportDeclaration_ord = 26;
    public static final int ImportModifier_ord = 27;
    public static final int TypeDeclarations_ord = 28;
    public static final int BodyDeclaration_ord = 29;
    public static final int AnnotatedBodyDeclaration_ord = 30;
    public static final int TypeDeclaration_ord = 31;
    public static final int EnumDeclaration_ord = 32;
    public static final int EnumConstants_ord = 33;
    public static final int EnumConstantDeclaration_ord = 34;
    public static final int Arguments_ord = 35;
    public static final int AnonymousClassDeclaration_ord = 36;
    public static final int AnnotationTypeDeclaration_ord = 37;
    public static final int ClassDeclaration_ord = 38;
    public static final int InterfaceDeclaration_ord = 39;
    public static final int TypeParameters_ord = 40;
    public static final int TypeParameter_ord = 41;
    public static final int Types_ord = 42;
    public static final int BodyDeclarations_ord = 43;
    public static final int AnnotationTypeMemberDeclaration_ord = 44;
    public static final int Initializer_ord = 45;
    public static final int FieldDeclaration_ord = 46;
    public static final int MethodDeclaration_ord = 47;
    public static final int ConstructorDeclaration_ord = 48;
    public static final int Parameters_ord = 49;
    public static final int SingleVariableDeclaration_ord = 50;
    public static final int Varargs_ord = 51;
    public static final int AnnotatedType_ord = 52;
    public static final int ArrayType_ord = 53;
    public static final int ParameterizedType_ord = 54;
    public static final int PrimitiveType_ord = 55;
    public static final int QualifiedType_ord = 56;
    public static final int SimpleType_ord = 57;
    public static final int WildcardType_ord = 58;
    public static final int UnionType_ord = 59;
    public static final int IntersectionType_ord = 60;
    public static final int UpperBound_ord = 61;
    public static final int AssertStatement_ord = 62;
    public static final int Block_ord = 63;
    public static final int BreakStatement_ord = 64;
    public static final int ConstructorInvocation_ord = 65;
    public static final int ContinueStatement_ord = 66;
    public static final int DoStatement_ord = 67;
    public static final int EmptyStatement_ord = 68;
    public static final int EnhancedForStatement_ord = 69;
    public static final int ExpressionStatement_ord = 70;
    public static final int ForStatement_ord = 71;
    public static final int Expressions_ord = 72;
    public static final int IfStatement_ord = 73;
    public static final int LabeledStatement_ord = 74;
    public static final int ReturnStatement_ord = 75;
    public static final int SuperConstructorInvocation_ord = 76;
    public static final int SwitchCase_ord = 77;
    public static final int SwitchDefault_ord = 78;
    public static final int SwitchStatement_ord = 79;
    public static final int Statements_ord = 80;
    public static final int SynchronizedStatement_ord = 81;
    public static final int ThrowStatement_ord = 82;
    public static final int TryStatement_ord = 83;
    public static final int CatchClauses_ord = 84;
    public static final int CatchClause_ord = 85;
    public static final int TypeDeclarationStatement_ord = 86;
    public static final int VariableDeclarationStatement_ord = 87;
    public static final int WhileStatement_ord = 88;
    public static final int Name_ord = 89;
    public static final int SimpleName_ord = 90;
    public static final int QualifiedName_ord = 91;
    public static final int NullLiteral_ord = 92;
    public static final int BooleanLiteral_ord = 93;
    public static final int ByteLiteral_ord = 94;
    public static final int CharLiteral_ord = 95;
    public static final int DoubleLiteral_ord = 96;
    public static final int FloatLiteral_ord = 97;
    public static final int IntLiteral_ord = 98;
    public static final int ShortLiteral_ord = 99;
    public static final int LongLiteral_ord = 100;
    public static final int StringLiteral_ord = 101;
    public static final int TypeLiteral_ord = 102;
    public static final int ArrayAccess_ord = 103;
    public static final int ArrayCreation_ord = 104;
    public static final int ArrayInitializer_ord = 105;
    public static final int Assignment_ord = 106;
    public static final int AssignmentOperator_ord = 107;
    public static final int CastExpression_ord = 108;
    public static final int ClassInstanceCreation_ord = 109;
    public static final int ConditionalExpression_ord = 110;
    public static final int FieldAccess_ord = 111;
    public static final int InfixExpression_ord = 112;
    public static final int InfixOperator_ord = 113;
    public static final int InstanceofExpression_ord = 114;
    public static final int LambdaExpression_ord = 115;
    public static final int MethodInvocation_ord = 116;
    public static final int ParenthesizedExpression_ord = 117;
    public static final int PostfixExpression_ord = 118;
    public static final int PostfixOperator_ord = 119;
    public static final int PrefixExpression_ord = 120;
    public static final int PrefixOperator_ord = 121;
    public static final int SuperFieldAccess_ord = 122;
    public static final int SuperMethodInvocation_ord = 123;
    public static final int ThisExpression_ord = 124;
    public static final int VariableDeclarationExpression_ord = 125;
    public static final int VariableDeclarationFragments_ord = 126;
    public static final int VariableDeclarationFragment_ord = 127;
    public static final int ExtraDimensions_ord = 128;
    public static final int ExtendedModifiers_ord = 129;
    public static final int Modifier_ord = 130;
    public static final int MethodReference_ord = 131;
    public static final int ConstructorReference_ord = 132;
    public static final int ExpressionMethodReference_ord = 133;
    public static final int SuperMethodReference_ord = 134;
    public static final int TypeMethodReference_ord = 135;
    public static final int LambdaParameters_ord = 136;
    public static final int DocElement_ord = 137;
    public static final int ExpressionOrStatement_ord = 138;
    public static final int ExtendedModifier_ord = 139;
    public static final int VariableDeclaration_ord = 140;
    public static final int Type_ord = 141;
    public static final JavaEntityDescriptorEnum instance = new JavaEntityDescriptorEnum();
    public static final EntityDescriptor<JavaSystemSoftware> JavaSystemSoftware = (EntityDescriptor<JavaSystemSoftware>) instance.valueOf(JavaSystemSoftware_ord);
    public static final EntityDescriptor<CompilationUnit> CompilationUnit = (EntityDescriptor<CompilationUnit>) instance.valueOf(CompilationUnit_ord);
    public static final EntityDescriptor<PackageDeclaration> PackageDeclaration = (EntityDescriptor<PackageDeclaration>) instance.valueOf(PackageDeclaration_ord);
    public static final EntityDescriptor<Statement> Statement = (EntityDescriptor<Statement>) instance.valueOf(Statement_ord);
    public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance.valueOf(Expression_ord);
    public static final EntityDescriptor<Comment> Comment = (EntityDescriptor<Comment>) instance.valueOf(Comment_ord);
    public static final EntityDescriptor<BlockComment> BlockComment = (EntityDescriptor<BlockComment>) instance.valueOf(BlockComment_ord);
    public static final EntityDescriptor<LineComment> LineComment = (EntityDescriptor<LineComment>) instance.valueOf(LineComment_ord);
    public static final EntityDescriptor<Javadoc> Javadoc = (EntityDescriptor<Javadoc>) instance.valueOf(Javadoc_ord);
    public static final EntityDescriptor<Tags> Tags = (EntityDescriptor<Tags>) instance.valueOf(Tags_ord);
    public static final EntityDescriptor<DocElements> DocElements = (EntityDescriptor<DocElements>) instance.valueOf(DocElements_ord);
    public static final EntityDescriptor<MethodRef> MethodRef = (EntityDescriptor<MethodRef>) instance.valueOf(MethodRef_ord);
    public static final EntityDescriptor<MethodRefParameters> MethodRefParameters = (EntityDescriptor<MethodRefParameters>) instance.valueOf(MethodRefParameters_ord);
    public static final EntityDescriptor<MethodRefParameter> MethodRefParameter = (EntityDescriptor<MethodRefParameter>) instance.valueOf(MethodRefParameter_ord);
    public static final EntityDescriptor<MemberRef> MemberRef = (EntityDescriptor<MemberRef>) instance.valueOf(MemberRef_ord);
    public static final EntityDescriptor<TextElement> TextElement = (EntityDescriptor<TextElement>) instance.valueOf(TextElement_ord);
    public static final EntityDescriptor<TagElement> TagElement = (EntityDescriptor<TagElement>) instance.valueOf(TagElement_ord);
    public static final EntityDescriptor<TagName> TagName = (EntityDescriptor<TagName>) instance.valueOf(TagName_ord);
    public static final EntityDescriptor<Annotations> Annotations = (EntityDescriptor<Annotations>) instance.valueOf(Annotations_ord);
    public static final EntityDescriptor<Annotation> Annotation = (EntityDescriptor<Annotation>) instance.valueOf(Annotation_ord);
    public static final EntityDescriptor<SingleMemberAnnotation> SingleMemberAnnotation = (EntityDescriptor<SingleMemberAnnotation>) instance.valueOf(SingleMemberAnnotation_ord);
    public static final EntityDescriptor<MarkerAnnotation> MarkerAnnotation = (EntityDescriptor<MarkerAnnotation>) instance.valueOf(MarkerAnnotation_ord);
    public static final EntityDescriptor<NormalAnnotation> NormalAnnotation = (EntityDescriptor<NormalAnnotation>) instance.valueOf(NormalAnnotation_ord);
    public static final EntityDescriptor<MemberValuePairs> MemberValuePairs = (EntityDescriptor<MemberValuePairs>) instance.valueOf(MemberValuePairs_ord);
    public static final EntityDescriptor<MemberValuePair> MemberValuePair = (EntityDescriptor<MemberValuePair>) instance.valueOf(MemberValuePair_ord);
    public static final EntityDescriptor<ImportDeclarations> ImportDeclarations = (EntityDescriptor<ImportDeclarations>) instance.valueOf(ImportDeclarations_ord);
    public static final EntityDescriptor<ImportDeclaration> ImportDeclaration = (EntityDescriptor<ImportDeclaration>) instance.valueOf(ImportDeclaration_ord);
    public static final EntityDescriptor<ImportModifier> ImportModifier = (EntityDescriptor<ImportModifier>) instance.valueOf(ImportModifier_ord);
    public static final EntityDescriptor<TypeDeclarations> TypeDeclarations = (EntityDescriptor<TypeDeclarations>) instance.valueOf(TypeDeclarations_ord);
    public static final EntityDescriptor<BodyDeclaration> BodyDeclaration = (EntityDescriptor<BodyDeclaration>) instance.valueOf(BodyDeclaration_ord);
    public static final EntityDescriptor<AnnotatedBodyDeclaration> AnnotatedBodyDeclaration = (EntityDescriptor<AnnotatedBodyDeclaration>) instance.valueOf(AnnotatedBodyDeclaration_ord);
    public static final EntityDescriptor<TypeDeclaration> TypeDeclaration = (EntityDescriptor<TypeDeclaration>) instance.valueOf(TypeDeclaration_ord);
    public static final EntityDescriptor<EnumDeclaration> EnumDeclaration = (EntityDescriptor<EnumDeclaration>) instance.valueOf(EnumDeclaration_ord);
    public static final EntityDescriptor<EnumConstants> EnumConstants = (EntityDescriptor<EnumConstants>) instance.valueOf(EnumConstants_ord);
    public static final EntityDescriptor<EnumConstantDeclaration> EnumConstantDeclaration = (EntityDescriptor<EnumConstantDeclaration>) instance.valueOf(EnumConstantDeclaration_ord);
    public static final EntityDescriptor<Arguments> Arguments = (EntityDescriptor<Arguments>) instance.valueOf(Arguments_ord);
    public static final EntityDescriptor<AnonymousClassDeclaration> AnonymousClassDeclaration = (EntityDescriptor<AnonymousClassDeclaration>) instance.valueOf(AnonymousClassDeclaration_ord);
    public static final EntityDescriptor<AnnotationTypeDeclaration> AnnotationTypeDeclaration = (EntityDescriptor<AnnotationTypeDeclaration>) instance.valueOf(AnnotationTypeDeclaration_ord);
    public static final EntityDescriptor<ClassDeclaration> ClassDeclaration = (EntityDescriptor<ClassDeclaration>) instance.valueOf(ClassDeclaration_ord);
    public static final EntityDescriptor<InterfaceDeclaration> InterfaceDeclaration = (EntityDescriptor<InterfaceDeclaration>) instance.valueOf(InterfaceDeclaration_ord);
    public static final EntityDescriptor<TypeParameters> TypeParameters = (EntityDescriptor<TypeParameters>) instance.valueOf(TypeParameters_ord);
    public static final EntityDescriptor<TypeParameter> TypeParameter = (EntityDescriptor<TypeParameter>) instance.valueOf(TypeParameter_ord);
    public static final EntityDescriptor<Types> Types = (EntityDescriptor<Types>) instance.valueOf(Types_ord);
    public static final EntityDescriptor<BodyDeclarations> BodyDeclarations = (EntityDescriptor<BodyDeclarations>) instance.valueOf(BodyDeclarations_ord);
    public static final EntityDescriptor<AnnotationTypeMemberDeclaration> AnnotationTypeMemberDeclaration = (EntityDescriptor<AnnotationTypeMemberDeclaration>) instance.valueOf(AnnotationTypeMemberDeclaration_ord);
    public static final EntityDescriptor<Initializer> Initializer = (EntityDescriptor<Initializer>) instance.valueOf(Initializer_ord);
    public static final EntityDescriptor<FieldDeclaration> FieldDeclaration = (EntityDescriptor<FieldDeclaration>) instance.valueOf(FieldDeclaration_ord);
    public static final EntityDescriptor<MethodDeclaration> MethodDeclaration = (EntityDescriptor<MethodDeclaration>) instance.valueOf(MethodDeclaration_ord);
    public static final EntityDescriptor<ConstructorDeclaration> ConstructorDeclaration = (EntityDescriptor<ConstructorDeclaration>) instance.valueOf(ConstructorDeclaration_ord);
    public static final EntityDescriptor<Parameters> Parameters = (EntityDescriptor<Parameters>) instance.valueOf(Parameters_ord);
    public static final EntityDescriptor<SingleVariableDeclaration> SingleVariableDeclaration = (EntityDescriptor<SingleVariableDeclaration>) instance.valueOf(SingleVariableDeclaration_ord);
    public static final EntityDescriptor<Varargs> Varargs = (EntityDescriptor<Varargs>) instance.valueOf(Varargs_ord);
    public static final EntityDescriptor<AnnotatedType> AnnotatedType = (EntityDescriptor<AnnotatedType>) instance.valueOf(AnnotatedType_ord);
    public static final EntityDescriptor<ArrayType> ArrayType = (EntityDescriptor<ArrayType>) instance.valueOf(ArrayType_ord);
    public static final EntityDescriptor<ParameterizedType> ParameterizedType = (EntityDescriptor<ParameterizedType>) instance.valueOf(ParameterizedType_ord);
    public static final EntityDescriptor<PrimitiveType> PrimitiveType = (EntityDescriptor<PrimitiveType>) instance.valueOf(PrimitiveType_ord);
    public static final EntityDescriptor<QualifiedType> QualifiedType = (EntityDescriptor<QualifiedType>) instance.valueOf(QualifiedType_ord);
    public static final EntityDescriptor<SimpleType> SimpleType = (EntityDescriptor<SimpleType>) instance.valueOf(SimpleType_ord);
    public static final EntityDescriptor<WildcardType> WildcardType = (EntityDescriptor<WildcardType>) instance.valueOf(WildcardType_ord);
    public static final EntityDescriptor<UnionType> UnionType = (EntityDescriptor<UnionType>) instance.valueOf(UnionType_ord);
    public static final EntityDescriptor<IntersectionType> IntersectionType = (EntityDescriptor<IntersectionType>) instance.valueOf(IntersectionType_ord);
    public static final EntityDescriptor<UpperBound> UpperBound = (EntityDescriptor<UpperBound>) instance.valueOf(UpperBound_ord);
    public static final EntityDescriptor<AssertStatement> AssertStatement = (EntityDescriptor<AssertStatement>) instance.valueOf(AssertStatement_ord);
    public static final EntityDescriptor<Block> Block = (EntityDescriptor<Block>) instance.valueOf(Block_ord);
    public static final EntityDescriptor<BreakStatement> BreakStatement = (EntityDescriptor<BreakStatement>) instance.valueOf(BreakStatement_ord);
    public static final EntityDescriptor<ConstructorInvocation> ConstructorInvocation = (EntityDescriptor<ConstructorInvocation>) instance.valueOf(ConstructorInvocation_ord);
    public static final EntityDescriptor<ContinueStatement> ContinueStatement = (EntityDescriptor<ContinueStatement>) instance.valueOf(ContinueStatement_ord);
    public static final EntityDescriptor<DoStatement> DoStatement = (EntityDescriptor<DoStatement>) instance.valueOf(DoStatement_ord);
    public static final EntityDescriptor<EmptyStatement> EmptyStatement = (EntityDescriptor<EmptyStatement>) instance.valueOf(EmptyStatement_ord);
    public static final EntityDescriptor<EnhancedForStatement> EnhancedForStatement = (EntityDescriptor<EnhancedForStatement>) instance.valueOf(EnhancedForStatement_ord);
    public static final EntityDescriptor<ExpressionStatement> ExpressionStatement = (EntityDescriptor<ExpressionStatement>) instance.valueOf(ExpressionStatement_ord);
    public static final EntityDescriptor<ForStatement> ForStatement = (EntityDescriptor<ForStatement>) instance.valueOf(ForStatement_ord);
    public static final EntityDescriptor<Expressions> Expressions = (EntityDescriptor<Expressions>) instance.valueOf(Expressions_ord);
    public static final EntityDescriptor<IfStatement> IfStatement = (EntityDescriptor<IfStatement>) instance.valueOf(IfStatement_ord);
    public static final EntityDescriptor<LabeledStatement> LabeledStatement = (EntityDescriptor<LabeledStatement>) instance.valueOf(LabeledStatement_ord);
    public static final EntityDescriptor<ReturnStatement> ReturnStatement = (EntityDescriptor<ReturnStatement>) instance.valueOf(ReturnStatement_ord);
    public static final EntityDescriptor<SuperConstructorInvocation> SuperConstructorInvocation = (EntityDescriptor<SuperConstructorInvocation>) instance.valueOf(SuperConstructorInvocation_ord);
    public static final EntityDescriptor<SwitchCase> SwitchCase = (EntityDescriptor<SwitchCase>) instance.valueOf(SwitchCase_ord);
    public static final EntityDescriptor<SwitchDefault> SwitchDefault = (EntityDescriptor<SwitchDefault>) instance.valueOf(SwitchDefault_ord);
    public static final EntityDescriptor<SwitchStatement> SwitchStatement = (EntityDescriptor<SwitchStatement>) instance.valueOf(SwitchStatement_ord);
    public static final EntityDescriptor<Statements> Statements = (EntityDescriptor<Statements>) instance.valueOf(Statements_ord);
    public static final EntityDescriptor<SynchronizedStatement> SynchronizedStatement = (EntityDescriptor<SynchronizedStatement>) instance.valueOf(SynchronizedStatement_ord);
    public static final EntityDescriptor<ThrowStatement> ThrowStatement = (EntityDescriptor<ThrowStatement>) instance.valueOf(ThrowStatement_ord);
    public static final EntityDescriptor<TryStatement> TryStatement = (EntityDescriptor<TryStatement>) instance.valueOf(TryStatement_ord);
    public static final EntityDescriptor<CatchClauses> CatchClauses = (EntityDescriptor<CatchClauses>) instance.valueOf(CatchClauses_ord);
    public static final EntityDescriptor<CatchClause> CatchClause = (EntityDescriptor<CatchClause>) instance.valueOf(CatchClause_ord);
    public static final EntityDescriptor<TypeDeclarationStatement> TypeDeclarationStatement = (EntityDescriptor<TypeDeclarationStatement>) instance.valueOf(TypeDeclarationStatement_ord);
    public static final EntityDescriptor<VariableDeclarationStatement> VariableDeclarationStatement = (EntityDescriptor<VariableDeclarationStatement>) instance.valueOf(VariableDeclarationStatement_ord);
    public static final EntityDescriptor<WhileStatement> WhileStatement = (EntityDescriptor<WhileStatement>) instance.valueOf(WhileStatement_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<SimpleName> SimpleName = (EntityDescriptor<SimpleName>) instance.valueOf(SimpleName_ord);
    public static final EntityDescriptor<QualifiedName> QualifiedName = (EntityDescriptor<QualifiedName>) instance.valueOf(QualifiedName_ord);
    public static final EntityDescriptor<NullLiteral> NullLiteral = (EntityDescriptor<NullLiteral>) instance.valueOf(NullLiteral_ord);
    public static final EntityDescriptor<BooleanLiteral> BooleanLiteral = (EntityDescriptor<BooleanLiteral>) instance.valueOf(BooleanLiteral_ord);
    public static final EntityDescriptor<ByteLiteral> ByteLiteral = (EntityDescriptor<ByteLiteral>) instance.valueOf(ByteLiteral_ord);
    public static final EntityDescriptor<CharLiteral> CharLiteral = (EntityDescriptor<CharLiteral>) instance.valueOf(CharLiteral_ord);
    public static final EntityDescriptor<DoubleLiteral> DoubleLiteral = (EntityDescriptor<DoubleLiteral>) instance.valueOf(DoubleLiteral_ord);
    public static final EntityDescriptor<FloatLiteral> FloatLiteral = (EntityDescriptor<FloatLiteral>) instance.valueOf(FloatLiteral_ord);
    public static final EntityDescriptor<IntLiteral> IntLiteral = (EntityDescriptor<IntLiteral>) instance.valueOf(IntLiteral_ord);
    public static final EntityDescriptor<ShortLiteral> ShortLiteral = (EntityDescriptor<ShortLiteral>) instance.valueOf(ShortLiteral_ord);
    public static final EntityDescriptor<LongLiteral> LongLiteral = (EntityDescriptor<LongLiteral>) instance.valueOf(LongLiteral_ord);
    public static final EntityDescriptor<StringLiteral> StringLiteral = (EntityDescriptor<StringLiteral>) instance.valueOf(StringLiteral_ord);
    public static final EntityDescriptor<TypeLiteral> TypeLiteral = (EntityDescriptor<TypeLiteral>) instance.valueOf(TypeLiteral_ord);
    public static final EntityDescriptor<ArrayAccess> ArrayAccess = (EntityDescriptor<ArrayAccess>) instance.valueOf(ArrayAccess_ord);
    public static final EntityDescriptor<ArrayCreation> ArrayCreation = (EntityDescriptor<ArrayCreation>) instance.valueOf(ArrayCreation_ord);
    public static final EntityDescriptor<ArrayInitializer> ArrayInitializer = (EntityDescriptor<ArrayInitializer>) instance.valueOf(ArrayInitializer_ord);
    public static final EntityDescriptor<Assignment> Assignment = (EntityDescriptor<Assignment>) instance.valueOf(Assignment_ord);
    public static final EntityDescriptor<AssignmentOperator> AssignmentOperator = (EntityDescriptor<AssignmentOperator>) instance.valueOf(AssignmentOperator_ord);
    public static final EntityDescriptor<CastExpression> CastExpression = (EntityDescriptor<CastExpression>) instance.valueOf(CastExpression_ord);
    public static final EntityDescriptor<ClassInstanceCreation> ClassInstanceCreation = (EntityDescriptor<ClassInstanceCreation>) instance.valueOf(ClassInstanceCreation_ord);
    public static final EntityDescriptor<ConditionalExpression> ConditionalExpression = (EntityDescriptor<ConditionalExpression>) instance.valueOf(ConditionalExpression_ord);
    public static final EntityDescriptor<FieldAccess> FieldAccess = (EntityDescriptor<FieldAccess>) instance.valueOf(FieldAccess_ord);
    public static final EntityDescriptor<InfixExpression> InfixExpression = (EntityDescriptor<InfixExpression>) instance.valueOf(InfixExpression_ord);
    public static final EntityDescriptor<InfixOperator> InfixOperator = (EntityDescriptor<InfixOperator>) instance.valueOf(InfixOperator_ord);
    public static final EntityDescriptor<InstanceofExpression> InstanceofExpression = (EntityDescriptor<InstanceofExpression>) instance.valueOf(InstanceofExpression_ord);
    public static final EntityDescriptor<LambdaExpression> LambdaExpression = (EntityDescriptor<LambdaExpression>) instance.valueOf(LambdaExpression_ord);
    public static final EntityDescriptor<MethodInvocation> MethodInvocation = (EntityDescriptor<MethodInvocation>) instance.valueOf(MethodInvocation_ord);
    public static final EntityDescriptor<ParenthesizedExpression> ParenthesizedExpression = (EntityDescriptor<ParenthesizedExpression>) instance.valueOf(ParenthesizedExpression_ord);
    public static final EntityDescriptor<PostfixExpression> PostfixExpression = (EntityDescriptor<PostfixExpression>) instance.valueOf(PostfixExpression_ord);
    public static final EntityDescriptor<PostfixOperator> PostfixOperator = (EntityDescriptor<PostfixOperator>) instance.valueOf(PostfixOperator_ord);
    public static final EntityDescriptor<PrefixExpression> PrefixExpression = (EntityDescriptor<PrefixExpression>) instance.valueOf(PrefixExpression_ord);
    public static final EntityDescriptor<PrefixOperator> PrefixOperator = (EntityDescriptor<PrefixOperator>) instance.valueOf(PrefixOperator_ord);
    public static final EntityDescriptor<SuperFieldAccess> SuperFieldAccess = (EntityDescriptor<SuperFieldAccess>) instance.valueOf(SuperFieldAccess_ord);
    public static final EntityDescriptor<SuperMethodInvocation> SuperMethodInvocation = (EntityDescriptor<SuperMethodInvocation>) instance.valueOf(SuperMethodInvocation_ord);
    public static final EntityDescriptor<ThisExpression> ThisExpression = (EntityDescriptor<ThisExpression>) instance.valueOf(ThisExpression_ord);
    public static final EntityDescriptor<VariableDeclarationExpression> VariableDeclarationExpression = (EntityDescriptor<VariableDeclarationExpression>) instance.valueOf(VariableDeclarationExpression_ord);
    public static final EntityDescriptor<VariableDeclarationFragments> VariableDeclarationFragments = (EntityDescriptor<VariableDeclarationFragments>) instance.valueOf(VariableDeclarationFragments_ord);
    public static final EntityDescriptor<VariableDeclarationFragment> VariableDeclarationFragment = (EntityDescriptor<VariableDeclarationFragment>) instance.valueOf(VariableDeclarationFragment_ord);
    public static final EntityDescriptor<ExtraDimensions> ExtraDimensions = (EntityDescriptor<ExtraDimensions>) instance.valueOf(ExtraDimensions_ord);
    public static final EntityDescriptor<ExtendedModifiers> ExtendedModifiers = (EntityDescriptor<ExtendedModifiers>) instance.valueOf(ExtendedModifiers_ord);
    public static final EntityDescriptor<Modifier> Modifier = (EntityDescriptor<Modifier>) instance.valueOf(Modifier_ord);
    public static final EntityDescriptor<MethodReference> MethodReference = (EntityDescriptor<MethodReference>) instance.valueOf(MethodReference_ord);
    public static final EntityDescriptor<ConstructorReference> ConstructorReference = (EntityDescriptor<ConstructorReference>) instance.valueOf(ConstructorReference_ord);
    public static final EntityDescriptor<ExpressionMethodReference> ExpressionMethodReference = (EntityDescriptor<ExpressionMethodReference>) instance.valueOf(ExpressionMethodReference_ord);
    public static final EntityDescriptor<SuperMethodReference> SuperMethodReference = (EntityDescriptor<SuperMethodReference>) instance.valueOf(SuperMethodReference_ord);
    public static final EntityDescriptor<TypeMethodReference> TypeMethodReference = (EntityDescriptor<TypeMethodReference>) instance.valueOf(TypeMethodReference_ord);
    public static final EntityDescriptor<LambdaParameters> LambdaParameters = (EntityDescriptor<LambdaParameters>) instance.valueOf(LambdaParameters_ord);
    public static final EntityDescriptor<DocElement> DocElement = (EntityDescriptor<DocElement>) instance.valueOf(DocElement_ord);
    public static final EntityDescriptor<ExpressionOrStatement> ExpressionOrStatement = (EntityDescriptor<ExpressionOrStatement>) instance.valueOf(ExpressionOrStatement_ord);
    public static final EntityDescriptor<ExtendedModifier> ExtendedModifier = (EntityDescriptor<ExtendedModifier>) instance.valueOf(ExtendedModifier_ord);
    public static final EntityDescriptor<VariableDeclaration> VariableDeclaration = (EntityDescriptor<VariableDeclaration>) instance.valueOf(VariableDeclaration_ord);
    public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance.valueOf(Type_ord);

    private JavaEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putCompositeEntity(
		JavaSystemSoftware_ord, "JavaSystemSoftware", JavaSystemSoftware.class, false, CompilationUnit_ord, true, false);
        putSimpleEntity(CompilationUnit_ord, "CompilationUnit", CompilationUnit.class, false).withFeature(JavaFeatureDescriptorEnum._package, PackageDeclaration_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.imports, ImportDeclarations_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.types, TypeDeclarations_ord);
        putSimpleEntity(PackageDeclaration_ord, "PackageDeclaration", PackageDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.annotations, Annotations_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, Name_ord);
        putSimpleEntity(Statement_ord, "Statement", Statement.class, true, DoStatement_ord, EmptyStatement_ord, Javadoc_ord, LineComment_ord, WhileStatement_ord, SynchronizedStatement_ord, IfStatement_ord, SwitchStatement_ord, ConstructorInvocation_ord, TryStatement_ord, ReturnStatement_ord, VariableDeclarationStatement_ord, EnhancedForStatement_ord, ThrowStatement_ord, ForStatement_ord, ContinueStatement_ord, Comment_ord, BlockComment_ord, SwitchDefault_ord, BreakStatement_ord, SwitchCase_ord, LabeledStatement_ord, TypeDeclarationStatement_ord, ExpressionStatement_ord, AssertStatement_ord, Block_ord, SuperConstructorInvocation_ord);
        putSimpleEntity(Expression_ord, "Expression", Expression.class, true, ShortLiteral_ord, BooleanLiteral_ord, SimpleName_ord, MethodInvocation_ord, SuperMethodInvocation_ord, Name_ord, Assignment_ord, ThisExpression_ord, ArrayAccess_ord, TypeLiteral_ord, InstanceofExpression_ord, InfixExpression_ord, NormalAnnotation_ord, IntLiteral_ord, TypeMethodReference_ord, SuperMethodReference_ord, ClassInstanceCreation_ord, ParenthesizedExpression_ord, ExpressionMethodReference_ord, CharLiteral_ord, LongLiteral_ord, FloatLiteral_ord, SingleMemberAnnotation_ord, ConditionalExpression_ord, VariableDeclarationExpression_ord, QualifiedName_ord, SuperFieldAccess_ord, ConstructorReference_ord, Annotation_ord, MarkerAnnotation_ord, StringLiteral_ord, PrefixExpression_ord, ArrayCreation_ord, ByteLiteral_ord, PostfixExpression_ord, MethodReference_ord, DoubleLiteral_ord, CastExpression_ord, FieldAccess_ord, NullLiteral_ord, LambdaExpression_ord, ArrayInitializer_ord);
        putSimpleEntity(Comment_ord, "Comment", Comment.class, true, BlockComment_ord, Javadoc_ord, LineComment_ord);
        putSimpleEntity(BlockComment_ord, "BlockComment", BlockComment.class, false).withFeature(JavaFeatureDescriptorEnum.docElements, DocElements_ord);
        putSimpleEntity(LineComment_ord, "LineComment", LineComment.class, false).withFeature(JavaFeatureDescriptorEnum.text, TextElement_ord);
        putSimpleEntity(Javadoc_ord, "Javadoc", Javadoc.class, false).withFeature(JavaFeatureDescriptorEnum.tags, Tags_ord);
        putCompositeEntity(
		Tags_ord, "Tags", Tags.class, false, TagElement_ord, true, false);
        putCompositeEntity(
		DocElements_ord, "DocElements", DocElements.class, false, DocElement_ord, true, false);
        putSimpleEntity(MethodRef_ord, "MethodRef", MethodRef.class, false).withFeature(JavaFeatureDescriptorEnum.qualifier, Name_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.parameters, MethodRefParameters_ord, true, false, false, false, false);
        putCompositeEntity(
		MethodRefParameters_ord, "MethodRefParameters", MethodRefParameters.class, false, MethodRefParameter_ord, true, false);
        putSimpleEntity(MethodRefParameter_ord, "MethodRefParameter", MethodRefParameter.class, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.varargs, Varargs_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord, true, false, false, false, false);
        putSimpleEntity(MemberRef_ord, "MemberRef", MemberRef.class, false).withFeature(JavaFeatureDescriptorEnum.qualifier, Name_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord);
        putDataEntity(TextElement_ord, "TextElement", TextElement.class, false, String.class);
        putSimpleEntity(TagElement_ord, "TagElement", TagElement.class, false).withFeature(JavaFeatureDescriptorEnum.tagName, TagName_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.fragments, DocElements_ord);
        putDataEntity(TagName_ord, "TagName", TagName.class, false, String.class);
        putCompositeEntity(
		Annotations_ord, "Annotations", Annotations.class, false, Annotation_ord, true, false);
        putSimpleEntity(Annotation_ord, "Annotation", Annotation.class, true, NormalAnnotation_ord, SingleMemberAnnotation_ord, MarkerAnnotation_ord).withFeature(JavaFeatureDescriptorEnum.typeName, Name_ord);
        putSimpleEntity(SingleMemberAnnotation_ord, "SingleMemberAnnotation", SingleMemberAnnotation.class, false).withFeature(JavaFeatureDescriptorEnum.typeName, Name_ord).withFeature(JavaFeatureDescriptorEnum.value, Expression_ord);
        putSimpleEntity(MarkerAnnotation_ord, "MarkerAnnotation", MarkerAnnotation.class, false).withFeature(JavaFeatureDescriptorEnum.typeName, Name_ord);
        putSimpleEntity(NormalAnnotation_ord, "NormalAnnotation", NormalAnnotation.class, false).withFeature(JavaFeatureDescriptorEnum.typeName, Name_ord).withFeature(JavaFeatureDescriptorEnum.values, MemberValuePairs_ord);
        putCompositeEntity(
		MemberValuePairs_ord, "MemberValuePairs", MemberValuePairs.class, false, MemberValuePair_ord, true, false);
        putSimpleEntity(MemberValuePair_ord, "MemberValuePair", MemberValuePair.class, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.value, Expression_ord);
        putCompositeEntity(
		ImportDeclarations_ord, "ImportDeclarations", ImportDeclarations.class, false, ImportDeclaration_ord, true, false);
        putSimpleEntity(ImportDeclaration_ord, "ImportDeclaration", ImportDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.name, Name_ord).withFeature(JavaFeatureDescriptorEnum.onDemand, ImportModifier_ord).withFeature(JavaFeatureDescriptorEnum._static, ImportModifier_ord);
        putDataEntity(ImportModifier_ord, "ImportModifier", ImportModifier.class, false, boolean.class);
        putCompositeEntity(
		TypeDeclarations_ord, "TypeDeclarations", TypeDeclarations.class, false, TypeDeclaration_ord, true, false);
        putSimpleEntity(BodyDeclaration_ord, "BodyDeclaration", BodyDeclaration.class, true, Comment_ord, BlockComment_ord, MethodDeclaration_ord, Javadoc_ord, AnnotationTypeDeclaration_ord, InterfaceDeclaration_ord, LineComment_ord, FieldDeclaration_ord, EnumDeclaration_ord, EnumConstantDeclaration_ord, ClassDeclaration_ord, AnnotationTypeMemberDeclaration_ord, Initializer_ord, ConstructorDeclaration_ord, TypeDeclaration_ord, AnnotatedBodyDeclaration_ord);
        putSimpleEntity(AnnotatedBodyDeclaration_ord, "AnnotatedBodyDeclaration", AnnotatedBodyDeclaration.class, true, EnumConstantDeclaration_ord, ClassDeclaration_ord, AnnotationTypeMemberDeclaration_ord, Initializer_ord, MethodDeclaration_ord, ConstructorDeclaration_ord, AnnotationTypeDeclaration_ord, InterfaceDeclaration_ord, TypeDeclaration_ord, FieldDeclaration_ord, EnumDeclaration_ord).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false);
        putSimpleEntity(TypeDeclaration_ord, "TypeDeclaration", TypeDeclaration.class, true, AnnotationTypeDeclaration_ord, InterfaceDeclaration_ord, ClassDeclaration_ord, EnumDeclaration_ord).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.bodyDeclarations, BodyDeclarations_ord);
        putSimpleEntity(EnumDeclaration_ord, "EnumDeclaration", EnumDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.superInterfaceTypes, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.enumConstants, EnumConstants_ord).withFeature(JavaFeatureDescriptorEnum.bodyDeclarations, BodyDeclarations_ord);
        putCompositeEntity(
		EnumConstants_ord, "EnumConstants", EnumConstants.class, false, EnumConstantDeclaration_ord, true, false);
        putSimpleEntity(EnumConstantDeclaration_ord, "EnumConstantDeclaration", EnumConstantDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.arguments, Arguments_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.anonymousClassDeclaration, AnonymousClassDeclaration_ord, true, false, false, false, false);
        putCompositeEntity(
		Arguments_ord, "Arguments", Arguments.class, false, Expression_ord, true, false);
        putCompositeEntity(
		AnonymousClassDeclaration_ord, "AnonymousClassDeclaration", AnonymousClassDeclaration.class, false, BodyDeclaration_ord, true, false);
        putSimpleEntity(AnnotationTypeDeclaration_ord, "AnnotationTypeDeclaration", AnnotationTypeDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.bodyDeclarations, BodyDeclarations_ord);
        putSimpleEntity(ClassDeclaration_ord, "ClassDeclaration", ClassDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.typeParameters, TypeParameters_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.superclassType, Type_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.superInterfaceTypes, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.bodyDeclarations, BodyDeclarations_ord);
        putSimpleEntity(InterfaceDeclaration_ord, "InterfaceDeclaration", InterfaceDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.typeParameters, TypeParameters_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.superInterfaceTypes, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.bodyDeclarations, BodyDeclarations_ord);
        putCompositeEntity(
		TypeParameters_ord, "TypeParameters", TypeParameters.class, false, TypeParameter_ord, true, false);
        putSimpleEntity(TypeParameter_ord, "TypeParameter", TypeParameter.class, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.typeBounds, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.annotations, Annotations_ord, true, false, false, false, false);
        putCompositeEntity(
		Types_ord, "Types", Types.class, false, Type_ord, true, false);
        putCompositeEntity(
		BodyDeclarations_ord, "BodyDeclarations", BodyDeclarations.class, false, BodyDeclaration_ord, true, false);
        putSimpleEntity(AnnotationTypeMemberDeclaration_ord, "AnnotationTypeMemberDeclaration", AnnotationTypeMemberDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum._default, Expression_ord, true, false, false, false, false);
        putSimpleEntity(Initializer_ord, "Initializer", Initializer.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.body, Block_ord);
        putSimpleEntity(FieldDeclaration_ord, "FieldDeclaration", FieldDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.fragments, VariableDeclarationFragments_ord, true, false, false, false, false);
        putSimpleEntity(MethodDeclaration_ord, "MethodDeclaration", MethodDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.typeParameters, TypeParameters_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.returnType, Type_ord).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.parameters, Parameters_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.extraDimensions, ExtraDimensions_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.thrownExceptions, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.body, Block_ord, true, false, false, false, false);
        putSimpleEntity(ConstructorDeclaration_ord, "ConstructorDeclaration", ConstructorDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.javadoc, Javadoc_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.typeParameters, TypeParameters_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.parameters, Parameters_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.extraDimensions, ExtraDimensions_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.thrownExceptions, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.body, Block_ord);
        putCompositeEntity(
		Parameters_ord, "Parameters", Parameters.class, false, SingleVariableDeclaration_ord, true, false);
        putSimpleEntity(SingleVariableDeclaration_ord, "SingleVariableDeclaration", SingleVariableDeclaration.class, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.varargs, Varargs_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.extraDimensions, ExtraDimensions_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.initializer, Expression_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.varargsAnnotations, Annotations_ord, true, false, false, false, false);
        putDataEntity(Varargs_ord, "Varargs", Varargs.class, false, boolean.class);
        putSimpleEntity(AnnotatedType_ord, "AnnotatedType", AnnotatedType.class, false).withFeature(JavaFeatureDescriptorEnum.annotations, Annotations_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord);
        putSimpleEntity(ArrayType_ord, "ArrayType", ArrayType.class, false).withFeature(JavaFeatureDescriptorEnum.componentType, Type_ord);
        putSimpleEntity(ParameterizedType_ord, "ParameterizedType", ParameterizedType.class, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false);
        putDataEntity(PrimitiveType_ord, "PrimitiveType", PrimitiveType.class, false, PrimitiveTypeEnum.Value.class);
        putDataEntity(QualifiedType_ord, "QualifiedType", QualifiedType.class, false, String.class);
        putDataEntity(SimpleType_ord, "SimpleType", SimpleType.class, false, String.class);
        putSimpleEntity(WildcardType_ord, "WildcardType", WildcardType.class, false).withFeature(JavaFeatureDescriptorEnum.bound, Type_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.upperBound, UpperBound_ord);
        putCompositeEntity(
		UnionType_ord, "UnionType", UnionType.class, false, Type_ord, true, false);
        putCompositeEntity(
		IntersectionType_ord, "IntersectionType", IntersectionType.class, false, Type_ord, true, false);
        putDataEntity(UpperBound_ord, "UpperBound", UpperBound.class, false, boolean.class);
        putSimpleEntity(AssertStatement_ord, "AssertStatement", AssertStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.message, Expression_ord, true, false, false, false, false);
        putCompositeEntity(
		Block_ord, "Block", Block.class, false, Statement_ord, true, false);
        putSimpleEntity(BreakStatement_ord, "BreakStatement", BreakStatement.class, false).withFeature(JavaFeatureDescriptorEnum.label, SimpleName_ord, true, false, false, false, false);
        putSimpleEntity(ConstructorInvocation_ord, "ConstructorInvocation", ConstructorInvocation.class, false).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.arguments, Arguments_ord, true, false, false, false, false);
        putSimpleEntity(ContinueStatement_ord, "ContinueStatement", ContinueStatement.class, false).withFeature(JavaFeatureDescriptorEnum.label, SimpleName_ord, true, false, false, false, false);
        putSimpleEntity(DoStatement_ord, "DoStatement", DoStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.body, Statement_ord);
        putSimpleEntity(EmptyStatement_ord, "EmptyStatement", EmptyStatement.class, false);
        putSimpleEntity(EnhancedForStatement_ord, "EnhancedForStatement", EnhancedForStatement.class, false).withFeature(JavaFeatureDescriptorEnum.parameter, SingleVariableDeclaration_ord).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.body, Statement_ord);
        putSimpleEntity(ExpressionStatement_ord, "ExpressionStatement", ExpressionStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(ForStatement_ord, "ForStatement", ForStatement.class, false).withFeature(JavaFeatureDescriptorEnum.initializers, Expressions_ord).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.updaters, Expressions_ord).withFeature(JavaFeatureDescriptorEnum.body, Statement_ord);
        putCompositeEntity(
		Expressions_ord, "Expressions", Expressions.class, false, Expression_ord, true, false);
        putSimpleEntity(IfStatement_ord, "IfStatement", IfStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.thenStatement, Statement_ord).withFeature(JavaFeatureDescriptorEnum.elseStatement, Statement_ord, true, false, false, false, false);
        putSimpleEntity(LabeledStatement_ord, "LabeledStatement", LabeledStatement.class, false).withFeature(JavaFeatureDescriptorEnum.label, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.body, Statement_ord);
        putSimpleEntity(ReturnStatement_ord, "ReturnStatement", ReturnStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord, true, false, false, false, false);
        putSimpleEntity(SuperConstructorInvocation_ord, "SuperConstructorInvocation", SuperConstructorInvocation.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.arguments, Arguments_ord, true, false, false, false, false);
        putSimpleEntity(SwitchCase_ord, "SwitchCase", SwitchCase.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(SwitchDefault_ord, "SwitchDefault", SwitchDefault.class, false);
        putSimpleEntity(SwitchStatement_ord, "SwitchStatement", SwitchStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.statements, Statements_ord);
        putCompositeEntity(
		Statements_ord, "Statements", Statements.class, false, Statement_ord, true, false);
        putSimpleEntity(SynchronizedStatement_ord, "SynchronizedStatement", SynchronizedStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.body, Block_ord);
        putSimpleEntity(ThrowStatement_ord, "ThrowStatement", ThrowStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(TryStatement_ord, "TryStatement", TryStatement.class, false).withFeature(JavaFeatureDescriptorEnum.body, Block_ord).withFeature(JavaFeatureDescriptorEnum.catchClauses, CatchClauses_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum._finally, Block_ord);
        putCompositeEntity(
		CatchClauses_ord, "CatchClauses", CatchClauses.class, false, CatchClause_ord, true, false);
        putSimpleEntity(CatchClause_ord, "CatchClause", CatchClause.class, false).withFeature(JavaFeatureDescriptorEnum.exception, SingleVariableDeclaration_ord).withFeature(JavaFeatureDescriptorEnum.body, Block_ord);
        putSimpleEntity(TypeDeclarationStatement_ord, "TypeDeclarationStatement", TypeDeclarationStatement.class, false).withFeature(JavaFeatureDescriptorEnum.typeDeclaration, TypeDeclaration_ord);
        putSimpleEntity(VariableDeclarationStatement_ord, "VariableDeclarationStatement", VariableDeclarationStatement.class, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.fragments, VariableDeclarationFragments_ord, true, false, false, false, false);
        putSimpleEntity(WhileStatement_ord, "WhileStatement", WhileStatement.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.body, Statement_ord);
        putSimpleEntity(Name_ord, "Name", Name.class, true, SimpleName_ord, QualifiedName_ord);
        putDataEntity(SimpleName_ord, "SimpleName", SimpleName.class, false, String.class);
        putDataEntity(QualifiedName_ord, "QualifiedName", QualifiedName.class, false, String.class);
        putSimpleEntity(NullLiteral_ord, "NullLiteral", NullLiteral.class, false);
        putDataEntity(BooleanLiteral_ord, "BooleanLiteral", BooleanLiteral.class, false, boolean.class);
        putDataEntity(ByteLiteral_ord, "ByteLiteral", ByteLiteral.class, false, byte.class);
        putDataEntity(CharLiteral_ord, "CharLiteral", CharLiteral.class, false, char.class);
        putDataEntity(DoubleLiteral_ord, "DoubleLiteral", DoubleLiteral.class, false, double.class);
        putDataEntity(FloatLiteral_ord, "FloatLiteral", FloatLiteral.class, false, float.class);
        putDataEntity(IntLiteral_ord, "IntLiteral", IntLiteral.class, false, int.class);
        putDataEntity(ShortLiteral_ord, "ShortLiteral", ShortLiteral.class, false, short.class);
        putDataEntity(LongLiteral_ord, "LongLiteral", LongLiteral.class, false, long.class);
        putDataEntity(StringLiteral_ord, "StringLiteral", StringLiteral.class, false, String.class);
        putSimpleEntity(TypeLiteral_ord, "TypeLiteral", TypeLiteral.class, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord);
        putSimpleEntity(ArrayAccess_ord, "ArrayAccess", ArrayAccess.class, false).withFeature(JavaFeatureDescriptorEnum.array, Expression_ord).withFeature(JavaFeatureDescriptorEnum.index, Expression_ord);
        putSimpleEntity(ArrayCreation_ord, "ArrayCreation", ArrayCreation.class, false).withFeature(JavaFeatureDescriptorEnum.type, ArrayType_ord).withFeature(JavaFeatureDescriptorEnum.dimensions, Expressions_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.initializer, ArrayInitializer_ord, true, false, false, false, false);
        putCompositeEntity(
		ArrayInitializer_ord, "ArrayInitializer", ArrayInitializer.class, false, Expression_ord, true, false);
        putSimpleEntity(Assignment_ord, "Assignment", Assignment.class, false).withFeature(JavaFeatureDescriptorEnum.leftHandSide, Expression_ord).withFeature(JavaFeatureDescriptorEnum.operator, AssignmentOperator_ord).withFeature(JavaFeatureDescriptorEnum.rightHandSide, Expression_ord);
        putDataEntity(AssignmentOperator_ord, "AssignmentOperator", AssignmentOperator.class, false, AssignmentOperatorEnum.Value.class);
        putSimpleEntity(CastExpression_ord, "CastExpression", CastExpression.class, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(ClassInstanceCreation_ord, "ClassInstanceCreation", ClassInstanceCreation.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.arguments, Arguments_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.anonymousClassDeclaration, AnonymousClassDeclaration_ord, true, false, false, false, false);
        putSimpleEntity(ConditionalExpression_ord, "ConditionalExpression", ConditionalExpression.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.thenExpression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.elseExpression, Expression_ord);
        putSimpleEntity(FieldAccess_ord, "FieldAccess", FieldAccess.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord);
        putSimpleEntity(InfixExpression_ord, "InfixExpression", InfixExpression.class, false).withFeature(JavaFeatureDescriptorEnum.leftOperand, Expression_ord).withFeature(JavaFeatureDescriptorEnum.operator, InfixOperator_ord).withFeature(JavaFeatureDescriptorEnum.rightOperand, Expression_ord).withFeature(JavaFeatureDescriptorEnum.extendedOperands, Expressions_ord, true, false, false, false, false);
        putDataEntity(InfixOperator_ord, "InfixOperator", InfixOperator.class, false, InfixOperatorEnum.Value.class);
        putSimpleEntity(InstanceofExpression_ord, "InstanceofExpression", InstanceofExpression.class, false).withFeature(JavaFeatureDescriptorEnum.leftOperand, Expression_ord).withFeature(JavaFeatureDescriptorEnum.rightOperand, Type_ord);
        putSimpleEntity(LambdaExpression_ord, "LambdaExpression", LambdaExpression.class, false).withFeature(JavaFeatureDescriptorEnum.parameters, LambdaParameters_ord).withFeature(JavaFeatureDescriptorEnum.body, ExpressionOrStatement_ord);
        putSimpleEntity(MethodInvocation_ord, "MethodInvocation", MethodInvocation.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.arguments, Arguments_ord, true, false, false, false, false);
        putSimpleEntity(ParenthesizedExpression_ord, "ParenthesizedExpression", ParenthesizedExpression.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(PostfixExpression_ord, "PostfixExpression", PostfixExpression.class, false).withFeature(JavaFeatureDescriptorEnum.operand, Expression_ord).withFeature(JavaFeatureDescriptorEnum.operator, PostfixOperator_ord);
        putDataEntity(PostfixOperator_ord, "PostfixOperator", PostfixOperator.class, false, PostfixOperatorEnum.Value.class);
        putSimpleEntity(PrefixExpression_ord, "PrefixExpression", PrefixExpression.class, false).withFeature(JavaFeatureDescriptorEnum.operator, PrefixOperator_ord).withFeature(JavaFeatureDescriptorEnum.operand, Expression_ord);
        putDataEntity(PrefixOperator_ord, "PrefixOperator", PrefixOperator.class, false, PrefixOperatorEnum.Value.class);
        putSimpleEntity(SuperFieldAccess_ord, "SuperFieldAccess", SuperFieldAccess.class, false).withFeature(JavaFeatureDescriptorEnum.qualifier, Name_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord);
        putSimpleEntity(SuperMethodInvocation_ord, "SuperMethodInvocation", SuperMethodInvocation.class, false).withFeature(JavaFeatureDescriptorEnum.qualifier, Name_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.arguments, Arguments_ord, true, false, false, false, false);
        putSimpleEntity(ThisExpression_ord, "ThisExpression", ThisExpression.class, false).withFeature(JavaFeatureDescriptorEnum.qualifier, Name_ord, true, false, false, false, false);
        putSimpleEntity(VariableDeclarationExpression_ord, "VariableDeclarationExpression", VariableDeclarationExpression.class, false).withFeature(JavaFeatureDescriptorEnum.modifiers, ExtendedModifiers_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.fragments, VariableDeclarationFragments_ord);
        putCompositeEntity(
		VariableDeclarationFragments_ord, "VariableDeclarationFragments", VariableDeclarationFragments.class, false, VariableDeclarationFragment_ord, true, false);
        putSimpleEntity(VariableDeclarationFragment_ord, "VariableDeclarationFragment", VariableDeclarationFragment.class, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord).withFeature(JavaFeatureDescriptorEnum.extraDimensions, ExtraDimensions_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.initializer, Expression_ord, true, false, false, false, false);
        putDataEntity(ExtraDimensions_ord, "ExtraDimensions", ExtraDimensions.class, false, int.class);
        putCompositeEntity(
		ExtendedModifiers_ord, "ExtendedModifiers", ExtendedModifiers.class, false, ExtendedModifier_ord, true, false);
        putDataEntity(Modifier_ord, "Modifier", Modifier.class, false, ModifierEnum.Value.class);
        putSimpleEntity(MethodReference_ord, "MethodReference", MethodReference.class, true, ExpressionMethodReference_ord, TypeMethodReference_ord, ConstructorReference_ord, SuperMethodReference_ord).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false);
        putSimpleEntity(ConstructorReference_ord, "ConstructorReference", ConstructorReference.class, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false);
        putSimpleEntity(ExpressionMethodReference_ord, "ExpressionMethodReference", ExpressionMethodReference.class, false).withFeature(JavaFeatureDescriptorEnum.expression, Expression_ord).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord);
        putSimpleEntity(SuperMethodReference_ord, "SuperMethodReference", SuperMethodReference.class, false).withFeature(JavaFeatureDescriptorEnum.qualifier, Name_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord);
        putSimpleEntity(TypeMethodReference_ord, "TypeMethodReference", TypeMethodReference.class, false).withFeature(JavaFeatureDescriptorEnum.type, Type_ord).withFeature(JavaFeatureDescriptorEnum.typeArguments, Types_ord, true, false, false, false, false).withFeature(JavaFeatureDescriptorEnum.name, SimpleName_ord);
        putSimpleEntity(LambdaParameters_ord, "LambdaParameters", LambdaParameters.class, true, VariableDeclarationFragment_ord, Parameters_ord, VariableDeclarationFragments_ord);
        putSimpleEntity(DocElement_ord, "DocElement", DocElement.class, true, MethodRef_ord, TextElement_ord, SimpleName_ord, QualifiedName_ord, TagElement_ord, MemberRef_ord, Name_ord);
        putSimpleEntity(ExpressionOrStatement_ord, "ExpressionOrStatement", ExpressionOrStatement.class, true, SimpleName_ord, EmptyStatement_ord, Javadoc_ord, MethodInvocation_ord, LineComment_ord, SuperMethodInvocation_ord, SynchronizedStatement_ord, Name_ord, Assignment_ord, ThisExpression_ord, IfStatement_ord, ArrayAccess_ord, SwitchStatement_ord, ConstructorInvocation_ord, TryStatement_ord, InfixExpression_ord, ReturnStatement_ord, VariableDeclarationStatement_ord, NormalAnnotation_ord, IntLiteral_ord, EnhancedForStatement_ord, BlockComment_ord, CharLiteral_ord, LongLiteral_ord, FloatLiteral_ord, SingleMemberAnnotation_ord, ConditionalExpression_ord, QualifiedName_ord, SuperFieldAccess_ord, ConstructorReference_ord, SwitchDefault_ord, SwitchCase_ord, LabeledStatement_ord, MarkerAnnotation_ord, StringLiteral_ord, TypeDeclarationStatement_ord, PrefixExpression_ord, AssertStatement_ord, Block_ord, PostfixExpression_ord, DoubleLiteral_ord, CastExpression_ord, NullLiteral_ord, LambdaExpression_ord, ShortLiteral_ord, DoStatement_ord, BooleanLiteral_ord, WhileStatement_ord, TypeLiteral_ord, InstanceofExpression_ord, TypeMethodReference_ord, ThrowStatement_ord, SuperMethodReference_ord, ForStatement_ord, ContinueStatement_ord, ClassInstanceCreation_ord, ParenthesizedExpression_ord, Comment_ord, ExpressionMethodReference_ord, Statement_ord, VariableDeclarationExpression_ord, Annotation_ord, BreakStatement_ord, Expression_ord, ExpressionStatement_ord, ArrayCreation_ord, ByteLiteral_ord, MethodReference_ord, SuperConstructorInvocation_ord, FieldAccess_ord, ArrayInitializer_ord);
        putSimpleEntity(ExtendedModifier_ord, "ExtendedModifier", ExtendedModifier.class, true, NormalAnnotation_ord, MarkerAnnotation_ord, Modifier_ord, SingleMemberAnnotation_ord, Annotation_ord);
        putSimpleEntity(VariableDeclaration_ord, "VariableDeclaration", VariableDeclaration.class, true, SingleVariableDeclaration_ord, VariableDeclarationFragment_ord);
        putSimpleEntity(Type_ord, "Type", Type.class, true, ArrayType_ord, ParameterizedType_ord, SimpleType_ord, UnionType_ord, AnnotatedType_ord, WildcardType_ord, IntersectionType_ord, QualifiedType_ord, PrimitiveType_ord);
    }
}
