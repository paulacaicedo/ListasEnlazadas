import java.util.Iterator;


public class List implements ListInterface, Iterable<ListNode> {

	private ListNode inode;
	private int size;
	
	public ListNode head;
	public ListNode tail;
	
	
    public List() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
    
    public List(Object object) {
		this.head = new ListNode();
		this.tail = head;
	}
    
    public void recorrer() {
		ListNode pointer=head;
		while(pointer.next!=null){
			System.out.println(pointer.toString());
			pointer=pointer.next;
		}
    }
    
    
    @Override
    public boolean isEmpty() {
    	return head==null;
    }
    
    @Override
    public int getSize() {
    	/*
    	ListNode pointer=head;
    	int cont=0;
    	while(pointer.next!=null) {
    		pointer=pointer.next;
    		cont++;
    	}
    	*/
    	return size;
    }
    
    @Override
    public ListNode search(Object object) {
    	ListNode pointer=head;
    	while(pointer.next!=null) {
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return pointer;
    		}
    		pointer=pointer.next;
    	}
    	
		return null;
    	
    }
    
    @Override
    public boolean insertHead(Object object) {
    	ListNode node = new ListNode(object);
    	if(isEmpty()) {
    		node.next=head;
        	head=node; 
        	size++;
        	return true;
    		
    	}else {
        	node.next=head;
        	head=node; 
        	size++;
        	return true;
    	}
    }
    
    @Override
    public boolean insertTail(Object object) {
    	tail = new ListNode(object);
    	ListNode pointer=head;
    	while(pointer.next!=null) {
    		pointer=pointer.next;
    	}
    	pointer.next=tail;
    	size++;
		return false;
    	
    }
    
    
   
    @Override
    public boolean add(Object object) {
    	
    	if(isEmpty()) {
    		head=new ListNode(object);
    		tail=head;
    		size++;
    	}else {
    		tail.next=new ListNode(object);
    		tail=tail.next;
    		size++;
    	}
    	
    	return false;
    }
    
    @Override
	public boolean insert(Object ob, Object object) {
		try {
			if(ob != null) {
				ListNode pointer = this.search(object);
				if(pointer.next==null) {
					add(object);
					size++;
				}else {
					ListNode node = new ListNode(object);
					node.next=pointer.next;
					pointer.next=node;
					size++;
				}
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
		
	}

	
    @Override
	public boolean insert(ListNode node, Object object) {
    	ListNode pointer=head;
    	while(pointer.next!=null) { 
    		if(pointer.toString().equals(node.toString())) {
    			ListNode newnode = new ListNode(object);
				newnode.next=pointer.next;
				pointer.next=newnode;
				size++;
				return true;
    		}
    		pointer=pointer.next;
    	}
		return false;
	}

	@Override
	public Object getHead() {
		ListNode pointer=head;
		return pointer.getObject();
	}

	@Override
	public Object getTail() {
		ListNode pointer=head;
    	while(pointer.next!=null) {
    		pointer=pointer.next;
    	}
    	pointer.next=tail;
		return tail.getObject();
	}
	
	@Override
	public Object get(ListNode node) {
		ListNode pointer=head;
    	while(pointer.next!=null) { 
    		if(pointer.toString().equals(node.toString())) {
    			return pointer;
    		}
    		pointer=pointer.next;
    	}
		return null;
	}
	
	
	@Override
	public void clear() {
		try {
		 if(!isEmpty()) {
			 ListNode pointer = head;
    		 while(pointer.next.next!=null) {
    			 pointer=pointer.next;
    		 }
    		 pointer.next=null;
    		 head=null;
    		}
		}catch(Exception e) {
			System.out.println("se limpio");  
		}
    		 
    }
		 
	
 

	
	@Override
	public boolean set(ListNode node, Object object) {
		ListNode pointer=head;
    	while(pointer.next!=null) { 
    		if(pointer.toString().equals(node.toString())) {
    			ListNode newnode = new ListNode(object);
				newnode.next=pointer.next;
				pointer.next=newnode;
				return true;
    		}
    		pointer=pointer.next;
    	}
		return false;
	}

	@Override
	public boolean remove(ListNode node) {
		ListNode pointer=head;
		 if(!isEmpty()) {
    		 if(head.next==null) {
    			 head=null;
    		 } 
		 }else {
			 while(pointer.next!=null) {
				 if(pointer.toString().equals(node.toString()))
					node =pointer.next;
	        		pointer.next=node.next;
	        		node.next=null;
		    	}
			 pointer=pointer.next;
			 
		 }
		return false;
	}
	
	

    @Override
    public boolean contains(Object object) {
    	ListNode pointer=head;
    	while(pointer.next!=null) {
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return true;
    		}
    		pointer=pointer.next;
    	}
        return false;
    }

    @Override
    public boolean isEquals(Object object) {
    	ListNode pointer=head;
    	while(pointer.next!=null) {
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return true;
    		}
    		pointer=pointer.next;
    	}
        return false;
    }


    @Override
    public Object getBeforeTo() {
    	 ListNode pointer=head;
    	 
         while (pointer.next!=tail){
             pointer=pointer.next;
         }
         
         return pointer;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
    	ListNode pointer=head;
           while (pointer.next!=node){
               pointer=pointer.next;
           }

           return pointer;
       
    }

    @Override
    public Object getNextTo() {
        return head.next;
    }

    @Override
    public Object getNextTo(ListNode node) {
    	ListNode pointer=head;
    	while(pointer.next!=null) { 
    		if(pointer.toString().equals(node.toString())) {
    			return pointer.next.next.getObject();
    		}
    		pointer=pointer.next;
    	}
        return null;
    }

    @Override
    public List subList(ListNode from, ListNode to) {
    	List list = null;
    	ListNode pointer=head;
    	while(pointer.next!=null) { 
    		if(pointer.toString().equals(from.toString())) {
    			head=pointer;
    			break;
    		}
    		pointer=pointer.next;
    	}
    	while(pointer.next!=to) { 
    		add(pointer.getObject());
    		pointer=pointer.next;
    	}
    	
        return list;
    }

    @Override
    public List sortList() {
        return null;
    }
    
    @Override
    public Object[] toArray() {
    	Object[] array = new Object[size];
    	ListNode pointer=head;
    	for (int i = 0; i < array.length; i++) {
    		while(pointer.next!=null) {
        		array[i]=pointer;
        		pointer=pointer.next;
        	}
		}
        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {	
    	Object[] array = new Object[size];
    	ListNode pointer=head;
    	for (int i = 0; i < array.length; i++) {
    		while(pointer.next!=null) {
        		array[i]=pointer;
        		pointer=pointer.next;
        	}
		}
        return array;
    }
 
    @Override
    public Iterator<ListNode> iterator() {
    	 inode = head;
         Iterator<ListNode> i = new Iterator<ListNode>() {
             @Override
             public boolean hasNext() {
                 return inode.next != null ? true : false;
             }

             @Override
             public ListNode next() {
                 if (hasNext()) {
                     ListNode tmp = inode;
                     inode = inode.next;
                     return tmp;
                 } else {
                     return null;
                 }
             }
         };
         return i;
    }


	
	
	
	//OTROS METODOS CONSULTADOS - SOLO CURIOSIDAD
    
    public void removeHead() {
    	if(!isEmpty()) {
    		ListNode node=head;
        	head=head.next;
        	node.next=null;
    		
    	}
    	 	
    }
    
    public void removeTail() {
    	 if(!isEmpty()) {
    		 if(head.next==null) {
    			 head=null;
    		 }else {
    			 ListNode pointer = head;
        		 while(pointer.next.next!=null) {
        			 pointer=pointer.next;
        		 }
        		 pointer.next=null;
    			 
    		 }
    		  
    	 }
    }
    
    
    
    public void remove(int n) {
    	if(!isEmpty()) {
    		if(n==0) {
    		 ListNode node = head;
    		 head=head.next;
    		 node.next=null;
    		}
    		else {
    			ListNode pointer =head;
        		int cont=0;
        		while(cont < (n-1)) {
        			pointer=pointer.next;
        			cont++;
        		}
        		ListNode temp=pointer.next;
        		pointer.next=temp.next;
        		temp.next=null;
    			
    		}
    		
    	}
    	 
    }
    public void instertPosition(int n, Object object) {
   	 
    	if(isEmpty()) {
    		head=new ListNode(object);
    		tail=head;
    	}else {
    		tail = new ListNode(object);
    		ListNode pointer=head;
    		int cont=0;
    		while(cont<n && pointer.next!=null) {
    			pointer=pointer.next;
    			cont++;
    		}
    		tail.next=pointer.next;
    		pointer.next=tail;
    	}
    
    }

	 
 
	

 
   }
    
    
    
    
	

