package org.whole.lang.e4.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.commands.ModelTextCommand;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.BehaviorUtils;

public class TextualFunctionRunnable extends FunctionRunnable {

	public TextualFunctionRunnable(IEclipseContext context, IBindingManager bm, String label, String functionUri) {
		super(context, bm, label, functionUri);
	}
	
	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException {
		//FIXME workaround for missing caret update events (no selection update is performed)
		E4Utils.defineCaretBindings(bm);
		
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity text = bm.wGet("focusEntity");
		
		boolean enableAnimation = AnimableRunnable.enableAnimation(false);
		ModelTextCommand mtc = new ModelTextCommand(text);
		try {
			mtc.setLabel(label);
			mtc.setViewer(viewer);
			mtc.begin();

			try {
				bm.wEnterScope();

				IEntity newText = BehaviorUtils.apply(functionUri, bm.wGet("self"), bm);

				mtc.setNewSelectedEntity(newText);
				mtc.setNewPosition(bm.wIntValue("caretPosition"));
				//FIXME add textual selection viariables updates
				// see E4Utils.defineCaretBindings()

			} catch (OperationCanceledException e) {
				throw e;
			} finally {
				bm.wExitScope();
			}

			mtc.commit();
			if (mtc.canUndo()) {
				CommandStack commandStack = viewer.getEditDomain().getCommandStack();
				commandStack.execute(mtc);
			}
		} catch (OperationCanceledException e) {
			mtc.rollbackIfNeeded();
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
			throw e;
		} finally {
			AnimableRunnable.enableAnimation(enableAnimation);
		}
	}
}
