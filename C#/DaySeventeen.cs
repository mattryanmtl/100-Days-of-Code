using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DaySeventeen
{
    class Program
    {
        static private Random rand = new Random((int) DateTime.Now.Ticks);

        static void Main()
        {
            string input;
            Console.WriteLine("Input dice info in d20 form separated by spaces:");
            input = Console.ReadLine();
            foreach (string s in input.Split(' '))
            {
                for (int i = 0; i < Convert.ToInt32(s.Split('d')[0]); i++)
                {
                    Console.Write("{0} ", rand.Next(Convert.ToInt32(s.Split('d')[1]))+1);
                }
                Console.WriteLine();
            }
        }
    }
}
