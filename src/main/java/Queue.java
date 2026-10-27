public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them

	 private class Node
	    {
	        T val; 
	        Node next; 
	        Node(T val, Node next)
	        {
	            this.val = val;
	            this.next = next; 
	        }
	    }

	 private Node front; 
	 private Node back; 
	 private int size;

   public Queue()
   {
		   front = null; 
		   back  = null;
		   size  = 0;
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {		
		   
		   Node newNode = new Node (val, null);
		   if (size==0) {front=newNode;back=newNode;}
		   
		   else 
		   {
		   back.next = newNode; 
		   back = newNode; 
		   }
		   size = size + 1; 
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {
		   if (isEmpty()==true) {throw new QueueUnderFlowException();}
		   
       T holdVal = front.val; 
       front = front.next;
       size = size - 1;
       
       return holdVal;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       if (size==0) {return true;}
       
       return false; 
   }




}
