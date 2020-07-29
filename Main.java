
public class Main {

	public static void main(String[] args) {


		List list1 = new List();
		
		for(int i=0;i<10;i++) {
			
			list1.add(i);
		}
		
		/*
		for(ListNode node = list1.head; node !=null; node=node.next) {
			System.out.println(node.toString());
		}
		*/
	
		list1.recorrer();
	
        
		System.out.println( "Tamaño de la Lista: " + list1.getSize());
		 
		list1.removeHead();
		list1.recorrer();
		
		System.out.println( "Tamaño de la Lista: " + list1.getSize());
		
		list1.remove(5);
		list1.recorrer();
		
		System.out.println( "Tamaño de la Lista: " + list1.getSize());
		
		list1.removeTail();
		list1.recorrer();
		
		System.out.println( "Tamaño de la Lista: " + list1.getSize());
		
		list1.clear();
		System.out.println(list1.getSize());
		 
		
	
	}

}
