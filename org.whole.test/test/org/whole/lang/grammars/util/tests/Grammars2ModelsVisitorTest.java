package org.whole.lang.grammars.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class Grammars2ModelsVisitorTest extends TestCase {

    protected static IEntity create(String templateName) {
        return Grammars2ModelsVisitorTestTemplateManager.instance().create(templateName);
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
    public void testMappingRules() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment");
            assertThat("at /testCases/1/tests/0/body/0", subject, matches(evaluate("fragment1")));
            subject = evaluate("fragment2");
            assertThat("at /testCases/1/tests/0/body/1", subject, matches(evaluate("fragment3")));
            subject = evaluate("fragment4");
            assertThat("at /testCases/1/tests/0/body/2", subject, matches(evaluate("fragment5")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingTestGrammar1() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment6");
            assertThat("at /testCases/1/tests/1/body/0", subject, matches(evaluate("fragment7")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingDataTypesGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment8");
            assertThat("at /testCases/1/tests/2/body/0", subject, matches(evaluate("fragment9")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingMessagesGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment10");
            assertThat("at /testCases/1/tests/3/body/0", subject, matches(evaluate("fragment11")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingStateMachineGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment12");
            assertThat("at /testCases/1/tests/4/body/0", subject, matches(evaluate("fragment13")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingStateMachine2Grammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment14");
            assertThat("at /testCases/1/tests/5/body/0", subject, matches(evaluate("fragment15")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingFamilyGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment16");
            assertThat("at /testCases/1/tests/6/body/0", subject, matches(evaluate("fragment17")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingMT3Grammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment18");
            assertThat("at /testCases/1/tests/7/body/0", subject, matches(evaluate("fragment19")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingXmlGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment20");
            assertThat("at /testCases/1/tests/8/body/0", subject, matches(evaluate("fragment21")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingMotoGPCSVGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment22");
            assertThat("at /testCases/1/tests/9/body/0", subject, matches(evaluate("fragment23")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testMappingMotoGPFLFGrammar() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment24");
            assertThat("at /testCases/1/tests/10/body/0", subject, matches(evaluate("fragment25")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
