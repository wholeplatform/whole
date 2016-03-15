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
package org.whole.lang.commons.visitors;

import org.whole.lang.commons.model.InlineVariable;
import org.whole.lang.commons.model.Quantifier;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.SameStageFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.model.VarName;
import org.whole.lang.commons.model.VarType;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.parsers.CommonsDataTypePresentationParser;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class CommonsPrettyPrinterVisitor extends CommonsIdentityVisitor {
	protected final IPrettyPrintWriter out;
	protected final String FRAGMENT_PREFIX = "||  ";
	
	public CommonsPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	public void visit(RootFragment entity) {
		IEntity root = entity.wGetRoot();
		out.printRaw("[[");
		out.printlnRaw(root.wGetLanguageKit().getName());
		out.addLinePrefix(FRAGMENT_PREFIX);

		stagedVisit(root);

		out.ensureNewLine();
		out.removeLinePrefix(FRAGMENT_PREFIX);
		out.printRaw("]]");
	}
	public void visit(SameStageFragment entity) {
		IEntity root = entity.wGetRoot();
		out.printRaw("[[");
		out.printlnRaw(root.wGetLanguageKit().getName());
		out.addLinePrefix(FRAGMENT_PREFIX);

		stagedVisit(entity.wGetRoot());

		out.ensureNewLine();
		out.removeLinePrefix(FRAGMENT_PREFIX);
		out.printRaw("]]");
	}
	public void visit(StageDownFragment entity) {
		IEntity root = entity.wGetRoot();
		out.printRaw("[[");
		out.printRaw(root.wGetLanguageKit().getName());
		out.printlnRaw("-1");
		out.addLinePrefix(FRAGMENT_PREFIX);

		stagedVisit(entity.wGetRoot());

		out.ensureNewLine();
		out.removeLinePrefix(FRAGMENT_PREFIX);
		out.printRaw("]]");
	}
	public void visit(StageUpFragment entity) {
		IEntity root = entity.wGetRoot();
		out.printRaw("[[");
		out.printRaw(root.wGetLanguageKit().getName());
		out.printlnRaw("+1");
		out.addLinePrefix(FRAGMENT_PREFIX);

		stagedVisit(entity.wGetRoot());

		out.ensureNewLine();
		out.removeLinePrefix(FRAGMENT_PREFIX);
		out.printRaw("]]");
	}

	public void visit(Resolver entity) {
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent)) {
			FeatureDescriptor fd = parent.wGetFeatureDescriptor(entity);
			if (!fd.isOptional())
				out.printRaw(fd.getEntityDescriptor().getName() + "[]");
		}
	}

	public void visit(Variable entity) {
		out.printRaw("[[ $");
		entity.getVarName().accept(this);
		out.printRaw(" : ");
		entity.getVarType().accept(this);
		entity.getQuantifier().accept(this);
		out.printRaw(" ]]");
	}
	public void visit(InlineVariable entity) {
		out.printRaw("[[ |$");
		entity.getVarName().accept(this);
		out.printRaw("| : ");
		entity.getVarType().accept(this);
		entity.getQuantifier().accept(this);
		out.printRaw(" ]]");
	}
	public void visit(VarName entity) {
		out.printRaw(entity.getValue());
	}
	public void visit(VarType entity) {
		out.printRaw(CommonsDataTypePresentationParser.unparseEntityDescriptor(entity.getValue()));
	}
	public void visit(Quantifier entity) {
		out.printRaw(CommonsDataTypePersistenceParser.unparseQuantifier(entity.getValue()));
	}
}
