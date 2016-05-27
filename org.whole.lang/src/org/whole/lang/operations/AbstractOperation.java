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
package org.whole.lang.operations;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.IEnvironmentManager;
import org.whole.lang.bindings.NullScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractOperation implements IOperation {
	private String operationId;
	private final IOperation enclosingOperation;
    private final IEnvironmentManager environmentManager;
	private final IBindingManager operationEnvironment;
	private final IBindingScope resultsScope, argumentsScope;
	private String phase = null;
	private boolean templatePhase = false;
	private int stage = 0;
	protected Map<String, IVisitor[]> stagedVisitorsMap; // uri -> stagedVisitors[2]
	protected IVisitor[] stagedDefaultVisitors = new IVisitor[2];
	private IOperationProgressMonitor operationProgressMonitor = null;

	public AbstractOperation(String name, IBindingManager args, boolean resultsInArgs) {
		this(name, args, resultsInArgs ? args.wTargetScope() : args.wEnclosingScope());
	}
	public AbstractOperation(String name, IBindingManager args, IBindingScope optResultsScope) {
		operationId = name;
	    stagedVisitorsMap = initStagedVisitors();

	    environmentManager = args.wGetEnvironmentManager();
		enclosingOperation = environmentManager.getCurrentOperation();

		operationEnvironment = args;
		argumentsScope = args.wTargetScope();

		if (optResultsScope != null)
			args.wSetResultScope(optResultsScope);
		if (args.wResultScope() == null)
			args.wSetResultScope(argumentsScope);

		resultsScope = args.wResultScope();
		
		if (resultsScope == NullScope.instance)
			throw new IllegalStateException("ResultsScope is a NullScope");
	}

	public String getOperationId() {
		return operationId;
	}

	public IOperation getEnclosingOperation() {
		return enclosingOperation;
	}

    public IEnvironmentManager getEnvironmentManager() {
    	return environmentManager;
    }

	public IBindingManager getOperationEnvironment() {
		return operationEnvironment;
	}

	public IBindingScope getResultsScope() {
		return resultsScope;
	}
	public IBindingScope getArgumentsScope() {
		return argumentsScope;
	}

	public boolean isCanceled() {
		return getProgressMonitor().isCanceled();
	}
	public void setCanceled(boolean value) {
		getProgressMonitor().setCanceled(value);
	}

	public IOperationProgressMonitor getProgressMonitor() {
		//TODO add environment delegation such that there's always an operationProgressMonitor defined
		if (operationProgressMonitor == null) { 
			operationProgressMonitor = getOperationEnvironment().wIsSet("progressMonitor") ?
				(IOperationProgressMonitor) getOperationEnvironment().wGetValue("progressMonitor") :
				new DefaultOperationProgressMonitor();
		}
		return operationProgressMonitor;
	}

	public boolean isSelectedFeature(String name) {
    	IBindingManager configuration = getEnvironmentManager().getEnvironment(IEnvironmentManager.CONFIGURATION);
    	IEntity value = configuration.wGet(name);
    	if (value == null)
    		return false;
    	else if (DataTypeUtils.getDataKind(value).isBoolean())
    		return value.wBooleanValue();
    	else
    		return true;
	}
    public IEntity setFeature(String name, boolean value) {
    	return setFeature(name, BindingManagerFactory.instance.createValue(value));
    }
    public IEntity setFeature(String name, IEntity value) {
    	IBindingManager configuration = getEnvironmentManager().getEnvironment(IEnvironmentManager.CONFIGURATION);
    	IEntity oldValue = configuration.wGet(name);
    	if (value == null)
    		configuration.wUnset(name);
    	else if (configuration.wIsSet(name))
    		configuration.wSetValue(name, value);
    	else
    		configuration.wDefValue(name, value);
    	return oldValue;
    }

	public final String getPhase() {
		return phase;
	}
	public final void setPhase(String phase) {
		this.phase = phase;
	}

	public final int getStage() {
		return stage;
	}
	public final void setStage(int stage) {
		if (!templatePhase)
			this.stage = stage;
	}

	public IVisitor getVisitor(IEntity entity, int absoluteStage) {
		int normalizedStage = absoluteStage <= 0 ? 0 : 1;
		String uri = ReflectionFactory.getLanguageKit(entity).getURI();
		IVisitor[] stagedVisitors = stagedVisitorsMap.get(uri);
		if (stagedVisitors == null)
			stagedVisitorsMap.put(uri, stagedVisitors = new IVisitor[2]);
		IVisitor visitor = stagedVisitors[normalizedStage];
		if (visitor == null) {
			visitor = stagedVisitors[normalizedStage] = initVisitor(entity, normalizedStage);
			visitor.setOperation(this);
		}
		return visitor;
	}
	//TODO test and change into liftVisitor
	public IVisitor setVisitor(IEntity entity, int absoluteStage, IVisitor visitor) {
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(entity);
		IVisitor oldVisitor = languageKit.hasVisitor(this) ? getVisitor(entity, absoluteStage) : null;

		int normalizedStage = absoluteStage <= 0 ? 0 : 1;

		String uri = ReflectionFactory.getLanguageKit(entity).getURI();
		IVisitor[] stagedVisitors = stagedVisitorsMap.get(uri);
		if (stagedVisitors == null)
			stagedVisitorsMap.put(uri, stagedVisitors = new IVisitor[2]);
		stagedVisitors[normalizedStage] = visitor;

		return oldVisitor;
	}
	
	protected Map<String, IVisitor[]> initStagedVisitors() {
	    return new HashMap<String, IVisitor[]>();
	}
	protected IVisitor initVisitor(IEntity entity, int normalizedStage) {
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(entity);
		IVisitor visitor = null;

		if (languageKit.hasVisitor(this))
			visitor = languageKit.getVisitor(this, normalizedStage);

		if (visitor == null)
			visitor = getDefaultVisitor(entity, normalizedStage);

		return visitor;
	}
	public IVisitor getDefaultVisitor(IEntity entity, int absoluteStage) {
		int normalizedStage = absoluteStage <= 0 ? 0 : 1;
		if (stagedDefaultVisitors[normalizedStage] == null) {
			stagedDefaultVisitors[normalizedStage] = createDefaultVisitor(entity, normalizedStage);
			stagedDefaultVisitors[normalizedStage].setOperation(this);
		}
		return stagedDefaultVisitors[normalizedStage];
	}
	protected IVisitor createDefaultVisitor(IEntity entity, int normalizedStage) {
		//TODO getOperation(normalizedStage).getVisitor(entity, normalizedStage);
		throw new UnsupportedOperationException("The "+entity.wGetLanguageKit().getURI()+" language does not support the (visitor) operation "+getOperationId()+" at stage "+normalizedStage+".");
	}

	public final void stagedVisit(IEntity entity) {
		stagedVisit(entity, 0);
	}
	public void stagedVisit(IEntity entity, int stageShift) {
		boolean isOperationChanged = getEnvironmentManager().getCurrentOperation() != this;
		if (isOperationChanged)
			getEnvironmentManager().enterOperation(this);

		int oldAbsoluteStage = getStage();
		if (stageShift == 0 || templatePhase)
		    getVisitor(entity, oldAbsoluteStage).visit(entity);
		else {
			int absoluteStage = oldAbsoluteStage + stageShift;
			setStage(absoluteStage);
		    getVisitor(entity, absoluteStage).visit(entity);
		    setStage(oldAbsoluteStage);
		}

		if (isOperationChanged)
			getEnvironmentManager().exitOperation();
	}
	public static int PHASE_SHIFT = 100;
	public void stagedVisit(IEntity entity, int stageShift, String phase) {
		String outerPhase = getPhase();
		int outerStage = getStage();
		boolean samePhase = (phase == null && phase == outerPhase) || (phase != null && phase.equals(outerPhase));
		boolean outerTemplate = outerStage > 0;
//		boolean innerTemplate = stageShift > 0;

		if (samePhase)
			stagedVisit(entity, stageShift);
		else if (outerTemplate) {
			boolean outerTemplatePhase = templatePhase;
			templatePhase = true;
			stagedVisit(entity);
			templatePhase = outerTemplatePhase;
		} else {
			setPhase(phase);
			stagedVisit(entity, stageShift*PHASE_SHIFT);			
			setPhase(outerPhase);
		}
	}
	public void stagedDefaultVisit(IEntity entity, int stageShift) {
		boolean isOperationChanged = getEnvironmentManager().getCurrentOperation() != this;
		if (isOperationChanged)
			getEnvironmentManager().enterOperation(this);

		int oldAbsoluteStage = getStage();
		if (stageShift == 0 || templatePhase)
			getDefaultVisitor(entity, oldAbsoluteStage).visit(entity);
		else {
			int absoluteStage = oldAbsoluteStage + stageShift;
			setStage(absoluteStage);
			getDefaultVisitor(entity, absoluteStage).visit(entity);
		    setStage(oldAbsoluteStage);
		}

		if (isOperationChanged)
			getEnvironmentManager().exitOperation();
	}
}
