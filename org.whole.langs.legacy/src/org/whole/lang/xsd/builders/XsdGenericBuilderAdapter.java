package org.whole.lang.xsd.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.xsd.model.ProcessContentsEnum.Value;
import java.math.BigInteger;

/** 
 * @generator Whole
 */
public class XsdGenericBuilderAdapter extends GenericIdentityBuilder {
	private IXsdBuilder specificBuilder;

	public XsdGenericBuilderAdapter(IXsdBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public XsdGenericBuilderAdapter(IXsdBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case XsdFeatureDescriptorEnum.namespaces_ord:
			specificBuilder.namespaces();
			break;
		case XsdFeatureDescriptorEnum.id_ord:
			specificBuilder.id();
			break;
		case XsdFeatureDescriptorEnum.attributes_ord:
			specificBuilder.attributes();
			break;
		case XsdFeatureDescriptorEnum.targetNamespace_ord:
			specificBuilder.targetNamespace();
			break;
		case XsdFeatureDescriptorEnum.version_ord:
			specificBuilder.version();
			break;
		case XsdFeatureDescriptorEnum.language_ord:
			specificBuilder.language();
			break;
		case XsdFeatureDescriptorEnum.attributeFormDefault_ord:
			specificBuilder.attributeFormDefault();
			break;
		case XsdFeatureDescriptorEnum.elementFormDefault_ord:
			specificBuilder.elementFormDefault();
			break;
		case XsdFeatureDescriptorEnum.blockDefault_ord:
			specificBuilder.blockDefault();
			break;
		case XsdFeatureDescriptorEnum.finalDefault_ord:
			specificBuilder.finalDefault();
			break;
		case XsdFeatureDescriptorEnum.directives_ord:
			specificBuilder.directives();
			break;
		case XsdFeatureDescriptorEnum.components_ord:
			specificBuilder.components();
			break;
		case XsdFeatureDescriptorEnum.annotation_ord:
			specificBuilder.annotation();
			break;
		case XsdFeatureDescriptorEnum.schemaLocation_ord:
			specificBuilder.schemaLocation();
			break;
		case XsdFeatureDescriptorEnum.definitions_ord:
			specificBuilder.definitions();
			break;
		case XsdFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case XsdFeatureDescriptorEnum.list_ord:
			specificBuilder.list();
			break;
		case XsdFeatureDescriptorEnum.source_ord:
			specificBuilder.source();
			break;
		case XsdFeatureDescriptorEnum.content_ord:
			specificBuilder.content();
			break;
		case XsdFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case XsdFeatureDescriptorEnum._public_ord:
			specificBuilder._public();
			break;
		case XsdFeatureDescriptorEnum.system_ord:
			specificBuilder.system();
			break;
		case XsdFeatureDescriptorEnum.minOccurs_ord:
			specificBuilder.minOccurs();
			break;
		case XsdFeatureDescriptorEnum.maxOccurs_ord:
			specificBuilder.maxOccurs();
			break;
		case XsdFeatureDescriptorEnum.type_ord:
			specificBuilder.type();
			break;
		case XsdFeatureDescriptorEnum._abstract_ord:
			specificBuilder._abstract();
			break;
		case XsdFeatureDescriptorEnum.nillable_ord:
			specificBuilder.nillable();
			break;
		case XsdFeatureDescriptorEnum.defaultValue_ord:
			specificBuilder.defaultValue();
			break;
		case XsdFeatureDescriptorEnum.fixedValue_ord:
			specificBuilder.fixedValue();
			break;
		case XsdFeatureDescriptorEnum.form_ord:
			specificBuilder.form();
			break;
		case XsdFeatureDescriptorEnum.block_ord:
			specificBuilder.block();
			break;
		case XsdFeatureDescriptorEnum._final_ord:
			specificBuilder._final();
			break;
		case XsdFeatureDescriptorEnum.substitutionGroup_ord:
			specificBuilder.substitutionGroup();
			break;
		case XsdFeatureDescriptorEnum.typeDef_ord:
			specificBuilder.typeDef();
			break;
		case XsdFeatureDescriptorEnum.identityConstraintDefs_ord:
			specificBuilder.identityConstraintDefs();
			break;
		case XsdFeatureDescriptorEnum.ref_ord:
			specificBuilder.ref();
			break;
		case XsdFeatureDescriptorEnum.xpath_ord:
			specificBuilder.xpath();
			break;
		case XsdFeatureDescriptorEnum.selector_ord:
			specificBuilder.selector();
			break;
		case XsdFeatureDescriptorEnum.fields_ord:
			specificBuilder.fields();
			break;
		case XsdFeatureDescriptorEnum.refer_ord:
			specificBuilder.refer();
			break;
		case XsdFeatureDescriptorEnum.mixed_ord:
			specificBuilder.mixed();
			break;
		case XsdFeatureDescriptorEnum.simpleType_ord:
			specificBuilder.simpleType();
			break;
		case XsdFeatureDescriptorEnum.simpleTypeDef_ord:
			specificBuilder.simpleTypeDef();
			break;
		case XsdFeatureDescriptorEnum.use_ord:
			specificBuilder.use();
			break;
		case XsdFeatureDescriptorEnum.namespaceSpecs_ord:
			specificBuilder.namespaceSpecs();
			break;
		case XsdFeatureDescriptorEnum.processContents_ord:
			specificBuilder.processContents();
			break;
		case XsdFeatureDescriptorEnum.attributeUses_ord:
			specificBuilder.attributeUses();
			break;
		case XsdFeatureDescriptorEnum.anyAttribute_ord:
			specificBuilder.anyAttribute();
			break;
		case XsdFeatureDescriptorEnum.modelGroup_ord:
			specificBuilder.modelGroup();
			break;
		case XsdFeatureDescriptorEnum.itemType_ord:
			specificBuilder.itemType();
			break;
		case XsdFeatureDescriptorEnum.itemTypeDef_ord:
			specificBuilder.itemTypeDef();
			break;
		case XsdFeatureDescriptorEnum.memberTypes_ord:
			specificBuilder.memberTypes();
			break;
		case XsdFeatureDescriptorEnum.memberTypesDefs_ord:
			specificBuilder.memberTypesDefs();
			break;
		case XsdFeatureDescriptorEnum.base_ord:
			specificBuilder.base();
			break;
		case XsdFeatureDescriptorEnum.baseDef_ord:
			specificBuilder.baseDef();
			break;
		case XsdFeatureDescriptorEnum.facets_ord:
			specificBuilder.facets();
			break;
		case XsdFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		case XsdFeatureDescriptorEnum.fixed_ord:
			specificBuilder.fixed();
			break;
		case XsdFeatureDescriptorEnum.derivation_ord:
			specificBuilder.derivation();
			break;
		case XsdFeatureDescriptorEnum.particles_ord:
			specificBuilder.particles();
			break;
		case XsdFeatureDescriptorEnum.prefix_ord:
			specificBuilder.prefix();
			break;
		case XsdFeatureDescriptorEnum.uri_ord:
			specificBuilder.uri();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.Schema_ord:
			specificBuilder.Schema();
			break;
		case XsdEntityDescriptorEnum.SchemaDirectives_ord:
			specificBuilder.SchemaDirectives();
			break;
		case XsdEntityDescriptorEnum.Include_ord:
			specificBuilder.Include();
			break;
		case XsdEntityDescriptorEnum.Redefine_ord:
			specificBuilder.Redefine();
			break;
		case XsdEntityDescriptorEnum.RedefineComponents_ord:
			specificBuilder.RedefineComponents();
			break;
		case XsdEntityDescriptorEnum.Import_ord:
			specificBuilder.Import();
			break;
		case XsdEntityDescriptorEnum.Annotation_ord:
			specificBuilder.Annotation();
			break;
		case XsdEntityDescriptorEnum.AnnotationList_ord:
			specificBuilder.AnnotationList();
			break;
		case XsdEntityDescriptorEnum.Appinfo_ord:
			specificBuilder.Appinfo();
			break;
		case XsdEntityDescriptorEnum.Documentation_ord:
			specificBuilder.Documentation();
			break;
		case XsdEntityDescriptorEnum.AnnotationContents_ord:
			specificBuilder.AnnotationContents();
			break;
		case XsdEntityDescriptorEnum.SchemaComponents_ord:
			specificBuilder.SchemaComponents();
			break;
		case XsdEntityDescriptorEnum.NotationDecl_ord:
			specificBuilder.NotationDecl();
			break;
		case XsdEntityDescriptorEnum.ElementDecl_ord:
			specificBuilder.ElementDecl();
			break;
		case XsdEntityDescriptorEnum.ElementRef_ord:
			specificBuilder.ElementRef();
			break;
		case XsdEntityDescriptorEnum.IdentityConstraintDefs_ord:
			specificBuilder.IdentityConstraintDefs();
			break;
		case XsdEntityDescriptorEnum.Fields_ord:
			specificBuilder.Fields();
			break;
		case XsdEntityDescriptorEnum.Selector_ord:
			specificBuilder.Selector();
			break;
		case XsdEntityDescriptorEnum.Field_ord:
			specificBuilder.Field();
			break;
		case XsdEntityDescriptorEnum.Unique_ord:
			specificBuilder.Unique();
			break;
		case XsdEntityDescriptorEnum.Key_ord:
			specificBuilder.Key();
			break;
		case XsdEntityDescriptorEnum.Keyref_ord:
			specificBuilder.Keyref();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDefs_ord:
			specificBuilder.SimpleTypeDefs();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDef_ord:
			specificBuilder.SimpleTypeDef();
			break;
		case XsdEntityDescriptorEnum.ComplexTypeDef_ord:
			specificBuilder.ComplexTypeDef();
			break;
		case XsdEntityDescriptorEnum.AttributeDecl_ord:
			specificBuilder.AttributeDecl();
			break;
		case XsdEntityDescriptorEnum.AttributeUseOrGroups_ord:
			specificBuilder.AttributeUseOrGroups();
			break;
		case XsdEntityDescriptorEnum.AttributeUseDecl_ord:
			specificBuilder.AttributeUseDecl();
			break;
		case XsdEntityDescriptorEnum.AttributeUseRef_ord:
			specificBuilder.AttributeUseRef();
			break;
		case XsdEntityDescriptorEnum.AnyAttribute_ord:
			specificBuilder.AnyAttribute();
			break;
		case XsdEntityDescriptorEnum.AttributeGroupDef_ord:
			specificBuilder.AttributeGroupDef();
			break;
		case XsdEntityDescriptorEnum.AttributeGroupRef_ord:
			specificBuilder.AttributeGroupRef();
			break;
		case XsdEntityDescriptorEnum.ModelGroupDef_ord:
			specificBuilder.ModelGroupDef();
			break;
		case XsdEntityDescriptorEnum.ModelGroupRef_ord:
			specificBuilder.ModelGroupRef();
			break;
		case XsdEntityDescriptorEnum.Particles_ord:
			specificBuilder.Particles();
			break;
		case XsdEntityDescriptorEnum.List_ord:
			specificBuilder.List();
			break;
		case XsdEntityDescriptorEnum.Union_ord:
			specificBuilder.Union();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeRestriction_ord:
			specificBuilder.SimpleTypeRestriction();
			break;
		case XsdEntityDescriptorEnum.Facets_ord:
			specificBuilder.Facets();
			break;
		case XsdEntityDescriptorEnum.WhiteSpace_ord:
			specificBuilder.WhiteSpace();
			break;
		case XsdEntityDescriptorEnum.Length_ord:
			specificBuilder.Length();
			break;
		case XsdEntityDescriptorEnum.MinLength_ord:
			specificBuilder.MinLength();
			break;
		case XsdEntityDescriptorEnum.MaxLength_ord:
			specificBuilder.MaxLength();
			break;
		case XsdEntityDescriptorEnum.MinInclusive_ord:
			specificBuilder.MinInclusive();
			break;
		case XsdEntityDescriptorEnum.MaxInclusive_ord:
			specificBuilder.MaxInclusive();
			break;
		case XsdEntityDescriptorEnum.MinExclusive_ord:
			specificBuilder.MinExclusive();
			break;
		case XsdEntityDescriptorEnum.MaxExclusive_ord:
			specificBuilder.MaxExclusive();
			break;
		case XsdEntityDescriptorEnum.TotalDigits_ord:
			specificBuilder.TotalDigits();
			break;
		case XsdEntityDescriptorEnum.FractionDigits_ord:
			specificBuilder.FractionDigits();
			break;
		case XsdEntityDescriptorEnum.Pattern_ord:
			specificBuilder.Pattern();
			break;
		case XsdEntityDescriptorEnum.Enumeration_ord:
			specificBuilder.Enumeration();
			break;
		case XsdEntityDescriptorEnum.SimpleContent_ord:
			specificBuilder.SimpleContent();
			break;
		case XsdEntityDescriptorEnum.ComplexRestriction_ord:
			specificBuilder.ComplexRestriction();
			break;
		case XsdEntityDescriptorEnum.ComplexExtension_ord:
			specificBuilder.ComplexExtension();
			break;
		case XsdEntityDescriptorEnum.SimpleRestriction_ord:
			specificBuilder.SimpleRestriction();
			break;
		case XsdEntityDescriptorEnum.SimpleExtension_ord:
			specificBuilder.SimpleExtension();
			break;
		case XsdEntityDescriptorEnum.ComplexContent_ord:
			specificBuilder.ComplexContent();
			break;
		case XsdEntityDescriptorEnum.DeclaredContent_ord:
			specificBuilder.DeclaredContent();
			break;
		case XsdEntityDescriptorEnum.Sequence_ord:
			specificBuilder.Sequence();
			break;
		case XsdEntityDescriptorEnum.Choice_ord:
			specificBuilder.Choice();
			break;
		case XsdEntityDescriptorEnum.All_ord:
			specificBuilder.All();
			break;
		case XsdEntityDescriptorEnum.Any_ord:
			specificBuilder.Any();
			break;
		case XsdEntityDescriptorEnum.Unbounded_ord:
			specificBuilder.Unbounded();
			break;
		case XsdEntityDescriptorEnum.MemberTypes_ord:
			specificBuilder.MemberTypes();
			break;
		case XsdEntityDescriptorEnum.NamespaceDecl_ord:
			specificBuilder.NamespaceDecl();
			break;
		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
			specificBuilder.NamespaceDecls();
			break;
		case XsdEntityDescriptorEnum.Attributes_ord:
			specificBuilder.Attributes();
			break;
		case XsdEntityDescriptorEnum.AnyNamespaceSpecs_ord:
			specificBuilder.AnyNamespaceSpecs();
			break;
		case XsdEntityDescriptorEnum.OtherNamespaceSpecs_ord:
			specificBuilder.OtherNamespaceSpecs();
			break;
		case XsdEntityDescriptorEnum.NamespaceSpecsList_ord:
			specificBuilder.NamespaceSpecsList();
			break;
		case XsdEntityDescriptorEnum.TargetNamespaceSpec_ord:
			specificBuilder.TargetNamespaceSpec();
			break;
		case XsdEntityDescriptorEnum.LocalNamespaceSpec_ord:
			specificBuilder.LocalNamespaceSpec();
			break;
		case XsdEntityDescriptorEnum.DerivationAll_ord:
			specificBuilder.DerivationAll();
			break;
		case XsdEntityDescriptorEnum.DerivationList_ord:
			specificBuilder.DerivationList();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.Schema_ord:
			specificBuilder.Schema_();
			break;
		case XsdEntityDescriptorEnum.SchemaDirectives_ord:
			specificBuilder.SchemaDirectives_();
			break;
		case XsdEntityDescriptorEnum.Include_ord:
			specificBuilder.Include_();
			break;
		case XsdEntityDescriptorEnum.Redefine_ord:
			specificBuilder.Redefine_();
			break;
		case XsdEntityDescriptorEnum.RedefineComponents_ord:
			specificBuilder.RedefineComponents_();
			break;
		case XsdEntityDescriptorEnum.Import_ord:
			specificBuilder.Import_();
			break;
		case XsdEntityDescriptorEnum.Annotation_ord:
			specificBuilder.Annotation_();
			break;
		case XsdEntityDescriptorEnum.AnnotationList_ord:
			specificBuilder.AnnotationList_();
			break;
		case XsdEntityDescriptorEnum.Appinfo_ord:
			specificBuilder.Appinfo_();
			break;
		case XsdEntityDescriptorEnum.Documentation_ord:
			specificBuilder.Documentation_();
			break;
		case XsdEntityDescriptorEnum.AnnotationContents_ord:
			specificBuilder.AnnotationContents_();
			break;
		case XsdEntityDescriptorEnum.SchemaComponents_ord:
			specificBuilder.SchemaComponents_();
			break;
		case XsdEntityDescriptorEnum.NotationDecl_ord:
			specificBuilder.NotationDecl_();
			break;
		case XsdEntityDescriptorEnum.ElementDecl_ord:
			specificBuilder.ElementDecl_();
			break;
		case XsdEntityDescriptorEnum.ElementRef_ord:
			specificBuilder.ElementRef_();
			break;
		case XsdEntityDescriptorEnum.IdentityConstraintDefs_ord:
			specificBuilder.IdentityConstraintDefs_();
			break;
		case XsdEntityDescriptorEnum.Fields_ord:
			specificBuilder.Fields_();
			break;
		case XsdEntityDescriptorEnum.Selector_ord:
			specificBuilder.Selector_();
			break;
		case XsdEntityDescriptorEnum.Field_ord:
			specificBuilder.Field_();
			break;
		case XsdEntityDescriptorEnum.Unique_ord:
			specificBuilder.Unique_();
			break;
		case XsdEntityDescriptorEnum.Key_ord:
			specificBuilder.Key_();
			break;
		case XsdEntityDescriptorEnum.Keyref_ord:
			specificBuilder.Keyref_();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDefs_ord:
			specificBuilder.SimpleTypeDefs_();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDef_ord:
			specificBuilder.SimpleTypeDef_();
			break;
		case XsdEntityDescriptorEnum.ComplexTypeDef_ord:
			specificBuilder.ComplexTypeDef_();
			break;
		case XsdEntityDescriptorEnum.AttributeDecl_ord:
			specificBuilder.AttributeDecl_();
			break;
		case XsdEntityDescriptorEnum.AttributeUseOrGroups_ord:
			specificBuilder.AttributeUseOrGroups_();
			break;
		case XsdEntityDescriptorEnum.AttributeUseDecl_ord:
			specificBuilder.AttributeUseDecl_();
			break;
		case XsdEntityDescriptorEnum.AttributeUseRef_ord:
			specificBuilder.AttributeUseRef_();
			break;
		case XsdEntityDescriptorEnum.AnyAttribute_ord:
			specificBuilder.AnyAttribute_();
			break;
		case XsdEntityDescriptorEnum.AttributeGroupDef_ord:
			specificBuilder.AttributeGroupDef_();
			break;
		case XsdEntityDescriptorEnum.AttributeGroupRef_ord:
			specificBuilder.AttributeGroupRef_();
			break;
		case XsdEntityDescriptorEnum.ModelGroupDef_ord:
			specificBuilder.ModelGroupDef_();
			break;
		case XsdEntityDescriptorEnum.ModelGroupRef_ord:
			specificBuilder.ModelGroupRef_();
			break;
		case XsdEntityDescriptorEnum.Particles_ord:
			specificBuilder.Particles_();
			break;
		case XsdEntityDescriptorEnum.List_ord:
			specificBuilder.List_();
			break;
		case XsdEntityDescriptorEnum.Union_ord:
			specificBuilder.Union_();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeRestriction_ord:
			specificBuilder.SimpleTypeRestriction_();
			break;
		case XsdEntityDescriptorEnum.Facets_ord:
			specificBuilder.Facets_();
			break;
		case XsdEntityDescriptorEnum.WhiteSpace_ord:
			specificBuilder.WhiteSpace_();
			break;
		case XsdEntityDescriptorEnum.Length_ord:
			specificBuilder.Length_();
			break;
		case XsdEntityDescriptorEnum.MinLength_ord:
			specificBuilder.MinLength_();
			break;
		case XsdEntityDescriptorEnum.MaxLength_ord:
			specificBuilder.MaxLength_();
			break;
		case XsdEntityDescriptorEnum.MinInclusive_ord:
			specificBuilder.MinInclusive_();
			break;
		case XsdEntityDescriptorEnum.MaxInclusive_ord:
			specificBuilder.MaxInclusive_();
			break;
		case XsdEntityDescriptorEnum.MinExclusive_ord:
			specificBuilder.MinExclusive_();
			break;
		case XsdEntityDescriptorEnum.MaxExclusive_ord:
			specificBuilder.MaxExclusive_();
			break;
		case XsdEntityDescriptorEnum.TotalDigits_ord:
			specificBuilder.TotalDigits_();
			break;
		case XsdEntityDescriptorEnum.FractionDigits_ord:
			specificBuilder.FractionDigits_();
			break;
		case XsdEntityDescriptorEnum.Pattern_ord:
			specificBuilder.Pattern_();
			break;
		case XsdEntityDescriptorEnum.Enumeration_ord:
			specificBuilder.Enumeration_();
			break;
		case XsdEntityDescriptorEnum.SimpleContent_ord:
			specificBuilder.SimpleContent_();
			break;
		case XsdEntityDescriptorEnum.ComplexRestriction_ord:
			specificBuilder.ComplexRestriction_();
			break;
		case XsdEntityDescriptorEnum.ComplexExtension_ord:
			specificBuilder.ComplexExtension_();
			break;
		case XsdEntityDescriptorEnum.SimpleRestriction_ord:
			specificBuilder.SimpleRestriction_();
			break;
		case XsdEntityDescriptorEnum.SimpleExtension_ord:
			specificBuilder.SimpleExtension_();
			break;
		case XsdEntityDescriptorEnum.ComplexContent_ord:
			specificBuilder.ComplexContent_();
			break;
		case XsdEntityDescriptorEnum.DeclaredContent_ord:
			specificBuilder.DeclaredContent_();
			break;
		case XsdEntityDescriptorEnum.Sequence_ord:
			specificBuilder.Sequence_();
			break;
		case XsdEntityDescriptorEnum.Choice_ord:
			specificBuilder.Choice_();
			break;
		case XsdEntityDescriptorEnum.All_ord:
			specificBuilder.All_();
			break;
		case XsdEntityDescriptorEnum.Any_ord:
			specificBuilder.Any_();
			break;
		case XsdEntityDescriptorEnum.Unbounded_ord:
			specificBuilder.Unbounded_();
			break;
		case XsdEntityDescriptorEnum.MemberTypes_ord:
			specificBuilder.MemberTypes_();
			break;
		case XsdEntityDescriptorEnum.NamespaceDecl_ord:
			specificBuilder.NamespaceDecl_();
			break;
		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
			specificBuilder.NamespaceDecls_();
			break;
		case XsdEntityDescriptorEnum.Attributes_ord:
			specificBuilder.Attributes_();
			break;
		case XsdEntityDescriptorEnum.AnyNamespaceSpecs_ord:
			specificBuilder.AnyNamespaceSpecs_();
			break;
		case XsdEntityDescriptorEnum.OtherNamespaceSpecs_ord:
			specificBuilder.OtherNamespaceSpecs_();
			break;
		case XsdEntityDescriptorEnum.NamespaceSpecsList_ord:
			specificBuilder.NamespaceSpecsList_();
			break;
		case XsdEntityDescriptorEnum.TargetNamespaceSpec_ord:
			specificBuilder.TargetNamespaceSpec_();
			break;
		case XsdEntityDescriptorEnum.LocalNamespaceSpec_ord:
			specificBuilder.LocalNamespaceSpec_();
			break;
		case XsdEntityDescriptorEnum.DerivationAll_ord:
			specificBuilder.DerivationAll_();
			break;
		case XsdEntityDescriptorEnum.DerivationList_ord:
			specificBuilder.DerivationList_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.Schema_ord:
			specificBuilder._Schema();
			break;
		case XsdEntityDescriptorEnum.SchemaDirectives_ord:
			specificBuilder._SchemaDirectives();
			break;
		case XsdEntityDescriptorEnum.Include_ord:
			specificBuilder._Include();
			break;
		case XsdEntityDescriptorEnum.Redefine_ord:
			specificBuilder._Redefine();
			break;
		case XsdEntityDescriptorEnum.RedefineComponents_ord:
			specificBuilder._RedefineComponents();
			break;
		case XsdEntityDescriptorEnum.Import_ord:
			specificBuilder._Import();
			break;
		case XsdEntityDescriptorEnum.Annotation_ord:
			specificBuilder._Annotation();
			break;
		case XsdEntityDescriptorEnum.AnnotationList_ord:
			specificBuilder._AnnotationList();
			break;
		case XsdEntityDescriptorEnum.Appinfo_ord:
			specificBuilder._Appinfo();
			break;
		case XsdEntityDescriptorEnum.Documentation_ord:
			specificBuilder._Documentation();
			break;
		case XsdEntityDescriptorEnum.AnnotationContents_ord:
			specificBuilder._AnnotationContents();
			break;
		case XsdEntityDescriptorEnum.SchemaComponents_ord:
			specificBuilder._SchemaComponents();
			break;
		case XsdEntityDescriptorEnum.NotationDecl_ord:
			specificBuilder._NotationDecl();
			break;
		case XsdEntityDescriptorEnum.ElementDecl_ord:
			specificBuilder._ElementDecl();
			break;
		case XsdEntityDescriptorEnum.ElementRef_ord:
			specificBuilder._ElementRef();
			break;
		case XsdEntityDescriptorEnum.IdentityConstraintDefs_ord:
			specificBuilder._IdentityConstraintDefs();
			break;
		case XsdEntityDescriptorEnum.Fields_ord:
			specificBuilder._Fields();
			break;
		case XsdEntityDescriptorEnum.Selector_ord:
			specificBuilder._Selector();
			break;
		case XsdEntityDescriptorEnum.Field_ord:
			specificBuilder._Field();
			break;
		case XsdEntityDescriptorEnum.Unique_ord:
			specificBuilder._Unique();
			break;
		case XsdEntityDescriptorEnum.Key_ord:
			specificBuilder._Key();
			break;
		case XsdEntityDescriptorEnum.Keyref_ord:
			specificBuilder._Keyref();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDefs_ord:
			specificBuilder._SimpleTypeDefs();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDef_ord:
			specificBuilder._SimpleTypeDef();
			break;
		case XsdEntityDescriptorEnum.ComplexTypeDef_ord:
			specificBuilder._ComplexTypeDef();
			break;
		case XsdEntityDescriptorEnum.AttributeDecl_ord:
			specificBuilder._AttributeDecl();
			break;
		case XsdEntityDescriptorEnum.AttributeUseOrGroups_ord:
			specificBuilder._AttributeUseOrGroups();
			break;
		case XsdEntityDescriptorEnum.AttributeUseDecl_ord:
			specificBuilder._AttributeUseDecl();
			break;
		case XsdEntityDescriptorEnum.AttributeUseRef_ord:
			specificBuilder._AttributeUseRef();
			break;
		case XsdEntityDescriptorEnum.AnyAttribute_ord:
			specificBuilder._AnyAttribute();
			break;
		case XsdEntityDescriptorEnum.AttributeGroupDef_ord:
			specificBuilder._AttributeGroupDef();
			break;
		case XsdEntityDescriptorEnum.AttributeGroupRef_ord:
			specificBuilder._AttributeGroupRef();
			break;
		case XsdEntityDescriptorEnum.ModelGroupDef_ord:
			specificBuilder._ModelGroupDef();
			break;
		case XsdEntityDescriptorEnum.ModelGroupRef_ord:
			specificBuilder._ModelGroupRef();
			break;
		case XsdEntityDescriptorEnum.Particles_ord:
			specificBuilder._Particles();
			break;
		case XsdEntityDescriptorEnum.List_ord:
			specificBuilder._List();
			break;
		case XsdEntityDescriptorEnum.Union_ord:
			specificBuilder._Union();
			break;
		case XsdEntityDescriptorEnum.SimpleTypeRestriction_ord:
			specificBuilder._SimpleTypeRestriction();
			break;
		case XsdEntityDescriptorEnum.Facets_ord:
			specificBuilder._Facets();
			break;
		case XsdEntityDescriptorEnum.WhiteSpace_ord:
			specificBuilder._WhiteSpace();
			break;
		case XsdEntityDescriptorEnum.Length_ord:
			specificBuilder._Length();
			break;
		case XsdEntityDescriptorEnum.MinLength_ord:
			specificBuilder._MinLength();
			break;
		case XsdEntityDescriptorEnum.MaxLength_ord:
			specificBuilder._MaxLength();
			break;
		case XsdEntityDescriptorEnum.MinInclusive_ord:
			specificBuilder._MinInclusive();
			break;
		case XsdEntityDescriptorEnum.MaxInclusive_ord:
			specificBuilder._MaxInclusive();
			break;
		case XsdEntityDescriptorEnum.MinExclusive_ord:
			specificBuilder._MinExclusive();
			break;
		case XsdEntityDescriptorEnum.MaxExclusive_ord:
			specificBuilder._MaxExclusive();
			break;
		case XsdEntityDescriptorEnum.TotalDigits_ord:
			specificBuilder._TotalDigits();
			break;
		case XsdEntityDescriptorEnum.FractionDigits_ord:
			specificBuilder._FractionDigits();
			break;
		case XsdEntityDescriptorEnum.Pattern_ord:
			specificBuilder._Pattern();
			break;
		case XsdEntityDescriptorEnum.Enumeration_ord:
			specificBuilder._Enumeration();
			break;
		case XsdEntityDescriptorEnum.SimpleContent_ord:
			specificBuilder._SimpleContent();
			break;
		case XsdEntityDescriptorEnum.ComplexRestriction_ord:
			specificBuilder._ComplexRestriction();
			break;
		case XsdEntityDescriptorEnum.ComplexExtension_ord:
			specificBuilder._ComplexExtension();
			break;
		case XsdEntityDescriptorEnum.SimpleRestriction_ord:
			specificBuilder._SimpleRestriction();
			break;
		case XsdEntityDescriptorEnum.SimpleExtension_ord:
			specificBuilder._SimpleExtension();
			break;
		case XsdEntityDescriptorEnum.ComplexContent_ord:
			specificBuilder._ComplexContent();
			break;
		case XsdEntityDescriptorEnum.DeclaredContent_ord:
			specificBuilder._DeclaredContent();
			break;
		case XsdEntityDescriptorEnum.Sequence_ord:
			specificBuilder._Sequence();
			break;
		case XsdEntityDescriptorEnum.Choice_ord:
			specificBuilder._Choice();
			break;
		case XsdEntityDescriptorEnum.All_ord:
			specificBuilder._All();
			break;
		case XsdEntityDescriptorEnum.Any_ord:
			specificBuilder._Any();
			break;
		case XsdEntityDescriptorEnum.Unbounded_ord:
			specificBuilder._Unbounded();
			break;
		case XsdEntityDescriptorEnum.MemberTypes_ord:
			specificBuilder._MemberTypes();
			break;
		case XsdEntityDescriptorEnum.NamespaceDecl_ord:
			specificBuilder._NamespaceDecl();
			break;
		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
			specificBuilder._NamespaceDecls();
			break;
		case XsdEntityDescriptorEnum.Attributes_ord:
			specificBuilder._Attributes();
			break;
		case XsdEntityDescriptorEnum.AnyNamespaceSpecs_ord:
			specificBuilder._AnyNamespaceSpecs();
			break;
		case XsdEntityDescriptorEnum.OtherNamespaceSpecs_ord:
			specificBuilder._OtherNamespaceSpecs();
			break;
		case XsdEntityDescriptorEnum.NamespaceSpecsList_ord:
			specificBuilder._NamespaceSpecsList();
			break;
		case XsdEntityDescriptorEnum.TargetNamespaceSpec_ord:
			specificBuilder._TargetNamespaceSpec();
			break;
		case XsdEntityDescriptorEnum.LocalNamespaceSpec_ord:
			specificBuilder._LocalNamespaceSpec();
			break;
		case XsdEntityDescriptorEnum.DerivationAll_ord:
			specificBuilder._DerivationAll();
			break;
		case XsdEntityDescriptorEnum.DerivationList_ord:
			specificBuilder._DerivationList();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.SchemaDirectives_ord:
			specificBuilder.SchemaDirectives_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.RedefineComponents_ord:
			specificBuilder.RedefineComponents_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.AnnotationList_ord:
			specificBuilder.AnnotationList_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.AnnotationContents_ord:
			specificBuilder.AnnotationContents_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.SchemaComponents_ord:
			specificBuilder.SchemaComponents_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.IdentityConstraintDefs_ord:
			specificBuilder.IdentityConstraintDefs_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.Fields_ord:
			specificBuilder.Fields_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDefs_ord:
			specificBuilder.SimpleTypeDefs_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.AttributeUseOrGroups_ord:
			specificBuilder.AttributeUseOrGroups_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.Particles_ord:
			specificBuilder.Particles_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.Facets_ord:
			specificBuilder.Facets_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.MemberTypes_ord:
			specificBuilder.MemberTypes_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
			specificBuilder.NamespaceDecls_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.Attributes_ord:
			specificBuilder.Attributes_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.NamespaceSpecsList_ord:
			specificBuilder.NamespaceSpecsList_(initialCapacity);
			break;
		case XsdEntityDescriptorEnum.DerivationList_ord:
			specificBuilder.DerivationList_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.Bounded_ord:
			specificBuilder.Bounded(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case XsdEntityDescriptorEnum.QName_ord:
			specificBuilder.QName(value);
			break;
		case XsdEntityDescriptorEnum.AnyURI_ord:
			specificBuilder.AnyURI(value);
			break;
		case XsdEntityDescriptorEnum.MixedText_ord:
			specificBuilder.MixedText(value);
			break;
		case XsdEntityDescriptorEnum.XPathString_ord:
			specificBuilder.XPathString(value);
			break;
		case XsdEntityDescriptorEnum.StringData_ord:
			specificBuilder.StringData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.ProcessContents_ord:
			specificBuilder.ProcessContents((Value) value);
			break;
		case XsdEntityDescriptorEnum.DerivationControl_ord:
			specificBuilder
					.DerivationControl((org.whole.lang.xsd.model.DerivationControlEnum.Value) value);
			break;
		case XsdEntityDescriptorEnum.Use_ord:
			specificBuilder.Use((org.whole.lang.xsd.model.UseEnum.Value) value);
			break;
		case XsdEntityDescriptorEnum.WhiteSpaceProcessing_ord:
			specificBuilder
					.WhiteSpaceProcessing((org.whole.lang.xsd.model.WhiteSpaceProcessingEnum.Value) value);
			break;
		case XsdEntityDescriptorEnum.Qualify_ord:
			specificBuilder
					.Qualify((org.whole.lang.xsd.model.QualifyEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, BigInteger value) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.IntegerData_ord:
			specificBuilder.IntegerData(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case XsdEntityDescriptorEnum.BooleanData_ord:
			specificBuilder.BooleanData(value);
			break;
		}
	}
}
