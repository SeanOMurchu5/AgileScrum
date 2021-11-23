package demo;


public class Controller {

	Model m;
	View view;
	public Controller(Model m, View v) {
		this.m = m;
		this.view = v;
		view.projectView();
		viewControl(view);
	}
	
	public void viewControl(View view) {
		
	}
}
