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
public class CutAdapter extends AbstractEntityAdapter implements Cut {
    private static final long serialVersionUID = 1;

    public CutAdapter(IEntity implementor) {
        super(implementor);
    }

    public CutAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Cut> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Cut;
    }

    public Content getContent() {
        return wGet(ChangesFeatureDescriptorEnum.content).wGetAdapter(ChangesEntityDescriptorEnum.Content);
    }

    public void setContent(Content content) {
        wSet(ChangesFeatureDescriptorEnum.content, content);
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
