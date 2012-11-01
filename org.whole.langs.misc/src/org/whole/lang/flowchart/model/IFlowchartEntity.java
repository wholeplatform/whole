package org.whole.lang.flowchart.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;

/** 
 * @generator Whole
 */
public interface IFlowchartEntity extends IEntity {
	public void accept(IFlowchartVisitor visitor);
}
