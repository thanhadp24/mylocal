package bean;

import common.Rank;

public class Student {
	private String name;
	private int id;
	private Rank rank;

	public Student() {
	}

	public Student(int id, String name, Rank rank) {
		this.name = name;
		this.id = id;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Student)) {
			return false;
		}
		Student that = (Student) obj;
		return getId() == that.getId();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", rank=" + rank + "]";
	}
}
