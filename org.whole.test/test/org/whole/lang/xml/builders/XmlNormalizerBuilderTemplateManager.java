package org.whole.lang.xml.builders;

import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class XmlNormalizerBuilderTemplateManager extends AbstractTemplateManager {

    private static XmlNormalizerBuilderTemplateManager instance;

    public static XmlNormalizerBuilderTemplateManager instance() {
        if (instance == null)
            instance = new XmlNormalizerBuilderTemplateManager();
                return instance;
    }

    private XmlNormalizerBuilderTemplateManager() {
        put("findNestedContent", newFindNestedContent());
        put("findMissingContentEntities", newFindMissingContentEntities());
        put("findConsecutiveCharDataOrCDataSect", newFindConsecutiveCharDataOrCDataSect());
    }

    public ITemplateFactory newFindNestedContent() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(1);
                b0.Filter_();
                b0.DescendantStep();
                b0.And_();
                b0.TypeTest("Content");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.ParentStep();
                b0.TypeTest("Content");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindMissingContentEntities() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("element");
                b0.Filter_();
                b0.DescendantStep();
                b0.And_();
                b0.And_();
                b0.And_();
                b0.Not_();
                b0.KindTest("RESOLVER");
                b0._Not();
                b0.SubtypeTest("IContent");
                b0._And();
                b0.Not_();
                b0.TypeTest("Content");
                b0._Not();
                b0._And();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.ParentStep();
                b0.Not_();
                b0.TypeTest("Content");
                b0._Not();
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindConsecutiveCharDataOrCDataSect() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(1);
                b0.Filter_();
                b0.DescendantStep();
                b0.Or_();
                b0.And_();
                b0.TypeTest("CharData");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FollowingSiblingStep();
                b0.And_();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0.TypeTest("CharData");
                b0._And();
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0.And_();
                b0.TypeTest("CDataSect");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FollowingSiblingStep();
                b0.And_();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0.TypeTest("CDataSect");
                b0._And();
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Or();
                b0._Filter();
                b0._Path();
            }
        };
    }
}
