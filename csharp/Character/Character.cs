namespace csharp;
class Character
{
    public string Control;
    public string Name;
    public Level Level;
    public int MaxHealth;
    public int Health;
    public int Attack;
    public int Toughness;
    public int ToughnessBoost;
    public int MagicalAttack;
    public int MagicalToughness;
    public int Speed;
    public int HealthPotion;
    public List<Move> DefaultMoves;
    public Weapon HeldWeapon;

    public Armor[] Clothing = new Armor[4];

    List<string> warriorNames = new List<string>
        {
            "Aldric", "Baldar", "Cayden", "Drakar", "Eldrin", "Faelan", "Gorath", "Haldor", "Ivor", "Jarek",
            "Korran", "Larsen", "Morak", "Nolan", "Orin", "Phelan", "Quintus", "Ragnar", "Soren", "Torin",
            "Ulric", "Varek", "Wulfric", "Xerath", "Yngvar", "Zorath", "Andros", "Brennar", "Cyran", "Dagmar",
            "Eirik", "Fenrik", "Gavrik", "Hakan", "Ingmar", "Jorik", "Kaelen", "Lothar", "Marek", "Nyren",
            "Odin", "Padrik", "Rurik", "Sigmar", "Tormund", "Ulfgar", "Vasili", "Wendell", "Xander", "Yngve",
            "Zander", "Aren", "Branok", "Celdric", "Dargan", "Edrin", "Felric", "Gunnar", "Haldric", "Irvin",
            "Jorund", "Keldar", "Lorkin", "Maelstrom", "Narvik", "Oslund", "Pravin", "Rurik", "Silas", "Thane",
            "Urdan", "Valkor", "Wulfrik", "Xalvador", "Yorin", "Zelgar", "Arvid", "Brannor", "Cairoth", "Dorian",
            "Eryx", "Fyrgar", "Galandor", "Hazen", "Ivarn", "Jorran", "Kragar", "Lorgan", "Mundar", "Nirvon",
            "Osmund", "Pyrrhus", "Rulf", "Skael", "Thorn", "Ulthon", "Varric", "Weylon", "Xavor", "Ylanor",
            "Zalthor", "Aeron", "Baldric", "Cypher", "Draven", "Erikson", "Fyrn", "Gorvik", "Huxley", "Ildon",
            "Jaxar", "Korrin", "Leron", "Marekson", "Naldor", "Ostun", "Prynn", "Roran", "Syrak", "Thrain",
            "Ulkas", "Vorin", "Wulfer", "Xarrak", "Yamir", "Zarron"
        };
    public Character(string control, int level)
    {
        Random rnd = new Random();
        Name = warriorNames[rnd.Next(0, 101)];
        Level = new();
        Level.Num = level;
        Level.MaxExp = (int)Math.Ceiling(Level.Num * 1.5 * 10);
        Health = 75;
        MaxHealth = Health;
        Attack = (int)Math.Round((double)(rnd.Next(10, 15) * level * 0.5), 0);
        Toughness = (int)Math.Round((double)(rnd.Next(1, 5) * level * 0.5), 0);
        ToughnessBoost = 0;
        MagicalAttack = (int)Math.Round((double)(rnd.Next(1, 5) * level * 0.5), 0);
        MagicalToughness = (int)Math.Round((double)(rnd.Next(1, 5) * level * 0.5), 0);
        Speed = (int)Math.Round((double)(rnd.Next(1, 5) * level * 0.5), 0);
        Control = control;
        HealthPotion = 2;
        DefaultMoves = [new Move()
            {
                Name="Use Health Potion",
                BaseAttack = -10000,
                Accuracy= 1.0,
                Attributes = new Attribute[]{
                    new(){Name = "Raise Health", Type = "Health", StatBuff = 20,}
                                             }
            }

        ];

        Clothing[0] = new Helmet();
        Clothing[1] = new Chestplate();
        Clothing[2] = new Leggings();
        Clothing[3] = new Boots();



        HeldWeapon = new Weapon()
        {
            Name = "Rusty Sword",
            Attack = rnd.Next(7, 30),
            Speed = rnd.Next(1, 11),
            Type = 0,
            Moves = new Move[4] {
                new Move(){
                    Name="Slash",
                    BaseAttack=9,
                    BaseSpeed=5,
                    Accuracy= 0.80,},
                new Move(){
                    Name = "Stab",
                    BaseAttack = 15,
                    BaseSpeed = 3,
                    Accuracy = 0.5,
                }, new Move(){
                    Name = "Sweep",
                    BaseAttack = 5,
                    BaseSpeed = 3,
                    Accuracy = 0.97,
                }, new Move(){
                    Name = "Block",
                    BaseAttack = 0,
                    Accuracy = 1.0,
                    Attributes = new Attribute[]{ new(){
                            Name = "Raise Defense",
                            Type = "Defense",
                            StatBuff = 0.2,
                        }
                    }
                }
            },
        };

    }


    public int GetDefense()
    {
        int defense = 0;
        foreach (var i in Clothing)
        {
            defense += i.Rating;
        }
        defense += Toughness + ToughnessBoost;

        //defense = (int)Math.Ceiling(defense * (Toughness * 0.5));

        return defense;


    }

    public int GetWeight()
    {
        int weight = 0;
        foreach (var i in Clothing)
        {
            weight += i.Weight;
        }
        return weight;
    }

    public int GetMagicalDefense()
    {
        int magicalDefense = 0;
        foreach (var i in Clothing)
        {
            magicalDefense += i.Rating;
        }
        magicalDefense += MagicalToughness;


        return magicalDefense;
    }

    public int GetSpeed(Move move)
    {
        int speed = 0;
        speed = Speed - GetWeight() + HeldWeapon.Speed + move.BaseSpeed * 2;


        return speed;
    }

    public List<Move> GetMoves()
    {
        List<Move> moves = [];

        foreach (var move in HeldWeapon.Moves)
        {
            moves.Add(move);
        }
        foreach (var move in DefaultMoves)
        {
            moves.Add(move);
        }



        return moves;
    }

    public void IncreaseStats()
    {
        Random rnd = new Random();
        MaxHealth += 2;
        Attack += rnd.Next(1, 4);
        Toughness += rnd.Next(1, 4);
        MagicalAttack += rnd.Next(1, 4);
        MagicalToughness += rnd.Next(1, 4);
        Speed += rnd.Next(1, 4);
    }

    public Move ChooseMove()
    {

        if (Control == "cpu")
        {
            Random rnd = new();
            var choice = rnd.Next(0, 4);

            return HeldWeapon.Moves[choice];
        }
        else
        {
            int ch = 0;
            bool move_on = false;
            var moves = GetMoves();

            while (!move_on)
            {
                Console.WriteLine("Choose a Move");

                for (int i = 0; i < moves.Count; i++)
                {
                    Console.WriteLine($"{i}: {moves[i].Name}");
                }

                var choice = Console.ReadLine();

                if (choice == "?")
                {
                    PrintReport();
                }
                if (choice == "?f")
                {
                    PrintStatSheet();
                }
                else if (choice != "?" && choice != "?f")
                {
                    try
                    {
                        ch = Convert.ToInt32(choice);
                        move_on = true;
                    }
                    catch
                    {
                        Console.WriteLine("Value was not a valid move");
                    }

                }



            }

            return moves[ch];
        }
    }
    public bool CheckStats(){
        if (MaxHealth + Attack + Toughness + MagicalAttack + MagicalToughness + Speed >  10000 || MaxHealth + Attack + Toughness + MagicalAttack + MagicalToughness + Speed < 0){
            return false;
        }
        return true;
    }

    public int GetDamage(Move move)
    {

        return (int)Math.Round(HeldWeapon.Attack * move.BaseAttack * 0.2); 
    }

    public void AddExp(int exp)
    {
        Level.Exp += exp;
        if (Level.Exp >= Level.MaxExp)
        {
            Level.Num += (int)Math.Floor((double)Level.Exp / Level.MaxExp);
            Level.Exp = Level.Exp % Level.MaxExp;
            Level.MaxExp = (int)Math.Ceiling(Level.Num * 1.5 * 10);
            LevelUp();
        }

    }

    public void LevelUp()
    {
        Console.WriteLine("Level Up!");
        this.IncreaseStats();
    }

    public void PrintReport()
    {
        Console.WriteLine($"Name: {Name}");
        Console.WriteLine($"HP: {Health}");
        Console.WriteLine($"Attack Skill: {Attack}");
        Console.WriteLine($"Toughness:{Toughness}");
        Console.WriteLine($"Magical Skill: {MagicalAttack}");
        Console.WriteLine($"Magical Defense: {MagicalToughness}");
        Console.WriteLine($"Speed: {Speed}");
    }

    public void PrintStatSheet()
    {
        Console.WriteLine($"Name: {Name}");
        Console.WriteLine($"HP: {Health}");
        Console.WriteLine($"Attack Skill: {Attack}");
        Console.WriteLine($"Toughness:{Toughness}");
        Console.WriteLine($"Magical Skill: {MagicalAttack}");
        Console.WriteLine($"Magical Defense: {MagicalToughness}");
        Console.WriteLine($"Speed: {Speed}");
        Console.WriteLine("-------------------------");
        Console.WriteLine("ARMOR EQUIPTED");
        foreach (var armor in Clothing)
        {
            Console.WriteLine("-------------------------");
            Console.WriteLine(armor.Name);
            Console.WriteLine($"Rating: {armor.Rating}");
            Console.WriteLine($"Weight: {armor.Weight}");

        }
        Console.WriteLine("-------------------------");
        Console.WriteLine($"Total Defense: {GetDefense()}");
        Console.WriteLine($"Total Magical Defense: {GetMagicalDefense()}");
        Console.WriteLine("-------------------------");
        Console.WriteLine("WEAPON");
        Console.WriteLine($"Name: {HeldWeapon.Name}");
        Console.WriteLine($"Base Attack: {HeldWeapon.Attack}");
        Console.WriteLine($"Base Speed: {HeldWeapon.Speed}");
        Console.WriteLine("MOVES");
        foreach (var move in HeldWeapon.Moves)
        {
            Console.WriteLine("-------------------------");
            Console.WriteLine($"Move Name: {move.Name} ");
            Console.WriteLine($"Move Attack: {move.BaseAttack}");
            foreach (var attribute in move.Attributes)
            {
                Console.WriteLine($"Attribute: {attribute.Name} {attribute.StatBuff}");
            }

        }
        Console.WriteLine("-------------------------");
    }



}