class  Chestplate : Armor{

    public Chestplate() : base(){
        Random rnd = new();
        this.Type = 1;
        this.Name = "Chestplate";
        this.Rating = rnd.Next(0, 5);
        this.Weight = rnd.Next(0, 5);
    }

}