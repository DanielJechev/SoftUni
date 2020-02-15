package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private static final int BULLETS_MIN = 0;
    private static final int TOTAL_BULLETS_MIN = 0;

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;

    protected BaseGun(String name, int bullets, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bullets);
        this.setTotalBullets(totalBullets);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.getBulletsPerBarrel() > BULLETS_MIN || this.getTotalBullets() > TOTAL_BULLETS_MIN;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }

        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < BULLETS_MIN) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }

        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {
        if (totalBullets < TOTAL_BULLETS_MIN) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }

        this.totalBullets = totalBullets;
    }
}
