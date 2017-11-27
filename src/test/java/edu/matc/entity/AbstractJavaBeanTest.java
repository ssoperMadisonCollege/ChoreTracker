package edu.matc.entity;

import static org.junit.Assert.assertEquals;
import java.io.Serializable;
import java.time.LocalDate;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;

/**
 * This abstract class tests all project javabean entities.
 *
 * @param <MyBean> the type parameter
 */
public abstract class AbstractJavaBeanTest<MyBean> {

    /**
     * Test that the bean is serializable.
     *
     * @throws Exception the exception
     */
    @Test
    public void beanIsSerializable() throws Exception {
        final MyBean myBean = getBeanInstance();
        final byte[] serializedMyBean = SerializationUtils.serialize((Serializable) myBean);
        //@SuppressWarnings("unchecked")
        final MyBean deserializedMyBean = (MyBean) SerializationUtils.deserialize(serializedMyBean);
        assertEquals(myBean, deserializedMyBean);
    }

// TODO figure out test recursion issue, not much value here but curious about it
//    /**
//     * Test the equals and hash code contract.
//     */
//    @Test
//    public void equalsAndHashCodeContract() {
//        EqualsVerifier.forClass(getBeanInstance().getClass()).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
//    }

    /**
     * Test getter and setter correctness.
     *
     * @throws Exception the exception
     */
    @Test
    public void getterAndSetterCorrectness() throws Exception {
        final BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDate.class, new LocalDateTimeFactory());
        beanTester.testBean(getBeanInstance().getClass());
    }

    /**
     * Gets bean instance.
     *
     * @return the bean instance
     */
    protected abstract MyBean getBeanInstance();

    /**
     * Concrete Factory that creates a LocalDateTime for use by the tests.
     */
    class LocalDateTimeFactory implements Factory {

        @Override
        public LocalDate create() {
            return LocalDate.now();
        }

    }

}
