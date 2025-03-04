using System;
using csharp;

class Program
{
    static void Main(string[] args)
    {
        Character character1 = new("cpu",1);
        int round = 0;
        Console.WriteLine("Start An Adventure?");
        var response = Console.ReadLine();

        if (response == "yes")
        {

            Console.WriteLine("1: CPU vs CPU");
            Console.WriteLine("2: Player vs CPU");
            response = Console.ReadLine();
            if (response == "1")
            {
                character1 = new("cpu", 5);
            }
            if (response == "2")
            {
                character1 = new("p1", 5);
            }



            while (character1.Health > 0)
            {
                round++;
                character1.Health = character1.MaxHealth;
                character1.ToughnessBoost = 0;
                Character character2 = new("cpu", round);
                Console.WriteLine($"New Opponent: {character2.Name}");
                var Battle = new Battle(character1, character2);
                Battle.StartBattle();
            }

            Console.WriteLine($"{character1.Name} Died! You reached: {character1.Level.Num} ");

            
            Console.WriteLine($"Round: {round}");
        }
        
        else if (response == "q")
        {
            Console.WriteLine("Goodbye!");


        }
    }
}