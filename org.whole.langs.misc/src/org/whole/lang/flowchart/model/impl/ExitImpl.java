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
public class ExitImpl extends AbstractSimpleEntity implements Exit {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Exit> wGetEntityDescriptor() {
		return FlowchartEntityDescriptorEnum.Exit;
	}

	public int wGetEntityOrd() {
		return FlowchartEntityDescriptorEnum.Exit_ord;
	}

	public void accept(IFlowchartVisitor visitor) {
		visitor.visit(this);
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

	private Transition targetTransition;

	public Transition getTargetTransition() {
		return notifyRequested(FlowchartFeatureDescriptorEnum.targetTransition,
				targetTransition);
	}

	public void setTargetTransition(Transition targetTransition) {
		notifyChanged(FlowchartFeatureDescriptorEnum.targetTransition,
				this.targetTransition,
				this.targetTransition = targetTransition, false);
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
			return getTargetTransition().wGetAdaptee(false);
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
			setTargetTransition(value
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
