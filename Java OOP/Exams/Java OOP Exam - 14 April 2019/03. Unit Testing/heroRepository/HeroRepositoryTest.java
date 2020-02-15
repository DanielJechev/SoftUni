package heroRepository;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    @Test(expected = IllegalArgumentException.class)
            public void  addException() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero=new Hero("asd",10,null);
        heroRepository.add(hero);
        heroRepository.add(hero);
    }
    @Test
    public void  add() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero=new Hero("asd",10,null);
        heroRepository.add(hero);

    }
    @Test
    public void  addSize() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero=new Hero("asd",10,null);
        heroRepository.add(hero);
        Assert.assertEquals(1,heroRepository.getCount());
    }

 @Test(expected = NullPointerException.class)
 public void removeException() {
     HeroRepository heroRepository = new HeroRepository();
     Hero hero=new Hero("asd",10,null);
     heroRepository.add(hero);
     heroRepository.remove(null);
 }

    @Test
    public void remove() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero=new Hero("asd",10,null);
        Hero hero1=new Hero("asd1",10,null);
        heroRepository.add(hero);
        heroRepository.add(hero1);
        heroRepository.remove("asd");
        Assert.assertEquals(1,heroRepository.getCount());
    }
@Test(expected = NullPointerException.class)
public void getHeroWithHighestStrengthException(){
    HeroRepository heroRepository = new HeroRepository();
    Hero hero1=new Hero("asd1",10,new Item(-100,100,100));
    heroRepository.add(hero1);
    heroRepository.getHeroWithHighestStrength();
}
    @Test
    public void getHeroWithHighestStrength(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1=new Hero("asd1",10,new Item(100,100,100));
        Hero hero2=new Hero("asd2",10,new Item(200,100,100));
        Hero hero3=new Hero("asd3",10,new Item(300,100,100));
        heroRepository.add(hero1);
        heroRepository.add(hero2);
        heroRepository.add(hero3);
        Assert.assertEquals(hero3,heroRepository.getHeroWithHighestStrength());
    }
    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityException(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1=new Hero("asd1",10,new Item(100,-100,100));
        heroRepository.add(hero1);
        heroRepository.getHeroWithHighestAgility();
    }
    @Test
    public void getHeroWithHighestAgility(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1=new Hero("asd1",10,new Item(100,100,100));
        Hero hero2=new Hero("asd2",10,new Item(200,200,100));
        Hero hero3=new Hero("asd3",10,new Item(300,300,100));
        heroRepository.add(hero1);
        heroRepository.add(hero2);
        heroRepository.add(hero3);
        Assert.assertEquals(hero3,heroRepository.getHeroWithHighestAgility());
    }
    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceException(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1=new Hero("asd1",10,new Item(100,100,-100));
        heroRepository.add(hero1);
        heroRepository.getHeroWithHighestIntelligence();
    }
    @Test
    public void getHeroWithHighestIntelligence(){
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1=new Hero("asd1",10,new Item(100,100,100));
        Hero hero2=new Hero("asd2",10,new Item(200,200,200));
        Hero hero3=new Hero("asd3",10,new Item(300,300,300));
        heroRepository.add(hero1);
        heroRepository.add(hero2);
        heroRepository.add(hero3);
        Assert.assertEquals(hero3,heroRepository.getHeroWithHighestIntelligence());
    }
@Test
    public void String(){
    HeroRepository heroRepository = new HeroRepository();
    Hero hero1=new Hero("asd1",10,new Item(100,200,300));
heroRepository.add(hero1);
    String expected=String.format("Hero: %s – %d%n" +
                    "  *  Strength: %d%n" +
                    "  *  Agility: %d%n" +
                    "  *  Intelligence: %d%n", hero1.getName(), hero1.getLevel(),
            hero1.getItem().getStrength(), hero1.getItem().getAgility(), hero1.getItem().getIntelligence());
    Assert.assertEquals(expected,heroRepository.toString());
    }
}