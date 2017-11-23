package org.whole.lang.queries.util;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class RewriteQueriesTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final RewriteQueriesTemplateManager instance = new RewriteQueriesTemplateManager();
    }

    public static RewriteQueriesTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private RewriteQueriesTemplateManager() {
        put("delete1", newdelete1());
        put("delete2", newdelete2());
        put("delete3", newdelete3());
        put("update1", newupdate1());
        put("update2", newupdate2());
        put("update3", newupdate3());
        put("update4", newupdate4());
        put("update5", newupdate5());
        put("update6", newupdate6());
        put("update7", newupdate7());
        put("update8", newupdate8());
        put("update9", newupdate9());
        put("update10", newupdate10());
        put("update11", newupdate11());
        put("insert1", newinsert1());
    }

    public ITemplateFactory<IEntity> newdelete1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Delete_();
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0._Path();
                b0._Delete();
            }
        };
    }

    public ITemplateFactory<IEntity> newdelete2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Delete_();
                b0.Path_(2);
                b0.Filter_();
                b0.DescendantStep();
                b0.TypeTest("As");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0._Delete();
            }
        };
    }

    public ITemplateFactory<IEntity> newdelete3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Delete_();
                b0.Path_(2);
                b0.DescendantStep();
                b0.Choose_(2);
                b0.If_();
                b0.TypeTest("As");
                b0.FeatureStep("name");
                b0._If();
                b0.If_();
                b0.TypeTest("Production");
                b0.FeatureStep("template");
                b0._If();
                b0._Choose();
                b0._Path();
                b0._Delete();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.PointwiseUpdate_();
                b0.Sequence_(2);
                b0.FeatureStep("name");
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.Sequence_(2);
                b0.FeatureStep("name");
                b0.FeatureStep("dataType");
                b0._Sequence();
                b0._Path();
                b0._Sequence();
                b0.Sequence_(4);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.SimpleName("MyModelName");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.SimpleName("MyFirstName");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.DataType("MyFirstDataType");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.SimpleName("MySecondName");
                b1._StageUpFragment();
                b0._Sequence();
                b0._PointwiseUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.Sequence_(1);
                b0.PointwiseUpdate_();
                b0.Sequence_(2);
                b0.FeatureStep("name");
                b0.FeatureStep("dataType");
                b0._Sequence();
                b0.Sequence_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.SimpleName("MyDataEntityName");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.DataType("MyDataType");
                b1._StageUpFragment();
                b0._Sequence();
                b0._PointwiseUpdate();
                b0._Sequence();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.PointwiseUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0._PointwiseUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.PointwiseUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0.Delete_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0._Delete();
                b0._PointwiseUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.PointwiseUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0.PointwiseUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("CompositeEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0._PointwiseUpdate();
                b0._PointwiseUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.CartesianUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.SimpleName("DataEntityName");
                b1._StageUpFragment();
                b0._CartesianUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.CartesianUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0.StringLiteral("DataEntityName");
                b0._CartesianUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0._Path();
                b0.Select_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.DataEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleName");
                b1.VarName("newName");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Types");
                b1.VarName("types");
                b1.Quantifier("!");
                b1._Variable();
                b2.DataType("Object");
                b2._DataEntity();
                b1._StageUpFragment();
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("DataEntity");
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("oldName");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("types");
                b0.VariableTest("types");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
                b0.Filter_();
                b1.SameStageFragment_();
                org.whole.lang.java.builders.IJavaBuilder b3 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b3.InfixExpression_();
                b3.StringLiteral("My");
                b3.InfixOperator("+");
                b3.SimpleName("oldName");
                b1.Resolver();
                b3._InfixExpression();
                b1._SameStageFragment();
                b0.VariableTest("newName");
                b0._Filter();
                b0.TemplateNames();
                b0._Select();
                b0._PointwiseUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.For_();
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0._Path();
                b0.PointwiseUpdate_();
                b0.SelfStep();
                b0.Select_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.DataEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleName");
                b1.VarName("newName");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Types");
                b1.VarName("types");
                b1.Quantifier("!");
                b1._Variable();
                b2.DataType("Object");
                b2._DataEntity();
                b1._StageUpFragment();
                b0.Filter_();
                b0.SelfStep();
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("oldName");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("types");
                b0.VariableTest("types");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0.Filter_();
                b1.SameStageFragment_();
                org.whole.lang.java.builders.IJavaBuilder b3 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b3.InfixExpression_();
                b3.StringLiteral("My");
                b3.InfixOperator("+");
                b3.SimpleName("oldName");
                b1.Resolver();
                b3._InfixExpression();
                b1._SameStageFragment();
                b0.VariableTest("newName");
                b0._Filter();
                b0.TemplateNames();
                b0._Select();
                b0._PointwiseUpdate();
                b0._For();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.CartesianUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.MethodInvocation_();
                b2.SimpleName("org.whole.lang.util.StringUtils");
                b1.Resolver();
                b2.SimpleName("toLowerCap");
                b2.Arguments_(1);
                b2.SimpleName("self");
                b2._Arguments();
                b2._MethodInvocation();
                b1._SameStageFragment();
                b0._CartesianUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newupdate11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.CartesianUpdate_();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("DataEntity");
                b0._Filter();
                b0.Sequence_(2);
                b0.FeatureStep("name");
                b0.FeatureStep("dataType");
                b0._Sequence();
                b0._Path();
                b0.Choose_(2);
                b0.If_();
                b0.TypeTest("SimpleName");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.MethodInvocation_();
                b2.SimpleName("org.whole.lang.util.StringUtils");
                b1.Resolver();
                b2.SimpleName("toLowerCap");
                b2.Arguments_(1);
                b2.SimpleName("self");
                b2._Arguments();
                b2._MethodInvocation();
                b1._SameStageFragment();
                b0._If();
                b0.Do_();
                b0.StringLiteral("MyDataType");
                b0._Do();
                b0._Choose();
                b0._CartesianUpdate();
            }
        };
    }

    public ITemplateFactory<IEntity> newinsert1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.CartesianInsert_();
                b0.Placement("INTO");
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0.FeatureStep("features");
                b0._Path();
                b0.Sequence_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("T1");
                b2.SimpleName("n1");
                b1.Resolver();
                b2._Feature();
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("T2");
                b2.SimpleName("n2");
                b1.Resolver();
                b2._Feature();
                b1._StageUpFragment();
                b0._Sequence();
                b0._CartesianInsert();
            }
        };
    }
}
