package bean;

public class TrueSubstring {
	private int longestLength;
	private int index;
	private String longestString;
	
	public TrueSubstring() {
		
	}
	public TrueSubstring(int number, int index, String s) {
		this.longestLength = number;
		this.index = index;
		this.longestString = s;
	}
	public int getNumber() {
		return longestLength;
	}
	public void setNumber(int number) {
		this.longestLength = number;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getS() {
		return longestString;
	}
	public void setS(String s) {
		this.longestString = s;
	}
	@Override
	public String toString() {
		return "TrueSubstring [number=" + longestLength + ", index=" + index + ", s=" + longestString + "]";
	}
	
	
}
