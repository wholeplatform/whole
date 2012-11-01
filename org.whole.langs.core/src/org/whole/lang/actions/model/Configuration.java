package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface Configuration extends IActionsEntity {
	public VariabilityModel getVariabilityModel();

	public void setVariabilityModel(VariabilityModel variabilityModel);

	public Predicate getValidator();

	public void setValidator(Predicate validator);

	public Transformation getBindingsGenerator();

	public void setBindingsGenerator(Transformation bindingsGenerator);

	public Dialog getDialog();

	public void setDialog(Dialog dialog);
}
