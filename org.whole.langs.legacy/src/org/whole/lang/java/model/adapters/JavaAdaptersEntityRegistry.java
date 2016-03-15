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
package org.whole.lang.java.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class JavaAdaptersEntityRegistry extends AbstractEntityRegistry {

    public JavaAdaptersEntityRegistry() {
        super(JavaEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new JavaSystemSoftwareAdapter());
        put(new CompilationUnitAdapter());
        put(new PackageDeclarationAdapter());
        put(new StatementAdapter());
        put(new ExpressionAdapter());
        put(new CommentAdapter());
        put(new BlockCommentAdapter());
        put(new LineCommentAdapter());
        put(new JavadocAdapter());
        put(new TagsAdapter());
        put(new DocElementsAdapter());
        put(new MethodRefAdapter());
        put(new MethodRefParametersAdapter());
        put(new MethodRefParameterAdapter());
        put(new MemberRefAdapter());
        put(new TextElementAdapter());
        put(new TagElementAdapter());
        put(new TagNameAdapter());
        put(new AnnotationsAdapter());
        put(new AnnotationAdapter());
        put(new SingleMemberAnnotationAdapter());
        put(new MarkerAnnotationAdapter());
        put(new NormalAnnotationAdapter());
        put(new MemberValuePairsAdapter());
        put(new MemberValuePairAdapter());
        put(new ImportDeclarationsAdapter());
        put(new ImportDeclarationAdapter());
        put(new ImportModifierAdapter());
        put(new TypeDeclarationsAdapter());
        put(new BodyDeclarationAdapter());
        put(new AnnotatedBodyDeclarationAdapter());
        put(new TypeDeclarationAdapter());
        put(new EnumDeclarationAdapter());
        put(new EnumConstantsAdapter());
        put(new EnumConstantDeclarationAdapter());
        put(new ArgumentsAdapter());
        put(new AnonymousClassDeclarationAdapter());
        put(new AnnotationTypeDeclarationAdapter());
        put(new ClassDeclarationAdapter());
        put(new InterfaceDeclarationAdapter());
        put(new TypeParametersAdapter());
        put(new TypeParameterAdapter());
        put(new TypesAdapter());
        put(new BodyDeclarationsAdapter());
        put(new AnnotationTypeMemberDeclarationAdapter());
        put(new InitializerAdapter());
        put(new FieldDeclarationAdapter());
        put(new MethodDeclarationAdapter());
        put(new ConstructorDeclarationAdapter());
        put(new ParametersAdapter());
        put(new SingleVariableDeclarationAdapter());
        put(new VarargsAdapter());
        put(new AnnotatedTypeAdapter());
        put(new ArrayTypeAdapter());
        put(new ParameterizedTypeAdapter());
        put(new PrimitiveTypeAdapter());
        put(new QualifiedTypeAdapter());
        put(new SimpleTypeAdapter());
        put(new WildcardTypeAdapter());
        put(new UnionTypeAdapter());
        put(new IntersectionTypeAdapter());
        put(new UpperBoundAdapter());
        put(new AssertStatementAdapter());
        put(new BlockAdapter());
        put(new BreakStatementAdapter());
        put(new ConstructorInvocationAdapter());
        put(new ContinueStatementAdapter());
        put(new DoStatementAdapter());
        put(new EmptyStatementAdapter());
        put(new EnhancedForStatementAdapter());
        put(new ExpressionStatementAdapter());
        put(new ForStatementAdapter());
        put(new ExpressionsAdapter());
        put(new IfStatementAdapter());
        put(new LabeledStatementAdapter());
        put(new ReturnStatementAdapter());
        put(new SuperConstructorInvocationAdapter());
        put(new SwitchCaseAdapter());
        put(new SwitchDefaultAdapter());
        put(new SwitchStatementAdapter());
        put(new StatementsAdapter());
        put(new SynchronizedStatementAdapter());
        put(new ThrowStatementAdapter());
        put(new TryStatementAdapter());
        put(new CatchClausesAdapter());
        put(new CatchClauseAdapter());
        put(new TypeDeclarationStatementAdapter());
        put(new VariableDeclarationStatementAdapter());
        put(new WhileStatementAdapter());
        put(new NameAdapter());
        put(new SimpleNameAdapter());
        put(new QualifiedNameAdapter());
        put(new NullLiteralAdapter());
        put(new BooleanLiteralAdapter());
        put(new ByteLiteralAdapter());
        put(new CharLiteralAdapter());
        put(new DoubleLiteralAdapter());
        put(new FloatLiteralAdapter());
        put(new IntLiteralAdapter());
        put(new ShortLiteralAdapter());
        put(new LongLiteralAdapter());
        put(new StringLiteralAdapter());
        put(new TypeLiteralAdapter());
        put(new ArrayAccessAdapter());
        put(new ArrayCreationAdapter());
        put(new ArrayInitializerAdapter());
        put(new AssignmentAdapter());
        put(new AssignmentOperatorAdapter());
        put(new CastExpressionAdapter());
        put(new ClassInstanceCreationAdapter());
        put(new ConditionalExpressionAdapter());
        put(new FieldAccessAdapter());
        put(new InfixExpressionAdapter());
        put(new InfixOperatorAdapter());
        put(new InstanceofExpressionAdapter());
        put(new LambdaExpressionAdapter());
        put(new MethodInvocationAdapter());
        put(new ParenthesizedExpressionAdapter());
        put(new PostfixExpressionAdapter());
        put(new PostfixOperatorAdapter());
        put(new PrefixExpressionAdapter());
        put(new PrefixOperatorAdapter());
        put(new SuperFieldAccessAdapter());
        put(new SuperMethodInvocationAdapter());
        put(new ThisExpressionAdapter());
        put(new VariableDeclarationExpressionAdapter());
        put(new VariableDeclarationFragmentsAdapter());
        put(new VariableDeclarationFragmentAdapter());
        put(new ExtraDimensionsAdapter());
        put(new ExtendedModifiersAdapter());
        put(new ModifierAdapter());
        put(new MethodReferenceAdapter());
        put(new ConstructorReferenceAdapter());
        put(new ExpressionMethodReferenceAdapter());
        put(new SuperMethodReferenceAdapter());
        put(new TypeMethodReferenceAdapter());
        put(new LambdaParametersAdapter());
        put(new DocElementAdapter());
        put(new ExpressionOrStatementAdapter());
        put(new ExtendedModifierAdapter());
        put(new VariableDeclarationAdapter());
        put(new TypeAdapter());
    }
}
