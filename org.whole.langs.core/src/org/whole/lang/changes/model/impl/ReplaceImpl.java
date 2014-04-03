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
public class ReplaceImpl extends AbstractSimpleEntity implements Replace {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Replace> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Replace;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.Replace_ord;
    }

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }
    private Content deleteContent;

    public Content getDeleteContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.deleteContent, deleteContent);
    }

    public void setDeleteContent(Content deleteContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.deleteContent, this.deleteContent, this.deleteContent = deleteContent);
    }
    private Content insertContent;

    public Content getInsertContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.insertContent, insertContent);
    }

    public void setInsertContent(Content insertContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.insertContent, this.insertContent, this.insertContent = insertContent);
    }
    private ChangeRevisions revisions;

    public ChangeRevisions getRevisions() {
        return notifyRequested(ChangesFeatureDescriptorEnum.revisions, revisions);
    }

    public void setRevisions(ChangeRevisions revisions) {
        notifyChanged(ChangesFeatureDescriptorEnum.revisions, this.revisions, this.revisions = revisions, false);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getDeleteContent().wGetAdaptee(false);
            case 1 :
            return getInsertContent().wGetAdaptee(false);
            case 2 :
            return getRevisions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setDeleteContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 1 :
            setInsertContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 2 :
            setRevisions(value.wGetAdapter(ChangesEntityDescriptorEnum.ChangeRevisions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }

    public int wAdjacentSize() {
        return 1;
    }
}
