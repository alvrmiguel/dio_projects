using System;

public enum HeroType
{
    Warrior,
    Mage,
    Monk,
    Ninja
}

public class Hero
{
    private string name;
    private int age;
    private HeroType heroType;
    private string attackType;

    public Hero(string name, int age, HeroType heroType)
    {
        this.name = name;
        this.age = age;
        this.heroType = heroType;

        Attack(heroType);
    }

    private void Attack(HeroType heroType) // ✅ Tipo correto
    {
        if (heroType == HeroType.Warrior)
        {
            Console.WriteLine($"O {heroType} atacou usando espada");
        }
        else if (heroType == HeroType.Mage)
        {
            Console.WriteLine($"O {heroType} atacou usando magia");
        }
        else if (heroType == HeroType.Monk)
        {
            Console.WriteLine($"O {heroType} atacou usando artes marciais");
        }
        else if (heroType == HeroType.Ninja)
        {
            Console.WriteLine($"O {heroType} atacou usando shuriken");
        }
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        new Hero("Aragorn", 35, HeroType.Warrior);
        new Hero("Blatten", 25, HeroType.Monk);
        new Hero("Augost", 15, HeroType.Mage);
        new Hero("Manetto", 5, HeroType.Ninja);
    }
}