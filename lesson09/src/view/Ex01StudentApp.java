package view;

import java.util.Arrays;

import bean.Student;
import common.Rank;

public class Ex01StudentApp {
	public static void main(String[] args) {
		Student[] result = findStudents(findAll(), Rank.B);
		for (Student r : result) {
			System.out.println(r);
		}
		System.out.println("==================");
		Student[] getResult = findResignedStudents(findAll());
		for (Student gr : getResult) {
			System.out.println(gr);
		}
	}

	// tìm danh sách sinh viên học lại
	private static Student[] findResignedStudents(Student[] students) {
		Student[] result = new Student[students.length];
		int count = 0;
		boolean[] flags = new boolean[students.length];

		for (int i = 0; i < students.length; i++) {
			if (!flags[i]) {
//			for (int j = i + 1; j < students.length; j++) {
//				if (!flags[j] && students[i].equals(students[j])) {
//					flags[i] = true;
//					flags[j] = true;
//				}
//			}
				process(students, i, flags);
				
				if (flags[i])
				result[count++] = students[i];
			}
		}
//		for (int i = 0; i < flags.length; i++) {
//			if (flags[i] && !contains(students, count, students[i]) {
//				result[count++] = students[i];
//			}
//		}
		return Arrays.copyOf(result, count);
	}

	private static void process(Student[] students, int checkPos, boolean[] flags) {
		for (int i = 0; i < students.length; i++) {
			if (!flags[i] && i != checkPos && students[checkPos].equals(students[i])) {
				flags[i] = true;
				flags[checkPos] = true;
			}
		}
	}

	private static boolean contains(Student[] elements, int notNullElements, Student student) {
		for (int i = 0; i < notNullElements; i++) {
			if (elements[i].equals(student)) {
				return true;
			}
		}
		return false;
	}

	private static Student[] findAll() {
		return new Student[] {
				new Student(102, "Nam", Rank.C), new Student(103, "Bảo", Rank.F),
				new Student(104, "Hoàng", Rank.D), new Student(105, "Nguyên", Rank.B),
				new Student(107, "Vũ", Rank.F),new Student(109, "Lan", Rank.A),
				new Student(202, "Đạt", Rank.C), new Student(103, "Bảo", Rank.F),
				new Student(107, "Vũ", Rank.C), new Student(104, "Hoàng", Rank.B) };
	}

	// tìm danh sách sinh viên đạt loại A
	private static Student[] findStudents(Student[] students, Rank rankFilter) {
		Student[] result = new Student[students.length];
		int count = 0;
		for (Student student : students) {
			if (student.getRank().equals(rankFilter)) {
				result[count++] = student;
			}

		}
		return Arrays.copyOfRange(result, 0, count);
	}
}
