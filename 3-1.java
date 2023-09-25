import java.io.*;
import java.util.Scanner;

class Polynomial {
	private int[][] term;
	private int curNoTerm = 0;

	// @param noTerm 항의 개수
	public Polynomial(int noTerm) {
		term = new int[noTerm][2];
	}

	public Polynomial() {
		this(20);  // default로 최대 20개의 항을 저장함
	}

	/***
    @param coef 계수
    @param exp 지수
	***/
	public void addTerm(int coef, int exp) {
		term[curNoTerm][0] = exp; //지수
		term[curNoTerm][1] = coef; //계수
		curNoTerm++;
	}
    
	// @param exp
	// 작성하시오
	public void delTerm(int exp) {

    }

	/**
	 * 출력할 때 사용
	 * @return 객체를 문자열로 반환 (예: 3x^15+2x^3+4x^2+x+5 )
	 * 작성하시오.
	 */
	public String toString() {
		String combine = "";

		for(int i = 0; i < this.curNoTerm; i++) {
			if (this.term[i][1] == 0) {
				//System.out.print(this.term[i][0]);
				//int temp = this.term[i][0];
				//System.out.print(temp);
				//System.out.print(Integer.toString(temp));
				//combine += Integer.toString(temp);
				
				// if (this.term[i][0] == "05")
				// 	combine += "5";
				// else
				// 	combine += Integer.toString(this.term[i][0]);
				combine += Integer.toString(this.term[i][0]);
			}
			else {
				combine += this.term[i][0]+"x^"+ this.term[i][1];
				//System.out.print(this.term[i][0]+"x^"+ this.term[i][1]);
				if (i != this.curNoTerm - 1)
					combine += "+";
			}
		}

		if (combine.isEmpty())
				return "0";
		return combine;
    }

	/**
	 * 두 개의 다항식을 더한다.
	 * @param p1 첫번째 다항식
	 * @param p2 두번째 다항식
	 * @return 두 개의 다항식을 더한 결과
	 * 작성할 것 
	 */
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {    
Polynomial p3 = new Polynomial();
		
		int i = 0;
		int j = 0;

		while(i != p1.curNoTerm && j != p2.curNoTerm) {
			if (p1.term[i][0] > p2.term[j][0]) {
				p3.addTerm(p1.term[i][0], p1.term[i][1]);
				i++;
			}
			else if (p1.term[i][0] < p2.term[j][0]) {
				p3.addTerm(p2.term[i][0], p2.term[i][1]);
				j++;
			}
			else {
				if (p1.term[i][1] + p2.term[i][1] != 0) {
					p3.addTerm(p1.term[i][0], p1.term[i][1] + p2.term[i][1]);	
				}
				i++;
				j++;
			}
			
			if (i == p1.curNoTerm) {
				//p3.addTerm(p1.term[i][0], p1.term[i][1]);
				for (; j < p2.curNoTerm; j++) {
					p3.addTerm(p2.term[j][0], p2.term[j][1]);
				}
				break;
			}
			else if(j == p2.curNoTerm) {
				//p3.addTerm(p2.term[j][0], p2.term[j][1]);
				for (; i < p1.curNoTerm; i++) {
					p3.addTerm(p1.term[i][0], p1.term[i][1]);
				}
				break;
			}
		}
		return p3;

    }
}

class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		// 첫번째 다항식 입력
		Polynomial p1 = new Polynomial();
		int no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp  = scan.nextInt();
			p1.addTerm(coef, exp);
		}

		Polynomial p2 = new Polynomial();
        // 두번째 다항식 입력 코드 여기에 작성할 것
		no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp  = scan.nextInt();
			p2.addTerm(coef, exp);
		}

		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3);  // 이것은 System.out.print(p3.toString())과 동일
	}
}

// 3
// 2 3 4 2 5 0
// 2
// 3 15 1 1
// 3x^15+2x^3+4x^2+x+5

// 3
// 2 3 4 2 5 0
// 3
// -2 3 -4 2 -5 0
// 0

// 3
// 2 3 4 2 5 0
// 1
// -2 3
// 4x^2+5

// 3
// 2 3 4 2 5 0
// 3
// -2 4 -2 3 -5 0
// -2x^4+4x^2