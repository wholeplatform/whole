package org.whole.lang.swiftsyntax.factories;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.*;
import static org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum.*;
import static org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum.*;
import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.*;

public class SwiftSyntaxDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {

    public void apply(IEntityRegistry er) {
        super.apply(er);
        SwiftSyntaxEntityFactory ef = SwiftSyntaxEntityFactory.instance(er);
        IEntity prototype;
        prototype = ef.createCodeBlock();
        prototype.wSet(leftBrace, createToken(ef, TokenKindEnum.leftBrace));
        prototype.wSet(rightBrace, createToken(ef, TokenKindEnum.rightBrace));
        er.put(prototype);
        prototype = ef.createInOutExpr();
        prototype.wSet(ampersand, createToken(ef, TokenKindEnum.prefixAmpersand));
        er.put(prototype);
        prototype = ef.createPoundColumnExpr();
        prototype.wSet(poundColumn, createToken(ef, TokenKindEnum.poundColumnKeyword));
        er.put(prototype);
        prototype = ef.createTryExpr();
        prototype.wSet(tryKeyword, createToken(ef, TokenKindEnum.tryKeyword));
        er.put(prototype);
        prototype = ef.createDeclNameArgument();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createDeclNameArguments();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createSuperRefExpr();
        prototype.wSet(superKeyword, createToken(ef, TokenKindEnum.superKeyword));
        er.put(prototype);
        prototype = ef.createNilLiteralExpr();
        prototype.wSet(nilKeyword, createToken(ef, TokenKindEnum.nilKeyword));
        er.put(prototype);
        prototype = ef.createDiscardAssignmentExpr();
        prototype.wSet(wildcard, createToken(ef, TokenKindEnum.wildcardKeyword));
        er.put(prototype);
        prototype = ef.createAssignmentExpr();
        prototype.wSet(assignToken, createToken(ef, TokenKindEnum.equal));
        er.put(prototype);
        prototype = ef.createPoundLineExpr();
        prototype.wSet(poundLine, createToken(ef, TokenKindEnum.poundLineKeyword));
        er.put(prototype);
        prototype = ef.createPoundFileExpr();
        prototype.wSet(poundFile, createToken(ef, TokenKindEnum.poundFileKeyword));
        er.put(prototype);
        prototype = ef.createPoundFunctionExpr();
        prototype.wSet(poundFunction, createToken(ef, TokenKindEnum.poundFunctionKeyword));
        er.put(prototype);
        prototype = ef.createPoundDsohandleExpr();
        prototype.wSet(poundDsohandle, createToken(ef, TokenKindEnum.poundDsohandleKeyword));
        er.put(prototype);
        prototype = ef.createArrowExpr();
        prototype.wSet(arrowToken, createToken(ef, TokenKindEnum.arrow));
        er.put(prototype);
        prototype = ef.createTupleExpr();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createArrayExpr();
        prototype.wSet(leftSquare, createToken(ef, TokenKindEnum.leftSquareBracket));
        prototype.wSet(rightSquare, createToken(ef, TokenKindEnum.rightSquareBracket));
        er.put(prototype);
        prototype = ef.createDictionaryExpr();
        prototype.wSet(leftSquare, createToken(ef, TokenKindEnum.leftSquareBracket));
        prototype.wSet(rightSquare, createToken(ef, TokenKindEnum.rightSquareBracket));
        er.put(prototype);
        prototype = ef.createFunctionCallArgument();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createTupleElement();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createArrayElement();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createDictionaryElement();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createTernaryExpr();
        prototype.wSet(questionMark, createToken(ef, TokenKindEnum.infixQuestionMark));
        prototype.wSet(colonMark, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createIsExpr();
        prototype.wSet(isTok, createToken(ef, TokenKindEnum.isKeyword));
        er.put(prototype);
        prototype = ef.createAsExpr();
        prototype.wSet(asTok, createToken(ef, TokenKindEnum.asKeyword));
        er.put(prototype);
        prototype = ef.createClosureCaptureItem();
        prototype.wSet(assignToken, createToken(ef, TokenKindEnum.equal));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createClosureCaptureSignature();
        prototype.wSet(leftSquare, createToken(ef, TokenKindEnum.leftSquareBracket));
        prototype.wSet(rightSquare, createToken(ef, TokenKindEnum.rightSquareBracket));
        er.put(prototype);
        prototype = ef.createClosureParam();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createClosureSignature();
        prototype.wSet(inTok, createToken(ef, TokenKindEnum.inKeyword));
        er.put(prototype);
        prototype = ef.createClosureExpr();
        prototype.wSet(leftBrace, createToken(ef, TokenKindEnum.leftBrace));
        prototype.wSet(rightBrace, createToken(ef, TokenKindEnum.rightBrace));
        er.put(prototype);
        prototype = ef.createFunctionCallExpr();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createSubscriptExpr();
        prototype.wSet(leftBracket, createToken(ef, TokenKindEnum.leftSquareBracket));
        prototype.wSet(rightBracket, createToken(ef, TokenKindEnum.rightSquareBracket));
        er.put(prototype);
        prototype = ef.createOptionalChainingExpr();
        prototype.wSet(questionMark, createToken(ef, TokenKindEnum.postfixQuestionMark));
        er.put(prototype);
        prototype = ef.createForcedValueExpr();
        prototype.wSet(exclamationMark, createToken(ef, TokenKindEnum.exclamationMark));
        er.put(prototype);
        prototype = ef.createExpressionSegment();
        prototype.wSet(backslash, createToken(ef, TokenKindEnum.backslash));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.stringInterpolationAnchor));
        er.put(prototype);
        prototype = ef.createKeyPathExpr();
        prototype.wSet(backslash, createToken(ef, TokenKindEnum.backslash));
        er.put(prototype);
        prototype = ef.createKeyPathBaseExpr();
        prototype.wSet(period, createToken(ef, TokenKindEnum.period));
        er.put(prototype);
        prototype = ef.createObjcNamePiece();
        prototype.wSet(dot, createToken(ef, TokenKindEnum.period));
        er.put(prototype);
        prototype = ef.createObjcKeyPathExpr();
        prototype.wSet(keyPath, createToken(ef, TokenKindEnum.poundKeyPathKeyword));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createObjcSelectorExpr();
        prototype.wSet(poundSelector, createToken(ef, TokenKindEnum.poundSelectorKeyword));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createObjectLiteralExpr();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createTypeInitializerClause();
        prototype.wSet(equal, createToken(ef, TokenKindEnum.equal));
        er.put(prototype);
        prototype = ef.createTypealiasDecl();
        prototype.wSet(typealiasKeyword, createToken(ef, TokenKindEnum.typealiasKeyword));
        er.put(prototype);
        prototype = ef.createAssociatedtypeDecl();
        prototype.wSet(associatedtypeKeyword, createToken(ef, TokenKindEnum.associatedtypeKeyword));
        er.put(prototype);
        prototype = ef.createParameterClause();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createReturnClause();
        prototype.wSet(arrow, createToken(ef, TokenKindEnum.arrow));
        er.put(prototype);
        prototype = ef.createIfConfigDecl();
        prototype.wSet(poundEndif, createToken(ef, TokenKindEnum.poundEndifKeyword));
        er.put(prototype);
        prototype = ef.createPoundErrorDecl();
        prototype.wSet(poundError, createToken(ef, TokenKindEnum.poundErrorKeyword));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createPoundWarningDecl();
        prototype.wSet(poundWarning, createToken(ef, TokenKindEnum.poundWarningKeyword));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createPoundSourceLocation();
        prototype.wSet(poundSourceLocation, createToken(ef, TokenKindEnum.poundSourceLocationKeyword));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createPoundSourceLocationArgs();
        prototype.wSet(fileArgColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(comma, createToken(ef, TokenKindEnum.comma));
        prototype.wSet(lineArgColon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createDeclModifier();
        prototype.wSet(detailLeftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(detailRightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createInheritedType();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createTypeInheritanceClause();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createClassDecl();
        prototype.wSet(classKeyword, createToken(ef, TokenKindEnum.classKeyword));
        er.put(prototype);
        prototype = ef.createStructDecl();
        prototype.wSet(structKeyword, createToken(ef, TokenKindEnum.structKeyword));
        er.put(prototype);
        prototype = ef.createProtocolDecl();
        prototype.wSet(protocolKeyword, createToken(ef, TokenKindEnum.protocolKeyword));
        er.put(prototype);
        prototype = ef.createExtensionDecl();
        prototype.wSet(extensionKeyword, createToken(ef, TokenKindEnum.extensionKeyword));
        er.put(prototype);
        prototype = ef.createMemberDeclBlock();
        prototype.wSet(leftBrace, createToken(ef, TokenKindEnum.leftBrace));
        prototype.wSet(rightBrace, createToken(ef, TokenKindEnum.rightBrace));
        er.put(prototype);
        prototype = ef.createSourceFile();
        prototype.wSet(eofToken, createToken(ef, TokenKindEnum.eof));
        er.put(prototype);
        prototype = ef.createInitializerClause();
        prototype.wSet(equal, createToken(ef, TokenKindEnum.equal));
        er.put(prototype);
        prototype = ef.createFunctionParameter();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createFunctionDecl();
        prototype.wSet(funcKeyword, createToken(ef, TokenKindEnum.funcKeyword));
        er.put(prototype);
        prototype = ef.createInitializerDecl();
        prototype.wSet(initKeyword, createToken(ef, TokenKindEnum.initKeyword));
        er.put(prototype);
        prototype = ef.createDeinitializerDecl();
        prototype.wSet(deinitKeyword, createToken(ef, TokenKindEnum.deinitKeyword));
        er.put(prototype);
        prototype = ef.createSubscriptDecl();
        prototype.wSet(subscriptKeyword, createToken(ef, TokenKindEnum.subscriptKeyword));
        er.put(prototype);
        prototype = ef.createAccessLevelModifier();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createAccessPathComponent();
        prototype.wSet(trailingDot, createToken(ef, TokenKindEnum.period));
        er.put(prototype);
        prototype = ef.createImportDecl();
        prototype.wSet(importTok, createToken(ef, TokenKindEnum.importKeyword));
        er.put(prototype);
        prototype = ef.createAccessorParameter();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createAccessorBlock();
        prototype.wSet(leftBrace, createToken(ef, TokenKindEnum.leftBrace));
        prototype.wSet(rightBrace, createToken(ef, TokenKindEnum.rightBrace));
        er.put(prototype);
        prototype = ef.createPatternBinding();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createEnumCaseElement();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createEnumCaseDecl();
        prototype.wSet(caseKeyword, createToken(ef, TokenKindEnum.caseKeyword));
        er.put(prototype);
        prototype = ef.createEnumDecl();
        prototype.wSet(enumKeyword, createToken(ef, TokenKindEnum.enumKeyword));
        er.put(prototype);
        prototype = ef.createOperatorDecl();
        prototype.wSet(operatorKeyword, createToken(ef, TokenKindEnum.operatorKeyword));
        er.put(prototype);
        prototype = ef.createOperatorPrecedenceAndTypes();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createPrecedenceGroupDecl();
        prototype.wSet(precedencegroupKeyword, createToken(ef, TokenKindEnum.precedencegroupKeyword));
        prototype.wSet(leftBrace, createToken(ef, TokenKindEnum.leftBrace));
        prototype.wSet(rightBrace, createToken(ef, TokenKindEnum.rightBrace));
        er.put(prototype);
        prototype = ef.createPrecedenceGroupRelation();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createPrecedenceGroupNameElement();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createPrecedenceGroupAssignment();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createPrecedenceGroupAssociativity();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createCustomAttribute();
        prototype.wSet(atSignToken, createToken(ef, TokenKindEnum.atSign));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createAttribute();
        prototype.wSet(atSignToken, createToken(ef, TokenKindEnum.atSign));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createLabeledSpecializeEntry();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createNamedAttributeStringArgument();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createImplementsAttributeArguments();
        prototype.wSet(comma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createObjCSelectorPiece();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createContinueStmt();
        prototype.wSet(continueKeyword, createToken(ef, TokenKindEnum.continueKeyword));
        er.put(prototype);
        prototype = ef.createWhileStmt();
        prototype.wSet(labelColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(whileKeyword, createToken(ef, TokenKindEnum.whileKeyword));
        er.put(prototype);
        prototype = ef.createDeferStmt();
        prototype.wSet(deferKeyword, createToken(ef, TokenKindEnum.deferKeyword));
        er.put(prototype);
        prototype = ef.createRepeatWhileStmt();
        prototype.wSet(labelColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(repeatKeyword, createToken(ef, TokenKindEnum.repeatKeyword));
        prototype.wSet(whileKeyword, createToken(ef, TokenKindEnum.whileKeyword));
        er.put(prototype);
        prototype = ef.createGuardStmt();
        prototype.wSet(guardKeyword, createToken(ef, TokenKindEnum.guardKeyword));
        prototype.wSet(elseKeyword, createToken(ef, TokenKindEnum.elseKeyword));
        er.put(prototype);
        prototype = ef.createWhereClause();
        prototype.wSet(whereKeyword, createToken(ef, TokenKindEnum.whereKeyword));
        er.put(prototype);
        prototype = ef.createForInStmt();
        prototype.wSet(labelColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(forKeyword, createToken(ef, TokenKindEnum.forKeyword));
        prototype.wSet(inKeyword, createToken(ef, TokenKindEnum.inKeyword));
        er.put(prototype);
        prototype = ef.createSwitchStmt();
        prototype.wSet(labelColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(switchKeyword, createToken(ef, TokenKindEnum.switchKeyword));
        prototype.wSet(leftBrace, createToken(ef, TokenKindEnum.leftBrace));
        prototype.wSet(rightBrace, createToken(ef, TokenKindEnum.rightBrace));
        er.put(prototype);
        prototype = ef.createDoStmt();
        prototype.wSet(labelColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(doKeyword, createToken(ef, TokenKindEnum.doKeyword));
        er.put(prototype);
        prototype = ef.createReturnStmt();
        prototype.wSet(returnKeyword, createToken(ef, TokenKindEnum.returnKeyword));
        er.put(prototype);
        prototype = ef.createYieldStmt();
        prototype.wSet(yieldKeyword, createToken(ef, TokenKindEnum.yield));
        er.put(prototype);
        prototype = ef.createYieldList();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createFallthroughStmt();
        prototype.wSet(fallthroughKeyword, createToken(ef, TokenKindEnum.fallthroughKeyword));
        er.put(prototype);
        prototype = ef.createBreakStmt();
        prototype.wSet(breakKeyword, createToken(ef, TokenKindEnum.breakKeyword));
        er.put(prototype);
        prototype = ef.createConditionElement();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createAvailabilityCondition();
        prototype.wSet(poundAvailableKeyword, createToken(ef, TokenKindEnum.poundAvailableKeyword));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createMatchingPatternCondition();
        prototype.wSet(caseKeyword, createToken(ef, TokenKindEnum.caseKeyword));
        er.put(prototype);
        prototype = ef.createThrowStmt();
        prototype.wSet(throwKeyword, createToken(ef, TokenKindEnum.throwKeyword));
        er.put(prototype);
        prototype = ef.createIfStmt();
        prototype.wSet(labelColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(ifKeyword, createToken(ef, TokenKindEnum.ifKeyword));
        prototype.wSet(elseKeyword, createToken(ef, TokenKindEnum.elseKeyword));
        er.put(prototype);
        prototype = ef.createSwitchDefaultLabel();
        prototype.wSet(defaultKeyword, createToken(ef, TokenKindEnum.defaultKeyword));
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createCaseItem();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createSwitchCaseLabel();
        prototype.wSet(caseKeyword, createToken(ef, TokenKindEnum.caseKeyword));
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createCatchClause();
        prototype.wSet(catchKeyword, createToken(ef, TokenKindEnum.catchKeyword));
        er.put(prototype);
        prototype = ef.createPoundAssertStmt();
        prototype.wSet(poundAssert, createToken(ef, TokenKindEnum.poundAssertKeyword));
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(comma, createToken(ef, TokenKindEnum.comma));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createGenericWhereClause();
        prototype.wSet(whereKeyword, createToken(ef, TokenKindEnum.whereKeyword));
        er.put(prototype);
        prototype = ef.createSameTypeRequirement();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createGenericParameter();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createGenericParameterClause();
        prototype.wSet(leftAngleBracket, createToken(ef, TokenKindEnum.leftAngle));
        prototype.wSet(rightAngleBracket, createToken(ef, TokenKindEnum.rightAngle));
        er.put(prototype);
        prototype = ef.createConformanceRequirement();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createClassRestrictionType();
        prototype.wSet(classKeyword, createToken(ef, TokenKindEnum.classKeyword));
        er.put(prototype);
        prototype = ef.createArrayType();
        prototype.wSet(leftSquareBracket, createToken(ef, TokenKindEnum.leftSquareBracket));
        prototype.wSet(rightSquareBracket, createToken(ef, TokenKindEnum.rightSquareBracket));
        er.put(prototype);
        prototype = ef.createDictionaryType();
        prototype.wSet(leftSquareBracket, createToken(ef, TokenKindEnum.leftSquareBracket));
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(rightSquareBracket, createToken(ef, TokenKindEnum.rightSquareBracket));
        er.put(prototype);
        prototype = ef.createMetatypeType();
        prototype.wSet(period, createToken(ef, TokenKindEnum.period));
        er.put(prototype);
        prototype = ef.createOptionalType();
        prototype.wSet(questionMark, createToken(ef, TokenKindEnum.postfixQuestionMark));
        er.put(prototype);
        prototype = ef.createImplicitlyUnwrappedOptionalType();
        prototype.wSet(exclamationMark, createToken(ef, TokenKindEnum.exclamationMark));
        er.put(prototype);
        prototype = ef.createTupleTypeElement();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createTupleType();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createFunctionType();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        prototype.wSet(arrow, createToken(ef, TokenKindEnum.arrow));
        er.put(prototype);
        prototype = ef.createGenericArgument();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createGenericArgumentClause();
        prototype.wSet(leftAngleBracket, createToken(ef, TokenKindEnum.leftAngle));
        prototype.wSet(rightAngleBracket, createToken(ef, TokenKindEnum.rightAngle));
        er.put(prototype);
        prototype = ef.createTypeAnnotation();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createEnumCasePattern();
        prototype.wSet(period, createToken(ef, TokenKindEnum.period));
        er.put(prototype);
        prototype = ef.createIsTypePattern();
        prototype.wSet(isKeyword, createToken(ef, TokenKindEnum.isKeyword));
        er.put(prototype);
        prototype = ef.createOptionalPattern();
        prototype.wSet(questionMark, createToken(ef, TokenKindEnum.postfixQuestionMark));
        er.put(prototype);
        prototype = ef.createAsTypePattern();
        prototype.wSet(asKeyword, createToken(ef, TokenKindEnum.asKeyword));
        er.put(prototype);
        prototype = ef.createTuplePattern();
        prototype.wSet(leftParen, createToken(ef, TokenKindEnum.leftParen));
        prototype.wSet(rightParen, createToken(ef, TokenKindEnum.rightParen));
        er.put(prototype);
        prototype = ef.createWildcardPattern();
        prototype.wSet(wildcard, createToken(ef, TokenKindEnum.wildcardKeyword));
        er.put(prototype);
        prototype = ef.createTuplePatternElement();
        prototype.wSet(labelColon, createToken(ef, TokenKindEnum.colon));
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createAvailabilityArgument();
        prototype.wSet(trailingComma, createToken(ef, TokenKindEnum.comma));
        er.put(prototype);
        prototype = ef.createAvailabilityLabeledArgument();
        prototype.wSet(colon, createToken(ef, TokenKindEnum.colon));
        er.put(prototype);
        prototype = ef.createVersionTuple();
        prototype.wSet(patchPeriod, createToken(ef, TokenKindEnum.period));
        er.put(prototype);
        prototype = ef.createStringLiteralExpr();
        prototype.wSet(openQuote, createToken(ef, TokenKindEnum.stringQuote));
        prototype.wSet(closeQuote, createToken(ef, TokenKindEnum.stringQuote));
        er.put(prototype);
    }

    public Token createToken(SwiftSyntaxEntityFactory ef, TokenKindEnum.Value value) {
        Text text;
        switch (value.getOrdinal()) {
            case TokenKindEnum.eof_ord :
            text = ef.createText("");
            break;
            case TokenKindEnum.associatedtypeKeyword_ord :
            text = ef.createText("associatedtype");
            break;
            case TokenKindEnum.classKeyword_ord :
            text = ef.createText("class");
            break;
            case TokenKindEnum.deinitKeyword_ord :
            text = ef.createText("deinit");
            break;
            case TokenKindEnum.enumKeyword_ord :
            text = ef.createText("enum");
            break;
            case TokenKindEnum.extensionKeyword_ord :
            text = ef.createText("extension");
            break;
            case TokenKindEnum.funcKeyword_ord :
            text = ef.createText("func");
            break;
            case TokenKindEnum.importKeyword_ord :
            text = ef.createText("import");
            break;
            case TokenKindEnum.initKeyword_ord :
            text = ef.createText("init");
            break;
            case TokenKindEnum.inoutKeyword_ord :
            text = ef.createText("inout");
            break;
            case TokenKindEnum.letKeyword_ord :
            text = ef.createText("let");
            break;
            case TokenKindEnum.operatorKeyword_ord :
            text = ef.createText("operator");
            break;
            case TokenKindEnum.precedencegroupKeyword_ord :
            text = ef.createText("precedencegroup");
            break;
            case TokenKindEnum.protocolKeyword_ord :
            text = ef.createText("protocol");
            break;
            case TokenKindEnum.structKeyword_ord :
            text = ef.createText("struct");
            break;
            case TokenKindEnum.subscriptKeyword_ord :
            text = ef.createText("subscript");
            break;
            case TokenKindEnum.typealiasKeyword_ord :
            text = ef.createText("typealias");
            break;
            case TokenKindEnum.varKeyword_ord :
            text = ef.createText("var");
            break;
            case TokenKindEnum.fileprivateKeyword_ord :
            text = ef.createText("fileprivate");
            break;
            case TokenKindEnum.internalKeyword_ord :
            text = ef.createText("internal");
            break;
            case TokenKindEnum.privateKeyword_ord :
            text = ef.createText("private");
            break;
            case TokenKindEnum.publicKeyword_ord :
            text = ef.createText("public");
            break;
            case TokenKindEnum.staticKeyword_ord :
            text = ef.createText("static");
            break;
            case TokenKindEnum.deferKeyword_ord :
            text = ef.createText("defer");
            break;
            case TokenKindEnum.ifKeyword_ord :
            text = ef.createText("if");
            break;
            case TokenKindEnum.guardKeyword_ord :
            text = ef.createText("guard");
            break;
            case TokenKindEnum.doKeyword_ord :
            text = ef.createText("do");
            break;
            case TokenKindEnum.repeatKeyword_ord :
            text = ef.createText("repeat");
            break;
            case TokenKindEnum.elseKeyword_ord :
            text = ef.createText("else");
            break;
            case TokenKindEnum.forKeyword_ord :
            text = ef.createText("for");
            break;
            case TokenKindEnum.inKeyword_ord :
            text = ef.createText("in");
            break;
            case TokenKindEnum.whileKeyword_ord :
            text = ef.createText("while");
            break;
            case TokenKindEnum.returnKeyword_ord :
            text = ef.createText("return");
            break;
            case TokenKindEnum.breakKeyword_ord :
            text = ef.createText("break");
            break;
            case TokenKindEnum.continueKeyword_ord :
            text = ef.createText("continue");
            break;
            case TokenKindEnum.fallthroughKeyword_ord :
            text = ef.createText("fallthrough");
            break;
            case TokenKindEnum.switchKeyword_ord :
            text = ef.createText("switch");
            break;
            case TokenKindEnum.caseKeyword_ord :
            text = ef.createText("case");
            break;
            case TokenKindEnum.defaultKeyword_ord :
            text = ef.createText("default");
            break;
            case TokenKindEnum.whereKeyword_ord :
            text = ef.createText("where");
            break;
            case TokenKindEnum.catchKeyword_ord :
            text = ef.createText("catch");
            break;
            case TokenKindEnum.throwKeyword_ord :
            text = ef.createText("throw");
            break;
            case TokenKindEnum.asKeyword_ord :
            text = ef.createText("as");
            break;
            case TokenKindEnum.anyKeyword_ord :
            text = ef.createText("Any");
            break;
            case TokenKindEnum.falseKeyword_ord :
            text = ef.createText("false");
            break;
            case TokenKindEnum.isKeyword_ord :
            text = ef.createText("is");
            break;
            case TokenKindEnum.nilKeyword_ord :
            text = ef.createText("nil");
            break;
            case TokenKindEnum.rethrowsKeyword_ord :
            text = ef.createText("rethrows");
            break;
            case TokenKindEnum.superKeyword_ord :
            text = ef.createText("super");
            break;
            case TokenKindEnum.selfKeyword_ord :
            text = ef.createText("self");
            break;
            case TokenKindEnum.capitalSelfKeyword_ord :
            text = ef.createText("Self");
            break;
            case TokenKindEnum.trueKeyword_ord :
            text = ef.createText("true");
            break;
            case TokenKindEnum.tryKeyword_ord :
            text = ef.createText("try");
            break;
            case TokenKindEnum.throwsKeyword_ord :
            text = ef.createText("throws");
            break;
            case TokenKindEnum.__file__Keyword_ord :
            text = ef.createText("__FILE__");
            break;
            case TokenKindEnum.__line__Keyword_ord :
            text = ef.createText("__LINE__");
            break;
            case TokenKindEnum.__column__Keyword_ord :
            text = ef.createText("__COLUMN__");
            break;
            case TokenKindEnum.__function__Keyword_ord :
            text = ef.createText("__FUNCTION__");
            break;
            case TokenKindEnum.__dso_handle__Keyword_ord :
            text = ef.createText("__DSO_HANDLE__");
            break;
            case TokenKindEnum.wildcardKeyword_ord :
            text = ef.createText("_");
            break;
            case TokenKindEnum.leftParen_ord :
            text = ef.createText("(");
            break;
            case TokenKindEnum.rightParen_ord :
            text = ef.createText(")");
            break;
            case TokenKindEnum.leftBrace_ord :
            text = ef.createText("{");
            break;
            case TokenKindEnum.rightBrace_ord :
            text = ef.createText("}");
            break;
            case TokenKindEnum.leftSquareBracket_ord :
            text = ef.createText("[");
            break;
            case TokenKindEnum.rightSquareBracket_ord :
            text = ef.createText("]");
            break;
            case TokenKindEnum.leftAngle_ord :
            text = ef.createText("<");
            break;
            case TokenKindEnum.rightAngle_ord :
            text = ef.createText(">");
            break;
            case TokenKindEnum.period_ord :
            text = ef.createText(".");
            break;
            case TokenKindEnum.prefixPeriod_ord :
            text = ef.createText(".");
            break;
            case TokenKindEnum.comma_ord :
            text = ef.createText(",");
            break;
            case TokenKindEnum.ellipsis_ord :
            text = ef.createText("...");
            break;
            case TokenKindEnum.colon_ord :
            text = ef.createText(":");
            break;
            case TokenKindEnum.semicolon_ord :
            text = ef.createText(";");
            break;
            case TokenKindEnum.equal_ord :
            text = ef.createText("=");
            break;
            case TokenKindEnum.atSign_ord :
            text = ef.createText("@");
            break;
            case TokenKindEnum.pound_ord :
            text = ef.createText("#");
            break;
            case TokenKindEnum.prefixAmpersand_ord :
            text = ef.createText("&");
            break;
            case TokenKindEnum.arrow_ord :
            text = ef.createText("->");
            break;
            case TokenKindEnum.backtick_ord :
            text = ef.createText("`");
            break;
            case TokenKindEnum.backslash_ord :
            text = ef.createText("\\");
            break;
            case TokenKindEnum.exclamationMark_ord :
            text = ef.createText("!");
            break;
            case TokenKindEnum.postfixQuestionMark_ord :
            text = ef.createText("?");
            break;
            case TokenKindEnum.infixQuestionMark_ord :
            text = ef.createText("?");
            break;
            case TokenKindEnum.stringQuote_ord :
            text = ef.createText("\"");
            break;
            case TokenKindEnum.singleQuote_ord :
            text = ef.createText("'");
            break;
            case TokenKindEnum.multilineStringQuote_ord :
            text = ef.createText("\"\"\"");
            break;
            case TokenKindEnum.poundKeyPathKeyword_ord :
            text = ef.createText("#keyPath");
            break;
            case TokenKindEnum.poundLineKeyword_ord :
            text = ef.createText("#line");
            break;
            case TokenKindEnum.poundSelectorKeyword_ord :
            text = ef.createText("#selector");
            break;
            case TokenKindEnum.poundFileKeyword_ord :
            text = ef.createText("#file");
            break;
            case TokenKindEnum.poundColumnKeyword_ord :
            text = ef.createText("#column");
            break;
            case TokenKindEnum.poundFunctionKeyword_ord :
            text = ef.createText("#function");
            break;
            case TokenKindEnum.poundDsohandleKeyword_ord :
            text = ef.createText("#dsohandle");
            break;
            case TokenKindEnum.poundAssertKeyword_ord :
            text = ef.createText("#assert");
            break;
            case TokenKindEnum.poundSourceLocationKeyword_ord :
            text = ef.createText("#sourceLocation");
            break;
            case TokenKindEnum.poundWarningKeyword_ord :
            text = ef.createText("#warning");
            break;
            case TokenKindEnum.poundErrorKeyword_ord :
            text = ef.createText("#error");
            break;
            case TokenKindEnum.poundIfKeyword_ord :
            text = ef.createText("#if");
            break;
            case TokenKindEnum.poundElseKeyword_ord :
            text = ef.createText("#else");
            break;
            case TokenKindEnum.poundElseifKeyword_ord :
            text = ef.createText("#elseif");
            break;
            case TokenKindEnum.poundEndifKeyword_ord :
            text = ef.createText("#endif");
            break;
            case TokenKindEnum.poundAvailableKeyword_ord :
            text = ef.createText("#available");
            break;
            case TokenKindEnum.poundFileLiteralKeyword_ord :
            text = ef.createText("#fileLiteral");
            break;
            case TokenKindEnum.poundImageLiteralKeyword_ord :
            text = ef.createText("#imageLiteral");
            break;
            case TokenKindEnum.poundColorLiteralKeyword_ord :
            text = ef.createText("#colorLiteral");
            break;
            case TokenKindEnum.stringInterpolationAnchor_ord :
            text = ef.createText(")");
            break;
            case TokenKindEnum.yield_ord :
            text = ef.createText("yield");
            break;
            case TokenKindEnum.integerLiteral_ord :
            text = ef.createText("0");
            break;
            case TokenKindEnum.floatingLiteral_ord :
            text = ef.createText("0.0");
            break;
            case TokenKindEnum.stringLiteral_ord :
            text = ef.createText("");
            break;
            case TokenKindEnum.unknown_ord :
            text = createResolver(Text);
            break;
            case TokenKindEnum.identifier_ord :
            text = ef.createText("identifier");
            break;
            case TokenKindEnum.unspacedBinaryOperator_ord :
            text = ef.createText("+");
            break;
            case TokenKindEnum.spacedBinaryOperator_ord :
            text = ef.createText("+");
            break;
            case TokenKindEnum.postfixOperator_ord :
            text = ef.createText("...");
            break;
            case TokenKindEnum.prefixOperator_ord :
            text = ef.createText("-");
            break;
            case TokenKindEnum.dollarIdentifier_ord :
            text = ef.createText("identifier");
            break;
            case TokenKindEnum.contextualKeyword_ord :
            text = ef.createText("keyword");
            break;
            case TokenKindEnum.rawStringDelimiter_ord :
            text = ef.createText("#");
            break;
            case TokenKindEnum.stringSegment_ord :
            text = ef.createText("string");
            break;
            default :
            throw new IllegalArgumentException("Unknown token kind: " + value.getName());
        }
        Trivia[] trivia = createTrivia(ef, text);
        return ef.createToken(ef.createTokenKind(value), ef.createSourcePresence(SourcePresenceEnum.present), trivia[0], trivia[1], text);
    }

    public Trivia[] createTrivia(SwiftSyntaxEntityFactory ef, Text text) {
        if (text.wGetEntityDescriptor().getDataKind().isString() && needTrivia(text.wStringValue()))
            return new Trivia[]  {ef.createTrivia(ef.createTriviaPiece(" ")) , ef.createTrivia(ef.createTriviaPiece(" "))};
        else
            return new Trivia[]  {ef.createTrivia(0) , ef.createTrivia(0)};
    }

    public static boolean needTrivia(String text) {
        char[] chars = text.toCharArray();
        return chars.length > 0 ? Character.isLetter(chars[0]) || Character.isLetter(chars[chars.length - 1]) : false;
    }
}
