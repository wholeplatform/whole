/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class QueriesModelContext extends EntityContext {

    public QueriesModelContext(IEntity root) {
        super(root);
    }

    public QueriesModelContext getName() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.name);
    }

    public void setName(QueriesModelContext name) {
        wSet(QueriesFeatureDescriptorEnum.name, name);
    }

    public QueriesModelContext getParameters() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.parameters);
    }

    public void setParameters(QueriesModelContext parameters) {
        wSet(QueriesFeatureDescriptorEnum.parameters, parameters);
    }

    public QueriesModelContext getBody() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.body);
    }

    public void setBody(QueriesModelContext body) {
        wSet(QueriesFeatureDescriptorEnum.body, body);
    }

    public QueriesModelContext getFromClause() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.fromClause);
    }

    public void setFromClause(QueriesModelContext fromClause) {
        wSet(QueriesFeatureDescriptorEnum.fromClause, fromClause);
    }

    public QueriesModelContext getPlacement() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.placement);
    }

    public void setPlacement(QueriesModelContext placement) {
        wSet(QueriesFeatureDescriptorEnum.placement, placement);
    }

    public QueriesModelContext getValuesClause() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.valuesClause);
    }

    public void setValuesClause(QueriesModelContext valuesClause) {
        wSet(QueriesFeatureDescriptorEnum.valuesClause, valuesClause);
    }

    public QueriesModelContext getSelectClause() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.selectClause);
    }

    public void setSelectClause(QueriesModelContext selectClause) {
        wSet(QueriesFeatureDescriptorEnum.selectClause, selectClause);
    }

    public QueriesModelContext getWhereClause() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.whereClause);
    }

    public void setWhereClause(QueriesModelContext whereClause) {
        wSet(QueriesFeatureDescriptorEnum.whereClause, whereClause);
    }

    public QueriesModelContext getClearClause() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.clearClause);
    }

    public void setClearClause(QueriesModelContext clearClause) {
        wSet(QueriesFeatureDescriptorEnum.clearClause, clearClause);
    }

    public QueriesModelContext getExpression() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.expression);
    }

    public void setExpression(QueriesModelContext expression) {
        wSet(QueriesFeatureDescriptorEnum.expression, expression);
    }

    public QueriesModelContext getPredicate() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.predicate);
    }

    public void setPredicate(QueriesModelContext predicate) {
        wSet(QueriesFeatureDescriptorEnum.predicate, predicate);
    }

    public QueriesModelContext getConstraints() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.constraints);
    }

    public void setConstraints(QueriesModelContext constraints) {
        wSet(QueriesFeatureDescriptorEnum.constraints, constraints);
    }

    public QueriesModelContext getBindings() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.bindings);
    }

    public void setBindings(QueriesModelContext bindings) {
        wSet(QueriesFeatureDescriptorEnum.bindings, bindings);
    }

    public QueriesModelContext getArguments() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.arguments);
    }

    public void setArguments(QueriesModelContext arguments) {
        wSet(QueriesFeatureDescriptorEnum.arguments, arguments);
    }

    public QueriesModelContext getLocalNames() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.localNames);
    }

    public void setLocalNames(QueriesModelContext localNames) {
        wSet(QueriesFeatureDescriptorEnum.localNames, localNames);
    }

    public QueriesModelContext getIndex() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.index);
    }

    public void setIndex(QueriesModelContext index) {
        wSet(QueriesFeatureDescriptorEnum.index, index);
    }

    public QueriesModelContext getStartIndex() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.startIndex);
    }

    public void setStartIndex(QueriesModelContext startIndex) {
        wSet(QueriesFeatureDescriptorEnum.startIndex, startIndex);
    }

    public QueriesModelContext getEndIndex() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.endIndex);
    }

    public void setEndIndex(QueriesModelContext endIndex) {
        wSet(QueriesFeatureDescriptorEnum.endIndex, endIndex);
    }

    public QueriesModelContext getComparator() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.comparator);
    }

    public void setComparator(QueriesModelContext comparator) {
        wSet(QueriesFeatureDescriptorEnum.comparator, comparator);
    }

    public QueriesModelContext getNames() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.names);
    }

    public void setNames(QueriesModelContext names) {
        wSet(QueriesFeatureDescriptorEnum.names, names);
    }

    public QueriesModelContext getExpressions() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.expressions);
    }

    public void setExpressions(QueriesModelContext expressions) {
        wSet(QueriesFeatureDescriptorEnum.expressions, expressions);
    }

    public QueriesModelContext getIdentity() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.identity);
    }

    public void setIdentity(QueriesModelContext identity) {
        wSet(QueriesFeatureDescriptorEnum.identity, identity);
    }

    public QueriesModelContext getPexp1() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.pexp1);
    }

    public void setPexp1(QueriesModelContext pexp1) {
        wSet(QueriesFeatureDescriptorEnum.pexp1, pexp1);
    }

    public QueriesModelContext getPexp2() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.pexp2);
    }

    public void setPexp2(QueriesModelContext pexp2) {
        wSet(QueriesFeatureDescriptorEnum.pexp2, pexp2);
    }

    public QueriesModelContext getExp1() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.exp1);
    }

    public void setExp1(QueriesModelContext exp1) {
        wSet(QueriesFeatureDescriptorEnum.exp1, exp1);
    }

    public QueriesModelContext getExp2() {
        return (QueriesModelContext) wGet(QueriesFeatureDescriptorEnum.exp2);
    }

    public void setExp2(QueriesModelContext exp2) {
        wSet(QueriesFeatureDescriptorEnum.exp2, exp2);
    }
}
