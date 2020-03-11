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

import org.whole.lang.builders.IBuilder;
import org.whole.lang.swift.model.QuestionOrExclamationMarkEnumEnum;
import org.whole.lang.swift.model.IdentifierEnumEnum;
import org.whole.lang.swift.model.DotEnumEnum;
import org.whole.lang.swift.model.OpenQuoteEnumEnum;
import org.whole.lang.swift.model.KindValueEnum;
import org.whole.lang.swift.model.PoundIdentifierEnumEnum;
import org.whole.lang.swift.model.ThrowsOrRethrowsKeywordEnumEnum;
import org.whole.lang.swift.model.PoundKeywordEnumEnum;
import org.whole.lang.swift.model.NameValueEnum;
import org.whole.lang.swift.model.OptionalMarkEnumEnum;
import org.whole.lang.swift.model.ImportKindEnumEnum;
import org.whole.lang.swift.model.AccessorKindValueEnum;
import org.whole.lang.swift.model.LetOrVarKeywordEnumEnum;
import org.whole.lang.swift.model.HigherThanOrLowerThanValueEnum;
import org.whole.lang.swift.model.FlagEnumEnum;
import org.whole.lang.swift.model.ValueValueEnum;
import org.whole.lang.swift.model.NameEnumEnum;
import org.whole.lang.swift.model.PeriodEnumEnum;
import org.whole.lang.swift.model.TypeOrProtocolValueEnum;
import org.whole.lang.swift.model.SpecifierValueEnum;
import org.whole.lang.swift.model.CaptureSpecifierEnumEnum;

/**
 *  @generator Whole
 */
public interface ISwiftBuilder extends IBuilder {


    public void visit();

    public void patchVersion();

    public void majorMinor();

    public void version();

    public void platform();

    public void valuePattern();

    public void patternIdentifier();

    public void subPattern();

    public void associatedTuple();

    public void caseName();

    public void returnType();

    public void inOut();

    public void ampersand();

    public void someSpecifier();

    public void wrappedType();

    public void typeOrProtocol();

    public void valueType();

    public void keyType();

    public void elementType();

    public void period();

    public void baseType();

    public void inheritedType();

    public void rightTypeIdentifier();

    public void equalityToken();

    public void leftTypeIdentifier();

    public void elseBody();

    public void availabilitySpec();

    public void yields();

    public void catchClauses();

    public void cases();

    public void whereClause();

    public void sequenceExpr();

    public void caseKeyword();

    public void unknownAttr();

    public void conditions();

    public void labelName();

    public void stringOrDeclname();

    public void nameTok();

    public void declBaseName();

    public void argument();

    public void attributeName();

    public void value();

    public void associativityKeyword();

    public void flag();

    public void assignmentKeyword();

    public void otherNames();

    public void higherThanOrLowerThan();

    public void groupAttributes();

    public void operatorPrecedenceAndTypes();

    public void operatorIdentifier();

    public void genericParameters();

    public void rawValue();

    public void associatedValue();

    public void bindings();

    public void letOrVarKeyword();

    public void typeAnnotation();

    public void parameter();

    public void accessorKind();

    public void path();

    public void importKind();

    public void modifier();

    public void accessor();

    public void result();

    public void indices();

    public void parameters();

    public void optionalMark();

    public void body();

    public void functionIdentifier();

    public void defaultArgument();

    public void ellipsis();

    public void secondName();

    public void firstName();

    public void extendedType();

    public void members();

    public void detail();

    public void lineNumber();

    public void lineArgLabel();

    public void fileName();

    public void fileArgLabel();

    public void args();

    public void message();

    public void elements();

    public void condition();

    public void poundKeyword();

    public void throwsOrRethrowsKeyword();

    public void inheritanceClause();

    public void genericWhereClause();

    public void initializer();

    public void genericParameterClause();

    public void modifiers();

    public void attributes();

    public void arguments();

    public void poundIdentifier();

    public void kind();

    public void rootExpr();

    public void segments();

    public void openQuote();

    public void openDelimiter();

    public void trailingClosure();

    public void argumentList();

    public void calledExpression();

    public void pattern();

    public void statements();

    public void signature();

    public void output();

    public void throwsTok();

    public void input();

    public void capture();

    public void specifier();

    public void type();

    public void typeName();

    public void name();

    public void dot();

    public void base();

    public void secondChoice();

    public void firstChoice();

    public void conditionExpression();

    public void valueExpression();

    public void keyExpression();

    public void label();

    public void throwsToken();

    public void postfixExpression();

    public void operatorToken();

    public void genericArgumentClause();

    public void declNameArguments();

    public void identifier();

    public void questionOrExclamationMark();

    public void expressions();

    public void delimiter();

    public void expression();

    public void BooleanLiteral();

    public void BooleanLiteral(boolean value);

    public void IntegerLiteral();

    public void IntegerLiteral(long value);

    public void FloatingLiteral();

    public void FloatingLiteral(double value);

    public void StringLiteral();

    public void StringLiteral(String value);

    public void Identifier();

    public void Identifier(String value);

    public void BinaryOperator();

    public void BinaryOperator(String value);

    public void PostfixOperator();

    public void PostfixOperator(String value);

    public void PrefixOperator();

    public void PrefixOperator(String value);

    public void DollarIdentifier();

    public void DollarIdentifier(String value);

    public void RawStringDelimiter();

    public void RawStringDelimiter(String value);

    public void CodeBlockItemList();

    public void CodeBlockItemList_();

    public void CodeBlockItemList_(int initialCapacity);

    public void _CodeBlockItemList();

    public void InOutExpr();

    public void InOutExpr_();

    public void _InOutExpr();

    public void PoundColumnExpr();

    public void PoundColumnExpr_();

    public void _PoundColumnExpr();

    public void FunctionCallArgumentList();

    public void FunctionCallArgumentList_();

    public void FunctionCallArgumentList_(int initialCapacity);

    public void _FunctionCallArgumentList();

    public void StringLiteralSegments();

    public void StringLiteralSegments_();

    public void StringLiteralSegments_(int initialCapacity);

    public void _StringLiteralSegments();

    public void ExpressionSegment();

    public void ExpressionSegment_();

    public void _ExpressionSegment();

    public void TryExpr();

    public void TryExpr_();

    public void _TryExpr();

    public void QuestionOrExclamationMarkEnum();

    public void QuestionOrExclamationMarkEnum(QuestionOrExclamationMarkEnumEnum.Value value);

    public void QuestionOrExclamationMarkEnum(String value);

    public void DeclNameArgumentList();

    public void DeclNameArgumentList_();

    public void DeclNameArgumentList_(int initialCapacity);

    public void _DeclNameArgumentList();

    public void IdentifierExpr();

    public void IdentifierExpr_();

    public void _IdentifierExpr();

    public void IdentifierEnum();

    public void IdentifierEnum(IdentifierEnumEnum.Value value);

    public void IdentifierEnum(String value);

    public void SuperRefExpr();

    public void SuperRefExpr_();

    public void _SuperRefExpr();

    public void NilLiteralExpr();

    public void NilLiteralExpr_();

    public void _NilLiteralExpr();

    public void DiscardAssignmentExpr();

    public void DiscardAssignmentExpr_();

    public void _DiscardAssignmentExpr();

    public void AssignmentExpr();

    public void AssignmentExpr_();

    public void _AssignmentExpr();

    public void SequenceExpr();

    public void SequenceExpr_();

    public void SequenceExpr_(int initialCapacity);

    public void _SequenceExpr();

    public void PoundLineExpr();

    public void PoundLineExpr_();

    public void _PoundLineExpr();

    public void PoundFileExpr();

    public void PoundFileExpr_();

    public void _PoundFileExpr();

    public void PoundFunctionExpr();

    public void PoundFunctionExpr_();

    public void _PoundFunctionExpr();

    public void PoundDsohandleExpr();

    public void PoundDsohandleExpr_();

    public void _PoundDsohandleExpr();

    public void SymbolicReferenceExpr();

    public void SymbolicReferenceExpr_();

    public void _SymbolicReferenceExpr();

    public void PrefixOperatorExpr();

    public void PrefixOperatorExpr_();

    public void _PrefixOperatorExpr();

    public void BinaryOperatorExpr();

    public void BinaryOperatorExpr_();

    public void _BinaryOperatorExpr();

    public void ArrowExpr();

    public void ArrowExpr_();

    public void _ArrowExpr();

    public void Throws();

    public void Throws_();

    public void _Throws();

    public void TupleExpr();

    public void TupleExpr_();

    public void TupleExpr_(int initialCapacity);

    public void _TupleExpr();

    public void ArrayExpr();

    public void ArrayExpr_();

    public void ArrayExpr_(int initialCapacity);

    public void _ArrayExpr();

    public void DictionaryExpr();

    public void DictionaryExpr_();

    public void DictionaryExpr_(int initialCapacity);

    public void _DictionaryExpr();

    public void FunctionCallArgument();

    public void FunctionCallArgument_();

    public void _FunctionCallArgument();

    public void TupleElement();

    public void TupleElement_();

    public void _TupleElement();

    public void DictionaryElement();

    public void DictionaryElement_();

    public void _DictionaryElement();

    public void TernaryExpr();

    public void TernaryExpr_();

    public void _TernaryExpr();

    public void MemberAccessExpr();

    public void MemberAccessExpr_();

    public void _MemberAccessExpr();

    public void DotEnum();

    public void DotEnum(DotEnumEnum.Value value);

    public void DotEnum(String value);

    public void IsExpr();

    public void IsExpr_();

    public void _IsExpr();

    public void AsExpr();

    public void AsExpr_();

    public void _AsExpr();

    public void TypeExpr();

    public void TypeExpr_();

    public void _TypeExpr();

    public void ClosureCaptureItem();

    public void ClosureCaptureItem_();

    public void _ClosureCaptureItem();

    public void ClosureCaptureItemList();

    public void ClosureCaptureItemList_();

    public void ClosureCaptureItemList_(int initialCapacity);

    public void _ClosureCaptureItemList();

    public void WildcardMarker();

    public void WildcardMarker_();

    public void _WildcardMarker();

    public void ClosureParamList();

    public void ClosureParamList_();

    public void ClosureParamList_(int initialCapacity);

    public void _ClosureParamList();

    public void ClosureSignature();

    public void ClosureSignature_();

    public void _ClosureSignature();

    public void ClosureExpr();

    public void ClosureExpr_();

    public void _ClosureExpr();

    public void UnresolvedPatternExpr();

    public void UnresolvedPatternExpr_();

    public void _UnresolvedPatternExpr();

    public void FunctionCallExpr();

    public void FunctionCallExpr_();

    public void _FunctionCallExpr();

    public void SubscriptExpr();

    public void SubscriptExpr_();

    public void _SubscriptExpr();

    public void OptionalChainingExpr();

    public void OptionalChainingExpr_();

    public void _OptionalChainingExpr();

    public void ForcedValueExpr();

    public void ForcedValueExpr_();

    public void _ForcedValueExpr();

    public void PostfixUnaryExpr();

    public void PostfixUnaryExpr_();

    public void _PostfixUnaryExpr();

    public void SpecializeExpr();

    public void SpecializeExpr_();

    public void _SpecializeExpr();

    public void StringLiteralExpr();

    public void StringLiteralExpr_();

    public void _StringLiteralExpr();

    public void OpenQuoteEnum();

    public void OpenQuoteEnum(OpenQuoteEnumEnum.Value value);

    public void OpenQuoteEnum(String value);

    public void KeyPathExpr();

    public void KeyPathExpr_();

    public void _KeyPathExpr();

    public void KeyPathBaseExpr();

    public void KeyPathBaseExpr_();

    public void _KeyPathBaseExpr();

    public void ObjcKeyPathExpr();

    public void ObjcKeyPathExpr_();

    public void ObjcKeyPathExpr_(int initialCapacity);

    public void _ObjcKeyPathExpr();

    public void ObjcSelectorExpr();

    public void ObjcSelectorExpr_();

    public void _ObjcSelectorExpr();

    public void KindValue();

    public void KindValue(KindValueEnum.Value value);

    public void KindValue(String value);

    public void EditorPlaceholderExpr();

    public void EditorPlaceholderExpr_();

    public void _EditorPlaceholderExpr();

    public void ObjectLiteralExpr();

    public void ObjectLiteralExpr_();

    public void _ObjectLiteralExpr();

    public void PoundIdentifierEnum();

    public void PoundIdentifierEnum(PoundIdentifierEnumEnum.Value value);

    public void PoundIdentifierEnum(String value);

    public void TypealiasDecl();

    public void TypealiasDecl_();

    public void _TypealiasDecl();

    public void AssociatedtypeDecl();

    public void AssociatedtypeDecl_();

    public void _AssociatedtypeDecl();

    public void FunctionParameterList();

    public void FunctionParameterList_();

    public void FunctionParameterList_(int initialCapacity);

    public void _FunctionParameterList();

    public void FunctionSignature();

    public void FunctionSignature_();

    public void _FunctionSignature();

    public void ThrowsOrRethrowsKeywordEnum();

    public void ThrowsOrRethrowsKeywordEnum(ThrowsOrRethrowsKeywordEnumEnum.Value value);

    public void ThrowsOrRethrowsKeywordEnum(String value);

    public void IfConfigClause();

    public void IfConfigClause_();

    public void _IfConfigClause();

    public void PoundKeywordEnum();

    public void PoundKeywordEnum(PoundKeywordEnumEnum.Value value);

    public void PoundKeywordEnum(String value);

    public void SwitchCaseList();

    public void SwitchCaseList_();

    public void SwitchCaseList_(int initialCapacity);

    public void _SwitchCaseList();

    public void MemberDeclList();

    public void MemberDeclList_();

    public void MemberDeclList_(int initialCapacity);

    public void _MemberDeclList();

    public void IfConfigDecl();

    public void IfConfigDecl_();

    public void IfConfigDecl_(int initialCapacity);

    public void _IfConfigDecl();

    public void PoundErrorDecl();

    public void PoundErrorDecl_();

    public void _PoundErrorDecl();

    public void PoundWarningDecl();

    public void PoundWarningDecl_();

    public void _PoundWarningDecl();

    public void PoundSourceLocation();

    public void PoundSourceLocation_();

    public void _PoundSourceLocation();

    public void PoundSourceLocationArgs();

    public void PoundSourceLocationArgs_();

    public void _PoundSourceLocationArgs();

    public void DeclModifier();

    public void DeclModifier_();

    public void _DeclModifier();

    public void NameValue();

    public void NameValue(NameValueEnum.Value value);

    public void NameValue(String value);

    public void InheritedTypeList();

    public void InheritedTypeList_();

    public void InheritedTypeList_(int initialCapacity);

    public void _InheritedTypeList();

    public void ClassDecl();

    public void ClassDecl_();

    public void _ClassDecl();

    public void StructDecl();

    public void StructDecl_();

    public void _StructDecl();

    public void ProtocolDecl();

    public void ProtocolDecl_();

    public void _ProtocolDecl();

    public void ExtensionDecl();

    public void ExtensionDecl_();

    public void _ExtensionDecl();

    public void SourceFile();

    public void SourceFile_();

    public void _SourceFile();

    public void FunctionParameter();

    public void FunctionParameter_();

    public void _FunctionParameter();

    public void Ellipsis();

    public void Ellipsis_();

    public void _Ellipsis();

    public void ModifierList();

    public void ModifierList_();

    public void ModifierList_(int initialCapacity);

    public void _ModifierList();

    public void FunctionDecl();

    public void FunctionDecl_();

    public void _FunctionDecl();

    public void InitializerDecl();

    public void InitializerDecl_();

    public void _InitializerDecl();

    public void OptionalMarkEnum();

    public void OptionalMarkEnum(OptionalMarkEnumEnum.Value value);

    public void OptionalMarkEnum(String value);

    public void DeinitializerDecl();

    public void DeinitializerDecl_();

    public void _DeinitializerDecl();

    public void SubscriptDecl();

    public void SubscriptDecl_();

    public void _SubscriptDecl();

    public void AccessorBlock();

    public void AccessorBlock_();

    public void AccessorBlock_(int initialCapacity);

    public void _AccessorBlock();

    public void AccessLevelModifier();

    public void AccessLevelModifier_();

    public void _AccessLevelModifier();

    public void AccessPath();

    public void AccessPath_();

    public void AccessPath_(int initialCapacity);

    public void _AccessPath();

    public void ImportDecl();

    public void ImportDecl_();

    public void _ImportDecl();

    public void ImportKindEnum();

    public void ImportKindEnum(ImportKindEnumEnum.Value value);

    public void ImportKindEnum(String value);

    public void AccessorDecl();

    public void AccessorDecl_();

    public void _AccessorDecl();

    public void AccessorKindValue();

    public void AccessorKindValue(AccessorKindValueEnum.Value value);

    public void AccessorKindValue(String value);

    public void PatternBinding();

    public void PatternBinding_();

    public void _PatternBinding();

    public void PatternBindingList();

    public void PatternBindingList_();

    public void PatternBindingList_(int initialCapacity);

    public void _PatternBindingList();

    public void VariableDecl();

    public void VariableDecl_();

    public void _VariableDecl();

    public void LetOrVarKeywordEnum();

    public void LetOrVarKeywordEnum(LetOrVarKeywordEnumEnum.Value value);

    public void LetOrVarKeywordEnum(String value);

    public void EnumCaseElement();

    public void EnumCaseElement_();

    public void _EnumCaseElement();

    public void EnumCaseElementList();

    public void EnumCaseElementList_();

    public void EnumCaseElementList_(int initialCapacity);

    public void _EnumCaseElementList();

    public void EnumCaseDecl();

    public void EnumCaseDecl_();

    public void _EnumCaseDecl();

    public void EnumDecl();

    public void EnumDecl_();

    public void _EnumDecl();

    public void OperatorDecl();

    public void OperatorDecl_();

    public void _OperatorDecl();

    public void IdentifierList();

    public void IdentifierList_();

    public void IdentifierList_(int initialCapacity);

    public void _IdentifierList();

    public void PrecedenceGroupDecl();

    public void PrecedenceGroupDecl_();

    public void _PrecedenceGroupDecl();

    public void PrecedenceGroupAttributeList();

    public void PrecedenceGroupAttributeList_();

    public void PrecedenceGroupAttributeList_(int initialCapacity);

    public void _PrecedenceGroupAttributeList();

    public void PrecedenceGroupRelation();

    public void PrecedenceGroupRelation_();

    public void _PrecedenceGroupRelation();

    public void PrecedenceGroupAssignment();

    public void PrecedenceGroupAssignment_();

    public void _PrecedenceGroupAssignment();

    public void PrecedenceGroupAssociativity();

    public void PrecedenceGroupAssociativity_();

    public void _PrecedenceGroupAssociativity();

    public void HigherThanOrLowerThanValue();

    public void HigherThanOrLowerThanValue(HigherThanOrLowerThanValueEnum.Value value);

    public void HigherThanOrLowerThanValue(String value);

    public void PrecedenceGroupNameList();

    public void PrecedenceGroupNameList_();

    public void PrecedenceGroupNameList_(int initialCapacity);

    public void _PrecedenceGroupNameList();

    public void FlagEnum();

    public void FlagEnum(FlagEnumEnum.Value value);

    public void FlagEnum(String value);

    public void ValueValue();

    public void ValueValue(ValueValueEnum.Value value);

    public void ValueValue(String value);

    public void CustomAttribute();

    public void CustomAttribute_();

    public void _CustomAttribute();

    public void Attribute();

    public void Attribute_();

    public void _Attribute();

    public void AvailabilitySpecList();

    public void AvailabilitySpecList_();

    public void AvailabilitySpecList_(int initialCapacity);

    public void _AvailabilitySpecList();

    public void SpecializeAttributeSpecList();

    public void SpecializeAttributeSpecList_();

    public void SpecializeAttributeSpecList_(int initialCapacity);

    public void _SpecializeAttributeSpecList();

    public void ObjCSelector();

    public void ObjCSelector_();

    public void ObjCSelector_(int initialCapacity);

    public void _ObjCSelector();

    public void ImplementsAttributeArguments();

    public void ImplementsAttributeArguments_();

    public void _ImplementsAttributeArguments();

    public void NamedAttributeStringArgument();

    public void NamedAttributeStringArgument_();

    public void _NamedAttributeStringArgument();

    public void AttributeList();

    public void AttributeList_();

    public void AttributeList_(int initialCapacity);

    public void _AttributeList();

    public void LabeledSpecializeEntry();

    public void LabeledSpecializeEntry_();

    public void _LabeledSpecializeEntry();

    public void DeclName();

    public void DeclName_();

    public void _DeclName();

    public void ContinueStmt();

    public void ContinueStmt_();

    public void _ContinueStmt();

    public void WhileStmt();

    public void WhileStmt_();

    public void _WhileStmt();

    public void DeferStmt();

    public void DeferStmt_();

    public void _DeferStmt();

    public void SwitchCase();

    public void SwitchCase_();

    public void _SwitchCase();

    public void RepeatWhileStmt();

    public void RepeatWhileStmt_();

    public void _RepeatWhileStmt();

    public void GuardStmt();

    public void GuardStmt_();

    public void _GuardStmt();

    public void ForInStmt();

    public void ForInStmt_();

    public void _ForInStmt();

    public void Case();

    public void Case_();

    public void _Case();

    public void SwitchStmt();

    public void SwitchStmt_();

    public void _SwitchStmt();

    public void CatchClauseList();

    public void CatchClauseList_();

    public void CatchClauseList_(int initialCapacity);

    public void _CatchClauseList();

    public void DoStmt();

    public void DoStmt_();

    public void _DoStmt();

    public void ReturnStmt();

    public void ReturnStmt_();

    public void _ReturnStmt();

    public void YieldStmt();

    public void YieldStmt_();

    public void _YieldStmt();

    public void YieldList();

    public void YieldList_();

    public void YieldList_(int initialCapacity);

    public void _YieldList();

    public void FallthroughStmt();

    public void FallthroughStmt_();

    public void _FallthroughStmt();

    public void BreakStmt();

    public void BreakStmt_();

    public void _BreakStmt();

    public void AvailabilityCondition();

    public void AvailabilityCondition_();

    public void _AvailabilityCondition();

    public void MatchingPatternCondition();

    public void MatchingPatternCondition_();

    public void _MatchingPatternCondition();

    public void OptionalBindingCondition();

    public void OptionalBindingCondition_();

    public void _OptionalBindingCondition();

    public void ConditionElementList();

    public void ConditionElementList_();

    public void ConditionElementList_(int initialCapacity);

    public void _ConditionElementList();

    public void ThrowStmt();

    public void ThrowStmt_();

    public void _ThrowStmt();

    public void IfStmt();

    public void IfStmt_();

    public void _IfStmt();

    public void SwitchDefaultLabel();

    public void SwitchDefaultLabel_();

    public void _SwitchDefaultLabel();

    public void SwitchCaseLabel();

    public void SwitchCaseLabel_();

    public void SwitchCaseLabel_(int initialCapacity);

    public void _SwitchCaseLabel();

    public void CaseItem();

    public void CaseItem_();

    public void _CaseItem();

    public void CatchClause();

    public void CatchClause_();

    public void _CatchClause();

    public void PoundAssertStmt();

    public void PoundAssertStmt_();

    public void _PoundAssertStmt();

    public void GenericRequirementList();

    public void GenericRequirementList_();

    public void GenericRequirementList_(int initialCapacity);

    public void _GenericRequirementList();

    public void SameTypeRequirement();

    public void SameTypeRequirement_();

    public void _SameTypeRequirement();

    public void ConformanceRequirement();

    public void ConformanceRequirement_();

    public void _ConformanceRequirement();

    public void GenericParameterList();

    public void GenericParameterList_();

    public void GenericParameterList_(int initialCapacity);

    public void _GenericParameterList();

    public void GenericParameter();

    public void GenericParameter_();

    public void _GenericParameter();

    public void SimpleTypeIdentifier();

    public void SimpleTypeIdentifier_();

    public void _SimpleTypeIdentifier();

    public void NameEnum();

    public void NameEnum(NameEnumEnum.Value value);

    public void NameEnum(String value);

    public void MemberTypeIdentifier();

    public void MemberTypeIdentifier_();

    public void _MemberTypeIdentifier();

    public void PeriodEnum();

    public void PeriodEnum(PeriodEnumEnum.Value value);

    public void PeriodEnum(String value);

    public void ClassRestrictionType();

    public void ClassRestrictionType_();

    public void _ClassRestrictionType();

    public void ArrayType();

    public void ArrayType_();

    public void _ArrayType();

    public void DictionaryType();

    public void DictionaryType_();

    public void _DictionaryType();

    public void MetatypeType();

    public void MetatypeType_();

    public void _MetatypeType();

    public void TypeOrProtocolValue();

    public void TypeOrProtocolValue(TypeOrProtocolValueEnum.Value value);

    public void TypeOrProtocolValue(String value);

    public void OptionalType();

    public void OptionalType_();

    public void _OptionalType();

    public void SomeType();

    public void SomeType_();

    public void _SomeType();

    public void ImplicitlyUnwrappedOptionalType();

    public void ImplicitlyUnwrappedOptionalType_();

    public void _ImplicitlyUnwrappedOptionalType();

    public void CompositionTypeElement();

    public void CompositionTypeElement_();

    public void _CompositionTypeElement();

    public void Ampersand();

    public void Ampersand_();

    public void _Ampersand();

    public void CompositionType();

    public void CompositionType_();

    public void CompositionType_(int initialCapacity);

    public void _CompositionType();

    public void TupleTypeElement();

    public void TupleTypeElement_();

    public void _TupleTypeElement();

    public void Inout();

    public void Inout_();

    public void _Inout();

    public void TupleTypeElementList();

    public void TupleTypeElementList_();

    public void TupleTypeElementList_(int initialCapacity);

    public void _TupleTypeElementList();

    public void TupleType();

    public void TupleType_();

    public void _TupleType();

    public void FunctionType();

    public void FunctionType_();

    public void _FunctionType();

    public void AttributedType();

    public void AttributedType_();

    public void _AttributedType();

    public void SpecifierValue();

    public void SpecifierValue(SpecifierValueEnum.Value value);

    public void SpecifierValue(String value);

    public void GenericArgumentList();

    public void GenericArgumentList_();

    public void GenericArgumentList_(int initialCapacity);

    public void _GenericArgumentList();

    public void EnumCasePattern();

    public void EnumCasePattern_();

    public void _EnumCasePattern();

    public void IsTypePattern();

    public void IsTypePattern_();

    public void _IsTypePattern();

    public void OptionalPattern();

    public void OptionalPattern_();

    public void _OptionalPattern();

    public void IdentifierPattern();

    public void IdentifierPattern_();

    public void _IdentifierPattern();

    public void SelfMarker();

    public void SelfMarker_();

    public void _SelfMarker();

    public void AsTypePattern();

    public void AsTypePattern_();

    public void _AsTypePattern();

    public void WildcardPattern();

    public void WildcardPattern_();

    public void _WildcardPattern();

    public void TuplePatternElement();

    public void TuplePatternElement_();

    public void _TuplePatternElement();

    public void ExpressionPattern();

    public void ExpressionPattern_();

    public void _ExpressionPattern();

    public void TuplePatternElementList();

    public void TuplePatternElementList_();

    public void TuplePatternElementList_(int initialCapacity);

    public void _TuplePatternElementList();

    public void ValueBindingPattern();

    public void ValueBindingPattern_();

    public void _ValueBindingPattern();

    public void AvailabilityVersionRestriction();

    public void AvailabilityVersionRestriction_();

    public void _AvailabilityVersionRestriction();

    public void AvailabilityLabeledArgument();

    public void AvailabilityLabeledArgument_();

    public void _AvailabilityLabeledArgument();

    public void VersionTuple();

    public void VersionTuple_();

    public void _VersionTuple();

    public void CaptureSpecifierEnum();

    public void CaptureSpecifierEnum(CaptureSpecifierEnumEnum.Value value);

    public void CaptureSpecifierEnum(String value);
}
