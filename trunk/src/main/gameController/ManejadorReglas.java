package main.gameController;

import java.util.Observable;
import java.util.Observer;

public class ManejadorReglas implements Observer{

	private static ManejadorReglas instance = null; 

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

	public static ManejadorReglas getInstance() {
		if (instance == null){
			instance = new ManejadorReglas();
		}
		return instance;
	}

}
