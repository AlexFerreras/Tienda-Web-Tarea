package Models;


public class Product {
    
    
    int Id;
    String Name;
    double Price;
    int Quantity;
    String Category;
    String Suplier;
    String Description;
    String CreationDate;
    int status;
    

    public Product() {
    }

    public Product(int Id) {
        this.Id = Id;
    }

    public Product( String Name, double Price, int Quantity, String Category, String Suplier, String Description, String CreationDate) {
        
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Category = Category;
        this.Suplier = Suplier;
        this.Description = Description;
        this.CreationDate = CreationDate;
    }
     public Product(int id, String Name, double Price, int Quantity, String Category, String Suplier, String Description, String CreationDate) {
        this.Id=id;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Category = Category;
        this.Suplier = Suplier;
        this.Description = Description;
        this.CreationDate = CreationDate;
    }
            
    public Product(String Name,double Price, String Category, String Suplier, String Description, String CreationDate) {
        this.Name = Name;
        this.Price = Price;
        this.Category = Category;
        this.Suplier = Suplier;
        this.Description = Description;
        this.CreationDate = CreationDate;
    }        
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getSuplier() {
        return Suplier;
    }

    public void setSuplier(String Suplier) {
        this.Suplier = Suplier;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String CreationDate) {
        this.CreationDate = CreationDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
    
}
