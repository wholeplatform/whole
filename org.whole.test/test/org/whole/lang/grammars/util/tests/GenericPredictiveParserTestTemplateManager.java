package org.whole.lang.grammars.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class GenericPredictiveParserTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final GenericPredictiveParserTestTemplateManager instance = new GenericPredictiveParserTestTemplateManager();
    }

    public static GenericPredictiveParserTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private GenericPredictiveParserTestTemplateManager() {
        put("fragment", newFragment());
        put("fragment1", newFragment1());
        put("fragment2", newFragment2());
        put("fragment3", newFragment3());
        put("fragment4", newFragment4());
        put("fragment5", newFragment5());
        put("fragment6", newFragment6());
        put("fragment7", newFragment7());
        put("fragment8", newFragment8());
        put("fragment9", newFragment9());
        put("fragment10", newFragment10());
        put("fragment11", newFragment11());
        put("fragment12", newFragment12());
        put("fragment13", newFragment13());
        put("fragment14", newFragment14());
        put("fragment15", newFragment15());
        put("fragment16", newFragment16());
        put("fragment17", newFragment17());
        put("fragment18", newFragment18());
        put("fragment19", newFragment19());
        put("fragment20", newFragment20());
        put("fragment21", newFragment21());
        put("fragment22", newFragment22());
        put("fragment23", newFragment23());
        put("fragment24", newFragment24());
        put("fragment25", newFragment25());
        put("fragment26", newFragment26());
        put("fragment27", newFragment27());
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
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("{\n\tfalse;\n\tx one;\n\t12345,000000;\n\t12345;\n\ttwo;\n\tthree;\n\t31/12/2005;\n\t2009-01-21T17:10:46.120Z;\n\ttrue;\n\t\"ciao\";\n\t-123,456000\n}");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://tests.whole.org/DataTypesGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://tests.lang.whole.org/DataTypes").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("DataTypes"), 11);
                b0.wEntity(e1.valueOf("BooleanLiteral"), false);
                b0.wEntity(e1.valueOf("EnumType"), "x one");
                b0.wEntity(e1.valueOf("DecimalLiteral"), "12345,000000");
                b0.wEntity(e1.valueOf("IntLiteral"), 12345l);
                b0.wEntity(e1.valueOf("EnumType"), "two");
                b0.wEntity(e1.valueOf("EnumType"), "three");
                b0.wEntity(e1.valueOf("DateLiteral"), new java.util.Date(1135987200000l));
                b0.wEntity(e1.valueOf("DateTimeLiteral"), new java.util.Date(1232557846120l));
                b0.wEntity(e1.valueOf("BooleanLiteral"), true);
                b0.wEntity(e1.valueOf("StringLiteral"), "ciao");
                b0.wEntity(e1.valueOf("DecimalLiteral"), "-123,456000");
                b0._wEntity(e1.valueOf("DataTypes"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("\nhd:\n\theader1 ||\n\t123numericBody !!\n\nhd: header2 || nonNumericBody !!\nhd:\n\theader1 ||\n\t1234567 !!\n\n");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://tests.whole.org/MessagesGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://test.lang.whole.org/Messages").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Messages"), 3);
                b0.wEntity_(e1.valueOf("Message"));
                b0.wEntity(e1.valueOf("Header"), "header1");
                b0.wEntity(e1.valueOf("OtherBody"), "123numericBody");
                b0._wEntity(e1.valueOf("Message"));
                b0.wEntity_(e1.valueOf("Message"));
                b0.wEntity(e1.valueOf("Header"), "header2");
                b0.wEntity(e1.valueOf("NonNumericBody"), "nonNumericBody");
                b0._wEntity(e1.valueOf("Message"));
                b0.wEntity_(e1.valueOf("Message"));
                b0.wEntity(e1.valueOf("Header"), "header1");
                b0.wEntity(e1.valueOf("NumericBody"), 1234567);
                b0._wEntity(e1.valueOf("Message"));
                b0._wEntity(e1.valueOf("Messages"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("events\n  doorClosed  D1CL\n  drawOpened  D2OP\n  lightOn     L1ON\n  doorOpened  D1OP\n  panelClosed PNCL\nend\n\nresetEvents\n  doorOpened\nend\n\ncommands\n  unlockPanel PNUL\n  lockPanel   PNLK\n  lockDoor    D1LK\n  unlockDoor  D1UL\nend\n\nstate idle\n  actions {unlockDoor lockPanel}\n  doorClosed => active\nend\n\nstate active\n  drawOpened => waitingForLight\n  lightOn    => waitingForDraw\nend\n\nstate waitingForLight\n  lightOn => unlockedPanel\nend\n\nstate waitingForDraw\n  drawOpened => unlockedPanel\nend\n\nstate unlockedPanel\n  actions {unlockPanel lockDoor}\n  panelClosed => idle\nend\n");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://tests.lang.whole.org/StateMachineGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://tests.lang.whole.org/StateMachine").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("StateMachine"));
                b0.wEntity_(e1.valueOf("Events"), 5);
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "doorClosed");
                b0.wEntity(e1.valueOf("ID"), "D1CL");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "drawOpened");
                b0.wEntity(e1.valueOf("ID"), "D2OP");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "lightOn");
                b0.wEntity(e1.valueOf("ID"), "L1ON");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "doorOpened");
                b0.wEntity(e1.valueOf("ID"), "D1OP");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "panelClosed");
                b0.wEntity(e1.valueOf("ID"), "PNCL");
                b0._wEntity(e1.valueOf("Event"));
                b0._wEntity(e1.valueOf("Events"));
                b0.wEntity_(e1.valueOf("ResetEvents"), 1);
                b0.wEntity(e1.valueOf("ID"), "doorOpened");
                b0._wEntity(e1.valueOf("ResetEvents"));
                b0.wEntity_(e1.valueOf("Commands"), 4);
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "unlockPanel");
                b0.wEntity(e1.valueOf("ID"), "PNUL");
                b0._wEntity(e1.valueOf("Command"));
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "lockPanel");
                b0.wEntity(e1.valueOf("ID"), "PNLK");
                b0._wEntity(e1.valueOf("Command"));
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "lockDoor");
                b0.wEntity(e1.valueOf("ID"), "D1LK");
                b0._wEntity(e1.valueOf("Command"));
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "unlockDoor");
                b0.wEntity(e1.valueOf("ID"), "D1UL");
                b0._wEntity(e1.valueOf("Command"));
                b0._wEntity(e1.valueOf("Commands"));
                b0.wEntity_(e1.valueOf("States"), 5);
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "idle");
                b0.wEntity_(e1.valueOf("Actions"), 2);
                b0.wEntity(e1.valueOf("ID"), "unlockDoor");
                b0.wEntity(e1.valueOf("ID"), "lockPanel");
                b0._wEntity(e1.valueOf("Actions"));
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "doorClosed");
                b0.wEntity(e1.valueOf("ID"), "active");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "active");
                b0.Resolver();
                b0.wEntity_(e1.valueOf("Transitions"), 2);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "drawOpened");
                b0.wEntity(e1.valueOf("ID"), "waitingForLight");
                b0._wEntity(e1.valueOf("Transition"));
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "lightOn");
                b0.wEntity(e1.valueOf("ID"), "waitingForDraw");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "waitingForLight");
                b0.Resolver();
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "lightOn");
                b0.wEntity(e1.valueOf("ID"), "unlockedPanel");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "waitingForDraw");
                b0.Resolver();
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "drawOpened");
                b0.wEntity(e1.valueOf("ID"), "unlockedPanel");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "unlockedPanel");
                b0.wEntity_(e1.valueOf("Actions"), 2);
                b0.wEntity(e1.valueOf("ID"), "unlockPanel");
                b0.wEntity(e1.valueOf("ID"), "lockDoor");
                b0._wEntity(e1.valueOf("Actions"));
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "panelClosed");
                b0.wEntity(e1.valueOf("ID"), "idle");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0._wEntity(e1.valueOf("States"));
                b0._wEntity(e1.valueOf("StateMachine"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("events\n  doorClosed  D1CL\n  drawOpened  D2OP\n  lightOn     L1ON\n  doorOpened  D1OP\n  panelClosed PNCL\nend\n\nresetEvents\n  doorOpened\nend\n\ncommands\n  unlockPanel PNUL\n  lockPanel   PNLK\n  lockDoor    D1LK\n  unlockDoor  D1UL\nend\n\nstate idle\n  actions {unlockDoor lockPanel}\n  doorClosed => active\nend\n\nstate active\n  drawOpened => waitingForLight\n  lightOn    => waitingForDraw\nend\n\nstate waitingForLight\n  lightOn => unlockedPanel\nend\n\nstate waitingForDraw\n  drawOpened => unlockedPanel\nend\n\nstate unlockedPanel\n  actions {unlockPanel lockDoor}\n  panelClosed => idle\nend\n");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://tests.lang.whole.org/StateMachine2Grammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://tests.lang.whole.org/StateMachine2").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("StateMachine"));
                b0.wEntity_(e1.valueOf("Events"), 5);
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "doorClosed");
                b0.wEntity(e1.valueOf("ID"), "D1CL");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "drawOpened");
                b0.wEntity(e1.valueOf("ID"), "D2OP");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "lightOn");
                b0.wEntity(e1.valueOf("ID"), "L1ON");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "doorOpened");
                b0.wEntity(e1.valueOf("ID"), "D1OP");
                b0._wEntity(e1.valueOf("Event"));
                b0.wEntity_(e1.valueOf("Event"));
                b0.wEntity(e1.valueOf("ID"), "panelClosed");
                b0.wEntity(e1.valueOf("ID"), "PNCL");
                b0._wEntity(e1.valueOf("Event"));
                b0._wEntity(e1.valueOf("Events"));
                b0.wEntity_(e1.valueOf("ResetEvents"), 1);
                b0.wEntity(e1.valueOf("ID"), "doorOpened");
                b0._wEntity(e1.valueOf("ResetEvents"));
                b0.wEntity_(e1.valueOf("Commands"), 4);
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "unlockPanel");
                b0.wEntity(e1.valueOf("ID"), "PNUL");
                b0._wEntity(e1.valueOf("Command"));
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "lockPanel");
                b0.wEntity(e1.valueOf("ID"), "PNLK");
                b0._wEntity(e1.valueOf("Command"));
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "lockDoor");
                b0.wEntity(e1.valueOf("ID"), "D1LK");
                b0._wEntity(e1.valueOf("Command"));
                b0.wEntity_(e1.valueOf("Command"));
                b0.wEntity(e1.valueOf("ID"), "unlockDoor");
                b0.wEntity(e1.valueOf("ID"), "D1UL");
                b0._wEntity(e1.valueOf("Command"));
                b0._wEntity(e1.valueOf("Commands"));
                b0.wEntity_(e1.valueOf("States"), 5);
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "idle");
                b0.wEntity_(e1.valueOf("Actions"), 2);
                b0.wEntity(e1.valueOf("ID"), "unlockDoor");
                b0.wEntity(e1.valueOf("ID"), "lockPanel");
                b0._wEntity(e1.valueOf("Actions"));
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "doorClosed");
                b0.wEntity(e1.valueOf("ID"), "active");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "active");
                b0.Resolver();
                b0.wEntity_(e1.valueOf("Transitions"), 2);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "drawOpened");
                b0.wEntity(e1.valueOf("ID"), "waitingForLight");
                b0._wEntity(e1.valueOf("Transition"));
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "lightOn");
                b0.wEntity(e1.valueOf("ID"), "waitingForDraw");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "waitingForLight");
                b0.Resolver();
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "lightOn");
                b0.wEntity(e1.valueOf("ID"), "unlockedPanel");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "waitingForDraw");
                b0.Resolver();
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "drawOpened");
                b0.wEntity(e1.valueOf("ID"), "unlockedPanel");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0.wEntity_(e1.valueOf("State"));
                b0.wEntity(e1.valueOf("ID"), "unlockedPanel");
                b0.wEntity_(e1.valueOf("Actions"), 2);
                b0.wEntity(e1.valueOf("ID"), "unlockPanel");
                b0.wEntity(e1.valueOf("ID"), "lockDoor");
                b0._wEntity(e1.valueOf("Actions"));
                b0.wEntity_(e1.valueOf("Transitions"), 1);
                b0.wEntity_(e1.valueOf("Transition"));
                b0.wEntity(e1.valueOf("ID"), "panelClosed");
                b0.wEntity(e1.valueOf("ID"), "idle");
                b0._wEntity(e1.valueOf("Transition"));
                b0._wEntity(e1.valueOf("Transitions"));
                b0._wEntity(e1.valueOf("State"));
                b0._wEntity(e1.valueOf("States"));
                b0._wEntity(e1.valueOf("StateMachine"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment13() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("Bob Smith\n{\n\tJoanie Smith,\n\tCathy Smith,\n\tBob Smith\n\t{\n\t\tJosh Smith,\n\t\tJennie Smith,\n\t\tJulie Smith\n\t};\n};\n");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment14() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://examples.whole.org/FamilyGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment15() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://oslo.examples.whole.org/Family").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Persons"), 1);
                b0.wEntity_(e1.valueOf("Person"));
                b0.wEntity(e1.valueOf("First"), "Bob");
                b0.wEntity(e1.valueOf("Last"), "Smith");
                b0.wEntity_(e1.valueOf("Persons"), 3);
                b0.wEntity_(e1.valueOf("Person"));
                b0.wEntity(e1.valueOf("First"), "Joanie");
                b0.wEntity(e1.valueOf("Last"), "Smith");
                b0.Resolver();
                b0._wEntity(e1.valueOf("Person"));
                b0.wEntity_(e1.valueOf("Person"));
                b0.wEntity(e1.valueOf("First"), "Cathy");
                b0.wEntity(e1.valueOf("Last"), "Smith");
                b0.Resolver();
                b0._wEntity(e1.valueOf("Person"));
                b0.wEntity_(e1.valueOf("Person"));
                b0.wEntity(e1.valueOf("First"), "Bob");
                b0.wEntity(e1.valueOf("Last"), "Smith");
                b0.wEntity_(e1.valueOf("Persons"), 3);
                b0.wEntity_(e1.valueOf("Person"));
                b0.wEntity(e1.valueOf("First"), "Josh");
                b0.wEntity(e1.valueOf("Last"), "Smith");
                b0.Resolver();
                b0._wEntity(e1.valueOf("Person"));
                b0.wEntity_(e1.valueOf("Person"));
                b0.wEntity(e1.valueOf("First"), "Jennie");
                b0.wEntity(e1.valueOf("Last"), "Smith");
                b0.Resolver();
                b0._wEntity(e1.valueOf("Person"));
                b0.wEntity_(e1.valueOf("Person"));
                b0.wEntity(e1.valueOf("First"), "Julie");
                b0.wEntity(e1.valueOf("Last"), "Smith");
                b0.Resolver();
                b0._wEntity(e1.valueOf("Person"));
                b0._wEntity(e1.valueOf("Persons"));
                b0._wEntity(e1.valueOf("Person"));
                b0._wEntity(e1.valueOf("Persons"));
                b0._wEntity(e1.valueOf("Person"));
                b0._wEntity(e1.valueOf("Persons"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment16() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("{270570            1235.3}\n{30:Mr. Pippo           270570},\n{30:Mr. Pippo           270570}\n{02}");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment17() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://examples.whole.org/MT3Grammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment18() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://test.whole.org/MT3").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Message"));
                b0.wEntity_(e1.valueOf("Header"));
                b0.wEntity(e1.valueOf("Date"), "270570");
                b0.wEntity(e1.valueOf("Decimal18"), 1235.3);
                b0._wEntity(e1.valueOf("Header"));
                b0.wEntity_(e1.valueOf("Body"), 2);
                b0.wEntity_(e1.valueOf("Msg2"));
                b0.wEntity(e1.valueOf("Name"), "Mr. Pippo           ");
                b0.wEntity(e1.valueOf("DateOfBidth"), "270570");
                b0.Resolver();
                b0._wEntity(e1.valueOf("Msg2"));
                b0.wEntity_(e1.valueOf("Msg2"));
                b0.wEntity(e1.valueOf("Name"), "Mr. Pippo           ");
                b0.wEntity(e1.valueOf("DateOfBidth"), "270570");
                b0.Resolver();
                b0._wEntity(e1.valueOf("Msg2"));
                b0._wEntity(e1.valueOf("Body"));
                b0.wEntity_(e1.valueOf("Trailer"));
                b0.wEntity(e1.valueOf("NofMsg"), "02");
                b0._wEntity(e1.valueOf("Trailer"));
                b0._wEntity(e1.valueOf("Message"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment19() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("0128AGK5009990000000000MUSTERMANN                 070108    1234567890EF00010402               21012008                        10303C50099900700999009876543210080000012346851000 0000000000050099900123456789000001010044   MALEREI PINSEL UND KLECKS G        NIKOLAUS MUSTERMANN                                   1  0501MBH                        02RECHNUNG 1111 VOM 13.1.2008           02 RECHNUNG 1112 VOM 14.1.200028 RECHNUNG 1113 VOM 15.1.200208                                                                  0128E     0000001000000000000000000009876543210000000000700999000000001010044                                                   ");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment20() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://examples.whole.org/DTAUSGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment21() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://xsd.dataintegration.examples.whole.org/DTAUS").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("DTAUS"));
                b0.wEntity_(e1.valueOf("ARecord"));
                b0.wEntity(e1.valueOf("TransactionKind"), "GK");
                b0.wEntity(e1.valueOf("SNumber"), 50099900);
                b0.wEntity(e1.valueOf("Chars"), "MUSTERMANN                 ");
                b0.wEntity(e1.valueOf("SDate"), "070108");
                b0.wEntity(e1.valueOf("LNumber"), 1234567890l);
                b0.wEntity(e1.valueOf("RefType"), "EF00010402");
                b0.wEntity(e1.valueOf("FDate"), "21012008");
                b0.wEntity(e1.valueOf("Currency"), "1");
                b0._wEntity(e1.valueOf("ARecord"));
                b0.wEntity_(e1.valueOf("CRecords"), 1);
                b0.wEntity_(e1.valueOf("CRecord"));
                b0.wEntity(e1.valueOf("Size"), (short) 303);
                b0.wEntity(e1.valueOf("SNumber"), 50099900);
                b0.wEntity(e1.valueOf("SNumber"), 70099900);
                b0.wEntity(e1.valueOf("LNumber"), 9876543210l);
                b0.wEntity(e1.valueOf("InternalID"), "0800000123468");
                b0.wEntity(e1.valueOf("TransactionType"), "51000");
                b0.wEntity(e1.valueOf("AMNumber"), 0l);
                b0.wEntity(e1.valueOf("SNumber"), 50099900);
                b0.wEntity(e1.valueOf("LNumber"), 1234567890l);
                b0.wEntity(e1.valueOf("AMNumber"), 1010044l);
                b0.wEntity(e1.valueOf("Chars"), "MALEREI PINSEL UND KLECKS G");
                b0.wEntity(e1.valueOf("Chars"), "NIKOLAUS MUSTERMANN        ");
                b0.wEntity(e1.valueOf("Chars"), "                           ");
                b0.wEntity(e1.valueOf("Currency"), "1");
                b0.wEntity(e1.valueOf("VSNumber"), 5);
                b0.wEntity(e1.valueOf("ExpansionType"), "01");
                b0.wEntity(e1.valueOf("Chars"), "MBH                        ");
                b0.wEntity(e1.valueOf("ExpansionType"), "02");
                b0.wEntity(e1.valueOf("Chars"), "RECHNUNG 1111 VOM 13.1.2008");
                b0.wEntity_(e1.valueOf("ExpansionRecords"), 1);
                b0.wEntity_(e1.valueOf("ExpansionRecord"));
                b0.wEntity(e1.valueOf("ExpansionType"), "02");
                b0.wEntity(e1.valueOf("Chars"), " RECHNUNG 1112 VOM 14.1.200");
                b0.wEntity(e1.valueOf("ExpansionType"), "02");
                b0.wEntity(e1.valueOf("Chars"), "8 RECHNUNG 1113 VOM 15.1.20");
                b0.wEntity(e1.valueOf("ExpansionType"), "02");
                b0.wEntity(e1.valueOf("Chars"), "08                         ");
                b0.wEntity(e1.valueOf("ExpansionType"), "  ");
                b0.wEntity(e1.valueOf("Chars"), "                           ");
                b0._wEntity(e1.valueOf("ExpansionRecord"));
                b0._wEntity(e1.valueOf("ExpansionRecords"));
                b0._wEntity(e1.valueOf("CRecord"));
                b0._wEntity(e1.valueOf("CRecords"));
                b0.wEntity_(e1.valueOf("ERecord"));
                b0.wEntity(e1.valueOf("RecordNumber"), 1);
                b0.wEntity(e1.valueOf("STotal"), 0l);
                b0.wEntity(e1.valueOf("LTotal"), 9876543210l);
                b0.wEntity(e1.valueOf("LTotal"), 70099900l);
                b0.wEntity(e1.valueOf("STotal"), 1010044l);
                b0._wEntity(e1.valueOf("ERecord"));
                b0._wEntity(e1.valueOf("DTAUS"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment22() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("Ducati Marlboro Team;Ducati;Casey Stoner;1;Marco Melandri;33\nFiat Yamaha Team;Yamaha;Valentino Rossi;46;Jorge Lorenzo;48\nRepsol Honda Team;Honda;Daniel Pedrosa;26;Nicky Hayden;69\nTeam Alice;Ducati;Tony Elias;24;Sylvain Guintoli;50\nHonda Gresini;Honda;Shinya Nakano;56;Alex De Angelis;3\nYamaha Tech 3;Yamaha;Colin Edwards;5;James Toseland;52\nRizla Suzuki MotoGP;Suzuki;Chris Vermeulen;7;Loris Capirossi;65\nKawasaki Racing Team;Kavasaki;John Hopkins;21;Anthony West;13\nHonda LCR;Honda;Randy De Puniet;14; ;0\nJir Scot Team;Honda;Andrea Dovizioso;3; ;0");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment23() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://examples.whole.org/MotoGPTeamsCSVGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment24() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://dataintegration.examples.whole.org/MotoGP").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Teams"), 10);
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Ducati Marlboro Team");
                b0.wEntity(e1.valueOf("Name"), "Ducati");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Casey Stoner");
                b0.wEntity(e1.valueOf("Number"), 1);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Marco Melandri");
                b0.wEntity(e1.valueOf("Number"), 33);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Fiat Yamaha Team");
                b0.wEntity(e1.valueOf("Name"), "Yamaha");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Valentino Rossi");
                b0.wEntity(e1.valueOf("Number"), 46);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Jorge Lorenzo");
                b0.wEntity(e1.valueOf("Number"), 48);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Repsol Honda Team");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Daniel Pedrosa");
                b0.wEntity(e1.valueOf("Number"), 26);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Nicky Hayden");
                b0.wEntity(e1.valueOf("Number"), 69);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Team Alice");
                b0.wEntity(e1.valueOf("Name"), "Ducati");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Tony Elias");
                b0.wEntity(e1.valueOf("Number"), 24);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Sylvain Guintoli");
                b0.wEntity(e1.valueOf("Number"), 50);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Honda Gresini");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Shinya Nakano");
                b0.wEntity(e1.valueOf("Number"), 56);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Alex De Angelis");
                b0.wEntity(e1.valueOf("Number"), 3);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Yamaha Tech 3");
                b0.wEntity(e1.valueOf("Name"), "Yamaha");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Colin Edwards");
                b0.wEntity(e1.valueOf("Number"), 5);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "James Toseland");
                b0.wEntity(e1.valueOf("Number"), 52);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Rizla Suzuki MotoGP");
                b0.wEntity(e1.valueOf("Name"), "Suzuki");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Chris Vermeulen");
                b0.wEntity(e1.valueOf("Number"), 7);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Loris Capirossi");
                b0.wEntity(e1.valueOf("Number"), 65);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Kawasaki Racing Team");
                b0.wEntity(e1.valueOf("Name"), "Kavasaki");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "John Hopkins");
                b0.wEntity(e1.valueOf("Number"), 21);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Anthony West");
                b0.wEntity(e1.valueOf("Number"), 13);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Honda LCR");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Randy De Puniet");
                b0.wEntity(e1.valueOf("Number"), 14);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), " ");
                b0.wEntity(e1.valueOf("Number"), 0);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Jir Scot Team");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Andrea Dovizioso");
                b0.wEntity(e1.valueOf("Number"), 3);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), " ");
                b0.wEntity(e1.valueOf("Number"), 0);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0._wEntity(e1.valueOf("Teams"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment25() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("init source variable");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("source");
                b0.StringLiteral("Ducati Marlboro Team          Ducati    Casey Stoner                01Marco Melandri              33Fiat Yamaha Team              Yamaha    Valentino Rossi             46Jorge Lorenzo               48Repsol Honda Team             Honda     Daniel Pedrosa              26Nicky Hayden                69Team Alice                    Ducati    Tony Elias                  24Sylvain Guintoli            50Honda Gresini                 Honda     Shinya Nakano               56Alex De Angelis             03Yamaha Tech 3                 Yamaha    Colin Edwards               05James Toseland              52Rizla Suzuki MotoGP           Suzuki    Chris Vermeulen             07Loris Capirossi             65Kawasaki Racing Team          Kavasaki  John Hopkins                21Anthony West                13Honda LCR                     Honda     Randy De Puniet             14                            00Jir Scot Team                 Honda     Andrea Dovizioso            03                            00");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment26() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse source using grammar");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Variable("source");
                b0.StringLiteral("http://examples.whole.org/MotoGPTeamsFLFGrammar");
                b1.Resolver();
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment27() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://dataintegration.examples.whole.org/MotoGP").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Teams"), 10);
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Ducati Marlboro Team");
                b0.wEntity(e1.valueOf("Name"), "Ducati");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Casey Stoner");
                b0.wEntity(e1.valueOf("Number"), 1);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Marco Melandri");
                b0.wEntity(e1.valueOf("Number"), 33);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Fiat Yamaha Team");
                b0.wEntity(e1.valueOf("Name"), "Yamaha");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Valentino Rossi");
                b0.wEntity(e1.valueOf("Number"), 46);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Jorge Lorenzo");
                b0.wEntity(e1.valueOf("Number"), 48);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Repsol Honda Team");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Daniel Pedrosa");
                b0.wEntity(e1.valueOf("Number"), 26);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Nicky Hayden");
                b0.wEntity(e1.valueOf("Number"), 69);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Team Alice");
                b0.wEntity(e1.valueOf("Name"), "Ducati");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Tony Elias");
                b0.wEntity(e1.valueOf("Number"), 24);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Sylvain Guintoli");
                b0.wEntity(e1.valueOf("Number"), 50);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Honda Gresini");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Shinya Nakano");
                b0.wEntity(e1.valueOf("Number"), 56);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Alex De Angelis");
                b0.wEntity(e1.valueOf("Number"), 3);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Yamaha Tech 3");
                b0.wEntity(e1.valueOf("Name"), "Yamaha");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Colin Edwards");
                b0.wEntity(e1.valueOf("Number"), 5);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "James Toseland");
                b0.wEntity(e1.valueOf("Number"), 52);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Rizla Suzuki MotoGP");
                b0.wEntity(e1.valueOf("Name"), "Suzuki");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Chris Vermeulen");
                b0.wEntity(e1.valueOf("Number"), 7);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Loris Capirossi");
                b0.wEntity(e1.valueOf("Number"), 65);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Kawasaki Racing Team");
                b0.wEntity(e1.valueOf("Name"), "Kavasaki");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "John Hopkins");
                b0.wEntity(e1.valueOf("Number"), 21);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Anthony West");
                b0.wEntity(e1.valueOf("Number"), 13);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Honda LCR");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Randy De Puniet");
                b0.wEntity(e1.valueOf("Number"), 14);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "");
                b0.wEntity(e1.valueOf("Number"), 0);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0.wEntity_(e1.valueOf("Team"));
                b0.wEntity(e1.valueOf("Name"), "Jir Scot Team");
                b0.wEntity(e1.valueOf("Name"), "Honda");
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "Andrea Dovizioso");
                b0.wEntity(e1.valueOf("Number"), 3);
                b0._wEntity(e1.valueOf("Rider"));
                b0.wEntity_(e1.valueOf("Rider"));
                b0.wEntity(e1.valueOf("Name"), "");
                b0.wEntity(e1.valueOf("Number"), 0);
                b0._wEntity(e1.valueOf("Rider"));
                b0._wEntity(e1.valueOf("Team"));
                b0._wEntity(e1.valueOf("Teams"));
            }
        };
    }
}
