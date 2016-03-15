/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.javascript.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.javascript.model.*;
import org.whole.lang.javascript.visitors.JavaScriptIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.KeywordDataEntityPart;
import org.whole.lang.ui.editparts.LiteralDataEntityPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 *  @generator Whole
 */
public class JavaScriptPartFactoryVisitor extends JavaScriptIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((IJavaScriptEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(IJavaScriptEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(Program entity) {
        part = new ProgramPart();
    }

    @Override
    public void visit(Statements entity) {
        part = new StatementsPart();
    }

    @Override
    public void visit(Comment entity) {
        part = new CommentPart();
    }

    @Override
    public void visit(CommentKind entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(ObjectLiteral entity) {
        part = new ObjectLiteralPart();
    }

    @Override
    public void visit(ObjectProperties entity) {
        part = new ObjectPropertiesPart();
    }

    @Override
    public void visit(ObjectProperty entity) {
        part = new ObjectPropertyPart();
    }

    @Override
    public void visit(ArrayLiteral entity) {
        part = new ArrayLiteralPart();
    }

    @Override
    public void visit(EmptyExpression entity) {
        part = new EmptyExpressionPart();
    }

    @Override
    public void visit(ExpressionStatement entity) {
        part = new ExpressionStatementPart();
    }

    @Override
    public void visit(IfStatement entity) {
        part = new IfStatementPart();
    }

    @Override
    public void visit(LabeledStatement entity) {
        part = new LabeledStatementPart();
    }

    @Override
    public void visit(Labels entity) {
        part = new LabelsPart();
    }

    @Override
    public void visit(Label entity) {
        part = new LabelPart();
    }

    @Override
    public void visit(BreakStatement entity) {
        part = new BreakStatementPart();
    }

    @Override
    public void visit(ContinueStatement entity) {
        part = new ContinueStatementPart();
    }

    @Override
    public void visit(WithStatement entity) {
        part = new WithStatementPart();
    }

    @Override
    public void visit(SwitchStatement entity) {
        part = new SwitchStatementPart();
    }

    @Override
    public void visit(SwitchCases entity) {
        part = new SwitchCasesPart();
    }

    @Override
    public void visit(SwitchCase entity) {
        part = new SwitchCasePart();
    }

    @Override
    public void visit(ReturnStatement entity) {
        part = new ReturnStatementPart();
    }

    @Override
    public void visit(ThrowStatement entity) {
        part = new ThrowStatementPart();
    }

    @Override
    public void visit(TryStatement entity) {
        part = new TryStatementPart();
    }

    @Override
    public void visit(CatchClauses entity) {
        part = new CatchClausesPart();
    }

    @Override
    public void visit(CatchClause entity) {
        part = new CatchClausePart();
    }

    @Override
    public void visit(WhileStatement entity) {
        part = new WhileStatementPart();
    }

    @Override
    public void visit(DoWhileStatement entity) {
        part = new DoWhileStatementPart();
    }

    @Override
    public void visit(ForStatement entity) {
        part = new ForStatementPart();
    }

    @Override
    public void visit(ForInStatement entity) {
        part = new ForInStatementPart();
    }

    @Override
    public void visit(ForEachStatement entity) {
        part = new ForEachStatementPart();
    }

    @Override
    public void visit(LetStatement entity) {
        part = new LetStatementPart();
    }

    @Override
    public void visit(VariableInitializers entity) {
        part = new VariableInitializersPart();
    }

    @Override
    public void visit(VariableInitializer entity) {
        part = new VariableInitializerPart();
    }

    @Override
    public void visit(FunctionDeclaration entity) {
        part = new FunctionDeclarationPart();
    }

    @Override
    public void visit(VariableDeclaration entity) {
        part = new VariableDeclarationPart();
    }

    @Override
    public void visit(VariableDeclarationKind entity) {
        part = new KeywordDataEntityPart();
    }

    @Override
    public void visit(XmlAny entity) {
        part = new XmlAnyPart();
    }

    @Override
    public void visit(ComputedXmlRef entity) {
        part = new ComputedXmlRefPart();
    }

    @Override
    public void visit(StaticXmlRef entity) {
        part = new StaticXmlRefPart();
    }

    @Override
    public void visit(XmlMemberGet entity) {
        part = new XmlMemberGetPart();
    }

    @Override
    public void visit(XmlDotQuery entity) {
        part = new XmlDotQueryPart();
    }

    @Override
    public void visit(XmlMemberOperator entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(XmlLiteral entity) {
        part = new XmlLiteralPart();
    }

    @Override
    public void visit(XmlFragments entity) {
        part = new XmlFragmentsPart();
    }

    @Override
    public void visit(XmlString entity) {
        part = new XmlStringPart();
    }

    @Override
    public void visit(XmlExpression entity) {
        part = new XmlExpressionPart();
    }

    @Override
    public void visit(XmlDefaultNamespace entity) {
        part = new XmlDefaultNamespacePart();
    }

    @Override
    public void visit(FunctionExpression entity) {
        part = new FunctionExpressionPart();
    }

    @Override
    public void visit(Expressions entity) {
        part = new ExpressionsPart();
    }

    @Override
    public void visit(ParenthesizedExpression entity) {
        part = new ParenthesizedExpressionPart();
    }

    @Override
    public void visit(PrefixExpression entity) {
        part = new PrefixExpressionPart();
    }

    @Override
    public void visit(PostfixExpression entity) {
        part = new PostfixExpressionPart();
    }

    @Override
    public void visit(PrefixOperator entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(InfixOperator entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(PostfixOperator entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(InfixExpression entity) {
        part = new InfixExpressionPart();
    }

    @Override
    public void visit(AssignmentExpression entity) {
        part = new AssignmentExpressionPart();
    }

    @Override
    public void visit(AssignmentOperator entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(ConditionalExpression entity) {
        part = new ConditionalExpressionPart();
    }

    @Override
    public void visit(NewExpression entity) {
        part = new NewExpressionPart();
    }

    @Override
    public void visit(CallExpression entity) {
        part = new CallExpressionPart();
    }

    @Override
    public void visit(ComputedMemberExpression entity) {
        part = new ComputedMemberExpressionPart();
    }

    @Override
    public void visit(StaticMemberExpression entity) {
        part = new StaticMemberExpressionPart();
    }

    @Override
    public void visit(YieldExpression entity) {
        part = new YieldExpressionPart();
    }

    @Override
    public void visit(ArrayComprehensionExpression entity) {
        part = new ArrayComprehensionExpressionPart();
    }

    @Override
    public void visit(ComprehensionBlocks entity) {
        part = new ComprehensionBlocksPart();
    }

    @Override
    public void visit(ForInComprehensionBlock entity) {
        part = new ForInComprehensionBlockPart();
    }

    @Override
    public void visit(ForEachComprehensionBlock entity) {
        part = new ForEachComprehensionBlockPart();
    }

    @Override
    public void visit(LetExpression entity) {
        part = new LetExpressionPart();
    }

    @Override
    public void visit(Identifier entity) {
        part = new ContentTextualEntityPart();
    }

    @Override
    public void visit(NullLiteral entity) {
        part = new NullLiteralPart();
    }

    @Override
    public void visit(ThisLiteral entity) {
        part = new ThisLiteralPart();
    }

    @Override
    public void visit(StringLiteral entity) {
        part = new StringLiteralPart();
    }

    @Override
    public void visit(BooleanLiteral entity) {
        part = new LiteralDataEntityPart();
    }

    @Override
    public void visit(NumberLiteral entity) {
        part = new LiteralDataEntityPart();
    }

    @Override
    public void visit(RegExpLiteral entity) {
        part = new RegExpLiteralPart();
    }

    @Override
    public void visit(BooleanData entity) {
        part = new ContentDataEntityPart();
    }

    @Override
    public void visit(StringData entity) {
        part = new ContentTextualEntityPart();
    }
}
