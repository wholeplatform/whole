package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ColumnReferenceAdapter extends AbstractEntityAdapter implements
		ColumnReference {
	private static final long serialVersionUID = 1;

	public ColumnReferenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnReferenceAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnReference> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ColumnReference;
	}

	public StringData getSource() {
		return wGet(RDBFeatureDescriptorEnum.source).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setSource(StringData source) {
		wSet(RDBFeatureDescriptorEnum.source, source);
	}

	public StringData getTarget() {
		return wGet(RDBFeatureDescriptorEnum.target).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setTarget(StringData target) {
		wSet(RDBFeatureDescriptorEnum.target, target);
	}
}
