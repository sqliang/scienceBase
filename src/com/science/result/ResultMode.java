package com.science.result;

import java.util.List;


public class ResultMode<T> {
		private int totalProperty=0;
		private List<T> root;
		public int getTotalProperty() {
			return totalProperty;
		}
		public void setTotalProperty(int totalProperty) {
			this.totalProperty = totalProperty;
		}
		public List<T> getRoot() {
			return root;
		}
		public void setRoot(List<T> root) {
			this.root = root;
		}
		
		
}
