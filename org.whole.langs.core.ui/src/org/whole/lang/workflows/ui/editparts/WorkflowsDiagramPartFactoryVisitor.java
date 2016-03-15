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
package org.whole.lang.workflows.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.VariableDataEntityPart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.notations.editparts.QuotedStringTextualEntityPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.workflows.model.Assign;
import org.whole.lang.workflows.model.AssignActivity;
import org.whole.lang.workflows.model.Assignments;
import org.whole.lang.workflows.model.BooleanLiteral;
import org.whole.lang.workflows.model.Breakpoint;
import org.whole.lang.workflows.model.ConditionalCase;
import org.whole.lang.workflows.model.ConditionalCases;
import org.whole.lang.workflows.model.CreateEntity;
import org.whole.lang.workflows.model.CreateJavaClassInstance;
import org.whole.lang.workflows.model.CreateModel;
import org.whole.lang.workflows.model.Declarations;
import org.whole.lang.workflows.model.DefaultCase;
import org.whole.lang.workflows.model.DeleteArtifacts;
import org.whole.lang.workflows.model.EmptyActivity;
import org.whole.lang.workflows.model.EventHandler;
import org.whole.lang.workflows.model.EventHandlers;
import org.whole.lang.workflows.model.Expressions;
import org.whole.lang.workflows.model.FaultEvent;
import org.whole.lang.workflows.model.FaultHandler;
import org.whole.lang.workflows.model.FaultHandlers;
import org.whole.lang.workflows.model.FlowObjects;
import org.whole.lang.workflows.model.ForeachLoop;
import org.whole.lang.workflows.model.IWorkflowsEntity;
import org.whole.lang.workflows.model.IntLiteral;
import org.whole.lang.workflows.model.InvokeJavaClassMethod;
import org.whole.lang.workflows.model.InvokeJavaInstanceMethod;
import org.whole.lang.workflows.model.InvokeOperation;
import org.whole.lang.workflows.model.InvokeQuery;
import org.whole.lang.workflows.model.LoadArtifacts;
import org.whole.lang.workflows.model.LoadJavaModel;
import org.whole.lang.workflows.model.LoadModel;
import org.whole.lang.workflows.model.OnCallEvent;
import org.whole.lang.workflows.model.OnMessageEvent;
import org.whole.lang.workflows.model.OnTimerEvent;
import org.whole.lang.workflows.model.Operation;
import org.whole.lang.workflows.model.Parallel;
import org.whole.lang.workflows.model.Parse;
import org.whole.lang.workflows.model.PickControl;
import org.whole.lang.workflows.model.ReturnEvent;
import org.whole.lang.workflows.model.SaveArtifacts;
import org.whole.lang.workflows.model.SaveModel;
import org.whole.lang.workflows.model.Scope;
import org.whole.lang.workflows.model.Sequence;
import org.whole.lang.workflows.model.StringLiteral;
import org.whole.lang.workflows.model.SwitchControl;
import org.whole.lang.workflows.model.Task;
import org.whole.lang.workflows.model.Text;
import org.whole.lang.workflows.model.Unparse;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.WhileLoop;
import org.whole.lang.workflows.model.Workflow;
import org.whole.lang.workflows.visitors.WorkflowsIdentityDefaultVisitor;


/** 
 * @author Riccardo Solmi
 */
public class WorkflowsDiagramPartFactoryVisitor extends WorkflowsIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IWorkflowsEntity) modelEntity).accept(this);
		return part;
	}

	public void visit(IWorkflowsEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Workflow entity) {
		part = new WorkflowPart();
	}

	public void visit(OnCallEvent entity) {
		part = new OnCallEventPart();
	}

	public void visit(OnMessageEvent entity) {
		part = new OnMessageEventPart();
	}

	public void visit(OnTimerEvent entity) {
		part = new OnTimerEventPart();
	}

	public void visit(Sequence entity) {
		part = new SequencePart();
	}

	public void visit(Parallel entity) {
		part = new ParallelPart();
	}

	public void visit(FlowObjects entity) {
		if (context instanceof ParallelPart)
			part = new AbstractCompositePart() {
			    protected IFigure createFigure() {
			    	CompositeFigure f = new CompositeFigure(true);
			    	f.getLayoutManager().withMinorAlignment(Alignment.LEADING);
			        return f;
			    }
			};
		else
			part = new AbstractCompositePart() {
			    protected IFigure createFigure() {
			    	CompositeFigure f = new CompositeFigure(false);
			    	f.getLayoutManager().withSpacing(7).withMinorAlignment(Alignment.CENTER);
			        return f;
			    }
		};
	}

	public void visit(SwitchControl entity) {
		part = new SwitchControlPart();
	}
	public void visit(ConditionalCases entity) {
		part = new AbstractCompositePart() {
		    protected IFigure createFigure() {
		    	CompositeFigure f = new CompositeFigure(true);
		    	f.getLayoutManager().withMinorAlignment(Alignment.LEADING);
		        return f;
		    }
		};
	}
	public void visit(ConditionalCase entity) {
		part = new ConditionalCasePart();
	}
	public void visit(DefaultCase entity) {
		part = new DefaultCasePart();
	}

	public void visit(PickControl entity) {
		part = new PickControlPart();
	}
	public void visit(EventHandler entity) {
		part = new EventHandlerPart();
	}

	public void visit(WhileLoop entity) {
		part = new WhileControlPart();
	}

	public void visit(Scope entity) {
		part = new ScopePart();
	}

	public void visit(FaultEvent entity) {
		part = new FaultEventPart();
	}

	public void visit(FaultHandler entity) {
		part = new FaultHandlerPart();
	}

	public void visit(AssignActivity entity) {
		part = new AssignActivityPart();
	}
	public void visit(Assignments entity) {
		part = new AssignmentsTablePart();
	}
	public void visit(Assign entity) {
		part = new AssignPart();
	}

	public void visit(EmptyActivity entity) {
		part = new EmptyActivityPart();
	}

	public void visit(ForeachLoop entity) {
		part = new ForeachLoopPart();
	}

	public void visit(ReturnEvent entity) {
		part = new ReturnEventPart();
	}

	public void visit(FaultHandlers entity) {
		part = new CompositeColumnPart();
	}

	public void visit(EventHandlers entity) {
		part = new CompositeRowWithPlaceholderPart();
	}

	public void visit(Declarations entity) {
		part = new CompositeColumnPart();
	}

	public void visit(Variable entity) {
		part = new VariableDataEntityPart();
	}

	@Override
	public void visit(BooleanLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(IntLiteral entity) {
		part = new ContentDataEntityPart();
	}
	@Override
	public void visit(StringLiteral entity) {
		part = EntityUtils.isComposite((IEntity) context.getModel()) ?
				new QuotedStringTextualEntityPart() :
					new ContentTextualEntityPart();
	}

	public void visit(Text entity) {
		part = new ContentTextualEntityPart();
	}

	@Override
	public void visit(Task entity) {
		part = new TaskPart();
	}

	@Override
	public void visit(Breakpoint entity) {
		part = new BreakpointPart();
	}

	@Override
	public void visit(Operation entity) {
		part = new OperationPart();
	}

	@Override
	public void visit(InvokeOperation entity) {
		part = new InvokeOperationPart();
	}

	@Override
	public void visit(InvokeQuery entity) {
		part = new InvokeQueryPart();
	}

	@Override
	public void visit(CreateEntity entity) {
		part = new CreateEntityPart();
	}

	@Override
	public void visit(CreateModel entity) {
		part = new CreateModelPart();
	}

	@Override
	public void visit(LoadJavaModel entity) {
		part = new LoadJavaModelPart();
	}

	@Override
	public void visit(LoadModel entity) {
		part = new LoadModelPart();
	}

	@Override
	public void visit(SaveModel entity) {
		part = new SaveModelPart();
	}

	@Override
	public void visit(DeleteArtifacts entity) {
		part = new DeleteArtifactsPart();
	}

	@Override
	public void visit(LoadArtifacts entity) {
		part = new LoadArtifactsPart();
	}
	@Override
	public void visit(SaveArtifacts entity) {
		part = new SaveArtifactsPart();
	}

	@Override
	public void visit(Parse entity) {
		part = new ParsePart();
	}
	@Override
	public void visit(Unparse entity) {
		part = new UnparsePart();
	}

	@Override
	public void visit(CreateJavaClassInstance entity) {
		part = new CreateJavaClassInstancePart();
	}
	@Override
	public void visit(InvokeJavaClassMethod entity) {
		part = new InvokeJavaClassMethodPart();
	}
	@Override
	public void visit(InvokeJavaInstanceMethod entity) {
		part = new InvokeJavaInstanceMethodPart();
	}

	@Override
	public void visit(Expressions entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}
}
