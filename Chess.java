package Challenge;

import java.util.ArrayList;

public class Chess {
//	 The challenge is to run all the board with some horse without duplicate position
	static ArrayList<ArrayList<Integer>> pMov = new ArrayList<>();
	
	static ArrayList<ArrayList<Integer>> log = new ArrayList<>();

	public static void main(String[] args) {
		addMoves(pMov);

		ArrayList<Integer>position = new ArrayList<Integer>();
		position.add(5);
		position.add(5);

		check(position);
		showResult();
	}
	

	static void check(ArrayList<Integer> position) {
		addPosition(position);
		
		for (ArrayList<Integer> element : pMov) {
			ArrayList<Integer> newPosition = new ArrayList<>();
			newPosition.add(element.get(0) + position.get(0));
			newPosition.add(element.get(1) + position.get(1));
			
			if(!isOut(newPosition) && !isPositionDuplicated(newPosition)) {
				check(newPosition);
				break;
			}
		}
	}

	static boolean isPositionDuplicated(ArrayList<Integer> position) {		
		if(log.contains(position)) {
			return true;
		}

		return false;
	}

	static void addPosition(ArrayList<Integer> position) {
		log.add(position);
	}

	static boolean isOut(ArrayList<Integer> position) {
		if(position.get(0) >= 9 || position.get(0) <= 0) {
			return true;
		}

		if(position.get(1) >= 9 || position.get(1) <= 0) {
			return true;
		}

		return false;
	}
	
	static void showResult() {
		for (ArrayList<Integer> element : log) {
			System.out.println("[" + element.get(0) + ", " + element.get(1) + "]");
		}
	}

	static void addMoves(ArrayList<ArrayList<Integer>> pMov){
		ArrayList<Integer> up1 = new ArrayList<>();
		up1.add(2);
		up1.add(-1);

		ArrayList<Integer> up2 = new ArrayList<>();
		up2.add(2);
		up2.add(1);

		ArrayList<Integer> down1 = new ArrayList<>();
		down1.add(-2);
		down1.add(-1);

		ArrayList<Integer> down2 = new ArrayList<>();
		down2.add(-2);
		down2.add(1);

		ArrayList<Integer> right1 = new ArrayList<>();
		right1.add(1);
		right1.add(2);

		ArrayList<Integer> right2 = new ArrayList<>();
		right2.add(-1);
		right2.add(2);

		ArrayList<Integer> left1 = new ArrayList<>();
		left1.add(1);
		left1.add(-2);

		ArrayList<Integer> left2 = new ArrayList<>();
		left2.add(-1);
		left2.add(-2);

		pMov.add(left2);
		pMov.add(left1);
		pMov.add(right2);
		pMov.add(right1);
		pMov.add(down2);
		pMov.add(down1);
		pMov.add(up2);
		pMov.add(up1);
	}
}