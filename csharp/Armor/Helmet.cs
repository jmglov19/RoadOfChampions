class Helmet : Armor{

    public Helmet() : base(){
        Random rnd = new();
        this.Type = 0;
        this.Name = "Helmet";
        this.Rating = rnd.Next(0, 5);
        this.Weight = rnd.Next(0, 5);
    }


}