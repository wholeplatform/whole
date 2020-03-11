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
package org.whole.lang.swift.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.swift.model.QuestionOrExclamationMarkEnumEnum.Value;

/**
 *  @generator Whole
 */
public class SwiftGenericBuilderAdapter extends GenericIdentityBuilder {
    private ISwiftBuilder specificBuilder;

    public SwiftGenericBuilderAdapter(ISwiftBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public SwiftGenericBuilderAdapter(ISwiftBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.BooleanLiteral_ord :
            specificBuilder.BooleanLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.IntegerLiteral_ord :
            specificBuilder.IntegerLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.FloatingLiteral_ord :
            specificBuilder.FloatingLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.StringLiteral_ord :
            specificBuilder.StringLiteral(value);
            break;
            case SwiftEntityDescriptorEnum.Identifier_ord :
            specificBuilder.Identifier(value);
            break;
            case SwiftEntityDescriptorEnum.BinaryOperator_ord :
            specificBuilder.BinaryOperator(value);
            break;
            case SwiftEntityDescriptorEnum.PostfixOperator_ord :
            specificBuilder.PostfixOperator(value);
            break;
            case SwiftEntityDescriptorEnum.PrefixOperator_ord :
            specificBuilder.PrefixOperator(value);
            break;
            case SwiftEntityDescriptorEnum.DollarIdentifier_ord :
            specificBuilder.DollarIdentifier(value);
            break;
            case SwiftEntityDescriptorEnum.RawStringDelimiter_ord :
            specificBuilder.RawStringDelimiter(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder.CodeBlockItemList();
            break;
            case SwiftEntityDescriptorEnum.InOutExpr_ord :
            specificBuilder.InOutExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundColumnExpr_ord :
            specificBuilder.PoundColumnExpr();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder.FunctionCallArgumentList();
            break;
            case SwiftEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder.StringLiteralSegments();
            break;
            case SwiftEntityDescriptorEnum.ExpressionSegment_ord :
            specificBuilder.ExpressionSegment();
            break;
            case SwiftEntityDescriptorEnum.TryExpr_ord :
            specificBuilder.TryExpr();
            break;
            case SwiftEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder.DeclNameArgumentList();
            break;
            case SwiftEntityDescriptorEnum.IdentifierExpr_ord :
            specificBuilder.IdentifierExpr();
            break;
            case SwiftEntityDescriptorEnum.SuperRefExpr_ord :
            specificBuilder.SuperRefExpr();
            break;
            case SwiftEntityDescriptorEnum.NilLiteralExpr_ord :
            specificBuilder.NilLiteralExpr();
            break;
            case SwiftEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            specificBuilder.DiscardAssignmentExpr();
            break;
            case SwiftEntityDescriptorEnum.AssignmentExpr_ord :
            specificBuilder.AssignmentExpr();
            break;
            case SwiftEntityDescriptorEnum.SequenceExpr_ord :
            specificBuilder.SequenceExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundLineExpr_ord :
            specificBuilder.PoundLineExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundFileExpr_ord :
            specificBuilder.PoundFileExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundFunctionExpr_ord :
            specificBuilder.PoundFunctionExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundDsohandleExpr_ord :
            specificBuilder.PoundDsohandleExpr();
            break;
            case SwiftEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            specificBuilder.SymbolicReferenceExpr();
            break;
            case SwiftEntityDescriptorEnum.PrefixOperatorExpr_ord :
            specificBuilder.PrefixOperatorExpr();
            break;
            case SwiftEntityDescriptorEnum.BinaryOperatorExpr_ord :
            specificBuilder.BinaryOperatorExpr();
            break;
            case SwiftEntityDescriptorEnum.ArrowExpr_ord :
            specificBuilder.ArrowExpr();
            break;
            case SwiftEntityDescriptorEnum.Throws_ord :
            specificBuilder.Throws();
            break;
            case SwiftEntityDescriptorEnum.TupleExpr_ord :
            specificBuilder.TupleExpr();
            break;
            case SwiftEntityDescriptorEnum.ArrayExpr_ord :
            specificBuilder.ArrayExpr();
            break;
            case SwiftEntityDescriptorEnum.DictionaryExpr_ord :
            specificBuilder.DictionaryExpr();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgument_ord :
            specificBuilder.FunctionCallArgument();
            break;
            case SwiftEntityDescriptorEnum.TupleElement_ord :
            specificBuilder.TupleElement();
            break;
            case SwiftEntityDescriptorEnum.DictionaryElement_ord :
            specificBuilder.DictionaryElement();
            break;
            case SwiftEntityDescriptorEnum.TernaryExpr_ord :
            specificBuilder.TernaryExpr();
            break;
            case SwiftEntityDescriptorEnum.MemberAccessExpr_ord :
            specificBuilder.MemberAccessExpr();
            break;
            case SwiftEntityDescriptorEnum.IsExpr_ord :
            specificBuilder.IsExpr();
            break;
            case SwiftEntityDescriptorEnum.AsExpr_ord :
            specificBuilder.AsExpr();
            break;
            case SwiftEntityDescriptorEnum.TypeExpr_ord :
            specificBuilder.TypeExpr();
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItem_ord :
            specificBuilder.ClosureCaptureItem();
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder.ClosureCaptureItemList();
            break;
            case SwiftEntityDescriptorEnum.WildcardMarker_ord :
            specificBuilder.WildcardMarker();
            break;
            case SwiftEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder.ClosureParamList();
            break;
            case SwiftEntityDescriptorEnum.ClosureSignature_ord :
            specificBuilder.ClosureSignature();
            break;
            case SwiftEntityDescriptorEnum.ClosureExpr_ord :
            specificBuilder.ClosureExpr();
            break;
            case SwiftEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            specificBuilder.UnresolvedPatternExpr();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallExpr_ord :
            specificBuilder.FunctionCallExpr();
            break;
            case SwiftEntityDescriptorEnum.SubscriptExpr_ord :
            specificBuilder.SubscriptExpr();
            break;
            case SwiftEntityDescriptorEnum.OptionalChainingExpr_ord :
            specificBuilder.OptionalChainingExpr();
            break;
            case SwiftEntityDescriptorEnum.ForcedValueExpr_ord :
            specificBuilder.ForcedValueExpr();
            break;
            case SwiftEntityDescriptorEnum.PostfixUnaryExpr_ord :
            specificBuilder.PostfixUnaryExpr();
            break;
            case SwiftEntityDescriptorEnum.SpecializeExpr_ord :
            specificBuilder.SpecializeExpr();
            break;
            case SwiftEntityDescriptorEnum.StringLiteralExpr_ord :
            specificBuilder.StringLiteralExpr();
            break;
            case SwiftEntityDescriptorEnum.KeyPathExpr_ord :
            specificBuilder.KeyPathExpr();
            break;
            case SwiftEntityDescriptorEnum.KeyPathBaseExpr_ord :
            specificBuilder.KeyPathBaseExpr();
            break;
            case SwiftEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            specificBuilder.ObjcKeyPathExpr();
            break;
            case SwiftEntityDescriptorEnum.ObjcSelectorExpr_ord :
            specificBuilder.ObjcSelectorExpr();
            break;
            case SwiftEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            specificBuilder.EditorPlaceholderExpr();
            break;
            case SwiftEntityDescriptorEnum.ObjectLiteralExpr_ord :
            specificBuilder.ObjectLiteralExpr();
            break;
            case SwiftEntityDescriptorEnum.TypealiasDecl_ord :
            specificBuilder.TypealiasDecl();
            break;
            case SwiftEntityDescriptorEnum.AssociatedtypeDecl_ord :
            specificBuilder.AssociatedtypeDecl();
            break;
            case SwiftEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder.FunctionParameterList();
            break;
            case SwiftEntityDescriptorEnum.FunctionSignature_ord :
            specificBuilder.FunctionSignature();
            break;
            case SwiftEntityDescriptorEnum.IfConfigClause_ord :
            specificBuilder.IfConfigClause();
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder.SwitchCaseList();
            break;
            case SwiftEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder.MemberDeclList();
            break;
            case SwiftEntityDescriptorEnum.IfConfigDecl_ord :
            specificBuilder.IfConfigDecl();
            break;
            case SwiftEntityDescriptorEnum.PoundErrorDecl_ord :
            specificBuilder.PoundErrorDecl();
            break;
            case SwiftEntityDescriptorEnum.PoundWarningDecl_ord :
            specificBuilder.PoundWarningDecl();
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocation_ord :
            specificBuilder.PoundSourceLocation();
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            specificBuilder.PoundSourceLocationArgs();
            break;
            case SwiftEntityDescriptorEnum.DeclModifier_ord :
            specificBuilder.DeclModifier();
            break;
            case SwiftEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder.InheritedTypeList();
            break;
            case SwiftEntityDescriptorEnum.ClassDecl_ord :
            specificBuilder.ClassDecl();
            break;
            case SwiftEntityDescriptorEnum.StructDecl_ord :
            specificBuilder.StructDecl();
            break;
            case SwiftEntityDescriptorEnum.ProtocolDecl_ord :
            specificBuilder.ProtocolDecl();
            break;
            case SwiftEntityDescriptorEnum.ExtensionDecl_ord :
            specificBuilder.ExtensionDecl();
            break;
            case SwiftEntityDescriptorEnum.SourceFile_ord :
            specificBuilder.SourceFile();
            break;
            case SwiftEntityDescriptorEnum.FunctionParameter_ord :
            specificBuilder.FunctionParameter();
            break;
            case SwiftEntityDescriptorEnum.Ellipsis_ord :
            specificBuilder.Ellipsis();
            break;
            case SwiftEntityDescriptorEnum.ModifierList_ord :
            specificBuilder.ModifierList();
            break;
            case SwiftEntityDescriptorEnum.FunctionDecl_ord :
            specificBuilder.FunctionDecl();
            break;
            case SwiftEntityDescriptorEnum.InitializerDecl_ord :
            specificBuilder.InitializerDecl();
            break;
            case SwiftEntityDescriptorEnum.DeinitializerDecl_ord :
            specificBuilder.DeinitializerDecl();
            break;
            case SwiftEntityDescriptorEnum.SubscriptDecl_ord :
            specificBuilder.SubscriptDecl();
            break;
            case SwiftEntityDescriptorEnum.AccessorBlock_ord :
            specificBuilder.AccessorBlock();
            break;
            case SwiftEntityDescriptorEnum.AccessLevelModifier_ord :
            specificBuilder.AccessLevelModifier();
            break;
            case SwiftEntityDescriptorEnum.AccessPath_ord :
            specificBuilder.AccessPath();
            break;
            case SwiftEntityDescriptorEnum.ImportDecl_ord :
            specificBuilder.ImportDecl();
            break;
            case SwiftEntityDescriptorEnum.AccessorDecl_ord :
            specificBuilder.AccessorDecl();
            break;
            case SwiftEntityDescriptorEnum.PatternBinding_ord :
            specificBuilder.PatternBinding();
            break;
            case SwiftEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder.PatternBindingList();
            break;
            case SwiftEntityDescriptorEnum.VariableDecl_ord :
            specificBuilder.VariableDecl();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElement_ord :
            specificBuilder.EnumCaseElement();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder.EnumCaseElementList();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseDecl_ord :
            specificBuilder.EnumCaseDecl();
            break;
            case SwiftEntityDescriptorEnum.EnumDecl_ord :
            specificBuilder.EnumDecl();
            break;
            case SwiftEntityDescriptorEnum.OperatorDecl_ord :
            specificBuilder.OperatorDecl();
            break;
            case SwiftEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder.IdentifierList();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            specificBuilder.PrecedenceGroupDecl();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder.PrecedenceGroupAttributeList();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            specificBuilder.PrecedenceGroupRelation();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            specificBuilder.PrecedenceGroupAssignment();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            specificBuilder.PrecedenceGroupAssociativity();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder.PrecedenceGroupNameList();
            break;
            case SwiftEntityDescriptorEnum.CustomAttribute_ord :
            specificBuilder.CustomAttribute();
            break;
            case SwiftEntityDescriptorEnum.Attribute_ord :
            specificBuilder.Attribute();
            break;
            case SwiftEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder.AvailabilitySpecList();
            break;
            case SwiftEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder.SpecializeAttributeSpecList();
            break;
            case SwiftEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder.ObjCSelector();
            break;
            case SwiftEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            specificBuilder.ImplementsAttributeArguments();
            break;
            case SwiftEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            specificBuilder.NamedAttributeStringArgument();
            break;
            case SwiftEntityDescriptorEnum.AttributeList_ord :
            specificBuilder.AttributeList();
            break;
            case SwiftEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            specificBuilder.LabeledSpecializeEntry();
            break;
            case SwiftEntityDescriptorEnum.DeclName_ord :
            specificBuilder.DeclName();
            break;
            case SwiftEntityDescriptorEnum.ContinueStmt_ord :
            specificBuilder.ContinueStmt();
            break;
            case SwiftEntityDescriptorEnum.WhileStmt_ord :
            specificBuilder.WhileStmt();
            break;
            case SwiftEntityDescriptorEnum.DeferStmt_ord :
            specificBuilder.DeferStmt();
            break;
            case SwiftEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder.SwitchCase();
            break;
            case SwiftEntityDescriptorEnum.RepeatWhileStmt_ord :
            specificBuilder.RepeatWhileStmt();
            break;
            case SwiftEntityDescriptorEnum.GuardStmt_ord :
            specificBuilder.GuardStmt();
            break;
            case SwiftEntityDescriptorEnum.ForInStmt_ord :
            specificBuilder.ForInStmt();
            break;
            case SwiftEntityDescriptorEnum.Case_ord :
            specificBuilder.Case();
            break;
            case SwiftEntityDescriptorEnum.SwitchStmt_ord :
            specificBuilder.SwitchStmt();
            break;
            case SwiftEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder.CatchClauseList();
            break;
            case SwiftEntityDescriptorEnum.DoStmt_ord :
            specificBuilder.DoStmt();
            break;
            case SwiftEntityDescriptorEnum.ReturnStmt_ord :
            specificBuilder.ReturnStmt();
            break;
            case SwiftEntityDescriptorEnum.YieldStmt_ord :
            specificBuilder.YieldStmt();
            break;
            case SwiftEntityDescriptorEnum.YieldList_ord :
            specificBuilder.YieldList();
            break;
            case SwiftEntityDescriptorEnum.FallthroughStmt_ord :
            specificBuilder.FallthroughStmt();
            break;
            case SwiftEntityDescriptorEnum.BreakStmt_ord :
            specificBuilder.BreakStmt();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityCondition_ord :
            specificBuilder.AvailabilityCondition();
            break;
            case SwiftEntityDescriptorEnum.MatchingPatternCondition_ord :
            specificBuilder.MatchingPatternCondition();
            break;
            case SwiftEntityDescriptorEnum.OptionalBindingCondition_ord :
            specificBuilder.OptionalBindingCondition();
            break;
            case SwiftEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder.ConditionElementList();
            break;
            case SwiftEntityDescriptorEnum.ThrowStmt_ord :
            specificBuilder.ThrowStmt();
            break;
            case SwiftEntityDescriptorEnum.IfStmt_ord :
            specificBuilder.IfStmt();
            break;
            case SwiftEntityDescriptorEnum.SwitchDefaultLabel_ord :
            specificBuilder.SwitchDefaultLabel();
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseLabel_ord :
            specificBuilder.SwitchCaseLabel();
            break;
            case SwiftEntityDescriptorEnum.CaseItem_ord :
            specificBuilder.CaseItem();
            break;
            case SwiftEntityDescriptorEnum.CatchClause_ord :
            specificBuilder.CatchClause();
            break;
            case SwiftEntityDescriptorEnum.PoundAssertStmt_ord :
            specificBuilder.PoundAssertStmt();
            break;
            case SwiftEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder.GenericRequirementList();
            break;
            case SwiftEntityDescriptorEnum.SameTypeRequirement_ord :
            specificBuilder.SameTypeRequirement();
            break;
            case SwiftEntityDescriptorEnum.ConformanceRequirement_ord :
            specificBuilder.ConformanceRequirement();
            break;
            case SwiftEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder.GenericParameterList();
            break;
            case SwiftEntityDescriptorEnum.GenericParameter_ord :
            specificBuilder.GenericParameter();
            break;
            case SwiftEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            specificBuilder.SimpleTypeIdentifier();
            break;
            case SwiftEntityDescriptorEnum.MemberTypeIdentifier_ord :
            specificBuilder.MemberTypeIdentifier();
            break;
            case SwiftEntityDescriptorEnum.ClassRestrictionType_ord :
            specificBuilder.ClassRestrictionType();
            break;
            case SwiftEntityDescriptorEnum.ArrayType_ord :
            specificBuilder.ArrayType();
            break;
            case SwiftEntityDescriptorEnum.DictionaryType_ord :
            specificBuilder.DictionaryType();
            break;
            case SwiftEntityDescriptorEnum.MetatypeType_ord :
            specificBuilder.MetatypeType();
            break;
            case SwiftEntityDescriptorEnum.OptionalType_ord :
            specificBuilder.OptionalType();
            break;
            case SwiftEntityDescriptorEnum.SomeType_ord :
            specificBuilder.SomeType();
            break;
            case SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            specificBuilder.ImplicitlyUnwrappedOptionalType();
            break;
            case SwiftEntityDescriptorEnum.CompositionTypeElement_ord :
            specificBuilder.CompositionTypeElement();
            break;
            case SwiftEntityDescriptorEnum.Ampersand_ord :
            specificBuilder.Ampersand();
            break;
            case SwiftEntityDescriptorEnum.CompositionType_ord :
            specificBuilder.CompositionType();
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElement_ord :
            specificBuilder.TupleTypeElement();
            break;
            case SwiftEntityDescriptorEnum.Inout_ord :
            specificBuilder.Inout();
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder.TupleTypeElementList();
            break;
            case SwiftEntityDescriptorEnum.TupleType_ord :
            specificBuilder.TupleType();
            break;
            case SwiftEntityDescriptorEnum.FunctionType_ord :
            specificBuilder.FunctionType();
            break;
            case SwiftEntityDescriptorEnum.AttributedType_ord :
            specificBuilder.AttributedType();
            break;
            case SwiftEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder.GenericArgumentList();
            break;
            case SwiftEntityDescriptorEnum.EnumCasePattern_ord :
            specificBuilder.EnumCasePattern();
            break;
            case SwiftEntityDescriptorEnum.IsTypePattern_ord :
            specificBuilder.IsTypePattern();
            break;
            case SwiftEntityDescriptorEnum.OptionalPattern_ord :
            specificBuilder.OptionalPattern();
            break;
            case SwiftEntityDescriptorEnum.IdentifierPattern_ord :
            specificBuilder.IdentifierPattern();
            break;
            case SwiftEntityDescriptorEnum.SelfMarker_ord :
            specificBuilder.SelfMarker();
            break;
            case SwiftEntityDescriptorEnum.AsTypePattern_ord :
            specificBuilder.AsTypePattern();
            break;
            case SwiftEntityDescriptorEnum.WildcardPattern_ord :
            specificBuilder.WildcardPattern();
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElement_ord :
            specificBuilder.TuplePatternElement();
            break;
            case SwiftEntityDescriptorEnum.ExpressionPattern_ord :
            specificBuilder.ExpressionPattern();
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder.TuplePatternElementList();
            break;
            case SwiftEntityDescriptorEnum.ValueBindingPattern_ord :
            specificBuilder.ValueBindingPattern();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            specificBuilder.AvailabilityVersionRestriction();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            specificBuilder.AvailabilityLabeledArgument();
            break;
            case SwiftEntityDescriptorEnum.VersionTuple_ord :
            specificBuilder.VersionTuple();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder.CodeBlockItemList_();
            break;
            case SwiftEntityDescriptorEnum.InOutExpr_ord :
            specificBuilder.InOutExpr_();
            break;
            case SwiftEntityDescriptorEnum.PoundColumnExpr_ord :
            specificBuilder.PoundColumnExpr_();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder.FunctionCallArgumentList_();
            break;
            case SwiftEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder.StringLiteralSegments_();
            break;
            case SwiftEntityDescriptorEnum.ExpressionSegment_ord :
            specificBuilder.ExpressionSegment_();
            break;
            case SwiftEntityDescriptorEnum.TryExpr_ord :
            specificBuilder.TryExpr_();
            break;
            case SwiftEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder.DeclNameArgumentList_();
            break;
            case SwiftEntityDescriptorEnum.IdentifierExpr_ord :
            specificBuilder.IdentifierExpr_();
            break;
            case SwiftEntityDescriptorEnum.SuperRefExpr_ord :
            specificBuilder.SuperRefExpr_();
            break;
            case SwiftEntityDescriptorEnum.NilLiteralExpr_ord :
            specificBuilder.NilLiteralExpr_();
            break;
            case SwiftEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            specificBuilder.DiscardAssignmentExpr_();
            break;
            case SwiftEntityDescriptorEnum.AssignmentExpr_ord :
            specificBuilder.AssignmentExpr_();
            break;
            case SwiftEntityDescriptorEnum.SequenceExpr_ord :
            specificBuilder.SequenceExpr_();
            break;
            case SwiftEntityDescriptorEnum.PoundLineExpr_ord :
            specificBuilder.PoundLineExpr_();
            break;
            case SwiftEntityDescriptorEnum.PoundFileExpr_ord :
            specificBuilder.PoundFileExpr_();
            break;
            case SwiftEntityDescriptorEnum.PoundFunctionExpr_ord :
            specificBuilder.PoundFunctionExpr_();
            break;
            case SwiftEntityDescriptorEnum.PoundDsohandleExpr_ord :
            specificBuilder.PoundDsohandleExpr_();
            break;
            case SwiftEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            specificBuilder.SymbolicReferenceExpr_();
            break;
            case SwiftEntityDescriptorEnum.PrefixOperatorExpr_ord :
            specificBuilder.PrefixOperatorExpr_();
            break;
            case SwiftEntityDescriptorEnum.BinaryOperatorExpr_ord :
            specificBuilder.BinaryOperatorExpr_();
            break;
            case SwiftEntityDescriptorEnum.ArrowExpr_ord :
            specificBuilder.ArrowExpr_();
            break;
            case SwiftEntityDescriptorEnum.Throws_ord :
            specificBuilder.Throws_();
            break;
            case SwiftEntityDescriptorEnum.TupleExpr_ord :
            specificBuilder.TupleExpr_();
            break;
            case SwiftEntityDescriptorEnum.ArrayExpr_ord :
            specificBuilder.ArrayExpr_();
            break;
            case SwiftEntityDescriptorEnum.DictionaryExpr_ord :
            specificBuilder.DictionaryExpr_();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgument_ord :
            specificBuilder.FunctionCallArgument_();
            break;
            case SwiftEntityDescriptorEnum.TupleElement_ord :
            specificBuilder.TupleElement_();
            break;
            case SwiftEntityDescriptorEnum.DictionaryElement_ord :
            specificBuilder.DictionaryElement_();
            break;
            case SwiftEntityDescriptorEnum.TernaryExpr_ord :
            specificBuilder.TernaryExpr_();
            break;
            case SwiftEntityDescriptorEnum.MemberAccessExpr_ord :
            specificBuilder.MemberAccessExpr_();
            break;
            case SwiftEntityDescriptorEnum.IsExpr_ord :
            specificBuilder.IsExpr_();
            break;
            case SwiftEntityDescriptorEnum.AsExpr_ord :
            specificBuilder.AsExpr_();
            break;
            case SwiftEntityDescriptorEnum.TypeExpr_ord :
            specificBuilder.TypeExpr_();
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItem_ord :
            specificBuilder.ClosureCaptureItem_();
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder.ClosureCaptureItemList_();
            break;
            case SwiftEntityDescriptorEnum.WildcardMarker_ord :
            specificBuilder.WildcardMarker_();
            break;
            case SwiftEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder.ClosureParamList_();
            break;
            case SwiftEntityDescriptorEnum.ClosureSignature_ord :
            specificBuilder.ClosureSignature_();
            break;
            case SwiftEntityDescriptorEnum.ClosureExpr_ord :
            specificBuilder.ClosureExpr_();
            break;
            case SwiftEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            specificBuilder.UnresolvedPatternExpr_();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallExpr_ord :
            specificBuilder.FunctionCallExpr_();
            break;
            case SwiftEntityDescriptorEnum.SubscriptExpr_ord :
            specificBuilder.SubscriptExpr_();
            break;
            case SwiftEntityDescriptorEnum.OptionalChainingExpr_ord :
            specificBuilder.OptionalChainingExpr_();
            break;
            case SwiftEntityDescriptorEnum.ForcedValueExpr_ord :
            specificBuilder.ForcedValueExpr_();
            break;
            case SwiftEntityDescriptorEnum.PostfixUnaryExpr_ord :
            specificBuilder.PostfixUnaryExpr_();
            break;
            case SwiftEntityDescriptorEnum.SpecializeExpr_ord :
            specificBuilder.SpecializeExpr_();
            break;
            case SwiftEntityDescriptorEnum.StringLiteralExpr_ord :
            specificBuilder.StringLiteralExpr_();
            break;
            case SwiftEntityDescriptorEnum.KeyPathExpr_ord :
            specificBuilder.KeyPathExpr_();
            break;
            case SwiftEntityDescriptorEnum.KeyPathBaseExpr_ord :
            specificBuilder.KeyPathBaseExpr_();
            break;
            case SwiftEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            specificBuilder.ObjcKeyPathExpr_();
            break;
            case SwiftEntityDescriptorEnum.ObjcSelectorExpr_ord :
            specificBuilder.ObjcSelectorExpr_();
            break;
            case SwiftEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            specificBuilder.EditorPlaceholderExpr_();
            break;
            case SwiftEntityDescriptorEnum.ObjectLiteralExpr_ord :
            specificBuilder.ObjectLiteralExpr_();
            break;
            case SwiftEntityDescriptorEnum.TypealiasDecl_ord :
            specificBuilder.TypealiasDecl_();
            break;
            case SwiftEntityDescriptorEnum.AssociatedtypeDecl_ord :
            specificBuilder.AssociatedtypeDecl_();
            break;
            case SwiftEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder.FunctionParameterList_();
            break;
            case SwiftEntityDescriptorEnum.FunctionSignature_ord :
            specificBuilder.FunctionSignature_();
            break;
            case SwiftEntityDescriptorEnum.IfConfigClause_ord :
            specificBuilder.IfConfigClause_();
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder.SwitchCaseList_();
            break;
            case SwiftEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder.MemberDeclList_();
            break;
            case SwiftEntityDescriptorEnum.IfConfigDecl_ord :
            specificBuilder.IfConfigDecl_();
            break;
            case SwiftEntityDescriptorEnum.PoundErrorDecl_ord :
            specificBuilder.PoundErrorDecl_();
            break;
            case SwiftEntityDescriptorEnum.PoundWarningDecl_ord :
            specificBuilder.PoundWarningDecl_();
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocation_ord :
            specificBuilder.PoundSourceLocation_();
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            specificBuilder.PoundSourceLocationArgs_();
            break;
            case SwiftEntityDescriptorEnum.DeclModifier_ord :
            specificBuilder.DeclModifier_();
            break;
            case SwiftEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder.InheritedTypeList_();
            break;
            case SwiftEntityDescriptorEnum.ClassDecl_ord :
            specificBuilder.ClassDecl_();
            break;
            case SwiftEntityDescriptorEnum.StructDecl_ord :
            specificBuilder.StructDecl_();
            break;
            case SwiftEntityDescriptorEnum.ProtocolDecl_ord :
            specificBuilder.ProtocolDecl_();
            break;
            case SwiftEntityDescriptorEnum.ExtensionDecl_ord :
            specificBuilder.ExtensionDecl_();
            break;
            case SwiftEntityDescriptorEnum.SourceFile_ord :
            specificBuilder.SourceFile_();
            break;
            case SwiftEntityDescriptorEnum.FunctionParameter_ord :
            specificBuilder.FunctionParameter_();
            break;
            case SwiftEntityDescriptorEnum.Ellipsis_ord :
            specificBuilder.Ellipsis_();
            break;
            case SwiftEntityDescriptorEnum.ModifierList_ord :
            specificBuilder.ModifierList_();
            break;
            case SwiftEntityDescriptorEnum.FunctionDecl_ord :
            specificBuilder.FunctionDecl_();
            break;
            case SwiftEntityDescriptorEnum.InitializerDecl_ord :
            specificBuilder.InitializerDecl_();
            break;
            case SwiftEntityDescriptorEnum.DeinitializerDecl_ord :
            specificBuilder.DeinitializerDecl_();
            break;
            case SwiftEntityDescriptorEnum.SubscriptDecl_ord :
            specificBuilder.SubscriptDecl_();
            break;
            case SwiftEntityDescriptorEnum.AccessorBlock_ord :
            specificBuilder.AccessorBlock_();
            break;
            case SwiftEntityDescriptorEnum.AccessLevelModifier_ord :
            specificBuilder.AccessLevelModifier_();
            break;
            case SwiftEntityDescriptorEnum.AccessPath_ord :
            specificBuilder.AccessPath_();
            break;
            case SwiftEntityDescriptorEnum.ImportDecl_ord :
            specificBuilder.ImportDecl_();
            break;
            case SwiftEntityDescriptorEnum.AccessorDecl_ord :
            specificBuilder.AccessorDecl_();
            break;
            case SwiftEntityDescriptorEnum.PatternBinding_ord :
            specificBuilder.PatternBinding_();
            break;
            case SwiftEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder.PatternBindingList_();
            break;
            case SwiftEntityDescriptorEnum.VariableDecl_ord :
            specificBuilder.VariableDecl_();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElement_ord :
            specificBuilder.EnumCaseElement_();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder.EnumCaseElementList_();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseDecl_ord :
            specificBuilder.EnumCaseDecl_();
            break;
            case SwiftEntityDescriptorEnum.EnumDecl_ord :
            specificBuilder.EnumDecl_();
            break;
            case SwiftEntityDescriptorEnum.OperatorDecl_ord :
            specificBuilder.OperatorDecl_();
            break;
            case SwiftEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder.IdentifierList_();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            specificBuilder.PrecedenceGroupDecl_();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder.PrecedenceGroupAttributeList_();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            specificBuilder.PrecedenceGroupRelation_();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            specificBuilder.PrecedenceGroupAssignment_();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            specificBuilder.PrecedenceGroupAssociativity_();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder.PrecedenceGroupNameList_();
            break;
            case SwiftEntityDescriptorEnum.CustomAttribute_ord :
            specificBuilder.CustomAttribute_();
            break;
            case SwiftEntityDescriptorEnum.Attribute_ord :
            specificBuilder.Attribute_();
            break;
            case SwiftEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder.AvailabilitySpecList_();
            break;
            case SwiftEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder.SpecializeAttributeSpecList_();
            break;
            case SwiftEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder.ObjCSelector_();
            break;
            case SwiftEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            specificBuilder.ImplementsAttributeArguments_();
            break;
            case SwiftEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            specificBuilder.NamedAttributeStringArgument_();
            break;
            case SwiftEntityDescriptorEnum.AttributeList_ord :
            specificBuilder.AttributeList_();
            break;
            case SwiftEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            specificBuilder.LabeledSpecializeEntry_();
            break;
            case SwiftEntityDescriptorEnum.DeclName_ord :
            specificBuilder.DeclName_();
            break;
            case SwiftEntityDescriptorEnum.ContinueStmt_ord :
            specificBuilder.ContinueStmt_();
            break;
            case SwiftEntityDescriptorEnum.WhileStmt_ord :
            specificBuilder.WhileStmt_();
            break;
            case SwiftEntityDescriptorEnum.DeferStmt_ord :
            specificBuilder.DeferStmt_();
            break;
            case SwiftEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder.SwitchCase_();
            break;
            case SwiftEntityDescriptorEnum.RepeatWhileStmt_ord :
            specificBuilder.RepeatWhileStmt_();
            break;
            case SwiftEntityDescriptorEnum.GuardStmt_ord :
            specificBuilder.GuardStmt_();
            break;
            case SwiftEntityDescriptorEnum.ForInStmt_ord :
            specificBuilder.ForInStmt_();
            break;
            case SwiftEntityDescriptorEnum.Case_ord :
            specificBuilder.Case_();
            break;
            case SwiftEntityDescriptorEnum.SwitchStmt_ord :
            specificBuilder.SwitchStmt_();
            break;
            case SwiftEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder.CatchClauseList_();
            break;
            case SwiftEntityDescriptorEnum.DoStmt_ord :
            specificBuilder.DoStmt_();
            break;
            case SwiftEntityDescriptorEnum.ReturnStmt_ord :
            specificBuilder.ReturnStmt_();
            break;
            case SwiftEntityDescriptorEnum.YieldStmt_ord :
            specificBuilder.YieldStmt_();
            break;
            case SwiftEntityDescriptorEnum.YieldList_ord :
            specificBuilder.YieldList_();
            break;
            case SwiftEntityDescriptorEnum.FallthroughStmt_ord :
            specificBuilder.FallthroughStmt_();
            break;
            case SwiftEntityDescriptorEnum.BreakStmt_ord :
            specificBuilder.BreakStmt_();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityCondition_ord :
            specificBuilder.AvailabilityCondition_();
            break;
            case SwiftEntityDescriptorEnum.MatchingPatternCondition_ord :
            specificBuilder.MatchingPatternCondition_();
            break;
            case SwiftEntityDescriptorEnum.OptionalBindingCondition_ord :
            specificBuilder.OptionalBindingCondition_();
            break;
            case SwiftEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder.ConditionElementList_();
            break;
            case SwiftEntityDescriptorEnum.ThrowStmt_ord :
            specificBuilder.ThrowStmt_();
            break;
            case SwiftEntityDescriptorEnum.IfStmt_ord :
            specificBuilder.IfStmt_();
            break;
            case SwiftEntityDescriptorEnum.SwitchDefaultLabel_ord :
            specificBuilder.SwitchDefaultLabel_();
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseLabel_ord :
            specificBuilder.SwitchCaseLabel_();
            break;
            case SwiftEntityDescriptorEnum.CaseItem_ord :
            specificBuilder.CaseItem_();
            break;
            case SwiftEntityDescriptorEnum.CatchClause_ord :
            specificBuilder.CatchClause_();
            break;
            case SwiftEntityDescriptorEnum.PoundAssertStmt_ord :
            specificBuilder.PoundAssertStmt_();
            break;
            case SwiftEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder.GenericRequirementList_();
            break;
            case SwiftEntityDescriptorEnum.SameTypeRequirement_ord :
            specificBuilder.SameTypeRequirement_();
            break;
            case SwiftEntityDescriptorEnum.ConformanceRequirement_ord :
            specificBuilder.ConformanceRequirement_();
            break;
            case SwiftEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder.GenericParameterList_();
            break;
            case SwiftEntityDescriptorEnum.GenericParameter_ord :
            specificBuilder.GenericParameter_();
            break;
            case SwiftEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            specificBuilder.SimpleTypeIdentifier_();
            break;
            case SwiftEntityDescriptorEnum.MemberTypeIdentifier_ord :
            specificBuilder.MemberTypeIdentifier_();
            break;
            case SwiftEntityDescriptorEnum.ClassRestrictionType_ord :
            specificBuilder.ClassRestrictionType_();
            break;
            case SwiftEntityDescriptorEnum.ArrayType_ord :
            specificBuilder.ArrayType_();
            break;
            case SwiftEntityDescriptorEnum.DictionaryType_ord :
            specificBuilder.DictionaryType_();
            break;
            case SwiftEntityDescriptorEnum.MetatypeType_ord :
            specificBuilder.MetatypeType_();
            break;
            case SwiftEntityDescriptorEnum.OptionalType_ord :
            specificBuilder.OptionalType_();
            break;
            case SwiftEntityDescriptorEnum.SomeType_ord :
            specificBuilder.SomeType_();
            break;
            case SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            specificBuilder.ImplicitlyUnwrappedOptionalType_();
            break;
            case SwiftEntityDescriptorEnum.CompositionTypeElement_ord :
            specificBuilder.CompositionTypeElement_();
            break;
            case SwiftEntityDescriptorEnum.Ampersand_ord :
            specificBuilder.Ampersand_();
            break;
            case SwiftEntityDescriptorEnum.CompositionType_ord :
            specificBuilder.CompositionType_();
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElement_ord :
            specificBuilder.TupleTypeElement_();
            break;
            case SwiftEntityDescriptorEnum.Inout_ord :
            specificBuilder.Inout_();
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder.TupleTypeElementList_();
            break;
            case SwiftEntityDescriptorEnum.TupleType_ord :
            specificBuilder.TupleType_();
            break;
            case SwiftEntityDescriptorEnum.FunctionType_ord :
            specificBuilder.FunctionType_();
            break;
            case SwiftEntityDescriptorEnum.AttributedType_ord :
            specificBuilder.AttributedType_();
            break;
            case SwiftEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder.GenericArgumentList_();
            break;
            case SwiftEntityDescriptorEnum.EnumCasePattern_ord :
            specificBuilder.EnumCasePattern_();
            break;
            case SwiftEntityDescriptorEnum.IsTypePattern_ord :
            specificBuilder.IsTypePattern_();
            break;
            case SwiftEntityDescriptorEnum.OptionalPattern_ord :
            specificBuilder.OptionalPattern_();
            break;
            case SwiftEntityDescriptorEnum.IdentifierPattern_ord :
            specificBuilder.IdentifierPattern_();
            break;
            case SwiftEntityDescriptorEnum.SelfMarker_ord :
            specificBuilder.SelfMarker_();
            break;
            case SwiftEntityDescriptorEnum.AsTypePattern_ord :
            specificBuilder.AsTypePattern_();
            break;
            case SwiftEntityDescriptorEnum.WildcardPattern_ord :
            specificBuilder.WildcardPattern_();
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElement_ord :
            specificBuilder.TuplePatternElement_();
            break;
            case SwiftEntityDescriptorEnum.ExpressionPattern_ord :
            specificBuilder.ExpressionPattern_();
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder.TuplePatternElementList_();
            break;
            case SwiftEntityDescriptorEnum.ValueBindingPattern_ord :
            specificBuilder.ValueBindingPattern_();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            specificBuilder.AvailabilityVersionRestriction_();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            specificBuilder.AvailabilityLabeledArgument_();
            break;
            case SwiftEntityDescriptorEnum.VersionTuple_ord :
            specificBuilder.VersionTuple_();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder.CodeBlockItemList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder.FunctionCallArgumentList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder.StringLiteralSegments_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder.DeclNameArgumentList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.SequenceExpr_ord :
            specificBuilder.SequenceExpr_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.TupleExpr_ord :
            specificBuilder.TupleExpr_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.ArrayExpr_ord :
            specificBuilder.ArrayExpr_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.DictionaryExpr_ord :
            specificBuilder.DictionaryExpr_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder.ClosureCaptureItemList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder.ClosureParamList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            specificBuilder.ObjcKeyPathExpr_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder.FunctionParameterList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder.SwitchCaseList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder.MemberDeclList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.IfConfigDecl_ord :
            specificBuilder.IfConfigDecl_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder.InheritedTypeList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.ModifierList_ord :
            specificBuilder.ModifierList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.AccessorBlock_ord :
            specificBuilder.AccessorBlock_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.AccessPath_ord :
            specificBuilder.AccessPath_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder.PatternBindingList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder.EnumCaseElementList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder.IdentifierList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder.PrecedenceGroupAttributeList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder.PrecedenceGroupNameList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder.AvailabilitySpecList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder.SpecializeAttributeSpecList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder.ObjCSelector_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.AttributeList_ord :
            specificBuilder.AttributeList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder.CatchClauseList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.YieldList_ord :
            specificBuilder.YieldList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder.ConditionElementList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseLabel_ord :
            specificBuilder.SwitchCaseLabel_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder.GenericRequirementList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder.GenericParameterList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.CompositionType_ord :
            specificBuilder.CompositionType_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder.TupleTypeElementList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder.GenericArgumentList_(initialCapacity);
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder.TuplePatternElementList_(initialCapacity);
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder._CodeBlockItemList();
            break;
            case SwiftEntityDescriptorEnum.InOutExpr_ord :
            specificBuilder._InOutExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundColumnExpr_ord :
            specificBuilder._PoundColumnExpr();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder._FunctionCallArgumentList();
            break;
            case SwiftEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder._StringLiteralSegments();
            break;
            case SwiftEntityDescriptorEnum.ExpressionSegment_ord :
            specificBuilder._ExpressionSegment();
            break;
            case SwiftEntityDescriptorEnum.TryExpr_ord :
            specificBuilder._TryExpr();
            break;
            case SwiftEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder._DeclNameArgumentList();
            break;
            case SwiftEntityDescriptorEnum.IdentifierExpr_ord :
            specificBuilder._IdentifierExpr();
            break;
            case SwiftEntityDescriptorEnum.SuperRefExpr_ord :
            specificBuilder._SuperRefExpr();
            break;
            case SwiftEntityDescriptorEnum.NilLiteralExpr_ord :
            specificBuilder._NilLiteralExpr();
            break;
            case SwiftEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            specificBuilder._DiscardAssignmentExpr();
            break;
            case SwiftEntityDescriptorEnum.AssignmentExpr_ord :
            specificBuilder._AssignmentExpr();
            break;
            case SwiftEntityDescriptorEnum.SequenceExpr_ord :
            specificBuilder._SequenceExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundLineExpr_ord :
            specificBuilder._PoundLineExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundFileExpr_ord :
            specificBuilder._PoundFileExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundFunctionExpr_ord :
            specificBuilder._PoundFunctionExpr();
            break;
            case SwiftEntityDescriptorEnum.PoundDsohandleExpr_ord :
            specificBuilder._PoundDsohandleExpr();
            break;
            case SwiftEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            specificBuilder._SymbolicReferenceExpr();
            break;
            case SwiftEntityDescriptorEnum.PrefixOperatorExpr_ord :
            specificBuilder._PrefixOperatorExpr();
            break;
            case SwiftEntityDescriptorEnum.BinaryOperatorExpr_ord :
            specificBuilder._BinaryOperatorExpr();
            break;
            case SwiftEntityDescriptorEnum.ArrowExpr_ord :
            specificBuilder._ArrowExpr();
            break;
            case SwiftEntityDescriptorEnum.Throws_ord :
            specificBuilder._Throws();
            break;
            case SwiftEntityDescriptorEnum.TupleExpr_ord :
            specificBuilder._TupleExpr();
            break;
            case SwiftEntityDescriptorEnum.ArrayExpr_ord :
            specificBuilder._ArrayExpr();
            break;
            case SwiftEntityDescriptorEnum.DictionaryExpr_ord :
            specificBuilder._DictionaryExpr();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallArgument_ord :
            specificBuilder._FunctionCallArgument();
            break;
            case SwiftEntityDescriptorEnum.TupleElement_ord :
            specificBuilder._TupleElement();
            break;
            case SwiftEntityDescriptorEnum.DictionaryElement_ord :
            specificBuilder._DictionaryElement();
            break;
            case SwiftEntityDescriptorEnum.TernaryExpr_ord :
            specificBuilder._TernaryExpr();
            break;
            case SwiftEntityDescriptorEnum.MemberAccessExpr_ord :
            specificBuilder._MemberAccessExpr();
            break;
            case SwiftEntityDescriptorEnum.IsExpr_ord :
            specificBuilder._IsExpr();
            break;
            case SwiftEntityDescriptorEnum.AsExpr_ord :
            specificBuilder._AsExpr();
            break;
            case SwiftEntityDescriptorEnum.TypeExpr_ord :
            specificBuilder._TypeExpr();
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItem_ord :
            specificBuilder._ClosureCaptureItem();
            break;
            case SwiftEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder._ClosureCaptureItemList();
            break;
            case SwiftEntityDescriptorEnum.WildcardMarker_ord :
            specificBuilder._WildcardMarker();
            break;
            case SwiftEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder._ClosureParamList();
            break;
            case SwiftEntityDescriptorEnum.ClosureSignature_ord :
            specificBuilder._ClosureSignature();
            break;
            case SwiftEntityDescriptorEnum.ClosureExpr_ord :
            specificBuilder._ClosureExpr();
            break;
            case SwiftEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            specificBuilder._UnresolvedPatternExpr();
            break;
            case SwiftEntityDescriptorEnum.FunctionCallExpr_ord :
            specificBuilder._FunctionCallExpr();
            break;
            case SwiftEntityDescriptorEnum.SubscriptExpr_ord :
            specificBuilder._SubscriptExpr();
            break;
            case SwiftEntityDescriptorEnum.OptionalChainingExpr_ord :
            specificBuilder._OptionalChainingExpr();
            break;
            case SwiftEntityDescriptorEnum.ForcedValueExpr_ord :
            specificBuilder._ForcedValueExpr();
            break;
            case SwiftEntityDescriptorEnum.PostfixUnaryExpr_ord :
            specificBuilder._PostfixUnaryExpr();
            break;
            case SwiftEntityDescriptorEnum.SpecializeExpr_ord :
            specificBuilder._SpecializeExpr();
            break;
            case SwiftEntityDescriptorEnum.StringLiteralExpr_ord :
            specificBuilder._StringLiteralExpr();
            break;
            case SwiftEntityDescriptorEnum.KeyPathExpr_ord :
            specificBuilder._KeyPathExpr();
            break;
            case SwiftEntityDescriptorEnum.KeyPathBaseExpr_ord :
            specificBuilder._KeyPathBaseExpr();
            break;
            case SwiftEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            specificBuilder._ObjcKeyPathExpr();
            break;
            case SwiftEntityDescriptorEnum.ObjcSelectorExpr_ord :
            specificBuilder._ObjcSelectorExpr();
            break;
            case SwiftEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            specificBuilder._EditorPlaceholderExpr();
            break;
            case SwiftEntityDescriptorEnum.ObjectLiteralExpr_ord :
            specificBuilder._ObjectLiteralExpr();
            break;
            case SwiftEntityDescriptorEnum.TypealiasDecl_ord :
            specificBuilder._TypealiasDecl();
            break;
            case SwiftEntityDescriptorEnum.AssociatedtypeDecl_ord :
            specificBuilder._AssociatedtypeDecl();
            break;
            case SwiftEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder._FunctionParameterList();
            break;
            case SwiftEntityDescriptorEnum.FunctionSignature_ord :
            specificBuilder._FunctionSignature();
            break;
            case SwiftEntityDescriptorEnum.IfConfigClause_ord :
            specificBuilder._IfConfigClause();
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder._SwitchCaseList();
            break;
            case SwiftEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder._MemberDeclList();
            break;
            case SwiftEntityDescriptorEnum.IfConfigDecl_ord :
            specificBuilder._IfConfigDecl();
            break;
            case SwiftEntityDescriptorEnum.PoundErrorDecl_ord :
            specificBuilder._PoundErrorDecl();
            break;
            case SwiftEntityDescriptorEnum.PoundWarningDecl_ord :
            specificBuilder._PoundWarningDecl();
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocation_ord :
            specificBuilder._PoundSourceLocation();
            break;
            case SwiftEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            specificBuilder._PoundSourceLocationArgs();
            break;
            case SwiftEntityDescriptorEnum.DeclModifier_ord :
            specificBuilder._DeclModifier();
            break;
            case SwiftEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder._InheritedTypeList();
            break;
            case SwiftEntityDescriptorEnum.ClassDecl_ord :
            specificBuilder._ClassDecl();
            break;
            case SwiftEntityDescriptorEnum.StructDecl_ord :
            specificBuilder._StructDecl();
            break;
            case SwiftEntityDescriptorEnum.ProtocolDecl_ord :
            specificBuilder._ProtocolDecl();
            break;
            case SwiftEntityDescriptorEnum.ExtensionDecl_ord :
            specificBuilder._ExtensionDecl();
            break;
            case SwiftEntityDescriptorEnum.SourceFile_ord :
            specificBuilder._SourceFile();
            break;
            case SwiftEntityDescriptorEnum.FunctionParameter_ord :
            specificBuilder._FunctionParameter();
            break;
            case SwiftEntityDescriptorEnum.Ellipsis_ord :
            specificBuilder._Ellipsis();
            break;
            case SwiftEntityDescriptorEnum.ModifierList_ord :
            specificBuilder._ModifierList();
            break;
            case SwiftEntityDescriptorEnum.FunctionDecl_ord :
            specificBuilder._FunctionDecl();
            break;
            case SwiftEntityDescriptorEnum.InitializerDecl_ord :
            specificBuilder._InitializerDecl();
            break;
            case SwiftEntityDescriptorEnum.DeinitializerDecl_ord :
            specificBuilder._DeinitializerDecl();
            break;
            case SwiftEntityDescriptorEnum.SubscriptDecl_ord :
            specificBuilder._SubscriptDecl();
            break;
            case SwiftEntityDescriptorEnum.AccessorBlock_ord :
            specificBuilder._AccessorBlock();
            break;
            case SwiftEntityDescriptorEnum.AccessLevelModifier_ord :
            specificBuilder._AccessLevelModifier();
            break;
            case SwiftEntityDescriptorEnum.AccessPath_ord :
            specificBuilder._AccessPath();
            break;
            case SwiftEntityDescriptorEnum.ImportDecl_ord :
            specificBuilder._ImportDecl();
            break;
            case SwiftEntityDescriptorEnum.AccessorDecl_ord :
            specificBuilder._AccessorDecl();
            break;
            case SwiftEntityDescriptorEnum.PatternBinding_ord :
            specificBuilder._PatternBinding();
            break;
            case SwiftEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder._PatternBindingList();
            break;
            case SwiftEntityDescriptorEnum.VariableDecl_ord :
            specificBuilder._VariableDecl();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElement_ord :
            specificBuilder._EnumCaseElement();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder._EnumCaseElementList();
            break;
            case SwiftEntityDescriptorEnum.EnumCaseDecl_ord :
            specificBuilder._EnumCaseDecl();
            break;
            case SwiftEntityDescriptorEnum.EnumDecl_ord :
            specificBuilder._EnumDecl();
            break;
            case SwiftEntityDescriptorEnum.OperatorDecl_ord :
            specificBuilder._OperatorDecl();
            break;
            case SwiftEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder._IdentifierList();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            specificBuilder._PrecedenceGroupDecl();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder._PrecedenceGroupAttributeList();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            specificBuilder._PrecedenceGroupRelation();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            specificBuilder._PrecedenceGroupAssignment();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            specificBuilder._PrecedenceGroupAssociativity();
            break;
            case SwiftEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder._PrecedenceGroupNameList();
            break;
            case SwiftEntityDescriptorEnum.CustomAttribute_ord :
            specificBuilder._CustomAttribute();
            break;
            case SwiftEntityDescriptorEnum.Attribute_ord :
            specificBuilder._Attribute();
            break;
            case SwiftEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder._AvailabilitySpecList();
            break;
            case SwiftEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder._SpecializeAttributeSpecList();
            break;
            case SwiftEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder._ObjCSelector();
            break;
            case SwiftEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            specificBuilder._ImplementsAttributeArguments();
            break;
            case SwiftEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            specificBuilder._NamedAttributeStringArgument();
            break;
            case SwiftEntityDescriptorEnum.AttributeList_ord :
            specificBuilder._AttributeList();
            break;
            case SwiftEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            specificBuilder._LabeledSpecializeEntry();
            break;
            case SwiftEntityDescriptorEnum.DeclName_ord :
            specificBuilder._DeclName();
            break;
            case SwiftEntityDescriptorEnum.ContinueStmt_ord :
            specificBuilder._ContinueStmt();
            break;
            case SwiftEntityDescriptorEnum.WhileStmt_ord :
            specificBuilder._WhileStmt();
            break;
            case SwiftEntityDescriptorEnum.DeferStmt_ord :
            specificBuilder._DeferStmt();
            break;
            case SwiftEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder._SwitchCase();
            break;
            case SwiftEntityDescriptorEnum.RepeatWhileStmt_ord :
            specificBuilder._RepeatWhileStmt();
            break;
            case SwiftEntityDescriptorEnum.GuardStmt_ord :
            specificBuilder._GuardStmt();
            break;
            case SwiftEntityDescriptorEnum.ForInStmt_ord :
            specificBuilder._ForInStmt();
            break;
            case SwiftEntityDescriptorEnum.Case_ord :
            specificBuilder._Case();
            break;
            case SwiftEntityDescriptorEnum.SwitchStmt_ord :
            specificBuilder._SwitchStmt();
            break;
            case SwiftEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder._CatchClauseList();
            break;
            case SwiftEntityDescriptorEnum.DoStmt_ord :
            specificBuilder._DoStmt();
            break;
            case SwiftEntityDescriptorEnum.ReturnStmt_ord :
            specificBuilder._ReturnStmt();
            break;
            case SwiftEntityDescriptorEnum.YieldStmt_ord :
            specificBuilder._YieldStmt();
            break;
            case SwiftEntityDescriptorEnum.YieldList_ord :
            specificBuilder._YieldList();
            break;
            case SwiftEntityDescriptorEnum.FallthroughStmt_ord :
            specificBuilder._FallthroughStmt();
            break;
            case SwiftEntityDescriptorEnum.BreakStmt_ord :
            specificBuilder._BreakStmt();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityCondition_ord :
            specificBuilder._AvailabilityCondition();
            break;
            case SwiftEntityDescriptorEnum.MatchingPatternCondition_ord :
            specificBuilder._MatchingPatternCondition();
            break;
            case SwiftEntityDescriptorEnum.OptionalBindingCondition_ord :
            specificBuilder._OptionalBindingCondition();
            break;
            case SwiftEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder._ConditionElementList();
            break;
            case SwiftEntityDescriptorEnum.ThrowStmt_ord :
            specificBuilder._ThrowStmt();
            break;
            case SwiftEntityDescriptorEnum.IfStmt_ord :
            specificBuilder._IfStmt();
            break;
            case SwiftEntityDescriptorEnum.SwitchDefaultLabel_ord :
            specificBuilder._SwitchDefaultLabel();
            break;
            case SwiftEntityDescriptorEnum.SwitchCaseLabel_ord :
            specificBuilder._SwitchCaseLabel();
            break;
            case SwiftEntityDescriptorEnum.CaseItem_ord :
            specificBuilder._CaseItem();
            break;
            case SwiftEntityDescriptorEnum.CatchClause_ord :
            specificBuilder._CatchClause();
            break;
            case SwiftEntityDescriptorEnum.PoundAssertStmt_ord :
            specificBuilder._PoundAssertStmt();
            break;
            case SwiftEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder._GenericRequirementList();
            break;
            case SwiftEntityDescriptorEnum.SameTypeRequirement_ord :
            specificBuilder._SameTypeRequirement();
            break;
            case SwiftEntityDescriptorEnum.ConformanceRequirement_ord :
            specificBuilder._ConformanceRequirement();
            break;
            case SwiftEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder._GenericParameterList();
            break;
            case SwiftEntityDescriptorEnum.GenericParameter_ord :
            specificBuilder._GenericParameter();
            break;
            case SwiftEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            specificBuilder._SimpleTypeIdentifier();
            break;
            case SwiftEntityDescriptorEnum.MemberTypeIdentifier_ord :
            specificBuilder._MemberTypeIdentifier();
            break;
            case SwiftEntityDescriptorEnum.ClassRestrictionType_ord :
            specificBuilder._ClassRestrictionType();
            break;
            case SwiftEntityDescriptorEnum.ArrayType_ord :
            specificBuilder._ArrayType();
            break;
            case SwiftEntityDescriptorEnum.DictionaryType_ord :
            specificBuilder._DictionaryType();
            break;
            case SwiftEntityDescriptorEnum.MetatypeType_ord :
            specificBuilder._MetatypeType();
            break;
            case SwiftEntityDescriptorEnum.OptionalType_ord :
            specificBuilder._OptionalType();
            break;
            case SwiftEntityDescriptorEnum.SomeType_ord :
            specificBuilder._SomeType();
            break;
            case SwiftEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            specificBuilder._ImplicitlyUnwrappedOptionalType();
            break;
            case SwiftEntityDescriptorEnum.CompositionTypeElement_ord :
            specificBuilder._CompositionTypeElement();
            break;
            case SwiftEntityDescriptorEnum.Ampersand_ord :
            specificBuilder._Ampersand();
            break;
            case SwiftEntityDescriptorEnum.CompositionType_ord :
            specificBuilder._CompositionType();
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElement_ord :
            specificBuilder._TupleTypeElement();
            break;
            case SwiftEntityDescriptorEnum.Inout_ord :
            specificBuilder._Inout();
            break;
            case SwiftEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder._TupleTypeElementList();
            break;
            case SwiftEntityDescriptorEnum.TupleType_ord :
            specificBuilder._TupleType();
            break;
            case SwiftEntityDescriptorEnum.FunctionType_ord :
            specificBuilder._FunctionType();
            break;
            case SwiftEntityDescriptorEnum.AttributedType_ord :
            specificBuilder._AttributedType();
            break;
            case SwiftEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder._GenericArgumentList();
            break;
            case SwiftEntityDescriptorEnum.EnumCasePattern_ord :
            specificBuilder._EnumCasePattern();
            break;
            case SwiftEntityDescriptorEnum.IsTypePattern_ord :
            specificBuilder._IsTypePattern();
            break;
            case SwiftEntityDescriptorEnum.OptionalPattern_ord :
            specificBuilder._OptionalPattern();
            break;
            case SwiftEntityDescriptorEnum.IdentifierPattern_ord :
            specificBuilder._IdentifierPattern();
            break;
            case SwiftEntityDescriptorEnum.SelfMarker_ord :
            specificBuilder._SelfMarker();
            break;
            case SwiftEntityDescriptorEnum.AsTypePattern_ord :
            specificBuilder._AsTypePattern();
            break;
            case SwiftEntityDescriptorEnum.WildcardPattern_ord :
            specificBuilder._WildcardPattern();
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElement_ord :
            specificBuilder._TuplePatternElement();
            break;
            case SwiftEntityDescriptorEnum.ExpressionPattern_ord :
            specificBuilder._ExpressionPattern();
            break;
            case SwiftEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder._TuplePatternElementList();
            break;
            case SwiftEntityDescriptorEnum.ValueBindingPattern_ord :
            specificBuilder._ValueBindingPattern();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            specificBuilder._AvailabilityVersionRestriction();
            break;
            case SwiftEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            specificBuilder._AvailabilityLabeledArgument();
            break;
            case SwiftEntityDescriptorEnum.VersionTuple_ord :
            specificBuilder._VersionTuple();
            break;
        }
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case SwiftFeatureDescriptorEnum.expression_ord :
            specificBuilder.expression();
            break;
            case SwiftFeatureDescriptorEnum.delimiter_ord :
            specificBuilder.delimiter();
            break;
            case SwiftFeatureDescriptorEnum.expressions_ord :
            specificBuilder.expressions();
            break;
            case SwiftFeatureDescriptorEnum.questionOrExclamationMark_ord :
            specificBuilder.questionOrExclamationMark();
            break;
            case SwiftFeatureDescriptorEnum.identifier_ord :
            specificBuilder.identifier();
            break;
            case SwiftFeatureDescriptorEnum.declNameArguments_ord :
            specificBuilder.declNameArguments();
            break;
            case SwiftFeatureDescriptorEnum.genericArgumentClause_ord :
            specificBuilder.genericArgumentClause();
            break;
            case SwiftFeatureDescriptorEnum.operatorToken_ord :
            specificBuilder.operatorToken();
            break;
            case SwiftFeatureDescriptorEnum.postfixExpression_ord :
            specificBuilder.postfixExpression();
            break;
            case SwiftFeatureDescriptorEnum.throwsToken_ord :
            specificBuilder.throwsToken();
            break;
            case SwiftFeatureDescriptorEnum.label_ord :
            specificBuilder.label();
            break;
            case SwiftFeatureDescriptorEnum.keyExpression_ord :
            specificBuilder.keyExpression();
            break;
            case SwiftFeatureDescriptorEnum.valueExpression_ord :
            specificBuilder.valueExpression();
            break;
            case SwiftFeatureDescriptorEnum.conditionExpression_ord :
            specificBuilder.conditionExpression();
            break;
            case SwiftFeatureDescriptorEnum.firstChoice_ord :
            specificBuilder.firstChoice();
            break;
            case SwiftFeatureDescriptorEnum.secondChoice_ord :
            specificBuilder.secondChoice();
            break;
            case SwiftFeatureDescriptorEnum.base_ord :
            specificBuilder.base();
            break;
            case SwiftFeatureDescriptorEnum.dot_ord :
            specificBuilder.dot();
            break;
            case SwiftFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case SwiftFeatureDescriptorEnum.typeName_ord :
            specificBuilder.typeName();
            break;
            case SwiftFeatureDescriptorEnum.type_ord :
            specificBuilder.type();
            break;
            case SwiftFeatureDescriptorEnum.specifier_ord :
            specificBuilder.specifier();
            break;
            case SwiftFeatureDescriptorEnum.capture_ord :
            specificBuilder.capture();
            break;
            case SwiftFeatureDescriptorEnum.input_ord :
            specificBuilder.input();
            break;
            case SwiftFeatureDescriptorEnum.throwsTok_ord :
            specificBuilder.throwsTok();
            break;
            case SwiftFeatureDescriptorEnum.output_ord :
            specificBuilder.output();
            break;
            case SwiftFeatureDescriptorEnum.signature_ord :
            specificBuilder.signature();
            break;
            case SwiftFeatureDescriptorEnum.statements_ord :
            specificBuilder.statements();
            break;
            case SwiftFeatureDescriptorEnum.pattern_ord :
            specificBuilder.pattern();
            break;
            case SwiftFeatureDescriptorEnum.calledExpression_ord :
            specificBuilder.calledExpression();
            break;
            case SwiftFeatureDescriptorEnum.argumentList_ord :
            specificBuilder.argumentList();
            break;
            case SwiftFeatureDescriptorEnum.trailingClosure_ord :
            specificBuilder.trailingClosure();
            break;
            case SwiftFeatureDescriptorEnum.openDelimiter_ord :
            specificBuilder.openDelimiter();
            break;
            case SwiftFeatureDescriptorEnum.openQuote_ord :
            specificBuilder.openQuote();
            break;
            case SwiftFeatureDescriptorEnum.segments_ord :
            specificBuilder.segments();
            break;
            case SwiftFeatureDescriptorEnum.rootExpr_ord :
            specificBuilder.rootExpr();
            break;
            case SwiftFeatureDescriptorEnum.kind_ord :
            specificBuilder.kind();
            break;
            case SwiftFeatureDescriptorEnum.poundIdentifier_ord :
            specificBuilder.poundIdentifier();
            break;
            case SwiftFeatureDescriptorEnum.arguments_ord :
            specificBuilder.arguments();
            break;
            case SwiftFeatureDescriptorEnum.attributes_ord :
            specificBuilder.attributes();
            break;
            case SwiftFeatureDescriptorEnum.modifiers_ord :
            specificBuilder.modifiers();
            break;
            case SwiftFeatureDescriptorEnum.genericParameterClause_ord :
            specificBuilder.genericParameterClause();
            break;
            case SwiftFeatureDescriptorEnum.initializer_ord :
            specificBuilder.initializer();
            break;
            case SwiftFeatureDescriptorEnum.genericWhereClause_ord :
            specificBuilder.genericWhereClause();
            break;
            case SwiftFeatureDescriptorEnum.inheritanceClause_ord :
            specificBuilder.inheritanceClause();
            break;
            case SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword_ord :
            specificBuilder.throwsOrRethrowsKeyword();
            break;
            case SwiftFeatureDescriptorEnum.poundKeyword_ord :
            specificBuilder.poundKeyword();
            break;
            case SwiftFeatureDescriptorEnum.condition_ord :
            specificBuilder.condition();
            break;
            case SwiftFeatureDescriptorEnum.elements_ord :
            specificBuilder.elements();
            break;
            case SwiftFeatureDescriptorEnum.message_ord :
            specificBuilder.message();
            break;
            case SwiftFeatureDescriptorEnum.args_ord :
            specificBuilder.args();
            break;
            case SwiftFeatureDescriptorEnum.fileArgLabel_ord :
            specificBuilder.fileArgLabel();
            break;
            case SwiftFeatureDescriptorEnum.fileName_ord :
            specificBuilder.fileName();
            break;
            case SwiftFeatureDescriptorEnum.lineArgLabel_ord :
            specificBuilder.lineArgLabel();
            break;
            case SwiftFeatureDescriptorEnum.lineNumber_ord :
            specificBuilder.lineNumber();
            break;
            case SwiftFeatureDescriptorEnum.detail_ord :
            specificBuilder.detail();
            break;
            case SwiftFeatureDescriptorEnum.members_ord :
            specificBuilder.members();
            break;
            case SwiftFeatureDescriptorEnum.extendedType_ord :
            specificBuilder.extendedType();
            break;
            case SwiftFeatureDescriptorEnum.firstName_ord :
            specificBuilder.firstName();
            break;
            case SwiftFeatureDescriptorEnum.secondName_ord :
            specificBuilder.secondName();
            break;
            case SwiftFeatureDescriptorEnum.ellipsis_ord :
            specificBuilder.ellipsis();
            break;
            case SwiftFeatureDescriptorEnum.defaultArgument_ord :
            specificBuilder.defaultArgument();
            break;
            case SwiftFeatureDescriptorEnum.functionIdentifier_ord :
            specificBuilder.functionIdentifier();
            break;
            case SwiftFeatureDescriptorEnum.body_ord :
            specificBuilder.body();
            break;
            case SwiftFeatureDescriptorEnum.optionalMark_ord :
            specificBuilder.optionalMark();
            break;
            case SwiftFeatureDescriptorEnum.parameters_ord :
            specificBuilder.parameters();
            break;
            case SwiftFeatureDescriptorEnum.indices_ord :
            specificBuilder.indices();
            break;
            case SwiftFeatureDescriptorEnum.result_ord :
            specificBuilder.result();
            break;
            case SwiftFeatureDescriptorEnum.accessor_ord :
            specificBuilder.accessor();
            break;
            case SwiftFeatureDescriptorEnum.modifier_ord :
            specificBuilder.modifier();
            break;
            case SwiftFeatureDescriptorEnum.importKind_ord :
            specificBuilder.importKind();
            break;
            case SwiftFeatureDescriptorEnum.path_ord :
            specificBuilder.path();
            break;
            case SwiftFeatureDescriptorEnum.accessorKind_ord :
            specificBuilder.accessorKind();
            break;
            case SwiftFeatureDescriptorEnum.parameter_ord :
            specificBuilder.parameter();
            break;
            case SwiftFeatureDescriptorEnum.typeAnnotation_ord :
            specificBuilder.typeAnnotation();
            break;
            case SwiftFeatureDescriptorEnum.letOrVarKeyword_ord :
            specificBuilder.letOrVarKeyword();
            break;
            case SwiftFeatureDescriptorEnum.bindings_ord :
            specificBuilder.bindings();
            break;
            case SwiftFeatureDescriptorEnum.associatedValue_ord :
            specificBuilder.associatedValue();
            break;
            case SwiftFeatureDescriptorEnum.rawValue_ord :
            specificBuilder.rawValue();
            break;
            case SwiftFeatureDescriptorEnum.genericParameters_ord :
            specificBuilder.genericParameters();
            break;
            case SwiftFeatureDescriptorEnum.operatorIdentifier_ord :
            specificBuilder.operatorIdentifier();
            break;
            case SwiftFeatureDescriptorEnum.operatorPrecedenceAndTypes_ord :
            specificBuilder.operatorPrecedenceAndTypes();
            break;
            case SwiftFeatureDescriptorEnum.groupAttributes_ord :
            specificBuilder.groupAttributes();
            break;
            case SwiftFeatureDescriptorEnum.higherThanOrLowerThan_ord :
            specificBuilder.higherThanOrLowerThan();
            break;
            case SwiftFeatureDescriptorEnum.otherNames_ord :
            specificBuilder.otherNames();
            break;
            case SwiftFeatureDescriptorEnum.assignmentKeyword_ord :
            specificBuilder.assignmentKeyword();
            break;
            case SwiftFeatureDescriptorEnum.flag_ord :
            specificBuilder.flag();
            break;
            case SwiftFeatureDescriptorEnum.associativityKeyword_ord :
            specificBuilder.associativityKeyword();
            break;
            case SwiftFeatureDescriptorEnum.value_ord :
            specificBuilder.value();
            break;
            case SwiftFeatureDescriptorEnum.attributeName_ord :
            specificBuilder.attributeName();
            break;
            case SwiftFeatureDescriptorEnum.argument_ord :
            specificBuilder.argument();
            break;
            case SwiftFeatureDescriptorEnum.declBaseName_ord :
            specificBuilder.declBaseName();
            break;
            case SwiftFeatureDescriptorEnum.nameTok_ord :
            specificBuilder.nameTok();
            break;
            case SwiftFeatureDescriptorEnum.stringOrDeclname_ord :
            specificBuilder.stringOrDeclname();
            break;
            case SwiftFeatureDescriptorEnum.labelName_ord :
            specificBuilder.labelName();
            break;
            case SwiftFeatureDescriptorEnum.conditions_ord :
            specificBuilder.conditions();
            break;
            case SwiftFeatureDescriptorEnum.unknownAttr_ord :
            specificBuilder.unknownAttr();
            break;
            case SwiftFeatureDescriptorEnum.caseKeyword_ord :
            specificBuilder.caseKeyword();
            break;
            case SwiftFeatureDescriptorEnum.sequenceExpr_ord :
            specificBuilder.sequenceExpr();
            break;
            case SwiftFeatureDescriptorEnum.whereClause_ord :
            specificBuilder.whereClause();
            break;
            case SwiftFeatureDescriptorEnum.cases_ord :
            specificBuilder.cases();
            break;
            case SwiftFeatureDescriptorEnum.catchClauses_ord :
            specificBuilder.catchClauses();
            break;
            case SwiftFeatureDescriptorEnum.yields_ord :
            specificBuilder.yields();
            break;
            case SwiftFeatureDescriptorEnum.availabilitySpec_ord :
            specificBuilder.availabilitySpec();
            break;
            case SwiftFeatureDescriptorEnum.elseBody_ord :
            specificBuilder.elseBody();
            break;
            case SwiftFeatureDescriptorEnum.leftTypeIdentifier_ord :
            specificBuilder.leftTypeIdentifier();
            break;
            case SwiftFeatureDescriptorEnum.equalityToken_ord :
            specificBuilder.equalityToken();
            break;
            case SwiftFeatureDescriptorEnum.rightTypeIdentifier_ord :
            specificBuilder.rightTypeIdentifier();
            break;
            case SwiftFeatureDescriptorEnum.inheritedType_ord :
            specificBuilder.inheritedType();
            break;
            case SwiftFeatureDescriptorEnum.baseType_ord :
            specificBuilder.baseType();
            break;
            case SwiftFeatureDescriptorEnum.period_ord :
            specificBuilder.period();
            break;
            case SwiftFeatureDescriptorEnum.elementType_ord :
            specificBuilder.elementType();
            break;
            case SwiftFeatureDescriptorEnum.keyType_ord :
            specificBuilder.keyType();
            break;
            case SwiftFeatureDescriptorEnum.valueType_ord :
            specificBuilder.valueType();
            break;
            case SwiftFeatureDescriptorEnum.typeOrProtocol_ord :
            specificBuilder.typeOrProtocol();
            break;
            case SwiftFeatureDescriptorEnum.wrappedType_ord :
            specificBuilder.wrappedType();
            break;
            case SwiftFeatureDescriptorEnum.someSpecifier_ord :
            specificBuilder.someSpecifier();
            break;
            case SwiftFeatureDescriptorEnum.ampersand_ord :
            specificBuilder.ampersand();
            break;
            case SwiftFeatureDescriptorEnum.inOut_ord :
            specificBuilder.inOut();
            break;
            case SwiftFeatureDescriptorEnum.returnType_ord :
            specificBuilder.returnType();
            break;
            case SwiftFeatureDescriptorEnum.caseName_ord :
            specificBuilder.caseName();
            break;
            case SwiftFeatureDescriptorEnum.associatedTuple_ord :
            specificBuilder.associatedTuple();
            break;
            case SwiftFeatureDescriptorEnum.subPattern_ord :
            specificBuilder.subPattern();
            break;
            case SwiftFeatureDescriptorEnum.patternIdentifier_ord :
            specificBuilder.patternIdentifier();
            break;
            case SwiftFeatureDescriptorEnum.valuePattern_ord :
            specificBuilder.valuePattern();
            break;
            case SwiftFeatureDescriptorEnum.platform_ord :
            specificBuilder.platform();
            break;
            case SwiftFeatureDescriptorEnum.version_ord :
            specificBuilder.version();
            break;
            case SwiftFeatureDescriptorEnum.majorMinor_ord :
            specificBuilder.majorMinor();
            break;
            case SwiftFeatureDescriptorEnum.patchVersion_ord :
            specificBuilder.patchVersion();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum_ord :
            specificBuilder.QuestionOrExclamationMarkEnum((Value) value);
            break;
            case SwiftEntityDescriptorEnum.IdentifierEnum_ord :
            specificBuilder.IdentifierEnum((org.whole.lang.swift.model.IdentifierEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.DotEnum_ord :
            specificBuilder.DotEnum((org.whole.lang.swift.model.DotEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.OpenQuoteEnum_ord :
            specificBuilder.OpenQuoteEnum((org.whole.lang.swift.model.OpenQuoteEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.KindValue_ord :
            specificBuilder.KindValue((org.whole.lang.swift.model.KindValueEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.PoundIdentifierEnum_ord :
            specificBuilder.PoundIdentifierEnum((org.whole.lang.swift.model.PoundIdentifierEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum_ord :
            specificBuilder.ThrowsOrRethrowsKeywordEnum((org.whole.lang.swift.model.ThrowsOrRethrowsKeywordEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.PoundKeywordEnum_ord :
            specificBuilder.PoundKeywordEnum((org.whole.lang.swift.model.PoundKeywordEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.NameValue_ord :
            specificBuilder.NameValue((org.whole.lang.swift.model.NameValueEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.OptionalMarkEnum_ord :
            specificBuilder.OptionalMarkEnum((org.whole.lang.swift.model.OptionalMarkEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.ImportKindEnum_ord :
            specificBuilder.ImportKindEnum((org.whole.lang.swift.model.ImportKindEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.AccessorKindValue_ord :
            specificBuilder.AccessorKindValue((org.whole.lang.swift.model.AccessorKindValueEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.LetOrVarKeywordEnum_ord :
            specificBuilder.LetOrVarKeywordEnum((org.whole.lang.swift.model.LetOrVarKeywordEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue_ord :
            specificBuilder.HigherThanOrLowerThanValue((org.whole.lang.swift.model.HigherThanOrLowerThanValueEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.FlagEnum_ord :
            specificBuilder.FlagEnum((org.whole.lang.swift.model.FlagEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.ValueValue_ord :
            specificBuilder.ValueValue((org.whole.lang.swift.model.ValueValueEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.NameEnum_ord :
            specificBuilder.NameEnum((org.whole.lang.swift.model.NameEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.PeriodEnum_ord :
            specificBuilder.PeriodEnum((org.whole.lang.swift.model.PeriodEnumEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.TypeOrProtocolValue_ord :
            specificBuilder.TypeOrProtocolValue((org.whole.lang.swift.model.TypeOrProtocolValueEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.SpecifierValue_ord :
            specificBuilder.SpecifierValue((org.whole.lang.swift.model.SpecifierValueEnum.Value) value);
            break;
            case SwiftEntityDescriptorEnum.CaptureSpecifierEnum_ord :
            specificBuilder.CaptureSpecifierEnum((org.whole.lang.swift.model.CaptureSpecifierEnumEnum.Value) value);
            break;
        }
    }
}
