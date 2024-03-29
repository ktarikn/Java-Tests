import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  
  @Test
  public void emptyQueue() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    when(mq.size()).thenReturn(0);
    assertEquals(-1,c.countNumberOfOccurrences("hello"));
    
  }
  @Test
  public void NoOccurence() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    when(mq.size()).thenReturn(1);
    when(mq.contains("hello")).thenReturn(false);
    assertEquals(0,c.countNumberOfOccurrences("hello"));
  }
  @Test
  public void YesOccurance() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    when(mq.size()).thenReturn(3);
    when(mq.contains("hello")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("hello");
    when(mq.getAt(1)).thenReturn("Nope");
    when(mq.getAt(2)).thenReturn("hello");
    assertEquals(2,c.countNumberOfOccurrences("hello"));
  }
}