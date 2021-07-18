
public class Answer {
	int id;
	Question q;
	String content;
	boolean isCorrect;
	public void printAW() {
		System.out.println("id: "+ id);
		System.out.println("Question: "+ q.content);
		System.out.println("Noi Dung: "+ content);
		System.out.println("Ket qua: "+ isCorrect);
		System.out.println(" ");
	}
}
