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
package org.whole.lang.swiftsyntax.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.swiftsyntax.model.TokenKindEnum;
import org.whole.lang.swiftsyntax.model.SourcePresenceEnum;

/**
 *  @generator Whole
 */
public interface ISwiftSyntaxBuilder extends IBuilder {


    public void visit();

    public void patchVersion();

    public void patchPeriod();

    public void majorMinor();

    public void version();

    public void platform();

    public void entry();

    public void valuePattern();

    public void asKeyword();

    public void subPattern();

    public void isKeyword();

    public void associatedTuple();

    public void caseName();

    public void argumentType();

    public void inOut();

    public void someSpecifier();

    public void wrappedType();

    public void typeOrProtocol();

    public void valueType();

    public void keyType();

    public void rightSquareBracket();

    public void elementType();

    public void leftSquareBracket();

    public void baseType();

    public void rightAngleBracket();

    public void genericParameterList();

    public void leftAngleBracket();

    public void inheritedType();

    public void rightTypeIdentifier();

    public void equalityToken();

    public void leftTypeIdentifier();

    public void requirementList();

    public void poundAssert();

    public void catchKeyword();

    public void caseItems();

    public void defaultKeyword();

    public void unknownAttr();

    public void elseBody();

    public void ifKeyword();

    public void throwKeyword();

    public void availabilitySpec();

    public void poundAvailableKeyword();

    public void breakKeyword();

    public void fallthroughKeyword();

    public void yields();

    public void yieldKeyword();

    public void returnKeyword();

    public void catchClauses();

    public void doKeyword();

    public void cases();

    public void switchKeyword();

    public void whereClause();

    public void sequenceExpr();

    public void inKeyword();

    public void forKeyword();

    public void guardResult();

    public void whereKeyword();

    public void elseKeyword();

    public void guardKeyword();

    public void repeatKeyword();

    public void deferKeyword();

    public void conditions();

    public void whileKeyword();

    public void labelColon();

    public void labelName();

    public void continueKeyword();

    public void declBaseName();

    public void stringOrDeclname();

    public void nameTok();

    public void argument();

    public void attributeName();

    public void atSignToken();

    public void associativityKeyword();

    public void flag();

    public void assignmentKeyword();

    public void otherNames();

    public void higherThanOrLowerThan();

    public void groupAttributes();

    public void precedencegroupKeyword();

    public void precedenceGroupAndDesignatedTypes();

    public void operatorPrecedenceAndTypes();

    public void operatorKeyword();

    public void genericParameters();

    public void enumKeyword();

    public void caseKeyword();

    public void rawValue();

    public void associatedValue();

    public void bindings();

    public void letOrVarKeyword();

    public void typeAnnotation();

    public void accessors();

    public void parameter();

    public void accessorKind();

    public void path();

    public void importKind();

    public void importTok();

    public void trailingDot();

    public void modifier();

    public void accessor();

    public void result();

    public void indices();

    public void subscriptKeyword();

    public void deinitKeyword();

    public void parameters();

    public void optionalMark();

    public void initKeyword();

    public void body();

    public void funcKeyword();

    public void defaultArgument();

    public void ellipsis();

    public void secondName();

    public void firstName();

    public void eofToken();

    public void decl();

    public void extendedType();

    public void extensionKeyword();

    public void protocolKeyword();

    public void structKeyword();

    public void members();

    public void classKeyword();

    public void inheritedTypeCollection();

    public void detailRightParen();

    public void detail();

    public void detailLeftParen();

    public void lineNumber();

    public void lineArgColon();

    public void lineArgLabel();

    public void comma();

    public void fileName();

    public void fileArgColon();

    public void fileArgLabel();

    public void args();

    public void poundSourceLocation();

    public void poundWarning();

    public void message();

    public void poundError();

    public void poundEndif();

    public void clauses();

    public void condition();

    public void poundKeyword();

    public void throwsOrRethrowsKeyword();

    public void returnType();

    public void arrow();

    public void parameterList();

    public void inheritanceClause();

    public void associatedtypeKeyword();

    public void genericWhereClause();

    public void initializer();

    public void genericParameterClause();

    public void typealiasKeyword();

    public void modifiers();

    public void attributes();

    public void value();

    public void equal();

    public void poundSelector();

    public void keyPath();

    public void period();

    public void rootExpr();

    public void closeDelimiter();

    public void closeQuote();

    public void segments();

    public void openQuote();

    public void openDelimiter();

    public void expressions();

    public void delimiter();

    public void backslash();

    public void exclamationMark();

    public void rightBracket();

    public void leftBracket();

    public void trailingClosure();

    public void argumentList();

    public void calledExpression();

    public void pattern();

    public void signature();

    public void inTok();

    public void output();

    public void throwsTok();

    public void input();

    public void capture();

    public void items();

    public void specifier();

    public void type();

    public void asTok();

    public void typeName();

    public void isTok();

    public void dot();

    public void base();

    public void secondChoice();

    public void colonMark();

    public void firstChoice();

    public void questionMark();

    public void conditionExpression();

    public void booleanLiteral();

    public void digits();

    public void valueExpression();

    public void keyExpression();

    public void trailingComma();

    public void label();

    public void content();

    public void rightSquare();

    public void leftSquare();

    public void elementList();

    public void floatingDigits();

    public void arrowToken();

    public void throwsToken();

    public void postfixExpression();

    public void operatorToken();

    public void genericArgumentClause();

    public void poundDsohandle();

    public void poundFunction();

    public void poundFile();

    public void poundLine();

    public void elements();

    public void assignToken();

    public void wildcard();

    public void nilKeyword();

    public void superKeyword();

    public void declNameArguments();

    public void identifier();

    public void rightParen();

    public void arguments();

    public void leftParen();

    public void colon();

    public void name();

    public void questionOrExclamationMark();

    public void tryKeyword();

    public void poundColumn();

    public void expression();

    public void ampersand();

    public void rightBrace();

    public void statements();

    public void leftBrace();

    public void errorTokens();

    public void semicolon();

    public void item();

    public void text();

    public void trailingTrivia();

    public void leadingTrivia();

    public void presence();

    public void kind();

    public void Token();

    public void Token_();

    public void _Token();

    public void UnknownDecl();

    public void UnknownDecl_();

    public void UnknownDecl_(int initialCapacity);

    public void _UnknownDecl();

    public void UnknownExpr();

    public void UnknownExpr_();

    public void UnknownExpr_(int initialCapacity);

    public void _UnknownExpr();

    public void UnknownPattern();

    public void UnknownPattern_();

    public void UnknownPattern_(int initialCapacity);

    public void _UnknownPattern();

    public void UnknownStmt();

    public void UnknownStmt_();

    public void UnknownStmt_(int initialCapacity);

    public void _UnknownStmt();

    public void UnknownType();

    public void UnknownType_();

    public void UnknownType_(int initialCapacity);

    public void _UnknownType();

    public void CodeBlockItem();

    public void CodeBlockItem_();

    public void _CodeBlockItem();

    public void CodeBlockItemList();

    public void CodeBlockItemList_();

    public void CodeBlockItemList_(int initialCapacity);

    public void _CodeBlockItemList();

    public void CodeBlock();

    public void CodeBlock_();

    public void _CodeBlock();

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

    public void TupleElementList();

    public void TupleElementList_();

    public void TupleElementList_(int initialCapacity);

    public void _TupleElementList();

    public void ArrayElementList();

    public void ArrayElementList_();

    public void ArrayElementList_(int initialCapacity);

    public void _ArrayElementList();

    public void DictionaryElementList();

    public void DictionaryElementList_();

    public void DictionaryElementList_(int initialCapacity);

    public void _DictionaryElementList();

    public void StringLiteralSegments();

    public void StringLiteralSegments_();

    public void StringLiteralSegments_(int initialCapacity);

    public void _StringLiteralSegments();

    public void TryExpr();

    public void TryExpr_();

    public void _TryExpr();

    public void DeclNameArgument();

    public void DeclNameArgument_();

    public void _DeclNameArgument();

    public void DeclNameArgumentList();

    public void DeclNameArgumentList_();

    public void DeclNameArgumentList_(int initialCapacity);

    public void _DeclNameArgumentList();

    public void DeclNameArguments();

    public void DeclNameArguments_();

    public void _DeclNameArguments();

    public void IdentifierExpr();

    public void IdentifierExpr_();

    public void _IdentifierExpr();

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

    public void _SequenceExpr();

    public void ExprList();

    public void ExprList_();

    public void ExprList_(int initialCapacity);

    public void _ExprList();

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

    public void FloatLiteralExpr();

    public void FloatLiteralExpr_();

    public void _FloatLiteralExpr();

    public void TupleExpr();

    public void TupleExpr_();

    public void _TupleExpr();

    public void ArrayExpr();

    public void ArrayExpr_();

    public void _ArrayExpr();

    public void DictionaryExpr();

    public void DictionaryExpr_();

    public void _DictionaryExpr();

    public void FunctionCallArgument();

    public void FunctionCallArgument_();

    public void _FunctionCallArgument();

    public void TupleElement();

    public void TupleElement_();

    public void _TupleElement();

    public void ArrayElement();

    public void ArrayElement_();

    public void _ArrayElement();

    public void DictionaryElement();

    public void DictionaryElement_();

    public void _DictionaryElement();

    public void IntegerLiteralExpr();

    public void IntegerLiteralExpr_();

    public void _IntegerLiteralExpr();

    public void BooleanLiteralExpr();

    public void BooleanLiteralExpr_();

    public void _BooleanLiteralExpr();

    public void TernaryExpr();

    public void TernaryExpr_();

    public void _TernaryExpr();

    public void MemberAccessExpr();

    public void MemberAccessExpr_();

    public void _MemberAccessExpr();

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

    public void ClosureCaptureSignature();

    public void ClosureCaptureSignature_();

    public void _ClosureCaptureSignature();

    public void ClosureParam();

    public void ClosureParam_();

    public void _ClosureParam();

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

    public void StringSegment();

    public void StringSegment_();

    public void _StringSegment();

    public void ExpressionSegment();

    public void ExpressionSegment_();

    public void _ExpressionSegment();

    public void StringLiteralExpr();

    public void StringLiteralExpr_();

    public void _StringLiteralExpr();

    public void KeyPathExpr();

    public void KeyPathExpr_();

    public void _KeyPathExpr();

    public void KeyPathBaseExpr();

    public void KeyPathBaseExpr_();

    public void _KeyPathBaseExpr();

    public void ObjcNamePiece();

    public void ObjcNamePiece_();

    public void _ObjcNamePiece();

    public void ObjcName();

    public void ObjcName_();

    public void ObjcName_(int initialCapacity);

    public void _ObjcName();

    public void ObjcKeyPathExpr();

    public void ObjcKeyPathExpr_();

    public void _ObjcKeyPathExpr();

    public void ObjcSelectorExpr();

    public void ObjcSelectorExpr_();

    public void _ObjcSelectorExpr();

    public void EditorPlaceholderExpr();

    public void EditorPlaceholderExpr_();

    public void _EditorPlaceholderExpr();

    public void ObjectLiteralExpr();

    public void ObjectLiteralExpr_();

    public void _ObjectLiteralExpr();

    public void TypeInitializerClause();

    public void TypeInitializerClause_();

    public void _TypeInitializerClause();

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

    public void ParameterClause();

    public void ParameterClause_();

    public void _ParameterClause();

    public void ReturnClause();

    public void ReturnClause_();

    public void _ReturnClause();

    public void FunctionSignature();

    public void FunctionSignature_();

    public void _FunctionSignature();

    public void IfConfigClause();

    public void IfConfigClause_();

    public void _IfConfigClause();

    public void IfConfigClauseList();

    public void IfConfigClauseList_();

    public void IfConfigClauseList_(int initialCapacity);

    public void _IfConfigClauseList();

    public void IfConfigDecl();

    public void IfConfigDecl_();

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

    public void InheritedType();

    public void InheritedType_();

    public void _InheritedType();

    public void InheritedTypeList();

    public void InheritedTypeList_();

    public void InheritedTypeList_(int initialCapacity);

    public void _InheritedTypeList();

    public void TypeInheritanceClause();

    public void TypeInheritanceClause_();

    public void _TypeInheritanceClause();

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

    public void MemberDeclBlock();

    public void MemberDeclBlock_();

    public void _MemberDeclBlock();

    public void MemberDeclList();

    public void MemberDeclList_();

    public void MemberDeclList_(int initialCapacity);

    public void _MemberDeclList();

    public void MemberDeclListItem();

    public void MemberDeclListItem_();

    public void _MemberDeclListItem();

    public void SourceFile();

    public void SourceFile_();

    public void _SourceFile();

    public void InitializerClause();

    public void InitializerClause_();

    public void _InitializerClause();

    public void FunctionParameter();

    public void FunctionParameter_();

    public void _FunctionParameter();

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

    public void DeinitializerDecl();

    public void DeinitializerDecl_();

    public void _DeinitializerDecl();

    public void SubscriptDecl();

    public void SubscriptDecl_();

    public void _SubscriptDecl();

    public void AccessLevelModifier();

    public void AccessLevelModifier_();

    public void _AccessLevelModifier();

    public void AccessPathComponent();

    public void AccessPathComponent_();

    public void _AccessPathComponent();

    public void AccessPath();

    public void AccessPath_();

    public void AccessPath_(int initialCapacity);

    public void _AccessPath();

    public void ImportDecl();

    public void ImportDecl_();

    public void _ImportDecl();

    public void AccessorParameter();

    public void AccessorParameter_();

    public void _AccessorParameter();

    public void AccessorDecl();

    public void AccessorDecl_();

    public void _AccessorDecl();

    public void AccessorList();

    public void AccessorList_();

    public void AccessorList_(int initialCapacity);

    public void _AccessorList();

    public void AccessorBlock();

    public void AccessorBlock_();

    public void _AccessorBlock();

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

    public void OperatorPrecedenceAndTypes();

    public void OperatorPrecedenceAndTypes_();

    public void _OperatorPrecedenceAndTypes();

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

    public void PrecedenceGroupNameList();

    public void PrecedenceGroupNameList_();

    public void PrecedenceGroupNameList_(int initialCapacity);

    public void _PrecedenceGroupNameList();

    public void PrecedenceGroupNameElement();

    public void PrecedenceGroupNameElement_();

    public void _PrecedenceGroupNameElement();

    public void PrecedenceGroupAssignment();

    public void PrecedenceGroupAssignment_();

    public void _PrecedenceGroupAssignment();

    public void PrecedenceGroupAssociativity();

    public void PrecedenceGroupAssociativity_();

    public void _PrecedenceGroupAssociativity();

    public void TokenList();

    public void TokenList_();

    public void TokenList_(int initialCapacity);

    public void _TokenList();

    public void CustomAttribute();

    public void CustomAttribute_();

    public void _CustomAttribute();

    public void Attribute();

    public void Attribute_();

    public void _Attribute();

    public void AttributeList();

    public void AttributeList_();

    public void AttributeList_(int initialCapacity);

    public void _AttributeList();

    public void SpecializeAttributeSpecList();

    public void SpecializeAttributeSpecList_();

    public void SpecializeAttributeSpecList_(int initialCapacity);

    public void _SpecializeAttributeSpecList();

    public void LabeledSpecializeEntry();

    public void LabeledSpecializeEntry_();

    public void _LabeledSpecializeEntry();

    public void NamedAttributeStringArgument();

    public void NamedAttributeStringArgument_();

    public void _NamedAttributeStringArgument();

    public void DeclName();

    public void DeclName_();

    public void _DeclName();

    public void ImplementsAttributeArguments();

    public void ImplementsAttributeArguments_();

    public void _ImplementsAttributeArguments();

    public void ObjCSelectorPiece();

    public void ObjCSelectorPiece_();

    public void _ObjCSelectorPiece();

    public void ObjCSelector();

    public void ObjCSelector_();

    public void ObjCSelector_(int initialCapacity);

    public void _ObjCSelector();

    public void ContinueStmt();

    public void ContinueStmt_();

    public void _ContinueStmt();

    public void WhileStmt();

    public void WhileStmt_();

    public void _WhileStmt();

    public void DeferStmt();

    public void DeferStmt_();

    public void _DeferStmt();

    public void SwitchCaseList();

    public void SwitchCaseList_();

    public void SwitchCaseList_(int initialCapacity);

    public void _SwitchCaseList();

    public void RepeatWhileStmt();

    public void RepeatWhileStmt_();

    public void _RepeatWhileStmt();

    public void GuardStmt();

    public void GuardStmt_();

    public void _GuardStmt();

    public void WhereClause();

    public void WhereClause_();

    public void _WhereClause();

    public void ForInStmt();

    public void ForInStmt_();

    public void _ForInStmt();

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

    public void _YieldList();

    public void FallthroughStmt();

    public void FallthroughStmt_();

    public void _FallthroughStmt();

    public void BreakStmt();

    public void BreakStmt_();

    public void _BreakStmt();

    public void CaseItemList();

    public void CaseItemList_();

    public void CaseItemList_(int initialCapacity);

    public void _CaseItemList();

    public void ConditionElement();

    public void ConditionElement_();

    public void _ConditionElement();

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

    public void SwitchCase();

    public void SwitchCase_();

    public void _SwitchCase();

    public void SwitchDefaultLabel();

    public void SwitchDefaultLabel_();

    public void _SwitchDefaultLabel();

    public void CaseItem();

    public void CaseItem_();

    public void _CaseItem();

    public void SwitchCaseLabel();

    public void SwitchCaseLabel_();

    public void _SwitchCaseLabel();

    public void CatchClause();

    public void CatchClause_();

    public void _CatchClause();

    public void PoundAssertStmt();

    public void PoundAssertStmt_();

    public void _PoundAssertStmt();

    public void GenericWhereClause();

    public void GenericWhereClause_();

    public void _GenericWhereClause();

    public void GenericRequirementList();

    public void GenericRequirementList_();

    public void GenericRequirementList_(int initialCapacity);

    public void _GenericRequirementList();

    public void SameTypeRequirement();

    public void SameTypeRequirement_();

    public void _SameTypeRequirement();

    public void GenericParameterList();

    public void GenericParameterList_();

    public void GenericParameterList_(int initialCapacity);

    public void _GenericParameterList();

    public void GenericParameter();

    public void GenericParameter_();

    public void _GenericParameter();

    public void GenericParameterClause();

    public void GenericParameterClause_();

    public void _GenericParameterClause();

    public void ConformanceRequirement();

    public void ConformanceRequirement_();

    public void _ConformanceRequirement();

    public void SimpleTypeIdentifier();

    public void SimpleTypeIdentifier_();

    public void _SimpleTypeIdentifier();

    public void MemberTypeIdentifier();

    public void MemberTypeIdentifier_();

    public void _MemberTypeIdentifier();

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

    public void CompositionTypeElementList();

    public void CompositionTypeElementList_();

    public void CompositionTypeElementList_(int initialCapacity);

    public void _CompositionTypeElementList();

    public void CompositionType();

    public void CompositionType_();

    public void _CompositionType();

    public void TupleTypeElement();

    public void TupleTypeElement_();

    public void _TupleTypeElement();

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

    public void GenericArgumentList();

    public void GenericArgumentList_();

    public void GenericArgumentList_(int initialCapacity);

    public void _GenericArgumentList();

    public void GenericArgument();

    public void GenericArgument_();

    public void _GenericArgument();

    public void GenericArgumentClause();

    public void GenericArgumentClause_();

    public void _GenericArgumentClause();

    public void TypeAnnotation();

    public void TypeAnnotation_();

    public void _TypeAnnotation();

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

    public void AsTypePattern();

    public void AsTypePattern_();

    public void _AsTypePattern();

    public void TuplePattern();

    public void TuplePattern_();

    public void _TuplePattern();

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

    public void AvailabilitySpecList();

    public void AvailabilitySpecList_();

    public void AvailabilitySpecList_(int initialCapacity);

    public void _AvailabilitySpecList();

    public void AvailabilityArgument();

    public void AvailabilityArgument_();

    public void _AvailabilityArgument();

    public void AvailabilityLabeledArgument();

    public void AvailabilityLabeledArgument_();

    public void _AvailabilityLabeledArgument();

    public void AvailabilityVersionRestriction();

    public void AvailabilityVersionRestriction_();

    public void _AvailabilityVersionRestriction();

    public void VersionTuple();

    public void VersionTuple_();

    public void _VersionTuple();

    public void TokenKind();

    public void TokenKind(TokenKindEnum.Value value);

    public void TokenKind(String value);

    public void Text();

    public void Text(String value);

    public void Trivia();

    public void Trivia_();

    public void Trivia_(int initialCapacity);

    public void _Trivia();

    public void TriviaPiece();

    public void TriviaPiece(String value);

    public void SourcePresence();

    public void SourcePresence(SourcePresenceEnum.Value value);

    public void SourcePresence(String value);
}
