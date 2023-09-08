package bean;

public class StringCount {
	private int numOfUcLetter;
	private int numOfLcLetter;
	private int numOfDigitLetter;
	
	public StringCount() {
	}

	public StringCount(int numOfUcLetter, int numOfLcLetter, int numOfDigitLetter) {
		this.numOfUcLetter = numOfUcLetter;
		this.numOfLcLetter = numOfLcLetter;
		this.numOfDigitLetter = numOfDigitLetter;
	}

	public int getNumOfUcLetter() {
		return numOfUcLetter;
	}

	public void setNumOfUcLetter(int numOfUcLetter) {
		this.numOfUcLetter = numOfUcLetter;
	}

	public int getNumOfLcLetter() {
		return numOfLcLetter;
	}

	public void setNumOfLcLetter(int numOfLcLetter) {
		this.numOfLcLetter = numOfLcLetter;
	}

	public int getNumOfDigitLetter() {
		return numOfDigitLetter;
	}

	public void setNumOfDigitLetter(int numOfDigitLetter) {
		this.numOfDigitLetter = numOfDigitLetter;
	}

	@Override
	public String toString() {
		return "StringCount [numOfUcLetter = " + numOfUcLetter + ", numOfLcLetter = " + numOfLcLetter
				+ ", numOfDigitLetter = " + numOfDigitLetter + "]";
	}
	
	
}
