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
public class CutImpl extends AbstractSimpleEntity implements Cut {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Cut> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Cut;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.Cut_ord;
    }

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }
    private Content content;

    public Content getContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.content, content);
    }

    public void setContent(Content content) {
        notifyChanged(ChangesFeatureDescriptorEnum.content, this.content, this.content = content);
    }
    private Clipboard clipboard;

    public Clipboard getClipboard() {
        return notifyRequested(ChangesFeatureDescriptorEnum.clipboard, clipboard);
    }

    public void setClipboard(Clipboard clipboard) {
        notifyChanged(ChangesFeatureDescriptorEnum.clipboard, this.clipboard, this.clipboard = clipboard);
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
            return getContent().wGetAdaptee(false);
            case 1 :
            return getClipboard().wGetAdaptee(false);
            case 2 :
            return getRevisions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 1 :
            setClipboard(value.wGetAdapter(ChangesEntityDescriptorEnum.Clipboard));
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
