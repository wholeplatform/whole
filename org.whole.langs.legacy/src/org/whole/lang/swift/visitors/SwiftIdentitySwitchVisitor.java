/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.swift.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class SwiftIdentitySwitchVisitor extends AbstractVisitor implements ISwiftVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case SwiftEntityDescriptorEnum.BooleanLiteral_ord :
            visit((BooleanLiteral) entity);
            break;
            case SwiftEntityDescriptorEnum.IntegerLiteral_ord :
            visit((IntegerLiteral) entity);
            break;
            case SwiftEntityDescriptorEnum.FloatingLiteral_ord :
            visit((FloatingLiteral) entity);
            break;
            case SwiftEntityDescriptorEnum.StringLiteral_ord :
            visit((StringLiteral) entity);
            break;
            case SwiftEntityDescriptorEnum.Identifier_ord :
            visit((Identifier) entity);
            break;
            case SwiftEntityDescriptorEnum.BinaryOperator_ord :
            visit((BinaryOperator) entity);
            break;
            case SwiftEntityDescriptorEnum.PostfixOperator_ord :
            visit((PostfixOperator) entity);
            break;
            case SwiftEntityDescriptorEnum.PrefixOperator_ord :
            visit((PrefixOperator) entity);
            break;
            case SwiftEntityDescriptorEnum.DollarIdentifier_ord :
            visit((DollarIdentifier) entity);
            break;
            case SwiftEntityDescriptorEnum.RawStringDelimiter_ord :
            visit((RawStringDelimiter) entity);
            break;
            case SwiftEntityDescriptorEnum.CodeBlockItemList_ord :
            visit((CodeBlockItemList) entity);
            break;
            case SwiftEntityDescriptorEnum.InOutExpr_ord :
            visit((InOutExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundColumnExpr_ord :
            visit((PoundColumnExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgumentList_ord :
            visit((FunctionCallArgumentList) entity);
            break;
            case SwiftEntityDescriptorEnum.StringLiteralSegments_ord :
            visit((StringLiteralSegments) entity);
            break;
            case SwiftEntityDescriptorEnum.ExpressionSegment_ord :
            visit((ExpressionSegment) entity);
            break;
            case SwiftEntityDescriptorEnum.TryExpr_ord :
            visit((TryExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum_ord :
            visit((QuestionOrExclamationMarkEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.DeclNameArgumentList_ord :
            visit((DeclNameArgumentList) entity);
            break;
            case SwiftEntityDescriptorEnum.IdentifierExpr_ord :
            visit((IdentifierExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.IdentifierEnum_ord :
            visit((IdentifierEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.SuperRefExpr_ord :
            visit((SuperRefExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.NilLiteralExpr_ord :
            visit((NilLiteralExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            visit((DiscardAssignmentExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.AssignmentExpr_ord :
            visit((AssignmentExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.SequenceExpr_ord :
            visit((SequenceExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundLineExpr_ord :
            visit((PoundLineExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundFileExpr_ord :
            visit((PoundFileExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundFunctionExpr_ord :
            visit((PoundFunctionExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundDsohandleExpr_ord :
            visit((PoundDsohandleExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            visit((SymbolicReferenceExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PrefixOperatorExpr_ord :
            visit((PrefixOperatorExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.BinaryOperatorExpr_ord :
            visit((BinaryOperatorExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.ArrowExpr_ord :
            visit((ArrowExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.Throws_ord :
            visit((Throws) entity);
            break;
            case SwiftEntityDescriptorEnum.TupleExpr_ord :
            visit((TupleExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.ArrayExpr_ord :
            visit((ArrayExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.DictionaryExpr_ord :
            visit((DictionaryExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgument_ord :
            visit((FunctionCallArgument) entity);
            break;
            case SwiftEntityDescriptorEnum.TupleElement_ord :
            visit((TupleElement) entity);
            break;
            case SwiftEntityDescriptorEnum.DictionaryElement_ord :
            visit((DictionaryElement) entity);
            break;
            case SwiftEntityDescriptorEnum.TernaryExpr_ord :
            visit((TernaryExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.MemberAccessExpr_ord :
            visit((MemberAccessExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.DotEnum_ord :
            visit((DotEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.IsExpr_ord :
            visit((IsExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.AsExpr_ord :
            visit((AsExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.TypeExpr_ord :
            visit((TypeExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItem_ord :
            visit((ClosureCaptureItem) entity);
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItemList_ord :
            visit((ClosureCaptureItemList) entity);
            break;
            case SwiftEntityDescriptorEnum.WildcardMarker_ord :
            visit((WildcardMarker) entity);
            break;
            case SwiftEntityDescriptorEnum.ClosureParamList_ord :
            visit((ClosureParamList) entity);
            break;
            case SwiftEntityDescriptorEnum.ClosureSignature_ord :
            visit((ClosureSignature) entity);
            break;
            case SwiftEntityDescriptorEnum.ClosureExpr_ord :
            visit((ClosureExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            visit((UnresolvedPatternExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionCallExpr_ord :
            visit((FunctionCallExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.SubscriptExpr_ord :
            visit((SubscriptExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.OptionalChainingExpr_ord :
            visit((OptionalChainingExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.ForcedValueExpr_ord :
            visit((ForcedValueExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PostfixUnaryExpr_ord :
            visit((PostfixUnaryExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.SpecializeExpr_ord :
            visit((SpecializeExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.StringLiteralExpr_ord :
            visit((StringLiteralExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.OpenQuoteEnum_ord :
            visit((OpenQuoteEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.KeyPathExpr_ord :
            visit((KeyPathExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.KeyPathBaseExpr_ord :
            visit((KeyPathBaseExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            visit((ObjcKeyPathExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.ObjcSelectorExpr_ord :
            visit((ObjcSelectorExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.KindValue_ord :
            visit((KindValue) entity);
            break;
            case SwiftEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            visit((EditorPlaceholderExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.ObjectLiteralExpr_ord :
            visit((ObjectLiteralExpr) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundIdentifierEnum_ord :
            visit((PoundIdentifierEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.TypealiasDecl_ord :
            visit((TypealiasDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.AssociatedtypeDecl_ord :
            visit((AssociatedtypeDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionParameterList_ord :
            visit((FunctionParameterList) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionSignature_ord :
            visit((FunctionSignature) entity);
            break;
            case SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum_ord :
            visit((ThrowsOrRethrowsKeywordEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.IfConfigClause_ord :
            visit((IfConfigClause) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundKeywordEnum_ord :
            visit((PoundKeywordEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseList_ord :
            visit((SwitchCaseList) entity);
            break;
            case SwiftEntityDescriptorEnum.MemberDeclList_ord :
            visit((MemberDeclList) entity);
            break;
            case SwiftEntityDescriptorEnum.IfConfigDecl_ord :
            visit((IfConfigDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundErrorDecl_ord :
            visit((PoundErrorDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundWarningDecl_ord :
            visit((PoundWarningDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocation_ord :
            visit((PoundSourceLocation) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            visit((PoundSourceLocationArgs) entity);
            break;
            case SwiftEntityDescriptorEnum.DeclModifier_ord :
            visit((DeclModifier) entity);
            break;
            case SwiftEntityDescriptorEnum.NameValue_ord :
            visit((NameValue) entity);
            break;
            case SwiftEntityDescriptorEnum.InheritedTypeList_ord :
            visit((InheritedTypeList) entity);
            break;
            case SwiftEntityDescriptorEnum.ClassDecl_ord :
            visit((ClassDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.StructDecl_ord :
            visit((StructDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.ProtocolDecl_ord :
            visit((ProtocolDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.ExtensionDecl_ord :
            visit((ExtensionDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.SourceFile_ord :
            visit((SourceFile) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionParameter_ord :
            visit((FunctionParameter) entity);
            break;
            case SwiftEntityDescriptorEnum.Ellipsis_ord :
            visit((Ellipsis) entity);
            break;
            case SwiftEntityDescriptorEnum.ModifierList_ord :
            visit((ModifierList) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionDecl_ord :
            visit((FunctionDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.InitializerDecl_ord :
            visit((InitializerDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.OptionalMarkEnum_ord :
            visit((OptionalMarkEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.DeinitializerDecl_ord :
            visit((DeinitializerDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.SubscriptDecl_ord :
            visit((SubscriptDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.AccessorBlock_ord :
            visit((AccessorBlock) entity);
            break;
            case SwiftEntityDescriptorEnum.AccessLevelModifier_ord :
            visit((AccessLevelModifier) entity);
            break;
            case SwiftEntityDescriptorEnum.AccessPath_ord :
            visit((AccessPath) entity);
            break;
            case SwiftEntityDescriptorEnum.ImportDecl_ord :
            visit((ImportDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.ImportKindEnum_ord :
            visit((ImportKindEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.AccessorDecl_ord :
            visit((AccessorDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.AccessorKindValue_ord :
            visit((AccessorKindValue) entity);
            break;
            case SwiftEntityDescriptorEnum.PatternBinding_ord :
            visit((PatternBinding) entity);
            break;
            case SwiftEntityDescriptorEnum.PatternBindingList_ord :
            visit((PatternBindingList) entity);
            break;
            case SwiftEntityDescriptorEnum.VariableDecl_ord :
            visit((VariableDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.LetOrVarKeywordEnum_ord :
            visit((LetOrVarKeywordEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElement_ord :
            visit((EnumCaseElement) entity);
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElementList_ord :
            visit((EnumCaseElementList) entity);
            break;
            case SwiftEntityDescriptorEnum.EnumCaseDecl_ord :
            visit((EnumCaseDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.EnumDecl_ord :
            visit((EnumDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.OperatorDecl_ord :
            visit((OperatorDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.IdentifierList_ord :
            visit((IdentifierList) entity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            visit((PrecedenceGroupDecl) entity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            visit((PrecedenceGroupAttributeList) entity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            visit((PrecedenceGroupRelation) entity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            visit((PrecedenceGroupAssignment) entity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            visit((PrecedenceGroupAssociativity) entity);
            break;
            case SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue_ord :
            visit((HigherThanOrLowerThanValue) entity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            visit((PrecedenceGroupNameList) entity);
            break;
            case SwiftEntityDescriptorEnum.FlagEnum_ord :
            visit((FlagEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.ValueValue_ord :
            visit((ValueValue) entity);
            break;
            case SwiftEntityDescriptorEnum.CustomAttribute_ord :
            visit((CustomAttribute) entity);
            break;
            case SwiftEntityDescriptorEnum.Attribute_ord :
            visit((Attribute) entity);
            break;
            case SwiftEntityDescriptorEnum.AvailabilitySpecList_ord :
            visit((AvailabilitySpecList) entity);
            break;
            case SwiftEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            visit((SpecializeAttributeSpecList) entity);
            break;
            case SwiftEntityDescriptorEnum.ObjCSelector_ord :
            visit((ObjCSelector) entity);
            break;
            case SwiftEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            visit((ImplementsAttributeArguments) entity);
            break;
            case SwiftEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            visit((NamedAttributeStringArgument) entity);
            break;
            case SwiftEntityDescriptorEnum.AttributeList_ord :
            visit((AttributeList) entity);
            break;
            case SwiftEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            visit((LabeledSpecializeEntry) entity);
            break;
            case SwiftEntityDescriptorEnum.DeclName_ord :
            visit((DeclName) entity);
            break;
            case SwiftEntityDescriptorEnum.ContinueStmt_ord :
            visit((ContinueStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.WhileStmt_ord :
            visit((WhileStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.DeferStmt_ord :
            visit((DeferStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.SwitchCase_ord :
            visit((SwitchCase) entity);
            break;
            case SwiftEntityDescriptorEnum.RepeatWhileStmt_ord :
            visit((RepeatWhileStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.GuardStmt_ord :
            visit((GuardStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.ForInStmt_ord :
            visit((ForInStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.Case_ord :
            visit((Case) entity);
            break;
            case SwiftEntityDescriptorEnum.SwitchStmt_ord :
            visit((SwitchStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.CatchClauseList_ord :
            visit((CatchClauseList) entity);
            break;
            case SwiftEntityDescriptorEnum.DoStmt_ord :
            visit((DoStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.ReturnStmt_ord :
            visit((ReturnStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.YieldStmt_ord :
            visit((YieldStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.YieldList_ord :
            visit((YieldList) entity);
            break;
            case SwiftEntityDescriptorEnum.FallthroughStmt_ord :
            visit((FallthroughStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.BreakStmt_ord :
            visit((BreakStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.AvailabilityCondition_ord :
            visit((AvailabilityCondition) entity);
            break;
            case SwiftEntityDescriptorEnum.MatchingPatternCondition_ord :
            visit((MatchingPatternCondition) entity);
            break;
            case SwiftEntityDescriptorEnum.OptionalBindingCondition_ord :
            visit((OptionalBindingCondition) entity);
            break;
            case SwiftEntityDescriptorEnum.ConditionElementList_ord :
            visit((ConditionElementList) entity);
            break;
            case SwiftEntityDescriptorEnum.ThrowStmt_ord :
            visit((ThrowStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.IfStmt_ord :
            visit((IfStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.SwitchDefaultLabel_ord :
            visit((SwitchDefaultLabel) entity);
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseLabel_ord :
            visit((SwitchCaseLabel) entity);
            break;
            case SwiftEntityDescriptorEnum.CaseItem_ord :
            visit((CaseItem) entity);
            break;
            case SwiftEntityDescriptorEnum.CatchClause_ord :
            visit((CatchClause) entity);
            break;
            case SwiftEntityDescriptorEnum.PoundAssertStmt_ord :
            visit((PoundAssertStmt) entity);
            break;
            case SwiftEntityDescriptorEnum.GenericRequirementList_ord :
            visit((GenericRequirementList) entity);
            break;
            case SwiftEntityDescriptorEnum.SameTypeRequirement_ord :
            visit((SameTypeRequirement) entity);
            break;
            case SwiftEntityDescriptorEnum.ConformanceRequirement_ord :
            visit((ConformanceRequirement) entity);
            break;
            case SwiftEntityDescriptorEnum.GenericParameterList_ord :
            visit((GenericParameterList) entity);
            break;
            case SwiftEntityDescriptorEnum.GenericParameter_ord :
            visit((GenericParameter) entity);
            break;
            case SwiftEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            visit((SimpleTypeIdentifier) entity);
            break;
            case SwiftEntityDescriptorEnum.NameEnum_ord :
            visit((NameEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.MemberTypeIdentifier_ord :
            visit((MemberTypeIdentifier) entity);
            break;
            case SwiftEntityDescriptorEnum.PeriodEnum_ord :
            visit((PeriodEnum) entity);
            break;
            case SwiftEntityDescriptorEnum.ClassRestrictionType_ord :
            visit((ClassRestrictionType) entity);
            break;
            case SwiftEntityDescriptorEnum.ArrayType_ord :
            visit((ArrayType) entity);
            break;
            case SwiftEntityDescriptorEnum.DictionaryType_ord :
            visit((DictionaryType) entity);
            break;
            case SwiftEntityDescriptorEnum.MetatypeType_ord :
            visit((MetatypeType) entity);
            break;
            case SwiftEntityDescriptorEnum.TypeOrProtocolValue_ord :
            visit((TypeOrProtocolValue) entity);
            break;
            case SwiftEntityDescriptorEnum.OptionalType_ord :
            visit((OptionalType) entity);
            break;
            case SwiftEntityDescriptorEnum.SomeType_ord :
            visit((SomeType) entity);
            break;
            case SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            visit((ImplicitlyUnwrappedOptionalType) entity);
            break;
            case SwiftEntityDescriptorEnum.CompositionTypeElement_ord :
            visit((CompositionTypeElement) entity);
            break;
            case SwiftEntityDescriptorEnum.Ampersand_ord :
            visit((Ampersand) entity);
            break;
            case SwiftEntityDescriptorEnum.CompositionType_ord :
            visit((CompositionType) entity);
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElement_ord :
            visit((TupleTypeElement) entity);
            break;
            case SwiftEntityDescriptorEnum.Inout_ord :
            visit((Inout) entity);
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElementList_ord :
            visit((TupleTypeElementList) entity);
            break;
            case SwiftEntityDescriptorEnum.TupleType_ord :
            visit((TupleType) entity);
            break;
            case SwiftEntityDescriptorEnum.FunctionType_ord :
            visit((FunctionType) entity);
            break;
            case SwiftEntityDescriptorEnum.AttributedType_ord :
            visit((AttributedType) entity);
            break;
            case SwiftEntityDescriptorEnum.SpecifierValue_ord :
            visit((SpecifierValue) entity);
            break;
            case SwiftEntityDescriptorEnum.GenericArgumentList_ord :
            visit((GenericArgumentList) entity);
            break;
            case SwiftEntityDescriptorEnum.EnumCasePattern_ord :
            visit((EnumCasePattern) entity);
            break;
            case SwiftEntityDescriptorEnum.IsTypePattern_ord :
            visit((IsTypePattern) entity);
            break;
            case SwiftEntityDescriptorEnum.OptionalPattern_ord :
            visit((OptionalPattern) entity);
            break;
            case SwiftEntityDescriptorEnum.IdentifierPattern_ord :
            visit((IdentifierPattern) entity);
            break;
            case SwiftEntityDescriptorEnum.SelfMarker_ord :
            visit((SelfMarker) entity);
            break;
            case SwiftEntityDescriptorEnum.AsTypePattern_ord :
            visit((AsTypePattern) entity);
            break;
            case SwiftEntityDescriptorEnum.WildcardPattern_ord :
            visit((WildcardPattern) entity);
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElement_ord :
            visit((TuplePatternElement) entity);
            break;
            case SwiftEntityDescriptorEnum.ExpressionPattern_ord :
            visit((ExpressionPattern) entity);
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElementList_ord :
            visit((TuplePatternElementList) entity);
            break;
            case SwiftEntityDescriptorEnum.ValueBindingPattern_ord :
            visit((ValueBindingPattern) entity);
            break;
            case SwiftEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            visit((AvailabilityVersionRestriction) entity);
            break;
            case SwiftEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            visit((AvailabilityLabeledArgument) entity);
            break;
            case SwiftEntityDescriptorEnum.VersionTuple_ord :
            visit((VersionTuple) entity);
            break;
            case SwiftEntityDescriptorEnum.CaptureSpecifierEnum_ord :
            visit((CaptureSpecifierEnum) entity);
            break;
        }
    }
}
