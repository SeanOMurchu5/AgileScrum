package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

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
		
		//button to bring users to home panel button.
		 this.view.homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.home);
			}
			 
		 });
		 //button to bring users to stock control button
		 this.view.stockControlButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.StockControlPanel);
				}
				 
			 });
		 //button to bring users to add items panel.
		 this.view.addItemsBTN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.addItemsPanel);
				}
				 
			 });
		 
		 //button to bring users to view items panel
		 this.view.viewItemsBTN.addActionListener(new ActionListener() {
                
				@Override
				public void actionPerformed(ActionEvent e) {
					setList(view);
					view.sp.setRightComponent(view.viewItemsPanel);
				}
				 
			 });
		 
		 //Remove Item Button
		 this.view.removeItemBTN.addActionListener(new ActionListener() {
             
				@Override
				public void actionPerformed(ActionEvent e) {
					removeItem(view.itemListCB.getSelectedItem());
					
				}
				 
			 });
		 
		 //Add items page button that adds the item to the list
		 this.view.submitItemBTN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name = view.itemNameTF.getText();
					String type = (String) view.itemTypeCB.getSelectedItem();
					int year = Integer.parseInt(view.yearTF.getText());
					int month = Integer.parseInt(view.monthTF.getText());
					int day = Integer.parseInt(view.dayTF.getText());

					Item i = new Item(name, type, day, month, year);
					m.addItem(i);
				}
				 
			 });
		 
		 //Add items page button that returns user to stock control panel.
		 this.view.returnToItemsBTN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.StockControlPanel);
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
	
	public void setList(View v) {
		ArrayList<String> newItemsArr = new ArrayList<String>();
		
		for(int i = 0; i < m.itemList.size(); i++) {
			String day = String.valueOf( m.itemList.get(i).getDay());
			String month = String.valueOf( m.itemList.get(i).getMonth());
			String year = String.valueOf( m.itemList.get(i).getYear());

		    newItemsArr.add(i, m.itemList.get(i).getName() + " : expires= " + day + "/" + month +"/"+year);

		}
		JComboBox newCB= new JComboBox(newItemsArr.toArray());

		
		v.itemListCB.setModel(new DefaultComboBoxModel(newItemsArr.toArray()));
	}
	
	public void removeItem(String s) {
		
	}
}
