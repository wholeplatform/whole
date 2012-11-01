package org.whole.lang.grammars.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class GrammarBasedUnparserVisitorTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final GrammarBasedUnparserVisitorTestTemplateManager instance = new GrammarBasedUnparserVisitorTestTemplateManager();
    }

    public static GrammarBasedUnparserVisitorTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private GrammarBasedUnparserVisitorTestTemplateManager() {
        put("fragment", newFragment());
        put("fragment1", newFragment1());
        put("fragment2", newFragment2());
        put("fragment3", newFragment3());
    }

    public ITemplateFactory<IEntity> newFragment() {
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

    public ITemplateFactory<IEntity> newFragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("unparse models with and without fragments");
                b0.FlowObjects_(2);
                b0.Unparse_();
                b0.Text("unparse model with fragments using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.reflect.EntityDescriptorEnum e2 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://tests.lang.whole.org/StateMachine2").getEntityDescriptorEnum();
                b1.wEntity_(e2.valueOf("StateMachine"));
                b1.wEntity_(e2.valueOf("Events"), 5);
                b1.wEntity_(e2.valueOf("Event"));
                b1.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b3 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b3.Addition_();
                b3.StringLiteral("door");
                b3.StringLiteral("Closed");
                b3._Addition();
                b1._StageDownFragment();
                b1.wEntity(e2.valueOf("ID"), "D1CL");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.SameStageFragment_();
                b3.StringLiteral("drawOpened");
                b1._SameStageFragment();
                b1.wEntity(e2.valueOf("ID"), "D2OP");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.StageUpFragment_();
                b3.StringLiteral("lightOn");
                b1._StageUpFragment();
                b1.wEntity(e2.valueOf("ID"), "L1ON");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.wEntity(e2.valueOf("ID"), "doorOpened");
                b1.wEntity(e2.valueOf("ID"), "D1OP");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.wEntity(e2.valueOf("ID"), "panelClosed");
                b1.wEntity(e2.valueOf("ID"), "PNCL");
                b1._wEntity(e2.valueOf("Event"));
                b1._wEntity(e2.valueOf("Events"));
                b1.wEntity_(e2.valueOf("ResetEvents"), 1);
                b1.wEntity(e2.valueOf("ID"), "doorOpened");
                b1._wEntity(e2.valueOf("ResetEvents"));
                b1.wEntity_(e2.valueOf("Commands"), 3);
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "unlockPanel");
                b1.wEntity(e2.valueOf("ID"), "PNUL");
                b1._wEntity(e2.valueOf("Command"));
                b1.StageUpFragment_();
                b1.wEntity_(e2.valueOf("Commands"), 2);
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "lockPanel");
                b1.wEntity(e2.valueOf("ID"), "PNLK");
                b1._wEntity(e2.valueOf("Command"));
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "lockDoor");
                b1.wEntity(e2.valueOf("ID"), "D1LK");
                b1._wEntity(e2.valueOf("Command"));
                b1._wEntity(e2.valueOf("Commands"));
                b1._StageUpFragment();
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "unlockDoor");
                b1.wEntity(e2.valueOf("ID"), "D1UL");
                b1._wEntity(e2.valueOf("Command"));
                b1._wEntity(e2.valueOf("Commands"));
                b1.wEntity_(e2.valueOf("States"), 5);
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "idle");
                b1.SameStageFragment_();
                b1.wEntity_(e2.valueOf("Actions"), 2);
                b1.wEntity(e2.valueOf("ID"), "unlockDoor");
                b1.wEntity(e2.valueOf("ID"), "lockPanel");
                b1._wEntity(e2.valueOf("Actions"));
                b1._SameStageFragment();
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "doorClosed");
                b1.wEntity(e2.valueOf("ID"), "active");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1.SameStageFragment_();
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "active");
                b1.Resolver();
                b1.wEntity_(e2.valueOf("Transitions"), 2);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "drawOpened");
                b1.wEntity(e2.valueOf("ID"), "waitingForLight");
                b1._wEntity(e2.valueOf("Transition"));
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "lightOn");
                b1.wEntity(e2.valueOf("ID"), "waitingForDraw");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1._SameStageFragment();
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "waitingForLight");
                b1.Resolver();
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "lightOn");
                b1.wEntity(e2.valueOf("ID"), "unlockedPanel");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "waitingForDraw");
                b1.Resolver();
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "drawOpened");
                b1.wEntity(e2.valueOf("ID"), "unlockedPanel");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "unlockedPanel");
                b1.wEntity_(e2.valueOf("Actions"), 2);
                b1.wEntity(e2.valueOf("ID"), "unlockPanel");
                b1.wEntity(e2.valueOf("ID"), "lockDoor");
                b1._wEntity(e2.valueOf("Actions"));
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "panelClosed");
                b1.wEntity(e2.valueOf("ID"), "idle");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1._wEntity(e2.valueOf("States"));
                b1._wEntity(e2.valueOf("StateMachine"));
                b1._StageUpFragment();
                b0.Variable("toStringFromModelWithFragments");
                b0.StringLiteral("http://tests.lang.whole.org/StateMachine2Grammar");
                b1.Resolver();
                b0._Unparse();
                b0.Unparse_();
                b0.Text("unparse model without fragments using grammar");
                b1.StageUpFragment_();
                b1.wEntity_(e2.valueOf("StateMachine"));
                b1.wEntity_(e2.valueOf("Events"), 5);
                b1.wEntity_(e2.valueOf("Event"));
                b1.wEntity(e2.valueOf("ID"), "doorClosed");
                b1.wEntity(e2.valueOf("ID"), "D1CL");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.wEntity(e2.valueOf("ID"), "drawOpened");
                b1.wEntity(e2.valueOf("ID"), "D2OP");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.wEntity(e2.valueOf("ID"), "lightOn");
                b1.wEntity(e2.valueOf("ID"), "L1ON");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.wEntity(e2.valueOf("ID"), "doorOpened");
                b1.wEntity(e2.valueOf("ID"), "D1OP");
                b1._wEntity(e2.valueOf("Event"));
                b1.wEntity_(e2.valueOf("Event"));
                b1.wEntity(e2.valueOf("ID"), "panelClosed");
                b1.wEntity(e2.valueOf("ID"), "PNCL");
                b1._wEntity(e2.valueOf("Event"));
                b1._wEntity(e2.valueOf("Events"));
                b1.wEntity_(e2.valueOf("ResetEvents"), 1);
                b1.wEntity(e2.valueOf("ID"), "doorOpened");
                b1._wEntity(e2.valueOf("ResetEvents"));
                b1.wEntity_(e2.valueOf("Commands"), 4);
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "unlockPanel");
                b1.wEntity(e2.valueOf("ID"), "PNUL");
                b1._wEntity(e2.valueOf("Command"));
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "lockPanel");
                b1.wEntity(e2.valueOf("ID"), "PNLK");
                b1._wEntity(e2.valueOf("Command"));
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "lockDoor");
                b1.wEntity(e2.valueOf("ID"), "D1LK");
                b1._wEntity(e2.valueOf("Command"));
                b1.wEntity_(e2.valueOf("Command"));
                b1.wEntity(e2.valueOf("ID"), "unlockDoor");
                b1.wEntity(e2.valueOf("ID"), "D1UL");
                b1._wEntity(e2.valueOf("Command"));
                b1._wEntity(e2.valueOf("Commands"));
                b1.wEntity_(e2.valueOf("States"), 5);
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "idle");
                b1.wEntity_(e2.valueOf("Actions"), 2);
                b1.wEntity(e2.valueOf("ID"), "unlockDoor");
                b1.wEntity(e2.valueOf("ID"), "lockPanel");
                b1._wEntity(e2.valueOf("Actions"));
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "doorClosed");
                b1.wEntity(e2.valueOf("ID"), "active");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "active");
                b1.Resolver();
                b1.wEntity_(e2.valueOf("Transitions"), 2);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "drawOpened");
                b1.wEntity(e2.valueOf("ID"), "waitingForLight");
                b1._wEntity(e2.valueOf("Transition"));
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "lightOn");
                b1.wEntity(e2.valueOf("ID"), "waitingForDraw");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "waitingForLight");
                b1.Resolver();
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "lightOn");
                b1.wEntity(e2.valueOf("ID"), "unlockedPanel");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "waitingForDraw");
                b1.Resolver();
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "drawOpened");
                b1.wEntity(e2.valueOf("ID"), "unlockedPanel");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1.wEntity_(e2.valueOf("State"));
                b1.wEntity(e2.valueOf("ID"), "unlockedPanel");
                b1.wEntity_(e2.valueOf("Actions"), 2);
                b1.wEntity(e2.valueOf("ID"), "unlockPanel");
                b1.wEntity(e2.valueOf("ID"), "lockDoor");
                b1._wEntity(e2.valueOf("Actions"));
                b1.wEntity_(e2.valueOf("Transitions"), 1);
                b1.wEntity_(e2.valueOf("Transition"));
                b1.wEntity(e2.valueOf("ID"), "panelClosed");
                b1.wEntity(e2.valueOf("ID"), "idle");
                b1._wEntity(e2.valueOf("Transition"));
                b1._wEntity(e2.valueOf("Transitions"));
                b1._wEntity(e2.valueOf("State"));
                b1._wEntity(e2.valueOf("States"));
                b1._wEntity(e2.valueOf("StateMachine"));
                b1._StageUpFragment();
                b0.Variable("toStringFromModelWithoutFragments");
                b0.StringLiteral("http://tests.lang.whole.org/StateMachine2Grammar");
                b1.Resolver();
                b0._Unparse();
                b0._FlowObjects();
                b0._Sequence();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Unparse_();
                b0.Text("unparse model using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.reflect.EntityDescriptorEnum e2 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://tests.lang.whole.org/DataTypes").getEntityDescriptorEnum();
                b1.wEntity_(e2.valueOf("DataTypes"), 11);
                b1.wEntity(e2.valueOf("BooleanLiteral"), false);
                b1.wEntity(e2.valueOf("EnumType"), "x one");
                b1.wEntity(e2.valueOf("DecimalLiteral"), "12345,500000");
                b1.wEntity(e2.valueOf("IntLiteral"), 12345l);
                b1.wEntity(e2.valueOf("EnumType"), "two");
                b1.wEntity(e2.valueOf("EnumType"), "three");
                b1.wEntity(e2.valueOf("DateLiteral"), new java.util.Date(1072828800000l));
                b1.wEntity(e2.valueOf("DateTimeLiteral"), new java.util.Date(1232557846120l));
                b1.wEntity(e2.valueOf("BooleanLiteral"), true);
                b1.wEntity(e2.valueOf("StringLiteral"), "ciao");
                b1.wEntity(e2.valueOf("DecimalLiteral"), "-123,456000");
                b1._wEntity(e2.valueOf("DataTypes"));
                b1._StageUpFragment();
                b1.Resolver();
                b0.StringLiteral("http://tests.whole.org/DataTypesGrammar");
                b1.Resolver();
                b0._Unparse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.environment.builders.IEnvironmentBuilder b0 = (org.whole.lang.environment.builders.IEnvironmentBuilder) op.wGetBuilder(org.whole.lang.environment.reflect.EnvironmentLanguageKit.URI);
                b0.StringData("{\n    false\n\n\n    ;\n    x one;\n    12345,500000;\n    12345;\n    two;\n    three;\n    31/12/2003;\n    2009-01-21T17:10:46.120Z;\n    true\n\n\n    ;\n    \"ciao\";\n    -123,456000\n}");
            }
        };
    }
}
