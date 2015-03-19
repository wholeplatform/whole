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
public class WrapImpl extends AbstractSimpleEntity implements Wrap {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Wrap> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Wrap;
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.Wrap_ord;
    }

    public void accept(IChangesVisitor visitor) {
		try {
	        visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}    }
    private Content cutContent;

    public Content getCutContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.cutContent, cutContent);
    }

    public void setCutContent(Content cutContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.cutContent, this.cutContent, this.cutContent = cutContent);
    }
    private Content insertContent;

    public Content getInsertContent() {
        return notifyRequested(ChangesFeatureDescriptorEnum.insertContent, insertContent);
    }

    public void setInsertContent(Content insertContent) {
        notifyChanged(ChangesFeatureDescriptorEnum.insertContent, this.insertContent, this.insertContent = insertContent);
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
            return getCutContent().wGetAdaptee(false);
            case 1 :
            return getInsertContent().wGetAdaptee(false);
            case 2 :
            return getClipboard().wGetAdaptee(false);
            case 3 :
            return getRevisions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCutContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 1 :
            setInsertContent(value.wGetAdapter(ChangesEntityDescriptorEnum.Content));
            break;
            case 2 :
            setClipboard(value.wGetAdapter(ChangesEntityDescriptorEnum.Clipboard));
            break;
            case 3 :
            setRevisions(value.wGetAdapter(ChangesEntityDescriptorEnum.ChangeRevisions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }

    public int wAdjacentSize() {
        return 1;
    }
}
