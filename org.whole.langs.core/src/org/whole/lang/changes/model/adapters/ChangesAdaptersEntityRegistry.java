package org.whole.lang.changes.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ChangesAdaptersEntityRegistry extends AbstractEntityRegistry {

    public ChangesAdaptersEntityRegistry() {
        super(ChangesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new RevisionFrameAdapter());
        put(new RevisionTrackAdapter());
        put(new RevisionsAdapter());
        put(new RevisionAdapter());
        put(new RevisionChangesAdapter());
        put(new RevisionChangeAdapter());
        put(new ChangeSidesAdapter());
        put(new ChangeRevisionsAdapter());
        put(new ContentCompareAdapter());
        put(new UnifiedCompareAdapter());
        put(new SideBySideCompareAdapter());
        put(new ContentAdapter());
        put(new NothingAdapter());
        put(new ChangeSideAdapter());
        put(new ChangeAdapter());
        put(new ChangesAdapter());
        put(new RelateAdapter());
        put(new CutAdapter());
        put(new CopyAdapter());
        put(new PasteAdapter());
        put(new DeleteAdapter());
        put(new InsertAdapter());
        put(new ReplaceAdapter());
        put(new WrapAdapter());
        put(new CommentAdapter());
        put(new RevisorAdapter());
        put(new TextAdapter());
        put(new ClipboardAdapter());
    }
}
