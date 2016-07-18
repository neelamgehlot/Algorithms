import java.util.*;

public class HashMapSort {
	public static void main(String[] args) {
		Map<String, Integer> linkedHashmap = new LinkedHashMap<String, Integer>();

		linkedHashmap.put("first", 2000);
		linkedHashmap.put("second", 5999);
		linkedHashmap.put("third", 434);
		linkedHashmap.put("fourth", 6577);

		System.out.println("In order of insertion :");
		display(linkedHashmap);

		Map<String, Integer> hashmap = new HashMap<>(linkedHashmap);

		System.out.println("Unordered : ");
		display(hashmap);

		Map<String, Integer> treemap = new TreeMap<>(linkedHashmap);

		System.out.println("Sorted as per Keys :");
		display(treemap);

		Map<String, Integer> reverseTreemap = new TreeMap<>(Collections.reverseOrder());
		reverseTreemap.putAll(linkedHashmap);

		System.out.println("Sorted as per Keys in reverse:");
		display(reverseTreemap);

		// Second argument is order true for natural sorting and false for
		// reverse sorting
		Map<String, Integer> valueSortHashMap = sortByValue(linkedHashmap, true);

		System.out.println("Sorted as per Values : ");
		display(valueSortHashMap);

		Map<String, Integer> reverseValueSortHashMap = sortByValue(linkedHashmap, false);

		System.out.println("Sorted as per Values in reverse : ");
		display(reverseValueSortHashMap);

	}

	public static void display(Map<String, Integer> map) {
		for (String s : map.keySet()) {
			System.out.println("Key : " + s + ", Value : " + map.get(s));
		}
	}

	public static Map<String, Integer> sortByValue(Map<String, Integer> map, Boolean order) {
		Map<String, Integer> linkedHashmap = new LinkedHashMap<>();

		List<Map.Entry<String, Integer>> list = new LinkedList(map.entrySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				if (order)
					return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
				else
					return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		for (Map.Entry<String, Integer> pair : list) {
			linkedHashmap.put(pair.getKey(), pair.getValue());
		}

		return linkedHashmap;
	}
}
