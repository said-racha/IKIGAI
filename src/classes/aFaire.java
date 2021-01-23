package classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class aFaire  extends RubriqueEcrite  {
	
	private StringProperty task;

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
