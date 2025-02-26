class Weapon{
    public string Name { get; set;} = "";
    public int Attack { get; set;} = 0;
    public int Speed { get; set;} = 0;
    public int Type{ get; set;} = 0;
    public Move[] Moves { get; set;} = new Move[4]{new Move(), new Move(), new Move(), new Move()};

    public Weapon(){

    }

}