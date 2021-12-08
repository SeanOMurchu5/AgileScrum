package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

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
		
		//button to bring users to home panel .
		 this.view.homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.home);
			}
			 
		 });
		 //button to bring users to stock control panel
		 this.view.stockControlButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.StockControlPanel);
				}
				 
			 });
		 
		 //button to bring users to Item packing panel 
		 this.view.itemPackingButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.ItemPackingPanel);
				}
				 
			 });
		 
		 //button to bring users to Box Dimensions panel 
		 this.view.boxDimensionsBTN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.sp.setRightComponent(view.addBoxPanel);
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
					removeItem(view.itemListCB.getSelectedIndex());
					
				}
				 
			 });
		 
		 //Refresh Item Button
		 this.view.refreshListBTN.addActionListener(new ActionListener() {
             
				@Override
				public void actionPerformed(ActionEvent e) {
					setList(view);
					
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
		 
		 //button to bring users to view items panel
		 this.view.itemDimensionsBTN.addActionListener(new ActionListener() {
                
				@Override
				public void actionPerformed(ActionEvent e) {
					int numItems = Integer.parseInt(String.valueOf(view.numItemsSpinner.getValue()));
					view.sp.setRightComponent(view.itemDimensionsPanel);
					setItemsTable(numItems);
				}
				 
			 });
		 
		 
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
	
	public void removeItem(int y) {
		for(int i = 0; i < m.itemList.size(); i++) {
			
			if(y == i) {
				m.removeItem(m, m.itemList.get(i));
			}
		}
	}
	
	public void setItemsTable(int y) {
	System.out.print(y);
		for(int i = 0; i < y;i++) {
		  m.row[0] = "item "+(i+1);
		  m.row[1] = 0;
		  m.row[2] = 0;
		  m.row[3] = 0;
		  m.row[4] = 0;

		  view.dtmodel.addRow(m.row);
		}

		
	}
}
