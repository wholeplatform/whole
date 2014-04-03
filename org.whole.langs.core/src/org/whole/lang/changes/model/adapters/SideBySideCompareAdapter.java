package org.whole.lang.changes.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class SideBySideCompareAdapter extends AbstractEntityAdapter implements SideBySideCompare {
    private static final long serialVersionUID = 1;

    public SideBySideCompareAdapter(IEntity implementor) {
        super(implementor);
    }

    public SideBySideCompareAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SideBySideCompare> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.SideBySideCompare;
    }

    public Content getBaseContent() {
        return wGet(ChangesFeatureDescriptorEnum.baseContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setBaseContent(Content baseContent) {
        wSet(ChangesFeatureDescriptorEnum.baseContent, baseContent);
    }

    public Content getFirstRevisedContent() {
        return wGet(ChangesFeatureDescriptorEnum.firstRevisedContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setFirstRevisedContent(Content firstRevisedContent) {
        wSet(ChangesFeatureDescriptorEnum.firstRevisedContent, firstRevisedContent);
    }

    public Content getSecondRevisedContent() {
        return wGet(ChangesFeatureDescriptorEnum.secondRevisedContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setSecondRevisedContent(Content secondRevisedContent) {
        wSet(ChangesFeatureDescriptorEnum.secondRevisedContent, secondRevisedContent);
    }
}
