package API;

public class Weather
{
	private String STATION_Id_C;
	private String YEAR;
	private String MON;
	private String DAY;
	private String HOUR;
	private double TEM;
	public String getStation_Id_C() {
		return STATION_Id_C;
	}
	public void setStation_Id_C(String station_Id_C) {
		STATION_Id_C = station_Id_C;
	}
	public String getYear() {
		return YEAR;
	}
	public void setYear(String year) {
		YEAR = year;
	}
	public String getMon() {
		return MON;
	}
	public void setMon(String mon) {
		MON = mon;
	}
	public String getDay() {
		return DAY;
	}
	public void setDay(String day) {
		DAY = day;
	}
	public double getTEM() {
		return TEM;
	}
	public void setTEM(double tEM) {
		TEM = tEM;
	}
	public String getHOUR() {
		return HOUR;
	}
	public void setHOUR(String hOUR) {
		HOUR = hOUR;
	}
}