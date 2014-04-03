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
public class UnifiedCompareImpl extends AbstractSimpleEntity implements UnifiedCompare {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<UnifiedCompare> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.UnifiedCompare;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.UnifiedCompare_ord;
    }

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }
    private Content unifiedContent;

    public Content getUnifiedContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.unifiedContent, unifiedContent);
    }

    public void setUnifiedContent(Content unifiedContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.unifiedContent, this.unifiedContent, this.unifiedContent = unifiedContent);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getUnifiedContent().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setUnifiedContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
