package Test;

import java.util.Scanner;

public class Test implements Queue {

	int front;         
	int last;           		
	Object [] queue;
	
	public ArrayQueue(int initialCapacity)
	{
      if (initialCapacity < 1)
	      throw new IllegalArgumentException
	           ("initialCapacity must be >= 1");
      queue = new Object [initialCapacity + 1];
	   
	}
	
	public ArrayQueue()
	{
		this(10);
	}
	
	public boolean isEmpty()
    {
		return front == last;
	}


	public Object getFrontElement()
	{
	    if (isEmpty())
	       return null;
	    else
	       return queue[(front + 1) % queue.length];
	 }
 	
	public Object getLastElement()
	   {
	      if (isEmpty())
	         return null;
	      else
	         return queue[last];
	   }
	
	public void put(Object theElement)
	   {
	      if ((last + 1) % queue.length == front)
	      {
	         Object [] newQueue = new Object [2 * queue.length];
	         int start = (front + 1) % queue.length;
	         if (start < 2)
	            System.arraycopy(queue, start, newQueue, 0,
	                             queue.length - 1);
	         else
	         {
	            System.arraycopy(queue, start, newQueue, 0,
	                             queue.length - start);
	            System.arraycopy(queue, 0, newQueue,
	                             queue.length - start, last + 1);
	         }
	         front = newQueue.length - 1;
	         last = queue.length - 2; 
	         queue = newQueue;
	      }

	      last = (last + 1) % queue.length;
	      queue[last] = theElement;
	   }
	

	public Object remove()
	   {
	      if (isEmpty())
	         return null;
	      front = (front + 1) % queue.length;
	      Object frontElement = queue[front];
	      queue[front] = null; 
	      return frontElement;
	   }
	
	 public void queueHaruulah() 
	    { 
	        int i; 
	        if (front == last) { 
	            System.out.printf("\nQueue is Empty\n"); 
	            return; 
	        } 
	        for (i = front; i < last; i++) { 
	            System.out.printf("%d ", queue[i+1]); 
	        } 
	        return; 
	    } 
	
	public static void main(String[] args) {
		
	      ArrayQueue q = new ArrayQueue(10);
	      boolean exit = false;
			String garaasAvahUtga;
			
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Heden too oruulha bicheed, toonuuda oruulna uu: ");
	        int z = scan.nextInt();
	        for(int x=0;x<z;x++) {
	        	q.put(scan.nextInt());
	        }
	        q.queueHaruulah();
	        zaavar();
	        
	        try {
				while(exit == false) {
				
				System.out.print("\nUgugduluu bichne uu!: ");
				garaasAvahUtga = scan.next();
				
				
				
				switch(garaasAvahUtga) {
				case "LastElement": System.out.println(q.getLastElement());
					break;
				case "FirstElement": System.out.println(q.getFrontElement());
					break;
				case "HoosonEseh": System.out.println(q.isEmpty());
					break;
				case "AddElement":
					System.out.println("Heden too nemhee bicheed, toonuuda oruulna uu: ");
			        int y = scan.nextInt();
			        for(int x=0;x<y;x++) {
			        	q.put(scan.nextInt());
			        }
			        System.out.println("Elementuud amjilttai nemegdlee.");
					break;
				case "RemoveElement": 
					q.remove();
					System.out.println("\nFIFO-iin daguu ehnii  element ustagdlaa.");
					break;
				case "QueueHarah": 
					System.out.println("Odoogiin queue: ");
					q.queueHaruulah();
					break;
				}
				
			}
			}catch(Exception e) {
				System.out.println(e);
				}
		 
	}
	public static void zaavar() {
		System.out.println("\n\n          Zaavar           \n");
		System.out.println("<keywords> : <zaavar>\n");
		System.out.println(" LastElement   :  suuliin elementiig haruulah");
		System.out.println(" FirstElement  :  ehnii elementiig haruulah");
		System.out.println(" HoosonEseh    :  hooson eshiig harah");
		System.out.println(" AddElement    :  element nemeh");
		System.out.println(" RemoveElement :  element ustgah");
		System.out.println(" QueueHarah    :  queue harah");
	}
}
