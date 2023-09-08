package view;

import java.util.Arrays;
import java.util.Scanner;

import bean.Student;

public class Ex01DemoStudent {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {

		Student sv1 = new Student(1, "Trần Phước Thành", 9f, 9f);
		Student sv2 = new Student(2, "My bestfriend", 9f, 8.5f);
		Student sv3 = new Student();
		inputInfor(sv3);
		Student[] students = { sv1, sv2, sv3 };
		for (Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("\n=============\n");
		
		Student[] result1 = filterByAverageScore(students);
		for (Student each : result1) {
			System.out.println(each);
		}
		
		System.out.println("\n=============\n");
		
		Student[] result2 = filterByTheoryGreaterThanPractical(students);
		for (Student each : result2) {
			System.out.println(each);
		}
		
		
	}

	private static void inputInfor(Student student) {
		// Student student = new Student();
		System.out.print("nhập id: ");
		student.setId(Integer.parseInt(ip.nextLine()));
		System.out.print("nhập họ tên: ");
		student.setName(ip.nextLine());
		System.out.print("nhập điểm lý thuyết: ");
		student.setTheoryScore(ip.nextFloat());
		System.out.print("nhập điểm thực hành: ");
		student.setPracticalScore(ip.nextFloat());

	}

	private static Student[] filterByAverageScore(Student[] students) {
		Student[] result = new Student[students.length];
		int count = 0;
		for (Student student : students) {
			float averageScore = (float) (student.getTheoryScore() + student.getPracticalScore()) / 2;
			if (averageScore > 8.5f) {
				result[count++] = student;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

	private static Student[] filterByTheoryGreaterThanPractical(Student[] students) {
		Student[] result = new Student[students.length];
		int count = 0;
		for (Student student : students) {
			if (student.getTheoryScore() > student.getPracticalScore()) {
				result[count++] = student;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
}
