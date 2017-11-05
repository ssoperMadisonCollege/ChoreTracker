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

public abstract class AbstractJavaBeanTest<MyBean> {

    @Test
    public void beanIsSerializable() throws Exception {
        final MyBean myBean = getBeanInstance();
        final byte[] serializedMyBean = SerializationUtils.serialize((Serializable) myBean);
        @SuppressWarnings("unchecked")
        final MyBean deserializedMyBean = (MyBean) SerializationUtils.deserialize(serializedMyBean);
        assertEquals(myBean, deserializedMyBean);
    }

    @Test
    public void equalsAndHashCodeContract() {
        EqualsVerifier.forClass(getBeanInstance().getClass()).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        final BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDate.class, new LocalDateTimeFactory());
        beanTester.testBean(getBeanInstance().getClass());
    }

    protected abstract MyBean getBeanInstance();

    /**
     * Concrete Factory that creates a LocalDateTime.
     */
    class LocalDateTimeFactory implements Factory {

        @Override
        public LocalDate create() {
            return LocalDate.now();
        }

    }

}
