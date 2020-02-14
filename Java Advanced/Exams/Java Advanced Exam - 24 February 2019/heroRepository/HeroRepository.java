package heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero>heroes;

    public HeroRepository() {
        this.heroes = new ArrayList<>();
    }

    public  void add(Hero hero){
        this.heroes.add(hero);
    }
    public  void  remove(String string){
        this.heroes.removeIf(hero -> hero.getName().equals(string));
    }
    public  Hero getHeroWithHighestStrength(){
        Hero hero=null;
        int max=-1;
        for (Hero g:heroes) {
            if (g.getItem().getStrength() > max) {
                max = g.getItem().getStrength();
                hero = g;
            }


        }
        return hero;
    }
    public  Hero getHeroWithHighestAgility() {
        Hero hero=null;
        int max=-1;
        for (Hero g:heroes) {
            if (g.getItem().getAgility() > max) {
                max = g.getItem().getAgility();
                hero = g;
            }


        }
        return hero;
    }
    public  Hero getHeroWithHighestIntelligence()  {
        Hero hero=null;
        int max=-1;
        for (Hero g:heroes) {
            if (g.getItem().getIntelligence() > max) {
                max = g.getItem().getIntelligence();
                hero = g;
            }


        }
        return hero;
    }
    public int getCount(){
        return this.heroes.size();
    }


    @Override
    public String toString() {
        return String.format("",heroes);
    }
}
