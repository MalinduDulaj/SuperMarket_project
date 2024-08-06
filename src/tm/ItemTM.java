package tm;

public class ItemTM {
    private String Code;
    private String Description;
    private String Pack_Size;
    private Double Unit_Price;
    private int Quantaty_on_hand;
    public String getCode() {
        return Code;
    }
    public void setCode(String code) {
        this.Code = code;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        this.Description = description;
    }
    public String getPack_Size() {
        return Pack_Size;
    }
    public void setPack_Size(String pack_Size) {
        this.Pack_Size = pack_Size;
    }
    public Double getUnit_Price() {
        return Unit_Price;
    }
    public void setUnit_Price(Double unit_Price) {
        this.Unit_Price = unit_Price;
    }
    public int getQuantaty_on_hand() {
        return Quantaty_on_hand;
    }
    public void setQuantaty_on_hand(int quantaty_on_hand) {
        this.Quantaty_on_hand = quantaty_on_hand;
    }

    



    public ItemTM(String code, String description, String pack_Size, Double unit_Price, int quantaty_on_hand) {
        Code = code;
        Description = description;
        Pack_Size = pack_Size;
        Unit_Price = unit_Price;
        Quantaty_on_hand = quantaty_on_hand;
    }
    public ItemTM() {
    }

    
    @Override
    public String toString() {
        return "ItemTM [Code=" + Code + ", Description=" + Description + ", Pack_Size=" + Pack_Size + ", Unit_Price="
                + Unit_Price + ", Quantaty_on_hand=" + Quantaty_on_hand + "]";
    }

    
}
