package org.whole.lang.unifiedlambdadelta.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class Identity extends AbstractTemplateFactory {


    public void apply(IBuilderOperation op) {
        org.whole.lang.unifiedlambdadelta.builders.IUnifiedLambdaDeltaBuilder b0 = (org.whole.lang.unifiedlambdadelta.builders.IUnifiedLambdaDeltaBuilder) op.wGetBuilder(org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaLanguageKit.URI);
        b0.Definition_();
        b0.Polarity(false);
        b0.Abstraction_();
        b0.Polarity(false);
        b0.Sort_();
        b0.Level(0);
        b0._Sort();
        b0.Local_();
        b0.Index(0);
        b0._Local();
        b0.Name_();
        b0.Access(false);
        b0.Prefix("id");
        b0.Postfix(0);
        b0._Name();
        b0._Abstraction();
        b0.Name_();
        b0.Access(false);
        b0.Prefix("id");
        b0.Postfix(0);
        b0._Name();
        b0.Top();
        b0._Definition();
    }
}
