package org.whole.lang.changes.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator  Whole
 */
public class ChangesFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int baseRevisions_ord = 0;
    public static final int leftRevisions_ord = 1;
    public static final int rightRevisions_ord = 2;
    public static final int baseContent_ord = 3;
    public static final int leftContent_ord = 4;
    public static final int rightContent_ord = 5;
    public static final int revisions_ord = 6;
    public static final int compare_ord = 7;
    public static final int revisor_ord = 8;
    public static final int changes_ord = 9;
    public static final int sides_ord = 10;
    public static final int unifiedContent_ord = 11;
    public static final int firstRevisedContent_ord = 12;
    public static final int secondRevisedContent_ord = 13;
    public static final int content_ord = 14;
    public static final int clipboard_ord = 15;
    public static final int deleteContent_ord = 16;
    public static final int insertContent_ord = 17;
    public static final int cutContent_ord = 18;
    public static final int comment_ord = 19;
    public static final ChangesFeatureDescriptorEnum instance = new ChangesFeatureDescriptorEnum();
    public static final FeatureDescriptor baseRevisions = instance.valueOf(baseRevisions_ord);
    public static final FeatureDescriptor leftRevisions = instance.valueOf(leftRevisions_ord);
    public static final FeatureDescriptor rightRevisions = instance.valueOf(rightRevisions_ord);
    public static final FeatureDescriptor baseContent = instance.valueOf(baseContent_ord);
    public static final FeatureDescriptor leftContent = instance.valueOf(leftContent_ord);
    public static final FeatureDescriptor rightContent = instance.valueOf(rightContent_ord);
    public static final FeatureDescriptor revisions = instance.valueOf(revisions_ord);
    public static final FeatureDescriptor compare = instance.valueOf(compare_ord);
    public static final FeatureDescriptor revisor = instance.valueOf(revisor_ord);
    public static final FeatureDescriptor changes = instance.valueOf(changes_ord);
    public static final FeatureDescriptor sides = instance.valueOf(sides_ord);
    public static final FeatureDescriptor unifiedContent = instance.valueOf(unifiedContent_ord);
    public static final FeatureDescriptor firstRevisedContent = instance.valueOf(firstRevisedContent_ord);
    public static final FeatureDescriptor secondRevisedContent = instance.valueOf(secondRevisedContent_ord);
    public static final FeatureDescriptor content = instance.valueOf(content_ord);
    public static final FeatureDescriptor clipboard = instance.valueOf(clipboard_ord);
    public static final FeatureDescriptor deleteContent = instance.valueOf(deleteContent_ord);
    public static final FeatureDescriptor insertContent = instance.valueOf(insertContent_ord);
    public static final FeatureDescriptor cutContent = instance.valueOf(cutContent_ord);
    public static final FeatureDescriptor comment = instance.valueOf(comment_ord);

    private ChangesFeatureDescriptorEnum() {
        putFeatureDescriptor(baseRevisions_ord, "baseRevisions");
        putFeatureDescriptor(leftRevisions_ord, "leftRevisions");
        putFeatureDescriptor(rightRevisions_ord, "rightRevisions");
        putFeatureDescriptor(baseContent_ord, "baseContent");
        putFeatureDescriptor(leftContent_ord, "leftContent");
        putFeatureDescriptor(rightContent_ord, "rightContent");
        putFeatureDescriptor(revisions_ord, "revisions");
        putFeatureDescriptor(compare_ord, "compare");
        putFeatureDescriptor(revisor_ord, "revisor");
        putFeatureDescriptor(changes_ord, "changes");
        putFeatureDescriptor(sides_ord, "sides");
        putFeatureDescriptor(unifiedContent_ord, "unifiedContent");
        putFeatureDescriptor(firstRevisedContent_ord, "firstRevisedContent");
        putFeatureDescriptor(secondRevisedContent_ord, "secondRevisedContent");
        putFeatureDescriptor(content_ord, "content");
        putFeatureDescriptor(clipboard_ord, "clipboard");
        putFeatureDescriptor(deleteContent_ord, "deleteContent");
        putFeatureDescriptor(insertContent_ord, "insertContent");
        putFeatureDescriptor(cutContent_ord, "cutContent");
        putFeatureDescriptor(comment_ord, "comment");
    }
    private static final long serialVersionUID = 1;
}
