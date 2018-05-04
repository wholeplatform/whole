package org.whole.lang.xml.builders;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class XmlNormalizerBuilderTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final XmlNormalizerBuilderTemplateManager instance = new XmlNormalizerBuilderTemplateManager();
    }

    public static XmlNormalizerBuilderTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private XmlNormalizerBuilderTemplateManager() {
        put("findNestedContent", newfindNestedContent());
        put("findMissingContentEntities", newfindMissingContentEntities());
        put("findConsecutiveCharDataOrCDataSect", newfindConsecutiveCharDataOrCDataSect());
    }

    public ITemplateFactory<IEntity> newfindNestedContent() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(1);
                b0.Filter_();
                b0.DescendantStep();
                b0.And_(2);
                b0.TypeTest("Content");
                b0.Some_();
                b0.Filter_();
                b0.ParentStep();
                b0.TypeTest("Content");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindMissingContentEntities() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("element");
                b0.Filter_();
                b0.DescendantStep();
                b0.And_(2);
                b0.And_(2);
                b0.And_(2);
                b0.Not_();
                b0.KindTest("RESOLVER");
                b0._Not();
                b0.SubtypeTest("IContent");
                b0._And();
                b0.Not_();
                b0.TypeTest("Content");
                b0._Not();
                b0._And();
                b0.Some_();
                b0.Filter_();
                b0.ParentStep();
                b0.Not_();
                b0.TypeTest("Content");
                b0._Not();
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindConsecutiveCharDataOrCDataSect() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(1);
                b0.Filter_();
                b0.DescendantStep();
                b0.Or_(2);
                b0.And_(2);
                b0.TypeTest("CharData");
                b0.Some_();
                b0.Filter_();
                b0.FollowingSiblingStep();
                b0.And_(2);
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0.TypeTest("CharData");
                b0._And();
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0.And_(2);
                b0.TypeTest("CDataSect");
                b0.Some_();
                b0.Filter_();
                b0.FollowingSiblingStep();
                b0.And_(2);
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0.TypeTest("CDataSect");
                b0._And();
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Or();
                b0._Filter();
                b0._Path();
            }
        };
    }
}
