package org.whole.lang.changes.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.changes.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ChangesEntityFactory extends GenericEntityFactory {
    public static final ChangesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static ChangesEntityFactory instance(IEntityRegistryProvider provider) {
        return new ChangesEntityFactory(provider);
    }

    protected ChangesEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public RevisionFrame createRevisionFrame() {
        return create(ChangesEntityDescriptorEnum.RevisionFrame);
    }

    public RevisionFrame createRevisionFrame(Revisions baseRevisions, Revisions leftRevisions, Revisions rightRevisions, Content baseContent, Content leftContent, Content rightContent) {
        return create(ChangesEntityDescriptorEnum.RevisionFrame, baseRevisions, leftRevisions, rightRevisions, baseContent, leftContent, rightContent);
    }

    public IEntityBuilder<RevisionFrame> buildRevisionFrame() {
        return new EntityBuilder<RevisionFrame>(create(ChangesEntityDescriptorEnum.RevisionFrame));
    }

    public RevisionTrack createRevisionTrack() {
        return create(ChangesEntityDescriptorEnum.RevisionTrack);
    }

    public RevisionTrack createRevisionTrack(Revisions revisions, ContentCompare compare) {
        return create(ChangesEntityDescriptorEnum.RevisionTrack, revisions, compare);
    }

    public IEntityBuilder<RevisionTrack> buildRevisionTrack() {
        return new EntityBuilder<RevisionTrack>(create(ChangesEntityDescriptorEnum.RevisionTrack));
    }

    public Revisions createRevisions() {
        return create(ChangesEntityDescriptorEnum.Revisions);
    }

    public Revisions createRevisions(Revision... entities) {
        return create(ChangesEntityDescriptorEnum.Revisions, (IEntity[]) entities);
    }

    public Revisions createRevisions(int initialSize) {
        return clone(ChangesEntityDescriptorEnum.Revisions, initialSize);
    }

    public Revision createRevision() {
        return create(ChangesEntityDescriptorEnum.Revision);
    }

    public Revision createRevision(Revisor revisor, RevisionChanges changes) {
        return create(ChangesEntityDescriptorEnum.Revision, revisor, changes);
    }

    public IEntityBuilder<Revision> buildRevision() {
        return new EntityBuilder<Revision>(create(ChangesEntityDescriptorEnum.Revision));
    }

    public RevisionChanges createRevisionChanges() {
        return create(ChangesEntityDescriptorEnum.RevisionChanges);
    }

    public RevisionChanges createRevisionChanges(RevisionChange... entities) {
        return create(ChangesEntityDescriptorEnum.RevisionChanges, (IEntity[]) entities);
    }

    public RevisionChanges createRevisionChanges(int initialSize) {
        return clone(ChangesEntityDescriptorEnum.RevisionChanges, initialSize);
    }

    public RevisionChange createRevisionChange() {
        return create(ChangesEntityDescriptorEnum.RevisionChange);
    }

    public RevisionChange createRevisionChange(ChangeSides sides) {
        return create(ChangesEntityDescriptorEnum.RevisionChange, sides);
    }

    public ChangeSides createChangeSides() {
        return create(ChangesEntityDescriptorEnum.ChangeSides);
    }

    public ChangeSides createChangeSides(ChangeSide... entities) {
        return create(ChangesEntityDescriptorEnum.ChangeSides, (IEntity[]) entities);
    }

    public ChangeSides createChangeSides(int initialSize) {
        return clone(ChangesEntityDescriptorEnum.ChangeSides, initialSize);
    }

    public ChangeRevisions createChangeRevisions() {
        return create(ChangesEntityDescriptorEnum.ChangeRevisions);
    }

    public ChangeRevisions createChangeRevisions(RevisionChange... entities) {
        return create(ChangesEntityDescriptorEnum.ChangeRevisions, (IEntity[]) entities);
    }

    public ChangeRevisions createChangeRevisions(int initialSize) {
        return clone(ChangesEntityDescriptorEnum.ChangeRevisions, initialSize);
    }

    public UnifiedCompare createUnifiedCompare() {
        return create(ChangesEntityDescriptorEnum.UnifiedCompare);
    }

    public UnifiedCompare createUnifiedCompare(Content unifiedContent) {
        return create(ChangesEntityDescriptorEnum.UnifiedCompare, unifiedContent);
    }

    public SideBySideCompare createSideBySideCompare() {
        return create(ChangesEntityDescriptorEnum.SideBySideCompare);
    }

    public SideBySideCompare createSideBySideCompare(Content baseContent, Content firstRevisedContent, Content secondRevisedContent) {
        return create(ChangesEntityDescriptorEnum.SideBySideCompare, baseContent, firstRevisedContent, secondRevisedContent);
    }

    public IEntityBuilder<SideBySideCompare> buildSideBySideCompare() {
        return new EntityBuilder<SideBySideCompare>(create(ChangesEntityDescriptorEnum.SideBySideCompare));
    }

    public Nothing createNothing() {
        return create(ChangesEntityDescriptorEnum.Nothing);
    }

    public Changes createChanges() {
        return create(ChangesEntityDescriptorEnum.Changes);
    }

    public Changes createChanges(Change... entities) {
        return create(ChangesEntityDescriptorEnum.Changes, (IEntity[]) entities);
    }

    public Changes createChanges(int initialSize) {
        return clone(ChangesEntityDescriptorEnum.Changes, initialSize);
    }

    public Relate createRelate() {
        return create(ChangesEntityDescriptorEnum.Relate);
    }

    public Relate createRelate(Content content, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Relate, content, revisions);
    }

    public IEntityBuilder<Relate> buildRelate() {
        return new EntityBuilder<Relate>(create(ChangesEntityDescriptorEnum.Relate));
    }

    public Cut createCut() {
        return create(ChangesEntityDescriptorEnum.Cut);
    }

    public Cut createCut(Content content, Clipboard clipboard, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Cut, content, clipboard, revisions);
    }

    public IEntityBuilder<Cut> buildCut() {
        return new EntityBuilder<Cut>(create(ChangesEntityDescriptorEnum.Cut));
    }

    public Copy createCopy() {
        return create(ChangesEntityDescriptorEnum.Copy);
    }

    public Copy createCopy(Content content, Clipboard clipboard, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Copy, content, clipboard, revisions);
    }

    public IEntityBuilder<Copy> buildCopy() {
        return new EntityBuilder<Copy>(create(ChangesEntityDescriptorEnum.Copy));
    }

    public Paste createPaste() {
        return create(ChangesEntityDescriptorEnum.Paste);
    }

    public Paste createPaste(Content content, Clipboard clipboard, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Paste, content, clipboard, revisions);
    }

    public IEntityBuilder<Paste> buildPaste() {
        return new EntityBuilder<Paste>(create(ChangesEntityDescriptorEnum.Paste));
    }

    public Delete createDelete() {
        return create(ChangesEntityDescriptorEnum.Delete);
    }

    public Delete createDelete(Content content, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Delete, content, revisions);
    }

    public IEntityBuilder<Delete> buildDelete() {
        return new EntityBuilder<Delete>(create(ChangesEntityDescriptorEnum.Delete));
    }

    public Insert createInsert() {
        return create(ChangesEntityDescriptorEnum.Insert);
    }

    public Insert createInsert(Content content, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Insert, content, revisions);
    }

    public IEntityBuilder<Insert> buildInsert() {
        return new EntityBuilder<Insert>(create(ChangesEntityDescriptorEnum.Insert));
    }

    public Replace createReplace() {
        return create(ChangesEntityDescriptorEnum.Replace);
    }

    public Replace createReplace(Content deleteContent, Content insertContent, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Replace, deleteContent, insertContent, revisions);
    }

    public IEntityBuilder<Replace> buildReplace() {
        return new EntityBuilder<Replace>(create(ChangesEntityDescriptorEnum.Replace));
    }

    public Wrap createWrap() {
        return create(ChangesEntityDescriptorEnum.Wrap);
    }

    public Wrap createWrap(Content cutContent, Content insertContent, Clipboard clipboard, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Wrap, cutContent, insertContent, clipboard, revisions);
    }

    public IEntityBuilder<Wrap> buildWrap() {
        return new EntityBuilder<Wrap>(create(ChangesEntityDescriptorEnum.Wrap));
    }

    public Comment createComment() {
        return create(ChangesEntityDescriptorEnum.Comment);
    }

    public Comment createComment(Text comment, Content content, ChangeRevisions revisions) {
        return create(ChangesEntityDescriptorEnum.Comment, comment, content, revisions);
    }

    public IEntityBuilder<Comment> buildComment() {
        return new EntityBuilder<Comment>(create(ChangesEntityDescriptorEnum.Comment));
    }

    public Text createText() {
        return create(ChangesEntityDescriptorEnum.Text);
    }

    public Text createText(String value) {
        return create(ChangesEntityDescriptorEnum.Text, value);
    }

    public Clipboard createClipboard() {
        return create(ChangesEntityDescriptorEnum.Clipboard);
    }

    public Clipboard createClipboard(int value) {
        return create(ChangesEntityDescriptorEnum.Clipboard, value);
    }
}
