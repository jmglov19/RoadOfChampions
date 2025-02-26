class Boots : Armor{


    public Boots() : base() {
        Random rnd = new();
        this.Type = 3;
        this.Name = "Boots";
        this.Rating = rnd.Next(0, 5);
        this.Weight = rnd.Next(0, 5);
    }
}