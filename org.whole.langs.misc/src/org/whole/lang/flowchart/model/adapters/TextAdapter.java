package org.whole.lang.flowchart.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TextAdapter extends AbstractEntityAdapter implements Text {
	private static final long serialVersionUID = 1;

	public TextAdapter(IEntity implementor) {
		super(implementor);
	}

	public TextAdapter() {
	}

	public void accept(IFlowchartVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Text> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Text;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
