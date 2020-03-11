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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.swiftsyntax.model.TokenKindEnum.Value;

/**
 *  @generator Whole
 */
public class SwiftSyntaxGenericBuilderAdapter extends GenericIdentityBuilder {
    private ISwiftSyntaxBuilder specificBuilder;

    public SwiftSyntaxGenericBuilderAdapter(ISwiftSyntaxBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public SwiftSyntaxGenericBuilderAdapter(ISwiftSyntaxBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case SwiftSyntaxFeatureDescriptorEnum.kind_ord :
            specificBuilder.kind();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.presence_ord :
            specificBuilder.presence();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leadingTrivia_ord :
            specificBuilder.leadingTrivia();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.trailingTrivia_ord :
            specificBuilder.trailingTrivia();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.text_ord :
            specificBuilder.text();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.item_ord :
            specificBuilder.item();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.semicolon_ord :
            specificBuilder.semicolon();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.errorTokens_ord :
            specificBuilder.errorTokens();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leftBrace_ord :
            specificBuilder.leftBrace();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.statements_ord :
            specificBuilder.statements();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rightBrace_ord :
            specificBuilder.rightBrace();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.ampersand_ord :
            specificBuilder.ampersand();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.expression_ord :
            specificBuilder.expression();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundColumn_ord :
            specificBuilder.poundColumn();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.tryKeyword_ord :
            specificBuilder.tryKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.questionOrExclamationMark_ord :
            specificBuilder.questionOrExclamationMark();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.colon_ord :
            specificBuilder.colon();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leftParen_ord :
            specificBuilder.leftParen();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.arguments_ord :
            specificBuilder.arguments();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rightParen_ord :
            specificBuilder.rightParen();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.identifier_ord :
            specificBuilder.identifier();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.declNameArguments_ord :
            specificBuilder.declNameArguments();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.superKeyword_ord :
            specificBuilder.superKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.nilKeyword_ord :
            specificBuilder.nilKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.wildcard_ord :
            specificBuilder.wildcard();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.assignToken_ord :
            specificBuilder.assignToken();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.elements_ord :
            specificBuilder.elements();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundLine_ord :
            specificBuilder.poundLine();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundFile_ord :
            specificBuilder.poundFile();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundFunction_ord :
            specificBuilder.poundFunction();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundDsohandle_ord :
            specificBuilder.poundDsohandle();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause_ord :
            specificBuilder.genericArgumentClause();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.operatorToken_ord :
            specificBuilder.operatorToken();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.postfixExpression_ord :
            specificBuilder.postfixExpression();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.throwsToken_ord :
            specificBuilder.throwsToken();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.arrowToken_ord :
            specificBuilder.arrowToken();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.floatingDigits_ord :
            specificBuilder.floatingDigits();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.elementList_ord :
            specificBuilder.elementList();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leftSquare_ord :
            specificBuilder.leftSquare();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rightSquare_ord :
            specificBuilder.rightSquare();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.content_ord :
            specificBuilder.content();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.label_ord :
            specificBuilder.label();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.trailingComma_ord :
            specificBuilder.trailingComma();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.keyExpression_ord :
            specificBuilder.keyExpression();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.valueExpression_ord :
            specificBuilder.valueExpression();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.digits_ord :
            specificBuilder.digits();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.booleanLiteral_ord :
            specificBuilder.booleanLiteral();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.conditionExpression_ord :
            specificBuilder.conditionExpression();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.questionMark_ord :
            specificBuilder.questionMark();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.firstChoice_ord :
            specificBuilder.firstChoice();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.colonMark_ord :
            specificBuilder.colonMark();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.secondChoice_ord :
            specificBuilder.secondChoice();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.base_ord :
            specificBuilder.base();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.dot_ord :
            specificBuilder.dot();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.isTok_ord :
            specificBuilder.isTok();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.typeName_ord :
            specificBuilder.typeName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.asTok_ord :
            specificBuilder.asTok();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.type_ord :
            specificBuilder.type();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.specifier_ord :
            specificBuilder.specifier();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.items_ord :
            specificBuilder.items();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.capture_ord :
            specificBuilder.capture();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.input_ord :
            specificBuilder.input();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.throwsTok_ord :
            specificBuilder.throwsTok();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.output_ord :
            specificBuilder.output();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.inTok_ord :
            specificBuilder.inTok();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.signature_ord :
            specificBuilder.signature();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.pattern_ord :
            specificBuilder.pattern();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.calledExpression_ord :
            specificBuilder.calledExpression();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.argumentList_ord :
            specificBuilder.argumentList();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.trailingClosure_ord :
            specificBuilder.trailingClosure();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leftBracket_ord :
            specificBuilder.leftBracket();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rightBracket_ord :
            specificBuilder.rightBracket();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.exclamationMark_ord :
            specificBuilder.exclamationMark();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.backslash_ord :
            specificBuilder.backslash();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.delimiter_ord :
            specificBuilder.delimiter();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.expressions_ord :
            specificBuilder.expressions();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.openDelimiter_ord :
            specificBuilder.openDelimiter();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.openQuote_ord :
            specificBuilder.openQuote();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.segments_ord :
            specificBuilder.segments();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.closeQuote_ord :
            specificBuilder.closeQuote();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.closeDelimiter_ord :
            specificBuilder.closeDelimiter();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rootExpr_ord :
            specificBuilder.rootExpr();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.period_ord :
            specificBuilder.period();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.keyPath_ord :
            specificBuilder.keyPath();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundSelector_ord :
            specificBuilder.poundSelector();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.equal_ord :
            specificBuilder.equal();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.value_ord :
            specificBuilder.value();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.attributes_ord :
            specificBuilder.attributes();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.modifiers_ord :
            specificBuilder.modifiers();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.typealiasKeyword_ord :
            specificBuilder.typealiasKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.genericParameterClause_ord :
            specificBuilder.genericParameterClause();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.initializer_ord :
            specificBuilder.initializer();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.genericWhereClause_ord :
            specificBuilder.genericWhereClause();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.associatedtypeKeyword_ord :
            specificBuilder.associatedtypeKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.inheritanceClause_ord :
            specificBuilder.inheritanceClause();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.parameterList_ord :
            specificBuilder.parameterList();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.arrow_ord :
            specificBuilder.arrow();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.returnType_ord :
            specificBuilder.returnType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword_ord :
            specificBuilder.throwsOrRethrowsKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundKeyword_ord :
            specificBuilder.poundKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.condition_ord :
            specificBuilder.condition();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.clauses_ord :
            specificBuilder.clauses();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundEndif_ord :
            specificBuilder.poundEndif();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundError_ord :
            specificBuilder.poundError();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.message_ord :
            specificBuilder.message();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundWarning_ord :
            specificBuilder.poundWarning();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundSourceLocation_ord :
            specificBuilder.poundSourceLocation();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.args_ord :
            specificBuilder.args();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.fileArgLabel_ord :
            specificBuilder.fileArgLabel();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.fileArgColon_ord :
            specificBuilder.fileArgColon();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.fileName_ord :
            specificBuilder.fileName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.comma_ord :
            specificBuilder.comma();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.lineArgLabel_ord :
            specificBuilder.lineArgLabel();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.lineArgColon_ord :
            specificBuilder.lineArgColon();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.lineNumber_ord :
            specificBuilder.lineNumber();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.detailLeftParen_ord :
            specificBuilder.detailLeftParen();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.detail_ord :
            specificBuilder.detail();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.detailRightParen_ord :
            specificBuilder.detailRightParen();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.inheritedTypeCollection_ord :
            specificBuilder.inheritedTypeCollection();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.classKeyword_ord :
            specificBuilder.classKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.members_ord :
            specificBuilder.members();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.structKeyword_ord :
            specificBuilder.structKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.protocolKeyword_ord :
            specificBuilder.protocolKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.extensionKeyword_ord :
            specificBuilder.extensionKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.extendedType_ord :
            specificBuilder.extendedType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.decl_ord :
            specificBuilder.decl();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.eofToken_ord :
            specificBuilder.eofToken();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.firstName_ord :
            specificBuilder.firstName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.secondName_ord :
            specificBuilder.secondName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.ellipsis_ord :
            specificBuilder.ellipsis();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.defaultArgument_ord :
            specificBuilder.defaultArgument();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.funcKeyword_ord :
            specificBuilder.funcKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.body_ord :
            specificBuilder.body();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.initKeyword_ord :
            specificBuilder.initKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.optionalMark_ord :
            specificBuilder.optionalMark();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.parameters_ord :
            specificBuilder.parameters();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.deinitKeyword_ord :
            specificBuilder.deinitKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.subscriptKeyword_ord :
            specificBuilder.subscriptKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.indices_ord :
            specificBuilder.indices();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.result_ord :
            specificBuilder.result();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.accessor_ord :
            specificBuilder.accessor();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.modifier_ord :
            specificBuilder.modifier();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.trailingDot_ord :
            specificBuilder.trailingDot();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.importTok_ord :
            specificBuilder.importTok();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.importKind_ord :
            specificBuilder.importKind();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.path_ord :
            specificBuilder.path();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.accessorKind_ord :
            specificBuilder.accessorKind();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.parameter_ord :
            specificBuilder.parameter();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.accessors_ord :
            specificBuilder.accessors();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.typeAnnotation_ord :
            specificBuilder.typeAnnotation();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.letOrVarKeyword_ord :
            specificBuilder.letOrVarKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.bindings_ord :
            specificBuilder.bindings();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.associatedValue_ord :
            specificBuilder.associatedValue();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rawValue_ord :
            specificBuilder.rawValue();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.caseKeyword_ord :
            specificBuilder.caseKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.enumKeyword_ord :
            specificBuilder.enumKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.genericParameters_ord :
            specificBuilder.genericParameters();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.operatorKeyword_ord :
            specificBuilder.operatorKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.operatorPrecedenceAndTypes_ord :
            specificBuilder.operatorPrecedenceAndTypes();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.precedenceGroupAndDesignatedTypes_ord :
            specificBuilder.precedenceGroupAndDesignatedTypes();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword_ord :
            specificBuilder.precedencegroupKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.groupAttributes_ord :
            specificBuilder.groupAttributes();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.higherThanOrLowerThan_ord :
            specificBuilder.higherThanOrLowerThan();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.otherNames_ord :
            specificBuilder.otherNames();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.assignmentKeyword_ord :
            specificBuilder.assignmentKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.flag_ord :
            specificBuilder.flag();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.associativityKeyword_ord :
            specificBuilder.associativityKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.atSignToken_ord :
            specificBuilder.atSignToken();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.attributeName_ord :
            specificBuilder.attributeName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.argument_ord :
            specificBuilder.argument();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.nameTok_ord :
            specificBuilder.nameTok();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.stringOrDeclname_ord :
            specificBuilder.stringOrDeclname();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.declBaseName_ord :
            specificBuilder.declBaseName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.continueKeyword_ord :
            specificBuilder.continueKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.labelName_ord :
            specificBuilder.labelName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.labelColon_ord :
            specificBuilder.labelColon();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.whileKeyword_ord :
            specificBuilder.whileKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.conditions_ord :
            specificBuilder.conditions();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.deferKeyword_ord :
            specificBuilder.deferKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.repeatKeyword_ord :
            specificBuilder.repeatKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.guardKeyword_ord :
            specificBuilder.guardKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.elseKeyword_ord :
            specificBuilder.elseKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.whereKeyword_ord :
            specificBuilder.whereKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.guardResult_ord :
            specificBuilder.guardResult();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.forKeyword_ord :
            specificBuilder.forKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.inKeyword_ord :
            specificBuilder.inKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.sequenceExpr_ord :
            specificBuilder.sequenceExpr();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.whereClause_ord :
            specificBuilder.whereClause();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.switchKeyword_ord :
            specificBuilder.switchKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.cases_ord :
            specificBuilder.cases();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.doKeyword_ord :
            specificBuilder.doKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.catchClauses_ord :
            specificBuilder.catchClauses();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.returnKeyword_ord :
            specificBuilder.returnKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.yieldKeyword_ord :
            specificBuilder.yieldKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.yields_ord :
            specificBuilder.yields();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.fallthroughKeyword_ord :
            specificBuilder.fallthroughKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.breakKeyword_ord :
            specificBuilder.breakKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundAvailableKeyword_ord :
            specificBuilder.poundAvailableKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.availabilitySpec_ord :
            specificBuilder.availabilitySpec();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.throwKeyword_ord :
            specificBuilder.throwKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.ifKeyword_ord :
            specificBuilder.ifKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.elseBody_ord :
            specificBuilder.elseBody();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.unknownAttr_ord :
            specificBuilder.unknownAttr();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.defaultKeyword_ord :
            specificBuilder.defaultKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.caseItems_ord :
            specificBuilder.caseItems();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.catchKeyword_ord :
            specificBuilder.catchKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.poundAssert_ord :
            specificBuilder.poundAssert();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.requirementList_ord :
            specificBuilder.requirementList();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leftTypeIdentifier_ord :
            specificBuilder.leftTypeIdentifier();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.equalityToken_ord :
            specificBuilder.equalityToken();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rightTypeIdentifier_ord :
            specificBuilder.rightTypeIdentifier();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.inheritedType_ord :
            specificBuilder.inheritedType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leftAngleBracket_ord :
            specificBuilder.leftAngleBracket();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.genericParameterList_ord :
            specificBuilder.genericParameterList();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rightAngleBracket_ord :
            specificBuilder.rightAngleBracket();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.baseType_ord :
            specificBuilder.baseType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.leftSquareBracket_ord :
            specificBuilder.leftSquareBracket();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.elementType_ord :
            specificBuilder.elementType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.rightSquareBracket_ord :
            specificBuilder.rightSquareBracket();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.keyType_ord :
            specificBuilder.keyType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.valueType_ord :
            specificBuilder.valueType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.typeOrProtocol_ord :
            specificBuilder.typeOrProtocol();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.wrappedType_ord :
            specificBuilder.wrappedType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.someSpecifier_ord :
            specificBuilder.someSpecifier();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.inOut_ord :
            specificBuilder.inOut();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.argumentType_ord :
            specificBuilder.argumentType();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.caseName_ord :
            specificBuilder.caseName();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.associatedTuple_ord :
            specificBuilder.associatedTuple();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.isKeyword_ord :
            specificBuilder.isKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.subPattern_ord :
            specificBuilder.subPattern();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.asKeyword_ord :
            specificBuilder.asKeyword();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.valuePattern_ord :
            specificBuilder.valuePattern();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.entry_ord :
            specificBuilder.entry();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.platform_ord :
            specificBuilder.platform();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.version_ord :
            specificBuilder.version();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.majorMinor_ord :
            specificBuilder.majorMinor();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.patchPeriod_ord :
            specificBuilder.patchPeriod();
            break;
            case SwiftSyntaxFeatureDescriptorEnum.patchVersion_ord :
            specificBuilder.patchVersion();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SwiftSyntaxEntityDescriptorEnum.Token_ord :
            specificBuilder.Token();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownDecl_ord :
            specificBuilder.UnknownDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownExpr_ord :
            specificBuilder.UnknownExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownPattern_ord :
            specificBuilder.UnknownPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownStmt_ord :
            specificBuilder.UnknownStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownType_ord :
            specificBuilder.UnknownType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItem_ord :
            specificBuilder.CodeBlockItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder.CodeBlockItemList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlock_ord :
            specificBuilder.CodeBlock();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InOutExpr_ord :
            specificBuilder.InOutExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr_ord :
            specificBuilder.PoundColumnExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder.FunctionCallArgumentList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElementList_ord :
            specificBuilder.TupleElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElementList_ord :
            specificBuilder.ArrayElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElementList_ord :
            specificBuilder.DictionaryElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder.StringLiteralSegments();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TryExpr_ord :
            specificBuilder.TryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgument_ord :
            specificBuilder.DeclNameArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder.DeclNameArgumentList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArguments_ord :
            specificBuilder.DeclNameArguments();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierExpr_ord :
            specificBuilder.IdentifierExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SuperRefExpr_ord :
            specificBuilder.SuperRefExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr_ord :
            specificBuilder.NilLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            specificBuilder.DiscardAssignmentExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssignmentExpr_ord :
            specificBuilder.AssignmentExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SequenceExpr_ord :
            specificBuilder.SequenceExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExprList_ord :
            specificBuilder.ExprList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundLineExpr_ord :
            specificBuilder.PoundLineExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFileExpr_ord :
            specificBuilder.PoundFileExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr_ord :
            specificBuilder.PoundFunctionExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr_ord :
            specificBuilder.PoundDsohandleExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            specificBuilder.SymbolicReferenceExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr_ord :
            specificBuilder.PrefixOperatorExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr_ord :
            specificBuilder.BinaryOperatorExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrowExpr_ord :
            specificBuilder.ArrowExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr_ord :
            specificBuilder.FloatLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleExpr_ord :
            specificBuilder.TupleExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayExpr_ord :
            specificBuilder.ArrayExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryExpr_ord :
            specificBuilder.DictionaryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument_ord :
            specificBuilder.FunctionCallArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElement_ord :
            specificBuilder.TupleElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElement_ord :
            specificBuilder.ArrayElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElement_ord :
            specificBuilder.DictionaryElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr_ord :
            specificBuilder.IntegerLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr_ord :
            specificBuilder.BooleanLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TernaryExpr_ord :
            specificBuilder.TernaryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr_ord :
            specificBuilder.MemberAccessExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsExpr_ord :
            specificBuilder.IsExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsExpr_ord :
            specificBuilder.AsExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeExpr_ord :
            specificBuilder.TypeExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem_ord :
            specificBuilder.ClosureCaptureItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder.ClosureCaptureItemList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature_ord :
            specificBuilder.ClosureCaptureSignature();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParam_ord :
            specificBuilder.ClosureParam();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder.ClosureParamList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureSignature_ord :
            specificBuilder.ClosureSignature();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureExpr_ord :
            specificBuilder.ClosureExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            specificBuilder.UnresolvedPatternExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr_ord :
            specificBuilder.FunctionCallExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptExpr_ord :
            specificBuilder.SubscriptExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr_ord :
            specificBuilder.OptionalChainingExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr_ord :
            specificBuilder.ForcedValueExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr_ord :
            specificBuilder.PostfixUnaryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeExpr_ord :
            specificBuilder.SpecializeExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringSegment_ord :
            specificBuilder.StringSegment();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionSegment_ord :
            specificBuilder.ExpressionSegment();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr_ord :
            specificBuilder.StringLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathExpr_ord :
            specificBuilder.KeyPathExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr_ord :
            specificBuilder.KeyPathBaseExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece_ord :
            specificBuilder.ObjcNamePiece();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcName_ord :
            specificBuilder.ObjcName();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            specificBuilder.ObjcKeyPathExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr_ord :
            specificBuilder.ObjcSelectorExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            specificBuilder.EditorPlaceholderExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr_ord :
            specificBuilder.ObjectLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause_ord :
            specificBuilder.TypeInitializerClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypealiasDecl_ord :
            specificBuilder.TypealiasDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl_ord :
            specificBuilder.AssociatedtypeDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder.FunctionParameterList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ParameterClause_ord :
            specificBuilder.ParameterClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnClause_ord :
            specificBuilder.ReturnClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionSignature_ord :
            specificBuilder.FunctionSignature();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClause_ord :
            specificBuilder.IfConfigClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList_ord :
            specificBuilder.IfConfigClauseList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigDecl_ord :
            specificBuilder.IfConfigDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl_ord :
            specificBuilder.PoundErrorDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl_ord :
            specificBuilder.PoundWarningDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation_ord :
            specificBuilder.PoundSourceLocation();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            specificBuilder.PoundSourceLocationArgs();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclModifier_ord :
            specificBuilder.DeclModifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedType_ord :
            specificBuilder.InheritedType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder.InheritedTypeList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause_ord :
            specificBuilder.TypeInheritanceClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassDecl_ord :
            specificBuilder.ClassDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StructDecl_ord :
            specificBuilder.StructDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ProtocolDecl_ord :
            specificBuilder.ProtocolDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExtensionDecl_ord :
            specificBuilder.ExtensionDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock_ord :
            specificBuilder.MemberDeclBlock();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder.MemberDeclList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem_ord :
            specificBuilder.MemberDeclListItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SourceFile_ord :
            specificBuilder.SourceFile();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerClause_ord :
            specificBuilder.InitializerClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameter_ord :
            specificBuilder.FunctionParameter();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ModifierList_ord :
            specificBuilder.ModifierList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionDecl_ord :
            specificBuilder.FunctionDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerDecl_ord :
            specificBuilder.InitializerDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl_ord :
            specificBuilder.DeinitializerDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptDecl_ord :
            specificBuilder.SubscriptDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier_ord :
            specificBuilder.AccessLevelModifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPathComponent_ord :
            specificBuilder.AccessPathComponent();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPath_ord :
            specificBuilder.AccessPath();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImportDecl_ord :
            specificBuilder.ImportDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorParameter_ord :
            specificBuilder.AccessorParameter();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorDecl_ord :
            specificBuilder.AccessorDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorList_ord :
            specificBuilder.AccessorList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorBlock_ord :
            specificBuilder.AccessorBlock();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBinding_ord :
            specificBuilder.PatternBinding();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder.PatternBindingList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.VariableDecl_ord :
            specificBuilder.VariableDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElement_ord :
            specificBuilder.EnumCaseElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder.EnumCaseElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl_ord :
            specificBuilder.EnumCaseDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumDecl_ord :
            specificBuilder.EnumDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorDecl_ord :
            specificBuilder.OperatorDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder.IdentifierList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes_ord :
            specificBuilder.OperatorPrecedenceAndTypes();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            specificBuilder.PrecedenceGroupDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder.PrecedenceGroupAttributeList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            specificBuilder.PrecedenceGroupRelation();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder.PrecedenceGroupNameList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement_ord :
            specificBuilder.PrecedenceGroupNameElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            specificBuilder.PrecedenceGroupAssignment();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            specificBuilder.PrecedenceGroupAssociativity();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TokenList_ord :
            specificBuilder.TokenList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CustomAttribute_ord :
            specificBuilder.CustomAttribute();
            break;
            case SwiftSyntaxEntityDescriptorEnum.Attribute_ord :
            specificBuilder.Attribute();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributeList_ord :
            specificBuilder.AttributeList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder.SpecializeAttributeSpecList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            specificBuilder.LabeledSpecializeEntry();
            break;
            case SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            specificBuilder.NamedAttributeStringArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclName_ord :
            specificBuilder.DeclName();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            specificBuilder.ImplementsAttributeArguments();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece_ord :
            specificBuilder.ObjCSelectorPiece();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder.ObjCSelector();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ContinueStmt_ord :
            specificBuilder.ContinueStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhileStmt_ord :
            specificBuilder.WhileStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeferStmt_ord :
            specificBuilder.DeferStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder.SwitchCaseList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt_ord :
            specificBuilder.RepeatWhileStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GuardStmt_ord :
            specificBuilder.GuardStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhereClause_ord :
            specificBuilder.WhereClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForInStmt_ord :
            specificBuilder.ForInStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchStmt_ord :
            specificBuilder.SwitchStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder.CatchClauseList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DoStmt_ord :
            specificBuilder.DoStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnStmt_ord :
            specificBuilder.ReturnStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldStmt_ord :
            specificBuilder.YieldStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldList_ord :
            specificBuilder.YieldList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FallthroughStmt_ord :
            specificBuilder.FallthroughStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BreakStmt_ord :
            specificBuilder.BreakStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItemList_ord :
            specificBuilder.CaseItemList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElement_ord :
            specificBuilder.ConditionElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition_ord :
            specificBuilder.AvailabilityCondition();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition_ord :
            specificBuilder.MatchingPatternCondition();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition_ord :
            specificBuilder.OptionalBindingCondition();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder.ConditionElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ThrowStmt_ord :
            specificBuilder.ThrowStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfStmt_ord :
            specificBuilder.IfStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder.SwitchCase();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel_ord :
            specificBuilder.SwitchDefaultLabel();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItem_ord :
            specificBuilder.CaseItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel_ord :
            specificBuilder.SwitchCaseLabel();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClause_ord :
            specificBuilder.CatchClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt_ord :
            specificBuilder.PoundAssertStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericWhereClause_ord :
            specificBuilder.GenericWhereClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder.GenericRequirementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement_ord :
            specificBuilder.SameTypeRequirement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder.GenericParameterList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameter_ord :
            specificBuilder.GenericParameter();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterClause_ord :
            specificBuilder.GenericParameterClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement_ord :
            specificBuilder.ConformanceRequirement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            specificBuilder.SimpleTypeIdentifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier_ord :
            specificBuilder.MemberTypeIdentifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType_ord :
            specificBuilder.ClassRestrictionType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayType_ord :
            specificBuilder.ArrayType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryType_ord :
            specificBuilder.DictionaryType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MetatypeType_ord :
            specificBuilder.MetatypeType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalType_ord :
            specificBuilder.OptionalType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SomeType_ord :
            specificBuilder.SomeType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            specificBuilder.ImplicitlyUnwrappedOptionalType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement_ord :
            specificBuilder.CompositionTypeElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList_ord :
            specificBuilder.CompositionTypeElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionType_ord :
            specificBuilder.CompositionType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElement_ord :
            specificBuilder.TupleTypeElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder.TupleTypeElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleType_ord :
            specificBuilder.TupleType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionType_ord :
            specificBuilder.FunctionType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributedType_ord :
            specificBuilder.AttributedType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder.GenericArgumentList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgument_ord :
            specificBuilder.GenericArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause_ord :
            specificBuilder.GenericArgumentClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeAnnotation_ord :
            specificBuilder.TypeAnnotation();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCasePattern_ord :
            specificBuilder.EnumCasePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsTypePattern_ord :
            specificBuilder.IsTypePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalPattern_ord :
            specificBuilder.OptionalPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierPattern_ord :
            specificBuilder.IdentifierPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsTypePattern_ord :
            specificBuilder.AsTypePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePattern_ord :
            specificBuilder.TuplePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WildcardPattern_ord :
            specificBuilder.WildcardPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElement_ord :
            specificBuilder.TuplePatternElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionPattern_ord :
            specificBuilder.ExpressionPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder.TuplePatternElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern_ord :
            specificBuilder.ValueBindingPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder.AvailabilitySpecList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument_ord :
            specificBuilder.AvailabilityArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            specificBuilder.AvailabilityLabeledArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            specificBuilder.AvailabilityVersionRestriction();
            break;
            case SwiftSyntaxEntityDescriptorEnum.VersionTuple_ord :
            specificBuilder.VersionTuple();
            break;
            case SwiftSyntaxEntityDescriptorEnum.Trivia_ord :
            specificBuilder.Trivia();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SwiftSyntaxEntityDescriptorEnum.Token_ord :
            specificBuilder.Token_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownDecl_ord :
            specificBuilder.UnknownDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownExpr_ord :
            specificBuilder.UnknownExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownPattern_ord :
            specificBuilder.UnknownPattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownStmt_ord :
            specificBuilder.UnknownStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownType_ord :
            specificBuilder.UnknownType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItem_ord :
            specificBuilder.CodeBlockItem_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder.CodeBlockItemList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlock_ord :
            specificBuilder.CodeBlock_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InOutExpr_ord :
            specificBuilder.InOutExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr_ord :
            specificBuilder.PoundColumnExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder.FunctionCallArgumentList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElementList_ord :
            specificBuilder.TupleElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElementList_ord :
            specificBuilder.ArrayElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElementList_ord :
            specificBuilder.DictionaryElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder.StringLiteralSegments_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TryExpr_ord :
            specificBuilder.TryExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgument_ord :
            specificBuilder.DeclNameArgument_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder.DeclNameArgumentList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArguments_ord :
            specificBuilder.DeclNameArguments_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierExpr_ord :
            specificBuilder.IdentifierExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SuperRefExpr_ord :
            specificBuilder.SuperRefExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr_ord :
            specificBuilder.NilLiteralExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            specificBuilder.DiscardAssignmentExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssignmentExpr_ord :
            specificBuilder.AssignmentExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SequenceExpr_ord :
            specificBuilder.SequenceExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExprList_ord :
            specificBuilder.ExprList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundLineExpr_ord :
            specificBuilder.PoundLineExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFileExpr_ord :
            specificBuilder.PoundFileExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr_ord :
            specificBuilder.PoundFunctionExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr_ord :
            specificBuilder.PoundDsohandleExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            specificBuilder.SymbolicReferenceExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr_ord :
            specificBuilder.PrefixOperatorExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr_ord :
            specificBuilder.BinaryOperatorExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrowExpr_ord :
            specificBuilder.ArrowExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr_ord :
            specificBuilder.FloatLiteralExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleExpr_ord :
            specificBuilder.TupleExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayExpr_ord :
            specificBuilder.ArrayExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryExpr_ord :
            specificBuilder.DictionaryExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument_ord :
            specificBuilder.FunctionCallArgument_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElement_ord :
            specificBuilder.TupleElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElement_ord :
            specificBuilder.ArrayElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElement_ord :
            specificBuilder.DictionaryElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr_ord :
            specificBuilder.IntegerLiteralExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr_ord :
            specificBuilder.BooleanLiteralExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TernaryExpr_ord :
            specificBuilder.TernaryExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr_ord :
            specificBuilder.MemberAccessExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsExpr_ord :
            specificBuilder.IsExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsExpr_ord :
            specificBuilder.AsExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeExpr_ord :
            specificBuilder.TypeExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem_ord :
            specificBuilder.ClosureCaptureItem_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder.ClosureCaptureItemList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature_ord :
            specificBuilder.ClosureCaptureSignature_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParam_ord :
            specificBuilder.ClosureParam_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder.ClosureParamList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureSignature_ord :
            specificBuilder.ClosureSignature_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureExpr_ord :
            specificBuilder.ClosureExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            specificBuilder.UnresolvedPatternExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr_ord :
            specificBuilder.FunctionCallExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptExpr_ord :
            specificBuilder.SubscriptExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr_ord :
            specificBuilder.OptionalChainingExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr_ord :
            specificBuilder.ForcedValueExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr_ord :
            specificBuilder.PostfixUnaryExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeExpr_ord :
            specificBuilder.SpecializeExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringSegment_ord :
            specificBuilder.StringSegment_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionSegment_ord :
            specificBuilder.ExpressionSegment_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr_ord :
            specificBuilder.StringLiteralExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathExpr_ord :
            specificBuilder.KeyPathExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr_ord :
            specificBuilder.KeyPathBaseExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece_ord :
            specificBuilder.ObjcNamePiece_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcName_ord :
            specificBuilder.ObjcName_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            specificBuilder.ObjcKeyPathExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr_ord :
            specificBuilder.ObjcSelectorExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            specificBuilder.EditorPlaceholderExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr_ord :
            specificBuilder.ObjectLiteralExpr_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause_ord :
            specificBuilder.TypeInitializerClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypealiasDecl_ord :
            specificBuilder.TypealiasDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl_ord :
            specificBuilder.AssociatedtypeDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder.FunctionParameterList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ParameterClause_ord :
            specificBuilder.ParameterClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnClause_ord :
            specificBuilder.ReturnClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionSignature_ord :
            specificBuilder.FunctionSignature_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClause_ord :
            specificBuilder.IfConfigClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList_ord :
            specificBuilder.IfConfigClauseList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigDecl_ord :
            specificBuilder.IfConfigDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl_ord :
            specificBuilder.PoundErrorDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl_ord :
            specificBuilder.PoundWarningDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation_ord :
            specificBuilder.PoundSourceLocation_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            specificBuilder.PoundSourceLocationArgs_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclModifier_ord :
            specificBuilder.DeclModifier_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedType_ord :
            specificBuilder.InheritedType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder.InheritedTypeList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause_ord :
            specificBuilder.TypeInheritanceClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassDecl_ord :
            specificBuilder.ClassDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StructDecl_ord :
            specificBuilder.StructDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ProtocolDecl_ord :
            specificBuilder.ProtocolDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExtensionDecl_ord :
            specificBuilder.ExtensionDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock_ord :
            specificBuilder.MemberDeclBlock_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder.MemberDeclList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem_ord :
            specificBuilder.MemberDeclListItem_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SourceFile_ord :
            specificBuilder.SourceFile_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerClause_ord :
            specificBuilder.InitializerClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameter_ord :
            specificBuilder.FunctionParameter_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ModifierList_ord :
            specificBuilder.ModifierList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionDecl_ord :
            specificBuilder.FunctionDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerDecl_ord :
            specificBuilder.InitializerDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl_ord :
            specificBuilder.DeinitializerDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptDecl_ord :
            specificBuilder.SubscriptDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier_ord :
            specificBuilder.AccessLevelModifier_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPathComponent_ord :
            specificBuilder.AccessPathComponent_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPath_ord :
            specificBuilder.AccessPath_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImportDecl_ord :
            specificBuilder.ImportDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorParameter_ord :
            specificBuilder.AccessorParameter_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorDecl_ord :
            specificBuilder.AccessorDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorList_ord :
            specificBuilder.AccessorList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorBlock_ord :
            specificBuilder.AccessorBlock_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBinding_ord :
            specificBuilder.PatternBinding_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder.PatternBindingList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.VariableDecl_ord :
            specificBuilder.VariableDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElement_ord :
            specificBuilder.EnumCaseElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder.EnumCaseElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl_ord :
            specificBuilder.EnumCaseDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumDecl_ord :
            specificBuilder.EnumDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorDecl_ord :
            specificBuilder.OperatorDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder.IdentifierList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes_ord :
            specificBuilder.OperatorPrecedenceAndTypes_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            specificBuilder.PrecedenceGroupDecl_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder.PrecedenceGroupAttributeList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            specificBuilder.PrecedenceGroupRelation_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder.PrecedenceGroupNameList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement_ord :
            specificBuilder.PrecedenceGroupNameElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            specificBuilder.PrecedenceGroupAssignment_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            specificBuilder.PrecedenceGroupAssociativity_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TokenList_ord :
            specificBuilder.TokenList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CustomAttribute_ord :
            specificBuilder.CustomAttribute_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.Attribute_ord :
            specificBuilder.Attribute_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributeList_ord :
            specificBuilder.AttributeList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder.SpecializeAttributeSpecList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            specificBuilder.LabeledSpecializeEntry_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            specificBuilder.NamedAttributeStringArgument_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclName_ord :
            specificBuilder.DeclName_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            specificBuilder.ImplementsAttributeArguments_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece_ord :
            specificBuilder.ObjCSelectorPiece_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder.ObjCSelector_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ContinueStmt_ord :
            specificBuilder.ContinueStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhileStmt_ord :
            specificBuilder.WhileStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeferStmt_ord :
            specificBuilder.DeferStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder.SwitchCaseList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt_ord :
            specificBuilder.RepeatWhileStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GuardStmt_ord :
            specificBuilder.GuardStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhereClause_ord :
            specificBuilder.WhereClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForInStmt_ord :
            specificBuilder.ForInStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchStmt_ord :
            specificBuilder.SwitchStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder.CatchClauseList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DoStmt_ord :
            specificBuilder.DoStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnStmt_ord :
            specificBuilder.ReturnStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldStmt_ord :
            specificBuilder.YieldStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldList_ord :
            specificBuilder.YieldList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FallthroughStmt_ord :
            specificBuilder.FallthroughStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BreakStmt_ord :
            specificBuilder.BreakStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItemList_ord :
            specificBuilder.CaseItemList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElement_ord :
            specificBuilder.ConditionElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition_ord :
            specificBuilder.AvailabilityCondition_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition_ord :
            specificBuilder.MatchingPatternCondition_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition_ord :
            specificBuilder.OptionalBindingCondition_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder.ConditionElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ThrowStmt_ord :
            specificBuilder.ThrowStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfStmt_ord :
            specificBuilder.IfStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder.SwitchCase_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel_ord :
            specificBuilder.SwitchDefaultLabel_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItem_ord :
            specificBuilder.CaseItem_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel_ord :
            specificBuilder.SwitchCaseLabel_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClause_ord :
            specificBuilder.CatchClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt_ord :
            specificBuilder.PoundAssertStmt_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericWhereClause_ord :
            specificBuilder.GenericWhereClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder.GenericRequirementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement_ord :
            specificBuilder.SameTypeRequirement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder.GenericParameterList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameter_ord :
            specificBuilder.GenericParameter_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterClause_ord :
            specificBuilder.GenericParameterClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement_ord :
            specificBuilder.ConformanceRequirement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            specificBuilder.SimpleTypeIdentifier_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier_ord :
            specificBuilder.MemberTypeIdentifier_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType_ord :
            specificBuilder.ClassRestrictionType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayType_ord :
            specificBuilder.ArrayType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryType_ord :
            specificBuilder.DictionaryType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MetatypeType_ord :
            specificBuilder.MetatypeType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalType_ord :
            specificBuilder.OptionalType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SomeType_ord :
            specificBuilder.SomeType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            specificBuilder.ImplicitlyUnwrappedOptionalType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement_ord :
            specificBuilder.CompositionTypeElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList_ord :
            specificBuilder.CompositionTypeElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionType_ord :
            specificBuilder.CompositionType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElement_ord :
            specificBuilder.TupleTypeElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder.TupleTypeElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleType_ord :
            specificBuilder.TupleType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionType_ord :
            specificBuilder.FunctionType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributedType_ord :
            specificBuilder.AttributedType_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder.GenericArgumentList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgument_ord :
            specificBuilder.GenericArgument_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause_ord :
            specificBuilder.GenericArgumentClause_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeAnnotation_ord :
            specificBuilder.TypeAnnotation_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCasePattern_ord :
            specificBuilder.EnumCasePattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsTypePattern_ord :
            specificBuilder.IsTypePattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalPattern_ord :
            specificBuilder.OptionalPattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierPattern_ord :
            specificBuilder.IdentifierPattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsTypePattern_ord :
            specificBuilder.AsTypePattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePattern_ord :
            specificBuilder.TuplePattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WildcardPattern_ord :
            specificBuilder.WildcardPattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElement_ord :
            specificBuilder.TuplePatternElement_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionPattern_ord :
            specificBuilder.ExpressionPattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder.TuplePatternElementList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern_ord :
            specificBuilder.ValueBindingPattern_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder.AvailabilitySpecList_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument_ord :
            specificBuilder.AvailabilityArgument_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            specificBuilder.AvailabilityLabeledArgument_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            specificBuilder.AvailabilityVersionRestriction_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.VersionTuple_ord :
            specificBuilder.VersionTuple_();
            break;
            case SwiftSyntaxEntityDescriptorEnum.Trivia_ord :
            specificBuilder.Trivia_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case SwiftSyntaxEntityDescriptorEnum.Token_ord :
            specificBuilder._Token();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownDecl_ord :
            specificBuilder._UnknownDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownExpr_ord :
            specificBuilder._UnknownExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownPattern_ord :
            specificBuilder._UnknownPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownStmt_ord :
            specificBuilder._UnknownStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownType_ord :
            specificBuilder._UnknownType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItem_ord :
            specificBuilder._CodeBlockItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder._CodeBlockItemList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlock_ord :
            specificBuilder._CodeBlock();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InOutExpr_ord :
            specificBuilder._InOutExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundColumnExpr_ord :
            specificBuilder._PoundColumnExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder._FunctionCallArgumentList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElementList_ord :
            specificBuilder._TupleElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElementList_ord :
            specificBuilder._ArrayElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElementList_ord :
            specificBuilder._DictionaryElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder._StringLiteralSegments();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TryExpr_ord :
            specificBuilder._TryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgument_ord :
            specificBuilder._DeclNameArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder._DeclNameArgumentList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArguments_ord :
            specificBuilder._DeclNameArguments();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierExpr_ord :
            specificBuilder._IdentifierExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SuperRefExpr_ord :
            specificBuilder._SuperRefExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.NilLiteralExpr_ord :
            specificBuilder._NilLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DiscardAssignmentExpr_ord :
            specificBuilder._DiscardAssignmentExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssignmentExpr_ord :
            specificBuilder._AssignmentExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SequenceExpr_ord :
            specificBuilder._SequenceExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExprList_ord :
            specificBuilder._ExprList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundLineExpr_ord :
            specificBuilder._PoundLineExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFileExpr_ord :
            specificBuilder._PoundFileExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundFunctionExpr_ord :
            specificBuilder._PoundFunctionExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundDsohandleExpr_ord :
            specificBuilder._PoundDsohandleExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr_ord :
            specificBuilder._SymbolicReferenceExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrefixOperatorExpr_ord :
            specificBuilder._PrefixOperatorExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BinaryOperatorExpr_ord :
            specificBuilder._BinaryOperatorExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrowExpr_ord :
            specificBuilder._ArrowExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FloatLiteralExpr_ord :
            specificBuilder._FloatLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleExpr_ord :
            specificBuilder._TupleExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayExpr_ord :
            specificBuilder._ArrayExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryExpr_ord :
            specificBuilder._DictionaryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgument_ord :
            specificBuilder._FunctionCallArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElement_ord :
            specificBuilder._TupleElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElement_ord :
            specificBuilder._ArrayElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElement_ord :
            specificBuilder._DictionaryElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IntegerLiteralExpr_ord :
            specificBuilder._IntegerLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BooleanLiteralExpr_ord :
            specificBuilder._BooleanLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TernaryExpr_ord :
            specificBuilder._TernaryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr_ord :
            specificBuilder._MemberAccessExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsExpr_ord :
            specificBuilder._IsExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsExpr_ord :
            specificBuilder._AsExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeExpr_ord :
            specificBuilder._TypeExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItem_ord :
            specificBuilder._ClosureCaptureItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder._ClosureCaptureItemList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature_ord :
            specificBuilder._ClosureCaptureSignature();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParam_ord :
            specificBuilder._ClosureParam();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder._ClosureParamList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureSignature_ord :
            specificBuilder._ClosureSignature();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureExpr_ord :
            specificBuilder._ClosureExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnresolvedPatternExpr_ord :
            specificBuilder._UnresolvedPatternExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallExpr_ord :
            specificBuilder._FunctionCallExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptExpr_ord :
            specificBuilder._SubscriptExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalChainingExpr_ord :
            specificBuilder._OptionalChainingExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForcedValueExpr_ord :
            specificBuilder._ForcedValueExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PostfixUnaryExpr_ord :
            specificBuilder._PostfixUnaryExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeExpr_ord :
            specificBuilder._SpecializeExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringSegment_ord :
            specificBuilder._StringSegment();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionSegment_ord :
            specificBuilder._ExpressionSegment();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr_ord :
            specificBuilder._StringLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathExpr_ord :
            specificBuilder._KeyPathExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.KeyPathBaseExpr_ord :
            specificBuilder._KeyPathBaseExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcNamePiece_ord :
            specificBuilder._ObjcNamePiece();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcName_ord :
            specificBuilder._ObjcName();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcKeyPathExpr_ord :
            specificBuilder._ObjcKeyPathExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcSelectorExpr_ord :
            specificBuilder._ObjcSelectorExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EditorPlaceholderExpr_ord :
            specificBuilder._EditorPlaceholderExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjectLiteralExpr_ord :
            specificBuilder._ObjectLiteralExpr();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause_ord :
            specificBuilder._TypeInitializerClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypealiasDecl_ord :
            specificBuilder._TypealiasDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl_ord :
            specificBuilder._AssociatedtypeDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder._FunctionParameterList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ParameterClause_ord :
            specificBuilder._ParameterClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnClause_ord :
            specificBuilder._ReturnClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionSignature_ord :
            specificBuilder._FunctionSignature();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClause_ord :
            specificBuilder._IfConfigClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList_ord :
            specificBuilder._IfConfigClauseList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigDecl_ord :
            specificBuilder._IfConfigDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundErrorDecl_ord :
            specificBuilder._PoundErrorDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundWarningDecl_ord :
            specificBuilder._PoundWarningDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocation_ord :
            specificBuilder._PoundSourceLocation();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundSourceLocationArgs_ord :
            specificBuilder._PoundSourceLocationArgs();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclModifier_ord :
            specificBuilder._DeclModifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedType_ord :
            specificBuilder._InheritedType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder._InheritedTypeList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause_ord :
            specificBuilder._TypeInheritanceClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassDecl_ord :
            specificBuilder._ClassDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.StructDecl_ord :
            specificBuilder._StructDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ProtocolDecl_ord :
            specificBuilder._ProtocolDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExtensionDecl_ord :
            specificBuilder._ExtensionDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock_ord :
            specificBuilder._MemberDeclBlock();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder._MemberDeclList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclListItem_ord :
            specificBuilder._MemberDeclListItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SourceFile_ord :
            specificBuilder._SourceFile();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerClause_ord :
            specificBuilder._InitializerClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameter_ord :
            specificBuilder._FunctionParameter();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ModifierList_ord :
            specificBuilder._ModifierList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionDecl_ord :
            specificBuilder._FunctionDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.InitializerDecl_ord :
            specificBuilder._InitializerDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeinitializerDecl_ord :
            specificBuilder._DeinitializerDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SubscriptDecl_ord :
            specificBuilder._SubscriptDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessLevelModifier_ord :
            specificBuilder._AccessLevelModifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPathComponent_ord :
            specificBuilder._AccessPathComponent();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPath_ord :
            specificBuilder._AccessPath();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImportDecl_ord :
            specificBuilder._ImportDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorParameter_ord :
            specificBuilder._AccessorParameter();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorDecl_ord :
            specificBuilder._AccessorDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorList_ord :
            specificBuilder._AccessorList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorBlock_ord :
            specificBuilder._AccessorBlock();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBinding_ord :
            specificBuilder._PatternBinding();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder._PatternBindingList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.VariableDecl_ord :
            specificBuilder._VariableDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElement_ord :
            specificBuilder._EnumCaseElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder._EnumCaseElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl_ord :
            specificBuilder._EnumCaseDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumDecl_ord :
            specificBuilder._EnumDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorDecl_ord :
            specificBuilder._OperatorDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder._IdentifierList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OperatorPrecedenceAndTypes_ord :
            specificBuilder._OperatorPrecedenceAndTypes();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl_ord :
            specificBuilder._PrecedenceGroupDecl();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder._PrecedenceGroupAttributeList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation_ord :
            specificBuilder._PrecedenceGroupRelation();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder._PrecedenceGroupNameList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameElement_ord :
            specificBuilder._PrecedenceGroupNameElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssignment_ord :
            specificBuilder._PrecedenceGroupAssignment();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAssociativity_ord :
            specificBuilder._PrecedenceGroupAssociativity();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TokenList_ord :
            specificBuilder._TokenList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CustomAttribute_ord :
            specificBuilder._CustomAttribute();
            break;
            case SwiftSyntaxEntityDescriptorEnum.Attribute_ord :
            specificBuilder._Attribute();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributeList_ord :
            specificBuilder._AttributeList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder._SpecializeAttributeSpecList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry_ord :
            specificBuilder._LabeledSpecializeEntry();
            break;
            case SwiftSyntaxEntityDescriptorEnum.NamedAttributeStringArgument_ord :
            specificBuilder._NamedAttributeStringArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclName_ord :
            specificBuilder._DeclName();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments_ord :
            specificBuilder._ImplementsAttributeArguments();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelectorPiece_ord :
            specificBuilder._ObjCSelectorPiece();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder._ObjCSelector();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ContinueStmt_ord :
            specificBuilder._ContinueStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhileStmt_ord :
            specificBuilder._WhileStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeferStmt_ord :
            specificBuilder._DeferStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder._SwitchCaseList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt_ord :
            specificBuilder._RepeatWhileStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GuardStmt_ord :
            specificBuilder._GuardStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WhereClause_ord :
            specificBuilder._WhereClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ForInStmt_ord :
            specificBuilder._ForInStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchStmt_ord :
            specificBuilder._SwitchStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder._CatchClauseList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DoStmt_ord :
            specificBuilder._DoStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ReturnStmt_ord :
            specificBuilder._ReturnStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldStmt_ord :
            specificBuilder._YieldStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.YieldList_ord :
            specificBuilder._YieldList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FallthroughStmt_ord :
            specificBuilder._FallthroughStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.BreakStmt_ord :
            specificBuilder._BreakStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItemList_ord :
            specificBuilder._CaseItemList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElement_ord :
            specificBuilder._ConditionElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityCondition_ord :
            specificBuilder._AvailabilityCondition();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MatchingPatternCondition_ord :
            specificBuilder._MatchingPatternCondition();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition_ord :
            specificBuilder._OptionalBindingCondition();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder._ConditionElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ThrowStmt_ord :
            specificBuilder._ThrowStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfStmt_ord :
            specificBuilder._IfStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCase_ord :
            specificBuilder._SwitchCase();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchDefaultLabel_ord :
            specificBuilder._SwitchDefaultLabel();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItem_ord :
            specificBuilder._CaseItem();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseLabel_ord :
            specificBuilder._SwitchCaseLabel();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClause_ord :
            specificBuilder._CatchClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt_ord :
            specificBuilder._PoundAssertStmt();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericWhereClause_ord :
            specificBuilder._GenericWhereClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder._GenericRequirementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SameTypeRequirement_ord :
            specificBuilder._SameTypeRequirement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder._GenericParameterList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameter_ord :
            specificBuilder._GenericParameter();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterClause_ord :
            specificBuilder._GenericParameterClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConformanceRequirement_ord :
            specificBuilder._ConformanceRequirement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier_ord :
            specificBuilder._SimpleTypeIdentifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier_ord :
            specificBuilder._MemberTypeIdentifier();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClassRestrictionType_ord :
            specificBuilder._ClassRestrictionType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayType_ord :
            specificBuilder._ArrayType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryType_ord :
            specificBuilder._DictionaryType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.MetatypeType_ord :
            specificBuilder._MetatypeType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalType_ord :
            specificBuilder._OptionalType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.SomeType_ord :
            specificBuilder._SomeType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ImplicitlyUnwrappedOptionalType_ord :
            specificBuilder._ImplicitlyUnwrappedOptionalType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElement_ord :
            specificBuilder._CompositionTypeElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList_ord :
            specificBuilder._CompositionTypeElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionType_ord :
            specificBuilder._CompositionType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElement_ord :
            specificBuilder._TupleTypeElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder._TupleTypeElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleType_ord :
            specificBuilder._TupleType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionType_ord :
            specificBuilder._FunctionType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributedType_ord :
            specificBuilder._AttributedType();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder._GenericArgumentList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgument_ord :
            specificBuilder._GenericArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause_ord :
            specificBuilder._GenericArgumentClause();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TypeAnnotation_ord :
            specificBuilder._TypeAnnotation();
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCasePattern_ord :
            specificBuilder._EnumCasePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IsTypePattern_ord :
            specificBuilder._IsTypePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.OptionalPattern_ord :
            specificBuilder._OptionalPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierPattern_ord :
            specificBuilder._IdentifierPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AsTypePattern_ord :
            specificBuilder._AsTypePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePattern_ord :
            specificBuilder._TuplePattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.WildcardPattern_ord :
            specificBuilder._WildcardPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElement_ord :
            specificBuilder._TuplePatternElement();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExpressionPattern_ord :
            specificBuilder._ExpressionPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder._TuplePatternElementList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.ValueBindingPattern_ord :
            specificBuilder._ValueBindingPattern();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder._AvailabilitySpecList();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityArgument_ord :
            specificBuilder._AvailabilityArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityLabeledArgument_ord :
            specificBuilder._AvailabilityLabeledArgument();
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilityVersionRestriction_ord :
            specificBuilder._AvailabilityVersionRestriction();
            break;
            case SwiftSyntaxEntityDescriptorEnum.VersionTuple_ord :
            specificBuilder._VersionTuple();
            break;
            case SwiftSyntaxEntityDescriptorEnum.Trivia_ord :
            specificBuilder._Trivia();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case SwiftSyntaxEntityDescriptorEnum.UnknownDecl_ord :
            specificBuilder.UnknownDecl_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownExpr_ord :
            specificBuilder.UnknownExpr_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownPattern_ord :
            specificBuilder.UnknownPattern_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownStmt_ord :
            specificBuilder.UnknownStmt_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.UnknownType_ord :
            specificBuilder.UnknownType_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList_ord :
            specificBuilder.CodeBlockItemList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList_ord :
            specificBuilder.FunctionCallArgumentList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleElementList_ord :
            specificBuilder.TupleElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ArrayElementList_ord :
            specificBuilder.ArrayElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DictionaryElementList_ord :
            specificBuilder.DictionaryElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments_ord :
            specificBuilder.StringLiteralSegments_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.DeclNameArgumentList_ord :
            specificBuilder.DeclNameArgumentList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ExprList_ord :
            specificBuilder.ExprList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureCaptureItemList_ord :
            specificBuilder.ClosureCaptureItemList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ClosureParamList_ord :
            specificBuilder.ClosureParamList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjcName_ord :
            specificBuilder.ObjcName_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.FunctionParameterList_ord :
            specificBuilder.FunctionParameterList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList_ord :
            specificBuilder.IfConfigClauseList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.InheritedTypeList_ord :
            specificBuilder.InheritedTypeList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.MemberDeclList_ord :
            specificBuilder.MemberDeclList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ModifierList_ord :
            specificBuilder.ModifierList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessPath_ord :
            specificBuilder.AccessPath_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AccessorList_ord :
            specificBuilder.AccessorList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PatternBindingList_ord :
            specificBuilder.PatternBindingList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList_ord :
            specificBuilder.EnumCaseElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.IdentifierList_ord :
            specificBuilder.IdentifierList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList_ord :
            specificBuilder.PrecedenceGroupAttributeList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList_ord :
            specificBuilder.PrecedenceGroupNameList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TokenList_ord :
            specificBuilder.TokenList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AttributeList_ord :
            specificBuilder.AttributeList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SpecializeAttributeSpecList_ord :
            specificBuilder.SpecializeAttributeSpecList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ObjCSelector_ord :
            specificBuilder.ObjCSelector_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SwitchCaseList_ord :
            specificBuilder.SwitchCaseList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CatchClauseList_ord :
            specificBuilder.CatchClauseList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CaseItemList_ord :
            specificBuilder.CaseItemList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.ConditionElementList_ord :
            specificBuilder.ConditionElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericRequirementList_ord :
            specificBuilder.GenericRequirementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericParameterList_ord :
            specificBuilder.GenericParameterList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.CompositionTypeElementList_ord :
            specificBuilder.CompositionTypeElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TupleTypeElementList_ord :
            specificBuilder.TupleTypeElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.GenericArgumentList_ord :
            specificBuilder.GenericArgumentList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TuplePatternElementList_ord :
            specificBuilder.TuplePatternElementList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.AvailabilitySpecList_ord :
            specificBuilder.AvailabilitySpecList_(initialCapacity);
            break;
            case SwiftSyntaxEntityDescriptorEnum.Trivia_ord :
            specificBuilder.Trivia_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case SwiftSyntaxEntityDescriptorEnum.TokenKind_ord :
            specificBuilder.TokenKind((Value) value);
            break;
            case SwiftSyntaxEntityDescriptorEnum.SourcePresence_ord :
            specificBuilder.SourcePresence((org.whole.lang.swiftsyntax.model.SourcePresenceEnum.Value) value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case SwiftSyntaxEntityDescriptorEnum.Text_ord :
            specificBuilder.Text(value);
            break;
            case SwiftSyntaxEntityDescriptorEnum.TriviaPiece_ord :
            specificBuilder.TriviaPiece(value);
            break;
        }
    }
}
