package classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

public class aFaire  extends RubriqueEcrite  {
	
	private StringProperty task;
	private CheckBox done;

	public aFaire() {
		task=new SimpleStringProperty();
		
	}

	public StringProperty getTaskProperty() {
		return task;
	}

	public void setTaskProperty(String task) {
		this.task.set(task);
	}
	
	public String getTask() {
		return task.get();
	}

	
	
	
	
	
	

}
