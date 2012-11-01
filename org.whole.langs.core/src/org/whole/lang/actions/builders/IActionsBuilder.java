package org.whole.lang.actions.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.actions.model.ActionKindEnum;

/** 
 * @generator Whole
 */
public interface IActionsBuilder extends IBuilder {
	public void visit();

	public void splitSize();

	public void namingStrategy();

	public void selectedEntities();

	public void dialog();

	public void bindingsGenerator();

	public void validator();

	public void variabilityModel();

	public void transformation();

	public void configuration();

	public void enablerPredicate();

	public void kind();

	public void actions();

	public void fillStrategy();

	public void text();

	public void icon();

	public void action();

	public void valueAssistActions();

	public void migrateMenuActions();

	public void analyzeMenuActions();

	public void translateMenuActions();

	public void refactorMenuActions();

	public void sourceMenuActions();

	public void generatorAction();

	public void interpreterAction();

	public void prettyPrinterAction();

	public void normalizerAction();

	public void validatorAction();

	public void contextMenuActions();

	public void toolbarActions();

	public void targetLanguage();

	public void version();

	public void name();

	public void namespace();

	public void uri();

	public void LanguageActionFactory();

	public void LanguageActionFactory_();

	public void _LanguageActionFactory();

	public void ToolbarActions();

	public void ToolbarActions_();

	public void _ToolbarActions();

	public void ContextMenuActions();

	public void ContextMenuActions_();

	public void _ContextMenuActions();

	public void MenuActions();

	public void MenuActions_();

	public void MenuActions_(int initialCapacity);

	public void _MenuActions();

	public void Actions();

	public void Actions_();

	public void Actions_(int initialCapacity);

	public void _Actions();

	public void SeparatedAction();

	public void SeparatedAction_();

	public void _SeparatedAction();

	public void GroupAction();

	public void GroupAction_();

	public void _GroupAction();

	public void SubgroupAction();

	public void SubgroupAction_();

	public void _SubgroupAction();

	public void CustomAction();

	public void CustomAction(Object value);

	public void CustomAction(String value);

	public void PerformAction();

	public void PerformAction_();

	public void _PerformAction();

	public void TemplateAction();

	public void TemplateAction_();

	public void _TemplateAction();

	public void FactoryAction();

	public void FactoryAction_();

	public void _FactoryAction();

	public void SimpleAction();

	public void SimpleAction_();

	public void _SimpleAction();

	public void GuardedAction();

	public void GuardedAction_();

	public void _GuardedAction();

	public void Configuration();

	public void Configuration_();

	public void _Configuration();

	public void ActionCall();

	public void ActionCall_();

	public void _ActionCall();

	public void Flat();

	public void Flat_();

	public void _Flat();

	public void Hierarchical();

	public void Hierarchical_();

	public void _Hierarchical();

	public void FullName();

	public void FullName_();

	public void _FullName();

	public void DistinctPrefix();

	public void DistinctPrefix_();

	public void _DistinctPrefix();

	public void URI();

	public void URI(String value);

	public void Namespace();

	public void Namespace(String value);

	public void Name();

	public void Name(String value);

	public void Version();

	public void Version(String value);

	public void Label();

	public void Label(String value);

	public void Text();

	public void Text(String value);

	public void Icon();

	public void Icon(Object value);

	public void Icon(String value);

	public void Size();

	public void Size(int value);

	public void ActionKind();

	public void ActionKind(ActionKindEnum.Value value);

	public void ActionKind(String value);
}
