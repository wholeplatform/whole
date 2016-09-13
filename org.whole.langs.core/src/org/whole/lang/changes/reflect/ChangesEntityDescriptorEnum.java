package org.whole.lang.changes.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.model.*;

/**
 *  @generator  Whole
 */
@SuppressWarnings("unchecked")
public class ChangesEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int RevisionFrame_ord = 0;
    public static final int RevisionTrack_ord = 1;
    public static final int Revisions_ord = 2;
    public static final int Revision_ord = 3;
    public static final int RevisionChanges_ord = 4;
    public static final int RevisionChange_ord = 5;
    public static final int ChangeSides_ord = 6;
    public static final int ChangeRevisions_ord = 7;
    public static final int ContentCompare_ord = 8;
    public static final int UnifiedCompare_ord = 9;
    public static final int SideBySideCompare_ord = 10;
    public static final int Content_ord = 11;
    public static final int Nothing_ord = 12;
    public static final int ChangeSide_ord = 13;
    public static final int Change_ord = 14;
    public static final int Changes_ord = 15;
    public static final int Relate_ord = 16;
    public static final int Cut_ord = 17;
    public static final int Copy_ord = 18;
    public static final int Paste_ord = 19;
    public static final int Delete_ord = 20;
    public static final int Insert_ord = 21;
    public static final int Replace_ord = 22;
    public static final int Wrap_ord = 23;
    public static final int Comment_ord = 24;
    public static final int Revisor_ord = 25;
    public static final int Text_ord = 26;
    public static final int Clipboard_ord = 27;
    public static final ChangesEntityDescriptorEnum instance = new ChangesEntityDescriptorEnum();
    public static final EntityDescriptor<RevisionFrame> RevisionFrame = (EntityDescriptor<RevisionFrame>) instance.valueOf(RevisionFrame_ord);
    public static final EntityDescriptor<RevisionTrack> RevisionTrack = (EntityDescriptor<RevisionTrack>) instance.valueOf(RevisionTrack_ord);
    public static final EntityDescriptor<Revisions> Revisions = (EntityDescriptor<Revisions>) instance.valueOf(Revisions_ord);
    public static final EntityDescriptor<Revision> Revision = (EntityDescriptor<Revision>) instance.valueOf(Revision_ord);
    public static final EntityDescriptor<RevisionChanges> RevisionChanges = (EntityDescriptor<RevisionChanges>) instance.valueOf(RevisionChanges_ord);
    public static final EntityDescriptor<RevisionChange> RevisionChange = (EntityDescriptor<RevisionChange>) instance.valueOf(RevisionChange_ord);
    public static final EntityDescriptor<ChangeSides> ChangeSides = (EntityDescriptor<ChangeSides>) instance.valueOf(ChangeSides_ord);
    public static final EntityDescriptor<ChangeRevisions> ChangeRevisions = (EntityDescriptor<ChangeRevisions>) instance.valueOf(ChangeRevisions_ord);
    public static final EntityDescriptor<ContentCompare> ContentCompare = (EntityDescriptor<ContentCompare>) instance.valueOf(ContentCompare_ord);
    public static final EntityDescriptor<UnifiedCompare> UnifiedCompare = (EntityDescriptor<UnifiedCompare>) instance.valueOf(UnifiedCompare_ord);
    public static final EntityDescriptor<SideBySideCompare> SideBySideCompare = (EntityDescriptor<SideBySideCompare>) instance.valueOf(SideBySideCompare_ord);
    public static final EntityDescriptor<Content> Content = (EntityDescriptor<Content>) instance.valueOf(Content_ord);
    public static final EntityDescriptor<Nothing> Nothing = (EntityDescriptor<Nothing>) instance.valueOf(Nothing_ord);
    public static final EntityDescriptor<ChangeSide> ChangeSide = (EntityDescriptor<ChangeSide>) instance.valueOf(ChangeSide_ord);
    public static final EntityDescriptor<Change> Change = (EntityDescriptor<Change>) instance.valueOf(Change_ord);
    public static final EntityDescriptor<Changes> Changes = (EntityDescriptor<Changes>) instance.valueOf(Changes_ord);
    public static final EntityDescriptor<Relate> Relate = (EntityDescriptor<Relate>) instance.valueOf(Relate_ord);
    public static final EntityDescriptor<Cut> Cut = (EntityDescriptor<Cut>) instance.valueOf(Cut_ord);
    public static final EntityDescriptor<Copy> Copy = (EntityDescriptor<Copy>) instance.valueOf(Copy_ord);
    public static final EntityDescriptor<Paste> Paste = (EntityDescriptor<Paste>) instance.valueOf(Paste_ord);
    public static final EntityDescriptor<Delete> Delete = (EntityDescriptor<Delete>) instance.valueOf(Delete_ord);
    public static final EntityDescriptor<Insert> Insert = (EntityDescriptor<Insert>) instance.valueOf(Insert_ord);
    public static final EntityDescriptor<Replace> Replace = (EntityDescriptor<Replace>) instance.valueOf(Replace_ord);
    public static final EntityDescriptor<Wrap> Wrap = (EntityDescriptor<Wrap>) instance.valueOf(Wrap_ord);
    public static final EntityDescriptor<Comment> Comment = (EntityDescriptor<Comment>) instance.valueOf(Comment_ord);
    public static final EntityDescriptor<Revisor> Revisor = (EntityDescriptor<Revisor>) instance.valueOf(Revisor_ord);
    public static final EntityDescriptor<Text> Text = (EntityDescriptor<Text>) instance.valueOf(Text_ord);
    public static final EntityDescriptor<Clipboard> Clipboard = (EntityDescriptor<Clipboard>) instance.valueOf(Clipboard_ord);

    private ChangesEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(RevisionFrame_ord, "RevisionFrame", RevisionFrame.class, false).withFeature(ChangesFeatureDescriptorEnum.baseRevisions, Revisions_ord, true, false, false, false, false).withFeature(ChangesFeatureDescriptorEnum.leftRevisions, Revisions_ord, true, false, false, false, false).withFeature(ChangesFeatureDescriptorEnum.rightRevisions, Revisions_ord, true, false, false, false, false).withFeature(ChangesFeatureDescriptorEnum.baseContent, Content_ord).withFeature(ChangesFeatureDescriptorEnum.leftContent, Content_ord, true, false, false, false, false).withFeature(ChangesFeatureDescriptorEnum.rightContent, Content_ord, true, false, false, false, false);
        putSimpleEntity(RevisionTrack_ord, "RevisionTrack", RevisionTrack.class, false).withFeature(ChangesFeatureDescriptorEnum.revisions, Revisions_ord).withFeature(ChangesFeatureDescriptorEnum.compare, ContentCompare_ord);
        putCompositeEntity(
		Revisions_ord, "Revisions", Revisions.class, false, Revision_ord, true, false);
        putSimpleEntity(Revision_ord, "Revision", Revision.class, false).withFeature(ChangesFeatureDescriptorEnum.revisor, Revisor_ord, true, false, false, false, false).withFeature(ChangesFeatureDescriptorEnum.changes, RevisionChanges_ord);
        putCompositeEntity(
		RevisionChanges_ord, "RevisionChanges", RevisionChanges.class, false, RevisionChange_ord, true, false);
        putSimpleEntity(RevisionChange_ord, "RevisionChange", RevisionChange.class, false).withFeature(ChangesFeatureDescriptorEnum.sides, ChangeSides_ord, ChangesFeatureDescriptorEnum.revisions, false, false, true, false, false);
        putCompositeEntity(ChangeSides_ord, "ChangeSides", ChangeSides.class, true, ChangeSide_ord, false, true, true, false, false);
        putCompositeEntity(ChangeRevisions_ord, "ChangeRevisions", ChangeRevisions.class, true, RevisionChange_ord, false, true, true, false, false);
        putSimpleEntity(ContentCompare_ord, "ContentCompare", ContentCompare.class, true, UnifiedCompare_ord, SideBySideCompare_ord);
        putSimpleEntity(UnifiedCompare_ord, "UnifiedCompare", UnifiedCompare.class, false).withFeature(ChangesFeatureDescriptorEnum.unifiedContent, Content_ord);
        putSimpleEntity(SideBySideCompare_ord, "SideBySideCompare", SideBySideCompare.class, false).withFeature(ChangesFeatureDescriptorEnum.baseContent, Content_ord, true, false, false, false, false).withFeature(ChangesFeatureDescriptorEnum.firstRevisedContent, Content_ord).withFeature(ChangesFeatureDescriptorEnum.secondRevisedContent, Content_ord);
        putSimpleEntity(Content_ord, "Content", Content.class, true, Changes_ord, Delete_ord, Replace_ord, Comment_ord, Cut_ord, Wrap_ord, Copy_ord, Paste_ord, Relate_ord, Change_ord, Insert_ord, Nothing_ord);
        putSimpleEntity(Nothing_ord, "Nothing", Nothing.class, false);
        putSimpleEntity(ChangeSide_ord, "ChangeSide", ChangeSide.class, true, Delete_ord, Replace_ord, Comment_ord, Cut_ord, Wrap_ord, Copy_ord, Relate_ord, Paste_ord, Insert_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Change_ord, "Change", Change.class, true, Changes_ord, Delete_ord, Replace_ord, Comment_ord, Cut_ord, Wrap_ord, Copy_ord, Relate_ord, Paste_ord, Insert_ord);
        putCompositeEntity(
		Changes_ord, "Changes", Changes.class, false, Change_ord, true, false);
        putSimpleEntity(Relate_ord, "Relate", Relate.class, false).withFeature(ChangesFeatureDescriptorEnum.content, Content_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Cut_ord, "Cut", Cut.class, false).withFeature(ChangesFeatureDescriptorEnum.content, Content_ord).withFeature(ChangesFeatureDescriptorEnum.clipboard, Clipboard_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Copy_ord, "Copy", Copy.class, false).withFeature(ChangesFeatureDescriptorEnum.content, Content_ord).withFeature(ChangesFeatureDescriptorEnum.clipboard, Clipboard_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Paste_ord, "Paste", Paste.class, false).withFeature(ChangesFeatureDescriptorEnum.content, Content_ord).withFeature(ChangesFeatureDescriptorEnum.clipboard, Clipboard_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Delete_ord, "Delete", Delete.class, false).withFeature(ChangesFeatureDescriptorEnum.content, Content_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Insert_ord, "Insert", Insert.class, false).withFeature(ChangesFeatureDescriptorEnum.content, Content_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Replace_ord, "Replace", Replace.class, false).withFeature(ChangesFeatureDescriptorEnum.deleteContent, Content_ord).withFeature(ChangesFeatureDescriptorEnum.insertContent, Content_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Wrap_ord, "Wrap", Wrap.class, false).withFeature(ChangesFeatureDescriptorEnum.cutContent, Content_ord).withFeature(ChangesFeatureDescriptorEnum.insertContent, Content_ord).withFeature(ChangesFeatureDescriptorEnum.clipboard, Clipboard_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Comment_ord, "Comment", Comment.class, false).withFeature(ChangesFeatureDescriptorEnum.comment, Text_ord).withFeature(ChangesFeatureDescriptorEnum.content, Content_ord).withFeature(ChangesFeatureDescriptorEnum.revisions, ChangeRevisions_ord, ChangesFeatureDescriptorEnum.sides, true, false, true, false, false);
        putSimpleEntity(Revisor_ord, "Revisor", Revisor.class, true, Text_ord);
        putDataEntity(Text_ord, "Text", Text.class, false, String.class);
        putDataEntity(Clipboard_ord, "Clipboard", Clipboard.class, false, int.class);
    }

    protected void initForeignTypeRelations() {
        setAssignableToAll(true, Change_ord, Nothing_ord);
        setAssignableFromAll(true, Content_ord);
    }
}
