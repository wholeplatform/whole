package org.whole.lang.editors.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.editors.model.*;

/** 
 * @generator Whole
 */
public interface IEditorsVisitor extends IVisitor {
	public void visit(Editor entity);

	public void visit(ModelComponent entity);

	public void visit(ControllerComponent entity);

	public void visit(ControllerDeclarations entity);

	public void visit(PartDeclaration entity);

	public void visit(JavaPartDeclaration entity);

	public void visit(GenericPartDeclaration entity);

	public void visit(EntityFeatures entity);

	public void visit(GenericPartName entity);

	public void visit(ViewComponent entity);

	public void visit(ViewDeclarations entity);

	public void visit(SimpleFigureDeclaration entity);

	public void visit(FoldableTextualFigure entity);

	public void visit(TextualFigure entity);

	public void visit(Row entity);

	public void visit(ChildPlace entity);

	public void visit(Indent entity);

	public void visit(FoldingToggle entity);

	public void visit(KeywordToken entity);

	public void visit(LiteralToken entity);

	public void visit(IdentifierToken entity);

	public void visit(OperatorToken entity);

	public void visit(DelimiterToken entity);

	public void visit(ParenthesisToken entity);

	public void visit(EntityNames entity);

	public void visit(Identifier entity);
}
