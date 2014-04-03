package org.whole.lang.changes.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public abstract class ChangesIdentitySwitchVisitor extends AbstractVisitor implements IChangesVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case ChangesEntityDescriptorEnum.RevisionFrame_ord :
            visit((RevisionFrame) entity);
            break;
            case ChangesEntityDescriptorEnum.RevisionTrack_ord :
            visit((RevisionTrack) entity);
            break;
            case ChangesEntityDescriptorEnum.Revisions_ord :
            visit((Revisions) entity);
            break;
            case ChangesEntityDescriptorEnum.Revision_ord :
            visit((Revision) entity);
            break;
            case ChangesEntityDescriptorEnum.RevisionChanges_ord :
            visit((RevisionChanges) entity);
            break;
            case ChangesEntityDescriptorEnum.RevisionChange_ord :
            visit((RevisionChange) entity);
            break;
            case ChangesEntityDescriptorEnum.ChangeSides_ord :
            visit((ChangeSides) entity);
            break;
            case ChangesEntityDescriptorEnum.ChangeRevisions_ord :
            visit((ChangeRevisions) entity);
            break;
            case ChangesEntityDescriptorEnum.UnifiedCompare_ord :
            visit((UnifiedCompare) entity);
            break;
            case ChangesEntityDescriptorEnum.SideBySideCompare_ord :
            visit((SideBySideCompare) entity);
            break;
            case ChangesEntityDescriptorEnum.Nothing_ord :
            visit((Nothing) entity);
            break;
            case ChangesEntityDescriptorEnum.Changes_ord :
            visit((Changes) entity);
            break;
            case ChangesEntityDescriptorEnum.Relate_ord :
            visit((Relate) entity);
            break;
            case ChangesEntityDescriptorEnum.Cut_ord :
            visit((Cut) entity);
            break;
            case ChangesEntityDescriptorEnum.Copy_ord :
            visit((Copy) entity);
            break;
            case ChangesEntityDescriptorEnum.Paste_ord :
            visit((Paste) entity);
            break;
            case ChangesEntityDescriptorEnum.Delete_ord :
            visit((Delete) entity);
            break;
            case ChangesEntityDescriptorEnum.Insert_ord :
            visit((Insert) entity);
            break;
            case ChangesEntityDescriptorEnum.Replace_ord :
            visit((Replace) entity);
            break;
            case ChangesEntityDescriptorEnum.Wrap_ord :
            visit((Wrap) entity);
            break;
            case ChangesEntityDescriptorEnum.Comment_ord :
            visit((Comment) entity);
            break;
            case ChangesEntityDescriptorEnum.Text_ord :
            visit((Text) entity);
            break;
            case ChangesEntityDescriptorEnum.Clipboard_ord :
            visit((Clipboard) entity);
            break;
        }
    }
}
