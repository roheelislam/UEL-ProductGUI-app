public class Product {
		
		private String name;
		private int stockLevel;
		private double price;
			
		public Product(String nameIn, int stockLevelIn, double priceIn)
		{
			name = nameIn;
			stockLevel = stockLevelIn;
			price = priceIn;
		}
		
		public void reStock(int stockLeveIn) {
			stockLevel = stockLevel + stockLeveIn;
		}
		
		public double sell(int itemsToSell) {
			double orderCost = 0;
			
			if(stockLevel >= itemsToSell) {
				stockLevel = stockLevel - itemsToSell;
				orderCost = itemsToSell * price;
			}
			else {
				orderCost = -1; // If not enough items are in stock.
			}
			
			
			return orderCost;
		}

		public String getName() {
			return name;
		}

		public int getStockLevel() {
			return stockLevel;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double priceIn) {
			price = priceIn;
		}
	}