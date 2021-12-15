package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

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

		// button to bring users to home panel
		this.view.homePanelBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.homePanel);
			}

		});

		// button to bring users to stock control panel
		this.view.stockControlButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.StockControlPanel);
			}

		});

		// button to bring users to Item packing panel
		this.view.itemPackingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.ItemPackingPanel);
			}

		});

		// button to bring users to Box Dimensions panel
		this.view.boxDimensionsBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.addBoxPanel);
			}

		});
		// button to bring users to add items panel.
		this.view.addItemsBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.addItemsPanel);
			}

		});

		// button to bring users to add items panel.
		this.view.clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.basketTextField.setText(" ");
				view.amountTextField.setText(" ");
			}

		});

		this.view.calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.basketTextField.getText();
				view.amountTextField.getText();
			}
		});

		this.view.changeCalculatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator calculator = new calculator();
				calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				calculator.setSize(200, 125);
				calculator.pack();
				calculator.setVisible(true);
				calculator.setTitle("Calculator");
				view.sp.setRightComponent(view.ChangeCalculatorPanel);

			}
		});

		this.view.shoppingBasketButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.ShoppingBasketPanel);
			}

		});

		// button to add box to list
		this.view.addBoxBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				double length = new Double(view.lengthSpinner.getValue().toString());
				double width = new Double(view.widthSpinner.getValue().toString());
				double depth = new Double(view.depthSpinner.getValue().toString());
				double weight = new Double(view.weightSpinner.getValue().toString());

				Box box = new Box(width, length, depth, weight);
				m.addBox(box);
			}

		});

		// button to bring users to view items panel
		this.view.viewItemsBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setList(view);
				view.sp.setRightComponent(view.viewItemsPanel);
			}

		});

		// Remove Item Button
		this.view.removeItemBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeItem(view.itemListCB.getSelectedIndex());

			}

		});

		// Refresh Item Button
		this.view.refreshListBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setList(view);

			}

		});

		// Add items page button that adds the item to the list
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

		// Add items page button that returns user to stock control panel.
		this.view.returnToItemsBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.sp.setRightComponent(view.StockControlPanel);
			}

		});

		// button to bring users to view items panel
		this.view.itemDimensionsBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int numItems = Integer.parseInt(String.valueOf(view.numItemsSpinner.getValue()));
				view.sp.setRightComponent(view.itemDimensionsPanel);
				setItemsTable(numItems);
			}

		});

		// button to submit items dimensions to model
		this.view.itemsSubmitBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				submitItemDimensions();
			}

		});

	}

	// sets the current list of items, from what the user has input so far.
	public void setList(View v) {
		ArrayList<String> newItemsArr = new ArrayList<String>();

		for (int i = 0; i < m.itemList.size(); i++) {
			String day = String.valueOf(m.itemList.get(i).getDay());
			String month = String.valueOf(m.itemList.get(i).getMonth());
			String year = String.valueOf(m.itemList.get(i).getYear());

			newItemsArr.add(i, m.itemList.get(i).getName() + " : expires= " + day + "/" + month + "/" + year);

		}
		JComboBox newCB = new JComboBox(newItemsArr.toArray());

		v.itemListCB.setModel(new DefaultComboBoxModel(newItemsArr.toArray()));
	}

	// Removes an item from the list.
	public void removeItem(int y) {
		for (int i = 0; i < m.itemList.size(); i++) {

			if (y == i) {
				m.removeItem(m, m.itemList.get(i));
			}
		}
	}

	// Sets the items dimensions table based on the number of items the user is
	// looking to input.
	public void setItemsTable(int y) {

		for (int i = 0; i < y; i++) {
			m.row[0] = "item " + (i + 1);
			m.row[1] = 0;
			m.row[2] = 0;
			m.row[3] = 0;
			m.row[4] = 0;

			view.dtmodel.addRow(m.row);
		}

	}

	// Submit item Dimensions method.
	// This method gets the items dimensions and box dimensions from the users input
	// from the table and the previously entered boxes,
	// it then calculates how many boxes is needed to fit all the items.
	public void submitItemDimensions() {
		ArrayList<Box> sortedBoxes = new ArrayList<Box>();
		ArrayList<ItemDimensions> sortedItems = new ArrayList<ItemDimensions>();
		ArrayList usedBoxes = new ArrayList<Integer>();
		int rows = view.dtmodel.getRowCount();
		for (int i = 0; i < rows; i++) {

			// getting dimensions from dtmodel
			double width = new Double(view.dtmodel.getValueAt(i, 1).toString());
			double length = new Double(view.dtmodel.getValueAt(i, 2).toString());
			double depth = new Double(view.dtmodel.getValueAt(i, 3).toString());
			double weight = new Double(view.dtmodel.getValueAt(i, 4).toString());

			ItemDimensions id = new ItemDimensions(weight, width, length, depth);
			m.itemDimensions.add(id);

			// adding to sortedItems

			sortedItems.add(id);
		}

		for (int i = 0; i < m.boxList.size(); i++) {
			double width = m.boxList.get(i).getWidth();
			double depth = m.boxList.get(i).getDepth();
			double length = m.boxList.get(i).getLength();

			double totalArea = width * length * depth;
			m.boxList.get(i).setArea(totalArea);

			sortedBoxes.add(m.boxList.get(i));
		}

		// Sort the boxes and items
		Collections.sort(sortedItems, new SortbyItemArea());
		Collections.sort(sortedBoxes, new SortbyArea());

		// Check how many boxes are needed.
		// Goes in descending order, from biggest item to smallest.
		// and biggest box to smallest.
		// Based on total area.
		for (int i = 0; i < sortedItems.size(); i++) {
			for (int y = 0; y < sortedBoxes.size(); y++) {
				if ((new Double(sortedItems.get(i).getTotalArea()) <= new Double(sortedBoxes.get(y).getTotalArea()))
						&& (new Double(sortedItems.get(i).getWeight()) <= new Double(sortedBoxes.get(i).getWeight()))) {

					double areaDiff = 0;
					double weightDiff = 0;
					areaDiff = new Double(sortedBoxes.get(y).getTotalArea())
							- new Double(sortedItems.get(i).getTotalArea());
					weightDiff = new Double(sortedBoxes.get(y).getTotalArea())
							- new Double(sortedItems.get(i).getTotalArea());
					sortedBoxes.get(i).setArea(areaDiff);
					sortedBoxes.get(i).setWeight(weightDiff);
					boolean found = false;
					for (int x = 0; x < usedBoxes.size(); x++) {

						if (y == new Integer(usedBoxes.get(x).toString())) {
							found = true;
						}
					}
					if (found == false) {
						usedBoxes.add(y);
					}
				}
			}
		}

		view.numBoxesNumberLabel.setText(String.valueOf(usedBoxes.size()));

	}
}
