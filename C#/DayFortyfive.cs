using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace phonebook
{
    class Program
    {
        static void Main(string[] args)
        {
            var DictionaryNames = new Names();

            bool stop = false;
            string input;
            char answer;

            do
            {
                bool found = false;
                Console.WriteLine("Please enter the person you want to search for?");
                input = Console.ReadLine();

                foreach (string name in DictionaryNames.PhoneBook.Keys)
                {
                    if (input == name || input == name.ToUpper() || input == name.ToLower())
                    {
                        found = true;
                        Console.WriteLine($"The phone number of {input} is {DictionaryNames.PhoneBook[name]} ");
                    }
                }

                if (!found)
                {
                    Console.WriteLine($"the person {input} is not present in your Phonebook. Do you want to add that person to your PhoneBook? press Y/N");
                    answer = Console.ReadKey().KeyChar;

                    if (answer =='n' || answer == 'N')
                    {
                        break;
                    }
                    else
                    {
                        Console.WriteLine("Please enter your person number?");
                        var number = int.Parse(Console.ReadLine());

                        DictionaryNames.PhoneBook.Add(input, number);
                    }


                }
                Console.WriteLine("Do you want to search again? Press Y/n");

                var answer2 = char.Parse(Console.ReadLine());
                if (answer2 == 'n' || answer2 == 'N')
                {
                    stop = true;
                    break;
                }               

            } while (stop == false);


        }
    }

}
