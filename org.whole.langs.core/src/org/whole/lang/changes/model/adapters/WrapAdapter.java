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
public class WrapAdapter extends AbstractEntityAdapter implements Wrap {
    private static final long serialVersionUID = 1;

    public WrapAdapter(IEntity implementor) {
        super(implementor);
    }

    public WrapAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Wrap> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Wrap;
    }

    public Content getCutContent() {
        return wGet(ChangesFeatureDescriptorEnum.cutContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setCutContent(Content cutContent) {
        wSet(ChangesFeatureDescriptorEnum.cutContent, cutContent);
    }

    public Content getInsertContent() {
        return wGet(ChangesFeatureDescriptorEnum.insertContent).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setInsertContent(Content insertContent) {
        wSet(ChangesFeatureDescriptorEnum.insertContent, insertContent);
    }

    public Clipboard getClipboard() {
        return wGet(ChangesFeatureDescriptorEnum.clipboard).wGetAdapter(ChangesEntityDescriptorEnum.Clipboard);
    }

    public void setClipboard(Clipboard clipboard) {
        wSet(ChangesFeatureDescriptorEnum.clipboard, clipboard);
    }

    public ChangeRevisions getRevisions() {
        return wGet(ChangesFeatureDescriptorEnum.revisions).wGetAdapter(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public void setRevisions(ChangeRevisions revisions) {
        wSet(ChangesFeatureDescriptorEnum.revisions, revisions);
    }
}
