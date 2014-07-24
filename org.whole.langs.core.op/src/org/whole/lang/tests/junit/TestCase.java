package org.whole.lang.tests.junit;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.tests.factories.TestsEntityFactory;
import org.whole.lang.tests.model.BooleanLiteral;
import org.whole.lang.tests.model.Expression;
import org.whole.lang.tests.model.FilterRule;
import org.whole.lang.tests.model.IntLiteral;
import org.whole.lang.tests.model.Sequence;
import org.whole.lang.tests.model.StringLiteral;
import org.whole.lang.tests.util.TestsHelpers;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public abstract class TestCase {
    protected static IBindingManager bindings;
    protected static IBindingManager bindings() {
        if (bindings == null)
            bindings = BindingManagerFactory.instance.createBindingManager();
        return bindings;
    }

    protected static IEntity evaluate(IEntity model) {
		IEntity entity = NullEntity.instance;
		try {
			entity = BehaviorUtils.evaluate(model, 0, bindings());
		} catch (RuntimeException e) {
			// save exception for later evaluation
			bindings().wDefValue("thrownException", e);
		}
		return entity == null ? NullEntity.instance : entity;
    }

    protected static StringLiteral createStringLiteral(String value) {
    	return TestsEntityFactory.instance.createStringLiteral(value);
    }
    protected static BooleanLiteral createBooleanLiteral(boolean value) {
    	return TestsEntityFactory.instance.createBooleanLiteral(value);
    }
    protected static IntLiteral createIntLiteral(int value) {
    	return TestsEntityFactory.instance.createIntLiteral(value);
    }
    protected static Sequence createSequence(Expression... values) {
    	return TestsEntityFactory.instance.createSequence(values);
    }
    protected static IEntity getVariable(String name) {
    	return bindings().wGet(name);
    }
    protected static IEntity applyFilter(IEntity filter, IEntity subject) {
    	return TestsHelpers.applyFilter(filter, EntityUtils.clone(subject), bindings());
    }
    @SuppressWarnings("unchecked")
	protected static void addFilterFamily(ITemplateManager templateManager) {
    	if (!bindings().wIsSet("filterRulesMap"))
    		bindings().wDefValue("filterRulesMap", new HashMap<String, FilterRule>());
    	Map<String, FilterRule> map = (Map<String, FilterRule>) bindings().wGetValue("filterRulesMap");
        map.putAll(TestsHelpers.createFilterRulesMap(templateManager));
    }

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @AfterClass
    public static void undeployWholePlatform() {
//    	ReflectionFactory.undeployWholePlatform();
    }
}
