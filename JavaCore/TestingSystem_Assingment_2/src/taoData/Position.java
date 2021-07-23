package taoData;

public class Position {
	public int id;
	public PositionName name;
	public enum PositionName {
		PM, DEV, TEST, SCRUM_MASTER
	}
	public void printP() {
		System.out.println(id);
		System.out.println(name);
		}
}
