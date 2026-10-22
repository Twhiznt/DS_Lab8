import java.lang.RuntimeException;

public class QueueUnderFlowException extends RuntimeException
{


   public QueueUnderFlowException()
   {
      super("UnderFlow");
   }


   public QueueUnderFlowException(String message)
   {
      super(message);
   }

}
