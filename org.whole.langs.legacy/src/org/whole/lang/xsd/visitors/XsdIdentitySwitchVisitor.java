package org.whole.lang.xsd.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class XsdIdentitySwitchVisitor extends AbstractVisitor
		implements IXsdVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case XsdEntityDescriptorEnum.Schema_ord:
			visit((Schema) entity);
			break;
		case XsdEntityDescriptorEnum.SchemaDirectives_ord:
			visit((SchemaDirectives) entity);
			break;
		case XsdEntityDescriptorEnum.Include_ord:
			visit((Include) entity);
			break;
		case XsdEntityDescriptorEnum.Redefine_ord:
			visit((Redefine) entity);
			break;
		case XsdEntityDescriptorEnum.RedefineComponents_ord:
			visit((RedefineComponents) entity);
			break;
		case XsdEntityDescriptorEnum.Import_ord:
			visit((Import) entity);
			break;
		case XsdEntityDescriptorEnum.Annotation_ord:
			visit((Annotation) entity);
			break;
		case XsdEntityDescriptorEnum.AnnotationList_ord:
			visit((AnnotationList) entity);
			break;
		case XsdEntityDescriptorEnum.Appinfo_ord:
			visit((Appinfo) entity);
			break;
		case XsdEntityDescriptorEnum.Documentation_ord:
			visit((Documentation) entity);
			break;
		case XsdEntityDescriptorEnum.AnnotationContents_ord:
			visit((AnnotationContents) entity);
			break;
		case XsdEntityDescriptorEnum.SchemaComponents_ord:
			visit((SchemaComponents) entity);
			break;
		case XsdEntityDescriptorEnum.NotationDecl_ord:
			visit((NotationDecl) entity);
			break;
		case XsdEntityDescriptorEnum.ElementDecl_ord:
			visit((ElementDecl) entity);
			break;
		case XsdEntityDescriptorEnum.ElementRef_ord:
			visit((ElementRef) entity);
			break;
		case XsdEntityDescriptorEnum.IdentityConstraintDefs_ord:
			visit((IdentityConstraintDefs) entity);
			break;
		case XsdEntityDescriptorEnum.Fields_ord:
			visit((Fields) entity);
			break;
		case XsdEntityDescriptorEnum.Selector_ord:
			visit((Selector) entity);
			break;
		case XsdEntityDescriptorEnum.Field_ord:
			visit((Field) entity);
			break;
		case XsdEntityDescriptorEnum.Unique_ord:
			visit((Unique) entity);
			break;
		case XsdEntityDescriptorEnum.Key_ord:
			visit((Key) entity);
			break;
		case XsdEntityDescriptorEnum.Keyref_ord:
			visit((Keyref) entity);
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDefs_ord:
			visit((SimpleTypeDefs) entity);
			break;
		case XsdEntityDescriptorEnum.SimpleTypeDef_ord:
			visit((SimpleTypeDef) entity);
			break;
		case XsdEntityDescriptorEnum.ComplexTypeDef_ord:
			visit((ComplexTypeDef) entity);
			break;
		case XsdEntityDescriptorEnum.AttributeDecl_ord:
			visit((AttributeDecl) entity);
			break;
		case XsdEntityDescriptorEnum.AttributeUseOrGroups_ord:
			visit((AttributeUseOrGroups) entity);
			break;
		case XsdEntityDescriptorEnum.AttributeUseDecl_ord:
			visit((AttributeUseDecl) entity);
			break;
		case XsdEntityDescriptorEnum.AttributeUseRef_ord:
			visit((AttributeUseRef) entity);
			break;
		case XsdEntityDescriptorEnum.AnyAttribute_ord:
			visit((AnyAttribute) entity);
			break;
		case XsdEntityDescriptorEnum.AttributeGroupDef_ord:
			visit((AttributeGroupDef) entity);
			break;
		case XsdEntityDescriptorEnum.AttributeGroupRef_ord:
			visit((AttributeGroupRef) entity);
			break;
		case XsdEntityDescriptorEnum.ModelGroupDef_ord:
			visit((ModelGroupDef) entity);
			break;
		case XsdEntityDescriptorEnum.ModelGroupRef_ord:
			visit((ModelGroupRef) entity);
			break;
		case XsdEntityDescriptorEnum.Particles_ord:
			visit((Particles) entity);
			break;
		case XsdEntityDescriptorEnum.List_ord:
			visit((List) entity);
			break;
		case XsdEntityDescriptorEnum.Union_ord:
			visit((Union) entity);
			break;
		case XsdEntityDescriptorEnum.SimpleTypeRestriction_ord:
			visit((SimpleTypeRestriction) entity);
			break;
		case XsdEntityDescriptorEnum.Facets_ord:
			visit((Facets) entity);
			break;
		case XsdEntityDescriptorEnum.WhiteSpace_ord:
			visit((WhiteSpace) entity);
			break;
		case XsdEntityDescriptorEnum.Length_ord:
			visit((Length) entity);
			break;
		case XsdEntityDescriptorEnum.MinLength_ord:
			visit((MinLength) entity);
			break;
		case XsdEntityDescriptorEnum.MaxLength_ord:
			visit((MaxLength) entity);
			break;
		case XsdEntityDescriptorEnum.MinInclusive_ord:
			visit((MinInclusive) entity);
			break;
		case XsdEntityDescriptorEnum.MaxInclusive_ord:
			visit((MaxInclusive) entity);
			break;
		case XsdEntityDescriptorEnum.MinExclusive_ord:
			visit((MinExclusive) entity);
			break;
		case XsdEntityDescriptorEnum.MaxExclusive_ord:
			visit((MaxExclusive) entity);
			break;
		case XsdEntityDescriptorEnum.TotalDigits_ord:
			visit((TotalDigits) entity);
			break;
		case XsdEntityDescriptorEnum.FractionDigits_ord:
			visit((FractionDigits) entity);
			break;
		case XsdEntityDescriptorEnum.Pattern_ord:
			visit((Pattern) entity);
			break;
		case XsdEntityDescriptorEnum.Enumeration_ord:
			visit((Enumeration) entity);
			break;
		case XsdEntityDescriptorEnum.SimpleContent_ord:
			visit((SimpleContent) entity);
			break;
		case XsdEntityDescriptorEnum.ComplexRestriction_ord:
			visit((ComplexRestriction) entity);
			break;
		case XsdEntityDescriptorEnum.ComplexExtension_ord:
			visit((ComplexExtension) entity);
			break;
		case XsdEntityDescriptorEnum.SimpleRestriction_ord:
			visit((SimpleRestriction) entity);
			break;
		case XsdEntityDescriptorEnum.SimpleExtension_ord:
			visit((SimpleExtension) entity);
			break;
		case XsdEntityDescriptorEnum.ComplexContent_ord:
			visit((ComplexContent) entity);
			break;
		case XsdEntityDescriptorEnum.DeclaredContent_ord:
			visit((DeclaredContent) entity);
			break;
		case XsdEntityDescriptorEnum.Sequence_ord:
			visit((Sequence) entity);
			break;
		case XsdEntityDescriptorEnum.Choice_ord:
			visit((Choice) entity);
			break;
		case XsdEntityDescriptorEnum.All_ord:
			visit((All) entity);
			break;
		case XsdEntityDescriptorEnum.Any_ord:
			visit((Any) entity);
			break;
		case XsdEntityDescriptorEnum.Bounded_ord:
			visit((Bounded) entity);
			break;
		case XsdEntityDescriptorEnum.Unbounded_ord:
			visit((Unbounded) entity);
			break;
		case XsdEntityDescriptorEnum.MemberTypes_ord:
			visit((MemberTypes) entity);
			break;
		case XsdEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case XsdEntityDescriptorEnum.QName_ord:
			visit((QName) entity);
			break;
		case XsdEntityDescriptorEnum.AnyURI_ord:
			visit((AnyURI) entity);
			break;
		case XsdEntityDescriptorEnum.NamespaceDecl_ord:
			visit((NamespaceDecl) entity);
			break;
		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
			visit((NamespaceDecls) entity);
			break;
		case XsdEntityDescriptorEnum.Attributes_ord:
			visit((Attributes) entity);
			break;
		case XsdEntityDescriptorEnum.ProcessContents_ord:
			visit((ProcessContents) entity);
			break;
		case XsdEntityDescriptorEnum.AnyNamespaceSpecs_ord:
			visit((AnyNamespaceSpecs) entity);
			break;
		case XsdEntityDescriptorEnum.OtherNamespaceSpecs_ord:
			visit((OtherNamespaceSpecs) entity);
			break;
		case XsdEntityDescriptorEnum.NamespaceSpecsList_ord:
			visit((NamespaceSpecsList) entity);
			break;
		case XsdEntityDescriptorEnum.TargetNamespaceSpec_ord:
			visit((TargetNamespaceSpec) entity);
			break;
		case XsdEntityDescriptorEnum.LocalNamespaceSpec_ord:
			visit((LocalNamespaceSpec) entity);
			break;
		case XsdEntityDescriptorEnum.DerivationAll_ord:
			visit((DerivationAll) entity);
			break;
		case XsdEntityDescriptorEnum.DerivationList_ord:
			visit((DerivationList) entity);
			break;
		case XsdEntityDescriptorEnum.DerivationControl_ord:
			visit((DerivationControl) entity);
			break;
		case XsdEntityDescriptorEnum.Use_ord:
			visit((Use) entity);
			break;
		case XsdEntityDescriptorEnum.WhiteSpaceProcessing_ord:
			visit((WhiteSpaceProcessing) entity);
			break;
		case XsdEntityDescriptorEnum.MixedText_ord:
			visit((MixedText) entity);
			break;
		case XsdEntityDescriptorEnum.XPathString_ord:
			visit((XPathString) entity);
			break;
		case XsdEntityDescriptorEnum.StringData_ord:
			visit((StringData) entity);
			break;
		case XsdEntityDescriptorEnum.IntegerData_ord:
			visit((IntegerData) entity);
			break;
		case XsdEntityDescriptorEnum.BooleanData_ord:
			visit((BooleanData) entity);
			break;
		case XsdEntityDescriptorEnum.Qualify_ord:
			visit((Qualify) entity);
			break;
		}
	}
}
