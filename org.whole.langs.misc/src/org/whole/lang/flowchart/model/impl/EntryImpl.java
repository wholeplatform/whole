package org.whole.lang.flowchart.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.flowchart.reflect.FlowchartEntityDescriptorEnum;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.flowchart.reflect.FlowchartFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EntryImpl extends AbstractSimpleEntity implements Entry {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Entry> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Entry;
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.Entry_ord;
	}

	public void accept(IFlowchartVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Pixels x;

	public Pixels getX() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.x, x);
	}

	public void setX(Pixels x) {
		notifyChanged(FlowchartFeatureDescriptorEnum.x, this.x, this.x = x);
	}

	private Pixels y;

	public Pixels getY() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.y, y);
	}

	public void setY(Pixels y) {
		notifyChanged(FlowchartFeatureDescriptorEnum.y, this.y, this.y = y);
	}

	private Pixels width;

	public Pixels getWidth() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.width, width);
	}

	public void setWidth(Pixels width) {
		notifyChanged(FlowchartFeatureDescriptorEnum.width, this.width,
				this.width = width);
	}

	private Pixels height;

	public Pixels getHeight() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.height, height);
	}

	public void setHeight(Pixels height) {
		notifyChanged(FlowchartFeatureDescriptorEnum.height, this.height,
				this.height = height);
	}

	private Text description;

	public Text getDescription() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.description,
				description);
	}

	public void setDescription(Text description) {
		notifyChanged(FlowchartFeatureDescriptorEnum.description,
				this.description, this.description = description);
	}

	private Transition sourceTransition;

	public Transition getSourceTransition() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.sourceTransition,
				sourceTransition);
	}

	public void setSourceTransition(Transition sourceTransition) {
		notifyChanged(FlowchartFeatureDescriptorEnum.sourceTransition,
				this.sourceTransition,
				this.sourceTransition = sourceTransition, false);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getX().wGetAdaptee(false);
		case 1:
			return getY().wGetAdaptee(false);
		case 2:
			return getWidth().wGetAdaptee(false);
		case 3:
			return getHeight().wGetAdaptee(false);
		case 4:
			return getDescription().wGetAdaptee(false);
		case 5:
			return getSourceTransition().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setX(value.wGetAdapter(FlowchartEntityDescriptorEnum.Pixels));
			break;
		case 1:
			setY(value.wGetAdapter(FlowchartEntityDescriptorEnum.Pixels));
			break;
		case 2:
			setWidth(value.wGetAdapter(FlowchartEntityDescriptorEnum.Pixels));
			break;
		case 3:
			setHeight(value.wGetAdapter(FlowchartEntityDescriptorEnum.Pixels));
			break;
		case 4:
			setDescription(value
					.wGetAdapter(FlowchartEntityDescriptorEnum.Text));
			break;
		case 5:
			setSourceTransition(value
					.wGetAdapter(FlowchartEntityDescriptorEnum.Transition));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}

	public int wAdjacentSize() {
		return 1;
	}
}
