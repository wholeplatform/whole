package org.whole.lang.workflows.visitors;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class WorkflowsTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final WorkflowsTestTemplateManager instance = new WorkflowsTestTemplateManager();
    }

    public static WorkflowsTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private WorkflowsTestTemplateManager() {
        put("sequenceTest", newSequenceTest());
        put("parallelTest", newParallelTest());
        put("whileLoopTest", newWhileLoopTest());
        put("foreachLoopTest", newForeachLoopTest());
        put("switchControlTest", newSwitchControlTest());
        put("loadModelTest", newLoadModelTest());
        put("saveModelTest", newSaveModelTest());
        put("loadAndSaveModelToStringTest", newLoadAndSaveModelToStringTest());
        put("loadJavaModelTest", newLoadJavaModelTest());
        put("shallowSaveArtifactsTest", newShallowSaveArtifactsTest());
        put("deepSaveArtifactsTest", newDeepSaveArtifactsTest());
        put("loadArtifactsTest", newLoadArtifactsTest());
        put("invokeOperationTest", newInvokeOperationTest());
        put("invokeQueryTest", newInvokeQueryTest());
        put("createEntityTest", newCreateEntityTest());
        put("createModelTest", newCreateModelTest());
        put("createJavaClassInstanceTest", newCreateJavaClassInstanceTest());
        put("invokeJavaClassMethodTest", newInvokeJavaClassMethodTest());
        put("invokeJavaInstanceMethodTest", newInvokeJavaInstanceMethodTest());
        put("parseTest", newParseTest());
        put("unparseTest", newUnparseTest());
        put("taskTest", newTaskTest());
    }

    public ITemplateFactory<IEntity> newSequenceTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(3);
                b0.AssignActivity_();
                b0.Text("init x variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("x");
                b0.IntLiteral(1234);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.AssignActivity_();
                b0.Text("init y variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("y");
                b0.IntLiteral(8766);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.AssignActivity_();
                b0.Text("check result");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("equals");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Singleton_();
                b2.Equals_();
                b2.Addition_();
                b2.VariableRefStep("x");
                b2.VariableRefStep("y");
                b2._Addition();
                b2.IntLiteral(10000);
                b2._Equals();
                b2._Singleton();
                b1._SameStageFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newParallelTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.Parallel_();
                b0.Text("parallel");
                b0.FlowObjects_(2);
                b0.AssignActivity_();
                b0.Text("init y variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("y");
                b0.IntLiteral(8766);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.AssignActivity_();
                b0.Text("init x variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("x");
                b0.IntLiteral(1234);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._FlowObjects();
                b0._Parallel();
                b0.AssignActivity_();
                b0.Text("check result");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("equals");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Singleton_();
                b2.Equals_();
                b2.Addition_();
                b2.VariableRefStep("x");
                b2.VariableRefStep("y");
                b2._Addition();
                b2.IntLiteral(10000);
                b2._Equals();
                b2._Singleton();
                b1._SameStageFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newWhileLoopTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.AssignActivity_();
                b0.Text("init variables");
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("len");
                b0.IntLiteral(5);
                b0._Assign();
                b0.Assign_();
                b0.Variable("count");
                b0.IntLiteral(0);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.WhileLoop_();
                b0.Text("whileloop");
                b0.TestTime("before");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Or_(2);
                b2.And_(2);
                b2.ExpressionTest_();
                b2.LessThan_();
                b2.VariableRefStep("count");
                b2.VariableRefStep("len");
                b2._LessThan();
                b2._ExpressionTest();
                b2.ExpressionTest_();
                b2.GreaterOrEquals_();
                b2.VariableRefStep("len");
                b2.IntLiteral(0);
                b2._GreaterOrEquals();
                b2._ExpressionTest();
                b2._And();
                b2.ExpressionTest_();
                b2.BooleanLiteral(false);
                b2._ExpressionTest();
                b2._Or();
                b1._SameStageFragment();
                b0.AssignActivity_();
                b0.Text("update counter");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("count");
                b1.SameStageFragment_();
                b2.Addition_();
                b2.VariableRefStep("count");
                b2.IntLiteral(1);
                b2._Addition();
                b1._SameStageFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._WhileLoop();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newForeachLoopTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(3);
                b0.AssignActivity_();
                b0.Text("init variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("count");
                b0.IntLiteral(0);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.CreateModel_();
                b0.Text("create composite\rwith elements");
                b0.Variable("composite");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Tuple_(5);
                b2.BooleanLiteral(false);
                b2.DateLiteral(new java.util.Date(1207030368285l));
                b2.StringLiteral("stringLiteral");
                b2.IntLiteral(99999);
                b2.DoubleLiteral(3.14);
                b2._Tuple();
                b1._StageUpFragment();
                b1.Resolver();
                b0._CreateModel();
                b0.ForeachLoop_();
                b0.Text("whileloop");
                b0.Variable("composite");
                b0.Variable("element");
                b0.Variable("index");
                b0.AssignActivity_();
                b0.Text("update counter");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("count");
                b1.SameStageFragment_();
                b2.Addition_();
                b2.VariableRefStep("count");
                b2.IntLiteral(1);
                b2._Addition();
                b1._SameStageFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._ForeachLoop();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newSwitchControlTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(3);
                b0.AssignActivity_();
                b0.Text("init variable");
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("value");
                b0.IntLiteral(11);
                b0._Assign();
                b0.Assign_();
                b0.Variable("result");
                b0.IntLiteral(0);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.SwitchControl_();
                b0.Text("switchcontrol");
                b0.SwitchType("exclusive");
                b0.ConditionalCases_(3);
                b0.ConditionalCase_();
                b0.Text("conditionalcase");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Singleton_();
                b2.Equals_();
                b2.VariableRefStep("value");
                b2.IntLiteral(11);
                b2._Equals();
                b2._Singleton();
                b1._SameStageFragment();
                b0.AssignActivity_();
                b0.Text("update");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("result");
                b0.IntLiteral(1234);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._ConditionalCase();
                b0.ConditionalCase_();
                b0.Text("conditionalcase");
                b1.SameStageFragment_();
                b2.Singleton_();
                b2.Equals_();
                b2.VariableRefStep("value");
                b2.IntLiteral(12);
                b2._Equals();
                b2._Singleton();
                b1._SameStageFragment();
                b0.AssignActivity_();
                b0.Text("update");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("result");
                b0.IntLiteral(4321);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._ConditionalCase();
                b0.ConditionalCase_();
                b0.Text("conditionalcase");
                b1.SameStageFragment_();
                b2.Singleton_();
                b2.LessThan_();
                b2.VariableRefStep("value");
                b2.IntLiteral(13);
                b2._LessThan();
                b2._Singleton();
                b1._SameStageFragment();
                b0.AssignActivity_();
                b0.Text("update");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("result");
                b0.IntLiteral(9999);
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._ConditionalCase();
                b0._ConditionalCases();
                b1.Resolver();
                b0._SwitchControl();
                b0.SwitchControl_();
                b0.Text("switchcontrol");
                b0.SwitchType("inclusive");
                b0.ConditionalCases_(2);
                b0.ConditionalCase_();
                b0.Text("conditionalcase");
                b1.SameStageFragment_();
                b2.Singleton_();
                b2.Equals_();
                b2.VariableRefStep("result");
                b2.IntLiteral(1234);
                b2._Equals();
                b2._Singleton();
                b1._SameStageFragment();
                b0.AssignActivity_();
                b0.Text("increment");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("result");
                b1.SameStageFragment_();
                b2.Addition_();
                b2.VariableRefStep("result");
                b2.IntLiteral(1);
                b2._Addition();
                b1._SameStageFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._ConditionalCase();
                b0.ConditionalCase_();
                b0.Text("conditionalcase");
                b1.SameStageFragment_();
                b2.Singleton_();
                b2.GreaterThan_();
                b2.VariableRefStep("value");
                b2.IntLiteral(4);
                b2._GreaterThan();
                b2._Singleton();
                b1._SameStageFragment();
                b0.AssignActivity_();
                b0.Text("increment");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("value");
                b1.SameStageFragment_();
                b2.Addition_();
                b2.VariableRefStep("value");
                b2.IntLiteral(1);
                b2._Addition();
                b1._SameStageFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0._ConditionalCase();
                b0._ConditionalCases();
                b1.Resolver();
                b0._SwitchControl();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newLoadModelTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.LoadModel_();
                b0.Text("load a model using java builder persistence");
                b0.Variable("model");
                b0.StringLiteral("org.whole.lang.java.codebase.JavaBuilderPersistenceKit");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("./test/org/whole/lang/workflows/visitors/SampleModel.java");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("varName");
                b0.StringLiteral("varValue");
                b0._Assign();
                b0._Assignments();
                b0._LoadModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newSaveModelTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.SaveModel_();
                b0.Text("save a model using xml builder persistence");
                b0.Variable("model");
                b0.StringLiteral("org.whole.lang.xml.codebase.XmlBuilderPersistenceKit");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/SampleModel.xwl");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._SaveModel();
                b0.LoadModel_();
                b0.Text("load a model using xml builder persistence");
                b0.Variable("newModel");
                b0.StringLiteral("org.whole.lang.xml.codebase.XmlBuilderPersistenceKit");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/SampleModel.xwl");
                b1.Resolver();
                b0._LoadModel();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newLoadAndSaveModelToStringTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.LoadModel_();
                b0.Text("load a model using text source persistence");
                b0.Variable("model");
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0.ResourceKind("VARIABLE");
                b0.Variable("sourceString");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._LoadModel();
                b0.SaveModel_();
                b0.Text("save back using text source persistence");
                b0.Variable("model");
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0.ResourceKind("VARIABLE");
                b0.Variable("targetString");
                b1.Resolver();
                b0._SaveModel();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newLoadJavaModelTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.LoadJavaModel_();
                b0.Text("task test");
                b0.Variable("model");
                b0.StringLiteral("org.whole.lang.workflows.visitors.SampleModel");
                b0.ClassPath();
                b0._LoadJavaModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newShallowSaveArtifactsTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(7);
                b0.AssignActivity_();
                b0.Text("assignactivity");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("artifacts");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.artifacts.builders.IArtifactsBuilder b2 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
                b2.FolderArtifact_();
                b2.Name("artifacts");
                b1.Resolver();
                b2.Artifacts_(3);
                b2.FolderArtifact_();
                b2.Name("folder_1");
                b1.Resolver();
                b2.Artifacts_(2);
                b2.FolderArtifact_();
                b2.Name("sub_folder_1");
                b1.Resolver();
                b2.Artifacts_(1);
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                org.whole.lang.text.builders.ITextBuilder b3 = (org.whole.lang.text.builders.ITextBuilder) op.wGetBuilder(org.whole.lang.text.reflect.TextLanguageKit.URI);
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FolderArtifact_();
                b2.Name("folder_2");
                b1.Resolver();
                b2.Artifacts_(2);
                b2.FolderArtifact_();
                b2.Name("sub_folder_2");
                b1.Resolver();
                b2.Artifacts_(1);
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b1._StageUpFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.SaveArtifacts_();
                b0.Text("shallow save artifacts");
                b0.Variable("artifacts");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("SHALLOW");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b1.Resolver();
                b0._SaveArtifacts();
                b0.LoadArtifacts_();
                b0.Text("shallow load artifacts");
                b0.Variable("shallowResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("SHALLOW");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b1.Resolver();
                b0._LoadArtifacts();
                b0.LoadArtifacts_();
                b0.Text("deep file load artifacts");
                b0.Variable("deepFileResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("DEEP_FILE");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0._LoadArtifacts();
                b0.LoadArtifacts_();
                b0.Text("deep directory load artifacts");
                b0.Variable("deepDirectoryResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("DEEP_DIRECTORY");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b1.Resolver();
                b0._LoadArtifacts();
                b0.LoadArtifacts_();
                b0.Text("deep load artifacts");
                b0.Variable("deepResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("DEEP");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0._LoadArtifacts();
                b0.DeleteArtifacts_();
                b0.Text("deleteartifacts");
                b0.Variable("deepResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0._DeleteArtifacts();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newDeepSaveArtifactsTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(7);
                b0.AssignActivity_();
                b0.Text("assignactivity");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("artifacts");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.artifacts.builders.IArtifactsBuilder b2 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
                b2.FolderArtifact_();
                b2.Name("artifacts");
                b1.Resolver();
                b2.Artifacts_(3);
                b2.FolderArtifact_();
                b2.Name("folder_1");
                b1.Resolver();
                b2.Artifacts_(2);
                b2.FolderArtifact_();
                b2.Name("sub_folder_1");
                b1.Resolver();
                b2.Artifacts_(1);
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                org.whole.lang.text.builders.ITextBuilder b3 = (org.whole.lang.text.builders.ITextBuilder) op.wGetBuilder(org.whole.lang.text.reflect.TextLanguageKit.URI);
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FolderArtifact_();
                b2.Name("folder_2");
                b1.Resolver();
                b2.Artifacts_(2);
                b2.FolderArtifact_();
                b2.Name("sub_folder_2");
                b1.Resolver();
                b2.Artifacts_(1);
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b2.FileArtifact_();
                b2.NameWithExtension_();
                b2.Name("file");
                b2.Extension("txt");
                b2._NameWithExtension();
                b1.Resolver();
                b1.StageUpFragment_();
                b3.Document_(2);
                b3.Row_(1);
                b3.Text("Hello,");
                b3._Row();
                b3.Row_(1);
                b3.Text("World!");
                b3._Row();
                b3._Document();
                b1._StageUpFragment();
                b2._FileArtifact();
                b2._Artifacts();
                b2._FolderArtifact();
                b1._StageUpFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.SaveArtifacts_();
                b0.Text("shallow save artifacts");
                b0.Variable("artifacts");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("DEEP");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b1.Resolver();
                b0._SaveArtifacts();
                b0.LoadArtifacts_();
                b0.Text("shallow load artifacts");
                b0.Variable("shallowResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("SHALLOW");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b1.Resolver();
                b0._LoadArtifacts();
                b0.LoadArtifacts_();
                b0.Text("deep file load artifacts");
                b0.Variable("deepFileResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("DEEP_FILE");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0._LoadArtifacts();
                b0.LoadArtifacts_();
                b0.Text("deep directory load artifacts");
                b0.Variable("deepDirectoryResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("DEEP_DIRECTORY");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b1.Resolver();
                b0._LoadArtifacts();
                b0.LoadArtifacts_();
                b0.Text("deep load artifacts");
                b0.Variable("deepResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0.ArtifactsTraversalStrategy("DEEP");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0._LoadArtifacts();
                b0.DeleteArtifacts_();
                b0.Text("deleteartifacts");
                b0.Variable("shallowResult");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("data/artifacts");
                b0._DeleteArtifacts();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newLoadArtifactsTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.AssignActivity_();
                b0.Text("assignactivity");
                b0.Assignments_(0);
                b0._Assignments();
                b0._AssignActivity();
                b0.LoadArtifacts_();
                b0.Text("loadartifacts");
                b0.Variable("variable");
                b0.ResourceKind("FILE_SYSTEM");
                b0.StringLiteral("pathToResource");
                b0.ArtifactsTraversalStrategy("SHALLOW");
                b0.ArtifactsSynchronizeStrategy("REMOVE_ADD_UPDATE");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._LoadArtifacts();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newInvokeOperationTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("invoke operations");
                b0.FlowObjects_(8);
                b0.CreateModel_();
                b0.Text("create a models model");
                b0.Variable("model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Model_();
                b2.SimpleName("SampleM");
                b2.TypeRelations_(0);
                b2._TypeRelations();
                b2.ModelDeclarations_(2);
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("Type");
                b2.Types_(1);
                b2.SimpleName("IType");
                b2._Types();
                b2.Features_(1);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("DataStr");
                b2.SimpleName("data");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b2._SimpleEntity();
                b2.DataEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("DataStr");
                b2.Types_(0);
                b2._Types();
                b2.DataType("String");
                b2._DataEntity();
                b2._ModelDeclarations();
                b2.Namespace("org.whole.lang");
                b1.Resolver();
                b2.URI("http://lang.whole.org/SampleM");
                b2._Model();
                b1._StageUpFragment();
                b1.Resolver();
                b0._CreateModel();
                b0.InvokeJavaClassMethod_();
                b0.Text("copy model");
                b0.Variable("modelCopy");
                b1.Resolver();
                b0.StringLiteral("org.whole.lang.util.EntityUtils");
                b0.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b0.Expressions_(1);
                b0.Variable("model");
                b0._Expressions();
                b0._InvokeJavaClassMethod();
                b0.CreateJavaClassInstance_();
                b0.Text("initialize current folder variable");
                b0.Variable("folder");
                b1.Resolver();
                b0.StringLiteral("java.io.File");
                b0.StringLiteral("File(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("data");
                b0._Expressions();
                b0._CreateJavaClassInstance();
                b0.InvokeOperation_();
                b0.Text("validate");
                b0.Variable("model");
                b0.Operation("VALIDATOR");
                b1.Resolver();
                b0._InvokeOperation();
                b0.InvokeOperation_();
                b0.Text("normalize");
                b0.Variable("model");
                b0.Operation("NORMALIZER");
                b1.Resolver();
                b0._InvokeOperation();
                b0.InvokeOperation_();
                b0.Text("pretty print");
                b0.Variable("model");
                b0.Operation("PRETTY_PRINTER");
                b1.Resolver();
                b0._InvokeOperation();
                b0.InvokeOperation_();
                b0.Text("interpret");
                b0.Variable("model");
                b0.Operation("INTERPRETER");
                b1.Resolver();
                b0._InvokeOperation();
                b0.InvokeOperation_();
                b0.Text("generate");
                b0.Variable("fileArtifact");
                b0.Operation("ARTIFACTS_GENERATOR");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("fileArtifact");
                b1.StageUpFragment_();
                org.whole.lang.artifacts.builders.IArtifactsBuilder b3 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
                b3.FileArtifact_();
                b3.NameWithExtension_();
                b3.Name("SampleM");
                b3.Extension("xwl");
                b3._NameWithExtension();
                b3.Metadata_();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3.PersistenceKitId("org.whole.lang.xml.codebase.XmlBuilderPersistenceKit");
                b3._Metadata();
                b1.StageUpFragment_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Model");
                b1.VarName("model");
                b1.Quantifier("!");
                b1._Variable();
                b1._StageUpFragment();
                b3._FileArtifact();
                b1._StageUpFragment();
                b0._Assign();
                b0._Assignments();
                b0._InvokeOperation();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newInvokeQueryTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.InvokeQuery_();
                b0.Text("invoke a query defined through assignments");
                b0.Variable("queryName");
                b0.Assignments_(3);
                b0.Assign_();
                b0.Variable("queryName");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Select_();
                b2.Filter_();
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b3 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b3.MethodInvocation_();
                b3.ThisExpression_();
                b1.Resolver();
                b3._ThisExpression();
                b3.Types_(0);
                b3._Types();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#SimpleName");
                b1.VarName("methodName");
                b1.Quantifier("!");
                b1._Variable();
                b3.Arguments_(0);
                b3._Arguments();
                b3._MethodInvocation();
                b1._StageUpFragment();
                b2.VariableTest("methodCall");
                b2._Filter();
                b2.SelfStep();
                b1.Resolver();
                b2.TemplateNames();
                b2._Select();
                b1._StageUpFragment();
                b0._Assign();
                b0.Assign_();
                b0.Variable("methodName");
                b0.StringLiteral("hashCode");
                b0._Assign();
                b0.Assign_();
                b0.Variable("self");
                b0.StringLiteral("selfValue");
                b0._Assign();
                b0._Assignments();
                b0._InvokeQuery();
            }
        };
    }

    public ITemplateFactory<IEntity> newCreateEntityTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.AssignActivity_();
                b0.Text("init variables");
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("features");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(1);
                b2.Feature_();
                b1.Resolver();
                b2.SimpleName("FType");
                b2.SimpleName("fname");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0._Assign();
                b0.Assign_();
                b0.Variable("name");
                b1.StageUpFragment_();
                b2.SimpleName("EntityName");
                b1._StageUpFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
                b0.CreateEntity_();
                b0.Text("create a simple entity");
                b0.Variable("entity");
                b0.Registry("DEFAULT");
                b0.StringLiteral("http://lang.whole.org/Models#SimpleEntity");
                b0.Expressions_(4);
                b1.StageUpFragment_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b1._StageUpFragment();
                b0.Variable("name");
                b1.StageUpFragment_();
                b2.Types_(1);
                b2.SimpleName("Type");
                b2._Types();
                b1._StageUpFragment();
                b0.Variable("features");
                b0._Expressions();
                b0._CreateEntity();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newCreateModelTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateModel_();
                b0.Text("create a model");
                b0.Variable("model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.SimpleEntity_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#EntityModifiers");
                b1.VarName("modifiers");
                b1.Quantifier("!");
                b1._Variable();
                b2.SimpleName("Entity1");
                b2.Types_(1);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Type");
                b1.VarName("type");
                b1.Quantifier("?");
                b1._Variable();
                b2._Types();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Features");
                b1.VarName("features");
                b1.Quantifier("!");
                b1._Variable();
                b2._SimpleEntity();
                b1._StageUpFragment();
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("features");
                b1.StageUpFragment_();
                b2.Features_(1);
                b2.Feature_();
                b1.Resolver();
                b2.SimpleName("FType");
                b2.SimpleName("fname");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0._Assign();
                b0.Assign_();
                b0.Variable("modifiers");
                b1.StageUpFragment_();
                b2.EntityModifiers_(1);
                b2.EntityModifier("abstract");
                b2._EntityModifiers();
                b1._StageUpFragment();
                b0._Assign();
                b0._Assignments();
                b0._CreateModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newCreateJavaClassInstanceTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateJavaClassInstance_();
                b0.Text("create java object");
                b0.Variable("value");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("java.math.BigDecimal");
                b0.StringLiteral("BigDecimal(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("1231.84587345");
                b0._Expressions();
                b0._CreateJavaClassInstance();
            }
        };
    }

    public ITemplateFactory<IEntity> newInvokeJavaClassMethodTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.InvokeJavaClassMethod_();
                b0.Text("invoke java static method");
                b0.Variable("value");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("java.lang.Double");
                b0.StringLiteral("parseDouble(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("1231.84587345");
                b0._Expressions();
                b0._InvokeJavaClassMethod();
            }
        };
    }

    public ITemplateFactory<IEntity> newInvokeJavaInstanceMethodTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(3);
                b0.CreateEntity_();
                b0.Text("createentity");
                b0.Variable("simpleEntity");
                b0.Registry("DEFAULT");
                b0.StringLiteral("http://lang.whole.org/Models#SimpleEntity");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._CreateEntity();
                b0.CreateEntity_();
                b0.Text("createentity");
                b0.Variable("compositeEntity");
                b0.Registry("DEFAULT");
                b0.StringLiteral("http://lang.whole.org/Models#CompositeEntity");
                b1.Resolver();
                b0._CreateEntity();
                b0.InvokeJavaInstanceMethod_();
                b0.Text("invoke java method");
                b0.Variable("value");
                b0.Variable("simpleEntity");
                b1.Resolver();
                b0.StringLiteral("org.whole.lang.model.IEntity");
                b0.StringLiteral("wEquals(org.whole.lang.model.IEntity)");
                b0.Expressions_(1);
                b0.Variable("compositeEntity");
                b0._Expressions();
                b0._InvokeJavaInstanceMethod();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newParseTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse model");
                b0.Variable("model");
                b0.StringLiteral("32 , enrico");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.grammars.builders.IGrammarsBuilder b2 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
                b2.Grammar_();
                b2.Name("SampleGrammar");
                b2.LanguageDescriptor_();
                b2.URI("http://lang.whole.org/Sample");
                b2.Namespace("org.whole.lang.sample");
                b2.Name("Sample");
                b1.Resolver();
                b2._LanguageDescriptor();
                b2.NonTerminal("StartSymbol");
                b2.LiteralTerminal_();
                b2.RegExp("\\p{javaWhitespace}*");
                b2.Category("SEPARATOR");
                b2.Literal("");
                b2._LiteralTerminal();
                b2.Productions_(0);
                b2._Productions();
                b2.Productions_(3);
                b2.Production_();
                b2.NonTerminal("StartSymbol");
                b2.Concatenate_(3);
                b2.As_();
                b2.NonTerminal("Age");
                b2.Name("number");
                b2._As();
                b2.LiteralTerminal_();
                b2.RegExp(",");
                b2.Category("DELIMITER");
                b2.Literal(",");
                b2._LiteralTerminal();
                b2.As_();
                b2.NonTerminal("Name");
                b2.Name("name");
                b2._As();
                b2._Concatenate();
                b1.Resolver();
                b2._Production();
                b2.Production_();
                b2.NonTerminal("Age");
                b2.DataTerminal_();
                b2.RegExp("[-]?[0-9]+");
                b2.Category("LITERAL");
                b2.Format("%d");
                b2._DataTerminal();
                b2.DataType("INT");
                b2._Production();
                b2.Production_();
                b2.NonTerminal("Name");
                b2.DataTerminal_();
                b2.RegExp("[^,]*");
                b2.Category("LITERAL");
                b2.Format("%s");
                b2._DataTerminal();
                b2.DataType("STRING");
                b2._Production();
                b2._Productions();
                b2.URI("http://lang.whole.org/SampleGrammar");
                b2.Namespace("org.whole.lang.sample");
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2._Grammar();
                b1._StageUpFragment();
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newUnparseTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Unparse_();
                b0.Text("unparse model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Types_(3);
                b2.SimpleName("Type1");
                b2.SimpleName("Type2");
                b2.SimpleName("Type3");
                b2._Types();
                b1._StageUpFragment();
                b0.Variable("text");
                b1.StageUpFragment_();
                org.whole.lang.grammars.builders.IGrammarsBuilder b3 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
                b3.Grammar_();
                b3.Name("SampleGrammar");
                b3.URI("http://lang.whole.org/Models");
                b3.NonTerminal("Types");
                b3.LiteralTerminal_();
                b3.RegExp("\\p{javaWhitespace}*");
                b3.Category("SEPARATOR");
                b3.Literal("");
                b3._LiteralTerminal();
                b3.Productions_(0);
                b3._Productions();
                b3.Productions_(2);
                b3.Production_();
                b3.NonTerminal("Types");
                b3.Repeat_();
                b3.Size(0);
                b3.Unbounded();
                b3.LiteralTerminal_();
                b3.RegExp(",");
                b3.Category("DELIMITER");
                b3.Literal(", ");
                b3._LiteralTerminal();
                b3.NonTerminal("Type");
                b3._Repeat();
                b1.Resolver();
                b3._Production();
                b3.Production_();
                b3.NonTerminal("Type");
                b3.DataTerminal_();
                b3.RegExp("[a-zA-Z]+");
                b3.Category("LITERAL");
                b3.Format("%s");
                b3._DataTerminal();
                b3.DataType("STRING");
                b3._Production();
                b3._Productions();
                b3.URI("http://lang.whole.org/SampleGrammar");
                b3.Namespace("org.whole.lang.sample");
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3._Grammar();
                b1._StageUpFragment();
                b1.Resolver();
                b0._Unparse();
            }
        };
    }

    public ITemplateFactory<IEntity> newTaskTest() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Task_();
                b0.Text("task test");
                b0.Text("turn around your desk once and\rsay hello to your co-workers!");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b1.Resolver();
                b0._Task();
            }
        };
    }
}
