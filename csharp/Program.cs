using System;
using csharp;

class Program
{
    static void Main(string[] args)
    {

        
            Console.WriteLine("Start A Battle?");
            var response = Console.ReadLine();
            
            if(response == "yes"){
                Console.WriteLine("1: CPU vs CPU");
                Console.WriteLine("2: Player vs CPU");
                response = Console.ReadLine();
                if(response == "1"){
                    Character character1 = new("cpu");
                    Character character2 = new("cpu");

                    var Battle = new Battle(character1, character2);

                    Battle.StartBattle();
                }
                if(response == "2"){
                    Character character1 = new("p1");
                    Character character2 = new("cpu");

                    var Battle = new Battle(character1, character2);

                    Battle.StartBattle();
                }
            }
            else if(response == "q"){
                Console.WriteLine("Goodbye!");
                
            
        }            
    }
}