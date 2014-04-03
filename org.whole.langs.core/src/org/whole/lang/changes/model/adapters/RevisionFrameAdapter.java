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
public class RevisionFrameAdapter extends AbstractEntityAdapter implements RevisionFrame {
    private static final long serialVersionUID = 1;

    public RevisionFrameAdapter(IEntity implementor) {
        super(implementor);
    }

    public RevisionFrameAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<RevisionFrame> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.RevisionFrame;
    }

    public Revisions getBaseRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.baseRevisions).wGetAdapter(ChangesEntityDescriptorEnum.Revisions);
    }

    public void setBaseRevisions(Revisions baseRevisions) {
        wSet(ChangesFeatureDescriptorEnum.baseRevisions, baseRevisions);
    }

    public Revisions getLeftRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.leftRevisions).wGetAdapter(ChangesEntityDescriptorEnum.Revisions);
    }

    public void setLeftRevisions(Revisions leftRevisions) {
        wSet(ChangesFeatureDescriptorEnum.leftRevisions, leftRevisions);
    }

    public Revisions getRightRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.rightRevisions).wGetAdapter(ChangesEntityDescriptorEnum.Revisions);
    }

    public void setRightRevisions(Revisions rightRevisions) {
        wSet(ChangesFeatureDescriptorEnum.rightRevisions, rightRevisions);
    }

    public Content getBaseContent() {
        return wGet(ChangesFeatureDescriptorEnum.baseContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setBaseContent(Content baseContent) {
        wSet(ChangesFeatureDescriptorEnum.baseContent, baseContent);
    }

    public Content getLeftContent() {
        return wGet(ChangesFeatureDescriptorEnum.leftContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setLeftContent(Content leftContent) {
        wSet(ChangesFeatureDescriptorEnum.leftContent, leftContent);
    }

    public Content getRightContent() {
        return wGet(ChangesFeatureDescriptorEnum.rightContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setRightContent(Content rightContent) {
        wSet(ChangesFeatureDescriptorEnum.rightContent, rightContent);
    }
}
