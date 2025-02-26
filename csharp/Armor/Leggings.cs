class Leggings : Armor{
    public Leggings() : base() 
    {
        Random rnd = new();
        this.Type = 2;
        this.Name = "Leggings";
        this.Rating = rnd.Next(0, 5);
        this.Weight = rnd.Next(0, 5);
    }

}