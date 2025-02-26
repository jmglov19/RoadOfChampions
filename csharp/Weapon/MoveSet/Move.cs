class Move{
    public string Name { get; set; } = "";
    public string Description { get; set;} = "";
    public int BaseAttack { get; set; } = 0;
    public int BaseMagicalAttack { get; set;} = 0;
    public double Accuracy { get; set; } = 0;
    public int BaseSpeed { get; set; } = 0;
    public Attribute[] Attributes { get; set; } = new Attribute[]{ new() };

    

}