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
public class InsertAdapter extends AbstractEntityAdapter implements Insert {
    private static final long serialVersionUID = 1;

    public InsertAdapter(IEntity implementor) {
        super(implementor);
    }

    public InsertAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Insert> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Insert;
    }

    public Content getContent() {
        return wGet(ChangesFeatureDescriptorEnum.content).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setContent(Content content) {
        wSet(ChangesFeatureDescriptorEnum.content, content);
    }

    public ChangeRevisions getRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.revisions).wGetAdapter(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public void setRevisions(ChangeRevisions revisions) {
        wSet(ChangesFeatureDescriptorEnum.revisions, revisions);
    }
}
