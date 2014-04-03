package org.whole.lang.changes.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ChangesSpecificBuilderAdapter extends GenericBuilderContext implements IChangesBuilder {

    public ChangesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public ChangesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void comment() {
        wFeature(ChangesFeatureDescriptorEnum.comment);
    }

    public void cutContent() {
        wFeature(ChangesFeatureDescriptorEnum.cutContent);
    }

    public void insertContent() {
        wFeature(ChangesFeatureDescriptorEnum.insertContent);
    }

    public void deleteContent() {
        wFeature(ChangesFeatureDescriptorEnum.deleteContent);
    }

    public void clipboard() {
        wFeature(ChangesFeatureDescriptorEnum.clipboard);
    }

    public void content() {
        wFeature(ChangesFeatureDescriptorEnum.content);
    }

    public void secondRevisedContent() {
        wFeature(ChangesFeatureDescriptorEnum.secondRevisedContent);
    }

    public void firstRevisedContent() {
        wFeature(ChangesFeatureDescriptorEnum.firstRevisedContent);
    }

    public void unifiedContent() {
        wFeature(ChangesFeatureDescriptorEnum.unifiedContent);
    }

    public void sides() {
        wFeature(ChangesFeatureDescriptorEnum.sides);
    }

    public void changes() {
        wFeature(ChangesFeatureDescriptorEnum.changes);
    }

    public void revisor() {
        wFeature(ChangesFeatureDescriptorEnum.revisor);
    }

    public void compare() {
        wFeature(ChangesFeatureDescriptorEnum.compare);
    }

    public void revisions() {
        wFeature(ChangesFeatureDescriptorEnum.revisions);
    }

    public void rightContent() {
        wFeature(ChangesFeatureDescriptorEnum.rightContent);
    }

    public void leftContent() {
        wFeature(ChangesFeatureDescriptorEnum.leftContent);
    }

    public void baseContent() {
        wFeature(ChangesFeatureDescriptorEnum.baseContent);
    }

    public void rightRevisions() {
        wFeature(ChangesFeatureDescriptorEnum.rightRevisions);
    }

    public void leftRevisions() {
        wFeature(ChangesFeatureDescriptorEnum.leftRevisions);
    }

    public void baseRevisions() {
        wFeature(ChangesFeatureDescriptorEnum.baseRevisions);
    }

    public void visit() {
    }

    public void RevisionFrame() {
        wEntity(ChangesEntityDescriptorEnum.RevisionFrame);
    }

    public void RevisionFrame_() {
        wEntity_(ChangesEntityDescriptorEnum.RevisionFrame);
    }

    public void _RevisionFrame() {
        _wEntity(ChangesEntityDescriptorEnum.RevisionFrame);
    }

    public void RevisionTrack() {
        wEntity(ChangesEntityDescriptorEnum.RevisionTrack);
    }

    public void RevisionTrack_() {
        wEntity_(ChangesEntityDescriptorEnum.RevisionTrack);
    }

    public void _RevisionTrack() {
        _wEntity(ChangesEntityDescriptorEnum.RevisionTrack);
    }

    public void Revisions() {
        wEntity(ChangesEntityDescriptorEnum.Revisions);
    }

    public void Revisions_() {
        wEntity_(ChangesEntityDescriptorEnum.Revisions);
    }

    public void Revisions_(int initialCapacity) {
        wEntity_(ChangesEntityDescriptorEnum.Revisions, initialCapacity);
    }

    public void _Revisions() {
        _wEntity(ChangesEntityDescriptorEnum.Revisions);
    }

    public void Revision() {
        wEntity(ChangesEntityDescriptorEnum.Revision);
    }

    public void Revision_() {
        wEntity_(ChangesEntityDescriptorEnum.Revision);
    }

    public void _Revision() {
        _wEntity(ChangesEntityDescriptorEnum.Revision);
    }

    public void RevisionChanges() {
        wEntity(ChangesEntityDescriptorEnum.RevisionChanges);
    }

    public void RevisionChanges_() {
        wEntity_(ChangesEntityDescriptorEnum.RevisionChanges);
    }

    public void RevisionChanges_(int initialCapacity) {
        wEntity_(ChangesEntityDescriptorEnum.RevisionChanges, initialCapacity);
    }

    public void _RevisionChanges() {
        _wEntity(ChangesEntityDescriptorEnum.RevisionChanges);
    }

    public void RevisionChange() {
        wEntity(ChangesEntityDescriptorEnum.RevisionChange);
    }

    public void RevisionChange_() {
        wEntity_(ChangesEntityDescriptorEnum.RevisionChange);
    }

    public void _RevisionChange() {
        _wEntity(ChangesEntityDescriptorEnum.RevisionChange);
    }

    public void ChangeSides() {
        wEntity(ChangesEntityDescriptorEnum.ChangeSides);
    }

    public void ChangeSides_() {
        wEntity_(ChangesEntityDescriptorEnum.ChangeSides);
    }

    public void ChangeSides_(int initialCapacity) {
        wEntity_(ChangesEntityDescriptorEnum.ChangeSides, initialCapacity);
    }

    public void _ChangeSides() {
        _wEntity(ChangesEntityDescriptorEnum.ChangeSides);
    }

    public void ChangeRevisions() {
        wEntity(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public void ChangeRevisions_() {
        wEntity_(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public void ChangeRevisions_(int initialCapacity) {
        wEntity_(ChangesEntityDescriptorEnum.ChangeRevisions, initialCapacity);
    }

    public void _ChangeRevisions() {
        _wEntity(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public void UnifiedCompare() {
        wEntity(ChangesEntityDescriptorEnum.UnifiedCompare);
    }

    public void UnifiedCompare_() {
        wEntity_(ChangesEntityDescriptorEnum.UnifiedCompare);
    }

    public void _UnifiedCompare() {
        _wEntity(ChangesEntityDescriptorEnum.UnifiedCompare);
    }

    public void SideBySideCompare() {
        wEntity(ChangesEntityDescriptorEnum.SideBySideCompare);
    }

    public void SideBySideCompare_() {
        wEntity_(ChangesEntityDescriptorEnum.SideBySideCompare);
    }

    public void _SideBySideCompare() {
        _wEntity(ChangesEntityDescriptorEnum.SideBySideCompare);
    }

    public void Nothing() {
        wEntity(ChangesEntityDescriptorEnum.Nothing);
    }

    public void Nothing_() {
        wEntity_(ChangesEntityDescriptorEnum.Nothing);
    }

    public void _Nothing() {
        _wEntity(ChangesEntityDescriptorEnum.Nothing);
    }

    public void Changes() {
        wEntity(ChangesEntityDescriptorEnum.Changes);
    }

    public void Changes_() {
        wEntity_(ChangesEntityDescriptorEnum.Changes);
    }

    public void Changes_(int initialCapacity) {
        wEntity_(ChangesEntityDescriptorEnum.Changes, initialCapacity);
    }

    public void _Changes() {
        _wEntity(ChangesEntityDescriptorEnum.Changes);
    }

    public void Relate() {
        wEntity(ChangesEntityDescriptorEnum.Relate);
    }

    public void Relate_() {
        wEntity_(ChangesEntityDescriptorEnum.Relate);
    }

    public void _Relate() {
        _wEntity(ChangesEntityDescriptorEnum.Relate);
    }

    public void Cut() {
        wEntity(ChangesEntityDescriptorEnum.Cut);
    }

    public void Cut_() {
        wEntity_(ChangesEntityDescriptorEnum.Cut);
    }

    public void _Cut() {
        _wEntity(ChangesEntityDescriptorEnum.Cut);
    }

    public void Copy() {
        wEntity(ChangesEntityDescriptorEnum.Copy);
    }

    public void Copy_() {
        wEntity_(ChangesEntityDescriptorEnum.Copy);
    }

    public void _Copy() {
        _wEntity(ChangesEntityDescriptorEnum.Copy);
    }

    public void Paste() {
        wEntity(ChangesEntityDescriptorEnum.Paste);
    }

    public void Paste_() {
        wEntity_(ChangesEntityDescriptorEnum.Paste);
    }

    public void _Paste() {
        _wEntity(ChangesEntityDescriptorEnum.Paste);
    }

    public void Delete() {
        wEntity(ChangesEntityDescriptorEnum.Delete);
    }

    public void Delete_() {
        wEntity_(ChangesEntityDescriptorEnum.Delete);
    }

    public void _Delete() {
        _wEntity(ChangesEntityDescriptorEnum.Delete);
    }

    public void Insert() {
        wEntity(ChangesEntityDescriptorEnum.Insert);
    }

    public void Insert_() {
        wEntity_(ChangesEntityDescriptorEnum.Insert);
    }

    public void _Insert() {
        _wEntity(ChangesEntityDescriptorEnum.Insert);
    }

    public void Replace() {
        wEntity(ChangesEntityDescriptorEnum.Replace);
    }

    public void Replace_() {
        wEntity_(ChangesEntityDescriptorEnum.Replace);
    }

    public void _Replace() {
        _wEntity(ChangesEntityDescriptorEnum.Replace);
    }

    public void Wrap() {
        wEntity(ChangesEntityDescriptorEnum.Wrap);
    }

    public void Wrap_() {
        wEntity_(ChangesEntityDescriptorEnum.Wrap);
    }

    public void _Wrap() {
        _wEntity(ChangesEntityDescriptorEnum.Wrap);
    }

    public void Comment() {
        wEntity(ChangesEntityDescriptorEnum.Comment);
    }

    public void Comment_() {
        wEntity_(ChangesEntityDescriptorEnum.Comment);
    }

    public void _Comment() {
        _wEntity(ChangesEntityDescriptorEnum.Comment);
    }

    public void Text() {
        wEntity(ChangesEntityDescriptorEnum.Text);
    }

    public void Text(String value) {
        wEntity(ChangesEntityDescriptorEnum.Text, value);
    }

    public void Clipboard() {
        wEntity(ChangesEntityDescriptorEnum.Clipboard);
    }

    public void Clipboard(int value) {
        wEntity(ChangesEntityDescriptorEnum.Clipboard, value);
    }
}
