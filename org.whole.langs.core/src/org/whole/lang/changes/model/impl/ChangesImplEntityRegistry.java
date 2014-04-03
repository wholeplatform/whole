package org.whole.lang.changes.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ChangesImplEntityRegistry extends AbstractEntityRegistry {

    public ChangesImplEntityRegistry() {
        super(ChangesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new RevisionFrameImpl());
        put(new RevisionTrackImpl());
        put(new RevisionsImpl());
        put(new RevisionImpl());
        put(new RevisionChangesImpl());
        put(new RevisionChangeImpl());
        put(new ChangeSidesImpl());
        put(new ChangeRevisionsImpl());
        put(new UnifiedCompareImpl());
        put(new SideBySideCompareImpl());
        put(new NothingImpl());
        put(new ChangesImpl());
        put(new RelateImpl());
        put(new CutImpl());
        put(new CopyImpl());
        put(new PasteImpl());
        put(new DeleteImpl());
        put(new InsertImpl());
        put(new ReplaceImpl());
        put(new WrapImpl());
        put(new CommentImpl());
        put(new TextImpl());
        put(new ClipboardImpl());
    }
}
