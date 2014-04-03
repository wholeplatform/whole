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
public class ReplaceAdapter extends AbstractEntityAdapter implements Replace {
    private static final long serialVersionUID = 1;

    public ReplaceAdapter(IEntity implementor) {
        super(implementor);
    }

    public ReplaceAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Replace> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Replace;
    }

    public Content getDeleteContent() {
        return wGet(ChangesFeatureDescriptorEnum.deleteContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setDeleteContent(Content deleteContent) {
        wSet(ChangesFeatureDescriptorEnum.deleteContent, deleteContent);
    }

    public Content getInsertContent() {
        return wGet(ChangesFeatureDescriptorEnum.insertContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setInsertContent(Content insertContent) {
        wSet(ChangesFeatureDescriptorEnum.insertContent, insertContent);
    }

    public ChangeRevisions getRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.revisions).wGetAdapter(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public void setRevisions(ChangeRevisions revisions) {
        wSet(ChangesFeatureDescriptorEnum.revisions, revisions);
    }
}
