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
public class CommentImpl extends AbstractSimpleEntity implements Comment {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Comment> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Comment;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.Comment_ord;
    }

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }
    private Text comment;

    public Text getComment() {
        return notifyRequested(ChangesFeatureDescriptorEnum.comment, comment);
    }

    public void setComment(Text comment) {
        notifyChanged(ChangesFeatureDescriptorEnum.comment, this.comment, this.comment = comment);
    }
    private Content content;

    public Content getContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.content, content);
    }

    public void setContent(Content content) {
        notifyChanged(ChangesFeatureDescriptorEnum.content, this.content, this.content = content);
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
            return getComment().wGetAdaptee(false);
            case 1 :
            return getContent().wGetAdaptee(false);
            case 2 :
            return getRevisions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setComment(value.wGetAdapter(ChangesEntityDescriptorEnum.Text));
            break;
            case 1 :
            setContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
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
