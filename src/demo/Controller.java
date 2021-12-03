package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	Model m;
	View view;
	int customerNo = 0;
	public Controller(Model m, View v) {
		this.m = m;
		this.view = v;
		view.projectView();
		viewControl(view);
	}
	
	public void viewControl(View view) {
		 this.view.homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.home);
			}
			 
		 });
		 
		 this.view.addItemsBTN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.addItemsPanel);
				}
				 
			 });
		 
		 this.view.viewItemsBTN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.viewItemsPanel);
				}
				 
			 });
		 
		 
	}
	
	public void addCustomer() {
		// orderHistory table
		String name = view.nameTF.getText();
		String address = view.addressTF.getText();
		String phoneNo = view.phoneNumberTF.getText();
		String email = view.emailTF.getText();

				customerNo += 1;
				m.row[0] = customerNo;
				m.row[1] = name;
				m.row[2] = address;
				m.row[3] = phoneNo;
				m.row[4] = email;

				view.dtmodel.addRow(m.row);

				
	}
}
