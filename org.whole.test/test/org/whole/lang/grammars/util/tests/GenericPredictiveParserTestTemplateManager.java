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
        put("fragment22", newfragment22());
        put("fragment23", newfragment23());
        put("fragment24", newfragment24());
        put("fragment25", newfragment25());
        put("fragment26", newfragment26());
        put("fragment27", newfragment27());
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

    public ITemplateFactory<IEntity> newfragment2() {
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

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
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

    public ITemplateFactory<IEntity> newfragment5() {
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

    public ITemplateFactory<IEntity> newfragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment7() {
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

    public ITemplateFactory<IEntity> newfragment8() {
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

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment10() {
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

    public ITemplateFactory<IEntity> newfragment11() {
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

    public ITemplateFactory<IEntity> newfragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment13() {
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

    public ITemplateFactory<IEntity> newfragment14() {
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

    public ITemplateFactory<IEntity> newfragment15() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment16() {
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

    public ITemplateFactory<IEntity> newfragment17() {
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

    public ITemplateFactory<IEntity> newfragment18() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment19() {
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

    public ITemplateFactory<IEntity> newfragment20() {
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


    public ITemplateFactory<IEntity> newfragment22() {
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

    public ITemplateFactory<IEntity> newfragment23() {
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

    public ITemplateFactory<IEntity> newfragment24() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment25() {
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

    public ITemplateFactory<IEntity> newfragment26() {
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

    public ITemplateFactory<IEntity> newfragment27() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
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
                b0._StageUpFragment();
            }
        };
    }
}
