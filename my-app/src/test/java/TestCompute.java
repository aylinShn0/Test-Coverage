import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testMqSizeIsZero(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals(-1,c.countNumberOfOccurrences("This one should return minus one"));
    //-1 döncek
  }

  @Test
  public void testDoesNotContain(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(5);
    when(mq.contains("not contains")).thenReturn(false);
    c = new Compute(mq);
    assertEquals(0,c.countNumberOfOccurrences("Does not contain"));
    //0 döncek
  }

  @Test
  public void testHowManyContains(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(5);
    when(mq.contains("Counter = 1")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("");
    when(mq.getAt(1)).thenReturn("hello");
    when(mq.getAt(2)).thenReturn("this is a test");
    when(mq.getAt(3)).thenReturn("Counter = 1");
    when(mq.getAt(4)).thenReturn("byee");
    c = new Compute(mq);
    assertEquals(1, c.countNumberOfOccurrences("Counter = 1"));
    //counter döncek
  }

  @Test
  public void testHowManyContains2(){
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(5);
    when(mq.contains("Return3")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("Return3");
    when(mq.getAt(1)).thenReturn("Return3");
    when(mq.getAt(2)).thenReturn("this is a test");
    when(mq.getAt(3)).thenReturn("Return3");
    when(mq.getAt(4)).thenReturn("byee");
    c = new Compute(mq);
    assertEquals(3,c.countNumberOfOccurrences("Return3"));
    //counter döncek
  }
}