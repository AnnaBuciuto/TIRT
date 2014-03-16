package map.element;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MapElementFactoryTest {

    @Test
    public void testCreateUser() {
        assertCreates('u', User.class);
    }

    @Test
    public void testCreateObstacle() {
        assertCreates('o', Obstacle.class);
    }

    @Test
    public void testCreateEmptySpace() {
        assertCreates('x', EmptySpace.class);
    }

    private void assertCreates(char c, Class cl) {
        MapElement e = MapElementFactory.create(c);
        assertThat(e, instanceOf(cl));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateIllegalArgumentException() {
        MapElementFactory.create('0');
    }

}
