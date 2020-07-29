

public class List implements ListInterface{

	public ListNode head;
	public ListNode tail;
	
	
    public List() {
		this.head = null;
		this.tail = null;
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
    	ListNode pointer=head;
    	int cont=0;
    	while(pointer.next!=null) {
    		pointer=pointer.next;
    		cont++;
    	}
    	return cont;
    }
    
    @Override
    public ListNode search(Object object) {
    	ListNode pointer=head;
    	while(pointer.next!=null) {
    		pointer=pointer.next;
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return pointer;
    		}
    	}
    	
		return null;
    	
    }
    
    @Override
    public boolean insertHead(Object object) {
    	ListNode node = new ListNode(object);
    	if(isEmpty()) {
    		node.next=head;
        	head=node; 
        	return true;
    		
    	}else {
        	node.next=head;
        	head=node; 
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
		return false;
    	
    }
    
    
   
    @Override
    public boolean add(Object object) {
    	
    	if(isEmpty()) {
    		head=new ListNode(object);
    		tail=head;
    	}else {
    		tail.next=new ListNode(object);
    		tail=tail.next;
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
				}else {
					ListNode node = new ListNode(object);
					node.next=pointer.next;
					pointer.next=node;
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
				return true;
    		}
    		pointer=pointer.next;
    	}
		return false;
	}

	@Override
	public Object getHead() {
		ListNode pointer=head;
		return pointer;
	}

	@Override
	public Object getTail() {
		ListNode pointer=head;
    	while(pointer.next!=null) {
    		pointer=pointer.next;
    	}
    	pointer.next=tail;
		return tail;
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
			 
		 }
		return false;
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
    
    
    
    
	

