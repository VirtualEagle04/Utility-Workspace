
public class AplMain {

	public static void main(String[] args) {
		
		NascarCarDAO ndao = new NascarCarDAO();
		ndao.create(new NascarCarDTO("Pepe", "Redbull", 300, 1, 100));
		ndao.create(new NascarCarDTO("Pepe1", "Redbull", 300, 1, 100));
		ndao.create(new NascarCarDTO("Pepe2", "Redbull", 300, 1, 100));
		ndao.create(new NascarCarDTO("Pepe3", "Redbull", 300, 1, 100));
		System.out.println(ndao.display());
		
		
//		MyDoubleLinkedList<String> list = new MyDoubleLinkedList<String>();
//		
//		list.insert("Fico");
//		list.insert("Javier");
//		list.insert("Juan");
//		System.out.println(list.toString());
//		
//		list.backward(1);
//		list.insert("UEB");
//		System.out.println(list.toString());
//		
//		list.insert("1");
//		list.insert("2");
//		list.insert("3");
//		list.insert("4");
//		
//		System.out.println(list.toString());
//		
//		list.extract();
//		
//		System.out.println(list.toString());
//	
//		list.forward(1);
//		list.extract();
//	
//		System.out.println(list.toString());
	
	}
	
}
