/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.compatibility;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author Enrico Persiani
 */
public class E3xPlugin extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "org.whole.lang.e4.ui.compatibility";

	private static E3xPlugin plugin;
	
	public E3xPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		plugin = this;
		super.start(context);
	}
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static E3xPlugin getDefault() {
		return plugin;
	}
}
