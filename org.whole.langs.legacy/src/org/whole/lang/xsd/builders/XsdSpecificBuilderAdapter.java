package org.whole.lang.xsd.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.model.ProcessContentsEnum;
import org.whole.lang.xsd.model.DerivationControlEnum;
import org.whole.lang.xsd.model.UseEnum;
import org.whole.lang.xsd.model.WhiteSpaceProcessingEnum;
import java.math.BigInteger;
import org.whole.lang.xsd.model.QualifyEnum;

/** 
 * @generator Whole
 */
public class XsdSpecificBuilderAdapter extends GenericBuilderContext implements
		IXsdBuilder {
	public XsdSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public XsdSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void uri() {
		wFeature(XsdFeatureDescriptorEnum.uri);
	}

	public void prefix() {
		wFeature(XsdFeatureDescriptorEnum.prefix);
	}

	public void particles() {
		wFeature(XsdFeatureDescriptorEnum.particles);
	}

	public void derivation() {
		wFeature(XsdFeatureDescriptorEnum.derivation);
	}

	public void fixed() {
		wFeature(XsdFeatureDescriptorEnum.fixed);
	}

	public void value() {
		wFeature(XsdFeatureDescriptorEnum.value);
	}

	public void facets() {
		wFeature(XsdFeatureDescriptorEnum.facets);
	}

	public void baseDef() {
		wFeature(XsdFeatureDescriptorEnum.baseDef);
	}

	public void base() {
		wFeature(XsdFeatureDescriptorEnum.base);
	}

	public void memberTypesDefs() {
		wFeature(XsdFeatureDescriptorEnum.memberTypesDefs);
	}

	public void memberTypes() {
		wFeature(XsdFeatureDescriptorEnum.memberTypes);
	}

	public void itemTypeDef() {
		wFeature(XsdFeatureDescriptorEnum.itemTypeDef);
	}

	public void itemType() {
		wFeature(XsdFeatureDescriptorEnum.itemType);
	}

	public void modelGroup() {
		wFeature(XsdFeatureDescriptorEnum.modelGroup);
	}

	public void anyAttribute() {
		wFeature(XsdFeatureDescriptorEnum.anyAttribute);
	}

	public void attributeUses() {
		wFeature(XsdFeatureDescriptorEnum.attributeUses);
	}

	public void processContents() {
		wFeature(XsdFeatureDescriptorEnum.processContents);
	}

	public void namespaceSpecs() {
		wFeature(XsdFeatureDescriptorEnum.namespaceSpecs);
	}

	public void use() {
		wFeature(XsdFeatureDescriptorEnum.use);
	}

	public void simpleTypeDef() {
		wFeature(XsdFeatureDescriptorEnum.simpleTypeDef);
	}

	public void simpleType() {
		wFeature(XsdFeatureDescriptorEnum.simpleType);
	}

	public void mixed() {
		wFeature(XsdFeatureDescriptorEnum.mixed);
	}

	public void refer() {
		wFeature(XsdFeatureDescriptorEnum.refer);
	}

	public void fields() {
		wFeature(XsdFeatureDescriptorEnum.fields);
	}

	public void selector() {
		wFeature(XsdFeatureDescriptorEnum.selector);
	}

	public void xpath() {
		wFeature(XsdFeatureDescriptorEnum.xpath);
	}

	public void ref() {
		wFeature(XsdFeatureDescriptorEnum.ref);
	}

	public void identityConstraintDefs() {
		wFeature(XsdFeatureDescriptorEnum.identityConstraintDefs);
	}

	public void typeDef() {
		wFeature(XsdFeatureDescriptorEnum.typeDef);
	}

	public void substitutionGroup() {
		wFeature(XsdFeatureDescriptorEnum.substitutionGroup);
	}

	public void _final() {
		wFeature(XsdFeatureDescriptorEnum._final);
	}

	public void block() {
		wFeature(XsdFeatureDescriptorEnum.block);
	}

	public void form() {
		wFeature(XsdFeatureDescriptorEnum.form);
	}

	public void fixedValue() {
		wFeature(XsdFeatureDescriptorEnum.fixedValue);
	}

	public void defaultValue() {
		wFeature(XsdFeatureDescriptorEnum.defaultValue);
	}

	public void nillable() {
		wFeature(XsdFeatureDescriptorEnum.nillable);
	}

	public void _abstract() {
		wFeature(XsdFeatureDescriptorEnum._abstract);
	}

	public void type() {
		wFeature(XsdFeatureDescriptorEnum.type);
	}

	public void maxOccurs() {
		wFeature(XsdFeatureDescriptorEnum.maxOccurs);
	}

	public void minOccurs() {
		wFeature(XsdFeatureDescriptorEnum.minOccurs);
	}

	public void system() {
		wFeature(XsdFeatureDescriptorEnum.system);
	}

	public void _public() {
		wFeature(XsdFeatureDescriptorEnum._public);
	}

	public void name() {
		wFeature(XsdFeatureDescriptorEnum.name);
	}

	public void content() {
		wFeature(XsdFeatureDescriptorEnum.content);
	}

	public void source() {
		wFeature(XsdFeatureDescriptorEnum.source);
	}

	public void list() {
		wFeature(XsdFeatureDescriptorEnum.list);
	}

	public void namespace() {
		wFeature(XsdFeatureDescriptorEnum.namespace);
	}

	public void definitions() {
		wFeature(XsdFeatureDescriptorEnum.definitions);
	}

	public void schemaLocation() {
		wFeature(XsdFeatureDescriptorEnum.schemaLocation);
	}

	public void annotation() {
		wFeature(XsdFeatureDescriptorEnum.annotation);
	}

	public void components() {
		wFeature(XsdFeatureDescriptorEnum.components);
	}

	public void directives() {
		wFeature(XsdFeatureDescriptorEnum.directives);
	}

	public void finalDefault() {
		wFeature(XsdFeatureDescriptorEnum.finalDefault);
	}

	public void blockDefault() {
		wFeature(XsdFeatureDescriptorEnum.blockDefault);
	}

	public void elementFormDefault() {
		wFeature(XsdFeatureDescriptorEnum.elementFormDefault);
	}

	public void attributeFormDefault() {
		wFeature(XsdFeatureDescriptorEnum.attributeFormDefault);
	}

	public void language() {
		wFeature(XsdFeatureDescriptorEnum.language);
	}

	public void version() {
		wFeature(XsdFeatureDescriptorEnum.version);
	}

	public void targetNamespace() {
		wFeature(XsdFeatureDescriptorEnum.targetNamespace);
	}

	public void attributes() {
		wFeature(XsdFeatureDescriptorEnum.attributes);
	}

	public void id() {
		wFeature(XsdFeatureDescriptorEnum.id);
	}

	public void namespaces() {
		wFeature(XsdFeatureDescriptorEnum.namespaces);
	}

	public void visit() {
	}

	public void Schema() {
		wEntity(XsdEntityDescriptorEnum.Schema);
	}

	public void Schema_() {
		wEntity_(XsdEntityDescriptorEnum.Schema);
	}

	public void _Schema() {
		_wEntity(XsdEntityDescriptorEnum.Schema);
	}

	public void SchemaDirectives() {
		wEntity(XsdEntityDescriptorEnum.SchemaDirectives);
	}

	public void SchemaDirectives_() {
		wEntity_(XsdEntityDescriptorEnum.SchemaDirectives);
	}

	public void SchemaDirectives_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.SchemaDirectives, initialCapacity);
	}

	public void _SchemaDirectives() {
		_wEntity(XsdEntityDescriptorEnum.SchemaDirectives);
	}

	public void Include() {
		wEntity(XsdEntityDescriptorEnum.Include);
	}

	public void Include_() {
		wEntity_(XsdEntityDescriptorEnum.Include);
	}

	public void _Include() {
		_wEntity(XsdEntityDescriptorEnum.Include);
	}

	public void Redefine() {
		wEntity(XsdEntityDescriptorEnum.Redefine);
	}

	public void Redefine_() {
		wEntity_(XsdEntityDescriptorEnum.Redefine);
	}

	public void _Redefine() {
		_wEntity(XsdEntityDescriptorEnum.Redefine);
	}

	public void RedefineComponents() {
		wEntity(XsdEntityDescriptorEnum.RedefineComponents);
	}

	public void RedefineComponents_() {
		wEntity_(XsdEntityDescriptorEnum.RedefineComponents);
	}

	public void RedefineComponents_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.RedefineComponents, initialCapacity);
	}

	public void _RedefineComponents() {
		_wEntity(XsdEntityDescriptorEnum.RedefineComponents);
	}

	public void Import() {
		wEntity(XsdEntityDescriptorEnum.Import);
	}

	public void Import_() {
		wEntity_(XsdEntityDescriptorEnum.Import);
	}

	public void _Import() {
		_wEntity(XsdEntityDescriptorEnum.Import);
	}

	public void Annotation() {
		wEntity(XsdEntityDescriptorEnum.Annotation);
	}

	public void Annotation_() {
		wEntity_(XsdEntityDescriptorEnum.Annotation);
	}

	public void _Annotation() {
		_wEntity(XsdEntityDescriptorEnum.Annotation);
	}

	public void AnnotationList() {
		wEntity(XsdEntityDescriptorEnum.AnnotationList);
	}

	public void AnnotationList_() {
		wEntity_(XsdEntityDescriptorEnum.AnnotationList);
	}

	public void AnnotationList_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.AnnotationList, initialCapacity);
	}

	public void _AnnotationList() {
		_wEntity(XsdEntityDescriptorEnum.AnnotationList);
	}

	public void Appinfo() {
		wEntity(XsdEntityDescriptorEnum.Appinfo);
	}

	public void Appinfo_() {
		wEntity_(XsdEntityDescriptorEnum.Appinfo);
	}

	public void _Appinfo() {
		_wEntity(XsdEntityDescriptorEnum.Appinfo);
	}

	public void Documentation() {
		wEntity(XsdEntityDescriptorEnum.Documentation);
	}

	public void Documentation_() {
		wEntity_(XsdEntityDescriptorEnum.Documentation);
	}

	public void _Documentation() {
		_wEntity(XsdEntityDescriptorEnum.Documentation);
	}

	public void AnnotationContents() {
		wEntity(XsdEntityDescriptorEnum.AnnotationContents);
	}

	public void AnnotationContents_() {
		wEntity_(XsdEntityDescriptorEnum.AnnotationContents);
	}

	public void AnnotationContents_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.AnnotationContents, initialCapacity);
	}

	public void _AnnotationContents() {
		_wEntity(XsdEntityDescriptorEnum.AnnotationContents);
	}

	public void SchemaComponents() {
		wEntity(XsdEntityDescriptorEnum.SchemaComponents);
	}

	public void SchemaComponents_() {
		wEntity_(XsdEntityDescriptorEnum.SchemaComponents);
	}

	public void SchemaComponents_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.SchemaComponents, initialCapacity);
	}

	public void _SchemaComponents() {
		_wEntity(XsdEntityDescriptorEnum.SchemaComponents);
	}

	public void NotationDecl() {
		wEntity(XsdEntityDescriptorEnum.NotationDecl);
	}

	public void NotationDecl_() {
		wEntity_(XsdEntityDescriptorEnum.NotationDecl);
	}

	public void _NotationDecl() {
		_wEntity(XsdEntityDescriptorEnum.NotationDecl);
	}

	public void ElementDecl() {
		wEntity(XsdEntityDescriptorEnum.ElementDecl);
	}

	public void ElementDecl_() {
		wEntity_(XsdEntityDescriptorEnum.ElementDecl);
	}

	public void _ElementDecl() {
		_wEntity(XsdEntityDescriptorEnum.ElementDecl);
	}

	public void ElementRef() {
		wEntity(XsdEntityDescriptorEnum.ElementRef);
	}

	public void ElementRef_() {
		wEntity_(XsdEntityDescriptorEnum.ElementRef);
	}

	public void _ElementRef() {
		_wEntity(XsdEntityDescriptorEnum.ElementRef);
	}

	public void IdentityConstraintDefs() {
		wEntity(XsdEntityDescriptorEnum.IdentityConstraintDefs);
	}

	public void IdentityConstraintDefs_() {
		wEntity_(XsdEntityDescriptorEnum.IdentityConstraintDefs);
	}

	public void IdentityConstraintDefs_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.IdentityConstraintDefs,
				initialCapacity);
	}

	public void _IdentityConstraintDefs() {
		_wEntity(XsdEntityDescriptorEnum.IdentityConstraintDefs);
	}

	public void Fields() {
		wEntity(XsdEntityDescriptorEnum.Fields);
	}

	public void Fields_() {
		wEntity_(XsdEntityDescriptorEnum.Fields);
	}

	public void Fields_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.Fields, initialCapacity);
	}

	public void _Fields() {
		_wEntity(XsdEntityDescriptorEnum.Fields);
	}

	public void Selector() {
		wEntity(XsdEntityDescriptorEnum.Selector);
	}

	public void Selector_() {
		wEntity_(XsdEntityDescriptorEnum.Selector);
	}

	public void _Selector() {
		_wEntity(XsdEntityDescriptorEnum.Selector);
	}

	public void Field() {
		wEntity(XsdEntityDescriptorEnum.Field);
	}

	public void Field_() {
		wEntity_(XsdEntityDescriptorEnum.Field);
	}

	public void _Field() {
		_wEntity(XsdEntityDescriptorEnum.Field);
	}

	public void Unique() {
		wEntity(XsdEntityDescriptorEnum.Unique);
	}

	public void Unique_() {
		wEntity_(XsdEntityDescriptorEnum.Unique);
	}

	public void _Unique() {
		_wEntity(XsdEntityDescriptorEnum.Unique);
	}

	public void Key() {
		wEntity(XsdEntityDescriptorEnum.Key);
	}

	public void Key_() {
		wEntity_(XsdEntityDescriptorEnum.Key);
	}

	public void _Key() {
		_wEntity(XsdEntityDescriptorEnum.Key);
	}

	public void Keyref() {
		wEntity(XsdEntityDescriptorEnum.Keyref);
	}

	public void Keyref_() {
		wEntity_(XsdEntityDescriptorEnum.Keyref);
	}

	public void _Keyref() {
		_wEntity(XsdEntityDescriptorEnum.Keyref);
	}

	public void SimpleTypeDefs() {
		wEntity(XsdEntityDescriptorEnum.SimpleTypeDefs);
	}

	public void SimpleTypeDefs_() {
		wEntity_(XsdEntityDescriptorEnum.SimpleTypeDefs);
	}

	public void SimpleTypeDefs_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.SimpleTypeDefs, initialCapacity);
	}

	public void _SimpleTypeDefs() {
		_wEntity(XsdEntityDescriptorEnum.SimpleTypeDefs);
	}

	public void SimpleTypeDef() {
		wEntity(XsdEntityDescriptorEnum.SimpleTypeDef);
	}

	public void SimpleTypeDef_() {
		wEntity_(XsdEntityDescriptorEnum.SimpleTypeDef);
	}

	public void _SimpleTypeDef() {
		_wEntity(XsdEntityDescriptorEnum.SimpleTypeDef);
	}

	public void ComplexTypeDef() {
		wEntity(XsdEntityDescriptorEnum.ComplexTypeDef);
	}

	public void ComplexTypeDef_() {
		wEntity_(XsdEntityDescriptorEnum.ComplexTypeDef);
	}

	public void _ComplexTypeDef() {
		_wEntity(XsdEntityDescriptorEnum.ComplexTypeDef);
	}

	public void AttributeDecl() {
		wEntity(XsdEntityDescriptorEnum.AttributeDecl);
	}

	public void AttributeDecl_() {
		wEntity_(XsdEntityDescriptorEnum.AttributeDecl);
	}

	public void _AttributeDecl() {
		_wEntity(XsdEntityDescriptorEnum.AttributeDecl);
	}

	public void AttributeUseOrGroups() {
		wEntity(XsdEntityDescriptorEnum.AttributeUseOrGroups);
	}

	public void AttributeUseOrGroups_() {
		wEntity_(XsdEntityDescriptorEnum.AttributeUseOrGroups);
	}

	public void AttributeUseOrGroups_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.AttributeUseOrGroups, initialCapacity);
	}

	public void _AttributeUseOrGroups() {
		_wEntity(XsdEntityDescriptorEnum.AttributeUseOrGroups);
	}

	public void AttributeUseDecl() {
		wEntity(XsdEntityDescriptorEnum.AttributeUseDecl);
	}

	public void AttributeUseDecl_() {
		wEntity_(XsdEntityDescriptorEnum.AttributeUseDecl);
	}

	public void _AttributeUseDecl() {
		_wEntity(XsdEntityDescriptorEnum.AttributeUseDecl);
	}

	public void AttributeUseRef() {
		wEntity(XsdEntityDescriptorEnum.AttributeUseRef);
	}

	public void AttributeUseRef_() {
		wEntity_(XsdEntityDescriptorEnum.AttributeUseRef);
	}

	public void _AttributeUseRef() {
		_wEntity(XsdEntityDescriptorEnum.AttributeUseRef);
	}

	public void AnyAttribute() {
		wEntity(XsdEntityDescriptorEnum.AnyAttribute);
	}

	public void AnyAttribute_() {
		wEntity_(XsdEntityDescriptorEnum.AnyAttribute);
	}

	public void _AnyAttribute() {
		_wEntity(XsdEntityDescriptorEnum.AnyAttribute);
	}

	public void AttributeGroupDef() {
		wEntity(XsdEntityDescriptorEnum.AttributeGroupDef);
	}

	public void AttributeGroupDef_() {
		wEntity_(XsdEntityDescriptorEnum.AttributeGroupDef);
	}

	public void _AttributeGroupDef() {
		_wEntity(XsdEntityDescriptorEnum.AttributeGroupDef);
	}

	public void AttributeGroupRef() {
		wEntity(XsdEntityDescriptorEnum.AttributeGroupRef);
	}

	public void AttributeGroupRef_() {
		wEntity_(XsdEntityDescriptorEnum.AttributeGroupRef);
	}

	public void _AttributeGroupRef() {
		_wEntity(XsdEntityDescriptorEnum.AttributeGroupRef);
	}

	public void ModelGroupDef() {
		wEntity(XsdEntityDescriptorEnum.ModelGroupDef);
	}

	public void ModelGroupDef_() {
		wEntity_(XsdEntityDescriptorEnum.ModelGroupDef);
	}

	public void _ModelGroupDef() {
		_wEntity(XsdEntityDescriptorEnum.ModelGroupDef);
	}

	public void ModelGroupRef() {
		wEntity(XsdEntityDescriptorEnum.ModelGroupRef);
	}

	public void ModelGroupRef_() {
		wEntity_(XsdEntityDescriptorEnum.ModelGroupRef);
	}

	public void _ModelGroupRef() {
		_wEntity(XsdEntityDescriptorEnum.ModelGroupRef);
	}

	public void Particles() {
		wEntity(XsdEntityDescriptorEnum.Particles);
	}

	public void Particles_() {
		wEntity_(XsdEntityDescriptorEnum.Particles);
	}

	public void Particles_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.Particles, initialCapacity);
	}

	public void _Particles() {
		_wEntity(XsdEntityDescriptorEnum.Particles);
	}

	public void List() {
		wEntity(XsdEntityDescriptorEnum.List);
	}

	public void List_() {
		wEntity_(XsdEntityDescriptorEnum.List);
	}

	public void _List() {
		_wEntity(XsdEntityDescriptorEnum.List);
	}

	public void Union() {
		wEntity(XsdEntityDescriptorEnum.Union);
	}

	public void Union_() {
		wEntity_(XsdEntityDescriptorEnum.Union);
	}

	public void _Union() {
		_wEntity(XsdEntityDescriptorEnum.Union);
	}

	public void SimpleTypeRestriction() {
		wEntity(XsdEntityDescriptorEnum.SimpleTypeRestriction);
	}

	public void SimpleTypeRestriction_() {
		wEntity_(XsdEntityDescriptorEnum.SimpleTypeRestriction);
	}

	public void _SimpleTypeRestriction() {
		_wEntity(XsdEntityDescriptorEnum.SimpleTypeRestriction);
	}

	public void Facets() {
		wEntity(XsdEntityDescriptorEnum.Facets);
	}

	public void Facets_() {
		wEntity_(XsdEntityDescriptorEnum.Facets);
	}

	public void Facets_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.Facets, initialCapacity);
	}

	public void _Facets() {
		_wEntity(XsdEntityDescriptorEnum.Facets);
	}

	public void WhiteSpace() {
		wEntity(XsdEntityDescriptorEnum.WhiteSpace);
	}

	public void WhiteSpace_() {
		wEntity_(XsdEntityDescriptorEnum.WhiteSpace);
	}

	public void _WhiteSpace() {
		_wEntity(XsdEntityDescriptorEnum.WhiteSpace);
	}

	public void Length() {
		wEntity(XsdEntityDescriptorEnum.Length);
	}

	public void Length_() {
		wEntity_(XsdEntityDescriptorEnum.Length);
	}

	public void _Length() {
		_wEntity(XsdEntityDescriptorEnum.Length);
	}

	public void MinLength() {
		wEntity(XsdEntityDescriptorEnum.MinLength);
	}

	public void MinLength_() {
		wEntity_(XsdEntityDescriptorEnum.MinLength);
	}

	public void _MinLength() {
		_wEntity(XsdEntityDescriptorEnum.MinLength);
	}

	public void MaxLength() {
		wEntity(XsdEntityDescriptorEnum.MaxLength);
	}

	public void MaxLength_() {
		wEntity_(XsdEntityDescriptorEnum.MaxLength);
	}

	public void _MaxLength() {
		_wEntity(XsdEntityDescriptorEnum.MaxLength);
	}

	public void MinInclusive() {
		wEntity(XsdEntityDescriptorEnum.MinInclusive);
	}

	public void MinInclusive_() {
		wEntity_(XsdEntityDescriptorEnum.MinInclusive);
	}

	public void _MinInclusive() {
		_wEntity(XsdEntityDescriptorEnum.MinInclusive);
	}

	public void MaxInclusive() {
		wEntity(XsdEntityDescriptorEnum.MaxInclusive);
	}

	public void MaxInclusive_() {
		wEntity_(XsdEntityDescriptorEnum.MaxInclusive);
	}

	public void _MaxInclusive() {
		_wEntity(XsdEntityDescriptorEnum.MaxInclusive);
	}

	public void MinExclusive() {
		wEntity(XsdEntityDescriptorEnum.MinExclusive);
	}

	public void MinExclusive_() {
		wEntity_(XsdEntityDescriptorEnum.MinExclusive);
	}

	public void _MinExclusive() {
		_wEntity(XsdEntityDescriptorEnum.MinExclusive);
	}

	public void MaxExclusive() {
		wEntity(XsdEntityDescriptorEnum.MaxExclusive);
	}

	public void MaxExclusive_() {
		wEntity_(XsdEntityDescriptorEnum.MaxExclusive);
	}

	public void _MaxExclusive() {
		_wEntity(XsdEntityDescriptorEnum.MaxExclusive);
	}

	public void TotalDigits() {
		wEntity(XsdEntityDescriptorEnum.TotalDigits);
	}

	public void TotalDigits_() {
		wEntity_(XsdEntityDescriptorEnum.TotalDigits);
	}

	public void _TotalDigits() {
		_wEntity(XsdEntityDescriptorEnum.TotalDigits);
	}

	public void FractionDigits() {
		wEntity(XsdEntityDescriptorEnum.FractionDigits);
	}

	public void FractionDigits_() {
		wEntity_(XsdEntityDescriptorEnum.FractionDigits);
	}

	public void _FractionDigits() {
		_wEntity(XsdEntityDescriptorEnum.FractionDigits);
	}

	public void Pattern() {
		wEntity(XsdEntityDescriptorEnum.Pattern);
	}

	public void Pattern_() {
		wEntity_(XsdEntityDescriptorEnum.Pattern);
	}

	public void _Pattern() {
		_wEntity(XsdEntityDescriptorEnum.Pattern);
	}

	public void Enumeration() {
		wEntity(XsdEntityDescriptorEnum.Enumeration);
	}

	public void Enumeration_() {
		wEntity_(XsdEntityDescriptorEnum.Enumeration);
	}

	public void _Enumeration() {
		_wEntity(XsdEntityDescriptorEnum.Enumeration);
	}

	public void SimpleContent() {
		wEntity(XsdEntityDescriptorEnum.SimpleContent);
	}

	public void SimpleContent_() {
		wEntity_(XsdEntityDescriptorEnum.SimpleContent);
	}

	public void _SimpleContent() {
		_wEntity(XsdEntityDescriptorEnum.SimpleContent);
	}

	public void ComplexRestriction() {
		wEntity(XsdEntityDescriptorEnum.ComplexRestriction);
	}

	public void ComplexRestriction_() {
		wEntity_(XsdEntityDescriptorEnum.ComplexRestriction);
	}

	public void _ComplexRestriction() {
		_wEntity(XsdEntityDescriptorEnum.ComplexRestriction);
	}

	public void ComplexExtension() {
		wEntity(XsdEntityDescriptorEnum.ComplexExtension);
	}

	public void ComplexExtension_() {
		wEntity_(XsdEntityDescriptorEnum.ComplexExtension);
	}

	public void _ComplexExtension() {
		_wEntity(XsdEntityDescriptorEnum.ComplexExtension);
	}

	public void SimpleRestriction() {
		wEntity(XsdEntityDescriptorEnum.SimpleRestriction);
	}

	public void SimpleRestriction_() {
		wEntity_(XsdEntityDescriptorEnum.SimpleRestriction);
	}

	public void _SimpleRestriction() {
		_wEntity(XsdEntityDescriptorEnum.SimpleRestriction);
	}

	public void SimpleExtension() {
		wEntity(XsdEntityDescriptorEnum.SimpleExtension);
	}

	public void SimpleExtension_() {
		wEntity_(XsdEntityDescriptorEnum.SimpleExtension);
	}

	public void _SimpleExtension() {
		_wEntity(XsdEntityDescriptorEnum.SimpleExtension);
	}

	public void ComplexContent() {
		wEntity(XsdEntityDescriptorEnum.ComplexContent);
	}

	public void ComplexContent_() {
		wEntity_(XsdEntityDescriptorEnum.ComplexContent);
	}

	public void _ComplexContent() {
		_wEntity(XsdEntityDescriptorEnum.ComplexContent);
	}

	public void DeclaredContent() {
		wEntity(XsdEntityDescriptorEnum.DeclaredContent);
	}

	public void DeclaredContent_() {
		wEntity_(XsdEntityDescriptorEnum.DeclaredContent);
	}

	public void _DeclaredContent() {
		_wEntity(XsdEntityDescriptorEnum.DeclaredContent);
	}

	public void Sequence() {
		wEntity(XsdEntityDescriptorEnum.Sequence);
	}

	public void Sequence_() {
		wEntity_(XsdEntityDescriptorEnum.Sequence);
	}

	public void _Sequence() {
		_wEntity(XsdEntityDescriptorEnum.Sequence);
	}

	public void Choice() {
		wEntity(XsdEntityDescriptorEnum.Choice);
	}

	public void Choice_() {
		wEntity_(XsdEntityDescriptorEnum.Choice);
	}

	public void _Choice() {
		_wEntity(XsdEntityDescriptorEnum.Choice);
	}

	public void All() {
		wEntity(XsdEntityDescriptorEnum.All);
	}

	public void All_() {
		wEntity_(XsdEntityDescriptorEnum.All);
	}

	public void _All() {
		_wEntity(XsdEntityDescriptorEnum.All);
	}

	public void Any() {
		wEntity(XsdEntityDescriptorEnum.Any);
	}

	public void Any_() {
		wEntity_(XsdEntityDescriptorEnum.Any);
	}

	public void _Any() {
		_wEntity(XsdEntityDescriptorEnum.Any);
	}

	public void Bounded() {
		wEntity(XsdEntityDescriptorEnum.Bounded);
	}

	public void Bounded(int value) {
		wEntity(XsdEntityDescriptorEnum.Bounded, value);
	}

	public void Unbounded() {
		wEntity(XsdEntityDescriptorEnum.Unbounded);
	}

	public void Unbounded_() {
		wEntity_(XsdEntityDescriptorEnum.Unbounded);
	}

	public void _Unbounded() {
		_wEntity(XsdEntityDescriptorEnum.Unbounded);
	}

	public void MemberTypes() {
		wEntity(XsdEntityDescriptorEnum.MemberTypes);
	}

	public void MemberTypes_() {
		wEntity_(XsdEntityDescriptorEnum.MemberTypes);
	}

	public void MemberTypes_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.MemberTypes, initialCapacity);
	}

	public void _MemberTypes() {
		_wEntity(XsdEntityDescriptorEnum.MemberTypes);
	}

	public void Name() {
		wEntity(XsdEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(XsdEntityDescriptorEnum.Name, value);
	}

	public void QName() {
		wEntity(XsdEntityDescriptorEnum.QName);
	}

	public void QName(String value) {
		wEntity(XsdEntityDescriptorEnum.QName, value);
	}

	public void AnyURI() {
		wEntity(XsdEntityDescriptorEnum.AnyURI);
	}

	public void AnyURI(String value) {
		wEntity(XsdEntityDescriptorEnum.AnyURI, value);
	}

	public void NamespaceDecl() {
		wEntity(XsdEntityDescriptorEnum.NamespaceDecl);
	}

	public void NamespaceDecl_() {
		wEntity_(XsdEntityDescriptorEnum.NamespaceDecl);
	}

	public void _NamespaceDecl() {
		_wEntity(XsdEntityDescriptorEnum.NamespaceDecl);
	}

	public void NamespaceDecls() {
		wEntity(XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public void NamespaceDecls_() {
		wEntity_(XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public void NamespaceDecls_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.NamespaceDecls, initialCapacity);
	}

	public void _NamespaceDecls() {
		_wEntity(XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public void Attributes() {
		wEntity(XsdEntityDescriptorEnum.Attributes);
	}

	public void Attributes_() {
		wEntity_(XsdEntityDescriptorEnum.Attributes);
	}

	public void Attributes_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.Attributes, initialCapacity);
	}

	public void _Attributes() {
		_wEntity(XsdEntityDescriptorEnum.Attributes);
	}

	public void ProcessContents() {
		wEntity(XsdEntityDescriptorEnum.ProcessContents);
	}

	public void ProcessContents(ProcessContentsEnum.Value value) {
		wEntity(XsdEntityDescriptorEnum.ProcessContents, value);
	}

	public void ProcessContents(String value) {
		wEntity(XsdEntityDescriptorEnum.ProcessContents, value);
	}

	public void AnyNamespaceSpecs() {
		wEntity(XsdEntityDescriptorEnum.AnyNamespaceSpecs);
	}

	public void AnyNamespaceSpecs_() {
		wEntity_(XsdEntityDescriptorEnum.AnyNamespaceSpecs);
	}

	public void _AnyNamespaceSpecs() {
		_wEntity(XsdEntityDescriptorEnum.AnyNamespaceSpecs);
	}

	public void OtherNamespaceSpecs() {
		wEntity(XsdEntityDescriptorEnum.OtherNamespaceSpecs);
	}

	public void OtherNamespaceSpecs_() {
		wEntity_(XsdEntityDescriptorEnum.OtherNamespaceSpecs);
	}

	public void _OtherNamespaceSpecs() {
		_wEntity(XsdEntityDescriptorEnum.OtherNamespaceSpecs);
	}

	public void NamespaceSpecsList() {
		wEntity(XsdEntityDescriptorEnum.NamespaceSpecsList);
	}

	public void NamespaceSpecsList_() {
		wEntity_(XsdEntityDescriptorEnum.NamespaceSpecsList);
	}

	public void NamespaceSpecsList_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.NamespaceSpecsList, initialCapacity);
	}

	public void _NamespaceSpecsList() {
		_wEntity(XsdEntityDescriptorEnum.NamespaceSpecsList);
	}

	public void TargetNamespaceSpec() {
		wEntity(XsdEntityDescriptorEnum.TargetNamespaceSpec);
	}

	public void TargetNamespaceSpec_() {
		wEntity_(XsdEntityDescriptorEnum.TargetNamespaceSpec);
	}

	public void _TargetNamespaceSpec() {
		_wEntity(XsdEntityDescriptorEnum.TargetNamespaceSpec);
	}

	public void LocalNamespaceSpec() {
		wEntity(XsdEntityDescriptorEnum.LocalNamespaceSpec);
	}

	public void LocalNamespaceSpec_() {
		wEntity_(XsdEntityDescriptorEnum.LocalNamespaceSpec);
	}

	public void _LocalNamespaceSpec() {
		_wEntity(XsdEntityDescriptorEnum.LocalNamespaceSpec);
	}

	public void DerivationAll() {
		wEntity(XsdEntityDescriptorEnum.DerivationAll);
	}

	public void DerivationAll_() {
		wEntity_(XsdEntityDescriptorEnum.DerivationAll);
	}

	public void _DerivationAll() {
		_wEntity(XsdEntityDescriptorEnum.DerivationAll);
	}

	public void DerivationList() {
		wEntity(XsdEntityDescriptorEnum.DerivationList);
	}

	public void DerivationList_() {
		wEntity_(XsdEntityDescriptorEnum.DerivationList);
	}

	public void DerivationList_(int initialCapacity) {
		wEntity_(XsdEntityDescriptorEnum.DerivationList, initialCapacity);
	}

	public void _DerivationList() {
		_wEntity(XsdEntityDescriptorEnum.DerivationList);
	}

	public void DerivationControl() {
		wEntity(XsdEntityDescriptorEnum.DerivationControl);
	}

	public void DerivationControl(DerivationControlEnum.Value value) {
		wEntity(XsdEntityDescriptorEnum.DerivationControl, value);
	}

	public void DerivationControl(String value) {
		wEntity(XsdEntityDescriptorEnum.DerivationControl, value);
	}

	public void Use() {
		wEntity(XsdEntityDescriptorEnum.Use);
	}

	public void Use(UseEnum.Value value) {
		wEntity(XsdEntityDescriptorEnum.Use, value);
	}

	public void Use(String value) {
		wEntity(XsdEntityDescriptorEnum.Use, value);
	}

	public void WhiteSpaceProcessing() {
		wEntity(XsdEntityDescriptorEnum.WhiteSpaceProcessing);
	}

	public void WhiteSpaceProcessing(WhiteSpaceProcessingEnum.Value value) {
		wEntity(XsdEntityDescriptorEnum.WhiteSpaceProcessing, value);
	}

	public void WhiteSpaceProcessing(String value) {
		wEntity(XsdEntityDescriptorEnum.WhiteSpaceProcessing, value);
	}

	public void MixedText() {
		wEntity(XsdEntityDescriptorEnum.MixedText);
	}

	public void MixedText(String value) {
		wEntity(XsdEntityDescriptorEnum.MixedText, value);
	}

	public void XPathString() {
		wEntity(XsdEntityDescriptorEnum.XPathString);
	}

	public void XPathString(String value) {
		wEntity(XsdEntityDescriptorEnum.XPathString, value);
	}

	public void StringData() {
		wEntity(XsdEntityDescriptorEnum.StringData);
	}

	public void StringData(String value) {
		wEntity(XsdEntityDescriptorEnum.StringData, value);
	}

	public void IntegerData() {
		wEntity(XsdEntityDescriptorEnum.IntegerData);
	}

	public void IntegerData(BigInteger value) {
		wEntity(XsdEntityDescriptorEnum.IntegerData, value);
	}

	public void IntegerData(String value) {
		wEntity(XsdEntityDescriptorEnum.IntegerData, value);
	}

	public void BooleanData() {
		wEntity(XsdEntityDescriptorEnum.BooleanData);
	}

	public void BooleanData(boolean value) {
		wEntity(XsdEntityDescriptorEnum.BooleanData, value);
	}

	public void Qualify() {
		wEntity(XsdEntityDescriptorEnum.Qualify);
	}

	public void Qualify(QualifyEnum.Value value) {
		wEntity(XsdEntityDescriptorEnum.Qualify, value);
	}

	public void Qualify(String value) {
		wEntity(XsdEntityDescriptorEnum.Qualify, value);
	}
}
