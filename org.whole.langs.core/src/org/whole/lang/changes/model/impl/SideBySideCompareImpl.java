package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class SideBySideCompareImpl extends AbstractSimpleEntity implements SideBySideCompare {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SideBySideCompare> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.SideBySideCompare;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.SideBySideCompare_ord;
    }

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }
    private Content baseContent;

    public Content getBaseContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.baseContent, baseContent);
    }

    public void setBaseContent(Content baseContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.baseContent, this.baseContent, this.baseContent = baseContent);
    }
    private Content firstRevisedContent;

    public Content getFirstRevisedContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.firstRevisedContent, firstRevisedContent);
    }

    public void setFirstRevisedContent(Content firstRevisedContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.firstRevisedContent, this.firstRevisedContent, this.firstRevisedContent = firstRevisedContent);
    }
    private Content secondRevisedContent;

    public Content getSecondRevisedContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.secondRevisedContent, secondRevisedContent);
    }

    public void setSecondRevisedContent(Content secondRevisedContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.secondRevisedContent, this.secondRevisedContent, this.secondRevisedContent = secondRevisedContent);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBaseContent().wGetAdaptee(false);
            case 1 :
            return getFirstRevisedContent().wGetAdaptee(false);
            case 2 :
            return getSecondRevisedContent().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBaseContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 1 :
            setFirstRevisedContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 2 :
            setSecondRevisedContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
