package org.whole.lang.xsd.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class SchemaModelsActions extends AbstractTemplateFactory<org.whole.lang.actions.model.LanguageActionFactory> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.actions.builders.IActionsBuilder b0 = (org.whole.lang.actions.builders.IActionsBuilder) op.wGetBuilder(org.whole.lang.actions.reflect.ActionsLanguageKit.URI);
        b0.LanguageActionFactory_();
        b0.URI("whole:org.whole.lang.xsd.codebase:SchemaModelsActions");
        b0.Namespace("org.whole.lang.xsd.codebase");
        b0.Name("Schema Models Actions");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b1.Resolver();
        b0.ToolbarActions_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b0._ToolbarActions();
        b0.ContextMenuActions_();
        b0.MenuActions_(1);
        b0.GuardedAction_();
        b0.Label("Generate Xml Schema and Mapping from Models instance");
        org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b2.Block_(3);
        b2.Select_();
        b2.Filter_();
        b1.StageUpFragment_();
        org.whole.lang.artifacts.builders.IArtifactsBuilder b3 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
        b3.Workspace_();
        b1.Resolver();
        b3.Projects_(1);
        b3.Project_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("projectName");
        b1.Quantifier("!");
        b1._Variable();
        b1.Resolver();
        b3.Metadata_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b3._Metadata();
        b3.Artifacts_(1);
        b3.FolderArtifact_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("sourceFolderName");
        b1.Quantifier("!");
        b1._Variable();
        b3.Metadata_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b3._Metadata();
        b3.Artifacts_(1);
        b3.PackageArtifact_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("packageName");
        b1.Quantifier("!");
        b1._Variable();
        b3.Metadata_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b3._Metadata();
        b3.Artifacts_(2);
        b3.FileArtifact_();
        b3.NameWithExtension_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("modelName");
        b1.Quantifier("!");
        b1._Variable();
        b3.Extension("xsd");
        b3._NameWithExtension();
        b3.Metadata_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b3.PersistenceKitId("org.whole.lang.xsd.codebase.XsdPersistenceKit");
        b3._Metadata();
        b1.StageUpFragment_();
        b1.Variable_();
        b1.VarType("http://www.w3.org/2001/XMLSchema#Schema");
        b1.VarName("schema");
        b1.Quantifier("!");
        b1._Variable();
        b1._StageUpFragment();
        b3._FileArtifact();
        b3.FileArtifact_();
        b3.NameWithExtension_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("mappingFileName");
        b1.Quantifier("!");
        b1._Variable();
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
        b1.VarType("http://www.w3.org/2001/XMLSchema#Schema");
        b1.VarName("mapping");
        b1.Quantifier("!");
        b1._Variable();
        b1._StageUpFragment();
        b3._FileArtifact();
        b3._Artifacts();
        b3._PackageArtifact();
        b3._Artifacts();
        b3._FolderArtifact();
        b3._Artifacts();
        b1.Resolver();
        b3._Project();
        b3._Projects();
        b3._Workspace();
        b1._StageUpFragment();
        b2.VariableTest("workspace");
        b2._Filter();
        b2.SelfStep();
        b2.Sequence_(3);
        b2.Filter_();
        b2.FeatureStep("http://lang.whole.org/Models#name");
        b2.VariableTest("modelName");
        b2._Filter();
        b2.Filter_();
        b2.Addition_();
        b2.VariableRefStep("modelName");
        b2.StringLiteral("Mapping");
        b2._Addition();
        b2.VariableTest("mappingFileName");
        b2._Filter();
        b2.Path_(2);
        b1.SameStageFragment_();
        org.whole.lang.workflows.builders.IWorkflowsBuilder b4 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
        b4.Sequence_();
        b4.Text("sequence");
        b4.FlowObjects_(3);
        b4.CreateJavaClassInstance_();
        b4.Text("create a ModelToXmlSchemaQuery factory");
        b4.Variable("modelToXmlSchemaQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery");
        b4.StringLiteral("ModelToXmlSchemaQuery()");
        b1.Resolver();
        b4._CreateJavaClassInstance();
        b4.InvokeJavaInstanceMethod_();
        b4.Text("create a ModelToXmlSchemaQuery");
        b4.Variable("modelToXmlSchema");
        b4.Variable("modelToXmlSchemaQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery");
        b4.StringLiteral("create()");
        b1.Resolver();
        b4._InvokeJavaInstanceMethod();
        b4.InvokeJavaClassMethod_();
        b4.Text("clone self model");
        b1.Resolver();
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.util.EntityUtils");
        b4.StringLiteral("clone(org.whole.lang.model.IEntity)");
        b4.Expressions_(1);
        b4.Variable("self");
        b4._Expressions();
        b4._InvokeJavaClassMethod();
        b4._FlowObjects();
        b4._Sequence();
        b1._SameStageFragment();
        b2.Call_();
        b2.Name("modelToXmlSchema");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2._Sequence();
        b2.TemplateNames();
        b2._Select();
        b4.InvokeOperation_();
        b4.Text("generate workspace");
        b4.Variable("workspace");
        b4.Operation("ARTIFACTS_GENERATOR");
        b1.Resolver();
        b4._InvokeOperation();
        b2.SelfStep();
        b2._Block();
        b2.TypeTest("http://lang.whole.org/Models#Model");
        b0._GuardedAction();
        b0._MenuActions();
        b0.MenuActions_(1);
        b0.GuardedAction_();
        b0.Label("Map Xml Schema To Models - assign type and feature names");
        b2.Block_(3);
        b1.SameStageFragment_();
        b4.Sequence_();
        b4.Text("sequence");
        b4.FlowObjects_(2);
        b4.CreateJavaClassInstance_();
        b4.Text("create a AnnotateXmlSchemaQuery factory");
        b4.Variable("annotateXmlSchemaQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.AnnotateXmlSchemaQuery");
        b4.StringLiteral("AnnotateXmlSchemaQuery()");
        b1.Resolver();
        b4._CreateJavaClassInstance();
        b4.InvokeJavaInstanceMethod_();
        b4.Text("create a AnnotateXmlSchemaQuery");
        b4.Variable("annotateXmlSchema");
        b4.Variable("annotateXmlSchemaQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.AnnotateXmlSchemaQuery");
        b4.StringLiteral("create()");
        b1.Resolver();
        b4._InvokeJavaInstanceMethod();
        b4._FlowObjects();
        b4._Sequence();
        b1._SameStageFragment();
        b2.Call_();
        b2.Name("annotateXmlSchema");
        b1.Resolver();
        b2._Call();
        b2.SelfStep();
        b2._Block();
        b2.TypeTest("http://www.w3.org/2001/XMLSchema#Schema");
        b0._GuardedAction();
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b0.MenuActions_(2);
        b0.GuardedAction_();
        b0.Label("Map Xml Schema To Models - generate models and mappings");
        b2.Block_(2);
        b1.SameStageFragment_();
        b4.Sequence_();
        b4.Text("sequence");
        b4.FlowObjects_(2);
        b4.CreateJavaClassInstance_();
        b4.Text("create a AnnotatedXmlSchemaToModelsAndMappingQuery factory");
        b4.Variable("annotatedXmlSchemaToModelsAndMappingQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.AnnotatedXmlSchemaToModelsAndMappingQuery");
        b4.StringLiteral("AnnotatedXmlSchemaToModelsAndMappingQuery()");
        b1.Resolver();
        b4._CreateJavaClassInstance();
        b4.InvokeJavaInstanceMethod_();
        b4.Text("create a AnnotatedXmlSchemaToModelsAndMappingQuery");
        b4.Variable("annotatedXmlSchemaToModelsAndMapping");
        b4.Variable("annotatedXmlSchemaToModelsAndMappingQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery");
        b4.StringLiteral("create()");
        b1.Resolver();
        b4._InvokeJavaInstanceMethod();
        b4._FlowObjects();
        b4._Sequence();
        b1._SameStageFragment();
        b2.Call_();
        b2.Name("annotatedXmlSchemaToModelsAndMapping");
        b1.Resolver();
        b2._Call();
        b2._Block();
        b2.TypeTest("http://www.w3.org/2001/XMLSchema#Schema");
        b0._GuardedAction();
        b0.GuardedAction_();
        b0.Label("Map Models To Xml Schema");
        b2.Block_(2);
        b1.SameStageFragment_();
        b4.Sequence_();
        b4.Text("sequence");
        b4.FlowObjects_(2);
        b4.CreateJavaClassInstance_();
        b4.Text("create a ModelToXmlSchemaQuery factory");
        b4.Variable("modelToXmlSchemaQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery");
        b4.StringLiteral("ModelToXmlSchemaQuery()");
        b1.Resolver();
        b4._CreateJavaClassInstance();
        b4.InvokeJavaInstanceMethod_();
        b4.Text("create a ModelToXmlSchemaQuery");
        b4.Variable("modelToXmlSchema");
        b4.Variable("modelToXmlSchemaQueryFactory");
        b1.Resolver();
        b4.StringLiteral("org.whole.lang.xsd.codebase.ModelToXmlSchemaQuery");
        b4.StringLiteral("create()");
        b1.Resolver();
        b4._InvokeJavaInstanceMethod();
        b4._FlowObjects();
        b4._Sequence();
        b1._SameStageFragment();
        b2.Call_();
        b2.Name("modelToXmlSchema");
        b1.Resolver();
        b2._Call();
        b2._Block();
        b2.TypeTest("http://lang.whole.org/Models#Model");
        b0._GuardedAction();
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b1.Resolver();
        b0._ContextMenuActions();
        b0._LanguageActionFactory();
    }
}
