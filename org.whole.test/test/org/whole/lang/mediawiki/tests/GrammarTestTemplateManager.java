package org.whole.lang.mediawiki.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class GrammarTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final GrammarTestTemplateManager instance = new GrammarTestTemplateManager();
    }

    public static GrammarTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private GrammarTestTemplateManager() {
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
        put("fragment28", newFragment28());
        put("fragment29", newFragment29());
        put("fragment30", newFragment30());
        put("fragment31", newFragment31());
        put("fragment32", newFragment32());
        put("fragment33", newFragment33());
    }

    public ITemplateFactory<IEntity> newFragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Sequence_();
                b0.Text("sequence");
                b0.FlowObjects_(2);
                b0.LoadModel_();
                b0.Text("load mediaWikiGrammar");
                b0.Variable("mediaWikiGrammar");
                b0.StringLiteral("org.whole.lang.java.codebase.JavaBuilderPersistenceKit");
                b0.ResourceKind("CLASSPATH");
                b0.StringLiteral("org/whole/lang/grammars/codebase/MediaWikiGrammar.class");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._LoadModel();
                b0.InvokeOperation_();
                b0.Text("interpret mediaWikiGrammar");
                b0.Variable("mediaWikiGrammar");
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
                b0.Text("assignactivity");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("whole:org.whole.lang.mediawiki:MediaWikiGrammar");
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
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|\n|Orange\n|Apple\n|-\n|Bread\n|Pie\n|-\n|Butter\n|Ice cream \n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.Resolver();
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|\n|Orange||Apple||more\n|-\n|Bread||Pie||more\n|-\n|Butter||Ice<br />cream||and<br />more\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.Resolver();
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "more");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "more");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 3);
                b0.wEntity(e1.valueOf("Text"), "Ice");
                b0.wEntity(e1.valueOf("LineBreak"));
                b0.wEntity(e1.valueOf("Text"), "cream");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 3);
                b0.wEntity(e1.valueOf("Text"), "and");
                b0.wEntity(e1.valueOf("LineBreak"));
                b0.wEntity(e1.valueOf("Text"), "more");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|\n|  Orange    ||   Apple   ||   more\n|-\n|   Bread    ||   Pie     ||   more\n|-\n|   Butter   || Ice cream ||  and more\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.Resolver();
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange    ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple   ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "more");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread    ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie     ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "more");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter   ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "and more");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|\n|Lorem ipsum dolor sit amet,FIXME\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.Resolver();
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 1);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 1);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Lorem ipsum dolor sit amet,FIXME");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|\n! Item\n! Amount\n! Cost\n|-\n|Orange\n|10\n|7.00\n|-\n|Bread\n|4\n|3.00\n|-\n|Butter\n|1\n|5.00\n|-\n!Total\n|\n|15.00\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.Resolver();
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 5);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Item");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Amount");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Cost");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "10");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "7.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "4");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "3.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "1");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "5.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Total");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "15.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|\n|+Food complements\n|-\n|Orange\n|Apple\n|-\n|Bread\n|Pie\n|-\n|Butter\n|Ice cream \n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment13() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableCaption"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Food complements");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableCaption"));
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment14() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| border=\"1\" align=\"center\" style=\"text-align:center;\"\n|Orange\n|Apple\n|12,333.00\n|-\n|Bread\n|Pie\n|500.00\n|-\n|Butter\n|Ice cream\n|1.00\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment15() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 3);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "center");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("CSSStyle"), 1);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "text-align");
                b0.wEntity(e1.valueOf("Value"), "center");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "12,333.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "500.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "1.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment16() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| border=\"1\"\n|Orange\n|Apple\n|align=\"right\" | 12,333.00\n|-\n|Bread\n|Pie\n|align=\"right\" | 500.00\n|-\n|Butter\n|Ice cream\n|align=\"right\" | 1.00\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment17() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "12,333.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "500.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "1.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment18() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| border=\"1\"\n| Orange || Apple     || align=\"right\" | 12,333.00\n|-\n| Bread  || Pie       || align=\"right\" | 500.00\n|-\n| Butter || Ice cream || align=\"right\" | 1.00\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment19() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple     ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "12,333.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread  ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie       ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "500.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "1.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment20() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| border=\"1\"\n|Orange\n|Apple\n|align=\"right\"|12,333.00\n|-\n|Bread\n|Pie\n|align=\"right\"|500.00\n|- style=\"font-style:italic; color:green;\"\n|Butter\n|Ice cream\n|align=\"right\"|1.00\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment21() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "12,333.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "500.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "font-style");
                b0.wEntity(e1.valueOf("Value"), "italic");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "color");
                b0.wEntity(e1.valueOf("Value"), "green");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "right");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "1.00");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment22() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|style=\"border-collapse: separate; border-spacing: 0; border-width: 1px; border-style: solid; border-color: #000; padding: 0\"\n|-\n!style=\"border-style: solid; border-width: 0 1px 1px 0\"| Orange\n!style=\"border-style: solid; border-width: 0 0 1px 0\"| Apple\n|-\n|style=\"border-style: solid; border-width: 0 1px 0 0\"| Bread\n|style=\"border-style: solid; border-width: 0\"| Pie\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment23() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 6);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-collapse");
                b0.wEntity(e1.valueOf("Value"), "separate");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-spacing");
                b0.wEntity(e1.valueOf("Value"), "0");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "1px");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-color");
                b0.wEntity(e1.valueOf("Value"), "#000");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "padding");
                b0.wEntity(e1.valueOf("Value"), "0");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 2);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "0 1px 1px 0");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "0 0 1px 0");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "0 1px 0 0");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "0");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment24() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{|style=\"border-collapse: collapse; border-width: 1px; border-style: solid; border-color: #000\"\n|-\n!style=\"border-style: solid; border-width: 1px\"| Orange\n!style=\"border-style: solid; border-width: 1px\"| Apple\n|-\n|style=\"border-style: solid; border-width: 1px\"| Bread\n|style=\"border-style: solid; border-width: 1px\"| Pie\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment25() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 4);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-collapse");
                b0.wEntity(e1.valueOf("Value"), "collapse");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "1px");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-color");
                b0.wEntity(e1.valueOf("Value"), "#000");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 2);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "1px");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "1px");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "1px");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-style");
                b0.wEntity(e1.valueOf("Value"), "solid");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "border-width");
                b0.wEntity(e1.valueOf("Value"), "1px");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment26() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| border=\"1\"\n!colspan=\"6\"|Shopping List\n|-\n|rowspan=\"2\"|Bread & Butter\n|Pie\n|Buns\n|Danish\n|colspan=\"2\"|Croissant\n|-\n|Cheese\n|colspan=\"2\"|Ice cream\n|Butter\n|Yoghurt\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment27() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 1);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "colspan");
                b0.wEntity(e1.valueOf("Value1"), "6");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Shopping List");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 5);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "rowspan");
                b0.wEntity(e1.valueOf("Value1"), "2");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread & Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Buns");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Danish");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "colspan");
                b0.wEntity(e1.valueOf("Value1"), "2");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Croissant");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 4);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Cheese");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "colspan");
                b0.wEntity(e1.valueOf("Value1"), "2");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Yoghurt");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment28() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| style=\"color:green; background-color:#ffffcc;\" cellpadding=\"10\" cellspacing=\"0\" border=\"1\"\n|Orange\n|Apple\n|-\n|Bread\n|Pie\n|-\n|Butter\n|Ice cream \n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment29() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 4);
                b0.wEntity_(e1.valueOf("CSSStyle"), 2);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "color");
                b0.wEntity(e1.valueOf("Value"), "green");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "background-color");
                b0.wEntity(e1.valueOf("Value"), "#ffffcc");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "cellpadding");
                b0.wEntity(e1.valueOf("Value1"), "10");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "cellspacing");
                b0.wEntity(e1.valueOf("Value1"), "0");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment30() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| border=\"1\" cellpadding=\"20\" cellspacing=\"0\"\n|+ align=\"bottom\" style=\"color:#e76700;\" |''Food complements''\n|-\n|Orange\n|Apple\n|-\n|Bread\n|Pie\n|-\n|Butter\n|Ice cream \n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment31() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 3);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "cellpadding");
                b0.wEntity(e1.valueOf("Value1"), "20");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "cellspacing");
                b0.wEntity(e1.valueOf("Value1"), "0");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("TableCaption"));
                b0.wEntity_(e1.valueOf("Attributes"), 2);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "align");
                b0.wEntity(e1.valueOf("Value1"), "bottom");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("CSSStyle"), 1);
                b0.wEntity_(e1.valueOf("CSSAttribute"));
                b0.wEntity(e1.valueOf("Name"), "color");
                b0.wEntity(e1.valueOf("Value"), "#e76700");
                b0._wEntity(e1.valueOf("CSSAttribute"));
                b0._wEntity(e1.valueOf("CSSStyle"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity_(e1.valueOf("Italics"));
                b0.wEntity(e1.valueOf("Text"), "Food complements");
                b0._wEntity(e1.valueOf("Italics"));
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableCaption"));
                b0.wEntity_(e1.valueOf("TableRows"), 3);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Orange");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Apple");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Pie");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Ice cream ");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment32() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.Parse_();
                b0.Text("parse");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.StringLiteral("{| border=\"1\" cellspacing=\"0\" cellpadding=\"2\"\n|-\n!scope=\"col\"| Item\n!scope=\"col\"| Quantity\n!scope=\"col\"| Price\n|-\n!scope=\"row\"| Bread\n| 0.3 kg\n| $0.65\n|-\n!scope=\"row\"| Butter\n| 0.125 kg\n| $1.25\n|-\n!scope=\"row\" colspan=\"2\"| Total\n| $1.90\n|}\n");
                b0.Variable("mediawikiGrammar");
                b0.StringLiteral("Table");
                b0._Parse();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment33() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.mediawiki:MediaWiki").getEntityDescriptorEnum();
                b0.wEntity_(e1.valueOf("Table"));
                b0.wEntity_(e1.valueOf("Attributes"), 3);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "border");
                b0.wEntity(e1.valueOf("Value1"), "1");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "cellspacing");
                b0.wEntity(e1.valueOf("Value1"), "0");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "cellpadding");
                b0.wEntity(e1.valueOf("Value1"), "2");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableRows"), 4);
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "scope");
                b0.wEntity(e1.valueOf("Value1"), "col");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Item");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "scope");
                b0.wEntity(e1.valueOf("Value1"), "col");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Quantity");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "scope");
                b0.wEntity(e1.valueOf("Value1"), "col");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Price");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "scope");
                b0.wEntity(e1.valueOf("Value1"), "row");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Bread");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "0.3 kg");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "$0.65");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 3);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 1);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "scope");
                b0.wEntity(e1.valueOf("Value1"), "row");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Butter");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "0.125 kg");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "$1.25");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0.wEntity_(e1.valueOf("TableRow"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("TableColumns"), 2);
                b0.wEntity_(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("Attributes"), 2);
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "scope");
                b0.wEntity(e1.valueOf("Value1"), "row");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0.wEntity_(e1.valueOf("HtmlAttribute"));
                b0.wEntity(e1.valueOf("Name1"), "colspan");
                b0.wEntity(e1.valueOf("Value1"), "2");
                b0._wEntity(e1.valueOf("HtmlAttribute"));
                b0._wEntity(e1.valueOf("Attributes"));
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "Total");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableHeader"));
                b0.wEntity_(e1.valueOf("TableData"));
                b0.Resolver();
                b0.wEntity_(e1.valueOf("InlineText"), 1);
                b0.wEntity(e1.valueOf("Text"), "$1.90");
                b0._wEntity(e1.valueOf("InlineText"));
                b0._wEntity(e1.valueOf("TableData"));
                b0._wEntity(e1.valueOf("TableColumns"));
                b0._wEntity(e1.valueOf("TableRow"));
                b0._wEntity(e1.valueOf("TableRows"));
                b0._wEntity(e1.valueOf("Table"));
            }
        };
    }
}
