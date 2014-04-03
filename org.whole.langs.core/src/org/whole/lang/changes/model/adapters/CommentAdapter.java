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
public class CommentAdapter extends AbstractEntityAdapter implements Comment {
    private static final long serialVersionUID = 1;

    public CommentAdapter(IEntity implementor) {
        super(implementor);
    }

    public CommentAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Comment> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Comment;
    }

    public Text getComment() {
        return wGet(ChangesFeatureDescriptorEnum.comment).wGetAdapter(ChangesEntityDescriptorEnum.Text);
    }

    public void setComment(Text comment) {
        wSet(ChangesFeatureDescriptorEnum.comment, comment);
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
