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
public class RevisionFrameImpl extends AbstractSimpleEntity implements RevisionFrame {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<RevisionFrame> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.RevisionFrame;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.RevisionFrame_ord;
    }

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }
    private Revisions baseRevisions;

    public Revisions getBaseRevisions() {
        return notifyRequested(ChangesFeatureDescriptorEnum.baseRevisions, baseRevisions);
    }

    public void setBaseRevisions(Revisions baseRevisions) {
        notifyChanged(ChangesFeatureDescriptorEnum.baseRevisions, this.baseRevisions, this.baseRevisions = baseRevisions);
    }
    private Revisions leftRevisions;

    public Revisions getLeftRevisions() {
        return notifyRequested(ChangesFeatureDescriptorEnum.leftRevisions, leftRevisions);
    }

    public void setLeftRevisions(Revisions leftRevisions) {
        notifyChanged(ChangesFeatureDescriptorEnum.leftRevisions, this.leftRevisions, this.leftRevisions = leftRevisions);
    }
    private Revisions rightRevisions;

    public Revisions getRightRevisions() {
        return notifyRequested(ChangesFeatureDescriptorEnum.rightRevisions, rightRevisions);
    }

    public void setRightRevisions(Revisions rightRevisions) {
        notifyChanged(ChangesFeatureDescriptorEnum.rightRevisions, this.rightRevisions, this.rightRevisions = rightRevisions);
    }
    private Content baseContent;

    public Content getBaseContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.baseContent, baseContent);
    }

    public void setBaseContent(Content baseContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.baseContent, this.baseContent, this.baseContent = baseContent);
    }
    private Content leftContent;

    public Content getLeftContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.leftContent, leftContent);
    }

    public void setLeftContent(Content leftContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.leftContent, this.leftContent, this.leftContent = leftContent);
    }
    private Content rightContent;

    public Content getRightContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.rightContent, rightContent);
    }

    public void setRightContent(Content rightContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.rightContent, this.rightContent, this.rightContent = rightContent);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBaseRevisions().wGetAdaptee(false);
            case 1 :
            return getLeftRevisions().wGetAdaptee(false);
            case 2 :
            return getRightRevisions().wGetAdaptee(false);
            case 3 :
            return getBaseContent().wGetAdaptee(false);
            case 4 :
            return getLeftContent().wGetAdaptee(false);
            case 5 :
            return getRightContent().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBaseRevisions(value.wGetAdapter(ChangesEntityDescriptorEnum.Revisions));
            break;
            case 1 :
            setLeftRevisions(value.wGetAdapter(ChangesEntityDescriptorEnum.Revisions));
            break;
            case 2 :
            setRightRevisions(value.wGetAdapter(ChangesEntityDescriptorEnum.Revisions));
            break;
            case 3 :
            setBaseContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 4 :
            setLeftContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 5 :
            setRightContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
