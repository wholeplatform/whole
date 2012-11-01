package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ColumnReferenceImpl extends AbstractSimpleEntity implements
		ColumnReference {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ColumnReference> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ColumnReference;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.ColumnReference_ord;
	}

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	private StringData source;

	public StringData getSource() {
		return notifyRequested(RDBFeatureDescriptorEnum.source, source);
	}

	public void setSource(StringData source) {
		notifyChanged(RDBFeatureDescriptorEnum.source, this.source,
				this.source = source);
	}

	private StringData target;

	public StringData getTarget() {
		return notifyRequested(RDBFeatureDescriptorEnum.target, target);
	}

	public void setTarget(StringData target) {
		notifyChanged(RDBFeatureDescriptorEnum.target, this.target,
				this.target = target);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSource().wGetAdaptee(false);
		case 1:
			return getTarget().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSource(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		case 1:
			setTarget(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
