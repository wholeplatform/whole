package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesCartesianIteratorsTest extends TestCase {

    protected static IEntity create(String templateName) {
        return QueriesCartesianIteratorsTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    protected static IEntity evaluateInScope(String templateName) {
        return evaluate(create(templateName), false);
    }

    /**
     *
     */
    @Test
    public void testCartesianUpdateIterator() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment");
            subject = evaluate("fragment1");
            assertThat("at /testCases/8/tests/0/body/1", subject, matches(evaluate("fragment2")));
            subject = evaluate("fragment3");
            assertThat("at /testCases/8/tests/0/body/2", subject, matches(evaluate("fragment4")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testCartesianInsertIterator() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment5");
            subject = evaluate("fragment6");
            assertThat("at /testCases/8/tests/1/body/1", subject, matches(evaluate("fragment7")));
            subject = evaluate("fragment8");
            assertThat("at /testCases/8/tests/1/body/2", subject, matches(evaluate("fragment9")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
