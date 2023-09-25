	/**
	 * 아래 메소드 getNumberOfDays를 완성하시오.
	 * 윤년이면 366를 그렇지 않으면 365를 반환한다. 
	 * @param year 계산할 연도
	 * @returns 입력받은 연도의 날짜수를 계산하여 반환한다.
	 */
	public static int getNumberOfDays(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return 366;
		}
		return 365;
	}