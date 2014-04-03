package org.whole.lang.changes.model.impl;


/**
 *  @generator  Whole
 */
public class ChangesStrictImplEntityRegistry extends ChangesImplEntityRegistry {

    protected void createPrototypes() {
        super.createPrototypes();
        put(new ChangeSidesStrictImpl());
        put(new ChangeRevisionsStrictImpl());
    }
}
