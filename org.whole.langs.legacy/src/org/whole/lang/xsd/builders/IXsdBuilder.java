package org.whole.lang.xsd.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.xsd.model.ProcessContentsEnum;
import org.whole.lang.xsd.model.DerivationControlEnum;
import org.whole.lang.xsd.model.UseEnum;
import org.whole.lang.xsd.model.WhiteSpaceProcessingEnum;
import java.math.BigInteger;
import org.whole.lang.xsd.model.QualifyEnum;

/** 
 * @generator Whole
 */
public interface IXsdBuilder extends IBuilder {
	public void visit();

	public void uri();

	public void prefix();

	public void particles();

	public void derivation();

	public void fixed();

	public void value();

	public void facets();

	public void baseDef();

	public void base();

	public void memberTypesDefs();

	public void memberTypes();

	public void itemTypeDef();

	public void itemType();

	public void modelGroup();

	public void anyAttribute();

	public void attributeUses();

	public void processContents();

	public void namespaceSpecs();

	public void use();

	public void simpleTypeDef();

	public void simpleType();

	public void mixed();

	public void refer();

	public void fields();

	public void selector();

	public void xpath();

	public void ref();

	public void identityConstraintDefs();

	public void typeDef();

	public void substitutionGroup();

	public void _final();

	public void block();

	public void form();

	public void fixedValue();

	public void defaultValue();

	public void nillable();

	public void _abstract();

	public void type();

	public void maxOccurs();

	public void minOccurs();

	public void system();

	public void _public();

	public void name();

	public void content();

	public void source();

	public void list();

	public void namespace();

	public void definitions();

	public void schemaLocation();

	public void annotation();

	public void components();

	public void directives();

	public void finalDefault();

	public void blockDefault();

	public void elementFormDefault();

	public void attributeFormDefault();

	public void language();

	public void version();

	public void targetNamespace();

	public void attributes();

	public void id();

	public void namespaces();

	public void Schema();

	public void Schema_();

	public void _Schema();

	public void SchemaDirectives();

	public void SchemaDirectives_();

	public void SchemaDirectives_(int initialCapacity);

	public void _SchemaDirectives();

	public void Include();

	public void Include_();

	public void _Include();

	public void Redefine();

	public void Redefine_();

	public void _Redefine();

	public void RedefineComponents();

	public void RedefineComponents_();

	public void RedefineComponents_(int initialCapacity);

	public void _RedefineComponents();

	public void Import();

	public void Import_();

	public void _Import();

	public void Annotation();

	public void Annotation_();

	public void _Annotation();

	public void AnnotationList();

	public void AnnotationList_();

	public void AnnotationList_(int initialCapacity);

	public void _AnnotationList();

	public void Appinfo();

	public void Appinfo_();

	public void _Appinfo();

	public void Documentation();

	public void Documentation_();

	public void _Documentation();

	public void AnnotationContents();

	public void AnnotationContents_();

	public void AnnotationContents_(int initialCapacity);

	public void _AnnotationContents();

	public void SchemaComponents();

	public void SchemaComponents_();

	public void SchemaComponents_(int initialCapacity);

	public void _SchemaComponents();

	public void NotationDecl();

	public void NotationDecl_();

	public void _NotationDecl();

	public void ElementDecl();

	public void ElementDecl_();

	public void _ElementDecl();

	public void ElementRef();

	public void ElementRef_();

	public void _ElementRef();

	public void IdentityConstraintDefs();

	public void IdentityConstraintDefs_();

	public void IdentityConstraintDefs_(int initialCapacity);

	public void _IdentityConstraintDefs();

	public void Fields();

	public void Fields_();

	public void Fields_(int initialCapacity);

	public void _Fields();

	public void Selector();

	public void Selector_();

	public void _Selector();

	public void Field();

	public void Field_();

	public void _Field();

	public void Unique();

	public void Unique_();

	public void _Unique();

	public void Key();

	public void Key_();

	public void _Key();

	public void Keyref();

	public void Keyref_();

	public void _Keyref();

	public void SimpleTypeDefs();

	public void SimpleTypeDefs_();

	public void SimpleTypeDefs_(int initialCapacity);

	public void _SimpleTypeDefs();

	public void SimpleTypeDef();

	public void SimpleTypeDef_();

	public void _SimpleTypeDef();

	public void ComplexTypeDef();

	public void ComplexTypeDef_();

	public void _ComplexTypeDef();

	public void AttributeDecl();

	public void AttributeDecl_();

	public void _AttributeDecl();

	public void AttributeUseOrGroups();

	public void AttributeUseOrGroups_();

	public void AttributeUseOrGroups_(int initialCapacity);

	public void _AttributeUseOrGroups();

	public void AttributeUseDecl();

	public void AttributeUseDecl_();

	public void _AttributeUseDecl();

	public void AttributeUseRef();

	public void AttributeUseRef_();

	public void _AttributeUseRef();

	public void AnyAttribute();

	public void AnyAttribute_();

	public void _AnyAttribute();

	public void AttributeGroupDef();

	public void AttributeGroupDef_();

	public void _AttributeGroupDef();

	public void AttributeGroupRef();

	public void AttributeGroupRef_();

	public void _AttributeGroupRef();

	public void ModelGroupDef();

	public void ModelGroupDef_();

	public void _ModelGroupDef();

	public void ModelGroupRef();

	public void ModelGroupRef_();

	public void _ModelGroupRef();

	public void Particles();

	public void Particles_();

	public void Particles_(int initialCapacity);

	public void _Particles();

	public void List();

	public void List_();

	public void _List();

	public void Union();

	public void Union_();

	public void _Union();

	public void SimpleTypeRestriction();

	public void SimpleTypeRestriction_();

	public void _SimpleTypeRestriction();

	public void Facets();

	public void Facets_();

	public void Facets_(int initialCapacity);

	public void _Facets();

	public void WhiteSpace();

	public void WhiteSpace_();

	public void _WhiteSpace();

	public void Length();

	public void Length_();

	public void _Length();

	public void MinLength();

	public void MinLength_();

	public void _MinLength();

	public void MaxLength();

	public void MaxLength_();

	public void _MaxLength();

	public void MinInclusive();

	public void MinInclusive_();

	public void _MinInclusive();

	public void MaxInclusive();

	public void MaxInclusive_();

	public void _MaxInclusive();

	public void MinExclusive();

	public void MinExclusive_();

	public void _MinExclusive();

	public void MaxExclusive();

	public void MaxExclusive_();

	public void _MaxExclusive();

	public void TotalDigits();

	public void TotalDigits_();

	public void _TotalDigits();

	public void FractionDigits();

	public void FractionDigits_();

	public void _FractionDigits();

	public void Pattern();

	public void Pattern_();

	public void _Pattern();

	public void Enumeration();

	public void Enumeration_();

	public void _Enumeration();

	public void SimpleContent();

	public void SimpleContent_();

	public void _SimpleContent();

	public void ComplexRestriction();

	public void ComplexRestriction_();

	public void _ComplexRestriction();

	public void ComplexExtension();

	public void ComplexExtension_();

	public void _ComplexExtension();

	public void SimpleRestriction();

	public void SimpleRestriction_();

	public void _SimpleRestriction();

	public void SimpleExtension();

	public void SimpleExtension_();

	public void _SimpleExtension();

	public void ComplexContent();

	public void ComplexContent_();

	public void _ComplexContent();

	public void DeclaredContent();

	public void DeclaredContent_();

	public void _DeclaredContent();

	public void Sequence();

	public void Sequence_();

	public void _Sequence();

	public void Choice();

	public void Choice_();

	public void _Choice();

	public void All();

	public void All_();

	public void _All();

	public void Any();

	public void Any_();

	public void _Any();

	public void Bounded();

	public void Bounded(int value);

	public void Unbounded();

	public void Unbounded_();

	public void _Unbounded();

	public void MemberTypes();

	public void MemberTypes_();

	public void MemberTypes_(int initialCapacity);

	public void _MemberTypes();

	public void Name();

	public void Name(String value);

	public void QName();

	public void QName(String value);

	public void AnyURI();

	public void AnyURI(String value);

	public void NamespaceDecl();

	public void NamespaceDecl_();

	public void _NamespaceDecl();

	public void NamespaceDecls();

	public void NamespaceDecls_();

	public void NamespaceDecls_(int initialCapacity);

	public void _NamespaceDecls();

	public void Attributes();

	public void Attributes_();

	public void Attributes_(int initialCapacity);

	public void _Attributes();

	public void ProcessContents();

	public void ProcessContents(ProcessContentsEnum.Value value);

	public void ProcessContents(String value);

	public void AnyNamespaceSpecs();

	public void AnyNamespaceSpecs_();

	public void _AnyNamespaceSpecs();

	public void OtherNamespaceSpecs();

	public void OtherNamespaceSpecs_();

	public void _OtherNamespaceSpecs();

	public void NamespaceSpecsList();

	public void NamespaceSpecsList_();

	public void NamespaceSpecsList_(int initialCapacity);

	public void _NamespaceSpecsList();

	public void TargetNamespaceSpec();

	public void TargetNamespaceSpec_();

	public void _TargetNamespaceSpec();

	public void LocalNamespaceSpec();

	public void LocalNamespaceSpec_();

	public void _LocalNamespaceSpec();

	public void DerivationAll();

	public void DerivationAll_();

	public void _DerivationAll();

	public void DerivationList();

	public void DerivationList_();

	public void DerivationList_(int initialCapacity);

	public void _DerivationList();

	public void DerivationControl();

	public void DerivationControl(DerivationControlEnum.Value value);

	public void DerivationControl(String value);

	public void Use();

	public void Use(UseEnum.Value value);

	public void Use(String value);

	public void WhiteSpaceProcessing();

	public void WhiteSpaceProcessing(WhiteSpaceProcessingEnum.Value value);

	public void WhiteSpaceProcessing(String value);

	public void MixedText();

	public void MixedText(String value);

	public void XPathString();

	public void XPathString(String value);

	public void StringData();

	public void StringData(String value);

	public void IntegerData();

	public void IntegerData(BigInteger value);

	public void IntegerData(String value);

	public void BooleanData();

	public void BooleanData(boolean value);

	public void Qualify();

	public void Qualify(QualifyEnum.Value value);

	public void Qualify(String value);
}
