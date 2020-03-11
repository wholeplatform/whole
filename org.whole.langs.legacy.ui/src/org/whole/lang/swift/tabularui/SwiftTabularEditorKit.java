package org.whole.lang.swift.tabularui;

import org.whole.lang.swift.reflect.SwiftLanguageKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.editor.AbstractEditorKit;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.swift.tabularui.editparts.SwiftTabularPartFactoryVisitor;

public class SwiftTabularEditorKit extends AbstractEditorKit {
    private static final long serialVersionUID = 1;
    public static final String ID = SwiftTabularEditorKit.class.getName();

    public String getId() {
        return ID;
    }

    public String getName() {
        return "Swift Tabular";
    }

    public int getDefaultLevel() {
        return 5;
    }

    public IEditPartFactory getPartFactory() {
        return new SwiftTabularPartFactoryVisitor();
    }

    public boolean canApply(ILanguageKit languageKit) {
        return languageKit.getURI().equals(SwiftLanguageKit.URI) && isStaticAndCurrent(languageKit);
    }
}
