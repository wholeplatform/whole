/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.tests.visitors;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.exceptions.IWholeFrameworkException;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Enrico Persiani
 */
public class TestsException extends RuntimeException implements IWholeFrameworkException {
	private static final long serialVersionUID = 1L;

	private IEntity subjectStatement;
	private IEntity subject;
	private IVisitor constraint;
	private IBindingManager bindings;

	public TestsException(IEntity subjectStatement, IEntity subject, IVisitor constraint, IBindingManager bindings) {
		super(formatMessage(bindings, subject, constraint));
		this.subjectStatement = subjectStatement;
		this.subject = subject;
		this.constraint = constraint;
		this.bindings = bindings;
	}

	public IEntity getSubjectStatement() {
		return subjectStatement;
	}
	public IEntity getSubject() {
		return subject;
	}
	public IVisitor getConstraint() {
		return constraint;
	}
	public IBindingManager getBindings() {
		return bindings;
	}
	
	@Override
	public IEntity getMessageModel() {
		IEntity subjectStatement = EntityUtils.clone(getSubjectStatement());
		IEntity subject = EntityUtils.clone(getSubject());
		IEntity fragment = CommonsEntityAdapterFactory.createStageUpFragment(TestsEntityDescriptorEnum.Expression, subject);
		subjectStatement.wSet(0, fragment);
		return subjectStatement;
	}

	public static String formatMessage(IBindingManager bm, IEntity subject, IVisitor constraint) {
		StringBuilder sb = new StringBuilder(2048);
		if (EntityUtils.isNull(subject))
			sb.append("NullEntity");
		else
			sb.append(PrettyPrinterOperation.toPrettyPrintString(subject).replaceFirst(StringUtils.EOL_REGEXP+"+$", ""));
		sb.append(" ");
		sb.append(PrettyPrinterOperation.toPrettyPrintString(constraint.getSourceEntity()));
		return sb.toString();
	}
}
