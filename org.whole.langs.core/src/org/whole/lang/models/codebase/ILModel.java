package org.whole.lang.models.codebase;

import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.models.builders.IModelsBuilder;

/**
 * @generator Whole
 */
public class ILModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {
	public void apply(IBuilderOperation op) {
		IModelsBuilder b0 = (IModelsBuilder) op
				.wGetBuilder(ModelsLanguageKit.URI);
		b0.Model_();
		b0.SimpleName("IL");
		b0.TypeRelations_(0);
		b0._TypeRelations();
		b0.ModelDeclarations_(42);
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("FunctionDeclaration");
		b0.Types_(1);
		b0.SimpleName("Declaration");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Type");
		b0.SimpleName("type");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Name");
		b0.SimpleName("name");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Parameters");
		b0.SimpleName("parameters");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Statement");
		b0.SimpleName("body");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Parameters");
		b0.Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("Parameter");
		b0._CompositeEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Parameter");
		b0.Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Type");
		b0.SimpleName("type");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Name");
		b0.SimpleName("name");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("VariableDeclaration");
		b0.Types_(1);
		b0.SimpleName("Declaration");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Type");
		b0.SimpleName("type");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Name");
		b0.SimpleName("name");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers_(1);
		b0.FeatureModifier("optional");
		b0._FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("initializer");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Declaration");
        b0.Types_(1);
        b0.SimpleName("Statement");
        b0._Types();
        b0.Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("EmptyStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ReturnStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("IfStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("condition");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Statement");
		b0.SimpleName("trueBody");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("IfElseStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("condition");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Statement");
		b0.SimpleName("trueBody");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Statement");
		b0.SimpleName("falseBody");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("WhileStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("condition");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Statement");
		b0.SimpleName("trueBody");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DoWhileStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Statement");
		b0.SimpleName("trueBody");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("condition");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ForStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("VariableDeclaration");
		b0.SimpleName("initializer");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("condition");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("updater");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Statement");
		b0.SimpleName("trueBody");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("BlockStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("Statement");
		b0._CompositeEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("PrintStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("PrintlnStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers_(1);
		b0.FeatureModifier("optional");
		b0._FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SaveStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers_(1);
		b0.FeatureModifier("optional");
		b0._FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("fileName");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ExpressionStatement");
		b0.Types_(1);
		b0.SimpleName("Statement");
		b0._Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("LoadExpression");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("fileName");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers_(1);
		b0.FeatureModifier("optional");
		b0._FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("language");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("FunctionInvocationExpression");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("NameExpression");
		b0.SimpleName("name");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Arguments");
		b0.SimpleName("arguments");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Arguments");
		b0.Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("Expression");
		b0._CompositeEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AssignmentExpression");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Name");
		b0.SimpleName("name");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("RunExpression");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Literal");
        b0.Types_(1);
        b0.SimpleName("Expression");
        b0._Types();
        b0.Features();
        b0._SimpleEntity();
        b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("BooleanLiteral");
		b0.Types_(1);
		b0.SimpleName("Literal");
		b0._Types();
		b0.DataType("boolean");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("IntLiteral");
		b0.Types_(1);
		b0.SimpleName("Literal");
		b0._Types();
		b0.DataType("int");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("StringLiteral");
		b0.Types_(1);
		b0.SimpleName("Literal");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Name");
		b0.Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("NameExpression");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.EnumEntity_();
		b0.EntityModifiers();
		b0.SimpleName("PrimitiveType");
		b0.Types_(1);
		b0.SimpleName("Type");
		b0._Types();
		b0.EnumValues_(6);
		b0.EnumValue("boolean");
		b0.EnumValue("int");
		b0.EnumValue("string");
		b0.EnumValue("entity");
		b0.EnumValue("function");
		b0.EnumValue("void");
		b0._EnumValues();
		b0._EnumEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Addition");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Subtraction");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Multiplication");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Division");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("And");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Or");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Not");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Equals");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("NotEquals");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("LessThan");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("LessOrEquals");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("GreaterThan");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("GreaterOrEquals");
		b0.Types_(1);
		b0.SimpleName("Expression");
		b0._Types();
		b0.Features_(2);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("Expression");
		b0.SimpleName("exp2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.il");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/IL");
		b0._Model();
	}
}