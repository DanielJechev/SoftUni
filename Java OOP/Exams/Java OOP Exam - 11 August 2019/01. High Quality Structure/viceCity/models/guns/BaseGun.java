package viceCity.models.guns;

public  abstract  class BaseGun implements Gun {
    private String name;
    private  int bulletsPerBarrel;
    private int totalBullets;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.name = name;
        this.bulletsPerBarrel = bulletsPerBarrel;
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getBulletsPerBarrel() {
        return 0;
    }

    @Override
    public boolean canFire() {
        return false;
    }

    @Override
    public int getTotalBullets() {
        return 0;
    }

    @Override
    public int fire() {
        return 0;
    }
}
