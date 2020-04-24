package jdbc.user.vo;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate() {
		
	}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof MyDate) {
			MyDate myDate = (MyDate)obj;
			if( (this.year == myDate.year) && (this.month == myDate.month) && (this.day == myDate.day)) {
				return true;
			}else return false;
		}else return false;
	}
	
	@Override
	public int hashCode() {
		return this.year ^ this.month ^ this.day;
	}
}
