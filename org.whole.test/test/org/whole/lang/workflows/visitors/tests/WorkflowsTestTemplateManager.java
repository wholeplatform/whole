package org.whole.lang.workflows.visitors.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class WorkflowsStagingTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final WorkflowsStagingTestTemplateManager instance = new WorkflowsStagingTestTemplateManager();
    }

    public static WorkflowsStagingTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private WorkflowsStagingTestTemplateManager() {
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
        put("fragment10", newfragment10());
        put("fragment11", newfragment11());
        put("fragment12", newfragment12());
        put("fragment13", newfragment13());
        put("fragment14", newfragment14());
        put("fragment15", newfragment15());
        put("fragment16", newfragment16());
        put("fragment17", newfragment17());
        put("fragment18", newfragment18());
        put("fragment19", newfragment19());
        put("fragment20", newfragment20());
        put("fragment21", newfragment21());
        put("fragment22", newfragment22());
        put("fragment23", newfragment23());
        put("fragment24", newfragment24());
        put("fragment25", newfragment25());
        put("fragment26", newfragment26());
        put("fragment27", newfragment27());
        put("fragment28", newfragment28());
        put("fragment29", newfragment29());
        put("fragment30", newfragment30());
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.LoadModel_();
                b0.Text("load Deployer Workflow");
                b0.Variable("deployerWorkflow");
                b0.StringLiteral("org.whole.lang.xml.codebase.XmlBuilderPersistenceKit");
                b0.ResourceKind("CLASSPATH");
                b0.StringLiteral("org/whole/lang/grammars/util/tests/GrammarsDeployer.xwl");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._LoadModel();
                b0.InvokeOperation_();
                b0.Text("interpret Deployer Workflow");
                b0.Variable("deployerWorkflow");
                b0.Operation("INTERPRETER");
                b1.Resolver();
                b0._InvokeOperation();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateJavaClassInstance_();
                b0.Text("create new instance in variable");
                b0.Variable("instance");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.StringLiteral("String(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("sample string");
                b0._Expressions();
                b0._CreateJavaClassInstance();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.VariableRefStep("instance");
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateJavaClassInstance_();
                b0.Text("create new instance");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.StringLiteral("String(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("sample string");
                b0._Expressions();
                b0._CreateJavaClassInstance();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateJavaClassInstance_();
                b0.Text("create new instance in variable");
                b0.Variable("instance2");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.StringLiteral("String(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("sample string");
                b0._Expressions();
                b0._CreateJavaClassInstance();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b2 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b2.InvokeJavaClassMethod_();
                b2.Text("invoke class methot and set result in variable");
                b2.Variable("retval");
                b1.Resolver();
                b2.StringLiteral("java.lang.String");
                b2.StringLiteral("valueOf(int)");
                b2.Expressions_(1);
                b2.IntLiteral(1234567890);
                b2._Expressions();
                b2._InvokeJavaClassMethod();
                b1._SameStageFragment();
                b0.VariableRefStep("retval");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.InvokeJavaClassMethod_();
                b0.Text("invoke class methot");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.StringLiteral("valueOf(int)");
                b0.Expressions_(1);
                b0.IntLiteral(1234567890);
                b0._Expressions();
                b0._InvokeJavaClassMethod();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.InvokeJavaClassMethod_();
                b0.Text("invoke class methot and set result in variable");
                b0.Variable("retval2");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.StringLiteral("valueOf(int)");
                b0.Expressions_(1);
                b0.IntLiteral(1234567890);
                b0._Expressions();
                b0._InvokeJavaClassMethod();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b2 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b2.InvokeJavaInstanceMethod_();
                b2.Text("invoke instance methot and set result in variable");
                b2.Variable("retval");
                b2.Variable("instance");
                b1.Resolver();
                b2.StringLiteral("java.lang.String");
                b2.StringLiteral("concat(java.lang.String)");
                b2.Expressions_(1);
                b2.StringLiteral("append this");
                b2._Expressions();
                b2._InvokeJavaInstanceMethod();
                b1._SameStageFragment();
                b0.VariableRefStep("retval");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.InvokeJavaInstanceMethod_();
                b0.Text("invoke instance methot");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("instance");
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.StringLiteral("concat(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("append this");
                b0._Expressions();
                b0._InvokeJavaInstanceMethod();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.InvokeJavaInstanceMethod_();
                b0.Text("invoke instance methot and set result in variable");
                b0.Variable("retval2");
                b0.Variable("instance");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.StringLiteral("concat(java.lang.String)");
                b0.Expressions_(1);
                b0.StringLiteral("append this");
                b0._Expressions();
                b0._InvokeJavaInstanceMethod();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b2 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b2.CreateEntity_();
                b2.Text("create new entity in variable");
                b2.Variable("entity");
                b2.Registry("DEFAULT");
                b2.StringLiteral("http://lang.whole.org/Models#Model");
                b1.Resolver();
                b2._CreateEntity();
                b1._SameStageFragment();
                b0.VariableRefStep("entity");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateEntity_();
                b0.Text("create new entity");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Registry("DEFAULT");
                b0.StringLiteral("http://lang.whole.org/Models#Model");
                b1.Resolver();
                b0._CreateEntity();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment13() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateEntity_();
                b0.Text("create new entity in variable");
                b0.Variable("entity2");
                b0.Registry("DEFAULT");
                b0.StringLiteral("http://lang.whole.org/Models#Model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._CreateEntity();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment14() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b2 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b2.CreateModel_();
                b2.Text("create new model in variable");
                b2.Variable("model");
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b3 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b3.Document_();
                b3.Prolog_();
                b3.XMLDecl_();
                b3.Version("1.0");
                b3.Encoding("UTF-8");
                b1.Resolver();
                b3._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b3._Prolog();
                b3.Element_();
                b3.Name("tag");
                b1.Resolver();
                b1.Resolver();
                b3._Element();
                b3._Document();
                b1._StageUpFragment();
                b1.Resolver();
                b2._CreateModel();
                b1._SameStageFragment();
                b0.VariableRefStep("model");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment15() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateModel_();
                b0.Text("create new model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b2 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("tag");
                b1.Resolver();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b1.Resolver();
                b0._CreateModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment16() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateModel_();
                b0.Text("create new model in variable");
                b0.Variable("model2");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.xml.builders.IXmlBuilder b2 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
                b2.Document_();
                b2.Prolog_();
                b2.XMLDecl_();
                b2.Version("1.0");
                b2.Encoding("UTF-8");
                b1.Resolver();
                b2._XMLDecl();
                b1.Resolver();
                b1.Resolver();
                b2._Prolog();
                b2.Element_();
                b2.Name("tag");
                b1.Resolver();
                b1.Resolver();
                b2._Element();
                b2._Document();
                b1._StageUpFragment();
                b1.Resolver();
                b0._CreateModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment17() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b2 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b2.LoadJavaModel_();
                b2.Text("load java model in variable");
                b2.Variable("entity");
                b2.StringLiteral("java.lang.String");
                b2.ClassPath();
                b2._LoadJavaModel();
                b1._SameStageFragment();
                b0.VariableRefStep("entity");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment18() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.LoadJavaModel_();
                b0.Text("load java model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("java.lang.String");
                b0.ClassPath();
                b0._LoadJavaModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment19() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.LoadJavaModel_();
                b0.Text("load java model in variable");
                b0.Variable("entity2");
                b0.StringLiteral("java.lang.String");
                b0.ClassPath();
                b0._LoadJavaModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment20() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b1 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b1.AssignActivity_();
                b1.Text("initialize a variable with some text");
                b1.Assignments_(1);
                b1.Assign_();
                b1.Variable("textInput");
                b1.StringLiteral("this is some text input");
                b1._Assign();
                b1._Assignments();
                b1._AssignActivity();
                b0._SameStageFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment21() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b2 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b2.LoadModel_();
                b2.Text("load text model in variable");
                b2.Variable("entity");
                b2.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b2.ResourceKind("VARIABLE");
                b2.Variable("textInput");
                b1.Resolver();
                b2._LoadModel();
                b1._SameStageFragment();
                b0.VariableRefStep("entity");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment22() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.LoadModel_();
                b0.Text("load text model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0.ResourceKind("VARIABLE");
                b0.Variable("textInput");
                b1.Resolver();
                b0._LoadModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment23() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.LoadModel_();
                b0.Text("load text model in variable");
                b0.Variable("entity2");
                b0.StringLiteral("org.whole.lang.text.codebase.TextSourcePersistenceKit");
                b0.ResourceKind("VARIABLE");
                b0.Variable("textInput");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._LoadModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment24() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse model in variable");
                b0.Variable("entity");
                b0.StringLiteral("{\n\tfalse;\n\tx one;\n\t12345,000000;\n\t12345;\n\ttwo;\n\tthree;\n\t31/12/2005;\n\t2009-01-21T17:10:46.120Z;\n\ttrue;\n\t\"ciao\";\n\t-123,456000\n}");
                b0.StringLiteral("DataTypesGrammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment25() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.VariableRefStep("entity");
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment26() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse model");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{\n\tfalse;\n\tx one;\n\t12345,000000;\n\t12345;\n\ttwo;\n\tthree;\n\t31/12/2005;\n\t2009-01-21T17:10:46.120Z;\n\ttrue;\n\t\"ciao\";\n\t-123,456000\n}");
                b0.StringLiteral("DataTypesGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment27() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse model in variable");
                b0.Variable("entity2");
                b0.StringLiteral("{\n\tfalse;\n\tx one;\n\t12345,000000;\n\t12345;\n\ttwo;\n\tthree;\n\t31/12/2005;\n\t2009-01-21T17:10:46.120Z;\n\ttrue;\n\t\"ciao\";\n\t-123,456000\n}");
                b0.StringLiteral("DataTypesGrammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment28() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b2 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b2.Unparse_();
                b2.Text("unparse model in variable");
                b2.Variable("entity");
                b2.Variable("text");
                b2.StringLiteral("DataTypesGrammar");
                b1.Resolver();
                b2._Unparse();
                b1._SameStageFragment();
                b0.VariableRefStep("text");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment29() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Unparse_();
                b0.Text("unparse model");
                b0.Variable("entity");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("DataTypesGrammar");
                b1.Resolver();
                b0._Unparse();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment30() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Unparse_();
                b0.Text("unparse model in variable");
                b0.Variable("entity");
                b0.Variable("text2");
                b0.StringLiteral("DataTypesGrammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Unparse();
            }
        };
    }
}
