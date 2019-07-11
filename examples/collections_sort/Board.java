package collections.sort;

public class Board {
	private int num;
	private String name = "";
	private String date = "";
	
	public Board(int num, String name, String date) {
		this.num = num;
		this.name = name;
		this.date = date;
	}
	
	public void setNum(int num) { this.num = num; }
	public int getNum() { return this.num; }
	public void setname(String name) { this.name = name; }
	public String getName() { return this.name; }
	public void setDate(String date) { this.date = date; }
	public String getDate() { return this.date; }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.num).append(" : ");
		sb.append(this.name).append(" : ");
		sb.append(this.date);
		return sb.toString();
	}
}