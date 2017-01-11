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
package org.whole.lang.e4.ui.actions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.e4.ui.util.E4Utils;

/**
 * @author Enrico Persiani
 */
public interface IE4UIConstants {
	// bundle id
	public static final String BUNDLE_ID = "org.whole.lang.e4.ui";

	// part id
	public static final String DETAILS_PART_ID = BUNDLE_ID+".part.details";
	public static final String MAP_PART_ID = BUNDLE_ID+".part.map";
	public static final String INDEX_PART_ID = BUNDLE_ID+".part.index";
	public static final String PALETTE_PART_ID = BUNDLE_ID+".part.palette";
	public static final String RESULTS_PART_ID = BUNDLE_ID+".part.results";
	public static final String OUTLINE_PART_ID = BUNDLE_ID+".part.outline";
	public static final String DEBUG_PART_ID = BUNDLE_ID+".part.debug";
	public static final String VARIABLES_PART_ID = BUNDLE_ID+".part.variables";
	public static final String CONTEXT_PART_ID = BUNDLE_ID+".part.context";
	public static final String SAMPLE_PART_ID = BUNDLE_ID+".part.sample";

	public static final Set<String> DERIVED_PARTS_ID_SET = new HashSet<>(Arrays.asList(
		OUTLINE_PART_ID,
		DETAILS_PART_ID,
		MAP_PART_ID,
		INDEX_PART_ID,
		PALETTE_PART_ID,
		DEBUG_PART_ID,
		VARIABLES_PART_ID,
		CONTEXT_PART_ID,
		SAMPLE_PART_ID
	));

	// context menu id
	public static final String CONTEXT_MENU_ID = BUNDLE_ID+".context.menu";

	// command and parameter id
	public static final String COMMAND_NS = BUNDLE_ID+".command::";
	public static final String PARAMETER_NS = BUNDLE_ID+".parameter::";

	public static final String COPY_ENTITY_PATH_COMMAND_ID = COMMAND_NS+"copyEntityPath";
	public static final String COPY_AS_IMAGE_COMMAND_ID = COMMAND_NS+"copyAsImage";
	public static final String PASTE_AS_COMMAND_ID = COMMAND_NS+"pasteAs";

	public static final String REPLACE_COMMAND_ID = COMMAND_NS+"replace";
	public static final String ADD_COMMAND_ID = COMMAND_NS+"add";
	public static final String REPLACE_FRAGMENT_COMMAND_ID = COMMAND_NS+"replaceFragment";
	public static final String ADD_FRAGMENT_COMMAND_ID = COMMAND_NS+"addFragment";

	public static final String REPLACE_WITH_DEFAULT_COMMAND_ID = COMMAND_NS+"replaceWithDefault";
	public static final String IMPORT_COMMAND_ID = COMMAND_NS+"import";
	public static final String SELECT_NOTATION_COMMAND_ID = COMMAND_NS+"selectNotation";
	public static final String ACTION_CALL_COMMAND_ID = COMMAND_NS+"actionCall";
	public static final String PERFORM_COMMAND_ID = COMMAND_NS+"perform";

	public static final String ZOOM_COMMAND_ID = COMMAND_NS+"zoom";
	public static final String ALIGN_COMMAND_ID = COMMAND_NS+"align";

	public static final String VALIDATE_MODEL_COMMAND_ID = COMMAND_NS+"validateModel";
	public static final String NORMALIZE_MODEL_COMMAND_ID = COMMAND_NS+"normalizeModel";
	public static final String PRETTYPRINT_MODEL_COMMAND_ID = COMMAND_NS+"prettyPrintModel";
	public static final String INTERPRET_MODEL_COMMAND_ID = COMMAND_NS+"interpretModel";
	public static final String GENERATEARTIFACTS_COMMAND_ID = COMMAND_NS+"generateArtifacts";
	public static final String GENERATEJAVA_COMMAND_ID = COMMAND_NS+"generateJava";

	
	public static final String ED_URI_PARAMETER_ID = PARAMETER_NS+"entityDescriptor";
	public static final String FD_URI_PARAMETER_ID = PARAMETER_NS+"featureDescriptor";
	public static final String FRAGMENT_XWL_PARAMETER_ID = PARAMETER_NS+"fragmentEntity";
	public static final String FUNCTION_URI_PARAMETER_ID = PARAMETER_NS+"functionUri";
	public static final String PREDICATE_XWL_PARAMETER_ID = PARAMETER_NS+"predicateEntity";
	public static final String BEHAVIOR_XWL_PARAMETER_ID = PARAMETER_NS+"behaviorEntity";
	public static final String EDITORKIT_ID_PARAMETER_ID = PARAMETER_NS+"editorKitId";
	public static final String ANALYSING_PARAMETER_ID = PARAMETER_NS+"analyzing";
	public static final String DESCRIPTION_PARAMETER_ID = PARAMETER_NS+"description";
	
	public static final String PERCENTAGE_PARAMETER_ID = PARAMETER_NS+"percentage";
	public static final String DIRECTION_PARAMETER_ID = PARAMETER_NS+"direction";

	// workbench command id
	//IWorkbenchCommandConstants provides all the workbench default commands
	public static final String EDIT_UNDO = "org.eclipse.ui.edit.undo";
	public static final String EDIT_REDO = "org.eclipse.ui.edit.redo";
	public static final String EDIT_CUT = "org.eclipse.ui.edit.cut";
	public static final String EDIT_COPY = "org.eclipse.ui.edit.copy";
	public static final String EDIT_PASTE = "org.eclipse.ui.edit.paste";
	public static final String EDIT_DELETE = "org.eclipse.ui.edit.delete";
	public static final String EDIT_SELECT_ALL = "org.eclipse.ui.edit.selectAll";
	public static final String EDIT_FIND_AND_REPLACE = "org.eclipse.ui.edit.findReplace";
	public static final String FILE_REVERT = "org.eclipse.ui.file.revert";

	// menu item id
	public static final String UNDO_MENU_ID = "undo";
	public static final String REDO_MENU_ID = "redo";
	
	public static final String COPY_MENU_ID = "copy";
	public static final String CUT_MENU_ID = "cut";
	public static final String PASTE_MENU_ID = "paste";

	public static final String DELETE_MENU_ID = "delete";
	public static final String SELECT_ALL_MENU_ID = "selectAll";

	// icon uris
	public static final String UNDO_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/undo_edit.gif");
	public static final String REDO_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/redo_edit.gif");
	public static final String REPLACE_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/replace.gif");
	public static final String ADD_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/insert.gif");
	public static final String WRAP_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/wrap.gif");
	public static final String TEXT_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/text.gif");
	public static final String IMPORT_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/import_fragment.gif");
	public static final String SELECT_LANGUAGE_ICON_URI = E4Utils.createPlatformPuginURI("icons/actions/select_language.gif"); 

	public static final String LINKED_TO_ACTIVE_EDITOR_URI = E4Utils.createPlatformPuginURI("icons/actions/link_to_active_editor.gif"); 
	public static final String LINKED_TO_EDITOR_URI = E4Utils.createPlatformPuginURI("icons/actions/link_to_editor.gif"); 
	public static final String NOT_LINKED_URI = E4Utils.createPlatformPuginURI("icons/actions/not_linked.gif"); 

	public static final String CLEAR_CONTENTS_URI = E4Utils.createPlatformPuginURI("icons/actions/clear_contents.gif");

	public static final String DEBUG_BREAKPOINTS_DISABLED_URI = E4Utils.createPlatformPuginURI("icons/actions/skip_brkp.gif");
	public static final String DEBUG_RESUME_URI = E4Utils.createPlatformPuginURI("icons/actions/resume.gif");
	public static final String DEBUG_TERMINATE_URI = E4Utils.createPlatformPuginURI("icons/actions/terminate.gif");

	// labels
	public static final String UNDO_LABEL = "Undo";
	public static final String REDO_LABEL = "Redo";
	public static final String COPY_ENTITY_PATH_LABEL = "Copy Entity Path";
	public static final String COPY_AS_IMAGE_LABEL = "Copy As Image";
	public static final String PASTE_AS_LABEL = "Paste As";
	public static final String SPLIT_ON_CARET_LABEL = "Split on Caret";
	public static final String NEWLINE_LABEL = "Newline on Caret";
	public static final String BACKSPACE_LABEL = "Backspace";
	public static final String DELETE_LABEL = "Delete";
	public static final String LEFT_LABEL = "Left";
	public static final String RIGHT_LABEL = "Right";
	public static final String UP_LABEL = "Up";
	public static final String DOWN_LABEL = "Down";

	public static final String REMOVE_LABEL = "Remove";
	public static final String DEFAULT_LABEL = "Default";

	public static final String CONTENT_ASSIST_LABEL = "Value Assist";
	public static final String ENTITY_ASSIST_LABEL = "Entity Assist";
	public static final String FEATURE_ASSIST_LABEL = "Feature Assist";

	public static final String NOTATION_LABEL = "Notation";
	public static final String IMPORT_LABEL = "Import...";

	public static final String SOURCE_LABEL = "Source";
	public static final String REFACTOR_LABEL = "Refactor";
	public static final String TRANSLATE_LABEL = "Translate";
	public static final String ANALYZE_LABEL = "Analyze";
	public static final String MIGRATE_LABEL = "Migrate";

	public static final String CLEAR_CONTENTS_LABEL = "Feature Assist";
	public static final String SAVE_AS_LABEL = "Save As...";

	public static final String DEBUG_RUN_LABEL = "Run";
	public static final String DEBUG_RESUME_LABEL = "Resume";
	public static final String DEBUG_TERMINATE_LABEL = "Terminate";

	// tag used to render a GroupMarker instead of a Separator
	public static final String TAG_GROUP_MARKER = "org.eclipse.jface.action.GroupMarker.GroupMarker(String)";

	// preference nodes
	public static final String WHOLE_PREFERENCE_PAGE_ID = BUNDLE_ID+".preference.page.whole";
	public static final String EDITOR_PREFERENCE_PAGE_ID = BUNDLE_ID+".preference.page.editor";

	public static final String TOPIC_UPDATE_RESULTS = "TOPIC_UPDATE_RESULTS";
	public static final String TOPIC_UPDATE_DEBUG = "TOPIC_BREAK_DEBUG";
	public static final String TOPIC_UPDATE_VARIABLES = "TOPIC_UPDATE_VARIABLES";
	public static final String TOPIC_UPDATE_SAMPLE_CONTEXT = "TOPIC_UPDATE_SAMPLE_CONTEXT";
	public static final String TOPIC_REBUILD_VIEWER_CONDITIONAL = "TOPIC_REBUILD_VIEWER_CONDITIONAL";
	public static final String TOPIC_REBUILD_VIEWER = "TOPIC_REBUILD_VIEWER";
	public static final String TOPIC_REFRESH_VIEWER = "TOPIC_REFRESH_VIEWER";
	public static final String TOPIC_SYNC_OUTLINE_SELECTION = "TOPIC_SYNC_OULINE_SELECTION";

	public static final String FIND_REPLACE_DIALOG_TEXT = "Find/Replace";
	public static final String FIND_BUTTON_TEXT = "Find";
	public static final String REPLACE_BUTTON_TEXT = "Replace";
	public static final String REPLACE_FIND_BUTTON_TEXT = "Replace/Find";
	public static final String REPLACE_ALL_BUTTON_TEXT = "Replace All";
	public static final String PATTERN_NOT_FOUND_TEXT = "Pattern Not Found";

	@Deprecated
	public static final String JAVA_COMPILER_OPERATION_ID = "toJavaModel";
}
