import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@code Timeable} class.
 *
 * @see Timeable
 * @author Thomas Munguya
 */
class TimeableTest {
    private Class<Timeable> timeableClass;

    @BeforeEach
    void setUp() {
        timeableClass = Timeable.class;
    }

    @Test
    void shouldBeAbstract() {
        assertTrue(Modifier.isAbstract(timeableClass.getModifiers()));
    }

    @Test
    void shouldHaveProtectedTimeField() {
        Field time = null;
        try {
            // should have time field
            time = timeableClass.getDeclaredField("time");
            assertNotNull(time);
            assertTrue(Modifier.isProtected(time.getModifiers()));
        } catch (NoSuchFieldException e) {
            assertNotNull(time);
        }
    }

    @Test
    void shouldHavePublicGetTimeMethod() {
        Method getTime = null;
        try {
            // should have getTime method
            getTime = timeableClass.getDeclaredMethod("getTime");
            assertNotNull(getTime);

            // getTime method should be public
            assertTrue(Modifier.isPublic(getTime.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(getTime);
        }
    }

    @Test
    void shouldHavePublicSetTimeMethod() {
        Method setTime = null;
        try {
            // should have getTime method
            setTime = timeableClass.getDeclaredMethod("setTime", Time.class);
            assertNotNull(setTime);

            // setTime method should be public
            assertTrue(Modifier.isPublic(setTime.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(setTime);
        }
    }

    @Test
    void shouldHavePublicResetMethod() {
        Method reset = null;
        try {
            // should have reset method
            reset = timeableClass.getDeclaredMethod("reset");
            assertNotNull(reset);

            // reset method should be public
            assertTrue(Modifier.isPublic(reset.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(reset);
        }
    }

    @Test
    void shouldResetTime() {
        Stopwatch stopwatch = new Stopwatch(new Time(5, 20, 0));
        stopwatch.reset();
        assertEquals("0:0:0", stopwatch.getTime().toString());
    }

    @Test
    void shouldHavePublicAllArgsConstructor() {
        Constructor<Timeable> allArgsConstructor = null;
        try {
            // should have all args constructor
            allArgsConstructor = timeableClass.getDeclaredConstructor(Time.class);
            assertNotNull(allArgsConstructor);

            // all args constructor should be public
            assertTrue(Modifier.isPublic(allArgsConstructor.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(allArgsConstructor);
        }
    }

}