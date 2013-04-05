package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CutImpl extends AbstractSimpleEntity implements Cut {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Cut> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.Cut;
	}

	public int wGetEntityOrd() {
		return PatternsEntityDescriptorEnum.Cut_ord;
	}

	public void accept(IPatternsVisitor visitor) {
		visitor.visit(this);
	}

	private PathExpression path;

	public PathExpression getPath() {
		return notifyRequested(PatternsFeatureDescriptorEnum.path, path);
	}

	public void setPath(PathExpression path) {
		notifyChanged(PatternsFeatureDescriptorEnum.path, this.path,
				this.path = path);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPath().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPath(value
					.wGetAdapter(PatternsEntityDescriptorEnum.PathExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
