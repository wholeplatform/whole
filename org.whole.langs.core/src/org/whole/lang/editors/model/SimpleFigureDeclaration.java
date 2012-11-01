package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface SimpleFigureDeclaration extends IEditorsEntity,
		ViewDeclaration {
	public FigureName getName();

	public void setName(FigureName name);

	public FigureBody getFigure();

	public void setFigure(FigureBody figure);
}
