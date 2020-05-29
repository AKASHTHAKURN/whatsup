// Map value(문자열) 정렬
// 숫자정렬은 빼기, 문자 정렬은 compareTo

package ssp.datastructure;

import java.util.*;
import java.util.Map.Entry;


public class HashMap_4_SortValue_String {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("d", "apple");
		map.put("a", "banana");
		map.put("c", "grape");
		map.put("b", "orange");

		System.out.println("------------sort 전 -------------");
		System.out.println(map);

		System.out.println("---------sort 후------------");

		
		/* 람다 사용 -> 간단함 */
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

		Collections.sort(list, (g1, g2) -> g1.getValue().compareTo(g2.getValue()));

		for (Entry<String, String> n : list) {
			System.out.printf("%s %s\n", n.getKey(), n.getValue());
		}

		
		/* Iterator 사용, 어렵다 */
		Iterator<String> it = sortByValue(map).iterator();

		while (it.hasNext()) {
			String temp = (String) it.next();
			System.out.println(temp + " = " + map.get(temp));
		}
	}

	// key(String)가 들어있는 List를 반환
	public static List sortByValue(final Map map) {
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v1).compareTo(v2);
			}
		});
		// Collections.reverse(list); // 주석시 오름차순, 없으면 내림차순
		return list;
	}
}
