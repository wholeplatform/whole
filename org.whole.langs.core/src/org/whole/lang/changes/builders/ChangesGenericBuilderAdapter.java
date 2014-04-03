package org.whole.lang.changes.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ChangesGenericBuilderAdapter extends GenericIdentityBuilder {
    private IChangesBuilder specificBuilder;

    public ChangesGenericBuilderAdapter(IChangesBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public ChangesGenericBuilderAdapter(IChangesBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case ChangesFeatureDescriptorEnum.baseRevisions_ord :
            specificBuilder.baseRevisions();
            break;
            case ChangesFeatureDescriptorEnum.leftRevisions_ord :
            specificBuilder.leftRevisions();
            break;
            case ChangesFeatureDescriptorEnum.rightRevisions_ord :
            specificBuilder.rightRevisions();
            break;
            case ChangesFeatureDescriptorEnum.baseContent_ord :
            specificBuilder.baseContent();
            break;
            case ChangesFeatureDescriptorEnum.leftContent_ord :
            specificBuilder.leftContent();
            break;
            case ChangesFeatureDescriptorEnum.rightContent_ord :
            specificBuilder.rightContent();
            break;
            case ChangesFeatureDescriptorEnum.revisions_ord :
            specificBuilder.revisions();
            break;
            case ChangesFeatureDescriptorEnum.compare_ord :
            specificBuilder.compare();
            break;
            case ChangesFeatureDescriptorEnum.revisor_ord :
            specificBuilder.revisor();
            break;
            case ChangesFeatureDescriptorEnum.changes_ord :
            specificBuilder.changes();
            break;
            case ChangesFeatureDescriptorEnum.sides_ord :
            specificBuilder.sides();
            break;
            case ChangesFeatureDescriptorEnum.unifiedContent_ord :
            specificBuilder.unifiedContent();
            break;
            case ChangesFeatureDescriptorEnum.firstRevisedContent_ord :
            specificBuilder.firstRevisedContent();
            break;
            case ChangesFeatureDescriptorEnum.secondRevisedContent_ord :
            specificBuilder.secondRevisedContent();
            break;
            case ChangesFeatureDescriptorEnum.content_ord :
            specificBuilder.content();
            break;
            case ChangesFeatureDescriptorEnum.clipboard_ord :
            specificBuilder.clipboard();
            break;
            case ChangesFeatureDescriptorEnum.deleteContent_ord :
            specificBuilder.deleteContent();
            break;
            case ChangesFeatureDescriptorEnum.insertContent_ord :
            specificBuilder.insertContent();
            break;
            case ChangesFeatureDescriptorEnum.cutContent_ord :
            specificBuilder.cutContent();
            break;
            case ChangesFeatureDescriptorEnum.comment_ord :
            specificBuilder.comment();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ChangesEntityDescriptorEnum.RevisionFrame_ord :
            specificBuilder.RevisionFrame();
            break;
            case ChangesEntityDescriptorEnum.RevisionTrack_ord :
            specificBuilder.RevisionTrack();
            break;
            case ChangesEntityDescriptorEnum.Revisions_ord :
            specificBuilder.Revisions();
            break;
            case ChangesEntityDescriptorEnum.Revision_ord :
            specificBuilder.Revision();
            break;
            case ChangesEntityDescriptorEnum.RevisionChanges_ord :
            specificBuilder.RevisionChanges();
            break;
            case ChangesEntityDescriptorEnum.RevisionChange_ord :
            specificBuilder.RevisionChange();
            break;
            case ChangesEntityDescriptorEnum.ChangeSides_ord :
            specificBuilder.ChangeSides();
            break;
            case ChangesEntityDescriptorEnum.ChangeRevisions_ord :
            specificBuilder.ChangeRevisions();
            break;
            case ChangesEntityDescriptorEnum.UnifiedCompare_ord :
            specificBuilder.UnifiedCompare();
            break;
            case ChangesEntityDescriptorEnum.SideBySideCompare_ord :
            specificBuilder.SideBySideCompare();
            break;
            case ChangesEntityDescriptorEnum.Nothing_ord :
            specificBuilder.Nothing();
            break;
            case ChangesEntityDescriptorEnum.Changes_ord :
            specificBuilder.Changes();
            break;
            case ChangesEntityDescriptorEnum.Relate_ord :
            specificBuilder.Relate();
            break;
            case ChangesEntityDescriptorEnum.Cut_ord :
            specificBuilder.Cut();
            break;
            case ChangesEntityDescriptorEnum.Copy_ord :
            specificBuilder.Copy();
            break;
            case ChangesEntityDescriptorEnum.Paste_ord :
            specificBuilder.Paste();
            break;
            case ChangesEntityDescriptorEnum.Delete_ord :
            specificBuilder.Delete();
            break;
            case ChangesEntityDescriptorEnum.Insert_ord :
            specificBuilder.Insert();
            break;
            case ChangesEntityDescriptorEnum.Replace_ord :
            specificBuilder.Replace();
            break;
            case ChangesEntityDescriptorEnum.Wrap_ord :
            specificBuilder.Wrap();
            break;
            case ChangesEntityDescriptorEnum.Comment_ord :
            specificBuilder.Comment();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ChangesEntityDescriptorEnum.RevisionFrame_ord :
            specificBuilder.RevisionFrame_();
            break;
            case ChangesEntityDescriptorEnum.RevisionTrack_ord :
            specificBuilder.RevisionTrack_();
            break;
            case ChangesEntityDescriptorEnum.Revisions_ord :
            specificBuilder.Revisions_();
            break;
            case ChangesEntityDescriptorEnum.Revision_ord :
            specificBuilder.Revision_();
            break;
            case ChangesEntityDescriptorEnum.RevisionChanges_ord :
            specificBuilder.RevisionChanges_();
            break;
            case ChangesEntityDescriptorEnum.RevisionChange_ord :
            specificBuilder.RevisionChange_();
            break;
            case ChangesEntityDescriptorEnum.ChangeSides_ord :
            specificBuilder.ChangeSides_();
            break;
            case ChangesEntityDescriptorEnum.ChangeRevisions_ord :
            specificBuilder.ChangeRevisions_();
            break;
            case ChangesEntityDescriptorEnum.UnifiedCompare_ord :
            specificBuilder.UnifiedCompare_();
            break;
            case ChangesEntityDescriptorEnum.SideBySideCompare_ord :
            specificBuilder.SideBySideCompare_();
            break;
            case ChangesEntityDescriptorEnum.Nothing_ord :
            specificBuilder.Nothing_();
            break;
            case ChangesEntityDescriptorEnum.Changes_ord :
            specificBuilder.Changes_();
            break;
            case ChangesEntityDescriptorEnum.Relate_ord :
            specificBuilder.Relate_();
            break;
            case ChangesEntityDescriptorEnum.Cut_ord :
            specificBuilder.Cut_();
            break;
            case ChangesEntityDescriptorEnum.Copy_ord :
            specificBuilder.Copy_();
            break;
            case ChangesEntityDescriptorEnum.Paste_ord :
            specificBuilder.Paste_();
            break;
            case ChangesEntityDescriptorEnum.Delete_ord :
            specificBuilder.Delete_();
            break;
            case ChangesEntityDescriptorEnum.Insert_ord :
            specificBuilder.Insert_();
            break;
            case ChangesEntityDescriptorEnum.Replace_ord :
            specificBuilder.Replace_();
            break;
            case ChangesEntityDescriptorEnum.Wrap_ord :
            specificBuilder.Wrap_();
            break;
            case ChangesEntityDescriptorEnum.Comment_ord :
            specificBuilder.Comment_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ChangesEntityDescriptorEnum.RevisionFrame_ord :
            specificBuilder._RevisionFrame();
            break;
            case ChangesEntityDescriptorEnum.RevisionTrack_ord :
            specificBuilder._RevisionTrack();
            break;
            case ChangesEntityDescriptorEnum.Revisions_ord :
            specificBuilder._Revisions();
            break;
            case ChangesEntityDescriptorEnum.Revision_ord :
            specificBuilder._Revision();
            break;
            case ChangesEntityDescriptorEnum.RevisionChanges_ord :
            specificBuilder._RevisionChanges();
            break;
            case ChangesEntityDescriptorEnum.RevisionChange_ord :
            specificBuilder._RevisionChange();
            break;
            case ChangesEntityDescriptorEnum.ChangeSides_ord :
            specificBuilder._ChangeSides();
            break;
            case ChangesEntityDescriptorEnum.ChangeRevisions_ord :
            specificBuilder._ChangeRevisions();
            break;
            case ChangesEntityDescriptorEnum.UnifiedCompare_ord :
            specificBuilder._UnifiedCompare();
            break;
            case ChangesEntityDescriptorEnum.SideBySideCompare_ord :
            specificBuilder._SideBySideCompare();
            break;
            case ChangesEntityDescriptorEnum.Nothing_ord :
            specificBuilder._Nothing();
            break;
            case ChangesEntityDescriptorEnum.Changes_ord :
            specificBuilder._Changes();
            break;
            case ChangesEntityDescriptorEnum.Relate_ord :
            specificBuilder._Relate();
            break;
            case ChangesEntityDescriptorEnum.Cut_ord :
            specificBuilder._Cut();
            break;
            case ChangesEntityDescriptorEnum.Copy_ord :
            specificBuilder._Copy();
            break;
            case ChangesEntityDescriptorEnum.Paste_ord :
            specificBuilder._Paste();
            break;
            case ChangesEntityDescriptorEnum.Delete_ord :
            specificBuilder._Delete();
            break;
            case ChangesEntityDescriptorEnum.Insert_ord :
            specificBuilder._Insert();
            break;
            case ChangesEntityDescriptorEnum.Replace_ord :
            specificBuilder._Replace();
            break;
            case ChangesEntityDescriptorEnum.Wrap_ord :
            specificBuilder._Wrap();
            break;
            case ChangesEntityDescriptorEnum.Comment_ord :
            specificBuilder._Comment();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case ChangesEntityDescriptorEnum.Revisions_ord :
            specificBuilder.Revisions_(initialCapacity);
            break;
            case ChangesEntityDescriptorEnum.RevisionChanges_ord :
            specificBuilder.RevisionChanges_(initialCapacity);
            break;
            case ChangesEntityDescriptorEnum.ChangeSides_ord :
            specificBuilder.ChangeSides_(initialCapacity);
            break;
            case ChangesEntityDescriptorEnum.ChangeRevisions_ord :
            specificBuilder.ChangeRevisions_(initialCapacity);
            break;
            case ChangesEntityDescriptorEnum.Changes_ord :
            specificBuilder.Changes_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case ChangesEntityDescriptorEnum.Text_ord :
            specificBuilder.Text(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        switch (entityDesc.getOrdinal()) {
            case ChangesEntityDescriptorEnum.Clipboard_ord :
            specificBuilder.Clipboard(value);
            break;
        }
    }
}
