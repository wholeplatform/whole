package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class TestsModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Tests");
        b0.TypeRelations_(1);
        b0.SupertypesOf_();
        b0.Types_(3);
        b0.SimpleName("Expression");
        b0.SimpleName("Statement");
        b0.SimpleName("Description");
        b0._Types();
        b0.AnyType();
        b0._SupertypesOf();
        b0._TypeRelations();
        b0.ModelDeclarations_(55);
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("TestSuite");
        b0.Types_(0);
        b0._Types();
        b0.Features_(6);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("PackageName");
        b0.SimpleName("packageName");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Description");
        b0.SimpleName("description");
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
        b0.SimpleName("Statement");
        b0.SimpleName("deployer");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("FilterFamilies");
        b0.SimpleName("filterFamilies");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("TestCases");
        b0.SimpleName("testCases");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("FilterFamilies");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("unique");
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("FilterFamily");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("FilterFamily");
        b0.Types_(0);
        b0._Types();
        b0.Features_(4);
        b0.Feature_();
        b0.FeatureModifiers_(2);
        b0.FeatureModifier("id");
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("PackageName");
        b0.SimpleName("packageName");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Description");
        b0.SimpleName("description");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("FilterRules");
        b0.SimpleName("filterRules");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("FilterRules");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("unique");
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("FilterRule");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("FilterRule");
        b0.Types_(0);
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Description");
        b0.SimpleName("description");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Statement");
        b0.SimpleName("body");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("TestCases");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("unique");
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("TestCase");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("TestCase");
        b0.Types_(0);
        b0._Types();
        b0.Features_(6);
        b0.Feature_();
        b0.FeatureModifiers_(2);
        b0.FeatureModifier("id");
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("PackageName");
        b0.SimpleName("packageName");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Description");
        b0.SimpleName("description");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Statement");
        b0.SimpleName("deployer");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Aspects");
        b0.SimpleName("aspects");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Tests");
        b0.SimpleName("tests");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("AbstractBehavior");
        b0.Types_(0);
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Description");
        b0.SimpleName("description");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Aspects");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("unique");
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Aspect");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Aspect");
        b0.Types_(1);
        b0.SimpleName("AbstractBehavior");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Statement");
        b0.SimpleName("body");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("BeforeTestCase");
        b0.Types_(1);
        b0.SimpleName("Aspect");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AfterTestCase");
        b0.Types_(1);
        b0.SimpleName("Aspect");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("BeforeTest");
        b0.Types_(1);
        b0.SimpleName("Aspect");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AfterTest");
        b0.Types_(1);
        b0.SimpleName("Aspect");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Tests");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("unique");
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Test");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Test");
        b0.Types_(1);
        b0.SimpleName("AbstractBehavior");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("TestStatements");
        b0.SimpleName("body");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("TestStatements");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("TestStatement");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("TestStatement");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Statement");
        b0.Types_(1);
        b0.SimpleName("TestStatement");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Comment");
        b0.Types_(1);
        b0.SimpleName("TestStatement");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("CommentKind");
        b0.SimpleName("kind");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Description");
        b0.SimpleName("description");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.EnumEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("CommentKind");
        b0.Types_(0);
        b0._Types();
        b0.EnumValues_(3);
        b0.EnumValue("NOTE");
        b0.EnumValue("TODO");
        b0.EnumValue("FIXME");
        b0._EnumValues();
        b0._EnumEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("UsingFilter");
        b0.Types_(1);
        b0.SimpleName("TestStatement");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Filter");
        b0.SimpleName("filter");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SubjectStatement");
        b0.SimpleName("subjectStatement");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("SubjectStatement");
        b0.Types_(1);
        b0.SimpleName("TestStatement");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Expression");
        b0.SimpleName("subject");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Constraint");
        b0.SimpleName("constraint");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AssertThat");
        b0.Types_(1);
        b0.SimpleName("SubjectStatement");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AssumeThat");
        b0.Types_(1);
        b0.SimpleName("SubjectStatement");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Filter");
        b0.Types_(0);
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Constraint");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IsNull");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IsTrue");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IsFalse");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IsDef");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IsUndef");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("HasKind");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Kind");
        b0.SimpleName("kind");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.EnumEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Kind");
        b0.Types_(0);
        b0._Types();
        b0.EnumValues_(12);
        b0.EnumValue("SIMPLE");
        b0.EnumValue("COMPOSITE");
        b0.EnumValue("DATA");
        b0.EnumValue("RESOLVER");
        b0.EnumValue("PROXY");
        b0.EnumValue("ADAPTER");
        b0.EnumValue("IMPL");
        b0.EnumValue("VARIABLE");
        b0.EnumValue("FRAGMENT");
        b0.EnumValue("SAME_STAGE_FRAGMENT");
        b0.EnumValue("STAGE_UP_FRAGMENT");
        b0.EnumValue("STAGE_DOWN_FRAGMENT");
        b0._EnumValues();
        b0._EnumEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IsAssignableTo");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("descriptorName");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("HasType");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("descriptorName");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Throws");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("ThrowableType");
        b0.SimpleName("throwableType");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ThrowableType");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("ObjectConstraint");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Expression");
        b0.SimpleName("object");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Same");
        b0.Types_(1);
        b0.SimpleName("ObjectConstraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Equals");
        b0.Types_(1);
        b0.SimpleName("ObjectConstraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Matches");
        b0.Types_(1);
        b0.SimpleName("ObjectConstraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("DecoratorConstraint");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Constraint");
        b0.SimpleName("constraint");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Not");
        b0.Types_(1);
        b0.SimpleName("DecoratorConstraint");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AllOf");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Constraint");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AnyOf");
        b0.Types_(1);
        b0.SimpleName("Constraint");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Constraint");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Expression");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("BooleanLiteral");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.DataType("boolean");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IntLiteral");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.DataType("int");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("StringLiteral");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("DataName");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Sequence");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.ComponentModifiers_(0);
        b0._ComponentModifiers();
        b0.SimpleName("Expression");
        b0._CompositeEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Name");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("PackageName");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Description");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.tests");
        b1.Resolver();
        b0.URI("http://lang.whole.org/Tests");
        b0._Model();
    }
}
