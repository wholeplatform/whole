package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface ToolbarActions extends IActionsEntity {
	public SimpleAction getValidatorAction();

	public void setValidatorAction(SimpleAction validatorAction);

	public SimpleAction getNormalizerAction();

	public void setNormalizerAction(SimpleAction normalizerAction);

	public SimpleAction getPrettyPrinterAction();

	public void setPrettyPrinterAction(SimpleAction prettyPrinterAction);

	public SimpleAction getInterpreterAction();

	public void setInterpreterAction(SimpleAction interpreterAction);

	public SimpleAction getGeneratorAction();

	public void setGeneratorAction(SimpleAction generatorAction);
}
