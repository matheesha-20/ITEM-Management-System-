package model;

public class Item {
        private String id;
        private String name;
        private Integer quantity;
        private String description;
        private Double price;

        public Item(String id, String name,Integer quantity, String description, Double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.description = description;
            this.price = price;
        }

        public Item() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(Double price) {
                this.price = price;
            }

        public Double getPrice() {
            return price;
        }
}
