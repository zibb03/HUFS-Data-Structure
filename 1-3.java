import java.io.*;

abstract class Person implements Comparable {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	// 여기에 필요한 코드를 작성하시오.
	public interface Compareable {
		int compareTo(Comparable x);
	}

}

class Student extends Person {
	private int id; // 학번

	public Student(String name, int id) {
		super(name);
        // 상위 클래스를 통한 생성자 호출(name 초기화)

		this.id = id;
	}
	// 여기에 필요한 코드를 추가하시오.
    @Override
    public int compareTo(Object name2) {
		return this.id < ((Student)name2).id ? -1 : this.id == ((Student)name2).id ? 0 : 1;
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name1 = br.readLine();
		int id1 = Integer.parseInt(br.readLine());
		String name2 = br.readLine();
		int id2 = Integer.parseInt(br.readLine());

		Person p1 = new Student(name1, id1);
		Person p2 = new Student(name2, id2);
		
		int cmp = p1.compareTo(p2);
		if (cmp < 0) {
  		System.out.println(p1.getName());
		} else if (cmp > 0) {
  		System.out.println(p2.getName());
		} else {
			System.out.println("SAME");
		}
	}
}