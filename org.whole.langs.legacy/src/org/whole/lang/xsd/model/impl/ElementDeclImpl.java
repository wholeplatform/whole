package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ElementDeclImpl extends AbstractSimpleEntity implements
		ElementDecl {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ElementDecl> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.ElementDecl;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.ElementDecl_ord;
	}

	public void accept(IXsdVisitor visitor) {
		visitor.visit(this);
	}

	private NamespaceDecls namespaces;

	public NamespaceDecls getNamespaces() {
		return notifyRequested(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		notifyChanged(XsdFeatureDescriptorEnum.namespaces, this.namespaces,
				this.namespaces = namespaces);
	}

	private StringData id;

	public StringData getId() {
		return notifyRequested(XsdFeatureDescriptorEnum.id, id);
	}

	public void setId(StringData id) {
		notifyChanged(XsdFeatureDescriptorEnum.id, this.id, this.id = id);
	}

	private Attributes attributes;

	public Attributes getAttributes() {
		return notifyRequested(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public void setAttributes(Attributes attributes) {
		notifyChanged(XsdFeatureDescriptorEnum.attributes, this.attributes,
				this.attributes = attributes);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(XsdFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(XsdFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Bounded minOccurs;

	public Bounded getMinOccurs() {
		return notifyRequested(XsdFeatureDescriptorEnum.minOccurs, minOccurs);
	}

	public void setMinOccurs(Bounded minOccurs) {
		notifyChanged(XsdFeatureDescriptorEnum.minOccurs, this.minOccurs,
				this.minOccurs = minOccurs);
	}

	private Occurrence maxOccurs;

	public Occurrence getMaxOccurs() {
		return notifyRequested(XsdFeatureDescriptorEnum.maxOccurs, maxOccurs);
	}

	public void setMaxOccurs(Occurrence maxOccurs) {
		notifyChanged(XsdFeatureDescriptorEnum.maxOccurs, this.maxOccurs,
				this.maxOccurs = maxOccurs);
	}

	private QName type;

	public QName getType() {
		return notifyRequested(XsdFeatureDescriptorEnum.type, type);
	}

	public void setType(QName type) {
		notifyChanged(XsdFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private BooleanData _abstract;

	public BooleanData getAbstract() {
		return notifyRequested(XsdFeatureDescriptorEnum._abstract, _abstract);
	}

	public void setAbstract(BooleanData _abstract) {
		notifyChanged(XsdFeatureDescriptorEnum._abstract, this._abstract,
				this._abstract = _abstract);
	}

	private BooleanData nillable;

	public BooleanData getNillable() {
		return notifyRequested(XsdFeatureDescriptorEnum.nillable, nillable);
	}

	public void setNillable(BooleanData nillable) {
		notifyChanged(XsdFeatureDescriptorEnum.nillable, this.nillable,
				this.nillable = nillable);
	}

	private StringData defaultValue;

	public StringData getDefaultValue() {
		return notifyRequested(XsdFeatureDescriptorEnum.defaultValue,
				defaultValue);
	}

	public void setDefaultValue(StringData defaultValue) {
		notifyChanged(XsdFeatureDescriptorEnum.defaultValue, this.defaultValue,
				this.defaultValue = defaultValue);
	}

	private StringData fixedValue;

	public StringData getFixedValue() {
		return notifyRequested(XsdFeatureDescriptorEnum.fixedValue, fixedValue);
	}

	public void setFixedValue(StringData fixedValue) {
		notifyChanged(XsdFeatureDescriptorEnum.fixedValue, this.fixedValue,
				this.fixedValue = fixedValue);
	}

	private Qualify form;

	public Qualify getForm() {
		return notifyRequested(XsdFeatureDescriptorEnum.form, form);
	}

	public void setForm(Qualify form) {
		notifyChanged(XsdFeatureDescriptorEnum.form, this.form,
				this.form = form);
	}

	private DerivationSet block;

	public DerivationSet getBlock() {
		return notifyRequested(XsdFeatureDescriptorEnum.block, block);
	}

	public void setBlock(DerivationSet block) {
		notifyChanged(XsdFeatureDescriptorEnum.block, this.block,
				this.block = block);
	}

	private DerivationSet _final;

	public DerivationSet getFinal() {
		return notifyRequested(XsdFeatureDescriptorEnum._final, _final);
	}

	public void setFinal(DerivationSet _final) {
		notifyChanged(XsdFeatureDescriptorEnum._final, this._final,
				this._final = _final);
	}

	private QName substitutionGroup;

	public QName getSubstitutionGroup() {
		return notifyRequested(XsdFeatureDescriptorEnum.substitutionGroup,
				substitutionGroup);
	}

	public void setSubstitutionGroup(QName substitutionGroup) {
		notifyChanged(XsdFeatureDescriptorEnum.substitutionGroup,
				this.substitutionGroup,
				this.substitutionGroup = substitutionGroup);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	private TypeDef typeDef;

	public TypeDef getTypeDef() {
		return notifyRequested(XsdFeatureDescriptorEnum.typeDef, typeDef);
	}

	public void setTypeDef(TypeDef typeDef) {
		notifyChanged(XsdFeatureDescriptorEnum.typeDef, this.typeDef,
				this.typeDef = typeDef);
	}

	private IdentityConstraintDefs identityConstraintDefs;

	public IdentityConstraintDefs getIdentityConstraintDefs() {
		return notifyRequested(XsdFeatureDescriptorEnum.identityConstraintDefs,
				identityConstraintDefs);
	}

	public void setIdentityConstraintDefs(
			IdentityConstraintDefs identityConstraintDefs) {
		notifyChanged(XsdFeatureDescriptorEnum.identityConstraintDefs,
				this.identityConstraintDefs,
				this.identityConstraintDefs = identityConstraintDefs);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNamespaces().wGetAdaptee(false);
		case 1:
			return getId().wGetAdaptee(false);
		case 2:
			return getAttributes().wGetAdaptee(false);
		case 3:
			return getName().wGetAdaptee(false);
		case 4:
			return getMinOccurs().wGetAdaptee(false);
		case 5:
			return getMaxOccurs().wGetAdaptee(false);
		case 6:
			return getType().wGetAdaptee(false);
		case 7:
			return getAbstract().wGetAdaptee(false);
		case 8:
			return getNillable().wGetAdaptee(false);
		case 9:
			return getDefaultValue().wGetAdaptee(false);
		case 10:
			return getFixedValue().wGetAdaptee(false);
		case 11:
			return getForm().wGetAdaptee(false);
		case 12:
			return getBlock().wGetAdaptee(false);
		case 13:
			return getFinal().wGetAdaptee(false);
		case 14:
			return getSubstitutionGroup().wGetAdaptee(false);
		case 15:
			return getAnnotation().wGetAdaptee(false);
		case 16:
			return getTypeDef().wGetAdaptee(false);
		case 17:
			return getIdentityConstraintDefs().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNamespaces(value
					.wGetAdapter(XsdEntityDescriptorEnum.NamespaceDecls));
			break;
		case 1:
			setId(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 2:
			setAttributes(value.wGetAdapter(XsdEntityDescriptorEnum.Attributes));
			break;
		case 3:
			setName(value.wGetAdapter(XsdEntityDescriptorEnum.Name));
			break;
		case 4:
			setMinOccurs(value.wGetAdapter(XsdEntityDescriptorEnum.Bounded));
			break;
		case 5:
			setMaxOccurs(value.wGetAdapter(XsdEntityDescriptorEnum.Occurrence));
			break;
		case 6:
			setType(value.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 7:
			setAbstract(value.wGetAdapter(XsdEntityDescriptorEnum.BooleanData));
			break;
		case 8:
			setNillable(value.wGetAdapter(XsdEntityDescriptorEnum.BooleanData));
			break;
		case 9:
			setDefaultValue(value
					.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 10:
			setFixedValue(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 11:
			setForm(value.wGetAdapter(XsdEntityDescriptorEnum.Qualify));
			break;
		case 12:
			setBlock(value.wGetAdapter(XsdEntityDescriptorEnum.DerivationSet));
			break;
		case 13:
			setFinal(value.wGetAdapter(XsdEntityDescriptorEnum.DerivationSet));
			break;
		case 14:
			setSubstitutionGroup(value
					.wGetAdapter(XsdEntityDescriptorEnum.QName));
			break;
		case 15:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		case 16:
			setTypeDef(value.wGetAdapter(XsdEntityDescriptorEnum.TypeDef));
			break;
		case 17:
			setIdentityConstraintDefs(value
					.wGetAdapter(XsdEntityDescriptorEnum.IdentityConstraintDefs));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 18;
	}
}
