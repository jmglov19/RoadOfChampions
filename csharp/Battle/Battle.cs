using csharp;

class Battle{
    public int Id { get; set; }
    public Character Character1{ get; set; }
    public Character Character2 { get; set; }



    public Battle(Character character1, Character character2) {
         Character1 = character1;
         Character2 = character2;
         Id = 0 ;
    }

    public (Character, Character) Attack(Character Attacker, Move move, Character Defender) {
        Random acc = new();
        if (move.Accuracy >= acc.NextDouble())
        {
            

            var attack = Attacker.GetDamage(move);
            var damage = attack - Defender.GetDefense();
              
            if(damage > 0){
                Console.WriteLine($"{Attacker.Name} attaked {Defender.Name} using {move.Name} for {damage} damage. ");
                Defender.Health -= damage;
            }
            else{
                Console.WriteLine($"{Attacker.Name} attaked {Defender.Name} using {move.Name} but it had no effect.");
            }

                      
        }
        else{
            Console.WriteLine($"{Attacker.Name} missed!");
        }

        if (move.Attributes.Length >0){
            foreach (var attr in move.Attributes){
                if (attr.Name.StartsWith("Raise")){
                    if (attr.Type == "Defense"){
                        Attacker.ToughnessBoost += (int)Math.Round(Attacker.Toughness * attr.StatBuff, 0);
                        Console.WriteLine($"{Attacker.Name} raised his toughness to {Attacker.GetDefense()}");
                    }
                    if (attr.Type == "Health"){
                        Attacker.Health += (int)attr.StatBuff;
                        Attacker.HealthPotion -= 1;
                        if(Attacker.Health > Attacker.MaxHealth) Attacker.Health = Attacker.MaxHealth;
                        Console.WriteLine($"{Attacker.Name} used a potion to raise his HP to {Attacker.Health}");
                    }
                }
                
            }

        }
        if (!Attacker.CheckStats() || !Defender.CheckStats()){
            throw new Exception("Stat Error");
        }

        return (Attacker, Defender);
    }

    public void StartBattle(){

        Random acc = new();
        while(true){
        
            var char1Move = Character1.ChooseMove();
            var char2Move = Character2.ChooseMove();

            var char1MoveSpeed = Character1.GetSpeed(char1Move);
            var char2MoveSpeed = Character2.GetSpeed(char2Move);

            if(char1MoveSpeed > char2MoveSpeed){

                var chars = Attack(Character1, char1Move, Character2);
                Character1 = chars.Item1;
                Character2 = chars.Item2;
                if (Character2.Health < 0) { break; }

                chars = Attack(Character2, char2Move, Character1);
                Character2 = chars.Item1;
                Character1 = chars.Item2;
                if (Character1.Health < 0) { break; }
               
            }
            if (char2MoveSpeed > char1MoveSpeed)
            {
                var chars = Attack(Character2, char2Move, Character1);
                Character2 = chars.Item1;
                Character1 = chars.Item2;
                if (Character1.Health < 0) { break; }

                chars = Attack(Character1, char1Move, Character2);
                Character1 = chars.Item1;
                Character2 = chars.Item2;
                if (Character2.Health < 0) { break; }                
            }
        }

        if (Character1.Health < 0) {
            Character2.AddExp(Character1.Level.Num * 5);
        }
        else if (Character2.Health < 0){
            Character1.AddExp(Character2.Level.Num * 10);
            Console.WriteLine($"You won and gained {Character2.Level.Num * 10} exp");
        }
        //Console.WriteLine($"{Character1.Name} {Character1.Control}: {Character1.Health} {Character2.Name} {Character2.Control}: {Character2.Health}");
    }

    
    

}
    
