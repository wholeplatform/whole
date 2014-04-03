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
public class UnifiedCompareAdapter extends AbstractEntityAdapter implements UnifiedCompare {
    private static final long serialVersionUID = 1;

    public UnifiedCompareAdapter(IEntity implementor) {
        super(implementor);
    }

    public UnifiedCompareAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<UnifiedCompare> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.UnifiedCompare;
    }

    public Content getUnifiedContent() {
        return wGet(ChangesFeatureDescriptorEnum.unifiedContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setUnifiedContent(Content unifiedContent) {
        wSet(ChangesFeatureDescriptorEnum.unifiedContent, unifiedContent);
    }
}
