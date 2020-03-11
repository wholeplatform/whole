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
package org.whole.lang.swiftsyntax.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class SwiftSyntaxIdentitySwitchVisitor extends AbstractVisitor implements ISwiftSyntaxVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case SwiftSyntaxEntityDescriptorEnum.Token_ord :
            visit((Token) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownDecl_ord :
            visit((UnknownDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownExpr_ord :
            visit((UnknownExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownPattern_ord :
            visit((UnknownPattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownStmt_ord :
            visit((UnknownStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownType_ord :
            visit((UnknownType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItem_ord :
            visit((CodeBlockItem) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList_ord :
            visit((CodeBlockItemList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlock_ord :
            visit((CodeBlock) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.InOutExpr_ord :
            visit((InOutExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr_ord :
            visit((PoundColumnExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList_ord :
            visit((FunctionCallArgumentList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElementList_ord :
            visit((TupleElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElementList_ord :
            visit((ArrayElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElementList_ord :
            visit((DictionaryElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments_ord :
            visit((StringLiteralSegments) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TryExpr_ord :
            visit((TryExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgument_ord :
            visit((DeclNameArgument) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList_ord :
            visit((DeclNameArgumentList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArguments_ord :
            visit((DeclNameArguments) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierExpr_ord :
            visit((IdentifierExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SuperRefExpr_ord :
            visit((SuperRefExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr_ord :
            visit((NilLiteralExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            visit((DiscardAssignmentExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssignmentExpr_ord :
            visit((AssignmentExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SequenceExpr_ord :
            visit((SequenceExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExprList_ord :
            visit((ExprList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundLineExpr_ord :
            visit((PoundLineExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFileExpr_ord :
            visit((PoundFileExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr_ord :
            visit((PoundFunctionExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr_ord :
            visit((PoundDsohandleExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            visit((SymbolicReferenceExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr_ord :
            visit((PrefixOperatorExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr_ord :
            visit((BinaryOperatorExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrowExpr_ord :
            visit((ArrowExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr_ord :
            visit((FloatLiteralExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleExpr_ord :
            visit((TupleExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayExpr_ord :
            visit((ArrayExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryExpr_ord :
            visit((DictionaryExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument_ord :
            visit((FunctionCallArgument) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElement_ord :
            visit((TupleElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElement_ord :
            visit((ArrayElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElement_ord :
            visit((DictionaryElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr_ord :
            visit((IntegerLiteralExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr_ord :
            visit((BooleanLiteralExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TernaryExpr_ord :
            visit((TernaryExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr_ord :
            visit((MemberAccessExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsExpr_ord :
            visit((IsExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsExpr_ord :
            visit((AsExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeExpr_ord :
            visit((TypeExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem_ord :
            visit((ClosureCaptureItem) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList_ord :
            visit((ClosureCaptureItemList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature_ord :
            visit((ClosureCaptureSignature) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParam_ord :
            visit((ClosureParam) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParamList_ord :
            visit((ClosureParamList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureSignature_ord :
            visit((ClosureSignature) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureExpr_ord :
            visit((ClosureExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            visit((UnresolvedPatternExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr_ord :
            visit((FunctionCallExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptExpr_ord :
            visit((SubscriptExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr_ord :
            visit((OptionalChainingExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr_ord :
            visit((ForcedValueExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr_ord :
            visit((PostfixUnaryExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeExpr_ord :
            visit((SpecializeExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringSegment_ord :
            visit((StringSegment) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionSegment_ord :
            visit((ExpressionSegment) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr_ord :
            visit((StringLiteralExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathExpr_ord :
            visit((KeyPathExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr_ord :
            visit((KeyPathBaseExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece_ord :
            visit((ObjcNamePiece) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcName_ord :
            visit((ObjcName) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            visit((ObjcKeyPathExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr_ord :
            visit((ObjcSelectorExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            visit((EditorPlaceholderExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr_ord :
            visit((ObjectLiteralExpr) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause_ord :
            visit((TypeInitializerClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypealiasDecl_ord :
            visit((TypealiasDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl_ord :
            visit((AssociatedtypeDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameterList_ord :
            visit((FunctionParameterList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ParameterClause_ord :
            visit((ParameterClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnClause_ord :
            visit((ReturnClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionSignature_ord :
            visit((FunctionSignature) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClause_ord :
            visit((IfConfigClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList_ord :
            visit((IfConfigClauseList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigDecl_ord :
            visit((IfConfigDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl_ord :
            visit((PoundErrorDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl_ord :
            visit((PoundWarningDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation_ord :
            visit((PoundSourceLocation) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            visit((PoundSourceLocationArgs) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclModifier_ord :
            visit((DeclModifier) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedType_ord :
            visit((InheritedType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedTypeList_ord :
            visit((InheritedTypeList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause_ord :
            visit((TypeInheritanceClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassDecl_ord :
            visit((ClassDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.StructDecl_ord :
            visit((StructDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ProtocolDecl_ord :
            visit((ProtocolDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExtensionDecl_ord :
            visit((ExtensionDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock_ord :
            visit((MemberDeclBlock) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclList_ord :
            visit((MemberDeclList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem_ord :
            visit((MemberDeclListItem) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SourceFile_ord :
            visit((SourceFile) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerClause_ord :
            visit((InitializerClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameter_ord :
            visit((FunctionParameter) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ModifierList_ord :
            visit((ModifierList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionDecl_ord :
            visit((FunctionDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerDecl_ord :
            visit((InitializerDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl_ord :
            visit((DeinitializerDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptDecl_ord :
            visit((SubscriptDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier_ord :
            visit((AccessLevelModifier) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPathComponent_ord :
            visit((AccessPathComponent) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPath_ord :
            visit((AccessPath) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImportDecl_ord :
            visit((ImportDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorParameter_ord :
            visit((AccessorParameter) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorDecl_ord :
            visit((AccessorDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorList_ord :
            visit((AccessorList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorBlock_ord :
            visit((AccessorBlock) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBinding_ord :
            visit((PatternBinding) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBindingList_ord :
            visit((PatternBindingList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.VariableDecl_ord :
            visit((VariableDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElement_ord :
            visit((EnumCaseElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList_ord :
            visit((EnumCaseElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl_ord :
            visit((EnumCaseDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumDecl_ord :
            visit((EnumDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorDecl_ord :
            visit((OperatorDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierList_ord :
            visit((IdentifierList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes_ord :
            visit((OperatorPrecedenceAndTypes) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            visit((PrecedenceGroupDecl) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            visit((PrecedenceGroupAttributeList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            visit((PrecedenceGroupRelation) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            visit((PrecedenceGroupNameList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement_ord :
            visit((PrecedenceGroupNameElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            visit((PrecedenceGroupAssignment) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            visit((PrecedenceGroupAssociativity) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TokenList_ord :
            visit((TokenList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CustomAttribute_ord :
            visit((CustomAttribute) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.Attribute_ord :
            visit((Attribute) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributeList_ord :
            visit((AttributeList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            visit((SpecializeAttributeSpecList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            visit((LabeledSpecializeEntry) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            visit((NamedAttributeStringArgument) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclName_ord :
            visit((DeclName) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            visit((ImplementsAttributeArguments) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece_ord :
            visit((ObjCSelectorPiece) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelector_ord :
            visit((ObjCSelector) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ContinueStmt_ord :
            visit((ContinueStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhileStmt_ord :
            visit((WhileStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeferStmt_ord :
            visit((DeferStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseList_ord :
            visit((SwitchCaseList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt_ord :
            visit((RepeatWhileStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GuardStmt_ord :
            visit((GuardStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhereClause_ord :
            visit((WhereClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForInStmt_ord :
            visit((ForInStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchStmt_ord :
            visit((SwitchStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClauseList_ord :
            visit((CatchClauseList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DoStmt_ord :
            visit((DoStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnStmt_ord :
            visit((ReturnStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldStmt_ord :
            visit((YieldStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldList_ord :
            visit((YieldList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FallthroughStmt_ord :
            visit((FallthroughStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.BreakStmt_ord :
            visit((BreakStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItemList_ord :
            visit((CaseItemList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElement_ord :
            visit((ConditionElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition_ord :
            visit((AvailabilityCondition) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition_ord :
            visit((MatchingPatternCondition) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition_ord :
            visit((OptionalBindingCondition) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElementList_ord :
            visit((ConditionElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ThrowStmt_ord :
            visit((ThrowStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfStmt_ord :
            visit((IfStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCase_ord :
            visit((SwitchCase) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel_ord :
            visit((SwitchDefaultLabel) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItem_ord :
            visit((CaseItem) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel_ord :
            visit((SwitchCaseLabel) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClause_ord :
            visit((CatchClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt_ord :
            visit((PoundAssertStmt) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericWhereClause_ord :
            visit((GenericWhereClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericRequirementList_ord :
            visit((GenericRequirementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement_ord :
            visit((SameTypeRequirement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterList_ord :
            visit((GenericParameterList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameter_ord :
            visit((GenericParameter) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterClause_ord :
            visit((GenericParameterClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement_ord :
            visit((ConformanceRequirement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            visit((SimpleTypeIdentifier) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier_ord :
            visit((MemberTypeIdentifier) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType_ord :
            visit((ClassRestrictionType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayType_ord :
            visit((ArrayType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryType_ord :
            visit((DictionaryType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MetatypeType_ord :
            visit((MetatypeType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalType_ord :
            visit((OptionalType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SomeType_ord :
            visit((SomeType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            visit((ImplicitlyUnwrappedOptionalType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement_ord :
            visit((CompositionTypeElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList_ord :
            visit((CompositionTypeElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionType_ord :
            visit((CompositionType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElement_ord :
            visit((TupleTypeElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList_ord :
            visit((TupleTypeElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleType_ord :
            visit((TupleType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionType_ord :
            visit((FunctionType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributedType_ord :
            visit((AttributedType) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentList_ord :
            visit((GenericArgumentList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgument_ord :
            visit((GenericArgument) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause_ord :
            visit((GenericArgumentClause) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeAnnotation_ord :
            visit((TypeAnnotation) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCasePattern_ord :
            visit((EnumCasePattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsTypePattern_ord :
            visit((IsTypePattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalPattern_ord :
            visit((OptionalPattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierPattern_ord :
            visit((IdentifierPattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsTypePattern_ord :
            visit((AsTypePattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePattern_ord :
            visit((TuplePattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.WildcardPattern_ord :
            visit((WildcardPattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElement_ord :
            visit((TuplePatternElement) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionPattern_ord :
            visit((ExpressionPattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList_ord :
            visit((TuplePatternElementList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern_ord :
            visit((ValueBindingPattern) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList_ord :
            visit((AvailabilitySpecList) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument_ord :
            visit((AvailabilityArgument) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            visit((AvailabilityLabeledArgument) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            visit((AvailabilityVersionRestriction) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.VersionTuple_ord :
            visit((VersionTuple) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TokenKind_ord :
            visit((TokenKind) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.Text_ord :
            visit((Text) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.Trivia_ord :
            visit((Trivia) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TriviaPiece_ord :
            visit((TriviaPiece) entity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SourcePresence_ord :
            visit((SourcePresence) entity);
            break;
        }
    }
}
