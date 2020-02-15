package heroRepository;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {
    @Test(expected =NullPointerException.class)
    public void  createException(){
        HeroRepository heroRepository=new HeroRepository();
        heroRepository.create(null);
    }
    @Test(expected =IllegalArgumentException.class)
    public void  createExceptionSame(){
        HeroRepository heroRepository=new HeroRepository();
        Hero hero=new Hero("asd",12);
        heroRepository.create(hero);
        heroRepository.create(hero);
    }
    @Test
    public void  create(){
        HeroRepository heroRepository=new HeroRepository();
        Hero hero=new Hero("asd",12);
        Hero hero1=new Hero("asd1",12);
        heroRepository.create(hero);
        heroRepository.create(hero1);
        Assert.assertEquals(2,heroRepository.getCount());

    }
    @Test(expected = NullPointerException.class)
    public void removeException(){
        HeroRepository heroRepository=new HeroRepository();
heroRepository.remove(null);
    }
    @Test
    public void remove(){
        HeroRepository heroRepository=new HeroRepository();
        Hero hero=new Hero("asd",12);
        Hero hero1=new Hero("asd1",12);
        heroRepository.create(hero);
        heroRepository.create(hero1);
        heroRepository.remove("asd");
        Assert.assertEquals(1,heroRepository.getCount());
    }

    @Test
    public void getHeroWithHighestLevel(){
        HeroRepository heroRepository=new HeroRepository();
        Hero hero=new Hero("asd",12);
        Hero hero1=new Hero("asd1",15);
        heroRepository.create(hero);
        heroRepository.create(hero1);
        Assert.assertEquals(hero1,heroRepository.getHeroWithHighestLevel());

    }
    @Test
    public void getHeroShouldReturnTheExpectedHeroByHisName(){
        HeroRepository heroRepository=new HeroRepository();
        Hero hero = new Hero("C",3);
        heroRepository.create(hero);
        Assert.assertEquals(hero,heroRepository.getHero("C"));
    }
}
