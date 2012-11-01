package org.whole.lang.workflows.model;

/** 
 * @generator Whole
 */
public interface Breakpoint extends IWorkflowsEntity, FlowObject {
	public BooleanLiteral getDisabled();

	public void setDisabled(BooleanLiteral disabled);

	public IntLiteral getHitCount();

	public void setHitCount(IntLiteral hitCount);

	public Condition getCondition();

	public void setCondition(Condition condition);

	public ConditionTest getConditionTest();

	public void setConditionTest(ConditionTest conditionTest);

	public Variables getShowVariables();

	public void setShowVariables(Variables showVariables);
}
