/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.java.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.JavaIdentityDefaultVisitor;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.editparts.AbstractTextualEntityPart;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.CompositeRowPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.KeywordDataEntityPart;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.QuotedStringFigure;
import org.whole.lang.ui.figures.StringSeparatedCompositeRowFigure;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class JavaTextualPartFactoryVisitor extends JavaIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IJavaEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IJavaEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(JavaSystemSoftware entity) {
		part = new CompositeColumnPart();
	}

	@Override
	public void visit(LambdaExpression entity) {
		part = new LambdaExpressionPart();
	}

	@Override
	public void visit(ConstructorReference entity) {
		part = new ConstructorReferencePart();
	}

	@Override
	public void visit(ExpressionMethodReference entity) {
		part = new ExpressionMethodReferencePart();
	}

	@Override
	public void visit(SuperMethodReference entity) {
		part = new SuperMethodReferencePart();
	}

	@Override
	public void visit(TypeMethodReference entity) {
		part = new TypeMethodReferencePart();
	}

	public void visit(InstanceofExpression entity) {
		part = new InstanceofExpressionPart();
	}

	public void visit(IfStatement entity) {
		part = new IfStatementPart();
	}

	@Override
	public void visit(SimpleName entity) {
		part = new ContentTextualEntityPart();
	}
	@Override
	public void visit(QualifiedName entity) {
		part = new ContentTextualEntityPart();
	}

	@Override
	public void visit(SimpleType entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(QualifiedType entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(ArrayType entity) {
		part = new ArrayTypePart();
	}

	public void visit(SingleVariableDeclaration entity) {
		part = new SingleVariableDeclarationPart();
	}

	public void visit(SwitchCase entity) {
		part = new SwitchCasePart();
	}
	public void visit(SwitchDefault entity) {
		part = new SwitchDefaultPart();
	}

	public void visit(TypeParameter entity) {
		part = new TypeParameterPart();
	}

	public void visit(ContinueStatement entity) {
		part = new ContinueStatementPart();
	}

	public void visit(FieldDeclaration entity) {
		part = new FieldDeclarationPart();
	}

	public void visit(NormalAnnotation entity) {
		part = new NormalAnnotationPart();
	}

	public void visit(AnnotationTypeMemberDeclaration entity) {
		part = new AnnotationTypeMemberDeclarationPart();
	}

	public void visit(SynchronizedStatement entity) {
		part = new SynchronizedStatementPart();
	}

	public void visit(PrefixExpression entity) {
		part = new PrefixExpressionPart();
	}

	public void visit(ParameterizedType entity) {
		part = new ParameterizedTypePart();
	}

	@Override
	public void visit(AnnotatedType entity) {
		part = new AnnotatedTypePart();
	}
	public void visit(SuperConstructorInvocation entity) {
		part = new SuperConstructorInvocationPart();
	}

	public void visit(ExpressionStatement entity) {
		part = new ExpressionStatementPart();
	}

	public void visit(NullLiteral entity) {
		part = new NullLiteralPart();
	}

	public void visit(StringLiteral entity) {
		part = new AbstractTextualEntityPart() {
			public IFigure createFigure() {
				return new QuotedStringFigure(LabelFactory.createIdentifier());
			}
		};
	}
	@Override
	public void visit(CharLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(BooleanLiteral entity) {
		part = new KeywordDataEntityPart();
	}
	@Override
	public void visit(ByteLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(DoubleLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(FloatLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(IntLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(LongLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(ShortLiteral entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(MethodDeclaration entity) {
		part = new MethodDeclarationPart();
	}

	public void visit(ConstructorDeclaration entity) {
		part = new ConstructorDeclarationPart();
	}

	public void visit(ThrowStatement entity) {
		part = new ThrowStatementPart();
	}

	public void visit(ClassDeclaration entity) {
		part = new ClassDeclarationPart();
	}
	public void visit(InterfaceDeclaration entity) {
		part = new InterfaceDeclarationPart();
	}

	public void visit(PrimitiveType entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(TypeLiteral entity) {
		part = new TypeLiteralPart();
	}

	public void visit(MethodInvocation entity) {
		part = new MethodInvocationPart();
	}

	public void visit(FieldAccess entity) {
		part = new FieldAccessPart();
	}

	public void visit(ArrayInitializer entity) {
		part = new ArrayInitializerPart();
	}

	public void visit(WhileStatement entity) {
		part = new WhileStatementPart();
	}

	public void visit(LabeledStatement entity) {
		part = new LabeledStatementPart();
	}

	public void visit(TryStatement entity) {
		part = new TryStatementPart();
	}

	@Override
	public void visit(UnionType entity) {
		part = new AbstractCompositePart() {
			@Override
			protected IFigure createFigure() {
				return new StringSeparatedCompositeRowFigure("|", 8);
			}
		};
	}

	@Override
	public void visit(IntersectionType entity) {
		part = new AbstractCompositePart() {
			@Override
			protected IFigure createFigure() {
				return new StringSeparatedCompositeRowFigure("&", 16);
			}
		};
	}

	public void visit(Assignment entity) {
		part = new AssignmentPart();
	}

	public void visit(WildcardType entity) {
		part = new WildcardTypePart();
	}

	public void visit(SuperFieldAccess entity) {
		part = new SuperFieldAccessPart();
	}

	public void visit(VariableDeclarationStatement entity) {
		part = new VariableDeclarationStatementPart();
	}

	public void visit(VariableDeclarationExpression entity) {
		part = new VariableDeclarationExpressionPart();
	}

	public void visit(MemberValuePair entity) {
		part = new MemberValuePairPart();
	}

	public void visit(AnnotationTypeDeclaration entity) {
		part = new AnnotationTypeDeclarationPart();
	}

	public void visit(ConstructorInvocation entity) {
		part = new ConstructorInvocationPart();
	}

	public void visit(DoStatement entity) {
		part = new DoStatementPart();
	}

	public void visit(VariableDeclarationFragment entity) {
		part = new VariableDeclarationFragmentPart();
	}

	public void visit(AssertStatement entity) {
		part = new AssertStatementPart();
	}

	public void visit(CastExpression entity) {
		part = new CastExpressionPart();
	}

	public void visit(EnumDeclaration entity) {
		part = new EnumDeclarationPart();
	}

	public void visit(ReturnStatement entity) {
		part = new ReturnStatementPart();
	}

	public void visit(EnhancedForStatement entity) {
		part = new EnhancedForStatementPart();
	}

	public void visit(EmptyStatement entity) {
		part = new EmptyStatementPart();
	}

	public void visit(CatchClause entity) {
		part = new CatchClausePart();
	}

	public void visit(ArrayCreation entity) {
		part = new ArrayCreationPart();
	}

	public void visit(ParenthesizedExpression entity) {
		part = new ParenthesizedExpressionPart();
	}

	public void visit(Modifier entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(ImportDeclaration entity) {
		part = new ImportDeclarationPart();
	}

	public void visit(ThisExpression entity) {
		part = new ThisExpressionPart();
	}

	public void visit(TypeDeclarationStatement entity) {
		part = new TypeDeclarationStatementPart();
	}

	public void visit(ClassInstanceCreation entity) {
		part = new ClassInstanceCreationPart();
	}

	public void visit(PackageDeclaration entity) {
		part = new PackageDeclarationPart();
	}

	public void visit(MethodRefParameter entity) {
		part = new MethodRefParameterPart();
	}
	public void visit(MethodRefParameters entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}
	public void visit(MethodRef entity) {
		part = new MethodRefPart();
	}
	public void visit(MemberRef entity) {
		part = new MemberRefPart();
	}
	public void visit(DocElements entity) {
		part = new DocElementsPart();
	}

	public void visit(TagName entity) {
		super.visit(entity);
	}

	public void visit(TagElement entity) {
		part = new TagElementPart();
	}

	public void visit(Tags entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(Javadoc entity) {
		part = new JavadocPart(!(context instanceof PackageDeclarationPart));
	}

	public void visit(ArrayAccess entity) {
		part = new ArrayAccessPart();
	}

	public void visit(BlockComment entity) {
		part = new BlockCommentPart();
	}

	public void visit(EnumConstants entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}
	public void visit(EnumConstantDeclaration entity) {
		part = new EnumConstantDeclarationPart();
	}

	public void visit(LineComment entity) {
		part = new LineCommentPart();
	}

	public void visit(InfixExpression entity) {
		part = new InfixExpressionPart();
	}

	public void visit(BreakStatement entity) {
		part = new BreakStatementPart();
	}

	public void visit(SuperMethodInvocation entity) {
		part = new SuperMethodInvocationPart();
	}

	public void visit(AnonymousClassDeclaration entity) {
		part = new CompositeColumnPart();
	}

	public void visit(MarkerAnnotation entity) {
		part = new MarkerAnnotationPart();
	}

	public void visit(SwitchStatement entity) {
		part = new SwitchStatementPart();
	}

	public void visit(Block entity) {
		part = new CompositeColumnPart();
	}

	public void visit(PostfixExpression entity) {
		part = new PostfixExpressionPart();
	}

	public void visit(Initializer entity) {
		part = new InitializerPart();
	}

	public void visit(SingleMemberAnnotation entity) {
		part = new SingleMemberAnnotationPart();
	}

	public void visit(ForStatement entity) {
		part = new ForStatementPart();
	}

	public void visit(CompilationUnit entity) {
		part = new CompilationUnitPart();
	}

	public void visit(ConditionalExpression entity) {
		part = new ConditionalExpressionPart();
	}

	public void visit(MemberValuePairs entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(Types entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(Arguments entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(Parameters entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(BodyDeclarations entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(CatchClauses entity) {
		part = new CompositeColumnPart();
	}

	public void visit(AssignmentOperator entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(VariableDeclarationFragments entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(InfixOperator entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(Statements entity) {
		part = new CompositeColumnPart();
	}

	public void visit(PostfixOperator entity) {
		part = new ContentDataEntityPart();
	}

	public void visit(Expressions entity) {
		part = new ExpressionsPart();
	}

	public void visit(ImportDeclarations entity) {
		part = new CompositeColumnPart();
	}

	public void visit(TypeDeclarations entity) {
		part = new CompositeColumnPart();
	}

	public void visit(ExtendedModifiers entity) {
		part = new CompositeRowPart();
	}
	public void visit(Annotations entity) {
		part = new CompositeRowPart();
	}
	public void visit(TypeParameters entity) {
		part = new CommaSeparatedCompositeFlowPart();		
	}
}