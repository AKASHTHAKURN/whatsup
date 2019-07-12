	 * 문자열 이동 기능
	public String moveStr(String str) {
		String result = "";

		String result1 = "";
		String result2 = "";
		char prev = ' ';
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != prev) {
				if (count % 2 == 0) {
					for (int j = 0; j < count / 2; j++) {
						result1 += prev;
						result2 = prev + result2;
					} 
				}
				else {
					for (int j = 0; j < count; j++) {
						result1 += prev;
					} 
				}
				
				count = 1;
				prev = str.charAt(i);
			}
			else {
				count++;
			}
		}
		
		if (count % 2 == 0) {
			for (int j = 0; j < count / 2; j++) {
				result1 += prev;
				result2 = prev + result2;
			} 
		}
		else {
			for (int j = 0; j < count; j++) {
				result1 += prev;
			} 
		}

		result = result1 + result2;

		return result;
	}

