package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesRelativeIndexesTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesRelativeIndexesTestTemplateManager instance = new QueriesRelativeIndexesTestTemplateManager();
    }

    public static QueriesRelativeIndexesTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesRelativeIndexesTestTemplateManager() {
        put("fragment", newfragment());
        put("fragment1", newfragment1());
        put("fragment2", newfragment2());
        put("fragment3", newfragment3());
        put("fragment4", newfragment4());
        put("fragment5", newfragment5());
        put("fragment6", newfragment6());
        put("fragment7", newfragment7());
        put("fragment8", newfragment8());
        put("fragment9", newfragment9());
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(2);
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(5);
                b3.Integer(0);
                b3.Integer(1);
                b3.Integer(2);
                b3.Integer(3);
                b3.Integer(4);
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(-1);
                b2._IndexTest();
                b2._Filter();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(4);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(2);
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(5);
                b3.Integer(0);
                b3.Integer(1);
                b3.Integer(2);
                b3.Integer(3);
                b3.Integer(4);
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(-2);
                b2._IndexTest();
                b2._Filter();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(3);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(2);
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(5);
                b3.Integer(0);
                b3.Integer(1);
                b3.Integer(2);
                b3.Integer(3);
                b3.Integer(4);
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexRangeTest_();
                b2.IntLiteral(0);
                b0.Resolver();
                b2._IndexRangeTest();
                b2._Filter();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(5);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(0);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2.Integer(4);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(2);
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(5);
                b3.Integer(0);
                b3.Integer(1);
                b3.Integer(2);
                b3.Integer(3);
                b3.Integer(4);
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexRangeTest_();
                b2.IntLiteral(0);
                b2.IntLiteral(-1);
                b2._IndexRangeTest();
                b2._Filter();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(5);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(0);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2.Integer(4);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(2);
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(5);
                b3.Integer(0);
                b3.Integer(1);
                b3.Integer(2);
                b3.Integer(3);
                b3.Integer(4);
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexRangeTest_();
                b2.IntLiteral(0);
                b2.IntLiteral(-2);
                b2._IndexRangeTest();
                b2._Filter();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(4);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(0);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }
}
