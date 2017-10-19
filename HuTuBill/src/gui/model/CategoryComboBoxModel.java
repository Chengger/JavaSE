package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
		public List<Category> cs  = new CategoryService().list();
		
		public Category c;
		public CategoryComboBoxModel(){
			if (!cs.isEmpty()) 
			c = cs.get(0);
		}
		
		public int getSize() {
			return cs.size();
		}
		
		public Category getElementAt(int index) {
			return cs.get(index);
		}
		
		public void addListDataListener(ListDataListener l) {
			
		}
		
		public void removeListDataListener(ListDataListener l) {
			
		}
		public void setSelectedItem(Object anItem) {
		        c = (Category) anItem;
		         
		}
		 
		    @Override
		public Object getSelectedItem() {
		    	if (!cs.isEmpty()) 
		    		return c;
		    	else
		    		return null;
		}
}


