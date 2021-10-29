package com.infoshare;

public enum TypeOfFood {
    DRINKS {
        public String toString() {
            return "Drinks";
        }
    },
    FATSANDOILS {
        public String toString() {
            return "Fats and Oils";
        }
    },
    MEAT {
        public String toString() {
            return "Meat";
        }
    },
    FRUITS {
        public String toString() {
            return "Fruits";
        }
    },
    SEEDSANDNUTS {
        public String toString() {
            return "Seeds and Nuts";
        }
    },
    CEREALPRODUCTS {
        public String toString() {
            return "Cereal Products";
        }
    },
    OTHER {
        public String toString() {
            return "Other";
        }
    },
    DAIRYANDEGGPRODUCTS {
        public String toString() {
            return "Dairy and Egg Products";
        }
    },
    SPICESANDHERBS {
        public String toString() {
            return "Spices and Herbs";
        }
    },
    VEGETABLES {
        public String toString() {
            return "Vegetables";
        }
    },
    private final String type;

    TypeOfFood(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }


}
