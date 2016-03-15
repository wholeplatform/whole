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
package org.whole.lang.java.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class JavaImplEntityRegistry extends AbstractEntityRegistry {

    public JavaImplEntityRegistry() {
        super(JavaEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new JavaSystemSoftwareImpl());
        put(new CompilationUnitImpl());
        put(new PackageDeclarationImpl());
        put(new BlockCommentImpl());
        put(new LineCommentImpl());
        put(new JavadocImpl());
        put(new TagsImpl());
        put(new DocElementsImpl());
        put(new MethodRefImpl());
        put(new MethodRefParametersImpl());
        put(new MethodRefParameterImpl());
        put(new MemberRefImpl());
        put(new TextElementImpl());
        put(new TagElementImpl());
        put(new TagNameImpl());
        put(new AnnotationsImpl());
        put(new SingleMemberAnnotationImpl());
        put(new MarkerAnnotationImpl());
        put(new NormalAnnotationImpl());
        put(new MemberValuePairsImpl());
        put(new MemberValuePairImpl());
        put(new ImportDeclarationsImpl());
        put(new ImportDeclarationImpl());
        put(new ImportModifierImpl());
        put(new TypeDeclarationsImpl());
        put(new EnumDeclarationImpl());
        put(new EnumConstantsImpl());
        put(new EnumConstantDeclarationImpl());
        put(new ArgumentsImpl());
        put(new AnonymousClassDeclarationImpl());
        put(new AnnotationTypeDeclarationImpl());
        put(new ClassDeclarationImpl());
        put(new InterfaceDeclarationImpl());
        put(new TypeParametersImpl());
        put(new TypeParameterImpl());
        put(new TypesImpl());
        put(new BodyDeclarationsImpl());
        put(new AnnotationTypeMemberDeclarationImpl());
        put(new InitializerImpl());
        put(new FieldDeclarationImpl());
        put(new MethodDeclarationImpl());
        put(new ConstructorDeclarationImpl());
        put(new ParametersImpl());
        put(new SingleVariableDeclarationImpl());
        put(new VarargsImpl());
        put(new AnnotatedTypeImpl());
        put(new ArrayTypeImpl());
        put(new ParameterizedTypeImpl());
        put(new PrimitiveTypeImpl());
        put(new QualifiedTypeImpl());
        put(new SimpleTypeImpl());
        put(new WildcardTypeImpl());
        put(new UnionTypeImpl());
        put(new IntersectionTypeImpl());
        put(new UpperBoundImpl());
        put(new AssertStatementImpl());
        put(new BlockImpl());
        put(new BreakStatementImpl());
        put(new ConstructorInvocationImpl());
        put(new ContinueStatementImpl());
        put(new DoStatementImpl());
        put(new EmptyStatementImpl());
        put(new EnhancedForStatementImpl());
        put(new ExpressionStatementImpl());
        put(new ForStatementImpl());
        put(new ExpressionsImpl());
        put(new IfStatementImpl());
        put(new LabeledStatementImpl());
        put(new ReturnStatementImpl());
        put(new SuperConstructorInvocationImpl());
        put(new SwitchCaseImpl());
        put(new SwitchDefaultImpl());
        put(new SwitchStatementImpl());
        put(new StatementsImpl());
        put(new SynchronizedStatementImpl());
        put(new ThrowStatementImpl());
        put(new TryStatementImpl());
        put(new CatchClausesImpl());
        put(new CatchClauseImpl());
        put(new TypeDeclarationStatementImpl());
        put(new VariableDeclarationStatementImpl());
        put(new WhileStatementImpl());
        put(new SimpleNameImpl());
        put(new QualifiedNameImpl());
        put(new NullLiteralImpl());
        put(new BooleanLiteralImpl());
        put(new ByteLiteralImpl());
        put(new CharLiteralImpl());
        put(new DoubleLiteralImpl());
        put(new FloatLiteralImpl());
        put(new IntLiteralImpl());
        put(new ShortLiteralImpl());
        put(new LongLiteralImpl());
        put(new StringLiteralImpl());
        put(new TypeLiteralImpl());
        put(new ArrayAccessImpl());
        put(new ArrayCreationImpl());
        put(new ArrayInitializerImpl());
        put(new AssignmentImpl());
        put(new AssignmentOperatorImpl());
        put(new CastExpressionImpl());
        put(new ClassInstanceCreationImpl());
        put(new ConditionalExpressionImpl());
        put(new FieldAccessImpl());
        put(new InfixExpressionImpl());
        put(new InfixOperatorImpl());
        put(new InstanceofExpressionImpl());
        put(new LambdaExpressionImpl());
        put(new MethodInvocationImpl());
        put(new ParenthesizedExpressionImpl());
        put(new PostfixExpressionImpl());
        put(new PostfixOperatorImpl());
        put(new PrefixExpressionImpl());
        put(new PrefixOperatorImpl());
        put(new SuperFieldAccessImpl());
        put(new SuperMethodInvocationImpl());
        put(new ThisExpressionImpl());
        put(new VariableDeclarationExpressionImpl());
        put(new VariableDeclarationFragmentsImpl());
        put(new VariableDeclarationFragmentImpl());
        put(new ExtraDimensionsImpl());
        put(new ExtendedModifiersImpl());
        put(new ModifierImpl());
        put(new ConstructorReferenceImpl());
        put(new ExpressionMethodReferenceImpl());
        put(new SuperMethodReferenceImpl());
        put(new TypeMethodReferenceImpl());
    }
}
