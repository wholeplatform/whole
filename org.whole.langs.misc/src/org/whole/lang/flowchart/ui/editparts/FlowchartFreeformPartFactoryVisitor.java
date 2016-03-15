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
package org.whole.lang.flowchart.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.flowchart.model.Block;
import org.whole.lang.flowchart.model.Choice;
import org.whole.lang.flowchart.model.Entry;
import org.whole.lang.flowchart.model.Exit;
import org.whole.lang.flowchart.model.Flowchart;
import org.whole.lang.flowchart.model.IFlowchartEntity;
import org.whole.lang.flowchart.model.Join;
import org.whole.lang.flowchart.model.LabeledTransition;
import org.whole.lang.flowchart.model.SimpleTransition;
import org.whole.lang.flowchart.visitors.FlowchartIdentityDefaultVisitor;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.DecoratedConnectionPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.SimpleConnectionPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;


/**
 * @author Riccardo Solmi
 */
public class FlowchartFreeformPartFactoryVisitor extends FlowchartIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IFlowchartEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IFlowchartEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Flowchart entity) {
		part = new FlowchartFreeformPart();
	}

	public void visit(SimpleTransition entity) {
//		part = new SimpleConnectionPart();
		part = DecoratedConnectionPartFactory.instance().createConnectionPart(DecoratedConnectionPartFactory.FILLED_ARROW);
	}
	public void visit(LabeledTransition entity) {
		part = new SimpleConnectionPart();
	}
	
	public void visit(Entry entity) {
		part = new EntryPart();
	}

	public void visit(Exit entity) {
		part = new ExitPart();
	}

	public void visit(Block entity) {
		part = new BlockPart();
	}

	public void visit(Choice entity) {
		part = new ChoicePart();
	}

	public void visit(Join entity) {
		part = new JoinPart();
	}
}
