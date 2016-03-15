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
package org.whole.lang.e4.ui.command;

import org.eclipse.e4.ui.model.application.commands.MCommand;

/**
 * @author Enrico Persiani
 */
public interface ICommandFactory {
	public MCommand createCopyEntityPathCommand();
	public MCommand createCopyAsImageCommand();
	public MCommand createPasteAsCommand();
	
	public MCommand createReplaceEntityCommand();
	public MCommand createAddEntityCommand();

	public MCommand createAddFragmentCommand();
	public MCommand createReplaceFragmentCommand();
	public MCommand createPerformCommand();

	public MCommand createReplaceWithDefaultCommand();
	public MCommand createSelectNotationCommand();
	public MCommand createImportCommand();

	public MCommand createActionCallCommand();

	public MCommand createZoomCommand();
	public MCommand createAlignCommand();

	public MCommand createValidateModelCommand();
	public MCommand createNormalizeModelCommand();
	public MCommand createPretyPrintModelCommand();
	public MCommand createInterpretModelCommand();
	public MCommand createGenerateArtifactsModelCommand();
	public MCommand createGenerateJavaModelCommand();	
}
