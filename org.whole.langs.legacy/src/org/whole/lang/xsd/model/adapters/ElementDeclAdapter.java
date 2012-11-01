package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ElementDeclAdapter extends AbstractEntityAdapter implements
		ElementDecl {
	private static final long serialVersionUID = 1;

	public ElementDeclAdapter(IEntity implementor) {
		super(implementor);
	}

	public ElementDeclAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ElementDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ElementDecl;
	}

	public NamespaceDecls getNamespaces() {
		return wGet(XsdFeatureDescriptorEnum.namespaces).wGetAdapter(
				XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		wSet(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public StringData getId() {
		return wGet(XsdFeatureDescriptorEnum.id).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setId(StringData id) {
		wSet(XsdFeatureDescriptorEnum.id, id);
	}

	public Attributes getAttributes() {
		return wGet(XsdFeatureDescriptorEnum.attributes).wGetAdapter(
				XsdEntityDescriptorEnum.Attributes);
	}

	public void setAttributes(Attributes attributes) {
		wSet(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public Name getName() {
		return wGet(XsdFeatureDescriptorEnum.name).wGetAdapter(
				XsdEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(XsdFeatureDescriptorEnum.name, name);
	}

	public Bounded getMinOccurs() {
		return wGet(XsdFeatureDescriptorEnum.minOccurs).wGetAdapter(
				XsdEntityDescriptorEnum.Bounded);
	}

	public void setMinOccurs(Bounded minOccurs) {
		wSet(XsdFeatureDescriptorEnum.minOccurs, minOccurs);
	}

	public Occurrence getMaxOccurs() {
		return wGet(XsdFeatureDescriptorEnum.maxOccurs).wGetAdapter(
				XsdEntityDescriptorEnum.Occurrence);
	}

	public void setMaxOccurs(Occurrence maxOccurs) {
		wSet(XsdFeatureDescriptorEnum.maxOccurs, maxOccurs);
	}

	public QName getType() {
		return wGet(XsdFeatureDescriptorEnum.type).wGetAdapter(
				XsdEntityDescriptorEnum.QName);
	}

	public void setType(QName type) {
		wSet(XsdFeatureDescriptorEnum.type, type);
	}

	public BooleanData getAbstract() {
		return wGet(XsdFeatureDescriptorEnum._abstract).wGetAdapter(
				XsdEntityDescriptorEnum.BooleanData);
	}

	public void setAbstract(BooleanData _abstract) {
		wSet(XsdFeatureDescriptorEnum._abstract, _abstract);
	}

	public BooleanData getNillable() {
		return wGet(XsdFeatureDescriptorEnum.nillable).wGetAdapter(
				XsdEntityDescriptorEnum.BooleanData);
	}

	public void setNillable(BooleanData nillable) {
		wSet(XsdFeatureDescriptorEnum.nillable, nillable);
	}

	public StringData getDefaultValue() {
		return wGet(XsdFeatureDescriptorEnum.defaultValue).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setDefaultValue(StringData defaultValue) {
		wSet(XsdFeatureDescriptorEnum.defaultValue, defaultValue);
	}

	public StringData getFixedValue() {
		return wGet(XsdFeatureDescriptorEnum.fixedValue).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setFixedValue(StringData fixedValue) {
		wSet(XsdFeatureDescriptorEnum.fixedValue, fixedValue);
	}

	public Qualify getForm() {
		return wGet(XsdFeatureDescriptorEnum.form).wGetAdapter(
				XsdEntityDescriptorEnum.Qualify);
	}

	public void setForm(Qualify form) {
		wSet(XsdFeatureDescriptorEnum.form, form);
	}

	public DerivationSet getBlock() {
		return wGet(XsdFeatureDescriptorEnum.block).wGetAdapter(
				XsdEntityDescriptorEnum.DerivationSet);
	}

	public void setBlock(DerivationSet block) {
		wSet(XsdFeatureDescriptorEnum.block, block);
	}

	public DerivationSet getFinal() {
		return wGet(XsdFeatureDescriptorEnum._final).wGetAdapter(
				XsdEntityDescriptorEnum.DerivationSet);
	}

	public void setFinal(DerivationSet _final) {
		wSet(XsdFeatureDescriptorEnum._final, _final);
	}

	public QName getSubstitutionGroup() {
		return wGet(XsdFeatureDescriptorEnum.substitutionGroup).wGetAdapter(
				XsdEntityDescriptorEnum.QName);
	}

	public void setSubstitutionGroup(QName substitutionGroup) {
		wSet(XsdFeatureDescriptorEnum.substitutionGroup, substitutionGroup);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public TypeDef getTypeDef() {
		return wGet(XsdFeatureDescriptorEnum.typeDef).wGetAdapter(
				XsdEntityDescriptorEnum.TypeDef);
	}

	public void setTypeDef(TypeDef typeDef) {
		wSet(XsdFeatureDescriptorEnum.typeDef, typeDef);
	}

	public IdentityConstraintDefs getIdentityConstraintDefs() {
		return wGet(XsdFeatureDescriptorEnum.identityConstraintDefs)
				.wGetAdapter(XsdEntityDescriptorEnum.IdentityConstraintDefs);
	}

	public void setIdentityConstraintDefs(
			IdentityConstraintDefs identityConstraintDefs) {
		wSet(XsdFeatureDescriptorEnum.identityConstraintDefs,
				identityConstraintDefs);
	}
}
