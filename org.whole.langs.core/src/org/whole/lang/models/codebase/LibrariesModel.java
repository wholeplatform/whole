package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class LibrariesModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Libraries");
        b0.TypeRelations_(2);
        b0.SupertypesOf_();
        b0.Types_(3);
        b0.SimpleName("Expression");
        b0.SimpleName("Pattern");
        b0.SimpleName("BindingBody");
        b0._Types();
        b0.AnyType();
        b0._SupertypesOf();
        b0.SubtypesOf_();
        b0.Types_(2);
        b0.SimpleName("ComponentCall");
        b0.SimpleName("Name");
        b0._Types();
        b0.AnyType();
        b0._SubtypesOf();
        b0._TypeRelations();
        b0.ModelDeclarations_(77);
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Library");
        b0.Types_(0);
        b0._Types();
        b0.Features_(6);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("URI");
        b0.SimpleName("uri");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Version");
        b0.SimpleName("version");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Tags");
        b0.SimpleName("tags");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Imports");
        b0.SimpleName("imports");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Rules");
        b0.SimpleName("rules");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Tags");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Name");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Imports");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(0);
        b0._ComponentModifiers();
        b0.SimpleName("URI");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Rules");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Rule");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Rule");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Patterns");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Pattern");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Pattern");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("BindingBody");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("EntityTemplate");
        b0.Types_(6);
        b0.SimpleName("Rule");
        b0.SimpleName("Predicate");
        b0.SimpleName("GroupDeclaration");
        b0.SimpleName("BindingBody");
        b0.SimpleName("Pattern");
        b0.SimpleName("Expression");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("EntityType");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("EntityBody");
        b0.SimpleName("body");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("EntityBody");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Bindings");
        b0.Types_(1);
        b0.SimpleName("EntityBody");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Binding");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Expressions");
        b0.Types_(1);
        b0.SimpleName("EntityBody");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Expression");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Binding");
        b0.Types_(1);
        b0.SimpleName("ValuePoint");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("BindingBody");
        b0.SimpleName("body");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Constraints");
        b0.Types_(1);
        b0.SimpleName("BindingBody");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Constraint");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Group");
        b0.Types_(2);
        b0.SimpleName("Rule");
        b0.SimpleName("GroupDeclaration");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("EntityType");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("GroupBody");
        b0.SimpleName("body");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("GroupBody");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("GroupDeclaration");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("GroupDeclaration");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("FlowEntity");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Relation");
        b0.Types_(1);
        b0.SimpleName("Rule");
        b0._Types();
        b0.Features_(5);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("EntityType");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("sources");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("targets");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("ComponentFlow");
        b0.SimpleName("flow");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("ComponentDeclarations");
        b0.SimpleName("where");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Component");
        b0.Types_(3);
        b0.SimpleName("Rule");
        b0.SimpleName("FlowEntity");
        b0.SimpleName("ComponentDeclaration");
        b0._Types();
        b0.Features_(5);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("EntityType");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("sources");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("targets");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("ComponentFlow");
        b0.SimpleName("flow");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("ComponentDeclarations");
        b0.SimpleName("where");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ComponentDeclarations");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("ComponentDeclaration");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("ComponentDeclaration");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("ComponentFlow");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("MatchCases");
        b0.Types_(1);
        b0.SimpleName("ComponentFlow");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("MatchCase");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("MatchCase");
        b0.Types_(0);
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Patterns");
        b0.SimpleName("patterns");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("ComponentFlow");
        b0.SimpleName("flow");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("SequenceCall");
        b0.Types_(1);
        b0.SimpleName("ComponentFlow");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("FlowEntity");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AndCall");
        b0.Types_(1);
        b0.SimpleName("FlowEntity");
        b0._Types();
        b0.ComponentModifiers_(0);
        b0._ComponentModifiers();
        b0.SimpleName("SequenceCall");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("OrCall");
        b0.Types_(1);
        b0.SimpleName("FlowEntity");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("SequenceCall");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ComponentCall");
        b0.Types_(1);
        b0.SimpleName("FlowEntity");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("EntityType");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("sources");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("targets");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Match");
        b0.Types_(1);
        b0.SimpleName("FlowEntity");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Pattern");
        b0.SimpleName("pattern");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Build");
        b0.Types_(1);
        b0.SimpleName("FlowEntity");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Pattern");
        b0.SimpleName("pattern");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Constraint");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("DependentConstraint");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Joinpoint");
        b0.SimpleName("dependGroup");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Invariant");
        b0.Types_(1);
        b0.SimpleName("DependentConstraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Predicate");
        b0.SimpleName("predicate");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Validation");
        b0.Types_(1);
        b0.SimpleName("DependentConstraint");
        b0._Types();
        b0.Features_(4);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("ValidationKind");
        b0.SimpleName("kind");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Message");
        b0.SimpleName("message");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Predicate");
        b0.SimpleName("predicate");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Expression");
        b0.SimpleName("helper");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Initializer");
        b0.Types_(1);
        b0.SimpleName("DependentConstraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Expression");
        b0.SimpleName("expression");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Derivation");
        b0.Types_(1);
        b0.SimpleName("DependentConstraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Expression");
        b0.SimpleName("expression");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Action");
        b0.Types_(1);
        b0.SimpleName("DependentConstraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Expression");
        b0.SimpleName("expression");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Expression");
        b0.Types_(2);
        b0.SimpleName("ComponentDeclaration");
        b0.SimpleName("ComponentFlow");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("RelationCall");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("EntityType");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("bindings");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("EntityCall");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Name");
        b0.SimpleName("selfEntity");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("EntityType");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Bindings");
        b0.SimpleName("bindings");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Assert");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Pointcut");
        b0.SimpleName("assertGroup");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Literal");
        b0.Types_(3);
        b0.SimpleName("Expression");
        b0.SimpleName("Pattern");
        b0.SimpleName("BindingBody");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("BooleanLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("boolean");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ByteLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("byte");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("CharLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("char");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("DoubleLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("double");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("FloatLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("float");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IntLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("int");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("LongLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("long");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ShortLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("short");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("DateLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("java.util.Date");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("EnumLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("StringLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ObjectLiteral");
        b0.Types_(1);
        b0.SimpleName("Literal");
        b0._Types();
        b0.DataType("Object");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Joinpoint");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("ValuePoint");
        b0.Types_(1);
        b0.SimpleName("Joinpoint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AndPoint");
        b0.Types_(1);
        b0.SimpleName("Joinpoint");
        b0._Types();
        b0.ComponentModifiers_(0);
        b0._ComponentModifiers();
        b0.SimpleName("Joinpoint");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("OrPoint");
        b0.Types_(1);
        b0.SimpleName("Joinpoint");
        b0._Types();
        b0.ComponentModifiers_(0);
        b0._ComponentModifiers();
        b0.SimpleName("Joinpoint");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("History");
        b0.Types_(1);
        b0.SimpleName("Joinpoint");
        b0._Types();
        b0.ComponentModifiers_(0);
        b0._ComponentModifiers();
        b0.SimpleName("ValuePoint");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Pointcut");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AllPoint");
        b0.Types_(1);
        b0.SimpleName("Pointcut");
        b0._Types();
        b0.ComponentModifiers_(0);
        b0._ComponentModifiers();
        b0.SimpleName("Pointcut");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Predicate");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Type");
        b0.Types_(1);
        b0.SimpleName("Predicate");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("VoidType");
        b0.Types_(1);
        b0.SimpleName("Type");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AnyType");
        b0.Types_(1);
        b0.SimpleName("Type");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("EntityType");
        b0.Types_(2);
        b0.SimpleName("Type");
        b0.SimpleName("GroupDeclaration");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("DataType");
        b0.Types_(1);
        b0.SimpleName("Type");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("CustomType");
        b0.Types_(1);
        b0.SimpleName("DataType");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.EnumEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("PrimitiveType");
        b0.Types_(1);
        b0.SimpleName("DataType");
        b0._Types();
        b0.EnumValues_(10);
        b0.EnumValue("BOOLEAN");
        b0.EnumValue("BYTE");
        b0.EnumValue("CHAR");
        b0.EnumValue("DOUBLE");
        b0.EnumValue("FLOAT");
        b0.EnumValue("INT");
        b0.EnumValue("LONG");
        b0.EnumValue("SHORT");
        b0.EnumValue("STRING");
        b0.EnumValue("DATE");
        b0._EnumValues();
        b0._EnumEntity();
        b0.EnumEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("CollectionType");
        b0.Types_(1);
        b0.SimpleName("DataType");
        b0._Types();
        b0.EnumValues_(4);
        b0.EnumValue("LIST");
        b0.EnumValue("ORDERED_SET");
        b0.EnumValue("SET");
        b0.EnumValue("BAG");
        b0._EnumValues();
        b0._EnumEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Multiplicity");
        b0.Types_(1);
        b0.SimpleName("Predicate");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("CollectionType");
        b0.SimpleName("type");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Predicate");
        b0.SimpleName("bounds");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Predicate");
        b0.SimpleName("element");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Name");
        b0.Types_(3);
        b0.SimpleName("ValuePoint");
        b0.SimpleName("Pointcut");
        b0.SimpleName("BindingBody");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("URI");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Version");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Message");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.EnumEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ValidationKind");
        b0.Types_(0);
        b0._Types();
        b0.EnumValues_(3);
        b0.EnumValue("ERROR");
        b0.EnumValue("WARNING");
        b0.EnumValue("INFO");
        b0._EnumValues();
        b0._EnumEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.libraries");
        b1.Resolver();
        b0.URI("http://lang.whole.org/Libraries");
        b0._Model();
    }
}
