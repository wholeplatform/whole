package org.whole.lang.scripts.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.scripts.model.Script;
import org.whole.lang.templates.AbstractTemplateFactory;

public class EmbeddedJS extends AbstractTemplateFactory<Script> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.scripts.builders.IScriptsBuilder b0 = (org.whole.lang.scripts.builders.IScriptsBuilder) op.wGetBuilder(org.whole.lang.scripts.reflect.ScriptsLanguageKit.URI);
        b0.Script_();
        b0.LanguageName("js");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.SameStageFragment_();
        org.whole.lang.text.builders.ITextBuilder b2 = (org.whole.lang.text.builders.ITextBuilder) op.wGetBuilder(org.whole.lang.text.reflect.TextLanguageKit.URI);
        b2.Document_(1);
        b2.Row_(1);
        b2.Text("print(\"Editor file name: \"+editorInputName)");
        b2._Row();
        b2._Document();
        b1._SameStageFragment();
        b0._Script();
    }
}
