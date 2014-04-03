package org.whole.lang.changes.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ChangesModelContext extends EntityContext {

    public ChangesModelContext(IEntity root) {
        super(root);
    }

    public ChangesModelContext getBaseRevisions() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.baseRevisions);
    }

    public void setBaseRevisions(ChangesModelContext baseRevisions) {
        wSet(ChangesFeatureDescriptorEnum.baseRevisions, baseRevisions);
    }

    public ChangesModelContext getLeftRevisions() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.leftRevisions);
    }

    public void setLeftRevisions(ChangesModelContext leftRevisions) {
        wSet(ChangesFeatureDescriptorEnum.leftRevisions, leftRevisions);
    }

    public ChangesModelContext getRightRevisions() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.rightRevisions);
    }

    public void setRightRevisions(ChangesModelContext rightRevisions) {
        wSet(ChangesFeatureDescriptorEnum.rightRevisions, rightRevisions);
    }

    public ChangesModelContext getBaseContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.baseContent);
    }

    public void setBaseContent(ChangesModelContext baseContent) {
        wSet(ChangesFeatureDescriptorEnum.baseContent, baseContent);
    }

    public ChangesModelContext getLeftContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.leftContent);
    }

    public void setLeftContent(ChangesModelContext leftContent) {
        wSet(ChangesFeatureDescriptorEnum.leftContent, leftContent);
    }

    public ChangesModelContext getRightContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.rightContent);
    }

    public void setRightContent(ChangesModelContext rightContent) {
        wSet(ChangesFeatureDescriptorEnum.rightContent, rightContent);
    }

    public ChangesModelContext getRevisions() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.revisions);
    }

    public void setRevisions(ChangesModelContext revisions) {
        wSet(ChangesFeatureDescriptorEnum.revisions, revisions);
    }

    public ChangesModelContext getCompare() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.compare);
    }

    public void setCompare(ChangesModelContext compare) {
        wSet(ChangesFeatureDescriptorEnum.compare, compare);
    }

    public ChangesModelContext getRevisor() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.revisor);
    }

    public void setRevisor(ChangesModelContext revisor) {
        wSet(ChangesFeatureDescriptorEnum.revisor, revisor);
    }

    public ChangesModelContext getChanges() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.changes);
    }

    public void setChanges(ChangesModelContext changes) {
        wSet(ChangesFeatureDescriptorEnum.changes, changes);
    }

    public ChangesModelContext getSides() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.sides);
    }

    public void setSides(ChangesModelContext sides) {
        wSet(ChangesFeatureDescriptorEnum.sides, sides);
    }

    public ChangesModelContext getUnifiedContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.unifiedContent);
    }

    public void setUnifiedContent(ChangesModelContext unifiedContent) {
        wSet(ChangesFeatureDescriptorEnum.unifiedContent, unifiedContent);
    }

    public ChangesModelContext getFirstRevisedContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.firstRevisedContent);
    }

    public void setFirstRevisedContent(ChangesModelContext firstRevisedContent) {
        wSet(ChangesFeatureDescriptorEnum.firstRevisedContent, firstRevisedContent);
    }

    public ChangesModelContext getSecondRevisedContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.secondRevisedContent);
    }

    public void setSecondRevisedContent(ChangesModelContext secondRevisedContent) {
        wSet(ChangesFeatureDescriptorEnum.secondRevisedContent, secondRevisedContent);
    }

    public ChangesModelContext getContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.content);
    }

    public void setContent(ChangesModelContext content) {
        wSet(ChangesFeatureDescriptorEnum.content, content);
    }

    public ChangesModelContext getClipboard() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.clipboard);
    }

    public void setClipboard(ChangesModelContext clipboard) {
        wSet(ChangesFeatureDescriptorEnum.clipboard, clipboard);
    }

    public ChangesModelContext getDeleteContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.deleteContent);
    }

    public void setDeleteContent(ChangesModelContext deleteContent) {
        wSet(ChangesFeatureDescriptorEnum.deleteContent, deleteContent);
    }

    public ChangesModelContext getInsertContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.insertContent);
    }

    public void setInsertContent(ChangesModelContext insertContent) {
        wSet(ChangesFeatureDescriptorEnum.insertContent, insertContent);
    }

    public ChangesModelContext getCutContent() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.cutContent);
    }

    public void setCutContent(ChangesModelContext cutContent) {
        wSet(ChangesFeatureDescriptorEnum.cutContent, cutContent);
    }

    public ChangesModelContext getComment() {
        return (ChangesModelContext) wGet(ChangesFeatureDescriptorEnum.comment);
    }

    public void setComment(ChangesModelContext comment) {
        wSet(ChangesFeatureDescriptorEnum.comment, comment);
    }
}
