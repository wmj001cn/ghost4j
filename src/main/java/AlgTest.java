import java.util.LinkedList;


public class AlgTest {
	
	static BoundedLinkedList<Integer> a = new BoundedLinkedList<>(12);
	static BoundedLinkedList<Integer> b = new BoundedLinkedList<>(5);
	static BoundedLinkedList<Integer> c = new BoundedLinkedList<>(3);
	private static boolean found;
	
	static BoundedLinkedList lists[] = new BoundedLinkedList[3];
	static int[] indexs = {0, 1, 2};
	public static void main(String[] args) {

		for (int i = 0; i < 12; i++) {
			a.add(1);
		}
		
		lists[0] = a;
		lists[1] = b;
		lists[2] = c;
		
		
		int aIndex = 0;
		int bIndex = 1;
		Pair pair = new Pair(aIndex, bIndex);
		
		for (int i = 0; i < 20; i++) {
			try {
				System.out.print("step " + (i+1) + " :");
				pair = doOnce(pair);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
				System.out.println("found solution at step: " + (i+1));
				break;
			}
		}
		
		/*while (!check()) {
			pair = doOnce(pair);
		}
		*/
		//System.out.println("found...");
		
	}

	private static void print(BoundedLinkedList from) {
		for (Object object : from) {
			System.out.println(object);
		}
		System.out.println();
	}
	
	static class Pair {
		private int fromInd;
		private int toInd;
		
		public Pair(int fromInd, int toInd) {
			super();
			this.fromInd = fromInd;
			this.toInd = toInd;
		}
		public int getFromInd() {
			return fromInd;
		}
		public void setFromInd(int fromInd) {
			this.fromInd = fromInd;
		}
		public int getToInd() {
			return toInd;
		}
		public void setToInd(int toInd) {
			this.toInd = toInd;
		}
		@Override
		public String toString() {
			return "Pair [fromInd=" + fromInd + ", toInd=" + toInd + "]";
		}
		
		
	}
	
	private static Pair doOnce(Pair pair) {
		//System.out.println(pair);
		
		int toInd = pair.toInd;
		BoundedLinkedList to = lists[toInd];
		int fromInd = pair.fromInd;
		BoundedLinkedList from = lists[fromInd];
		
		boolean empty = false;
		boolean full = false;
		int count = 0;
		while (true) {
			count++;
			to.add(from.pop());
			
			empty = from.isEmpty();
			full = to.isFull();
			if (empty || full) {
				
				
				break;
			}
		}
		
		if (full || empty) {
			
			int catchCount = 9;
			boolean d = to.size() == catchCount;
			boolean d2 = from.size() == catchCount;
			if ((d || d2)) {
				System.out.print("move " + count +" items from " + fromInd +" to " + toInd);
				
				if (d) {
					System.out.print(" - found "+catchCount+" at " + toInd);
				} else {
					System.out.print(" - found "+catchCount+" at " + fromInd);
				}
				
				throw new RuntimeException("found!");
			}
		}
		
		
		int[] dd = {toInd, fromInd};
		int other = find(dd);
		
		System.out.println("move " + count +" items from " + fromInd +" to " + toInd);
		//System.out.print(" other:" + other + " ");
		if (full) {
			if (!lists[other].isFull()) {
				return new Pair(toInd, other);
			} else {
				return new Pair(toInd, fromInd);
			}
			
		} else if (empty){
			
			if (!lists[other].isEmpty()) {
				return new Pair(other, fromInd);
			} else {
				return new Pair(toInd, fromInd);
			}
		} else {
			
			return new Pair(toInd, other);
		}
		
		
		
	}
	
	private static int find(int[] dd) {
		
		for (int i = 0; i < indexs.length; i++) {
			if(!exist(dd, i)) {
				return i;
			}
		}
		
		throw new RuntimeException("Cant find other!");
	}

	private static boolean exist(int[] dd, int i) {
		for (int j = 0; j < dd.length; j++) {
			if (i == dd[j]) {
				return true;
			}
		}
		
		return false;
	}

	private static int findNextNonFull() {
		for (int i = 0; i < lists.length; i++) {
			if (!lists[i].isFull()) {
				return i;
			}
		}
		
		return 0;
	}
	
	private static int findNextNonEmpty(int aIndex, int bIndex) {
		
		
		return 0;
	}
	
	private static boolean check() {
		for (int i = 0; i < lists.length; i++) {
			if (lists[i].size() == 4) {
				return true;
			}
		}
		
		return false;
	}
}
