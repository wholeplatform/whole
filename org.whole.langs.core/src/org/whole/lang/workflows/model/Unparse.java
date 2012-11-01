package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Unparse extends IWorkflowsEntity, GrammarActivity {
	public Variable getModel();

	public void setModel(Variable model);

	public Expression getText();

	public void setText(Expression text);

	public Expression getGrammar();

	public void setGrammar(Expression grammar);

	public Expression getNt();

	public void setNt(Expression nt);
}
