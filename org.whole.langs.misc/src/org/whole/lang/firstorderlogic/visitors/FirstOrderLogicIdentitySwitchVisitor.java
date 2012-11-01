package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class FirstOrderLogicIdentitySwitchVisitor extends
		AbstractVisitor implements IFirstOrderLogicVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case FirstOrderLogicEntityDescriptorEnum.Theory_ord:
			visit((Theory) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportTheories_ord:
			visit((ImportTheories) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.ImportDeclaration_ord:
			visit((ImportDeclaration) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Declarations_ord:
			visit((Declarations) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Assertions_ord:
			visit((Assertions) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.EntityName_ord:
			visit((EntityName) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.FeatureName_ord:
			visit((FeatureName) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.LanguageName_ord:
			visit((LanguageName) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SimpleFeature_ord:
			visit((SimpleFeature) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFeature_ord:
			visit((QualifiedFeature) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SubtypeDeclaration_ord:
			visit((SubtypeDeclaration) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.NameDeclaration_ord:
			visit((NameDeclaration) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SortType_ord:
			visit((SortType) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableType_ord:
			visit((VariableType) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionType_ord:
			visit((FunctionType) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateType_ord:
			visit((PredicateType) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Parameters_ord:
			visit((Parameters) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.VariableDeclaration_ord:
			visit((VariableDeclaration) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateDefinition_ord:
			visit((PredicateDefinition) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionDefinition_ord:
			visit((FunctionDefinition) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Axiom_ord:
			visit((Axiom) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Theorem_ord:
			visit((Theorem) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Formulae_ord:
			visit((Formulae) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.PredicateApplication_ord:
			visit((PredicateApplication) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication_ord:
			visit((EqualityPredicateApplication) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Implication_ord:
			visit((Implication) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Coimplication_ord:
			visit((Coimplication) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Xor_ord:
			visit((Xor) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.And_ord:
			visit((And) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Or_ord:
			visit((Or) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Not_ord:
			visit((Not) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.ForAll_ord:
			visit((ForAll) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Exist_ord:
			visit((Exist) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.ExistUnique_ord:
			visit((ExistUnique) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Arguments_ord:
			visit((Arguments) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SimplePredicate_ord:
			visit((SimplePredicate) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedPredicate_ord:
			visit((QualifiedPredicate) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.TheoryName_ord:
			visit((TheoryName) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Constant_ord:
			visit((Constant) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Variable_ord:
			visit((Variable) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.FunctionApplication_ord:
			visit((FunctionApplication) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.SimpleFunction_ord:
			visit((SimpleFunction) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.QualifiedFunction_ord:
			visit((QualifiedFunction) entity);
			break;
		case FirstOrderLogicEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		}
	}
}
